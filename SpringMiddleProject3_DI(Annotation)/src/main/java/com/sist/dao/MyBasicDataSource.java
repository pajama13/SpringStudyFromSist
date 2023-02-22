package com.sist.dao;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.stereotype.Component;
//사용자정의는 어노테이션, 라이브러리는 xml 사용
@Component("ds") //어노테이션 통해 메모리 할당
public class MyBasicDataSource extends BasicDataSource{
	/*
		이 부분을 자바에서 코딩하기
		
		<bean id="ds" class="org.apache.commons.dbcp.BasicDataSource"
		   p:driverClassName="oracle.jdbc.driver.OracleDriver"
		   p:url="jdbc:oracle:thin:@localhost:1521:XE"
		   p:username="hr"
		   p:password="happy"
		   p:maxActive="10"
		   p:maxIdle="10"
		   p:maxWait="-1"
	    />
	*/
	public MyBasicDataSource()
	{
		setDriverClassName("oracle.jdbc.driver.OracleDriver");
		setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		setUsername("hr");
		setPassword("happy");
		setMaxActive(10);
		setMaxIdle(10);
		setMaxWait(-1);
	}
}
