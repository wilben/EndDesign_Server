package com.gem.hsx.json;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.gem.hsx.bean.Designer;
import com.gem.hsx.bean.Project;
import com.gem.hsx.bean.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JsonUtil {
	public List<User> StringFromJson(String jsondata) {
		Type listType = new TypeToken<List<User>>() {
		}.getType();
		Gson gson = new Gson();
		ArrayList<User> list = gson.fromJson(jsondata, listType);
		return list;

	}

	public List<Project> FromJson(String jsondata) {
		Type listType = new TypeToken<List<Project>>() {
		}.getType();
		Gson gson = new Gson();
		ArrayList<Project> list = gson.fromJson(jsondata, listType);
		return list;

	}
	public List<Designer> FromJson1(String jsondata) {
		Type listType = new TypeToken<List<Designer>>() {
		}.getType();
		Gson gson = new Gson();
		ArrayList<Designer> list = gson.fromJson(jsondata, listType);
		return list;

	}
}
