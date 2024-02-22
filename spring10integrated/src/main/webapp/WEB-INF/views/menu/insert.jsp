<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>    
    
    <script type="text/javascript">
	    function checkNameKor() {
	        var inputTarget = document.querySelector("[name=menuNameKor]");
	        var menuNameKor = inputTarget.value;
	
	        //한글인지 검사    
	        var regex = /^[가-힣]{1,20}$/; //varchar2(60)
	        var isValid = regex.test(menuNameKor);
	
	        inputTarget.classList.remove("success", "fail", "fail2");
	
	        if(isValid) {
	            inputTarget.classList.add("success");
	            return true;
	        }
	        else if(!menuNameKor) {
	            inputTarget.classList.add("fail2");
	            return false;
	        }
	        else {
	            inputTarget.classList.add("fail");
	            return false;
	        }
	}
	function checkNameEng() {
	    var inputTarget = document.querySelector("[name=menuNameEng]");
	    var menuNameEng = inputTarget.value;
	
	    
	
	    //영문인지 검사
	    var regex = /^[a-zA-Z]{1,60}$/;
	    var isValid = regex.test(menuNameEng);
	
	    inputTarget.classList.remove("success", "fail", "fail2");
	
	    if(isValid) {
	        inputTarget.classList.add("success");
	        return true;
	    }
	    else if(!menuNameEng) {
	        inputTarget.classList.add("fail2");
	        return false;
	    }
	    else {
	        inputTarget.classList.add("fail");
	        return false;
	    }
	
	}
	    function checkType() {
	        var inputTarget = document.querySelector("[name=menuType]");
	        var menuType = inputTarget.value;
	
	        //var regex = /^[가-힣a-zA-Z0-9]+$/; //아무거나
	        var isValid = menuType.length > 0;
	
	        inputTarget.classList.remove("success", "fail");
	        inputTarget.classList.add(isValid ? "success" : "fail");
	        return isValid;
	    }
	    function checkPrice() {
	        var inputTarget = document.querySelector("[name=menuPrice]");
	        var menuPrice = inputTarget.value;
	
	        var regex = /^[0-9]+$/;
	        var isValid = regex.test(menuPrice);
	
	        inputTarget.classList.remove("success", "fail", "fail2");
	
	        if(isValid) {
	            inputTarget.classList.add("success");
	            return true;
	        }
	        else if(!menuPrice) {
	            inputTarget.classList.add("fail2");
	            return false;
	        }
	        else {
	            inputTarget.classList.add("fail");
	            return false;
	        }
	    }
	
	    function checkForm() {
	        var isValid1 = checkNameKor();
	        var isValid2 = checkNameEng();
	        var isValid3 = checkType();
	        var isValid4 = checkPrice();
	        return isValid1 && isValid2 && isValid3 && isValid4;
	    }
	
	
	</script>
    
    
    
    
    <%--
    <select>를 사용하면 주어진 목록 중에서 선택시킬 수 있다
    <select name="...">
    	<option value="...">...</option>
    	<option value="...">...</option>
    	<option value="...">...</option>
    </select>
     --%>
     
<div class="container w-400">
	<div class="cell center">
		<h1>
			<i class="fa-solid fa-coffee fa-flip-horizontal" style="color: #00b894;"></i>
			신규 메뉴 등록
			<i class="fa-solid fa-coffee" style="color: #00b894;"></i>
		</h1>
	</div>
	<div class="cell">
		<form action="insert" method="post" onsubmit="return checkForm();">
			<div class="cell">
	            <label>
	                메뉴명(한글)
	                <i class="fa-solid fa-asterisk red"></i>
	            </label>
	            <input name="menuNameKor" type="text" class="tool w-100" placeholder="(ex)아메리카노" onblur="checkNameKor();">
	            <div class="success-feedback"></div>
	            <div class="fail-feedback">한글만 30자까지 입력 가능합니다</div>
	            <div class="fail2-feedback">메뉴명을 반드시 작성하세요</div>
	        </div>
	        <div class="cell">
	            <label>
	                메뉴명(영어)
	                <i class="fa-solid fa-asterisk red"></i>
	            </label>
	            <input name="menuNameEng" type="text" class="tool w-100" placeholder="(ex)Americano" onblur="checkNameEng();">
	            <div class="success-feedback"></div>
	            <div class="fail-feedback">영문만 60자까지 입력 가능합니다</div>
	            <div class="fail2-feedback">메뉴명을 반드시 작성하세요</div>
	        </div>
	
	        <div class="cell">
	            <label>
	                메뉴유형
	                <i class="fa-solid fa-asterisk red"></i>
	            </label>
	            <select name="menuType" class="tool w-100" oninput="checkType();">
	                <option value="">선택하세요</option>
	                <option value="음료">음료</option>
	                <option value="스무디">스무디</option>
	                <option value="에이드">에이드</option>
	                <option value="디저트">디저트</option>
	                <option value="베이커리">베이커리</option>
	            </select>
	            <div class="success-feedback"></div>
	            <div class="fail-feedback">메뉴유형을 반드시 선택하세요</div>
	        </div>
	
	        <div class="cell">
	        <label>
	            메뉴가격 
	            <i class="fa-solid fa-asterisk red"></i>
	        </label>
	        <input name="menuPrice" type="number" class="tool w-100 right" placeholder="(ex)4000" onblur="checkPrice();">
	        <div class="success-feedback"></div>
	        <div class="fail-feedback">숫자만 입력 가능합니다</div>
	        <div class="fail2-feedback">메뉴가격을 반드시 작성하세요</div>
	        </div>
	        
	        <div class="cell">
	            <button class="btn positive w-100">
	                <i class="fa-solid fa-plus"></i>
	                등록하기
	            </button>
	        </div>
		</form>
	</div>
	<hr class="my-20">
	<div class="cell">
		<a href="list" class="btn pink w-100">
			<i class="fa-solid fa-list"></i>
			목록보기
		</a>
	</div>
</div>

<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>