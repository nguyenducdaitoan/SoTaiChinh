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
		<title><c:out value="${gioithieu.title}"/></title>
	</head>
<body>
	<div class="content_post">
		<div class="content_post_detail" id="contentId">
			<h1 class="title_post" style="text-align: justify;">
				<c:out value="${gioithieu.title}"/>
			</h1>
			<div style="padding-top: 1px; text-align: right;">
				<a class="linkprint" href="#" onclick="javascript: printDetail(<c:out value="${gioithieu.gioiThieuId}"/>);"><img src="/images/printer.png" border="0" style="margin-right: 4px;" /><span style="position: relative; top: -4px;">In bài</span></a>			
				<a style="padding-left: 8px;" class="linkprint" href="#" onclick="javascript: sendToEmail(<c:out value="${gioithieu.gioiThieuId}"/>);"><img src="/images/mail.png" border="0" style="margin-right: 4px;" /><span style="position: relative; top: -4px;">Gởi bài</span></a>
			</div>
			<div class="post_content">
				<c:out value="${gioithieu.content}" escapeXml="false"/>
			</div>
			<div class="clear"></div>
		</div>
		<div class="clear"></div>
		<c:choose>
			<c:when test="${ empty listGioiThieu}">
				
			</c:when>
			<c:otherwise>
				<div class="recent_post">
					<h1 class="title_content title_content_position">Thông tin cùng chuyên mục </h1>
						<div class="info_box_cotent  recent_post">		
							<ul class="ul_top_content_right">
								<c:forEach var="recentGioiThieu" items="${listGioiThieu}">
									<li class="giathitruongcatalog"><a href="/gioithieu/detail.html?gioiThieuId=<c:out value="${ recentGioiThieu.gioiThieuId}"/>"><c:out value="${ recentGioiThieu.title}"/></a>	</li>
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
			openwindow('/gioithieu/printdetail.html?gioiThieuId='+id);	
		}
	
		function sendToEmail(id) {
			var url = '/gioithieu/sendtoemail.html?id='+id;
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