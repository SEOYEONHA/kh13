package jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.PocketmonDto;
import jdbc.util.JdbcHelper;

//DAO(Data Access Object)
//- 해당 테이블에 대한 CRUD 코드를 가진 클래스
public class PocketmonDao {

	//등록 메소드
	//public void insert(int pockemonNo, String pocketmonName, String pockemonType) { //권장하지 않음
	public void insert(PocketmonDto dto) {
		JdbcTemplate jdbcTemplate = JdbcHelper.getJdbcTemplate();
		String sql = "insert into pocketmon("
							+ "pocketmon_no, pocketmon_name, pocketmon_type) "
							+ "values(?, ?, ?)";
		Object[] data = {
				dto.getPocketmonNo(),
				dto.getPocketmonName(),
				dto.getPocketmonType()
		};
		jdbcTemplate.update(sql, data);
	}
	//수정 메소드
	
	//삭제 메소드
	//목록 메소드
	//검색 메소드
	
	
}
