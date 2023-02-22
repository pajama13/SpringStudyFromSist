package com.sist.dao;

public class MovieDAO2 {
	public void select()
	{
		//Before (ex getConnection()) 
		System.out.println("SELECT 기능 수행");
		//After (ex disConnection())
	}
	public void delete()
	{
		System.out.println("DELETE 기능 수행");
	}
	public void insert()
	{
		System.out.println("INSERT 기능 수행");
	}
	public void update()
	{
		System.out.println("UPDATE 기능 수행");
	}
}
