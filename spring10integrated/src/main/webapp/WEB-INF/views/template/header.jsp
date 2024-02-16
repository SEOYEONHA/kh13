<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
	HTML은 여러 버전이 있었으며, 지금은 HTML 5가 표준
	- 디자인과 관련된 요소를 많이 제거하고 다른 언어들과의 화합을 고려
	- 자체적으로 제공하는 컴포넌트(화면도구)를 많이 늘렸음
	
	<!DOCTYPE html> 은 HTML5 임을 표시하는 것
	
	<html> 은 HTML 문서의 범위를 정하는 태그(없으면 자동으로 생김)
	<html> 은 <head>와 <body>로 나뉜다
	<head> 에는 문서의 정보를 작성하고 <body>에는 화면에 표시할 내용을 작성
	
	<meta>는 홈페이지의 정보를 설정하는 태그
	<title>은 문서의 제목이며 브라우저의 탭 부분에 표시됨
 --%>    
 
 <!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>나의 홈페이지</title>

    <!-- 구글 폰트 -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&display=swap" rel="stylesheet">

    <!-- 내가 구현한 스타일 -->
    <link rel="stylesheet" type="text/css" href="/css/commons.css">
    <link rel="stylesheet" type="text/css" href="/css/test.css">
    <link rel="stylesheet" type="text/css" href="/css/layout.css">

    <!-- font awesome 아이콘 CDN -->
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
    
    <style>
    </style>
</head>
<body>
    
    <main>
        <div class="header">
            <h1 class="center">KH정보교육원</h1>            
        </div>
        <div class="nav">
			<ul class="menu">
				<li>
					<a href="/">
						<i class="fa-solid fa-house"></i>
						HOME
					</a>
				</li>
			
		        <li>
		            <a href="#">
		            <i class="fa-regular fa-floppy-disk"></i> 
		            데이터관리</a>
		            <ul>
		                <li><a href="/pocketmon/list">
		                	<i class="fa-solid fa-ghost"></i>
		                	포켓몬스터</a></li>
		                <li><a href="/emp/list">
		                	<i class="fa-solid fa-user-tie"></i>
		                	사원정보</a></li>
		                <li><a href="/menu/list">
			                <i class="fa-solid fa-mug-saucer"></i>
			                메뉴정보</a></li>
		                <li><a href="/student/list">
			                <i class="fa-solid fa-school"></i>
			                학생성적</a></li>
		            </ul>
		        </li>
		        
		        <li><a href="/board/list">
		        <i class="fa-solid fa-table"></i> 자유게시판</a></li>
		        
		        <%-- 관리자 메뉴는 관리자에게만 출력 --%>
		        <c:if test="${sessionScope.loginLevel == '관리자'}">
		        <li>
		            <a href="#">
		            <i class="fa-solid fa-hammer"></i>
		            관리자메뉴</a>
		            <ul>
		                <li><a href="/admin/member/search">회원관리</a></li>
		                <li><a href="/admin/item/list">충전상품관리</a></li>
		                <li>
		                    <a href="#">통계</a>
		                    <ul>
		                        <li><a href="/admin/stat/pocketmon">포켓몬통계</a></li>
		                        <li><a href="/admin/stat/emp">사원통계</a></li>
		                        <li><a href="/admin/stat/menu">메뉴통계</a></li>
		                        <li><a href="/admin/stat/member">회원통계</a></li>
		                    </ul>
		                </li>
		            </ul>
		        </li>
		        </c:if>
		        
		        <li class="menu-end">
		        	<c:choose>
						<c:when test="${sessionScope.loginId != null}">
							<a href="/member/mypage">
								<i class="fa-solid fa-user"></i>
								${sessionScope.loginId}
							</a>
				            <ul>
				                <li><a href="/point/charge">
				                <i class="fa-solid fa-coins"></i> 
				                포인트충전</a></li>
				                <li><a href="/member/logout">
				                <i class="fa-solid fa-arrow-right-from-bracket"></i>
				                로그아웃</a></li>
				            </ul>
						</c:when>
						<c:otherwise>
							<a href="/member/login">
							<i class="fa-regular fa-user"></i>
							로그인</a>
				            <ul>
				                <li><a href="/member/join">
				                <i class="fa-solid fa-user-plus"></i>
				                회원가입</a></li>
				            </ul>
						</c:otherwise>
					</c:choose>
		        </li>
		    </ul>
		</div>
        <div class="section">
<!--             <div class="aside"></div> -->
            <div class="article">
