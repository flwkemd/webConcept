<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page session="true" %>
<%@ page buffer="8kb" %>
<%@ page isThreadSafe="true" %>
<%@ page info="이 페이지는 page 지시어 페이지 입니다." %>
<%@ page errorPage="error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	Calendar c = Calendar.getInstance();
	//int num = 100/0;
%>
<%
	String name ="홍길동";
	request.setAttribute("name", name);
%>

<%
	String name2 = request.getParameter("name2");
	String msg2 = name2 +"Hi!";
	request.setAttribute("msg2", msg2);
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
	<c:forEach var="i" begin="0" end="10">
		<li>${i }번째 행 </li>
	</c:forEach>	
	</ul>
	<hr>
	<ul>
	<%
		for(int i=0; i<=10; i++){
	%>
		<li><%=i %>번째 행</li>
	<%		
		}
	%>
	</ul>
	<hr>
	
	<%@ include file="vs.jsp" %> <!-- 하나의 html 만들기 -->
	<jsp:include page="vs.jsp"></jsp:include> <!-- 별도의 2개의 html 만들기  -->
	<hr>
	
	<%-- <jsp:forward page="script.jsp"/> --%>
	
</body>
</html>