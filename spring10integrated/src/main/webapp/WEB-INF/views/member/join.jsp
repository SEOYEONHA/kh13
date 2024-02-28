<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
    
<style>
	input[name=memberId] {
	    background-image: url("/image/user-login.png");
	}
	input[name=memberPw], input[id="pw-reinput"] {
	    background-image: url("/image/lock-login.png");
	}
	input[name=memberNick] {
	    background-image: url("/image/nickname.png");
	}
	input[name=memberBirth] {
	    background-image: url("/image/calendar.png");
	}
	input[name=memberContact] {
	    background-image: url("/image/telephone.png");
	}
	input[name=memberEmail] {
	    background-image: url("/image/email.png");
	}
	input[name=memberPost] {
	    background-image: url("/image/post.png");
	}
	input[name=memberAddress1] {
	    background-image: url("/image/letterbox.png");
	}
	input[name=memberAddress2] {
	    background-image: url("/image/home.png");
	}
	
	.fa-asterisk {
		color: red;
	}
</style>


<!-- 이 페이지에서만 사용할 JS 코드 -->
<script type="text/javascript">

$(function(){
	//이전, 다음 버튼을 누르면 표시된 페이지의 순서에 맞게 진행바 변경
	calculatePercent(1);
	
	$(".page").find(".btn-prev").click(function(){
		//표시되는 페이지가 몇 번째인가?
		//-> $(대상).index(전체대상)
		//-> 대상은 :visible 이라고 붙이면 표시된 항목을 찾아준다(jQuery 전용)
		var index = $(".page:visible").index(".page") + 1;
		calculatePercent(index);
	});
	$(".page").find(".btn-next").click(function(){
		var index = $(".page:visible").index(".page") + 1;
		calculatePercent(index);
	});
	
	function calculatePercent(page) {
		var total = $(".page").length;
		var percent = page * 100 / total;
		$(".progressbar > .guage").css("width", percent+"%");
	}
});

$(function(){
    //상태객체(React의 state로 개념이 이어짐)
    var state = {
        //key : value
        memberIdValid : false,
        memberPwValid : false,
        memberPwCheckValid : false,
        memberNickValid : false,
        memberEmailValid : false,
        memberBirthValid : true, //선택항목
        memberContactValid : true, //선택항목
        memberAddressValid : true,//선택항목
        //객체에 함수를 변수처럼 생성할 수 있다
        //- this는 객체 자신(자바와 동일하지만 생략이 불가능)
        ok : function(){
            return this.memberIdValid 
                    && this.memberPwValid && this.memberPwCheckValid
                    && this.memberNickValid && this.memberEmailValid
                    && this.memberBirthValid && this.memberContactValid
                    && this.memberAddressValid;
        },
    };

    $("[name=memberId]").blur(function(){
        var regex = /^[a-z][a-z0-9]{7,19}$/;
        var value = $(this).val();

        if(regex.test(value)) {//아이디 형식 검사를 통과했다면
            $.ajax({
                //url : "http://localhost:8080/checkId?memberId="+value,
                url : "/rest/member/checkId",
                method : "post",//전송방식(get/post)
                data: {
                    memberId : value
                },
                success : function(response) {
                    //console.log(response);
                    if(response == "NNNNN") {
                        $("[name=memberId]").removeClass("success fail fail2").addClass("fail2");
                        state.memberIdValid = false;
                    }
                    else if(response == "NNNNY") {
                        $("[name=memberId]").removeClass("success fail fail2").addClass("success");
                        state.memberIdValid = true;
                    }
                }
            });
        }
        else {//아이디가 형식검사를 통과하지 못했다면
            $("[name=memberId]").removeClass("success fail fail2").addClass("fail");
            state.memberIdValid = false;
        }
    });
    $("[name=memberPw]").on("blur", function(){
    	var regex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[!@#$])[a-zA-Z\d!@#$]{6,15}$/;
    	state.memberPwValid = regex.test($(this).val());
        $(this).removeClass("success fail")
                    .addClass(state.memberPwValid ? "success" : "fail");
    });
    $("#pw-reinput").blur(function(){
        var memberPw = $("[name=memberPw]").val();
        state.memberPwCheckValid = memberPw == $(this).val();
        
        if(memberPw.length == 0) {
            $(this).removeClass("success fail fail2").addClass("fail2");
        }
        else {
            $(this).removeClass("success fail fail2")
                        .addClass(state.memberPwCheckValid ? "success" : "fail");
        }
    });
    $("[name=memberNick]").blur(function(){
        var regex = /^[가-힣0-9]{2,10}$/;
        var value = $(this).val();

        if(regex.test(value)) {
            $.ajax({
                url : "/rest/member/checkMemberNick",
                method : "post",
                data : { memberNick : value },
                success:function(response){
                    if(response) {//사용 가능한 경우 - success
                        state.memberNickValid = true;
                        $("[name=memberNick]")
                            .removeClass("success fail fail2")
                            .addClass("success");
                    }
                    else {//이미 사용중인 경우 - fail2
                        state.memberNickValid = false;
                        $("[name=memberNick]")
                            .removeClass("success fail fail2")
                            .addClass("fail2");
                    }
                }
            });
        }
        else {//형식이 맞지 않는 경우 - fail
            state.memberNickValid = false;
            $("[name=memberNick]")
                .removeClass("success fail fail2")
                .addClass("fail");
        }
    });
    $("[name=memberEmail]").blur(function(){
        var regex = /^[a-z0-9]{8,20}@[a-z0-9\.]{1,20}$/;
        var value = $(this).val();
        state.memberEmailValid = regex.test(value);
        $(this).removeClass("success fail")
                    .addClass(state.memberEmailValid ? "success" : "fail");
    });
    $("[name=memberContact]").blur(function(){
        var regex = /^010[1-9][0-9]{7}$/;
        var value = $(this).val();
        state.memberContactValid = value.length == 0 || regex.test(value);
        $(this).removeClass("success fail")
                    .addClass(state.memberContactValid ? "success" : "fail");
    });
    $("[name=memberBirth]").blur(function(){
        var regex = /^(19[0-9]{2}|20[0-9]{2})-(02-(0[1-9]|1[0-9]|2[0-8])|(0[469]|11)-(0[1-9]|1[0-9]|2[0-9]|30)|(0[13578]|1[02])-(0[1-9]|1[0-9]|2[0-9]|3[01]))$/;
        var value = $(this).val();
        state.memberBirthValid = value.length == 0 || regex.test(value);
        $(this).removeClass("success fail")
                    .addClass(state.memberBirthValid ? "success" : "fail");
    });

    //주소는 세 개의 입력창이 모두 입력되거나 안되거나 둘 중 하나
    $("[name=memberAddress2]").blur(function(){
        var post = $("[name=memberPost]").val();
        var address1 = $("[name=memberAddress1]").val();
        var address2 = $("[name=memberAddress2]").val();

        var isClear = post.length == 0 && address1.length == 0 && address2.length == 0;
        var isFill = post.length > 0 && address1.length > 0 && address2.length > 0;

        state.memberAddressValid = isClear || isFill;

        $("[name=memberPost], [name=memberAddress1], [name=memberAddress2]")
                .removeClass("success fail")
                .addClass(state.memberAddressValid ? "success" : "fail");
    });

    //form 전송
    $(".check-form").submit(function(){
        //$(this).find("[name], #pw-reinput").blur();
        //$(this).find(".tool").blur();//모든 창
        
        //입력창 중에서 success fail fail2가 없는 창
        $(this).find(".tool").not(".success, .fail, .fail2").blur();
        return state.ok();
    });
});
</script>

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    $(function(){
        $(".btn-address-search").click(function(){
            new daum.Postcode({
                oncomplete: function(data) {
                    // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                    // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                    // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                    var addr = ''; // 주소 변수

                    //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                    if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                        addr = data.roadAddress;
                    } else { // 사용자가 지번 주소를 선택했을 경우(J)
                        addr = data.jibunAddress;
                    }

                    // 우편번호와 주소 정보를 해당 필드에 넣는다.
                    $("[name=memberPost]").val(data.zonecode);
                    $("[name=memberAddress1]").val(addr);

                    // 커서를 상세주소 필드로 이동한다.
                    $("[name=memberAddress2]").focus();
                }
            }).open();
        });
        $(".btn-address-clear").click(function(){
        	$("[name=memberPost]").val("");
        	$("[name=memberAddress1]").val("");
        	$("[name=memberAddress2]").val("");
        });
    });


</script>



<form action="join" method="post" enctype="multipart/form-data" class="check-form" >    
    
	<div class="container w-500">
		<div class="cell title center">
			<h1>회원가입</h1>
		</div>
		<div class="cell center red">
			<p>
				<i class="fa-solid fa-asterisk"></i>
				표시는 필수항목입니다.
			</p>
		</div>
	
		<!-- 진행바 -->
	<div class="cell">
		<div class="progressbar"><div class="guage"></div></div>
	</div>
	
	
		<!-- 1페이지 - 아이디/비밀번호 -->
		<div class="cell page">
			<div class="cell">
				<label>
					아이디 
					<i class="fa-solid fa-asterisk"></i>
				</label>
				<input type="text" name="memberId" class="tool tool-image w-100" placeholder="소문자 시작, 숫자포함 8~20자">
				<div class="success-feedback">멋진 아이디네요!</div>
                <div class="fail-feedback">아이디는 소문자 시작, 숫자 포함 8~20자로 작성하세요</div>
			</div>
			
			<div class="cell">
				<label>
					비밀번호 
					<i class="fa-solid fa-asterisk"></i>
				</label>
				<input type="password" name="memberPw" class="tool tool-image w-100" placeholder="대소문자, 숫자, 특수문자(!@#$) 포함 6~15자">
				<div class="success-feedback">비밀번호가 올바른 형식입니다</div>
                <div class="fail-feedback">비밀번호에는 반드시 영문 대,소문자와 숫자, 특수문자가 포함되어야 합니다</div>
			</div>
			
			<div class="cell">
                <label>
                    비밀번호 확인
                    <i class="fa-solid fa-asterisk red"></i>
                </label>
                <input type="password" placeholder=""  id="pw-reinput" class="tool tool-image w-100">
                <div class="fail2-feedback">비밀번호를 먼저 입력하세요</div>
                <div class="fail-feedback">비밀번호가 일치하지 않습니다</div>
                <div class="success-feedback">비밀번호가 일치합니다</div>
            </div>
            
			<div class="flex-cell">
				<div class="w-100 left"></div>
				<div class="w-100 right">
					<button type="button" class="btn btn-next w-100">다음</button>
				</div>
			</div>
		</div>	
		
		<!-- 2페이지 - 닉네임 -->
		<div class="cell page">
			<div class="cell">
				<label>
					닉네임 <i class="fa-solid fa-asterisk"></i>
				</label>
				<input type="text" name="memberNick" class="tool tool-image w-100" placeholder="한글, 숫자 2~10글자(반드시 한글로 시작)">
                <div class="fail-feedback">닉네임은 한글 시작, 한글 또는 숫자 2~10자로 작성하세요</div>
                <div class="success-feedback">닉네임 형식이 일치합니다</div>
			</div>
		
			<div class="flex-cell">
				<div class="w-100 left">
					<button type="button" class="btn btn-prev w-100 pink">이전</button>
				</div>
				<div class="w-100 right">
					<button type="button" class="btn btn-next w-100">다음</button>
				</div>
			</div>
		</div>
		
		<!-- 3페이지 -->
		<div class="cell page">
			<div class="cell">
				<label>
					생년월일
					<input name="memberBirth" class="tool tool-image w-100" type="date">
				</label> 
			</div>
			<div class="cell">
				<label>
					연락처
				</label>
				<input name="memberContact" class="tool tool-image w-100" type="tel">
			</div>
			<div class="cell">
				<label>
					이메일 <i class="fa-solid fa-asterisk"></i>
				</label>
                <input type="email" name="memberEmail" 
                                    placeholder="test1234@kh.com" class="tool tool-image w-100">
                <div class="fail-feedback">잘못된 이메일 형식입니다</div>
			</div>
		
			<div class="flex-cell">
				<div class="w-100 left">
					<button type="button" class="btn btn-prev w-100 pink">이전</button>
				</div>
				<div class="w-100 right">
					<button type="button" class="btn btn-next w-100">다음</button>
				</div>
			</div>
		</div>
		
		
		<!-- 4페이지 -->
		<div class="cell page">
			<div class="cell">
				<label>주소</label>
			</div>
			<div class="cell">
				<input name="memberPost" class="tool tool-image w-50" placeholder="우편번호"  type="text">
				<button type="button" class="btn positive btn-address-search">
					<i class="fa-solid fa-magnifying-glass"></i>
				</button>
				<button type="button" class="btn negative btn-address-clear">
					<i class="fa-solid fa-xmark"></i>
				</button>
			</div>
			<div class="cell">
				<input name="memberAddress1" class="tool tool-image w-100" placeholder="기본주소" type="text">
			</div>
			<div class="cell">
				<input name="memberAddress2" class="tool tool-image w-100" placeholder="상세주소" type="text">
			</div>
			
			<div class="flex-cell">
				<div class="w-100 left">
					<button type="button" class="btn btn-prev w-100 pink">이전</button>
				</div>
				<div class="w-100 right">
					<button type="button" class="btn btn-next w-100">다음</button>
				</div>
			</div>
		</div>
	
		<!-- 5페이지 -->
		<div class="cell page">
			<div class="cell">
				<label>프로필 이미지</label>
				<input type ="file" name="attach" class="too w-100">
			</div>
		
			<div class="flex-cell">
				<div class="w-100 left">
					<button type="button" class="btn btn-prev w-100 pink">이전</button>
				</div>
				<div class="w-100 right">
					<button type="submit" class="btn positive w-100">회원가입</button>
				</div>
			</div>
		</div>
	</div>		
			

</form>
<%-- 템플릿 페이지를 불러오는 코드 --%>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>