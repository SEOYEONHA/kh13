package loop2;

import java.util.Scanner;

public class Test03등급판정 {
	public static void main(String[] args) {
//		사용자에게 10개의 시험점수를 입력받아서 A등급과 B등급의 개수를 출력
//
//		A등급은 85점 이상 100점 이하
//		B등급은 70점 이상 85점 미만
		
		int A = 0;
		int B = 0;
		Scanner sc = new Scanner(System.in);
		for(int i = 1 ; i <= 10 ; i ++) {
			System.out.print("시험 점수를 입력하세요 : ");
			int score = sc.nextInt();
			if (score <= 100 && score >= 85) {
				A++;
			}
			if (score < 85 && score >= 70) {
				B++;
			}
		}
		System.out.println("A등급 개수 : " + A);
		System.out.println("B등급 개수 : " + B);
	
	}

}
