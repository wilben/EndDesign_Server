<%@page import="com.gem.hsx.bean.User"%>
<%@page import="com.gem.hsx.bean.Designer"%>
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
<base href="<%=basePath%>">
</HEAD>
<jsp:include page="isLogin.jsp"></jsp:include>
<style type="text/css">
.errorMessage {
	font-size: 12px;
	color: red;
}

.label {
	font-size: 12px;
}

.errorLabel {
	font-size: 14px;
	color: red;
}
</style>
<BODY>

	<TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
		<TR height=28>
			<TD background=images/title_bg1.jpg
				style="FONT-WEIGHT: bold; COLOR: black" align=middle>普通用户列表</TD>
		</TR>
		<TR>
			<TD bgColor=#b1ceef height=1></TD>
			<TD bgColor=#b1ceef height=1></TD>
		</TR>
		<TR height=20>
			<TD background=images/shadow_bg.jpg></TD>
			<TD background=images/shadow_bg.jpg></TD>
		</TR>
	</TABLE>
	<center>
		<table cellSpacing=0 cellPadding=2 width="60%" align=center
			class="table" border="1px">
			<%
				List<User> users = (List) session.getAttribute("users");
				Iterator iter = users.iterator();
			%>
			<tr></tr>
			<tr></tr>
			<tr>
				<td align=center width=100>用户名</td>
				<td align=center width=100>性别</td>
				<td align=center width=100>真实姓名</td>
				<td align=center width=100>风格</td>
				<td align=center width=100>修改</td>
				<td align=center width=100>重置密码</td>
				<td align=center width=100>删除</td>
			</tr>
			<%
				while (iter.hasNext()) {
					User user = (User) iter.next();
					if (user.getSex() == null) {
						user.setSex("");
					}
					if (user.getRealname() == null) {
						user.setRealname("");
					}
					if (user.getStyle() == null) {
						user.setStyle("");
					}
			%>
			<tr>
				<td align=center width=100><%=user.getUsername()%></td>
				<td align=center width=100><%=user.getSex()%></td>
				<td align=center width=100><%=user.getRealname()%></td>
				<td align=center width=100><%=user.getStyle()%></td>
				<td align=center width=100><a
					href="SelectInfoServlet?username=<%=user.getUsername()%>&role=<%=user.getRole()%>">修改</a></td>
				<td align=center width=100><a
					onclick="if (confirm('确定要重置密码吗？')) return true; else return false;"
					href="ResetServlet?username=<%=user.getUsername()%>&role=<%=user.getRole()%>">重置密码</a></td>
				<td align=center width=100><a
					onclick="if (confirm('确定要删除吗？')) return true; else return false;"
					href="DeleteInfoServlet?username=<%=user.getUsername()%>&role=<%=user.getRole()%>">删除</a></td>
			</tr>
			<%
				}
			%>
		</table>
	</center>
</BODY>
</HTML>