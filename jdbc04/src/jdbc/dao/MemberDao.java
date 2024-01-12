package jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.MemberDto;
import jdbc.mapper.MemberMapper;
import jdbc.util.JdbcHelper;

public class MemberDao {
	//메소드에서 공용으로 사용하는 도구들을 생성
	private JdbcTemplate jdbcTemplate = JdbcHelper.getJdbcTemplate();
	private MemberMapper mapper = new MemberMapper();
	
	//등록
	public void insert(MemberDto dto) {
		//JdbcTemplate jdbcTemplate = JdbcHelper.getJdbcTemplate();
		String sql = "insert into member("
						+ "member_id, member_pw, member_nick, member_birth, member_contact, "
						+ "member_email, member_post, member_address1, member_address2) "
						+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] data = {
				dto.getMemberId(),
				dto.getMemberPw(),
				dto.getMemberNick(),
				dto.getMemberBirth(),
				dto.getMemberContact(),
				dto.getMemberEmail(),
				dto.getMemberPost(),
				dto.getMemberAddress1(),
				dto.getMemberAddress2()
		};
		jdbcTemplate.update(sql, data);
	}
	
	//수정
	public boolean update(MemberDto dto, String memberPw) {
		//JdbcTemplate jdbcTemplate = JdbcHelper.getJdbcTemplate();
		String sql = "update member "
						+ "set member_pw = ? "
						+ "where member_id = ? and member_pw = ?";
		Object[] data = {
				memberPw,
				dto.getMemberId(),
				dto.getMemberPw()
		};
		return jdbcTemplate.update(sql, data) > 0;
	}
	
	//삭제
	public boolean delete(String memberId, String memberPw) {
		//JdbcTemplate jdbcTemplate = JdbcHelper.getJdbcTemplate();
		String sql = "delete member where member_id = ? and member_pw = ?";
		Object[] data = {memberId, memberPw};
		return jdbcTemplate.update(sql, data) > 0;
	}
	
	//목록
	public List<MemberDto> selectList(){
		//JdbcTemplate jdbcTemplate = JdbcHelper.getJdbcTemplate();
		String sql = "select * from member order by member_id asc";
//		Object[] data = {};
		//MemberMapper mapper = new MemberMapper();
		return jdbcTemplate.query(sql, mapper);
	}
	
	//상세
	public MemberDto selectOne(String memberId) {
		//JdbcTemplate jdbcTemplate = JdbcHelper.getJdbcTemplate();
		String sql = "select * from member where member_id = ?";
		//MemberMapper mapper = new MemberMapper();
		Object[] data = {memberId};
		List<MemberDto> list = jdbcTemplate.query(sql, mapper, data);
		
		return list.isEmpty() ? null : list.get(0);
	}
	
}
