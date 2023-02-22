package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.dao.*;

public interface FoodMapper {
	@Select("SELECT cno,title,poster,subject "
			+"FROM project_category "
			+"WHERE cno BETWEEN #{start} AND #{end}")
	public List<CategoryVO> categoryListData(Map map);  //=> start, end 매개변수 2개 => VO 변수 아님 => map으로 받기
	
	@Select("SELECT fno,name,poster,address,tel,type,score "
			+"FROM project_food "
			+"WHERE cno=#{cno}")
	public List<FoodVO> foodListData(int cno);
	
	@Select("SELECT title,subject FROM project_category "
			+"WHERE cno=#{cno}")
	public CategoryVO categoryInfoData(int cno);
}
