package jdbc.app;

import java.util.Scanner;

import jdbc.dao.MemberDao;
import jdbc.dto.MemberDto;

public class Test03회원찾기 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("조회할 아이디를 입력하세요");
		String memberId = sc.nextLine();
		sc.close();
		
		MemberDao dao = new MemberDao();
		MemberDto dto = dao.selectOne(memberId);
		
		if(dto != null) {
			System.out.println("<아이디 " +memberId + " 회원정보>");
			System.out.println("비밀번호 : " + dto.getMemberPw());
			System.out.println("닉네임 : " + dto.getMemberNick());
			System.out.println("생년월일 : " + dto.getMemberBirth());
			System.out.println("전화번호 : " + dto.getMemberContact());
			System.out.println("이메일 주소 : " + dto.getMemberEmail());
			System.out.println("우편번호 : " + dto.getMemberPost());
			System.out.println("주소 : " + dto.getMemberAdderess1() + " / " + dto.getMemberAdderess2());
			System.out.println("회원 등급 : " + dto.getMemberLevel());
			System.out.println("보유 포인트 : " + dto.getMemberPoint());
			System.out.println("회원가입 시각 : " + dto.getMemberJoin());
			System.out.println("마지막 로그인 시각 : " + dto.getMemberLogin());
		}
	}
}
