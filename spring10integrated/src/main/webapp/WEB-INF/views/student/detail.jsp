<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include> 
    
<c:choose>
	<c:when test="${studentDto != null}">
		<h1 align="center">학생 상세정보</h1>
		<table border="1" width="300" >
			<tr>
				<th width="30%">학생번호</th>
				<td>${studentDto.studentId}</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>${studentDto.name}</td>
			</tr>
			<tr>
				<th>국어점수</th>
				<td>${studentDto.koreanScore}</td>
			</tr>
			<tr>
				<th>수학점수</th>
				<td>${studentDto.mathScore}</td>
			</tr>
			<tr>
				<th>영어점수</th>
				<td>${studentDto.englishScore}</td>
			</tr>
			<tr>
				<th>총점</th>
				<td>${studentDto.getStudentTotal()}
			</td>
			<tr>
				<th>평균</th>
				<td>${studentDto.getStudentAverage()}</td>
			</tr>
		</table>
		<br>
		<%-- 다른 페이지로의 링크 --%>
		<a href="list"><button>목록보기</button></a>&nbsp;
		<a href="add"><button>신규등록</button></a>&nbsp;
		<a href="edit?studentId=${studentDto.studentId}"><button>수정</button></a>&nbsp;
		<a href="delete?studentId=${studentDto.studentId}"><button>삭제</button></a>
	</c:when>
	<c:otherwise>
		<h1>존재하지 않는 학생 번호</h1>
		<a href="list"><button>목록보기</button></a>
	</c:otherwise>
</c:choose>
   
    
<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>