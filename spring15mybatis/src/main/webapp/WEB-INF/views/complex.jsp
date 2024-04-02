<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>회원 복합 검색 페이지</h1>

<%-- 검색창 --%>
<form>
	<fieldset>
		<legend>검색창</legend>
		아이디 <input type="text" name="memberId" value="${vo.memberId}"> <br><br>
		닉네임 <input type="text" name="memberNick" value="${vo.memberNick}"> <br><br>
		연락처 <input type="text" name="memberContact" value="${vo.memberContact}"> <br><br>
		포인트 
		<input type="number" name="minPoint" value="${vo.minPoint}"> ~
		<input type="number" name="maxPoint" value="${vo.maxPoint}">
		<br><br>
		가입일 <input type="date" name="memberJoin" value="${vo.memberJoin}"><br><br>
		최종로그인 일시
		<input type="date" name="minLoginDate" value="${vo.minLoginDate}"> 부터
		<input type="date" name="maxLoginDate" value="${vo.maxLoginDate}"> 까지
		<br><br>
		회원등급 
		<input type="checkbox" name="memberLevelList" value="일반회원" <c:if test="${vo.memberLevelList.contains('일반회원')}">checked</c:if>>일반회원
		<input type="checkbox" name="memberLevelList" value="우수회원" <c:if test="${vo.memberLevelList.contains('우수회원')}">checked</c:if>>우수회원
		<input type="checkbox" name="memberLevelList" value="관리자" <c:if test="${vo.memberLevelList.contains('관리자')}">checked</c:if>>관리자
		<br><br>

		1차 정렬
		<select name="orderList">
			<option value="member_id asc" <c:if test="${vo.orderList.get(0) == 'member_id asc'}">selected</c:if>>아이디순</option>
			<option value="member_nick asc" <c:if test="${vo.orderList.get(0) == 'member_nick asc'}">selected</c:if>>닉네임순</option>
			<option value="member_contact asc" <c:if test="${vo.orderList.get(0) == 'member_contact asc'}">selected</c:if>>연락처순</option>
			<option value="member_point desc" <c:if test="${vo.orderList.get(0) == 'member_point desc'}">selected</c:if>>보유포인트순</option>
			<option value="member_join desc" <c:if test="${vo.orderList.get(0) == 'member_join desc'}">selected</c:if>>최근가입순</option>
			<option value="member_login desc" <c:if test="${vo.orderList.get(0) == 'member_login desc'}">selected</c:if>>최근로그인순</option>
		</select>		
		<br><br>
		
		2차 정렬
		<select name="orderList">
			<option value="member_id asc" <c:if test="${vo.orderList.get(1) == 'member_id asc'}">selected</c:if>>아이디순</option>
			<option value="member_nick asc" <c:if test="${vo.orderList.get(1) == 'member_nick asc'}">selected</c:if>>닉네임순</option>
			<option value="member_contact asc" <c:if test="${vo.orderList.get(1) == 'member_contact asc'}">selected</c:if>>연락처순</option>
			<option value="member_point desc" <c:if test="${vo.orderList.get(1) == 'member_point desc'}">selected</c:if>>보유포인트순</option>
			<option value="member_join desc" <c:if test="${vo.orderList.get(1) == 'member_join desc'}">selected</c:if>>최근가입순</option>
			<option value="member_login desc" <c:if test="${vo.orderList.get(1) == 'member_login desc'}">selected</c:if>>최근로그인순</option>
		</select>		
		<br><br>
		
		3차 정렬
		<select name="orderList">
			<option value="member_id asc" <c:if test="${vo.orderList.get(2) == 'member_id asc'}">selected</c:if>>아이디순</option>
			<option value="member_nick asc" <c:if test="${vo.orderList.get(2) == 'member_nick asc'}">selected</c:if>>닉네임순</option>
			<option value="member_contact asc" <c:if test="${vo.orderList.get(2) == 'member_contact asc'}">selected</c:if>>연락처순</option>
			<option value="member_point desc" <c:if test="${vo.orderList.get(2) == 'member_point desc'}">selected</c:if>>보유포인트순</option>
			<option value="member_join desc" <c:if test="${vo.orderList.get(2) == 'member_join desc'}">selected</c:if>>최근가입순</option>
			<option value="member_login desc" <c:if test="${vo.orderList.get(2) == 'member_login desc'}">selected</c:if>>최근로그인순</option>
		</select>		
		<br><br>
		
		페이지번호 <input type="number" name="page" value="${vo.page}"> <br><br>
		페이지크기 <input type="number" name="size" value="${vo.size}"> <br><br>
		
		<button type="submit">검색</button>
	</fieldset>
</form>

<%-- 결과 --%>
<h2>결과 수 : ${list.size()}</h2>
<c:forEach var="memberDto" items="${list}">
	${memberDto}
	<hr>
</c:forEach>