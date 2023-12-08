package condition2;

import java.util.Scanner;

public class Test02지하철요금 {
	public static void main(String[] args) {
		//지하철 이용요금이 다음과 같을 때 사용자의 나이를 입력받아 지하철 요금을 출력하세요
		//(추가) 카드보증금 500원을 추가해서 계산하고 출력하세요
	
		Scanner sc = new Scanner(System.in);
	
		System.out.print("나이를 입력하세요 : ");
		int age = sc.nextInt();
		int deposit = 500; // 카드보증금
	
		if(age < 8 || age >= 65) { //어르신 또는 영유아
			System.out.println("지하철 요금은 0원입니다.");
			System.out.println("보증금 포함 " + (0 + deposit) +"원 입니다.");
		}
		else if(age >= 20 && age < 65) {
			System.out.println("지하철 요금은 1400원입니다.");
			System.out.println("보증금 포함 " + (1400 + deposit) +"원 입니다.");
		}
		else if(age >= 14 && age < 20) {
			System.out.println("지하철 요금은 800원입니다.");
			System.out.println("보증금 포함 " + (800 + deposit) +"원 입니다.");
		}
		else if(age >= 8 && age < 14) {
			System.out.println("지하철 요금은 500원입니다.");
			System.out.println("보증금 포함 " + (500 + deposit) +"원 입니다.");
		}
		System.out.println("보증금 : " + deposit + "원");
		}
		}
