package com.example.guestBook;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GuestBookDao {
	void insert(GuestBookVO vo);
	List<GuestBookVO> list(GuestBookVO vo);
	List<GuestBookVO> list2(GuestBookVO vo);
	int getTc(GuestBookVO vo);
}
