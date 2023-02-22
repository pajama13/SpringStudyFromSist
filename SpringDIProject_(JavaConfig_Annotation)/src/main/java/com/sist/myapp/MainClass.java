package com.sist.myapp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.sist.config.BookConfig;
import com.sist.model.Model;
import com.sist.service.JejuService;
import com.sist.vo.JejuFoodVO;
import com.sist.vo.JejuLocationVO;
@Component
public class MainClass {
	@Autowired
	private Model model;
	@Autowired
	private JejuService js;
	
	//자바
	public static void main(String[] args) {
		AnnotationConfigApplicationContext app=
				new AnnotationConfigApplicationContext(BookConfig.class);
		MainClass mc=(MainClass)app.getBean("mainClass");
		
		System.out.println("--- 제주 명소 ---");
		//모델 사용 없이
		//JejuService js=(JejuService)app.getBean("jejuService");
		List<JejuLocationVO> list=mc.js.locationListData();
		for(JejuLocationVO vo:list)
		{
			System.out.println(vo.getTitle()+"("+vo.getPrice()+")");
		}
		
		System.out.println("--- 제주 맛집 ---");
		List<JejuFoodVO> list2=mc.js.foodListData();
		for(JejuFoodVO vo:list2)
		{
			System.out.println(vo.getTitle()+"("+vo.getScore()+")");
		}
		
		
		//책 관련
		/*
		System.out.println("--- 책 카테고리 ---");
		mc.model.bookCategoryData();
		System.out.println("--------------------");
		Scanner scan=new Scanner(System.in);
		System.out.println("카테고리 선택:");
		int no=scan.nextInt();
		String[] cate={
			"",
			"순수과학",
			"역사",
			"언어",
			"총류",
			"기술과학",
			"종교",
			"문학",
			"예술",
			"철학",
			"사회과학"
			};
		System.out.println("------ 실행결과 ------");
		mc.model.bookListData(cate[no]);
		*/
		
		
	}
}
