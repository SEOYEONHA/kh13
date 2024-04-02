<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h1>현재 로그인 상태 : ${sessionScope.loginId != null}</h1>

<h2><a href="join">회원가입</a></h2>
<h2><a href="login">로그인</a></h2>
<h2><a href="logout">로그아웃</a></h2>