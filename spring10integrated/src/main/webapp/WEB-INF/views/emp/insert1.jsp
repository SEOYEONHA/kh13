<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

    <%--
    	절대경로
    	<form action="/emp/insert2"></form>
    	
    	상대경로
    	<form action="insert2"></form>
     --%>

<!-- <h1>사원 등록</h1>
<form action="insert" method="post">
	사원명 <input name="empName" type="text"><br><br>
	부서명 <input name="empDept" type="text"><br><br>
	입사일 <input name="empDate" type="date"><br><br>
	급여액 <input name="empSal" type="text"><br><br>
	<button>사원 등록</button>
</form> -->
<div class="container w-400">
	<div class="cell">
		<c:if test="${param.error != null}">
			<h4 style="color:red">수정 실패</h4>
		</c:if>
	</div>
	

	<div class="cell">
		<form action="insert" method="post" autocomplete="off">
			<div class="cell center">
				<h1>사원 등록</h1>
			</div>
			<div class="cell">
				<label>사원명</label>
				<input type="text" name="empName" class="tool w-100" required>
			</div>
			<div class="cell">
				<label>부서명</label>
				<input type="text" name="empDept" class="tool w-100" required>
			</div>
			<div class="cell">
				<label>입사일</label>
				<input type="date" name="empDate" class="tool w-100" required>
			</div>
			<div class="cell">
				<label>급여액</label>
				<input type="text" name="empSal" class="tool w-100 right" required>
			</div>
			<div class="cell center">
				<button class="btn positive w-400">등록하기</button>
				<hr class="w-400">
				<a href="list" class="btn pink w-400 mb-30">목록으로</a>
			</div>
		</form>
	</div>
</div>


<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
