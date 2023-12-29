package api.time;

import java.time.LocalDate;
import java.time.Period;

public class Test01LocalDate클래스 {
	public static void main(String[] args) {
		//LocalDate 클래스는 날짜만을 사용하고자 할 때 쓴다
		//1. 기존에 비해 메소드의 의미가 명확해짐
		//2. 월 설정을 1~12로 할 수 있다.
		//3. 객체가 불변 처리된다.
		
		LocalDate a = LocalDate.now(); //현재날짜
		LocalDate b = LocalDate.of(2024, 1, 1); //2024-01-01
		
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		
		//항목 추출(연/월/일)
		System.out.println(a.getYear());
		System.out.println(a.getMonthValue());
		System.out.println(a.getDayOfMonth());
		
		//윤년
		System.out.println(a.isLeapYear()); //a가 윤년이에요?
		System.out.println(b.isLeapYear()); //b가 윤년이에요?
		
		//날짜계산
		//(Q) 수료 30일 전부터 프로젝트를 시작할 예정입니다. 날짜를 구해보세요
		LocalDate finish = LocalDate.of(2024, 5, 20);
		LocalDate project = finish.minusDays(30);
		System.out.println("project = " + project);
		
		//오늘은 수료 며칠 전입니까?
		//= finish와 a의 차이를 구하세요
		//= 주인공이 애매하므로 별도의 클래스로 계산 (Period)
		Period period = Period.between(a, finish);
		System.out.println(period.getYears()); //남은연도
		System.out.println(period.getMonths()); //남은개월수
		System.out.println(period.getDays()); //남은일수
		
		
	}
}
