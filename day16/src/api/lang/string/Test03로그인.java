package api.lang.string;

import java.util.Scanner;

public class Test03로그인 {
	public static void main(String[] args) {
//		사용자에게 아이디(ID)와 비밀번호(Password)를 입력받아서 로그인 판정을 수행하는 프로그램을 구현
//
//		단, 아이디가 khacademy이고 비밀번호가 adminuser일 경우만 로그인이 성공된다고 가정한다
//
//		로그인 성공 시 화면에 로그인 되었습니다 출력
//		로그인 실패 시 화면에 입력한 정보가 잘못되었습니다 출력
		Scanner sc = new Scanner(System.in);
	
		String ID = "khacademy";
		String PW = "adminuser";
		
		System.out.print("ID입력 : ");
		String userID = sc.next();
		System.out.print("PW입력 : ");
		String userPW = sc.next();
		
		//if(ID.equals(userID) && PW.equals(userPW)) {
		if(ID.equalsIgnoreCase(userID) && PW.equals(userPW)){
			System.out.println("로그인 되었습니다");
		}
		else {
			System.out.println("입력한 정보가 잘못되었습니다");
		}
	}
}
