<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="chuyenMucId" value="0"/>
<c:choose>
	<c:when test="${empty listCKTC}">
		<div class="box_content have_title">
				<h1 class="title_content title_content_position">
					<a href="#tthc_thongbao">
						<span class="title_span_left"></span>
						<span class="title_span_center">Thông báo</span>
						<span class="title_span_right"></span>
					</a>
				</h1>
				<div class="info_box_cotent">
					<p>Chưa có dữ liệu</p>
				</div>
			</div>
	</c:when>	
	<c:otherwise>
		<c:forEach var="cktc" items="${ listCKTC}" >
			<c:set var="lastChuyenMucId" value="${cktc.tblCktcCm.cktcCmId }"/>
		<c:if test="${(chuyenMucId == 0) || ((chuyenMucId != 0) && (chuyenMucId != lastChuyenMucId)) }">
			<c:if test="${(chuyenMucId != 0) && (chuyenMucId != lastChuyenMucId) }">
							</div>
						</div>
					<div class="clear"></div>
				</div>
			</div>
			<div class="clear"></div>
			</c:if>
			<div class="box_content have_title">
				<h1 class="title_content title_content_position">
					<a href="cktc/category.html?tthcDmId=<c:out value="${cktc.tblCktcCm.cktcCmId}"/>">
					<span class="title_span_left"></span>
					<span class="title_span_center">
						<c:out value="${cktc.tblCktcCm.name}"/>
					</span>
					<span class="title_span_right"></span>
					</a>
				</h1>
				<div class="info_box_cotent">
					<div id="pagination_content" class="demo">
						<div class="papge_content">
			</c:if>
					<div class="box_content_post box_content_post_tthc">
						<div style="padding: 1px 14px 2px 14px; text-align: left; font-size: 10pt;">
							<a class="linkbmdt" style="background: url('/images/arrow_menu.gif') no-repeat scroll 0 2px transparent; padding-left: 15px" href="/cktc/detail.html?cktcId=<c:out value="${cktc.cktcId}"/>"><c:out value="${cktc.tieuDe}"/></a><span class="date_content">(<fmt:formatDate pattern="dd/MM/yyyy" timeZone="GMT+7" value="${cktc.modified }"/>)</span>
						</div>
					</div>	
			<c:set var="chuyenMucId" value="${lastChuyenMucId }"/>
								</c:forEach>
							<div class="clear"></div>
						</div>
					<div class="clear"></div>
					<div id="paginate_category"> </div>
				</div>
				</div>
			</div>
			<div class="clear"></div>
	
	<c:if test="${totalPage>1}">
	<script type="text/javascript">
		$(function() {
			$("#paginate_category").paginate({
				count 		: <c:out value="${totalPage}"/>,
				start 		: 1,
				display     : 16,
				border					: true,
				border_color			: '#fff',
				text_color  			: '#fff',
				background_color    	: '#3F90DB',	
				border_hover_color		: '#ccc',
				text_hover_color  		: '#000',
				background_hover_color	: '#fff', 
				images					: false,
				mouse					: 'press',
				onChange     			: function(page) {
					$('._current','#pagination_content').removeClass('_current').hide();
	//				$('#p'+page).addClass('_current').show();
					$("div.papge_content").append('<div style="clear: both; margin-top: 10px;"><center><img src="/images/loadingAnimation.gif" /></center></div>');
					$.ajax({
						cache: false, 
						url:   '/cktc/ajaxcategory.html',
						data:  'tthcCmId=<c:out value="${chuyenMucId}"/>&page=' + page,
						dataType: "html",
						success: function(data) {
							$("div.papge_content").html('');
							$("div.papge_content").html(data);
						}
					});
				}
			});
		});
		</script>
	</c:if>
	<c:if test="${(totalPage <= 1) }">
		<style>
			#paginate_category {
			    display: none!important;
			}
		</style>
	</c:if>
	</c:otherwise>
</c:choose>
	