<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/toastify-js/src/toastify.min.css">
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/toastify-js"></script>    
    

<h1>챗봇 예제</h1>

<button class="btn-connect">연결</button>
<button class="btn-disconnect">종료</button>

<hr>

<div class="question-wrapper"></div>
<div class="answer-wrapper"></div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.6.1/sockjs.min.js"></script>
<script type="text/javascript">
$(function(){
	$(".btn-connect").click(function(){
		//window.socket = new WebSocket("ws://localhost:8080/ws/chatbot");
		//window.socket = new SockJS("http://localhost:8080/ws/chatbot");
		//window.socket = new SockJS("/ws/chatbot");
		window.socket = new SockJS("${pageContext.request.contextPath}/ws/chatbot");
		
		//웹소켓을 생성하고나서 예상되는 각종 상황에 대해 미리 콜백함수를 정의
		//- onopen(연결완료시), onclose(연결종료시), onerror(오류발생시)
		//- onmessage(메세지수신시)
		window.socket.onmessage = function(e){
			//console.log(e.data); //서버에서 전송된 내용(문자열)
			
			var json = JSON.parse(e.data); //자바스크립트 스타일로 해석
			//console.log(json);
			
			if(Array.isArray(json)){ //배열이라면
				//json에 들어있는 데이터 개수만큼 버튼을 생성하여 추가
				$(".question-wrapper").empty();
				$(json).each(function(){
					var button = $("<button>").text(this.chatbotQuestion)
															.attr("data-no", this.chatbotNo)
															.addClass("btn-question");
					$(".question-wrapper").append(button);
				});
			}
			else{ //배열이 아니라면(객체)
				$(".answer-wrapper").text(json.chatbotAnswer);
			
				Toastify({
					  text: json.chatbotAnswer,
					  duration: 3000, //지속시간
					  //destination: "https://github.com/apvarun/toastify-js", //클릭하면 어디로갈건지!!
					  newWindow: true, //새창
					  close: true,
					  gravity: "top", // `top` or `bottom`
					  position: "right", // `left`, `center` or `right`
					  stopOnFocus: true, // Prevents dismissing of toast on hover
					  style: {
					    background: "linear-gradient(to right, #00b09b, #96c93d)",
					  },
					  onClick: function(){} // Callback after click
					}).showToast();
			}

		};
	});	
	$(".btn-disconnect").click(function(){
		window.socket.close();
	});
	
	//문서 내에 존재하는 .btn-question에 클릭 이벤트를 예약
	$(document).on("click", ".btn-question", function(){
		var chatbotNo = $(this).data("no"); //버튼에 있는 번호(data-no)추출
		window.socket.send(chatbotNo); //서버로 전송
	});
});
</script>