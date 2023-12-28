package api.lang.exception;

import java.util.Scanner;

public class Test01예외처리 {
	public static void main(String[] args) {
		//예외(Exception)
		//- 프로그램 실행 중에 발생하는 돌발상황
		//프로그래밍 기법으로 해결 가능
		//에러(Error)
		//- 프로그램이 실행되지 않는 상황
		//- 프로그래밍 기법으로 해결 불가
		
		//(Q) 사용자에게 귤 개수와 인원 수를 입력받아 1인당 개수와 나머지 구하기
		Scanner sc = new Scanner(System.in);
		System.out.print("귤 개수 : ");
		int mandarin = sc.nextInt();
		System.out.print("인원 수 : ");
		int people =  sc.nextInt();
		
		int dist = mandarin / people;
		int rest = mandarin % people;
		
		System.out.println("한 사람당 " + dist + "개 씩 줄 수 있습니다");
		System.out.println("다 주면 " + rest + "개 남네요");
		
	}
}
