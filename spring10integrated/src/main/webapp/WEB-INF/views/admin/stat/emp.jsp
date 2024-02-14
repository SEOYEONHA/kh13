<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<div class="container w-400">
	<div class="cell title">
		<h1 align="center">부서별 사원수</h1>
	</div>
	
	<div class="cell">
		<table class="table table-border">
			<thead>
				<tr>
					<th>부서명</th>
					<th>인원수</th>	
				</tr>
			</thead>
			<tbody>
				<c:forEach var="statVO" items="${list}">
				<tr>
					<td>${statVO.title}</td>
					<td>${statVO.count}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>

<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>