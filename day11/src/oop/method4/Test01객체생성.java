package oop.method4;

public class Test01객체생성 {
	public static void main(String[] args) {
		//객체 생성
		CafeMenu c1 = new CafeMenu();
		CafeMenu c2 = new CafeMenu();
		CafeMenu c3 = new CafeMenu();
		CafeMenu c4 = new CafeMenu();
		
		//초기화
		c1.data("아메리카노", "음료", 2500, true);
		c2.data("모카라떼", "음료", 3500, false);
		c3.data("치즈케이크", "디저트", 5000, true);
		c4.data("마카롱", "디저트", 3000, true);
		
		//출력
				System.out.println("<커피숍 메뉴 정보>");
				c1.information();
				System.out.println();
				c2.information();
				System.out.println();
				c3.information();
				System.out.println();
				c4.information();
	}

}
