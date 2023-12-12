package loop3;

public class Test02누적합계 {
	public static void main(String[] args) {
//		다음 누적합계를 구하세요
//
//		1부터 100 사이의 짝수 합계를 구하여 출력
//		1부터 100 사이의 7의 배수의 합계를 구하여 출력
//	
		int even= 0;
		int seven = 0;
		for(int i = 1; i <= 100; i ++) {
			if (i % 2 == 0) {
				even += i;
			}
			if (i % 7 == 0) {
				seven += i;
			}
	
}
		System.out.println("1부터 100 사이의 짝수 합계 : " + even);
		System.out.println("1부터 100 사이의 7의 배수의 합계 : " + seven);
	}
}