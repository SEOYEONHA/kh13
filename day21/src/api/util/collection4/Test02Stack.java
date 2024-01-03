package api.util.collection4;

import java.util.Stack;

public class Test02Stack {
	public static void main(String[] args) {
		//Stack(스택)
		//- LIFO(Last-In-First-Out)구조
		
		Stack<String> stack = new Stack<String>();
		
		//데이터 추가 - push()
		stack.push("뽀로로");
		stack.push("크롱");
		stack.push("루피");
		stack.push("패티");
		
		//데이터 확인 - peek()
		System.out.println("현재 차례 = " + stack.peek()); //패티
		
		//데이터 삭제 - pop()
		stack.pop(); //패티
		stack.pop(); //루피
		System.out.println("현재 차례 = " + stack.peek()); //크롱
	}
}
