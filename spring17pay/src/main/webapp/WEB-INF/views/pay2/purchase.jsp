<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
    
<h1>간단한 결제</h1>

<c:forEach var="productDto" items="${list}">
	<div>
		[${productDto.type}]
		${productDto.name}
		(${productDto.price}원)
		
		<form action="purchase" method="post">
			<input type="hidden" name="no" value="${productDto.no}">
			<button type="submit">구매하기</button>
		</form>
	</div>
</c:forEach>	
