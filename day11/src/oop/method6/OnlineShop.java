package oop.method6;

public class OnlineShop {
		//멤버 변수
		
		String name;
		String type;
		int price;
		boolean earlyDelivery;
		boolean event;
		
		//멤버 메소드
//		void data(String name, String type, int price) {
//		this.name = name;
//		this.type = type;
//		this.price = price;
//		this.earlyDelivery = false;
//		this.event = false;
//		this.data(name, type, price,false,false);
//		}
		void data(String name, String type, int price, 
				boolean earlyDelivery, boolean event) {
			this.name = name;
			this.type = type;
			this.price = price;
			this.earlyDelivery = earlyDelivery;
			this.event = event;
		}
		//(주의) 구분되지 않는 상황은 오버로딩이 불가능하다
//		void data(String name, String type, int price, 
//				boolean earlyDelivery) {
//		}
//		void data(String name, String type, int price, 
//				boolean event) {
//			this.name = name;
//			this.type = type;
//			this.price = price;
//			this.earlyDelivery = false;
//			this.event = event;
//		}
		
		void information() {
			System.out.println("상품명 : " + this.name);
			System.out.println("상품분류 : " + this.type);
			if(this.event) {
				int discount = this.price * 90 / 100;
				System.out.println("가격 : "+discount+"원(원가 "+ this.price+"원, 10% 할인 행사중)");
			}
			else {
				System.out.println("가격 : " + this.price + "원");	
			}
			if(this.earlyDelivery) {
				System.out.println("새벽배송 가능상품으로 배송비 2500원이 추가됩니다.");
			}
			else {
				System.out.println("새벽배송 불가 상품입니다.");
			}
		}
		

		
	}

