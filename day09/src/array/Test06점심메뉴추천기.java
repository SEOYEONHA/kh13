package array;

import java.util.Random;
import java.util.Scanner;

public class Test06점심메뉴추천기 {
	public static void main(String[] args) {
		//사용자에게 5가지의 점심메뉴를 입력받아 배열에 저장한 뒤
		//무작위로 한 개를 골라 출력하도록 프로그램을 구현하세요.
		//입력 : 자장면
		//입력 : 피자
		//입력 : 육개장
		//입력 : 회덮밥
		//입력 : 떡볶이

		//오늘은 "육개장"을 드시죠
		
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		
		int RandomLunch = r.nextInt(5);
		String[] lunchList = new String[5];
		
		for(int i = 0 ; i < lunchList.length ; i++) {
			System.out.print("점심 메뉴 입력 : ");
			lunchList[i] = sc.nextLine();
		}
		//for(int i2 = 0 ; i2 < lunchList.length ; i2++) {
			//System.out.println(lunchList[i]);
			//int RandomLunch = r.nextInt(5);
			System.out.println("오늘은 \"" + lunchList[RandomLunch] + "\"을 드시죠");
			//System.out.println(RandomLunch);
		//}
		
	}
	}
