<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ page import="com.niit.control.common.GlobalConstants" %>
<%@ page import="com.niit.control.web.action.BaseAction" %>
<%@ page import="com.niit.control.web.UserAccountBean" %>
<%@ page import="com.niit.control.common.StringUtil" %>
<%@ page import="com.niit.control.common.ComboVO" %>
<%@ page import="com.rclgroup.dolphin.rcl.web.captcha.CaptchaServiceSingleton" %>
<%@ page import="java.awt.image.BufferedImage" %>
<%@ page import="java.io.ByteArrayOutputStream" %>
<%@ page import="com.octo.captcha.service.CaptchaServiceException" %>
<%@ page import="com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceRegistrationUim" %>
<%@ page import = "com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceRegistrationDao" %>
<%@ page import="java.util.List" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
  String contextPath = request.getContextPath();
  String userIdChecked = (String) request.getAttribute("userIdChecked");
  if(userIdChecked == null){
      userIdChecked = "false";
  }
  
  String userIdPassed = (String) request.getAttribute("userIdPassed");
  if(userIdPassed == null){
      userIdPassed = "false";
  }
  
  String userIdViewMode = (String) request.getAttribute("userIdViewMode");
  if(userIdViewMode == null){
      userIdViewMode = "false";
  }
  
  String authPage = (String) request.getAttribute("authPage");
  if(authPage == null){
      authPage = "Auth";
  }
  
  String userId = (String) request.getAttribute("userId");
  %>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="Pragma" content="no-cache">
	<meta http-equiv="Expires" content="-1">
    <title>RCL Group</title>
    <jsp:include page="../../pages/common/cognis/commonInclude.jsp"></jsp:include>    
    <script type="text/javascript" src="<%=contextPath%>/js/screen/EserviceRegistration.js?id=3"></script>
   
    <script type="text/javascript">
      (function(i, s, o, g, r, a, m) {
      	i['GoogleAnalyticsObject'] = r;
      	i[r] = i[r] || function() {
      		(i[r].q = i[r].q || []).push(arguments)
      	}, i[r].l = 1 * new Date();
      	a = s.createElement(o),
      		m = s.getElementsByTagName(o)[0];
      	a.async = 1;
      	a.src = g;
      	m.parentNode.insertBefore(a, m)
      })(window, document, 'script', '//www.google-analytics.com/analytics.js', 'ga');
      ga('create', 'UA-39255240-1', 'rclgroup.com');
      ga('send', 'pageview');
    </script>
    <script type="text/javascript">
      var REGISTRATION = "../do/sexn007Registration";
      var CHECK_AVAILABLE_USER_ID ="../do/sexn007CheckAvailableUserId";
      var BROWSE_CUSTOMER_DATA = "../do/serv014";
      var BROWSE_CUSTOMER_TYPE_DATA = "../do/serv016";
      var CREATE_CRM_CUSTOMER = '../do/serv007CreateCRMCustomer", pageContext)%>';
      var REGISTRATION_REQUEST = "../do/serv015";
      var GENERATE_CAPTCHA = "../do/serv007GenerateCaptcha";
      var OPEN_ACKNOWLEDGE = "../do/serv007OpenAcknowledge";
      var REJECTREASON = "../do/serv007Reject";
      var userIdPassed = '<%=userIdPassed%>';
      var userIdChecked = '<%=userIdChecked%>';
      /*Begin @02*/
      var ADD_CONTRACT_COMPANY = "../do/serv007addContractPartyCompany" 
      var UPD_CONTRACT_COMPANY = "../do/serv007updContractPartyCompany" ;
      var DEL_CONTRACT_COMPANY = "../do/serv007delContractPartyCompany" ;
      var CREATE_CRM_FOR_CONTRACT_PARTY = "../do/serv007CreateCRMCustomerForContractParty";
      var UPDATE_PASSWORD = "../do/serv007UpdateUserPassword";
      /*End @02*/
      /*##04 Begin */
      var ACTIVATE_REPRESENTED_COMPANY = "../do/serv007activateRepresentedCompany";
      var FILTER_CONTRACT_PARTY = "../do/serv007filterContractParty";
      /*##04 End */
      var LOGOUT_URL = "../do/serv00111";
    </script>
  </head>
  <body onload="onLoad();">
    <form method="post" action="/sexn007usePassword">
    
   <input type="hidden" class="form-control " name="msgUserProfile"   id="msgUserProfile" value="${userUim.msg }">
   <input type="hidden" class="form-control " name="errorMessage"   id="errorMessage" value="${userUim.errorMessage }">
   <input type="hidden" name="loginDateCheck" id="loginDateCheck"  value="${sessionScope.sUserAccountBean.dateFormat}"/> 
    <!-- Start Of Nav Bar -->
    <jsp:include page="../common/cognis/header.jsp"></jsp:include>
    <!-- End Of Nav Bar -->
    <!-- Start Of Vertical Menu -->
    <div class="rcl-content">
      <div class="container-fluid px-1 px-md-4 py-5 mx-auto">
        <div class="row d-flex justify-content-center">
          <div class="col-12">
            <div class="card card0 border-0">
              <div class="row">
                <div class="col-12">
                  <div class="card card00 m-2 border-0">
                    <div class="d-flex flex-md-row px-3 mt-4 mb-4 flex-column-reverse">
                      <div class="col-md-5 border-right">
                        <div class="row px-3">
                          <div class="col-9">
                            <h3 style="margin-top: 10px;;">
                              <strong>
                               <%--  <bean:message key="registration.Registration"/> --%>User Password Reset
                              </strong>
                            </h3>
                          </div>
                          <div class="col-3">
                            <div class="row justify-content-center">
                              <div class=" col">
                                <div class="custom-chart" id="registration-custom-chart" data-percent="0" data-size="60" data-line="6"> </div>
                              </div>
                            </div>
                          </div>
                        </div>
                        <hr />
                        <div class="card1 mt-5">
                          <ul id="progressbar" class="text-center">
                            <li class="active step0"></li>
                          </ul>
                          <h5 class="mb-5">
                            <a href="#" class="progressbar-menu progressbar-menu-active">
                              <i class="fas fa-user-circle"
                                aria-hidden="true"></i>&nbsp;
                              <strong>
                               <bean:message key="registration.Reset_Password"/>
                              </strong>
                            </a>
                          </h5>
                        </div>
                      </div>
                      <div class="col-md-7 mb-4" style="min-height: 700px;">   
                      <jsp:include page="../../pages/common/cognis/alert.jsp"></jsp:include> 
                      <jsp:include page="../../pages/common/cognis/alertInfo.jsp"></jsp:include>                    
                        <div class="card2 first-screen show ml-2">
                          <h5 class="card-title">
                            <strong>
                              <i class="fas fa-user-alt" aria-hidden="true"></i>&nbsp; 
                              <bean:message key="registration.Reset_Password"/>
                            </strong>
                          </h5>
                          <hr />
                         <div class="form-group ">
                            <label for="inputPassword ">
                              <bean:message key="registration.User_ID"/>
                            </label>
                            <input type="text" class="form-control " name="userId" id="userId" value="${userUim.userId}" readonly="true"/> 
                          </div>
                          
                          <div class="form-group ">
                            <label for="inputPassword ">
                              <bean:message key="registration.Old_Password"/><span class="mandatory">*</span>
                            </label>
                            <input type="password" class="form-control " name="oldPassword" id="oldPassword" required="required"  maxlength="10"/> 
                          </div>
                          
                          <div class="form-group ">
                            <label for="inputPassword ">
                              <bean:message key="registration.Password"/><span class="mandatory">*</span>
                            </label>
                            <input type="password" class="form-control " name="password" id="password" required="required"  maxlength="10"/> 
                          </div>
                          <div class="form-group ">
                            <label for="inputRepeatPassword ">
                              <bean:message key="registration.Repeat_Password"/><span class="mandatory">*</span>
                            </label>
                            <input type="password" class="form-control " required="required" name="rePassword" id="rePassword"  maxlength="10 "
                               />
                          </div>
                          <div class="float-right ">
                            <div class="btn btn-primary next-button1 " onclick="updateUserPassword(); ">
                                <span class="fas fa-arrow-right "></span>&nbsp;&nbsp; 
                                <bean:message key="registration.Submit"/>
                                &nbsp;&nbsp;
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- End Of Vertical Menu -->
    <!-- Start Of script Section -->
   
     <%-- <script src="<%=contextPath%>/js/registration.js?id=1"></script> --%>
     
    <script>
      $(document).ready(function() {
    	  debugger;
      	$('#registration-custom-chart').attr('data-percent', 0);
      	updateCustomGraph('registration-custom-chart');
      	
      	if($("#errorMessage").val()!="" ){
      		showBarMessageNew($("#errorMsgUserProfile").val());
      	}else if($("#msgUserProfile").val()=="Successfuly Updated."){
      		showBarMessageInfo('Successfuly Updated.');
      	}
      	
      });
      function updateUserPassword(){
    	  debugger;
    	 var validate= persoanlDetail();
    	 if(validate==true){
    		 var userIdtemp=$("#userId").val();
    		 var oldPasswordtemp=$("#oldPassword").val();
    		 var passwordtemp=$("#password").val();
    		 document.forms[0].action = UPDATE_PASSWORD + "?userId="+userIdtemp+"&oldPassword="+oldPasswordtemp+"&password="+passwordtemp ;
    		 document.forms[0].submit();
    	 }
      }
      
      function persoanlDetail(){
    	  $("#alertId").hide();
    	  var index=3;
    	  var isValid=true;
		
    	  if($("#oldPassword").val()== ""){          	             
         	 $("#oldPassword").parsley().validate(true);    		
  		 	 $("#"+ $("#userInfoMod_userId").attr("aria-describedby")+" li").html("Please enter Old password.");
  		 	 isValid =false;
  		 	index--;
  		 	return false;
    	  }else{
	  		isValid= validatePassword($("#oldPassword").val(),"");
	  		if(isValid){
	    	  if($("#password").val()== ""){          	             
	            	 $("#password").parsley().validate(true);    		
	     		 	 $("#"+ $("#userInfoMod_userId").attr("aria-describedby")+" li").html("Please New enter password.");
	     		 	 isValid =false;
	     		 	index--;
	            }else{
	            	isValid= validatePassword($("#password").val(),"");
	            	if(isValid){
	            			if($("#password").val()!=$("#rePassword").val()){
	            				showBarMessageNew('Both the New password Repeat Password are not same');
	            				isValid =false;
	            			}else if($("#password").val()==$("#oldPassword").val()){
	            				showBarMessageNew('Both the Old password New Password Should not be same');
	            				isValid =false;
	            			}
	            	}
	            }
  			}
      }
    	  
    	$('#registration-custom-chart span').html((Math.ceil(index/(4))+3)+"0%");
      	  
    	  return isValid;
    	  
    	 
    	  
      }
      
      
     
    </script>
    <!-- End Of Script Section -->
  </body>
</html>