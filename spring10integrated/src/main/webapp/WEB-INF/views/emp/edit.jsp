<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

    <%--
    EL(Expression Language) 표현 언어 
    ${dto.getEmpName} = ${dto.empName}
     --%>
<div class="container w-500">
	<div class="cell center title">
		<h1>사원 정보 수정</h1>
	</div>
	<div class="cell" >
		<form action="edit" method="post" autocomplete="off">
			<input type="hidden" name="empNo" required value="${dto.empNo}">
			<div class="cell">
				<label>사원명</label>
				<input type="text" name="empName" class="tool w-100" required value="${dto.empName}">
			</div>
			<div class="cell">
				<label>부서명</label>
				<input type="text" name="empDept" class="tool w-100"  required value="${dto.empDept}">
			</div>
			
			입사일 <input type="date" name="empDate" class="tool w-100"  required value="${dto.empDate}"> <br><br>
			급여액 <input type="number" name="empSal" class="tool w-100"  required value="${dto.empSal}"> <br><br>
			<button class="btn positive w-100">수정하기</button>
			<hr>
		</form>
	</div>
	<div>
		<a href="list" class="btn w-100 mb-20">목록보기</a>
	</div>
</div>

<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>