package com.kh.spring12;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

//미리 만들어준 도구를 불러와서 이메일을 발송
@SpringBootTest
public class SendMailTest02 {
	
	@Autowired
	private JavaMailSenderImpl sender;
	
	@Test
	public void test() {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo("only3322@naver.com");
		message.setSubject("테스트 제목");
		message.setText("테스트 내용");
		
		sender.send(message);
	}
}
