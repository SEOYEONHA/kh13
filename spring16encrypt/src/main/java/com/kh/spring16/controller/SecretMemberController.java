package com.kh.spring16.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.kh.spring16.dao.SecretMemberDao;

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

}
