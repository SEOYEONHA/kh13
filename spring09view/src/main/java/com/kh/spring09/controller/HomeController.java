package com.kh.spring09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/home")
	public String welcome() {
		return "/WEB-INF/views/home.jsp";
	}
	
	@RequestMapping("/dummy")
	public String dummy() {
		return "/WEB-INF/views/dummy.jsp";
	}
}
