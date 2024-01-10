package jdbc.app;

import jdbc.dao.MenuDao;

public class Test09메뉴삭제 {
	public static void main(String[] args) {	
		
		int menuNo = 11;
		
		//처리
		MenuDao dao = new MenuDao();
		boolean result = dao.delete(menuNo);
		
		if(result) {
			System.out.println("메뉴정보가 삭제되었습니다");
		}
		else {
			System.out.println("존재하지않는 메뉴 번호입니다");
		}

	}
}
