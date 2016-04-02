<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link rel="stylesheet" type="text/css"  media="screen" href="/admin/css/style.css" />
<script type="text/javascript" src="/js/jquery-1.7.1.js"></script>
<style type="text/css">
	fieldset {
		font-family: Arial;
		font-size: 10pt;
	}
	fieldset legend {
		font-family: Tahoma;
		font-weight: bold;
		color: #191970;
		margin-bottom: 4px;
	}
	div.title {
		font-family: Tahoma;
		font-size: 0.8em;
		color: #1100db;
		font-weight: bold;
		padding-bottom: 4px;
	}
	div.inline {
		float: left;
	}
	div.label {
		font-size: 10pt;
		font-weight: bold;
		color: #1100db;
		padding-right: 4px;
	}
	div.clear {
		clear: both;
		height: 2px;
	}	
</style>
<script type="text/javascript" charset="utf-8">
	$(document).ready(function() {
		$("input:button[name='changepassword']").click(function() {
			var oldpassword = $("input:password[name='oldpassword']").val();
			if (oldpassword == '') {
				alert('Chưa nhập mật khẩu hiện tại');
				$("input:password[name='oldpassword']").focus();
				return;
			}			
			var newpassword1 = $("input:password[name='newpassword1']").val();
			if (newpassword1 == '') {
				alert('Chưa nhập mật khẩu mới');
				$("input:password[name='newpassword1']").focus();
				return;
			}
			var newpassword2 = $("input:password[name='newpassword2']").val();
			if (newpassword2 == '') {
				alert('Chưa nhập lặp lại mật khẩu mới');
				$("input:password[name='newpassword2']").focus();
				return;
			}
			if (newpassword1 != newpassword2) {
				alert('Mật khẩu mới và lặp lại mật khẩu là không giống nhau');
				$("input:password[name='newpassword2']").focus();
				return;
			}
			$.ajax({
				type: "POST",
				url: "/admin/changepassword.do",
				dataType: 'html',
				data: "oldpassword="+oldpassword+"&newpassword1="+newpassword1+"&newpassword2="+newpassword2,
				success: function(data) {
					var respone = $.parseJSON(data);
					if ((respone.message != null) && (respone.message != '')) {
						alert(respone.message);
					} else {
						alert("Mật khẩu đã thay đổi thành công");
					}			
				}
			});
		});
		$("input:button[name='changeInfoAccount']").click(function() {
			var firstName = $("input:text[name='firstName']").val();
			if (firstName == '') {
				alert('Chưa nhập firstName');
				$("input:text[name='firstName']").focus();
				return;
			}			
			var lastName = $("input:text[name='lastName']").val();
			if (lastName == '') {
				alert('Chưa nhập lastName');
				$("input:text[name='lastName']").focus();
				return;
			}
			var email = $("input:text[name='email']").val();
			if (email == '') {
				alert('Chưa nhập email');
				$("input:text[name='email']").focus();
				return;
			}			
			$.ajax({
				type: "POST",
				url: "/admin/changeinfo.do",
				dataType: 'html',
				data: "firstname="+firstName+"&lastname="+lastName+"&email="+email,
				success: function(data) {
					var respone = $.parseJSON(data);
					if ((respone.message != null) && (respone.message != '')) {
						alert(respone.message);
					} else {
						alert("Thay đổi thông tin thành công");
					}			
				}
			});
		});
	});
</script>
</head>
<body>
	<div style="margin: 0 auto; padding: 15px 20px">
		<fieldset>
			<legend>Đổi mật khẩu</legend>
			<div style="float:left; padding-top: 1px; width: 140px; text-align:right; padding-right:3px; font-family: Arial; font-size: 10pt;">
                Mật khẩu hiện tại&nbsp;:
            </div>
            <div style="float:left; width: 360px; text-align:left;">
           		<input type="password" style="width:90%;" maxlength="50" class="textbox" name="oldpassword" value="" />  
            </div>
            <div style="clear:both; height: 3px;"></div>
            <div style="float:left; padding-top: 1px; width: 140px; text-align:right; padding-right:3px; font-family: Arial; font-size: 10pt;">
                Mật khẩu mới&nbsp;:
            </div>
            <div style="float:left; width: 360px; text-align:left;">
           		<input type="password" style="width:90%;" maxlength="50" class="textbox" name="newpassword1" value="" />  
            </div>
            <div style="clear:both; height: 3px;"></div>
            <div style="float:left; padding-top: 1px; width: 140px; text-align:right; padding-right:3px; font-family: Arial; font-size: 10pt;">
                Nhập lại&nbsp;:
            </div>
            <div style="float:left; width: 360px; text-align:left;">
           		<input type="password" style="width:90%;" maxlength="50" class="textbox" name="newpassword2" value="" />  
            </div>
            <div style="clear:both; height: 9px;"></div>
            <div style="float:left; padding-top: 1px; width: 140px; text-align:right; padding-right:3px; font-family: Arial; font-size: 10pt;"></div>            
            <div style="float:left; width: 360px; text-align:left;">
           		<input type="button" class="button" name="changepassword" value="Đổi mật khẩu" />  
            </div>
		</fieldset>		
	</div>
	<div style="margin: 0 auto; padding: 10px 20px;">
		<fieldset>
			<legend>Thay đổi thông tin người dùng</legend>
			<div style="float:left; padding-top: 1px; width: 140px; text-align:right; padding-right:3px; font-family: Arial; font-size: 10pt;">
                First Name&nbsp;:
            </div>
            <div style="float:left; width: 360px; text-align:left;">
           		<input type="text" style="width:90%;" maxlength="50" class="textbox" name="firstName" value="Quản" />  
            </div>
            <div style="clear:both; height: 3px;"></div>
            <div style="float:left; padding-top: 1px; width: 140px; text-align:right; padding-right:3px; font-family: Arial; font-size: 10pt;">
                Last Name&nbsp;:
            </div>
            <div style="float:left; width: 360px; text-align:left;">
           		<input type="text" style="width:90%;" maxlength="50" class="textbox" name="lastName" value="Trị" />  
            </div>
            <div style="clear:both; height: 3px;"></div>
            <div style="float:left; padding-top: 1px; width: 140px; text-align:right; padding-right:3px; font-family: Arial; font-size: 10pt;">
                Email&nbsp;:
            </div>
            <div style="float:left; width: 360px; text-align:left;">
           		<input type="text" style="width:90%;" maxlength="50" class="textbox" name="email" value="stcdanang@mof.gov.vn" />  
            </div>
            <div style="clear:both; height: 9px;"></div>
            <div style="float:left; padding-top: 1px; width: 140px; text-align:right; padding-right:3px; font-family: Arial; font-size: 10pt;"></div>            
            <div style="float:left; width: 360px; text-align:left;">
           		<input type="button" class="button" name="changeInfoAccount" value="Cập nhật" />  
            </div>
		</fieldset>
	</div>
</body>
</html>
