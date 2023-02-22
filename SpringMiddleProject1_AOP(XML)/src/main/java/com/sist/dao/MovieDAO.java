package com.sist.dao;

public class MovieDAO {
	public void getConnection() //공통 모듈 반복
	{
		System.out.println("오라클 연결...");
	}
	public void disConnection() //공통 모듈 반복
	{
		System.out.println("오라클 닫기");
	}
	public void select()
	{
		getConnection();
		System.out.println("SELEECT 문장 수행");
		disConnection();
	}
	public void insert()
	{
		getConnection();
		System.out.println("INSERT 문장 수행");
		disConnection();
	}
	public void update()
	{
		getConnection();
		System.out.println("UPDATE 문장 수행");
		disConnection();
	}
	public void delete()
	{
		getConnection();
		System.out.println("DELETE 문장 수행");
		disConnection();
	}
}
