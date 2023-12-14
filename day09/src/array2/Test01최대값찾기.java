package array2;

public class Test01최대값찾기 {
	public static void main(String[] args) {
		
		int[] numbers =  new int[] {30, 50, 20, 10, 40};
		
		int max = 0;
		for(int i = 1 ; i < numbers.length ; i++) {//1부터 4까지 반복하며
			if(numbers[max] < numbers[i]) {
				max = i;
			}
		}
		System.out.println("max = " + numbers[max]);
	}

}
