package oop.modifier1_1;

public class Test01 {
	public static void main(String[] args) {
		Book a = new Book();
		
		a.data("마흔에 읽는 쇼펜하우어", "강용수", 15300, 850);
		
		//만약 페이지를 900으로 변경하려면
		a.page = 900;//변수를 직접 건드리거나
		//a.data("마흔에 읽는 쇼펜하우어", "강용수", 15300, 900); //메소드를 부르거나
		
		a.information();
	}

}
