<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<%-- 페이지 제목 --%>
<h1 align="center">메뉴 목록</h1>



<%-- 목록 출력 --%>
<table border="1" width="700">
	<thead>
		<tr>
			<th>메뉴번호</th>
			<th>메뉴이름</th>
			<th>메뉴유형</th>
			<th>판매가격</th>
		</tr>
	</thead>
	<tbody align="center">
		<c:forEach var="dto" items="${list}">
		<tr>
			<td>${dto.menuNo}</td>
			<td><a href="detail?menuNo=${dto.menuNo}">${dto.menuNameKor}(${dto.menuNameEng})</a></td>
			<td>${dto.menuType}</td>
<%--			<td align="right">${dto.menuPrice}원</td> --%>
			<td><fmt:formatNumber value="${dto.menuPrice}" pattern="#,##0"></fmt:formatNumber>
			원</td>
		</tr>
		</c:forEach>
	</tbody>
</table>
<br>

<%-- 네비게이터(구조는 복잡하지만 /board/list와 같지않을까?) --%>
<jsp:include page="/WEB-INF/views/template/navigator.jsp"></jsp:include>

<%--검색창 --%>
<form action="list" method="get">
	<select name="column">
		<option value="menu_name_kor" ${param.column == 'menu_name_kor' ? 'selected' : ' '}>메뉴명(한글)</option>
		<option value="menu_name_eng" ${param.column == 'menu_name_eng' ? 'selected' : ' '}>메뉴명(영문)</option>	
		<option value="menu_type" ${param.column == 'menu_type' ? 'selected' : ' '}>타입</option>
	</select>
	<input type="text" name="keyword" placeholder="검색어를 입력하세요" required value="${param.keyword}">
	<button>검색</button>
</form>
<br>

<a href="list"><button>목록보기</button></a>
<a href="insert"><button>신규등록</button></a> 

<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>