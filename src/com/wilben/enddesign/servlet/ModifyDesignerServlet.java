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
 * 修改设计师信息
 * 
 * @author wilben
 * 
 */
@WebServlet("/ModifyDesignerServlet")
public class ModifyDesignerServlet extends HttpServlet {
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
		Designer designer = new Designer();
		designer.setUsername(request.getParameter("username"));
		designer.setSex(request.getParameter("sex"));
		designer.setAge(request.getParameter("age"));
		designer.setRealname(request.getParameter("realname"));
		designer.setRole(Integer.parseInt(request.getParameter("role")));
		designer.setStyle(request.getParameter("style"));
		designer.setConcept(request.getParameter("concept"));
		designer.setMotto(request.getParameter("motto"));
		designer.setWork(request.getParameter("work"));
		designer.setPeriod(request.getParameter("period"));
		designer.setArea(request.getParameter("area"));
		if (new UserDaoImpl().modifyDesigner(designer)) {
			session.setAttribute("result", "修改成功");
		} else {
			session.setAttribute("result", "修改失败");
		}
		response.sendRedirect("result.jsp");
	}
}