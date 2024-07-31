package com.example.board;

import java.util.List;

public interface BoardService {
	  List<BoardVO> getBoardList(BoardVO  vo);
	  
	  BoardVO getBoard(BoardVO  vo);
	  
	  void update(BoardVO  vo);	
	  
	  int insert(BoardVO  vo);
}
