package com.sist.mapper;
import java.util.*;
import java.util.Locale.Category;

import com.sist.dao.*;
import com.sist.vo.*;
import org.apache.ibatis.annotations.Select;

public interface FoodMapper {
	//동적쿼리
	@Select({
		"<script>"
		+"SELECT cno,title,poster,subject "
		+"FROM project_category "
		+"WHERE "
		+"<if test='cno==1'>"
		+"cno BETWEEN 1 AND 12"
		+"</if>"
		+"<if test='cno==2'>"
		+"cno BETWEEN 13 AND 18"
		+"</if>"
		+"<if test='cno==3'>"
		+"cno BETWEEN 19 AND 30"
		+"</if>"
		+"</script>"
	})
	public List<CategoryVO> categoryListData(Map map);
	//카테고리 목록 출력
	@Select("SELECT fno,name,poster,address,tel,type,score "
			+"FROM project_food "
			+"WHERE cno=#{cno}")
	public List<FoodVO> foodListData(int cno);
	
	@Select("SELECT title,subject FROM project_category "
			+"WHERE cno=#{cno}")
	public CategoryVO categoryInfoData(int cno);
	
	//상세보기
	@Select("SELECT * FROM project_food "
			+"WHERE fno=#{fno}")
	public FoodVO foodDetailData(int fno);
	
	//검색
	//동적쿼리 => 상황에 따라 다른 쿼리문장 실행 : if, choose, foreach, trim, where, set
	//MyBatis => JOIN, SubQuery, Procedure, Function, Trigger
	@Select({
		"<script>"
		+"SELECT fno,name,poster,num "
		+"FROM (SELECT fno,name,poster,rownum as num "
		+"FROM (SELECT fno,name,poster "
		+"FROM food_location "
		+"<if test=\"ss!='all'\">"
		+"WHERE address LIKE '%'||#{ss}||'%'"
		+"</if>"
		+"ORDER BY fno ASC)) "
		+"WHERE num BETWEEN #{start} AND #{end} "
		+"</script>"
	})
	public List<FoodVO> foodFindData(Map map);
	
}






