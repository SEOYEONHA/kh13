<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<div class="cotainer w-500">
	<c:choose>
		<c:when test="${dto != null}">
			<div class="cell center title">
				<h1>사원 정보</h1>
			</div>
			<div class="cell">
				<table class="table table-border">
					<tr>
						<th width="30%">사원번호</th>
						<td>${dto.empNo}</td>
					</tr>
					<tr>
						<th>사원명</th>
						<td>${dto.empName}</td>
					</tr>
					<tr>
						<th>부서명</th>
						<td>${dto.empDept}</td>
					</tr>
					<tr>
						<th>입사일</th>
						<td>${dto.empDate}</td>
					</tr>
					<tr>
						<th>급여액</th>
						<td><fmt:formatNumber value="${dto.empSal}" pattern="#,##0"></fmt:formatNumber>원</td>
					</tr>
				</table>
			</div>
			
			<%-- 다른 페이지로의 링크 --%>
			<div class="cell center">
				<a href="list" class="btn pink">목록보기</a>&nbsp;
				<a href="insert" class="btn positive">신규등록</a>&nbsp;
				<a href="edit?empNo=${dto.empNo}" class="btn purple">수정</a>&nbsp;
				<a href="delete?empNo=${dto.empNo}" class="btn negative">삭제</a>
			</div>
		</c:when>
		<c:otherwise>
			<h1>존재하지 않는 사원 번호</h1>
			<a href="list"><button>목록보기</button></a>
		</c:otherwise>
	</c:choose>
</div>

<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>