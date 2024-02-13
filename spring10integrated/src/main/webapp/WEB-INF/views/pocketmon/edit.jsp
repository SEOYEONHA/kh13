<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<div class="container w-500">
	<div class="cell title center">
		<h1>포켓몬스터 정보 수정</h1>
	</div>
	<div class="cell">
		<form action="edit" method="post" autocomplete="off">
		<div class="cell">
			<label>번호 </label>
			<input type="number" name="pocketmonNo" class="tool w-100" value="${dto.pocketmonNo}">
		</div>
		<div class="cell">
			<label>이름</label> 
			<input type="text" name="pocketmonName" class="tool w-100" value="${dto.pocketmonName}">
		</div>
		<div class="cell">
			<label>속성</label>
			<input type="text" name="pocketmonType" class="tool w-100" value="${dto.pocketmonType}">
		</div>
		<div class="cell center">
			<button class="btn purple">정보 수정</button>
			<a href="list" class="btn pink">목록보기</a>
		</div>
		</form>
	</div>
</div>
<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>