package loop;

public class Test06필터링2 {
	public static void main(String[] args) {
		// '1'부터 '99'사이의 숫자 중에서 '5'가 포함된 숫자들만 출력
		
		for(int i = 1 ; i <= 99 ; i ++) {
			boolean ten = i / 10 == 5 ;
			boolean one = i % 10 == 5;
			if(ten || one) {
				System.out.println(i);
			}
		}
	}

}
