package com.sist.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.*;
import com.sist.dao.*;

import lombok.Delegate;

public interface BoardMapper {
	//목록 출력
	@Select("SELECT no,subject,name,TO_CHAR(regdate,'yyyy-MM-dd') as dbday,hit,num "
			+"FROM (SELECT no,subject,name,regdate,hit,rownum as num "
			+"FROM (SELECT no,subject,name,regdate,hit "
			+"FROM spring_board)) "
			+"WHERE num BETWEEN #{start} AND #{end} ")
	public List<BoardVO> boardListData(Map map);
	
	@Select("SELECT CEIL(count(*)/10.0) FROM spring_board")
	public int boardTotalpage();
	/*
		1. 매개변수는 반드시 1개만 설정 가능 (int start, int end => 사용 불가)
		2. 여러 개 매개변수가 있는 경우 VO 또는 Map 사용 => VO에 있는 변수들이면 VO 사용, 없으면 Map 사용
		3. 리턴형 => resultType => SQL문장 실행한 결과값
		   ROW 여러 개 => LIST
		   ROW 1개 => VO
		   
		   ex  SELECT pwd FROM member => 리턴형 : List<String> 테이블 내 모든 pwd 불러오기 때문
		       SELECT pwd FROM member WHERE id='hong' => 리턴형 : String  
	*/
	//데이터 추가
	@Insert("INSERT INTO spring_board(no,name,subject,content,pwd) "
			+"VALUES(sprbo_no_seq.nextval,#{name},#{subject},#{content},#{pwd}) ")
	public void boardInsert(BoardVO vo);
	//상세보기
	@Update("UPDATE spring_board SET "
			+"hit=hit+1 "
			+"WHERE no=#{no}")
	public void hitIncrement(int no);
	
	@Select("SELECT no,name,subject,content,hit,TO_CHAR(regdate,'yyyy-MM-dd') as dbday "
			+"FROM spring_board "
			+"WHERE no=#{no}")
	public BoardVO boardDetailData(int no);
	
	//비밀번호 조회(비밀번호 일치여부 확인)
	@Select("SELECT pwd FROM spring_board WHERE no=#{no}")
	public String boardGetPassword(int no);
	
	//데이터 수정
	@Update("UPDATE spring_board SET "
			+"name=#{name},subject=#{subject},content=#{content} "
			+"WHERE no=#{no} ")
	public void boardUpdate(BoardVO vo);
	
	//데이터 삭제
	@Delete("DELETE FROM spring_board WHERE no=#{no}")
	public void boardDelete(int no);
	
	//데이터 검색
	//검색결과개수
	/*
		WHERE name LIKE '%홍%'
		      ----       ----
		      ${}         #{}
		      ----       ---- 실제 데이터값
		      컬럼/테이블
		      
		      따옴표 없을 때/없어야 할 때 => ${}
		      따옴표 있어야 할 때 => #{}
	*/
	@Select("SELECT count(*) FROM spring_board "
			+"WHERE ${fs} LIKE '%'||#{ss}||'%'")
	public int boardFindCount(Map map); //매개변수가 1개보다 많을 때 : VO 또는 Map 사용 => VO에 없는 변수면 Map 사용
	
	@Select("SELECT no,name,subject,TO_CHAR(regdate,'yyyy-MM-dd') as dbday,hit FROM spring_board "
			+"WHERE ${fs} LIKE '%'||#{ss}||'%'")
	public List<BoardVO> boardFindData(Map map);
}
