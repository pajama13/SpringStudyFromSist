package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
/*
	Application:main() => System.out.println()
	Web => Model => 브라우저 전송 => 브라우저에서 출력
	---------------------------------------------- DI/AOP는 동일
	DispatcherServlet에서 처리 => getBean()을 사용하지 않음
	
*/
@Repository
public class SeoulDAO {
	@Autowired
	private SeoulMapper mapper;  //인터페이스 구현
	
	public List<SeoulVO> seoulListData(Map map)
	{
		return mapper.seoulListData(map);
	}
	public int seoulTotalPage()
	{
		return mapper.seoulTotalPage();
	}
}
