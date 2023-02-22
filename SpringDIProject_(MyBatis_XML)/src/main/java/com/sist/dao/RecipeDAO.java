package com.sist.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import com.sist.vo.*;
import java.util.*;

public class RecipeDAO extends SqlSessionDaoSupport{
	public List<RecipeVO> recipeListData()
	{
		return getSqlSession().selectList("recipeListData");
	}
}
