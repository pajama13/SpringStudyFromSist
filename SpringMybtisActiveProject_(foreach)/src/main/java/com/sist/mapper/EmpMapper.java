package com.sist.mapper;
import java.util.*;
import com.sist.dao.*;
public interface EmpMapper {
	/*
	<select id="empNameListData" resultType="string">
	            ---------------  ----------
	            메소드명           리턴형
	  SELECT DISTINCT ename FROM emp
	</select>
	  
	=> @Select("SELECT DISTINCT ename FROM emp")와 동일
	*/
	
	public List<String> empNameListData();
	
	/*
	<select id="empInfoData" resultType="com.sist.dao.EmpVO">
    SELECT * FROM emp
	*/
	public List<EmpVO> empInfoData(Map map);
}
