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
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<LINK href="css/admin.css" type="text/css" rel="stylesheet">
</HEAD>
<BODY>
	<TABLE cellSpacing=0 cellPadding=0 width="100%"
		background="images/header_bg.jpg" border=0>
		<TR height=76>
			<TD width=360
				style="font-size: 30px; FONT-WEIGHT: bold;; COLOR: #fff; PADDING-TOP: 10px; padding-left: 20px"
				align="left">装修设计信息管理系统</TD>
			<TD
				style="FONT-WEIGHT: bold; COLOR: #fff; PADDING-TOP: 20px; font-size: 15px"
				align=right>&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
				<A style="COLOR: #fff; font-size: 15px"
				onclick="if (confirm('确定要退出吗？')) return true; else return false;"
				href="exit" target=_top>退出系统</A>
			</TD>
			<TD align=right width=268></TD>
		</TR>
	</TABLE>
	<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
		<TR bgColor=#1c5db6 height=4>
			<TD></TD>
		</TR>
	</TABLE>
</BODY>
</HTML>
