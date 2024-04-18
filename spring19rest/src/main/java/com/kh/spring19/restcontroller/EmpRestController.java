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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring19.dao.EmpDao;
import com.kh.spring19.dto.EmpDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@CrossOrigin
@RestController
@RequestMapping("/emp")
public class EmpRestController {
	
	@Autowired
	private EmpDao empDao;
	
	//문서용 설정 추가
	@Operation(
		description = "사원 목록 조회",
		responses = {
			@ApiResponse(
				responseCode = "200",
				description = "조회 성공",
				content = {
					@Content(
						mediaType = "application/json",
						array = @ArraySchema(
							schema = @Schema(implementation = EmpDto.class)
						)
					) 
				}
			),
			@ApiResponse(
				responseCode = "500",
				description = "서버 오류",
				content = {
					@Content(
						mediaType = "text/plain",
						schema = @Schema(implementation = String.class),
						examples = @ExampleObject("server error")
					)
				}
			)
		}
	)
	
	@GetMapping("/")
	public List<EmpDto> list() {
		return empDao.selectList();
	}
	
//	@GetMapping("/{empNo}")
//	public EmpDto find(@PathVariable int empNo) {
//		EmpDto empDto = empDao.selectOne(empNo);
//		return empDto;
//	}
	
//	조회되지 않는 경우(null인 경우)는 404번으로 처리하고 싶다면
	@Operation(
			description = "사원 상세 조회",
			responses = {
				@ApiResponse(
					responseCode = "200",
					description = "조회 성공",
					content = {
						@Content(
							mediaType = "application/json",
							schema = @Schema(implementation = EmpDto.class)
						)
					}
				),
				@ApiResponse(
					responseCode = "404",
					description = "해당 사번의 데이터가 없음",
					content = @Content(
						mediaType = "text/plain", 
						schema = @Schema(implementation = String.class),
						examples = @ExampleObject("not found")
					)
				),
				@ApiResponse(
					responseCode = "500",
					description = "서버 오류",
					content = @Content(
						mediaType = "text/plain", 
						schema = @Schema(implementation = String.class),
						examples = @ExampleObject("server error")
					)
				)
			}
		)
	@GetMapping("/{empNo}")
	public ResponseEntity<EmpDto> find(@PathVariable int empNo) {
		EmpDto empDto = empDao.selectOne(empNo);
		if(empDto == null) {
			//return ResponseEntity.notFound().build();
			return ResponseEntity.status(404).build();
		}
		//return ResponseEntity.ok(empDto);
		return ResponseEntity.status(200).body(empDto);
	}

	
	@PostMapping("/") //등록
	public EmpDto insert(@RequestBody EmpDto empDto){ 
		int sequence = empDao.sequence(); //번호생성
		empDto.setEmpNo(sequence); //번호설정
		empDao.insert(empDto); //등록
		
		//return empDto;
		return empDao.selectOne(sequence); //DB는최대한 안가는 게 좋긴함
	}
	
	// 조회되지 않는 사원(존재하지 않는 사원)은 404번으로 반환
	
	@PutMapping("/")
	public ResponseEntity<?> editAll(@RequestBody EmpDto empDto) {
		boolean result = empDao.editAll(empDto);
		if(result == false) {
			//return ResponseEntity.notFound().build();
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok().build();
	}
	
	@PatchMapping("/")
	public ResponseEntity<?> editUnit(@RequestBody EmpDto empDto) {
		boolean result = empDao.editUnit(empDto);
		if(result == false) {
			//return ResponseEntity.notFound().build();
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok().build();
	}
	
	//@Operation(작업에 대한 설명)
	@DeleteMapping("/{empNo}")
	public ResponseEntity<?> delete(@PathVariable int empNo) {
		boolean result = empDao.delete(empNo);
		if(result == false) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().build();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
