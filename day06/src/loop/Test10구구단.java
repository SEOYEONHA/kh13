package loop;

import java.util.Scanner;

public class Test10구구단 {
	public static void main(String[] args) {
//		사용자에게 원하는 '단'을 입력받아서 구구단 문제를 내고 정답을 입력받는 프로그램을 구현
		
//		구구단 : (3)
//
//		3 x 1 = (3)
//		정답!
//		3 x 2 = (5)
//		땡!
//		3 x 3 = (6)
//		정답!
//		...
//		3 x 9 = (27)
//		정답!
//
//		게임 끝!
		
		Scanner sc = new Scanner(System.in);
		System.out.print("단을 입력하세요 : ");
		int table = sc.nextInt();
		
		System.out.println(table + "단 시작!");
		for(int i = 1 ; i <= 9 ; i ++) {
			System.out.print(table + " x " + i + " = ");
			int result = table * i;
			int userResult = sc.nextInt();
			boolean correct = result == userResult;
			if (correct) {
				System.out.println("정답!");
			}
			else {
				System.out.println("땡!");
			}
		}
		System.out.println("게임 끝!");
	}
}
