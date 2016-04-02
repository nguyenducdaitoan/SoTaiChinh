<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="resultSearch" value="1"/>
<c:choose>
	<c:when test="${empty listTinTuc }"></c:when>
	<c:otherwise>
		<c:set var="result" value="0"/>
		<div class="box_content have_title">
		<h1 class="title_content title_content_position">
			<a href="#search">
				<span class="title_span_left"></span>
				<span class="title_span_center">Kết quả tìm kiếm: Tin tức</span>
				<span class="title_span_right"></span>
			</a>
		</h1>
		<div class="info_box_cotent">
			<div class="demo" id="pagination_content">
				<div class="papge_content">
					<c:forEach var="tinTuc" items="${ listTinTuc}">
						<div class="box_content_post_search">
							<h1><a href="/tintuc/detail.html?tinTucId=<c:out value="${tinTuc.tinTucId }" />"><c:out value="${tinTuc.title }" /></a><span class="date_content">(<fmt:formatDate pattern="dd/MM/yyyy" timeZone="GMT+7" value="${tinTuc.modified }"/>)</span></h1>
							<p class="meta_data_content">
								<c:if test="${ empty(tinTuc.pathImage) || (tinTuc.pathImage != null) }">
									<img alt="<c:out value="${tinTuc.title }" />" src="<c:out value="${tinTuc.pathImage }" />" class="img_meta_data_content">
								</c:if>
								<c:out value="${tinTuc.summary }" />
							</p>
						</div>	
					</c:forEach>
					<div class="clear"></div>
				</div>
			</div>
		</div>
	</div>
	</c:otherwise>
</c:choose>

<!-- Thu tuc hanh chính -->

<c:choose>
	<c:when test="${empty listTTHC }"></c:when>
	<c:otherwise>
		<c:set var="resultSearch" value="0"/>
		<div class="box_content have_title">
		<h1 class="title_content title_content_position">
			<a href="#search">
				<span class="title_span_left"></span>
				<span class="title_span_center">Kết quả tìm kiếm: Thủ tục hành chính</span>
				<span class="title_span_right"></span>
			</a>
		</h1>
		<div class="info_box_cotent">
			<div class="demo" id="pagination_content">
				<div class="papge_content">
					<c:forEach var="thuTucHanhChinh" items="${ listTTHC}">
						<div class="box_content_post box_content_post_tthc">
							<h1><a href="/tthc/detail.html?tthcId=<c:out value="${thuTucHanhChinh.tthcId}"/>"><c:out value="${thuTucHanhChinh.title}"/></a><span class="date_content">(<fmt:formatDate pattern="dd/MM/yyyy" timeZone="GMT+7" value="${thuTucHanhChinh.modified }"/>)</span></h1>
						</div>	
						<div class="clear"></div>
					</c:forEach>
					<div class="clear"></div>
				</div>
			</div>
		</div>
	</div>
	</c:otherwise>
</c:choose>

<!-- listBmdt biểu mẫu điện tử -->
<c:choose>
	<c:when test="${empty listBMDT }"></c:when>
	<c:otherwise>
		<c:set var="resultSearch" value="0"/>
		<div class="box_content have_title">
		<h1 class="title_content title_content_position">
			<a href="#search">
				<span class="title_span_left"></span>
				<span class="title_span_center">Kết quả tìm kiếm: Biểu mẫu điện tử</span>
				<span class="title_span_right"></span>
			</a>
		</h1>
		<div class="info_box_cotent">
			<div class="demo" id="pagination_content">
				<div class="papge_content">
					<c:forEach var="bmdt" items="${ listBMDT}">
						<div class="box_content_post box_content_post_tthc">
							<h1><a href="/bmdt/detail.html?bmdtId=<c:out value="${bmdt.bmdtId}"/>"><c:out value="${bmdt.description}"/></a><span class="date_content">(<fmt:formatDate pattern="dd/MM/yyyy" timeZone="GMT+7" value="${bmdt.modified }"/>)</span></h1>
						</div>	
						<div class="clear"></div>
					</c:forEach>
					<div class="clear"></div>
				</div>
			</div>
		</div>
	</div>
	</c:otherwise>
</c:choose>

<!-- listVbpq Văn bản pháp quy -->

<c:choose>
	<c:when test="${empty listVBPQ }"></c:when>
	<c:otherwise>
		<c:set var="resultSearch" value="0"/>
		<div class="box_content have_title">
		<h1 class="title_content title_content_position">
			<a href="#search">
				<span class="title_span_left"></span>
				<span class="title_span_center">Kết quả tìm kiếm: Văn bản pháp quy</span>
				<span class="title_span_right"></span>
			</a>
		</h1>
		<div class="info_box_cotent">
			<div class="demo" id="pagination_content">
				<div class="papge_content">
					<table id="hor-minimalist-b" class="tabel_content" cellspacing="1" style="width:100%; padding-top: 0px; margin-top: 0px">
		                <thead>
		                	<tr>
		                    	<th class="th_center" width="10px" style="font-family: Arial; font-size: 12px; font-weight: bold;">#</th>
		                    	<th  width="60px" style="font-family: Arial; font-size: 12px; font-weight: bold;">Số/Ký hiệu</th>	                        	              
		                        <th style="font-family: Arial; font-size: 12px; font-weight: bold;">Trích yếu</th> 
		                        <th width="60px" style="font-family: Arial; font-size: 12px; font-weight: bold;">Ngày<br />Ban hành</th>
		                        <th width="60px" align="center" style="font-family: Arial; font-size: 12px; font-weight: bold;">Ngày<br />Hiệu lực</th>
		                    </tr>                    
		                </thead>
		                <tbody style="text-align:left;">
						<%
							int iSTT = 1;
						%>
		                <c:forEach var="vbpq" items="${ listVBPQ}">
							<tr>				
								<td align="right"><%=iSTT++%></td>
									<td><c:out value="${vbpq.soHieuVb }"/></td>    						
								<td align="justify"><a href="/vanban/downloadvbpq.html?id=<c:out value="${vbpq.legalDocumentsId }"/>"><div style="width: 100%; text-align: justify;"><c:out value="${vbpq.tenVb }"/></div></a></td>
								<td>
									<fmt:formatDate pattern="dd/MM/yyyy" timeZone="GMT+7" value="${vbpq.ngayBh }"/>
								</td>
								<td>
									<fmt:formatDate pattern="dd/MM/yyyy" timeZone="GMT+7" value="${vbpq.ngayHieuLuc }"/>
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
					<div class="clear"></div>
				</div>
			</div>
		</div>
	</div>
	</c:otherwise>
</c:choose>

<c:if test="${resultSearch == 1}">
	
<div class="box_content have_title">
		<h1 class="title_content title_content_position">
			<a href="#search">
				<span class="title_span_left"></span>
				<span class="title_span_center"> Kết quả tìm kiếm với từ khóa: <c:out value="${keyword }"/> không có thông tin</span>
				<span class="title_span_right"></span>
			</a>
		</h1>
		<div class="info_box_cotent">
			<div class="demo" id="pagination_content">
				<div class="papge_content">
					<div style="padding:20px;">
						<form:form id="search1"  commandName="search" name="SearchForm" method="POST" cssStyle="position:relative;" action="/searchformaction.html">
							<div><label>Nhập từ khóa cần tìm</label></div>
							<form:input cssStyle="float:left;"  path="query" cssClass="search_name"  value="Nhập từ khóa..."  onblur="if(this.value =='') this.value = 'Nhập từ khóa...'" onfocus="if(this.value == 'Nhập từ khóa...') this.value ='';"/>
							<input cssStyle="float:left;" type="image" src="/images/go.png" name="submit_search" class="submit_search" style="padding: 0px" />
						</form:form>
						<script>
						jQuery(document).ready(function(){
							
							function submit_form1(){
								if((jQuery.trim(jQuery("form#search1 input.search_name").val()) != "Nhập từ khóa...") && (jQuery.trim(jQuery("form#search1 input.search_name").val()) != "")){
									return true;
								} else{
									alert("Nhập từ khóa cần tìm.");
									jQuery("form#search1 input.search_name").focus();
									return false;
								}
							}
							jQuery("form#search1 input.submit_search").click(function(){
								if(submit_form1()){
									return true;
								}
								return false;
							});
							
							$('form#search1 input.search_name').bind('keypress', function(e) {
								if(e.keyCode==13){
									// Enter pressed... do anything here...
									if(submit_form1()){
										return true;
									}
									return false;
								}
							});		
							
						});
					</script>
					</div>
				</div>
			</div>
		</div>
	</div>
</c:if>