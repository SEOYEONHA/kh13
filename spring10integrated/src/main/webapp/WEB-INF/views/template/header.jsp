<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<%-- 
	HTML은 여러 버전이 있었으며, 지금은 HTML 5가 표준
	- 디자인과 관련된 요소를 많이 제거하고 다른 언어들과의 화합을 고려
	- 자체적으로 제공하는 컴포넌트(화면도구)를 많이 늘렸음
	
	<!DOCTYPE html> 은 HTML5 임을 표시하는 것
	
	<html> 은 HTML 문서의 범위를 정하는 태그(없으면 자동으로 생김)
	<thml> 은 <head> 와 <body> 로 나뉜다
	<head> 에는 문서의 정보를 작성하고 <body>에는 화면에 표시할 내용을 작성
	
	<meta> 는 홈페이지의 정보를 설정하는 태그
	<title> 은 문서의 제목이며 브라우저의 탭 부분에 표시됨
 --%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>나의 홈페이지</title>
		
		<!-- 구글 폰트 -->
	    <link rel="preconnect" href="https://fonts.googleapis.com">
	    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&display=swap" rel="stylesheet">
		
		<!-- 내가 구현한 스타일 -->
		<link rel="stylesheet" type="text/css" href="/css/commons.css">
		<link rel="stylesheet" type="text/css" href="/css/test.css">
		
		<!-- font awesome 아이콘 CDN -->
		<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
	</head>
	<body>
		<%--
			상단 영역
			- 홈페이지에서 가장 많이 보이는 부분
			- 로고, 검색창, 각종 메뉴들을 배치
			- div는 투명한 영역
		 --%>
		<div>
		<%-- 템플릿 페이지는 무조건 절대경로를 써야한다 --%>
			<a href="/" class="link">홈으로</a>
			<a href="/pocketmon/list" class="link">포켓몬스터 시스템</a>
			<a href="/emp/list" class="link">사원관리 시스템</a>
			<a href="/menu/list" class="link">메뉴관리 시스템</a>
			<a href="/student/list" class="link">학생관리 시스템</a>
			<a href="/board/list" class="link">자유게시판</a>
		</div>
		<%--로그인 여부에 따라 달라지는 메뉴 --%>
		<div>
			<c:choose>
				<c:when test="${sessionScope.loginId != null}">
					<a href="/member/logout" class="link">로그아웃</a>  
					<a href="/member/mypage" class="link">마이페이지</a>
					<a href="/point/charge" class="link">포인트충전</a>   
				</c:when>
				<c:otherwise>
					<a href="/member/join" class="link">회원가입</a>
					<a href="/member/login" class="link">로그인</a>
				</c:otherwise>
			</c:choose>
		</div>
		<%--관리자 메뉴 = 관리자일 경우에만 출력 --%>
		<c:if test="${sessionScope.loginLevel == '관리자'}">
		<div>
			<a href="/admin/member/search" class="link">회원관리</a>
			<a href="/admin/item/list" class="link">충전상품관리</a>
			<a href="/admin/stat/pocketmon" class="link">포켓몬통계</a>
			<a href="/admin/stat/emp" class="link">사원통계</a>
			<a href="/admin/stat/menu" class="link">메뉴통계</a>
			<a href="/admin/stat/member" class="link">회원통계</a>
		</div>
		</c:if>
		
		<div>
		<%-- 
			<c:choose>
				<c:when test="${sessionScope.loginId != null}">
					<a href="/member/testLogout">테스트로그아웃</a>
				</c:when>
				<c:otherwise>
					<a href="/member/testLogin">테스트로그인</a>
				</c:otherwise>
			</c:choose>
			--%>
			
			login = ${sessionScope.loginId != null} , 
			loginId = ${sessionScope.loginId} ,
			loginLevel = ${sessionScope.loginLevel}
		</div>
		<hr>
		<%-- 
			중단 영역
			-실질적인 홈페이지의 내용이 표시되는 영역
			- 크기는 무제한으로 늘어날 수 있음
		--%>
		<div>