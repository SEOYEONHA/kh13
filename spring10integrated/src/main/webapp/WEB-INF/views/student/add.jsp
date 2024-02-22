<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include> 

<script type="text/javascript">
    function checkName() {
        var inputTarget = document.querySelector("[name=name]");
        var studentName = inputTarget.value;

        //한글이름인지 검사    
        var regex = /^[가-힣]{2,7}$/;
        var isValid = regex.test(studentName);

        inputTarget.classList.remove("success", "fail", "fail2");

        if(isValid) {
            inputTarget.classList.add("success");
            return true;
        }
        else if(!studentName) {
            inputTarget.classList.add("fail2");
            return false;
        }
        else {
            inputTarget.classList.add("fail");
            return false;
        }
    }
    function checkKorean() {
        var inputTarget = document.querySelector("[name=koreanScore]");
        // var koreanScore = inputTarget.value;

        var regex = /^([1-9]?[0-9]|100)$/;
        var isValid = regex.test(inputTarget.value);

        inputTarget.classList.remove("success", "fail", "fail2");

        if(isValid) {
            inputTarget.classList.add("success");
            return true;
        }
        else if(!inputTarget.value) {
            inputTarget.classList.add("fail2");
            return false;
        }
        else {
            inputTarget.classList.add("fail");
            return false;
        }
    }
    function checkMath() {
        var inputTarget = document.querySelector("[name=mathScore]");

        var regex = /^([1-9]?[0-9]|100)$/;
        var isValid = regex.test(inputTarget.value);

        inputTarget.classList.remove("success", "fail", "fail2");

        if(isValid) {
            inputTarget.classList.add("success");
            return true;
        }
        else if(!inputTarget.value) {
            inputTarget.classList.add("fail2");
            return false;
        }
        else {
            inputTarget.classList.add("fail");
            return false;
        }
    }
    function checkEnglish() {
        var inputTarget = document.querySelector("[name=englishScore]");

        var regex = /^([1-9]?[0-9]|100)$/;
        var isValid = regex.test(inputTarget.value);

        inputTarget.classList.remove("success", "fail", "fail2");

        if(isValid) {
            inputTarget.classList.add("success");
            return true;
        }
        else if(!inputTarget.value) {
            inputTarget.classList.add("fail2");
            return false;
        }
        else {
            inputTarget.classList.add("fail");
            return false;
        }
    }




    function checkForm() {
        var isValid1 = checkName();
        var isValid2 = checkKorean();
        var isValid3 = checkMath();
        var isValid4 = checkEnglish();
        return isValid1 && isValid2 && isValid3 && isValid4;
    }

</script>




<div class="container w-400">
    <div class="cell center">
        <h1>
            <i class="fa-solid fa-user pink"></i>
            학생 등록
            <i class="fa-solid fa-user pink"></i>
        </h1>
    </div>
    <div class="cell">
        <form action="add" method="post" autocomplete="off" onsubmit="return checkForm();">
            <div class="cell">
                <label>
                    이름
                    <i class="fa-solid fa-asterisk red"></i>
                </label>
                <input type="text" name="name" class="tool w-100" placeholder="(ex)홍길동" onblur="checkName();">
                <div class="success-feedback"></div>
                <div class="fail-feedback">이름은 한글 2~7자까지 입력 가능합니다</div>
                <div class="fail2-feedback">이름을 반드시 작성하세요</div>
            </div>
            <div class="cell">
                <label>
                    국어점수
                    <i class="fa-solid fa-asterisk red"></i>
                </label>
                <input type="text" name="koreanScore" class="tool w-100" onblur="checkKorean();">
                <div class="success-feedback"></div>
                <div class="fail-feedback">점수는 숫자만 0~100까지 입력가능합니다</div>
                <div class="fail2-feedback">국어점수를 반드시 작성하세요</div>
            </div>
            </div>
            <div class="cell">
                <label>
                    수학점수 
                    <i class="fa-solid fa-asterisk red"></i>
                </label>
                <input type="text" name="mathScore" class="tool w-100" onblur="checkMath();">
                <div class="success-feedback"></div>
                <div class="fail-feedback">점수는 숫자만 0~100까지 입력가능합니다</div>
                <div class="fail2-feedback">영어점수를 반드시 작성하세요</div>
            </div>
            <div class="cell">
                <label>
                    영어점수
                    <i class="fa-solid fa-asterisk red"></i>
                </label>
                <input type="text" name="englishScore" class="tool w-100" onblur="checkEnglish();">
                <div class="success-feedback"></div>
                <div class="fail-feedback">점수는 숫자만 0~100까지 입력가능합니다</div>
                <div class="fail2-feedback">영어점수를 반드시 작성하세요</div>
            </div>
            <div class="cell">
                <button class="btn positive w-100">
                    <i class="fa-solid fa-plus"></i>
                    학생등록
                </button>
            </div>
        </form>
        <hr class="my-20">
        
        <div class="cell">
            <a href="list" class="btn pink w-100">
                <i class="fa-solid fa-list"></i>
                목록보기
            </a>
        </div>
    </div>
</div>

<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>   