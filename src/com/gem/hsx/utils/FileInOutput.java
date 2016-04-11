package com.gem.hsx.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.fileupload.FileItem;

public class FileInOutput {

	String filename;//图片名
/**
 * 上传图片
 * @param items 图片实体
 * @param filedir 存储路径
 * @return
 */

	public String upLoadFile(List<FileItem> items, String filedir) {

		try {

			if (items != null && !items.isEmpty()) {

				for (FileItem fileItem : items) {
					filename = fileItem.getName();
					String filepath = filedir + File.separator + filename;
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
			return "images/"+filename;
		} catch (Exception e) {
			e.printStackTrace();
			return "-1";
		}

	}

}
