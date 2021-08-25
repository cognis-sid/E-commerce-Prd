
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
  String contextPath = request.getContextPath();
  String strUserid = (String)request.getParameter("userid");
  String strServerName = request.getServerName();
  String strServerPort = ""+request.getServerPort();
  %>
  <!-- 
<div class="top-nav">
   
  <div class="section-white"></div>
  <div class="section-blue navbar navbar-expand-lg navbar-dark">
     
    <div class="collapse navbar-collapse" id="rclNavBar">
      <ul class="nav nav-blue navbar-nav ml-auto">
      	
       <c:if test="${sessionScope.sUserAccountBean== null}" >
        
      <li class="nav-item">
          <a class="nav-link" href="../do/serv00111">
            <bean:message key="header.Login" />
          </a>
        </li>
        
        </c:if>
         <c:if test="${sessionScope.sUserAccountBean!= null}" >
        
			<c:if test="${sessionScope.sUserAccountBean.getRate == 'Y'}" >        	 	
        	 	  <li class="nav-item " id="GetRateModifier">
					<a class="nav-link" href="#" onclick="callGetrate()"> Rate Inquiry </a>
				 </li>        
        	 </c:if>
        	 <c:if test="${sessionScope.sUserAccountBean.webBooking == 'Y'}" >  
			<li class="nav-item " id="dashboardModifier">
			<a class="nav-link" href="#" onclick="callBookingInquery();"> <bean:message key="header.Dashboard" /> </a>
			</li>
			<li class="nav-item" id="webBookingModifier">
			<a class="nav-link" href="#" onclick="callSearchApi();"><bean:message key="header.Web_Booking" /></a>
			</li>
			<li class="nav-item" id="shippingModifier">
			<a class="nav-link" href="#"  onclick="callShippingInquiry();"><bean:message key="header.shipping" /></a>
			</li>
			       </c:if>
        
        </c:if>
        
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownLanguageLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-language"></i>&nbsp;
            <bean:message key="header.Language" />
          </a>
          <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownLanguageLink">
            <a class="dropdown-item" href="javascript:sendRequest('cn')"><img onclick="sendRequest('cn')" src="<%=contextPath%>/images/flags/CN.png" alt="Chinna" class="language-image">
            &nbsp;<bean:message key="header.Chinese"/></a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="javascript:sendRequest('en')"><img  onclick="sendRequest('en')" src="<%=contextPath%>/images/flags/US.png" alt="English" class="language-image">
            &nbsp;English</a> 
          </div>
        </li>
        
         <c:if test="${sessionScope.sUserAccountBean!= null}" >
         
         <li class="nav-item">
          <a class="nav-link" href="#">
            <bean:message key="header.Last_Login" />
            ${sessionScope.sUserAccountBean.dateFormat}
          </a>
        </li>
        
        
        <li class="nav-item dropdown">
         
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-user-circle"></i>&nbsp;
            <bean:message key="header.My_Account" />
          </a>
          <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">
            <c:if test="${sessionScope.sUserAccountBean!= null}" >
            
            <a class="nav-link dropdown-toggle" href="#" >
            <i class="fas fa-user-circle"></i>&nbsp;
        	    ${sessionScope.sUserAccountBean.customerName}
            
          </a>
            </c:if>
            
            <a class="dropdown-item" href="<%=contextPath%>/do/serv00333">
              <i class="fas fa-user-circle"></i>&nbsp;
              <bean:message key="header.Profile" />
            </a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="javascript:managePortPair();">
              <i class="fas fa-sign-out-alt"></i>&nbsp;
              Manage port pair
            </a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="javascript:logout();">
              <i class="fas fa-sign-out-alt"></i>&nbsp;
              <bean:message key="header.Log_Out" />
            </a>
          </div>
        </li>
        </c:if>
      </ul>
    </div>
  </div>
</div>
<style>
.navbar-nav .nav-link{
	padding-top:0px;
	padding-bottom: 0px;
}
.section-blue {
    height: 30px;
    
}
</style>
<script>

 var sippingValidationMsg='<bean:message key="Commen_Error_Msg.Shipping_Validation" />';
 var editValidationMsg='<bean:message key="Commen_Error_Msg.Edit_Validation" />';
 var canelValidationMsg='<bean:message key="Commen_Error_Msg.Cancel_Validation" />';
 var confirmShippingMsg='<bean:message key="Commen_Error_Msg.SI_Confirm_Validation" />';
 var norecodefound = '<bean:message key="Commen_Error_Msg.No_Recode_Found" />';
 var somthingwentWrong = '<bean:message key="Commen_Error_Msg.Somthing_went_Wrong" />';
 var profilesuccessfullyupdated = '<bean:message key="Commen_Error_Msg.Profile_successfully_updated" />';
 
 
  var ON_LOAD_BOOKING_INQUERY = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn002", pageContext)%>';
  var ON_LOAD_SEARCH_API = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv00444", pageContext)%>';
  var ON_LOAD_SHIPPING_INQUERY = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn010", pageContext)%>';
  
  var ON_LOAD_GET_RATE_INQUERY = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/getRate001", pageContext)%>';
  
  var lstrCtxPath = '<%=contextPath%>';
   
  <%
	String protocal ="http";
if(request.isSecure()){
  protocal="https";
}
%>
var serverUrl = '<%=protocal+"://" + strServerName + ":" + strServerPort%>'; 

  var screen_id = 'sexn001';
  var screenWidth = aw - 5;
  var screenHeight = ah - 54;
  var x = aw > 800 ? (aw - screenWidth) / 2 : 0;
  var y = ah > 600 ? (ah - screenHeight) / 2 : 0;
  var ON_LOGOUT = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv00111", pageContext) %>';
  var screen_url = serverUrl + lstrCtxPath + "/do/serv00444?appId=webbkg&first_login=first&txtUserId=" ;
  
  
  function callBookingInquery(){
		debugger;
		loading();
		document.forms[0].action = ON_LOAD_BOOKING_INQUERY;
	    document.forms[0].submit();
		
	}
	function callSearchApi(){
		debugger;
		loading();
		document.forms[0].action = ON_LOAD_SEARCH_API;
	    document.forms[0].submit();
	}
	function callShippingInquiry(){
		debugger;
		loading();
		document.forms[0].action = ON_LOAD_SHIPPING_INQUERY+"?esiStatusCode=&bookingNo=";
	    document.forms[0].submit();
	}
	 
   
  function logout() {
   
  	var logoutUrl = "../do/logout";
  	document.forms[0].action = logoutUrl;
  	document.forms[0].submit();
  }
  
  function managePortPair() {
	   
	  	var logoutUrl = "../do/serv029";
	  	document.forms[0].action = logoutUrl;
	  	document.forms[0].submit();
	  }
  
  function sendRequest(language) {
  	//alert("inside send funtion ");
  	debugger;
  	var url = serverUrl + lstrCtxPath + "/do/serv00222?appId=webbkg&first_login=first&language=" + language;
  	$.ajax({
  		method: "POST",
  		async: true,
  		cache: false,
  		url: url,
  		contentType: "application/json;",
  		traditional: true,
  		dataType: 'text',
  		success: function() {
  			//alert("inside success funtion ");
  			window.location.reload();
  		},
  		error: function(error, textStatus, jqXHR) {
  			//process error msg
  			//errorFunction.apply(this, [data]);
  		},
  	});
  }
  function loading(isRemove){
	  if(isRemove){
		  $("body").find('.loading').remove(); 
	  }else{
	 	 $( "body" ).append('<div class="loading"></div>'); 
	  }
		
  }
  function loadingRemove(){
	  $("body").find('.loading').remove();
  }
  
  function callGetrate(){
		loading();
		document.forms[0].action = ON_LOAD_GET_RATE_INQUERY;
	    document.forms[0].submit();
	}
</script>
 -->