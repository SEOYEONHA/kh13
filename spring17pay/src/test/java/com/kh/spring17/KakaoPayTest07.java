package com.kh.spring17;

import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring17.service.KakaoPayService;
import com.kh.spring17.vo.KakaoPayCancelRequestVO;
import com.kh.spring17.vo.KakaoPayCancelResponseVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class KakaoPayTest07 {

	@Autowired
	private KakaoPayService kakaoPayService;
	
	@Test
	public void test() throws URISyntaxException {
		//취소 테스트
		KakaoPayCancelRequestVO requestVO = KakaoPayCancelRequestVO.builder()
					.tid("T60e357a65886da99c0e")
					.cancelAmount(500)
				.build();
		
		KakaoPayCancelResponseVO responseVO = 
									kakaoPayService.cancel(requestVO);
		
		log.debug("responseVO = {}", responseVO);
	}
	
}