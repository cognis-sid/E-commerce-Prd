<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="../../pages/common/cognis/commonInclude.jsp"></jsp:include>
</head>
<body>
	<form action="/serverSetting">
		<jsp:include page="../../pages/common/cognis/header.jsp"></jsp:include>
		<div style="padding-top: 150px;">
			<input type="button" class="btn btn-light-blue btn-block"
				value="Re-Start Schedular" onclick="restarTheSchedular()">
			<input type="button" class="btn btn-light-blue btn-block"
				value="Refresh Satting" onclick="refreshTheSatting()">
		</div>
	</form>
</body>
<script>

	function restarTheSchedular(){
		debugger;
		$.ajax({method : "POST",
				async : true,
				url : "../do/reStartSchedualr",
			success: function(result){
				swal("Message", "Schedular successfully Re-started" , "info");
				  }
		});
	}
	
	function refreshTheSatting(){
		debugger;
		$.ajax({method : "POST",
			async : true,
			url : "../do/refreshSetting",
		success: function(result){
			swal("Message", "Setting successfully Refreshed" , "info");
	  			}
		});
	}

</script>
</html>