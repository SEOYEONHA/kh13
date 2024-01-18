package com.kh.spring10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	//수정 페이지
	//- 등록과 매우 유사한 흐름을 가진다
	//- 입력된 정보 중 기본키를 제외한 나머지 정보를 수정한다
	//- 수정이 될 수도 안될 수도 있다 -> 그에 따른 결과 페이지가 달라진다
	
	@GetMapping("/edit")
	public String edit() {
		return "/WEB-INF/views/pocketmon/edit.jsp";
	}
	@PostMapping("/edit")
	public String edit(@ModelAttribute PocketmonDto dto) {
		if(dao.update(dto)) {
			//return "redirect:/pocketmon/editSuccess";
			return "redirect:editSuccess";
		}
		else {
			//return "redirect:/pocketmon/editFail";
			return "redirect:editFail";
		}
	}
	@RequestMapping("/editSuccess")
	public String editSuccess() {
		return "/WEB-INF/views/pocketmon/editSuccess.jsp";
	}
	@RequestMapping("/editFail")
	public String editFaile() {
		return "/WEB-INF/views/pocketmon/editFail.jsp";
	}
	
	
	
	
	
	
	
	
}
