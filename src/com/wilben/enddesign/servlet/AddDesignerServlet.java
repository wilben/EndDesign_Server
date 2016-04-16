package com.wilben.enddesign.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wilben.enddesign.bean.Designer;
import com.wilben.enddesign.daoimpl.UserDaoImpl;

/**
 * 添加设计师
 * @author wilben
 *
 */
@WebServlet("/AddDesignerServlet")
public class AddDesignerServlet extends HttpServlet {
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
		String sex = request.getParameter("sex");
		String age = request.getParameter("age");
		String realname = request.getParameter("realname");
		Designer designer = new Designer();
		HttpSession session = request.getSession();
		if (!new UserDaoImpl().check(username)) {
			designer.setUsername(username);
			designer.setPassword("000000");
			designer.setSex(sex);
			designer.setAge(age);
			designer.setRealname(realname);
			designer.setRole(1);
			if (new UserDaoImpl().register(designer)) {
				session.setAttribute("result", "添加成功");
			} else {
				session.setAttribute("result", "添加失败");
			}
			response.sendRedirect("result.jsp");
		}else{
			session.setAttribute("result", "用户名已存在");
			response.sendRedirect("addDesigner.jsp");
		}
	}
}