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

import net.sf.json.JSONObject;

import com.gem.hsx.bean.User;
import com.gem.hsx.daoimpl.UserDaoImpl;
import com.gem.hsx.json.JsonUtil;

@SuppressWarnings("serial")
public class SaveInfo extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		StringBuffer jString = new StringBuffer();
		String line = null;
		String jsondata = null;
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
				jsondata = jsonObject.getString("jsonstring");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			JsonUtil jsonUtil = new JsonUtil();
			System.out.println(jsondata);
			List<User> list = jsonUtil.StringFromJson(jsondata);
			User user = list.get(0);
			UserDaoImpl userDaoImpl = new UserDaoImpl();
			boolean b = userDaoImpl.saveInfo(user);
			if (b) {
				out.write("t");
			} else {
				out.write("f");
			}
			out.flush();
			out.close();

		}

	}
}
