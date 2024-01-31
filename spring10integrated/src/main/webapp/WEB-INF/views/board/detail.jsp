<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
    
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include> 


<h1 align="center">${detailDto.boardNo}번 게시글</h1>

<table border="1" width="900">
	<tr>
		<td>${detailDto.boardTitle}</td>
	</tr>
	<tr align="right">
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
		<td>${detailDto.boardContent}</td>
	</tr>
	<tr>
		<td>
			댓글 ? 
		</td>
	</tr>
</table>


<br>

<a href="#"><button>답글쓰기</button></a>
<a href="list"><button>목록보기</button></a>
<%-- 
	수정과 삭제 링크는 회원이면서 본인글이거나 관리자일 경우만 출력 
	- 본인글이란 로그인한 사용자 아이디와 게시글 작성자가 같은 경우
	- 관리자란 로그인한 사용자 등급이 '관리자'인 경우	
--%>
<c:if test="${sessionScope.loginId != null && (sessionScope.loginId == detailDto.boardWriter || sessionScope.loginLevel == '관리자')}">
	<a href="edit?boardNo=${detailDto.boardNo}"><button>수정하기</button></a>
	<a href="delete?boardNo=${detailDto.boardNo}"><button>삭제하기</button></a>
</c:if>
<a href="write"><button>새 게시글 작성하기</button></a> 




<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>