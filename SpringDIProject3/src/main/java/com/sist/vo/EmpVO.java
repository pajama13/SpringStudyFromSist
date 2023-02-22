package com.sist.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
//MyBatis => 값 받는 변수명과 테이블 컬럼명이 동일하면 바로 사용 가능하지만, 다르면 각각 다 설정해줘야 함
@Getter
@Setter
public class EmpVO {
	private int empno,sal,deptno,rank;
	private String ename,job;
	private Date regdate; //테이블 컬럼명과 다른 변수명 (Emp테이블 hiredate컬럼)
	private String dname,loc;
	private int grade;
}
