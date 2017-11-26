<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
	<c:if test="${sessionScope.user == null}">
		alert('로그인 하신 뒤 이용하세요 \n 로그인 페이지로 이동합니다.');
		location.href="/login/form.do";
	</c:if>
</script>
</head>
<body>
	갤러리
</body>
</html>