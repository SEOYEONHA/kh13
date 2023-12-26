package api.lang.string;

public class Test02문자열클래스 {
	public static void main(String[] args) {
		//문자열(String)
		//- 자바에서 제공하는 문자열 제어 클래스
		//- 정말 몇 개 안되는 new 없이 객체가 생성되는 클래스
		
		//객체 생성
		String a = new String();
		String b = new String("hello");
		
		StringBuffer c = new StringBuffer("hello");
		String d = new String(c);
		
		String e = "hello";
		String f = "hello";
		
		//정보 출력
		//System.out.pirnltn("a = " + a.toString());
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("c = " + c);
		System.out.println("d = " + d);
		
		//비교 연산? 객체에서는 사용하기가 까다롭다
		System.out.println("<비교 연산>");
		System.out.println("b랑 d랑 같나요? " + (b == d));
		System.out.println("d랑 e랑 같나요? " + (d == e));
		System.out.println("e랑 f랑 같나요? " + (e == f));
		System.out.println("b랑 f랑 같나요? " + (b == f));
		
		//비교 메소드 - equals 메소드 사용
		//헷갈리면 그냥 문자 객체에선 비교연산 쓰지말고 비교메소드만 사용하기!
		System.out.println("<비교 메소드>");
		System.out.println("b랑 d랑 같아요? " + b.equals(d));
		System.out.println("d랑 e랑 같아요? " + e.equals(d));
		System.out.println("e랑 f랑 같아요? " + e.equals(f));
		System.out.println("b랑 f랑 같아요? " + b.equals(f));
	}
}
