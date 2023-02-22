package com.sist.myapp;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;
public class MainClass {
	public static void main(String[] args) {
//		MyDAO dao=new MyDAO("oracle.jdbc.driver.OracleDriver");
//		dao.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
//		dao.setUsername("hr");
//		dao.setPassword("happy");
		
		//스프링 이용
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
		MyDAO dao=(MyDAO)app.getBean("dao");
		//연결
		dao.getConnection();
	}
}
