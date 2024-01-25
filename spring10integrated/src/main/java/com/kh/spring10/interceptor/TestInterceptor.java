package com.kh.spring10.interceptor;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// ** 컨트롤러를 건드리지 않고 앞과 뒤에 뭔가 해보려고 하는것!! (대상을 안건드리기 위해
//간섭하려고 **

//특정 주소(URL)에 대한 처리 과정을 간섭할 수 있는 객체
//인터셉터는 특별한 처리를 수행하기 때문에 만드는 방법이 정해져있다
//[1] 상속을 통해 자격요건을 획득한다
//[2] 스프링에 등록한다
//[3] 간섭 메소드를 재정의하여 내용을 작성한다
// -preHandle 메소드는 컨트롤러가 실행되기 전 시점을 간섭할 수 있다
//		- true를 반환하면 통과, false를 반환하면 차단

@Service
public class TestInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("인터셉터 실행");
		return true; //통과
		//return false; //차단(아무것도 설정 안하면 하얀화면으로만 나옴)
	}

}
