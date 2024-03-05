<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<div class="container w-800">
	<div class="cell center">
		<c:choose>
			<c:when test="${param.boardTarget == null}">
				<h1>새 게시글 작성</h1>
			</c:when>
			<c:otherwise>
				<h1>${targetDto.boardNo}번 글의 답글 작성</h1>
			</c:otherwise>
		</c:choose>
	</div>
	
	<div class="cell">
		<form action="write" method="post" autocomplete="off">
			<%-- (중요) 답변글일 경우 대상의 번호가 반드시 등록페이지로 전송돼야함 --%>
			<div class="cell">
				<c:choose>
					<c:when test="${param.boardTarget != null}">
						<input type="hidden" name="boardTarget" value="${param.boardTarget}" >
					<input type="text" name="boardTitle" placeholder="게시글 제목" class="tool w-75" required value="RE: ${targetDto.boardTitle}">
					</c:when>
					<c:otherwise>
						<input type="text" name="boardTitle" placeholder="게시글 제목" required class="tool w-75">
					</c:otherwise>
				</c:choose>
			</div>
			<hr>
				
		
			<%-- 
				여러 줄 입력하고 싶다면 textarea 태그를 사용한다 
				<input type="text" name="boardContent" required>
				
				textarea 태그는 종료 태그가 필요하며, type과 value를 설정할 수 없다
				 <textarea name="boardContent" required></textarea>
			--%>
			<div class="cell">
				<textarea rows="10" name="boardContent" placeholder="내용을 작성해주세요" required class="w-100"></textarea>
				<input type="hidden" name="boardWriter" required value="${boardDto.boardWriter}"><br>
			</div>
			<div class="cell floating-cell">
				<div class="cell w-50 left center">
					<button class="btn positive w-75">게시글 등록</button>
				</div>
				<div class="cell w-50 center">
					<a href="list" class="btn pink w-75">목록으로</a>
				</div>
			</div>
		</form>
	</div>
	<br>
	
</div>



<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>