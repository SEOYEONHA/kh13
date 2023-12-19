package oop.modifier1_1;

public class Book {
	
	//멤버 필드(변수)
	String title;
	String author;
	int price;
	int page;

	//멤버 메소드
	void data(String title, String author, int price, int page) {
		this.title = title;
		this.author = author;
		this.price = price;
		if(page > 0) {
			this.page = page;
		}
	}
	void information() {
		System.out.println("<도서 정보>");
		System.out.println("이름 : " + this.title);
		System.out.println("저자 : " + this.author);
		System.out.println("가격 : " + this.price + "원");
		System.out.println("페이지 : " + this.page);
	}
}
