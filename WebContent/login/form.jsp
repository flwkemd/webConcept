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
	function send(f){
		<c:if test="${requestScope.saveId == null }">
			var saveId = confirm("아이디를 저장하시겠습니까?");
			if(saveId){
				f.save.value = "y";
			}
		</c:if>
		f.submit();
	}
</script>

</head>
<body>
	<h1>로그인 페이지</h1>
	<form action="/webConcept/login/login.do" method="post">
		<input type="hidden" name="save" value="n">
		<table border="1">
			<caption>::로그인::</caption>
			<tr>
				<th>아이디</th>
				<td>
					<c:if test="${requestScope.saveId != null }">
						<input name="id" value="${requestScope.saveId }">
					</c:if>
					<c:if test="${requestScope.saveId == null }">
						<input name="id">
					</c:if>
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>
					<input type="password" name="pwd">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="로그인" onclick="send(this.form)">
					<input type="reset" value="초기화">
				</td>
		</table>
	</form>
</body>
</html>