package api.time;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Test02기간구하기 {
	public static void main(String[] args) {
//		사용자에게 YYYY-MM-DD 형태로 두 개의 날짜를 입력받아서 두 날짜의 차이를 구하여 화면에 출력
//
//		요구사항
//		반드시 먼저 입력한 날짜가 나중에 입력한 날짜보다 이전이어야 합니다
//		그렇지 않을 경우 차이를 계산할 수 없습니다 메세지를 출력
//		차이는 ?년 ?개월 ?일 형태로 출력해주세요
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이전 날짜를 입력하세요 (YYYY-MM-DD) : ");
		String input1 = sc.nextLine();
		System.out.print("이후 날짜를 입력하세요 (YYYY-MM-DD) : ");
		String input2 = sc.nextLine();

		
		
		String yearParts1 = input1.substring(0, 4);
		String monthParts1 = input1.substring(5, 7);
		String dayParts1 = input1.substring(8);
		
		String yearParts2 = input2.substring(0, 4);
		String monthParts2 = input2.substring(5, 7);
		String dayParts2 = input2.substring(8);
		
		int year1 = Integer.valueOf(yearParts1);
		int month1 = Integer.valueOf(monthParts1);
		int day1 = Integer.valueOf(dayParts1);
		
		int year2 = Integer.valueOf(yearParts2);
		int month2 = Integer.valueOf(monthParts2);
		int day2 = Integer.valueOf(dayParts2);
		
		LocalDate d1 = LocalDate.of(year1, month1, day1);
		LocalDate d2 = LocalDate.of(year2, month2, day2);
		
		
		
		int comparison = input1.compareTo(input2);
		
		if (comparison < 0) {
			Period period = Period.between(d1, d2);
			System.out.println(period.getYears() + "년 " + period.getMonths() 
			+ "개월 " + period.getDays() + "일");
		}
		else {
			System.err.println("차이를 계산할 수 없습니다.");
		}
	}
}
