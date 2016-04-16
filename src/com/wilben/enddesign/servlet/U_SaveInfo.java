package com.wilben.enddesign.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.wilben.enddesign.bean.User;
import com.wilben.enddesign.daoimpl.UserDaoImpl;
import com.wilben.enddesign.json.JsonUtil;

/**
 * 修改用户个人信息
 * 
 * @author wilben
 * 
 */
@WebServlet("/U_SaveInfo")
@SuppressWarnings("serial")
public class U_SaveInfo extends HttpServlet {

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
			List<User> list = jsonUtil.StringFromJson(jsondata);
			User user = list.get(0);
			UserDaoImpl userDaoImpl = new UserDaoImpl();
			boolean b = userDaoImpl.saveU_Info(user);
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
