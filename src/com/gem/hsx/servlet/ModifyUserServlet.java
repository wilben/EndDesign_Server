package com.gem.hsx.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gem.hsx.bean.User;
import com.gem.hsx.daoimpl.UserDaoImpl;

/**
 * Servlet implementation class AdduserServlet
 */
@WebServlet("/ModifyUserServlet")
public class ModifyUserServlet extends HttpServlet {
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
		User user = new User();
		user.setUsername(request.getParameter("username"));
		user.setSex(request.getParameter("sex"));
		user.setAge(request.getParameter("age"));
		user.setAvatar(request.getParameter("avatar"));
		user.setRealname(request.getParameter("realname"));
		user.setRole(Integer.parseInt(request.getParameter("role")));
		user.setStyle(request.getParameter("style"));
		if (new UserDaoImpl().modifyuser(user)) {
			session.setAttribute("result", "修改成功");
		} else {
			session.setAttribute("result", "修改失败");
		}
		response.sendRedirect("result.jsp");
	}
}