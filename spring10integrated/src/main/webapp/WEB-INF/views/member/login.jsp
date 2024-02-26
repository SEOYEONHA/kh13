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
<style>
	input[name=memberId] {
	    background-image: url("/image/user-login.png");
	}
	input[name=memberPw] {
	    background-image: url("/image/lock-login.png");
	}
</style>





<div class="container w-400">
	<div class="cell">
		<c:if test="${param.error != null}">
			<h4 class="red center">로그인 정보가 일치하지 않습니다.</h4>
		</c:if>
	</div>
	<form action="login" method="post" autocomplete="off">
			<div class="cell center">
				<h1>로그인</h1>
			</div>
			<div class="cell">
				<label>
					아이디
					<input type="text" name="memberId" class="tool tool-image w-100">
				</label>
			</div>
			
			<div class="cell">
				<label>
					비밀번호
					<input type="password" name="memberPw" class="tool tool-image w-100">
				</label>
				 
			</div>
			
            
            <hr class="my-20">
            
			<div class="cell ">
				<button class="btn positive w-100">로그인</button>
			</div>
			<hr>
			<div class="cell center blue">
				<p>아직 회원이 아니신가요?</p>
			</div>
	</form>
		<div class="cell center">
			<a href="/member/join" class="btn w-100 mb-20 pink">회원가입</a>
		</div>
</div>



<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>