package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;

@Repository
public class FoodDAO {
	@Autowired
	private FoodMapper mapper;
	
	/*
	  @Select("SELECT fno,name,poster,num "
				 +"FROM (SELECT fno,name,poster,rownum as num "
				 +"FROM (SELECT fno,name,poster "
				 +"FROM food_location ORDER BY fno ASC)) "
				 +"WHERE num BETWEEN #{start} AND #{end}")
	  public List<FoodVO> foodListData(Map map);
	*/
	public List<FoodVO> foodListData(Map map)
	{
		return mapper.foodListData(map);
	}
}
