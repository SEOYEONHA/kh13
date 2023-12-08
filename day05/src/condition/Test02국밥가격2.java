package condition;

import java.time.LocalDate;
import java.util.Scanner;

public class Test02국밥가격2 {
	public static void main(String[] args) {
		//KH국밥집에서는 국밥 한그릇을 7천원에 팔고 있습니다.
		//65세 이상 어르신에게는 30% 할인된 가격으로 판매합니다.

		//사용자에게 출생년도 8자리를 입력받아 한국나이 계산 후 금액 출력
		
		int current = 20231208;
		int currentYear = current / 10000;
		int gukbapPrice = 7000;
		int discountRate = 30;
		int discountPrice = gukbapPrice * (100-discountRate) / 100;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("생년월일 8자리를 입력하세요 : ");
		int birth = sc.nextInt();
		int birthYear = birth / 10000;
		int age = currentYear - birthYear + 1;
		//int age = LocalDate.now().getYear() - birthYear + 1;
		
		
		if(age >= 65) {
			System.out.println("65세 이상입니다. 할인대상 입니다.");
			System.out.println(discountRate + "% 할인된 가격은 " + discountPrice + "원 입니다.");  
		}
		else {
			System.out.println("65세 미만입니다. 할인대상이 아닙니다.");
			System.out.println(gukbapPrice + "원 입니다.");
		}
	}

}
