<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="content_post">
	<div class="content_post_detail">
			<h1 class="title_post">
				<c:out value="${tthc.title }"/><a href="#" onclick="javascript: printDetail(<c:out value="${tthc.tthcId }"/>);"><span class="icon_print">&nbsp;</span></a>
			</h1>
			<div class="post_content">
					<c:out value="${tthc.content}" escapeXml="false"/>
			</div>
			<div class="clear"></div>
	</div>
	<div class="clear"></div>

	<c:choose>
		<c:when test="${empty listTthcByChuyenMuc }"></c:when>
		<c:otherwise>
		<div class="recent_post">
			<h1 class="title_content title_content_position">Các thủ tục hành chính cùng chuyên mục</h1>
			<div class="info_box_cotent  recent_post">		
				<ul class="ul_top_content_right">
					<c:forEach var="tthcByCm" items="${listTthcByChuyenMuc }">
						<li>
							<a href="/tthc/detail.html?tthcId=<c:out value="${tthcByCm.tthcId }"/>"> <c:out value="${tthcByCm.title }"/><span class="date_content">(<fmt:formatDate pattern="dd/MM/yyyy" timeZone="GMT+7" value="${tthcByCm.modified }"/>)</span></a>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>	
		</c:otherwise>
	</c:choose>
	<script type="text/javascript" charset="utf-8">
		function printDetail(id) {
			openwindow('/tthc/printdetail.html?tthcId='+id);	
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
</div>
