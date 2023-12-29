package api.lang.exception;

public class Test09예외전가 {
	public static void main(String[] args) {
		
		System.out.println("시작!");
		
		//Plan B가 없으면 부를 수 없는 위험한 메소드
		try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		
		System.out.println("종료!");
	}
}
