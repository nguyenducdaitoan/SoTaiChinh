<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="content_post">
	<div class="content_post_detail">
			<h1 class="title_post">
				Thông tin biểu mẫu<a href="#" onclick="javascript: printDetail(<c:out value="${bmdt.bmdtId }"/>);"><span class="icon_print">&nbsp;</span></a>
			</h1>
			<div class="post_content">
					<c:out value="${bmdt.description}" escapeXml="false"/>
			</div>
			<div class="download" style="padding-top: 4px; padding-left: 0px">Tải biểu mẫu : <a href="/bmdt/downloadbmdt.do?id=<c:out value="${bmdt.bmdtId }"/>">tại đây</a></div>
			<div class="clear"></div>
	</div>
	<div class="clear"></div>

	<c:choose>
		<c:when test="${empty listbmdtByChuyenMuc }"></c:when>
		<c:otherwise>
		<div class="recent_post">
			<h1 class="title_content title_content_position">Biểu mẫu cùng chuyên mục</h1>
			<div class="info_box_cotent  recent_post">		
				<ul class="ul_top_content_right">
					<c:forEach var="bmdtByCm" items="${listbmdtByChuyenMuc }">
						<li>
							<a href="/bmdt/detail.html?bmdtId=<c:out value="${bmdtByCm.bmdtId }"/>"> <c:out value="${bmdtByCm.description }"/><span class="date_content">(<fmt:formatDate pattern="dd/MM/yyyy" timeZone="GMT+7" value="${bmdtByCm.modified }"/>)</span></a>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>	
		</c:otherwise>
	</c:choose>
	<script type="text/javascript" charset="utf-8">
		function printDetail(id) {
			openwindow('/bmdt/printdetail.html?bmdtId='+id);	
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
