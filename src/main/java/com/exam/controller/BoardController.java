package com.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.board.BoardService;
import com.example.board.BoardVO;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/board")
@Controller
public class BoardController {
  
	@Autowired
	BoardService  service;
	
	@GetMapping("/form")	
	private String form( ) {
		
		return "board/form.html";		
	}	
	

	@GetMapping("/insert")	
	private String insert(BoardVO vo,  Model  model , HttpSession  session  ) {
		
		int totalCount = service.insert(vo);
		
		model.addAttribute("totalCount", totalCount);
		
		return "redirect:/board/getBoardList";		
	}
	
	@GetMapping("/update")	
	private String update(BoardVO vo  ) {		
		service.update(vo);			
		return "redirect:/board/getBoardList";		
	}
	
	@GetMapping("/delete")	
	private String delete(BoardVO vo  ) {
		
		System.out.println("삭제:" + vo);
				
		return "redirect:/board/getBoardList";		
	}
	
	
	@GetMapping("/getBoardList")	
	private String getBoardList( Model  model , BoardVO vo ) {
		model.addAttribute("li", service.getBoardList(vo)) ;
		return "board/getBoardList.html";		
	}	
	
	@GetMapping("/getBoard")	
	private String getBoard( Model  model , BoardVO vo ) {
		System.out.println("getBoard:" + vo);
		model.addAttribute("m", service.getBoard(vo)) ;
		return "board/getBoard.html";		
	}	
}
