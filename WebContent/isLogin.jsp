<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	if ((String) session.getAttribute("Login") == null) {
%>
<jsp:forward page="login.jsp"></jsp:forward>
<%
	}
%>
