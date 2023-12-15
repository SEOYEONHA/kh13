package array3;

public class Test01선택정렬3 {
	public static void main(String[] args) {
		
		//배열 준비
		int[] numbers = new int[] {30, 50, 20, 10, 40};
		
		//선택 정렬(selection sort) - 최소값을 앞에서부터 채우는 방식
		
		//첫 번째 회차에서 발생하는 일
		//- [2]부터 [4] 사이에서 최소값의 위치를 찾아 [2]와 바꾼다
		
		int min = 2; //[2]이 가장 작은값의 위치라고 치자
		for(int i = 3 ; i < numbers.length ; i ++) {//[3]부터 [4]사이의 범위에서
			if(numbers[min] > numbers[i]) {//내 생각보다 더 작은값이 있다면
				min = i;//생각을 수정한다
				}
			}
		int backup = numbers[2]; 
		numbers[2] = numbers[min];
		numbers[min] = backup;
		
		for(int k = 0 ; k < numbers.length ; k++) {
			System.out.println(numbers[k]);
			}
	}
}