<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="net.fckeditor.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Danh sách Legal Documents</title>
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
				alert('Hãy chọn một văn bản để xóa');
			} else {
				ok = confirm('Bạn chắc chắn muốn xóa?');
				if (ok) {
					$.ajax({
						cache: false,
						type: 'POST',
						url:   '/admin/legaldocuments/deleteajaxlegaldocuments.html',
						data:  'legalDocumentsId=' + list_activities_id,
						dataType: "html",
						success: function(data) {
							var getData = $.parseJSON(data);
							if ((getData.error != null) && (getData.error != '')) {
								alert(getData.error);
							} else {
								alert('Xóa bỏ thành công');
								window.location.href = '/admin/legaldocuments/list.html';
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
				var legalDocumentsId = this.id.substr(10);
				$.ajax({
					cache: false,
					type: 'POST',
					url:   '/admin/legaldocuments/deleteajaxlegaldocuments.html',
					data:  'legalDocumentsId=' + legalDocumentsId,
					dataType: "html",
					success: function(data) {
						var getData = $.parseJSON(data);
						if ((getData.error != null) && (getData.error != '')) {
							alert(getData.error);
						} else {
							alert('Xóa bỏ thành công');
							window.location.href = '/admin/legaldocuments/list.html';
						}
					},
					error: function(e, xhr) {
						alert(e);
					}
				});
			}
	    });
	    
//	    $("#tableOne").tablesorter({headers: {3: {sorter: false}}, widgets: ['zebra'] });
	    $("table#tableOne").tablesorter({ 
	        headers: { 
	            5: {sorter: false} 
	        } 
	    }); 

	    $("input:button[name='timkiemvbpq']").click(function() {
			var query = $("input:text[name='queryvbpq']").val();
			var tungay = $("input:text[name='tungay']").val();
			var denngay = $("input:text[name='denngay']").val();
			var sohieuvb = $("input:text[name='soHieuVB']").val();
			var ldlinhvucid = $("select[name='ldLinhVucId']").val();
			var ldcapid = $("select[name='ldCapId']").val();
			var ldcoquanid = $("select[name='ldCoQuanId']").val();
			var ldloaivbid = $("select[name='ldLoaiVbId']").val();

			if (ldcapid=='-1') {
				ldcapid='';
			}
			if (ldcoquanid=='-1') {
				ldcoquanid='';
			}
			if (ldlinhvucid=='-1') {
				ldlinhvucid='';
			}
			if (ldloaivbid=='-1') {
				ldloaivbid='';
			}						
			var url = '?query='+query+'&sohieuvb='+sohieuvb+'&tungay='+tungay+'&denngay='+denngay+'&ldlinhvucid='+ldlinhvucid+'&ldcoquanid='+ldcoquanid+'&ldloaivbid='+ldloaivbid+'&ldcapid='+ldcapid;
			window.location.href = url;
		});
	    $("input:text[name='queryvbpq']").bind('keypress', function(e) {
	        if(e.keyCode==13){
	        	$("input:button[name='timkiemvbpq']").click();
	        }
		});
	    $("input:text[name='soHieuVB']").bind('keypress', function(e) {
	        if(e.keyCode==13){
	        	$("input:button[name='timkiemvbpq']").click();
	        }
		});
	});
</script>
</head>
<body>
	<div id="bodyadmin">
	<form:form commandName="legaldocumentform" method="Post">
    	<div id="header">
            <div style="width: 250px; text-align:left; float:left; font-family: Tahoma; font-size:10pt;">
                <img src="/admin/images/data.gif" title="" />
				<div style="position:absolute; top:4px; left:14px;">&nbsp;Danh mục văn bản pháp quy</div>				
            </div>
            <div style="width: 130px; text-align:right; float:right;">
            	<div style="position:absolute; top:1px;">
	                <a href="/admin/legaldocuments/add.html" title="News"><img id="btnadd" src="/admin/images/add.gif" style="border: none" title="New" /></a>&nbsp;
	                <img id="btndelete" src="/admin/images/delete.gif" title="Delete" />&nbsp;
	                <img id="btnSelectAll" src="/admin/images/checkall.gif" title="Select All" />&nbsp;
	                <img id="btnUnSelectAll" src="/admin/images/uncheckall.gif" title="Deselect All" />&nbsp;
	                <img id="btnDisSelect" src="/admin/images/checkdis.gif" title="Swich select" />
	            </div>
            </div>
            <div style="clear:both"></div>
        </div>
        
        <div id="content" style="padding-left: 0px; margin-right: 0px; vertical-align: top;">
        
        
        
        <div id="search-content" style="width: 96%; text-align: left; font-family: Arial; font-size: 10pt; padding: 0px;">
        	<fieldset style="width: 100%;">
        		<legend style="font-weight: bold; margin-left: 30px">Tìm kiếm văn bản pháp quy</legend>        		
		        <div class="doc_title_search">		        	
		        	<div>
		        		<div style="float: left; width: 181px; padding-right: 4px; padding-top: 3px; font-family: Arial; font-size: 12px; font-weight: bold; text-align: right;">Cấp cơ quan ban hành:</div>
			 			<div style="float: left; width: 320px; padding-right: 4px; text-align: left;">
				 			<form:select path="ldCapId" id="ldCapId" style="background-color: #EDF8D6; border: 1px solid gray; font-family: Arial; width: 313px" class="SelectBox">
				 				<form:option value="-1" label="--- Tất cả các cấp ---"/>
				 				<c:forEach items="${listcap}" var="ldcap">							
									<form:option value="${ldcap.ldCapId}" label="${ldcap.name}"/>
								</c:forEach>								
							</form:select>
			 			</div>
			 		</div>
			 		<div style="clear: both; height: 2px;"></div>
			 		<div>
		        		<div style="float: left; width: 181px; padding-right: 4px; padding-top: 3px; font-family: Arial; font-size: 12px; font-weight: bold; text-align: right;">Cơ quan ban hành:</div>
			 			<div style="float: left; width: 320px; padding-right: 4px; text-align: left;">
				 			<form:select path="ldCoQuanId" name="ldCoQuanId" id="ldCoQuanId" style="background-color: #EDF8D6; border: 1px solid gray; font-family: Arial; width: 313px" class="SelectBox">
				 				<form:option value="-1" label="--- Tất cả cơ quan ---"/>
								<c:forEach items="${listcoquan}" var="ldcoquan">							
									<form:option value="${ldcoquan.ldCoQuanId}" label="${ldcoquan.name}"/>
								</c:forEach>				 				
							</form:select>
			 			</div>
			 		</div>
			 		<div style="clear: both; height: 2px;"></div>
			 		<div>
		        		<div style="float: left; width: 181px; padding-right: 4px; padding-top: 3px; font-family: Arial; font-size: 12px; font-weight: bold; text-align: right;">Loại văn bản:</div>
			 			<div style="float: left; width: 320px; padding-right: 4px; text-align: left;">
				 			<form:select path="ldLoaiVbId" name="ldLoaiVbId" id="ldLoaiVbId" style="background-color: #EDF8D6; border: 1px solid gray; font-family: Arial; width: 313px" class="SelectBox">
				 				<form:option value="-1" label="--- Tất cả loại văn bản ---"/>
								<c:forEach items="${listloaivb}" var="ldloaivb">							
									<form:option value="${ldloaivb.ldLoaiVbId}" label="${ldloaivb.name}"/>
								</c:forEach>				 				
							</form:select>
			 			</div>
			 		</div>
			 		<div style="clear: both; height: 2px;"></div>
			 		<div>
		        		<div style="float: left; width: 181px; padding-right: 4px; padding-top: 3px; font-family: Arial; font-size: 12px; font-weight: bold; text-align: right;">Lĩnh vực:</div>
			 			<div style="float: left; width: 320px; padding-right: 4px; text-align: left;">
				 			<form:select path="ldLinhVucId" name="ldLinhVucId" id="ldLinhVucId" style="background-color: #EDF8D6; border: 1px solid gray; font-family: Arial; width: 313px" class="SelectBox">
				 				<form:option value="-1" label="--- Tất cả lĩnh vực ---"/>
								<c:forEach items="${listlinhvuc}" var="ldlinhvuc">							
									<form:option value="${ldlinhvuc.ldLinhVucId}" label="${ldlinhvuc.name}"/>
								</c:forEach>				 				
							</form:select>
			 			</div>
			 		</div>
		        	<div style="clear: both; height: 2px;"></div>
		        	<div>
		        		<div style="float: left; width: 181px; padding-right: 4px; padding-top: 3px; font-family: Arial; font-size: 12px; font-weight: bold; text-align: right;">Số hiệu văn bản:</div>
		        		<div style="float: left; width: 220px; padding-right: 4px; text-align: left;">
				 			<input type="text" style="width: 311px; border: 1px solid gray" maxlength="512" class="textbox" name="soHieuVB" id="soHieuVB" value="" />
				 		</div>
		        	</div>
		        	<div style="clear: both; height: 2px;"></div>
		        	<div>
		        		<div style="float: left; width: 181px; padding-right: 4px; padding-top: 3px; font-family: Arial; font-size: 12px; font-weight: bold; text-align: right;">Ngày ban hành:</div>
		        		<div style="float: left; width: 98px; text-align: left;">
				 			<input type="text" style="width: 70px; border: 1px solid gray" maxlength="10" class="textbox" name="tungay" id="txtTuNgayId" value="" />
			           		<img src="/images/lich.png" style="padding-left: 0px; padding-top: 0px; position:relative; top: +2px; cursor:pointer" title="Chọn ngày từ ngày" onclick="displayCalendar(document.getElementById('txtTuNgayId'),'dd/mm/yyyy',this)" />
				 		</div>
				 		<div style="float:left; padding-top: 1px; width: 10px; text-align:right; padding-right:14px; font-family: Arial; font-size: 10pt;">
			                -
			            </div>
			            <div style="float:left; width: 98px; text-align:left;">
			           		<input type="text" style="width: 70px; border: 1px solid gray" maxlength="10" class="textbox" name="denngay" id="txtDenNgayId" value="" />
			           		<img src="/images/lich.png" style="padding-left: 0px; padding-top: 0px; position:relative; top: +2px; cursor:pointer" title="Chọn ngày đến ngày" onclick="displayCalendar(document.getElementById('txtDenNgayId'),'dd/mm/yyyy',this)" /> 
			            </div>
		        	</div>
		        	<div style="clear: both; height: 2px;"></div>				 	
					<div>
		        		<div style="float: left; width: 181px; padding-right: 4px; padding-top: 3px; font-family: Arial; font-size: 12px; font-weight: bold; text-align: right;">Trích yếu:</div>
		        		<div style="float: left; width: 220px; padding-right: 4px; text-align: left;">
				 			<input type="text" style="width: 311px; border: 1px solid gray" maxlength="100" class="textbox" name="queryvbpq" id="queryvbpqId" value="" />
				 		</div>
		        	</div>				 	
				 	<div style="clear: both; height: 8px;"></div>
				 	<div style="padding-left: 185px; text-align: left;">
				 		<input type="button" style="width: 70px;" class="button" value="Tìm kiếm" name="timkiemvbpq">
				 	</div>				
				</div>
        	</fieldset>
        </div>
    	
    
    
    
    
        <div style="clear: both; height: 8px;"></div>
        
        <center>
        	<table id="tableOne" class="tablesorter" cellspacing="1" style="width:100%; padding-top: 0px; margin-top: 0px">
                <thead>
                	<tr>
                    	<th width="30px">#</th>
                        <th width="130px">Số hiệu văn bản</th>
                        <th>Trích yếu</th>
                        <th width="70px">Ngày BH</th>
                        <th width="68px">#</th>
                    </tr>                    
                </thead>
                <tbody style="text-align:left;">
				
                <c:forEach var="doc" items="${listLegalDocuments}" varStatus="status">
					<tr>				
						<td align="right" style="padding-right: 4px;">
							<c:out value="${status.count}"/>
						</td>
						<td>
							<c:out value="${doc.getSoHieuVb()}"/>
						</td>
						<td>
							<c:out value="${doc.getTenVb()}"/>
						</td>
                        <td>
                        	<c:out value="${doc.getNgayBh()}"/>
                        </td>
                        <td>
                            <span class="selectAllItems"><input id="checkbox-id-<c:out value="${doc.getLegalDocumentsId()}"/>" type="checkbox" name="chkdelete" title="Chọn" /></span>
                            <span class="deleteItems"><img src="/admin/images/delete.gif" class="deleteIterm" id="delete-id-<c:out value="${doc.getLegalDocumentsId()}"/>" title="Xóa" /></span>
                            <span class="editItems"><a href="/admin/legaldocuments/edit.html?legalDocumentsId=<c:out value="${doc.getLegalDocumentsId()}"/>"><img src="/admin/images/lightning_go.gif" title="Sửa" class="editIterm" style="border: none" /></a></span>
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
        </center>
        
        </div>
	    <!-- End Div Content -->    
	    <div id="footer">
			
			
			<div style="float:right; width:230px;">Tổng số:&nbsp;<c:out value="${legaldocumentform.getTotalRecord()}"/> &nbsp;/&nbsp;<c:out value="${legaldocumentform.getTotalPage()}"/>&nbsp;Trang
			<form:select path="page" onchange="load_page(this.value);" name="page" id="pageId">
				<%
					int totalPage= (Integer)request.getAttribute("totalPage");
					for (int i = 1; i<=totalPage;i++) {					
				%>									
					<form:option value="<%=i%>"/>
				
				<%
					}
				%>	
			</form:select>
 				
			</div>
		</div>
	    <!-- End Div footer -->
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
			$("div#search-content").css({"width": clientWidth - 30});
		} else if ($.browser.mozilla) {
			clientHeight = clientHeight - 18;
			$("div#content").css({"height": clientHeight - 24});
			$("div#footer").css({"top": clientHeight - 4,"left": 0});
			$("div#search-content").css({"width": clientWidth - 40});
		} else if ($.browser.safari) {
			clientHeight = clientHeight - 2;
			$("div#content").css({"height": clientHeight - 24});
		} else if ($.browser.opera) {
			clientHeight = clientHeight - 18;
		} else {
			clientHeight = clientHeight - 18;
		}
		function load_page(page) {			
			var url = '&query=&sohieuvb=&tungay=&denngay=&ldlinhvucid=&ldcoquanid=&ldloaivbid=';
			window.location.href = '?page='+page+url;
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