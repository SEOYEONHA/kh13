package com.kh.spring13;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class LoggingTest03 {

	@Test
	public void test() {
		//logging의 홀더 사용법
		//- slf4j에서 문장 내에 중괄호를 넣으면 홀더 역할을 한다
		//- 문장 뒤에 홀더 개수만큼의 데이터를 콤마로 연결하여 배치
		//- 실행 시 홀더와 데이터가 자동으로 합쳐져서 출력됨
		log.debug("10 + 20 = 30");
		
		int a = 10 , b = 20;
		log.debug(a + " + " + b + " = " + (a+b));
		log.debug("{} + {} = {}", a, b, a+b);
	}
	
}



