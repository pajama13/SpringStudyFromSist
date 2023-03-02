package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sist.mapper.*;
import com.sist.vo.JejuFoodVO;
import com.sist.vo.JejuLocationVO;

@Repository
public class JejuDAO {
	@Autowired
	private JejuMapper mapper;
	
	/*
	//목록 (여행지)
	@Select("SELECT no,title,poster,num "
			+"FROM SELECT no,title,poster,rownum as num "
			+"FROM (SELECT no,title,poster "
			+"FROM jejulocation ORDER BY no ASC)) "
			+"WHERE num BETWEEN #{start} AND #{end}")
	*/		
	public List<JejuLocationVO> jejuLocationListData(Map map)
	{
		return mapper.jejuLocationListData(map);
	}
	
	/*
	@Select("SELECT CEIL(count(*)/20.0) FROM jejulocation")
	*/
	public int jejuTotalPage()
	{
		return mapper.jejuTotalPage();
	}
	
	/*
	@Select("SELECT * FROM jejulocation WHERE no=#{no}")
	public JejuLocationVO jejuDetailData(int no);
	*/
	public JejuLocationVO jejuDetailData(int no)
	{
		return mapper.jejuDetailData(no);
	}
	/*
	@Select("SELECT no,title,poster,score,type "
			+"FROM jejufood "
			+"WHERE rownum<=4 AND addr LIKE '%'||#{addr}||'%'")
	public List<JejuFoodVO> jejuFoodData(Map map);
	*/
	public List<JejuFoodVO> jejuFoodData(Map map)
	{
		return mapper.jejuFoodData(map);
	}
}
