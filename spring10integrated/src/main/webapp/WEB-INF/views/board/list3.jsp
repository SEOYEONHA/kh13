<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<%-- 페이지 제목 --%>
<h1 align="center">자유게시판</h1>

	<p>
		타인에 대한 무분별한 비방 또는 욕설은 환영합니다.
	</p>




<%-- 목록 출력 --%>
<table border="1" width="800">
	<thead>
		<tr>
			<th>글번호</th>
			<th width="40%">제목</th>
			<th>작성자</th>
			<th>작성시간</th>
			<th>조회수</th>
			<th>그룹</th>
			<th>대상</th>
			<th>차수</th>
		</tr>
	</thead>
	<tbody align="center">
		<c:forEach var="boardDto" items="${boardList}">
		<tr>
			<td>${boardDto.boardNo}</td>
			<%-- 제목 칸 --%>
			<td align="left">
				<%-- 제목 앞에 차수만큼 띄어쓰기 처리 --%>
				<c:forEach var="i" begin="1" end="${boardDto.boardDepth}" step="1">
					&nbsp;&nbsp;&nbsp;&nbsp;
				</c:forEach>
				
				<%-- 답글일 경우만 이미지를 출력 --%>
				<c:if test="${boardDto.boardDepth >0}">
					♥
				</c:if>
			
				<%-- 제목 출력 --%>
				<a href="detail?boardNo=${boardDto.boardNo}">${boardDto.boardTitle}
			</a></td>
			<%-- 
			<c:choose>
				<c:when test="${boardDto.boardWriter == null}">
					<td>(탈퇴한회원)</td>
				</c:when>
				<c:otherwise>
					<td>${boardDto.boardWriter}</td>
				</c:otherwise>
			</c:choose>
			--%>
			<td>${boardDto.boardWriterStr}</td>
			<td>${boardDto.boardWtimeStr}	</td>
			<td>${boardDto.boardReadcount}</td>
			<td>${boardDto.boardGroup}</td>
			<td>${boardDto.boardTarget}</td>
			<td>${boardDto.boardDepth}</td>
		</tr>
		</c:forEach>
	</tbody>
</table>

<%-- 네비게이터 --%>
<jsp:include page="/WEB-INF/views/template/navigator.jsp"></jsp:include>

<%-- 검색창 --%>
<form action="list" method="get">
	<select name="column">
		<option value="board_title" ${param.column == 'board_title' ? 'selected' : ' '}>제목</option>
		<option value="board_writer" ${param.column == 'board_writer' ? 'selected' : ' '}>작성자</option>
		<option value="board_content" ${param.column == 'board_content' ? 'selected' : ' '}>내용</option>
	</select>
		<input type="search" name="keyword" placeholder="검색어를 입력하세요" value="${param.keyword}">
	<button>검색</button>
</form> <br>

<a href="list"><button>목록보기</button></a>
<a href="write"><button>새 게시글 작성하기</button></a> 







<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>