package oop.poly2;

import java.util.Scanner;

public class Test01다형성 {
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		
		
		System.out.println("노트북을 먼저 선택하세요");
		System.out.print("1. 맥북 \t 2. 갤럭시북 : ");
		int choice = sc.nextInt();
		if(choice == 1) {
			Laptop l = new MacBook();
			System.out.println("테스트할 기능을 선택하세요");
			System.out.print("1. 전원 \t 2. 동영상재생 \t 3. 타이핑 : ");
			int choice2 = sc.nextInt();
			if(choice2 == 1) {
				l.power();
			}
			if(choice2 == 2) {
				l.video();
			}
			else
				l.typing();
		}
		else {
			Laptop l2 = new GalaxyBook();
			System.out.println("테스트할 기능을 선택하세요");
			System.out.print("1. 전원 \t 2. 동영상재생 \t 3. 타이핑 : ");
			int choice2 = sc.nextInt();
			if(choice2 == 1) {
				l2.power();
			}
			if(choice2 == 2) {
				l2.video();
			}
			else {
				l2.typing();
			}
		}
	}
}