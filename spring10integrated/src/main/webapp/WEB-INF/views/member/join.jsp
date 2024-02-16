<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
    
<style>
	input[name=memberId] {
	    background-image: url("/image/user-login.png");
	}
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
    
    
<div class="container w-500">
	<div class="cell title center">
		<h1>회원가입</h1>
	</div>
	<div class="cell">
		<p style="color: red;">
				<i class="fa-solid fa-asterisk"></i>
				는 필수 항목입니다.
			</p>
		<form action="join" method="post" enctype="multipart/form-data">
			<div class="cell">
				<label>
					아이디 <i class="fa-solid fa-asterisk"></i>
					<input name="memberId" class="tool tool-image w-100" placeholder="소문자 시작, 숫자포함 8~20자" type="text" required>
				</label>
			</div>
			<div class="cell">
				<label>
					비밀번호 <i class="fa-solid fa-asterisk"></i>
					<input name="memberPw" class="tool tool-image w-100" placeholder="대소문자, 숫자, 특수문자(!@#$) 포함 6~15자" type="password" required>
				</label>
			</div>
			<div class="cell">
				<label>
					닉네임 <i class="fa-solid fa-asterisk"></i>
					<input name="memberNick" class="tool tool-image w-100" type="text" required>
				</label>
			</div>
			<div class="cell">
				<label>
					생년월일
					<input name="memberBirth" class="tool tool-image w-100" type="date">
				</label> 
			</div>
			<div class="cell">
				<label>
					연락처
					<input name="memberContact" class="tool tool-image w-100" type="tel">
				</label>
			</div>
			<div class="cell">
				<label>
					이메일 <i class="fa-solid fa-asterisk"></i>
					<input name="memberEmail" class="tool tool-image w-100" type="email" required>
				</label>
			</div>
			<div class="cell">
				<label>주소</label><br>
				<input name="memberPost" class="tool tool-image w-50" placeholder="우편번호"  type="text">
				<input name="memberAddress1" class="tool tool-image w-100" placeholder="기본주소" type="text">
				<input name="memberAddress2" class="tool tool-image w-100" placeholder="상세주소" type="text">
			</div>
			<div class="cell">
				<label>프로필 이미지</label> <br>
				<input type ="file" name="attach">
			</div>
			
			<div class="cell center">
				<button class="btn positive w-100 my-20">회원가입</button>
			</div>
		</form>
	</div>
</div>
<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>