<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
	<hr>
	<form action="list.do">
		상품명:<input name="searchText" value="${param.searchText }">
		<input type="button" value="검색" onclick="search(this.form)">
	</form>
	<hr>
	<table border="1">
		<caption>::상품리스트::</caption>
		<tr>
			<th>이미지</th>
			<th>상품명</th>
			<th>최저가</th>
			<th>최고가</th>
			<th>판매몰</th>
		</tr>
		<c:forEach var="item" items="${list }">
			<tr>
				<td>
					<img src="${list.image }" width="120" height="100">
				</td>
				<td>
					<a href="${list.link }">${item.title }</a>
				</td>
				<td>
					<fmt:formatNumber value="${item.lprice }"/>
				</td>
				<td>
					<fmt:formatNumber value="${item.hprice }"/>
				</td>
				<td>
					<fmt:formatNumber value="${item.hprice }"/>
				</td>
				<td>
					${item.mallName }
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>