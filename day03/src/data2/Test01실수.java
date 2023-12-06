package data2;

public class Test01실수 {

	public static void main(String[] args) {
		//실수
		//- 소수점이 있는 숫자
		//- 손해가 좀 발생하더라도 경량 형태(부동소수점 방식)로 저장하도록 구성
		//- float, double이 있으며 double이 기본 형태
		
		double a = 123.4567;
		System.out.println(a);
		
		float b = 123.4567f;
		System.out.println(b);
		
		//- 실수가 하나라도 포함된 계산은 결과가 ㅣㄹ수
		int s1 = 50;
		int s2 = 55;
		int s3 = (s1 + s2) / 2;
		System.out.println(s3);
		
		double s4 = (s1 + s2) / 2.0;
		System.out.println(s4);
		
	}

}
