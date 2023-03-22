package com.sist.recommend;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.*;
/*
	{items:[{},{},{}...}
*/
@Component
public class FoodRecommendManager {

	
	public List<String> jsonParser(String json)
	{
		List<String> list=new ArrayList<String>();
		try
		{
			JSONParser jp=new JSONParser();
			JSONObject root=(JSONObject)jp.parse(json); //파싱된 데이터 넣기
			JSONArray arr=(JSONArray)root.get("items"); //추천한 내용 받기
			for(int i=0;i<arr.size();i++)
			{
				JSONObject obj=(JSONObject)arr.get(i);
				String desc=(String)obj.get("description");
				list.add(desc);
			}
		}catch(Exception ex) {ex.printStackTrace();}
		return list;
	}
}
