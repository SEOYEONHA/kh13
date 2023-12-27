package api.lang.string2;

import java.util.Scanner;

public class Test05날짜검사 {
	public static void main(String[] args) {
//		사용자에게 생년월일을 입력받아서 올바른 형식인지 검사 후 출력
//
//		요구사항
//		연도는 1900 부터 2099년 사이에서 설정 (1900~2099)
//		월은 1월부터 12월 사이에서 설정 (01~12)
//		일은 월에 따라 다르긴 하지만 우선 31일로 고정 (01~31)
//		형식은 YYYY-MM-DD 형태로 대시가 포함된다.
//
//		업그레이드
//		월에 따라 날짜가 다르게 설정되도록 구현(2월은 29일로 가정)
//		윤년인지 아닌지 프로그램에서 판정하여 정규표현식에 반영
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("생년월일을 입력하세요(YYYY-MM-DD) : ");
		String birth = sc.nextLine();
		
		String regex = "^(19|20)[0-9]{2}-(0[1-9]|1[12])-([0-2][1-9]|3[01])$";
		String regexDay30 = "^(19|20)[0-9]{2}-(0|4|6|9|11)-([0-2][1-9]|30)$";
		String regexDay29 = "^(19|20)[0-9]{2}-(02)-[0-2][1-9]$";
		String regexDay28 = "^(19|20)[0-9]{2}-(02)-[0-2][1-8]$";
		
		String yearParts = birth.substring(0, 4);
		
		int year = Integer.valueOf(yearParts);
		
		boolean condition1 = year % 4 == 0;
		boolean condition2 = year % 100 != 0;
		boolean condition3 = year % 400 == 0;
		boolean leap = condition3 || (condition1 && condition2);
		
		boolean OkDate = birth.matches(regex);
		boolean OkDate30 = birth.matches(regexDay30);
		boolean OkDate29 = birth.matches(regexDay29);
		boolean OkDate28 = birth.matches(regexDay28);
		
		
		if (OkDate && (OkDate30 || OkDate29 || OkDate28) && leap) {
            System.out.println("올바른 생년월일 형식입니다.");
            System.out.println("윤년입니다.");
        } 
		else if (OkDate && (OkDate30 || OkDate28)) {
            System.out.println("올바른 생년월일 형식입니다.");
        } 
		else {
            System.out.println("잘못된 날짜 형식입니다.");
        }
	}
}
