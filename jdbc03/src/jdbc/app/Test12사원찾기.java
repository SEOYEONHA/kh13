package jdbc.app;

import java.util.Scanner;

import jdbc.dao.EmpDao;
import jdbc.dto.EmpDto;

public class Test12사원찾기 {
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		System.out.print("검색할 사원 번호를 입력하세요 : ");
		int empNo = sc.nextInt(); 
		sc.close();
		
		EmpDao dao = new EmpDao();
		EmpDto dto = dao.selectOne(empNo);
		
		if(dto != null) {
			System.out.println("<사원 정보>");
			System.out.println("사원 이름 : " + dto.getEmpName());
			System.out.println("부서명 : " + dto.getEmpDept());
			System.out.println("입사 일자 : " + dto.getEmpDate());
			System.out.println("사원 급여 : " + dto.getEmpSal());
		}
		else {
			System.out.println("존재하지 않는 사번입니다.");
		}
	}
}