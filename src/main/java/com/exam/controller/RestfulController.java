package com.exam.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.guestBook.GuestBookService;
import com.example.guestBook.GuestBookVO;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("Restful")
public class RestfulController {
	@Autowired
	private GuestBookService service;
	
	@GetMapping(value="/list" , produces="application/json; charset=UTF-8")
    public String getGuestBookList(GuestBookVO vo, Model model, HttpServletRequest request) {
		System.out.println("===> list ");

    	// 페이징
		model.addAttribute("nowPage",request.getParameter("nowPage"));
    	model.addAttribute("tc",service.getTc(vo));
    	
    	// tp : 전체 페이지
    	int tp = 0;
    	if(service.getTc(vo) % 10 == 0) {
    		tp = service.getTc(vo) / 10;
    	} else {
    		tp = (service.getTc(vo) / 10) + 1;
    	}
    	model.addAttribute("tp", tp);
    	
    	// pz : 페이지 사이즈
    	model.addAttribute("pz",vo.getPz());
    	
    	// 쿼리의 시작과 끝
    	vo.setQs((Integer.parseInt(request.getParameter("nowPage")) - 1) * vo.getPz() + 1); // 1, 11, 21, 31 : (nowPage-1) * pageSize +1 
    	vo.setQe(vo.getQs()+9); // 10, 20, 30, 40 : Qs + 9
    	
    	System.out.println();
    	
    	int ps = 1;
    	// 페이지의 시작과 끝
    	if(vo.getPz() > vo.getNowPage()) {
    	
    	model.addAttribute("ps",ps);
    	model.addAttribute("pe",ps + 8);
    	} else {
    	ps = (vo.getNowPage()/10)*10;
    		model.addAttribute("ps",ps);
        	model.addAttribute("pe",ps+9);
    	}
    	
    	// 검색
    	vo.setCh1(request.getParameter("ch1"));
    	model.addAttribute("ch1", request.getParameter("ch1"));
    	
    	vo.setCh2(request.getParameter("ch2"));
    	model.addAttribute("ch2", request.getParameter("ch2"));
    	
    	model.addAttribute("li",service.list(vo));
    	System.out.println("리스트 종료");
    	
    	Map<String, Object> resultMap = new HashMap<>();
    	resultMap.put("nowPage",request.getParameter("nowPage")); // 값 넣기 
    	resultMap.put("tc",service.getTc(vo));
    	resultMap.put("tp", tp);
    	resultMap.put("pz",vo.getPz());
    	
    	if(vo.getPz() > vo.getNowPage()) {
        	
    		resultMap.put("ps",ps);
    		resultMap.put("pe",ps + 8);
        	} else {
        	ps = (vo.getNowPage()/10)*10;
        		resultMap.put("ps",ps);
        		resultMap.put("pe",ps+9);
        	}
    	
    	resultMap.put("ch1", request.getParameter("ch1"));
    	resultMap.put("ch2", request.getParameter("ch2"));
    	resultMap.put("li",service.list(vo));
    	resultMap.put("nowPage",request.getParameter("nowPage"));
    	resultMap.put("tc",service.getTc(vo));
    	resultMap.put("tp", tp);
    	resultMap.put("pz",vo.getPz());
    	
ObjectMapper mapper = new ObjectMapper();
		
		try {
			return  mapper.writeValueAsString(resultMap);
		}catch( Exception e ){
			e.printStackTrace();
			return null;    
		}
	}
		
		@GetMapping(value="/list2" , produces="application/json; charset=UTF-8")
	    public String getGuestBookList2(GuestBookVO vo, Model model, HttpServletRequest request) {
			System.out.println("===> list ");

	    	// 페이징
			model.addAttribute("nowPage",request.getParameter("nowPage"));
	    	model.addAttribute("tc",service.getTc(vo));
	    	
	    	// tp : 전체 페이지
	    	int tp = 0;
	    	if(service.getTc(vo) % 10 == 0) {
	    		tp = service.getTc(vo) / 10;
	    	} else {
	    		tp = (service.getTc(vo) / 10) + 1;
	    	}
	    	model.addAttribute("tp", tp);
	    	
	    	// pz : 페이지 사이즈
	    	model.addAttribute("pz",vo.getPz());
	    	
	    	// 쿼리의 시작과 끝
	    	vo.setQs((Integer.parseInt(request.getParameter("nowPage")) - 1) * vo.getPz() + 1); // 1, 11, 21, 31 : (nowPage-1) * pageSize +1 
	    	vo.setQe(vo.getQs()+9); // 10, 20, 30, 40 : Qs + 9
	    	
	    	System.out.println();
	    	
	    	int ps = 1;
	    	// 페이지의 시작과 끝
	    	if(vo.getPz() > vo.getNowPage()) {
	    	
	    	model.addAttribute("ps",ps);
	    	model.addAttribute("pe",ps + 8);
	    	} else {
	    	ps = (vo.getNowPage()/10)*10;
	    		model.addAttribute("ps",ps);
	        	model.addAttribute("pe",ps+9);
	    	}
	    	
	    	// 검색
	    	vo.setCh1(request.getParameter("ch1"));
	    	model.addAttribute("ch1", request.getParameter("ch1"));
	    	
	    	vo.setCh2(request.getParameter("ch2"));
	    	model.addAttribute("ch2", request.getParameter("ch2"));
	    
	    	vo.setTc(service.getTc(vo));
	    	model.addAttribute("li",service.list2(vo));
	    	System.out.println("리스트 종료");
	    	
	    	Map<String, Object> resultMap = new HashMap<>();
	    	resultMap.put("nowPage",request.getParameter("nowPage")); // 값 넣기 
	    	resultMap.put("tc",service.getTc(vo));
	    	resultMap.put("tp", tp);
	    	resultMap.put("pz",vo.getPz());
	    	
	    	if(vo.getPz() > vo.getNowPage()) {
	        	
	    		resultMap.put("ps",ps);
	    		resultMap.put("pe",ps + 8);
	        	} else {
	        	ps = (vo.getNowPage()/10)*10;
	        		resultMap.put("ps",ps);
	        		resultMap.put("pe",ps+9);
	        	}
	    	resultMap.put("qs", (Integer.parseInt(request.getParameter("nowPage")) - 1) * vo.getPz() + 1);
	    	resultMap.put("qe", ((Integer.parseInt(request.getParameter("nowPage")) - 1) * vo.getPz() + 1)+9);
	    	
	    	resultMap.put("ch1", request.getParameter("ch1"));
	    	resultMap.put("ch2", request.getParameter("ch2"));
	    	resultMap.put("li",service.list2(vo));
	    	resultMap.put("nowPage",request.getParameter("nowPage"));
	    	resultMap.put("tc",service.getTc(vo));
	    	resultMap.put("tp", tp);
	    	resultMap.put("pz",vo.getPz());
	    	
	ObjectMapper mapper = new ObjectMapper();
			
			try {
				return  mapper.writeValueAsString(resultMap);
			}catch( Exception e ){
				e.printStackTrace();
				return null;    
			}		

	}
}
