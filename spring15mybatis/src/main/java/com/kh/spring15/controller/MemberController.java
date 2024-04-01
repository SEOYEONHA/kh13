package com.kh.spring15.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring15.dao.MemberDao;
import com.kh.spring15.vo.MemberComplexVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MemberController {
	
	//빈문자열을 null로 처리하는 도구 설정
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}
	
	@Autowired
	private MemberDao memberDao;

	//회원에 대한 복합검색 페이지
	@RequestMapping("/complex")
	public String complex(@ModelAttribute MemberComplexVO vo, Model model) {
		model.addAttribute("vo", vo);
		model.addAttribute("list", memberDao.selectList(vo));
		return "/WEB-INF/views/complex.jsp";
	}
}
