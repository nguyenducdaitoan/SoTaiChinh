<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="net.fckeditor.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome Home Page</title>
</head>
<body>


<div class="box_content content_top have_title">
	<div id="featured" style="border: none !important;">
		<h1 class="tin_noi_bat"><span>Tin nổi bật</span></h1>
		<ul class="ui-tabs-nav">
<%
int intSTT = 0;
%>
			<c:forEach var="topTinTuc" items="${listTopPostAllChuyenMuc }">		
<%
 intSTT++;
%>							 
			 	<li id="nav-fragment-<%=intSTT %>" class="ui-tabs-nav-item">
			 		<a href="#fragment-<%=intSTT %>" onclick="window.location.href='/tintuc/detail.html?tinTucId=<c:out value="${topTinTuc.tinTucId }" />'">
			 		<span style="font-size: 13px !important;font-family: Arial"><c:out value="${topTinTuc.title }" /></span>
			 	</a></li>
	
				</c:forEach>
			
		</ul>
<%
intSTT = 0;
%>
			<c:forEach var="topTinTuc1" items="${listTopPostAllChuyenMuc }">	
<%
 intSTT++;
%>			
				<div class="ui-tabs-panel" id="fragment-<%=intSTT %>" style="padding-top: 0px">
					<a class="readone" href="/tintuc/detail.html?tinTucId=<c:out value="${topTinTuc1.tinTucId }" />">
					<img alt="<c:out value="${topTinTuc1.title }" />" src="<c:out value="${topTinTuc1.pathImage }" />">
					<div class="info"></div>
					<p style="text-align: justify; font-family: Arial"><c:out value="${topTinTuc1.summary }" />....</p>
					</a>
				</div>
			</c:forEach>

	</div>
	<script type="text/javascript">
		jQuery(document).ready(function(){
			jQuery("#featured > ul").tabs({
				fx: {opacity: "toggle"}
						, event: "mouseover"
					}).tabs("rotate", 10000, true);
		});
	</script>
	<div class="clear"></div>
</div>



<div class="box_content content_top have_title">
	<div class="hotrotructuyen">
 		<a href="/question.do"><img src="images/hoi-dap.png"/></a>
		<a href="/tracuu.do"><img src="images/tra-cuu-dvc.png"/></a>
		<a href="/vanbanhanhchinh.do"><img src="images/vb-huong-dan.png"/></a>
		<a href="/vanbanphapquy.do" style="padding-right: 0px !important;"><img src="images/vbpq.png"/></a>

	</div>
</div>


<c:choose>
	<c:when test="${empty listTopPostAllChuyenMuc}">
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
	//short chuyenMucId = 0; 
    //int i = 1;
	Calendar calendar = Calendar.getInstance();
	calendar.add(Calendar.DAY_OF_MONTH, -7);
%>
<!-- begin repeat news -->
		<c:set var="chuyenMucId" value="0" />
		<c:set var="i" value="1" />
		<c:forEach var="tinTuc" items="${listTopPostAllChuyenMuc }">
			<c:set var="lastChuyenMucId" value="${tinTuc.tblChuyenMuc.chuyenMucId}" />
			<c:if test="${(chuyenMucId == 0) || ((chuyenMucId != 0) && (chuyenMucId != lastChuyenMucId))}" >
				<c:if test="${(chuyenMucId != 0) && (chuyenMucId != lastChuyenMucId)}" >
					<c:set var="i" value="1" />
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
				</h1>
				<div class="info_box_cotent" style="width: 100% !important">
			</c:if>
			<c:if test="${i == 1}">
				<div class="box_content_post box_content_post_index">
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
				<div class="box_content_post box_content_post_index">
					
			</c:if>
			<c:if test="${i != 1}">
				<h1 class="content_title_right" style="text-align: justify;"><a style="font-weight: normal;" href="/tintuc/detail.html?tinTucId=<c:out value="${tinTuc.tinTucId }" />"><c:out value="${tinTuc.title }" /></a><span class="date_content">(<fmt:formatDate pattern="dd/MM/yyyy" timeZone="GMT+7" value="${tinTuc.modified}" />)</span>
				<%
				Date ngayPostTin1 = new Date();
				%>
				<% if (ngayPostTin1.after(calendar.getTime())) { %><img src="/images/icon_new.gif" class="new_icon_title"><% } %>
				</h1>
			</c:if>
			<c:set var="i" value="${i+1}" />
		<c:set var="chuyenMucId" value="${lastChuyenMucId }" />
		</c:forEach>
		</div>
		<div class="clear"></div>
	</div>
</div>
<div class="clear"></div>
<!-- end repeat news -->
</c:otherwise>
</c:choose>

<c:choose>
	<c:when test="${empty listLegalDocuments }"></c:when>
	<c:otherwise>
		<div class="box_content have_title">
			<h1 class="title_content title_content_position">
				<a href="#lienhe">
					<span class="title_span_left"></span>
					<span class="title_span_center">Văn bản mới ban hành</span>
					<span class="title_span_right"></span>
				</a>
			</h1>
			<div class="info_box_cotent">
				<table id="hor-minimalist-b" class="tabel_content" cellspacing="1" style="width:100%; padding-top: 0px; margin-top: 0px">
					<thead>
						<tr>
					    	<th class="th_center" width="10px" style="font-family: Arial; font-size: 12px; font-weight: bold; color: #393939">#</th>
					    	<th  width="130px" style="font-family: Arial; font-size: 12px; font-weight: bold; color: #393939">Số/Ký hiệu</th>	                        	              
					        <th style="font-family: Arial; font-size: 12px; font-weight: bold; color: #393939">Trích yếu</th> 
					        <th width="60px" align="center" style="font-family: Arial; font-size: 12px; font-weight: bold; color: #393939">Ngày<br />ban hành</th>
					        <th width="60px" align="center" style="font-family: Arial; font-size: 12px; font-weight: bold; color: #393939">Ngày<br />hiệu lực</th>
					    </tr>                    
					</thead>
					<tbody style="text-align:left;">
<% 
int strSTT = 0;
%>
						<c:forEach var="legalDocument" items="${ listLegalDocuments}">
<% 
strSTT ++ ;
%>						
							<tr>				
								<td align="right"><%=strSTT %></td>
								<td><c:out value="${legalDocument.soHieuVb }"/></td>    						
								<td align="justify"><a href="/vanban/downloadvbpq.html?id=<c:out value="${legalDocument.legalDocumentsId }"/>"><div style="width: 100%; text-align: justify;"><c:out value="${legalDocument.tenVb }"/></div></a></td>
								<td>
									<fmt:formatDate pattern="dd/MM/yyyy" timeZone="GMT+7" value="${legalDocument.ngayBh }"/>
								</td>
								<td>
									<fmt:formatDate pattern="dd/MM/yyyy" timeZone="GMT+7" value="${legalDocument.ngayHieuLuc }"/>
								</td>
							</tr>
						</c:forEach>
					</tbody>
					<tfoot>
					    <tr style="display:none;">
					        <td colspan="5">
					            No rows match the filter...
					        </td>
					    </tr>	    
					</tfoot>
				</table>
			</div>
		</div>
	</c:otherwise>
</c:choose>

<c:choose>
	<c:when test="${empty listVbhc }"></c:when>
	<c:otherwise>
		<div class="box_content have_title">
			<h1 class="title_content title_content_position">
				<a href="#lienhe">
					<span class="title_span_left"></span>
					<span class="title_span_center">Văn bản Hành chính</span>
					<span class="title_span_right"></span>
				</a>
			</h1>
			<div class="info_box_cotent">
				<table id="hor-minimalist-b" class="tabel_content" cellspacing="1" style="width:100%; padding-top: 0px; margin-top: 0px">
					<thead>
						<tr>
					    	<th class="th_center" width="10px" style="font-family: Arial; font-size: 12px; font-weight: bold; color: #393939">#</th>
					    	<th  width="130px" style="font-family: Arial; font-size: 12px; font-weight: bold; color: #393939">Số/Ký hiệu</th>	                        	              
					        <th style="font-family: Arial; font-size: 12px; font-weight: bold; color: #393939">Trích yếu</th> 
					        <th width="60px" align="center" style="font-family: Arial; font-size: 12px; font-weight: bold; color: #393939">Ngày<br />ban hành</th>
					        <th width="60px" align="center" style="font-family: Arial; font-size: 12px; font-weight: bold; color: #393939">Ngày<br />hiệu lực</th>
					    </tr>                    
					</thead>
					<tbody style="text-align:left;">
<% 
int strSTT = 0;
%>
						<c:forEach var="vbhc" items="${ listVbhc}">
<% 
strSTT ++ ;
%>						
							<tr>				
								<td align="right"><%=strSTT %></td>
								<td><c:out value="${vbhc.soHieuVb }"/></td>    						
								<td align="justify"><a href="/vanban/downloadvbpq.html?id=<c:out value="${vbhc.vbHanhChinhId }"/>"><div style="width: 100%; text-align: justify;"><c:out value="${vbhc.tenVb }"/></div></a></td>
								<td>
									<fmt:formatDate pattern="dd/MM/yyyy" timeZone="GMT+7" value="${vbhc.ngayBh }"/>
								</td>
								<td>
									<fmt:formatDate pattern="dd/MM/yyyy" timeZone="GMT+7" value="${vbhc.ngayHieuLuc }"/>
								</td>
							</tr>
						</c:forEach>
					</tbody>
					<tfoot>
					    <tr style="display:none;">
					        <td colspan="5">
					            No rows match the filter...
					        </td>
					    </tr>	    
					</tfoot>
				</table>
			</div>
		</div>
	</c:otherwise>
</c:choose>
</body>
</html>