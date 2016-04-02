<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title><c:out value="${detailThongBao.title}"/></title>	
	</head>
<body>
	<div class="content_post">
		<div class="content_post_detail" id="contentId">
			<h1 class="title_post" style="text-align: justify;">
				<c:out value="${detailThongBao.title}"/>
			</h1>
			<div style="padding-top: 1px; text-align: right;">
				<a class="linkprint" href="#" onclick="javascript: printDetail(<c:out value="${detailThongBao.thongBaoId}"/>);"><img src="/images/printer.png" border="0" style="margin-right: 4px;" /><span style="position: relative; top: -4px;">In bài</span></a>			
				<a style="padding-left: 8px;" class="linkprint" href="#" onclick="javascript: sendToEmail(<c:out value="${detailThongBao.thongBaoId}"/>);"><img src="/images/mail.png" border="0" style="margin-right: 4px;" /><span style="position: relative; top: -4px;">Gởi bài</span></a>
			</div>
			<div class="post_content">
				<c:out value="${detailThongBao.content}" escapeXml="false"/>
			</div>
			<div class="clear"></div>
		</div>
		<div class="clear"></div>
	</div>
	<script type="text/javascript" charset="utf-8">
		function printDetail(id) {
			openwindow('/thongbao/printdetail.html?thongBaoId='+id);	
		}
	
		function sendToEmail(id) {
			var url = '/thongbao/sendtoemail.html?id='+id;
			var options = 'scrollbars=yes,resizable=yes,status=no,toolbar=no,menubar=no,location=no';
			options += ',width=500,height=320';    
			options += ',screenX=0,screenY=0,top=0,left=0';    
			var win = window.open(url, 'PrintDetail', options);    
			win.focus();    
			win.moveTo(0, 0);	
		}
		
		function openwindow(url) {
				var options = 'scrollbars=yes,resizable=yes,status=no,toolbar=no,menubar=no,location=no';
				options += ',width=' + screen.availWidth + ',height=' + screen.availHeight;    
				options += ',screenX=0,screenY=0,top=0,left=0';    
				var win = window.open(url, 'PrintDetail', options);    
				win.focus();    
				win.moveTo(0, 0);
		}
	</script>
</body>
</html>