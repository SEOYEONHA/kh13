<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
    
<div class="container w-800">
	<div class="cell title center">
		<h1>회원가입</h1>
	</div>
	<div class="cell">
		<p style="color: red;">(*)는 필수 항목입니다.</p>
		<form action="join" method="post" enctype="multipart/form-data">
			<div class="cell">
				<label>아이디(*)</label>
				<input name="memberId" class="tool w-100" placeholder="소문자 시작, 숫자포함 8~20자" type="text" required>
			</div>
			<div class="cell">
				<label>비밀번호(*) </label>
				<input name="memberPw" class="tool w-100" placeholder="대소문자, 숫자, 특수문자(!@#$) 포함 6~15자" type="password" required>
			</div>
			<div class="cell">
				<label>닉네임(*)</label>
				<input name="memberNick" class="tool w-100" type="text" required>
			</div>
			<div class="cell">
				<label>생년월일</label> 
				<input name="memberBirth" class="tool w-100" type="date">
			</div>
			<div class="cell">
				<label>연락처</label>
				<input name="memberContact" class="tool w-100" type="tel">
			</div>
			<div class="cell">
				<label>이메일(*)</label>
				<input name="memberEmail" class="tool w-100" type="email" required>
			</div>
			<div class="cell">
				<label>주소</label><br>
				<input name="memberPost" class="tool w-50" placeholder="우편번호"  type="text">
				<input name="memberAddress1" class="tool w-100" placeholder="기본주소" type="text">
				<input name="memberAddress2" class="tool w-100" placeholder="상세주소" type="text">
			</div>
			<div class="cell">
				<label>프로필 이미지</label> 
				<input type ="file" class="tool w-100" name="attach">
			</div>
			
			<div class="cell center">
				<button class="btn positive w-100 my-20">회원가입</button>
			</div>
		</form>
	</div>
</div>
<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>