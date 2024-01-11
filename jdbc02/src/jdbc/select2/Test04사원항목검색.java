package jdbc.select2;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.select.EmpDto;
import jdbc.select.EmpMapper;
import jdbc.util.JdbcHelper;

public class Test04사원항목검색 {
	public static void main(String[] args) {
		
		int choice = 1;
		String keyword = "피카";
		
		String column;
		if(choice == 1) {
			column = "emp_name";
		}
		else if(choice == 2) {
			column = "emp_dept";
		}
		else {
			column = "emp_date";
		}
		
		//처리
		JdbcTemplate jdbcTemplate = JdbcHelper.getJdbcTemplate();
//		String sql = "select * from emp where "+column+" like ? || '%'"
		String sql = "select * from emp where instr("+column+", ?) > 0"
										+ "order by "+column+" asc, emp_no asc";
		EmpMapper mapper = new EmpMapper();
		Object[] data = {keyword};
		
		List<EmpDto> list = jdbcTemplate.query(sql, mapper, data);
		System.out.println(column+" 항목에 대해 ["+keyword+"] 키워드로 검색한 결과");
		if(list.isEmpty()) {
			System.out.println("표시할 결과가 없습니다");
		}
		else {
			System.out.println("검색 결과 수 : " + list.size()+"건");
			for(EmpDto dto : list) {
				System.out.print("이름 : " + dto.getEmpName());
				System.out.print(", 부서 : " + dto.getEmpDept());
				System.out.println(", 입사일 : " + dto.getEmpDate());
			}
		}
	}
}
