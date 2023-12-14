package array2;

import java.util.Scanner;

public class Test02의미있는평균 {
	public static void main(String[] args) {
//		사용자에게 5개의 실수를 입력받아 평균을 구하려고 합니다. 
//
//		좀 더 의미있는 데이터를 만들기 위해서 가장 작은 값과 가장 큰 값을 뺀 나머지 데이터로 평균을 구하는 프로그램을 구현하세요.
//
//		(단, 최소나 최대값이 2개이상이라면 둘 중 아무거나 한 개를 정해서 하시면 됩니다.)
		
		
		Scanner sc = new Scanner(System.in);
		double numbers [] = new double [5];
		System.out.println("5개의 실수를 입력하세요");
		for(int i = 0 ; i < numbers.length ; i ++) {
			System.out.print("실수 " + (i + 1) + " = ");
			numbers[i] = sc.nextDouble();
		}
		
		int total = 0;
		int max = 0;
		int min = 0;
		
		for(int i = 0 ; i < numbers.length ; i ++) {
			total += numbers[i];
			if(numbers[max] < numbers[i]) {
				max = i;
			}
		}
			for(int i = 0 ; i < numbers.length ; i ++) {
				if(numbers[min] > numbers[i]) {
					min = i;
			}
		}
		
		System.out.println("최대값 = " + numbers[max]);	
		System.out.println("최소값 = " + numbers[min]);
		System.out.println("총 합계 = " + total);
		
		double average = (total - numbers[max] - numbers[min]) / 3;
		System.out.println("의미있는 평균 = " + average);
	}
}

