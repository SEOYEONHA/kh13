<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%--
	EL(Expression Language, 표현 언어)
	- 컨트롤러에서 전달된 값을 화면에 인쇄하는 출력언어
	- 컨트롤러 뿐 아니라 서버의 여러 다른 값들도 출력 가능
	- ${이름} 형식으로 출력(입력 또는 설정은 불가능 : 오로지 출력만 가능)
	- 사용자가 보는 결과화면에서 확인할 수 없다(만드는 과정에서 사용)
	- null을 화면에 출력하지 않고 공백으로 처리한다
	- JSP 에서만 사용이 가능하다(다른형식에서는 사용불가)
 --%>
<h1>EL 출력 예제</h1>

<h2>a = ${requestScope.a}</h2>
<h2>a = ${a}</h2>
<h2 ${b}>b 출력</h2>
<h2>c = ${c}</h2>
<h2>d = ${d}</h2>