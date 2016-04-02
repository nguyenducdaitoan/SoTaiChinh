<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:choose>
	<c:when test="${empty listAdvert }">
		<div class="box_content have_title">
			<h1 class="title_content title_content_position">
				<a href="/gallary/category.html">
					<span class="title_span_left"></span>
					<span class="title_span_center">Quảng cáo</span>
					<span class="title_span_right"></span>
				</a> 
			</h1>
			<div class="img_adsversiting adsversiting_have_title">
				<div id="msg_slideshow" class="msg_slideshow">
					Đang cập nhật thông tin
				</div>
			</div>
		</div>
	</c:when>	
	<c:otherwise>
		<div class="box_content have_title">
			<h1 class="title_content title_content_position">
				<a href="/gallary/category.html">
					<span class="title_span_left"></span>
					<span class="title_span_center">Quảng cáo</span>
					<span class="title_span_right"></span>
				</a> 
			</h1>
			<div class="img_adsversiting adsversiting_have_title">
				<ul class="jcarousel-skin-tango" id="mycarouselRight">
					<c:forEach var="advert" items="${listAdvert }">
						<li><a target="_blank" href="<c:out value="${advert.link }"/>"><img alt="" src='<c:out value="${advert.pathImage }"/>' class="ad_right"></a></li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</c:otherwise>
</c:choose>	