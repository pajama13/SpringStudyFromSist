package com.sist.dao;
import com.sist.mapper.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
@Repository
public class SeoulDAO {
	@Autowired
	private SeoulMapper mapper;
	public List<SeoulVO> seoulListData(Map map)
	{
		return mapper.seoulListData(map);
	}
}
