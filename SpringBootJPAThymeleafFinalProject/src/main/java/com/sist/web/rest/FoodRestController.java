package com.sist.web.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.dao.CategoryDAO;
import com.sist.web.dao.FoodDAO;
import com.sist.web.dao.FoodLocationDAO;
import com.sist.web.entity.CategoryEntity;
import com.sist.web.entity.FoodEntity;
import com.sist.web.entity.FoodLocationEntity;

@RestController
@RequestMapping("food/")
@CrossOrigin("http://localhost:3000")
public class FoodRestController {
	@Autowired
	private FoodDAO fdao;
	
	@Autowired
	private FoodLocationDAO fldao;
	
	@Autowired
	private CategoryDAO cdao;
	
	@GetMapping(value="category_react")
	public List<CategoryEntity> categoryChangeData(int cno)
	{
		int start=0, end=0;
		if(cno==1)
		{
			start=1;
			end=12;
		}
		else if(cno==2)
		{
			start=13;
			end=18;
		}
		else if(cno==3)
		{
			start=19;
			end=30;
		}
		List<CategoryEntity> list=cdao.categoryChangeData(start, end);
		return list;
	}
	
	@GetMapping(value="food_location_react")
	public List<FoodLocationEntity> foodChangeData()
	{
		List<FoodLocationEntity> list=fldao.foodChangeData();
		for(FoodLocationEntity vo:list)
		{
			String poster=vo.getPoster();
			poster=poster.substring(0,poster.indexOf("^")).replace("#", "&");
			vo.setPoster(poster);
		}
		return list;
	}
	@GetMapping("category_info_react")
	public CategoryEntity category_info(int cno)
	{
		CategoryEntity vo=cdao.findByCno(cno);
		return vo;
	}
	@GetMapping("food_list_react")
	public List<FoodEntity> food_list(int cno)
	{
		List<FoodEntity> list=fdao.findByCno(cno);
		for(FoodEntity vo:list)
		{
			String address=vo.getAddress();
			address=address.substring(0,address.lastIndexOf("지"));
			vo.setAddress(address);
			
			String poster=vo.getPoster();
			poster=poster.substring(0,poster.indexOf("^")).replace("#", "&");
			vo.setPoster(poster);
		}
		return list;
	}
	@GetMapping("food_detail_react")
	public FoodEntity food_detail(int fno)
	{
		FoodEntity vo=fdao.findByFno(fno);
		//주소 나눠서 보내기
		String addr1=vo.getAddress();
		addr1=addr1.substring(0,addr1.lastIndexOf("지"));
		vo.setAddress(addr1);
		return vo;
	}
}
