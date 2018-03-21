<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8;"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="favicon.ico">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/bootstrap/css/bootstrap.min.css" >
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/bootstrap/css/bootstrap-theme.min.css" >
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/validate-form-master/css/formValidation.min.css">

<script src="${pageContext.request.contextPath}/resources/libs/bootstrap/js/jquery-3.2.1.min.js" ></script>
<script src="${pageContext.request.contextPath}/resources/libs/bootstrap/js/bootstrap.min.js" ></script>
<script src="${pageContext.request.contextPath}/resources/libs/validate-form-master/js/formValidation.min.js" ></script>
<script src="${pageContext.request.contextPath}/resources/libs/validate-form-master/js/framework/bootstrap.min.js"></script>

<style>
@font-face {
	font-family: 'Cloud-Bold';
	src: url('resources/fonts/Cloud-LightBold/Cloud-Bold.otf');
}
@font-face {
	font-family: 'passion_bold';
	src: url('resources/fonts/Passion_One/PassionOne-Bold.ttf');
}
.loginmodal-container { 
  padding: 30px;
  max-width: 350px;
  width: 100% !important;
  background-color: #F7F7F7;
  margin: 0 auto;
  border-radius: 5px;
  box-shadow: 0px 2px 2px rgba(0.6, 0, 0, 0.3);
  overflow: hidden;
  font-family: roboto;
}
#inFormLogin .has-error .control-label,
#inFormLogin .has-error .help-block,
#inFormLogin .has-error .form-control-feedback {
    color: red;
}

#inFormLogin .has-success .control-label,
#inFormLogin .has-success .help-block,
#inFormLogin .has-success .form-control-feedback {
    color: #18bc9c;
}
#errorMsg{
	max-width: 350px;
	margin: auto;	
}
.txt16{
	font-size: 16px;
}
.txt18{
	font-size: 18px;
}
.txt20{
	font-size: 20px;
}
.txt26{
	font-size: 26px;
}
.bg{
	background-color: #f7f7f7;
}
</style>
<title>Hello Spring</title>
</head>
<body class="bg">
	<div class="container" style="margin-top: 12%" >
		<c:if test="${not empty error}">
			<div id="errorMsg"  class="alert alert-danger" align="center">
			<a href="#" class="close" onclick="$('#errorMsg').hide()"> &times;</a>
				 ชื่อผู้ใช้ หรือรหัสผ่าน <strong>ไม่ถูกต้อง</strong>
			</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>
		<div class="loginmodal-container" style="margin-top: 10px;">
			<form id="inFormLogin" action="login" method="post">
				<div class="form-group">
					<div class="text-center">
						<div class="txt26" style="font-family: 'passion_bold';"><b style="color:green">Spring</b>MVC</div>
					</div>		
				</div>	
				<div class="form-group">
					<div class="input-group">
						<span class="input-group-addon" id="sizing-addon2"><span class="glyphicon glyphicon-user"></span></span>
						<input type="text" class="form-control" name="username" placeholder="Username" aria-describedby="sizing-addon2">
					</div>
				</div>	
				
				<div class="form-group">
				 	<div class="input-group">
						<span class="input-group-addon" id="sizing-addon2"><span class="glyphicon glyphicon-lock"></span> </span>
						<input type="password" class="form-control" name="password" placeholder="Password" aria-describedby="sizing-addon2">
					</div>
				</div>
				
				<div class="form-group">
					<input  class="btn btn-success"  type="submit" value="Login"  style="width: 100%;font-weight: 800;">	 
			    </div>	
			    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />			
			</form>
		</div> <!-- loginmodal-container -->

	</div>	<!-- container -->
<script>
$(document).ready(function(){
	
	var userName = $('#errorMsg');
	 
	
	$('#inFormLogin').formValidation({
		 framework: 'bootstrap',
	        icon: {
	            /* valid: 'glyphicon glyphicon-ok', */
	            /* invalid: 'glyphicon glyphicon-remove', */
	            validating: 'glyphicon glyphicon-refresh'
	        },
	        fields: {
	            username: {
	                validators: {
	                    notEmpty: {
	                        message: 'The username is required'
	                    },
	                    stringLength: {
	                        min: 3,
	                        max: 30,
	                        message: 'The username must be more than 6 and less than 30 '
	                    }
	                }
	            },
	            password: {
	                validators: {
	                    notEmpty: {
	                        message: 'The password is required'
	                    },
	                    stringLength: {
	                        min: 3,
	                        max: 100,
	                        message: 'The password must be more than 6 and less than 100 '
	                    }
	                }
	            }
	        }
        
	}).on('err.field.fv', function(e, data) {
        if (data.fv.getSubmitButton()) {
            data.fv.disableSubmitButtons(false);
        }
    }).on('success.form.fv', function(event) {	  
		
	});  
	
	
	
	
}); 
</script>
</body>
</html>