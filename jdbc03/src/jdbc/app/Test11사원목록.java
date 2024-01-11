package jdbc.app;

import java.util.List;

import jdbc.dao.EmpDao;
import jdbc.dto.EmpDto;

public class Test11사원목록 {
	public static void main(String[] args) {
		
		EmpDao dao = new EmpDao();
		List<EmpDto> list = dao.selectList();
		
		System.out.println("조회 결과 : 총 " + list.size() + "건");
		for(EmpDto dto:list) {			
			System.out.println("사원 이름 : " + dto.getEmpName() + " / 부서명 : " + dto.getEmpDept());
		}
	}
}