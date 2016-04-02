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
		<title><c:out value="${suKienTinTuc.title}"/></title>
	</head>
<body>
	<div class="content_post">
		<div class="content_post_detail" id="contentId">
			<h1 class="title_post" style="text-align: justify;">
				<c:out value="${suKienTinTuc.title}"/>
			</h1>
			<div style="padding-top: 1px; text-align: right;">
				<a class="linkprint" href="#" onclick="javascript: printDetail(<c:out value="${suKienTinTuc.suKienTinTucId}"/>);"><img src="/images/printer.png" border="0" style="margin-right: 4px;" /><span style="position: relative; top: -4px;">In bài</span></a>			
				<a style="padding-left: 8px;" class="linkprint" href="#" onclick="javascript: sendToEmail(<c:out value="${suKienTinTuc.suKienTinTucId}"/>);"><img src="/images/mail.png" border="0" style="margin-right: 4px;" /><span style="position: relative; top: -4px;">Gởi bài</span></a>
			</div>
			<div class="post_content">
				<c:out value="${suKienTinTuc.content}" escapeXml="false"/>
			</div>
			<div class="clear"></div>
		</div>
		<div class="clear"></div>
		<c:choose>
			<c:when test="${ empty listRecentSuKienTinTuc}">
				
			</c:when>
			<c:otherwise>
				<div class="recent_post">
					<h1 class="title_content title_content_position">Sự kiện tin tức cùng chuyên mục </h1>
						<div class="info_box_cotent  recent_post">		
							<ul class="ul_top_content_right">
								<c:forEach var="recentTTSK" items="${listRecentSuKienTinTuc}">
									<li class="giathitruongcatalog"><a href="/sukien/detail.html?suKienTinTucId=<c:out value="${ recentTTSK.suKienTinTucId}"/>"><c:out value="${ recentTTSK.title}"/><span class="date_content">(<fmt:formatDate timeZone="GMT+7" pattern="dd/MM/yyyy" value="${ recentTTSK.modified }"/>)</span></a>	</li>
								</c:forEach>
							</ul>
						</div>
						<div class="clear"></div>
					</div>
			
			</c:otherwise>
		</c:choose>
	</div>
	
	<script type="text/javascript" charset="utf-8">
		function printDetail(id) {
			openwindow('/sukien/printdetail.html?suKienId='+id);	
		}
	
		function sendToEmail(id) {
			var url = '/sukien/sendtoemail.html?id='+id;
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