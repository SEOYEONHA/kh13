package jdbc.delete;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.util.JdbcHelper;

public class Test01포켓몬삭제 {
	public static void main(String[] args) {
		
		//포켓몬스터를 삭제하려면 "번호"만 알면 된다(번호가 기본키PK니까)
		
		//데이터 준비
		int pocketmonNo = 1;
		
		//처리
		JdbcTemplate jdbcTemplate = JdbcHelper.getJdbcTemplate();
		
		String sql = "delete pocketmon where pocketmon_no=?";
		Object[] data = {pocketmonNo};
		
		int result = jdbcTemplate.update(sql, data);
		
		//출력
		if(result > 0) {
			System.out.println("포켓몬스터 삭제 완료");
		}
		else {
			System.out.println("존재하지 않는 포켓몬스터 번호");
		}
	} 
}


