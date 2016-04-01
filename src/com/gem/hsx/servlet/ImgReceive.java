package com.gem.hsx.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@SuppressWarnings("serial")
public class ImgReceive extends HttpServlet
{
	@SuppressWarnings("unchecked")
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
			{
		String str=UUID.randomUUID().toString();
		try
		{
			request.setCharacterEncoding("UTF-8"); // ���ô����������ı����ʽ
			response.setContentType("text/html;charset=UTF-8"); // ����Content-Type�ֶ�ֵ
			PrintWriter out = response.getWriter();
			// ����Ĵ��뿪ʼʹ��Commons-UploadFile��������ϴ����ļ����
			FileItemFactory factory = new DiskFileItemFactory(); // ��bFileItemFactory����
			ServletFileUpload upload = new ServletFileUpload(factory);
			// �������󣬲��õ��ϴ��ļ���FileItem����
			List<FileItem> items = upload.parseRequest(request);
			// ��web.xml�ļ��еĲ����еõ��ϴ��ļ���·��
			String uploadPath = "f:\\upload\\";
			File file = new File(uploadPath);
			if (!file.exists())
			{
				file.mkdir();
			}
			String filename = ""; // �ϴ��ļ����浽��������ļ���
			InputStream is = null; // ��ǰ�ϴ��ļ���InputStream����
			// ѭ�������ϴ��ļ�
			for (FileItem item : items)
			{
				// ������ͨ�ı?��
				if (item.isFormField())
				{
					if (item.getFieldName().equals("filename"))
					{
						// ������ļ���Ϊ�գ����䱣����filename��
						if (!item.getString().equals(""))
							filename = item.getString("UTF-8");
					}
				}
				// �����ϴ��ļ�
				else if (item.getName() != null && !item.getName().equals(""))
				{
					// �ӿͻ��˷��͹�4���ϴ��ļ�·���н�ȡ�ļ���
					filename = item.getName().substring(
							item.getName().lastIndexOf("\\")+1);
					is = item.getInputStream(); // �õ��ϴ��ļ���InputStream����
				}
			}
			// ��·�����ϴ��ļ�����ϳ�����ķ����·��
			StringBuffer buffername=new StringBuffer();
			buffername.append(str);
			buffername.append(filename);
			filename = uploadPath + buffername.toString();
			System.out.println(filename);
			// ���������Ѿ����ں��ϴ��ļ�ͬ����ļ����������ʾ��Ϣ
			if (new File(filename).exists())
			{
				new File(filename).delete();
			}
			// ��ʼ�ϴ��ļ�
			if (!filename.equals(""))
			{
				// ��FileOutputStream�򿪷���˵��ϴ��ļ�
				FileOutputStream fos = new FileOutputStream(filename);
				byte[] buffer = new byte[8192]; // ÿ�ζ�8K�ֽ�
				int count = 0;
				// ��ʼ��ȡ�ϴ��ļ����ֽڣ�������������˵��ϴ��ļ��������
				while ((count = is.read(buffer)) > 0)
				{
					fos.write(buffer, 0, count); // �������ļ�д���ֽ���

				}
				fos.close(); // �ر�FileOutputStream����
				is.close(); // InputStream����
				out.write(filename);
				out.flush();
				out.close();
			}
		}
		catch (Exception e)
		{

		}
			}


}