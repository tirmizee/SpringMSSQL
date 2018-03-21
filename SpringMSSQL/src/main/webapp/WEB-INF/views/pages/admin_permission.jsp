<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <link rel="shortcut icon" href="favicon.ico">

<link rel="shortcut icon" href="favicon.ico">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/bootstrap/css/bootstrap.min.css" >
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/validate-form-master/css/formValidation.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/ionicons/css/ionicons.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/select2/css/select2.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/admin-lte2/css/AdminLTE.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/admin-lte2/css/skins/skin-green.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/datatables/css/jquery.dataTables.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/datatables/css/buttons.dataTables.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/datatables/css/colReorder.dataTables.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/datatables/css/responsive.dataTables.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/bootstrap-toggle/css/bootstrap-toggle.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/sweetalert2/css/sweetalert2.min.css">


<script src="${pageContext.request.contextPath}/resources/libs/bootstrap/js/jquery-3.2.1.min.js" ></script>
<script src="${pageContext.request.contextPath}/resources/libs/bootstrap/js/bootstrap.min.js" ></script>
<script src="${pageContext.request.contextPath}/resources/libs/validate-form-master/js/formValidation.min.js" ></script>
<script src="${pageContext.request.contextPath}/resources/libs/validate-form-master/js/framework/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/libs/select2/js/select2.full.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/libs/admin-lte2/js/app.js"></script>
<script src="${pageContext.request.contextPath}/resources/libs/datatables/js/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/libs/datatables/js/dataTables.buttons.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/libs/datatables/js/dataTables.colReorder.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/libs/datatables/js/dataTables.responsive.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/libs/bootstrap-toggle/js/bootstrap-toggle.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/libs/sweetalert2/js/sweetalert2.all.js"></script>

<style >
.toggle.ios, .toggle-on.ios, .toggle-off.ios { border-radius: 20px;height:  }
.toggle.ios .toggle-handle { border-radius: 20px; }
div.dt-buttons {
    position: relative;
    float: right;
}
</style>
  <title>Permission</title>
</head>
<body class="hold-transition skin-green sidebar-mini">
  <div class="wrapper">

    <jsp:include page="../template/header.jsp" />
    <jsp:include page="../template/menu_sidebar_admin.jsp" />


    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
      <!-- Content Header (Page header) -->
      <section class="content-header">
        <h1>
          Dashboard
          <small>Version 0.1</small>
        </h1>
        <ol class="breadcrumb">
          <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
          <li class="active">Dashboard</li>
        </ol>
      </section>
		
      <!-- Main content -->
      <section class="content">
      	<div class="box box-default">
        <div class="box-header with-border">
          <h3 class="box-title">Search</h3>

          <div class="box-tools pull-right">
            <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
          </div>
        </div>
        <!-- /.box-header -->
        
        <div class="box-body">
        <form id="frmSearchUser" role="form">
          <div class="row">
          	<div class="col-md-6">
          	  <div class="form-group">
                <label>Permission Code</label>
                <input name="perCode" type="text" class="form-control"  placeholder="Permission Code">
              </div>
           	</div>
           	<div class="col-md-6">
          	  <div class="form-group">
                <label>Permission Name</label>
                <input name="perName" type="text" class="form-control"  placeholder="Permission Name">
              </div>
           	</div>
          </div>
          <div class="row text-center">
            <button id="btnClear" type="button" class="btn btn-default">Clear</button>
            <button id="btnSearch" type="submit" class="btn bg-olive">Search</button>
          </div>
         
         </form>
        </div>
        <!-- /.box-body -->
        <div class="box-footer">
          One of the best ways to learn how to do anything new (including software APIs!) is to get your hands dirty
        </div>
      </div>
      <!-- /.box box-default-->
      	<div class="box">
            <div class="box-body">
             <table id="example" class="display nowrap" cellspacing="0" width="100%"></table>
            </div><!-- /.box-body -->
      	</div><!-- /.box -->
        <a href="${pageContext.request.contextPath}/admin/report" target="_blank">export pdf</a> 
		

      </section>
      <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
	
	
	
   <jsp:include page="../template/footer.jsp" />

    <!-- /.control-sidebar -->
  <div class="control-sidebar-bg"></div>

</div>
<!-- ./wrapper -->
<div id="modalEdit" class="modal fade bd-example-modal-md" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true" >
  <div class="modal-dialog modal-md" >
    <div class="modal-content" style="border-radius: 10px;">
     <div class="box box-success">
      <div class="box-header">
        <h3 class="box-title">Edit User</h3>
      </div>
      <div class="box-body">
        <form id="frmEdit">
        
          <div class="row">
          	<input name="perId" type="hidden" class="form-control">
          	<div class="col-md-3">
	          <div class="form-group">
		          <label>Create Date</label>
		          <input name="createDate" type="text" class="form-control" disabled>
		       </div>
            </div>
          	<div class="col-md-3">
	          <div class="form-group">
	            <label>Permission Code</label>
	            <input name="perCode" type="text" class="form-control" disabled >
	          </div>
             </div>
             
             <div class="col-md-6">
	          <div class="form-group">
	            <label>Permission Name</label>
	            <input name="perName" type="text" class="form-control" >
	          </div>
             </div>
             
           </div>
           
           <div class="form-group">
	         <label>Permission Description</label>
	         <textarea name="perDesc" class="form-control" rows="3"></textarea>
	        </div>
           
          <!-- /.form group -->
          <div class="form-group">
            <div class="row text-center">
              <button id="btnCloseEdit" type="button" class="btn btn-default">close</button>
              <button id="btnSaveEdit" type="submit" class="btn bg-olive">Save</button>
            </div>
          </div>
          <!-- /.form group -->
        </form>
      </div>
      <!-- /.box-body -->
    </div>
    <!-- /.box -->
  </div>
 </div>
</div>
<script>
var AjaxManager = {
	RootUrl: 'http://localhost:8080/SpringMSSQL',
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
    },
    GetData: function (objToGet, getUri, onGetSuccess, onGetError) {
        $.ajax({
            type: 'GET',
            url: getUri,
            contentType: 'application/json;charset=utf-8',
            dataType: 'json',
            headers: {
            	'Accept': 'application/json'
            },
            data: objToGet,
        }).done(function (objRet) {
            onGetSuccess(objRet);
        }).fail(function (jqXHR, textStatus, errorThrown) {
            onGetError(jqXHR, textStatus, errorThrown);
        });
    }
};

var SpringPermission = function() {
	
	// init global variables
	var searchParam = {};
	var editParam = {};
	
	var handleActiveMenu = function() {
		$('ul.sidebar-menu > li.menu-role').addClass('active');
		$('ul.sidebar-menu > li.menu-role > ul.treeview-menu > li.permission').addClass('active');
	}
	
	var handleDataTable = function() {
		var btnEdit = '<button data-btn-name="btnEdit" type="button" class="btn btn-success" data-toggle="tooltip" title="Edit!"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></button>';
		var btnInfo = '<button data-btn-name="btnInfo" type="button" class="btn btn-info" data-toggle="tooltip" title="View!"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></button>';
		var DataTable = $('#example').DataTable( {
	        processing  : true,
	        responsive  : true,
	        select      : true,
	        serverSide  : true,
	        searching   : false,
	        ajax : {
	            url  : '../service/permission/findAll',
	            type : "POST",
	            contentType : 'application/json',
	            data : function ( d ) {
	            	d.search = searchParam;
	                return JSON.stringify(d);
	            },
				error: function (xhr, textStatus, errorThrown) {
				    switch (xhr.status) {
				  	  	case 302: alert(JSON.stringify(xhr));break;
				    	case 404: alert(JSON.stringify(xhr));break;
				    }
				}
	        },
	        columns : [ 
	            { data : "perId" },
	            { data :  null         ,title :"ลำดับ" },
	            { data : "perCode"     ,title :"รหัส" },
	            { data : "perName"     ,title :"ชื่อ" },
	            { data : "perDesc"     ,title :"รายละเอียด" },
	            { data : "createDate"  ,title :"วันที่สร้าง" },
	            { data : null }
	     
	        ],
	        columnDefs : [
	        	{
	         		 targets : 0,
	         		 visible : false
	         	 
	         	 },
	             {
		        	targets   : 1,
		        	width     : "10%",
		        	orderable : false,
		           	render    : function ( data, type, row, meta ) {
		             	return meta.settings._iDisplayStart + meta.row + 1;
		            }
	         	  },
	         	  {
	         		 targets  : 6,
	         		 className : "dt-right",
	         		 orderable : false,
		           	 render    : function ( data, type, row, meta ) {
		             	return btnInfo + ' ' + btnEdit;
		             }
	         	  }
	         ]
	    });
		
		// handle button edit for table
		$(document).on('click', 'button[data-btn-name="btnEdit"]', function () {
			$('#frmEdit').formValidation('resetForm', true);
			var data = DataTable.row( $(this).parents('tr') ).data();
			editParam = data;
			$('#frmEdit input[name="createDate"]').val(data.createDate);
			$('#frmEdit input[name="perCode"]').val(data.perCode);
			$('#frmEdit input[name="perName"]').val(data.perName);
			$('#frmEdit textarea[name="perDesc"]').val(data.perDesc);
			$('#modalEdit').modal('show');
		});
	}
	
	var handleButtonSearch = function() {
		$('#btnSearch').on('click',function(e){
			e.preventDefault()
			searchParam.perCode = $('input[name="perCode"]').val();
			searchParam.perName = $('input[name="perName"]').val();
			console.log(JSON.stringify(searchParam,undefined,4));
			$('#example').DataTable().ajax.reload();
		});
	}
	
	var handleButtonClear = function () {
		$('#btnClear').on('click',function(){
			$('#frmSearchUser')[0].reset();
		});
	}
	
	var handleButtonCloseEdit = function () {
		$('#btnCloseEdit').on('click',function(){
			$('#modalEdit').modal('hide');
		});
	}
	
	var handleButtonSaveEdit = function(){
		$('#btnSaveEdit').on('click',function(e){
			e.preventDefault()
			var objEdit = {
				perId   : editParam.perId,
				perName : $('#frmEdit input[name="perName"]').val(),
				perDesc : $('#frmEdit textarea[name="perDesc"]').val()
			};
			AjaxManager.PostData(objEdit,'../service/permission/edit',function(response){
				if (response) {
					$('#modalEdit').modal('hide');
					swal({ type: 'success'  ,  title: 'บันทึกข้อมูล สำเร็จ'  , showConfirmButton: false, timer: 2000 });
					$('#example').DataTable().ajax.reload();
				}
			});
		});
	}
	
	return { 
		init : function(){
			handleActiveMenu();
			handleDataTable();
			handleButtonSearch();
			handleButtonClear();
			handleButtonCloseEdit();
			handleButtonSaveEdit();
		}
	};

}();

$(document).ready(function() {
	SpringPermission.init();
});
</script>
</body>
</html>