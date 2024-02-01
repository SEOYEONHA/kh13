<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- column, keyword 형태일때만 사용가능!! --%>

<%-- 네비게이터 --%>
<h3 align="center">

	<%-- 이전이 있을 경우에만 링크 제공 --%>
	<c:choose>
		<c:when test="${pageVO.firstBlock}">&lt;이전</c:when>
		<c:otherwise>
			<a href="list?page=1&${pageVO.queryString}">처음으로</a>
			<a href="list?page=${pageVO.prevBlock}&${pageVO.queryString}">&lt;이전</a>
		</c:otherwise>
	</c:choose>
	&nbsp;&nbsp;
	<c:forEach var="i" begin="${pageVO.getBeginBlock()}" end="${pageVO.getEndBlock()}" step="1">
		<%-- 다른 페이지일 경우에만 링크를 제공 --%>
		<c:choose>
			<c:when test="${pageVO.isCurrentPage(i)}">${i}</c:when>		
			<c:otherwise>
				<a href="list?page=${i}&${pageVO.getQueryString()}">${i}</a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	&nbsp;&nbsp;
	
	<%-- 다음이 있을 경우에만 링크를 제공 --%>
	<c:choose>
		<c:when test="${pageVO.isLastBlock()}">다음&gt;</c:when>
		<c:otherwise>
			<a href="list?page=${pageVO.getNextBlock()}&${pageVO.getQueryString()}">다음&gt;</a>
		</c:otherwise>
	</c:choose>
</h3>
