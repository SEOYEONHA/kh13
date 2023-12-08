package condition2;

import java.util.Scanner;

public class Test02지하철요금2 {
	public static void main(String[] args) {
		//지하철 이용요금이 다음과 같을 때 사용자의 나이를 입력받아 지하철 요금을 출력하세요
		//(추가) 카드보증금 500원을 추가해서 계산하고 출력하세요
	
		Scanner sc = new Scanner(System.in);
	
		System.out.print("나이를 입력하세요 : ");
		int age = sc.nextInt();
		
		int price; //변수를 선언만
		if(age < 8 || age >= 65) { //어르신 또는 영유아
			price = 0;
		}
		else if(age >= 20) {
			price = 1400;
		}
		else if(age >= 14) {
			price = 800;
		}
		else {
			price = 500;
		}
		int card = 500;
		int result = price + card;
		
		//출력
		System.out.println("요금 : " + price + "원");
		System.out.println("카드보증금 : " + card + "원");
		System.out.println("결제 금액 : " + result + "원");
		
		}
		}
