<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>    

<div class="container w-1200">
	<div class="cell title center">
		<h1 align="center">마이페이지</h1>
		<hr class="my-20">
	</div>
	
	<div class="cell center">
		<h2>${memberDto.memberId}님의 회원 정보</h2>
	</div>
	
	<div class="cell floating-cell card">
		<div class="p-20">
			<div>
				<img src="image" width="200" height="200">
			</div>
			<div class="mt-40">
				<a href="/member/password" class="btn pink w-100">비밀번호 변경</a>
			</div>
			<div>
				<a href="/member/change" class="btn w-100">개인정보 변경</a>
			</div>
			<div>
				<a href="/member/exit" class="btn negative w-100">회원 탈퇴</a>
			</div>
		</div>
		
		<div class="cell w-75">
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
			<div>
			<c:if test="${not empty buyList}">
			
			<div class="cell title center">
				<h1>포인트 구매 내역 </h1>
			</div>
			
			<div>
			<h2 align="right">
				<a href="/point/charge" class="link"><i class="fa-solid fa-store"></i>추가구매</a>
			</h2>
			</div>
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
		</div>
		<hr class="my-20">
</div>








<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>