<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h1>아주 무식한 구매 페이지</h1>

<form action="purchase" method="post">
	상품이름 <input type="text" name="itemName" required><br><br>
	상품가격 <input type="text" name="totalAmount" required><br><br>
	<button type="submit">구매하기</button>
</form>