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
	<table border="1">
		<tr>
			<th>제목</th>
			<td>${book.title }</td>
		</tr>
		<tr>
			<th>저자</th>
			<td>${book.author }</td>
		</tr>
		<tr>
			<th>가격</th>
			<td>${book.price }</td>
		</tr>
		<tr>
			<th>출판사</th>
			<td>${book.publisher }</td>
		</tr>
	</table>
</body>
</html>