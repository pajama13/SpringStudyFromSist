package com.haru.vo;

import java.util.*;

import lombok.Getter;
import lombok.Setter;
/*

ch_board_2_3 테이블

BNO     NOT NULL NUMBER        
BTYPE   NOT NULL NUMBER        
ID               VARCHAR2(100) 
TITLE   NOT NULL VARCHAR2(300) 
CONTENT NOT NULL CLOB          
REGDATE          DATE          
HIT              NUMBER        
TAG              VARCHAR2(500) 

*/

@Getter
@Setter

public class BoardVO {
	private int bno,btype,hit;
	private String id,title,content,dbday,tag;
	private Date regdate;
}
