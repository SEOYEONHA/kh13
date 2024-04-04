package com.kh.spring17.controller;

import java.net.URISyntaxException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring17.service.KakaoPayService;
import com.kh.spring17.vo.KakaoPayApproveRequestVO;
import com.kh.spring17.vo.KakaoPayApproveResponseVO;
import com.kh.spring17.vo.KakaoPayReadyRequestVO;
import com.kh.spring17.vo.KakaoPayReadyResponseVO;

import jakarta.servlet.http.HttpSession;

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
	public String purchase(@ModelAttribute KakaoPayReadyRequestVO requestVO, HttpSession session) throws URISyntaxException {
		requestVO.setPartnerOrderId(UUID.randomUUID().toString());
		requestVO.setPartnerUserId("testuser1");
		
		KakaoPayReadyResponseVO responseVO = kakaoPayService.ready(requestVO);
		
		//세션에 Flash Attribute를 추가
		session.setAttribute("partner_order_id", requestVO.getPartnerOrderId());
		session.setAttribute("partner_user_id", requestVO.getPartnerUserId());
		session.setAttribute("tid", responseVO.getTid());
		
		return "redirect:" + responseVO.getNextRedirectPcUrl();
	}
	
	//결제 성공 처리 페이지
	@GetMapping("/purchase/success")
	public String success(@RequestParam String pg_token, HttpSession session) throws URISyntaxException {
		
		KakaoPayApproveRequestVO requestVO = KakaoPayApproveRequestVO.builder()
																	.partnerOrderId((String)session.getAttribute("partner_order_id"))
																	.partnerUserId((String)session.getAttribute("partner_user_id"))
																	.tid((String)session.getAttribute("tid"))
																	.pgToken(pg_token)
																.build();
		
		//세션의 Flash Attribute를 제거
		session.removeAttribute("partner_order_id");
		session.removeAttribute("partner_user_id");
		session.removeAttribute("tid");
		
		KakaoPayApproveResponseVO responseVO = kakaoPayService.approve(requestVO);
		
		return "redirect:successComplete";
	}
	
	@GetMapping("/purchase/successComplete")
	public String successComplete() {
		return "/pay1/successComplete";
	}
	
	//결제 취소 처리 페이지
	//@GetMapping("/purcase/cancel")
	
	//결제 실패 처리 페이지
	
}
