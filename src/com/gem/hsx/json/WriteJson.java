package com.gem.hsx.json;

import java.util.List;

import com.google.gson.Gson;
/**
 * 转为Json
 * @author wilben
 *
 */
public class WriteJson {
	public String getJsonData(List<?> list)
	{
		Gson gson=new Gson();
		String jsonstring=gson.toJson(list);
		return jsonstring;
	}
	
	
	
	
}
