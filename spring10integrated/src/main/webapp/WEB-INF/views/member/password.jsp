<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>    

<h1 align="center">��й�ȣ ����</h1>

<form action="password" method="post">
	���� ��й�ȣ <input type="password" name="originPw" required placeholder="���� ��й�ȣ" ><br><br>
	�ű� ��й�ȣ <input type="password" name="changePw" required placeholder="�ű� ��й�ȣ" ><br><br>
	<button>�����ϱ�</button>
</form>

<c:if test="${param.error != null}">
	<h4 style="color:red">��й�ȣ�� ��ġ���� �ʽ��ϴ�</h4>
</c:if>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>