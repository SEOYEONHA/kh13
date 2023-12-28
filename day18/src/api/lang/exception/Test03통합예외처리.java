package api.lang.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test03통합예외처리 {
	public static void main(String[] args) {
		
		//문제 : 예외를 다 해결했는지도 모르겠고... catch가 너무 많다!
		//해결 : 
		//- 올인원 catch 블록을 구현한다
		//- 결론 : 앞으로 모든 catch 블록은 Exception으로 만든다. 끝!
		
		try {//Plan A
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
		
		//catch(RuntimeException e) {//Plan B - 잘못된 입력
		catch(Exception e) {
		//catch(Throwable e) { (Error까지 처리됨)
		//catch(Object e) {//error
			//System.err.println("프로그램 오류 발생");
			System.err.println("잘못된 입력");
		}
	}
}
