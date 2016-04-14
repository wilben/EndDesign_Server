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
				style="FONT-WEIGHT: bold; COLOR: black" align=middle>修改设计师信息</TD>
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
		<form action="ModifyDesignerServlet" method="post">
			<table>
				<tr></tr>
				<tr></tr>
				<%
					Designer designer = (Designer) session.getAttribute("designer");
					if (designer.getSex() == null)
						designer.setSex("");
					if (designer.getAge() == null)
						designer.setAge("");
					if (designer.getAvatar() == null)
						designer.setAvatar("");
					if (designer.getRealname() == null)
						designer.setRealname("");
					if (designer.getConcept() == null)
						designer.setConcept("");
					if (designer.getMotto() == null)
						designer.setMotto("");
					if (designer.getStyle() == null)
						designer.setStyle("");
					if (designer.getWork() == null)
						designer.setWork("");
					if (designer.getPeriod() == null)
						designer.setPeriod("");
					if (designer.getArea() == null)
						designer.setArea("");
				%>
				<tr>
					<td>用户名</td>
					<td><input type="text" name="username" readOnly="readonly"
						value="<%=designer.getUsername()%>"></td>
				</tr>
				<tr>
					<td>性别</td>
					<td><input type="text" name="sex"
						value="<%=designer.getSex()%>"></td>
				</tr>
				<tr>
					<td>年龄</td>
					<td><input type="text" name="age"
						value="<%=designer.getAge()%>"></td>
				</tr>
				<tr>
					<td>头像</td>
					<td><input type="text" name="avatar"
						value="<%=designer.getAvatar()%>"></td>
				</tr>
				<tr>
					<td>真实姓名</td>
					<td><input type="text" name="realname"
						value="<%=designer.getRealname()%>"></td>
				</tr>
				<tr>
					<td>风格</td>
					<td><input type="text" name="style"
						value="<%=designer.getStyle()%>"></td>
				</tr>
				<tr>
					<td>设计理念</td>
					<td><input type="text" name="concept"
						value="<%=designer.getConcept()%>"></td>
				</tr>
				<tr>
					<td>人生格言</td>
					<td><input type="text" name="motto"
						value="<%=designer.getMotto()%>"></td>
				</tr>
				<tr>
					<td>作品</td>
					<td><input type="text" name="work"
						value="<%=designer.getWork()%>"></td>
				</tr>
				<tr>
					<td>从业年限</td>
					<td><input type="text" name="period"
						value="<%=designer.getPeriod()%>"></td>
				</tr>
				<tr>
					<td>服务区域</td>
					<td><input type="text" name="area"
						value="<%=designer.getArea()%>"></td>
				</tr>
				<tr>
					<td colSpan=2 align=center><input type="hidden" name="role"
						value="<%=designer.getRole()%>"><input type="submit"
						value="修改"
						onclick="if (confirm('确定要提交修改吗？')) return true; else return false;"></td>
				</tr>
			</table>
		</form>
	</center>
</BODY>
</HTML>