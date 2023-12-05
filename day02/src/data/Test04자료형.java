package data;

public class Test04자료형 {
	public static void main(String[] args) {
		//자료형이란?
		//- 데이터를 저장하기 위해 구분하는 방법
		//- 숫자는 크게 소수점 유무로 없으면 정수, 있으면 실수
		//- 빠른 처리를 위해 각자 여러 형태를 미리 정해두었다.
		//- 정수 : byte, short, int, long 4가지 (int가 기본)
		//- 실수 : float, double 2가지 (double이 기본)
		
		int a = 10;
		//int b = 12345678901; //자리가 부족하다
		long b = 12345678901L; //충분한 자리를 갖는 변수
		System.out.println(b);
		
		//계산하다가 넘어갈 경우 뒤집힌다(순환한다)
		//int c = 1234567 * 1234567;
		long c = 1234567L * 1234567L;
		System.out.println(c);
		
		//(중요) 정수의 계산 결과는 정수가 나온다. (나눗셈에서도)
		int d = 10;
		int e = 3;
		System.out.println(d / e); //몫
		System.out.println(d % e); //나머지
		
	}
}
