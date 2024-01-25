<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>    



<h1 align="center">회원 탈퇴</h1>
<p>탈퇴를 위해 비밀번호를 한 번 더 입력해주세요</p>

<form action="exit" method="post">
	<input type="password" name="memberPw" placeholder="비밀번호 입력" required>
	<button>확인</button>
</form>


<c:if test="${param.error != null}">
	<h4 style="color:red">비밀번호가 일치하지 않습니다</h4>
</c:if>


<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>