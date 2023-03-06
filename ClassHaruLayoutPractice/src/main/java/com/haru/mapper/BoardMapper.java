package com.haru.mapper;

import org.apache.ibatis.annotations.Select;
import java.util.*;
import com.haru.vo.*;

public interface BoardMapper {
	//게시판 Type별 리스트
	@Select("SELECT btype,bno,id,nickname,title,content,tag,hit,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,num "
			+"FROM (SELECT btype,bno,id,nickname,title,content,tag,hit,regdate,rownum as num "
			+"FROM (SELECT /*+ INDEX_DESC(ch_board_2_3 ch_b_bno_pk_2_3)*/ btype,bno,a.id,nickname,title,content,tag,hit,regdate "
			+"FROM ch_board_2_3 a, ch_member_2_3 b WHERE a.id=b.id)) "
			+"WHERE btype=#{btype} "
			+"AND num BETWEEN #{start} AND #{end} ")
	public List<BoardVO> boardListData(Map map);
	
	//게시판 Type별 리스트 총페이지
	@Select("SELECT CEIL(count(*)/5.0) FROM ch_board_2_3 "
			+"WHERE btype=#{btype}")
	public int boardListTotalPage(int btype);
	
	//게시글별 댓글수
	
	//올해 게시글 최다작성자 TOP7
	@Select("SELECT id,nickname,cnt,rownum "
			+"FROM (SELECT a.id,nickname,count(*) as cnt "
			+"FROM ch_board_2_3 a, ch_member_2_3 b "
			+"WHERE TO_CHAR(regdate,'YYYY')=TO_CHAR(SYSDATE,'YYYY') "
			+"GROUP BY id "
			+"ORDER BY count(*) DESC) "
			+"WHERE rownum <=7")
	public List<BoardVO> boardWriterTop7(BoardVO vo);
	
	//가장 많이 글을 쓴 순서대로 정렬
	
	//게시글 작성
	
	//게시글 수정
	
	//게시글 삭제
}
