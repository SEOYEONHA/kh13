package array;

import java.util.Scanner;

public class Test05배열입력 {
	public static void main(String[] args) {
		//배열을 만들고 사용자에게 숫자를 5개 입력받아서 저장한 뒤 출력
		
		 Scanner sc = new Scanner(System.in);
		 
		System.out.print("숫자 몇 개를 입력하시겠습니까? : ");
		int inputNumbers = sc.nextInt();
        int[] numberList = new int[inputNumbers];
        int total = 0;
        System.out.println("숫자 " + inputNumbers + "개를 입력하세요");

        for (int i = 0 ; i < numberList.length ; i++) {
            System.out.print("숫자 " + (i + 1) + " = ");
            numberList[i] = sc.nextInt();
        }
        
        System.out.println();
        System.out.print("입력한 숫자 : ");

        for (int i = 0 ; i < numberList.length ; i++) {
        	total += numberList[i];
            System.out.print(numberList[i]);
            if (i < numberList.length - 1) {
                System.out.print(", ");
        }
	}
        double average = (double) total / inputNumbers;
        System.out.println();
        System.out.println("입력한 숫자의 총 합계 : " + total);
        System.out.println("입력한 숫자의 평균 : " + average);
	}
}