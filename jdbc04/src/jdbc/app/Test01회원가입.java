package jdbc.app;

import java.util.Scanner;

import jdbc.dao.MemberDao;
import jdbc.dto.MemberDto;

public class Test01회원가입 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		MemberDto dto = new MemberDto();
		
		System.out.print("아이디를 입력하세요(필수항목) : ");
		dto.setMemberId(sc.nextLine());
		System.out.print("비밀번호를 입력하세요(필수항목) : ");
		dto.setMemberPw(sc.nextLine());
		System.out.print("닉네임을 입력하세요(필수항목) : ");
		dto.setMemberNick(sc.nextLine());
		System.out.print("생년월일을 입력하세요(선택항목, YYYY-MM-DD) : ");
		dto.setMemberBirth(sc.nextLine());
		System.out.print("전화번호를 입력하세요(선택항목, - 제외) : ");
		dto.setMemberContact(sc.nextLine());
		System.out.print("이메일을 입력하세요(필수항목) : ");
		dto.setMemberEmail(sc.nextLine());
		System.out.print("우편번호 5~6자리를 입력하세요(선택항목) : ");
		dto.setMemberPost(sc.nextLine());
		System.out.print("주소를 입력하세요(선택항목) : ");
		dto.setMemberAdderess1(sc.nextLine());
		System.out.print("상세주소를 입력하세요(선택항목) : ");
		dto.setMemberAdderess2(sc.nextLine());
		dto.setMemberLevel(null);
		dto.setMemberPoint(0);
		dto.setMemberJoin(null);
		dto.setMemberLogin(null);
		
		sc.close();
		
		//처리
		MemberDao dao = new MemberDao();
		dao.insert(dto);
		
		//출력
		System.out.println("회원가입이 완료되었습니다");
	}
}
