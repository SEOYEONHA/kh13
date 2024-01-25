<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>    

<h1 align="center">비밀번호 변경</h1>

<form action="password" method="post">
	현재 비밀번호 <input type="password" name="originPw" required placeholder="현재 비밀번호" ><br><br>
	신규 비밀번호 <input type="password" name="changePw" required placeholder="신규 비밀번호" ><br><br>
	<button>변경하기</button>
</form>

<c:if test="${param.error != null}">
	<h4 style="color:red">비밀번호가 일치하지 않습니다</h4>
</c:if>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>