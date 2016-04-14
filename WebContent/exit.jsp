<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<base href="<%=basePath%>">
<TITLE></TITLE>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<LINK href="css/admin.css" type="text/css" rel="stylesheet">
<style type="text/css">
.errorMessage {
	font-size: 12px;
	color: red;
}
</style>
</HEAD>
<jsp:include page="isLogin.jsp"></jsp:include>
<BODY>
	<%
		session.removeAttribute("Login");
	%>
	<jsp:forward page="login.jsp"></jsp:forward>
</BODY>
</HTML>
