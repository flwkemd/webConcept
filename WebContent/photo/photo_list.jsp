<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
	function download(filename){
		location.href="${pageContext.request.contextPath }/download.do?dir=/upload/&filename="+filename
	}
</script>

</head>
<body>
	<div id="main_box">
		<h1>::Photo</h1>
		<div align = "center">
			<input id ="button_add" type="button" value="사진 올리기" onclick="location.href='insert_form.do'">
		</div>
		<div id="photo_box">
			<c:if test="${list.size() ==0 }">
				<div class="empty_msg" align="cneter">
					등록된 사진이 없습니다.
				</div>
			</c:if>
			<c:forEach var="vo" items="${list }">
				<div class="photo_type">
					<img src="../upload/${vo.filename }">
					<div class="title">${vo.title }</div>
					<div allgn="center">
						<input type="button" value="download" onclick="download('${vo.filename}')">
						<input type="button" value="delete" onclick="">
					</div>
				</div>
			</c:forEach>
		
		</div>
	</div>
</body>
</html>