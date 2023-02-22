package com.sist.sawon;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import lombok.Getter;
import lombok.Setter;

/*

	스프링 역할 : 여러 개의 클래스(컴포넌트) 관리 => 컨테이너
	
	스프링 => 컨테이너 (라이브러리)
			BeanFactory
			     |
			ApplicationContext => 클래스를 Map에 저장(id, new 클래스) => DL(클라이언트가 요청한 클래스 찾아주는 역할)
			     |                                                => getBean(id) 이용
			     |                                                => 클래스 간 연결관계 없이 독립적으로 동작(POJO) => 결합성이 낮은 프로그램(다른 클래스에 영향X, 유지보수 용이)
			     |  
			--------------------------------------------------------------     
	        |                                |                           |
GenericApplicationContext    AnnotationConfigApplicationContext      WepApplicationContext(MVC)
=> 컨테이너 종료                => 자바로 스프링 설정                      


	컨테이너 : 클래스 관리(객체 생성~소멸)
	         ---------
	         1) 객체 생성(메모리 할당)
	           -new 
	           -리플렉션*** => Class.forName() 클래스 이름으로 메모리 할당
	           -id, 객체주소 저장 <bean id="" class="">
	        
	         2) 필요데이터 설정 : 데이터베이스 연결, 채팅 서버 연결 등
	           -필요 멤버변수 값 설정 : setXxx(), 생성자
	           
	         3) 메소드 호출
               -객체 생성 : init-method
               -객체 소멸 : destroy-method
               
*/
/*
	
	<bean id="sa" class="com.sist.sawon.Sawon">
	String id="sa"
	String cls="com.sist.sawon.Sawon"
	
	Class clsName=Class.forName(cls); 클래스 정보 읽어오기
	Object obj=className.newInstance();  객체 생성, 메모리 할당
	map.put(id,obj) => 저장 => 스프링 내부에서 작업(싱글턴) : 요청 시마다 메모리 1개를 재사용 => 메모리 누수현상 방지
	
	app.getBean("sa") => 프로그램에 필요한 객체 얻어오기
	
	스프링에서 XML 읽는 경우,  Annotation
	--------------------  -----------
	
	setter DI, 생성자 DI    값 주입이 어려움(라이브러리만 주입:XML)
	
	생명주기
	  -생성자 호출(메모리 할당)
	    => 생성자 DI
	  -setter DI
	  -프로그래머 활용
	  -객체 소멸
	  
*/

public class Sawon implements InitializingBean,DisposableBean,BeanNameAware,BeanFactoryAware{
	private String name;
	private String sex;
	
	public Sawon()
	{
		System.out.println("1. 스프링에서 메모리 할당 : Sawon 객체 생성... Class.forName() 통해 메모리 할당");
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("2. setName() 호출, name값 채우기(주입, DI) => setName("+name+")");
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
		System.out.println("2. setSex() 호출, sex값 채우기(주입, DI) => setSex("+sex+")");
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("setBeanFactory() Call");
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("setBeanName() Call.. :"+name);
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("객체 소멸.. destroy()...");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet() : SetterDI 완료(데이터 주입 완료)");
	}
	
	public void print()
	{
		System.out.println("프로그래머 활용");
		System.out.println("name:"+name);
		System.out.println("sex:"+sex);
	}
}

