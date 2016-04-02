<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quản lý Phần mềm</title>
<link rel="stylesheet" type="text/css"  media="screen" href="/admin/css/style.css" />
<link rel="stylesheet" href="/css/jquery.tablesorter/themes/blue/style.css" type="text/css" id="" media="print, projection, screen" />
<script type="text/javascript" src="/js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="/js/jquery.tablesorter.js"></script>
<script type="text/javascript" charset="utf-8">
	var lastClickphanmemId = null;	
	$(document).ready(function() {
		//set display none button delete
		show_hide_botton_del(false);
		reset_value();
		$('input:text[name="priority"]').keypress(function (e){  
			if (e.which!=8 && e.which!=0 && e.which!=43 && e.which!=46 && (e.which<48 || e.which>57)) {
				return false;  
			}
		});

		$("[name='PhanMemForm']").submit(function() {
			console.log('submit');
			if($("input:hidden[name='action']").val() != 'delete') {
				if ($("input:text[name='title']").val() == '') {
					alert('Chưa nhập tiêu đề');
					$("input:text[name='title']").focus();
					return false;
				}
				if ($("input:text[name='url']").val() == '') {
					alert('Chưa nhập địa chỉ url');
					$("input:text[name='url']").focus();
					return false;
				}
			}
			console.log('end submit');
			return true;		
		});

		$("input:button[name='reset']").click(function() {
			$("input:hidden[name='phanmemId']").val("");
			$("input:text[name='title']").val("");
			$("input:text[name='url']").val("");
			$("input:text[name='priority']").val("");
			$("input:text[name='phienBan']").val("");
			$("textarea[name='moTa']").val("");
			$("input:button[name='reset']").val("Làm lại");
			$("input:submit[name='submit']").val("Lưu");	
			$("input:hidden[name='action']").val("");
			$("tr#row-"+lastClickphanmemId).find('td').each(function() {
				$(this).css("background-color","#ffffff");
			});
			show_hide_botton_del(false);
			lastClickphanmemId = null;
		});
		//del
		$("input:button[name='delete']").click(function() {
			ok = confirm('Bạn chắc chắn muốn xóa?');
			if (ok) {
				if ($("input:hidden[name='phanmemId']").val() == '') {
					alert('Phần mềm không tồn tại. Chọn phần mềm để xóa');
					$("input:hidden[name='phanmemId']").focus();
					return false;
				}
				$("input:hidden[name='action']").val("delete");
				console.log('delete');
				$("input:submit[name='submit']").click();
				
	//			$("form[name='phanmemForm']").submit();
			}
		});
		
	});

	function fillThongTinphanmem(phanmemId, title, url, phienban, priority,mota) {
		if ($("input:submit[name='submit']").val() == "Cập nhật") return;
		if (lastClickphanmemId != null) {
			$("tr#row-"+lastClickphanmemId).find('td').each(function() {
				$(this).css("background-color","#ffffff");
			});
		} 
		$("input:hidden[name='phanmemId']").val(phanmemId);
		$("input:text[name='title']").val(title);
		$("input:text[name='url']").val(url);
		$("input:text[name='priority']").val(priority);
		$("input:text[name='phienBan']").val(phienban);
		$("textarea[name='moTa']").val(mota);
		$("input:button[name='reset']").val("Hủy bỏ");
		$("input:submit[name='submit']").val("Cập nhật");	
		$("input:hidden[name='action']").val("update");
		$("tr#row-"+phanmemId).find('td').each(function() {
			$(this).css("background-color","yellow");
		});
		show_hide_botton_del(true);
		lastClickphanmemId = phanmemId;
	}	
	function show_hide_botton_del(status){
		if(!status){
			$("#bt_delete").hide();
			$("input:submit[name='delete']").attr("disabled", true);
		}else{
			$("#bt_delete").show();
			$("input:submit[name='delete']").attr("disabled", false);
		}
	}
	function reset_value(){
		$("input:hidden[name='phanmemId']").val("");
		$("input:text[name='title']").val("");
		$("input:text[name='url']").val("");
		$("input:text[name='priority']").val("");
		$("input:text[name='phienBan']").val("");
		$("textarea[name='moTa']").val("");
		$("input:button[name='reset']").val("Làm lại");
		$("input:submit[name='submit']").val("Lưu");	
		$("input:hidden[name='action']").val("");
		$("tr#row-"+lastClickphanmemId).find('td').each(function() {
			$(this).css("background-color","#ffffff");
		});
		show_hide_botton_del(false);
		lastClickphanmemId = null;
	}
	function doBrowseServer(typeFile, elementId) {
		window
				.open(
						"/browser/ServerBrowser.jsp?FileType=" + typeFile
								+ "&EltID=" + elementId,
						"",
						"height=400px,width=600px,top=50px,left=50px,fullscreen=0,location=0,menubar=0,resizable=0,scrollbars=1,titlebar=0,status=0,toolbar=0",
						true);
	}
</script>
</head>
<body>
<div id="bodyadmin">
    	<div id="header">
            <div style="width: 250px; text-align:left; float:left; font-family: Tahoma; font-size:10pt;">
                <img src="/admin/images/data.gif" title="" />
				<div style="position:absolute; top:4px; left:14px;">&nbsp;Danh sách phân mềm</div>				
            </div>
            <div style="width: 172px; text-align:right; float:right; font-weight: normal; font-family: Arial">            	
            </div>
            <div style="clear:both"></div>
        </div>
        <div id="content" style="padding-left: 0px; margin-right: 0px; vertical-align: top;">
        	<form:form name="PhanMemForm" method="POST"  commandName="phanmem" action="/admin/phanmem/list.html" accept-charset="UTF-8">
        	<form:hidden path="phanmemId"/> 
			<form:hidden path="action"/> 
        	<div style="padding: 10px 0px;">
				<div>
		            <div style="float:left; padding-top: 1px; width: 140px; text-align:right; padding-right:3px; font-family: Arial; font-size: 10pt;">
		                <span style="color: red; font-style: italic;">(*)</span>Tiêu đề&nbsp;:
		            </div>
		            <div style="float:left; width: 483px; text-align:left;">
		           		<form:input path="title" name="title" maxlength="90" value="" style="width:90%;" class="textbox"/>  
		            </div>
		        </div>
		        <div style="clear:both; height: 3px;"></div>
		        <div>
		            <div style="float:left; padding-top: 1px; width: 140px; text-align:right; padding-right:3px; font-family: Arial; font-size: 10pt;">
		                <span style="color: red; font-style: italic;">(*)</span>Địa chỉ Url&nbsp;:
		            </div>
		            <div style="float:left; width: 483px; text-align:left;">
		           		<form:input path="url" type="text" name="url" maxlength="90" value="" id="urlSofwareId" style="width:357px;" class="textbox"/>
		           		<input type="button" id="formbutton" name="btnSelectFile" value="Chọn file" onclick="doBrowseServer('software', 'urlSofwareId');">  
		            </div>
		        </div>
		        <div style="clear:both; height: 3px;"></div>
		        <div>
		        	<div style="float:left; padding-top: 1px; width: 140px; text-align:right; padding-right:3px; font-family: Arial; font-size: 10pt;">
		                <span style="color: red; font-style: italic;">(*)</span>Phiên bản&nbsp;:
		            </div>
		            <div style="float:left; width: 83px; text-align:left;">
		           		<form:input path="phienBan" type="text" name="phienBan" maxlength="90" value="" style="width:80px;" class="textbox"/>  
		            </div>
		            <div style="float:left; padding-top: 1px; width: 70px; text-align: right; padding-right:3px; font-family: Arial; font-size: 10pt;">
		                <span style="color: red; font-style: italic;">(*)</span>Ưu tiên&nbsp;:
		            </div>
		            <div style="float:left; width: 263px; text-align:left;">
		           		<form:input path="priority" type="text" name="priority" maxlength="90" value="" style="width:50px;" class="textbox"/>  
		            </div>
		        </div>
		        <div style="clear:both; height: 3px;"></div>
		        <div style="float:left; padding-top: 1px; width: 140px; text-align:right; padding-right:3px; font-family: Arial; font-size: 10pt;">
		                <span style="color: red; font-style: italic;">(*)</span>Mô tả&nbsp;:
		            </div>
		            <div style="float:left; width: 483px; text-align:left;">
		           		<form:textarea path="moTa" name="moTa" style="width:90%; height: 80px;" class="textbox"/>  
		            </div>
		        <div style="clear:both; height: 3px;"></div>
		        <div style="float:left; text-align: left; padding-left: 144px; width: 74px;">
		        	<input type="submit" name="submit" value="Lưu" class="button" style="width: 70px;" />
		        </div>
		        <div id="bt_delete" style="float:left; text-align: left; padding-left: 10px; width: 74px">
		        	<input type="button" name="delete" value="Xóa" class="button" style="width: 70px;" />
		        </div>
		        <div style="float:left; text-align: left; padding-left: 10px; width: 74px">
		        	<input type="button" name="reset" value="Làm lại" class="button" style="width: 70px;" />
		        </div>
		        <div style="clear:both; height: 3px;"></div>
        	</div>
        	</form:form>
        	<table id="tableOne" class="tablesorter" cellspacing="1" style="width:100%; padding-top: 0px; margin-top: 0px">
                <thead>
                    <tr>
                        <th width="30px">#</th>
                        <th width="*">Tiêu đề</th>
                        <th width="100px">Ưu tiên</th>
                        <th width="102px" align="center">Cập nhật</th>
                    </tr>
                </thead>
				<tbody style="text-align:left;">   
				<c:forEach var="phanmem" items="${listphanmem}" varStatus="status">                             	
					<tr style="cursor: pointer;" id="row-23" onclick="javascript: fillThongTinphanmem('<c:out value="${phanmem.getPhanmemId()}"/>',
															'<c:out value="${phanmem.getTitle()}"/>',
															'<c:out value="${phanmem.getUrl()}"/>',
															'<c:out value="${phanmem.getPhienBan()}"/>',
															'<c:out value="${phanmem.getPriority()}"/>',
															'<c:out value="${phanmem.getMoTa()}"/>');">
						<td id="23" align="right" style="padding-right: 4px;">
							<c:out value="${status.count}"/>
						</td>
						<td align="left">
							<c:out value="${phanmem.getTitle()}"/>
						</td>
						<td align="left">
							<c:out value="${phanmem.getPriority()}"/>
						</td>						
                        <td align="center">
                        	<fmt:formatDate pattern="dd/MM/yyyy HH:mm" timeZone="GMT+7" value="${phanmem.getModified()}" />
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
	    <!-- End Div Content -->    
	    <div id="footer">
			<div style="float:right; width:200px;"></div>
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
			$("div#footer").css({"top": clientHeight - 16,"left": 0});
		} else if ($.browser.mozilla) {
			clientHeight = clientHeight - 18;
			$("div#content").css({"height": clientHeight-26});
			$("div#footer").css({"top": clientHeight,"left": 0});
		} else if ($.browser.safari) {
			clientHeight = clientHeight - 2;
			$("div#content").css({"height": clientHeight - 24});
		} else if ($.browser.opera) {
			clientHeight = clientHeight - 18;
			$("div#content").css({"height": clientHeight - 24});
			$("div#footer").css({"top": clientHeight,"left": 0});
		} else {
			clientHeight = clientHeight - 18;
			$("div#content").css({"height": clientHeight - 24});
			$("div#footer").css({"top": clientHeight,"left": 0});
		}		
	</script>
<!-- 		
	<div style="display:none">
	    <form name="frmdelete" method="post" action="">
	        <input type="hidden" name="id" value="" />		
	        <input type="hidden" name="action" value="delete" />
	    </form>
	</div>
 -->
</body>
</html>