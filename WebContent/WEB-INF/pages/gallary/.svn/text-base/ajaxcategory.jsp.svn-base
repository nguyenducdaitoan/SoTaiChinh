<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:choose>
	<c:when test="${ empty listCategoryGallary }">
		Không có dữ liệu
	</c:when>
	<c:otherwise>
		<div class="info_box_cotent">
			<ul id="library_image" class="lib_img">
			<c:forEach var="gallaryItem" items="${listCategoryGallary }">
				<li>
					<a  class="lightbox" rel="lightbox" href='<c:out value="${gallaryItem.path }"/>' title="<c:out value="${gallaryItem.title }"/>"><img src="<c:out value="${gallaryItem.path }"/>"  alt="" /></a>
					<p class="title_img"><c:out value="${gallaryItem.title }"/></p>
				</li>
			</c:forEach>
			</ul>
			<div class="clear"></div>
		</div>
	</c:otherwise>
</c:choose>