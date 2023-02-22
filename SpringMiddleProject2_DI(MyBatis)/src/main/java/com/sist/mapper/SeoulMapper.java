package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.dao.SeoulVO;

public interface SeoulMapper {
	//<select> 대신 @Select 사용 => xml 불필요
	@Select("SELECT no,title,msg,address FROM ${seoul_tbl}")
	public List<SeoulVO> seoulListData(Map map);
	
	@Select("SELECT no,title,msg,address FROM ${seoul_tbl} WHERE no=#{no}")
	public SeoulVO seoulDetailData(Map map);
	
}
