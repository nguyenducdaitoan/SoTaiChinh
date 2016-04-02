<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="box_content have_title">
		<h1 class="title_content title_content_position"><a href="#lienhe">
				<span class="title_span_left"></span>
				<span class="title_span_center">Gởi thông tin liên hệ</span>
				<span class="title_span_right"></span>
		</a></h1>
		<div class="info_box_cotent forn_contact">
				
				<form:form name="LienHeForm" method="POST" commandName="lienhe" action="/lienhe/action.html" accept-charset="UTF-8"  enctype="multipart/form-data">
						<div class="info_contact">							
							 <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>
						    <script type="text/javascript">
						      var map;
						      var myLatLng = new google.maps.LatLng(16.080213,108.222713);
						      function initialize() {
						        var myOptions = {
						          zoom: 17,
						          zoomControl: false,
						          scaleControl: true,
						          panControl: false,
						          streetViewControl: false,
						          overviewMapControl: false,
						          mapTypeControl: false,           
						          center: myLatLng,
						          mapTypeId: google.maps.MapTypeId.ROADMAP
						        };
						        map = new google.maps.Map(document.getElementById('map_canvas'), myOptions);
						        
						        var marker = new google.maps.Marker({
						            position: myLatLng,
						            map: map,
						            title: 'Sở tài chính thành phố Đà Nẵng 12 Trần Phú - Hải Châu - thành phố Đà Nẵng'
						        });
						        var infowindow = new google.maps.InfoWindow({
									  content: "<div style=\"color: blue; font-weight: bold; font-family: Arial; font-size: 0.8em\">Sở tài chính thành phố Đà Nẵng</div><div style=\"font-family: Arial; font-size: 0.8em\">Địa chỉ: 12 Trần Phú - Hải Châu - thành phố Đà Nẵng</div><div style=\"font-family: Arial; font-size: 0.8em\">Điện thoại: (84.511) 3822130</div><div style=\"font-family: Arial; font-size: 0.8em\">Email: stcdanang@mof.gov.vn</div>",
									  maxWidth:350,
									  boxStyle: {
						                 border: "1px solid black"                 
						               },                                  
									  position: myLatLng,
									  pixelOffset: new google.maps.Size(-1, 0)
								});
						        infowindow.open(map);        
						      }
						
						      google.maps.event.addDomListener(window, 'load', initialize);
						    </script>
						   	<div id="map_canvas"></div>
						   	<style>
						   		#map_canvas{
						   			width: 650px;
						   			height: 400px;
						   		}
						   	</style>
						</div>
						<div class="clear"></div>
						<div style="padding: 10px;">* Khi quý khách cần thông tin, hãy liên hệ với chúng tôi. Sau khi nhận được thông tin của quý khách chúng tôi sẽ liên hệ lại trong thời gian sớm nhất.<br/> Cảm ơn!</div>
						<div class="content_form">
							<fieldset>
								<legend>Thông tin liên hệ</legend>
								 <div class="select_text"><label class="label" style="width: 100px;">Họ tên<span class="requied">*</span></label>
								 	<form:input path="hoTen" maxlength="90" cssClass="textinput"/>
								</div>
								<div style="clear: both; height: 1px;"></div>
								 <div class="select_text"><label class="label" style="width: 100px;">Chức danh</label>
									<form:input path="chucDanh" maxlength="90" cssClass="textinput"/>
								</div>
								<div style="clear: both; height: 1px;"></div>
								 <div class="select_text"><label class="label" style="width: 100px;">Địa chỉ<span class="requied">*</span></label>
									<form:input path="diaChi" maxlength="90" cssClass="textinput"/>
								</div>
								<div style="clear: both; height: 1px;"></div>
								 <div class="select_text"><label class="label" style="width: 100px;"><span class="requied">*</span>Số điện thoại</label>
								 	<form:input path="soDienThoai" maxlength="90" cssClass="textinput"/>
								</div>
								<div style="clear: both; height: 1px;"></div>
								 <div class="select_text"><label class="label" style="width: 100px;">Email<span class="requied">*</span></label>
								 	<form:input path="email" maxlength="90" cssClass="textinput"/>
								</div>
								<div style="clear: both; height: 1px;"></div>
								 <div class="select_text"><label class="label" style="width: 100px;">Nội dung<span class="requied">*</span></label>
								 	<form:textarea path="noiDung"  cssClass="content_textarea_contact"/>
								</div>
								<div style="clear: both; height: 1px;"></div>
								 <div class="select_text"><label class="label" style="width: 100px;">File đính kèm</label>
								 	  <form:input path="dulieu" type="file" maxlength="90" styleClass="textinput"/>	  
								</div>
								<div style="clear: both; height: 1px;"></div>
								<div class="select_text"><label class="label" style="width: 100px;"></label>
									<div style="float: left;"><img src="/taichinhCaptchaImg" id="taichinhCaptchaImgId" /></div>
									<div style="float: left; padding-top: 16px; padding-left: 4px;"><a href="#" onClick="return reloadImg('taichinhCaptchaImgId');">Chọn mã khác</a></div>
								</div>
								<div style="clear: both; height: 1px;"></div>
								<div class="select_text"><label class="label" style="width: 100px;">Mã an toàn</label>
									<form:input path="maAnToan" cssClass="textinput input_inline_capcha"/>
								</div>
								<div style="clear: both; height: 1px;"></div>
								<div>
									<form:button value="Gởi thông tin">Gởi thông tin</form:button>
								</div>
								</fieldset>
							<div style="clear: both; height: 1px;"></div>
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
		jQuery('form#formLienHeId').submit(function(){
			var str = jQuery.trim(jQuery("input[name='hoTen']").val());
			if ((str == null) || (str == '')) {
				alert('Vui lòng nhập vào họ và tên');
				jQuery('input[name="hoten"]').focus();
				jQuery('input[name="hoten"]').select();
				return false;
			}
			str = jQuery.trim(jQuery("input[name='diaChi']").val());
			if ((str == null) || (str == '')) {
				alert('Vui lòng nhập vào địa chỉ');
				jQuery('input[name="diaChi"]').focus();
				jQuery('input[name="diaChi"]').select();
				return false;
			}

			str = jQuery.trim(jQuery("input[name='soDienThoai']").val());
			if ((str == null) || (str == '')) {
				alert('Vui lòng nhập vào số điện thoại liên hệ');
				jQuery('input[name="soDienThoai"]').focus();
				jQuery('input[name="soDienThoai"]').select();
				return false;
			} else {
				if (str.length <= 7) {
					alert('Số điện thoại không đúng định dạng (tối thiểu 7 chữ số)\nví dụ: 511.3886680 hoặc 3886680 hoặc 0905250270');
					jQuery('input[name="soDienThoai"]').focus();
					jQuery('input[name="soDienThoai"]').select();
					return false;
				}
			}
			str = jQuery.trim(jQuery("input[name='email']").val());
			if ((str == null) || (str == '')) {
				alert('Vui lòng nhập vào địa chỉ email');
				jQuery('input[name="email"]').focus();
				jQuery('input[name="email"]').select();
				return false;
			} else {
				var email  = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/; 
				if (!str.match(email)) {
					alert('Địa chỉ email không đúng định dạng');
					jQuery('input[name="email"]').focus();
					jQuery('input[name="email"]').select();
					return false;
				}
			}
			str = jQuery.trim(jQuery("textarea[name='txtFCKContent']").val());
			if ((str == null) || (str == '')) {
				alert('Vui lòng nhập nội dung liên hệ');
				jQuery('textarea[name="txtFCKContent"]').focus();
				jQuery('textarea[name="txtFCKContent"]').select();
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