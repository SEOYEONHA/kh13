package jdbc.app;

import java.util.List;

import jdbc.dao.PocketmonDao;
import jdbc.dto.PocketmonDto;

public class Test15포켓몬검색 {
	public static void main(String[] args) {
		
		String column = "pocketmon_name";
		String keyword = "피카";
		
		PocketmonDao dao = new PocketmonDao();
		List<PocketmonDto> list = dao.selectList(column, keyword);
		
		//이후부터는 목록과 동일한 코드로 출력 가능
		if(list.isEmpty()) {
			System.out.println("표시할 데이터가 없습니다.");
		}
		else {
			System.out.println("<" + keyword + "> 검색결과 총 " + list.size() + "건");
			for(PocketmonDto dto:list) {
				System.out.println("이름 : " + dto.getPocketmonName() + ", 속성 : " + dto.getPocketmonType());
			}
		}
		
	}
}
