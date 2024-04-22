package com.kh.spring19.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring19.dao.StudentDao;
import com.kh.spring19.dto.EmpDto;
import com.kh.spring19.dto.StudentDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

//학생 REST API - 전부 다 ResponseEntity 형태로 처리
@Tag(name = "학생 관리")

@CrossOrigin
@RestController
@RequestMapping("/student")
public class StudentRestController {

	@Autowired
	private StudentDao studentDao;
	
	//등록
	@Operation(
		description = "학생 정보 등록",
		responses = {
			@ApiResponse(responseCode = "200",description = "학생 등록 완료",
				content = @Content(
					mediaType = "application/json",
					schema = @Schema(implementation = StudentDto.class)
				)
			),
			@ApiResponse(responseCode = "500",description = "서버 오류",
				content = @Content(
						mediaType = "text/plain",
						schema = @Schema(implementation = String.class), 
						examples = @ExampleObject("server error")
				)
			),
		}
	)
	
	@PostMapping("/")
	public ResponseEntity<StudentDto> insert(
			@Parameter(description = "생성할 학생 정보에 대한 입력값", required = true, schema = @Schema(implementation = StudentDto.class))
			@RequestBody StudentDto studentDto) {
		int sequence = studentDao.sequence();
		studentDto.setStudentId(sequence);
		studentDao.insert(studentDto);
		return ResponseEntity.ok().body(studentDao.selectOne(sequence));
	}
	
	//목록
	@Operation(
		description = "학생 목록 조회",
		responses = {
			@ApiResponse(responseCode = "200",description = "조회 완료",
				content = @Content(
						mediaType = "application/json",
						array = @ArraySchema(schema = @Schema(implementation = EmpDto.class))
				)
			),
			@ApiResponse(responseCode = "500",description = "서버 오류",
				content = @Content(
						mediaType = "text/plain",
						schema = @Schema(implementation = String.class), 
						examples = @ExampleObject("server error")
				)
			),
		}
	)
	
	@GetMapping("/")
	public ResponseEntity<List<StudentDto>> list() {
		List<StudentDto> list = studentDao.selectList();
		return ResponseEntity.ok().body(list);
	}
	
	//상세
	@Operation(
		description = "학생 상세 정보 조회",
		responses = {
			@ApiResponse(responseCode = "200",description = "조회 완료",
					content = @Content(
						mediaType = "application/json",
						schema = @Schema(implementation = StudentDto.class)
					)
			),
			@ApiResponse(responseCode = "404",description = "학생 정보 없음",
				content = @Content(
						mediaType = "text/plain",
						schema = @Schema(implementation = String.class), 
						examples = @ExampleObject("not found")
				)
			),
			@ApiResponse(responseCode = "500",description = "서버 오류",
				content = @Content(
						mediaType = "text/plain",
						schema = @Schema(implementation = String.class), 
						examples = @ExampleObject("server error")
				)
			),
		}
	)
	
	@GetMapping("/{studentId}")
	public ResponseEntity<StudentDto> find(@PathVariable int studentId) {
		StudentDto studentDto = studentDao.selectOne(studentId);
		if(studentDto == null) return ResponseEntity.notFound().build();
		return ResponseEntity.ok().body(studentDto);
	}
	
	//수정
	@Operation(
		description = "학생 정보 변경",
		responses = {
			@ApiResponse(responseCode = "200",description = "변경 완료",
				content = @Content(
					mediaType = "application/json",
					schema = @Schema(implementation = StudentDto.class)
				)
			),
			@ApiResponse(responseCode = "404",description = "학생 정보 없음",
				content = @Content(
						mediaType = "text/plain",
						schema = @Schema(implementation = String.class), 
						examples = @ExampleObject("not found")
				)
			),
			@ApiResponse(responseCode = "500",description = "서버 오류",
				content = @Content(
						mediaType = "text/plain",
						schema = @Schema(implementation = String.class), 
						examples = @ExampleObject("server error")
				)
			),
		}
	)
	
	@PatchMapping("/")
	public ResponseEntity<StudentDto> edit(@RequestBody StudentDto studentDto) {
		boolean result = studentDao.edit(studentDto);
		if(result == false) return ResponseEntity.notFound().build();
		return ResponseEntity.ok().body(studentDao.selectOne(studentDto.getStudentId()));//수정 완료된 결과를 조회하여 반환
	}
	
	//삭제
	@Operation(
		description = "학생 정보 삭제",
		responses = {
			@ApiResponse(responseCode = "200",description = "삭제 완료",
				content = @Content(
						mediaType = "text/plain",
						schema = @Schema(implementation = String.class),
						examples = @ExampleObject("ok")
				)
			),
			@ApiResponse(responseCode = "404",description = "학생 정보 없음",
				content = @Content(
						mediaType = "text/plain",
						schema = @Schema(implementation = String.class), 
						examples = @ExampleObject("not found")
				)
			),
			@ApiResponse(responseCode = "500",description = "서버 오류",
				content = @Content(
						mediaType = "text/plain",
						schema = @Schema(implementation = String.class), 
						examples = @ExampleObject("server error")
				)
			),
		}
	)
	
	@DeleteMapping("/{studentId}")
	public ResponseEntity<?> delete(@PathVariable int studentId) {
		boolean result = studentDao.delete(studentId);
		if(result == false) return ResponseEntity.notFound().build();
		return ResponseEntity.ok().build();
	}
	
}