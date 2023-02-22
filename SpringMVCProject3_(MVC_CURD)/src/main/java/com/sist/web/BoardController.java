
package com.sist.web;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.dao.*;
import java.util.*;
//Controller => Model 역할
//화면 전환 => 리턴형이 jsp, do
/*
	?page=1&no=1
	=> 모든 데이터형 (매개변수)
	   1) 해당 데이터형
	   2) null = String
*/
@Controller
@RequestMapping("board/")
public class BoardController {
	@Autowired
	private BoardDAO dao;
	
	@RequestMapping("list.do")
	public String board_list(String page,Model model)  //Model 전송 객체 => request 전송 / request.getParameter 대신하는 역할
	{
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		Map map=new HashMap();
		int rowSize=10;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		map.put("start",start);
		map.put("end",end);
		List<BoardVO> list=dao.boardListData(map);
		int totalpage=dao.boardTotalpage();
		model.addAttribute("curpage",curpage);
		model.addAttribute("totalpage",totalpage);
		model.addAttribute("list",list);  // = request.setAttribute
		
		return "board/list";
	}
	@RequestMapping("insert.do")
	public String board_insert()
	{
		return "board/insert";
	}
	@RequestMapping("insert_ok.do")
	public String board_insert_ok(BoardVO vo)  //DispatcherServlet이 vo 전달(?)
	{
		dao.boardInsert(vo);
		return "redirect:list.do";
	}
	// <a href="detail.do?no=${vo.no}">${vo.subject }</a>
	@RequestMapping("detail.do")
	public String board_detail(int no,Model model)
	{
		BoardVO vo=dao.boardDetailData(no);
		model.addAttribute("vo",vo);
		return "board/detail";
	}
	
	// <a href="update.do?no=${vo.no }" class="btn btn-xs btn-danger">수정</a>
	@RequestMapping("update.do")
	public String board_update(int no,Model model) //Model은 보내줄 값 있을 때 넣기
	{
		BoardVO vo=dao.boardUpdateData(no);
		//"" 공백처리 => ""들어가면 값 안 나옴
		String s=vo.getSubject();
		s=s.replace("\"", "");
		vo.setSubject(s);
		model.addAttribute("vo",vo);
		return "board/update";
	}
	// <a href="delete.do?no${vo.no }" class="btn btn-xs btn-info">삭제</a>
	@RequestMapping("delete.do")
	public String board_delete(int no,Model model)
	{
		model.addAttribute("no",no);
		return "board/delete";
	}
	
	@RequestMapping("find.do")
	public String board_find(String fs,String ss,Model model)
	{
		Map map=new HashMap();
		map.put("fs",fs);
		map.put("ss",ss);
		List<BoardVO> list=dao.boardFindData(map);
		int count=dao.boardFindCount(map);
		model.addAttribute("list",list);
		model.addAttribute("count",count);
		return "board/find";
	}
}
