<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en-US">
<head>
    <title>Sở Tài Chính Tp Đà Nẵng</title>
    <link rel="shortcut icon" href='/images/favicon.ico' />
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
    <link rel="alternate" type="application/rss+xml" title="Sở Tài Chính thành phố Đà Nẵng - RSS" href="/rss.do" />	
	<link rel="stylesheet" type="text/css" media="screen" href="/css/style.css" />
	<link rel="stylesheet" type="text/css" href="/css/ddsmoothmenu.css" />
	<script type="text/javascript" src="/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="/js/ddsmoothmenu.js"></script>
	<script type="text/javascript" src="/js/slideshow-1.07.js"></script>
	<link type="text/css" rel="stylesheet" href="/css/dhtmlgoodies_calendar.css" media="screen"></link>
	<link type="text/css" rel="stylesheet" href="/css/tabelstyle.css" media="screen"></link>
	<script type="text/javascript" src="/js/dhtmlgoodies_calendar.js"></script>
	<script type="text/javascript" src="/js/jquery.lightbox-0.5.js"></script>
    <link rel="stylesheet" type="text/css" href="/css/jquery.lightbox-0.5.css" media="screen" />
	<script type="text/javascript" src="/js/jquery.ui.js"></script>
	<script type="text/javascript" src="/js/jwplayer.js"></script>
	<script type="text/javascript" src="/js/swfobject.js"></script>
    <link rel="stylesheet" type="text/css" href="/css/style-1.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="/js/paginate/paginate.css" media="screen" />
    <script type="text/javascript" src="/js/paginate/jquery.paginate.js"></script>
    <link rel="stylesheet" type="text/css" href="/css/red.css" media="screen" />
	<script type="text/javascript">
		ddsmoothmenu.init({
			mainmenuid: "smoothmenu", //menu DIV id
			orientation: 'h', //Horizontal or vertical menu: Set to "h" or "v"
			classname: 'ddsmoothmenu', //class added to menu's outer DIV
			//customtheme: ["#1c5a80", "#18374a"],
			contentsource: "markup" //"markup" or ["container_id", "path_to_menu_file"]
		});		
		$(function() {
			$('#msg_wrapper a').lightBox({fixedNavigation:true});
			// Use this example, or...
			//$('a[@rel*=lightbox]').lightBox(); // Select all links that contains lightbox in the attribute rel
			// This, or...
			//$('#gallery a').lightBox(); // Select all links in object with gallery ID
			// This, or...
			$('a.lightbox').lightBox(); // Select all links with lightbox class
			// This, or...
			//$('a').lightBox(); // Select all links in the page
			// ... The possibility are many. Use your creative or choose one in the examples above
		});
		//fancybox
	</script>
	<script type="text/javascript">
	  var _gaq = _gaq || [];
	  _gaq.push(['_setAccount', 'UA-4077777-11']);
	  _gaq.push(['_trackPageview']);

	  (function() {
		var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
		ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
		var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
	  })();
	</script>
</head>
<body>
<center>
<!-- start wrapper -->
<div id="wrapper">
    <!-- start header -->
    <div id="header">
    	<div id="bottom">
	    		<div id="slideshow">
	    			<a href="/" class="home_link">
	    				<img src="images/1.png" class="active" />
					    <img src="images/7.png" />
					    <img src="images/9.png" />
				    </a>
				</div>
    		<script type="text/javascript">
				/*** 
				    Simple jQuery Slideshow Script
				    Released by Jon Raasch (jonraasch.com) under FreeBSD license: free to use or modify, not responsible for anything, etc.  Please link out to me if you like it :)
				***/
				function slideSwitch() {
				    var $active = $('#slideshow IMG.active');
				    if ( $active.length == 0 ) $active = $('#slideshow IMG:last');
				    // use this to pull the images in the order they appear in the markup
				    var $next =  $active.next().length ? $active.next()
				        : $('#slideshow IMG:first');
				    // uncomment the 3 lines below to pull the images in random order
				    // var $sibs  = $active.siblings();
				    // var rndNum = Math.floor(Math.random() * $sibs.length );
				    // var $next  = $( $sibs[ rndNum ] );
				    $active.addClass('last-active');
				    $next.css({opacity: 0.0})
				        .addClass('active')
				        .animate({opacity: 1.0}, 1000, function() {
				            $active.removeClass('active last-active');
				        });
				}
				$(function() {
				    setInterval( "slideSwitch()", 5000 );
				});
			</script>
    	</div>
		<div id="smoothmenu" class="ddsmoothmenu">
			<!-- <a href="/" class="a_home_sotaichinh"><img src="/images/home_sotaichinh.png"/></a>-->
			<ul>
				<li><a href="/">Trang chủ</a></li>
				<tiles:insertAttribute name="menu/list" />
				<li><a class="last" href="/lienhe/detail.html">Liên hệ</a></li>
			</ul>
		<!-- <div class="date_time"> <span id="tick_time"></span></div>-->
		<div class="form_search" style="height: 24px !important; overflow: hidden">
			<tiles:insertAttribute name="searchform" />
		</div>
		<div style="clear: both;"></div>
	</div>
	<div style="clear: both;"></div>
    </div>
	<!-- end header -->	
	<!-- start page -->
	<div id="page">
		<!-- start content -->
       <div id="content">
       		<tiles:importAttribute name="featured"/>
        	<tiles:insertAttribute name="content" />
        </div>
        <!-- end content -->
        <div id="menu_right">
        	<div style="padding-top: 10px; padding-left: 10px;">
				<a href="/dvc/list.html"><img src="/images/dvc.png"/></a>
			</div>
			<tiles:insertAttribute name="thongbao/list" />
			<tiles:insertAttribute name="sukien/list" />
			        	<div class="box_content have_title">
				<h1 class="title_content title_content_position_sidebar">
					<a href="#video">
						<span class="title_span_left"></span>
						<span class="title_span_center">Tin Video</span>
						<span class="title_span_right"></span>
					</a>
				</h1>
				<div class="box_video">
						<div id='mediaspace'></div>
						<ul class="list_video">
							<tiles:insertAttribute name="video/list" />
						</ul>
						<script type='text/javascript'>			
						$(document).ready(function() {
							var link_video = $(".list_video li").find('a').attr("alt"); 
							jwplayer('mediaspace').setup({
							    'flashplayer': '/js/player.swf',
								'file': link_video,
								'controlbar': 'bottom',
								'icons': 'false',
								'width': '276',
								'height': '222' 
							});
							$(".list_video li a").click(function(){ 
								$id_video = $(".list_video li:hover").find('a').attr("alt"); 
								if($id_video){
									jwplayer('mediaspace').setup({
										'flashplayer':  '/js/player.swf',
										'file': $id_video,
										'autostart': 'true',
										'controlbar': 'bottom',
										'icons': 'false',
										'width': '276',
										'height': '222'
									});
									$("#mediaspace_wrapper").addClass("bg_mediaspace");
									$(".list_video li").removeClass("playvideo"); 
									$(".list_video li:hover").addClass("playvideo"); 
								}
								return false;
							});
						});
						</script>
				</div>
			</div>
			<tiles:insertAttribute name="gallary/list" />
			<tiles:insertAttribute name="advert/list" />
			<div style="padding-left: 10px;">
				<a href="/phanmem.do"><img src="/images/pmtc.png"/></a>
			</div>
			<div style="padding-left: 10px;">
				<a href="/vbduthaolist.do"><img src="/images/vb_du_thao.png"/></a>
			</div>
			<div style="padding-left: 10px;">
				<a href="/giadat.do"><img src="/images/tra_cuu_gia_dat.png"/></a>
			</div>
			
			<div class="box_content have_title">
				<h1 class="title_content title_content_position_sidebar">
					<a href="#link_website">
						<span class="title_span_left"></span>
						<span class="title_span_center">Liên kết website</span>
						<span class="title_span_right"></span>
					</a>
				</h1>
				<div class="link_website">
					
					<select onchange="load_lienket(this.value);">
						<option value="">--------------------Chọn website--------------------</option>
						<tiles:insertAttribute name="lienket/list" />
					</select>
					<script type='text/javascript'>
						function load_lienket(link) {
							if(link != '') {
								var w = window.open('about:blank', '_blank');
								w.location.href = link;
							} else {
								return false;
							}
						}
					</script>
				</div>
			</div>
        	<tiles:insertAttribute name="right" />
		</div>
     
	</div>
    <!-- end page -->
    <!-- start footer -->
	<div id="footer">
		<tiles:insertAttribute name="footer" />
    </div>
	<!-- end footer -->
</div>
<!-- end wrapper -->
</center> 
</body>
</html>