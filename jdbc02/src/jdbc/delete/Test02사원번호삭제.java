package jdbc.delete;

import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.util.JdbcHelper;

public class Test02사원번호삭제 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			
			//입력
			System.out.print("삭제할 사원 번호 : ");
			int empNo = sc.nextInt();
			
			
			sc.close();
			
			JdbcTemplate jdbcTemplate = JdbcHelper.getJdbcTemplate();
			
			String sql = "delete emp "
						+ "where emp_no = ?";
			Object[] data = {empNo};
			
			//update 메소드는 반환형이 int 이며 적용된 행의 개수가 반환된다.
			int count = jdbcTemplate.update(sql, data);
			
			//출력
			if (count > 0) {
				System.out.println("사원 정보 삭제 완료");
			}
			else {
				System.out.println("존재하지 않는 사원번호");
			}
		}
}
