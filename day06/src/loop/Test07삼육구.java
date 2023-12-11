package loop;

public class Test07삼육구 {
	public static void main(String[] args) {
		// '1'부터 '99'사이의 숫자 중 369게임상에서 박수를 쳐야하는 
		// 숫자들만 골라서 출력
		
		for(int i = 1 ; i <= 99 ; i ++) {
			boolean three = i / 10 == 3 || i % 10 == 3;
			boolean six = i / 10 == 6 || i % 10 == 6;
			boolean nine = i / 10 == 9 || i % 10 == 9; 
					
			if(three || six || nine) {
				System.out.println(i);
			}
			}
	}
}

