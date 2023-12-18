package oop.method3;

public class Test01객체생성 {
	public static void main(String[] args) {
		//객체 생성
		Carrier a = new Carrier();
		Carrier b = new Carrier();
		Carrier c = new Carrier();
		
		//초기화
		a.data("SK", "5G 언택트 52", 52000, 200, 1000, 2000);
		b.data("KT", "5G세이브", 45000, 100, 900, 1500);
		c.data("LG", "5G시그니처", 130000, 500, 2000, 2500);
		
		//출력
		System.out.println("<통신사 요금제 정보>");
		a.information();
		System.out.println();
		b.information();
		System.out.println();
		c.information();
	}

}
