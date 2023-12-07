package io;

import java.util.Scanner;

public class Test03성인인증기 {
	public static void main(String[] args) {
		//입력
		Scanner sc =new Scanner(System.in);
		int birth = sc.nextInt();
		
		//계산
		int age = 2023 - birth + 1;
		boolean adult = age >= 20;
		
		//출력
		System.out.println("나이 = " + age);
		System.out.println("성인 = " + adult);
	}

}
