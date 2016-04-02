<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:forEach var="cktc" items="${listCKTCByChuyenMuc }">
	<div class="box_content_post box_content_post_tthc">
		<h1>
			<a href="/cktc/detail.html?tthcId=<c:out value="${ cktc.cktcId}" />">
				<c:out value="${ cktc.tieuDe}"/>
			</a>
			<span class="date_content">(<fmt:formatDate pattern="dd/MM/yyyy" timeZone="GMT+7" value="${cktc.modified }"/>)</span></h1>
	</div>	
</c:forEach>
<div class="clear"></div>