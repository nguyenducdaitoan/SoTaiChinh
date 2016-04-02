<%@page import="vn.softech.hibernate.TblGioiThieu"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="net.fckeditor.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sửa thông tin giới thiệu</title>
<link rel="stylesheet" type="text/css"  media="screen" href="/admin/css/style.css" />
<script type="text/javascript" src="/js/jquery-1.7.1.js"></script>
<script type="text/javascript" charset="utf-8">
	$(document).ready(function() {
		$("img#imgSaveNews").click(function(){
			$("[name=GioiThieuEditForm]").submit();
		});
	});
</script>
</head>
<body>
	<form:form name="GioiThieuEditForm" method="POST" commandName="gioithieu" action="/admin/gioithieu/submitedit.html" accept-charset="UTF-8">
	<form:hidden path="gioiThieuId"/>
	<div id="bodyadmin">
	    <div id="header">
	        <div style="width: 250px; text-align:left; float:left; font-family: Tahoma; font-size:10pt;">
	            <img src="/admin/images/data.gif" title="" />&nbsp;Sửa thông tin giới thiệu
	        </div>
	        <div style="width: 150px; text-align:right; float:right; padding-right:5px;"></div>
	        <div style="clear:both"></div>
	    </div>
	    <div id="content" style="font-family:Arial; font-size:10pt; text-align:left">
	    	<div style="clear:both; height:15px;"></div>
       
	        <div>
	            <div style="float:left; width: 140px; text-align:right; padding-right:8px;">
	                Tiêu đề
	            </div>
	            <div style="float:left; width: 456px; text-align:left;">
	                <form:input path="title" maxlength="90" style="width:90%"/>
	            </div>
	        </div>
	        <div style="clear:both; height: 3px;"></div>
	        <div>
	            <div style="float:left; width: 140px; text-align:right; padding-right:8px;">
	                Tiêu đề hiển thị menu
	            </div>
	            <div style="float:left; width: 456px; text-align:left;">	            	
	            	<form:input path="titleMenu" maxlength="90" style="width:90%" />
	            </div>
	        </div>
	        <div style="clear:both; height: 3px;"></div> 
	        <div>
	            <div style="float:left; width: 140px; text-align:right; padding-right:8px;">
	                Hiển thị
	            </div>
	            <div style="float:left; width: 40px; text-align:left;">
	                <form:checkbox path="active"/>
	            </div>
	            <div style="float:left; width: 60px; text-align:right; padding-right:8px;">
	                Thứ tự
	            </div>
	            <div style="float:left; width: 356px; text-align:left;">	              
	                <form:input path="priority" maxlength="2" style="width:20px"/>
	            </div>
			</div>
			<div style="clear:both; height:3px;"></div>
	        <div style="padding-left: 4px;">
	        
	        
<div><%
			TblGioiThieu gioithieu= (TblGioiThieu)request.getAttribute("gioithieu");
			FCKeditor oFCKeditor;
			oFCKeditor = new FCKeditor(request,"txtFCKContent");
			oFCKeditor.setWidth("100%");
			oFCKeditor.setHeight("350");
			oFCKeditor.setBasePath("/fckeditor/");
			String content= gioithieu.getContent();
			if (content!=null) {
				oFCKeditor.setValue(content);
			} else oFCKeditor.setValue(""); 
			out.println(oFCKeditor.createHtml());
%>
</div>
<!-- <iframe id="txtFCKContent___Frame" frameborder="0" height="350" scrolling="no" width="100%" src="/fckeditor//editor/fckeditor.html?InstanceName=txtFCKContent&amp;Toolbar=Default"> </iframe></div> -->

	        </div>
	        <div style="clear:both"></div>
	    </div>
		<div id="footer">
	    	<img src="/admin/images/save.png" style="margin-left:10px; cursor:pointer" id="imgSaveNews" title="Lưu dữ liệu" /><span style="padding-left:5px; color:red; font-family:Tahoma; font-size:10pt;"><-Lưu dữ liệu</span>
	    </div>
	</div>
	</form:form>
<script type="text/javascript">
	var clientHeight = document.documentElement.clientHeight;
	var clientWidth = document.documentElement.clientWidth;
	if ($.browser.msie)	{
//		if ($.browser.version == '9.0') {
			$("div#content").css({"height": clientHeight - 43});
			$("input[name=titleMenu]").css({"width": clientWidth - 172});
			$("input[name=title]").css({"width": clientWidth - 172});				
			document.getElementById('txtFCKContent___Frame').width = clientWidth - 23;
			document.getElementById('txtFCKContent___Frame').height = clientHeight - 144;
			$("div#footer").css({"top": clientHeight - 18,"left": 0});
//		} else {
//			$("div#content").css({"height": clientHeight - 43});
//			$("input[name=titleMenu]").css({"width": clientWidth - 154});
//			$("input[name=title]").css({"width": clientWidth - 154});
//			document.getElementById('txtFCKContent___Frame').width = clientWidth - 5;
//			document.getElementById('txtFCKContent___Frame').height = clientHeight - 144;
//			$("div#footer").css({"top": clientHeight - 18,"left": 0});
//		}
	} else if ($.browser.mozilla) {
		$("div#content").css({"height": clientHeight - 44});
		$("input[name=titleMenu]").css({"width": clientWidth - 171});
		$("input[name=title]").css({"width": clientWidth - 171});		
		document.getElementById('txtFCKContent___Frame').width = clientWidth - 24;
		document.getElementById('txtFCKContent___Frame').height = clientHeight - 140;
		$("div#footer").css({"top": clientHeight - 19,"left": 0});
	} else if ($.browser.safari) {
		$("div#content").css({"height": clientHeight - 44});
		$("input[name=titleMenu]").css({"width": clientWidth - 171});
		$("input[name=title]").css({"width": clientWidth - 171});		
		document.getElementById('txtFCKContent___Frame').width = clientWidth - 24;
		document.getElementById('txtFCKContent___Frame').height = clientHeight - 140;
		$("div#footer").css({"top": clientHeight - 19,"left": 0});
	} else if ($.browser.opera) {
		$("div#content").css({"height": clientHeight - 44});
		$("input[name=titleMenu]").css({"width": clientWidth - 171});
		$("input[name=title]").css({"width": clientWidth - 171});		
		document.getElementById('txtFCKContent___Frame').width = clientWidth - 24;
		document.getElementById('txtFCKContent___Frame').height = clientHeight - 140;
		$("div#footer").css({"top": clientHeight - 19,"left": 0});
	}  else{
		$("div#content").css({"height": clientHeight - 44});
		$("input[name=titleMenu]").css({"width": clientWidth - 171});
		$("input[name=title]").css({"width": clientWidth - 171});		
		document.getElementById('txtFCKContent___Frame').width = clientWidth - 24;
		document.getElementById('txtFCKContent___Frame').height = clientHeight - 140;
		$("div#footer").css({"top": clientHeight - 19,"left": 0});
	}
</script>
</body>
</html>