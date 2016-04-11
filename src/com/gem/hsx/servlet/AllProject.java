package com.gem.hsx.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import com.gem.hsx.daoimpl.UserDaoImpl;
/**
 * 查询所有经典案例
 * @author wilben
 *
 */
public class AllProject extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public AllProject() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; Charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		List<com.gem.hsx.bean.Project> caseList = userDaoImpl.selectAllCase();
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("allproject", caseList);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String jsonString = jsonObject.toString();
		out.print(jsonString);
		out.flush();
		out.close();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
