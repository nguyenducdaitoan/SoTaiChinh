<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="box_content have_title" style="background-color: #F8F8F8">
	<h1 class="title_content title_content_position">
		<a href="#ggoicauhoi">
		<span class="title_span_left"></span>
		<span class="title_span_center">
			Xây dựng cơ bản
		</span>
		<span class="title_span_right"></span>
		</a>
	</h1>
	<div class="info_box_cotent forn_contact">

		<form:form name="DVCXdcbForm" commandName="xdcb" action="/dvc/actionxdcb.html" acceptCharset="UTF-8" method="POST" enctype="multipart/form-data">
		
			<div class="content_form">
				<fieldset style="font-family: Tahoma; font-size: 12px; border-color: #9C9C9C; color: #4D4D4D">				
					<legend style="font-weight: bold; color: #B2280C">Thông tin cá nhân - người đại diện nộp hồ sơ</legend>
					<div>
						<div style="float: left; width: 150px; text-align: right; padding-right: 4px; padding-top: 3px; font-weight: bold;">Họ và tên&nbsp;<span style="color: red">(*)</span>:</div>
						<div style="float: left; width: 226px;">
					 		<form:input path="hoTen" maxlength="90" cssClass="textinput" cssStyle="width: 226px"/>
					 	</div>
					</div>
					<div style="clear: both; height: 2px;"></div>
					<div>
						<div style="float: left; width: 150px; text-align: right; padding-right: 4px; padding-top: 3px; font-weight: bold;">Số CMND/Hộ Chiếu&nbsp;<span style="color: red">(*)</span>:</div>
						<div style="float: left; width: 74px;">
					 		<form:input path="soCmnd" maxlength="90" cssClass="textinput" cssStyle="width: 74px"/>
					 	</div>
					 	<div style="float: left; width: 80px; text-align: right; padding-right: 4px; padding-top: 3px; font-weight: bold;">Nơi cấp&nbsp;<span style="color: red">(*)</span>:</div>
					 	<div style="float: left; width: 140px;">
					 		<form:input path="noiCapCmnd" maxlength="90" cssClass="textinput" cssStyle="width: 140px"/>
					 	</div>
					 	<div style="float: left; width: 90px; text-align: right; padding-right: 4px; padding-top: 3px; font-weight: bold;">Ngày cấp&nbsp;<span style="color: red">(*)</span>:</div>
					 	<div style="float: left; width: 70px;">
					 		<form:input path="ngayCapCmnd" styleId="ngayCapCmndId" maxlength="90" cssClass="textinput" cssStyle="width: 70px"/>
					 		<img src="/images/lich.png" style="padding-left: 2px; padding-top: 1px; position: absolute; cursor:pointer" id="ngayBhId" title="Chọn ngày" onclick="displayCalendar(document.getElementById('ngayCapCmndId'),'dd/mm/yyyy',this)" />
					 	</div>
					 </div>
					 <div style="clear: both; height: 2px;"></div>
					 <div>
						<div style="float: left; width: 150px; text-align: right; padding-right: 4px; padding-top: 3px; font-weight: bold;">Địa chỉ&nbsp;<span style="color: red">(*)</span>:</div>
						<div style="float: left; width: 480px;">
					 		<form:input path="diaChiCaNhan"  maxlength="90" cssClass="textinput" cssStyle="width: 480px"/>
					 	</div>
					 </div>
					 <div style="clear: both; height: 2px;"></div>
					 <div>
						<div style="float: left; width: 150px; text-align: right; padding-right: 4px; padding-top: 3px; font-weight: bold;">Điện thoại&nbsp;<span style="color: red">(*)</span>:</div>
						<div style="float: left; width: 190px;">
							<form:input path="dienThoaiCaNhan"  maxlength="90" cssClass="textinput" cssStyle="width: 190px"/>
						</div>
						<div style="float: left; width: 90px; text-align: right; padding-right: 4px; padding-top: 3px; font-weight: bold;">Email&nbsp;<span style="color: red">(*)</span>:</div>
						<div style="float: left; width: 190px;">
							<form:input path="emailCaNhan"  maxlength="90" cssClass="textinput" cssStyle="width: 196px"/>
						</div>
					</div>
					<div style="clear: both; height: 2px;"></div>
				</fieldset>
				<fieldset style="font-family: Tahoma; font-size: 12px; border-color: #9C9C9C; color: #4D4D4D">				
					<legend style="font-weight: bold;  color: #B2280C">Thông tin đơn vị - tổ chức - chủ đầu tư</legend>					
					<div>
						<div style="float: left; width: 120px; text-align: right; padding-right: 4px; padding-top: 3px; font-weight: bold;">Tên chủ đầu tư&nbsp;<span style="color: red">(*)</span>:</div>
						<div style="float: left; width: 510px;">
					 		<form:input path="tenCoQuan"  maxlength="90" cssClass="textinput" cssStyle="width: 510px"/>
					 	</div>
					</div>
					<div style="clear: both; height: 2px;"></div>
					<div>
						<div style="float: left; width: 120px; text-align: right; padding-right: 4px; padding-top: 3px; font-weight: bold;">Địa chỉ chi tiết&nbsp;<span style="color: red">(*)</span>:</div>
						<div style="float: left; width: 510px;">
							<form:input path="diaChi"  maxlength="90" cssClass="textinput" cssStyle="width: 510px"/>
						</div>
					</div>
					<div style="clear: both; height: 2px;"></div>
					<div>
						<div style="float: left; width: 120px; text-align: right; padding-right: 4px; padding-top: 3px; font-weight: bold;">Điện thoại&nbsp;:</div>
						<div style="float: left; width: 190px;">
							<form:input path="soDienThoai"  maxlength="90" cssClass="textinput" cssStyle="width: 190px"/>
						</div>
						<div style="float: left; width: 120px; text-align: right; padding-right: 4px; padding-top: 3px; font-weight: bold;">Fax&nbsp;:</div>
						<div style="float: left; width: 190px;">
							<form:input path="soFax"  maxlength="90" cssClass="textinput" cssStyle="width: 196px"/>
						</div>
					</div>
					<div style="clear: both; height: 2px;"></div>

				</fieldset>
				<fieldset style="font-family: Tahoma; font-size: 12px; border-color: #9C9C9C; color: #4D4D4D" id="fsAttachment">
					<legend style="font-weight: bold;  color: #B2280C">Thông tin hồ sơ</legend>
					<div class="docAttachment">
						<div>
							<div style="float: left; width: 120px; text-align: right; padding-right: 4px; padding-top: 3px; font-weight: bold;">Tên dự án&nbsp;<span style="color: red">(*)</span>:</div>
							<div style="float: left; width: 510px;">
								<form:input path="tenDuAn"  maxlength="90" cssClass="textinput" cssStyle="width: 510px"/>
						 	</div>
						</div>
					<div style="clear: both; height: 2px;"></div>
						<div style="float: left; width: 120px; text-align: right; padding-right: 4px; padding-top: 3px; font-weight: bold;">Tên hồ sơ&nbsp;:</div>
						<div style="float: left; width: 510px;">
							<form:input path="tenHoSo[0]" cssClass="textinput input_inline_file"/>
							<form:input path="files" type="file" styleId="uploadFile_0" cssClass="textinput input_inline" style="width: 210px"/>
							<img src="/images/delete.png" style="cursor: pointer; position: relative; top: +5px; left: +40px !important;" class="removeDocAttachment" />
							<img src="/images/recycle.png" style="cursor: pointer; position: relative; top: +5px; left: +40px !important;" class="clearDocAttachment" />
						</div>
					</div>
					<div style="clear: both; height: 2px;"></div>
					<div class="docAttachment">
						<div style="float: left; width: 120px; text-align: right; padding-right: 4px; padding-top: 3px; font-weight: bold;">Tên hồ sơ&nbsp;:</div>
						<div style="float: left; width: 510px;">
							<form:input path="tenHoSo[1]" cssClass="textinput input_inline_file"/>
							<form:input path="files" type="file"  styleId="uploadFile_1" cssClass="textinput input_inline" style="width: 210px"/>
							<img src="/images/delete.png" style="cursor: pointer; position: relative; top: +5px; left: +40px !important;" class="removeDocAttachment" />
							<img src="/images/recycle.png" style="cursor: pointer; position: relative; top: +5px; left: +40px !important;" class="clearDocAttachment" />
						</div>
					</div>
					<div style="clear: both; height: 2px;"></div>
					<div class="docAttachment">
						<div style="float: left; width: 120px; text-align: right; padding-right: 4px; padding-top: 3px; font-weight: bold;">Tên hồ sơ&nbsp;:</div>
						<div style="float: left; width: 510px;">
							<form:input path="tenHoSo[2]" cssClass="textinput input_inline_file"/>
							<form:input path="files" type="file" styleId="uploadFile_2" cssClass="textinput input_inline" style="width: 210px"/>
							<img src="/images/delete.png" style="cursor: pointer; position: relative; top: +5px; left: +40px !important;" class="removeDocAttachment" />
							<img src="/images/recycle.png" style="cursor: pointer; position: relative; top: +5px; left: +40px !important;" class="clearDocAttachment" />
						</div>					
					</div>
					<div style="clear: both; height: 2px;"></div>
					<div id="div-insertdocattachment-id" style="padding-left: 124px; padding-top: 3px;">
						<a href="#" class="insertdocattachment">Thêm mới</a>
					</div>
					<div style="clear: both; height: 2px;"></div>
					<div style="padding-left: 124px; padding-top: 3px;">
						- Loại file đính kèm:  pdf, doc, docx, odt... Dung lượng tối đa: 3Mb.<br/>
						- Các file là bản scan có dấu đỏ.
					</div>
				</fieldset>
				<fieldset style="font-family: Tahoma; font-size: 12px; border-color: #9C9C9C; color: #4D4D4D">
					<div>
						<div style="float: left; width: 120px; text-align: right; padding-right: 4px; padding-top: 16px; font-weight: bold;">Mã an toàn&nbsp;:</div>
						<div style="float: left; width: 160px;">
							<img src="/taichinhCaptchaImg" id="taichinhCaptchaImgId" />
						</div>
						<div style="float: left; padding-top: 16px; padding-left: 4px;"><a href="#" onClick="return reloadImg('taichinhCaptchaImgId');">Chọn mã khác</a></div>
					</div>
					<div style="clear: both; height: 2px;"></div>
					<div>
						<div style="float: left; width: 120px; text-align: right; padding-right: 4px; padding-top: 3px; font-weight: bold;"></div>
						<div style="float: left; width: 200px;">
							<form:input path="maAnToan"  maxlength="90" style="width: 100px;" styleClass="textinput input_inline_capcha"/>
						</div>
					</div>
				</fieldset>							
				<p>
					<form:button>Gởi hồ sơ</form:button>
				</p>
			</div>			
		</form:form>	
		<div class="clear"></div>
	</div>
	<script type="text/javascript">
	jQuery(document).ready(function() {
		jQuery('input[name="soDienThoai"]').keypress(function (e){  
			if (e.which!=8 && e.which!=0 && e.which!=43 && e.which!=46 && (e.which<48 || e.which>57)) {
				return false;  
			}
		});
		jQuery('img.removeDocAttachment').click(function() {
			var length = $("fieldset#fsAttachment div.docAttachment").length;
			if (length <=1) {
				alert("Ít nhất bạn phải đính kèm 1 file hồ sơ");
				return false;
			}
			if ($(this).parent().parent().find("div input:file").val() != "") {
				var ok = confirm("File bạn xóa đang tồn tại file đính kèm\nBạn chắn chắn muốn xóa file này?");
				if (!ok) {
					return false;
				}
			}
			$(this).parent().parent().next().remove();
			$(this).parent().parent().remove();
		});
		jQuery('img.clearDocAttachment').click(function() {
			$(this).parent().parent().find("div input:text").val("");
			$(this).parent().parent().find("div input:file").val("");
		});
		
		jQuery('a.insertdocattachment').click(function() {
			insertDocAttachment();
		});
		function insertDocAttachment() {
			var fullAttachment = true;
			$("fieldset#fsAttachment div.docAttachment").each(function() {
				if ($(this).last().find("div input:file").val() == "") {					
					fullAttachment = false;
					return false;
				}
			});

			if (!fullAttachment) {
				alert("Bạn phải nhập đầy đủ các file đính kèm, trương trường hợp thiếu mới thực hiện thêm mới");
				return false;
			}

			var length = $("fieldset#fsAttachment div.docAttachment").length;
			if (length >= 10) {
				alert("Tổng số file cho phép đính kèm trong 1 lần gởi hồ sơ là không quá 10 hồ sơ");
				return false;
			}

			var lastDocAttachment = "";
			for (index = 0; index <= $("fieldset#fsAttachment div.docAttachment").length; index++) {
				if ($("input:text[name='tenHoSo[" + index + "]']").length == 0) {
					lastDocAttachment = index;
					break;
				}
			}
			
		    var strAppend = "" +
							"<div class=\"docAttachment\">" +
							"	<div style=\"float: left; width: 120px; text-align: right; padding-right: 4px; padding-top: 3px; font-weight: bold;\">Tên hồ sơ&nbsp;:</div>" +
							"	<div style=\"float: left; width: 510px;\">" +
							"		<input type=\"text\" name=\"tenHoSo[" + lastDocAttachment + "]\" value=\"\" class=\"textinput input_inline_file\">" +
							"		<input type=\"file\" name=\"files\" value=\"\" id=\"uploadFile_" + lastDocAttachment + "\" class=\"textinput input_inline\" style=\"width: 210px\">" +
							"		<img src=\"/images/delete.png\" style=\"cursor: pointer; position: relative; top: +5px; left: +40px !important;\" class=\"removeDocAttachment\" />" +
							"		<img src=\"/images/recycle.png\" style=\"cursor: pointer; position: relative; top: +5px; left: +40px !important;\" class=\"clearDocAttachment\" />" +
							"	</div>" +						
							"</div>" +
							"<div style=\"clear: both; height: 2px;\"></div>";			
			$("div#div-insertdocattachment-id").before(strAppend);
			eval("jQuery('img.removeDocAttachment').click(function() {$(this).parent().parent().next().remove();$(this).parent().parent().remove();});");
			eval("jQuery('img.clearDocAttachment').click(function() {$(this).parent().parent().find('div input:text').val('');$(this).parent().parent().find('div input:file').val('');});");			
		}
		jQuery('form#formLienHeId').submit(function() {
			jQuery('input[name="soCmnd"]').keypress(function (e){  
				if (e.which!=8 && e.which!=0 && (e.which<48 || e.which>57)) {
					return false;  
				}
			});	
			jQuery('input[name="ngayCapCmnd"]').keypress(function (e){  
				if (e.which!=8 && e.which!=0 && e.which!=47 && (e.which<48 || e.which>57)) {
					return false;  
				}
			});	
			jQuery('input[name="soDienThoai"]').keypress(function (e){  
				if (e.which!=8 && e.which!=0 && e.which!=43 && e.which!=46 && (e.which<48 || e.which>57)) {
					return false;  
				}
			});			
			var str = jQuery.trim(jQuery("input[name='hoTen']").val());
			if ((str == null) || (str == '')) {
				alert('Vui lòng nhập vào họ và tên');
				jQuery('input[name="hoTen"]').focus();
				jQuery('input[name="hoTen"]').select();
				return false;
			}
			/*
			var str = jQuery.trim(jQuery("input[name='chucDanh']").val());
			if ((str == null) || (str == '')) {
				alert('Vui lòng nhập vào chức danh');
				jQuery('input[name="chucDanh"]').focus();
				jQuery('input[name="chucDanh"]').select();
				return false;
			}*/
			str = jQuery.trim(jQuery("input[name='soCmnd']").val());
			if ((str == null) || (str == '')) {
				alert('Vui lòng nhập vào số chứng minh nhân dân / hộ chiếu');
				jQuery('input[name="soCmnd"]').focus();
				jQuery('input[name="soCmnd"]').select();
				return false;
			} else {
				if (str.length < 9){
					alert('Số CMDN/Hộ chiếu không đúng định dạng\n(Dãy số có 10 chữ số)');
					jQuery('input[name="soCmnd"]').focus();
					jQuery('input[name="soCmnd"]').select();
					return false;
					}
			}
			str = jQuery.trim(jQuery("input[name='noiCapCmnd']").val());
			if ((str == null) || (str == '')) {
				alert('Vui lòng nhập vào cơ quan cấp (nơi cấp) chứng minh nhân dân / hộ chiếu');
				jQuery('input[name="noiCapCmnd"]').focus();
				jQuery('input[name="noiCapCmnd"]').select();
				return false;
			}

			str = jQuery.trim(jQuery("input[name='ngayCapCmnd']").val());
			if ((str == null) || (str == '')) {
				alert('Vui lòng nhập vào ngày cấp giấy CMND/Hộ chiếu DD/MM/YYYY: 06/08/1985');
				jQuery('input[name="ngayCapCmnd"]').focus();
				jQuery('input[name="ngayCapCmnd"]').select();
				return false;
			} else {
				var dob  = /(0[1-9]|[12][0-9]|3[01])+\/(0[1-9]|1[012])+\/(19|20)\d\d/;
				if (!str.match(dob)) {
					alert('Định dạng ngày tháng là DD/MM/YYYY');
					jQuery('input[name="ngayCapCmnd"]').focus();
					jQuery('input[name="ngayCapCmnd"]').select();
					return false;
				}
			}

			str = jQuery.trim(jQuery("input[name='diaChiCaNhan']").val());
			if ((str == null) || (str == '')) {
				alert('Vui lòng nhập vào địa chỉ');
				jQuery('input[name="diaChiCaNhan"]').focus();
				jQuery('input[name="diaChiCaNhan"]').select();
				return false;
			}
			str = jQuery.trim(jQuery("input[name='dienThoaiCaNhan']").val());
			if ((str == null) || (str == '')) {
				alert('Vui lòng nhập vào số điện thoại liên hệ');
				jQuery('input[name="dienThoaiCaNhan"]').focus();
				jQuery('input[name="dienThoaiCaNhan"]').select();
				return false;
			} else {
				if (str.length <= 7) {
					alert('Số điện thoại không đúng định dạng (tối thiểu 7 chữ số)\nví dụ: 511.3886680 hoặc 3886680 hoặc 0909090909');
					jQuery('input[name="dienThoaiCaNhan"]').focus();
					jQuery('input[name="dienThoaiCaNhan"]').select();
					return false;
				}
			}
			str = jQuery.trim(jQuery("input[name='emailCaNhan']").val());
			if ((str == null) || (str == '')) {
				alert('Vui lòng nhập vào địa chỉ email');
				jQuery('input[name="emailCaNhan"]').focus();
				jQuery('input[name="emailCaNhan"]').select();
				return false;
			} else {
				var email  = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/; 
				if (!str.match(email)) {
					alert('Địa chỉ email không đúng định dạng');
					jQuery('input[name="emailCaNhan"]').focus();
					jQuery('input[name="emailCaNhan"]').select();
					return false;
				}
			}
			var str = jQuery.trim(jQuery("input[name='tenCoQuan']").val());
			if ((str == null) || (str == '')) {
				alert('Vui lòng nhập vào tên cơ quan');
				jQuery('input[name="tenCoQuan"]').focus();
				jQuery('input[name="tenCoQuan"]').select();
				return false;
			}
			var str = jQuery.trim(jQuery("input[name='diaChi']").val());
			if ((str == null) || (str == '')) {
				alert('Vui lòng nhập vào tên địa chỉ');
				jQuery('input[name="diaChi"]').focus();
				jQuery('input[name="diaChi"]').select();
				return false;
			}
			str = jQuery.trim(jQuery("input[name='maAnToan']").val());
			if ((str == null) || (str == '')) {
				alert('Hãy nhập mã an toàn');
				jQuery('input[name="maAnToan"]').focus();
				jQuery('input[name="maAnToan"]').select();
				return false;
			} else {
				if (str.length != 6) {
					alert('Mã an toàn có 6 ký tự');
					jQuery('input[name="maAnToan"]').focus();
					jQuery('input[name="maAnToan"]').select(); 
					return false;
				}
			}
			return true;
		});	
	});
	function reloadImg(id) {
		   var obj = document.getElementById(id);
		   var src = obj.src;
		   var pos = src.indexOf('?');
		   if (pos >= 0) {
		      src = src.substr(0, pos);
		   }
		   var date = new Date();
		   obj.src = src + '?v=' + date.getTime();
		   return false;
		}
</script>
</div>