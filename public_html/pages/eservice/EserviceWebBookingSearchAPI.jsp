<%@ page language="java" contentType="application/json; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   
    <%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page import="com.niit.control.common.GlobalConstants" %>
<%@page import="com.niit.control.web.action.BaseAction" %>
<%@page import="com.niit.control.web.UserAccountBean" %>
<%@page import="com.niit.control.common.StringUtil" %>
<%@page import="com.niit.control.common.ComboVO" %>
<%@ page import="com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceRegistrationUim" %>
<%@page import="java.util.List" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%

String strServerName = request.getServerName();
String strServerPort = ""+request.getServerPort();
String lstrCtxPath = request.getContextPath();

String strUserid = (String)request.getParameter("userid");
String strAppId = (String) request.getParameter("appId");
if(strAppId == null || "".equals(strAppId)){
    strAppId = "webbkg";
}
    String contextPath = request.getContextPath();

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta content="text/html; charset=utf-8" http-equiv="content-type" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Login | Regional Container Lines</title>

<jsp:include page="../../pages/common/cognis/commonInclude.jsp"></jsp:include>

<link rel="stylesheet" href="<%=contextPath%>/css/libraries/site.css" />
 
<script src="<%=contextPath%>/js/libraries/bootstrap-datetimepicker.js"></script>
    
    <script language="JavaScript">
        var ON_LOAD_BOOKING_INQUIRY                     = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn002", pageContext)%>';
    </script>  
   
</head>
<body>

<form action="/serv00444" method="POST">
		<!-- Start Of Nav Bar -->
	
		<jsp:include page="../../pages/common/cognis/header.jsp"></jsp:include>
		<input type="hidden" name="loginDateCheck" id="loginDateCheck"  value="${sessionScope.sUserAccountBean.dateFormat}"/>
		<!-- End Of Nav Bar -->



		<div class="rcl-content">
			<nav aria-label="breadcrumb" class="mt-2">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="dashboard.html"><bean:message
							key="search.Dashboard" /></a></li>
				<li class="breadcrumb-item active" aria-current="page"><bean:message
						key="search.Schedule_Selection" /></li>
			</ol>
			</nav>
			<!-- Start Of Page -->
			<div class="content-container content-height">
				<div class="left-menu pt-3">
					<div class="form-group">
						<label for="portOfLoad"><bean:message
								key="search.Port_of_Load" /></label>
						<div class="input-icons">
							 
							   <select class="form-control input-field js-example-tags" name="pol" id="pol" >
										<option selected="selected" value=""><bean:message key="search.Select_Pol" /></option>
									<c:forEach var="listValue" items="${feserv12.contryList}">
										<option  value="${listValue.code}">${listValue.contryName} - ${listValue.code}</option>
									</c:forEach>
					  		</select>   
					  		<%--<select class="form-control basicAutoSelect"   
    								placeholder="Select Pol" id="pol" name="pol"
    								data-url="./serv00444PolPod" autocomplete="on" minLength="2" 
    								noResultsText="NO data found">--%>
    						</select>
						</div>
					</div>
					<div class="form-group">
						<label for="portOfDischarge"><bean:message
								key="search.Port_of_Discharge" /> </label>
						<div class="input-icons">
							
							  <select class="form-control input-field  js-example-tags" name="pod" id="pod" >
										<option selected="selected" value=""><bean:message key="search.Select_Pod" /></option>
									<c:forEach var="countryCode" items="${feserv12.contryList}">
										<option value="${countryCode.code}">${countryCode.contryName} - ${countryCode.code}</option>
									</c:forEach>
					  		</select> 
					  	<%-- 	<select class="form-control basicAutoSelect"   
    								placeholder="Select Pod" id="pod" name="pod"
    								data-url="./serv00444PolPod" autocomplete="on" minLength="2" 
    								noResultsText="NO data found">--%> 
    						</select>
					  		
						</div>
					</div>
					<div class="form-row">
						<div class="col">
							<label for="etd" style="font-size:15px"><bean:message key="search.ETD" /> </label>
							<div class="input-icons">
								<i class="fas fa-calendar-alt icon"></i> <input type="text"
									id="etdDates" class="form-control  input-field  date-picker"   >
							</div>
						</div>
						<div class="col">
							<label for="eta" style="font-size:15px"><bean:message key="search.ETA" /> </label>
							<div class="input-icons">
								<i class="fas fa-calendar-alt icon"></i> <input type="text"
									id="etaDates" class="form-control input-field  date-picker"  >
							</div>
						</div>
					</div>
					<%-- <div class="form-group quantity-selector"
						data-increment="Containers">
						<label for="containerCOunt"><bean:message
								key="search.Container" /> </label>
						<div class="input-icons">
							<i class="fas fa-subway icon"></i> <input type="text"
								class="form-control input-field" id="containerCOunt"
								aria-describedby="emailHelp" value="1" placeholder="Containers">
							<div class="quantity-selector-box"
								id="mobile-FlySearchPassengers">
								<div class="quantity-selector-inner">
									<p class="quantity-selector-title">
										<bean:message key="search.Container" />
									</p>
									<ul class="quantity-selector-controls">
										<li class="quantity-selector-decrement"><a href="#">&#45;</a>
										</li>
										<li class="quantity-selector-current">1</li>
										<li class="quantity-selector-increment"><a href="#">&#43;</a>
										</li>
									</ul>
								</div>
							</div>
						</div>
					</div> --%>
					<button type="button" class="btn btn-light-blue btn-block"
						style="background-color: #61f2ff;" onclick="search();">
						<bean:message key="search.Submit" />
					</button>
				</div>
				<div class="right-menu">
					<div class="">
						<div class="row ml-1 mr-1">
							<%-- <div class="col-md-1 border-right d-flex align-items-center">
								<h5>
									<strong><bean:message key="search.Sort_By" /> :</strong>
								</h5>
							</div> --%>

							<%-- <div class="col-md-1 border-right cursor-pointer active">
								<h5>
									<strong><bean:message key="search.Duration" /> </strong>
								</h5>
								<h6>
									<bean:message key="search.Long" /> &#8594;
									<bean:message key="search.Short" />
								</h6>
							</div> --%>
							<%-- <div class="col-md-1 border-right cursor-pointer">
								<h5>
									<strong><bean:message key="search.ETD" /></strong>
								</h5>
								<h6>
									<bean:message key="search.Low" />
									&#8594;
									<bean:message key="search.High" />
								</h6>
							</div> --%>
							<%-- <div class="col-md-1 border-right cursor-pointer">
								<h5>
									<strong><bean:message key="search.ETA"/></strong>
								</h5>
								<h6>
									<bean:message key="search.Low" />
									&#8594;
									<bean:message key="search.High" />
								</h6>
							</div> --%>
							<%-- <div class="col-md-1 cursor-pointer">
								<h5>
									<strong><bean:message key="search.Bookings" /> </strong>
								</h5>
								<h6>A &#8594; Z</h6>
							</div> --%>
							<%-- <div class="col-md-7">
								<div class="dropdown show  float-right pt-3">
									<a class="dropdown-toggle" href="#" role="button"
										id="moreSortOptionDropdown" data-toggle="dropdown"
										aria-haspopup="true" aria-expanded="false"> <bean:message
											key="search.More" />
									</a>
									<div class="dropdown-menu  dropdown-menu-right"
										aria-labelledby="moreSortOptionDropdown">
										<a class="dropdown-item" href="#"> </a> <a class="dropdown-item" href="#"> </a> <a class="dropdown-item" href="#"> </a>
									</div>
								</div>
							</div>
						</div> --%>
						<div class="row right-row mt-3 ml-1 mr-1" style="width:100%">
							<div class="col-md-2">
								<h5><bean:message key="search.ETD" /></h5>
							</div>
							<div class="col-md-6 border-left">
								<h5><bean:message key="search.Duration" /></h5>
							</div>
							<div class="col-md-2  border-left">
								<h5><bean:message key="search.bookingStatus" /></h5>
							</div>
							<div class="col-md-2"></div>
						</div>

  						<jsp:include page="../../pages/common/cognis/alert.jsp"></jsp:include>
  
						<div id="result"
							class="right-row mt-3 ml-1 mr-1 row-booking-wrapper" style="height:500px"></div>

					</div>
				</div>
			</div>
		</div>
		<div class="clearfix"></div>
</div>
</form>
	<!-- End of Page -->
 
	<!-- End Of Script Section -->

<script>
	
    $(document).ready(function () {
   	debugger; 
   	
   	$(".js-example-tags").select2({
        tags: true
      });
   	
	if($("#loginDateCheck").val()==null || $("#loginDateCheck").val()==""){
    		  window.location.href="../do/sexn007usePassword";
    } 
	  debugger;
	   var etdDate = new Date();
	  etdDate.setDate(etdDate.getDate() + 3); 
	
	  $('#etdDates').datetimepicker({
        format: 'DD/MM/YYYY',
		defaultDate: etdDate,
		minDate : 	etdDate,
      }).on('dp.change', function (e) {
        console.log(e.date);
        var date = new Date(e.date);
        date.setDate(date.getDate() + 15);
        
        var st = $('#etaDates').val().replaceAll('/','.');
		var pattern = /(\d{2})\.(\d{2})\.(\d{4})/;
		var dt = new Date(st.replace(pattern,'$3-$2-$1'));
        
        if(new Date(e.date)>dt){
		$('#etaDates').data("DateTimePicker").maxDate(new Date(date));
		$('#etaDates').data("DateTimePicker").date(new Date(date));
		$('#etaDates').data("DateTimePicker").minDate(new Date(e.date));
		}else{
		$('#etaDates').data("DateTimePicker").minDate(new Date(e.date));
		$('#etaDates').data("DateTimePicker").maxDate(new Date(date));
		$('#etaDates').data("DateTimePicker").date(new Date(date));
		}
		});
	  
	  var etaDate=new Date(etdDate);
	  etaDate.setDate(etaDate.getDate()+15);
	  
	  $('#etaDates').datetimepicker({
        format: 'DD/MM/YYYY',
		defaultDate : etaDate,
		maxDate : etaDate,
		minDate : etdDate,
      });
      $('#etaDates').data("DateTimePicker").date(new Date(etaDate));
      
      
		debugger;
		getContry();
							
	});
	
	function search(){
	debugger;
	if(!checkRequired()){
    		 return ;
    	 }
	loading();
	//alert("Search()");  //ETD= Today+3 days, ETA>ETD
	var pol =  $('[name=pol]').val();
	var pod =  $('[name=pod]').val();
	var eta =  $("#etaDates").val();
	var etd =  $("#etdDates").val();
	var containerCOunt = $("#containerCOunt").val();
	//var url="http://zebra-ce.rclgroup.com:8080/RWSWebApp/rclws/productcatalog/getproductcatalog"+"?pol="+pol+"&pod="+pod+"&pol_etd_date="+etd+"&transhipment_service="+containerCOunt;
	debugger;
	
	var url="../do/search"+"?pol="+pol+"&pod="+pod+"&pol_etd_date="+etd ;
	$.ajax({
		method: "POST",		
		async: true,
		cache: false,
		url: url,
		
		dataType: 'json',
		
		contentType: "application/json;",
		traditional: true,
		
		success: function (dataResponse) {
		    loading(true);
		    var displaycount=0;
		    debugger;
		    var newDiv='<div style="none"></div>';
		    document.getElementById("result").innerHTML = newDiv;
			var searchDuplicatRecordList=[];
			var serviceDtls={};
			if(dataResponse.obj.msg!=undefined){
				swal("Message", dataResponse.obj.msg.error , "info");
			}else{
			if(dataResponse.obj[0].productcatalog!=undefined){
					serviceDtls=dataResponse.obj[1];
					dataResponse = dataResponse.obj[0].productcatalog;
					dataResponse=dataResponse.sort(function(a, b){return convertDateToDateObject(a.ESTIMATED_TIME_DEP) - convertDateToDateObject(b.ESTIMATED_TIME_DEP)})
			}else{
					serviceDtls=dataResponse.obj[0];
					dataResponse = dataResponse.obj[1].productcatalog;
					dataResponse=dataResponse.sort(function(a, b){return convertDateToDateObject(a.ESTIMATED_TIME_DEP) - convertDateToDateObject(b.ESTIMATED_TIME_DEP)})
			}
			
			
			console.log(dataResponse);
			debugger;
			if(dataResponse.length==0){
			loading(true);
			swal("Message", "No schedule found. Please contact our local agency" , "info");
			
			}
			 
			debugger;
			for (i = 0; i < dataResponse.length; i++) {
				var count;
				var searchDuplicatRecordobj={};
				
        		if(convertDateToDateObject(dataResponse[i].ESTIMATED_TIME_DEP)>convertDateToDateObject($('#etaDates').val())){
							displaycount++
							continue;        				
        		}
        		
        		if(dataResponse[i].POT1!=null && dataResponse[i].POT1!=''){
        			if(dataResponse[i].SERVICE!=null && dataResponse[i].SERVICE!=''){
		        		if(serviceDtls[dataResponse[i].SERVICE]!=undefined){
		        			 if(serviceDtls[dataResponse[i].SERVICE].tsValue=="N"){
			        			 displaycount++
								 continue;
		        			 }else{
		        			 	if(serviceDtls[dataResponse[i].SERVICE].pot1!=dataResponse[i].POT1){
		        			 		 displaycount++
								 	 continue;
		        			 	}
		        			 }
		        		}else{
		        			 displaycount++
							 continue;
		        		}
        			}
	        		if(dataResponse[i].POL.substring(0, 2)==dataResponse[i].POT1.substring(0, 2)){
	        			if(dataResponse[i].POL.substring(0, 2)=='CN'){
	        				if(dataResponse[i].SERVICE != 'AFS'){
	        					displaycount++
								continue; 
								}
						}
	        		}
        		}else{
        			if(dataResponse[i].SERVICE!=null && dataResponse[i].SERVICE!=''){
		        		if(serviceDtls[dataResponse[i].SERVICE]!=undefined){
		        		  if(serviceDtls[dataResponse[i].SERVICE].pot1==null || serviceDtls[dataResponse[i].SERVICE].pot1==""){
			        		  if(serviceDtls[dataResponse[i].SERVICE].effectivedate!=null && serviceDtls[dataResponse[i].SERVICE].expireddate!=null){
			        			if(convertServiceDateToDateObject(serviceDtls[dataResponse[i].SERVICE].effectivedate)<convertDateToDateObject(dataResponse[i].ESTIMATED_TIME_DEP) 
			        			&& convertDateToDateObject(dataResponse[i].ESTIMATED_TIME_DEP)< convertServiceDateToDateObject(serviceDtls[dataResponse[i].SERVICE].expireddate)){
				        			     console.log("check the log");
									 }else{
										 displaycount++
										 continue;
									 }
								} 
							}else{
			        			 displaycount++
								 continue;
		        			}
		        		}else{
		        			 displaycount++
							 continue;
		        		}
        			}	
        		}
        		
          		if(searchDuplicatRecordList.length==0){
          			searchDuplicatRecordobj["from_terminal"]=dataResponse[i].FROM_TERMINAL;
          			searchDuplicatRecordobj["to_terminal"]=dataResponse[i].TO_TERMINAL;
          			searchDuplicatRecordobj["POT1"]=dataResponse[i].POT1;
          			searchDuplicatRecordobj["VESSEL"]=dataResponse[i].VESSEL;
          			searchDuplicatRecordobj["VOYAGE"]=dataResponse[i].VOYAGE;
          			searchDuplicatRecordobj["SERVICE"]=dataResponse[i].SERVICE;
          			
          			searchDuplicatRecordList.push(searchDuplicatRecordobj);	
          		}	else{
          			var count=0;
	          		for(var l=0;l<searchDuplicatRecordList.length;l++){  
	          			if(searchDuplicatRecordList[l].POT1==dataResponse[i].POT1  &&
          								searchDuplicatRecordList[l].VESSEL==dataResponse[i].VESSEL  &&
          								searchDuplicatRecordList[l].VOYAGE==dataResponse[i].VOYAGE  &&
          								searchDuplicatRecordList[l].SERVICE==dataResponse[i].SERVICE){
	          						count++;	
	          						break;	
	          			
	          			}
	          		}
          		}
          		if(count!=undefined && count>0){
          			continue;
          		}else{
          			searchDuplicatRecordobj["from_terminal"]=dataResponse[i].FROM_TERMINAL;
          			searchDuplicatRecordobj["to_terminal"]=dataResponse[i].TO_TERMINAL;
          			searchDuplicatRecordobj["POT1"]=dataResponse[i].POT1;
          			searchDuplicatRecordobj["VESSEL"]=dataResponse[i].VESSEL;
          			searchDuplicatRecordobj["VOYAGE"]=dataResponse[i].VOYAGE;
          			searchDuplicatRecordobj["SERVICE"]=dataResponse[i].SERVICE;
          			searchDuplicatRecordList.push(searchDuplicatRecordobj);
          		}
          		if(displaycount==dataResponse.length){
          			swal("Message", "No schedule found. Please contact our local agency" , "info");
          		}
		 debugger;
		 newDiv +='<hr class="mt-0 mb-0" /><div class="row"><div class="col-md-2 etd-details"> <div class="etd-place-name">'+dataResponse[i].POL+'-'+listofContry[dataResponse[i].POL]+'</div>'+
                '<div ><strong>('+listOfTerminal[dataResponse[i].FROM_TERMINAL]+')</strong></div>'+
                '<div class="etd-date">'+dataResponse[i].ESTIMATED_TIME_DEP+'</div><div class="etd-footer">   </div>'+
              	'</div><div class="col-md-6"><br><div class="md-stepper-horizontal blue"><div class="md-step active"><div class="md-step-title-top"><i class="" aria-hidden="true"></i></div>'+
                    '<div class="md-step-circle"><span>1</span></div><div class="md-step-title">'+dataResponse[i].POL+'</div><div class="md-step-bar-left"></div> <div class="md-step-bar-right"></div>'+
                '</div>' ;
				   if(dataResponse[i].POT1==null && dataResponse[i].POT2==null){
				               newDiv +=          '<div class="md-step active">'+
                    '<div class="md-step-title-top"><i class="" aria-hidden="true"></i></div>'+
                    '<div class="md-step-circle"><span>2</span></div>'+
                    '<div class="md-step-title">'+dataResponse[i].POD.split('|')[0]+'</div>'+
                    '<div class="md-step-bar-left"></div>'+
                    '<div class="md-step-bar-right"></div>'+
                  '</div>'+
                '</div>'+
                '<div align="center"><strong style="font-size:18px">'+dataResponse[i].VESSEL_NAME+' / '+dataResponse[i].VOYAGE+'</strong></div>'+
              '</div>'+
              '<div class="col-md-2 etd-details">'+
                '<div class="etd-place-name">'+dataResponse[i].POD.split('|')[0] +'-'+ listofContry[dataResponse[i].POD.split('|')[0]]+'</div>'+
                '<div ><strong>('+listOfTerminal[dataResponse[i].POD.split('|')[1]]+')</strong></div>'+
                '<div class="etd-date">'+dataResponse[i].ESTIMATED_TIME_ARR+'</div>'+
              '</div>'+
              '<div class="col-md-2 etd-button-book-now">'+
                 '<a href="javascript:openScreen('+"'"+dataResponse[i].VESSEL+"'"+','+"'"+dataResponse[i].VESSEL_NAME+"'"+','+"'"+dataResponse[i].VOYAGE+"'"+','+"'"+dataResponse[i].ESTIMATED_TIME_DEP+"'"+','+"'"+dataResponse[i].ESTIMATED_TIME_ARR+"'"+','+"'"+dataResponse[i].POL+"'"+','+"'"+dataResponse[i].POD.split('|')[0]+"'"+','+"'"+dataResponse[i].POD.split('|')[1]+"'"+','+"'"+dataResponse[i].DIRECTION+"'"+','+"'"+dataResponse[i].SERVICE+"'"+','+"'"+dataResponse[i].POT1+"'"+','+"'"+dataResponse[i].POT2+"'"+','+"'"+dataResponse[i].FROM_TERMINAL+"'"+','+"'"+dataResponse[i].POL_ESTIMATED_TIME_ARR+"'"+','+"'"+dataResponse[i].TO_LOCATION+"'"+','+"'"+dataResponse[i].TO_TERMINAL+"'"+')" class="btn btn-primary"><i class="fas fa-ticket-alt" aria-hidden="true"></i>&nbsp;<bean:message key="search.bookNow" /></a>'+
              '</div>'+
			  '</div>';
				   }
				   else{
				 if(dataResponse[i].POT1==null){

newDiv += '<div class="md-step active">'+
'<div class="md-step-circle"><span>2</span></div>'+
'<div class="md-step-title">POT2</div>'+
'<div class="md-step-bar-left"></div>'+
'<div class="md-step-bar-right"></div>'+
'</div>'+
'<div class="md-step active">'+
'<div class="md-step-title-top"><i class="" aria-hidden="true"></i></div>'+
'<div class="md-step-circle"><span>3</span></div>'+
'<div class="md-step-title">'+dataResponse[i].POD.split('|')[0]+'</div>'+
'<div class="md-step-bar-left"></div>'+
'<div class="md-step-bar-right"></div>'+
'</div>'+
'</div>'+
'<div align="center"><strong style="font-size:18px">'+dataResponse[i].VESSEL_NAME+' / '+dataResponse[i].VOYAGE+'</strong></div>'+
'</div>'+
'<div class="col-md-2 etd-details">'+
'<div class="etd-place-name">'+dataResponse[i].POD.split('|')[0] +'-'+ listofContry[dataResponse[i].POD.split('|')[0]]+'</div>'+
'<div ><strong>('+listOfTerminal[ dataResponse[i].POD.split('|')[1]]+')</strong></div>'+
'<div class="etd-date">'+dataResponse[i].ESTIMATED_TIME_ARR+'</div>'+
'</div>'+
'<div class="col-md-2 etd-button-book-now">'+
  '<a href="javascript:openScreen('+"'"+dataResponse[i].VESSEL+"'"+','+"'"+dataResponse[i].VESSEL_NAME+"'"+','+"'"+dataResponse[i].VOYAGE+"'"+','+"'"+dataResponse[i].ESTIMATED_TIME_DEP+"'"+','+"'"+dataResponse[i].ESTIMATED_TIME_ARR+"'"+','+"'"+dataResponse[i].POL+"'"+','+"'"+dataResponse[i].POD.split('|')[0]+"'"+','+"'"+dataResponse[i].POD.split('|')[1]+"'"+','+"'"+dataResponse[i].DIRECTION+"'"+','+"'"+dataResponse[i].SERVICE+"'"+','+"'"+dataResponse[i].POT1+"'"+','+"'"+dataResponse[i].POT2+"'"+','+"'"+dataResponse[i].FROM_TERMINAL+"'"+','+"'"+dataResponse[i].POL_ESTIMATED_TIME_ARR+"'"+','+"'"+dataResponse[i].TO_LOCATION+"'"+','+"'"+dataResponse[i].TO_TERMINAL+"'"+')" class="btn btn-primary"><i class="fas fa-ticket-alt" aria-hidden="true"></i>&nbsp;<bean:message key="search.bookNow" /></a>'+
'</div>'+
'</div>';

}

else if(dataResponse[i].POT2==null){

newDiv += '<div class="md-step active">'+
'<div class="md-step-circle"><span>2</span></div>'+
'<div class="md-step-title">POT1</div>'+
'<div class="md-step-bar-left"></div>'+
'<div class="md-step-bar-right"></div>'+
'</div>'+
'<div class="md-step active">'+
'<div class="md-step-title-top"><i class="" aria-hidden="true"></i></div>'+
'<div class="md-step-circle"><span>3</span></div>'+
'<div class="md-step-title">'+dataResponse[i].POD.split('|')[0]+'</div>'+
'<div class="md-step-bar-left"></div>'+
'<div class="md-step-bar-right"></div>'+
'</div>'+
'</div>'+
'<div align="center"><strong style="font-size:18px">'+dataResponse[i].VESSEL_NAME+' / '+dataResponse[i].VOYAGE+'</strong></div>'+
'</div>'+
'<div class="col-md-2 etd-details">'+
'<div class="etd-place-name">'+dataResponse[i].POD.split('|')[0] +'-'+ listofContry[dataResponse[i].POD.split('|')[0]]+'</div>'+
'<div ><strong>('+listOfTerminal[dataResponse[i].POD.split('|')[1]]+')</strong></div>'+
'<div class="etd-date">'+dataResponse[i].ESTIMATED_TIME_ARR+'</div>'+
'</div>'+
'<div class="col-md-2 etd-button-book-now">'+
 '<a href="javascript:openScreen('+"'"+dataResponse[i].VESSEL+"'"+','+"'"+dataResponse[i].VESSEL_NAME+"'"+','+"'"+dataResponse[i].VOYAGE+"'"+','+"'"+dataResponse[i].ESTIMATED_TIME_DEP+"'"+','+"'"+dataResponse[i].ESTIMATED_TIME_ARR+"'"+','+"'"+dataResponse[i].POL+"'"+','+"'"+dataResponse[i].POD.split('|')[0]+"'"+','+"'"+dataResponse[i].POD.split('|')[1]+"'"+','+"'"+dataResponse[i].DIRECTION+"'"+','+"'"+dataResponse[i].SERVICE+"'"+','+"'"+dataResponse[i].POT1+"'"+','+"'"+dataResponse[i].POT2+"'"+','+"'"+dataResponse[i].FROM_TERMINAL+"'"+','+"'"+dataResponse[i].POL_ESTIMATED_TIME_ARR+"'"+','+"'"+dataResponse[i].TO_LOCATION+"'"+','+"'"+dataResponse[i].TO_TERMINAL+"'"+')" class="btn btn-primary"><i class="fas fa-ticket-alt" aria-hidden="true"></i>&nbsp;<bean:message key="search.bookNow" /></a>'+
'</div>'+
'</div>';

}
			else{ newDiv += '<div class="md-step active"><div class="md-step-circle"><span>2</span></div>'+
			' <div class="md-step-title">POT1</div><div class="md-step-bar-left"></div><div class="md-step-bar-right"></div> </div>'+
			'<div class="md-step active">'+
			'<div class="md-step-circle"><span>3</span></div>'+
			'<div class="md-step-title">POT2</div>'+
			'<div class="md-step-bar-left"></div>'+
			'<div class="md-step-bar-right"></div>'+
			'</div>'+
			'<div class="md-step active">'+
			'<div class="md-step-title-top"><i class="" aria-hidden="true"></i></div>'+
			'<div class="md-step-circle"><span>4</span></div>'+
			'<div class="md-step-title">'+dataResponse[i].POD.split('|')[0]+'</div>'+
			'<div class="md-step-bar-left"></div>'+
			'<div class="md-step-bar-right"></div>'+
			'</div>'+
			'</div>'+
	'<div align="center"><strong style="font-size:18px">'+dataResponse[i].VESSEL_NAME+' / '+dataResponse[i].VOYAGE+'</strong></div>'+
			'</div>'+
			'<div class="col-md-2 etd-details">'+
			'<div class="etd-place-name">'+dataResponse[i].POD.split('|')[0] +'-'+ listofContry[dataResponse[i].POD.split('|')[0]]+'</div>'+
			'<div ><strong>('+listOfTerminal[dataResponse[i].POD.split('|')[1]]+')</strong></div>'+
			'<div class="etd-date">'+dataResponse[i].ESTIMATED_TIME_ARR+'</div>'+
			'</div>'+
			'<div class="col-md-2 etd-button-book-now">'+
			 '<a href="javascript:openScreen('+"'"+dataResponse[i].VESSEL+"'"+','+"'"+dataResponse[i].VESSEL_NAME+"'"+','+"'"+dataResponse[i].VOYAGE+"'"+','+"'"+dataResponse[i].ESTIMATED_TIME_DEP+"'"+','+"'"+dataResponse[i].ESTIMATED_TIME_ARR+"'"+','+"'"+dataResponse[i].POL+"'"+','+"'"+dataResponse[i].POD.split('|')[0]+"'"+','+"'"+dataResponse[i].POD.split('|')[1]+"'"+','+"'"+dataResponse[i].DIRECTION+"'"+','+"'"+dataResponse[i].SERVICE+"'"+','+"'"+dataResponse[i].POT1+"'"+','+"'"+dataResponse[i].POT2+"'"+','+"'"+dataResponse[i].FROM_TERMINAL+"'"+','+"'"+dataResponse[i].POL_ESTIMATED_TIME_ARR+"'"+','+"'"+dataResponse[i].TO_LOCATION+"'"+','+"'"+dataResponse[i].TO_TERMINAL+"'"+')" class="btn btn-primary"><i class="fas fa-ticket-alt" aria-hidden="true"></i>&nbsp;<bean:message key="search.bookNow" /></a>'+
			'</div>'+
			'</div>'; } 
			
			}  //else_End
		 
		 
		 
        }
        if(displaycount==dataResponse.length){
          			swal("Message", "No schedule found. Please contact our local agency" , "info");
          		}
		document.getElementById("result").innerHTML = newDiv;	
		}	
		},
		error: function (error, textStatus, jqXHR) {
		debugger;
		    loading(true);
			//process error msg
			swal("Message", somthingwentWrong , "info");
			
			//errorFunction.apply(this, [data]);
		},
	});

}
	
	function checkRequired(){
	
		  $("#alertId").hide();
    	  var index=2;
    	  var isValid=true;
    	  if($("#pol").val()== ""){    		   
    		  $("#pol").parsley().validate(true);    		
    		  $("#"+ $("#pol").attr("aria-describedby")+" li").html("Please provide POL.");
    		  isValid =false;
    		  index--; 		 
    	  }
    	  
          if($("#pod").val()== ""){          	             
          	 $("#pod").parsley().validate(true);    		
   		 	 $("#"+ $("#pod").attr("aria-describedby")+" li").html("Please provide POD.");
   		 	 isValid =false;
   		 	index--;
          }
	 return isValid;
	}
	
	 var lstrCtxPath = '<%=lstrCtxPath%>';
    <%
    	String protocal ="http";
    if(request.isSecure()){
  	  protocal="https";
    }
    %>
    var serverUrl = '<%=protocal+"://" + strServerName + ":" + strServerPort%>'; 
    
	  var txtPwd  =  "";
	  var userId = "";
	  var screen_id = 'sexn001';
	  var screenWidth = aw-5;
	  var screenHeight= ah-54;
	  var x = aw>800?(aw-screenWidth)/2:0;
	  var y = ah>600?(ah-screenHeight)/2:0;
	//  var screen_url=serverUrl+lstrCtxPath+"/do/sexn001?appId=webbkg&first_login=first&txtUserId="+userId+"&txtPwd="+txtPwd;
	   
	 function openScreen(vessel,vesselName, voyage, etd, eta, pol, pod, terminal, direction, service, pot1, pot2,formTerminal,vessel_date,toloaction,toTerminal) {
     loading();
     debugger;
	 var screen_url=serverUrl+lstrCtxPath+"/do/sexn001?appId=webbkg&first_login=first&vessel="+vessel+"&vesselName="+vesselName+"&voyage="+voyage+"&etd="+etd+"&eta="+eta+"&pol="+pol+"&pod="+pod+"&terminal="+terminal+"&direction="+direction+"&service="+service+"&pot1="+pot1+"&pot2="+pot2+"&fromTerminal="+formTerminal+"&vesseldate="+vessel_date+"&toLoaction="+toloaction+"&toTerminal="+toTerminal;
	      
	 document.forms[0].action = screen_url;
     document.forms[0].submit();
	 
	  }
	  
	  var THTST =[]; 
	  var listOfTerminal=[];
	  function getContry(){
	  		debugger;
		 // alert("getContry()");
		  var data={};
		  var result1 = {};
		  var url=serverUrl+lstrCtxPath+"/do/serv0555?appId=webbkg&first_login=first";
		  $.ajax({
				method: "POST",		
				async: true,
				cache: false,
				url: url,
				data: JSON.stringify(data),
				contentType: "application/json;",
				traditional: true,
				dataType: 'json',
				
				success: function (data) {
				//  var result1 = JSON.parse(data);
				//	alert("result data = "+result1.length);
				//	listofContry = data.dataResult;
			listofContry = {};
			listOfTerminal = {};	
            for (var i=0; i<data.dataResult.length; i++){
             	 var obj=data.dataResult[i];
                 listofContry[obj.code]=obj.contryName;
            }
            for(var k=0; k<data.terminalResult.length; k++){
           		 var obj=data.terminalResult[k];
                 listOfTerminal[obj.terminalCode]=obj.terminalName;
            }
            	console.log(listOfTerminal);
				//result1 = 	JSON.parse(result.result);    
				//		alert("success" );
				},
				error: function (error, textStatus, jqXHR) {
				alert("Error");
				},
			});

		}
	window.onload = function(){  	
	$("#webBookingModifier").removeClass();
	$("#webBookingModifier").addClass("nav-item active")	
	}	
	function onloadbookingInquiry(){
 		var bookingInquiryURL= ON_LOAD_BOOKING_INQUIRY;
 		document.forms[0].action = bookingInquiryURL;
      	document.forms[0].submit();
	}
	  
	function convertDateToDateObject(date){
		var dateResult = new Date();
		dateResult.setDate(Number(date.split("/")[0]));
		dateResult.setMonth(Number(date.split("/")[1])-1);
		dateResult.setYear(Number(date.split("/")[2]));
	   return dateResult;
	} 
	function convertServiceDateToDateObject(date){
		var dateResult = new Date();
		dateResult.setDate(Number(date.split("-")[2]));
		dateResult.setMonth(Number(date.split("-")[1])-1);
		dateResult.setYear(Number(date.split("-")[0]));
	   return dateResult;
	} 
	function changeUpper(afield)
	{
	  	 return  afield.toUpperCase();
	}
	
	$('.basicAutoSelect').autoComplete({
		resolver: 'custom',
		events: {
		search: function (qry, callback) {
		// let's do a custom ajax call
		$.ajax(
			'./serv00444PolPod',
		{
			data: { 'polPod': qry,'id':$("#pol").val()}
		}
		).done(function (res) {
		 
		callback(res.polPod)
		 
		});
		}
		}
		});
	
  </script>
</body>

</html>