<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
	/*  
		class Test{
		int number = 10;
		String name = "홍길동";
		
		int sum(int a, int b){
			return a+b;
		}
	}
	
	Test myTest = new Test();
	myTest.number;
	
	*/
	
	var jsonObject ={"number":10, "name":"홍길동", "sum":function(a,b){return a+b}}
	console.log(jsonObject.number);
	console.log(jsonObject["name"]);
	console.log(jsonObject.sum(10,30));
	
	var jsonArr = [
		{"name":"정길도", "IQ":200},
		{name:"홍길동", IQ:150}
	];
	
	console.log(jsonArr[1].IQ)
	
	var jsonObject2 = { 
		"fruit_arr":["apple","banana","kiwi","orange"], //배열
		"city_obj":{"name":"sungnam","region":"gyeonggi-do", myObj:{"num":100}} //객체 , 객체 안에 객체
		
	}
	
	console.log(jsonObject2.fruit_arr[2]);
	console.log(jsonObject2.city_obj.region);
	console.log(jsonObject2.city_obj.myObj.num);
	
	
	
</script>

</head>
<body>

</body>
</html>