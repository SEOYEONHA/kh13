<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
    
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<style>
    .temp{
        word-break: break-all;
        white-space: pre-line;
        valign="top"
    }
</style>


<div class="container w-1100">
	<div class="cell center">
		<h1>${detailDto.boardTitle}</h1>
	</div>
	<div class="cell floating-cell mx-10">
		<div class="cell w-50 left">
			<span>
				<fmt:formatDate value="${detailDto.boardWtime}" 
					pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate> (${detailDto.boardWtimeDiff})
					<c:if test="${detailDto.boardEtime != null}">
						(수정됨)<fmt:formatDate value="${detailDto.boardEtime}" 
							pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>
					</c:if>
					<span> | </span>
				<c:choose>
					<c:when test="${detailDto.boardWriter == null}">
						${boardDto.boardWriterStr}
					</c:when>
					<c:otherwise>
						(${memberDto.memberLevel}) ${memberDto.memberNick}
					</c:otherwise>
				</c:choose>
			</span>
		</div>
		<div class="cell w-50 right">
			<span>조회수 ${detailDto.boardReadcount}</span><span> | </span>
			<span>댓글 ?</span>
		</div>
	</div>
	<hr>
	<div class="cell w-1000 mx-50 temp">
		<span>${detailDto.boardContent}</span>
	</div>
	<hr>
	<div class="cell center">
		<a href="write?boardTarget=${detailDto.boardNo}" class="btn">답글쓰기</a>
		<a href="list" class="btn pink">목록보기</a>
	
		<%-- 
			수정과 삭제 링크는 회원이면서 본인글이거나 관리자일 경우만 출력 
			- 본인글이란 로그인한 사용자 아이디와 게시글 작성자가 같은 경우
			- 관리자란 로그인한 사용자 등급이 '관리자'인 경우	
		--%>
		<c:if test="${sessionScope.loginId != null && (sessionScope.loginId == detailDto.boardWriter || sessionScope.loginLevel == '관리자')}">
			<a href="edit?boardNo=${detailDto.boardNo}" class="btn purple">수정하기</a>
			<a href="delete?boardNo=${detailDto.boardNo}" class="btn negative">삭제하기</a>
		</c:if>
		<a href="write" class="btn positive">새 게시글 작성하기</a> 
	</div>
</div> 














<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>