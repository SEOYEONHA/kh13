package api.lang.etc;

public class Test02Math클래스 {
	public static void main(String[] args) {
		//Math 클래스
		//- 프로그램 구현 시 필요한 수학적인 연산을 처리하는 클래스
		//- 객체 생성이 불가능하며 모든 필드, 메소드가 static으로 구성
		
		int a = 100, b = 80;
		//System.out.println(a - b);
		//System.out.println(b - a);
		System.out.println(Math.abs(a - b)); //절대값
		System.out.println(Math.abs(b - a));
		
		double c =1.5;
		System.out.println((int)(c + 0.5)); //반올림(직접)
		System.out.println(Math.round(c)); //반올림
		System.out.println(Math.floor(c)); //버림
		System.out.println(Math.ceil(c)); //올림
		
		System.out.println(Math.sqrt(9)); //루트 9
		System.out.println(Math.pow(2, 5)); //2의 5승
		
		
		double d = 3, e = 4;
		double f = Math.sqrt(Math.pow(d, 2) + Math.pow(e, 2));
		System.out.println("f = " + f);
		
		System.out.println(Math.max(d, e)); //큰 수 구하기
		System.out.println(Math.min(d, e)); //작은 수 구하기
	}
}
