package loop;

public class Test05필터링2 {
	public static void main(String[] args) {
		//Test05필터링
		//다음 숫자를 화면에 출력해보세요
		
		//1부터 20 사이의 홀수
		//1부터 50 사이의 3의배수
		
		for(int i = 1 ; i <= 20 ; i = i + 2) {
			if(i % 2 == 1) { //홀수라면
			System.out.println(i);
	    	}
		}
		for(int i = 3 ; i <= 50 ; i = i + 1) {
			if(i % 3 == 0) { //3의 배수라면
			System.out.println(i);
			}
		}
	}
}
