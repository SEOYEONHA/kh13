package jdbc.app;

import jdbc.dao.MenuDao;
import jdbc.dto.MenuDto;

public class Test06메뉴정보변경 {
	public static void main(String[] args) {
		
		//데이터준비
		MenuDto dto = new MenuDto();
		dto.setMenuNo(1);
		dto.setMenuNameKor("바닐라 라떼");
		dto.setMenuNameEng("Vanilla Latte");
		dto.setMenuType("음료");
		dto.setMenuPrice(5500);
		
		//데이터 처리
		MenuDao dao = new MenuDao();
		boolean result = dao.update(dto);
		
		//출력
		if(result) {
			System.out.println("메뉴변경이 완료되었습니다.");
		}
		else {
			System.out.println("존재하지않는 메뉴번호입니다.");
		}
	}
}
