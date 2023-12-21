package oop.inherit4;

//상위(super) 클래스 구현 시 주의사항
//필드 - 접근 제한 설정(private/protected)
//- private으로 설정하면 setter/getter를 통해서만 접근이 가능(강력한 통제)
//- protected로 설정하면 setter/getter 없이 하위 클래스에서 자유롭게 접근 가능
//메소드 
//- 재정의(override) 설정
//- final 키워드를 이용해서 재정의를 금지할 수 있다
//- 재정의를 하면 메소드의 형태를 제외한 모든 것을 바꿀 수 있다
//생성자 (객체를 만들 때 꼭 집어넣어야하는 것)
//- 필수 설정 항목을 정의
//- 상속을 받으려면 생성자를 맞춰야만 가능하다
//- 빠르고 편리한 자동 완성 코드 구현 가능


public class Phone {
	
	private String number; //전화기엔 번호가 있어야한다(아무도 못건드려)
	//protected String number;//전화기엔 번호가 있어야한다(우리말고는 못건드려)
	
	//전화기를 만들려면 번호를 꼭 설정해야 된다
	//= 번호가 없으면 전화기는 못만들어!
	public Phone(String number) {
		this.setNumber(number);
	}
	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	//재정의를 금지하고 싶다면 final 키워드를 메소드에 붙이면 된다
	public void internet() {//재정의 가능
	//public final void internet() {//재정의 불가
		System.out.println("인터넷 기능");
	}
	
}
