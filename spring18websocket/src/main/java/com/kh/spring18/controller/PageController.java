package com.kh.spring18.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class PageController {
	
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

}
