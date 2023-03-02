package com.sist.web;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.dao.FoodDAO;
import com.sist.vo.*;
// <if>, <choose>, <where>, <trim>, <foreach>
@Controller
public class FoodController {
	@Autowired
	private FoodDAO dao;
	
	@GetMapping("food/category.do")
	public String food_category(String no,Model model)
	{
		if(no==null)
			no="1";
		Map map=new HashMap();
		map.put("cno",no);
		List<CategoryVO> list=dao.categoryListData(map);
		model.addAttribute("list",list);
		return "food/category";
	}
	
	//<a href="../food/list.do?cno=${vo.cno }">
	@GetMapping("food/list.do")
	public String food_list(int cno,Model model)
	{
		List<FoodVO> list=dao.foodListData(cno);
		CategoryVO vo=dao.categoryInfoData(cno);
		model.addAttribute("list",list);
		model.addAttribute("vo",vo);
		return "food/list";
	}
	
	@GetMapping("food/detail.do")
	public String food_detail(int fno,Model model)
	{
		FoodVO vo=dao.foodDetailData(fno);
		model.addAttribute("vo",vo);
		return "food/detail";
	}
	
	//@RequestMapping => get/post 동시 처리 (카테고리에선 a태그 get방식, 검색창에선 form태그 post방식)
	@RequestMapping("food/find.do")
	public String food_find(String addr,String page,Model model)
	{
		System.out.println("addr="+addr);
		String s="";
		if(addr==null || addr.equals(""))
		{
			s="all";
		}
		else
		{
			s=addr;
		}
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		int rowSize=20;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		Map map=new HashMap();
		map.put("start", start);
		map.put("end",end);
		map.put("ss",s);
		List<FoodVO> list=dao.foodFindData(map);
		model.addAttribute("list",list);
		
			
		return "food/find";
	}
	
}
