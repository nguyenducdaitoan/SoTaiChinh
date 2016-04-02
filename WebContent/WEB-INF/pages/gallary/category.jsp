<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:choose>
	<c:when test="${empty listCategoryGallary}">
		<div class="box_content have_title">
			<h1 class="title_content title_content_position">
				<a href="#tintucTop" style="font-weight: normal ! important;" class="bg_title">
				<span class="title_span_left"></span>
				<span class="title_span_center">
					Thư vnhanj hình ảnh
				</span>
				<span class="title_span_right"></span>
				</a>
			</h1>
			<div style="width: 100% ! important;" class="info_box_cotent">
				<p>Hình ảnh đang cập nhật</p>
	        </div>
			<div class="clear"></div>
		</div>
	</c:when>
	<c:otherwise>
		<div class="box_content have_title">
			<h1 class="title_content title_content_position"><a href="/librarygallary.do">
				<span class="title_span_left"></span>
				<span class="title_span_center">
					Thư viện hình ảnh
				</span>
				<span class="title_span_right"></span>
			</a>	
			</h1>
			<div id="pagination_content" class="demo">
				<div class="papge_content">
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
				</div>
			</div>
			<div class="clear"></div>
			<div id="paginate_category"> </div>
		</div>
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
							url:   '/gallary/ajaxcategory.html',
							data:  'page=' + page,
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


