package data4;

public class Test07윤년판정 {
	public static void main(String[] args) {
		//윤년은 날짜 계산상의 오차를 메꾸기 위해 하루를 더 부여한 해를 말합니다. 

		//실제 1년은 365.24... 일입니다.
		//365일로 1년을 정하고 지내다 보면 시간이 틀어집니다.
		//다음과 같이 날짜를 추가하는 규칙을 세웁니다.
		//1. 연도가 4의 배수라면 1년이 366일입니다.
		//2. 100의 배수가 될 경우는 윤년이 아니라고 간주합니다.
		//3. 400의 배수라면 100의 배수여도 윤년이라고 간주합니다.

		//어떤 연도가 주어졌을 때 (ex : 2100) 윤년인지 판정하여 출력
		
		//입력
		int year = 1900;
		
		//계산
		int four = year % 4;
		int hundred = year % 100;
		int fourHundred = year % 400;
		
		boolean leapYear = four == 0 && (hundred != 0 || fourHundred == 0);
		
		//출력
		System.out.println("윤년인가요? : " + leapYear);
		
	}

}
