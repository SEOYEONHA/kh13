<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h1>포켓몬스터 정보 수정</h1>

<form action="edit" method="post">
	번호 <input type="number" name="pocketmonNo"> <br><br>
	이름 <input type="text" name="pocketmonName"><br><br>
	속성 <input type="text" name="pocketmonType"><br><br>
	<button>정보 수정</button>
</form>