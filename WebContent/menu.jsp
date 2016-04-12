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
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<LINK href="css/admin.css" type="text/css" rel="stylesheet">

</HEAD>
<BODY>
	<TABLE height="100%" cellSpacing=0 cellPadding=0 width=190
		background=images/menu_bg.jpg border=0>
		<TR>
			<TD vAlign=top align=middle>
				<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>

					<TR>
						<TD height=10></TD>
					</TR>
				</TABLE>
				<TABLE cellSpacing=0 cellPadding=0 width=150 border=0>

					<TR height=22>
						<TD style="PADDING-LEFT: 30px" background=images/menu_bt.jpg><A
							class=menuParent>导航信息</A></TD>
					</TR>
					<TR height=4>
						<TD></TD>
					</TR>
				</TABLE>
				<TABLE id=child1 cellSpacing=0 cellPadding=0 width=150 border=0>
					<TR height=20>
						<TD align=middle width=30><IMG height=9
							src="images/menu_icon.gif" width=9></TD>
						<TD><A class=menuChild href="addDesigner.jsp"
							target="main">添加设计师</A></TD>
					</TR>
					<TR height=20>
						<TD align=middle width=30><IMG height=9
							src="images/menu_icon.gif" width=9></TD>
						<TD><A class=menuChild href="AllDesignerServlet"
							target="main">设计师</A></TD>
					</TR>
					<TR height=20>
						<TD align=middle width=30><IMG height=9
							src="images/menu_icon.gif" width=9></TD>
						<TD><A class=menuChild href="common/changepwdswitch"
							target="main">修改密码</A></TD>
					</TR>
					<TR height=20>
						<TD align=middle width=30><IMG height=9
							src="images/menu_icon.gif" width=9></TD>
						<TD><A class=menuChild href="common/getallclasses"
							target="main">班级信息</A></TD>
					</TR>
					<TR height=20>
						<TD align=middle width=30><IMG height=9
							src="images/menu_icon.gif" width=9></TD>
						<TD><A class=menuChild href="common/addclassswitch"
							target="main">添加新班级</A></TD>
					</TR>
					<TR height=20>
						<TD align=middle width=30><IMG height=9
							src="images/menu_icon.gif" width=9></TD>
						<TD><A class=menuChild href="common/getallprizes"
							target="main">奖惩管理</A></TD>
					</TR>
					<TR height=20>
						<TD align=middle width=30><IMG height=9
							src="images/menu_icon.gif" width=9></TD>
						<TD><A class=menuChild href="common/addprizeswitch"
							target="main">添加新奖惩</A></TD>
					</TR>
					<TR height=20>
						<TD align=middle width=30><IMG height=9
							src="images/menu_icon.gif" width=9></TD>
						<TD><A class=menuChild href="common/checkuserprizes"
							target="main">学生奖惩情况</A></TD>
					</TR>
					<TR height=20>
						<TD align=middle width=30><IMG height=9
							src="images/menu_icon.gif" width=9></TD>
						<TD><A class=menuChild href="common/adduserprizeswitch"
							target="main">添加学生奖惩记录</A></TD>
					</TR>
				</TABLE>
	</TABLE>
</BODY>
</HTML>