package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sist.mapper.*;

//메모리 할당 요청 => <bean id="dao"> 대신 Annotation @Repository 사용
@Repository("dao")
public class SeoulDAO {
	@Autowired //자동 주입
	private SeoulMapper mapper;
	public List<SeoulVO> seoulListData()
	{
		return mapper.seoulListData();
	}
}
