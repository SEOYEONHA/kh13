package io;

import java.util.Scanner;

public class Test06분식점 {
	public static void main(String[] args) {
		//KH분식점의 메뉴판은 다음과 같습니다.

		//사용자에게 떡볶이, 튀김, 순대 개수를 입력받아 결제금액을 출력
		//(단, 현재 행사중이라서 10% 할인된 가격으로 판매합니다)
		
		//떡볶이 3000 , 튀김 500 , 순대 2000
		
		Scanner sc = new Scanner(System.in);
		
		//입력
		int tteokPrice = 3000;
		int tuiPrice = 500;
		int soonPrice = 2000;
		int discountRate = 10;
		
		System.out.print("주문하실 떡볶이 수량을 입력하세요. (" + tteokPrice + "원) : ");
		int tteokNum = sc.nextInt();
		System.out.print("주문하실 튀김 수량을 입력하세요. (" + tuiPrice + "원) : ");
		int tuiNum = sc.nextInt();
		System.out.print("주문하실 순대 수량을 입력하세요. (" + soonPrice + "원) : ");
		int soonNum = sc.nextInt();
		
		//계산
		int tteokSum = tteokPrice * tteokNum;
		int tuiSum = tuiPrice * tuiNum;
		int soonSum = soonPrice * soonNum;
		
		int sum = tteokSum + tuiSum +soonSum;
		int discount = (sum * (100 - discountRate)) / 100;
		
		
		//출력
		System.out.println("총 금액은 " + sum + "원 입니다.");
		System.out.println(discountRate + "%" + " 할인된 금액은 " + discount + "원 입니다.");
		System.out.println("할인된 금액 : " + (sum - discount) +"원");
		

	}

}
