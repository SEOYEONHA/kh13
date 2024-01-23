<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
    
    
<h1>회원가입</h1>
<p>(*)는 필수 항목입니다.</p>
<form action="join" method="post">
	아이디(*) <input name="memberId" placeholder="소문자 시작, 숫자포함 8~20자" type="text" required><br>
	비밀번호(*) <input name="memberPw" placeholder="대소문자, 숫자, 특수문자(!@#$) 포함 6~15자" type="password" required><br>
	닉네임(*) <input name="memberNick" type="text" required><br>
	생년월일 <input name="memberBrith" type="date"><br>
	연락처 <input name="memberContact" type="tel"><br>
	이메일(*) <input name="memberEmail" type="email" required><br><br>
	주소
	<input name="memberPost" placeholder="우편번호"  type="text"><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input name="memberAddress1" placeholder="기본주소" type="text"><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input name="memberAddress2" placeholder="상세주소" type="text"><br><br>
	<button>회원가입</button>
</form>

<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>