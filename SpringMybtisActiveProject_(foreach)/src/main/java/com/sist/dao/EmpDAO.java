package com.sist.dao;
import com.sist.mapper.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDAO {
	@Autowired
	private EmpMapper mapper;
	
	public List<String> empNameListData()
	{
		return mapper.empNameListData();
	}
	
	public List<EmpVO> empInfoData(Map map)
	{
		return mapper.empInfoData(map);
	}
}
