package loop;

import java.util.Scanner;

public class Test09타이머 {
	public static void main(String[] args) {
//			사용자에게 분과 초를 입력받아서 해당하는 시간만큼의 메세지를 출력하는 프로그램을 구현
//	
//			분 입력 : 1
//			초 입력 : 30
//	
//			1분 30초 후 알람이 울립니다
//			1분 29초 후 알람이 울립니다
//			1분 28초 후 알람이 울립니다
//			...
//			0분 2초 후 알람이 울립니다
//			0분 1초 후 알람이 울립니다
//			0분 0초 후 알람이 울립니다
//			띠링!
		
		Scanner sc = new Scanner(System.in);
		System.out.print("분 입력 : ");
		int minute = sc.nextInt();
		System.out.print("초 입력 : ");
		int second = sc.nextInt();
		
		
		int time = minute * 60 + second;
		
		System.out.println("알람을 실행합니다.");
		
		for(int i = time ; i >= 0 ; i --) {
			//int m = 1 / 60, s = i % 60;
			//System.out.println(m + "분 " + s + "초 후 알람이 울립니다.");
			System.out.println((i / 60) + "분 " + (i % 60) + "초 후 알람이 울립니다.");
		}
		System.out.println("띠링!");
		}
	}


