package jdbc.update;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.util.JdbcHelper;

public class Test01포켓몬수정 {
	public static void main(String[] args) {
		//목표 : 1개의 포켓몬스터 정보 중 이름과 유형을 변경하도록 구현
		
		//데이터 준비
		int pocketmonNo = 1;
		String pocketmonName = "테스트";
		String pocketmonType = "테스트";
		
		//도구를 한번에 생성
		JdbcTemplate jdbcTemplate = JdbcHelper.getJdbcTemplate();
		
		String sql = "update pocketmon "
						+ "set pocketmon_name = ?, pocketmon_type = ? "
						+ "where pocketmon_no = ?";
		Object[] data = {pocketmonName, pocketmonType, pocketmonNo};
		
		jdbcTemplate.update(sql, data);
		
		//출력
		System.out.println("정보 변경 완료");
	}
}
