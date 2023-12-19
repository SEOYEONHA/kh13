package oop.method7;

public class Test01객체생성 {
	public static void main(String[] args) {
		//객체 생성
		Grade a = new Grade();
		Grade b = new Grade();
		Grade c = new Grade();
		Grade d = new Grade();
		
		//초기화
		a.data(1, 1, "마리오", 50, 60, 50);
		b.data(1, 1, "루이지", 60, 90, 50);
		c.data(1, 2, "쿠파", 70, 70, 80);
		d.data(1, 2, "요시", 80, 85, 35);
		
		
		//출력
		System.out.println("<학생 성적 정보>");
		a.information();
		System.out.println();
		b.information();
		System.out.println();
		c.information();
		System.out.println();
		d.information();
	}

}
