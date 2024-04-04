package com.kh.spring17.controller;

import java.net.URISyntaxException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring17.service.KakaoPayService;
import com.kh.spring17.vo.KakaoPayReadyRequestVO;
import com.kh.spring17.vo.KakaoPayReadyResponseVO;

@Controller
@RequestMapping("/pay1")
public class Pay1Controller {
	
	@Autowired
	private KakaoPayService kakaoPayService;
	
	@GetMapping("/purchase")
	public String purchase() {
		return "/pay1/purchase";
	}
	@PostMapping("/purchase")
	public String purchase(@ModelAttribute KakaoPayReadyRequestVO requestVO) throws URISyntaxException {
		requestVO.setPartnerOrderId(UUID.randomUUID().toString());
		requestVO.setPartnerUserId("testuser1");
		
		KakaoPayReadyResponseVO responseVO = kakaoPayService.ready(requestVO);
		
		return "redirect:" + responseVO.getNextRedirectPcUrl();
	}
	
}
