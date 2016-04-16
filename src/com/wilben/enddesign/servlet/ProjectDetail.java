package com.wilben.enddesign.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import com.wilben.enddesign.bean.Project;
import com.wilben.enddesign.daoimpl.UserDaoImpl;

/**
 * 查询作品详情
 * 
 * @author wilben
 * 
 */
@WebServlet("/ProjectDetail")
public class ProjectDetail extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ProjectDetail() {
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
		String workId = null;
		String state = null;
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
				workId = jsonObject.getString("workId");
				state = jsonObject.getString("state");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			UserDaoImpl userDaoImpl = new UserDaoImpl();
			Project project = userDaoImpl.getProjectDetail(
					Integer.parseInt(workId), Integer.parseInt(state));
			JSONObject jsonObject = new JSONObject();
			try {
				jsonObject.put("workdetail", project);
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
