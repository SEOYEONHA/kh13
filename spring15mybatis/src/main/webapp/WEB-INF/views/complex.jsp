<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>ȸ�� ���� �˻� ������</h1>

<%-- �˻�â --%>

<%-- ��� --%>
<h2>��� �� : ${list.size()}</h2>
<c:forEach var="memberDto" items="${list}">
	${memberDto}
	<hr>
</c:forEach>

