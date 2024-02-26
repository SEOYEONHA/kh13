<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<div class="container w-800">
	<%-- 페이지 제목 --%>
	<c:choose>
		<c:when test="${isSearch}">
			<div class="cell center title">
				<h1>사원 검색</h1>
			</div>
		</c:when>
		<c:otherwise>
			<div class="cell center title">
				<h1>사원 목록</h1>
			</div>
		</c:otherwise>
	</c:choose>
	
	<div class="cell right">
		<a href="insert" class="btn positive">신규등록</a> 
	</div>
	
	<form action="deleteAll" method="post">
	<div class="cell">
		<%-- 목록 출력 --%>
		<table class="table table-border table-hover">
			<thead>
				<tr>
					<c:if test="${sessionScope.loginLevel == '관리자'}">
						<th>
							<input type="checkbox" class="check-all">
						</th>
					</c:if>
					<th width="11%">사원번호</th>
					<th>사원명</th>
					<th>부서명</th>
					<th>입사일</th>
					<th>급여액</th>
				</tr>
			</thead>
			<tbody align="center">
				<c:forEach var="dto" items="${list}">
				<tr>
					<c:if test="${sessionScope.loginLevel == '관리자'}">
						<td>
							<input type="checkbox" class="check-item" 
										name="empNo" value="${dto.empNo}">
						</td>
					</c:if>
					<td>${dto.empNo}</td>
					<td><a href="detail?empNo=${dto.empNo}" class="link">${dto.empName}</a></td>
					<td>${dto.empDept}</td>
					<td>${dto.empDate}</td>
					<td><fmt:formatNumber value="${dto.empSal}" pattern="#,##0"></fmt:formatNumber>원</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		
	

	
	<%-- 네비게이터 --%>
	<jsp:include page="/WEB-INF/views/template/navigator.jsp"></jsp:include>
	
	<div class="cell center">
		<%-- 검색창 시작지점 --%>
		<form action="list" method="get" autocomplete="off">
			<div class="cell">
				<select name="column" class="tool">
				<%--
					EL은 문자열도 == 로 비교한다 (물론 equals도 가능)
					EL은 문자열도 쌍따옴표로 쓰건 외따옴표로 쓰건 상관하지 않는다
				 --%>
					<option value="emp_name" ${param.column == 'emp_name' ? 'selected' : ' '}>사원명</option>
					<option value="emp_dept" ${param.column == 'emp_dept' ? 'selected' : ' '}>부서명</option>
					<option value="emp_date" ${param.column == 'emp_date' ? 'selected' : ' '}>입사일</option>
				</select>
				<input type="search" name="keyword" placeholder="검색어 입력" class="tool" value="${param.keyword}">
				<button class="btn">검색</button>
			</div>
		</form>
		<%-- 검색창 종료지점 --%>
	</div>

				<!-- 삭제버튼 -->
	<c:if test="${sessionScope.loginLevel == '관리자'}">	
		<div class="cell right">
				<button class="btn negative">선택삭제</button>
			</form>
		</div>
	</c:if>
	
	</form>
	</div>

	
</div>


	



<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>