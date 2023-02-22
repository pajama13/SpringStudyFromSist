package com.sist.mapper;

import org.apache.ibatis.annotations.Select;
import java.util.*;
import com.sist.vo.*;
/*
	private String title,addr,price;
*/
public interface LocationMapper {
	@Select("SELECT title,addr,price,rownum FROM jejulocation WHERE rownum<=30 ")
	public List<JejuLocationVO> locationListData();
}
