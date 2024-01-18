package com.kh.spring10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring10.dao.PocketmonDao;
import com.kh.spring10.dto.PocketmonDto;

@Controller
@RequestMapping("/pocketmon")
public class PocketmonController {
	
	@Autowired
	private PocketmonDao dao;
	
	//등록을 위한 페이지들
	@RequestMapping("/insert1")
	public String insert1() {
		return "/WEB-INF/views/pocketmon/insert1.jsp";
	}
	
	@RequestMapping("/insert2")
	public String insert2(@ModelAttribute PocketmonDto dto) {
		dao.insert(dto);
		return "redirect:insert3"; //리다이렉트(다른 주소로 강제 이동) - 상대경로
		//return "redirect:/pocketmon/insert3"; //리다이렉트 - 절대경로
	}
	
	@RequestMapping("/insert3")
	public String insert3() {
		return "/WEB-INF/views/pocketmon/insert3.jsp";
	}
	
	
}
