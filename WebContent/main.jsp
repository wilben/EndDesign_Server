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
<TITLE>装修设计信息管理系统</TITLE>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<META http-equiv=Pragma content=no-cache>
<META http-equiv=Cache-Control content=no-cache>
<META http-equiv=Expires content=-1000>
<LINK href="css/admin.css" type="text/css" rel="stylesheet">
</HEAD>
<jsp:include page="isLogin.jsp"></jsp:include>
<FRAMESET border=0 frameSpacing=0 rows="80, *" frameBorder=0>
	<FRAME name=header src="header.jsp" frameBorder=0 noResize scrolling=no>
	<FRAMESET cols="190, *">
		<FRAME name=menu src="menu.jsp" frameBorder=0 noResize scrolling=no>
		<FRAME name=main src="main.jsp" frameBorder=0 noResize scrolling=yes>
	</FRAMESET>
</FRAMESET>
<noframes>
</noframes>
</HTML>
