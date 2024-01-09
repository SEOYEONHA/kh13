package jdbc.select;

import java.util.List;
import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.util.JdbcHelper;

public class Test03메뉴조회 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("검색 할 메뉴 명 입력 : ");
		String keyword = sc.nextLine();
		
		String sql = "select * from menu where menu_name_kor = ? order by menu_no asc";
		Object[] data = {keyword};
		
		JdbcTemplate jdbcTemplate = JdbcHelper.getJdbcTemplate();
		MenuMapper mapper = new MenuMapper();
		
		//List<MenuDto> list = jdbcTemplate.query(sql, mapper);
		List<MenuDto> list = jdbcTemplate.query(sql, mapper, data);
		
		//System.out.println("조회 결과 수: " + list.size());
		
		
		
		
		for(MenuDto dto : list) { 
			//System.out.println(dto.toString());
			System.out.println(dto.getMenuNameKor() + "(" + dto.getMenuNameEng() + ") : "+ dto.getMenuPrice());
		}
	}
}
