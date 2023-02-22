package com.sist.web;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sist.dao.*;
//데이터 전송(javascript, json) => 수정, 삭제
@RestController
// @RestController => Vue, Ajax, React 연결할 때 사용
/*
	@Controller : 화면변경 (return => 화면(forward, redirect))
	@RestController : 데이터 전송 (JSON, javascript, ajax) => 문자열
	@Repository : 데이터베이스 연결, DAO 여러 개를 통합해서 사용 (ex 게시판 댓글 여러 개 처리) => BI
	
	==> DAO vs Service 차이점 ***
	
*/
public class BoardRestController {
	@Autowired
	private BoardDAO dao;
	
	//<form method="post" action="update_ok.do">
	@RequestMapping(value="board/update_ok.do",produces="text/html; charset=utf-8") //한글깨짐 방지
	public String board_update_ok(BoardVO vo)
	{
		String result="";
		boolean bCheck=dao.boardUpdate(vo);
		if(bCheck==true)
		{
			result="<script>"
					+"location.href=\"detail.do?no="+vo.getNo()+"\""
					+"</script>";
		}
		else
		{
			result="<script>"
					+"alert(\"비밀번호가 틀립니다!\");"
					+"history.back();"
					+"</script>";
		}
		return result;
	}
	
	@RequestMapping(value="board/delete_ok.do",produces="text/html;charset=utf-8")
	//form태그 통해 name값 no, pwd 넘어옴
	public String board_delete(int no,String pwd)
	{
		String result="";
		boolean bCheck=dao.boardDelete(no, pwd);
		if(bCheck==true)
		{
			result="<script>"
					+"location.href=\"list.do\""
					+"</script>";
		}
		else
		{
			result="<script>"
					+"alert(\"비밀번호가 틀립니다!\");"
					+"history.back();"
					+"</script>";
		}
		return result;
	}
	
}














