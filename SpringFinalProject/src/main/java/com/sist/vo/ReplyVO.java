package com.sist.vo;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ReplyVO {
	private int rno,type,no;
	private String id,name,msg,dbday;
	private Date regdate;
}
