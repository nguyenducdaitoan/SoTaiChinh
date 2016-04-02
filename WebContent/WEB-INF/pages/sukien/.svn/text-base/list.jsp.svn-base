<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="box_content have_title">
	<h1 class="title_content title_content_position_sidebar">
		<a href="#">
			<span class="title_span_left"></span>
			<span class="title_span_center">Sự kiện  </span>
			<span class="title_span_right"></span>
		</a>
	</h1>
	<c:choose>
		<c:when test="${empty listRecentsukien } ">
			<ul class="ul_content_right_sidebar">
				<li style="padding-bottom: 14px;">
					Chưa có thông tin sự kiện
				</li>
			</ul>
		</c:when>
		<c:otherwise>
			<ul class="ul_content_right_sidebar">
				<c:forEach var="recentSuKien" items="${listRecentsukien }">
					<li class="giattCatalog_arrow have_imge_catolog">
						<c:if test="${recentSuKien.pathImage  != null }">
							<img class="img_catalog" style="marign:0 auto;padding: 0px 0px;" src="<c:out value="${recentSuKien.pathImage }"/>" />
						</c:if>		
						<a href="/sukien/category.html?suKienId=<c:out value="${recentSuKien.suKienId }"/>">
							<c:out value="${recentSuKien.name }"/>
						</a>
					</li>	
				</c:forEach>				
			</ul>
			<style type="text/css">
				ul.ul_content_right_sidebar{
				
				}
				
				li.giattCatalog_arrow {
				    background: url("/images/arrow_menu.gif") no-repeat scroll 0 7px transparent;
				    padding-left: 15px !important;
				}
				li.have_imge_catolog{
					background: none!important;
				    padding-left: 0px !important;
				    height:60px !important;
				}
				li.have_imge_catolog img.img_catalog {
				    border: 1px solid #D5D5D5;
				    clear: both;
				    display: block;
				    float: left;
				    height: 60px;
				    margin: 0 5px 0 0;
				    width: 80px;
				}
				li.giattCatalog_arrow a {
				    overflow: hidden;
				    display:block;
				}
			</style>
		</c:otherwise>
	</c:choose>	
</div>