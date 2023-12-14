package array2;

public class Test04위치변경 {
	public static void main(String[] args) {
		//배열 준비
		int[] numbers = new int[] {30, 50, 20, 10, 40};
		
		//[0]과 [3]의 데이터를 바꿔서 출력
		
		//- 자바는 데이터의 맞교환이 불가능(한칸에 하나밖에 안들어감)
		//numbers[0] = numbers[3];
		//numbers[3] = numbers[0];
		
		//- 변수를 하나 더 만들어서 백업할 수 있도록 구현
		int backup = numbers[0];
		numbers[0] = numbers[3];
		numbers[3] = backup;
		
		System.out.println(numbers[0]);
		System.out.println(numbers[1]);
		System.out.println(numbers[2]);
		System.out.println(numbers[3]);
		System.out.println(numbers[4]);
	}

}
