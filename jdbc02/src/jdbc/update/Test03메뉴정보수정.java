package jdbc.update;

import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.util.JdbcHelper;

public class Test03메뉴정보수정 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
				
		System.out.print("변경할 메뉴 번호 : ");
		int menuNo = sc.nextInt();
		sc.nextLine();
		System.out.print("메뉴 한글 이름 : ");
		String menuNameKor = sc.nextLine();
		System.out.print("메뉴 영문 이름 : ");
		String menuNameEng = sc.nextLine();
		System.out.print("메뉴 종류 : ");
		String menuType = sc.nextLine();
		System.out.print("메뉴 판매가(원) : ");
		int menuPrice = sc.nextInt();
		
		sc.close();
		
		JdbcTemplate jdbcTemplate = JdbcHelper.getJdbcTemplate();
		
		String sql = "update menu "
				+ "set menu_name_kor = ?, menu_name_eng = ?, menu_type = ?, "
				+ "menu_price = ? "
				+ "where menu_no = ?";
		Object[] data = {menuNameKor, menuNameEng, menuType, menuPrice, menuNo};
		
		int result = jdbcTemplate.update(sql, data);
		
		//출력
		if (result > 0) {
			System.out.println("메뉴 정보 변경 완료");
		}
		else {
			System.out.println("존재하지 않는 메뉴번호");
				
		}
	}
}
