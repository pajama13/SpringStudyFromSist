package com.sist.mapper;

import org.apache.ibatis.annotations.Select;
import com.sist.dao.*;
import java.util.*;

public interface RecipeMapper {
	@Select("SELECT title,chef,poster,rownum "
			+"FROM recipe "
			+"WHERE rownum<=40 AND REGEXP_LIKE(title,#{menu})")
	public List<RecipeVO> recipeFindData(String menu);
}
