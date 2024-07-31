package com.example.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardDao {
	  List<BoardVO> getBoardList(BoardVO  vo);
	  void insert(BoardVO  vo);	
	  void update(BoardVO  vo);	
      int totalCount(BoardVO  vo);
	  
	  BoardVO getBoard(BoardVO  vo);
	  
}
