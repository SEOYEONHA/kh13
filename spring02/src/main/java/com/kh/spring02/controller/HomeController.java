package com.kh.spring02.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //등록 코드
public class HomeController {
	
	@RequestMapping("/home")
	public String home() {
		return "안녕 친구들";
	}
}
