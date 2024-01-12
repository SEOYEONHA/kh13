package jdbc.app;

import java.util.Scanner;

import jdbc.dao.MemberDao;
import jdbc.dto.MemberDto;

public class Test04비밀번호변경2 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		MemberDto dto = new MemberDto();
		
		System.out.print("아이디 입력 : ");
		dto.setMemberId(sc.nextLine());
		System.out.print("변경 전 비밀번호 입력 : ");
		dto.setMemberPw(sc.nextLine());
		System.out.print("변경할 비밀번호 입력 : ");
		String changePw = sc.nextLine();
		
		sc.close();
		
		//데이터 처리
		MemberDao dao = new MemberDao();
		MemberDto find = dao.selectOne(dto.getMemberId());
		if(find != null && find.getMemberPw().equals(changePw)) {
			dao.updateMemberPw(dto);
			System.out.println("비밀번호 변경 완료");
		}
		else {
			System.out.println("정보가 일치하지 않습니다.");
		}
		
//		boolean result = dao.update(dto, memberPw);
//		
//		//출력
//		if(result) {
//			System.out.println("비밀번호 변경이 완료되었습니다.");
//		}
//		else {
//			System.out.println("아이디 또는 비밀번호를 확인하세요.");
//		}
	}
}
