<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<%
	String msg = (String)request.getAttribute("error-msg");
	Exception e = (Exception)request.getAttribute("exception");
	
%>

<%@ include file="../common/header.jsp" %>
	
	<div class="outer">
		<h1>Service ERROR</h1>
		<br><br>
		<h3 style="color:red;">ERROR : <%= e.getMessage() %></h3>
		<h4><span>서</span>비스 수행 중 에러가 발생했습니다.
		전송 값을 확인해 보시고,<br>
		이상이 없을 시 담당자에게 연락하시기 바랍니다.</h4>
	
	</div>
<%@ include file="../common/footer.jsp" %>
