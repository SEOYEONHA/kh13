<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%--
	A(Anchor)태그
	- 하이퍼링크를 생성하는 태그
	- href 속성으로 이동할 위치를 설정
	- 영역을 제외한 실체가 있는 대상(글자, 이미지, 버튼)에 설정하여 이동하도록 처리가 가능
--%>

<h1>하이퍼링크 예제</h1>

<a href="https://www.naver.com/">네이버로 이동</a>
<br>
<a href="https://www.google.com/">구글로 이동</a>

<h2><a href="https://kh-academy.co.kr/main/main.kh">KH정보교육원 홈페이지</a></h2>
<br>

<%-- (Q) 네이버 이미지를 누르면 네이버로 이동하도록 구현 --%>
<a href="https://www.naver.com/">
	<img alt="네이버 로고" width="100" height="100" src="/logo/naver.png">
</a>

<br>
<h2><a href="home">첫 번째 예제 보기</a></h2>
<h2><a href="/home">첫 번째 예제 보기</a></h2>
<h2><a href="dummy">더미이미지 예제 보기</a></h2>
<h2><a href="/dummy">더미이미지 예제 보기</a></h2>