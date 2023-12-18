package oop.method3;

public class Carrier {
	//멤버 변수(필드)
	String brand;
	String name;
	int price;
	int GB, call, message;
	
	//멤버 메소드
	void information() {
		System.out.println("<통신사 정보>");
		System.out.println("통신사 : " + this.brand);
		System.out.println("상품명 : " + this.name);
		System.out.println("월정액 : " + this.price + "원");
		System.out.println("데이터(GB) : " + this.GB + "GB");
		System.out.println("통화(분) : " + this.call + "분");
		System.out.println("문자(건) : " + this.message + "건");
	}
		
	void data(String brand, String name, int price, int GB, 
			int call, int message) {
		this.brand = brand;
		this.name = name;
		this.price = price;
		this.GB = GB;
		this.call = call;
		this.message = message;
	}
	
}
