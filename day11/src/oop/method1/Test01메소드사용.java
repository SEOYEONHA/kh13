package oop.method1;

public class Test01메소드사용 {
	public static void main(String[] args) {
		//객체 생성
		Football a = new Football();
		Football b = new Football();
		Football c = new Football();
		Football d = new Football();
		
		//초기화
		//- 팀 정보시간은 모두 다르므로 메소드를 사용할 때 정보 전달
		a.data(1, "아스널" , 12, 3, 2);
		b.data(2, "리버풀", 11, 5, 1);
		c.data(3, "애스턴 빌라",12	, 2, 3);
		d.data(4, "맨 시티", 10, 4, 3);
		
		//출력
		a.information(); //a를 주인공으로 해서 information에 저장된 코드를 실행
		b.information();
		c.information();
		d.information();
	}

}
