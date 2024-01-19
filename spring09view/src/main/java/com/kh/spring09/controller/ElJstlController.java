package com.kh.spring09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/el-jstl")
public class ElJstlController {
	
	@RequestMapping("/test01")
	public String test01(Model model) {
		model.addAttribute("a", 100);
		model.addAttribute("b", "hello");
		model.addAttribute("c", 3.14);
		return "/WEB-INF/views/elJstl/test01.jsp";
	}

}
