<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
	function send(f){
		var title = f.title.value.trim();
		var pwd = f.pwd.value.trim();
		var photo = f.photo.value.trim();
		
		if(title==''){
			alert('제목을 입력해주세요!');
			f.title.focus();
			return;
		}
		if(pwd==''){
			alert('비밀번호를 입력해주세요!');
			f.pwd.focus();
			return;
		}
		if(photo==''){
			alert('사진을 입력해주세요!');
			f.photo.focus();
			return;
		}
		
		f.submit();
	}
</script>

</head>
<body>
	<form action="insert.do" enctype="multipart/form-data" method="post">
		<table border="1" align="cneter">
			<caption>::사진등록::</caption>
			<tr>
				<th>제목</th>
				<td>
					<input type="text" name="title">
				</td>
			</tr>
			
			<tr>
				<th>비밀번호</th>
				<td>
					<input type="password" name="pwd">
				</td>
			</tr>
			<tr>
				<th>사진</th>
				<td>
					<input type="file" name="photo">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="등록하기" onclick="send(this.form)">
					<input type="button" value="목록으로" onclick="location.href='list.do'">
					
				</td>
			</tr>
			
		</table>
	</form>
</body>
</html>