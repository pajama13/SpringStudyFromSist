package com.haru.web;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.haru.dao.*;
import com.haru.vo.*;

@RestController
public class BoardRestController {
	@Autowired
	private BoardDAO dao;
	
	@GetMapping(value="board/main_vue.do",produces="text/plain;charset=utf-8")
	public String board_main(String btype,String page,Model model)
	{
		// 게시판 btype : 1번 자유주제, 2번 스터디&모임, 3번 질문답변 
		if(btype==null)
			btype="1";
		if(page==null)
			page="1";
		
		int curpage=Integer.parseInt(page);
		int type=Integer.parseInt(btype);
		
		Map map=new HashMap();
		map.put("btype",type);
		map.put("start",(curpage*5)-4);
		map.put("end",curpage*5);
		
		List<BoardVO> list=dao.boardListData(map);
		int totalpage=dao.boardListTotalPage(type);
		
		JSONArray arr=new JSONArray();
		int i=0;
		for(BoardVO vo:list)
		{
			JSONObject obj=new JSONObject();
			obj.put("title",vo.getTitle());
			obj.put("content",vo.getContent());
			obj.put("tag",vo.getTag());
			obj.put("id",vo.getId());
			
			obj.put("dbday",vo.getDbday());
			obj.put("hit",vo.getHit());
			if(i==0)
			{
				obj.put("curpage",curpage);
				obj.put("totalpage",totalpage);
			}
			arr.add(obj);
			i++;

			//RestController 페이징 처리에서 if(i==0) 부분 뜻
			//닉네임 가져오려면 BoardVO에 MemberVO 변수 넣으면 되는지..
			//tag를 공백으로 나눠서 반복문 돌려서 출력하는 방법
			
		}
		return arr.toJSONString();
	}
}
