package com.example.guestBook;

import lombok.Data;

@Data
public class GuestBookVO {
	private int idx;
	private String name;
	private String memo;
	private int age;
	private String regdate;
	
	// 페이징
	private int pz = 10; // page size
	private int tc; // total count
	private int tp; // total page
	
	private int ps; // page start
	private int pe; // page end
	private int nowPage;
	
	private int qs; // qurry start
	private int qe; // qurry end
	
	
	private String ch1;
	private String ch2;
	
	
	
	
}
