package jdbc.select2;

import java.util.List;
import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.select.EmpDto;
import jdbc.select.EmpMapper;
import jdbc.util.JdbcHelper;

public class Test02사원검색2 {
//	사원의 이름을 입력받아 like 검색과 instr 검색을 별도의 파일로 각각 구현하세요
//
//	(추가) 이름 또는 부서가 검색될 수 있도록 처리해보세요
	public static void main(String[] args) {
		//데이터 준비
		Scanner sc = new Scanner(System.in);
		System.out.print("사원 검색 : ");
		String keyword = sc.nextLine();
		sc.close();
		
		//처리
		JdbcTemplate jdbcTemplate = JdbcHelper.getJdbcTemplate();
		String sql = "select * from emp "
						+ "where instr(emp_name, ?) > 0 or instr(emp_dept, ?) > 0";
		Object[] data = {keyword, keyword};
		
		EmpMapper mapper = new EmpMapper();
		
		List<EmpDto> list = jdbcTemplate.query(sql, mapper, data);
		
		System.out.println("조회 결과 : " + list.size() + "건");
		for(EmpDto dto : list) {
			System.out.println("<사원 정보>");
			System.out.println("사원 이름 : " + dto.getEmpName());
			System.out.println("부서명 : " + dto.getEmpDept());
			System.out.println("입사 일자 : " + dto.getEmpDate());
			System.out.println("사원 급여 : " + dto.getEmpSal());
			System.out.println();
		}
	}
}
