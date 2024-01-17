package com.kh.spring09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HtmlController {
	
	@RequestMapping("/heading")
	public String heading() {
		return "/WEB-INF/views/heading.jsp";
	}
	
	@RequestMapping("/image")
	public String image() {
		return "/WEB-INF/views/image.jsp";
	}
	
	@RequestMapping("/snslogin")
	public String snsLogin() {
		return "/WEB-INF/views/snsLogin.jsp";
	}
	
	@RequestMapping("/dummy")
	public String dummy() {
		return "/WEB-INF/views/dummy.jsp";
	}
	
	@RequestMapping("/link")
	public String link() {
		return "/WEB-INF/views/link.jsp";
	}
}
