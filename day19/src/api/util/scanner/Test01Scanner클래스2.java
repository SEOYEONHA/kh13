package api.util.scanner;

import java.util.Scanner;

public class Test01Scanner클래스2 {
	public static void main(String[] args) {
		//Scanner 클래스
		String song = "노는게 제일좋아 친구들 모여라\n언제나 즐거워\n뽀롱뽀롱뽀롱뽀롱뽀로로";
		//System.out.println(song);
		
		//.nextLine() 는 "한 줄"를 읽는 명령 (엔터 \n 전까지)
		Scanner sc = new Scanner(song);
		while(sc.hasNextLine()) {
			//if (sc.hasNext() == false) break;
			System.out.println(sc.nextLine());
		}	
		sc.close();//통로형 객체를 정리하는 메소드
	}
}