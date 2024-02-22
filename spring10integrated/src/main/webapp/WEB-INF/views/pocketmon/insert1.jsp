<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>    
    


<script type="text/javascript">

    function checkPocketmonNo() {
        //입력
        var inputTarget = document.querySelector("input[name=pocketmonNo]");
        var pocketmonNo = inputTarget.value;

        //검사
        var regex = /^[1-9][0-9]{1,3}$/;
        var isValid = regex.test(pocketmonNo);

        //출력
        inputTarget.classList.remove("success", "fail", "fail2");

        if(isValid) {
            inputTarget.classList.add("success");
            return true;
        }
        else if(!pocketmonNo) {
            inputTarget.classList.add("fail2");
            return false;
        }
        else {
            inputTarget.classList.add("fail");
            return false;
        }
    }

    function checkPocketmonName() {
        //입력
        var inputTarget = document.querySelector("input[name=pocketmonName]");
        var pocketmonName = inputTarget.value;

        //검사
        var regex = /^[가-힣]{1,10}$/;
        var isValid = regex.test(pocketmonName);

        //출력
        inputTarget.classList.remove("success", "fail", "fail2");

        if(isValid) {
            inputTarget.classList.add("success");
            return true;
        }
        else if(!pocketmonName) {
            inputTarget.classList.add("fail2");
            return false;
        }
        else {
            inputTarget.classList.add("fail");
            return false;
        }
    }

    function checkPocketmonType() {
        //입력
        var inputTarget = document.querySelector("input[name=pocketmonType]");
        var pocketmonType = inputTarget.value;

        //검사
        var regex = /^[가-힣]{1,3}$/;
        var isValid = regex.test(pocketmonType);

        //출력
        inputTarget.classList.remove("success", "fail", "fail2");

        if(isValid) {
            inputTarget.classList.add("success");
            return true;
        }
        else if(!pocketmonType) {
            inputTarget.classList.add("fail2");
            return false;
        }
        else {
            inputTarget.classList.add("fail");
            return false;
        }
    }

    function checkForm() {
    var noValid = checkPocketmonNo();
    var nameValid = checkPocketmonName();
    var typeValid = checkPocketmonType();

    return noValid && nameValid && typeValid;
}

</script>

    
	
	<%--
		생성해야하는 주소 형태
		http://localhos:8080/pocketmon/insert2
		?pocketmonNo=1&pocketmonName=피카츄&pocketmonType=전기
		
		폼(절대경로)
		<form action="/pocketmon/insert2">
		
		폼(상대경로)
		<form action="insert2">
	--%>
	
<div class="container w-400">
    <div class="cell center title">
        <h1>
            <img src="/image/pokemon.png" width="25">
                포켓몬스터 등록
            <img src="/image/pokemon.png" width="25">
        </h1>
    </div>
    <div class="cell">
        <form autocomplete="off" action="insert" method="get"
                onsubmit="return checkForm();">

            <div class="cell">
                <label>
                    번호
                    <i class="fa-solid fa-asterisk red"></i>
                </label>
                <input name="pocketmonNo" class="tool w-100" onblur="checkPocketmonNo();" placeholder="(ex) 1">
				<div class="success-feedback"></div>
                <div class="fail-feedback">포켓몬 번호는 숫자만 입력 가능합니다</div>
                <div class="fail2-feedback">포켓몬 번호를 반드시 입력해주세요</div>
               </div>

                <div class="cell">
                   <label>
                     	이름
                  		<i class="fa-solid fa-asterisk red"></i>
                  </label>
                  <input name="pocketmonName" class="tool w-100" onblur="checkPocketmonName();" placeholder="(ex) 이상해씨">
                  <div class="success-feedback"></div>
                  <div class="fail-feedback">포켓몬 이름은 한글 10자까지 입력 가능합니다.</div>
                  <div class="fail2-feedback">포켓몬 이름을 반드시 입력해주세요</div>
                </div>

                <div class="cell">
                    <label>
                        속성
                        <i class="fa-solid fa-asterisk red"></i>
                    </label>
                    <input name="pocketmonType" class="tool w-100" onblur="checkPocketmonType();" placeholder="(ex) 풀">
                    <div class="success-feedback"></div>
                    <div class="fail-feedback">포켓몬 속성은 한글 3자까지 입력 가능합니다</div>
                    <div class="fail2-feedback">포켓몬 속성을 반드시 입력해주세요</div>
                </div>

            <hr class="my-20">

            <div class="cell center">
                <button class="btn positive w-100">
                    <i class="fa-solid fa-ghost"></i>
                    등록하기
                </button>
            </div>
            <hr class="my-20">
            <div class="cell center">
                <a href="list" class="btn pink w-100">
                    <i class="fa-solid fa-list"></i>
                    목록보기
                </a>
            </div>
        </form>
    </div>
</div>

<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>