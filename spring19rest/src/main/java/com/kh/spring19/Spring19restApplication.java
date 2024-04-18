package com.kh.spring19;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//Spring Security 기본 시스템 설정 해제
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class Spring19restApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring19restApplication.class, args);
	}

}
