package jdbc.app;

import java.util.Scanner;

import jdbc.dao.MemberDao;

public class Test05회원탈퇴 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("탈퇴할 아이디를 입력하세요 : ");
		String memberId = sc.nextLine();
		System.out.print("비밀번호를 입력하세요 : ");
		String memberPw = sc.nextLine();
		sc.close();
		
		//처리
		MemberDao dao = new MemberDao();
		boolean result = dao.delete(memberId, memberPw);
		
		if(result) {
			System.out.println("회원탈퇴가 완료되었습니다.");
		}
		else {
			System.out.println("아이디 또는 비밀번호를 확인하세요.");
		}
	}
}
