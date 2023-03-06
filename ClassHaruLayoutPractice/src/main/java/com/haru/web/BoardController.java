package com.haru.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.*;
import com.haru.dao.BoardDAO;
import com.haru.vo.BoardVO;

@Controller
public class BoardController {
	@Autowired
	private BoardDAO dao;
	@GetMapping("board/main.do")
	public String board_main()
	{

		return "board_main"; // => tiles.xml에서 name="board_main"인 파일 반환
	}
	
	@GetMapping("board/detail.do")
	public String board_detail()
	{
		return "board/detail"; // => tiles.xml에서 name="board_main"인 파일 반환
	}
	@GetMapping("board/insert.do")
	public String board_insert()
	{
		// type : 1번 자유주제, 2번 스터디&모임, 3번 질문답변
		return "board/insert";
	}
}
