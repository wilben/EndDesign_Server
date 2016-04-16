package com.wilben.enddesign.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wilben.enddesign.bean.Project;
import com.wilben.enddesign.daoimpl.UserDaoImpl;

/**
 * 修改项目信息
 * 
 * @author wilben
 * 
 */
@WebServlet("/ModifyProjectServlet")
public class ModifyProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		Project project = new Project();
		project.setWorkId(Integer.parseInt(request.getParameter("workId")));
		project.setTitle(request.getParameter("title"));
		project.setUsername(request.getParameter("username"));
		project.setDesignername(request.getParameter("designername"));
		project.setTime(request.getParameter("time"));
		project.setStyle(request.getParameter("style"));
		project.setDescription(request.getParameter("description"));
		project.setState(Integer.parseInt(request.getParameter("state")));

		if (new UserDaoImpl().modifyProject(project)) {
			session.setAttribute("result", "修改成功");
		} else {
			session.setAttribute("result", "修改失败");
		}
		response.sendRedirect("result.jsp");
	}
}