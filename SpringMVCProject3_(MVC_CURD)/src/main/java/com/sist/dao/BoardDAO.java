package com.sist.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.mapper.*;

@Repository
public class BoardDAO {
	@Autowired //mapper를 구현한 클래스의 객체 주소값을 스프링으로부터 받아오기
	private BoardMapper mapper;
	
	/*
	
		@Select("SELECT no,subject,name,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit,num "
			+"FROM (SELECT no,subject,name,regdate as dbday,hit,rownum as num "
			+"FROM (SELECT no,subject,name,regdate as dbday,hit "
			+"FROM spring_board)) "
			+"WHERE num BETWEEN #{start} AND #{end} ")
	
	*/
	public List<BoardVO> boardListData(Map map)
	{
		return mapper.boardListData(map);
	}
	
	/*
		@Insert("INSERT INTO spring_board(no,name,subject,content,pwd) "
				+"VALUES(sprbo_no_seq.nextval,#{name},#{subject},#{content},#{pwd}) ")
	*/
	
	public void boardInsert(BoardVO vo)
	{
		mapper.boardInsert(vo);
	}
	
	/*
	@Select("SELECT CEIL(count(*)/10.0) FROM spring_board")
	*/
	public int boardTotalpage()
	{
	    return mapper.boardTotalpage();
	}
	
	
	/*
		//상세보기 조회수 증가
		@Update("UPDATE spring_board SET "
				+"hit=hit+1 "
				+"WHERE no=#{no}")
	*/		
	/*
		//상세보기 읽어오기
		@Select("SELECT no,name,subject,content,hit,TO_CHAR(regdate,'yyyy-MM-dd') as dbday "
				+"FROM spring_board "
				+"WHERE no=#{no}")
	*/		
	public BoardVO boardDetailData(int no)
	{
		mapper.hitIncrement(no);
		return mapper.boardDetailData(no);
	}
	
	public BoardVO boardUpdateData(int no)
	{
		return mapper.boardDetailData(no);
	}
	
	/*
	//비밀번호 조회(비밀번호 일치여부 확인)
	@Select("SELECT pwd FROM spring_board WHERE no=#{no}")
	public String boardGetPassword(int no);
	
	//데이터 수정
	@Update("UPDATE spring_board SET "
			+"name=#{name},subject=#{subject},content=#{content} "
			+"WHERE no=#{no} ")
	*/		
	public boolean boardUpdate(BoardVO vo)
	{
		boolean bCheck=false;
		String db_pwd=mapper.boardGetPassword(vo.getNo());
		if(db_pwd.equals(vo.getPwd()))
		{
			bCheck=true;
			mapper.boardUpdate(vo);
		}
		return bCheck;
	}
	
	/*
	@Select("SELECT pwd FROM spring_board WHERE no=#{no}")
	public String boardGetPassword(int no)
	*/
	
	/*
	@Delete("DELETE FROM spring_board WHERE no=#{no}")
	*/
	public boolean boardDelete(int no,String pwd)
	{
		boolean bCheck=false;
		//비밀번호 읽기
		String db_pwd=mapper.boardGetPassword(no);
		if(db_pwd.equals(pwd))
		{
			bCheck=true;
			mapper.boardDelete(no);
		}
		return bCheck;
	}
	
	/*
	@Select("SELECT count(*) FROM spring_board "
			+"WHERE ${fs} LIKE '%'||#{ss}||'%'")
	*/
	public int boardFindCount(Map map) //매개변수가 1개보다 많을 때 : VO 또는 Map 사용 => VO에 없는 변수면 Map 사용
	{
		return mapper.boardFindCount(map);
	}
	/*
	@Select("SELECT no,name,subject,TO_CHAR(regdate,'yyyy-MM-dd') as dbday,hit FROM spring_board "
			+"WHERE ${fs} LIKE '%'||#{ss}||'%'")
	*/
	public List<BoardVO> boardFindData(Map map)
	{
		
		return mapper.boardFindData(map);
	}
	
}
