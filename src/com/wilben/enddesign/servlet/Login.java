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

import net.sf.json.JSONObject;

import com.wilben.enddesign.daoimpl.UserDaoImpl;

/**
 * 登录
 * 
 * @author wilben
 * 
 */
@WebServlet("/Login")
@SuppressWarnings("serial")
public class Login extends HttpServlet {

	public static String url = "http://127.0.0.1:8080/EndDesign/";

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
		String username = null;
		String password = null;
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
				password = jsonObject.getString("password");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			UserDaoImpl userDaoImpl = new UserDaoImpl();
			int b = userDaoImpl.login(username, password);
			out.write(String.valueOf(b));
			out.flush();
			out.close();
		}

	}
}
