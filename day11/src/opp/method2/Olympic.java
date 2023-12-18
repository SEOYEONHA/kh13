package opp.method2;

public class Olympic {
	
	//멤버 변수(필드) - 이 객체가 가져야 하는 데이터를 정의
	String name; // 반드시 이름정보가 저장될 곳이 있어야 한다
	String event; // 반드시 종목정보가 저장될 곳이 있어야 한다
	String division; // 반드시 구분정보가 저장될 곳이 있어야 한다
	int gold, silver, bronze; // 반드시 금,은,동 메달이 저장될 곳이 있어야 한다

	//멤버 메소드 - 이 객체가 가지면 좋은 코드를 정의
	//- information : 객체의 정보를 출력하는 메소드
	//- data : 객체의 정보를 초기화하는 메소드
	void information() {
		//this = 현재 실행중인 객체(주인공)
		System.out.println("<선수 정보>");
		System.out.println("이름 : " + this.name);
		System.out.println("종목 : " + this.event);
		System.out.println("구분 : " + this.division);
		System.out.println("금메달 : " + this.gold + ", 은메달 : " + this.silver + ", 동메달 : " + this.bronze);
	}

	void data(String name, String event, String division, int gold, int silver, int bronze) {
		this.name = name;
		this.event = event;
		this.division = division;
		this.gold = gold;
		this.silver = silver;
		this.bronze = bronze;
	}
}
