<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>


<div class="container w-500">
	<div class="cell center mt-50">
		<h2>비밀번호 찾기</h2>
	</div>
	
	<hr class="my-20">
	
		<form action="findPw" method="post">
			<div class="cell my-50">
				<input type="text" name="memberId" required class="tool w-100" placeholder="아이디를 입력하세요">
				<br><br>
				<input type="text" name="memberEmail" required class="tool w-100" placeholder="이메일을 입력하세요">
				
				
				<button class="btn pink w-100 my-40">
					찾기
				</button>
				
			</div>
		</form>
	
</div>



<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
