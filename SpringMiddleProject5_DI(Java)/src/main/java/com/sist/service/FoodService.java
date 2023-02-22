package com.sist.service;
import com.sist.mapper.*;
import com.sist.vo.CategoryVO;
import com.sist.vo.FoodVO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//DAO 여러 개를 통합(BI)
//DAO vs Service 차이
@Service
public class FoodService {
	@Autowired
	private FoodMapper fMapper;
	
	@Autowired
	private CategoryMapper gMapper;
	
	public List<FoodVO> foodListData(int cno)
	{
		return fMapper.foodListData(cno);
	}
	public List<CategoryVO> categoryListData()
	{
		return gMapper.categoryListData();
	}
}
