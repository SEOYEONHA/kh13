<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1 align="center">등급별 인원수</h1>

<table border="1" width="300">
	<thead>
		<tr>
			<th>등급</th>
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

<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>