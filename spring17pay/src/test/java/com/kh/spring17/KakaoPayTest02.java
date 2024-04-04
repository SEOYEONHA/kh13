package com.kh.spring17;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class KakaoPayTest02 {

	@Test
	public void test( ) throws URISyntaxException, JsonProcessingException {
		//카카오페이 서버에 결제 준비(ready) 요청을 보내보자!
		//신버전 코드(카카오페이 개발자센터가 따로 생김)
		
		//요청 전송 도구 생성
		RestTemplate template = new RestTemplate();
		
		//주소 생성
		URI uri = new URI("https://open-api.kakaopay.com/online/v1/payment/ready");
		
		//헤더 생성
		HttpHeaders header = new HttpHeaders();
		header.add("Authorization", "SECRET_KEY DEV3350CDA48FC064BA68D29380D7A68AD964960");
		header.add("Content-Type", "application/json");
		
		//바디 생성
		Map<String, String> body = new HashMap<>();
		body.put("cid", "TC0ONETIME");
		body.put("partner_order_id", UUID.randomUUID().toString());
		body.put("partner_user_id", "testuser1");
		body.put("item_name", "초코파이 외 1개");
		body.put("quantity", "1");
		body.put("total_amount", "4500");
		body.put("tax_free_amount", "0");
		body.put("approval_url", "http://localhost:8080/success");
		body.put("cancel_url", "http://localhost:8080/cancel");
		body.put("fail_url", "http://localhost:8080/fail");
		
		//통신 요청
		HttpEntity entity = new HttpEntity(body, header);//헤더+바디
		
		Map response = template.postForObject(uri, entity, Map.class);
		//log.debug("response = {}", response);
		log.debug("partner_order_id = {}", body.get("partner_order_id"));
		log.debug("partner_user_id = {}", body.get("partner_user_id"));
		log.debug("tid = {}", response.get("tid"));
		log.debug("주소 = {}", response.get("next_redirect_pc_url"));
	}
	
}