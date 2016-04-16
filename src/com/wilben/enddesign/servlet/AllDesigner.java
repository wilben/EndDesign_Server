package com.wilben.enddesign.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import com.wilben.enddesign.bean.Designer;
import com.wilben.enddesign.daoimpl.UserDaoImpl;

/**
 * 查询所有设计师
 * 
 * @author wilben
 * 
 */
@WebServlet("/AllDesigner")
public class AllDesigner extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public AllDesigner() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; Charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		List<Designer> designerList = userDaoImpl.selectAllDesigner();
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("allDesigner", designerList);
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
