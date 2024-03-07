package com.kh.spring12;

import java.util.Properties;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

//스프링 테스트
//- 스프링에서 제공하는 테스트를 위한 도구들
//- 자바 진영에서는 JUnit이라는 압도적으로 유명한 테스트 도구가 있다
//- 스프링에서는 JUnit을 쓸 수 있도록 연결고리를 제공한다

@SpringBootTest //스프링 테스트 파일임을 표시(기존 환경과 연동됨)
public class SendMailTest01 {
	
	@Test //테스트 케이스임을 표시(메소드 이름은 자유며 형식은 유지해야함)
	public void test() {
		
		//이메일을 전송하려면 전송도구가 필요하다
		JavaMailSenderImpl sender = new JavaMailSenderImpl();
		sender.setHost("smtp.gmail.com"); //업체의 호스트 정보
		sender.setPort(587); //업체의 포트번호
		sender.setUsername("yeonhaseo570@gmail.com"); //계정
		sender.setPassword("Yeonhaseo570!@"); //비밀번호
		
		//통신과 관련된 추가 설정
		Properties props = new Properties(); //자바에서 제공하는 문자열 Map
		props.setProperty("mail.smtp.auth", "true"); //인증 후 이용 설정(필수)
		props.setProperty("mail.smtp.debug", "true"); //디버깅 이용 설정(선택)
		props.setProperty("mail.smtp.starttls.enable", "true"); //TLS사용 설정(필수)
		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2"); //TLS 버전 설정(필수)
		props.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com"); //신뢰할 수 있는 대상으로 설정(필수)
		sender.setJavaMailProperties(props);
		
		//메세지 생성
		SimpleMailMessage message = new SimpleMailMessage();
		
//		message.setTo("받는사람1", "받는사람2", "받는사람3");
//		message.setCc("참조대상1", "참조대상2", "참조대상3");
//		message.setBcc("숨은참조대상1", "숨은참조대상2");
		message.setTo("only3322@naver.com");
		message.setCc("kh13soyeon@gmail.com");
		message.setSubject("테스트");
		message.setText("테스트 내용");
		
		//전송
		sender.send(message);
	}

}
