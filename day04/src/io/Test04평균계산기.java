package io;

import java.util.Scanner;

public class Test04평균계산기 {
	public static void main(String[] args) {
		//사용자에게 다음 정보를 입력받아서 총점과 평균을 구하여 출력

		//국어 점수(korean)
		//영어 점수(english)
		//수학 점수(math)
		
		Scanner sc = new Scanner(System.in);
		System.out.println("국어 점수를 입력하세요.");
		int korean = sc.nextInt();
		System.out.println("영어 점수를 입력하세요.");
		int english = sc.nextInt();
		System.out.println("수학 점수를 입력하세요.");
		int math = sc.nextInt();
		
		int sum = korean + english + math;
		double average = sum / 3.0; //평균은 double이나 float으로 해야함
		//double average = (double)sum / 3;
		//double average = sum / 3d;
		
		System.out.println("총점 : " + sum);
		System.out.println("평균 : " + average);
		
	}

}
