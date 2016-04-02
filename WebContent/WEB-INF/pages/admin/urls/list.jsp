<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Danh sách tin tức</title>
<link rel="stylesheet" type="text/css"  media="screen" href="/admin/css/style.css" />
<link rel="stylesheet" href="/css/jquery.tablesorter/themes/blue/style.css" type="text/css" id="" media="print, projection, screen" />
<link type="text/css" rel="stylesheet" href="/css/dhtmlgoodies_calendar.css" media="screen"></link>
<script type="text/javascript" src="/js/dhtmlgoodies_calendar.js"></script>
<script type="text/javascript" src="/js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="/js/jquery.tablesorter.js"></script>
<style type="text/css">    
    div.quicksearch {padding-bottom: 10px;}
	img.editIterm {cursor: pointer;}
	img.deleteIterm	{cursor: pointer;}
</style>
<script type="text/javascript">
	var processing = false;
	$(document).ready(function() {
		
	});	
	function moveUp(urlsId, beforeUrlsId) {
		if (!processing) {
			$.ajax({
				cache: false,
				type: 'POST',
				url:   '/admin/urls/moveup.html',
				data:  'urlsId=' + urlsId + '&beforeUrlsId='+beforeUrlsId,
				dataType: "html",
				success: function(data) {
					var getData = $.parseJSON(data);
					if ((getData.error != null) && (getData.error != '')) {
						alert(getData.error);
					} else {
						window.location.href = '/admin/urls/list.html'
					}
				},
				error: function(e, xhr) {
					alert(e);
				}
			});
		}
	}
	function moveDown(urlsId) {
		if (!processing) {
			$.ajax({
				cache: false,
				type: 'POST',
				url:   '/admin/urls/movedown.html',
				data:  'urlsId=' + urlsId,
				dataType: "html",
				success: function(data) {
					var getData = $.parseJSON(data);
					if ((getData.error != null) && (getData.error != '')) {
						alert(getData.error);
					} else {
						window.location.href = '/admin/urls/list.html'
					}
				},
				error: function(e, xhr) {
					alert(e);
				}
			});
		}
	}
</script>
</head>
<body>
	<div id="bodyadmin">
    	<div id="header">
            <div style="width: 250px; text-align:left; float:left; font-family: Tahoma; font-size:10pt;">
                <img src="/admin/images/data.gif" title="" />
				<div style="position:absolute; top:4px; left:14px;">&nbsp;Danh sách các Url hệ thống</div>				
            </div>
            <div style="clear:both"></div>
        </div>
      
        <div id="content" style="padding-left: 0px; margin-right: 0px; vertical-align: top; text-align: left !important; padding-left: 20px; font-size: 10pt; font-family: Arial">
			<c:if test="${not empty listUrls}">
				<c:set var="beforeParentId" value="${null}" />
				<c:set var="beforeUrlsId" value="${null}" />
				<c:forEach var="urls" items="${listUrls}" varStatus="status">					
					<c:choose>
						<c:when test="${urls.parentId == null}">
							<c:set var="beforeParentId" value="${urls.urlsId}" />
							<c:if test="${status.count == 1}" >
								<div style="font-weight: bold; color: red;"><img src="/admin/images/urls-minus4.gif" style="position: relative; top: +4px; padding-right: 3px" /><a href="/admin/urls/edit.html?urlsId=<c:out value="${urls.urlsId}" />" target="urlsContent"><c:out value="${urls.name}" /></a></div>
							</c:if>
							<c:if test="${status.count != 1}" >
								<div style="font-weight: bold; color: red;"><img src="/admin/images/urls-minus3.gif" style="position: relative; top: +4px; padding-right: 3px" /><a href="/admin/urls/edit.html?urlsId=<c:out value="${urls.urlsId}" />" target="urlsContent"><c:out value="${urls.name}" /></a></div>
							</c:if>
						</c:when>
						<c:otherwise>
							<div style="position:relative; top: -3px; font-weight: bold; color: blue; padding-top: 0px; padding-bottom: 0px; font-size: 12px;;">
								<img src="/admin/images/urls-line3.gif" style="position: relative; top: +4px; padding-right: 3px" /><c:out value="${urls.name}" />
								<img class="img-move-down" src="/admin/images/urls-down.gif" style="cursor: pointer;" onclick="javascript: moveDown('<c:out value="${urls.urlsId}" />')" />
								<img class="img-move-up" src="/admin/images/urls-up.gif" style="cursor: pointer;" onclick="javascript: moveUp('<c:out value="${urls.urlsId}" />','<c:out value="${beforeUrlsId}" />')" />
							</div>
							<c:set var="beforeParentId" value="${urls.parentId}" />
						</c:otherwise>
					</c:choose>
					<c:set var="beforeUrlsId" value="${urls.urlsId}" />
                </c:forEach>
			</c:if>
			<c:if test="${empty listUrls}">
				<div style="font-weight: bold; font-family: Arial; font-size: 11px; text-shadow: 1px 1px gray; color: red">Không có dữ liệu</div>
			</c:if>        
        </div>
	    <!-- End Div Content -->    
	    <div id="footer">&nbsp;</div>
	    <!-- End Div footer -->
	</div>
	<script type="text/javascript">
		var clientHeight = document.documentElement.clientHeight;
		var clientWidth = document.documentElement.clientWidth;
		if ($.browser.msie)	//	IE
		{
			clientHeight = clientHeight - 2;
			$("div#content").css({"height": clientHeight - 40});
			$("div#footer").css({"top": clientHeight - 18,"left": 0});
			$("div#search-content").css({"width": clientWidth - 30});
		} else if ($.browser.mozilla) {
			clientHeight = clientHeight - 18;
			$("div#content").css({"height": clientHeight - 26});
			$("div#footer").css({"top": clientHeight - 4,"left": 0});
			$("div#search-content").css({"width": clientWidth - 40});
		} else if ($.browser.safari) {
			clientHeight = clientHeight - 2;
			$("div#content").css({"height": clientHeight - 26});
		} else if ($.browser.opera) {
			clientHeight = clientHeight - 18;
			$("div#content").css({"height": clientHeight - 33});
		} else {
			clientHeight = clientHeight - 18;
			$("div#content").css({"height": clientHeight - 26});
		}
		
		function load_page(page) {			
			var url = '&query=<bean:write name="TinTucForm" property="query"  />&approved=<bean:write name="TinTucForm" property="selectApproved"  />&tungay=<bean:write name="TinTucForm" property="tuNgay"  />&denngay=<bean:write name="TinTucForm" property="denNgay"  />&chuyenmucid=<bean:write name="TinTucForm" property="chuyenMucId"  />';
			window.location.href = '/admin/tintuclist.do?page='+page+url;
		}
/*
		function load_chuyenMucId(id){
			var pageId = $("#pageId").val();
			var approved = $("#cboApproved").val();
			link = '/admin/tintuclist.do?chuyenMucId='+id;
			if(pageId != ''){
				link = link + "&page="+ pageId;
			}
			window.location.href = link +"&approved="+ approved ;
		}
*/
/*		
		function load_approved(id){
			var pageId = $("#pageId").val();
			var cboChuyenMuc = $("#cboChuyenMuc").val();
			link = '/admin/tintuclist.do?chuyenMucId='+cboChuyenMuc + "&page="+pageId+"&approved="+ id;
			window.location.href = link;
		}
*/
	</script>
	<div style="display:none">
	    <form name="frmdelete" method="post" action="">
	        <input type="hidden" name="id" value="" />		
	        <input type="hidden" name="action" value="delete" />
	    </form>
	</div>	
</body>
</html>