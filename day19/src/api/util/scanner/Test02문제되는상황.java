package api.util.scanner;

import java.util.Scanner;

public class Test02문제되는상황 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름 : ");
		String name = sc.next(); //단어 입력(띄어쓰기, 엔터, 탭 등은 건드리지 않는다)
		sc.nextLine(); //남아있는 \n을 정리
		
		System.out.print("자기소개 : ");
		String intro = sc.nextLine(); //한줄 입력(엔터를 삭제시켜준다)
		
		sc.close();
		
		System.out.println("이름 : " + name);
		System.out.println("자기소개 : " + intro);
	}
}
