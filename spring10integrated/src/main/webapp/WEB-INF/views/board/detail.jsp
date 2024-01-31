<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
    
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include> 


<h1>${detailDto.boardNo}번 게시글</h1>

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
				pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate> <br>
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

<a href="list"><button>목록보기</button></a>
<a href="edit?boardNo=${detailDto.boardNo}"><button>수정하기</button></a>
<a href="delete?boardNo=${detailDto.boardNo}"><button>삭제하기</button></a> 
<a href="write"><button>새 게시글 작성하기</button></a> 




<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>