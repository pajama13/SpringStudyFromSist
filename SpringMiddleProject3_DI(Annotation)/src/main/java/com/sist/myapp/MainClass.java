package com.sist.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sist.dao.SeoulDAO;
import com.sist.dao.SeoulVO;

import java.util.*;
@Component("mc")
public class MainClass {
	@Autowired //필요한 의존 객체의 “타입"에 해당하는 빈을 찾아 주입 (생성자/setter/필드)
	//Autowired 단점 : 같은 객체형이 있는 경우 에러 발생 => @Qualifier 사용
	
	private SeoulDAO dao;
	
	public static void main(String[] args) {
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
		MainClass mc=(MainClass)app.getBean("mc");
		List<SeoulVO> list=mc.dao.seoulListData();
		for(SeoulVO vo:list)
		{
			System.out.println(vo.getNo()+"."+vo.getTitle());
		}
	}

}
