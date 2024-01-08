package jdbc.connect;

import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Test04Emp등록 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		//입력
		
		System.out.print("사원 이름 : ");
		String empName = sc.nextLine();
		System.out.print("사원 소속 부서 : ");
		String empDept = sc.nextLine();
		System.out.print("사원 입사 일자(YYYY-MM-DD) : ");
		String empDate = sc.nextLine();
		System.out.print("사원 급여 : ");
		int empSal = sc.nextInt();
		sc.close();
		
		//처리 - JDBC
		String sql = "insert into emp("
				+ "emp_no, emp_name, emp_dept, emp_date, emp_sal"
				+ ") "
				+ "values(emp_seq.nextval, ?, ?, ?, ?)";
		Object[] data = {empName, empDept, empDate, empSal};
		
		//연결 정보 생성
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setUsername("kh13"); 
			dataSource.setPassword("kh13"); 
			dataSource.setDriverClassName("oracle.jdbc.OracleDriver");	
			dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe"); 
				
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			
			jdbcTemplate.update(sql, data);
			
			//출력
			System.out.println("사원 등록 완료");
				
		
	}
}
