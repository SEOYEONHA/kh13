<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
    
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include> 


<h2 align="center">${detailDto.boardTitle}</h2>
<h4 align="right">작성자 : ${detailDto.boardWriter}    조회수 : ${detailDto.boardReadcount }</h4>
<h5 align="right">${detailDto.boardWtime}</h5>
<c:if test="${detailDto.boardEtime != null}"><h5 align="right" style="color: purple">
(수정됨) ${detailDto.boardEtime}</h5></c:if>
${detailDto.boardContent}
<br><br>

<a href="list"><button>목록보기</button></a>
<a href="write"><button>새 게시글 작성하기</button></a> 




<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>