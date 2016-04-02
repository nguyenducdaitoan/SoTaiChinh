<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:choose>
	<c:when test="${ empty tintucByChuyenMuc }">

	</c:when>
	<c:otherwise>
<% 
	Calendar calendar = Calendar.getInstance();
	calendar.add(Calendar.DAY_OF_MONTH, -7);
%>
		<c:forEach var="tinTuc" items="${tintucByChuyenMuc }">
			<div class="box_content_post tintuc_content_post">
					<h1>
						<a href="/newsdetail.do?tinTucId=<c:out value="${tinTuc.tinTucId}"  />"><c:out value="${tinTuc.title}"  /></a>
						<%
						Date ngayPostTin = new Date();
						%>					
						<% if (ngayPostTin.after(calendar.getTime())) { %><img src="/images/icon_new.gif" class="new_icon_title"><% } %>
						
					</h1>
					<p class="meta_data_content">
						<c:if test="${tinTuc.getPathImage() != null }">
							<img alt="<c:out value="${tinTuc.title}" />" src="<c:out value="${tinTuc.pathImage }" />" class="img_meta_data_content">
						</c:if>						
						<c:out value="${tinTuc.summary}" />
					</p>
				</div>	
		</c:forEach>
		<div class="clear"></div>
	</c:otherwise>
</c:choose>