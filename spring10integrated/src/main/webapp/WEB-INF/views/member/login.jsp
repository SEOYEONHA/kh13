<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<%-- <h1>로그인</h1>
<c:if test="${param.error != null}">
	<h4 style="color:red">로그인 정보가 일치하지 않습니다</h4>
</c:if>

<form action="login" method="post">
	아이디 <input type="text" name="memberId" required><br><br>
	비밀번호 <input type="password" name="memberPw" required><br><br>
	<button>로그인</button>
</form> --%>

<form action="login" method="post" autocomplete="off">
	<div class="container w-400">
		<div class="cell center">
			<h1>로그인</h1>
		</div>
		<div class="cell">
			<label>아이디</label>
			<input type="text" name="memberId" class="tool w-100" required>
		</div>
		<div class="cell">
			<label>비밀번호 </label>
			<input type="password" name="memberPw" class="tool w-100" required>
		</div>
		<div class="cell center">
			<button class="btn positive w-400 mb-30">로그인</button>
		</div>
	</div>

</form>




<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>