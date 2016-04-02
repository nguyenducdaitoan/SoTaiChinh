<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
	$(document).ready(function() {
		$("#btndelete").click(function() {
			var list_activities_id = "";
			$("td > .selectAllItems > input:checkbox").each(function() { 
				if (this.checked) {
					if (list_activities_id == "") {
						list_activities_id = this.id.substr(12);
					} else {
						var activities_id = this.id.substr(12);
						list_activities_id = list_activities_id + "," + activities_id;
					}
				}
			}); 
			if (list_activities_id == "") {
				alert('Hãy chọn một giới thiệu để xóa');
			} else {
				ok = confirm('Bạn chắc chắn muốn xóa?');
				if (ok) {
					$.ajax({
						cache: false,
						type: 'POST',
						url:   '/admin/tintuc/delete.html',
						cache: false,						
						data:  'tinTucId=' + list_activities_id,
						dataType: "html",
						success: function(data) {
							var getData = $.parseJSON(data);
							console.log(getData);
							if ((getData.error != null) && (getData.error != '')) {
								alert(getData.error);
							} else {
								alert('Xóa bỏ thành công');
								var url = '/admin/tintuc/list.html?page=&query=&approved=&tungay=&denngay=&chuyenmucid=';
								window.location.href = url;
							}
						},
						error: function(e, xhr) {
							alert(e);
						}
					});
				}
			}
	    });
		$("#btnSelectAll").click(function() {
			$("td > .selectAllItems > input:checkbox").each(function() { 
				this.checked = true; 
			}); 
	    });	
		
		$("#btnUnSelectAll").click(function() {
			$("td > .selectAllItems > input:checkbox").each(function() { 
				this.checked = false; 
			}); 
	    });	
		
		$("#btnDisSelect").click(function() {
			$("td > .selectAllItems > input:checkbox").each(function() { 
				this.checked = !this.checked;
			}); 
	    });	

		$(".deleteIterm").click(function() {
			ok = confirm('Bạn chắc chắn muốn xóa?');
			if (ok)	{
				var tinTucId = this.id.substr(10);
				$.ajax({
					cache: false,
					type: 'POST',
					url:   '/admin/tintuc/delete.html',
					cache: false,
					data:  'tinTucId=' + tinTucId,
					dataType: "html",
					success: function(data) {
						var getData = $.parseJSON(data);
						if ((getData.error != null) && (getData.error != '')) {
							alert(getData.error);
						} else {
							alert('Xóa bỏ thành công');
							var url = '/admin/tintuc/list.html';
							window.location.href = url;
						}
					},
					error: function(e, xhr) {
						alert(e);
					}
				});
			}
	    });
		$(".approvedIterm").click(function() {
			ok = confirm('Bạn chắc chắn muốn phê duyệt?');
			if (ok)	{
				var tinTucId = this.id.substr(10);
				$.ajax({
					cache: false,
					type: 'POST',
					url:   '/admin/tintuc/approved.html',
					cache: false,
					data:  'tinTucId=' + tinTucId,
					dataType: "html",
					success: function(data) {
						var getData = $.parseJSON(data);
						if ((getData.error != null) && (getData.error != '')) {
							alert(getData.error);
						} else {
							alert('Phê duyệt tin tức thành công');
							var url = '/admin/tintuc/list.html';
							window.location.href = url;
						}
					},
					error: function(e, xhr) {
						alert(e);
					}
				});
			}
	    });
		$("#btnapproved").click(function() {
			alert('11111111111111111111111111111');
			var list_activities_id = "";
			$("td > .selectAllItems > input:checkbox").each(function() { 
				if (this.checked) {
					if (list_activities_id == "") {
						list_activities_id = this.id.substr(12);
					} else {
						var activities_id = this.id.substr(12);
						list_activities_id = list_activities_id + "," + activities_id;
					}
				}
			}); 
			if (list_activities_id == "") {
				alert('Hãy chọn một tin tức để phê duyệt');
			} else {
				ok = confirm('Bạn chắc chắn muốn phê duyệt tin tức?');
				if (ok) {
					$.ajax({
						cache: false,
						type: 'POST',
						url:   '/admin/tintuc/approved.html',
						cache: false,						
						data:  'tinTucId=' + list_activities_id,
						dataType: "html",
						success: function(data) {
							var getData = $.parseJSON(data);
							console.log(getData);
							if ((getData.error != null) && (getData.error != '')) {
								alert(getData.error);
							} else {
								alert('Phê duyệt tin thành công');
								var url = '/admin/tintuc/list.html';
								window.location.href = url;
							}
						},
						error: function(e, xhr) {
							alert(e);
						}
					});
				}
			}
	    });
		
		$(".unApprovedIterm").click(function() {
			ok = confirm('Bạn chắc chắn muốn hủy phê duyệt?');
			if (ok)	{
				var tinTucId = this.id.substr(10);
				$.ajax({
					cache: false,
					type: 'POST',
					url:   '/admin/tintuc/unapproved.html',
					cache: false,
					data:  'tinTucId=' + tinTucId,
					dataType: "html",
					success: function(data) {
						var getData = $.parseJSON(data);
						if ((getData.error != null) && (getData.error != '')) {
							alert(getData.error);
						} else {
							alert('Hủy phê duyệt tin tức thành công');
							var url = '/admin/tintuc/list.html';
							window.location.href = url;
						}
					},
					error: function(e, xhr) {
						alert(e);
					}
				});
			}
	    });
	    $("table#tableOne").tablesorter({ 
	        headers: {
	        	5: {sorter: false} 
	        } 
	    }); 
	    $("select[name='page']").change(function(){
	    	//alert($("select[name='page']").val().trim());
			window.location.href = "/admin/tintuc/list.html?page=" + $("select[name='page']").val();
		});
	    $("input:button[name='search']").click(function() {
	    	//alert('search click');
	    	var pageId = $("#pageId").val();
			var approved = $("select#cboApprovedId").val();
			var cboChuyenMuc = $('#chuyenMucId').val().trim();
			//var cboChuyenMuc = $("select#chuyenMucid").val();
			var query = $("input:text[name='query']").val();
			var tungay = $("input:text[name='tungay']").val();
			var denngay = $("input:text[name='denngay']").val();
			var url = '?query='+query+'&approved='+approved+'&tungay='+tungay+'&denngay='+denngay+'&chuyenmucid='+cboChuyenMuc;
			//alert(cboChuyenMuc);
			//alert(approved);
			window.location.href = url;
		});
	    $("input:text[name='query']").bind('keypress', function(e) {
	        if(e.keyCode==13){
	        	$("input:button[name='search']").click();
	        }
		});
	    
	    $("#fsSearchId > legend").click(function(){
	    	$(this).siblings().slideToggle("slow");
        });
	    $("#fsSearchId > legend").click();
	    function textNoteWordRepeat() {
		    var textNoteId = $('span#textNoteId');
		    textNoteId.hide().contents().each(function() {
		        var words;
		        if (this.nodeType === 3) {
		            words = '<span> ' + this.data.split(/\s+/).join(' </span><span> ') + ' </span>';
		            $(this).replaceWith(words);
		        } else if (this.nodeType === 1) {
		            this.innerHTML = '<span> ' + this.innerHTML.split(/\s+/).join(' </span><span> ') + ' </span>';
		        }
		    });

		    textNoteId.find('span').hide().each(function() {
		        if( !$.trim(this.innerHTML) ) {
		            $(this).remove();
		        }
		    });

		    textNoteId.show().find('span').each(function(i) {
		        $(this).delay(400 * i).fadeIn(600);
		    });
		}
		textNoteWordRepeat();
	});
	
</script>
</head>
<body>
	<div id="bodyadmin">
    	<div id="header">
            <div style="width: 250px; text-align:left; float:left; font-family: Tahoma; font-size:10pt;">
                <img src="/admin/images/data.gif" title="" />
				<div style="position:absolute; top:4px; left:14px;">&nbsp;Danh mục tin tức</div>				
            </div>
            <div style="width: 430px; text-align:right; float:right; padding-right: 18px;">
            	<span id="textNoteId" style="color: red; font-size: 12px;">Hãy cẩn thận khi sử dụng chức năng này &raquo;&raquo;&raquo;</span>
            	<img id="btndelete" src="/admin/images/delete.gif" title="Xóa tất cả các tin tức được chọn" style="cursor: pointer; position: relative; top: -2px; padding-right: 5px;" />
            	<img id="btnapproved" src="/admin/images/approved.png" title="Phê duyệt tất cả được chọn" style="cursor: pointer; position: relative; top: -2px; padding-right: 5px;" />
            	<img id="btnSelectAll" src="/admin/images/checkall.gif" title="Select All" />&nbsp;
	            <img id="btnUnSelectAll" src="/admin/images/uncheckall.gif" title="Deselect All" />&nbsp;
	            <img id="btnDisSelect" src="/admin/images/checkdis.gif" title="Swich select" />
            </div>
            <div style="clear:both"></div>
        </div>
      
        <div id="content" style="padding-left: 0px; margin-right: 0px; vertical-align: top;">
        <div id="search-content" style="width: 96%; text-align: left; font-family: Arial; font-size: 10pt; padding: 0px;">
        	<fieldset style="width: 100%;" id="fsSearchId">
        		<legend style="font-weight: bold; margin-left: 30px; cursor: pointer;" title="Click để hiện/ẩn tìm kiếm">Tìm kiếm</legend>
        		<div style="float: left; width: 120px; text-align: right; padding-right: 3px; padding-top: 3px;">Chuyên Mục:</div>
        		<div style="float: left; width: 320px">
        		<form:form commandName="chuyenMucForm">
        			<form:select path="chuyenMucId" id="chuyenMucId" name="chuyenMucid" style="background-color: #EDF8D6; border: 1px solid gray; font-family: Arial; width: 313px" class="SelectBox">
			         <form:option value="-1" label="------- Chọn một chuyên mục --------"/>
				        <c:forEach items="${listDanhMuc}" var="danhmuc">       
				         <form:option value="${danhmuc.chuyenMucId}" label="${danhmuc.title}"/>
				        </c:forEach>         
			       	</form:select> 
			    </form:form>
        		</div>
        		<div style="clear: both; height: 2px;"></div>
        		<div style="float: left; width: 120px; text-align: right; padding-right: 3px; padding-top: 3px;">Trang thái:</div>
        		<div style="float: left; width: 320px">
	                <select id="cboApprovedId" name="cboApproved" onchange="load_approved(this.value);" style="border: 1px solid gray; font-family: Arial; width: 150px">
					       <option value="-1">---Tất cả trạng thái---</option>
					       <option value="0">Chưa phê duyệt</option>
					       <option value="1">Đã phê duyệt</option>							
					</select>
        		</div>
        		<div style="clear: both; height: 2px;"></div>
        		<div>
		            <div style="float:left; padding-top: 1px; width: 120px; text-align:right; padding-right:3px; padding-top: 3px;">Từ ngày&nbsp;:</div>
		            <div style="float:left; width: 116px; text-align:left;">
		           		<input type="text" style="width: 84px;" maxlength="10" class="textbox" name="tungay" id="txtTuNgayId" value='' />
		           		<img src="/images/lich.png" style="padding-left: 0px; padding-top: 0px; position: relative; top: +2px; cursor:pointer" title="Chọn ngày từ ngày" onclick="displayCalendar(document.getElementById('txtTuNgayId'),'dd/mm/yyyy',this)" /> 
		            </div>
		            <div style="float:left; padding-top: 1px; width: 84px; text-align:right; padding-right:3px; padding-top: 3px;">Đến ngày&nbsp;:</div>
		            <div style="float:left; width: 456px; text-align:left;">
		           		<input type="text" style="width: 84px;" maxlength="10" class="textbox" name="denngay" id="txtDenNgayId" value="" />
		           		<img src="/images/lich.png" style="padding-left: 0px; padding-top: 0px; position: relative; top: +2px; cursor:pointer" title="Chọn ngày đến ngày" onclick="displayCalendar(document.getElementById('txtDenNgayId'),'dd/mm/yyyy',this)" /> 
		            </div>
		        </div>
		        <div style="clear: both; height: 2px;"></div>
		        <div style="float: left; width: 120px; text-align: right; padding-right: 3px; padding-top: 3px;">Tìm kiếm:</div>
        		<div style="float: left; width: 320px">
        			<input type="text" name="query" value="" style="width: 320px;" class="textbox">
        		</div>
        		<div style="clear:both; height: 12px;"></div>
		        <div style="float:left; text-align: left; padding-left: 123px; width: 74px">
		        	<input type="button" name="search" value="Tìm kiếm" class="button" style="width: 70px;" />
		        </div>
        		<div style="clear: both; height: 2px;"></div>
        	</fieldset>
        </div>
        <div style="clear: both; height: 8px;"></div>
        <center>
        	<table id="tableOne" class="tablesorter" cellspacing="1" style="width:100%; padding-top: 0px; margin-top: 0px">
                <thead>
                    <tr>
                        <th width="30px">#</th>
                        <th>Tên tiêu đề</th>                        
                        <th width="102px">Ngày tạo</th>
                        <th width="102px">Ngày chỉnh</th>
                        <th width="104px">#</th>
                    </tr>
                </thead>
			<c:if test="${not empty listTinTuc}">
                <tbody style="text-align:left;">
				<c:forEach var="tinTuc" items="${listTinTuc}" varStatus="status">
					<tr>				
						<td align="right" style="padding-right: 4px;"><c:out value="${status.count}" /></td>
						<td>
							<c:out value="${tinTuc.title}" />
							<c:choose>
							    <c:when test="${tinTuc.approved > 0 }">
							       <span style="color: red">&nbsp;&lt;Phê duyệt&gt;</span>
							    </c:when>
							    <c:otherwise>
							       <span style="color: red">&nbsp;&lt;Chưa phê duyệt&gt;</span>
							    </c:otherwise>
							</c:choose>							
						</td>
                        <td>
                        	<fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${tinTuc.created}" /></td>
                        <td>
                        	<fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${tinTuc.modified}" /></td>
                        <td>
                        	<span class="selectAllItems"><input id="checkbox-id-<c:out value="${tinTuc.tinTucId}" />" type="checkbox" name="chkdelete" title="Chọn" /></span>
                            <span class="deleteItems"><img src="/admin/images/delete.gif" class="deleteIterm" id="delete-id-<c:out value="${tinTuc.tinTucId}" />" title="Xóa" /></span>
                            <span class="editItems"><a href="/admin/tintuc/edit.html?tinTucId=<c:out value="${tinTuc.tinTucId}" />"><img src="/admin/images/lightning_go.gif" title="Sửa" class="editIterm" style="border: none" /></a></span>
							<span class="deleteItems"><a href="/admin/tintuc/unapproved.html?tinTucId=<c:out value="${tinTuc.tinTucId}" />"><img src="/admin/images/approved_del.png" title="Hủy phê duyệt nhanh" style="cursor: pointer;" /></a></span>
						</td>
                    </tr>
                </c:forEach>
				</tbody>
			</c:if>
<c:if test="${empty listTinTuc}">
	<tbody style="text-align:left;">
		<tr>
			<td colspan="5">Không có dữ liệu</td>			
		</tr>
	</tbody>
</c:if>
                <tfoot>
                    <tr style="display:none;">
                        <td colspan="5">
                            No rows match the filter...
                        </td>
                    </tr>	    
                </tfoot>
            </table>
        </center>
        
        </div>
	    <!-- End Div Content -->    
	    <div id="footer">	
	    	<div>
Tổng cộng <c:out value="${pager.results}" />&nbsp;kết quả&nbsp;/&nbsp;<c:out value="${pager.totalPage}" />&nbsp;Trang&nbsp;
<select name="page" id="pageId">
<c:forEach var="i" begin="1" end="${pager.totalPage}">
	<c:if test="${i==pager.page}">
	<option value="${i}" selected="selected">Trang ${i}</option>
	</c:if>
	<c:if test="${i!=pager.page}">
	<option value="${i}">Trang ${i}</option>
	</c:if>
</c:forEach>
</select>
</div>
		</div>
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