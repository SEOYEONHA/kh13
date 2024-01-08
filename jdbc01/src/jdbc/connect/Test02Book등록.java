package jdbc.connect;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Test02Book등록 {
	public static void main(String[] args) {
//		book  테이블에 다음과 같은 정보의 데이터를 등록할 수 있도록 구현하세요.
//
//		book_id - 50
//		book_title - 자바신공
//		book_author - 열혈강사
//		book_publication_date - 2023-10-01
//		book_price - 5$
//		book_publisher - wikidocs
//		book_page_count - 199
//		book_genre - Education
		
		//[1] 연결 생성
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUsername("kh13"); 
		dataSource.setPassword("kh13"); 
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe"); 
		
		//[2] 명령 생성
		String sql = "insert into book("
					+ "book_id, book_title, book_author, book_publication_date, book_price, "
					+ "book_publisher, book_page_count, book_genre"
					+ ") "
					+ "values(50, '자바신공', '열혈강사', '2023-10-01', 5, 'wikidocs', 199, 'Education')";
		
		//[3] 명령 처리 도구 생성
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		//[4] 실행
		jdbcTemplate.update(sql);
		System.out.println("완료!");
				
	}
}
