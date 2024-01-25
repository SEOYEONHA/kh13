<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include> 


<h1 align="center">신규 학생 등록</h1>
<form action="add" method="post">
	이름 <input type="text" name="name" required><br><br>
	국어점수 <input type="number" name="koreanScore" required><br><br>
	수학점수 <input type="number" name="mathScore" required><br><br>
	영어점수 <input type="number" name="englishScore" required><br><br>
<button>학생등록</button>
</form>
<br>
<a href="list"><button>목록보기</button></a>

<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>   