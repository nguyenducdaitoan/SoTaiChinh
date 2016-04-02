<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Administrator</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<script language="JavaScript" src="js/service.js"></script>

		<script language="Javascript">
			if (top.frames.length>0) {
				top.location.href=document.location.href;
			}
		</script>
	</head>
	<frameset rows="50,*" framespacing="0px" border="0" frameborder="no">
		<frame name="banner" scrolling="no" noresize="noresize" src="banner.html" marginheight="0" marginwidth="0" />
		<frameset id="iFrame" cols="199,*">
			<frame name="contents" marginheight="0" scrolling="auto" src="left.html" />
			<frameset id="iFrame" cols="7,*">
				<frame name="showhide" marginheight="0" scrolling="no" src="showhide.html" />
				<frame name="main" marginwidth="0" marginheight="0" scrolling="yes" src="main.html" />
			</frameset>
		</frameset>
		<noframes>
			<BODY>
			</BODY>
		</noframes>
	</frameset>
</html>