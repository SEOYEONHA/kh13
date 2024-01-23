<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>


<h1>메뉴 정보 수정</h1>

<form action="change" method="post">
	<input type="hidden" name="menuNo" required value="${dto.menuNo}">
	메뉴 명(한글) <input name="menuNameKor" type="text" required value="${dto.menuNameKor}"><br><br>
	메뉴 명(영어) <input name="menuNameEng" type="text" required value="${dto.menuNameEng}"><br><br>
	메뉴 타입
	<select name= "menuType">
		<option value="${dto.menuType}">${dto.menuType}</option>
		<option value="커피">커피</option>
		<option value="스무디">스무디</option>
		<option value="에이드">에이드</option>
		<option value="디저트">디저트</option>
	</select><br><br>
	메뉴 가격 <input name="menuPrice" type="number" required value="${dto.menuPrice}"><br><br>
	<button>정보 수정</button>
</form>

<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>