package com.sist.dao;

import org.springframework.stereotype.Repository;

import com.sist.vo.ReplyVO;

import oracle.jdbc.internal.OracleTypes;

import java.util.*;
import java.sql.*;

@Repository
/*

*/
public class ReplyDAO {
	
	private Connection conn;
	private CallableStatement cs;
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	
	public ReplyDAO()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception ex){}
		
		
	}
	
	public void getConnection()
	{
		try
		{
			conn=DriverManager.getConnection(URL,"hr","happy");
		}catch(Exception ex) {}
	}
	public void disConnection()
	{
		try
		{
			if(cs!=null) cs.close();
			if(conn!=null) conn.close();
		}catch(Exception ex) {}
	}
	
	//CRUD (select, insert, update, delete)
	public List<ReplyVO> replyListData(ReplyVO vo)
	{
		List<ReplyVO> list=new ArrayList<ReplyVO>();
		try
		{
			getConnection();
			String sql="{CALL replyList(?,?,?)}";
			cs=conn.prepareCall(sql);
			cs.setInt(1, vo.getType()); //카테고리번호
			cs.setInt(2, vo.getNo()); // 개별번호
			cs.registerOutParameter(3, OracleTypes.CURSOR);
			cs.executeQuery();
			ResultSet rs=(ResultSet)cs.getObject(3);
			while(rs.next())
			{
				ReplyVO rvo=new ReplyVO();
				rvo.setNo(rs.getInt(1));
				rvo.setRno(rs.getInt(2));
				rvo.setType(rs.getInt(3));
				rvo.setId(rs.getString(4));
				rvo.setName(rs.getString(5));
				rvo.setMsg(rs.getString(6));
				rvo.setRegdate(rs.getDate(7));
				rvo.setDbday(rs.getString(8));
				list.add(rvo);
			}
			rs.close();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
		return list;
	}
	
	public void replyInsert(ReplyVO vo)
	{
		try
		{
			getConnection();
			String sql="{CALL replyInsert(?,?,?,?,?)}";
			cs=conn.prepareCall(sql);
			cs.setInt(1, vo.getRno());
			cs.setInt(2, vo.getType());
			cs.setString(3, vo.getId());
			cs.setString(4, vo.getName());
			cs.setString(5, vo.getMsg());
			cs.executeQuery();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
	}
	
	public void replyUpdate(int no,String msg)
	{
		try
		{
			getConnection();
			String sql="{CALL replyUpdate()}";
			cs=conn.prepareCall(sql);
			cs.setInt(1, no);
			cs.setString(2,msg);
			cs.executeQuery();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
	}
	
	public void replyDelete(int no)
	{
		try
		{
			getConnection();
			String sql="{CALL replyDelete()}";
			cs=conn.prepareCall(sql);
			cs.setInt(1, no);
			cs.executeQuery();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
	}
}
