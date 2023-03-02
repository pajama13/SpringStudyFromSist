package com.sist.web;

import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sist.dao.SeoulDAO;
import com.sist.vo.FoodVO;
import com.sist.vo.JejuFoodVO;
import com.sist.vo.SeoulVO;

@Controller
public class SeoulController {
	@Autowired
	private SeoulDAO dao;
	
	//리스트
	@GetMapping("seoul/list.do")
	public String seoul_list(String page,Model model,HttpServletRequest request)
	{
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		Map map=new HashMap();
		int rowSize=20;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		map.put("start",start);
		map.put("end",end);
		List<SeoulVO> list=dao.seoulListData(map);
		for(SeoulVO vo:list)
		{
			String title=vo.getTitle();
			if(title.length()>19)
			{
				title=title.substring(0,16)+"...";
				vo.setTitle(title);
			}
		}
		int totalpage=dao.seoulTotalPage();
		final int BLOCK=5;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		model.addAttribute("curpage",curpage);
		model.addAttribute("totalpage",totalpage);
		model.addAttribute("curpage",curpage);
		model.addAttribute("startPage",startPage);
		model.addAttribute("endPage",endPage);
		model.addAttribute("list",list);
		
		List<SeoulVO> scList=new ArrayList<SeoulVO>();
		//쿠키 받기
		Cookie[] cookies=request.getCookies();
		if(cookies!=null)
		{
			for(int i=cookies.length-1;i>=0;i--)
			{
				if(cookies[i].getName().startsWith("seoul"))
				{
					String no=cookies[i].getValue();
					SeoulVO vo=dao.seoulDetailData(Integer.parseInt(no));
					scList.add(vo);
				}
			}
		}
		model.addAttribute("scList",scList);
		return "seoul/list";
	}
	//쿠키 보내기
	@GetMapping("seoul/detail_before.do")
	public String seoul_detail_before(String no,HttpServletResponse response,RedirectAttributes ra)
	{
		Cookie cookie=new Cookie("seoul"+no,no);
		cookie.setPath("/");
		cookie.setMaxAge(60*60*24); //하루 저장
		//브라우저로 전송
		response.addCookie(cookie);
		ra.addAttribute("no",no);
		return "redirect:detail.do";
	}
	//상세보기
	@GetMapping("seoul/detail")
	public String seoul_detail(int no,Model model)
	{
		SeoulVO vo=dao.seoulDetailData(no);
		String addr=vo.getAddress();
		String[] addrs=addr.split(" ");
		Map map=new HashMap();
		map.put("addr", addrs[2].trim());
		
		List<FoodVO> list=dao.nearbyFoodData(map);
		model.addAttribute("vo",vo);
		model.addAttribute("list",list);
		
		return "seoul/detail";
	}
	
	//검색
	
	
}
