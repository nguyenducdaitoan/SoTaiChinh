<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
    <title><c:out value="${detailThongBao.title}"/></title>    
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />	
	<link rel="stylesheet" type="text/css" media="screen" href="/css/style.css" />
</head>
<body>
<center>
<!-- start wrapper -->
<div id="wrapper">
    <!-- start header -->
    <div id="header">
    	<div id="bottom">
			<div id="slideshow">
			  <img src="images/banner.jpg" class="active" />
			</div>
    	</div>
    	<div style="clear: both"></div>
    </div>
	<!-- end header -->	
	<!-- start page -->
	<div id="page">
		<!-- start content -->        
       <div id="content" style="width: 100%">
        	<h1 class="title_post" style="font-size: 10pt; padding-left: 4px;">
				<c:out value="${detailThongBao.title}"/>
			</h1>
		<div class="post_content">
			<c:out value="${detailThongBao.content}" escapeXml="false"/>
		</div>
		<div class="clear"></div>
        </div>
        <!-- end content -->
	</div>
    <!-- end page -->
    <!-- start footer -->
	<div id="footer" style="height: 74px">
		<div style="padding: 10px 0px 0px 0px; margin: 0px">&copy; 2012 - Bản quyền thuộc sở tài chính thành phố Đà Nẵng</div>
		<div style="padding: 0px; margin: 0px">Giấy phép: Số 152/GP-TTĐT của Cục Quản lý Phát thanh, Truyền chình và Thông tin điện tử</div>
		<div style="padding: 0px; margin: 0px">Đại chỉ: 12 Trần Phú, thành phố Đà Nẵng</div>
		<div style="padding: 0px; margin: 0px">Điện thoại: (84.511) 3822130 - Fax : (84.511) 3827074 - Email: contact@sotaichinh.gov</div>
    </div>
	<!-- end footer -->
</div>
<!-- end wrapper -->
<style>
	.post_content div { width: 100% !important; text-align: justify;}
</style>
</center>
 
</body>
</html>