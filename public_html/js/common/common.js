
function sendRequest(language){
    alert("inside send funtion ");
    debugger;
    var url = serverUrl+lstrCtxPath+"/do/serv00222?appId=webbkg&first_login=first&language="+language;
    $.ajax({
		method: "POST",		
		async: true,
		cache: false,
		url: url,
		contentType: "application/json;",
		traditional: true,
		dataType: 'text',
		
		success: function () {
		 alert("inside success funtion ");
			window.location.reload();
		},
		error: function (error, textStatus, jqXHR) {
			//process error msg
			
			//errorFunction.apply(this, [data]);
		},
	}); 
  

    
         
} 