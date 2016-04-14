<%@page import="java.net.URLEncoder"%>
<%@page import="com.gem.hsx.bean.Project"%>
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
				style="FONT-WEIGHT: bold; COLOR: black" align=middle>项目列表</TD>
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
		<table>
			<%
				int cur = Integer.parseInt((String) session.getAttribute("cur"));
				int totalPage = Integer.parseInt((String) session
						.getAttribute("totalPage"));
				List<Project> projects = (List) session.getAttribute("projects");
				Iterator iter = projects.iterator();
			%>
			<tr>
				<form action="SearchProjectServlet" method="post">
					<td><input type="text" name="content1" value="项目名称/用户/设计师"
						onFocus="if(value==defaultValue){value='';this.style.color='#000'}"
						onBlur="if(!value){value=defaultValue;this.style.color='#999'}"
						style="color: #999999"></td>
					<td><input type="text" name="content2" value="项目状态"
						onFocus="if(value==defaultValue){value='';this.style.color='#000'}"
						onBlur="if(!value){value=defaultValue;this.style.color='#999'}"
						style="color: #999999"></td>
					<td><input type="submit" value="查询"></td>
				</form>
			</tr>
			<tr></tr>
			<tr></tr>
			<tr>
				<td>时间</td>
				<td>项目名称</td>
				<td>用户</td>
				<td>设计师</td>
				<td>状态</td>
				<td>修改</td>
				<td>取消</td>
			</tr>
			<%
				while (iter.hasNext()) {
					Project project = (Project) iter.next();
			%>
			<tr>
				<td><%=project.getTime()%></td>
				<td><%=project.getTitle()%></td>
				<td><%=project.getUsername()%></td>
				<td><%=project.getDesignername()%></td>
				<td>
					<%
						if (project.getState() == -1) {
					%><%="已取消"%> <%
 	} else if (project.getState() == 0) {
 %><%="待设计"%> <%
 	} else if (project.getState() == 1) {
 %><%="设计中"%> <%
 	} else {
 %><%="已完成"%> <%
 	}
 %>
				</td>

				<td><a
					href="SelectProjectServlet?workId=<%=project.getWorkId()%>&state=<%=project.getState()%>">修改</a></td>
				<td><a
					onclick="if (confirm('确定要取消项目吗？')) return true; else return false;"
					href="CancelProjectServlet?workId=<%=project.getWorkId()%>">取消</a></td>
			</tr>
			<%
				}
			%>
			<tr>
				<td></td>
				<%
					if (cur == 1) {
				%>
				<td><a>首页</a></td>
				<td><a>上一页</a></td>
				<%
					} else if (cur != 1) {
				%>
				<td><a href="SearchProjectServlet?cur=1">首页</a></td>
				<td><a href="SearchProjectServlet?cur=<%=cur - 1%>">上一页</a></td>
				<%
					}
				%>
				<td><%=cur%> / <%=totalPage%></td>
				<%
					if (cur == totalPage) {
				%>
				<td><a>下一页</a></td>
				<td><a>尾页</a></td>
				<%
					} else if (cur != totalPage) {
				%>
				<td><a href="SearchProjectServlet?cur=<%=cur + 1%>">下一页</a></td>
				<td><a href="SearchProjectServlet?cur=<%=totalPage%>">尾页</a></td>
				<%
					}
				%>

				<td></td>
			</tr>
		</table>
	</center>
</BODY>
</HTML>