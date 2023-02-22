package com.sist.dao;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/*
	@Autowired 들어가는 위치
	-멤버변수
	-생성자
	-매개변수
	
	public class A
	{
		@Autowired //필드
		private B b;
		
		@Autowired //생성자
		public A(B b)
		{
		}
		
		@Autowired //매개변수
		public void setB(B b)
		{
		}
	}
*/
@Component("ssf") //어노테이션 통해 메모리 할당
//Target(value={TYPE}) => @Component는 클래스 위에만 올릴 수 있음
public class MySqlSessionFactoryBean extends SqlSessionFactoryBean{

	@Autowired	//Target(value={CONSTRUCTOR, METHOD, PARAMETER, FIELD, ANNOTATION_TYPE})
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	/*
		이 부분을 자바에서 코딩하기 (setter 이용)
		
		<bean id="ssf" class="org.mybatis.spring.SqlSessionFactoryBean"
		  p:dataSource-ref="ds"
		/>
		 
	*/
	
}
