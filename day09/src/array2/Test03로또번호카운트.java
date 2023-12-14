package array2;

import java.util.Random;

public class Test03로또번호카운트 {
	public static void main(String[] args) {
//		KH로또연구소에서는 가장 많이 나오는 로또번호가 몇번인지 알고 싶어서 시뮬레이션을 진행하려고 합니다.
//
//		로또번호를 1000번정도 추첨해서 각각 나온 횟수를 저장하려고 합니다.
//
//		번호별로 나온 횟수를 출력
//		가장 많이 나온 번호를 출력(동점이면 아무거나)
		
		Random r = new Random();
		
		int counts[] = new int [45];
		 
		for(int i = 0 ; i < 1000 ; i ++) {
			int number = r.nextInt(45) + 1;
			//System.out.println("number = " + number);
			
			counts[number - 1] ++;
		}
		
		int max = 0;
		for(int i = 0 ; i < counts.length ; i ++) {
			if (counts[i] > max) {
				max = i;
				}
		
			System.out.println((i+1) + " 나온 횟수 = " + counts[i]);
			//2 - 동점까지 출력하고 싶다면
		}
			for(int i = 0; i < counts.length ; i ++) {
				if(counts[max] == counts[i]) {
					System.out.println("가장 많이 나온 번호 = " + (i + 1) + "(" + counts[i] + "번)");
				}
			}
		}
		
	}

		