package com.sist.myapp;

import com.sist.dao.MovieDAO;

/*
	aspect : 공통모듈(자주 호출)
	공통 / 핵심
	
	OOP는 공통으로 사용 시 => 1개의 클래스 이용할 때 메소드
	                      getConnection(), disConnection()
	                   => 여러 개 클래스 이용할 때 메소드
	                      CreateConnection
	
	스프링에서는 공통으로 사용되는 부분을 자동화 처리 => AOP => CommonsData.footData()
	
	AOP처리
	1) 호출 시점 (언제 호출할지) => JoinPoint
	  -Before
	  -After
	  -AfterReturning
	  -AfterThrowing
	  -Around
	  
	  *예시 => 각각 어느 위치에서 호출되는지 잘 확인하기
	  
	  public String display()
	  {
	     @Before (getConnection())
	     try
	     {
	        ------------- @Around (처리 시간 계산) => setAutoCommit(false)
	        소스코딩
	        ------------- commit
	     }catch(Exception ex)
	     {
	        에러 발생 시 @AfterThrowing => rollback()
	     }
	     finally
	     {
	        @After (disConnection())
	     }
	     return "" => AfterReturning (정상 수행 시) => 리턴값 받아서 처리
	  }
	  
	2) 어떤 메소드에서 자동화 처리할지 => PointCut
	   execution("* com.sist.main.*.*(..)")
	             ------------------------
	             *(첫번째) : 리턴형 (모든 리턴형 출력)
	             *(2번째) : 모든 클래스 
	             *(마지막) : 모든 메소드에 적용
	             .. : 모든 매개변수
	   within("com.sist.main.*") => 패키지 단위로 모든 클래스에 적용
	3) Advice(JoinPoint+PointCut) => Aspect
	4) Weaving : 통합 => Proxy패턴 (대리자)
	
	*예시
	public class A
	{
	   public void display()
	   {
	      
	   }
	   public class Proxy
	   {
	      private A a;
	      public Proxy(A a)
	      {
	      
	      }
	      public void display()
	      {
	         @Before
	         System.out.println("Before")
	         a.display()
	         @After
	         System.out.println("After")
	      }
	   }
	}
*/
public class MainClass {
	public static void main(String[] args) {
		MovieDAO dao=new MovieDAO();
		dao.select();
		System.out.println("-----------");
		dao.insert();
		System.out.println("-----------");
		dao.update();
		System.out.println("-----------");
		dao.delete();
	}
}
