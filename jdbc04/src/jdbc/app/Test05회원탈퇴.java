package jdbc.app;

import java.util.Scanner;

import jdbc.dao.MemberDao;
import jdbc.dto.MemberDto;

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
		
		//memberId에 해당하는 회원정보를 불러와서 비밀번호 검사를 수행
		MemberDto find = dao.selectOne(memberId);
		//아이디에 대한 회원정보가 있으면서 비밀번호가 일치하는 경우
		boolean isValid = find != null && find.getMemberPw().equals(memberPw);
		if(isValid) {
			dao.delete(memberId);
			System.out.println("회원탈퇴가 완료되었습니다.");
			System.out.println("그동안 이용해주셔서 감사합니다.");
		}
		else {
			System.out.println("입력하신 정보가 일치하지 않습니다");
		}
		
//		boolean result = dao.delete(memberId);
//		
//		if(result) {
//			System.out.println("회원탈퇴가 완료되었습니다.");
//			System.out.println("그동안 이용해주셔서 감사합니다.");
//		}
//		else {
//			System.out.println("아이디 또는 비밀번호를 확인하세요.");
//		}
	}
}
