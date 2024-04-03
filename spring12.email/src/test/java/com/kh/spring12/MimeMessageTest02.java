package com.kh.spring12;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class MimeMessageTest02 {
	
	@Autowired
	private JavaMailSender sender;
	
	@Test
	public void test() throws MessagingException, IOException {
		//MimeMessage는 여러가지 옵션을 설정할 수 있는 메세지
		
		//메세지 객체 생성
		MimeMessage message = sender.createMimeMessage();
		
		//도우미 객체 생성 = 파일전송은 안하고 UTF-8로 변환해서 전송하겠다
		MimeMessageHelper helper = new MimeMessageHelper(message, false, "UTF-8");
		
		//헬퍼에 정보를 설정
		helper.setTo(new String[]{"only3322@naver.com", "rysin12346@gmail.com"});
		helper.setSubject("집에 가고싶나요?");
		
		//내용을 외부 파일에서 불러와 전송하도록 구현
		ClassPathResource resource = new ClassPathResource("templates/email-template.html"); //탐색
		File target = resource.getFile(); //파일 추출
		
		StringBuffer buffer = new StringBuffer(); //문자열 합성 도구 생성
		Scanner sc = new Scanner(target); //파일을 읽을 수 있는 도구 생성
		while(sc.hasNextLine()) { //읽을 수 있는 줄이 남아있다면 반복하여 실행
			buffer.append(sc.nextLine()); //한 줄을 읽어 buffer에 추가
		}
		sc.close();
		
		helper.setText(buffer.toString(), true); //읽은 내용을 전송
		
		
		
		//전송
		sender.send(message);
		
	}

}
