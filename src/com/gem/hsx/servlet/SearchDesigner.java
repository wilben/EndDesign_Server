package com.gem.hsx.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import com.gem.hsx.bean.Designer;
import com.gem.hsx.daoimpl.UserDaoImpl;
/**
 * 查询设计师
 * @author wilben
 *
 */
public class SearchDesigner extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public SearchDesigner() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; Charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		StringBuffer jString = new StringBuffer();
		String line = null;
		String content = null;
		try {
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null) {
				jString.append(line);
			}
			reader.close();
		} catch (Exception e) {
			// report an error
		}
		String str = URLDecoder.decode(jString.toString(), "utf-8");
		if (str.length() != 0) {
			try {
				JSONObject jsonObject = JSONObject.fromObject(str);
				content = jsonObject.getString("content");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			UserDaoImpl userDaoImpl = new UserDaoImpl();
			List<Designer> designerList = userDaoImpl.searchDesigner(content);
			JSONObject jsonObject = new JSONObject();
			try {
				jsonObject.put("searchDesigner", designerList);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String jsonString = jsonObject.toString();
			out.print(jsonString);
			out.flush();
			out.close();
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
