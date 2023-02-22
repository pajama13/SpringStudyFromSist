package com.sist.mapper;

import java.util.*;
import com.sist.vo.*;
import org.apache.ibatis.annotations.Select;

public interface RecipeMapper {
	@Select("SELECT no,title,chef,rownum "
			+"FROM (SELECT no,title,chef FROM recipe ORDER BY no ASC) "
			+"WHERE rownum<=30")
	public List<RecipeVO> recipeListData();
}
