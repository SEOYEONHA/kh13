package jdbc.app;

import java.util.List;

import jdbc.dao.MemberDao;
import jdbc.dto.MemberDto;

public class Test06회원검색2 {
	public static void main(String[] args) {
		
		//목록과 검색을 통합
		//- 언제 목록이고 언제 검색으로 볼 것인가?
		String column = "member_id";
		String keyword = "test";
		
		//boolean isSearch = column != null & keyword != null //colunm도 있고 keyword도 있으면
		boolean isSearch = column != null && !column.equals("")
											&& keyword != null && !keyword.equals("");
		
		MemberDao dao = new MemberDao();
		List<MemberDto> list;
		if(isSearch) { //검색이면
			list = dao.selectList(column, keyword);
		}
		else {
			list = dao.selectList();
		}
		
		System.out.println("검색 결과 : 총 " + list.size() + "건");
		for(MemberDto dto:list) {
			System.out.println(dto.getMemberId() + " (" + dto.getMemberNick() + ")");
		}
	}
}
