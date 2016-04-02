<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<form:form commandName="search" name="SearchForm" method="POST" action="/searchformaction.html">
	<form:input  path="query" cssClass="search_name" cssStyle="position: absolute; top: 5px; with: 200px; right: 50px" value="Nhập từ khóa..."  onblur="if(this.value =='') this.value = 'Nhập từ khóa...'" onfocus="if(this.value == 'Nhập từ khóa...') this.value ='';"/>
	<input type="image" src="/images/go.png" name="submit_search" class="submit_search" style="padding: 0px" />
</form:form>
<a class="a_linnk_rss" href="/rss.do" title="RSS"><img src="/images/rss_icon.png" width="16" height="16" border="0" style="position: relative; top: 3px;" /></a>
<script>
	jQuery(document).ready(function(){
		
		function submit_form(){
			if((jQuery.trim(jQuery("div.form_search form#search input.search_name").val()) != "Nhập từ khóa...") && (jQuery.trim(jQuery("div.form_search form#search input.search_name").val()) != "")){
				return true;
			} else{
				alert("Nhập từ khóa cần tìm");
				jQuery("div.form_search form#search input.search_name").focus();
				return false;
			}
		}
		jQuery("div.form_search form#search input.submit_search").click(function(){
			if(submit_form()){
				return true;
			}
			return false;
		});
		
		$('div.form_search form#search input.search_name').bind('keypress', function(e) {
			if(e.keyCode==13){
				// Enter pressed... do anything here...
				if(submit_form()){
					return true;
				}
				return false;
			}
		});		
		
	});
</script>