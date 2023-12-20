package oop.keyword4;

public class Test01정적메소드 {
	public static void main(String[] args) {
		
		System.out.println("제곱 : " + Robot.squre(11));
		
		System.out.println("삼각형 넓이 : " + Robot.triangle(5, 7));
		
		System.out.println("원의 넓이 " + Robot.circle(5));
		
		System.out.println("지하철 요금 : " + Robot.subway(2010));
		
		System.out.println("윤년 판정 : " + Robot.leap(2023));
		
		System.out.println("bmi지수 : " + Robot.bmi(180, 80));
	}
}
