package com.sist.myapp;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sist.model.*;
@Component
public class MainClass {
	@Autowired
	private Model model;
	
	public static void main(String[] args) {
		
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
		MainClass mc=(MainClass)app.getBean("mainClass");
		System.out.println("--- 메뉴 ---");
		System.out.println("1. 레시피");
		System.out.println("2. 맛집");
		System.out.println("3. 상품");
		System.out.println("-----------");
		Scanner scan=new Scanner(System.in);
		System.out.println("메뉴 선택:");
		int no=scan.nextInt();
		
		if(no==1)
		{
			mc.model.recipeListData();
		}
		else if(no==2)
		{
			mc.model.foodListData();
		}
		else if(no==3)
		{
			mc.model.goodsListData();
		}
	}
}
