package com.kh.spring18.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring18.dao.MemberDao;
import com.kh.spring18.dto.MemberDto;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/page")
public class PageController {
	
	@Autowired
	private MemberDao memberDao;
	
	@PostMapping("/login")
	public String login(@ModelAttribute MemberDto memberDto, HttpSession session) { //웹소켓세션이랑 다르다는점 항상 주의
		MemberDto findDto = memberDao.selectOneByMemberPw(memberDto);
		if(findDto != null) { //로그인 성공
			session.setAttribute("loginId", findDto.getMemberId());
			session.setAttribute("loginLevel", findDto.getMemberLevel());
		}
		return "redirect:/page/";
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.removeAttribute("loginId");
		session.removeAttribute("loginLevel");
		return "redirect:/page/";
	}
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	
	@RequestMapping("/basic")
	public String basic() {
		return "basic";
	}
	
	@RequestMapping("/simple")
	public String simple() {
		return "simple";
	}
	
	@RequestMapping("/chatbot")
	public String chatbot() {
		return "chatbot";
	}
	
	@RequestMapping("/group")
	public String group() {
		return "group";
	}
	
	@RequestMapping("/json")
	public String json() {
		return "json";
	}
	
	@RequestMapping("/member")
	public String member() {
		return "member";
	}

}
