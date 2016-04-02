<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Danh sách thủ tục hành chính</title>
<link rel="stylesheet" type="text/css"  media="screen" href="/admin/css/style.css" />
<link rel="stylesheet" href="/css/jquery.tablesorter/themes/blue/style.css" type="text/css" id="" media="print, projection, screen" />
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
				alert('Hãy chọn một tài khoản để xóa');
			} else {
				//alert(list_activities_id);
				ok = confirm('Bạn chắc chắn muốn xóa?');
				if (ok) {
					$.ajax({
						cache: false,
						type: 'POST',
						url:   '/admin/thutuchanhchinh/delete.html',
						data:  'tthcId=' + list_activities_id,
						dataType: "html",
						success: function(data) {
							var getData = $.parseJSON(data);
							if ((getData.error != null) && (getData.error != '')) {
								alert(getData.error);
							} else {
								alert('Xóa bỏ thành công');
								window.location.href = '/admin/thutuchanhchinh/list.html'
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
				var tthcId = this.id.substr(10);
				//alert(tthcId);
				$.ajax({
					cache: false,
					type: 'POST',
					url:   '/admin/thutuchanhchinh/delete.html',
					data:  'tthcId=' + tthcId,
					dataType: "html",
					success: function(data) {
						var getData = $.parseJSON(data);
						if ((getData.error != null) && (getData.error != '')) {
							alert(getData.error);
						} else {
							alert('Xóa bỏ thành công');
							window.location.href = '/admin/thutuchanhchinh/list.html'
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
	            6: {sorter: false} 
	        } 
	    }); 		
	    $("select[name='tthcDmId']").change(function() {
	    	if ($("select[name='tthcDmId']").val() != '') {
		    	window.location.href = "?tthcDmId=" + $("select[name='tthcDmId']").val();
		    }
		});
	});
</script>
</head>
<body>
	<div id="bodyadmin">
	<form:form commandName="danhmuc">
    	<div id="header">
            <div style="width: 250px; text-align:left; float:left; font-family: Tahoma; font-size:10pt;">
                <img src="/admin/images/data.gif" title="" />
				<div style="position:absolute; top:4px; left:14px;">&nbsp;Danh sách thủ tục hành chính</div>				
            </div>
            <div style="width: 480px; text-align:right; float:right;">
            	<div style="position:absolute; top:1px;">
            		<form:select path="tthcDmId" name="tthcDmId" id="tthcDmId" style="background-color: #EDF8D6; border: 1px solid gray; font-family: Arial; width: 313px" class="SelectBox">
			         <form:option value="-1" label="------- Chọn một chuyên mục hành chính --------"/>
				        <c:forEach items="${listDanhMuc}" var="danhmuc">       
				         <form:option value="${danhmuc.tthcDmId}" label="${danhmuc.name}"/>
				        </c:forEach>         
			       	</form:select> 
	                <a href="/admin/thutuchanhchinh/add.html" title="News"><img id="btnadd" src="/admin/images/add.gif" style="border: none" title="New" /></a>&nbsp;
	                <img id="btndelete" src="/admin/images/delete.gif" title="Delete" />&nbsp;
	                <img id="btnSelectAll" src="/admin/images/checkall.gif" title="Select All" />&nbsp;
	                <img id="btnUnSelectAll" src="/admin/images/uncheckall.gif" title="Deselect All" />&nbsp;
	                <img id="btnDisSelect" src="/admin/images/checkdis.gif" title="Swich select" />
	            </div>
            </div>
            <div style="clear:both"></div>
        </div>
        <div id="content" style="padding-left: 0px; margin-right: 0px; vertical-align: top;">

        <center>
        	<table id="tableOne" class="tablesorter" cellspacing="1" style="width:100%; padding-top: 0px; margin-top: 0px">
                <thead>
                    <tr>
                    	<th width="30px">#</th>
                    	<th>Tiêu đề</th>
                        <th width="80px">Kích hoạt</th>
                        <th width="100px">Ngày sửa</th>
                        <th width="68px">#</th>
                    </tr>
                </thead>
                <tbody style="text-align:left;">
                <c:if test="${not empty listThuTucHanhChinh}">
                <c:forEach var="ThuTucHanhChinh" items="${listThuTucHanhChinh}" varStatus="status">
					<tr>				
						<td align="right" style="padding-right: 4px;"><c:out value="${status.count}" /></td>
						<td><c:out value="${ThuTucHanhChinh.title}" /></td>
						<td>
							<c:if test="${ThuTucHanhChinh.active}">Active</c:if>
							<c:if test="${!ThuTucHanhChinh.active}">Deactive</c:if>							
						</td>  
                        <td><fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${ThuTucHanhChinh.modified}" /></td>
                        <td>
                            <span class="selectAllItems"><input id="checkbox-id-<c:out value="${ThuTucHanhChinh.tthcId}" />" type="checkbox" name="chkdelete" title="Chọn" /></span>
                            <span class="deleteItems"><img src="/admin/images/delete.gif" class="deleteIterm" id="delete-id-<c:out value="${ThuTucHanhChinh.tthcId}" />" title="Xóa" /></span>
                            <span class="editItems"><a href="/admin/thutuchanhchinh/edit.html?tthcId=<c:out value="${ThuTucHanhChinh.tthcId}" />"><img src="/admin/images/lightning_go.gif" title="Sửa" class="editIterm" style="border: none" /></a></span>
						</td>
                    </tr>
                </c:forEach>
                </c:if>
				</tbody>
                <tfoot>
                    <tr style="display:none;">
                        <td colspan="5">
                            No rows match the filter...
                        </td>
                    </tr>	    
                </tfoot>
            </table>
        </center>
	    <!-- End Div Content -->    
	    <div id="footer">&nbsp;</div>
	    <!-- End Div footer -->
	</div>
        </form:form>
     </div>   
	<script type="text/javascript">
		var clientHeight = document.documentElement.clientHeight;
		var clientWidth = document.documentElement.clientWidth;
		if ($.browser.msie)	//	IE
		{
			clientHeight = clientHeight - 2;
			$("div#content").css({"height": clientHeight - 40});
			$("div#footer").css({"top": clientHeight - 16,"left": 0});
		} else if ($.browser.mozilla) {
			clientHeight = clientHeight - 18;
			$("div#content").css({"height": clientHeight - 24});
			$("div#footer").css({"top": clientHeight,"left": 0});
		} else if ($.browser.safari) {
			clientHeight = clientHeight - 2;
			$("div#content").css({"height": clientHeight - 24});
		} else if ($.browser.opera) {
			clientHeight = clientHeight - 18;
		} else {
			clientHeight = clientHeight - 18;
		}
	</script>
	<div style="display:none">
	    <form name="frmdelete" method="post" action="">
	        <input type="hidden" name="id" value="" />		
	        <input type="hidden" name="action" value="delete" />
	    </form>
	</div>
</body>
</html>