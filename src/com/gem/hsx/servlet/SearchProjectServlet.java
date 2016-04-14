package com.gem.hsx.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gem.hsx.daoimpl.UserDaoImpl;

/**
 * Servlet implementation class AllDesignerServlet
 */
@WebServlet("/SearchProjectServlet")
public class SearchProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	private String cur, totalPage, content1, content2;
	private int totalRecord;
	private int DATA_PER_PAGE = 15;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		if (request.getParameter("cur") != null) {
			cur = request.getParameter("cur");
			content1 = (String) request.getSession().getAttribute("content1");
			content2 = (String) request.getSession().getAttribute("content2");
		} else {
			cur = "1";
			content1 = request.getParameter("content1");
			content2 = request.getParameter("content2");
		}
		request.getSession().setAttribute("cur", cur);
		if (content1.equals("项目名称/用户/设计师")) {
			content1 = "";
		}
		if (content2.equals("项目状态")) {
			content2 = "";
		}
		request.getSession().setAttribute("content1", content1);
		request.getSession().setAttribute("content2", content2);
		totalRecord = new UserDaoImpl().getTotalRecord(content1, content2);
		if (totalRecord % DATA_PER_PAGE == 0) {
			totalPage = String.valueOf(totalRecord / DATA_PER_PAGE);
		} else {
			totalPage = String.valueOf(totalRecord / DATA_PER_PAGE + 1);
		}
		request.getSession().setAttribute("totalPage", totalPage);
		request.getSession().setAttribute(
				"projects",
				new UserDaoImpl().selectAllProject(content1, content2,
						Integer.parseInt(cur), DATA_PER_PAGE));
		response.sendRedirect("searchProjects.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
