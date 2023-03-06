package com.haru.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haru.vo.BoardVO;
import com.haru.mapper.*;

@Repository
public class BoardDAO {
	@Autowired
	private BoardMapper mapper;
		
	//게시판 Type별 리스트 출력
	/*
	@Select("SELECT btype,bno,id,nickname,title,content,tag,hit,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,num "
	+"FROM (SELECT btype,bno,id,nickname,title,content,tag,hit,regdate,rownum as num "
	+"FROM (SELECT //INDEX_DESC(ch_board_2_3 ch_b_bno_pk_2_3)// btype,bno,id,nickname,title,content,tag,hit,regdate "
	+"FROM ch_board_2_3)) "
	+"WHERE btype=#{btype} "
	+"AND num BETWEEN #{start} AND #{end} ")
	*/
	public List<BoardVO> boardListData(Map map)
	{
		return mapper.boardListData(map);
	}
	
	//게시판 Type별 리스트 총페이지
	/*
	@Select("SELECT CEIL(count(*)/7.0) FROM ch_board_2_3 "
			+"WHERE btype=#{btype}")
	*/
	public int boardListTotalPage(int btype)
	{
		return mapper.boardListTotalPage(btype);
	}
}
