<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="net.fckeditor.FCKeditor"%>
<%@ page import="vn.softech.form.TthcForm"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Chỉnh sửa thủ tục hành chính</title>
<link rel="stylesheet" type="text/css"  media="screen" href="/admin/css/style.css" />
<script type="text/javascript" src="/js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" charset="utf-8">
	$(document).ready(function() {
		$("img#imgSaveNews").click(function(){
		
			if ($('input[name=title]').val().trim() == '') {
				alert('Chưa nhập tiêu đề');
				$('input[name=title]').focus();
				$('select[name=title]').select();
				return false;
			}
			
			if ($('#tthcDmId').val().trim() == '-1') {
				alert('Chưa chọn chuyên mục');
				$('select#tthcDmId').focus();
				return false;
			}
			
			if ($('input#fileNameId').val().trim() == '') {
				alert('Chưa chọn file');
				$('input#fileNameId').focus();
				return false;
			}
// 			}
			$("form[name=ThuTucHanhChinhForm]").submit();
		});
	});
	
	function doBrowseServer(typeFile, elementId) {
		window
				.open(
						"/browser/ServerBrowser.jsp?FileType=" + typeFile
								+ "&EltID=" + elementId,
						"",
						"height=400px,width=600px,top=50px,left=50px,fullscreen=0,location=0,menubar=0,resizable=0,scrollbars=1,titlebar=0,status=0,toolbar=0",
						true);
	}
</script>
</head>
<body>
	<form:form name="ThuTucHanhChinhForm" commandName="thuTucHanhChinhForm" method="POST" action="/admin/thutuchanhchinh/edit.html">
	<form:hidden path="tthcId" />
	<div id="bodyadmin">
	    <div id="header">
	        <div style="width: 250px; text-align:left; float:left; font-family: Tahoma; font-size:10pt;">
	            <img src="images/data.gif" title="" />&nbsp;Thêm mới thủ tục hành chính
	        </div>
	        <div style="width: 150px; text-align:right; float:right; padding-right:5px;"></div>
	        <div style="clear:both"></div>
	    </div>
	    <div id="content" style="font-family:Arial; font-size:10pt; text-align:left">
	    	<div style="clear:both; height:15px;"></div>
	            <div style="float:left; width: 140px; text-align:right; padding-right:8px;">
	                Chuyên mục
	            </div>
	            <div style="float:left; width: 456px; text-align:left;">
	               <form:select path="tthcDmId" name="tthcDmId" id="tthcDmId" style="background-color: #EDF8D6; border: 1px solid gray; font-family: Arial; width: 313px" class="SelectBox">
			         <form:option value="-1" label="------- Chọn một chuyên mục hành chính --------"/>
				        <c:forEach items="${listDanhMuc}" var="danhmuc">       
				         <form:option value="${danhmuc.tthcDmId}" label="${danhmuc.name}"/>
				        </c:forEach>         
			       	</form:select> 
	            </div>       
	        <div style="clear:both; height: 3px;"></div>
	        <div>
	            <div style="float:left; width: 140px; text-align:right; padding-right:8px;">
	                Tiêu đề
	            </div>
	            <div style="float:left; width: 456px; text-align:left;">
	                <form:input path="title" name="title" maxlength="90" style="width:90%"/>
	            </div>
	        </div>
	        <div style="clear:both; height: 3px;"></div>
	        <div>
	            <div style="float:left; width: 140px; text-align:right; padding-right:8px;">
	                 Chọn file
	            </div>
	            <div style="float:left; width: 456px; text-align:left;">
	            	<form:input path="fileName" maxlength="90"
					 	id="fileNameId" style="width: 357px;" cssClass="textbox"/> 
						<input type="button" id="formbutton" name="btnSelectFile" value="Chọn file"	onclick="doBrowseServer('video', 'fileNameId');">                
	            </div>
	        </div>
	        <div style="clear:both; height: 3px;"></div>
	        <div>
	            <div style="float:left; width: 140px; text-align:right; padding-right:8px;">
	                Hiển thị
	            </div>
	            <div style="float:left; width: 456px; text-align:left;">
	                <form:checkbox path="active"/>
	            </div>
			</div>
	        <div style="clear:both height:3px;"></div>
	        <div style="padding-left: 4px;">
			<div>
			<%
				TthcForm thutuchanhchinh= (TthcForm)request.getAttribute("thuTucHanhChinhForm");
				FCKeditor oFCKeditor;
				oFCKeditor = new FCKeditor(request,"txtFCKContent");
				oFCKeditor.setWidth("100%");
				oFCKeditor.setHeight("350");
				oFCKeditor.setBasePath("/fckeditor/");
				String content= thutuchanhchinh.getContent();
				if (content!=null) {
					oFCKeditor.setValue(content);
				} else oFCKeditor.setValue(""); 
				out.println(oFCKeditor.createHtml());
			%>
	        </div>
	    </div>
		<div id="footer">
	    	<img src="/admin/images/save.png" style="margin-left:10px; cursor:pointer" id="imgSaveNews" title="Lưu dữ liệu" /><span style="padding-left:5px; color:red; font-family:Tahoma; font-size:10pt;">- Lưu dữ liệu</span>
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