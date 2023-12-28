package api.lang.exception;

import java.util.Scanner;

public class Test07만나이계산기 {
	public static void main(String[] args) {
		/*사용자에게 생년월일을 YYYY-MM 형식으로 입력받습니다.
		이 사용자의 한국나이와 만나이를 구하여 출력
		만나이는 태어난 달이거나 해당 달이 지나면 1살을 추가하는 방식으로 구현


		예를들어 2000년 1월이면 1월이 되면 한 살이 늘어납니다


		처리를 하면서 문제가 되는 상황이 발생하면 상황에 맞는 에러메세지를 출력
		예상 가능한 문제상황들은 다음과 같습니다.

		입력이 너무 짧은 경우
		숫자 변환이 올바로 되지 않는 경우
		생년월일을 미래의 값으로 입력하는 경우
		월을 1~12로 입력하지 않은 경우
		연도가 1900 미만인 경우

		한 개의 catch 블록으로 모든 예외를 처리할 수 있도록 구현하세요*/
		
		Scanner sc = new Scanner(System.in);
		
		try {
			int currentYear = 2023;
			int currentMonth = 12;
			
			System.out.print("출생년도와 월을 'YYYY-MM' 형식으로 입력해주세요 : ");
			String birth = sc.nextLine();
			
			if (birth.length() < 7) {
				throw new Exception("입력길이가 짧습니다. (YYYY-MM) 형식을 지켜주세요.");
			}
			
			String yearParts = birth.substring(0, 4);
			String monthParts = birth.substring(5);
			
//			String regexMonth = "^0[1-9]|1[12]$";
//			if (!monthParts.matches(regexMonth)) {
//				throw new Exception("1월부터 12월까지만 입력 가능합니다.");
//			}
			
			int birthYear = Integer.valueOf(yearParts);
			int birthMonth = Integer.valueOf(monthParts);
			
			if (birthYear != Integer.valueOf(yearParts) && birthMonth != Integer.valueOf(monthParts)) {
				throw new Exception("숫자만 입력해주세요.");
			}
			if (birthYear < 1900) {
				throw new Exception("1900년 미만은 입력할 수 없습니다.");
			}
			if (birthMonth < 0 || birthMonth > 12) {
				throw new Exception("1월부터 12월까지만 입력 가능합니다.");
			}
			
			int year = currentYear - birthYear;
			int month = currentMonth - birthMonth;
			
			if (year < 0 || (year == 0 && month < 0)) {
				throw new Exception("미래 일자를 입력하셨습니다.");
			}
			
			int InternationalAge = (year * 12 + month) / 12;
			int korAge = currentYear - birthYear + 1;
			
			System.out.println("만 나이 : " + InternationalAge);
			System.out.println("한국 나이 : " + korAge);
			}
		
		catch (Exception e) {
			if(e.getMessage() == null) { 
				System.err.println("예외 발생");
			}
			else {
				System.err.println(e.getMessage());
			}
		}
	}
}
