<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:forEach var="tintucSK" items="${listTinTucSuKien }">
	<div class="box_content_post box_content_post_tthc">
		<h1> 
			<a style="background: url('/images/arrow_menu.gif') no-repeat scroll 0pt 2px transparent; padding-left: 15px;" href="/sukientintucdetail.do?suKienTinTucId=<c:out value="${tintucSK.suKienTinTucId  }"/>"><c:out value="${tintucSK.title  }"/></a>
			<span>(<fmt:formatDate pattern="dd/MM/yyyy" timeZone="GMT+7" value="${tintucSK.modified }"/>)</span></h1>
	</div>
	
</c:forEach>		