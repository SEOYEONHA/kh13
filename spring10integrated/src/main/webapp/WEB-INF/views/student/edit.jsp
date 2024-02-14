<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<div class="container w-500">
	
	<div class="cell">
		<c:if test="${param.error != null}">
			<h4 style="color:red">수정 실패</h4>
		</c:if>
	</div>
	
	<div class="cell title center">
		<h1>학생 정보 수정</h1>
	</div>
	
	<div class="cell">
		<form action="edit" method="post" autocomplete="off">
			<input type="hidden" name="studentId" required value="${studentDto.studentId}">
			<div class="cell">
				<label>이름 </label>
				<input type="text" name="name" class="tool w-100" required value="${studentDto.name}">
			</div>
			<div class="cell">
				<label>국어점수 </label>
				<input type="number" name="koreanScore" class="tool w-100" required value="${studentDto.koreanScore}">
			</div>
			<div class="cell">
				<label>수학점수</label> 
				<input type="number" name="mathScore" class="tool w-100" required value="${studentDto.mathScore}">
			</div>
			<div class="cell">
				<label>영어점수</label> 
				<input type="number" name="englishScore" class="tool w-100" required value="${studentDto.englishScore}">
			</div>
			<div class="cell center">
				<button class="btn purple">정보 수정</button>
				<a href="list" class="btn pink">목록보기</a>
			</div>
		</form> 
	</div>
</div>

<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>