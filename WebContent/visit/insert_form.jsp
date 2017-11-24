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
		var name = f.name.value.trim();
		var content = f.content.value.trim();
		var pwd = f.pwd.value.trim();
		
		if(name == ''){
			alert('이름을 입력해주세요.');
			f.name.focus();
			return;
		}
		if(content == ''){
			alert('내용을 입력해주세요.');
			f.content.focus();
			return;
		}
		if(pwd == ''){
			alert('비밀번호를 입력해주세요.');
			f.pwd.focus();
			return;
		}
		
		f.action = "insert.do";
		f.method = "post";
		f.submit();
	}
</script>

</head>
<body>
	<form>
		<table border="1" align="center" width="400">
			<caption>:::방명록 글쓰기</caption>
			<tr>
				<th>작성자</th>
				<td><input name="name"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="content" rows="5" cols=""></textarea></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pwd"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="글쓰기" onclick="send(this.form)">
					<input type="button" value="목록으로" onclick="location.href='list.do'">
				</td>
		</table>
	</form>
</body>
</html>