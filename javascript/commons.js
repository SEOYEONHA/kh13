/*
사용자에게 물어보고 확인을 누르면 이동하는 링크 구현
메세지는 설정할 수도 있고 하지 않을 수도 있으며, 하지 않은 경우 기본메세지 출력

- a태그에 .link-confirm을 추가하면 기본메세지가 출력되는 확인 링크가 생성
- 생성한 태그에 data-message 속성을 추가하여 확인창의 멘트를 설정
*/
$(function(){
    $("a.link-confirm").click(function(){
        var message = $(this).data("message");
        if(message == undefined) { //메세지가 없으면
            message = "정말 이동하시겠습니까?";
        }
        var choice = window.confirm(message);

        return choice;
        //return true; //통과
        // return false; //차단
    });
});
