<%@page import="com.gem.hsx.servlet.Login"%>
<%@page import="com.gem.hsx.bean.Project"%>
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
	<%
		String flag = (String) session.getAttribute("flag");
	%>
	<TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
		<TR height=28>
			<TD background=images/title_bg1.jpg
				style="FONT-WEIGHT: bold; COLOR: black" align=middle>修改项目信息</TD>
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
		<%
			if (flag.equals("projects")) {
		%>
		<form action="ModifyProjectServlet" method="post">
			<%
				} else {
			%>
			<form action="AddWorkServlet" method="post">
				<%
					}
				%>
				<table>
					<tr></tr>
					<tr></tr>
					<%
						Project project = (Project) session.getAttribute("project");
						if (project.getDescription() == null)
							project.setDescription("");
						if (project.getStyle() == null)
							project.setStyle("");
					%>
					<tr>
						<td width=70>项目名称</td>
						<td><input type="text" name="title"
							value="<%=project.getTitle()%>"></td>
					</tr>
					<tr>
						<td>用户</td>
						<td><input type="text" name="username" readonly="readonly"
							value="<%=project.getUsername()%>"></td>
					</tr>
					<tr>
						<td>设计师</td>
						<td><input type="text" name="designername"
							readonly="readonly" value="<%=project.getDesignername()%>"></td>
					</tr>
					<tr>
						<td>时间</td>
						<td><input type="text" name="time"
							value="<%=project.getTime()%>"></td>
					</tr>
					<tr>
						<td>状态</td>
						<td><select name="state">
								<option value=-1 <%if (project.getState() == -1) {%> selected
									<%}%>>已取消</option>
								<option value=0 <%if (project.getState() == 0) {%> selected
									<%}%>>待设计</option>
								<option value=1 <%if (project.getState() == 1) {%> selected
									<%}%>>设计中</option>
								<option value=2 <%if (project.getState() == 2) {%> selected
									<%}%>>已完成</option>
						</select></td>
					</tr>
					<tr>
						<td>风格</td>
						<td><input type="text" name="style"
							value="<%=project.getStyle()%>"></td>
					</tr>
					<tr>
						<td>项目描述</td>
						<td><textarea name="description"><%=project.getDescription()%></textarea>
					</tr>
					<table>
						<tr>
							<%
								if (project.getImageUrls() != null) {
									ArrayList<String> list = project.getImageUrls();
									for (int i = 0; i < list.size(); i++) {
										if (i % 4 == 0) {
							%>
						
						<tr />
						<tr>
							<%
								}
							%>
							<td><img src="<%=Login.url + list.get(i)%>" width="150"
								height="150"></td>
							<%
								}
								}
							%>
						</tr>
					</table>
					<tr></tr>
					<tr>
						<td colSpan=2 align=center><input type="hidden" name="workId"
							value="<%=project.getWorkId()%>"><input type="submit"
							<%if (flag.equals("projects")) {%>
							onclick="if (confirm('确定要提交修改吗？')) return true; else return false;"
							value="修改" <%} else {%>
							onclick="if (confirm('确定要添加吗？')) return true; else return false;"
							value="添加" <%}%>></td>
					</tr>
				</table>
			</form>
	</center>
</BODY>
</HTML>