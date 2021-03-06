<%@page import="vo.ScoreVo"%>
<%@page import="java.util.List"%>
<%@page import="dao.ScoreDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<ScoreVo> scoreList = ScoreDao.getInstance().selectList();
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
	
	#addDiv{
		margin:auto;
		margin-top: 30px;
		background-color : #ccaa99;
		width: 300px;
		height: 200px;
		box-shadow: 0px 0px 3px 3px gray;
		display : none;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
	function showAddDiv(){
		$("#addDiv").css("display","block");
	}
	function hideAddDiv(){
		$("#addDiv").css("display", "none");
	}
	
	function add(f){
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
		f.action ="score_add.jsp"
		f.submit();
	}
	
	function del(code){
		location.href="score_del.jsp?code="+code;
	}
	
	function modify(code){
		location.href="score_modify.jsp?code="+code;
	}
	
</script>

</head>
<body>

	<table border="1px solid #aaaaaa" align="center" cellpadding="10">
		<caption>:::성적 리스트:::</caption>
		<thead>
			<tr>
				<th>번호</th><th>이름</th><th>국어</th><th>영어</th><th>수학</th><th>총점</th><th>평균</th><th>비고</th>
			</tr>
		</thead>
		<tbody>
			<%
				for(ScoreVo vo : scoreList){
			%>
			<tr>
				<td><%=vo.getCode() %></td>
				<td><%=vo.getName() %></td>
				<td><%=vo.getKorean() %></td>
				<td><%=vo.getEnglish() %></td>
				<td><%=vo.getMath() %></td>
				<td><%=vo.getTotal() %></td>
				<td><%=vo.getAverage() %></td>
				<td>
					<input type="button" value="삭제" onclick="del('<%=vo.getCode()%>')">
					<input type="button" value="수정" onclick="modify(<%=vo.getCode()%>)">
				</td>
			</tr>
			<%
				}
			%>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="8">
					<input type="button" value="추가" onclick="showAddDiv()">
				</td>
			</tr>
		</tfoot>
	</table>
	
	<div id="addDiv" align="center">
		<form>
			<table cellpadding="5">
				<caption>:::성적 추가:::</caption>
				<tbody>
					<tr>
						<th>이름</th>
						<td><input type="text" id="name" name="name" placeholder="이름입력"></td>
					</tr>
					<tr>
						<th>국어점수</th>
						<td><input type="text" id="korean" name="korean" placeholder="0~100사이 숫자 입력"></td>
					</tr>
					<tr>
						<th>영어점수</th>
						<td><input type="text" id="english" name="english" placeholder="0~100사이 숫자 입력"></td>
					</tr>
					<tr>
						<th>수학점수</th>
						<td><input type="text" id="math" name="math" placeholder="0~100사이 숫자 입력"></td>
					</tr>
					</tbody>
					<tfoot>
						<tr>
							<td colspan="2">
							<input type="button" value="추가하기" onclick="add(this.form)">
							<input type="reset" value="다시입력">
							<input type="button" value="취소하기" onclick="hideAddDiv()">
						</tr>
					</tfoot>
			</table>
		</form>
	</div>


</body>
</html>