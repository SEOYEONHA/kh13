<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<div class="container w-900">
	<div class="cell title">
		<h1 align="center">충전 상품 목록</h1>
	</div>
	<div class="cell right">
		<h2><a href="add" class="btn positive">신규등록</a></h2>
	</div>
	<div class="cell">
		<table class="table table-border">
			<c:forEach var="itemDto" items="${list}">
			<tr>
				<td><img src="image?itemNo=${itemDto.itemNo}"></td>
				<td>${itemDto.itemName}</td>
				<td>
					<fmt:formatNumber value="${itemDto.itemPrice}" pattern="#,##0"></fmt:formatNumber>원
				</td>
				<td>${itemDto.itemCharge}포인트 충전</td>
				<td>
					<a href="edit?itemNo=${itemDto.itemNo}" class="link">수정</a>
				</td>
				<td>
					<a href="delete?itemNo=${itemDto.itemNo}" class="link">삭제</a>
				</td>
			</tr>
			</c:forEach>
		</table>
	</div>
</div>


<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>