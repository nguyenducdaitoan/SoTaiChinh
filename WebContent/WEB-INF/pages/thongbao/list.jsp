<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="box_content have_title">
	<h1 class="title_content title_content_position_sidebar">
		<a href="#thongbao">
			<span class="title_span_left"></span>
			<span class="title_span_center">Thông báo</span>
			<span class="title_span_right"></span>
		</a>
	</h1>
		<c:choose>
			<c:when test="${empty listRecentThongBao } ">
				<ul class="ul_content_right_sidebar">
					<li style="padding-bottom: 14px;">
						Chưa có thông báo mới
					</li>
				</ul>
			</c:when>
			<c:otherwise>
				<marquee scrolldelay="90" height="200" onmouseover="this.stop()" onmouseout="this.start()" scrollamount="2" direction="up">
					<ul class="ul_content_right_sidebar">
						<c:forEach var="recentThongBao" items="${listRecentThongBao }">
							<li style="padding-bottom: 14px;">
								<a href="/thongbao/detail.html?thongBaoId=<c:out value="${recentThongBao.thongBaoId }"/>">
									<c:out value="${recentThongBao.title }"/>
								</a>
								<span>(<fmt:formatDate value="${recentThongBao.modified }" pattern="dd/MM/yyyy" timeZone="GMT+7"/>)</span>
							</li>
						</c:forEach>				
					</ul>
				</marquee>
				
			</c:otherwise>
		</c:choose>	
</div>