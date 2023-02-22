package com.sist.myapp;

import com.sist.config.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sist.dao.*;
import com.sist.vo.*;

@Component
public class MainClass {
	@Autowired
	private GoodsDAO dao;
	public static void main(String[] args) {
		//XML용
//		ApplicationContext app=
//				new ClassPathXmlApplicationContext("app.xml");
		
		//자바용
		AnnotationConfigApplicationContext app=
				new AnnotationConfigApplicationContext(GoodsConfig.class);
		
		System.out.println("----- 메뉴 -----");
		System.out.println("1. 전체보기");
		System.out.println("2. 베스트상품");
		System.out.println("3. 신상품");
		System.out.println("4. 특가상품");
		System.out.println("---------------");
		String[] table={"","all","best","new","special"};
		Scanner scan=new Scanner(System.in);
		System.out.println("메뉴 선택(1~4):");
		int menu=scan.nextInt();
		
		Map map=new HashMap();
		map.put("goods_tbl","goods_"+table[menu]);
		
		MainClass mc=app.getBean("mainClass",MainClass.class);
		List<GoodsVO> list=mc.dao.goodsListData(map);
		for(GoodsVO vo:list)
		{
			System.out.println(vo.getNo()+"."+vo.getGoods_name()+"("+vo.getGoods_price()+")");
		}
	}
}
