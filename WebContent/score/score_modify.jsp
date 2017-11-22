<%@page import="dao.ScoreDao"%>
<%@page import="vo.ScoreVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String code = request.getParameter("code");
	ScoreVo svo = ScoreDao.getInstance().selectOne(Integer.parseInt(code));

%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	table{
		border-collapse: collapse;
	}
	td{
		text-align: center;
	}
	input[type="button"]{
		width: 80px;
	}
	
	#modifyDiv{
		margin:auto;
		margin-top: 30px;
		background-color : #ccaa99;
		width: 300px;
		height: 200px;
		box-shadow: 0px 0px 3px 3px gray;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
	function cancle(){
		location.href="score_list.jsp";
	}
	function modify(f){
		var name= f.name;
		//var name = $("name")
		var korean = f.korean;
		var english = f.english;
		var math = f.math;
		
		if(name.value == ''){
			alert('이름을 입력해주세요');
			f.name.focus();
			return;
		}
		if(korean.value == ''){
			alert('국어 점수를 입력해주세요');
			f.korean.focus();
			return;
		}
		if(english.value == ''){
			alert('영어 점수를 입력해주세요');
			f.english.focus();
			return;
		}
		if(math.value == ''){
			alert('수학 점수를 입력해주세요');
			f.math.focus();
			return;
		}
		
		f.method = 'post';
		f.action ="score_update.jsp"
		f.submit();
	}
	
</script>
</head>
<body>
	<div id="modifyDiv" align="center">
		<form>
			<input type="hidden" name="code" value="<%=svo.getCode() %>">
			<table cellpadding="5">
				<caption>:::성적 추가:::</caption>
				<tbody>
					<tr>
						<th>이름</th>
						<td><input type="text" id="name" name="name" value="<%=svo.getName()%>"></td>
					</tr>
					<tr>
						<th>국어점수</th>
						<td><input type="text" id="korean" name="korean" value="<%=svo.getKorean() %>"></td>
					</tr>
					<tr>
						<th>영어점수</th>
						<td><input type="text" id="english" name="english" value="<%=svo.getEnglish()%>"></td>
					</tr>
					<tr>
						<th>수학점수</th>
						<td><input type="text" id="math" name="math" value="<%=svo.getMath()%>"></td>
					</tr>
					</tbody>
					<tfoot>
						<tr>
							<td colspan="2">
							<input type="button" value="수정하기" onclick="modify(this.form)">
							<input type="reset" value="다시입력">
							<input type="button" value="취소하기" onclick="cancle()">
						</tr>
					</tfoot>
			</table>
		</form>
	</div>
</body>
</html>