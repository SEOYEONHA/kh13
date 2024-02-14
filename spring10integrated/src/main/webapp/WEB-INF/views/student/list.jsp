<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<div class="container w-800">

	<%-- 페이지 제목 --%>
	<div class="cell title center">
		<c:choose>
			<c:when test="${isSearch}">
				<h1 align="center">학생 검색</h1>
			</c:when>
			<c:otherwise>
				<h1 align="center">학생 목록</h1>
			</c:otherwise>
		</c:choose>
	</div>
	
	
	<div class="cell">
		<%-- 목록 출력 --%>
		<table class="table table-border table-hover">
			<thead>
				<tr>
					<th>번호</th>
					<th>이름</th>
					<th>국어점수</th>
					<th>수학점수</th>
					<th>영어점수</th>
				</tr>
			</thead>
			<tbody align="center">
				<c:forEach var="studentDto" items="${list}">
				<tr>
					<td>${studentDto.studentId}</td>
					<td><a href="detail?studentId=${studentDto.studentId}" class="link">${studentDto.name}</a></td>
					<td>${studentDto.koreanScore}</td>
					<td>${studentDto.mathScore}</td>
					<td>${studentDto.englishScore}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<%-- 네비게이터 --%>
	<jsp:include page="/WEB-INF/views/template/navigator.jsp"></jsp:include>
	
	<div class="cell center">
		<%-- 검색창 --%>
		<form action="list" method="get" autocomplete="off">
			<select name="column" class="tool">
				<option value="student_id" ${param.column == 'student_id' ? 'selected' : ' '}>학생 번호</option>
				<option value="name" ${param.column == 'name' ? 'selected' : ' '}>학생 이름</option>
			</select>
				<input type="text" name="keyword" placeholder="검색어를 입력하세요" class="tool" required value="${param.keyword}">
			<button class="btn">검색</button>
		</form>
		<hr class="my-20">
	</div>
	
	<div class="cell center mb-20">
		<a href="list" class="btn pink">목록보기</a>
		<a href="add" class="btn positive">학생 신규 등록</a> 
	</div>
</div>




<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>