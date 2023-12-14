package array2;

public class Test05배열뒤집기2 {
	public static void main(String[] args) {
		//30, 50, 20, 10, 40을 배열에 저장하고 
		//이 배열의 모든 데이터의 위치를 반대로 뒤집은 뒤 출력하세요
		
		//배열 준비
		int[] numbers = new int[] {30, 50, 20, 10, 40};
		
		//위치 교체
		// - 데이터의 개수에 따른 교체 규칙 확인
		// 데이터 n개  -> 교체 n/2번
		
		int left = 0;
		int right = numbers.length - 1;
		//for(int i = 0 ; i < numbers.length/2 ; i++){
		for(int i = 1 ; i <= numbers.length/2 ; i++) {
			
			int backup = numbers[left];
			numbers[left] = numbers[right];
			numbers[right] = backup;
			
			//다음 턴을 위해서 left는 1 증가, right는 1 감소 처리
			left ++;
			right --;
			
		}
				
				
		
		//출력
		for(int i = 0 ; i < numbers.length ; i++) {
			System.out.println(numbers[i]);
			}
		}
	}


