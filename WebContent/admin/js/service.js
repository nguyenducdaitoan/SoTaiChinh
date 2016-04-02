//cookies
function GetCookie(sName)
{
  var aCookie = document.cookie.split("; ");
  for (var i=0; i < aCookie.length; i++)
  {
    var aCrumb = aCookie[i].split("=");
    if (sName == aCrumb[0]) 
      return unescape(aCrumb[1]);
  }
  return null;
}
function SetCookie(sName, sValue)
{
  document.cookie = sName + "=" + escape(sValue) + "; "
}
function SetPermanentCookie(sName, sValue)
{
  var date = new Date();
  date.setTime(date.getTime()+(365*24*60*60*1000));
  document.cookie = sName + "=" + escape(sValue) + "; expires=" + date.toGMTString() + ";";
}
function DelCookie(sName)
{
  document.cookie = sName + "=" + escape(sValue) + "; expires=Fri, 31 Dec 1999 23:59:59 GMT;";
}

// elements
function GetElement(id, d){
    if (id){
        if (!d) {d = document;}   
	    if (d.getElementById){
		    return d.getElementById(id);
	    } else if (d.all){
		    return d.all[id];
	    } else if (d.layers){
	        return d.layers[id];   
	    }
	}
	return false;
}

//frames
var m_isrefresh = true;
var m_frameset = 'iFrame';
var m_leftFrame = 'contents';
var m_size = '210';
var m_bar_expanded = true;

function GetBarExpanded()
{
    var sbe=GetCookie('BarExpanded');
    if(sbe){
        return sbe=='True';
    }else{
        SetCookie('BarExpanded','True');    
    }
    return true;
}
function FindFrame(id, f){
	var i = 0;
    for(i=0;i<f.frames.length;i++){
        if(f.frames[i].frameElement.id==id) {return f.frames[i];}
        var ff = FindFrame(id ,f.frames[i]);
        if(ff) {return ff;}
    }
    return false; 
}
function GetFrame(id){
    return FindFrame(id, top)
}
function GetFrameElement(id){
    var f = FindFrame(id, top);
    if(f && f.frameElement) {return f.frameElement }
    return false;
}
function GetCurrentX(){
    var frmset = GetElement(m_frameset, top.document); 
return (parseInt(frmset.cols));
	var frm = GetFrameElement(m_leftFrame);
	var x = 0;
	if (frm){
		x = frm.clientWidth;
		if(x==0) x = parseInt(m_size)
	}
	return x;
}
function FoldFrame(f){
    if(GetBarExpanded()!=f||(!f&&m_isrefresh)){
        if(f){
            ShowFrame();
        } else {
            HideFrame();
        }
        SetPermanentCookie('BarExpanded',f?'True':'False');
        m_isrefresh=false;
    }
}
function HideFrame(){
	ResizeMode(false);
	var x = GetCurrentX();
	var t = 0; 
	m_size = x;
	for(i=x;i>0;--i){
	    t+=5;
	    i-=Math.round(i/5);
	    setTimeout('ResizeFrame("' + i + ',*")', (x - i) < t ? x - i : t);
	}
	setTimeout('ResizeMode(true)', t);
}
function ShowFrame(){
	ResizeMode(false);
	var x = parseInt(m_size);
	var t = 0;
	for(i=0;i<x;++i){
	    t+=5;
	    i+=Math.round(i/5);
	    setTimeout('ResizeFrame("' + i + ',*")', i < t ? i : t);
	}
	setTimeout('ResizeMode(true)', t);
}
function ResizeFrame(s){
    var frmset = GetElement(m_frameset); 
	if (frmset){
		frmset.cols = s;
	}
}
function ResizeMode(mode){
	var frm = GetFrameElement (m_leftFrame);
	if (frm){
		frm.noResize = mode;		

	}
}