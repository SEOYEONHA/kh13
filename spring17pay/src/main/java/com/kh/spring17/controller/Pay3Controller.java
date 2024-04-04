package com.kh.spring17.controller;

import java.net.URISyntaxException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring17.dao.ProductDao;
import com.kh.spring17.dto.ProductDto;
import com.kh.spring17.service.KakaoPayService;
import com.kh.spring17.vo.KakaoPayApproveRequestVO;
import com.kh.spring17.vo.KakaoPayApproveResponseVO;
import com.kh.spring17.vo.KakaoPayReadyRequestVO;
import com.kh.spring17.vo.KakaoPayReadyResponseVO;
import com.kh.spring17.vo.PurchaseListVO;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/pay3")
public class Pay3Controller {
	
	@Autowired
	private KakaoPayService kakaoPayService;
	
	@Autowired
	private ProductDao productDao;
	
	@GetMapping("/purchase")
	public String purchase(Model model) {
		model.addAttribute("list", productDao.selectList());
		return "/pay3/purchase";
	}
	
	@PostMapping("/purchase")
	public String purchase(@ModelAttribute PurchaseListVO vo, HttpSession session) throws URISyntaxException {
		
		log.debug("size = {}", vo.getPurchase().size());
		log.debug("vo = {}", vo);
		
		//return "redirect:" + responseVO.getNextRedirectPcUrl();
		return null;
	}
	
	@GetMapping("/purchase/success")
	public String success(HttpSession session, @RequestParam String pg_token) throws URISyntaxException {
		KakaoPayApproveRequestVO requestVO = KakaoPayApproveRequestVO.builder()
																.partnerOrderId((String)session.getAttribute("partner_order_id"))
																.partnerUserId((String)session.getAttribute("partner_user_id"))
																.tid((String)session.getAttribute("tid"))
																.pgToken(pg_token)
															.build();
		KakaoPayApproveResponseVO responseVO = kakaoPayService.approve(requestVO);
		
		//세션의 Flash Attribute를 제거
		session.removeAttribute("partner_order_id");
		session.removeAttribute("partner_user_id");
		session.removeAttribute("tid");
		
		return "redirect:successComplete";
	}
	
	@GetMapping("/purchase/successComplete")
	public String successComplete() {
		return "/pay3/successComplete";
	}

}
