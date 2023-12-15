package array3;

public class Test01선택정렬4 {
	public static void main(String[] args) {
		
		//배열 준비
		int[] numbers = new int[] {30, 50, 20, 10, 40, 80, 60, 70};
		
		//선택 정렬(selection sort) - 최소값을 앞에서부터 채우는 방식
		
		for(int k = 0 ; k < numbers.length - 1 ; k ++) {
		int min = k; //[k]이 가장 작은값의 위치라고 치자
		for(int i = k + 1 ; i < numbers.length ; i ++) {//[3]부터 [4]사이의 범위에서
			if(numbers[min] > numbers[i]) {//내 생각보다 더 작은값이 있다면
				min = i;//생각을 수정한다
				}
			}
		int backup = numbers[k]; 
		numbers[k] = numbers[min];
		numbers[min] = backup;
		
			}
		for(int i = 0 ; i < numbers.length ; i++) {
			System.out.println(numbers[i]);
		}
	}
}