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
 * 修改作品信息
 * 
 * @author wilben
 * 
 */
@WebServlet("/ModifyWorkServlet")
public class ModifyWorkServlet extends HttpServlet {
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

		if (new UserDaoImpl().modifyWork(workId, description)) {
			session.setAttribute("result", "修改成功");
		} else {
			session.setAttribute("result", "修改失败");
		}
		response.sendRedirect("result.jsp");
	}
}