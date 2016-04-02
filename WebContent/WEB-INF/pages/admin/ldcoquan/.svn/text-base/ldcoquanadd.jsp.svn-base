<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="net.fckeditor.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Thêm mới cơ quan</title>
<link rel="stylesheet" type="text/css"  media="screen" href="/admin/css/style.css" />
<script type="text/javascript" src="/js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" charset="utf-8">
	$(document).ready(function() {
		$("img#imgSaveNews").click(function(){
			if ($('input#name').val() == '') {
				alert("Bạn chưa nhập tên cơ quan!");
				$('input#name').focus();
				return false;
			}
			if ($('select#cboCap').val() == '-1') {
				alert("Chọn cấp cơ quan!");
				$('select#cboCap').focus();
				return false;
			}
			$("form[name=LdCoQuanForm]").submit();	
		});
		$("form#ldCoQuanFormId").submit(function() {
			if ($('input#name').val() == '') {
				alert("Bạn chưa nhập tên cơ quan!");
				$('input#name').focus();
				return false;
			}
			if ($('select#cboCap').val() == '') {
				alert("Chọn cấp cơ quan!");
				$('select#cboCap').focus();
				return false;
			}
		});
	});
</script>
</head>
<body>
	<form:form commandName="ldcoquan" name="LdCoQuanForm" id="ldCoQuanFormId" method="POST" action="/admin/ldcoquan/submitadd.html" accept-charset="UTF-8">
	
	<div id="bodyadmin">
	    <div id="header">
	        <div style="width: 250px; text-align:left; float:left; font-family: Tahoma; font-size:10pt;">
	            <img src="/admin/images/data.gif" title="" />&nbsp;Thêm mới cơ quan
	        </div>
	        <div style="width: 150px; text-align:right; float:right; padding-right:5px;"></div>
	        <div style="clear:both"></div>
	    </div>
	    <div id="content" style="font-family:Arial; font-size:10pt; text-align:left">
	    	<div style="clear:both; height:15px;"></div>
	        <div>
	            <div style="float:left; width: 140px; text-align:right; padding-right:8px;">
	                Tên cơ quan
	            </div>
	            <div style="float:left; width: 456px; text-align:left;">
	                <form:input path="name" name="name" maxlength="90" id="name" style="width:90%"/>
	            </div>
	        </div>
	        <div style="clear:both; height: 3px;"></div>
	        <div>
	        	<div style="float:left; width: 140px; text-align:right; padding-right:8px;">
	                Chọn cấp cơ quan
	            </div>
				<div style="float:left; width: 456px; text-align:left;">			
					<form:select path="ldCapId" name="ldCapId" id="cboCap" style="border: 1px solid gray; font-family: Arial;">
						<form:option value="-1" label="-------Chọn cấp cơ quan--------"/>
						<c:forEach items="${listldcap}" var="ldcap">							
							<form:option value="${ldcap.ldCapId}" label="${ldcap.name}"/>
						</c:forEach>
					</form:select>
             	</div>
			</div>
	        <div style="clear:both; height: 3px;"></div>
	        <div>
	            <div style="float:left; width: 140px; text-align:right; padding-right:8px;">
	                Mặc định
	            </div>
	            <div style="float:left; width: 456px; text-align:left;">
	                <form:checkbox path="macDinh" name="macDinh"/>
	            </div>
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
			$("input[name=name]").css({"width": clientWidth - 172});
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
		$("div#footer").css({"top": clientHeight - 19,"left": 0});
	} else if ($.browser.safari) {
		
	} else if ($.browser.opera) {
		$("div#content").css({"height": clientHeight - 44});
		$("input[name=titleMenu]").css({"width": clientWidth - 171});
		$("input[name=title]").css({"width": clientWidth - 171});		
		$("div#footer").css({"top": clientHeight - 17,"left": 0});
	} else {
		
	}	
</script>
</body>
</html>