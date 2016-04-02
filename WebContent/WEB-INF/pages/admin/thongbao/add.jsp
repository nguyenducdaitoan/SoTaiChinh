<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jstl/core' prefix='c'%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="net.fckeditor.FCKeditor"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Thêm mới thông báo</title>
<link rel="stylesheet" type="text/css" media="screen"
	href="/admin/css/style.css" />
<script type="text/javascript" src="/js/jquery-1.7.1.min.js"></script>
<link type="text/css" rel="stylesheet" href="/css/dhtmlgoodies_calendar.css" media="screen"></link>
<script type="text/javascript" src="/js/dhtmlgoodies_calendar.js"></script>	
<script type="text/javascript" charset="utf-8">
	$(document).ready(function() {
		$("img#imgSaveNews").click(function() {
			if ($("input[name='title']").val() == '') {
				alert('Bạn chưa nhập tiêu đề thông báo!');
				$('input[name="title"]').focus();
				$('input[name="title"]').select();
				return false;
			}
			var str = jQuery.trim($("input[name='tuNgay']").val());
			if ((str == null) || (str == '')) {
				alert('Vui lòng nhập vào ngày ra thông báo');
				$('input[name="tuNgay"]').focus();
				$('input[name="tuNgay"]').select();
				return false;
			} else {
				var dob  = /(0[1-9]|[12][0-9]|3[01])+\/(0[1-9]|1[012])+\/(19|20)\d\d/;
				if (!str.match(dob)) {
					alert('Định dạng ngày tháng là DD/MM/YYYY');
					$('input[name="tuNgay"]').focus();
					$('input[name="tuNgay"]').select();
					return false;
				}
			}
			var str = jQuery.trim($("input[name='denNgay']").val());
			if ((str == null) || (str == '')) {
				alert('Vui lòng nhập vào ngày hết hạn thông báo');
				$('input[name="denNgay"]').focus();
				$('input[name="denNgay"]').select();
				return false;
			} else {
				var dob  = /(0[1-9]|[12][0-9]|3[01])+\/(0[1-9]|1[012])+\/(19|20)\d\d/;
				if (!str.match(dob)) {
					alert('Định dạng ngày tháng là DD/MM/YYYY');
					$('input[name="denNgay"]').focus();
					$('input[name="denNgay"]').select();
					return false;
				}
			}
			$("form[name=normal_form]").submit();
		});
	});
</script>
</head>
<body>
	<form:form name="normal_form" commandName="thongbaoForm" method="POST"
		action="/admin/thongbao/add.html">
		<div id="bodyadmin">
			<div id="header">
				<div
					style="width: 250px; text-align: left; float: left; font-family: Tahoma; font-size: 10pt;">
					<img src="images/data.gif" title="" />&nbsp;Thêm mới thông báo
				</div>
				<div
					style="width: 150px; text-align: right; float: right; padding-right: 5px;"></div>
				<div style="clear: both"></div>
			</div>
			<div id="content"
				style="font-family: Arial; font-size: 10pt; text-align: left">
				<div style="clear: both; height: 15px;"></div>
				<div style="clear: both; height: 3px;"></div>
				<div>
					<div
						style="float: left; width: 140px; text-align: right; padding-right: 8px;">
						<span style="color: red; font-style: italic;">(*)</span> Tiêu đề
					</div>
					<div style="float: left; width: 456px; text-align: left;">
						<form:input path="title" maxlength="90" style="width:90%" />
					</div>
				</div>
				<div style="clear: both"></div>
				<div>
					<div
						style="float: left; width: 140px; text-align: right; padding-right: 8px;">
						Kích hoạt</div>
					<div style="float: left; width: 456px; text-align: left;">
						<form:checkbox path="active" />
					</div>
				</div>
				<div style="clear: both"></div>
				<div>
					<div
						style="float: left; width: 140px; text-align: right; padding-right: 3px;">
						<span style="color: red; font-style: italic;">(*)</span> Từ ngày
					</div>
					<div style="float: left; width: 456px; text-align: left;">
						<form:input path="tuNgay" maxlength="12" style="width:20%" />
						<img src="/admin/images/lich.png"
							style="padding-left: 2px; padding-top: 1px; position: absolute; cursor: pointer"
							id="tuNgay" title="Chọn ngày ra thông báo"
							onclick="displayCalendar(document.forms[0].tuNgay,'dd/mm/yyyy',this)" />
					</div>
				</div>
				<div style="clear: both; height: 3px;"></div>
				<div>
					<div
						style="float: left; width: 140px; text-align: right; padding-right: 3px;">
						<span style="color: red; font-style: italic;">(*)</span> Đến ngày
					</div>
					<div style="float: left; width: 456px; text-align: left;">
						<form:input path="denNgay" maxlength="12" style="width:20%" />
						<img src="/admin/images/lich.png"
							style="padding-left: 2px; padding-top: 1px; position: absolute; cursor: pointer"
							id="denNgay" title="Chọn ngày hết hạn thông báo"
							onclick="displayCalendar(document.forms[0].denNgay,'dd/mm/yyyy',this)" />
					</div>
				</div>
				<div style="clear: both; height: 3px;"></div>
				<div>
					<%
						FCKeditor oFCKeditor;
							oFCKeditor = new FCKeditor(request, "txtFCKContent");
							oFCKeditor.setWidth("100%");
							oFCKeditor.setHeight("350");
							oFCKeditor.setBasePath("/fckeditor/");
							out.println(oFCKeditor.createHtml());
					%>
				</div>
				<div style="clear: both"></div>
			</div>
			<div id="footer">
				<img src="/admin/images/save.png"
					style="margin-left: 10px; cursor: pointer" id="imgSaveNews"
					title="Lưu dữ liệu" /><span
					style="padding-left: 5px; color: red; font-family: Tahoma; font-size: 10pt;"><- Lưu
					dữ liệu</span>
			</div>
		</div>
	</form:form>
	<script type="text/javascript">
		var clientHeight = document.documentElement.clientHeight;
		var clientWidth = document.documentElement.clientWidth;
		if ($.browser.msie) {
			//		if ($.browser.version == '9.0') {
			$("div#content").css({
				"height" : clientHeight - 43
			});
			$("input[name=titleMenu]").css({
				"width" : clientWidth - 172
			});
			$("input[name=title]").css({
				"width" : clientWidth - 172
			});
			document.getElementById('txtFCKContent___Frame').width = clientWidth - 23;
			document.getElementById('txtFCKContent___Frame').height = clientHeight - 144;
			$("div#footer").css({
				"top" : clientHeight - 18,
				"left" : 0
			});
			//		} else {
			//			$("div#content").css({"height": clientHeight - 43});
			//			$("input[name=titleMenu]").css({"width": clientWidth - 154});
			//			$("input[name=title]").css({"width": clientWidth - 154});
			//			document.getElementById('txtFCKContent___Frame').width = clientWidth - 5;
			//			document.getElementById('txtFCKContent___Frame').height = clientHeight - 144;
			//			$("div#footer").css({"top": clientHeight - 18,"left": 0});
			//		}
		} else if ($.browser.mozilla) {
			$("div#content").css({
				"height" : clientHeight - 44
			});
			$("input[name=titleMenu]").css({
				"width" : clientWidth - 171
			});
			$("input[name=title]").css({
				"width" : clientWidth - 171
			});
			document.getElementById('txtFCKContent___Frame').width = clientWidth - 24;
			document.getElementById('txtFCKContent___Frame').height = clientHeight - 144;
			$("div#footer").css({
				"top" : clientHeight - 19,
				"left" : 0
			});
		} else if ($.browser.safari) {

		} else if ($.browser.opera) {
			$("div#content").css({
				"height" : clientHeight - 44
			});
			$("input[name=titleMenu]").css({
				"width" : clientWidth - 171
			});
			$("input[name=title]").css({
				"width" : clientWidth - 171
			});
			document.getElementById('txtFCKContent___Frame').width = clientWidth - 24;
			document.getElementById('txtFCKContent___Frame').height = clientHeight - 144;
			$("div#footer").css({
				"top" : clientHeight - 17,
				"left" : 0
			});
		} else {

		}
	</script>
</body>
</html>