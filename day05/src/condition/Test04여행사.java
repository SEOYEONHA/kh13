package condition;

import java.util.Scanner;

public class Test04여행사 {
	public static void main(String[] args) {
		//KH여행사에서는 다음과 같은 슬로건을 걸고 영업을 하고 있습니다.
		
		//어디든 무조건 1사람 1박에 10만원
		
		//여름 매출이 너무 저조해서 여름에 여행하는 사람은 추가로 20%할인 행사를 진행합니다.
		
		//사용자에게 인원수, 기간(일), 예정(월)을 입력받아서 예상금액을 구하여 출력
		//(단, 여름은 6,7,8월 입니다)
		
		//입력
		Scanner sc =  new Scanner(System.in);
		int price = 100000;
		int discountRate = 20;
		System.out.print("인원수를 입력하세요 : ");
		int people = sc.nextInt();
		System.out.print("여행 기간을 입력하세요 : ");
		int night = sc.nextInt();
		System.out.print("여행 예정 월을 입력하세요 : ");
		int month = sc.nextInt();
		
		//계산
		int total = people * price * night;
		int discount = total * (100 - discountRate) / 100;
		//boolean summer = 5 < month && month < 9;
		//boolean summer = 6 <= month && month <= 8;
		boolean summer = month == 6 || month == 7 || month == 8;
		//boolean summer = month / 3 == 2;
		
		//출력
		System.out.println("인원수 : " + people + "명\n여행 기간 : " + night + "일\n여행 예정 월 : " + month + "월");
		
		if(summer) {
			System.out.println("★여름 " + discountRate + "% 할인 행사중입니다.★");
			System.out.println("총 금액 : " + total + "원");
			System.out.println("할인된 금액 : " + (total - discount) + "원");
			System.out.println("결제할 금액 : " + discount + "원");
		}
		else {
			System.out.println("결제할 금액 : " + total + "원");
			System.out.println("★여름(6~8월)에는 " + discountRate + "% 할인된 금액으로 여행 하실 수 있습니다.★");
		}
		

	}

}
