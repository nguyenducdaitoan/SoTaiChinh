<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jstl/core' prefix='c' %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sửa thông tin vai trò người dùng</title>
<link rel="stylesheet" type="text/css"  media="screen" href="/admin/css/style.css" />
<script type="text/javascript" src="/js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" charset="utf-8">
	$(document).ready(function() {
		$("img#imgSaveNews").click(function(){
			if ($("input[name='name']").val() == '') {
				alert('Bạn chưa nhập tên URL!');
				$('input[name="name"]').focus();
				$('input[name="name"]').select();
				return false;
			} else if ($("input[name='priority']").val() == '') {
				alert('Bạn chưa nhập độ ưu tiên!');
				$('input[name="priority"]').focus();
				$('input[name="priority"]').select();
				return false;
			} else {
				$("form[name=UrlsForm]").submit();
			}
		});
	});
</script>
</head>
<body>
	<form:form name="UrlsForm" commandName="urlsForm" method="POST" action="/admin/urls/edit.html">
	<form:hidden path="urlsId"/>
	<div id="bodyadmin">
	    <div id="header">
	        <div style="width: 250px; text-align:left; float:left; font-family: Tahoma; font-size:10pt;">
	            <img src="images/data.gif" title="" />&nbsp;Sửa thông tin URL
	        </div>
	        <div style="width: 150px; text-align:right; float:right; padding-right:5px;"></div>
	        <div style="clear:both"></div>
	    </div>
	    <div id="content" style="font-family:Arial; font-size:10pt; text-align:left">
	    	<div style="clear:both; height:15px;"></div>
	        <div>
	            <div style="float:left; width: 80px; text-align:right; padding-right:8px;">
	                Tên URL:
	            </div>
	            <div style="float:left; width: 256px; text-align:left;">
	                <form:input path="name" maxlength="90" style="width:90%"/>
	            </div>
	        </div>	       
	        <div style="clear:both; height: 3px;"></div>
	        <div>
	            <div style="float:left; width: 80px; text-align:right; padding-right:8px;">
	                Ưu tiên
	            </div>
	            <div style="float:left; width: 256px; text-align:left;">
	                <form:input path="priority" maxlength="90" style="width:90%"/>
	            </div>
	        </div>
	        <div style="clear:both; height: 3px;"></div>
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
		document.getElementById('txtFCKContent___Frame').height = clientHeight - 144;
		$("div#footer").css({"top": clientHeight - 19,"left": 0});
	} else if ($.browser.safari) {
		
	} else if ($.browser.opera) {
		$("div#content").css({"height": clientHeight - 44});
		$("input[name=titleMenu]").css({"width": clientWidth - 171});
		$("input[name=title]").css({"width": clientWidth - 171});		
		document.getElementById('txtFCKContent___Frame').width = clientWidth - 24;
		document.getElementById('txtFCKContent___Frame').height = clientHeight - 144;
		$("div#footer").css({"top": clientHeight - 17,"left": 0});
	} else {
		
	}	
</script>
</body>
</html>