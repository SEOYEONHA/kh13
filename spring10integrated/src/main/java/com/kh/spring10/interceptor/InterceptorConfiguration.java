package com.kh.spring10.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//application.properties에서 하기 힘든 설정들을 이곳에서 구현할 수 있다
//[1] 상속을 통한 자격 획득 (WebMvcConfigurer)
//[2] 등록
//[3] 필요한 메소드를 재정의하여 설정 구현
@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer{
	@Autowired
	private TestInterceptor testInterceptor;
	
	@Autowired
	private MemberInterceptor memberInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//registry에다가 인터셉터를 주소와 함께 등록
		//registry.addInterceptor(인터샙터객체).addPathPatterns(주소);
		//registry.addInterceptor(testInterceptor).addPathPatterns("/**"); // testInterceptor이 아이를 모든주소에 전부다 라는 뜻
		//registry.addInterceptor(testInterceptor).addPathPatterns("/pocketmon/list", "/emp/list");
	
		registry.addInterceptor(memberInterceptor).addPathPatterns("/member/mypage");
		
	}
}
