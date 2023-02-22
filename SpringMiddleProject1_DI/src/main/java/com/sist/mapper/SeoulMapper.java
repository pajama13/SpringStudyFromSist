package com.sist.mapper;
import java.util.*;
//MyBatis 관련

import com.sist.dao.SeoulLocationVO;
public interface SeoulMapper {
	/*
		매개변수를 2개 이상 사용 시 오류 발생
		
		매개변수 여러 개 받고 싶을 때
		1. ~VO 사용
		2. Map 사용
	*/
	public List<SeoulLocationVO> seoulListData(Map map);
	public SeoulLocationVO seoulDetailData(Map map);
	//        resultType          id       parameterType
}
