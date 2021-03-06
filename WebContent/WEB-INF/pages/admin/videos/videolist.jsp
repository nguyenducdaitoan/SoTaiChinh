<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<title>Danh sách giới thiệu</title>
<link rel="stylesheet" type="text/css" media="screen" href="/admin/css/style.css">
<link rel="stylesheet" href="/css/jquery.tablesorter/themes/blue/style.css" type="text/css" id="" media="print, projection, screen">
<script type="text/javascript" src="/js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="/js/jquery.tablesorter.js"></script>
<style type="text/css">
div.quicksearch {
	padding-bottom: 10px;
}

img.editIterm {
	cursor: pointer;
}

img.deleteIterm {
	cursor: pointer;
}
</style>
<script type="text/javascript" charset="utf-8">
	var lastClickVideoId = null;
	$(document).ready(
			function() {
				show_hide_botton_del(false);
				reset_value();
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
				
				//Delete all item
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
						alert('Hãy chọn một video để xóa');
					} else {
						ok = confirm('Bạn chắc chắn muốn xóa?');
						if (ok) {
							$.ajax({
								cache: false,
								type: 'POST',
								url:   '/admin/videos/deleteAjax.html',
								cache: false,						
								data:  'videoId=' + list_activities_id,
								dataType: "html",
								success: function(data) {
									var getData = $.parseJSON(data);
									if ((getData.error != null) && (getData.error != '')) {
										alert(getData.error);
									} else {
										alert('Xóa bỏ thành công');
										window.location.href = '/admin/videos/list.html';
									}
								},
								error: function(e, xhr) {
									alert(e);
								}
							});
						} else {
							reset_value_when_delete();
						}
					}
			    });
				
				//Delete this item
				$(".deleteIterm").click(function() {
					ok = confirm('Bạn chắc chắn muốn xóa?');

					if (ok)	{
						var videoId = this.id.substr(10);
						$.ajax({
							cache: false,
							type: 'POST',
							url:   '/admin/videos/deleteAjax.html',
							cache: false,
							data:  'videoId=' + videoId,
							dataType: "html",
							success: function(data) {
								var getData = $.parseJSON(data);
								if ((getData.error != null) && (getData.error != '')) {
									alert(getData.error);
								} else {
									alert('Xóa bỏ thành công');
									window.location.href = '/admin/videos/list.html';
								}
							},
							error: function(e, xhr) {
								alert(e);
							}
						});
					} else {
						reset_value_when_delete();
					}
			    });
				
				$('input:text[name="priority"]').keypress(
						function(e) {
							if (e.which != 8 && e.which != 0 && e.which != 43
									&& e.which != 46
									&& (e.which<48 || e.which>57)) {
								return false;
							}
						});

				$("[name='VideoForm']").submit(function() {
					console.log('submit');
					if ($("input:hidden[name='action']").val() != 'delete') {
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
					//console.log('end submit');
					return true;
				});

				$("input:button[name='reset']").click(function() {
					$("input:hidden[name='videoId']").val("");
					$("input:text[name='title']").val("");
					$("input:text[name='url']").val("");
					$("input:text[name='priority']").val("");
					$("input:button[name='reset']").val("Làm lại");
					$("input:submit[name='submit']").val("Lưu");
					$("input:hidden[name='action']").val("");
					$("tr#row-" + lastClickVideoId).find('td').each(function() {
						$(this).css("background-color", "#ffffff");
					});
					show_hide_botton_del(false);
					lastClickVideoId = null;
				});
				//del
				$("input:button[name='delete']").click(function() {
					
					if ($("input:hidden[name='videoId']").val() == '') {
						alert('Video không tồn tại. Chọn Video để xóa');
						$("input:hidden[name='videoId']").focus();
						return false;
					}
					ok = confirm('Bạn chắc chắn muốn xóa?');
					if(ok){
						$("input:hidden[name='action']").val("delete");
						$("input:submit[name='submit']").click();
						//			$("form[name='VideoForm']").submit();
						return true;
					}
				});
				

			});

	function fillThongTinVideo(videoId, title, url, priority) {
		if ($("input:submit[name='submit']").val() == "Cập nhật")
			return;
		if (lastClickVideoId != null) {
			$("tr#row-" + lastClickVideoId).find('td').each(function() {
				$(this).css("background-color", "#ffffff");
			});
		}
		$("input:hidden[name='videoId']").val(videoId);
		$("input:text[name='title']").val(title);
		$("input:text[name='url']").val(url);
		$("input:text[name='priority']").val(priority);
		$("input:button[name='reset']").val("Hủy bỏ");
		$("input:submit[name='submit']").val("Cập nhật");
		$("input:hidden[name='action']").val("update");
		$("tr#row-" + videoId).find('td').each(function() {
			$(this).css("background-color", "yellow");
		});
		show_hide_botton_del(true);
		lastClickVideoId = videoId;
	}
	function show_hide_botton_del(status) {
		if (!status) {
			$("#bt_delete").hide();
			$("input:submit[name='delete']").attr("disabled", true);
		} else {
			$("#bt_delete").show();
			$("input:submit[name='delete']").attr("disabled", false);
		}
	}
	function reset_value() {
		$("input:hidden[name='videoId']").val("");
		$("input:text[name='title']").val("");
		$("input:text[name='url']").val("");
		$("input:text[name='priority']").val("");
		$("input:button[name='reset']").val("Làm lại");
		$("input:submit[name='submit']").val("Lưu");
		$("input:hidden[name='action']").val("");
		$("tr#row-" + lastClickVideoId).find('td').each(function() {
			$(this).css("background-color", "#ffffff");
		});
		show_hide_botton_del(false);
		lastClickVideoId = null;
	}
	function reset_value_when_delete() {

		$("input:hidden[name='videoId']").val("");
		$("input:text[name='title']").val("");
		$("input:text[name='url']").val("");
		$("input:text[name='priority']").val("");
		$("input:button[name='reset']").val("Làm lại");
		$("input:submit[name='submit']").val("Lưu");
		$("input:hidden[name='action']").val("");
		$("tbody tr").find('td').each(function() {
			$(this).css("background-color", "#ffffff");
		});
		show_hide_botton_del(false);
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
			<div
				style="width: 250px; text-align: left; float: left; font-family: Tahoma; font-size: 10pt;">
				<img src="/admin/images/data.gif" title="">
				<div style="position: absolute; top: 4px; left: 14px;">&nbsp;Danh
					Mục Video</div>
			</div>
			<div style="clear: both"></div>
		</div>
		<div id="content"
			style="padding-left: 0px; margin-right: 0px; vertical-align: top; height: 97%;">

			<form:form name="VideoForm" method="POST" commandName="video" action="/admin/videos/action.html"
				accept-charset="UTF-8">
				<form:hidden path="videoId"/> 
				<form:hidden path="action"/> 
				<div style="padding: 10px 0px;">
					<div>
						<div
							style="float: left; padding-top: 1px; width: 140px; text-align: right; padding-right: 3px; font-family: Arial; font-size: 10pt;">
							<span style="color: red; font-style: italic;">(*)</span>Tiêu
							đề&nbsp;:
						</div>
						<div style="float: left; width: 483px; text-align: left;">
							<form:input  path="title" maxlength="90" style="width: 90%;" cssClass="textbox"/>
						</div>
					</div>
					<div style="clear: both; height: 3px;"></div>
					<div>
						<div
							style="float: left; padding-top: 1px; width: 140px; text-align: right; padding-right: 3px; font-family: Arial; font-size: 10pt;">
							<span style="color: red; font-style: italic;">(*)</span>Địa chỉ
							Url&nbsp;:
						</div>
						<div style="float: left; width: 483px; text-align: left;">
							<form:input path="url" maxlength="90"
							 	id="urlVideoId" style="width: 357px;" cssClass="textbox"/> 
								
								<input type="button" id="formbutton" name="btnSelectFile" value="Chọn file"	onclick="doBrowseServer('video', 'urlVideoId');">
						</div>
					</div>
					<div style="clear: both; height: 3px;"></div>
					<div>
						<div
							style="float: left; padding-top: 1px; width: 140px; text-align: right; padding-right: 3px; font-family: Arial; font-size: 10pt;">
							<span style="color: red; font-style: italic;">(*)</span>Ưu
							tiên&nbsp;:
						</div>
						<div style="float: left; width: 483px; text-align: left;">
							<form:input path="priority" maxlength="90" style="width: 50px;" cssClass="textbox"/>
						</div>
					</div>
					<div style="clear: both; height: 3px;"></div>
					<div
						style="float: left; text-align: left; padding-left: 144px; width: 74px;">
						<input type="submit" name="submit" value="Lưu" class="button"
							style="width: 70px;">
					</div>
					<div id="bt_delete"
						style="float: left; text-align: left; padding-left: 10px; width: 74px; display: none;">
						<input type="button" name="delete" value="Xóa video"
							class="button" style="width: 70px;">
					</div>
					<div
						style="float: left; text-align: left; padding-left: 10px; width: 74px;">
						<input type="button" name="reset" value="Làm lại" class="button"
							style="width: 70px;">
					</div>
					<div style="clear: both; height: 3px;"></div>
				</div>
			</form:form>
			<table cellspacing="1"
				style="width: 100%; padding-top: 0px; margin-top: 0px;"
				class="tablesorter" id="tableOne">
				<thead>
					<tr>
						<th width="30px">#</th>
						<th width="*">Tiêu đề</th>
						<th width="100px">Ưu tiên</th>
						<th align="center" width="130px">Cập nhật</th>
						<th width="70px"><img title="Delete"
							src="/admin/images/delete.gif" id="btndelete">&nbsp; <img
							title="Select All" src="/admin/images/checkall.gif"
							id="btnSelectAll">&nbsp; <img title="Deselect All"
							src="/admin/images/uncheckall.gif" id="btnUnSelectAll"></th>
					</tr>
				</thead>
				<tbody style="text-align: left;">

<%
	int iSTT = 1;
%>
					<c:forEach var="tblvideo" items="${listvideo}">
					<tr
						onclick="javascript: fillThongTinVideo('<c:out value="${tblvideo.getVideoId()}"/>', '<c:out value="${tblvideo.getTitle() }"/>','<c:out value="${tblvideo.getUrl() }"/>','<c:out value="${tblvideo.getStatus() }"/>');"
						id="row-<c:out value="${tblvideo.getVideoId()}"/>" style="cursor: pointer;">
						<td align="right" style="padding-right: 4px;" id="30"><%=iSTT %></td>
						<td align="left"><c:out value="${tblvideo.getTitle() }"/></td>
						<td align="left"><c:out value="${tblvideo.getPriority() }"/></td>
						<td align="center">

							<fmt:formatDate pattern="dd/MM/yyyy HH:mm" timeZone="GMT+7" value="${tblvideo.getModified() }" />
						</td>
						<td>
							<span class="selectAllItems">
								<input	type="checkbox" title="Chọn" name="chkdelete"id="checkbox-id-<c:out value="${tblvideo.getVideoId()}"/>"></span> 
								<span class="deleteItems"><img	title="Xóa" id="delete-id-<c:out value="${tblvideo.getVideoId()}"/>" class="deleteIterm" src="/admin/images/delete.gif">
							</span>
						</td>
					</tr>
<%
iSTT++;
%>
					</c:forEach>


				</tbody>
				<tfoot>
					<tr style="display: none;">
						<td colspan="5">No rows match the filter...</td>
					</tr>
				</tfoot>
			</table>
		</div>
		<!-- End Div Content -->
		<div style="top: 214px; left: 0px;" id="footer">&nbsp;</div>
		<!-- End Div footer -->
	</div>
	<script type="text/javascript">
		var clientHeight = document.documentElement.clientHeight;
		//alert(clientHeight);
		var clientWidth = document.documentElement.clientWidth;
		if ($.browser.msie) //	IE
		{
			clientHeight = clientHeight - 2;
			$("div#content").css({
				"height" : clientHeight - 40
			});
			$("div#footer").css({
				"top" : clientHeight - 16,
				"left" : 0
			});
		} else if ($.browser.mozilla) {
			clientHeight = clientHeight - 18;
			$("div#content").css({
				"height" : clientHeight - 24
			});
			$("div#footer").css({
				"top" : clientHeight,
				"left" : 0
			});
		} else if ($.browser.safari) {
			clientHeight = clientHeight - 2;
			$("div#content").css({
				"height" : clientHeight - 24
			});
		} else if ($.browser.opera) {
			clientHeight = clientHeight - 18;
			$("div#content").css({
				"height" : clientHeight - 24
			});
			$("div#footer").css({
				"top" : clientHeight,
				"left" : 0
			});
		} else {
			clientHeight = clientHeight - 18;
			$("div#content").css({
				"height" : clientHeight - 24
			});
			$("div#footer").css({
				"top" : clientHeight,
				"left" : 0
			});
		}
		$("table#tableOne").tablesorter({
			headers : {
				4 : {
					sorter : false
				}
			}
		});
	</script>
	<div style="display: none">
		<form name="frmdelete" method="post" action="">
			<input name="id" value="" type="hidden"> <input name="action"
				value="delete" type="hidden">
		</form>
	</div>

</body>
</html>