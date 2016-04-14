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
<LINK href="css/admin.css" type="text/css" rel="stylesheet">
<style type="text/css">
.errorMessage {
	font-size: 12px;
	color: red;
}
</style>
</HEAD>
<BODY>

	<TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%"
		bgColor=#002779 border=0>
		<TR>
			<TD align=middle>
				<TABLE cellSpacing=0 cellPadding=0 width=468 border=0>
					<TR>
						<TD><IMG height=23 src="images/login_1.jpg" width=468></TD>
					</TR>
					<TR>
						<TD><IMG height=147 src="images/login_2.jpg" width=468></TD>
					</TR>
				</TABLE>
				<TABLE cellSpacing=0 cellPadding=0 width=468 bgColor=#ffffff
					border=0>
					<TR>
						<TD width=16><IMG height=122 src="images/login_3.jpg"
							width=16></TD>
						<TD align=middle>
							<FORM action="LoginServlet" method="post">
								<TABLE cellSpacing=0 cellPadding=0 width=230 border=0>
									<TR height=5>
										<TD width=5></TD>
										<TD width=56></TD>
										<TD></TD>
									</TR>
									<TR height=36>
										<TD></TD>
										<TD>用户名</TD>
										<TD><INPUT type="text"
											style="BORDER-RIGHT: #000000 1px solid; BORDER-TOP: #000000 1px solid; BORDER-LEFT: #000000 1px solid; BORDER-BOTTOM: #000000 1px solid"
											maxLength=30 size=24 name="username"></TD>
									</TR>
									<TR height=36>
										<TD>&nbsp;</TD>
										<TD>密 码</TD>
										<TD><INPUT
											style="BORDER-RIGHT: #000000 1px solid; BORDER-TOP: #000000 1px solid; BORDER-LEFT: #000000 1px solid; BORDER-BOTTOM: #000000 1px solid"
											type=password maxLength=30 size=24 name="password"></TD>
									</TR>
									<TR height=5>
										<TD colSpan=3></TD>
									</TR>
									<TR>
										<TD colSpan=3 align="center"><INPUT type="submit" height=18 
											value="登录"></TD>
									</TR>
								</TABLE>
							</form>
						</TD>
						<TD width=16><IMG height=122 src="images/login_4.jpg"
							width=16></TD>
					</TR>
				</TABLE>
				<TABLE cellSpacing=0 cellPadding=0 width=468 border=0>
					<TR>
						<TD align="center"><IMG height=16 src="images/login_5.jpg"
							width=468></TD>
					</TR>
				</TABLE>
			</TD>
		</TR>
	</TABLE>

</BODY>
</HTML>
