<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>    

<style>

	input[name=originPw], input[name=changePw] {
	    background-image: url("/image/lock-login.png");
	}

</style>

<div class="container w-400">
	<div class="cell title">
		<h1 align="center">��й�ȣ ����</h1>
	</div>
	
	<div class="cell">
		<c:if test="${param.error != null}">
			<h4 style="color:red">���� ��й�ȣ�� ��ġ���� �ʽ��ϴ�.</h4>
		</c:if>
	</div>
	
	<div class="cell">
		<form action="password" method="post">
			<div class="cell">
				<label>
					���� ��й�ȣ 
					<input type="password" name="originPw" class="tool tool-image w-100" required placeholder="���� ��й�ȣ" >
				</label>
			</div>
			<div class="cell">
				<label>
					�ű� ��й�ȣ 
					<input type="password" name="changePw" class="tool tool-image w-100" required placeholder="�ű� ��й�ȣ" >
				</label>
			</div>
			<div class="cell center my-30">
				<button class="btn w-100 positive">�����ϱ�</button>
			</div>
		</form>
	</div>
	
</div>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>