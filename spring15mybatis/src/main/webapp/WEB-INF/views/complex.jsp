<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>회원 복합 검색 페이지</h1>

<%-- 검색창 --%>

<%-- 결과 --%>
<h2>결과 수 : ${list.size()}</h2>
<c:forEach var="memberDto" items="${list}">
	${memberDto}
	<hr>
</c:forEach>

