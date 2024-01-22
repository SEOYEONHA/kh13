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
<%-- for(EmpDto dto : list){} --%>
<c:forEach var="dto" items="${list}">
	<h3>
	No.${dto.empNo} 사원명 : ${dto.empName}(${dto.empDept})
	</h3>
	<h4>
	입사일자 : ${dto.empDate} <br>
	급여 : ${dto.empSal}원
	</h4>
</c:forEach>

<%-- 
	html에서 꺾쇠는 태그를 의미하여 사용할 수 없다
	특수문자로 대체하여 사용
	< 는 less than 줄여서 &lt;
	> 는 greather than 줄여서 &gt;
	띄어쓰기는 non-breaking space 줄여서 &nbsp;
	(이스케이프 문자 \ 랑 비슷한 느낌)
	궁금하다면 인터넷에 HTML특수문자표 검색
--%>