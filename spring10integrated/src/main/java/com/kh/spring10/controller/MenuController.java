package com.kh.spring10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring10.dao.MenuDao;
import com.kh.spring10.dto.MenuDto;

@Controller
@RequestMapping("/menu")
public class MenuController {

	@Autowired
	private MenuDao dao;
	
	//등록 페이지
	@GetMapping("/insert")
	public String insert() {
		return "/WEB-INF/views/menu/insert.jsp";
	}
	
	@PostMapping("/insert")
	public String insert(@ModelAttribute MenuDto dto) {
		dao.insert(dto);
		return "redirect:insertComplete";
	}
	
	@RequestMapping("/insertComplete")
	public String insertComplete() {
		return "/WEB-INF/views/menu/insertComplete.jsp";
	}
	
	//수정 페이지
	@GetMapping("/change")
	public String change(@RequestParam int menuNo, Model model) {
		MenuDto dto = dao.selectOne(menuNo);
		model.addAttribute("dto", dto);
		if(dto == null) {
			return "redirect:changeFail";
		}
		else {
			return "/WEB-INF/views/menu/change.jsp";
		}
	}
	@PostMapping("/change")
	public String change(@ModelAttribute MenuDto dto) {
			return "redirect:chageSuccess";
	}
	
	@RequestMapping("/changeSuccess")
	public String chageSuccess() {
		return "/WEB-INF/views/menu/changeSuccess.jsp";
	}
	@RequestMapping("/changeFail")
	public String chageFail() {
		return "/WEB-INF/views/menu/changeFail.jsp";
	}
}