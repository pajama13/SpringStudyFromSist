package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.FoodVO;
import com.sist.vo.SeoulVO;
import com.sist.mapper.*;

@Repository
public class SeoulDAO {
	@Autowired
	private SeoulMapper mapper;
	/*
	@Select("SELECT no,title,poster,num "
			+"FROM (SELECT no,title,poster,rownum as num "
			+"FROM (SELECT no,title,poster "
			+"FROM seoul_location ORDER BY no ASC)) "
			+"WHERE num BETWEEN #{start} AND #{end}")
	public List<SeoulVO> seoulListData(Map map);
	*/
	public List<SeoulVO> seoulListData(Map map)
	{
		return mapper.seoulListData(map);
	}
	
	/*
	//총페이지
	@Select("SELECT CEIL(count(*)/20.0) FROM seoul_location")
	public int seoulTotalPage();
	*/
	public int seoulTotalPage()
	{
		return mapper.seoulTotalPage();
	}
	
	/*
	//상세보기
	@Select("SELECT no,title,poster,address,msg FROM seoul_location "
			+"WHERE no=#{no}")
	public SeoulVO seoulDetailData(int no);
	*/
	public SeoulVO seoulDetailData(int no)
	{
		return mapper.seoulDetailData(no);
	}
	
	/*
	//근처맛집
	@Select("SELECT fno,name,poster FROM project_food "
			+ "WHERE address LIKE '%'||#{addr}||'%'")
	public List<FoodVO> nearbyFoodData(String addr);
	*/
	public List<FoodVO> nearbyFoodData(Map map)
	{
		return mapper.nearbyFoodData(map);
	}
}
