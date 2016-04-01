/**
 * 
 */
/**
 * @author wilben
 *
 */
package com.gem.hsx.utils;

import java.util.ArrayList;
import java.util.List;

import com.gem.hsx.bean.Designer;
import com.gem.hsx.bean.ItemEntity;

public class HeaderNewsService {
	private List<ItemEntity> HeaderNews = new ArrayList<ItemEntity>();
	private ArrayList<String> imageList = new ArrayList<String>();

	public List<ItemEntity> getHeaderNews() {

		imageList.add("http://192.168.1.111:8080/Login/images/1.jpg");
		imageList.add("http://192.168.1.111:8080/Login/images/2.jpg");
		imageList.add("http://192.168.1.111:8080/Login/images/3.jpg");
		imageList.add("http://192.168.1.111:8080/Login/images/4.jpg");
		imageList.add("http://192.168.1.111:8080/Login/images/5.jpg");
		imageList.add("http://192.168.1.111:8080/Login/images/6.jpg");
		imageList.add("http://192.168.1.111:8080/Login/images/7.jpg");
		imageList.add("http://192.168.1.111:8080/Login/images/8.jpg");
		imageList.add("http://192.168.1.111:8080/Login/images/9.jpg");

		HeaderNews.add(new ItemEntity(
				"http://192.168.1.111:8080/Login/images/a.jpg", "Ross",
				"三室一厅装修设计图之现代简约风格", imageList));
		HeaderNews.add(new ItemEntity(
				"http://192.168.1.111:8080/Login/images/b.jpg", "Julie",
				"三室一厅装修设计图之现代简约风格", imageList));
		HeaderNews.add(new ItemEntity(
				"http://192.168.1.111:8080/Login/images/c.jpg", "Gary",
				"三室一厅装修设计图之现代简约风格", imageList));
		HeaderNews.add(new ItemEntity(
				"http://192.168.1.111:8080/Login/images/d.jpg", "Jack",
				"三室一厅装修设计图之现代简约风格", imageList));
		HeaderNews.add(new ItemEntity(
				"http://192.168.1.111:8080/Login/images/e.jpg", "Lee",
				"三室一厅装修设计图之现代简约风格", imageList));
		HeaderNews.add(new ItemEntity(
				"http://192.168.1.111:8080/Login/images/f.jpg", "Paul",
				"三室一厅装修设计图之现代简约风格", imageList));
		return HeaderNews;
	}

	public List<Designer> getDesigner() {
		HeaderNews.add(new ItemEntity(
				"http://192.168.1.111:8080/Login/images/a.jpg", "Ross",
				"设计作品:102张", null));
		HeaderNews.add(new ItemEntity(
				"http://192.168.1.111:8080/Login/images/b.jpg", "Julie",
				"设计作品:10张", null));
		HeaderNews.add(new ItemEntity(
				"http://192.168.1.111:8080/Login/images/c.jpg", "Gary",
				"设计作品:24张", null));
		HeaderNews.add(new ItemEntity(
				"http://192.168.1.111:8080/Login/images/d.jpg", "Jack",
				"设计作品:79张", null));
		HeaderNews.add(new ItemEntity(
				"http://192.168.1.111:8080/Login/images/e.jpg", "Lee",
				"设计作品:294张", null));
		HeaderNews.add(new ItemEntity(
				"http://192.168.1.111:8080/Login/images/f.jpg", "Paul",
				"设计作品:43张", null));
		return null;
	}
}
