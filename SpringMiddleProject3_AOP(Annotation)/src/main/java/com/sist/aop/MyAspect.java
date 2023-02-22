package com.sist.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect  //공통 기반
@Component
/*
	@Component
	@Service
	@Repository
	-----------------Web
	@Controller
	@RestController
	@ControllerAdvice
*/
public class MyAspect {
	@Before("execution(* com.sist.dao.MyDAO.*(..))")  //모든 메소드에 적용
	public void before()
	{
		System.out.println("오라클 연결");
	}
	@After("execution(* com.sist.dao.MyDAO.*(..))")
	public void after()
	{
		System.out.println("오라클 해제");
	}
}
