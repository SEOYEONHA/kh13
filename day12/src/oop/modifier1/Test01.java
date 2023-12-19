package oop.modifier1;

public class Test01 {
	public static void main(String[] args) {
		Book a = new Book();
		
		a.data("마흔에 읽는 쇼펜하우어", "강용수", 15300, 850);
		
		//만약 페이지를 900으로 변경하려면
		//a.page = 900;//변수를 직접 건드리거나
		//a.data("마흔에 읽는 쇼펜하우어", "강용수", 15300, 900); //메소드를 부르거나
		a.setPage(-900);//setter 메소드를 사용하거나
		
		a.information();
		
		Book b = new Book();
		b.data("트렌드 코리아 2024", "김난도 외", 17100, 950);
		
		//(Q) a와 b의 가격차이는?
		//System.out.println(a.price - b.price); //잠겨서 안됨
		System.out.println(a.getPrice() - b.getPrice());
	}

}
