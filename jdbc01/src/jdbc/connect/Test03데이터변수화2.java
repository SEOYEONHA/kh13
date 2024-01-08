package jdbc.connect;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Test03데이터변수화2 {
	public static void main(String[] args) {
		//목표 : 변수에 저장된 정보를 구문과 합쳐서 실행
		
		//입력
		int pocketmonNo = 99;
		String pocketmonName = "테스트몬";
		//String pocketmonName = "테스트'몬"; //구문에 영향을 주는 글자 '
		//String pocketmonName = "'||(select pocketmon_name from pocketmon where pocketmon_no=1)||'";//SQL Injection 공격
		String pocketmonType = "테스트";
		
		//처리
		//- 동적 SQL 방식에서는 위치홀더(?)를 사용한다
		//- 위치홀더를 준비하고 그에 맞는 데이터를 배치하면 자동으로 구문 완정
		//- 단, 완성된 구문은 볼 수 없음(상상만 해야함)
		
		String sql = "insert into pocketmon("
				+ "pocketmon_no, pocketmon_name, pocketmon_type"
				+ ") "
				+ "values(?, ?, ?)";
		//Object[] data = new Object[] {pocketmonNo, pocketmonName, pocketmonType};
		Object[] data = {pocketmonNo, pocketmonName, pocketmonType}; //약식 
		
		//연결 정보 생성
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUsername("kh13"); 
		dataSource.setPassword("kh13"); 
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe"); 
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		//실행 시 홀더가 있는 구문과 그 데이터를 같이 주면서 실행 요청한다
		jdbcTemplate.update(sql, data);
		System.out.println("실행 완료");

	}
}
