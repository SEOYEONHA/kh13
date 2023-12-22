package oop.inherit8;

public abstract class Phone {
	private String number;
	private String color;
	
	public Phone(String number, String color) {
		this.setNumber(number);
		this.setColor(color);
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	public String getNumber() {
		return number;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getColor() {
		return color;
	}
	
	public abstract void call();
	public abstract void sms();
	
	public final void show() {
		System.out.println("<휴대전화 정보>");
		System.out.println("전화번호 : " + this.number);
		System.out.println("색상 : " + this.color);
	}
	
}
