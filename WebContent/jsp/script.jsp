<%-- jsp 주석입니다. --%> <!-- html 주석입니다. -->
<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%!
	//이곳은 선언문영역이며, 실제 서블릿으로 파싱될 때, 그 서블릿의 필드영역(멤버영역)이다.
	String sayHello = "안녕하세요";
	Random ran = new Random();
	
	public int sum(int a, int b){
		return a+b;
	}
%>

<%
	//이곳은 스크립트릿 영역이며, service() 메서드의 지역(바디)영역이다.
	request.setCharacterEncoding("utf-8");
	String msg = request.getParameter("msg");
	
	//response.setContentType("text/html; charset=utf-8");
	response.getWriter().println("메세지:"+msg);
	
	//application, pageContext, session
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
	스크립트요소 스터디<br>
	<%= sayHello %><br>
	<%= sum(10,20) %><br>

	<%= request.getAttribute("msg2") %>

</body>
</html>