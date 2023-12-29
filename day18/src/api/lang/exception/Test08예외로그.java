package api.lang.exception;

import java.util.Scanner;

public class Test08예외로그 {
	public static void main(String[] args) {
		
		try { //Plan A
			Scanner sc = new Scanner(System.in);
			System.out.print("귤 개수 : ");
			int mandarin = sc.nextInt(); 
			if (mandarin < 0) { 
				//throw new Exception();
				throw new Exception("귤 개수는 음수일 수 없어요");
			}
			
			System.out.print("인원 수 : ");
			int people =  sc.nextInt(); 
			if(people < 0) { 
				throw new Exception("인원 수는 음수일 수 없어요");
			}
			
			int dist = mandarin / people; 
			int rest = mandarin % people;
			
			System.out.println("한 사람당 " + dist + "개 씩 줄 수 있습니다");
			System.out.println("다 주면 " + rest + "개 남네요");
		}
		
		catch(Exception e) { //Plan B 
			//예외가 발생했을 때 나오는 메세지를 스택 트레이스(stack trace)라고 한다
			//스택 트레이스에는 예외, 종류, 원인, 위치 등이 매우 상세하게 나온다
			//개발자한테는 도움이 되는 정보이므로 확인하고 싶다면?
			
			e.printStackTrace();
		}
	}
}
