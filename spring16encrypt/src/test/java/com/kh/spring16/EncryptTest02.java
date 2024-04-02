package com.kh.spring16;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class EncryptTest02 {
	
	@Test
	public void test() {
		//언제든지 되돌릴 수 있기 때문에 양방향 암호화 라고 함!!
		
		//XOR 암호화
		
		String origin = "hello world";
		int offset = 3;
		
		StringBuffer buffer = new StringBuffer(); //임시 저장소 준비
		for(int i = 0 ; i < origin.length(); i ++) { //origin의 모든 글자를 조회하여
			char ch = origin.charAt(i); //현재 위치의 글자를 꺼내고
			ch ^= offset;
			buffer.append(ch); 
		}
		
		log.debug("원래 문자열 = {}", origin);
		log.debug("암호화 결과 = {}", buffer);
	}
	

}
