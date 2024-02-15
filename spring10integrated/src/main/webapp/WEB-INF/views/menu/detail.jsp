<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<div class="cell container w-600">
	<div class="cell">
	<c:choose>
			<c:when test="${dto != null}">
				<div class="cell title center">
					<h1 >메뉴 정보</h1>
				</div>
				<table class="table table-border">
					<tr>
						<th width="30%">메뉴번호</th>		
						<td>${dto.menuNo}</td>
					<tr>
						<th>메뉴이름(한글)</th>
						<td>${dto.menuNameKor}</td>
					</tr>
						<tr>
						<th>메뉴이름(영문)</th>
						<td>${dto.menuNameEng}</td>
					</tr>
					<tr>
						<th>메뉴유형</th>
						<td>${dto.menuType}</td>
					</tr>
					<tr>
						<th>판매가격</th>
						<td><fmt:formatNumber value="${dto.menuPrice}" pattern="#,##0"></fmt:formatNumber>원</td>
					</tr>
				</table>
				
				<%-- 다른 페이지로의 링크 --%>
			<div class="cell center">
				<a href="list" class="btn pink">목록보기</a>&nbsp;
				<a href="insert" class="btn positive">신규등록</a>&nbsp;
				<a href="change?menuNo=${dto.menuNo}" class="btn purple">수정</a>&nbsp;
				<a href="delete?menuNo=${dto.menuNo}" class="btn negative">삭제</a>
			</div>
			</c:when>
		
		
		<c:otherwise>
			<div class="cell title center">
				<h1>존재하지 않는 메뉴 번호</h1>
			</div>
			<div class="cell">
				<a href="list" class="btn pink"><button>목록보기</button></a>
			</div>
		</c:otherwise>
	</c:choose>
	</div>
</div>


<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>