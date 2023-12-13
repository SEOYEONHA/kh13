package array;

public class Test01배열 {
	public static void main(String[] args) {
		
		
		// - 같은 종류의 데이터를 여러 개 모아서 저장
		//(Q) 숫자 3개(10, 20, 30)를 저장하고 출력하세
		//(A) 변수 3개를 만들어서 저장 후 출력
		
		int a = 10;
		int b = 20;
		int c = 30;
		
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("c = " + c);
		
		//(A) 배열을 만들어서 저장 후 출력
		int[] arr = new int[] {10, 20, 30};
		
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
	}

}
