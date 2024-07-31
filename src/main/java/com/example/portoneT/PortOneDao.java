package com.example.portoneT;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PortOneDao {
	 void insert(PortOneVO vo);
	 public PortOneVO edit(PortOneVO vo);
}
