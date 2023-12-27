package api.lang.string;

import java.util.Random;
import java.util.Scanner;

public class Test06쿵쿵따게임만들기2 {
	public static void main(String[] args) {
			//(Q) 업그레이드(제시어랜덤, 라운드추가)
			Scanner sc = new Scanner(System.in);

			String[] words = new String[] {
				"바나나", "물고기", "초콜릿", "이발소", "컴퓨터"
			};
			Random r = new Random();

			//String given = "바나나";
			int position = r.nextInt(words.length);
			String given = words[position];
			int round = 1;//1라운드부터 시작
			while(true) {
				System.out.print(given+"! 쿵쿵따! ");
				String input = sc.next();
				char last = given.charAt(given.length()-1);
				char first = input.charAt(0);

				//판정계산
				boolean isLengthOk = input.length() == 3;
				boolean isConnect = first == last;
				boolean isOk = isLengthOk && isConnect;
				if(isOk) {
					//제시어를 입력값으로 변경
					given = input;
					round++;//맞추면 라운드 증가
				}
				else {//입력이 잘못되었다면
					break;
				}
			}

			//게임오버처리
			System.out.println("게임 끝!");
			System.out.println("총 "+round+"라운드까지 진행");

		}
	}
