package oop.keyword5;

//회원 클래스
//- 아이디는 최초 설정 이후 "절대로" 변경되면 안됩니다
public class Member {
	private final String id;
	private String password;

	//final 항목이 필드로 존재한다면 반드시 생성자에서 초기화를 해야한다
	public Member(String id, String password) {
		this.id = id;
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getId() {
		return id;
	}
	//fianl 필드는 setter 메소드 생성이 불가능하다
	//public void setId(String id){
	//this.id  id;
	//}
}
