<%@ page language="java" pageEncoding="UTF-8"%>   	

		

	<script type="text/javascript">
		$(document).ready(function() {
			$("input:button[name='btnVote']").click(function() {
				var voteItemSelected = $("input:radio[name='voteItemSelected']:checked");
				var voteItemId = $("input:radio[name='voteItemSelected']:checked").val();
				if (typeof(voteItemId) != 'undefined') {
					$.ajax({
						cache: false,
						url:   '/vote.do',
						type: 'POST',
						data:  'voteItemId=' + voteItemId,
						dataType: "html",
						success: function(data) {
							var getData = $.parseJSON(data);
							if ((getData.error != null) && (getData.error != '')) {
								alert(getData.error);
							} else {
								$("input:button[name='btnVote']").hide();
								alert('Cảm ơn bạn đã bình chọn');
							}
						},
						error: function(e, xhr) {
							alert(e);
						}
					});
				} else {
					alert('Hãy chọn 1 tiêu chí');
				}
			});
		});
	</script>
	<div class="box_content have_title">
		<h1 class="title_content title_content_position_sidebar">
			<a href="#vote">
				<span class="title_span_left"></span>
				<span class="title_span_center">Bình chọn</span>
				<span class="title_span_right"></span>
			</a>
		</h1>
		<table width="100%" cellspacing="0" cellpadding="0" border="0" id="AdVote" style="font-weight: bold;">
			<tr>
				<td style="padding: 6px 2px 2px 4px; font-family: Tahoma; font-size: 10pt;">Theo bạn giao diện mới của website như thế nào?</td>
			</tr>
		
			<tr style="background-color: white;">
				<td width="*" style="padding: 0px 2px 2px 0px; font-family: Arial; font-size: 10pt;">
					<input type="radio" name="voteItemSelected" id="voteItem_6" value="6">&nbsp;<label for="voteItem_6">Rất đẹp</label>
				</td>
			</tr>
		
			<tr style="background-color: white;">
				<td width="*" style="padding: 0px 2px 2px 0px; font-family: Arial; font-size: 10pt;">
					<input type="radio" name="voteItemSelected" id="voteItem_7" value="7">&nbsp;<label for="voteItem_7">Đẹp</label>
				</td>
			</tr>
		
			<tr style="background-color: white;">
				<td width="*" style="padding: 0px 2px 2px 0px; font-family: Arial; font-size: 10pt;">
					<input type="radio" name="voteItemSelected" id="voteItem_8" value="8">&nbsp;<label for="voteItem_8">Trung bình</label>
				</td>
			</tr>
		
			<tr style="background-color: white;">
				<td width="*" style="padding: 0px 2px 2px 0px; font-family: Arial; font-size: 10pt;">
					<input type="radio" name="voteItemSelected" id="voteItem_9" value="9">&nbsp;<label for="voteItem_9">Tạm được</label>
				</td>
			</tr>
		
			<tr style="background-color: white;">
				<td width="*" style="padding: 0px 2px 2px 0px; font-family: Arial; font-size: 10pt;">
					<input type="radio" name="voteItemSelected" id="voteItem_10" value="10">&nbsp;<label for="voteItem_10">Xấu</label>
				</td>
			</tr>
		
			<tr style="background-color: white;">
				<td width="*" style="padding: 0px 2px 2px 0px; font-family: Arial; font-size: 10pt;">
					<input type="radio" name="voteItemSelected" id="voteItem_11" value="11">&nbsp;<label for="voteItem_11">Ý kiến khác</label>
				</td>
			</tr>
		
			<tr>
				<td align="left" style="padding: 6px 2px 2px 4px;">
				
					<input type="button" name="btnVote" id="btnVoteId" value="Bình chọn" style="font-weight: bold; font-size: 8pt; padding: 2px 4px" />
					<input type="button" name="btnVoteResult" id="btnVoteResultId" value="Kết quả" style="font-weight: bold; font-size: 8pt; padding: 2px 4px" onclick="javascript: window.open('/voteresult.do','mywindow','width=600,height=200');" />
				
				
				</td>				
			</tr>
		</table>
	</div>
 	
			<div class="box_content have_title">
				<h1 class="title_content title_content_position_sidebar">
					<a href="#online_today">
						<span class="title_span_left"></span>
						<span class="title_span_center">Thống kê truy cập</span>
						<span class="title_span_right"></span>
					</a>
				</h1>
				<div class="img_adsversiting">
					<div class="count_visit" style="padding: 1px 0px 0px 0px; font-size: 12px;"><span class="f_span_left"><img src="/images/who_stats.png" alt="" />Trực tuyến </span><span class="f_span_right"> 16</span></div>
					<div class="clear"></div>
					<div class="count_visit" style="padding: 5px 0px 0px 0px; font-size: 12px;"><span class="f_span_left"><img src="/images/who_stats.png" alt="" />Hôm nay </span><span class="f_span_right"> 1009</span></div>
					<div class="clear"></div>
					<div class="count_visit" style="padding-top: 4px; font-size: 12px;"><span class="f_span_left"><img src="/images/who_stats.png" alt="" />Lượt truy cập </span><span class="f_span_right">2596555</span></div>
					<div class="clear"></div>	
				</div>
			</div>
			<div style="clear: both;"></div>
