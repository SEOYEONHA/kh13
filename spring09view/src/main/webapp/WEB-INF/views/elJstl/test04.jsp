<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%--
	JSTL (Jsp Standard Tag Library, JSP 표준 태그 모음)
	- 태그 형식을 가지는 페이지 생성에 도움되는 도구들
	- 조건, 반복, 예외처리, 포맷변환 등 다양한 처리가 가능
	- 종류는 총 5가지가 존재(core, format, function, sql, xml)
	- EL과 같이 사용하여 효과적으로 페이지를 구현
	- 페이지에 설정으로 등록해야 사용할 수 있다
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>JSTL을 이용한 조건부 코드</h1>

<h2>n = ${param.n}</h2>

<%-- 
	<c:if>를 사용하면 조건부 화면을 작성할 수 있다.
	- test 속성에 EL을 이용하여 조건식을 작성한다
	- <c:else>, <c:elseif>는 없다
	- 단순하게 한 가지를 보여주거나 말아야 할 때 사용
 --%>
 
	<c:if test="${param.n % 2 == 0}">
	<h2>n은 짝수입니다</h2>
</c:if>
<c:if test="${param.n % 2 != 0}">
	<h2>n은 홀수입니다</h2>
</c:if>


<%--
	그룹 조건을 사용하고 싶다면 <c:choose>를 사용한다
	- <c:when>은 원하는 개수만큼 배치가 가능하며 test로 조건식을 작성(EL)
	- <c:otherwise>는 마지막에 1개만 배치가 가능하며 나머지 경우를 처리(else)
					<c:when test=""></c:when>
					<c:when test=""></c:when>
					<c:otherwise></c:otherwise>
 --%>

<c:choose>
	<c:when test="${param.n % 2 == 0}">
		<h2>n은 짝수입니다</h2>
		</c:when>
	<c:otherwise>
		<h2>n은 홀수입니다</h2>
		</c:otherwise>
</c:choose>


<h1>JSTL을 이용한 반복 코드</h1>

<h2>list = ${list}</h2>

<%--
for(int number:list){
	System.out.println(number);
	}
 --%>

<c:forEach var="number" items="${list}">
	<h2>number = ${number}</h2>	
</c:forEach>

