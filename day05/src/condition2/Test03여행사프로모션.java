package condition2;

import java.util.Scanner;

public class Test03여행사프로모션 {
	public static void main(String[] args) {
		//KH 여행사에서 두 번째 프로모션을 진행합니다.
		//무조건 1인당 1일 10만원이라는 기존의 슬로건은 유지하면서 계절별로 다양하게 추가 할인을 제공합니다.

		//사용자에게 인원수, 여행기간(일), 예정(월)을 입력받아 예상 요금을 출력하세요
	
	
		Scanner sc =  new Scanner(System.in);
		
		//입력
		int price = 100000;
		System.out.print("인원수를 입력하세요 : ");
		int people = sc.nextInt();
		System.out.print("여행 기간을 입력하세요 : ");
		int night = sc.nextInt();
		System.out.print("여행 예정 월을 입력하세요 : ");
		int month = sc.nextInt();

		
		int discountRate;
		if (month == 3 || month == 4 || month == 5) {
			discountRate = 20;
			System.out.println("★봄 " + discountRate + "% 할인 행사중입니다.★");
		}
		else if (month == 6 || month == 7 || month == 8) {
			discountRate = 10;
			System.out.println("★여름 " + discountRate + "% 할인 행사중입니다.★");
		}
		else if (month == 9 || month == 10 || month == 11) {
			discountRate = 30;
			System.out.println("★가을 " + discountRate + "% 할인 행사중입니다.★");
		}
		else {
			discountRate = 5;
			System.out.println("★겨울 " + discountRate + "% 할인 행사중입니다.★");
		}
		
		//계산
		int total = price * people * night;
		int pay = total * (100-discountRate) / 100;
		int discount = total - pay;
		
		//출력
		System.out.println("총 금액 : " + total + "원");
		System.out.println("할인된 금액 : " + discount+ "원");
		System.out.println("결제할 금액 : " + pay+ "원");
		
		
		
		
	}
}
