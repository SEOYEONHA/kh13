package oop.modifier1;

public class Book {
	
	//멤버 필드(변수)
	//-외부에서 접근이 불가능하도록 잠금(private) 처리
	private String title;
	private String author;
	private int price;
	private int page;
	
	//변수가 잠기면 외부에서 직접 접근할 수 있는 방법이 없다
	//- 설정을 위한 setter 메소드, 확인을 위한 getter 메소드를 설정해야 한다
	void setTitle(String title) {
		this.title = title;
	}
	void setAuthor(String author) {
		this.author = author;
	}
	void setPrice(int price) {
		if(price >= 0) {
			this.price = price;
		}
	}
	void setPage(int page) {
		if(page > 0) {
			this.page = page;
		}
	}

	String getTitle() {
		return this.title;
	}
	String getAuthor() {
		return this.author;
	}
	int getPrice() {
		return this.price;
	}
	int getPage() {
		return this.page;
	}
	
	
	//멤버 메소드
	void data(String title, String author, int price, int page) {
		this.setTitle(title);
		this.setAuthor(author);
		this.setPrice(price);
		this.setPage(page);
	}
	void information() {
		System.out.println("<도서 정보>");
		System.out.println("이름 : " + this.title);
		System.out.println("저자 : " + this.author);
		System.out.println("가격 : " + this.price + "원");
		System.out.println("페이지 : " + this.page);
	}
}
