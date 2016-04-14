package com.gem.hsx.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gem.hsx.bean.Project;
import com.gem.hsx.daoimpl.UserDaoImpl;

/**
 * Servlet implementation class AddDesignerServlet
 */
@WebServlet("/SelectProjectServlet")
public class SelectProjectServlet extends HttpServlet {
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
		int workId = Integer.parseInt(request.getParameter("workId"));
		int state = Integer.parseInt(request.getParameter("state"));
		Project project = new UserDaoImpl().getWorkDetail(workId, state);
		request.getSession().setAttribute("project", project);
		response.sendRedirect("project.jsp");
	}
}