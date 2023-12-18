package oop.basic2;

public class Test01객체생성 {
	public static void main(String[] args) {
		//4명의 학생 데이터를 생성
		
		School a = new School();
		School b = new School();
		School c = new School();
		School d = new School();
		
		//초기화
		a.name = "뽀로로";
		a.grade = 1;
		a.score = 70;
		
		b.name = "크롱";
		b.grade = 1;
		b.score = 55;
		
		c.name = "포비";
		c.grade = 2;
		c.score = 80;
		
		d.name = "해리";
		d.grade = 2;
		d.score = 75;
		
		System.out.println("<학생 정보>");
		System.out.println("이름 : " + a.name);
		System.out.println("학년 : " + a.grade);
		System.out.println("점수 : " + a.score + "점");
		
		System.out.println("<학생 정보>");
		System.out.println("이름 : " + b.name);
		System.out.println("학년 : " + b.grade);
		System.out.println("점수 : " + b.score);

		System.out.println("<학생 정보>");
		System.out.println("이름 : " + c.name);
		System.out.println("학년 : " + c.grade);
		System.out.println("점수 : " + c.score);
		
		System.out.println("<학생 정보>");
		System.out.println("이름 : " + d.name);
		System.out.println("학년 : " + d.grade);
		System.out.println("점수 : " + d.score);
	}

}
