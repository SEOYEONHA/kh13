package jdbc.app;

import java.util.List;

import jdbc.dao.MenuDao;
import jdbc.dto.MenuDto;

public class Test13메뉴목록 {
	public static void main(String[] args) {
		
		MenuDao dao = new MenuDao();
		List<MenuDto> list = dao.selectList();
		
		if(list.isEmpty()) {
			System.out.println("등록된 메뉴가 없습니다");
		}
		else {
			System.out.println("조회결과 : 총 " + list.size() + "건");
			for(MenuDto dto:list) {
				System.out.println("메뉴 명(한글) : " + dto.getMenuNameKor() + ", 가격 : " + dto.getMenuPrice() + "원");
			}
		}
	}
}
