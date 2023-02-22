package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;

public interface SeoulMapper {
	@Select("SELECT no,title,address FROM ${seoul_tbl}") //map의 키값 => ${}값
	public List<SeoulVO> seoulListData(Map map); //map의 키값
	
}
