package loop;

import java.util.Scanner;
public class Tset02 {
	public static void main(String[] args) {
		//사용자에게 5개의 이름을 입력받아 입력받은 이름 뒤에 "님 환영합니다!" 라는 문구를 붙여 출력할 수 있도록 구현하세요

		//단, 문자열 입력은 다음과 같이 받습니다.
		//String str = sc.next();
		
		Scanner sc = new Scanner(System.in);
		
		for(int i = 1 ; i <= 5 ; i = i + 1) {
		System.out.print("이름 입력 : ");
		
		String name = sc.next();
		System.out.println(name + "님 환영합니다!");
		}
	}
}
