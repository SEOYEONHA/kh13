<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<c:if test="${param.error != null}">
	<h4 style="color:red">수정 실패</h4>
</c:if>

<form action="edit" method="post">
	<input type="hidden" name="studentId" required value="${studentDto.studentId}">
	이름 <input type="text" name="name" required value="${studentDto.name}"><br><br>
	국어점수 <input type="number" name="koreanScore" required value="${studentDto.koreanScore}"><br><br>
	국어점수 <input type="number" name="mathScore" required value="${studentDto.mathScore}"><br><br>
	국어점수 <input type="number" name="englishScore" required value="${studentDto.englishScore}"><br><br>
	<button>정보 수정</button>
</form> <br>
<a href="detail?studentId=${studentDto.studentId}"><button>상세페이지로 돌아가기</button></a>
<a href="list"><button>목록으로 돌아가기</button></a>

<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>