package com.kh.spring16;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class EncryptTest01 {
	
	@Test
	public void test() {
		//암호화(Encryption) - 대상을 어떤 방식으로 변조하는 것
		String origin = "hello world";
		
		//시저 암호화(caesar) - 글자를 주어진 offset만큼 회전시키는 방식
		StringBuffer buffer = new StringBuffer(); //임시 저장소 준비
		for(int i = 0 ; i < origin.length(); i ++) { //origin의 모든 글자를 조회하여
			char ch = origin.charAt(i); //현재 위치의 글자를 꺼내고
			ch += 3; //정해진 값만큼 증가시키고
			buffer.append(ch); //임시 저장소에 추가
		}
		
		log.debug("원래 문자열 = {}", origin);
		log.debug("암호화 결과 = {}", buffer);
	}

}
