package com.kh.spring16;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class EncryptTest05 {
	
	@Test
	public void test() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		String input = "hello world";
		String db = "$2a$10$wqkDT.DNcLL2d8SQjigTle668x9ByYr3cQnsKlUdDeYruk7UtBEbi";
		
		//비교할 때도 반드시 encoder를 사용해야 한다
		boolean isValid = encoder.matches(input, db);
		log.debug("isValid = {}", isValid);
	}
}
