package oop.keyword6;

import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("게임 타이틀을 입력하세요: ");
		String title = sc.next();
		System.out.print("게임화면의 폭을 입력하세요 : ");
		int width = sc.nextInt();
		System.out.print("게임화면의 높이를 입력하세요 : ");
		int height = sc.nextInt();
		
		GameScreen screen = new GameScreen(title, width, height);
		
		
		screen.information();
	}
}
