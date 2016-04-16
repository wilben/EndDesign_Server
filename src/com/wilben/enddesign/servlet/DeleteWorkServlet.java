package com.wilben.enddesign.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wilben.enddesign.daoimpl.UserDaoImpl;

/**
 * 删除经典案例
 * 
 * @author wilben
 * 
 */
@WebServlet("/DeleteWorkServlet")
public class DeleteWorkServlet extends HttpServlet {
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

		if (new UserDaoImpl().deleteWork(workId)) {
			session.setAttribute("result", "删除成功");
		} else {
			session.setAttribute("result", "删除失败");
		}
		response.sendRedirect("result.jsp");
	}
}