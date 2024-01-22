<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>메뉴 목록</h1>
<form action="list" method="get">
	<select name="column">
		<option value="menu_name_kor">메뉴명(한글)</option>
		<option value="menu_name_eng">메뉴명(Eng)</option>
		<option value="menu_type">종류</option>
	</select>
	<input type="search" name="keyword" value="${param.keyword}">
	<button>검색</button>
</form>

<c:forEach var="dto" items="${list}">
	<h3>
	No.${dto.menuNo} 메뉴명 : ${dto.menuNameKor}(${dto.menuNameEng}) 
	[${dto.menuType}] - ${dto.menuPrice}원
	</h3>
</c:forEach>