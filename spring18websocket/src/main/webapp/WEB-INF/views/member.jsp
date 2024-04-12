<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/toastify-js/src/toastify.min.css">
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/toastify-js"></script>
    

<h1>회원전용 채팅 예제</h1>

<h2>로그인 상태 : ${sessionScope.loginId != null}</h2>
<h2>아이디 : ${sessionScope.loginId}, 등급 : ${sessionScope.loginLevel}</h2>



<input type="text" class="text-input" placeholder="메세지 작성">
<button class="btn-send">전송</button>

<div class="chat-wrapper"></div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.6.1/sockjs.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.30.1/moment.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.30.1/locale/ko.min.js"></script>
<script type="text/javascript">
$(function(){
	//시작하자마자 웹소켓 서버에 연결
	window.socket = new SockJS("${pageContext.request.contextPath}/ws/member");
		
	//연결 완료 시 해야할 작업들을 "콜백 함수"로 설정
	window.socket.onmessage = function(e){
		var obj = JSON.parse(e.data); //전송된 문자열을 객체로 변환
		//obj는 ChatResponseVO와 동일한 구조를 가진다
		
		//시간 제어 라이브러리인 moment를 사용하여 시간 형식을 변경
		//var time = moment(obj.time).fromNow(); //현재시간 기준
		//var time = moment(obj.time).format("HH:mm"); //형식지정
		var time = moment(obj.time).format("a h:mm"); //형식지정(오전 오후)
		var area = $("<div>").append(obj.memberId)
										.append("(" + obj.memberLevel + ")")
										.append("<br>")
										.append(obj.content)
										.append("<br>")
										.append(time);
		$(".chat-wrapper").append(area);
	};
	
	//전송버튼을 누르면 입력한 메세지가 있는 경우 서버에 전송
	$(".btn-send").click(function(){
		var text = $(".text-input").val(); //입력창의 입력값을 불러온다
		if(text.length == 0) return; //입력값이 없으면 중지한다
		
		//서버에서 이해할 수 있는 형태로 객체를 생성
		var data = {
			content: text
		};
		
		var json = JSON.stringify(data); //data를 JSON 문자열로 변환
		
		window.socket.send(json); //서버로 입력값을 전송한다
		$(".text-input").val(""); //입력창의 입력값을 삭제한다
	});
});
</script>