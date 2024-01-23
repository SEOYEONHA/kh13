<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:choose>
	<c:when test="${dto != null}">
		<h1>사원 정보</h1>
		
		<table border="1" width="300">
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
		<br>
		
		<%-- 다른 페이지로의 링크 --%>
		<a href="list"><button>목록보기</button></a>&nbsp;
		<a href="insert"><button>신규등록</button></a>&nbsp;
		<a href="edit?empNo=${dto.empNo}"><button>수정</button></a>&nbsp;
		<a href="delete?empNo=${dto.empNo}"><button>삭제</button></a>
		
	</c:when>
	<c:otherwise>
		<h1>존재하지 않는 사원 번호</h1>
		<a href="list"><button>목록보기</button></a>
	</c:otherwise>
</c:choose>