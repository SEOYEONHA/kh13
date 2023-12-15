package array3;

public class Test02버블정렬3 {
    public static void main(String[] args) {
        // 배열 준비
    	
        int[] numbers = new int[] {50, 30, 20, 10, 40};

        // 버블정렬(bubble sort) - 인접한 두 개의 값을 비교하여 교체하는 방식
        
        if(numbers[0] > numbers[1]) {
        	int backup = numbers[0];
        	numbers[0] = numbers[1];
        	numbers[1] = backup;
        }
                
        
                // 출력
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }
}