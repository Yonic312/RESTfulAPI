package com.exam.controller;

import java.net.http.HttpRequest;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.guestBook.GuestBookService;
import com.example.guestBook.GuestBookVO;

import jakarta.servlet.http.HttpServletRequest;

@RequestMapping("/guestBook")
@Controller
public class GuestBookController {
	GuestBookController(){
		System.out.println("===> GuestBookController ");
	}
	
	@Autowired GuestBookService service;
	
	@GetMapping("/insert")
    public String insert(GuestBookVO vo) {
		System.out.println("===> insert ");
		
		Random random = new Random();
		String[] name = {"하니","두리","지효","지솔","태익","골댕","대상","지수","진상","한강"};
		String[] fname = {"김","박","진","강","태","조","홍","차","송","이"};
		
		String[] memo = {"안녕하세요", "반가워요", "배고파요", "졸려요", "슬퍼요", 
				"행복해요", "집이 그리워요", "마음에 들어요"};
		
		for (int i = 0; i < 125; i++) {
			int age = random.nextInt(111);
			vo.setName(fname[random.nextInt(name.length)] + name[random.nextInt(fname.length)]);
			vo.setAge(age);
			vo.setMemo(memo[random.nextInt(memo.length)]);
			service.insert(vo);
		}
		System.out.println("insert 완료");
		return "redirect:/index"; 	
    	}
	
	@GetMapping("/list")
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
    	
    	// 페이지의 시작과 끝
    	if(vo.getPz() > vo.getNowPage()) {
    	int ps = 1;
    	model.addAttribute("ps",ps);
    	model.addAttribute("pe",ps + 8);
    	} else {
    	int ps = (vo.getNowPage()/10)*10;
    		model.addAttribute("ps",ps);
        	model.addAttribute("pe",ps+9);
    	}
    	
    	// 검색
    	vo.setCh1(request.getParameter("ch1"));
    	model.addAttribute("ch1", request.getParameter("ch1"));
    	
    	vo.setCh2(request.getParameter("ch2"));
    	model.addAttribute("ch2", request.getParameter("ch2"));
    	System.out.println("ch2 : " + request.getParameter("ch2"));
    	
    	model.addAttribute("li",service.list(vo));
    	System.out.println("리스트 종료");
		return "/guestBook/list";    	
    }
}
