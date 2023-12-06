package data;

public class Test09만나이 {
	public static void main(String[] args) {
		//오늘은 2023년 12월 6일입니다.
		//2000년 1월 1일 생의 만나이를 구하여 출력하세요.
		
		//단, 생년월일은 '20231206'처럼 8자리의 숫자형태로 제공됩니다.
		//단, 일은 고려하지 않고 월까지만 고려합니다.
		//12개월마다 1살
		
		//입력
		int current = 20231206;
		int birth = 20000101;
		
		//계산
		int currentYear = current / 10000;
		int currentMonth = current % 10000 / 100;
		int birthYear = birth  / 10000;
		int birthMonth = birth % 10000 / 100;
		int year = currentYear - birthYear;
		int month = currentMonth - birthMonth;
		
		int numberOfMonths = year * 12 + month;
		int age = numberOfMonths / 12;
		
		System.out.println(age);
		
		
	}

}
