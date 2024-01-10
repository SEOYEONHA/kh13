package jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.MenuDto;
import jdbc.util.JdbcHelper;

//menu 테이블에 대한 DB처리(CRUD)를 담당하는 클래스
public class MenuDao {
	
	//등록
	public void insert(MenuDto dto) {
		JdbcTemplate jdbcTemplate = JdbcHelper.getJdbcTemplate();
		String sql = "insert into menu("
							+ "menu_no, menu_name_kor, menu_name_eng, menu_type, menu_price) "
							+ "values(menu_seq.nextval, ?, ?, ?, ?)";
		Object[] data = {
				dto.getMenuNameKor(),
				dto.getMenuNameEng(),
				dto.getMenuType(),
				dto.getMenuPrice()
		};
		jdbcTemplate.update(sql, data);
	}
}
