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
		<option value="음료" ${dto.menuType == '음료' ? 'selected' : ' '}>음료</option>
		<option value="베이커리" ${dto.menuType == '베이커리' ? 'selected' : ' '}>베이커리</option>
		<option value="디저트" ${dto.menuType == '디저트' ? 'selected' : ' '}>디저트</option>
		<option value="식사" ${dto.menuType == '식사' ? 'selected' : ' '}>식사</option>
	</select><br><br>
	메뉴 가격 <input name="menuPrice" type="number" required value="${dto.menuPrice}"><br><br>
	<button>정보 수정</button>
</form><br>
<a href="list"><button>목록보기</button></a>

<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>