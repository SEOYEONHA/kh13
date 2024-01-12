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
		
		//상세조회로 아이디 중복검사
		MemberDao dao = new MemberDao();
		MemberDto find = dao.selectOne(dto.getMemberId());
		if(find != null) {
			System.out.println("이미 사용중인 아이디입니다.");
			System.exit(0);
		}
		
		System.out.print("비밀번호를 입력하세요(필수항목) : ");
		dto.setMemberPw(sc.nextLine());
		
		//비밀번호 확인하기
		System.out.println("비밀번호 확인");
		String memberPwCheck = sc.nextLine();
		if(!dto.getMemberPw().equals(memberPwCheck)) { //비밀번호가 일치하지않으면
			System.out.println("입력하신 비밀번호와 동일하게 입력해주세요.");
			System.exit(0);
		}
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
		dto.setMemberAddress1(sc.nextLine());
		System.out.print("상세주소를 입력하세요(선택항목) : ");
		dto.setMemberAddress2(sc.nextLine());
		dto.setMemberLevel(null);
		dto.setMemberPoint(0);
		dto.setMemberJoin(null);
		dto.setMemberLogin(null);
		
		sc.close();
		
		//처리
		//MemberDao dao = new MemberDao();
		dao.insert(dto);
		
		//출력
		System.out.println("회원가입이 완료되었습니다");
	}
}
