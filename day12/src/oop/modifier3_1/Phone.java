package oop.modifier3_1;

public class Phone {
	//멤버 필드(변수)
	private String name;
	private String telecom;
	private int price;
	private int contact;
	
	//멤버 메소드 - setter/getter , 기타
	void setName(String name) {
		this.name = name;
	}
	void setTelecom(String telecom) {
		switch(telecom) {
		case "SK":
		case "LG":
		case "KT":
			this.telecom = telecom;
		}
	}
	void setPrice(int price) {
		if(price < 0) return;
		this.price = price;
	}
	void setContact(int contact) {
		switch(contact) {
		//case 0, 24, 36:
		case 0: case 24: case 36:
			this.contact = contact;
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
	int getContact() {
		return this.contact;
	}

	boolean getContactStatus() {
		//return this.contact > 0;
		if(this.contact > 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	int getResult() {
		if(!this.getContactStatus()) {//약정기간이 없으면
			return this.getPrice() * 95 / 100;
		}
		else {//약정기간이 있으면
			return this.getPrice();
		}
	}
	int getMonthPrice() {
		return this.getPrice() / this.getContact();
	}
	
	void data(String name, String telecom, int price) {
		this.data(name, telecom, price, 0);
	}
	void data(String name, String telecom, int price, int contact) {
		this.setName(name);
		this.setTelecom(telecom);
		this.setPrice(price);
		this.setContact(contact);
	}
	
	void information() {
		System.out.println("<기기 판매정보>");
		System.out.println("이름 : " + this.getName());
		System.out.println("통신사 : " + this.getTelecom());
		System.out.println("가격 : " + this.getResult()+"원");
		if(this.getContactStatus()) {
			System.out.println("(월 "+this.getMonthPrice()+"원)");
		}
		System.out.println("약정기간 : " + this.getContact()+"개월");
	}
}