package oop.poly2;

import java.util.Scanner;

public class Test01다형성2 {
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		
		
		System.out.println("노트북을 먼저 선택하세요");
		System.out.print("1. 맥북 \t 2. 갤럭시북 : ");
		int choice = sc.nextInt();
		Laptop Laptop;
		if(choice == 1) {
			Laptop = new MacBook();
		}
		else {
			Laptop = new GalaxyBook();
		}
		System.out.println("테스트할 기능을 선택하세요");
		System.out.print("1. 전원 \t 2. 동영상재생 \t 3. 타이핑 :");
		int choice2 = sc.nextInt();
		if(choice2 == 1) {
			Laptop.power();
		}
		else if(choice2 == 2) {
			Laptop.video();
		}
		else {
			Laptop.typing();
		}
	}
}