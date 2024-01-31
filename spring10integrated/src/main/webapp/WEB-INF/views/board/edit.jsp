<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>    

<c:if test="${param.error != null}">
	<h4 style="color:red">수정되지 않았습니다</h4>
</c:if>


<form action="edit" method="post">
	<input type="text" name="boardTitle" placeholder="게시글 제목" required size="50" value="${boardDto.boardTitle}"><br><br>
	<%-- 
		textarea는 시작태그와 종료태그 사이에 내용을 작성
		종료태그 전에 엔터를 넣으면 엔터도 들어감. 
		${boardDto.boardNo} 앞뒤로 띄어쓰기 넣으면 수정할때마다 띄어쓰기 추가됨...
	 --%>
	<textarea rows="10" cols="100" name="boardContent" placeholder="내용을 작성해주세요" required>${boardDto.boardContent}</textarea>
	<input type="hidden" name="boardNo" required value="${boardDto.boardNo}"><br>
	<button>게시글 수정</button>
</form> <br>


<a href="list"><button>목록보기</button></a>



<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>    