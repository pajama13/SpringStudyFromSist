package com.sist.dao;

public class MyDAO {
	private String url,username,password;
	
	public void setUrl(String url) {
		this.url = url;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public MyDAO(String driver)
	{
		System.out.println("driver:"+driver);
	}
	public void getConnection()
	{
		System.out.println("URL:"+url);
		System.out.println("USER:"+username);
		System.out.println("PWD:"+password);
	}
}
