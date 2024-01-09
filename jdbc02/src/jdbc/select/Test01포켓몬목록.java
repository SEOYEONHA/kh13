package jdbc.select;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.util.JdbcHelper;

public class Test01포켓몬목록 {
	public static void main(String[] args) {
		
		//포켓몬스터 조회(select)
		//- SELECT 구문을 실행시켜서 나온 ResultSet을 객체로 변환하여 조회
		//- DB테이블에 5줄이 있으면 자바는 객체 5개로 조회해야 한다
		//- insert, update, delete와는 다르게 추가 클래스를 생성해야 한다
		//- PocketmonDto라는 클래스를 만들어서 하나의 몬스터 정보를 정의(번호, 이름, 타입)
		//- PocketmonMapper라는 클래스르 만들어서 List를 생성하기 위한 처리를 구현
		//- 결론 : 이 작업으로 만들어지는 데이터가 List<PocketmonDto>
		
		//준비할 데이터
		
		String sql = "select * from pocketmon";
		//Object[] data = {};
		
		JdbcTemplate jdbcTemplate = JdbcHelper.getJdbcTemplate();
		PocketmonMapper mapper = new PocketmonMapper();
		
		//조회는 명령이 다르다 - .query()
		List<PocketmonDto> list = jdbcTemplate.query(sql, mapper);
		
		System.out.println("조회 결과 수 : " + list.size());
	}
}
