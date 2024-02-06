package com.kh.spring10.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.kh.spring10.interceptor.AdminInterceptor;
import com.kh.spring10.interceptor.BoardInterceptor;
import com.kh.spring10.interceptor.BoardOwnerInterceptor;
import com.kh.spring10.interceptor.BoardReadcountInterceptor;
import com.kh.spring10.interceptor.MemberInterceptor;
import com.kh.spring10.interceptor.TestInterceptor;

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
	
	@Autowired
	private AdminInterceptor adminInterceptor;
	
	@Autowired
	private BoardInterceptor boardInterceptor;
	
	@Autowired
	private BoardReadcountInterceptor boardReadcountInterceptor;
	
	@Autowired
	private BoardOwnerInterceptor boardOwnerInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		
		//registry에다가 인터셉터를 주소와 함께 등록
		//registry.addInterceptor(인터샙터객체).addPathPatterns(주소);
		//registry.addInterceptor(testInterceptor).addPathPatterns("/**"); // testInterceptor이 아이를 모든주소에 전부다 라는 뜻
		//registry.addInterceptor(testInterceptor).addPathPatterns("/pocketmon/list", "/emp/list");
	
		//지정한 페이지만 허용하도록 설정
//		registry.addInterceptor(memberInterceptor)
//									.addPathPatterns("/member/mypage", "/member/password", 
//														"/member/change" /* 등등 */);
		
		//중간주소를 등록하고 특정페이지를 제외(exclude)
		//- 주소를 설정할 때 **와 *를 사용할 수 있다
		//- **는 하위 엔드포인트(마지막 /)까지 모두 포함하여 설정할 때 사용
		//- *는 동일 엔드포인트까지만 포함하여 설정할 때 사용
		registry.addInterceptor(memberInterceptor)
						.addPathPatterns("/member/**", //멤버 전부 막힘
											"/board/**",
											"/point/**"
																	)
						.excludePathPatterns(
											//"/member/join", "/member/joinFinish",
											"/member/join*", //join 어쩌고는 포함
											"/member/login", "/member/exitFinish", 
											"/board/list", "/board/detail"
													);
		
		//관리자 인터셉터 등록
		registry.addInterceptor(adminInterceptor)
											.addPathPatterns("/admin/**"); // /admin/* 만 하면 admin/pocketmon/list 이런건 아예안됨
		
		//게시글 조회수 중복방지 인터셉터 등록
		registry.addInterceptor(boardReadcountInterceptor)
											.addPathPatterns("/board/detail");
		
		
//		registry.addInterceptor(boardInterceptor).addPathPatterns("/board/edit", "/board/delete");
		
		//내 글 또는 관리자만 수정 삭제하는 인터셉터 등록
		registry.addInterceptor(boardOwnerInterceptor)
											.addPathPatterns("/board/edit", "/board/delete");
	}
	
	
}
