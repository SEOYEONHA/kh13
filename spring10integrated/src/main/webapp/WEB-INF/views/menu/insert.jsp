<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>    
    
    <%--
    <select>를 사용하면 주어진 목록 중에서 선택시킬 수 있다
    <select name="...">
    	<option value="...">...</option>
    	<option value="...">...</option>
    	<option value="...">...</option>
    </select>
     --%>
<h1>신규 메뉴 등록</h1>
<form action="insert" method="post">
	메뉴 명(한글) <input name="menuNameKor" type="text" required><br><br>
	메뉴 명(영어) <input name="menuNameEng" type="text" required><br><br>
	메뉴 타입
	<select name= "menuType">
		<option value="">선택하세요</option>
		<option value="음료">음료</option>
		<option value="스무디">스무디</option>
		<option value="에이드">에이드</option>
		<option value="디저트">디저트</option>
		<option value="베이커리">베이커리</option>
	</select><br><br>
	메뉴 가격 <input name="menuPrice" type="number" required><br><br>
	<button>메뉴 등록</button>
</form>
<a href="list"><button>목록보기</button></a>

<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>