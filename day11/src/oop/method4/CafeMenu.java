package oop.method4;

public class CafeMenu {
	//멤버 변수(필드)
	String name;
	String division;
	int price;
	boolean event;
	

	//멤버 메소드
	void data(String name, String division, int price, boolean event) {
		this.name = name;
		this.division = division;
		this.price = price;
		this.event = event;
		}
	void information() {
		System.out.println("<메뉴 정보>");
		if(this.event) {//주인공이 행사중이라면
			System.out.println("이름 : " + this.name + "(행사중)");
		}
		else {
			System.out.println("이름 : " + this.name);
		}
		System.out.println("분류 : " + this.division);
		
		//(주의) 할인은 즉석에서 계산해서 만들어내는것이지 저장하는게 아님
		if(this.event) {//주인공이 할인중이라면
			int discount = this.price * 80 / 100;
			System.out.println("가격 : "+discount+"원(원가 "+this.price+"원, 20% 할인)");
		}
		else {
			System.out.println("가격 : " + this.price + "원");	
		}
		
	}
}



