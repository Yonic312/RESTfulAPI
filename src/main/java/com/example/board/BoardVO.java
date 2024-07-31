package com.example.board;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {

	private int idx ;
	private String name; 
	private int age ;
	private String etc; 
	private String regdate; 
	private Date regdate2; 
	
	private String ch1; 
	private String ch2; 
}
