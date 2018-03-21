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
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/inputmark/css/inputmask.css">


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
<script src="${pageContext.request.contextPath}/resources/libs/inputmark/js/jquery.inputmask.bundle.js"></script>
<script src="${pageContext.request.contextPath}/resources/libs/juery-cookie/js/jquery.cookie.js"></script>

<style >
.toggle.ios, .toggle-on.ios, .toggle-off.ios { border-radius: 20px;height:  }
.toggle.ios .toggle-handle { border-radius: 20px; }
div.dt-buttons {
    position: relative;
    float: right;
}
</style>
  <title>Address</title>
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
          <h3 class="box-title">${label.btn_search}</h3>

          <div class="box-tools pull-right">
            <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
          </div>
        </div>
        <!-- /.box-header -->
        
        <div class="box-body">
        <form id="frmSearchAddress" role="form">
          <div class="row">
          	<div class="col-md-6">
          	  <div class="form-group">
                <label>Province</label>
                <input name="provinceName" type="text" class="form-control"  placeholder="Province...">
              </div>
           	</div>
           	<div class="col-md-6">
          	  <div class="form-group">
                <label>District</label>
                <input name="districtName" type="text" class="form-control"  placeholder="District...">
              </div>
           	</div>
          </div>
          <div class="row">
          	<div class="col-md-6">
          	  <div class="form-group">
                <label>Sub District</label>
                <input name="subDistrictName" type="text" class="form-control"  placeholder="Sub District...">
              </div>
           	</div>
           	<div class="col-md-6">
          	  <div class="form-group">
                <label>Post Code</label>
                <input name="postCode" type="text" class="form-control"  placeholder="Post Code...">
              </div>
           	</div>
          </div>
          <div class="row text-center">
            <button id="btnClear" type="button" class="btn btn-default">Clear</button>
            <button id="btnSearch" type="submit" class="btn bg-olive">Search</button>
          </div>
         
         </form>
        </div>
        <div class="box-footer">
          One of the best ways to learn how to do anything new (including software APIs!) is to get your hands dirty
        </div>
      </div>
      	<div class="box">
            <div class="box-body">
             <table id="example" class="display nowrap" cellspacing="0" width="100%"></table>
            </div><!-- /.box-body -->
      	</div><!-- /.box -->
      </section>
    </div>
	
	
	
   <jsp:include page="../template/footer.jsp" />

    <!-- /.control-sidebar -->
  <div class="control-sidebar-bg"></div>

</div>
<!-- ./wrapper -->

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

var SpringAddress = function() {
	
	// init global variables
	var searchParam = {};
	
	var handleActiveMenu = function() {
		$('ul.sidebar-menu > li.menu-address').addClass('active');
	}
	
	var handleDataTable = function(){
		var lang = $.cookie("Language");
		var btnEdit = '<button data-btn-name="btnEdit" type="button" class="btn btn-success" data-toggle="tooltip" title="Edit!"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></button>';
		var DataTable = $('#example').DataTable( {
	        processing  : true,
	        responsive  : true,
	        select      : true,
	        serverSide  : true,
	        searching   : false,
	        language    : {
	        	"lengthMenu"     : lang === "th" ? "แสดง  _MENU_ รายการ"        : "Show _MENU_ entries",
	            "zeroRecords"    : lang === "th" ? "ไม่พบข้อมูล"                 : "Nothing found - sorry",
	            "info"           : lang === "th" ? "แสดงหน้า _PAGE_ ของ _PAGES_" : "Showing page _PAGE_ of _PAGES_",
	            "infoEmpty"      : lang === "th" ? "ไม่พบข้อมูล"                 : "No records available",
	            "loadingRecords" : lang === "th" ? "กำลังโหลดข้อมูล..."            : "Loading...",
          		"paginate"  : {
      		        "first"    : lang === "th" ? "หน้าแรก"  : "First",
      		        "last"     : lang === "th" ? "สุดท้าย"   : "Last",
      		        "next"     : lang === "th" ? "ถัดไป"    : "Next",
      		        "previous" : lang === "th" ? "ก่อนหน้า"  : "Previous"
          		 },
	        },
	        ajax : {
	            url  : '../service/address/findByCriteria',
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
	            { data :  null ,title : lang === "th" ? "ลำดับ"    : "Order"},
	            { data : (lang === "th" ? "provinceNameTH" : "provinceNameEN")  ,title : lang === "th" ? "จังหวัด"    : "Province"},
	            { data : (lang === "th" ? "districtNameTH" : "districtNameEN")  ,title : lang === "th" ? "อำเภอ"    : "District" },
	            { data : "subDistrictName"  ,title : lang === "th" ? "ตำบล"     : "SubDistrict" },
	            { data : "postcode"         ,title : lang === "th" ? "รหัสไปษณีย์" : "PostCode" },
	            { data : null }
	        ],
	        columnDefs : [
	             {
		        	targets   : 0,
		        	width     : "10%",
		        	orderable : false,
		           	render    : function ( data, type, row, meta ) {
		             	return meta.settings._iDisplayStart + meta.row + 1;
		            }
	         	  },
	         	  {
		        	targets   : 4,
		        	width     : "10%"
		          },
	         	  {
	         		 targets   : 5,
	         		 width     : "10%",
	         		 className : "dt-right",
	         		 orderable : false,
		           	 render    : function ( data, type, row, meta ) {
		             	return btnEdit;
		             }
	         	  }
	         ]
	    });
	}
	
	var handleButtonSearch = function() {
		$('#btnSearch').on('click',function(e){
			e.preventDefault()
			searchParam.provinceName = $('input[name="provinceName"]').val();
			searchParam.districtName = $('input[name="districtName"]').val();
			searchParam.subDistrictName = $('input[name="subDistrictName"]').val();
			searchParam.postCode = $('input[name="postCode"]').val();
			console.log(JSON.stringify(searchParam,undefined,4));
			$('#example').DataTable().ajax.reload();
		});
	}
	
	var handleButtonClear = function () {
		$('#btnClear').on('click',function(){
			$('#frmSearchAddress')[0].reset();
		});
	}
	
	var handleInputPostCode = function(){
		$('input[name="postCode"]').inputmask({
			 mask : "99999",
			 placeholder : ""
		}); 
	}

	return { 
		init : function(){
			handleActiveMenu();
			handleDataTable();
			handleButtonSearch();
			handleButtonClear();
			handleInputPostCode();
		}
	};

}();

$(document).ready(function() {
	SpringAddress.init();
});
</script>
</body>
</html>