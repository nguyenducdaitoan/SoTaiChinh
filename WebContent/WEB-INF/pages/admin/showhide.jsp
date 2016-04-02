<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title></title>
<style type="text/css">
	.LeftFrameSwitcher {
		position: fixed;
		left: 0;
		top: 110px;
		cursor: pointer;
	}	
	* html .LeftFrameSwitcher {
		position: absolute;
	}
	.MainFrameBody {
		padding-right: 7px;
		background-image: url(/admin/images/body_bg.gif);
		background-position: top left;
		background-repeat: repeat-y;
	}
</style>
</head>
<body class="MainFrameBody" topmargin="0" leftmargin="0" rightmargin="0" bottommargin="0" bgcolor="#DCDCDC">
<script language="javascript" type="text/javascript">
function SwitchLeftFrame(){
	if(typeof(top.GetBarExpanded)!="undefined"){
    	ExpandLeftFrame(!top.GetBarExpanded());
	}
}
function ExpandLeftFrame(f) {
    var i=document.getElementById("imgLeftFrameSwitcher");
    if(i){
        i.src="images/bar_"+(f?"close":"open")+".gif";
        top.FoldFrame(f);
    }
}
function SetExpandLeftFrame(){
    if(typeof(top.GetBarExpanded)!="undefined"){
    	ExpandLeftFrame(top.GetBarExpanded());
    }
}

</script>
<div class="LeftFrameSwitcher" id="divLeftFrameSwitcher">
<img alt="bar_close.gif" title="Hide/show the navigation pane" id="imgLeftFrameSwitcher" onClick="SwitchLeftFrame();" src="images/bar_close.gif" height="60" width="6" style="margin-top:230px">
</div>
</body>
</html>