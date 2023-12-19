package oop.modifier2;

public class Academy {
	//멤버필드
	private String title;
	private int time;
	private int price;
	private String type;
	
	void setTitle(String title) {
		this.title = title;
	}
//	void setTime(int time) {
//		if(time > 0 && time % 30 ==0) {
//			this.time = time;
//		}
//	}
	void setTime(int time) {
		if(time <=0 || time % 30 != 0) {
			return; //그만해!
		}
		this.time = time;
	}
// pirce가 0 이상일 경우 설정하세요 (화이트리스트 방식)
//	void setPrice(int price) {
//		if(price >= 0) {
//			this.price = price;
//		}
//	}
	
// price가 0미만이라면 설정하지 마세요 (블랙리스트 방식)
	void setPrice(int price) {
		if(price < 0) {
			return;
		}
		this.price = price;
	}
	//(주의) 문자열과ㅑ 객체 등은 비교연산을 쓰지 않는다
	//			(비교연산은 원시형을 위한 연산)
	//(해결) 별도의 비교명령을 쓰거나 switch구문을 사용
	void setType(String type) {
//		if(type == "온라인" || type == "오프라인" || type == "혼합") {
//			this.type = type;
//		}
		switch(type) {
		case "온라인":
		case "오프라인":
		case "혼합":
			this.type = type;
		}
	}
	
	String getTitle() {
		return this.title;
	}
	int getTime() {
		return this.time;
	}
	int getPrice() {
		return this.price;
	}
	String getType() {
		return this.type;
	}
	//1시간당 수강료를 계산하는 메소드가 추가로 필요하다(가상의 getter)
	int getPricePerHour() {
		return this.getPrice() / this.getTime() ;
	}
	
	
	void data(String title, int time, int price, String type) {
		this.setTitle(title);
		this.setTime(time);
		this.setPrice(price);
		this.setType(type);
	}
	void information() {
		System.out.println("<학원 강의 요금표>");
		System.out.println("강좌명 : " + this.title);
		System.out.println("강의 시간 : " + this.time);
		System.out.println("수강료 : " + this.price + "원 (시간당 " + this.getPricePerHour() + "원)");
		System.out.println("구분 : " + this.type);
		System.out.println();
	}
}
