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
<script type="text/javascript">
	function check() {

		if (document.getElementById("username").value == "") {
			alert("请输入用户名");
			username.focus();
			return false;
		} else {
			return true;
		}
	}
</script>
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
				style="FONT-WEIGHT: bold; COLOR: black" align=middle>添加普通用户</TD>
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
		<form action="AddUserServlet" method="post" onsubmit="return check();">
			<table>
				<tr>
					<%
						String result = (String) session.getAttribute("result");
						if (result != null && !result.equals("")) {
					%><%=result%>
					<%
						}
					%>
				</tr>
				<%
					session.removeAttribute("result");
				%>
				<tr></tr>
				<tr>
					<td>用户名</td>
					<td><input type="text" name="username" id="username"></td>
				</tr>
				<tr>
					<td>性别</td>
					<td><input type="text" name="sex"></td>
				</tr>
				<tr>
					<td>年龄</td>
					<td><input type="text" name="age"></td>
				</tr>
				<tr>
					<td>真实姓名</td>
					<td><input type="text" name="realname"></td>
				</tr>
				<tr>
					<td colSpan=2 align=center><input type="submit" value="提交"></td>
				</tr>
			</table>
		</form>
	</center>
</BODY>
</HTML>