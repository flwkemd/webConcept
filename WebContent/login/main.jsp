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

	<h1>메인페이지1</h1>
	<c:if test="${sessionScope.user == null } ">
		<input type="button" value="로그인" onclick="location.href='/webConcept/login/form.do'">
	</c:if>
	<c:if test="${sessionScope.user != null } ">
		<input type="button" value="로그아웃" onclick="location.href='/login/logout.do'">
		<input type="button" value="갤러리" onclick="location.href='/photo/list.do'">
	</c:if>
</body>
</html>