package jdbc.app;

import java.text.DecimalFormat;
import java.util.Scanner;

import jdbc.dao.MenuDao;
import jdbc.dto.MenuDto;

public class Test14메뉴상세 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("검색할 메뉴 번호를 입력하세요 : ");
		int menuNo = sc.nextInt();
		sc.close();
		
		MenuDao dao = new MenuDao();
		MenuDto dto = dao.selectOne(menuNo);
		
		if(dto != null) {
			DecimalFormat fmt = new DecimalFormat("#,##0");
			
			System.out.println("<" + menuNo + "번 메뉴 정보>");
			System.out.println("메뉴 명 : " + dto.getMenuNameKor() + "(" + dto.getMenuNameEng() + ")");
			System.out.println("종류 : " + dto.getMenuType());
			System.out.println("가격 : " + fmt.format(dto.getMenuPrice()));
		}
		else {
			System.out.println("존재하지않는 메뉴번호입니다.");
		}
	}
}
