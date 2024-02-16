<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>    

<style>

	input[name=originPw], input[name=changePw] {
	    background-image: url("/image/lock-login.png");
	}

</style>

<div class="container w-400">
	<div class="cell title">
		<h1 align="center">비밀번호 변경</h1>
	</div>
	
	<div class="cell">
		<c:if test="${param.error != null}">
			<h4 style="color:red">현재 비밀번호가 일치하지 않습니다.</h4>
		</c:if>
	</div>
	
	<div class="cell">
		<form action="password" method="post">
			<div class="cell">
				<label>
					현재 비밀번호 
					<input type="password" name="originPw" class="tool tool-image w-100" required placeholder="현재 비밀번호" >
				</label>
			</div>
			<div class="cell">
				<label>
					신규 비밀번호 
					<input type="password" name="changePw" class="tool tool-image w-100" required placeholder="신규 비밀번호" >
				</label>
			</div>
			<div class="cell center my-30">
				<button class="btn w-100 positive">변경하기</button>
			</div>
		</form>
	</div>
	
</div>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>