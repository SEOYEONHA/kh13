package com.kh.spring12;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring12.service.EmailService;

@SpringBootTest
public class SendMailTest04 {
	
	@Autowired
	private EmailService emailServcie;
	
	@Test
	public void test() {
		emailServcie.sendTempPassword("rysin12346@gmail.com");
	}

}
