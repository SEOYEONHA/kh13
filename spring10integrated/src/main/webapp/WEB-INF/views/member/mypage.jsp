<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>    
<h1 align="center">마이페이지</h1>
<hr>
<h3>${memberDto.memberId}님의 회원 정보</h3>

<img src="image" width="200" height="200"><br>

<table border="1" width = "600">
	<tr>
		<th width="30%">닉네임</th>
		<td>${memberDto.memberNick}</td>
	</tr>
	<tr>
		<th>생년월일</th>
		<td>${memberDto.memberBirth}</td>
	</tr>
	<tr>
		<th>연락처</th>
		<td>${memberDto.memberContact}</td>
	</tr>
	<tr>
		<th>이메일</th>
		<td>${memberDto.memberEmail}</td>
	</tr>
	<tr>
		<th>주소</th>
		<td>[${memberDto.memberPost}] ${memberDto.memberAddress1}<br>
		${memberDto.memberAddress2}
		</td>
	</tr>
	<tr>
		<th>회원등급</th>
		<td>${memberDto.memberLevel}</td>
	</tr>
	<tr>
		<th>포인트</th>
		<td>${memberDto.memberPoint} point</td>
	</tr>
	<tr>
		<th>가입시간</th>
		<td><fmt:formatDate value="${memberDto.memberJoin}" 
									pattern="Y-MM-DD HH:mm:ss"></fmt:formatDate>
<%--	<td><fmt:formatDate value="${memberDto.memberJoin}" 
							pattern="Y년 M월 D일 H시 m분 s초"></fmt:formatDate>
		 																								--%>	
		</td>
	</tr>
	<tr>
		<th>마지막 로그인시간</th>
		<td><fmt:formatDate value="${memberDto.memberLogin}" 
									pattern="Y-MM-dd HH:mm:ss"></fmt:formatDate>
	<%--	<td><fmt:formatDate value="${memberDto.memberJoin}" 
								pattern="Y년 M월 D일 H시 m분 s초"></fmt:formatDate>
			 																								--%>	
		</td>
	</tr>
</table>
<br>
<a href="/member/password"><button>비밀번호 변경</button></a>
<a href="/member/change"><button>개인정보 변경</button></a>
<a href="/member/exit"><button>회원 탈퇴</button></a>


<hr>

<br>

<h1 align="center">
	포인트 구매 내역
	<a href="/point/charge">추가구매</a>
</h1>
<table border="1" width="600">
	<thead>
		<tr>
			<th>번호</th>
			<th>상품명</th>
			<th>수량</th>
			<th>구매금액</th>
			<th>구매일시</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="buyDto" items="${buyList}">
		<tr>
			<td>${buyDto.buySerial}</td>
			<td>${buyDto.itemName}</td>
			<td>${buyDto.buyQty}</td>
			<td>
				<fmt:formatNumber value="${buyDto.buyTotal}" pattern="#,##0"></fmt:formatNumber>
			</td>
			<td>
				<fmt:formatDate value="${buyDto.buyTime}" pattern="yyyy-MM-dd HH:mm"></fmt:formatDate>
			</td>
		</tr>
		</c:forEach>
	</tbody>
</table>










<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>