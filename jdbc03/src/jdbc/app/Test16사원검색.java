package jdbc.app;

import java.util.List;
import java.util.Scanner;

import jdbc.dao.EmpDao;
import jdbc.dto.EmpDto;

public class Test16사원검색 {
	public static void main(String[] args) {
//		1.사원명, 2.부서명 : (1)
//		검색어 : (홍길)
//
//		검색 결과 : 2건
//		- 홍길동 (인사팀)
//		- 홍길남 (재무팀)
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("1. 사원명, 2. 부서명 (숫자 입력) : ");
		int choice = sc.nextInt();
		sc.nextLine();
		
		String column;
//		if(choice == 1) {
//			column = "emp_name";
//		}
//		else {
//			column = "emp_dept";
//		}
		if(choice == 1)
			column = "emp_name";
		else
			column = "emp_dept";
		
//		String column = switch(choice) {//Java 16+
//		case 1 -> "emp_name";
//		default -> "emp_dept";
//		};
//		else {
//			System.out.println("1 또는 2만 입력해주세요");
//		}
		
		System.out.print("검색할 키워드를 입력하세요 : ");
		String keyword = sc.nextLine();
		
		sc.close();
		EmpDao dao = new EmpDao();
		List<EmpDto> list = dao.selectList(column, keyword);
		
		if(list.isEmpty()) {
			System.out.println(keyword + "에 대한 검색결과가 없습니다.");
		}
		else {
			System.out.println("<" + keyword +"> 에 대한 검색결과 총 " + list.size() + "건");
			for(EmpDto dto:list) {
				System.out.println("- " + dto.getEmpName() + " (" + dto.getEmpDept() + ")");
			}
		}
	}
}
