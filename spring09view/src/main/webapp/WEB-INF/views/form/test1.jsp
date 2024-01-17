<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h1>폼 예제</h1>

<%--
	<form>
	- 정보를 제출하기 위한 도구 모음(주소를 생성하는 도구)
	- 화면에 보이지 않음
	- action 속성으로 제출할 대상을 설정할 수 있다
	
	<input>
	- 입력을 위한 도구
	- 입력한 값이 전송될 때 파라미터의 이름을 name 속성으로 설정
	
	<button>
	- 폼을 전송시키는 도구
--%>
<img width="500" src="/bg.jpg">
<h1>지니뮤직 검색창</h1>
<form action="https://www.genie.co.kr/search/searchMain">
	<input name="query">
	<button><img width="15" src="/logo/glass2.png"></button>
</form>

<h1>네이버 검색창</h1>
<form action="https://search.naver.com/search.naver">
	<input name="query">
	<button><img width="15" src="/logo/glass2.png"></button>
</form>

<h1>구글 검색창</h1>
<form action="https://www.google.com/search">
	<input name="q">
	<button><img width="15" src="/logo/glass2.png"></button>
</form>
