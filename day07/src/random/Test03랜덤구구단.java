package random;

import java.util.Random;
import java.util.Scanner;

public class Test03랜덤구구단 {
	public static void main(String[] args) {
//		10개의 랜덤 구구단 문제를 출제하는 프로그램을 구현하세요
//		-2단 부터 19단 까지의 범위 내에서 출제
//		-사용자에게 입력을 받아 정답, 오답 판정
//		-사용자가 맞춘 문제 수를 카운트하여 출력
//		-맞춘 문제 하나당 점수를 부여
//			-쉬운 문제는 10점 (2~11단, x1)
//			-어려운 문제는 15점 (나머지)
//		-사용자가 획득한 점수를 누적합산하여 출력
		
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		
		
		int count = 0;
		int score = 0;
		int easy = 0;
		int difficult = 0;
		
		System.out.println("구구단 게임 시작!");
		
		for(int i1 = 1 ; i1 <= 10 ; i1 ++) {
		int i = r.nextInt(9)+1;
		int table = r.nextInt(18)+2;
		
		System.out.print(table + " x " + i + " = ");
		int result = table * i;
		int userResult = sc.nextInt();
		boolean correct = result == userResult;
		if (correct && i == 1) {
			System.out.println("정답!");
			count += 1;
			score += 10;
			easy += 1;
		}
		else if ((correct && table <= 11)) {
			System.out.println("정답!");
			count += 1;
			score += 10;
			easy += 1;
		}
		else if (!correct) {
			System.out.println("땡!");
		}
		else {
			System.out.println("정답!");
			count += 1;
			score += 15;
			difficult += 1;
			}
		}
		
		System.out.println("게임 끝!");	
		System.out.println("맞힌 문제 수 : " + count + "개");	
		System.out.println(" - 쉬운 문제 : " + easy + "개 맞음");	
		System.out.println(" - 어려운 문제 : " + difficult + "개 맞음");	
		System.out.println("총 점수 : " + score + "점");
		}
	}