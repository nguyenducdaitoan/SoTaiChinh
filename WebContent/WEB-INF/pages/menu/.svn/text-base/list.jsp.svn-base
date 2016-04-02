<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:choose>
	<c:when test="${empty listMenuGioiThieu }"></c:when>
	<c:otherwise>
		<li class="space"></li>
		<li><a href="#gioithieu">Giới thiệu</a>
			<ul>
				<c:forEach var="menuGioiThieu" items="${listMenuGioiThieu }">
					<li><a href="/gioithieu/detail.html?gioiThieuId=<c:out value="${ menuGioiThieu.gioiThieuId}"/>"><c:out value="${ menuGioiThieu.titleMenu}"/></a></li>
				</c:forEach>
			</ul>
		</li>
		<li class="space"></li>
	</c:otherwise>
</c:choose>

<c:choose>
	<c:when test="${empty listMenuChuyenMuc }"></c:when>
	<c:otherwise>
		<li><a href="#tintuc">Tin tức</a>
			<ul>
				<c:forEach var="menuTinTuc" items="${ listMenuChuyenMuc}">
					<li><a href="/tintuc/category.html?catId=<c:out value="${ menuTinTuc.chuyenMucId}"/>"><c:out value="${ menuTinTuc.title}"/></a></li>
				</c:forEach>
			</ul>
		</li>
		<li class="space"></li>		
	</c:otherwise>
</c:choose>

<c:choose>
	<c:when test="${empty listMenuTTHC }"></c:when>
	<c:otherwise>
		<li><a href="#chuyenmuc_tthc">Thủ tục hành chính</a>
			<ul>
				<c:forEach var="menuCmTTHC" items="${ listMenuTTHC}">
					<li><a href="/tthc/category.html?tthcDmId=<c:out value="${ menuCmTTHC.tthcDmId}"/>"><c:out value="${ menuCmTTHC.name}"/></a></li>
				</c:forEach>
			</ul>
		</li>
		<li class="space"></li>		
	</c:otherwise>
</c:choose>

<c:choose>
	<c:when test="${empty listMenuCKTC }"></c:when>
	<c:otherwise>
		<li><a href="#congkhaitaichinh">Công khai tài chính</a>
			<ul>
				<c:forEach var="menuCmCKTT" items="${ listMenuCKTC}">
					<li><a href="/cktc/category.html?cktcCmId=<c:out value="${ menuCmCKTT.cktcCmId}"/>"><c:out value="${ menuCmCKTT.name}"/></a></li>
				</c:forEach>
			</ul>
		</li>
	</c:otherwise>
</c:choose>

<c:choose>
	<c:when test="${empty listMenuBmdtDm }"></c:when>
	<c:otherwise>
		<li><a href="#bmdt">Biểu mẫu</a>
			<ul>
				<c:forEach var="menuBmdtDm" items="${ listMenuBmdtDm}">
					<li><a href="/bmdt/category.html?bmdtDmId=<c:out value="${ menuBmdtDm.bmdtDmId}"/>"><c:out value="${ menuBmdtDm.name}"/></a></li>
				</c:forEach>
			</ul>
		</li>
	</c:otherwise>
</c:choose>