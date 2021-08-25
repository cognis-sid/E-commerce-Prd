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
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page
	import="com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceRegistrationUim"%>
<%@page import="java.util.List"%>

<%
	String strServerName = request.getServerName();
String strServerPort = "" + request.getServerPort();
String lstrCtxPath = request.getContextPath();

String strUserid = (String) request.getParameter("userid");
String strAppId = (String) request.getParameter("appId");
if (strAppId == null || "".equals(strAppId)) {
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
<link rel="stylesheet"
	href="<%=contextPath%>/css/libraries/bootstrap.css" />
<link rel="stylesheet" href="<%=contextPath%>/css/site.css" />
<link rel="stylesheet" href="<%=contextPath%>/css/custom-chart.css" />

<script src="https://kit.fontawesome.com/cfc9fdee3b.js"
	crossorigin="anonymous"></script>
<script type="text/javascript" src="<%=contextPath%>/js/jquery-3.5.1.js"></script>
 <jsp:include page="../../pages/common/cognis/commonInclude.jsp"></jsp:include>
<link rel="stylesheet"
	href="<%=contextPath%>/css/libraries/bootstrap.css" />
<script src="<%=contextPath%>/js/libraries/jquery-3.5.1.js"></script>
<script src="<%=contextPath%>/js/libraries/popper.js"></script>
<script src="<%=contextPath%>/js/libraries/bootstrap.js"></script>
<script src="<%=contextPath%>/js/registration.js"></script>
<link rel="stylesheet" href="<%=lstrCtxPath%>/css/site.css" />
<link rel="stylesheet" href="<%=lstrCtxPath%>/css/login-new.css" />
<script src="https://kit.fontawesome.com/cfc9fdee3b.js"
	crossorigin="anonymous"></script>

<script language="JavaScript">
		var  LOAD_REGISTRATION_PAGE         = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn007", pageContext)%>';
		
		</script>
</head>
<body class="login-background">
${userUim.password}
	<form action="<%=lstrCtxPath%>/do/servadmin00666" mathod="POST">
		<!-- Start Of Nav Bar -->
	
  			<jsp:include page="../../pages/common/cognis/header.jsp"></jsp:include>
  
<!-- Start Of Nav Bar -->
	
  			
  
  <!-- End Of Nav Bar -->
		<!-- Start Of Vertical Menu -->
		<div class="login-body">
			<!-- <div class="container-fluid login-background" id="loginFormDiv">  cognis need to check-->
			<%-- <div class="row justify-content-md-center">
				<div class="col-md-4">
					<div class="row">
						<div class="col text-center">
							<h2>
								<strong><bean:message key="forgetPassword.title" /></strong>
								
								
							</h2>

						</div>
					</div> --%>
					<c:if test="${empty userUim.dbPasword}">
					 <div id="panel_bhumnet" class="login-wrapper">
	
                                <div class="login-header">
                                    <div class="login-header-text"><bean:message key="forgetPassword.title"/></div>
                                </div>
                                <div class="login-form">
                                    <div class="login-row">
                                        <div class="login-text"><bean:message key="forgetPassword.userId"/></div>
                                        <input name="loginId" maxlength="30" placeholder="<bean:message key="logIn.Error_Please_provide_User_ID"/>" id="userId" class="login-field" type="text" required="required" onblur="changeUpper(this)" />
                                    </div>
                                    <div class="login-row">
                                         <div class="login-text"><bean:message key="forgetPassword.Email_Address"/></div>
                                        <input name=email type="text" maxlength="30" id="email"  class="login-field" required="required"/>
                                    </div>
                                  </div>  
                                 <div class="login-btn-row">
                                     <input type="submit" value="<bean:message key="forgetPassword.Submit"/>" onclick="openScreen()" class="submit-button css300"/>
                                     <div class="row mt-2 text-light-blue">
                  <%--             <div class="login-text-link css300"><a href="<%=lstrCtxPath%>/do/sexn007"><span class="login-mini-text"><bean:message key="forgetPassword.dontHaveAccnt"/></span> <bean:message key="forgetPassword.createNewAccount"/></a></div>
                              <div class="login-text-link css300"><a href="<%=lstrCtxPath%>/do/serv00111"><bean:message key="header.Login" /></a></div>
                 --%>         </div>
                       </div>  
					<%-- <div>
						<div class="form-group">
							<label for="inputEmailAddress"><bean:message
									key="forgetPassword.userId" /></label> <input type="text"
								class="form-control" id="userId" name="userId">
						</div>
						<div class="form-group">
							<label for="inputPassword"><bean:message
									key="forgetPassword.Email_Address" /></label> <input type="text"
								name="email" class="form-control" id="email">
						</div>
						<div class="form-row mt-3">
							<div class="checkbox col-md-6"></div>
							<div class="col-md-6 text-light-blue"></div>
						</div>
						<div class="row mt-3">
							<div class="col">
								<button class="btn btn-primary btn-block" onclick="openScreen()">
									<bean:message key="forgetPassword.Submit" />
								</button>


							</div>
						</div>
						<div class="row mt-2 text-light-blue">
							<div class="col"><bean:message key="forgetPassword.dontHaveAccnt"/><a href="#"
									onclick="callRegistrationPage()"
									class="float-right text-light-blue"><bean:message key="forgetPassword.createNewAccount"/></a>
							</div>
						</div>
					</div> --%>
					</c:if>
				
				</div>
			</div>
		</div>
	</form>
	<!-- End Of Vertical Menu -->
	<script type="text/javascript">
 
		function openScreen() {
			 
			document.forms[0].submit();
			 
		}
	
    
	
	</script>
	  <script>
	  var LOGOUT_URL = "../do/servAdmin";
      $(document).ready(function () {   
    	  debugger;
    	  var pass = '${internaluserUim.dbPasword}';
    	  //alert(pass)
	    	 if(pass.length != 0){
	    		
	    		 swal("Message","Your Password is sent on your mail","info")
					.then(function(){
						 window.location.href=LOGOUT_URL;
					});
	    	 }
 		});</script>
</body>
</html>