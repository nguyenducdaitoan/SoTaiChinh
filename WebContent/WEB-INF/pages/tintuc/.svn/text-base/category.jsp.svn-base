<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:choose>
	<c:when test="${empty tintucByChuyenMuc}">
		<div class="box_content have_title">
			<h1 class="title_content title_content_position">
				<a href="#tintucTop" style="font-weight: normal ! important;" class="bg_title">
				<span class="title_span_left"></span>
				<span class="title_span_center">
					Thông báo
				</span>
				<span class="title_span_right"></span>
				</a>
			</h1>
			<div style="width: 100% ! important;" class="info_box_cotent">
				<p>Tin tức đang cập nhật</p>
	        </div>
			<div class="clear"></div>
		</div>
	</c:when>
<c:otherwise>


<% 
	Calendar calendar = Calendar.getInstance();
	calendar.add(Calendar.DAY_OF_MONTH, -7);
%>
<!-- begin repeat news -->
		<c:set var="chuyenMucId" value="0" />
		<c:set var="i" value="1" />
			<c:forEach var="tinTuc" items="${tintucByChuyenMuc }">
				<c:set var="lastChuyenMucId" value="${tinTuc.tblChuyenMuc.chuyenMucId}" />
				<c:if test="${(chuyenMucId == 0) || ((chuyenMucId != 0) && (chuyenMucId != lastChuyenMucId))}" >
					<c:if test="${(chuyenMucId != 0) && (chuyenMucId != lastChuyenMucId)}" >
						
										</div>
									</div>
								<div class="clear"></div>
							</div>
						</div>
						<div class="clear"></div>
					</c:if>
					
					<div class="box_content have_title">
					<h1 class="title_content title_content_position">
						<a class="bg_title" style="font-weight: normal !important;" href="/tintuc/category.html?catId=<c:out value="${tinTuc.tblChuyenMuc.chuyenMucId}"  />">
							<span class="title_span_left"></span>
							<span class="title_span_center">
								<c:out value="${tinTuc.tblChuyenMuc.title}"  />
							</span>
							<span class="title_span_right"></span>
						</a>
						<a class="more_link" href="/tintuc.category.html?catId=<c:out value="${tinTuc.tblChuyenMuc.chuyenMucId}"  />">Xem thêm...</a>
					</h1>
					<div class="info_box_cotent tintuc_content">
						<div id="pagination_content" class="demo">
							<div class="papge_content">
				</c:if>
					<div class="box_content_post tintuc_content_post">
						<h1><a href="/tintuc/detail.html?tinTucId=<c:out value="${tinTuc.tinTucId }" />"><c:out value="${tinTuc.title}" /></a><span class="date_content">(<fmt:formatDate pattern="dd/MM/yyyy" timeZone="GMT+7" value="${tinTuc.modified}" />)</span>
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
				<c:set var="chuyenMucId" value="${lastChuyenMucId }" />
			</c:forEach>
				<div class="clear"></div>
			</div>
			<div class="clear"></div>
			<div id="paginate_category"> </div>
		</div>
	</div>
</div>
<div class="clear"></div>
<!-- end repeat news -->

<c:if test="${totalPage >1 }">

	<script type="text/javascript">
		$(function() {
			$("#paginate_category").paginate({
				count 		: <c:out value="${totalPage}" />,
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
						url:   '/tintuc/ajaxcategory.html',
						data:  'catId=<c:out value="${chuyenMucId}" />&page=' + page,
						dataType: "html",
						success: function(data) {
							$("div.papge_content").html('');
							$("div.papge_content").html(data);
							$(window).scrollTop(0);
						}
					});
				}
			});
		});
	</script>
</c:if>
<c:if test="${ totalPage <= 1}">

	<style>
		#paginate_category {
		    display: none!important;
		}
	</style>
		
</c:if>
</c:otherwise>
</c:choose>	


