<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>
<style type="text/css">
	.topBody {
		background-color: #ffffff;
		background-image:url(images/top_bg.jpg);
		background-position: left bottom;
		background-repeat: repeat-x;
	}
	
	.adminTop {
		background-image:url(images/top_body_bg.jpg);
		background-position: top right;
		background-repeat: no-repeat;
		margin: 0;
		height: 48px;
	}
	
	.adminTopLeft {
		width: 300px;
		float: left;
		height: 48px;
		font-size: 14px;
		padding-left:10px;
		font-family: Tahoma;
	}
	
	.adminTopLeft p {
		line-height:48px;
		margin:0;
		padding:0;
	}
	
	.adminTopRight {
		width: 300px;
		float: right;
		text-align:right
	}
	
	.adminTopRight p {
		line-height:48px;
		margin:0;
		padding:0;
	}
	.adminTopRight a {
	    color: #B30715;
	    outline: medium none;
	    text-decoration: none;
	    text-transform: none;
	    position: relative;
	    top: 5px;
	    padding-right: 20px;
	    font-size: 14px;
	    font-weight: bold;
	    font-family: Tahoma;
		text-shadow: 1px 1px #FFFFFF;
	}
	.adminTopRight a:hover {
	    color: #FDDEBF;	    
	}
</style>
</head>
<body topmargin="0" leftmargin="0" rightmargin="0" bottommargin="0">
	<div class="topBody" style="height:50px;">
		<div class="adminTop">
			<div class="adminTopLeft">
<%
	String fullNameLogin = "";
	try {
		fullNameLogin = session.getAttribute("FirstName").toString() + "&nbsp;" + session.getAttribute("LastName").toString();
	} catch(Exception e) {}
	
	if ((fullNameLogin != null) && (!"".equals(fullNameLogin))) {
%>
				<p><b>Chào mừng <span style="color: blue"><%=fullNameLogin%></span></b></p>
<%
	}
%>
			</div>
			<div class="adminTopRight">
				<div><a href="/home.do" target="_blank" >Xem trang ngoài</a></div>
				<div><a href="/admin/logout.html">Thoát</a></div>
			</div>
		</div>
	</div>
</body>
</html>