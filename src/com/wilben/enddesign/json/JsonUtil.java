package com.wilben.enddesign.json;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wilben.enddesign.bean.Designer;
import com.wilben.enddesign.bean.Project;
import com.wilben.enddesign.bean.User;
/**
 * 转换Json
 * @author wilben
 *
 */
public class JsonUtil {
	/**
	 * 转为User
	 * @param jsondata 
	 * @return
	 */
	public List<User> StringFromJson(String jsondata) {
		Type listType = new TypeToken<List<User>>() {
		}.getType();
		Gson gson = new Gson();
		ArrayList<User> list = gson.fromJson(jsondata, listType);
		return list;

	}
	
	/**
	 * 转为Project
	 * @param jsondata 
	 * @return
	 */
	public List<Project> FromJson(String jsondata) {
		Type listType = new TypeToken<List<Project>>() {
		}.getType();
		Gson gson = new Gson();
		ArrayList<Project> list = gson.fromJson(jsondata, listType);
		return list;

	}
	/**
	 * 转为Designer
	 * @param jsondata
	 * @return
	 */
	public List<Designer> FromJson1(String jsondata) {
		Type listType = new TypeToken<List<Designer>>() {
		}.getType();
		Gson gson = new Gson();
		ArrayList<Designer> list = gson.fromJson(jsondata, listType);
		return list;

	}
}
