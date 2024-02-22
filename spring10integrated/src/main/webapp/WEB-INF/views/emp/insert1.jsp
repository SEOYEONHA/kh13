<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>


        <script type="text/javascript">

            function checkEmpName() {
                var inputTarget = document.querySelector("[name=empName]");
                var empName = inputTarget.value;

                var regex = /^[가-힣]{2,7}$/;
                var isValid = regex.test(empName);

                inputTarget.classList.remove("success", "fail", "fail2");
                
                if(isValid) {
                    inputTarget.classList.add("success");
                    return true;
                }
                else if(!empName) {
                    inputTarget.classList.add("fail2");
                    return false;
                }
                else {
                    inputTarget.classList.add("fail");
                    return false;
                }

            return isValid;
            }
            function checkEmpDept() {
                var inputTarget = document.querySelector("[name=empDept]");
                var empDept = inputTarget.value;

                //var regex = /^[가-힣a-zA-Z0-9]+$/; //아무거나
                var isValid = empDept.length > 0;

                inputTarget.classList.remove("success", "fail");
                inputTarget.classList.add(isValid ? "success" : "fail");
                return isValid;
            }
            function checkEmpDate() {
                var inputTarget = document.querySelector("[name=empDate]");
                // var empDate = inputTarget.value;


                //날짜형식인지 검사
                var regex = /^(19[0-9]{2}|20[0-9]{2})-(02-(0[1-9]|1[0-9]|2[0-8])|(0[469]|11)-(0[1-9]|1[0-9]|2[0-9]|30)|(0[13578]|1[02])-(0[1-9]|1[0-9]|2[0-9]|3[01]))$/;
                var isValid = regex.test(inputTarget.value);

                inputTarget.classList.remove("success", "fail");
                inputTarget.classList.add(isValid ? "success" : "fail");
                return isValid;

            }
            function checkEmpSal() {
                var inputTarget = document.querySelector("[name=empSal]");

                 //숫자인지 검사
                var regex = /^[0-9]+$/;
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

            // function checkForm() {
            //     var nameVaild = checkEmpName();
            //     var deptValid = checkEmpDept();
            //     var dateValid = checkEmpDate();
            //     var salValid = checkEmpSal();

            //     return nameVaild && deptValid && dateValid && salValid;
            // }

            function checkForm() {
                var isValid1 = checkEmpName();
                var isValid2 = checkEmpDept();
                var isValid3 = checkEmpDate();
                var isValid4 = checkEmpSal();
                return isValid1 && isValid2 && isValid3 && isValid4;
            }
        
        
        
        </script>



    <%--
    	절대경로
    	<form action="/emp/insert2"></form>
    	
    	상대경로
    	<form action="insert2"></form>
     --%>

<!-- <h1>사원 등록</h1>
<form action="insert" method="post">
	사원명 <input name="empName" type="text"><br><br>
	부서명 <input name="empDept" type="text"><br><br>
	입사일 <input name="empDate" type="date"><br><br>
	급여액 <input name="empSal" type="text"><br><br>
	<button>사원 등록</button>
</form> -->


<div class="container w-400">
    <div class="cell center">
    	<div class="cell">
			<c:if test="${param.error != null}">
				<h4 style="color:red">수정 실패</h4>
			</c:if>
		</div>
        <h1 class="center">
            <i class="fa-solid fa-user-tie pink"></i>
            사원 등록
            <i class="fa-solid fa-user-tie pink"></i>
        </h1>
    </div>
    <div class="cell">
        <form action="https://google.com" method="get" autocomplete="off" onsubmit="return checkForm();">
           
            <div class="cell">
                <label>
                    사원명
                    <i class="fa-solid fa-asterisk red"></i>
                </label>
                <input type="text" name="empName" class="tool w-100" placeholder="(ex) 홍길동" onblur="checkEmpName();">
                <div class="success-feedback"></div>
                <div class="fail-feedback">이름은 한글 2~7자까지 입력 가능합니다</div>
                <div class="fail2-feedback">이름을 반드시 작성하세요</div>
            </div>

            <div class="cell">
                <label>
                    부서명
                    <i class="fa-solid fa-asterisk red"></i>
                </label>
                <select name="empDept" class="tool w-100" oninput="checkEmpDept();">
                    <option value="">선택하세요</option>
                    <option value="인사부">인사부</option>
                    <option value="개발부">개발부</option>
                    <option value="마케팅부">마케팅부</option>
                    <option value="영업부">영업부</option>
                </select>
                <div class="success-feedback"></div>
                <div class="fail-feedback">부서를 반드시 선택하세요</div>
            </div>

            <div class="cell">
                <label>
                    입사일
                    <i class="fa-solid fa-asterisk red"></i>
                </label>
                <input type="date" name="empDate" class="tool w-100" onblur="checkempDate();">
                <div class="success-feedback"></div>
                <div class="fail-feedback">입사일을 반드시 작성하세요</div>
            </div>

            <div class="cell">
                <label>
                    급여액
                    <i class="fa-solid fa-asterisk red"></i>
                </label>
                <input type="text" name="empSal" class="tool w-100 right" placeholder="(ex)2000000" onblur="checkEmpSal();">
                <div class="success-feedback"></div>
                <div class="fail-feedback">급여는 숫자만 입력 가능합니다</div>
                <div class="fail2-feedback">급여액을 반드시 작성하세요</div>
            </div>

            <div class="cell center">
                <button class="btn positive w-100">
                    <i class="fa-solid fa-plus"></i>
                    등록하기
                </button>
            </div>
            <hr class="my-20">
        </form>
        <div class="cell center">
            <a href="https://google.com" class="btn pink w-100">
                <i class="fa-solid fa-list"></i>
                목록으로
            </a>
        </div>
    </div>
</div>


<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
