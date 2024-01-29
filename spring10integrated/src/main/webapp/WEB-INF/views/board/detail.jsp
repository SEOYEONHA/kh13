<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
    
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include> 


<h2 align="center">${boardDto.boardTitle}</h2>
<h4 align="right">작성자 : ${boardDto.boardWriter}    조회수 : ${boardDto.boardReadcount }</h4>
<h5 align="right">${boardDto.boardWtime}</h5>
<c:if test="${boardDto.boardEtime != null}"><h5 align="right" style="color: purple">
(수정됨) ${boardDto.boardEtime}</h5></c:if>
${boardDto.boardContent}
<br><br>

<a href="list"><button>목록보기</button></a>
<a href="edit?boardNo=${boardDto.boardNo}"><button>수정하기</button></a>
<a href="delete?boardNo=${boardDto.boardNo}"><button>삭제하기</button></a> 
<a href="wirte"><button>새 게시글 작성하기</button></a> 




<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>