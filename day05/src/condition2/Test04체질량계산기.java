package condition2;

import java.util.Scanner;

public class Test04체질량계산기 {
	public static void main(String[] args) {

		//입력
		Scanner sc = new Scanner(System.in);
		System.out.print("키(cm)를 입력하세요 : ");
		double cm = sc.nextDouble();
		System.out.print("몸무게(kg)를 입력하세요 : ");
		double kg = sc.nextDouble();
		
		
		double m = cm / 100;
		double bmi = kg / (m * m);
		
		
		System.out.println("체중 : " + kg + "kg");
		System.out.println("키 : " + cm + "cm");
		System.out.println("체질량(bmi) 지수 : " + bmi);
	
		
		if (bmi < 18.5) {
			System.out.println("저체중 입니다.");
		}
		else if (bmi < 23) {
			System.out.println("정상체중 입니다.");
		}
		else if (bmi < 25) {
			System.out.println("과체중 입니다.");
		}
		else if (bmi < 30) {
			System.out.println("경도비만 입니다.");
		}
		else {
			System.out.println("중등도비만 입니다.");
		}
	}

}
