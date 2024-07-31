package com.example.guestBook;

import java.util.List;

public interface GuestBookService {
	void insert(GuestBookVO vo);
	List<GuestBookVO> list(GuestBookVO vo);
	List<GuestBookVO> list2(GuestBookVO vo);
	int getTc(GuestBookVO vo);
}
