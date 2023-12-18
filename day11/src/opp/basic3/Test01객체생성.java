package opp.basic3;

public class Test01객체생성 {
	public static void main(String[] args) {
		
		Football a = new Football();
		Football b = new Football();
		Football c = new Football();
		Football d = new Football();
		
		//초기화
		a.rank = 1;
		a.team = "아스널";
		a.win = 12;
		a.draw = 3;
		a.lose = 2;
		
		b.rank = 2;
		b.team = "리버풀";
		b.win = 11;
		b.draw = 5;
		b.lose = 1;
		
		c.rank = 3;
		c.team = "애스턴 빌라";
		c.win = 12;
		c.draw = 2;
		c.lose = 3;
		
		d.rank = 4;
		d.team = "아스널";
		d.win = 10;
		d.draw = 4;
		d.lose = 3;
		
		System.out.println("<영국 축구 순위>");
		System.out.println("순위 : " + a.rank);
		System.out.println("클럽명 : " + a.team);
		System.out.println("승리 : " + a.win);
		System.out.println("무승부 : " + a.draw);
		System.out.println("패배 : " + a.lose);
		
		System.out.println();
		
		System.out.println("순위 : " + b.rank);
		System.out.println("클럽명 : " + b.team);
		System.out.println("승리 : " + b.win);
		System.out.println("무승부 : " + b.draw);
		System.out.println("패배 : " + b.lose);
		
		System.out.println();
		
		System.out.println("순위 : " + c.rank);
		System.out.println("클럽명 : " + c.team);
		System.out.println("승리 : " + c.win);
		System.out.println("무승부 : " + c.draw);
		System.out.println("패배 : " + c.lose);
		
		System.out.println();
		
		System.out.println("순위 : " + d.rank);
		System.out.println("클럽명 : " + d.team);
		System.out.println("승리 : " + d.win);
		System.out.println("무승부 : " + d.draw);
		System.out.println("패배 : " + d.lose);
	}

}
