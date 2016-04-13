package com.gem.hsx.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gem.hsx.daoimpl.UserDaoImpl;

/**
 * Servlet implementation class AddDesignerServlet
 */
@WebServlet("/SelectInfoServlet")
public class SelectInfoServlet extends HttpServlet {
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
		String username = request.getParameter("username");
		int role = Integer.parseInt(request.getParameter("role"));
		if (role == 1) {
			request.getSession().setAttribute("designer",
					new UserDaoImpl().getDesignerDetail(username));
			response.sendRedirect("designer.jsp");
		} else {
			request.getSession().setAttribute("user",
					new UserDaoImpl().getU_Info(username));
			response.sendRedirect("user.jsp");
		}
	}
}