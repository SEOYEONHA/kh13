package com.kh.spring16;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class EncryptTest04 {
	
	@Test
	public void test() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		String origin = "hello world";
		String result = encoder.encode(origin);
		
		log.debug("origin = {}", origin);
		log.debug("result = {}", result);
	}
}
