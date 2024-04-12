<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/toastify-js/src/toastify.min.css">
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/toastify-js"></script>    
    

<h1>그룹채팅 예제</h1>

<button class="btn-connect">연결</button>
<button class="btn-disconnect">종료</button>

<hr>

<input type="text" class="text-input" placeholder="메세지 작성">
<button class="btn-send">전송</button>

<div class="chat-wrapper"></div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.6.1/sockjs.min.js"></script>
<script type="text/javascript">
$(function(){
	$(".btn-connect").click(function(){
		window.socket = new SockJS("${pageContext.request.contextPath}/ws/group");
		
		//연결 완료 시 해야할 작업들을 "콜백 함수"로 설정
		window.socket.onmessage = function(e){
			var area = $("<div>").text(e.data);
			$(".chat-wrapper").append(area);
		}
	});	
	$(".btn-disconnect").click(function(){
		window.socket.close();
	});
	
	//전송버튼을 누르면 입력한 메세지가 있는 경우 서버에 전송
	$(".btn-send").click(function(){
		var text = $(".text-input").val(); //입력창의 입력값을 불러온다
		if(text.length == 0) return; //입력값이 없으면 중지한다
		
		window.socket.send(text); //서버로 입력값을 전송한다
		$(".text-input").val(""); //입력창의 입력값을 삭제한다
	});
});
</script>