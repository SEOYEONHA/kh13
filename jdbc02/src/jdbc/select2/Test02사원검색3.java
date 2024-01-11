package jdbc.select2;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.select.EmpDto;
import jdbc.select.EmpMapper;
import jdbc.util.JdbcHelper;

public class Test02사원검색3 {
	public static void main(String[] args) {
		//사원검색을 like 연산자와 instr 함수로 각각 구현
		//- 시작검색은 like연산자, 포함검색은 instr함수
		
		//검색어
		String keyword = "피카";
		
		//처리
		JdbcTemplate jdbcTemplate = JdbcHelper.getJdbcTemplate();
		String sql = "select * from emp "
								+ "where instr(emp_name, ?) > 0 "
									+ "or instr(emp_dept, ?) > 0 "
								+ "order by emp_name asc, emp_no asc";
		Object[] data = {keyword, keyword};//홀더에 배치될 데이터
		EmpMapper mapper = new EmpMapper();//조회 결과 처리 방법 객체
		
		List<EmpDto> list = jdbcTemplate.query(sql, mapper, data);
		
//		if(list.size() == 0) {
		if(list.isEmpty()) {
			System.out.println("검색결과가 존재하지 않습니다");
		}
		else {
			System.out.println("검색 결과 총 "+ list.size()+"개");
//			for(EmpDto dto : list) {
//				System.out.println(dto.getEmpName()+"("+dto.getEmpDept()+")");
//			}
			for(int i=0; i < list.size(); i++) {
				EmpDto dto = list.get(i);
				System.out.println(dto.getEmpName()+"("+dto.getEmpDept()+")");
			}
		}
		
	}
}
