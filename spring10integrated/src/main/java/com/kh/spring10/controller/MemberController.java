package com.kh.spring10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring10.dao.MemberDao;
import com.kh.spring10.dto.MemberDto;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberDao dao;
	
	
	//회원가입
	@GetMapping("/join")
	public String join() {
		return "/WEB-INF/views/member/join.jsp";
	}
	@PostMapping("/join")
	public String join(@ModelAttribute MemberDto dto) {
		dao.insert(dto);
		return "redirect:joinFinish";
	}
	@RequestMapping("/joinFinish")
	public String joinFinish() {
		return "/WEB-INF/views/member/joinFinish.jsp";
	}
	
	//로그인
	@GetMapping("/login")
	public String login() {
		return "/WEB-INF/views/member/longin.jsp";
	}
	@PostMapping("/login")
	public String login(Model model,
							@ModelAttribute MemberDto dto,
							@RequestParam String memberId,
							@RequestParam String memberPw) {
		boolean pass = memberId.equals(dto.getMemberId()) && memberPw.equals(dto.getMemberPw());
		model.addAttribute("dto", dto);
		model.addAttribute("pass", pass);
		if(pass) {
			return "/WEB-INF/views/home";
		}
		else {
			return "/WEB-INF/views/member/login.jsp";
		}
	}
	
	
			
}
