package condition2;

import java.util.Scanner;

public class Test06날짜계산 {

	public static void main(String[] args) {
		//1월부터 12월은 각각 정해진 날짜 수가 존재합니다.
		//이를 일반적으로 큰달, 작은달로 표현합니다.

		//사용자에게 연도와 월을 입력받아 해당하는 달의 마지막 날짜가 몇일인지 구하여 출력하세요.
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("연도 입력 : ");		
		int year = sc.nextInt();
		System.out.print("월 입력 : ");		
		int month = sc.nextInt();
		
		boolean condition1 = year % 4 == 0;
		boolean condition2 = year % 100 != 0;
		boolean condition3 = year % 400 == 0;
				
		boolean leap = condition3 || (condition1 && condition2);
		
		String day;
		if (month == 4 || month ==6 || month == 9 || month == 11) {
			day = "30";
		}
		else if (month == 2 && leap) {
			day = "29";
		}
		else if (month == 2) {
			day = "28";
		}
		else {
			day = "31";
		}
	
		System.out.println(year + "년 " + month + "월의 마지막 날짜는 "
				+ day + "일 입니다.");
	}
}
