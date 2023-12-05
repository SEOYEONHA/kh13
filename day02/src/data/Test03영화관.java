package data;

public class Test03영화관 {

	public static void main(String[] args) {
		//Test03 를 만들어서 다음 금액 계산 결과를 출력

		//영화관 요금표는 다음과 같습니다.
		//성인 : 12000원
		//청소년 : 8500원

		//성인 2명과 청소년 2명의 요금을 구하세요

		
		//입력 - 문제에서 주어진 값들을 변수에 저장
		int adultPrice = 12000;
		int youthPrice = 8500;
		int numberOfAdults = 2;
		int numberOfYouths = 2;
		
		//계산
		int adultTotal = adultPrice * numberOfAdults;
		//System.out.println(adultTotal);
		int youthTotal = youthPrice * numberOfYouths;
		//System.out.println(youthTotal);
		int total = adultTotal + youthTotal;
		
		//출력 - 문제에서 요구하는 값을 화면에 출력
		System.out.println(total);		
	}

}
