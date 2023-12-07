package io;

import java.util.Scanner;

public class Test05시간계산기 {
	public static void main(String[] args) {
		//사용자에게 강의장 입실시각과 퇴실시각을 4자리 정수로 입력받아 수업에 참여한 시간을 계산하여 출력하는 프로그램을 구현

		//입실시각 입력 : 0925
		//퇴실시각 입력 : 1827

		//수업에 참여한 시간은 총 9시간 2분입니다.
		
		Scanner sc = new Scanner(System.in);
		
		//입력
		System.out.print("입실시각 입력 : ");
		int in = sc.nextInt();
		System.out.print("퇴실시각 입력 : ");
		int out = sc.nextInt();
		
		//계산
		int inHour = in / 100 , inMinute = in % 100;
		int outHour = out / 100 , outMinute = out % 100;
		int inTotal = (inHour * 60) + inMinute;
		int outTotal = (outHour * 60) + outMinute;
		int time = outTotal - inTotal;
		int hour = time / 60 ,  minute = time % 60;
		
		//출력
		//System.out.println(); // 엔터 or 아래처럼 \n사용
		System.out.println("\n수업에 참여한 시간은 총 " + hour + 
				"시간 " + minute + "분입니다.");
				
	}

}
