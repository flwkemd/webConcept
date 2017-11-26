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
	<table border="1" align="center">
		<caption> :: 개인목록 :: </caption>
		<tr>
			<th>이름</th>
			<th>별명</th>
			<th>나이</th>
			<th>전화</th>
			<th>집전화</th>
		</tr>
		<c:forEach var="pvo" items="${p_list }">
			<tr>
				<td>${pvo.name }</td>
				<td>${pvo.nickname }</td>
				<td>${pvo.age }</td>
				<td>${pvo.tel }</td>
				<td>${pvo.hometel }</td>
			</tr>
		</c:forEach>
		
	</table>
</body>
</html>