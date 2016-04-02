<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="content-type" content="text/html;charset=UTF-8" />
    <title>Đăng nhập hệ thống</title>
	<script type="text/javascript" src="/js/jquery-1.7.1.min.js"></script>
	<script type="text/javascript" src="/js/md5.js"></script>
    <link href="/admin/css/login.css" media="screen" rel="stylesheet" type="text/css" />
	<!--[if IE]>		
	<style type="text/css">			
		.ie-shadow {				
			background: #999; 
			display: block; 
			left: -5px; 
			height: 100%; 
			position: absolute; 
			top: -5px; 
			width: 100%; 
			z-index: 1;				
			filter:progid:DXImageTransform.Microsoft.Blur(PixelRadius='5', MakeShadow='true', ShadowOpacity='0.40');
		}
	</style>
    <![endif]-->    
	<!--[if IE 7]>		
	<style type="text/css">			
		div#login-form-container { height: 180px; }			
		.login-position, .login-form-container { width: 602px; }			
		h2 { width:200px; overflow:hidden; text-align:center; }		
	</style>    
	<![endif]-->    
	<!--[if lte IE 6]>		
	<style type="text/css">			
		.login-position { width: 350px !important; }			
		.login-form-container { text-align:center; width: auto !important; }			
		h2#company-logo { 
			border-left: none !important; 
			border-bottom: 1px dotted #999 !important; 
			float:none !important; 
			height:auto !important; 
			line-height: 1em !important; 
			margin:0 0 25px !important; 
			padding: 0 0 25px !important; 
			width:285px; 
		}			
		div#login-form { 
			border: none !important; 
			float:none !important; 
			margin:0 auto !important; 
			padding:0 !important; 
			text-align:left; 
		}			
		.ie-shadow { display:none; }			
		.forgot-password input { width:210px !important; }			
		form#normal_form, form#openid_form, form#forgot_password { margin-top:0 !important; }
		div.login-footer { text-align:center !important; }			
		div.login-footer ul { float:none !important; margin:0 auto !important; }			
		div.login-footer .poweredby { margin-top:15px; }			
		img { -ms-interpolation-mode:bicubic; }		
	</style>    
	<![endif]-->  
	<script type="text/javascript">
		$(document).ready(function() {
			$("input#usernameId").focus();
			$('form[name="normal_form"]').submit(function() {
				if ($('input#usernameId').val() == '') {
					alert('Tên đăng nhập không được trống');
					$("input#user_name").focus();
					return false;
				}
				if ($('input#passwordId').val() == '') {
					alert('Mật khẩu đăng nhập là không được trống');
					$("input#passwordId").focus();
					return false;
				}
				var passwordMd5 = hex_md5($('input#passwordId').val());
				$('input#passwordId').val('password');
				$('input#passwordMd5Id').val(passwordMd5);
				return true;
			});
			if (top.frames.length>0) {
				top.location.href=document.location.href;
			}
		});
	</script>
</head> 
<body class="login">	
	<div class="login-position">		
		<div class="login-container shadow-boxer login-center">			
			<div class="ie-shadow">&nbsp;</div>			
			<div id="login-form-container">				
				<div id="company-logo">
				<div style="padding-top: 8px; font-family: 'Arial'; font-size: 12pt; font-weight: bold; letter-spacing: 1.5pt; text-shadow: 0.05em 0.05em 0.05em #fff">Sở Tài Chính TP Đà Nẵng</div>
					<img src="/admin/images/login.png" />
				</div>				
				<div id="login-form">										
					<form:form name="normal_form" commandName="loginForm" method="POST" action="/admin/login.html">
						<form:errors path="*" cssStyle="color: red" />
						<form:hidden path="passwordMd5" id="passwordMd5Id" />																
						<div class="text-field">
							<label for="user_name">Tên đăng nhập</label>
							<form:input path="userName" size="30" tabindex="1" id="userNameId" />
						</div>
						<div class="text-field">
							<label for="user_password">Mật khẩu</label>
							<form:password path="password" size="30" tabindex="2" value="" id="passwordId" />						
						</div>						
						<div class="btn_container submit-field">
							<input type="submit" tabindex="4" value="Đăng nhập" class="login">
						</div>					
					</form:form>				
				</div>				
				<div class="clear"></div>			
			</div>		
		</div>		
		<div class="clear"></div>		
		<div class="login-center login-footer"></div>
	</div>
</body>
</html>