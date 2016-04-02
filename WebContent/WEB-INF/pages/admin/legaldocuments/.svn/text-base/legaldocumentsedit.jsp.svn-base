<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="net.fckeditor.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sửa văn bản</title>
<style type="text/css">
	body { 
		background-repeat: no-repeat;
		font-family: Trebuchet MS, Lucida Sans Unicode, Arial, sans-serif;
		margin: 0px;
	}

	#ad {
		padding-top: 220px;
		padding-left: 10px;
	}

	img {
		border: 0px;
	}
</style>
<link type="text/css" rel="stylesheet" href="/css/dhtmlgoodies_calendar.css" media="screen"></link>
<script type="text/javascript" src="/js/dhtmlgoodies_calendar.js"></script>	
<link rel="stylesheet" type="text/css"  media="screen" href="/admin/css/style.css" />
<script type="text/javascript" src="/js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" charset="utf-8">
	$(document).ready(function() {
		$('input[name="ngayBh"]').keypress(function (e){  
			if (e.which!=8 && e.which!=0 && e.which!=47 && (e.which<48 || e.which>57)) {
				return false;  
			}
		});
		$('input[name="ngayHieuLuc"]').keypress(function (e){  
			if (e.which!=8 && e.which!=0 && e.which!=47 && (e.which<48 || e.which>57)) {
				return false;  
			}
		});
		
		
		$("img#imgSaveNews").click(function(){			
			if ($("textarea[name='tenVb']").val() == '') {
				alert('Bạn chưa nhập tên văn bản!');
				$('textarea[name="tenVb"]').focus();
				$('textarea[name="tenVb"]').select();
				return false;
			} 
			
			if ($("input[name='soHieuVb']").val() == '') {
				alert('Bạn chưa nhập số hiệu văn bản!');
				$('input[name="soHieuVb"]').focus();
				$('input[name="soHieuVb"]').select();
				return false;
			}
			if ($("input[name='ngaybanhanh']").val() == '') {
				alert('Bạn chưa nhập ngày ban hành!');
				$('input[name="ngaybanhanh"]').focus();
				$('input[name="ngaybanhanh"]').select();
				return false;
			} else {
				var dob  = /(0[1-9]|[12][0-9]|3[01])+\/(0[1-9]|1[012])+\/(19|20)\d\d/;
				if (!$("input[name='ngaybanhanh']").val().match(dob)) {
					alert('Định dạng ngày tháng là DD/MM/YYYY');
					jQuery('input[name="ngaybanhanh"]').focus();
					jQuery('input[name="ngaybanhanh"]').select();
					return false;
				}
			}
			
			if ($("input[name='ngayhieuluc']").val() == '') {
				alert('Bạn chưa nhập ngày van ban co hieu luc!');
				$('input[name="ngayhieuluc"]').focus();
				$('input[name="ngayhieuluc"]').select();
				return false;
			} else {
				var dob  = /(0[1-9]|[12][0-9]|3[01])+\/(0[1-9]|1[012])+\/(19|20)\d\d/;
				if (!$("input[name='ngayhieuluc']").val().match(dob)) {
					alert('Định dạng ngày tháng là DD/MM/YYYY');
					jQuery('input[name="ngayhieuluc"]').focus();
					jQuery('input[name="ngayhieuluc"]').select();
					return false;
				}
			}
			
			if ($("input[name='data']").val() == '') {
				alert('Bạn chưa nhập tên tập tin!');
				$('input[name="data"]').focus();
				$('input[name="data"]').select();
				return false;
			}
			if ($("select[name='ldLoaiVbId']").val() == '-1') {
				alert('Bạn chưa chọn loại văn bản!');
				$('select[name="ldLoaiVbId"]').focus();
				$('select[name="ldLoaiVbId"]').select();
				return false;
			}
			if ($("select[name='ldCoQuanId']").val() == '-1') {
				alert('Bạn chưa chọn cơ quan ban hành!');
				$('select[name="ldCoQuanId"]').focus();
				$('select[name="ldCoQuanId"]').select();
				return false;
			}
			if ($("select[name='ldLinhVucId']").val() == '-1') {
				alert('Bạn chưa chọn lĩnh vực văn bản!');
				$('select[name="ldLinhVucId"]').focus();
				$('select[name="ldLinhVucId"]').select();
				return false;
			}
			$("form[name=LegalDocumentsForm]").submit();
		});
		$("#formLegalDocumentsId").submit(function(){
			if ($("textarea[name='tenVb']").val() == '') {
				alert('Bạn chưa nhập tên văn bản!');
				$('textarea[name="tenVb"]').focus();
				$('textarea[name="tenVb"]').select();
				return false;
			} 
			
			if ($("input[name='soHieuVb']").val() == '') {
				alert('Bạn chưa nhập số hiệu văn bản!');
				$('input[name="soHieuVb"]').focus();
				$('input[name="soHieuVb"]').select();
				return false;
			} 
			

			if ($("input[name='dulieu']").val() == '') {
				alert('Bạn chưa chon tập tin!');
				$('input[name="dulieu"]').focus();
				$('input[name="dulieu"]').select();
				return false;
			}

			if ($("select[name='ldLoaiVbId']").val() == '') {
				alert('Bạn chưa chọn loại văn bản!');
				$('select[name="ldLoaiVbId"]').focus();
				$('select[name="ldLoaiVbId"]').select();
				return false;
			}
			if ($("select[name='ldCoQuanId']").val() == '') {
				alert('Bạn chưa chọn cơ quan ban hành!');
				$('select[name="ldCoQuanId"]').focus();
				$('select[name="ldCoQuanId"]').select();
				return false;
			}
			if ($("select[name='ldLinhVucId']").val() == '') {
				alert('Bạn chưa chọn lĩnh vực văn bản!');
				$('select[name="ldLinhVucId"]').focus();
				$('select[name="ldLinhVucId"]').select();
				return false;
			}
		});
	});
</script>
</head>
<body>
	<form:form commandName="legalDocument" name="LegalDocumentsForm" id="formLegalDocumentsId" method="POST" action="/admin/legaldocuments/submitedit.html" accept-charset="UTF-8" enctype="multipart/form-data">
	<form:hidden path="legalDocumentsId"/>
	<div id="bodyadmin">
	    <div id="header">
	        <div style="width: 250px; text-align:left; float:left; font-family: Tahoma; font-size:10pt;">
	            <img src="/admin/images/data.gif" title="" />&nbsp;Sửa văn bản
	        </div>
	        <div style="width: 150px; text-align:right; float:right; padding-right:5px;"></div>
	        <div style="clear:both"></div>
	    </div>
	    <div id="content" style="font-family:Arial; font-size:10pt; text-align:left">
	    	<div style="clear:both; height:15px;"></div>
	    	
	    	<div>
	        	<div style="float:left; width: 140px; text-align:right; padding-right:8px;">
	                Chọn loại văn bản
	            </div>
				<div style="float:left; width: 360px; text-align:left;">			
	                 <form:select path="ldLoaiVbId" name="ldLoaiVbId" id="ldLoaiVbId" style="background-color: #EDF8D6; border: 1px solid gray; font-family: Arial; width: 313px" class="SelectBox">
				 				<form:option value="-1" label="--- Chọn loại văn bản ---"/>
								<c:forEach items="${listloaivb}" var="ldloaivb">							
									<form:option value="${ldloaivb.ldLoaiVbId}" label="${ldloaivb.name}"/>
								</c:forEach>				 				
					</form:select>
             	</div>
			</div>
	    	<div style="clear:both; height: 3px;"></div>
	    	<div>
	    		<div style="float:left; width: 140px; text-align:right; padding-right:8px;">
	                Chọn lĩnh vực
	            </div>
				<div style="float:left; width: 360px; text-align:left;">			
	                 <form:select path="ldLinhVucId" name="ldLinhVucId" id="ldLinhVucId" style="background-color: #EDF8D6; border: 1px solid gray; font-family: Arial; width: 313px" class="SelectBox">
				 				<form:option value="-1" label="--- Tất cả lĩnh vực ---"/>
								<c:forEach items="${listlinhvuc}" var="ldlinhvuc">							
									<form:option value="${ldlinhvuc.ldLinhVucId}" label="${ldlinhvuc.name}"/>
								</c:forEach>				 				
							</form:select>
             	</div>
			</div>
	    	<div style="clear:both; height: 3px;"></div>
	    	<div>
	    		<div style="float:left; width: 140px; text-align:right; padding-right:8px;">
	                Chọn cơ quan
	            </div>
				<div style="float:left; width: 360px; text-align:left;">			
	                 <form:select path="ldCoQuanId" name="ldCoQuanId" id="ldCoQuanId" style="background-color: #EDF8D6; border: 1px solid gray; font-family: Arial; width: 313px" class="SelectBox">
				 				<form:option value="-1" label="--- Chọn cơ quan ---"/>
								<c:forEach items="${listcoquan}" var="ldcoquan">							
									<form:option value="${ldcoquan.ldCoQuanId}" label="${ldcoquan.name}"/>
								</c:forEach>				 				
					</form:select>
            	</div>
            </div>
			<div style="clear:both; height: 3px;"></div>
	    	<div>
	            <div style="float:left; width: 140px; text-align:right; padding-right:8px;">
	                Số hiệu văn bản
	            </div>
	            <div style="float:left; width: 260px; text-align:left;">
	                <form:input path="soHieuVb" name="soHieuVb" maxlength="128" value="" style="width:244px"/>
	            </div>	            
	        </div>
	    	<div style="clear:both; height: 3px;"></div>
	    	<div>
	            <div style="float:left; width: 140px; text-align:right; padding-right:8px;">
	                Ngày ban hành
	            </div>
	            <div style="float:left; width: 140px; text-align:left;">	                
	                <form:input path="ngaybanhanh" name="ngaybanhanh" maxlength="12" value="" style="width:90px"/>
	                <img src="/images/lich.png" style="padding-left: 2px; padding-top: 1px; position: absolute; cursor:pointer" id="ngayBhId" title="Chọn ngày ban hành" onclick="displayCalendar(document.forms[0].ngaybanhanh,'dd/mm/yyyy',this)" />
	            </div>
	        </div>
	        <div style="clear:both; height: 3px;"></div>	    	
	        <div>
	            <div style="float:left; width: 140px; text-align:right; padding-right:8px;">
	                Trích yếu
	            </div>
	            <div style="float:left; width: 344px; text-align:left;">
	                <form:textarea path="tenVb" name="tenVb" style="width:100%; height: 70px;"/>
	            </div>
	        </div>
	        <div style="clear:both; height: 3px;"></div>	        
	        
	        <div>
	        	<div style="float:left; width: 140px; text-align:right; padding-right:8px;">
	               Ngày hiệu lực
	            </div>
	            <div style="float:left; width: 140px; text-align:left;">
	                <form:input path="ngayhieuluc" name="ngayhieuluc" maxlength="12" value="" style="width:90px"/>
	                <img src="/images/lich.png" style="padding-left: 2px; padding-top: 1px; position: absolute; cursor:pointer" id="ngayHieuLucId" title="Chọn ngày hiệu lực" onclick="displayCalendar(document.forms[0].ngayhieuluc,'dd/mm/yyyy',this)" />
	            </div>
	        </div>
<!-- 
	        <div style="clear:both; height: 3px;"></div>
	        <div>
	    		<div style="float:left; width: 140px; text-align:right; padding-right:8px;">
	               Người ký văn bản
	            </div>
	            <div style="float:left; width: 260px; text-align:left;">
	                <input type="text" name="nguoiKyVb" maxlength="90" value="" style="width:244px">
	            </div>
            </div>
 -->
			<div style="clear:both; height: 3px;"></div>
	        <div>
	            <div style="float:left; width: 140px; text-align:right; padding-right:8px;">
	                Upload văn bản
	            </div>
	            <div style="float:left; width: 456px; text-align:left;">
	                <form:input path="dulieu" type="file" style="width: 300px;"/>	                
	            </div>
	        </div>
	        <div style="clear:both"></div>
	    </div>
		<div id="footer">
	    	<img src="/admin/images/save.png" style="margin-left:10px; cursor:pointer" id="imgSaveNews" title="Lưu dữ liệu" /><span style="padding-left:5px; color:red; font-family:Tahoma; font-size:10pt;">-Lưu dữ liệu</span>
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
		$("textarea[name=tenVb]").css({"width": clientWidth - 171});		
		$("div#footer").css({"top": clientHeight - 20,"left": 0});
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