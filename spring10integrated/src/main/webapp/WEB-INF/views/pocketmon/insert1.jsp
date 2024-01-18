<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>포켓몬스터 등록</h1>

<%--
	생성해야하는 주소 형태
	http://localhos:8080/pocketmon/insert2
	?pocketmonNo=1&pocketmonName=피카츄&pocketmonType=전기
	
	폼(절대경로)
	<form action="/pocketmon/insert2">
	
	폼(상대경로)
	<form action="insert2">
--%>

<form action="insert2">
	번호 : <input name="pocketmonNo"><br><br>
	이름 : <input name="pocketmonName"><br><br>
	속성 : <input name="pocketmonType"><br><br>
	<button>등록</button>
</form>