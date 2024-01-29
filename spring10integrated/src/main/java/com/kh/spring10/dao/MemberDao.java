package com.kh.spring10.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring10.dto.MemberDto;
import com.kh.spring10.mapper.MemberMapper;
import com.kh.spring10.mapper.StatMapper;
import com.kh.spring10.vo.StatVO;

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
	
	//회원 탈퇴
	public boolean delete(String memberId) {
		//JdbcTemplate jdbcTemplate = JdbcHelper.getJdbcTemplate();
		String sql = "delete member where member_id = ?";
		Object[] data = {memberId};
		return jdbcTemplate.update(sql, data) > 0;
	}
	
	//목록(조회, Read)
	public List<MemberDto> selectList(){
		//JdbcTemplate jdbcTemplate = JdbcHelper.getJdbcTemplate();
		String sql = "select * from member order by member_id asc";
//		Object[] data = {};
		//MemberMapper mapper = new MemberMapper();
		return jdbcTemplate.query(sql, mapper);
	}
	
	//검색(조회, Read)
	public List<MemberDto> selectList(String column, String keyword){
		String sql = "select * from member where instr(" + column + ", ?) >0 "
									+ "order by " + column + " asc, member_id asc";
		Object[] data = {keyword};
		return jdbcTemplate.query(sql, mapper, data);
	}
	
	//비밀번호 변경(수정, Update)
	public boolean updateMemberPw(MemberDto dto) {
		//JdbcTemplate jdbcTemplate = JdbcHelper.getJdbcTemplate();
		String sql = "update member "
						+ "set member_pw = ? "
						+ "where member_id = ?";
		Object[] data = {
				dto.getMemberPw(),
				dto.getMemberId()
		};
		return jdbcTemplate.update(sql, data) > 0;
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
	
	//최종 로그인시각 변경(수정, Update)
	public boolean updateMemberLogin(String memberId) {
		String sql = "update member set member_login=sysdate "
													+ "where member_id = ?";
		Object[] data = {memberId};
		return jdbcTemplate.update(sql, data) > 0;
	}
	
	//회원이 자신의 정보를 변경(수정, Update)
	public boolean updateMember(MemberDto dto) {
		String sql = "update member "
						+ "set member_nick = ?, member_birth = ?, member_contact = ?, "
						+ "member_email = ?, member_post = ?, member_address1 = ?, "
						+ "member_address2 = ? "
						+ "where member_id = ?";
		Object[] data = {
				dto.getMemberNick(), dto.getMemberBirth(), dto.getMemberContact(), 
				dto.getMemberEmail(), dto.getMemberPost(), dto.getMemberAddress1(), 
				dto.getMemberAddress2(), dto.getMemberId()
		};
		return jdbcTemplate.update(sql, data) > 0;
	}
	
	//관리자가 회원의 정보를 변경(관리자에 의한 회원정보 수정, Update) 
	public boolean updateMemberAdmin(MemberDto dto) {
		String sql = "update member "
						+ "set member_nick = ?, member_birth = ?, member_contact = ?, "
						+ "member_email = ?, member_post = ?, member_address1 = ?, "
						+ "member_address2 = ?, member_level = ?, member_point = ? "
						+ "where member_id = ?";
		Object[] data = {
				dto.getMemberNick(), dto.getMemberBirth(), dto.getMemberContact(), 
				dto.getMemberEmail(), dto.getMemberPost(), dto.getMemberAddress1(), 
				dto.getMemberAddress2(), dto.getMemberLevel(), dto.getMemberPoint(),  
				dto.getMemberId()
		};
		return jdbcTemplate.update(sql, data) > 0;
	}
	
	@Autowired
	private StatMapper statMapper;
	
	public List<StatVO> statByLevel(){
		String sql = "select member_level 항목, count(*) 개수 from member "
						+ "group by member_level "
						+ "order by 개수 desc, member_level asc";
		return jdbcTemplate.query(sql, statMapper);
	}
	
	
}
