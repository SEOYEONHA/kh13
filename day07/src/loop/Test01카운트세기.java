package loop;

public class Test01카운트세기 {
	public static void main(String[] args) {
		
		//(Q) 1부터 100 사이의 짝수 개수 - (A) 50개
		
		//1. 일단 1부터 100 사이의 범위를 만든다(for)
		//2. 조건을 추가하여 짝수만 출력하도록 구문을 만든다
		//3. 2번에서 만든 영역에 대한 개수를 카운트
		
		int count = 0; // 카운트 측정을 위한 변수를 선언
		for(int i =1 ; i <= 100 ; i ++) { //1
			if(i % 2 == 0) { //2
				count ++;
			}
		}
		System.out.println("짝수 개수 = " + count);
	}

}
