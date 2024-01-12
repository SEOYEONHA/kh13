package com.kh.spring01.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//페이지를 생성하는 도구
@RestController
public class HelloController {
	
	@RequestMapping("/home")
	public String home() {
		return "Hello Spring Boot!";
	}
	
	@RequestMapping("/kh")
	public String kh() {
		return "KH정보교육원";
	}
}
