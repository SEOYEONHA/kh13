package jdbc.select;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.util.JdbcHelper;

public class Test02사원목록조회 {

	public static void main(String[] args) {
		
		String sql = "select * from emp order by emp_no asc";
		//Object[] data = {}; 
		
		JdbcTemplate jdbcTemplate = JdbcHelper.getJdbcTemplate();
		EmpMapper mapper = new EmpMapper();
		
		List<EmpDto> list = jdbcTemplate.query(sql, mapper);
		
		System.out.println("조회 결과 수 : " + list.size());
		
		for(EmpDto dto : list) { //확장 반복문(list에 있는거 다 꺼내서 dto로 사용하겠다)
			System.out.println(dto.getEmpName() + ", " + dto.getEmpDept());
		}
	}
}
