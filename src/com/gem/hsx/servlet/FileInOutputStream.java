package com.gem.hsx.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.gem.hsx.utils.FileInOutput;

public class FileInOutputStream extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ServletFileUpload upload;
	private final long MAXSize = 4194304 * 2L;// 4*2MB
	private String filedir;
	public ServletContext context;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		context = this.getServletContext();
		FileItemFactory factory = new DiskFileItemFactory();
		this.upload = new ServletFileUpload(factory);
		this.upload.setSizeMax(this.MAXSize);
		filedir = this.getServletContext().getRealPath("/images");

		PrintWriter out = response.getWriter();
		FileInOutput fio = new FileInOutput();

		try {
			@SuppressWarnings("unchecked")
			List<FileItem> items = this.upload.parseRequest(request);

			String url = fio.upLoadFile(items, filedir);
			out.println(url);
			System.out.println(url);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			out.println("-1");
			e.printStackTrace();
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
