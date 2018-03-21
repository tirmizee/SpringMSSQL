var AjaxUploadManager = {
		RootUrl: 'http://localhost:8080/ProjectExcel',
		PostData : function (formData, postUri, onPostSuccess, onPostError) {
	        $.ajax({
	        	processData: false,
	            contentType: false,
	            async: false,
	            cache: false,
	        	type: 'POST',
	            url: postUri,
	            data: formData
	        }).done(function (objRet) {
	            onPostSuccess(objRet);
	        }).fail(function (jqXHR, textStatus, errorThrown) {
	            onPostError(jqXHR, textStatus, errorThrown);
	        });
	    }
	};
	
var AjaxManager = {
		RootUrl: 'http://localhost:8080/ProjectExcel',
		PostData : function (objToPost, postUri, onPostSuccess, onPostError) {
	        $.ajax({
	            type: 'POST',
	            url: postUri,
	            contentType: 'application/json',
	            headers: {
	                'Accept': 'application/json'
	            },
	            data: JSON.stringify(objToPost)
	        }).done(function (objRet) {
	            onPostSuccess(objRet);
	        }).fail(function (jqXHR, textStatus, errorThrown) {
	            onPostError(jqXHR, textStatus, errorThrown);
	        });
	    }
	};
	
var SpringAdminIdex = function(){
	
	var dataSource = [];
	var requestDatas = {};
	
	var handleActiveMenu = function () {
		 $('ul.sidebar-menu > li.menu-index').addClass('active');
	}
	
	var handleButtonClear = function () {
		$('#btnClear').on('click',function(){
			$frmUpload = $('#frmUpload')
			$frmUpload.data('formValidation').resetForm($frmUpload);
		});
	}
	
	var handleForm = function () {
		 $('#frmUpload').formValidation({
		        framework: 'bootstrap',
		        excluded: ':disabled',
		        icon: {
		            valid: 'glyphicon glyphicon-ok',
		            invalid: 'glyphicon glyphicon-remove',
		            validating: 'glyphicon glyphicon-refresh'
		        },
		        fields: {
		        	file: {
		                selector: '.file',
		                validators: {
		                    callback: {
		                        message: 'You must enter at least one file',
		                        callback: function(value, validator, $field) {
		                            var isEmpty = true,
		                                $fields = validator.getFieldElements('file');
		                            for (var i = 0; i < $fields.length; i++) {
		                                if ($fields.eq(i).val() !== '') {
		                                    isEmpty = false;
		                                    break;
		                                }
		                            }
		                            if (!isEmpty) {
		                                validator.updateStatus('file', validator.STATUS_VALID, 'callback');
		                                return true;
		                            }
		                            return false;
		                        }
		                    },
		                    file: {
		                        extension: 'xls,xlsx,xlsm',
		                        maxSize: 5242880,   // 2048 * 1024
		                        message: 'Please select an excel xls,xlsx,xlsm'
		                    }
		                }
		            }
		        }
		    }).on('success.form.fv', function(e) {
	            e.preventDefault();
	            clearAllTable();
	            upload();
	        });	
	}
	
	var upload = function(){
		var $frmUpload = $('#frmUpload');
        var $form_data = new FormData($frmUpload[0]);
        var resignObject   = $('input[name="excelResign"]').prop("files")[0];
        var transferObject = $('input[name="excelTransfer"]').prop("files")[0];
        var licenseObject  = $('input[name="excelLicense"]').prop("files")[0];
        $('#errorResign,#errorTransfer,#errorLicense').hide();
        if (!jQuery.isEmptyObject(resignObject)) { uploadResign($form_data); }
        if (!jQuery.isEmptyObject(transferObject)) { uploadTransfer($form_data); }
        if (!jQuery.isEmptyObject(licenseObject)) { uploadLicense($form_data); }
        $frmUpload.data('formValidation').resetForm($frmUpload);
	}
	
	var selectAll = function($table){
		$('input[type=checkbox]',$table.dataTable().fnGetNodes()).each(function(i){
			var isValid = $table.DataTable().row($(this).parents('tr')).data().valid;
			if(isValid){ $table.DataTable().row(':eq(' + i + ')').select(); }
		});
	}
	
	var uploadResign = function($form_data){
		AjaxUploadManager.PostData($form_data,'admin/uploadResign',function(response){
			var dataSource = response.datas;
			var $table = $('#resignTable');
			$table.DataTable().clear();
			$table.DataTable().rows.add(dataSource);
			$table.DataTable().draw();
			selectAll($table);
	    },function (jqXHR, textStatus, errorThrown) {
			 switch (jqXHR.status) { 
			 	case 400 : $('#errorResign').show();
			 	 		   $('#errorResign > p').text(jqXHR.responseJSON.errorDescription);
			 			   break; 
			 }
		});
	}
	
	var uploadTransfer = function($form_data){
		AjaxUploadManager.PostData($form_data,'admin/uploadTransfer',function(response){
			var dataSource = response.datas;
			var $table = $('#transferTable');
			$table.DataTable().clear();
			$table.DataTable().rows.add(dataSource);
			$table.DataTable().draw();
			selectAll($table);
		},function (jqXHR, textStatus, errorThrown) {
			 switch (jqXHR.status) {
			 	case 400 : $('#errorTransfer').show();
			 			   $('#errorTransfer > p').text(jqXHR.responseJSON.errorDescription);
			 			   break; 
			 }
		});
	}
	
	var uploadLicense = function($form_data){
		AjaxUploadManager.PostData($form_data,'admin/uploadLicense',function(response){
			var dataSource = response.datas;
			var $table = $('#licenseTable');
			$table.DataTable().clear();
			$table.DataTable().rows.add(dataSource);
			$table.DataTable().draw();
			selectAll($table);	    
		},function (jqXHR, textStatus, errorThrown) {
			 switch (jqXHR.status){
			 	case 400 : $('#errorLicense').show();
			 			   $('#errorLicense > p').text(jqXHR.responseJSON.errorDescription);
			 			   break; 
			 }
		});
	}
	
	var handleTableResign = function () {
		 $('#resignTable').DataTable( {
			 "data"       : dataSource,
			 "processing" : true,
			 "serverSide" : false,
			 "deferRender": false,
			 "fnRowCallback": function( Row, Data) {
				 if(!Data.valid){$('td', Row).css('background-color', '#ff8d8d').find('input[type=checkbox]').attr("disabled", true);}
             },
			 "columns": [
				{ "data": "resignID" },
//				{ "data" : null          ,title :"ลำดับ" },
				{ "data": "empId"        ,title :"รหัสพนักงาน"},
				{ "data": "salutation"   ,title :"คำนำหน้า"},
				{ "data": "name"         ,title :"ชื่อ"},
				{ "data": "surname"      ,title :"นามสกุล"},
				{ "data": "newPosition"  ,title :"ตำแหน่ง (ใหม่)"},
				{ "data": "newSection"   ,title :"สำนักงานภาค (ใหม่)"},
				{ "data": "newArea"      ,title :"สำนักงานเขต (ใหม่)"},
				{ "data": "newBranchID"  ,title :"รหัสสาขา (ใหม่)"},
				{ "data": "newBranchNm"  ,title :"สาขา (ใหม่)"},
				{ "data": "email"        ,title :"E-mail"},
				{ "data": "status"       ,title :"status"},
				{ "data": "effectiveDateStr",title :"วันมีผลบังคับ"},
				{ "data": "statusType"   ,title :"STATUS_TYPE"}
	         ],
			 "scrollX"   : true,
			 "columnDefs": [
//				 {
//		        	targets  : 1,
//		        	orderable : false,
//		           	render   : function ( data, type, row, meta ) {
//		             	return meta.settings._iDisplayStart + meta.row + 1;
//		            }
//		         },
		         {
		            'targets': 0,
		            'checkboxes': {
		               'selectRow': true
		             }
		         }
		      ],
		      "select": {
		         "style" : "multi"
		      },
		      "order": [[ 1, "asc" ]]
			 
	     }); 
	}
	
	var handleTableTransfer = function() {
		$('#transferTable').DataTable( {
			 "data"       : dataSource,
			 "processing" : true,
			 "serverSide" : false,
			 "deferRender": false,
			 "fnRowCallback": function( Row, Data) {
				 if(!Data.valid){$('td', Row).css('background-color', '#ff8d8d').find('input[type=checkbox]').attr("disabled", true);}
             },
			 "columns": [
				{ "data": "transferID" },
				{ "data" : null          ,title :"ลำดับ" },
				{ "data": "empId"            ,title :"รหัสพนักงาน" },
				{ "data": "salutation"       ,title :"คำนำหน้า	" },
				{ "data": "name"             ,title :"ชื่อ"},
				{ "data": "surname"          ,title :"นามสกุล"},
				{ "data": "previousPosition" ,title :"ตำแหน่ง (เก่า)" },
				{ "data": "previousSector"   ,title :"สำนักงานภาค (เก่า)"},
				{ "data": "previousArea"     ,title :"สำนักงานเขต (เก่า)"},
				{ "data": "previousBranchIdStr" ,title :"รหัสสาขา (เก่า)"},
				{ "data": "previousBranchNm" ,title :"สาขา (เก่า)"},
				{ "data": "newPosition"      ,title :"ตำแหน่ง (ใหม่)"},
				{ "data": "newSector"        ,title :"สำนักงานภาค (ใหม่)"},
				{ "data": "newArea"          ,title :"สำนักงานเขต (ใหม่)"},
				{ "data": "newBranchIDStr"      ,title :"รหัสสาขา (ใหม่)"},
				{ "data": "newBranchNm"      ,title :"สาขา (ใหม่)"},
				{ "data": "email"            ,title :"E-Mail"},
				{ "data": "status"           ,title :"status"},
				{ "data": "effectiveDateStr" ,title :"วันมีผลบังคับ"},
				{ "data": "statusType"       ,title :"STATUS_TYPE"},
				{ "data": "channel"          ,title :"Channel"},
	         ],
			 "scrollX"   : true,
			 "columnDefs": [
				 {
		        	targets  : 1,
		        	orderable : false,
		           	render   : function ( data, type, row, meta ) {
		             	return meta.settings._iDisplayStart + meta.row + 1;
		            }
		         },
		         {
		            'targets': 0,
		            'checkboxes': {
		               'selectRow': true
		             }
		         }
		      ],
		      "select": {
		         "style" : "multi"
		      },
		      "order": [[ 1, "asc" ]]
			 
	     }); 
	}
	
	var handleTableLicense = function() {
		$('#licenseTable').DataTable( {
			 "data"       : dataSource,
			 "processing" : true,
			 "serverSide" : false,
			 "deferRender": false,
			 "fnRowCallback": function( Row, Data) {
				 if(!Data.valid){$('td', Row).css('background-color', '#ff8d8d').find('input[type=checkbox]').attr("disabled", true);}
             },
			 "columns": [
				 { "data": "modificationID" },
				 { "data" : null          ,title :"ลำดับ" },
				 { "data": "empId"        ,title :"รหัสพนักงาน"},
				 { "data": "salutation"   ,title :"คำนำหน้า" },
				 { "data": "name"         ,title :"ชื่อ" },
				 { "data": "surname"      ,title :"นามสกุล" },
				 { "data": "idCard"       ,title :"รหัสบัตรประชาชน" },
				 { "data": "position"     ,title :"ตำแหน่ง" },
				 { "data": "section"      ,title :"สำนักงานภาค" },
				 { "data": "areaIdStr"       ,title :"รหัสเขต" },
				 { "data": "areaName"     ,title :"สำนักงานเขต" },
				 { "data": "branchIdStr"     ,title :"รหัสสาขา" },
				 { "data": "branchName"   ,title :"ชื่อสาขา" },
				 { "data": "licenseId"    ,title :"เลขที่ใบอนุญาต" },
				 { "data": "effectiveDateStr",title :"วันที่ออกบัตร" },
				 { "data": "expiryDateStr"   ,title :"วันที่หมดอายุ" },
				 { "data": "email"        ,title :"E-Mail" },
				 { "data": "type"         ,title :"ประเภท" },
				 { "data": "channel"      ,title :"Channel" }
	         ],
		     
			 "scrollX"   : true,
			 "columnDefs": [
				 {
		        	targets  : 1,
		        	orderable : false,
		           	render   : function ( data, type, row, meta ) {
		             	return meta.settings._iDisplayStart + meta.row + 1;
		            }
		         },
		         {
		            'targets': 0,
		            'checkboxes': {
		               'selectRow': true
		             }
		         }
		      ],
		      "select": {
			  	  style : "multi"
			  },
		      "order"  : [[1, 'asc']]
	     }); 
	}
	
	var handleButtonClearTable = function() {
		$("#btnClearTable").on('click',function(){
			clearAllTable();
		});
	}
	
	var findListOfObjectTable = function($table) {
		var list = [];
		$('input:checked', $table.dataTable().fnGetNodes()).each(function(){
			var objectData = $table.DataTable().row($(this).parents('tr')).data();
			if (objectData !== undefined) {
				list.push(objectData);
			}
		});
		return list;
	}
	
	var clearAllTable = function(){
		$('#resignTable,#transferTable,#licenseTable').DataTable().clear();
		$('#resignTable,#transferTable,#licenseTable').DataTable().draw();
	}
	
	var saveExcelDatas = function(request){
		AjaxManager.PostData(request,'admin/saveExcelData',function(response){
			$('#modalConfirm').modal('hide');
			swal({ type: 'success'  ,  title: 'บันทึกข้อมูล สำเร็จ'  , showConfirmButton: false, timer: 2000 });
			clearAllTable();
		},function (jqXHR, textStatus, errorThrown) {
			$('#modalConfirm').modal('hide');
			swal({ type: 'warning'  ,  title: 'บันทึกข้อมูล ล้มเหลว '  , showConfirmButton: false, timer: 2000 });
			clearAllTable();
		});
	}
	
	var handleButtonSave = function() {
		$('#btnSave').on('click',function(){
			requestDatas = {};
			var $tableResign   = $('#resignTable');
			var $tableTransfer = $('#transferTable');
			var $tableLicense  = $('#licenseTable');
			requestDatas.resignDatas   = findListOfObjectTable($tableResign);
			requestDatas.transferDatas = findListOfObjectTable($tableTransfer);
			requestDatas.licenseDatas  = findListOfObjectTable($tableLicense);
			var isRequestEmpty = requestDatas.resignDatas.length   === 0 &&
								 requestDatas.transferDatas.length === 0 &&
								 requestDatas.licenseDatas.length  === 0;
			if(isRequestEmpty){
				swal({ type: 'warning'  ,  title: 'กรุณาเลือกข้อมูลอย่างน้อย  1 รายการ'  , showConfirmButton: false, timer: 2000 });
				return;
			}
			$('#modalConfirm').modal('show');
		});
	}
	
	var handleButtonConfirm = function(){
		$('#btnConfirm').on('click',function(){
			saveExcelDatas(requestDatas);
		});
	}
	
	return {
		init : function() {
			handleActiveMenu();
			handleForm();
			handleTableResign();
			handleTableTransfer();
			handleTableLicense();
			handleButtonClear();
			handleButtonClearTable();
			handleButtonSave();
			handleButtonConfirm();
		}
	}
}();

$(document).ready(function() {
	SpringAdminIdex.init();
});