<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
	<c:if test="${requestScope.id != null }">
		<p>${requestScope.id }</p>
	</c:if>
	<c:if test="${requestScope.id == null }">
		<p>아이디가 존재하지 않습니다.</p>
	</c:if>
	<c:if test="${requestScope.name != null }">
		<p>${requestScope.name }</p>
	</c:if>
	<c:if test="${requestScope.name == null }">
		<p>이름이 존재하지 않습니다.</p>
	</c:if>
</body>
</html>