<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%--
    	절대경로
    	<form action="/emp/insert2"></form>
    	
    	상대경로
    	<form action="insert2"></form>
     --%>

<h1>사원 등록</h1>
<form action="insert" method="post">
	사원명 <input name="empName" type="text"><br><br>
	부서명 <input name="empDept" type="text"><br><br>
	입사일 <input name="empDate" type="date"><br><br>
	급여액 <input name="empSal" type="text"><br><br>
	<button>사원등록</button>
</form>
