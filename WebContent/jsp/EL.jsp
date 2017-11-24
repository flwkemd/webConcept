<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String msg = "지역변수";
	pageContext.setAttribute("msg", "pageScope 소숙");
	request.setAttribute("msg", "requestScope 소숙");
	session.setAttribute("msg", "sessionScope 소숙");
	application.setAttribute("msg", "applicationScope 소숙");

%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
	<ul>
		<li><%=msg %></li>
		<li>${msg }</li>
		<li>${param.msg }</li>
		<li>${pageScope.msg }</li>
		<li>${requestScope.msg }</li>
		<%-- <li><%=request.getAttribute("msg") %></li> --%>
		<li>${sessionScope.msg }</li>
		<li>${applicationScope.msg }</li>
	</ul>
	
	<input type="button" value="페이지 이동" onclick="location.href='test.jsp?msg=param소속'">
	
</body>
</html>