package loop3;

import java.util.Scanner;

public class Test03합계구하기 {
	public static void main(String[] args) {
		//사용자가 0을 입력하기 전까지 입력한 숫자들의 합계와 
		//평균을 구하여 출력
		
		Scanner sc = new Scanner(System.in);
		int count = 0;
		int total = 0;
		
		while(true) {
			System.out.print("숫자 입력 : ");
			int userEnter = sc.nextInt();
				total  += userEnter;
				count ++;
			
				if (userEnter == 0) {
					break;
			}
			
		}
		
		double average = (double)total / (count - 1); // double average = user * 1.0 / (count - 1);
		
		System.out.println(total);
		System.out.println(average);
		
	}


}
