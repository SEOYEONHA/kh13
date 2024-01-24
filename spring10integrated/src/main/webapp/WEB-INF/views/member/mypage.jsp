<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>    
<h1 align="center">����������</h1>
<hr>
<h3>${memberDto.memberId}���� ȸ�� ����</h3>
<table border="1" width = "400">
	<tr>
		<th width="40%">�г���</th>
		<td>${memberDto.memberNick}</td>
	</tr>
	<tr>
		<th>�������</th>
		<td>${memberDto.memberBirth}</td>
	</tr>
	<tr>
		<th>����ó</th>
		<td>${memberDto.memberContact}</td>
	</tr>
	<tr>
		<th>�̸���</th>
		<td>${memberDto.memberEmail}</td>
	</tr>
	<tr>
		<th>�ּ�</th>
		<td>[${memberDto.memberPost}] ${memberDto.memberAddress1}<br>
		${memberDto.memberAddress2}
		</td>
	</tr>
	<tr>
		<th>ȸ�����</th>
		<td>${memberDto.memberLevel}</td>
	</tr>
	<tr>
		<th>����Ʈ</th>
		<td>${memberDto.memberPoint} point</td>
	</tr>
	<tr>
		<th>���Խð�</th>
		<td><fmt:formatDate value="${memberDto.memberJoin}" 
									pattern="Y-MM-DD HH:mm:ss"></fmt:formatDate>
<%--	<td><fmt:formatDate value="${memberDto.memberJoin}" 
							pattern="Y�� M�� D�� H�� m�� s��"></fmt:formatDate>
		 																								--%>	
		</td>
	</tr>
	<tr>
		<th>������ �α��νð�</th>
		<td><fmt:formatDate value="${memberDto.memberLogin}" 
									pattern="Y-MM-DD HH:mm:ss"></fmt:formatDate>
	<%--	<td><fmt:formatDate value="${memberDto.memberJoin}" 
								pattern="Y�� M�� D�� H�� m�� s��"></fmt:formatDate>
			 																								--%>	
		</td>
	</tr>
</table>
<br>
<a href="#"><button>��й�ȣ ����</button></a>
<a href="#"><button>�������� ����</button></a>
<a href="#"><button>ȸ�� Ż��</button></a>



<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>