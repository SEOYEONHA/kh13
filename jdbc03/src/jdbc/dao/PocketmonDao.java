package jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.PocketmonDto;
import jdbc.mapper.PocketmonMapper;
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
	public boolean update(PocketmonDto dto) {
		JdbcTemplate jdbcTemplate = JdbcHelper.getJdbcTemplate();
		String sql = "update pocketmon "
				+ "set pcoketmon_name = ?, pocketmon_type = ? "
				+ "where pocketmon_no = ?";
		Object[] data = {
				dto.getPocketmonName(),
				dto.getPocketmonType(),
				dto.getPocketmonNo()
		};
		return jdbcTemplate.update(sql, data) > 0;
		
//		int result =jdbcTemplate.update(sql, data);
//		if(result > 0) {
//			return true;
//		}
//		else {
//			return false;	
//		} 
		
	}
	
	//삭제 메소드 : delete pocketmon where pocketmon_no = ?
	public boolean delete(int pocketmonNo) {
		JdbcTemplate jdbcTemplate = JdbcHelper.getJdbcTemplate();
		String sql = "delete pocketmon where pocketmon_no = ?";
		Object[] data = {pocketmonNo};
		return jdbcTemplate.update(sql, data) > 0;
	}
	
	//목록 메소드
	public List<PocketmonDto> selectList() {
		JdbcTemplate jdbcTemplate = JdbcHelper.getJdbcTemplate();
		String sql = "select * from pocketmon order by pocketmon_no asc";
		//Object[] data = {};
		PocketmonMapper mapper = new PocketmonMapper();
		return jdbcTemplate.query(sql, mapper);
//		List<PocketmonDto> list = jdbcTemplate.query(sql, mapper);
//		return list;
	}
	
	//항목 - 키워드검색 (결과가 1%라도 여러개 나올 가능성이 있다면 Lsit)
	public List<PocketmonDto> selectList(String column, String keyword){
		JdbcTemplate jdbcTemplate = JdbcHelper.getJdbcTemplate();
		String sql = "select * from pocketmon where instr(" + column + ", ?) > 0";
		Object[] data = {keyword};
		PocketmonMapper mapper = new PocketmonMapper();
		return jdbcTemplate.query(sql, mapper, data);
	}
	
	//상세 메소드
	public PocketmonDto selectOne(int pocketmonNo) {
		JdbcTemplate jdbcTemplate = JdbcHelper.getJdbcTemplate();
		String sql = "select * from pocketmon where pocketmon_no = ?";
		Object[] data = {pocketmonNo};
		PocketmonMapper mapper = new PocketmonMapper();
		List<PocketmonDto> list = jdbcTemplate.query(sql, mapper, data);
//		list에는 데이터가 없거나 1개있거나 둘 중 하나의 상태
		return list.isEmpty() ? null : list.get(0); //조건 ? 참일때 : 거짓일때
//		if(list.isEmpty()) {
//			return null;
//		}
//		else {
//			return list.get(0);
//		}

	}
}



