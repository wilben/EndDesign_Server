package com.wilben.enddesign.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wilben.enddesign.daoimpl.UserDaoImpl;

/**
 * 删除用户
 * 
 * @author wilben
 * 
 */
@WebServlet("/DeleteInfoServlet")
public class DeteleInfoServlet extends HttpServlet {
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
		if (new UserDaoImpl().deleteInfo(username, role)) {
			request.getSession().setAttribute("result", "删除成功");
		} else {
			request.getSession().setAttribute("result", "删除失败");
		}
		response.sendRedirect("result.jsp");
	}
}