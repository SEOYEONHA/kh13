<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
    
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include> 

<div class="container w-800">
	<div class="cell center title">
		<h1 align="center">${detailDto.boardNo}번 게시글</h1>
	</div>
	
	<div class="cell">
		<table class="table table-border">
			<tr class="left">
				<td>${detailDto.boardTitle}</td>
			</tr>
			<tr class="right">
				<td>
					<c:choose>
						<c:when test="${detailDto.boardWriter == null}">
							${boardDto.boardWriterStr}
						</c:when>
						<c:otherwise>
							작성자 : ${memberDto.memberNick}(${memberDto.memberLevel}) 
						</c:otherwise>
					</c:choose>
					<br>
					조회수 : ${detailDto.boardReadcount} <br>
				</td>
			</tr>
			<tr align="right">
				<td>
					<fmt:formatDate value="${detailDto.boardWtime}" 
						pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate> (${detailDto.boardWtimeDiff})<br>
						
					<c:if test="${detailDto.boardEtime != null}">
						(수정됨)<fmt:formatDate value="${detailDto.boardEtime}" 
						pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>
					</c:if>
				</td>
			</tr>
			<tr height="200" valign="top">
				<td>
					<%-- 
						HTML은 엔터와 스페이스 등을 무시하기때문에 tectarea와 모양이 달라진다
						- 상용 에디터를 쓰면 알아서 글자를 보정해주기 때문에 문제가 없다
						- 기본 textarea를 쓰면 문제가 발생한다
						- <pre>태그를 사용하면 글자를 있는그대로 출력한다
					 --%>
					<pre>${detailDto.boardContent}</pre>
				</td>
			</tr>
			<tr>
				<td>
					댓글 ? 
				</td>
			</tr>
		</table>
	</div>
	
	<br>
	
	<a href="write?boardTarget=${detailDto.boardNo}" class="btn ">답글쓰기</a>
	<a href="list" class="btn pink">목록보기</a>
	<%-- 
		수정과 삭제 링크는 회원이면서 본인글이거나 관리자일 경우만 출력 
		- 본인글이란 로그인한 사용자 아이디와 게시글 작성자가 같은 경우
		- 관리자란 로그인한 사용자 등급이 '관리자'인 경우	
	--%>
	<c:if test="${sessionScope.loginId != null && (sessionScope.loginId == detailDto.boardWriter || sessionScope.loginLevel == '관리자')}">
		<a href="edit?boardNo=${detailDto.boardNo}" class="btn">수정하기</a>
		<a href="delete?boardNo=${detailDto.boardNo}" class="btn negative">삭제하기</a>
	</c:if>
	<a href="write" class="btn positive">새 게시글 작성하기</a> 

</div>


<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>