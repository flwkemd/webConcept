<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
	$(document).ready(function(){
		//var url = "video_list.jsp";
		var url = "video_list_db.jsp";
		var obj = {
				"url":url,
				"data":null,
				"method":"POST",
				"success":function(data){
					var videoArr = eval(data);
					for(var i=0; i<videoArr.length; i++){}
						var title = videoArr[i].title;
						var path = videoArr[i].path;
						
						/* var option = "<option value'"+path+"'>"+title+"</option>";
						var select = document.getElementById("video_select");
						select.innerHTML += option; */
					
						var $op = $("<option>");
						$op.html(title);
						$op.val(path);
						
						$("#video_select").append($op);
						console.log($("#video_select").html());
				
				}
		}
		
		 // var result ="1+2"; 이것은 문자열, 자바스크립트 코드 X
		 // var result = eval("1+2"); 이것은 자바스크립트 코드 , 문자열 "" 이 벗겨짐"
		
		$.ajax(obj);
	});
	
	function video_play(){
		var path = $("#video_select").val();
		if(path == ""){
			return;
		}
		
/* 		var video_poketmon = document.getElementById("video_poketmon");
		video_poketmon.src = path;
		video_poketmon.play(); */

		$("#video_poketmon").attr("src",path);
		$("#video_poketmon").get(0).play();
		
	}
	
</script>
</head>
<body>
	비디오 목록:
	<select id="video_select" onchange="video_play()">
		<option value="">::: 재생할 비디오를 선택해주세요 :::</option>
	</select>
	<hr>
	<video id="video_poketmon" style="width:320px; height:240px" src="" controls></video>
</body>
</html>