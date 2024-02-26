<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<%--
	컨트롤러에서 dto라는 이름으로 정보가 전달되며 없을 수 있다
	조건을 통해 있는 경우와 없는 경우를 분리하여 출력
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container w-500">
	<div class="cell center">
		<c:choose>
			<c:when test="${dto != null}">
				<div class="cell title">
					<h1>몬스터 정보</h1>	
				</div>
				<div class="cell">
					<table class="table table-border">
						<tr>
							<th width="30%">번호</th>
							<td>${dto.pocketmonNo}</td>
						</tr>
						<tr>
							<th>이름</th>
							<td>${dto.pocketmonName}</td>
						</tr>
						<tr>
							<th>속성</th>
							<td>${dto.pocketmonType}</td>
						</tr>
					</table>
				</div>
			<div class="cell center my-20">
				<%-- 다른 페이지로의 링크 --%>
				<a href="list" class="btn pink w-25">목록보기</a>&nbsp;&nbsp;
				<a href="edit?pocketmonNo=${dto.pocketmonNo}" class="btn purple w-25">수정</a>&nbsp;&nbsp;
				<a href="delete?pocketmonNo=${dto.pocketmonNo}" class="btn negative w-25 link-confirm" data-message="정말 삭제하시겠습니까?">삭제</a>
			</div>
		</c:when>
		<c:otherwise>
			<div class="cell title">
				<h1>존재하지 않는 포켓몬스터 번호</h1>
			</div>
			<div class="cell">
				<a href="list">목록보기></a>
			</div>
		</c:otherwise>
	</c:choose>
	</div>
</div>
<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>