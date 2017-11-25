var xhr;

function createRequest(){
	if(xhr!=null){
		return;
	}else if(window.ActiveXObject){ //  != undefined
		xhr = new ActiveXObject("Microsoft.XMLHTTP");
	}else{
		xhr = new XMLHttpRequest();
	}
}

function sendRequest(url, param, method, callback, isAsync){
	createRequest();
	
	var httpMethod = "GET";
	if(method.toUpperCase() == "POST"){
		httpMethod = "POST";
	}
	
	var httpParam = param;
	if(param ==''){
		httpParam = null;
	}
	
	var httpURL = url;
	
	if(httpMethod == "GET" && httpParam != null){
		httpURL = HttpURL + "?" + httpParam;
	}
	
	xhr.open(httpMethod, httpURL, isAsync);
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.onreadystatechange = callback;
	
	if(httpMethod == "GET"){
		xhr.send(null);
	}else{
		xhr.send(httpParam);
	}
}