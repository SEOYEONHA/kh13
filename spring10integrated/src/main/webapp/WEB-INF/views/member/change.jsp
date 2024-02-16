<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>    

<style>
	input[name=memberPw] {
	    background-image: url("/image/lock-login.png");
	}
	input[name=memberNick] {
	    background-image: url("/image/nickname.png");
	}
	input[name=memberBirth] {
	    background-image: url("/image/calendar.png");
	}
	input[name=memberContact] {
	    background-image: url("/image/telephone.png");
	}
	input[name=memberEmail] {
	    background-image: url("/image/email.png");
	}
	input[name=memberPost] {
	    background-image: url("/image/post.png");
	}
	input[name=memberAddress1] {
	    background-image: url("/image/letterbox.png");
	}
	input[name=memberAddress2] {
	    background-image: url("/image/home.png");
	}

	.fa-asterisk {
		color: red;
	}
</style>

<div class="container w-500" >
	<div class="cell center">
		<h1>${memberDto.memberId}님의 회원 정보 변경</h1>
	</div>
	<div class="cell">
		<c:if test="${param.error != null}">
			<h4 style="color:red">비밀번호가 일치하지 않습니다</h4>
		</c:if>
	</div>
	
	<div class="cell">
		<div class="cell">
			<p style="color: red;">
				<i class="fa-solid fa-asterisk"></i>
				는 필수 항목입니다.
			</p>
		</div>
		<form action="change" method="post">
			<div class="cell">
				<label>
					닉네임 <i class="fa-solid fa-asterisk"></i>
					<input name="memberNick" type="text" class="tool tool-image w-100" required value="${memberDto.memberNick}">
				</label>
			</div>
			<div class="cell">
				<label>
					생년월일 
					<input name="memberBirth" type="date" class="tool tool-image w-100"  value="${memberDto.memberBirth}">
				</label>
			</div>
			<div class="cell">
				<label>
					연락처 
					<input name="memberContact" type="tel" class="tool tool-image w-100"  value="${memberDto.memberContact}">
				</label>
			</div>
			<div class="cell">
				<label>
					이메일 <i class="fa-solid fa-asterisk"></i> 
					<input name="memberEmail" type="email" class="tool tool-image w-100" required value="${memberDto.memberEmail}">
				</label>
			</div>
			<div class="cell">
				<label>
				주소<br>
					<input name="memberPost" placeholder="우편번호" class="tool tool-image w-50" type="text" value="${memberDto.memberPost}" size="6" maxlength="6">
					<input name="memberAddress1" placeholder="기본주소" type="text" class="tool tool-image w-100" value="${memberDto.memberAddress1}" size="50">
					<input name="memberAddress2" placeholder="상세주소" type="text" class="tool tool-image w-100"  value="${memberDto.memberAddress2}">
				</label>
			</div>
			<div class="cell">
				<label>
					비밀번호 확인 <i class="fa-solid fa-asterisk"></i> <br>
					<input type="password" name="memberPw" class="tool tool-image w-100" required>
				</label>
			</div>
			<div class="cell center my-20">
				<button class="btn positive w-100">정보 변경</button>
			</div>
		</form>
	</div>
	<div class="cell center">
		<a href="/member/mypage" class="btn pink w-100 mb-20">마이페이지로 돌아가기</a>
	</div>


</div>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>