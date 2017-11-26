<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/list.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="../js/httpRequest.js"></script>
<script>
	function del(idx){
		var user_pwd = $("#c_pwd_"+idx).val();
		/* if(pwd == user_pwd){
			location.href="delete.do?idx="+idx;
		}else{
			alert('비밀번호가 올바르지 않습니다.')
		} */
		
		var url = "checkPwd.do";
		var param = "idx="+idx+"&pwd="+user_pwd;
		var method = "POST";
		$.ajax({
			"url":url,
			"data":param,
			"method":method,
			"success":function(data){
				if(data=='yes'){
					location.href="delete.do?idx="+idx;
				}else{
					alert('비밀번호가 올바르지 않습니다.')
				}
				
			}
		});
		
	}

	function update(idx){
		var user_pwd = $("#c_pwd_"+idx).val();
		sendRequest("checkPwd.do", "idx="+idx+"&pwd="+user_pwd, "POST", resultFunc, true);
		
		function resultFunc(){
			if(xhr.readyState == 4 && xhr.status == 200){
				/* var result = xhr.responseText;
				if(result == 'yes'){
					location.href="update.do?idx="+idx;
				}else{
					alert("비밀번호가 올바르지 않습니다.")
				} */
				
				var result = xhr.responseXML;
				console.log(result);
				
				var resultDoc = result.documentElement;
				console.log(resultDoc);
				
				var name = resultDoc.getElementByTagName("name");
				console.log(name);
				
				var myName = name[0];
				console.log(myName);
				
				var nameData = myName.firstChild;
				console.log(nameData); // "홍길동"
				console.log(nameData.data); //홍길동
				
				var pwd = xhr.responseXML.documentElement.getElementsByTagName("pwd")[0].fistChild.data;
				console.log(pwd);
				
				if(user_pwd == pwd){
					if(result == 'yes'){
						location.href="update.do?idx="+idx;
					}else{
						alert("비밀번호가 올바르지 않습니다.")
					}
				}
				
			}
			
		}	
	}
	
	function search(){
		var search_option = $("#search_option").val();
		var search_text = $("#search_text").val();
		
		if(search_option != 'all' && search_text == ''){
			alert('검색어를 입력해주세요.');
			return;
		}
		var param ="?search_option="+search_option+"$search_text="+search_text;
		location.href =param;
	}
	
</script>
</head>
<body>
	<div id="main_box">
		<h1> ::: 방명록 리스트  :::</h1>
		<div align="center">
			<input type="button" value="글쓰기" onclick="location.href='insert_form.do'">
		</div>
		<div align="center">
			<select id="search_option">
				<option value="all">:::전체검색:::</option>
				<option value="name">이름</option>
				<option value="content">내용</option>
				<option value="name_content">이름+내용</option>
			</select>
			<input type="text" id="search_text">
			<input type="button" value="검색" onclick="search()">
		</div>
		<hr>
		<!-- 데이터가 없는 경우 -->
		<c:if test="${requestScope.list.size() == 0 } ">
			<div align="center">
				<font color="red">데이터가 없습니다.</font>
			</div>
		</c:if>
		<c:forEach var="vo" items="${list }">
			<div class="box_style">
				<div class="content_style">
					${vo.content } 
				</div>
				<div class="name_style">
					작성자:${vo.name } (${vo.ip }) 
				</div>
				<div class="date_style">
					작성일 : ${vo.regdate }
				</div>
				<div class="pwd_style">
					비밀번호:
					<input size=10 id="c_pwd_${vo.idx }" type="password">
					<input type="button" value="삭제" onclick="del('${vo.idx}')">
					<input type="button" value="수정" onclick="update('${vo.idx}')">
					
				</div>
			</div>
		</c:forEach>
	</div>

</body>
</html>