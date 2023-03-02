package com.sist.vo;

import lombok.Getter;
import lombok.Setter;

/*
 	NO         NUMBER         
	TITLE      VARCHAR2(200)  
	URL        VARCHAR2(1000) 
	POSTER     VARCHAR2(1000) 
	IMAGE      CLOB           
	ADDR       VARCHAR2(500)  
	ADDR2      VARCHAR2(500)  
	TEL        VARCHAR2(100)  
	TYPE       VARCHAR2(100)  
	PARKING    VARCHAR2(100)  
	TIME       VARCHAR2(500)  
	MENU       VARCHAR2(2000) 
	SCORE      VARCHAR2(50)   
	HIT        NUMBER
*/

@Getter
@Setter
//MyBatis의 주의점 : SELECT * 를 사용하려면 테이블의 모든 컬럼을 VO에 넣어야 함 (일부만 VO에 있는 경우 오류 발생)
public class JejuFoodVO {
	private int no,hit;
	private String title,url,poster,image,addr,addr2,tel,type,parking,time,menu,score;
}
