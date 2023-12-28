package api.lang.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test05강제예외처리 {
	public static void main(String[] args) {
		
		try {//Plan A
			Scanner sc = new Scanner(System.in);
			System.out.print("귤 개수 : ");
			int mandarin = sc.nextInt(); //예외 발생 예상위치
			if (mandarin < 0) { // 귤 개수가 음수라면 문제가 된다(근데 자바는 모르네?)
//				Exception ex = new Exception();
//				throw ex;
				throw new Exception();
			}
			System.out.print("인원 수 : ");
			int people =  sc.nextInt(); //예외 발생 예상위치
			if(people < 0) { //인원수가 음수라면 문제가 된다(자바는 모르네?)
				throw new Exception();
			}
			
			int dist = mandarin / people; //예외 발생 예상위치(people이 0이면 에러남)
			int rest = mandarin % people;
			
			System.out.println("한 사람당 " + dist + "개 씩 줄 수 있습니다");
			System.out.println("다 주면 " + rest + "개 남네요");
		}
		
		//catch(RuntimeException e) {//Plan B - 잘못된 입력
		catch(Exception e) {
			System.err.println("잘못된 입력");
		}
	}
}
