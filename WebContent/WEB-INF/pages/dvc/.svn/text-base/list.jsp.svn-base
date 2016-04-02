<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div id="content">
      
<style type="text/css">
	fieldset {
		font-family: Arial;
		font-size: 10pt;
	}
	fieldset legend {
		font-family: Tahoma;
		font-weight: bold;
		color: #191970;
		margin-bottom: 4px;
	}
	div.title {
		font-family: Tahoma;
		font-size: 0.8em;
		color: #1100db;
		font-weight: bold;
		padding-bottom: 4px;
	}
	div.inline {
		float: left;
	}
	.label {
		font-family: Arial;
		font-size: 10pt;
		font-weight: bold;
		color: #1100db;
		padding-right: 4px;
	}
	div.clear {
		clear: both;
		height: 2px;
	}
	a.dvclink {	
		color:#FF4500;
		text-decoration: none;
		font-family: Arial;
		font-size: 10pt;
	}
	a.dvclink:hover	{
		text-decoration: none;
		color: #6A5ACD	!important; 
	}
</style>
<script charset="utf-8" type="text/javascript">
	$(document).ready(function() {
		$('a.linkHuongDan').click(function() {
			if ($('#huongDanContent').css('display') == 'none') {			
				$('#huongDanContent').slideDown('slow');
			} else {
				$('#huongDanContent').slideUp('slow');
			}
		});
		$('a.linkGopyDvc').click(function() {
			if ($('#formGopyDvcContent').css('display') == 'none') {			
				$('#formGopyDvcContent').slideDown('slow');
			} else {
				$('#formGopyDvcContent').slideUp('slow');
			}
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
<div class="box_content have_title">
	<h1 class="title_content title_content_position_sidebar">
		<a class="linkHuongDan" href="#">
			<span class="title_span_left"></span>
			<span class="title_span_center">
				Hướng dẫn 
			</span>
			<span style="width: 400px; background-repeat: no-repeat;" class="title_span_right"><span style="position: relative; top: 7px; left: 36px; color: blue;">Click vào để hiện/ẩn nội dung hướng dẫn</span></span>
		</a>
	</h1>
	<div style="padding: 6px 10px 0px; font-family: Arial; font-size: 10pt; display: none;" id="huongDanContent">
		<div style="font-weight: bold;">Gởi hồ sơ:</div>
		<div style="padding-left: 16px;">
            Bước 1: Chọn một loại dịch vụ công và điền tất cả các thông tin trên biểu mẫu hồ sơ điện tử.<br>
            Bước 2: Nhận tên hồ sơ và đính kèm các tệp bản quét/bản mềm đối với những văn bản, tài liệu đi kèm hồ sơ.<br>
            Bước 3: Thực hiện gởi hồ sơ, sau khi gởi hồ sơ hoàn tất công dân sẽ nhận được email thông báo bao gồm mã số hồ sơ và mã số tra cứu.<br>
		</div>
		<div style="font-weight: bold;">Tra cứu hồ sơ:</div>
		<div style="padding-left: 16px;">
            Bước 1: Nhập mã số hồ sơ và mã số tra cứu (Bạn đã nhận qua email lúc đăng ký).<br>
            Bước 2: Nhập mã số an toàn.<br>
            Bước 3: Click vào nút tra cứu để tra cứu thông tin hồ sơ.<br>
		</div>
		<div style="font-weight: bold;">Sửa đổi thông tin hồ sơ đã được gởi:</div>
		<div style="padding-left: 16px;">
			Bước 1: Thực hiện việc tra cứu hồ sơ.<br>
			Bước 2: Bên dưới thông tin hồ sơ mà bạn tra cứu Click vào nút <span style="color: blue;"><strong>Thay đổi hồ sơ</strong></span>.<br>
			Bước 3: Trang sửa đổi thông tin hồ sơ sẽ hiển thị lên.<br>
			Bước 4: Thay đổi thông tin hồ sơ và click <span style="color: blue;"><strong>Lưu hồ sơ</strong></span>.<br>
		</div>
		<div style="font-weight: bold;">Thông báo:</div>
		<div style="padding-left: 16px; text-align: justify;">
			- Công dân có nghĩa vụ đảm bảo tính xác thực nội dung của hồ sơ giấy với hồ sơ điện tử đã gửi và chịu trách nhiệm hoàn toàn khi có sai sót.<br>
			- Hồ sơ sẽ được chuyển về bộ phận Tiếp nhận và trả kết quả và sẽ được Sở Tài chính TP Đà Nẵng thẩm định, giải quyết.<br>
			- Thông tin về quá trình giải quyết hồ sơ sẽ được cập nhật trực tiếp trên mạng để thông báo cho công dân.<br>
			- Trường hợp hồ sơ chưa hoàn chỉnh hoặc có yêu cầu khác, công dân sẽ được hướng dẫn chi tiết để hoàn chỉnh hồ sơ.<br>
			- Công dân thường xuyên kiểm tra email của mình vì người xử lý hồ sơ có thể gởi thông báo về việc xử lý hồ sơ qua email.<br>
			- Công dân đem đầy đủ hồ sơ giấy đến nộp tại Bộ phận tiếp nhận và trả kết quả Sở Tài chính TP Đà Nẵng để lấy kết quả.<br>
		</div>
	</div>
	<div style="clear: both; height: 3px;"></div>
</div>
<div class="box_content have_title">
	<h1 class="title_content title_content_position_sidebar">
		<a href="/librarygallary.do">
			<span class="title_span_left"></span>
			<span class="title_span_center">
				Tra cứu hồ sơ
			</span>
			<span class="title_span_right"></span>
		</a>
	</h1>
	<div style="padding: 10px 10px 0px 30px;">
		<form action="/tracuu.do" method="post" name="DichVuCongForm">

			<div style="clear: both; height: 3px;"></div>
			<div style="float: left; padding-top: 1px; width: 180px; text-align: right; padding-right: 3px; font-family: Arial; font-size: 1em;">
		    	Mã số hồ sơ&nbsp;:
			</div>
			<div style="float: left; text-align: left;">
				<input type="text" class="input" style="width: 194px;" value="" name="soBienNhan">
			</div>

			<div style="clear: both; height: 3px;"></div>
			<div style="float: left; padding-top: 1px; width: 180px; text-align: right; padding-right: 3px; font-family: Arial; font-size: 1em;">
		    	Mã tra cứu&nbsp;:
			</div>
			<div style="float: left; text-align: left;">
				<input type="text" class="input" style="width: 194px;" value="" name="codeTraCuu">
			</div>
			<div style="clear: both; height: 3px;"></div>
			<div style="float: left; padding-top: 1px; width: 180px; text-align: right; padding-right: 3px; font-family: Arial; font-size: 1em;">
			</div>
			<div style="float: left; text-align: left;">
				<img id="taichinhCaptchaImgId" src="/taichinhCaptchaImg">		
			</div>
			<div style="float: left; text-align: left; padding-left: 6px; padding-top: 18px;">
				<a onclick="return reloadImg('taichinhCaptchaImgId');" href="#">Chọn mã khác</a>
			</div>
			<div style="clear: both; height: 3px;"></div>	
			<div style="float: left; padding-top: 1px; width: 180px; text-align: right; padding-right: 3px; font-family: Arial; font-size: 1em;">
		    	Mã an toàn&nbsp;:
			</div>
			<div style="float: left; text-align: left;">
				<input type="text" class="textinput input_inline_capcha" style="width: 80px;" value="" maxlength="6" name="maAnToan">
			</div>
			
			<div style="clear: both; height: 3px;"></div>
			<div style="float: left; padding-top: 1px; width: 180px; text-align: right; padding-right: 3px; font-family: Arial; font-size: 1em;">
			</div>
			<div style="float: left; text-align: left; height: 30px;">
				<input type="submit" style="width: 70px;" class="button" value="Tra cứu" name="submit">
			</div>
			<div style="clear: both; height: 3px;"></div>
		</form>
	</div>
	<div style="clear: both; height: 3px;"></div>
</div>

<div class="box_content have_title">
	<h1 class="title_content title_content_position_sidebar">
		<a href="/librarygallary.do">
			<span class="title_span_left"></span>
			<span class="title_span_center">
				Dịch vụ công mức 3
			</span>
			<span class="title_span_right"></span>
		</a>
	</h1>
	<div style="padding: 6px 10px 0px; font-family: Arial; font-size: 10pt; font-weight: bold; color: red;"><img src="/images/arrow_menu.gif">Lĩnh vực Quản lý ngân sách
	</div>
	<div style="padding: 2px 10px 0px 22px; font-family: Arial; font-size: 10pt;">
		<a href="#123" style="color: rgb(63, 144, 219);" class="dvclink">Cấp giấy chứng nhận đăng ký mã số các đơn vị sử dụng ngân sách</a><br>
		<a href="#123" style="color: rgb(63, 144, 219);" class="dvclink">Thẩm tra phương án phân bổ dự toán ngân sách của các đơn vị hành chính sự nghiệp </a><br>
	</div>
	<div style="clear: both; height: 3px;"></div>
	<div style="padding: 6px 10px 0px; font-family: Arial; font-size: 10pt; font-weight: bold; color: red;"><img src="/images/arrow_menu.gif">Lĩnh vực Tài chính đầu tư
	</div>
	<div style="padding: 2px 10px 0px 22px; font-family: Arial; font-size: 10pt;">
		<a href="/dvc/xdcb.html" style="color: rgb(63, 144, 219);" class="dvclink">Cấp Giấy chứng nhận đăng ký mã số công trình xây dựng cơ bản </a><br>
	</div>
	<div style="clear: both; height: 3px;"></div>
	<div style="padding: 6px 10px 0px; font-family: Arial; font-size: 10pt; font-weight: bold; color: red;"><img src="/images/arrow_menu.gif">Lĩnh vực Quản lý giá
	</div>
	<div style="padding: 2px 10px 0px 22px; font-family: Arial; font-size: 10pt;">
		<a href="/dvc/ttpdgmsts/dangky.do" style="color: rgb(63, 144, 219);" class="dvclink">Thẩm tra phê duyệt giá mua sắm tài sản bằng nguồn ngân sách nhà nước</a><br>
	</div>
	<div style="clear: both; height: 3px;"></div>
</div>
<div class="box_content have_title">
	<h1 class="title_content title_content_position_sidebar">
		<a href="/librarygallary.do">
			<span class="title_span_left"></span>
			<span class="title_span_center">
				Liên hệ
			</span>
			<span class="title_span_right"></span>
		</a>
	</h1>
	<div style="padding-left: 22px; padding-top: 10px; padding-bottom: 10px; font-size: 10pt;">
		<div style="font-weight: bold;">Mọi thắc mắc về dịch vụ công trực tuyến công dân, đơn vị, tổ chức xin liên hệ theo địa chỉ sau:</div>
		<div style="padding-left: 20px; font-weight: bold;">Bộ phận Tiếp nhận hồ sơ và trả kết quả</div>
		<div style="padding-left: 20px;">Điện thoại: <span class="skype_pnh_print_container_1352767985">05113 863820</span><span class="skype_pnh_container" dir="ltr" tabindex="-1" onmouseover="SkypeClick2Call.MenuInjectionHandler.showMenu(this, event);" onmouseout="SkypeClick2Call.MenuInjectionHandler.hideMenu(event);" skype_menu_props="{'numberToCall':'+845113863820' , 'isFreecall':false, 'isMobile':false, 'isRtl':false}"><span class="skype_pnh_mark"> begin_of_the_skype_highlighting</span>&nbsp;<span class="skype_pnh_highlighting_inactive_common" dir="ltr"><img src="chrome://skype_ff_extension/skin/numbers_button_skype_logo.png" class="skype_pnh_logo_img"><span class="skype_pnh_free_text_span">FREE&nbsp;</span><span class="skype_pnh_text_span">05113 863820</span></span>&nbsp;<span class="skype_pnh_mark">end_of_the_skype_highlighting</span></span></div>
		<div style="padding-left: 20px;">Email: motcua-stc@danang.gov.vn</div>
		<div style="padding-left: 20px; font-weight: bold;">Bà Đặng Thị Thảo Nguyên - Cán bộ phụ trách Bộ phận Tiếp nhận hồ sơ và trả kết quả</div>
		<div style="padding-left: 20px;">Điện thoại: <span class="skype_pnh_print_container_1352767985">05113 863820</span><span class="skype_pnh_container" dir="ltr" tabindex="-1" onmouseover="SkypeClick2Call.MenuInjectionHandler.showMenu(this, event);" onmouseout="SkypeClick2Call.MenuInjectionHandler.hideMenu(event);" skype_menu_props="{'numberToCall':'+845113863820' , 'isFreecall':false, 'isMobile':false, 'isRtl':false}"><span class="skype_pnh_mark"> begin_of_the_skype_highlighting</span>&nbsp;<span class="skype_pnh_highlighting_inactive_common" dir="ltr"><img src="chrome://skype_ff_extension/skin/numbers_button_skype_logo.png" class="skype_pnh_logo_img"><span class="skype_pnh_free_text_span">FREE&nbsp;</span><span class="skype_pnh_text_span">05113 863820</span></span>&nbsp;<span class="skype_pnh_mark">end_of_the_skype_highlighting</span></span></div>
		<div style="padding-left: 20px;">Email: nguyendtt@danang.gov.vn</div>
	</div>
</div>
<div class="box_content have_title">
	<h1 class="title_content title_content_position_sidebar">
		<a class="linkGopyDvc" href="#">
			<span class="title_span_left"></span>
			<span class="title_span_center">
				Góp ý dịch vụ công 
			</span>
			<span style="width: 400px; background-repeat: no-repeat;" class="title_span_right"><span style="position: relative; top: 7px; left: 36px; color: blue;">Click vào để hiện/ẩn nội dung góp ý</span></span>
		</a>
	</h1>
	<div style="padding: 6px 10px 0px 20px; font-family: Arial; font-size: 10pt;" id="formGopyDvcContent">
	<form enctype="multipart/form-data" accept-charset="UTF-8" action="/dvc/gopy.do" method="POST" id="formLienHeId" name="DvcGopyForm">
		<div class="clear"></div>
		<div class="content_form">
			 <div class="select_text"><label style="width: 100px;" class="label">Họ tên<span class="requied">*</span></label>
			 	<input type="text" class="textinput" value="" maxlength="90" name="hoTen">
			</div>
			<div style="clear: both; height: 1px;"></div>

			 <div class="select_text"><label style="width: 100px;" class="label">Chức danh</label>
			 	<input type="text" class="textinput" value="" maxlength="90" name="chucDanh">
			</div>
			<div style="clear: both; height: 1px;"></div>
			 <div class="select_text"><label style="width: 100px;" class="label">Địa chỉ<span class="requied">*</span></label>
			 	<input type="text" class="textinput" value="" maxlength="90" name="diaChi">
			</div>

			<div style="clear: both; height: 1px;"></div>
			 <div class="select_text"><label style="width: 100px;" class="label">Số điện thoại</label>
			 	<input type="text" class="textinput" value="" maxlength="90" name="soDienThoai">
			</div>
			<div style="clear: both; height: 1px;"></div>
			 <div class="select_text"><label style="width: 100px;" class="label">Email<span class="requied">*</span></label>
			 	<input type="text" class="textinput" value="" maxlength="90" name="email">

			</div>
			<div style="clear: both; height: 1px;"></div>
			 <div class="select_text"><label style="width: 100px;" class="label">Nội dung<span class="requied">*</span></label>
			 	<textarea class="content_textarea_contact" style="height: 130px;" rows="5" name="txtFCKContent"></textarea>
			</div>
			<div style="clear: both; height: 1px;"></div>
			 <div class="select_text"><label style="width: 100px;" class="label">File đính kèm</label>

			 	<input type="file" class="textinput" value="" maxlength="90" name="attachFile">
			</div>
			<div style="clear: both; height: 1px;"></div>
			<div class="select_text"><label style="width: 100px;" class="label"></label>
				<div style="float: left;"><img id="taichinhCaptchaImgId" src="/taichinhCaptchaImg"></div>
				<div style="float: left; padding-top: 16px; padding-left: 4px;"><a onclick="return reloadImg('taichinhCaptchaImgId');" href="#">Chọn mã khác</a></div>
			</div>
			<div style="clear: both; height: 1px;"></div>

			<div class="select_text"><label style="width: 100px;" class="label">Mã an toàn</label>
			 	<input type="text" class="textinput input_inline_capcha" value="" maxlength="90" name="maAnToan">
			</div>
			<div style="clear: both; height: 1px;"></div>
			<div>
				<input type="submit" value="Gởi thông tin">
			</div>
			<div style="clear: both; height: 1px;"></div>

		</div>			
	</form>
	</div>
</div>
</div>