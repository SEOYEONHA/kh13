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
        //해야할 일
        //1. 아이디 입력창에서 입력이 완료될 경우 형식 검사하여 결과 기록
        //2. 비밀번호 입력창에서 입력이 완료될 경우 형식 검사하여 결과 기록
        //3. 비밀번호 확인창에서 입력이 완료될 경우 비밀번호와 비교하여 결과 기록
        //4. form의 전송이 이루어질 때 모든 검사결과가 유효한지 판단하여 전송

        //상태객체(React의 state로 개념이 이어짐)
        var state = {
            //key : value
            memberIdValid : false, 
            memberPwValid : false, 
            memberPwCheckValid : false,
            memberNickValid : false,
            //객체에 함수를 변수처럼 생성할 수 있다
            //- this는 객체 자신(자바와 동일하지만 생략이 불가능)
            ok : function(){
                return this.memberIdValid && this.memberPwValid && this.memberPwCheckValid
                 && this.memberNickValid;
            },
        };
        // var memberIdValid = false;
        // var memberPwValid = false;
        // var memberPwCheckValid = false;

        $("[name=memberId]").on("blur", function(){
            var regex = /^[a-z][a-z0-9]{7,19}$/;
            state.memberIdValid = regex.test($(this).val());
            $(this).removeClass("success fail").addClass(state.memberIdValid ? "success" : "fail");
        });
        $("[name=memberPw]").on("blur", function(){
            var regex = /^[A-Za-z0-9!@#$]{6,15}$/;
            state.memberPwValid = regex.test($(this).val());
            $(this).removeClass("success fail").addClass(state.memberPwValid ? "success" : "fail");
        });
        $("#pw-reinput").blur(function(){
            var memberPw = $("[name=memberPw]").val();
            state.memberPwCheckValid = memberPw == $(this).val();
            if(memberPw.length == 0){
                $(this).removeClass("success fail fail2").addClass("fail2");
            }
            else {
                $(this).removeClass("success fail fail2").addClass(state.memberPwCheckValid ? "success" : "fail");
            }
        });
         $("[name=memberNick]").blur(function(){
        	var regex = /^[가-힣][가-힣0-9]{1,9}$/
        	state.memberNickValid = regex.test($(this).val());
        	$(this).removeClass("success fail").addClass(state.memberNickValid ? "success" : "fail");
         });

        //form 전송시에는 미리 설정해둔 상태변수만 확인하면 된다
        //- 검사 효과까지 보고싶다면 blur 이벤트를 강제로 발생시킨다
        //- $(대상).on("blur") 또는 $(대상).blur()
        $(".check-form").submit(function(){
            $("[name=memberId]").blur();
            $("[name=memberPw]").blur();
            $("#pw-reinput").blur();
            $("[name=memberNick]").blur();
            // console.log(memberIdValid, memberPwValid, memberPwCheckValid);
            // return memberIdValid && memberPwValid && memberPwCheckValid;
            return state.ok();
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
					<input name="memberContact" class="tool tool-image w-100" type="tel">
				</label>
			</div>
			<div class="cell">
				<label>
					이메일 <i class="fa-solid fa-asterisk"></i>
					<input name="memberEmail" class="tool tool-image w-100" type="email" required>
				</label>
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
				<button type="button" class="btn">검색</button>
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