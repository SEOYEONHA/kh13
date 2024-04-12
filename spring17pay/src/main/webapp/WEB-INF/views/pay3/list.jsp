<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>결제 내역</h1>

<c:forEach var="paymentDto" items="${list}">
	<div>
		${paymentDto}
		<h2><a href="detail?paymentNo=${paymentDto.paymentNo}">더보기</a></h2>
	</div>
</c:forEach>