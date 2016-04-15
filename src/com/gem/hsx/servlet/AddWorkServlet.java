package com.gem.hsx.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gem.hsx.daoimpl.UserDaoImpl;

/**
 * Servlet implementation class AdduserServlet
 */
@WebServlet("/AddWorkServlet")
public class AddWorkServlet extends HttpServlet {
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
		int workId = Integer.parseInt(request.getParameter("workId"));
		String description = request.getParameter("description");

		if (new UserDaoImpl().addWork(workId, description)) {
			session.setAttribute("result", "添加成功");
		} else {
			session.setAttribute("result", "添加失败");
		}
		response.sendRedirect("result.jsp");
	}
}