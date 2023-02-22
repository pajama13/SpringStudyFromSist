package com.sist.myapp;
import java.util.*;
import com.sist.model.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.sist.vo.*;
import com.sist.dao.*;
public class MainClass {
	//방법1 : 모델 없이 처리
//	private FoodDAO fdao;
//	private GoodsDAO gdao;
//	private RecipeDAO rdao;
//	
//	public void setFdao(FoodDAO fdao) {
//		this.fdao = fdao;
//	}
//
//	public void setGdao(GoodsDAO gdao) {
//		this.gdao = gdao;
//	}
//
//	public void setRdao(RecipeDAO rdao) {
//		this.rdao = rdao;
//	}

	//방법2 : 모델 사용
	private Model model;
	
	public void setModel(Model model) {
		this.model = model;
	}

	public static void main(String[] args) {
		//MainClass mc=new MainClass(); //fdao,gdao,rdao => null => 주소값이
		
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
		MainClass mc=(MainClass)app.getBean("mc");
		System.out.println("--- 메뉴 ---");
		System.out.println("1. 레시피");
		System.out.println("2. 맛집");
		System.out.println("3. 상품");
		System.out.println("-----------");
		Scanner scan=new Scanner(System.in);
		System.out.println("메뉴 선택:");
		int no=scan.nextInt();
		
		//방법1 : 모델 없이 처리
//		if(no==1)
//		{
//			List<RecipeVO> list=mc.rdao.recipeListData();
//			for(RecipeVO vo:list)
//			{
//				System.out.println(vo.getNo()+"."+vo.getTitle()+"("+vo.getChef()+")");
//			}
//		}
//		else if(no==2)
//		{
//			List<FoodVO> list=mc.fdao.foodListData();
//			for(FoodVO vo:list)
//			{
//				System.out.println(vo.getFno()+"."+vo.getName()+"("+vo.getType()+")");
//			}
//		}
//		else if(no==3)
//		{
//			List<GoodsVO> list=mc.gdao.goodsListData();
//			for(GoodsVO vo:list)
//			{
//				System.out.println(vo.getNo()+"."+vo.getName()+"("+vo.getPrice()+")");
//			}
//		}		
		
		//방법2 : 모델 사용
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
