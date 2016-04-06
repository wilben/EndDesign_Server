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

import com.gem.hsx.daoimpl.UserDaoImpl;

public class Project extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public Project() {
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
		String username = null;
		String position = null;
		String role = null;
		List<com.gem.hsx.bean.Project> projectList;
		int state = -1;
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
				username = jsonObject.getString("username");
				position = jsonObject.getString("position");
				role = jsonObject.getString("role");
				switch (Integer.parseInt(position)) {
				case 0:
					state = 3;
					break;
				case 1:
					state = 0;
					break;
				case 2:
					state = 1;
					break;
				case 3:
					state = 2;
					break;
				default:
					break;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			UserDaoImpl userDaoImpl = new UserDaoImpl();
			projectList = userDaoImpl.getProjects(username, state, role);
			JSONObject jsonObject = new JSONObject();
			try {
				jsonObject.put("projects", projectList);
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
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
