<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>    

<div class="container w-800">
	<div class="cell title center">
		<h1 align="center">마이페이지</h1>
		<hr class="my-20">
	</div>
	
	<div class="cell center">
		<h2>${memberDto.memberId}님의 회원 정보</h2>
	</div>
	
	<div class="cell center">
		<img src="image" width="200" height="200">
	</div>
	
	<div class="cell">
		<table class="table table-border">
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
	</div>
	<hr class="my-20">
	<div class="cell center">
		<a href="/member/password" class="btn pink">비밀번호 변경</a>&nbsp;&nbsp;&nbsp;
		<a href="/member/change" class="btn">개인정보 변경</a>&nbsp;&nbsp;&nbsp;
		<a href="/member/exit" class="btn negative">회원 탈퇴</a>
	</div>
	
	<hr class="mt-50">
	
	
	
	<div class="cell center">
		<c:if test="${not empty buyList}">
		
		<h1>포인트 구매 내역 </h1>
		
			<table class="table table-border">
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
			<div class="cell my-30">
				<a href="/point/charge" class="btn positive w-50">추가구매</a>
			</div>
		</c:if>
	</div>

	
	
	
	
	<c:if test="${empty buyList}">
		<div class="cell center">
			<i class="fa-regular fa-face-sad-tear fa-5x"></i> 
			<h2>구매내역이 없습니다</h2>
		</div>
		<div class="cell my-30">
			<a href="/point/charge" class="btn positive w-100">구매하러가기</a>
		</div>
	</c:if>
</div>








<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>