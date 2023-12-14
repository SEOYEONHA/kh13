package loop3;

import java.util.Scanner;

public class Test05베스킨라빈스31 {
	public static void main(String[] args) {
//		베스킨라빈스31 게임은 사용자들이 번갈아서 숫자를 1~3개 골라 31을 말하게 되는 사람이 지는 게임입니다.
//
//		사용자에게 반복적으로 1~3 사이의 숫자를 입력받아 다음과 같이 게임이 진행될 수 있도록 구현해보세요
//
//		현재 숫자 : 1
//		숫자 개수(1~3) 입력 : 2
//
//		현재 숫자 : 3
//		숫자 개수(1~3) 입력 : 3
//
//		현재 숫자 : 6
//		숫자 개수(1~3) 입력 : 1
//
//		현재 숫자 : 7
//		숫자 개수(1~3) 입력 : ?
//
//		...
//
//		현재 숫자 : 31
//		숫자 개수(1~3) 입력 : 1
//
//		당신은 패배했습니다.
		
		Scanner sc = new Scanner(System.in);
		
		int num = 1;
		System.out.println("현재 숫자 : " + num);
		while(true) {
			
			System.out.print("숫자 개수(1~3) 입력 : ");
			int user = sc.nextInt();
			num += user;
			
			
			if (num < 31) {
				System.out.println("현재 숫자 : " + num);
			}
			if (num >= 31) {
			System.out.println("당신은 패배했습니다.");
			break;
			}
		}
	}

}
