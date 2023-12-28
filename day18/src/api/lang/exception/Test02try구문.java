package api.lang.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test02try구문 {
	public static void main(String[] args) {
		
		try {//Plan A
			//(Q) 사용자에게 귤 개수와 인원 수를 입력받아 1인당 개수와 나머지 구하기
			Scanner sc = new Scanner(System.in);
			System.out.print("귤 개수 : ");
			int mandarin = sc.nextInt(); //예외 발생 예상위치
			System.out.print("인원 수 : ");
			int people =  sc.nextInt(); //예외 발생 예상위치
			
			int dist = mandarin / people; //예외 발생 예상위치(people이 0이면 에러남)
			int rest = mandarin % people;
			
			System.out.println("한 사람당 " + dist + "개 씩 줄 수 있습니다");
			System.out.println("다 주면 " + rest + "개 남네요");
		}
		
		catch(InputMismatchException e) {//Plan B - 잘못된 입력
			System.err.println("입력이 잘못되었습니다");
		}
		
		catch(ArithmeticException e) {//Plan B - 나누기 에러
			System.err.println("인원수를 1명이상 입력해주세요");
		}
	}
}
