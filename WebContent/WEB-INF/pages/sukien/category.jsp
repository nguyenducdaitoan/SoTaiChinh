<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="box_content have_title">
	<h1 class="title_content title_content_position">
		<a href="#giathiturongcatalog">
		<span class="title_span_left"></span>
		<span class="title_span_center">
			<c:out value="${detailSuKien.name }"/>
		</span>
		<span class="title_span_right"></span>
		</a>
	</h1>
	<div class="info_box_cotent">
		<div class="demo" id="pagination_content">
				<div class="papge_content">
					<c:choose>
						<c:when test="${empty listSuKienTinTuc }">
							<div style="padding:10px; color:red;">Chưa có dữ liệu  </div>
						</c:when>
						<c:otherwise>
							<c:forEach var="suKienTinTuc" items="${listSuKienTinTuc }">
								<div class="box_content_post box_content_post_tthc">
									<h1> <a style="background: url('/images/arrow_menu.gif') no-repeat scroll 0pt 2px transparent; padding-left: 15px;" href="/sukien/detail.html?suKienTinTucId=<c:out value="${suKienTinTuc.suKienTinTucId }"/>"><c:out value="${suKienTinTuc.title }"/></a><span class="date_content">(<fmt:formatDate pattern="dd/MM/yyyy" timeZone="GMT+7" value="${suKienTinTuc.modified }"/>)</span></h1>
								</div>	
							</c:forEach>
							<div class="clear"></div>
						</c:otherwise>
					</c:choose>
			</div>
				<div id="paginate_category"> </div>
		</div>
	</div>
	<c:if test="${ suKienId >0}">
		
		<c:if test="${totalPage >1 }">
			<script type="text/javascript">
				$(function() {
					$("#paginate_category").paginate({
						count 		: <c:out value="${totalPage}"/> ,
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
							$("div.papge_content").append('<div style="clear: both; margin-top: 10px;"><center><img src="/images/loadingAnimation.gif" /></center></div>');
							$.ajax({
								cache: false,
								url:   '/sukien/ajaxcategory.html',
								data:  'suKienId=<c:out value="${suKienId}"/>&page=' + page,
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
			<c:if test="${totalPage <= 1}">
				<style>
					#paginate_category {
					    display: none!important;
					}
				</style>
			</c:if>	
		</c:if>	
		<c:if test="${ suKienId <= 0}">
			<style>
				#paginate_category {
				    display: none!important;
				}
			</style>
		</c:if>
</div>