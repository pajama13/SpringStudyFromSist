package com.sist.myapp;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;
public class MainClass {
	private SeoulDAO dao;
	
	public void setDao(SeoulDAO dao) {
		this.dao = dao;
	}

	public static void main(String[] args) {
		String[] table={"","seoul_location","seoul_nature","seoul_shop"};
		Scanner scan=new Scanner(System.in);
		System.out.println("데이터베이스 선택:");
		int no=scan.nextInt();
		Map map=new HashMap();
		map.put("seoul_tbl", table[no]); //seoul-mapper.xml 에서 ${seoul_tbl} 키값과 같아야 함 => map.get("seoul_tbl");
		//Map => 키, VO => getXxx()
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
		MainClass mc=(MainClass)app.getBean("mc");
		List<SeoulLocationVO> list=mc.dao.seoulListData(map);
		for(SeoulLocationVO vo:list)
		{
			System.out.println("이름:"+vo.getTitle());
			System.out.println("주소:"+vo.getAddress());
			System.out.println("소개:"+vo.getMsg());
			System.out.println("------------------------------");
		}
	}

}
