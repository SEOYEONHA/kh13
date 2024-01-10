package jdbc.app;

import java.util.Scanner;

import jdbc.dao.EmpDao;
import jdbc.dto.EmpDto;

public class Test02사원등록 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		EmpDto dto = new EmpDto();
		System.out.print("사원 이름 : ");
		dto.setEmpName(sc.nextLine());
		System.out.print("부서 명 : ");
		dto.setEmpDept(sc.nextLine());
		System.out.print("입사 일자(YYYY-MM-DD) : ");
		dto.setEmpDate(sc.nextLine());
		System.out.print("급여(원) : ");
		dto.setEmpSal(sc.nextInt());
		
		//처리
		EmpDao dao = new EmpDao();
		dao.insert(dto);
		
		//출력
		System.out.println("사원 등록 완료");
	}
}
