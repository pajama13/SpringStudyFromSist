package com.sist.service;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.sist.mapper.*;
import com.sist.vo.*;
//BI
@Service
public class JejuService {
	@Autowired
	private FoodMapper fMapper;
	@Autowired
	private LocationMapper lMapper;
	
	//@Select("SELECT no,title,addr,score,rownum FROM jejufood WHERE rownum<=30")
	public List<JejuFoodVO> foodListData()
	{
		return fMapper.foodListData();
	}
	
	//@Select("SELECT title,addr,price,rownum FROM jejulocation WHERE rownum<=30 ")
	public List<JejuLocationVO> locationListData()
	{
		return lMapper.locationListData();
	}
}
