package com.example.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {

	BoardServiceImpl(){
		System.out.println("===>BoardServiceImpl ");
	}
	
	@Autowired
	private BoardDao  dao ;

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		 System.out.println("getBoardList vo(1):" + vo);
		 
		 String ch2 = vo.getCh2();
		 vo.setCh2("%"+ch2+"%");
	
        System.out.println("getBoardList vo(2):" + vo);
		return dao.getBoardList(vo);
	}

	@Override
	public int insert(BoardVO vo) {	
		dao.insert(vo);
		return dao.totalCount(vo);		
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		return dao.getBoard(vo);
	}

	@Override
	public void update(BoardVO vo) {
		dao.update(vo);	
	}		
}
