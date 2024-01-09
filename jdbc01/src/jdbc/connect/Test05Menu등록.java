package jdbc.connect;

import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Test05Menu등록 {
	public static void main(String[] args) {
		
		// 입력 
		Scanner sc = new Scanner(System.in);
		
		System.out.print("메뉴 한글 이름 : ");
		String menuNameKor = sc.nextLine();
		System.out.print("메뉴 영문 이름 : ");
		String menuNameEng = sc.nextLine();
		System.out.print("메뉴 종류 : ");
		String menuType = sc.nextLine();
		System.out.print("메뉴 판매가(원) : ");
		int menuPrice = sc.nextInt();
		sc.close();
		
		String sql = "insert into menu("
				+ "menu_no, menu_name_kor, menu_name_eng, menu_type, menu_price"
				+ ") "
				+ "values(menu_seq.nextval, ?, ?, ?, ?)";
		Object[] data = {menuNameKor, menuNameEng, menuType, menuPrice};
		
		//연결 정보 생성
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUsername("kh13"); 
		dataSource.setPassword("kh13");
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		//실행
		jdbcTemplate.update(sql, data);
		
		System.out.println("메뉴 등록 완료");
		
	}
}
