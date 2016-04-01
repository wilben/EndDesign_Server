package com.gem.hsx.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.fileupload.FileItem;

public class FileInOutput {

	public String imagePath = "http://192.168.1.111:8080/Login/images/";
	String filename;

	public String upLoadFile(List<FileItem> items, String filedir) {

		try {

			if (items != null && !items.isEmpty()) {

				for (FileItem fileItem : items) {
					filename = fileItem.getName();
					String filepath = filedir + File.separator + filename;
					String savepath = filepath.replaceAll("\\\\", "/");
					System.out.println(filepath.replaceAll("\\\\", "/"));
					System.out.println("文件保存路径为:" + savepath);
					// 文件路径
					File file = new File(filepath);
					InputStream inputSteam = fileItem.getInputStream();
					BufferedInputStream fis = new BufferedInputStream(
							inputSteam);
					FileOutputStream fos = new FileOutputStream(file);
					int f;
					while ((f = fis.read()) != -1) {
						fos.write(f);
					}
					fos.flush();
					fos.close();
					fis.close();
					inputSteam.close();
				}

			}
			return imagePath + filename;
		} catch (Exception e) {
			e.printStackTrace();
			return "-1";
		}

	}

}
