<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
    
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<style>
    .temp{
        word-break: break-all;
        white-space: pre-line;
        valign="top"
    }
   	.reply-list-wrapper > .reply-item {
	padding-bottom:10px;
	margin-bottom: 10px;
	border-bottom: 1px solid #b2bec3;
	}
</style>

<script type="text/template" id="reply-item-wrapper">
	<div class="reply-item">
		<h3>
			<span class="reply-writer">
				작성자
			</span>
			<i class="fa-solid fa-edit blue ms-20 btn-reply-edit"></i>
			<i class="fa-solid fa-trash red btn-reply-delete"></i>
		</h3>
		<pre class="reply-content">댓글 내용</pre>
		<div class="reply-time">yyyy-MM-dd HH:mm:ss</div>
	</div>
</script>

<script type="text/javascript">
$(function(){
	//파라미터에서 게시글 번호를 읽는다
	var params = new URLSearchParams(location.search);
	var boardNo = params.get("boardNo");
	
	//페이지 로딩 완료 시 댓글 목록을 불러와서 출력
	$.ajax({
		url : "/rest/reply/list", 
		method : "post", 
		data : { replyOrigin : boardNo }, 
		success : function(response) { 
			//댓글 개수를 표시
			$(".reply-count").text(response.length);
			
			//response는 List<ReplyDto>형태
			for(var i=0 ; i < response.length ; i++) {
				//template 불러오고
				var templateText = $("#reply-item-wrapper").text();
				var templateHtml = $.parseHTML(templateText);
				
				//청보출력
				$(templateHtml).find(".reply-writer").text(response[i].replyWriter);
				$(templateHtml).find(".reply-content").text(response[i].replyContent);
				$(templateHtml).find(".reply-time").text(response[i].replyTime);
				
				//화면에 추가
				$(".reply-list-wrapper").append(templateHtml);
			}
		}
	});
	
	//문서에 댓글 삭제 이벤트 등록
	//- 화면을 지우는 것이 아니라 서버에 지워달라고 요청
	//- 삭제가 완료되면 화면을 직접 지우지 말고 목록을 다시 불러온다
	$(document).on("click", ".btn-reply-delete", function(){
		
	});
	
	//문서에 댓글 수정 이벤트 등록
	$(document).on("click", ".btn-reply-edit", function(){});
	$(document).on("click", ".btn-reply-save", function(){});
	$(document).on("click", ".btn-reply-cancel", function(){});
});
</script>


<c:if test="${sessionScope.loginId != null}">
<script type="text/javascript">
	//좋아요 하트 클릭 이벤트
	$(function(){
		//(주의) 아무리 같은 페이지라도 서로 다른언어를 혼용하지 말것
		//- 자바스크립트에서 파라미터를 읽어 번호를 추출
		var params = new URLSearchParams(location.search);
		var boardNo = params.get("boardNo");
		
		//목표 : 하트를 클릭하면 좋아요 갱신처리
		$(".board-like").find(".fa-heart").click(function(){
			$.ajax({
				url : "/rest/board_like/toggle",//같은 서버이므로 앞 경로 생략
				method : "post",
				data : { boardNo : boardNo },
				success : function(response){
					//console.log(response);
					
					//response.state에 따라서 하트의 형태를 설정
					$(".board-like").find(".fa-heart")
						.removeClass("fa-solid fa-regular")
						.addClass(response.state ? "fa-solid" : "fa-regular");
					
					//response.count에 따라서 좋아요 개수를 표시
					$(".board-like").find(".count").text(response.count);
				}
			});
		});
	});
</script>
</c:if>
<script type="text/javascript">
	//좋아요 최초 불러오기
	$(function(){
		//(주의) 아무리 같은 페이지라도 서로 다른언어를 혼용하지 말것
		//- 자바스크립트에서 파라미터를 읽어 번호를 추출
		var params = new URLSearchParams(location.search);
		var boardNo = params.get("boardNo");
		
		//최초에 표시될 화면을 위해 화면이 로딩되자마자 서버로 비동기통신 시도
		$.ajax({
			url : "/rest/board_like/check",
			method : "post",
			data : { boardNo : boardNo },
			success: function(response) {
				//response.state에 따라서 하트의 형태를 설정
				$(".board-like").find(".fa-heart")
					.removeClass("fa-solid fa-regular")
					.addClass(response.state ? "fa-solid" : "fa-regular");
				
				//response.count에 따라서 좋아요 개수를 표시
				$(".board-like").find(".count").text(response.count);
			}
		});
	});
</script>



<div class="container w-1100">
	<div class="cell center">
		<h1>${detailDto.boardTitle}</h1>
	</div>
	<div class="cell floating-cell mx-10">
		<div class="cell w-50 left">
			<span>
				<fmt:formatDate value="${detailDto.boardWtime}" 
					pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate> (${detailDto.boardWtimeDiff})
					<c:if test="${detailDto.boardEtime != null}">
						(수정됨)<fmt:formatDate value="${detailDto.boardEtime}" 
							pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>
					</c:if>
					<span> | </span>
				<c:choose>
					<c:when test="${detailDto.boardWriter == null}">
						${boardDto.boardWriterStr}
					</c:when>
					<c:otherwise>
						(${memberDto.memberLevel}) ${memberDto.memberNick}
					</c:otherwise>
				</c:choose>
			</span>
		</div>
		<div class="cell w-50 right">
			<span>조회수 ${detailDto.boardReadcount}</span><span> | 댓글</span>
			<span class="reply-count">0</span><span> | </span>
			<span class="board-like red">
			<i class="fa-regular fa-heart"></i>
			<span class="count">?</span>
		</span>
		</div>
	</div>
	<hr>
	<div class="cell w-1000 mx-50 temp">
		<span>${detailDto.boardContent}</span>
	</div>
	<hr>
	<div class="cell center">
		<a href="write?boardTarget=${detailDto.boardNo}" class="btn">답글쓰기</a>
		<a href="list" class="btn pink">목록보기</a>
	
		<%-- 
			수정과 삭제 링크는 회원이면서 본인글이거나 관리자일 경우만 출력 
			- 본인글이란 로그인한 사용자 아이디와 게시글 작성자가 같은 경우
			- 관리자란 로그인한 사용자 등급이 '관리자'인 경우	
		--%>
		<c:if test="${sessionScope.loginId != null && (sessionScope.loginId == detailDto.boardWriter || sessionScope.loginLevel == '관리자')}">
			<a href="edit?boardNo=${detailDto.boardNo}" class="btn purple">수정하기</a>
			<a href="delete?boardNo=${detailDto.boardNo}" class="btn negative">삭제하기</a>
		</c:if>
		<a href="write" class="btn positive">새 게시글 작성하기</a> 
	</div>
	
		<!-- 댓글 작성창 + 댓글 목록 -->
	<div class="cell reply-list-wrapper"></div>
	<div class="cell">
		댓글작성창
	</div>
	
</div> 














<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>