<%@page import="com.gem.hsx.servlet.Login"%>
<%@page import="com.gem.hsx.bean.User"%>
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
				style="FONT-WEIGHT: bold; COLOR: black" align=middle>修改普通用户信息</TD>
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
		<form action="ModifyUserServlet" method="post">
			<table>
				<tr></tr>
				<tr></tr>
				<%
					User user = (User) session.getAttribute("user");
					if (user.getSex() == null)
						user.setSex("");
					if (user.getAge() == null)
						user.setAge("");
					if (user.getAvatar() == null)
						user.setAvatar("");
					if (user.getRealname() == null)
						user.setRealname("");
					if (user.getStyle() == null)
						user.setStyle("");
				%>
				<tr>
					<td width=70>头像</td>
					<td><img name="avatar"
						src="<%=(user.getAvatar() == null || user.getAvatar().equals("")) ? Login.url
					+ "images/default.jpg"
					: Login.url + user.getAvatar()%>"
						width="107" height="97"></td>
				</tr>
				<tr>
					<td>用户名</td>
					<td><input type="text" name="username" readOnly="readonly"
						value="<%=user.getUsername()%>"></td>
				</tr>
				<tr>
					<td>性别</td>
					<td><input type="text" name="sex" value="<%=user.getSex()%>"></td>
				</tr>
				<tr>
					<td>年龄</td>
					<td><input type="text" name="age" value="<%=user.getAge()%>"></td>
				</tr>
				<tr>
					<td>真实姓名</td>
					<td><input type="text" name="realname"
						value="<%=user.getRealname()%>"></td>
				</tr>
				<tr>
					<td>风格</td>
					<td><input type="text" name="style"
						value="<%=user.getStyle()%>"></td>
				</tr>
				<tr>
					<td colSpan=2 align=center><input type="hidden" name="role"
						value="<%=user.getRole()%>"><input type="submit"
						onclick="if (confirm('确定要提交修改吗？')) return true; else return false;"
						value="修改"></td>
				</tr>
			</table>
		</form>
	</center>
</BODY>
</HTML>