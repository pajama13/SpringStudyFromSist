package com.sist.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import com.sist.vo.*;
import java.util.*;

public class FoodDAO extends SqlSessionDaoSupport{
	
	public List<FoodVO> foodListData()
	{
		return getSqlSession().selectList("foodListData");
	}
	
}
