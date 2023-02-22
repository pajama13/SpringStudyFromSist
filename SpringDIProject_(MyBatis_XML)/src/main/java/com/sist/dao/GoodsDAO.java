package com.sist.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import com.sist.vo.*;
import java.util.*;

public class GoodsDAO extends SqlSessionDaoSupport{
	public List<GoodsVO> goodsListData()
	{
		return getSqlSession().selectList("goodsListData");
		
	}
}
