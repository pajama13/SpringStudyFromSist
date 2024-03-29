package com.sist.web.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="board")
@Getter
@Setter
public class BoardEntity {
	  @Id
	  private int no;
	  private String name,subject,content,pwd,regdate;
	  private int hit;
	  
	  @PrePersist
	  public void regdate() {
		   this.regdate=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	  }
//	@Id
//	private int no;
//	private int hit;
//	private String name,subject,content,pwd,regdate;
//	//private LocalDateTime regdate;
//	
//	@PrePersist
//	public void regdate() {
//		this.regdate=LocalDateTime.now();
//	}
}
