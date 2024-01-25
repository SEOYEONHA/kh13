<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>    

<h1 align="center">${memberDto.memberId}님의 회원 정보 변경</h1>



<form action="change" method="post">
	닉네임(*) <input name="memberNick" type="text" required value="${memberDto.memberNick}"><br>
	생년월일 <input name="memberBirth" type="date" value="${memberDto.memberBirth}"><br>
	연락처 <input name="memberContact" type="tel" value="${memberDto.memberContact}"><br>
	이메일(*) <input name="memberEmail" type="email" required value="${memberDto.memberEmail}"><br>
	주소
	<input name="memberPost" placeholder="우편번호"  type="text" value="${memberDto.memberPost}" size="6" maxlength="6"><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input name="memberAddress1" placeholder="기본주소" type="text" value="${memberDto.memberAddress1}" size="50"><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input name="memberAddress2" placeholder="상세주소" type="text" value="${memberDto.memberAddress2}"><br><br>
	비밀번호 확인(*) <input type="password" name="memberPw" required><br>
	<button>정보 변경</button>
</form>
<a href="/member/mypage"><button>마이페이지</button></a>

<c:if test="${param.error != null}">
	<h4 style="color:red">비밀번호가 일치하지 않습니다</h4>
</c:if>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>