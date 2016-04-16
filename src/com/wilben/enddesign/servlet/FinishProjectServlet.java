package com.wilben.enddesign.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wilben.enddesign.daoimpl.UserDaoImpl;

/**
 * 查询所有已完成非经典案例项目
 * 
 * @author wilben
 * 
 */
@WebServlet("/FinishProjectServlet")
public class FinishProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	private String cur, totalPage;
	private int totalRecord;
	private int DATA_PER_PAGE = 15;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		if (request.getParameter("cur") != null) {
			cur = request.getParameter("cur");
		} else {
			cur = "1";
		}
		request.getSession().setAttribute("cur", cur);
		totalRecord = new UserDaoImpl().getTotalRecord(2);
		if (totalRecord % DATA_PER_PAGE == 0) {
			totalPage = String.valueOf(totalRecord / DATA_PER_PAGE);
		} else {
			totalPage = String.valueOf(totalRecord / DATA_PER_PAGE + 1);
		}
		request.getSession().setAttribute("totalPage", totalPage);
		request.getSession().setAttribute(
				"finishProjects",
				new UserDaoImpl().selectAllProject(2, Integer.parseInt(cur),
						DATA_PER_PAGE));
		response.sendRedirect("finishProjects.jsp");
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
