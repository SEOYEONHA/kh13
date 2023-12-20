package oop.keyword4;
	
//이 클래스는 별도의 멤버 필드를 가지지 않고 일회성 계산 메소드만 보관


public class Robot {
	 //1. 11의 제곱을 구할 수 있도록 square 메소드 구현
	public static double squre(double num) {
		return num*num;
	}
	//2. 폭이 5, 높이가 7인 삼각형의 넓이를 구할 수 있도록 triangle 메소드 구현
	public static double triangle(double width, double height) {
		return width * height / 2;
	}
	//3. 반지름이 5인 원의 넓이를 구할 수 있도록 circle 메소드 구현
	public static double circle(double radius) {
		//return 3.14 * radius * radius;
		return squre(radius) * 3.14;
	}
	//4. 출생년도 4자리를 집어넣으면 지하철 요금이 계산되도록 subway 메소드 구현
	public static String subway(int birth) {
		int age = 2023 - birth + 1;
		if(age >= 20 && age < 65) {
			return "성인 : 1400원";
		}
		if(age >= 14 && age < 20) {
			return "청소년 : 800원";
		}
		if(age >= 8 && age < 14) {
			return "어린이 : 500원";
		}
		else
			return "그 외 : 0원";
	}
	//5. 연도 4자리를 집어넣으면 윤년인지 아닌지 판정하는 leap 메소드 구현
	public static String leap(int year) {
		boolean condition1 = year % 4 == 0;
		boolean condition2 = year % 100 != 0;
		boolean condition3 = year % 400 == 0;
		boolean leap = condition3 || (condition1 && condition2);
		
		if(leap) {
			return "윤년입니다.";
		}
		else {
			return "윤년이 아닙니다.";
		}
	}
	//6. 키(cm)와 몸무게(kg)를 집어넣으면 체질량지수(BMI)를 구하는 bmi 메소드 구현
	public static double bmi(double cm, double kg) {
		double m = cm / 100;
		return kg / (m * m);
	}
}
