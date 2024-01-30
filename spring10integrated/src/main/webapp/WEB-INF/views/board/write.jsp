<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>



<h1 align="center"> 게시글 작성</h1>
<form action="write" method="post">
	<input type="text" name="boardTitle" placeholder="게시글 제목" size="50" required><br><br>
	<textarea rows="10" cols="100" name="boardContent" placeholder="내용을 작성해주세요" required></textarea>
	<input type="hidden" name="boardWriter" required value="${boardDto.boardWriter}"><br>

	<button>게시글 등록</button>
</form>



<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>