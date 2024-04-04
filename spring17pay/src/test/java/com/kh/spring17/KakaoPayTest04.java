package com.kh.spring17;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kh.spring17.configuration.KakaoPayProperties;
import com.kh.spring17.vo.KakaoPayReadyRequestVO;
import com.kh.spring17.vo.KakaoPayReadyResponseVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class KakaoPayTest04 {
	
	@Autowired
	private KakaoPayProperties kakaoPayProperties;

	@Test
	public void test( ) throws URISyntaxException, JsonProcessingException {
		//카카오페이 서버에 결제 준비(ready) 요청을 보내보자!
		//신버전 코드(카카오페이 개발자센터가 따로 생김)
		
		//결제에 필요한 정보를 미리 생성
		KakaoPayReadyRequestVO requestVO = KakaoPayReadyRequestVO
																		.builder().partnerOrderId(UUID.randomUUID().toString())
																		.partnerUserId("testuser1")
																		.itemName("자바 하루 무료 수강권")
																		.totalAmount(55555)
																	.build();
		
		//요청 전송 도구 생성
		RestTemplate template = new RestTemplate();
		
		//주소 생성
		URI uri = new URI("https://open-api.kakaopay.com/online/v1/payment/ready");
		
		//헤더 생성
		HttpHeaders header = new HttpHeaders();
		header.add("Authorization", "SECRET_KEY " + kakaoPayProperties.getKey());
		header.add("Content-Type", "application/json");
		
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
		body.put("approval_url", "http://localhost:8080/success");
		body.put("cancel_url", "http://localhost:8080/cancel");
		body.put("fail_url", "http://localhost:8080/fail");
		
		//통신 요청
		HttpEntity entity = new HttpEntity(body, header);//헤더+바디
		
		//Map response = template.postForObject(uri, entity, Map.class);
		KakaoPayReadyResponseVO responseVO = 
				template.postForObject(uri, entity, KakaoPayReadyResponseVO.class);
//		log.debug("response = {}", response);
		log.debug("partner_order_id = {}", requestVO.getPartnerOrderId());
		log.debug("partner_user_id = {}", requestVO.getPartnerUserId());
		log.debug("tid = {}", responseVO.getTid());
		log.debug("주소 = {}", responseVO.getNextRedirectPcUrl());
		
	}
	
}