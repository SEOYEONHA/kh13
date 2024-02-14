<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
    
<div class="container w-500">
	<div class="cell title center">
		<h1>사원등록 완료</h1>
	</div>
	<div class="cell center">
	<a href="list" class="btn pink">목록보기</a>
	<a href="insert" class="btn positive">신규등록</a> 
	</div>
	
</div>
<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>