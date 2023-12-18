package oop.method2;

public class Test01문제풀이 {
	public static void main(String[] args) {
		//객체 생성
		Olympic a = new Olympic();
		Olympic b = new Olympic();
		Olympic c = new Olympic();
		
		//초기화
		a.data("진종오", "사격", "하계", 4, 2, 0);
		b.data("김수녕", "양궁", "하계" , 4, 1, 1);
		c.data("전이경", "쇼트트랙", "동계", 4, 0, 1);
		
		//출력
		System.out.println("<역대 한국인 올림픽 메달 보유 선수>");
		a.information();
		System.out.println();
		b.information();
		System.out.println();
		c.information();
	}
}
