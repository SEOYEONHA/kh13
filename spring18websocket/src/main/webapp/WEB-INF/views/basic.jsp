<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<h1>Basic 웹소켓 예제</h1>


<button class="btn-connect">연결</button>
<button class="btn-disconnect">종료</button>

<!-- JS 처리 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	//연결 버튼을 누르면 웹소켓 생성, 종료 버튼을 누르면 웹소켓 소멸
	$(".btn-connect").click(function(){
		//var socket = new WebSocket("연결주소"); //자바스크립트 내장 API
		window.socket = new WebSocket("ws://localhost:8080/ws/basic");
	});
	$(".btn-disconnect").click(function(){
		window.socket.close();
	});
});
</script>

