<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%--
	EL에서 파라미터를 읽고 싶다면 param 이라는 내장객체를 사용한다
	예를들어 ${param.query}라고 쓰면 query=ㅇㅇㅇ 을 읽는다
 --%>
<h1>EL에서 파라미터 읽기</h1>

<form action="test03" method="get">
	<input type="search" name="query" value="${param.query}">
	<button>검색</button>
</form>

<h2>${param.query} 에 대한 검색 결과</h2>