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

import com.gem.hsx.bean.ItemEntity;
import com.gem.hsx.utils.HeaderNewsService;

public class HeaderNewsJsonServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public HeaderNewsJsonServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HeaderNewsService headerNewsService = new HeaderNewsService();
		response.setContentType("text/html; Charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		List<ItemEntity> headerNews = headerNewsService.getHeaderNews();
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("case", headerNews);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String jsonString = jsonObject.toString();
		System.out.println(jsonString);
		out.print(jsonString);
		out.flush();
		out.close();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
