package com.sist.web.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.web.dao.CategoryDAO;
import com.sist.web.dao.FoodDAO;
import com.sist.web.dao.FoodLocationDAO;
import com.sist.web.entity.CategoryEntity;
import com.sist.web.entity.FoodEntity;
import com.sist.web.entity.FoodLocationEntity;

@Controller
@RequestMapping("food/") //반복되는 상위경로 빼내기
public class FoodController {
	@Autowired
	private FoodDAO dao;
	
	@Autowired
	private CategoryDAO cdao;
	
	@Autowired
	private FoodLocationDAO fdao;
	
	@GetMapping("food_list")
	public String food_list(int cno,Model model)
	{
		CategoryEntity cvo=cdao.findByCno(cno);
		List<FoodEntity> list=dao.findByCno(cno);
		for(FoodEntity vo:list)
		{
			String address=vo.getAddress();
			address=address.substring(0,address.lastIndexOf("지"));
			vo.setAddress(address);
			
			String poster=vo.getPoster();
			poster=poster.substring(0,poster.indexOf("^")).replace("#", "&");
			vo.setPoster(poster);
		}
		model.addAttribute("list",list);
		model.addAttribute("cvo",cvo);
		model.addAttribute("main_html","food/food_list");
		return "main";
	}
	@GetMapping("food_detail")
	public String food_detail(int fno,Model model)
	{
		FoodEntity vo=dao.findByFno(fno);
		
		//포스터 나눠서 보내기
		String poster=vo.getPoster();
		List<String> pList=new ArrayList<String>();
		StringTokenizer st=new StringTokenizer(poster,"^");
		while(st.hasMoreTokens())
		{
			pList.add(st.nextToken());
		}
		model.addAttribute("pList",pList);
		
		//주소 나눠서 보내기
		String addr1=vo.getAddress();
		addr1=addr1.substring(0,addr1.lastIndexOf("지"));
		model.addAttribute("addr1",addr1.trim());
		
		model.addAttribute("vo",vo);
		model.addAttribute("main_html","food/food_detail");
		return "main";
	}
	@RequestMapping("food_find")
	public String food_find(String address,String page,Model model)
	{
		if(address==null)
			address="역삼";
		if(page==null)
			page="1";
		
		int curpage=Integer.parseInt(page);
		int rowSize=20;
		int start=(curpage*rowSize)-rowSize;
		
		List<FoodLocationEntity> list=fdao.foodFindData(address, start);
		for(FoodLocationEntity vo:list)
		{
			String poster=vo.getPoster();
			poster=poster.substring(0,poster.indexOf("^")).replace("#", "&");
			vo.setPoster(poster);
		}
		int totalpage=fdao.foodFindTotalPage(address);
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage=totalpage;
		model.addAttribute("curpage",curpage);
		model.addAttribute("totalpage",totalpage);
		model.addAttribute("startPage",startPage);
		model.addAttribute("endPage",endPage);
		model.addAttribute("list",list);
		model.addAttribute("address",address);
		model.addAttribute("main_html","food/food_find");
		return "main";
	}
	@GetMapping("find_detail")
	public String find_detail(int fno,Model model)
	{
		FoodLocationEntity vo=fdao.findByFno(fno);
		//포스터 나눠서 보내기
		String poster=vo.getPoster();
		List<String> pList=new ArrayList<String>();
		StringTokenizer st=new StringTokenizer(poster,"^");
		while(st.hasMoreTokens())
		{
			pList.add(st.nextToken());
		}
		model.addAttribute("pList",pList);
		
		//주소 나눠서 보내기
		String addr1=vo.getAddress();
		addr1=addr1.substring(0,addr1.lastIndexOf("지"));
		model.addAttribute("addr1",addr1.trim());
		
		model.addAttribute("vo",vo);
		model.addAttribute("main_html","food/find_detail");
		return "main";
	}
}
