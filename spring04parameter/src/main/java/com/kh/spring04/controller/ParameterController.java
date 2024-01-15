package com.kh.spring04.controller;

import java.text.DecimalFormat;
import java.time.LocalDate;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParameterController {
	
	//(Q) 숫자 두 개를 더해서 반환하는 페이지
	//- 필요한 값을 매개변수로 선언하면 된다
	//- 주소 뒤에 있는 해당 이름의 파라미터를 자동 수신
	//- 웹에서는 Scanner 대신 파라미터를 사용
	@RequestMapping("/plus")
	public String plus(int a, int b) {
		int result = a + b;
		return "덧셈 결과 : " + result;
	}
	
	//(Q) 출생년도 8자리를 입력하면 한국 나이를 반환
	@RequestMapping("/KoreanAge")
		public String KoreaAge(int birth) {
			int birthYear = birth / 10000;
			int current = LocalDate.now().getYear();
			int KoreaAge = current - birthYear + 1 ;
			return "한국나이 : " + KoreaAge;
		}
	
	
	//(Q) 키(cm)와 체중(kg)을 입력하면 BMI를 반환
	@RequestMapping("/bmi")
		public String bmi(float cm, float kg) {
		float m = cm / 100;
		float bmi = kg / (m * m);
		DecimalFormat fmt = new DecimalFormat("#,##0.00");
		return "bmi 지수 : " + fmt.format(bmi);
	}
}
