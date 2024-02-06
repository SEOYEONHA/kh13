<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    

    
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>


<h1 align="center">포인트 충전</h1>

<%-- 가격 표시를 위한 영역 --%>
<c:forEach var="itemDto" items="${list}">
<hr>
<div>
	<h2>${itemDto.itemName}</h2>
	<img src="image?itemNo=${itemDto.itemNo}"> <br>
	가격 : 
	<fmt:formatNumber value="${itemDto.itemPrice}"></fmt:formatNumber>
	원, 
	충전포인트 : 
	<fmt:formatNumber value="${itemDto.itemCharge}"></fmt:formatNumber>
	포인트
	
	<%-- 구매를 위한 form 생성 --%>
	<form action="charge" method="post">
		<input type="hidden" name="itemNo" value="${itemDto.itemNo}">
		<input type="number" name="buyQty" value="1" required>
		<button>구매</button>
	</form>
</div>
</c:forEach>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>