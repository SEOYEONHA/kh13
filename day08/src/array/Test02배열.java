package array;

public class Test02배열 {
	public static void main(String[] args) {
		//1.5 , 3.2 , 7.4를 저장한 뒤 출력
		//- 변수 3개를 쓰거나 배열 1개를 쓰거나
		
		double[] arr = new double[] {1.5, 3.2, 7.4};
		
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		
		//반복문 사용 가능
		for(int i = 0 ; i <= 2 ; i++) {
			System.out.println(arr[i]);
		}
	}	

}
