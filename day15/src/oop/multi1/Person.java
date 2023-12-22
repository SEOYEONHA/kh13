package oop.multi1;

//인터페이스는 클래스와 상속 키워드가 다르다
public class Person /*extends 클래스*/implements Singer, Comedian{
								//핵심상속 			//부가상속(절대로 super가 될 수 없음)
	@Override
	public void gag() {
		
	}

	@Override
	public void sing() {
		
	}

}
