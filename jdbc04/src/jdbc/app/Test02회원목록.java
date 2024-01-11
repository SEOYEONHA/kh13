package jdbc.app;

import java.util.List;

import jdbc.dao.MemberDao;
import jdbc.dto.MemberDto;

public class Test02회원목록 {
	public static void main(String[] args) {
		
		MemberDao dao = new MemberDao();
		List<MemberDto> list = dao.selectList();
		
		if(list.isEmpty()) {
			System.out.println("등록된 회원이 없습니다.");
		}
		else {
			System.out.println("조회결과 : 총 " + list.size() + "건");
			for(MemberDto dto:list) {
				System.out.println("아이디 : " + dto.getMemberId() + " / 닉네임 : " + dto.getMemberNick());
			}
		}
	}
}
