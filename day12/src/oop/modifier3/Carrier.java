package oop.modifier3;

public class Carrier {
	//멤버필드
	private String name;
	private String telecom;
	private int price;
	private int plan;
	
	//멤버 메소드 - setter/getter , 기타
	void setName(String name) {
		this.name = name;
	}
	void setTelecom(String telecom) {
		switch(telecom) {
		case "SK":
		case "KT":
		case "LG":
			this.telecom = telecom;
		}
	}
	void setPrice(int price) {
		if(price < 0) {
			return;
		}
		this.price = price;
	}
	void setPlan(int plan) {
		if(plan == 0 || plan == 24 || plan == 36) {
			this.plan = plan;
		}
	}
	
	String getName() {
		return this.name;
	}
	String getTelecom() {
		return this.telecom;
	}
	int getPrice() {
		return this.price;
	}
	int getPlan() {
		return this.plan;
	}
	int getMonthly(){
		return this.getPrice() / this.getPlan();
	}
	int getDiscount() {
		return this.getPrice() * 95 / 100;
	}
	
	void data(String name, String telecom, int price, int plan) {
		this.setName(name);
		this.setTelecom(telecom);
		this.setPrice(price);
		this.setPlan(plan);
	}
	void information() {
		System.out.println("<휴대폰 판매 정보>");
		System.out.println("휴대폰 이름 : " + this.name);
		System.out.println("통신사 : " + this.telecom);
		if(this.getPlan() == 0) {
			System.out.println("가격 : " + this.price + "원 (약정없음)");
			System.out.println("5% 할인된 가격 : " + this.getDiscount() + "만원");
		}
		else {
			System.out.println("가격 : " + this.price + "원, 약정 개월 : " + this.plan + "개월 (월 " + this.getMonthly() + "원 씩 납부)");
		}
		System.out.println();
	}
}
