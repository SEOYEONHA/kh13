<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>


<div class="container w-500">
	<div class="cell center mt-50">
		<h2>아이디 찾기</h2>
	</div>
	
	<hr class="my-20">
	
		<form action="findId" method="post">
			<div class="cell flex-cell my-50">
				
				<input type="text" name="memberNick" required class="tool w-100" placeholder="닉네임을 입력하세요">
				
				<button class="btn pink ms-10">
					<i class="fa-solid fa-magnifying-glass"></i>
				</button>
				
			</div>
		</form>
	
</div>



<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
