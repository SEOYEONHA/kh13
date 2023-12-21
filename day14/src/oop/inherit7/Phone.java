package oop.inherit7;

//이 클래스는 상속에서 상위 클래스 역할을 수행한다
public abstract class Phone { //상속용 클래스 (추상클래스)
	private String number;
	public void setNumber(String number) {
		this.number = number;
	}
	public void information() {
		System.out.println("전화번호 : " + this.number);
	}
	
	
	//전화기니까 전화 기능이 있어야겠지 .....?
	//근데 어떻게 거는지는 아직 모르겠는데...
	public abstract void call();
	public abstract void sms();
}
