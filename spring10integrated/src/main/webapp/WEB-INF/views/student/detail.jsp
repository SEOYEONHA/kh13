<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include> 

<div class="container w-400">
	<div class="cell center">
	<c:choose>
		<c:when test="${studentDto != null}">
			<div class="cell title">
				<h1 align="center">학생 상세정보</h1>
			</div>
			<div class="cell">
				<table class="table table-border">
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
					<tr>
						<th>석차</th>
						<td>${rank}</td>
					</tr>
				</table>
			</div>
			<div class="cell">
				<%-- 다른 페이지로의 링크 --%>
				<a href="list" class="btn pink w-25">목록</a>
				<a href="edit?studentId=${studentDto.studentId}" class="btn purple w-25">수정</a>
				<a href="delete?studentId=${studentDto.studentId}" class="btn negative w-25">삭제</a>
			</div>
		</c:when>
		<c:otherwise>
			<div class="cell center">
				<h1>존재하지 않는 학생 번호</h1>
			</div>
			<div class="cell">
				<a href="list">목록보기></a>
			</div>
		</c:otherwise>
	</c:choose>
	</div>
</div>   
    
<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>