package com.gem.hsx.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.gem.hsx.daoimpl.UserDaoImpl;

@SuppressWarnings("serial")
public class ChangeState extends HttpServlet {

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
			String result = userDaoImpl.changeState(Integer.parseInt(workId),
					Integer.parseInt(state));
			out.write(result);
			out.flush();
			out.close();
		}

	}
}
