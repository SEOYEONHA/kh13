<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 페이지 제목 --%>
<c:choose>
	<c:when test="${isSearch}">
		<h1>사원 검색</h1>
	</c:when>
	<c:otherwise>
		<h1>사원 목록</h1>
	</c:otherwise>
</c:choose>

<%-- 검색창 시작지점 --%>
<form action="list" method="get">
	<select name="column">
	<%--
		EL은 문자열도 == 로 비교한다 (물론 equals도 가능)
		EL은 문자열도 쌍따옴표로 쓰건 외따옴표로 쓰건 상관하지 않는다
	 --%>
	<c:choose>
		<c:when test="${param.column == 'emp_name'}">
			<option value="emp_name" selected>사원명</option>
		</c:when>
		<c:otherwise>
			<option value="emp_name">사원명</option>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${param.column == 'emp_dept'}">
			<option value="emp_dept" selected>부서명</option>
		</c:when>
		<c:otherwise>
			<option value="emp_dept">부서명</option>
		</c:otherwise>
	</c:choose>
		<c:choose>
		<c:when test="${param.column == 'emp_date'}">
			<option value="emp_date">입사일</option>
		</c:when>
		<c:otherwise>
			<option value="emp_date">입사일</option>
		</c:otherwise>
	</c:choose>
	</select>
	<input type="search" name="keyword" placeholder="검색어 입력" value="${param.keyword}">
	<button>검색</button>
</form>
<%-- 검색창 종료지점 --%>


<%-- 목록 출력 --%>
<table border="1">
	<thead>
		<tr>
			<th>사원번호</th>
			<th>사원명</th>
			<th>부서명</th>
			<th>입사일</th>
			<th>급여액</th>
		</tr>
	</thead>
	<tbody align="center">
		<c:forEach var="dto" items="${list}">
		<tr>
			<td>${dto.empNo}</td>
			<td>${dto.empName}</td>
			<td>${dto.empDept}</td>
			<td>${dto.empDate}</td>
			<td>${dto.empSal}원</td>
		</tr>
		</c:forEach>
	</tbody>
</table>
