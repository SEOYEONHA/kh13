package jdbc.app;

import java.util.List;

import jdbc.dao.MemberDao;
import jdbc.dto.MemberDto;

public class Test06회원검색 {
	public static void main(String[] args) {
		
		//항목 + 키워드 검색
		String column = "member_id";
		String keyword = "test";
		
		MemberDao dao = new MemberDao();
		List<MemberDto> list = dao.selectList(column, keyword);
		
		System.out.println("검색 결과 : 총 " + list.size() + "건");
		for(MemberDto dto:list) {
			System.out.println(dto.getMemberId() + " (" + dto.getMemberNick() + ")");
		}
	}
}
