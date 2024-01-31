<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>



<h1 align="center"> 게시글 작성</h1>
<form action="write" method="post">
	<input type="text" name="boardTitle" placeholder="게시글 제목" size="50" required><br><br>
	<%-- 
		여러 줄 입력하고 싶다면 textarea 태그를 사용한다 
		<input type="text" name="boardContent" required>
		
		textarea 태그는 종료 태그가 필요하며, type과 value를 설정할 수 없다
		 <textarea name="boardContent" required></textarea>
	--%>
	<textarea rows="10" cols="100" name="boardContent" placeholder="내용을 작성해주세요" required></textarea>
	<input type="hidden" name="boardWriter" required value="${boardDto.boardWriter}"><br>

	<button>게시글 등록</button>
</form>



<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>