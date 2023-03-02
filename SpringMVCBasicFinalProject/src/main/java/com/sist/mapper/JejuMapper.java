package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.JejuFoodVO;
import com.sist.vo.JejuLocationVO;
public interface JejuMapper {
	//목록 (여행지)
	@Select("SELECT no,title,poster,price,num "
			+"FROM (SELECT no,title,poster,price,rownum as num "
			+"FROM (SELECT no,title,poster,price "
			+"FROM jejulocation ORDER BY no ASC)) "
			+"WHERE num BETWEEN #{start} AND #{end}")
	public List<JejuLocationVO> jejuLocationListData(Map map);
	
	@Select("SELECT CEIL(count(*)/20.0) FROM jejulocation")
	public int jejuTotalPage();
	
	@Select("SELECT * FROM jejulocation WHERE no=#{no}")
	public JejuLocationVO jejuDetailData(int no);
	
	@Select("SELECT no,title,poster,score,type "
			+"FROM jejufood "
			+"WHERE rownum<=4 AND addr2 LIKE '%'||#{addr}||'%'")
	public List<JejuFoodVO> jejuFoodData(Map map);
	
}
