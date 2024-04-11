<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>결제 상세 정보</h1>

<%-- 전체 취소는 잔여금액이 존재할 때 출력 --%>
<c:if test="${paymentDto.paymentRemain > 0}">
<h2><a href="cancelAll?paymentNo=${paymentDto.paymentNo}">전체 취소</a></h2>
</c:if>

<ul>
	<li>결제고유번호 : ${paymentDto.paymentNo}</li>
	<li>결제일 : ${paymentDto.paymentTime}</li>
	<li>결제상품명 : ${paymentDto.paymentName}</li>
	<li>총결제금액 : ${paymentDto.paymentTotal}원</li>
	<li>취소가능금액 : ${paymentDto.paymentRemain}원</li>
	<li>구매자 : ${paymentDto.memberId}</li>
	<li>거래번호 : ${paymentDto.paymentTid}</li>
</ul>

<hr>

<c:forEach var="paymentDetailDto" items="${detailList}">
<ul>
	<li>결제상세번호 : ${paymentDetailDto.paymentDetailNo}</li>
	<li>상품번호 : ${paymentDetailDto.paymentDetailProduct}</li>
	<li>구매수량 : ${paymentDetailDto.paymentDetailQty}</li>
	<li>상품명 : ${paymentDetailDto.paymentDetailName}</li>
	<li>개당가격 : ${paymentDetailDto.paymentDetailPrice}원</li>
	<li>결제상태 : ${paymentDetailDto.paymentDetailStatus}</li>
<%-- 	<li>소계 : ${paymentDetailDto.getTotalPrice()}원</li> --%>
	<li>소계 : ${paymentDetailDto.totalPrice}원</li>
</ul>

<%-- 항목 취소는 "승인" 상태인 항목에만 출력 --%>
<c:if test="${paymentDetailDto.paymentDetailStatus == '승인'}">
<h2><a href="cancelItem?paymentDetailNo=${paymentDetailDto.paymentDetailNo}">↑↑↑항목 취소↑↑↑</a></h2>
</c:if>
</c:forEach>

<hr>

<ul>
<c:forEach var="paymentActionDetailVO" items="${responseVO.paymentActionDetails}">
 	<li>요청번호 : ${paymentActionDetailVO.aid}</li>
	<li>요청유형 : ${paymentActionDetailVO.paymentActionType}</li>
	<li>금액 : ${paymentActionDetailVO.amount} 원</li>
</c:forEach>
</ul>

${responseVO}