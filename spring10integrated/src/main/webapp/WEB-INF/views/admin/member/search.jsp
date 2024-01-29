<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1 align="center">회원 검색</h1>
    
    
<%--
	절대경로
	<form action="/admin/member/search" method="get"></form>

	절대경로로 할 이유가 없으니 상대경로로 함! --%>
	
	
<%-- 검색창 --%>
<form action="search" method="get">
	<select name="column">
		<option value="member_id" ${param.column == 'member_id' ? 'selected' : ' '}>아이디</option>
		<option value="member_nick" ${param.column == 'member_nick' ? 'selected' : ' '}>닉네임</option>	
		<option value="member_contact" ${param.column == 'member_contact' ? 'selected' : ' '}>연락처</option>
		<option value="member_email" ${param.column == 'member_email' ? 'selected' : ' '}>이메일</option>
		<option value="member_birth" ${param.column == 'member_birth' ? 'selected' : ' '}>생년월일</option>
	</select>
	<input type="search" name="keyword" required placeholder="검색어를 입력하세요"
					 value="${param.keyword}" >
	<button>검색</button>
</form>


<%-- 조회 결과는 list의 유무에 따라 다르게 출력--%>
<%-- 목록 출력 --%>

<%--     강사님 코드
<c:choose>
	<c:when test="${list=null}">
		<h2>검색어를 입력하세요</h2>
	</c:when>
	<c:when test="${list.isEmpty()}">
		<h2>검색 결과가 존재하지 않습니다</h2> 
	</c:when>
	<c:otherwise>
		<table>
		...
		</table>
	</c:otherwise>
</c:choose>
--%>

<c:choose>
	<c:when test="${not empty param.keyword}">
		<br>
		<table border="1" width="700">
			<thead>
				<tr>
					<th>아이디</th>
					<th>닉네임</th>
					<th>연락처</th>
					<th>이메일</th>
					<th>생년월일</th>
				</tr>
				</thead>
			<tbody align="center">
				<c:forEach var="memberDto" items="${list}">
					<tr>
						<td><a href="detail?memberId=${memberDto.memberId}">${memberDto.memberId}</a></td>
						<td> ${memberDto.memberNick}</td>
						<td>${memberDto.memberContact}</td>
						<td>${memberDto.memberEmail}</td>
						<td>${memberDto.memberBirth}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:when>
	<c:otherwise>
		<h2 style="color:fuchsia;" align="center">♡검색어를 입력하세요♡</h2>
		<img width="400" src="/bg2.jpg">
	</c:otherwise>
</c:choose>




		
			
		


<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>