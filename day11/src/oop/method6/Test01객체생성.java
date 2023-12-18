package oop.method6;

public class Test01객체생성 {
	public static void main(String[] args) {
		//객체 생성
		OnlineShop a = new OnlineShop();
		OnlineShop b = new OnlineShop();
		OnlineShop c = new OnlineShop();
		OnlineShop d = new OnlineShop();
		
		//초기화
		a.data("참이슬후레쉬", "주류", 1200, true, true);
		b.data("클라우드맥주", "주류", 3000, false, true);
		c.data("바나나킥", "과자", 1500, false, true);
		d.data("허니버터칩", "과자", 2000, true, false);
		
		System.out.println("<온라인 쇼핑몰 상품 정보>");
		a.information();
		System.out.println();
		b.information();
		System.out.println();
		c.information();
		System.out.println();
		d.information();
	}

}
