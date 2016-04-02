<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="content_post">
	<div class="content_post_detail">
			<h1 class="title_post">
				<c:out value="${cktc.tieuDe }"/><a href="#" onclick="javascript: printDetail(<c:out value="${cktc.cktcId }"/>);"><span class="icon_print">&nbsp;</span></a>
			</h1>
			<div class="post_content">
					<c:out value="${cktc.noiDung}" escapeXml="false"/>
			</div>
			<div class="clear"></div>
	</div>
	<div class="clear"></div>

	<c:choose>
		<c:when test="${empty listCKTCByChuyenMuc }"></c:when>
		<c:otherwise>
		<div class="recent_post">
			<h1 class="title_content title_content_position">Công khai tài chính cùng chuyên mục</h1>
			<div class="info_box_cotent  recent_post">		
				<ul class="ul_top_content_right">
					<c:forEach var="cktcByCm" items="${listCKTCByChuyenMuc }">
						<li>
							<a href="/cktc/detail.html?cktcId=<c:out value="${cktcByCm.cktcId }"/>"> <c:out value="${cktcByCm.tieuDe }"/><span class="date_content">(<fmt:formatDate pattern="dd/MM/yyyy" timeZone="GMT+7" value="${cktcByCm.modified }"/>)</span></a>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>	
		</c:otherwise>
	</c:choose>
	<script type="text/javascript" charset="utf-8">
		function printDetail(id) {
			openwindow('/cktc/printdetail.html?cktcId='+id);	
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
