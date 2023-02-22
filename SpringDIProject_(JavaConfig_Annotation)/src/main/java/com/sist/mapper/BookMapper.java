package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;

public interface BookMapper {
	@Select("SELECT no,price,condition,publisher,author,title,rownum "
			+"FROM (SELECT no,price,condition,publisher,author,title,type FROM used_book_3 ORDER BY no ASC) "
			+"WHERE type=#{type}")
	public List<BookVO> bookCategoryListData(String type);
	
	@Select("SELECT DISTINCT type FROM used_book_3")
	public List<String> bookCategory();
}
