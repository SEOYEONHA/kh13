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
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class KakaoPayTest03 {

	@Test
	public void test( ) throws URISyntaxException, JsonProcessingException {
		//카카오페이 서버에 결제 준비(ready) 요청을 보내보자!
		//신버전 코드(카카오페이 개발자센터가 따로 생김)
		
		//요청 전송 도구 생성
		RestTemplate template = new RestTemplate();
		
		//주소 생성
		URI uri = new URI("https://open-api.kakaopay.com/online/v1/payment/approve");
		
		//헤더 생성
		HttpHeaders header = new HttpHeaders();
		header.add("Authorization", "SECRET_KEY DEV3350CDA48FC064BA68D29380D7A68AD964960");
		header.add("Content-Type", "application/json");
		
		//바디 생성
		//MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		Map<String, String> body = new HashMap<>();
		body.put("cid", "TC0ONETIME");
		body.put("tid", "T60e085a65886da99b52");
		body.put("pg_token", "05712f936d5d3339f279");
		body.put("partner_order_id", "fa490e02-2445-4e38-a6d6-1dc6e77cbd6b");
		body.put("partner_user_id", "testuser1");
		
		//통신 요청
		HttpEntity entity = new HttpEntity(body, header);//헤더+바디
		
		Map response = template.postForObject(uri, entity, Map.class);
		log.debug("response = {}", response);
		
	}
	
}