package jdbc.app;

import jdbc.dao.EmpDao;
import jdbc.dto.EmpDto;

public class Test05사원정보변경 {
	public static void main(String[] args) {
		
		//데이터 준비
		EmpDto dto = new EmpDto();
		dto.setEmpNo(1);
		dto.setEmpName("김대리");
		dto.setEmpDept("개발부");
		dto.setEmpDate("2023-01-01");
		dto.setEmpSal(3000000);
		
		//데이터 처리
		EmpDao dao = new EmpDao();
		boolean result = dao.update(dto);
		
		//출력
		if(result) {
			System.out.println("정보변경이 완료되었습니다.");
		}
		else {
			System.out.println("존재하지않는 사원번호입니다.");
		}
	}
}
