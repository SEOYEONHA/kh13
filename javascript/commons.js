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

/*
    전체선택 체크박스에 대한 이벤트 구현
    - .check-all은 전체 선택 체크박스
    - .check-item은 개별 항목 체크박스
    - jquery에서는 태그의 속성을 .props() 명령으로 제어 또는 확인
*/
$(function(){
    //전체선택 체크박스에 입력이 발생하면 확인하여 개별 항목에 반영
    // $(".check-all").on("input", function(){});
    $(".check-all").change(function(){
            var checked = $(this).prop("checked"); //jQuery
        //  console.log(checked);

        $(".check-item").prop("checked", checked); //개별항목 체크변경
        $(".check-all").prop("checked", checked); //전체항목 체크변경
    });

    $(".check-item").change(function(){
        //총 ?개 중 ?개가 선택되었는지를 파악하여 처리
        var countAll = $(".check-item").length;
        var countChecked = $(".check-item:checked").length;

        var allChecked = countAll == countChecked;

        $(".check-all").prop("checked", allChecked);
    });
});