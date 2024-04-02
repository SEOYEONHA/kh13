package com.kh.spring16.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring16.dao.SecretMemberDao;
import com.kh.spring16.dto.SecretMemberDto;

import jakarta.servlet.http.HttpSession;

@Controller
public class SecretMemberController {
	
	@Autowired
	private SecretMemberDao secretMemberDao;
	
	//회원가입
	@GetMapping("/join")
	public String join() {
		//return "/WEB-INF/views/join.jsp";
		return "join"; //application.properties에 등록해놔서 이제 이렇게만 써도 됨
	}
	
	@PostMapping("/join")
	public String join(@ModelAttribute SecretMemberDto secretMemberDto) {
		secretMemberDao.insert(secretMemberDto);
		return "redirect:join";
	}
	
	//로그인
	@GetMapping("/login")
	public String login() {
		//return "/WEB-INF/views/member/login.jsp";
		//return "member/login";
		return "login";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute SecretMemberDto secretMemberDto, HttpSession session) {
		
		SecretMemberDto findDto = secretMemberDao.selectOneByMemberPw(secretMemberDto);
		
		if(findDto != null) {
			session.setAttribute("loginId", findDto.getMemberId());
			return "redirect:/";
		}
		else {
			return "redirect:login?error";
		}
	}
	
	//로그아웃
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("loginId");
		return "redirect:/";
	}
	
	
	//메인페이지
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
