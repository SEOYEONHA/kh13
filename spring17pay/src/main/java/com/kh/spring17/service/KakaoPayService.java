package com.kh.spring17.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kh.spring17.configuration.KakaoPayProperties;
import com.kh.spring17.vo.KakaoPayApproveRequestVO;
import com.kh.spring17.vo.KakaoPayApproveResponseVO;
import com.kh.spring17.vo.KakaoPayReadyRequestVO;
import com.kh.spring17.vo.KakaoPayReadyResponseVO;

@Service
public class KakaoPayService {
	
	@Autowired
	private KakaoPayProperties kakaoPayProperties;
	
	@Autowired
	private RestTemplate template;
	
	@Autowired
	private HttpHeaders header;
	
	//준비요청 메소드
	public KakaoPayReadyResponseVO ready(KakaoPayReadyRequestVO requestVO) throws URISyntaxException {
		//주소 생성
		URI uri = new URI("https://open-api.kakaopay.com/online/v1/payment/ready");
		
		//바디 생성
		//MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		Map<String, String> body = new HashMap<>();
		body.put("cid", kakaoPayProperties.getCid());
		body.put("partner_order_id", requestVO.getPartnerOrderId());
		body.put("partner_user_id", requestVO.getPartnerUserId());
		body.put("item_name", requestVO.getItemName());
		body.put("quantity", "1");
		body.put("total_amount", String.valueOf(requestVO.getTotalAmount()));
		body.put("tax_free_amount", "0");
		
		//구매페이지 주소의 뒤에 /success, /cancel, /fail을 붙여서 처리하도록 구현
		String page = ServletUriComponentsBuilder.fromCurrentRequestUri().build().toUriString();
		body.put("approval_url", page + "/success");
		body.put("cancel_url", page + "/cancel");
		body.put("fail_url", page + "/fail");
		
		//통신 요청
		HttpEntity entity = new HttpEntity(body, header);//헤더+바디
		
		return template.postForObject(uri, entity, KakaoPayReadyResponseVO.class);
	}
	
	//승인요청 메소드
	public KakaoPayApproveResponseVO approve(KakaoPayApproveRequestVO requestVO) throws URISyntaxException {
		//주소 생성
		URI uri = new URI("https://open-api.kakaopay.com/online/v1/payment/approve");
		
		//바디 생성
		//MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		Map<String, String> body = new HashMap<>();
		body.put("cid", kakaoPayProperties.getCid());
		body.put("tid", requestVO.getTid());
		body.put("pg_token", requestVO.getPgToken());
		body.put("partner_order_id", requestVO.getPartnerOrderId());
		body.put("partner_user_id", requestVO.getPartnerUserId());
		
		//통신 요청
		HttpEntity entity = new HttpEntity(body, header);//헤더+바디
		
		return template.postForObject(uri, entity, KakaoPayApproveResponseVO.class);
	}
	
	
	
	
	
	
	
	
	
}