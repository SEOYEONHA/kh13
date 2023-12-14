package loop4;

import java.util.Scanner;

public class Test01반복문 {
	public static void main(String[] args) {
		//do-while 반복
		//- 선 실행(do) 후 반복(while)의 형태를 가지는 구문
		//- (ex) 시험 점수를 제대로 입력할때까지 입력받는 코드
		
		Scanner sc = new Scanner(System.in);
		
		int score;
		
		do {//반복 실행할 내용
			System.out.print("시험점수 입력 : ");
			score = sc.nextInt();
		}
		//while(score < 0 || score > 100);
		while(!(score >= 0 && score <= 100));
		
		System.out.println("입력된 점수 = " + score);
		
	}
}