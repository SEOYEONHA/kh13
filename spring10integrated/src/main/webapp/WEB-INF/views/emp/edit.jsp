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
	<div>
		<form action="edit" method="post" autocomplete="off">
			<input type="hidden" name="empNo" required value="${dto.empNo}">
			사원명 <input type="text" name="empName" required value="${dto.empName}"> <br><br>
			부서명 <input type="text" name="empDept" required value="${dto.empDept}"> <br><br>
			입사일 <input type="date" name="empDate" required value="${dto.empDate}"> <br><br>
			급여액 <input type="number" name="empSal" required value="${dto.empSal}"> <br><br>
			<button>수정하기</button>
		</form>
	</div>
	<div>
		<a href="list">목록보기</a>
	</div>
</div>

<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>