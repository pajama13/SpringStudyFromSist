package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.dao.*;


public interface SeoulMapper {
	@Select("SELECT no,title,poster,num "
			+"FROM (SELECT no,title,poster,rownum as num "
			+"FROM (SELECT no,title,poster "
			+"FROM seoul_location ORDER BY no ASC)) "
			+"WHERE num BETWEEN #{start} AND #{end}")
	
	public List<SeoulVO> seoulListData(Map map);
	
	@Select("SELECT CEIL(count(*)/20.0) FROM seoul_location")
	public int seoulTotalPage();
}
