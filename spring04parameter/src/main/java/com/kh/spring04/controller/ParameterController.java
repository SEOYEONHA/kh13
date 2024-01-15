package com.kh.spring04.controller;

import java.text.DecimalFormat;
import java.time.LocalDate;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	//파라미터를 받기 위한 고급 설정이 가능하다
	//- price가 없을 경우 0으로 대체
	//- people이 없을 경우 1로 대체
	//- 파라미터에 @RequestParam 등록을 해야함
	@RequestMapping("/dutch")
	public String dutch(
			@RequestParam(required = false, defaultValue = "0") int price, 
			@RequestParam(required = false, defaultValue = "1") int people) {
		int result = price / people;
		return "한 사람당 " + result + "원";
	}
	
	//(Q) /coffee라는 주소를 만들어서 다음과 같이 처리해보세요
	//- kind와 shot이라는 이름의 파라미터를 받아서 커피명과 샷 수를 출력
	//- kind=latte&shot=1 일 경우 "latte 주문, 샷 1개 추가" 처럼 페이지 출력
	//- kind가 없으면 americano로 처리
	//- shot이 없으면 0으로 처리
	@RequestMapping("/coffee")
	public String coffee(
			@RequestParam(required = false, defaultValue = "americano") String kind,
			@RequestParam(required = false, defaultValue = "0") int shot) {
		return kind + "주문, 샷 " + shot +"개 추가";
	}
	
	
}










