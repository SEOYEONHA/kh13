<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>    
    
<h1 align="center">${memberDto.memberId}님의 회원 정보 수정</h1>

<form action="edit" method="post">
	<input type="hidden" name="memberId" required value="${memberDto.memberId}">
	닉네임 <input type="text" name="memberNick" required value="${memberDto.memberNick}"> <br><br>
	생년월일 <input type="date" name="memberBirth" value="${memberDto.memberBirth}"> <br><br>
	연락처 <input type="tel" name="memberContact" value="${memberDto.memberContact}"> <br><br>
	이메일 <input type="email" name="memberEmail" required value="${memberDto.memberEmail}"> <br><br>
	주소
	<input name="memberPost" placeholder="우편번호"  type="text" value="${memberDto.memberPost}"><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input name="memberAddress1" placeholder="기본주소" type="text" value="${memberDto.memberAddress1}"><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input name="memberAddress2" placeholder="상세주소" type="text" value="${memberDto.memberAddress2}"><br><br>
	회원등급 
	<select name= "memberLevel">
		<option value="일반회원" ${memberDto.memberLevel == '일반회원' ? 'selected' : ' '}>일반회원</option>
		<option value="우수회원" ${memberDto.memberLevel == '우수회원' ? 'selected' : ' '}>우수회원</option>
		<option value="관리자" ${memberDto.memberLevel == '관리자' ? 'selected' : ' '}>관리자</option>
	</select><br><br>
	포인트 <input type="number" name="memberPoint" required value="${memberDto.memberPoint}"> <br><br>
	<button>정보 수정</button>
</form>
<br>
<a href="detail?memberId=${memberDto.memberId}"><button>상세페이지로 돌아가기</button></a>



<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>