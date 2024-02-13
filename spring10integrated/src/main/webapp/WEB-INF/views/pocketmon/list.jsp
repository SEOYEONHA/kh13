<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
    
<h1>포켓몬스터 목록</h1>

<%-- 목록 출력 --%>
<table border="1" width="700">
	<thead>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>속성</th>
		</tr>
	</thead>
	<tbody align="center">
	<%-- for(PocketmonDto dto:list) --%>
		<c:forEach var="dto" items="${list}">
		<tr>
			<td>${dto.pocketmonNo}</td>
			<td><a href="detail?pocketmonNo=${dto.pocketmonNo}">${dto.pocketmonName}</a></td>
			<td>${dto.pocketmonType}</td>
		</tr>
		</c:forEach>
	</tbody>
</table>

	<%-- 네비게이터 --%>
	<jsp:include page="/WEB-INF/views/template/navigator.jsp"></jsp:include>
	
	<%-- 검색창(form은 그냥 주소생성기라고 생각) --%>
<form action="list" method="get">
	<select name="column" class="tool">
		<option value="pocketmon_name">포켓몬 이름</option>
		<option value="pocketmon_type">포켓몬 속성</option> 
	</select>
	<input type="search" name="keyword" placeholder="검색어를 입력하세요" value="${param.keyword}">
	<button class="btn">검색</button>
</form>
<br>

<a href="list"><button>목록보기</button></a>
<a href="insert1"><button>포켓몬 신규 등록</button></a> 




<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>