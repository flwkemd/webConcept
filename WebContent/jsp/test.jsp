<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
	<ul>
		<li>지역변수</li>
		<li>${msg }</li>
		<li>${param.msg }</li>
		<li>${pageScope.msg }</li>
		<li>${requestScope.msg }</li>
		<%-- <li><%=request.getAttribute("msg") %></li> --%>
		<li>${sessionScope.msg }</li>
		<li>${applicationScope.msg }</li>
	</ul>
</body>
</html>