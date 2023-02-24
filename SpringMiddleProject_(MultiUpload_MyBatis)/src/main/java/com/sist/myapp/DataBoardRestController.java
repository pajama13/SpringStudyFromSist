package com.sist.myapp;
import com.sist.dao.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.*;

@RestController
public class DataBoardRestController {
	@Autowired
	private DataBoardDAO dao; //setterDI
	
	@PostMapping("databoard/delete.do")
	public String databoard_delete(int no,String pwd)
	{
		String result="";
		try
		{
			DataBoardVO vo=dao.databoardFileInfoData(no);
			if(vo.getFilecount()>0) //파일 있으면
			{
				String[] fn=vo.getFilename().split(",");
				for(String f:fn) //for문으로 하나씩 삭제
				{
					File file=new File("c:\\download\\"+f);
					file.delete();
				}
			}
		}catch(Exception ex) {}
		boolean bCheck=dao.databoardDelete(no, pwd);
		if(bCheck==true)
			result="yes";
		else
			result="no";
		return "";
	}
	 @PostMapping("databoard/pwd_check.do")
	 public String pwd_check(int no,String pwd)
	 {
		 String result="";
		 boolean bCheck=dao.pwdCheck(no, pwd);
		 if(bCheck==true)
			 result="yes";
		 else
			 result="no";
		 return result;
	 }
}
