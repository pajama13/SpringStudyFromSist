package com.sist.mapper;

import org.apache.ibatis.annotations.Select;
import java.util.*;
import com.sist.vo.*;

public interface GoodsMapper {
	@Select("SELECT no,goods_name,goods_price,rownum FROM ${goods_tbl} "
			+ "WHERE rownum <=30")
	public List<GoodsVO> goodsListData(Map map);
}
