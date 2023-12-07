package io;

import java.util.Scanner; // ctrl + shift + o

public class Test02입력 {
	public static void main(String[] args) {
		//표준 입력(Standard input)
		//- 표준 입력장치(ex : 키보드)를 이용하여 값을 전달받는 작업
		//- 표준 입력 통로(System.in)을 활용
		//- 언제 어디서 누가 얼만큼 입력할지 모른다는 문제가 있음
		//- 이런 문제를 해결해주는 보조 도구와 같이 사용(Scanner)
		
		
		Scanner sc = new Scanner(System.in); //입력 도구 생성
		
		int a = sc.nextInt(); //키보드에서 숫자 한개를 전달받아 a에 저장
		int b = sc.nextInt(); //키보드에서 숫자 한개를 전달받아 b에 저장
	
		System.out.println("a = " + a);
		System.out.println("b = " + b);
	}

}
