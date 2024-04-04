package com.kh.spring17;

import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring17.service.KakaoPayService;
import com.kh.spring17.vo.KakaoPayApproveRequestVO;
import com.kh.spring17.vo.KakaoPayApproveResponseVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class KakaoPayTest06 {
	
	@Autowired
	private KakaoPayService kakaoPayService;
	
	@Test
	public void test() throws URISyntaxException {
		//데이터 준비 - KakaoPayApproveRequestVO
		KakaoPayApproveRequestVO requestVO = KakaoPayApproveRequestVO.builder()
															.tid("T60e357a65886da99c0e")
															.partnerOrderId("81ca18d2-aff1-4a46-9697-1f591734084a")
															.partnerUserId("testuser1")
															.pgToken("00e9975b352812794b3b")
														.build();
		//처리
		KakaoPayApproveResponseVO responseVO = kakaoPayService.approve(requestVO);
		
		//결과 출력 - KakaoPayApproveResponseVO
		log.debug("responseVO = {}", responseVO);
	}

}
