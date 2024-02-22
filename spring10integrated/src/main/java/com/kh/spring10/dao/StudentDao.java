package com.kh.spring10.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring10.dto.StudentDto;
import com.kh.spring10.mapper.StudentMapper;
import com.kh.spring10.vo.PageVO;

@Repository
public class StudentDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private StudentMapper mapper;
	
	//학생 등록
	public void insert(StudentDto dto) {
		String sql = "insert into student("
								+ "student_id, name, korean_score, math_score, english_score) "
								+ "values(student_seq.nextval, ?, ?, ?, ?)";
		Object[] data = {dto.getName(), dto.getKoreanScore(), 
				dto.getMathScore() ,dto.getEnglishScore()
					};
		jdbcTemplate.update(sql, data);
	}
	
	//학생 목록
	public List<StudentDto> selectList(){
		String sql = "select * from student order by student_id asc";
		return jdbcTemplate.query(sql, mapper);
	}
	
	public List<StudentDto> selectList(String column, String keyword){
		String sql = "select * from student "
							+ "where instr(" + column + ", ?) > 0 "
							+ "order by " + column + " asc, student_id asc";
		Object[] data = {keyword};
		return jdbcTemplate.query(sql, mapper, data);
	
	}
	//상세 검색
	public StudentDto selectOne(int studentId) {
		String sql = "select * from student where student_id = ?";
		Object[] data = {studentId};
		List<StudentDto> list = jdbcTemplate.query(sql, mapper, data);
		return list.isEmpty() ? null : list.get(0);
	}
	
	//정보 수정
	public boolean updateStudent(StudentDto dto) {
		String sql = "update student "
						+ "set name = ?, korean_score = ?, math_score = ?, "
						+ "english_score = ? where student_id = ?";
		Object[] data = {
				dto.getName(), dto.getKoreanScore(), dto.getMathScore(), 
				dto.getEnglishScore(), dto.getStudentId()
		};
		return jdbcTemplate.update(sql, data) > 0;
	}
	
	//정보 삭제
	public boolean delete(int studentId) {
		String sql = "delete student where student_id = ?";
		Object[] data = {studentId};
		return jdbcTemplate.update(sql, data) > 0;
	}
	
	//평균에 따른 석차
	public List<StudentDto> rankList(){
		String sql = "select rownum as 석차, student_id, name, korean_score, math_score, english_score, (korean_score + math_score + english_score) / 3 AS 평균 "
				+ "from ( "
				+ " select student_id, name, korean_score, math_score, english_score "
				+ "from student "
				+ "order by (korean_score + math_score + english_score) desc) "
				+ "order by 평균 desc;";
		return jdbcTemplate.query(sql, mapper);
	}
	
	//VO를 이용한 카운트
	public int count(PageVO pageVO) {
		if(pageVO.isSearch()) {
			String sql = "select count(*) from student "
							+ "where instr(" + pageVO.getColumn() + ", ?) > 0";
			Object[] data = {pageVO.getKeyword()};
			return jdbcTemplate.queryForObject(sql, int.class, data);
		}
		else { //목록
			String sql = "select count(*) from student";
			return jdbcTemplate.queryForObject(sql, int.class);
		}
	}
	
	//통합 페이징
	public List<StudentDto> selectListByPaging(PageVO pageVO){
		if(pageVO.isSearch()) { //검색
			String sql = "select * from ("
					+ "select rownum rn, TMP.* from ("
						+ "select * from student where instr(" + pageVO.getColumn() + ", ?) > 0 "
						+ "order by " + pageVO.getColumn() + " asc, student_id asc"
					+ ")TMP"
				+ ") where rn between ? and ?";
			Object[] data = {pageVO.getKeyword(), pageVO.getBeginRow(), pageVO.getEndRow()};
			return jdbcTemplate.query(sql, mapper, data);
		}
		else { //목록
			String sql = "select * from ("
					+ "select rownum rn, TMP.* from ("
						+ "select * from student order by student_id asc"
					+ ")TMP"
				+ ") where rn between ? and ?";
			Object[] data = {pageVO.getBeginRow(), pageVO.getEndRow()};
			return jdbcTemplate.query(sql, mapper, data);
		}
	}
	
	//특정 번호의 학생에 대한 순위를 추첨하는 메소드
	//- 필요 데이터 : 학생의 총점
	//- 결과 데이터 : 해당 학생의 순위(int)
	//- 명령 : jdbcTemplate.query가 아닌 jdbcTemplate.queryForObject 사용
	//- int, String등 하나의 결과만 나오는 경우 사용할 수 있음
	//- 총점을 통해 등수 확인 가능(아래 구문은 220점인 학생의 등수 구하는 구문)
	//- select rank(220) within group(order by korean_score+english_score+math_score desc) from student;
	public int rank(int total) {
		String sql = "select rank(?) within group(order by korean_score+english_score+math_score desc) from student";
		Object[] data = {total};
		//int.class는 int라는 결과값을 얻어내기 위해 알려주는 자료형 정보
		//- 만약 String이라면 해당 위치에 String.class라고 작성
		return jdbcTemplate.queryForObject(sql, int.class, data);
	}
}
