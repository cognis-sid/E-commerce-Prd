<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@page import="com.niit.control.common.GlobalConstants"%>
<%@page import="com.niit.control.web.action.BaseAction"%>
<%@page import="com.niit.control.web.UserAccountBean"%>
<%@page import="com.niit.control.common.StringUtil"%>
<%@page import="com.niit.control.common.ComboVO"%>
<%@ page
  import="com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceRegistrationUim"%>
<%@page import="java.util.List"%>
<%
  String strServerName = request.getServerName();
  String strServerPort = ""+request.getServerPort();
  String lstrCtxPath = request.getContextPath();
  
  String strUserid = (String)request.getParameter("loginId");
  String strAppId = (String) request.getParameter("appId");
  if(strAppId == null || "".equals(strAppId)){
      strAppId = "webbkg";
  }
      String contextPath = request.getContextPath();
  
  %>
<!DOCTYPE html>
<html>
  <head>
    <meta content="text/html; charset=utf-8" http-equiv="content-type" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Login | Regional Container Lines</title>
    <jsp:include page="../../pages/common/cognis/commonInclude.jsp"></jsp:include>
    <script type="text/javascript" src="<%=contextPath%>/js/jquery-3.5.1.js"></script>
    <link rel="stylesheet" href="<%=contextPath%>/css/libraries/bootstrap.css" />
    <script src="<%=contextPath%>/js/registration.js"></script>
    <script src="<%=contextPath%>/js/common/common.js"></script>
    
    <link rel="stylesheet" href="<%=lstrCtxPath%>/css/site.css" />
     <link rel="stylesheet" href="<%=lstrCtxPath%>/css/login-new.css" />
    <script language="JavaScript">
      var LOAD_REGISTRATION_PAGE = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn007", pageContext)%>';
      var ON_LOGIN
		= '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/servAdminLogin", pageContext)%>';
		
	var ON_SUCESS = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn333", pageContext)%>';
	var ON_CREATE= '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv0031", pageContext)%>';
    </script>
    <style>
::placeholder {
  color: #afafaf;
  opacity: 1; /* Firefox */
}

:-ms-input-placeholder { /* Internet Explorer 10-11 */
 color: #afafaf;
}

::-ms-input-placeholder { /* Microsoft Edge */
 color: #afafaf;
}
</style>
</head>
  <div class="login-body">
  <input type="hidden"   id="loginIdTepp"  value="${internaluserUim.loginId }"/>
    <form action="/servAdminLogin" mathod="POST">
     <input type="hidden" name="loginStatus" id="loginStatus"  value="${internaluserUim.loginStatus }"/>
     
     <input type="hidden" name="errorMessage" id="errorMessage"  value="${internaluserUim.errorMessage }"/>
      <!-- Start Of Nav Bar -->
      <jsp:include page="../../pages/common/cognis/header.jsp"></jsp:include>
      <!-- End Of Nav Bar -->
      <!-- Start Of Vertical Menu -->

 
                            <div id="panel_bhumnet" class="login-wrapper">
	
                                <div class="login-header">
                                    <div class="login-header-text"><bean:message key="logIn.welcome.admin"/></div>
                                </div>
                                <div class="login-form">
                                    <div class="login-row">
                                        <div class="login-text"><bean:message key="logIn.User_ID"/></div>
                                        <input name="loginId" maxlength="30" placeholder="<bean:message key="logIn.Error_Please_provide_User_ID"/>"  id="loginId" class="login-field" type="text" required="required" onblur="changeUpper(this)" />
                                    </div>
                                    <div class="login-row">
                                         <div class="login-text"><bean:message key="logIn.password"/></div>
                                        <input name="password" type="password" maxlength="30" id="password" placeholder="<bean:message key="logIn.Error_Please_provide_Password"/>"  class="login-field" required="required"/>
                                    </div>
                                    <span id="errormsgDtls" >&nbsp;</span>
                                     
                                      <div class="login-other-row">
                                        <div class="login-text"></div>
                                        <a class="login-forget login-mini-text" href="<%=contextPath%>/do/adminserv009"><bean:message key="logIn.forgotPassword"/></a>
                                    </div>                                                             
                                    
                                </div>
                                <div class="login-btn-row">
                                     <input type="submit" value="<bean:message key="logIn.submit"/>" onclick="openScreen()" class="submit-button css300"/>
                                     
                       			</div>
                       			
                       		<%--  <div class="login-text-link css300"><a href="<%=lstrCtxPath%>/do/serv0031"> <bean:message key="logIn.createNewAccount"/></a></div> --%>
                       			
                            
                      </div>
           </form>
    </div>
    <!-- End Of Vertical Menu -->
    <script type="text/javascript">
    var lstrCtxPath = '<%=lstrCtxPath%>';
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
      
      
      function callRegistrationPage() {
      	onLoadRegistrationPage = LOAD_REGISTRATION_PAGE;
      	document.forms[0].action = onLoadRegistrationPage + "?appId=webbkg&first_login=first&registMode=R";
      	document.forms[0].submit();
      }
      
      function openScreen() {
    	  $("#errormsgDtls").html('');
    	  if(!userEntry()){
     		 return ;
     	 }
    	  var  loginId= $('#loginId').val();
          var  txtPwd= $('#password').val();
      	document.forms[0].action = ON_LOGIN+"?userId"+loginId+"&password"+txtPwd;
      	document.forms[0].submit();
      }
      
      $(document).ready(function () {
    	  debugger;
    	  $("#errormsgDtls").html('');
    	  var validateLogin=$("#loginStatus").val();
    	  
    	  console.log(validateLogin);
    	 // alert($("#loginIdTepp").val())
    	  if(validateLogin=="true"){
    		
    		  debugger;
    		  /* document.forms[0].action = "./do/sexn002";
    	      document.forms[0].submit(); */
    	      if($("#loginIdTepp").val()=='ADMIN')
    		 	 window.location.href = ON_SUCESS;
    	      else
    	    	  window.location.href = ON_CREATE;
    	      return ;
    	  }
    	   if($("#errorMessage").val()!=null &&  $("#errorMessage").val()!=""){
    		   $("#loginId").val("");
    		   
    		   $("#password").val("");
    		   
    		   $("#loginId").css({
                   "background-color" : "#ffb3b3"
               }).on('change', function (){
            	   $('#loginId').css({"background-color" : "#ffffff"});
               });            
    		   $("#password").css({
                   "background-color" : "#ffb3b3"
               }).on('change', function (){
            	   $('#password').css({"background-color" : "#ffffff"});
               });
    		   
    		   $("#errormsgDtls").css({
                   "color" : "#990000"
               });        
    		   $("#errormsgDtls").css({
                   "fontWeight" : "bold"
               });
    		   $("#errormsgDtls").css({
                   "fontSize" : "10"
               });
    		   
    		   //logIn.err_msg       logIn.Error   '<bean:message key="logIn.Error"/>'
    		   if( $("#errorMessage").val()=="USER_DO_NOT_EXIST"){
    			   swal('<bean:message key="logIn.Error"/>', 'User id does not exist', "error");
    		   }else if( $("#errorMessage").val()=="USER_IS_NOT_APPROVE"){
    			   swal('<bean:message key="logIn.Error"/>', 'User is not approved', "error");
    		   }else if( $("#errorMessage").val()=="WRONG_PASSWORD"){
    			   swal('<bean:message key="logIn.Error"/>', 'Wrong password', "error");
    		   }else{
    		   swal('<bean:message key="logIn.Error"/>', '<bean:message key="logIn.err_msg"/>', "error");
    		   }
    		   //$("#errormsgDtls").html('Provide valid UserId and Password.');
    		  
    	  }
      });
      
      function userEntry(){
    	
    	  var index=2;
    	  var isValid=true;
    	  if($("#loginId").val()== ""){    		   
    		  $("#loginId").parsley().validate(true);    		
    		  $("#"+ $("#userId").attr("aria-describedby")+" li").html('<bean:message key="logIn.Error_Please_provide_User_ID"/>');
    		  isValid =false;
    		  index--; 		 
    	  }
    	  
    	  if($("#password").val()== ""){    		   
    		  $("#password").parsley().validate(true);    		
    		  $("#"+ $("#password").attr("aria-describedby")+" li").html('<bean:message key="logIn.Error_Please_provide_Password"/>');
    		  isValid =false;
    		  index--; 		 
    	  }
    	  
    	  return isValid;
      }
      function changeUpper(afield)
      {
          afield.value = afield.value.toUpperCase();
      }
    </script>
    <!-- End Of Script Section -->
  </body>
  
<style>



input.parsley-error,
select.parsley-error,
textarea.parsley-error {
color: #B94A48;
background-color: #F2DEDE;
border: 1px solid #EED3D7;
}

.parsley-errors-list {
margin: 2px 0 3px;
padding: 0;
list-style-type: none;
font-size: 1.em;
font-weight:bold;
line-height: 0.9em;
opacity: 0;
color: #B94A48;

transition: all .3s ease-in;
-o-transition: all .3s ease-in;
-moz-transition: all .3s ease-in;
-webkit-transition: all .3s ease-in;
}

.parsley-errors-list.filled {
opacity: 1;
}

</style>
</html>