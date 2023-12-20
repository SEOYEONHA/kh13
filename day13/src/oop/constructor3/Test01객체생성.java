package oop.constructor3;

import java.util.Scanner;

public class Test01객체생성 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디를 입력하세요 : ");
		String userName = sc.next();
		System.out.print("직업을 입력하세요(전사, 도적, 마법사) : ");
		String userJob = sc.next();
		
		Game a = new Game(userName, userJob);
		
		//레벨업 (이렇게하면 안됨)
		//int level = a.getLevel();
		//a.setLevel(level + 1);
		
		//a.levelUp();
		a.information();
	}
}
