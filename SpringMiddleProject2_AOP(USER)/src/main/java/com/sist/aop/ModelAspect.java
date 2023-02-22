package com.sist.aop;

import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;

import com.sist.model.EmpDAO;
import com.sist.model.EmpVO;

import lombok.Setter;
/*
	AOP의 적용 부분
	@Transactional()
	public List<MovieVO> movieListData()
	{
	   List<MovieVO> list=new ArrayList<MovieVO>;
	   try
	   {
	      getConnection() => Before
	      around => setAutoCommit(false)
	      오라클 처리
	      around => commit()
	      
	   }catch(Exception ex)
	   {
	      오류 처리
	      ex.printStackTrace() => AfterThrowing
	   }
	   finally
	   {
	      오라클 닫기 => rollback()
	      disConnection() => After
	   }
	   return => afterReturning
	}
*/
public class ModelAspect {
    @Setter
	private EmpDAO dao;
   
   public void before() {
	   System.out.println("before Call...: 시작전");
	   dao.getConnection();
   }
   public void after()
   {
	   System.out.println("after Call... : finally");
	   dao.disConnection();
   }
	public Object around(ProceedingJoinPoint jp) throws Throwable
	{
		Object obj=null;
		//수행 시간 계산 
		long start=0;
		long end=0;
		try
		{
			start=System.currentTimeMillis(); //시작시간 가져오기
			System.out.println("Client 요청 메소드:"+jp.getSignature().getName()); //사용자가 요청한 이름 가져오기
			obj=jp.proceed();  //메소드 호출
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			end=System.currentTimeMillis();  //종료시간 가져오기
			System.out.println("수행시간:"+(end-start));  //통계
		}
		return obj;
		
	}
	public void afterReturning(Object obj) throws Throwable
	{
		//결과값 받아서 출력 => 웹에서 return값 먼저 처리 => 자동로그인, ID 저장, 권한 등
	   System.out.println("afterReturning Call...");
	   List<EmpVO> list=(List<EmpVO>)obj;
	   for(EmpVO vo:list)
	   {
		   System.out.println(vo.getEmpno()+" "+vo.getEname()+" "+vo.getJob());
	   }
	}
	public void afterThrowing(Throwable ex) throws Throwable
	{
		//catch절 수행(에러 발생 시 수행)
		System.out.println("afterThrowing Call...");
		System.out.println(ex.getMessage());  //웹에서 alert 띄워서 처리
	}
}
