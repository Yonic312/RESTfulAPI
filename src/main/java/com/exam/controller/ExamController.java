package com.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.board.BoardService;
import com.example.exam.ExamService;
@RequestMapping("/exam")
@Controller
public class ExamController {
	
	@Autowired
	ExamService  service;
	
	@GetMapping("/getExamList")	
	private String getExamList(Model  model ) {
		model.addAttribute("li", service.getExamList(null));
		return "exam/getExamList.html";		
	}	
	
}
