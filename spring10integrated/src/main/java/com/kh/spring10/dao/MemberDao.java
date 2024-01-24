package com.kh.spring10.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring10.dto.MemberDto;
import com.kh.spring10.mapper.MemberMapper;

@Repository
public class MemberDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private MemberMapper mapper;
	
	
	//회원가입
	public void insert(MemberDto dto) {
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
	
	//목록(조회, Read)
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
