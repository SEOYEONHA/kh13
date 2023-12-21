package oop.inherit2;

//"휴대전화"의 공통점을 모아둔 추상적인 클래스
//-객체를 만들기 위함이 아니라 클래스를 편하게 만들기 위한 클래스
public class Phone {
	//공통 필드 - "휴대전화"라면 있어야하는 필드
	private String number; //"휴대전화"라면 전화번호가 있어야지!
	private String color; //"휴대전화"라면 색상이 있어야지!
	
	//공통 메소드 - "휴대전화"라면 있어야 하는 기능
	public void call() {//"휴대전화"라면 전화기능이 있어야지!
		System.out.println("전화 기능");
	}
	public void sms() {//"휴대전화"라면 문자기능이 있어야지!
		System.out.println("문자 기능");
	}
}
