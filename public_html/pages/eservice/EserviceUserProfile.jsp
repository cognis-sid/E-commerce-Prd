<%@page import="java.util.Date"%>
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
    <script type="text/javascript" src="<%=contextPath%>/js/registration.js?id=<%=new Date()%>"></script>
   
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
      /*End @02*/
      /*##04 Begin */
      var ACTIVATE_REPRESENTED_COMPANY = "../do/sexn007activateRepresentedCompany";
      var FILTER_CONTRACT_PARTY = "../do/serv007filterContractParty";
      /*##04 End */
      var LOGOUT_URL = "../do/serv00111";
    </script>
  </head>
  <body onload="onLoad();">
  
  
  
    <form method="post" action="../do/sexn007updateUser">
    
   <input type="hidden" class="form-control " name="msgUserProfile"   id="msgUserProfile" value="${userUim.msg }">
   <input type="hidden" name="loginDateCheck" id="loginDateCheck"  value="${sessionScope.sUserAccountBean.dateFormat}"/> 
   <input type="hidden" name="loginDateCheck" id="loginDateCheck"  value="${sessionScope.sUserAccountBean.dateFormat}"/> 
   <input type="hidden" name="allSFUChecked" value="${userUim.allSFUChecked}" /> 
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
                      <div class="col-md-4 border-right">
                        <div class="row px-3">
                          <div class="col-9">
                            <h3 style="margin-top: 10px;;">
                              <strong>
                               <%--  <bean:message key="registration.Registration"/> --%>User Profile
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
                            <li class="active step0" id="step0" onclick="fastPage()"></li>
                            <li class="step0" id="step1" onclick="secPage()"></li>
                            <li class="step0" id="step2" onclick="thardPage()"></li>
                          </ul>
                          <h5 class="mb-5">
                            <a href="#" class="progressbar-menu progressbar-menu-active" onclick="fastPage()">
                              <i class="fas fa-user-circle"
                                aria-hidden="true"></i>&nbsp;
                              <strong>
                                <bean:message key="registration.Personal_&_Account_Details"/>
                              </strong>
                            </a>
                          </h5>
                          <h5 class="mb-5">
                            <a href="#" class="progressbar-menu" onclick="secPage()">
                              <i class="fas fa-building" aria-hidden="true"></i>&nbsp;
                              <strong>
                                <bean:message key="registration.Company_Details"/>
                              </strong>
                          </h5>
                          </a>
                          <h5 class="mb-5">
                            <a href="#" class="progressbar-menu" onclick="thardPage()">
                              <i class="fas fa-file-invoice"
                                aria-hidden="true"></i>&nbsp;
                              <strong>
                                <bean:message key="registration.Service_Request"/>
                              </strong>
                          </h5>
                          </a>
                        </div>
                      </div>
                      <div class="col-md-8 mb-4" style="min-height: 700px;">   
                      <jsp:include page="../../pages/common/cognis/alert.jsp"></jsp:include>                     
                        <div class="card2 first-screen show ml-2" id="first-screen">
                          <h5 class="card-title">
                            <strong>
                              <i class="fas fa-user-alt" aria-hidden="true"></i>&nbsp; 
                              <bean:message key="registration.Personal_Details"/>
                            </strong>
                          </h5>
                          <hr />
                          <div class="form-row">
                            <div class="form-group col-md-6">
                              <label for="inputFirstName">
                                <bean:message key="registration.First_Name" /><span class="mandatory">*</span>
                              </label>
                              <input type="text" class="form-control" name="firstName" id="firstName"  value="${userUim.firstName}" onkeypress="clearMsg();" readonly required  /> 
                            </div>
                            <div class="form-group col-md-6">
                              <label for="inputLastName">
                                <bean:message key="registration.Last_Name" /><span class="mandatory">*</span>
                              </label>
                              <input type="text" class="form-control" name="lastName" id="lastName" value="${userUim.lastName }" onkeypress="clearMsg();" readonly required="required"  /> 
                            </div>
                          </div>
                          <div class="form-group">
                            <label for="inputEmailAddress">
                              <bean:message key="registration.E-Mail_Address" /><span class="mandatory">*</span>
                            </label>
                            <input type="email"  class="form-control" name="email" id="userInfoMod_email" value="${userUim.email}" data-parsley-trigger="change" required="required"  />
                          </div>
                          <div class="form-group ">
                            <label for="inputRepeatEmailAddress ">
                              <bean:message key="registration.Repeat_Email_Address"/><span class="mandatory">*</span>
                            </label>
                            <input type="email" class="form-control " name="reEmailAddress" id="reEmailAddress"
                              value="${userUim.email}"  required data-parsley-type="email"/>
                          </div>
                          <h5 class="card-title mt-5 ">
                            <strong>
                              <i class="fas fa-address-card aria-hidden="true "></i>&nbsp;
                              <bean:message key="registration.Account_Details"/>
                            </strong>
                          </h5>
                          <hr />
                          <div class="form-group ">
                            <label for="inputUserId ">
                              <bean:message key="registration.User_ID"/><span class="mandatory">*</span>
                            </label>
                            <input type="text" class="form-control " name="userId"   id="userInfoMod_userId" 
                             value="${userUim.userId}"	onchange="checkAvailableUserId() " readonly required="required"/>
                            <span id="checkResultMessage">&nbsp;</span>
                          </div>
                          <div class="form-group ">
                            <label for="inputPassword ">
                              <bean:message key="registration.Password"/><span class="mandatory">*</span>
                            </label>
                            <input type="password" class="form-control " name="password" id="password" required="required" value="${userUim.password}" maxlength="10 "
                               /> 
                          </div>
                          <div class="form-group ">
                            <label for="inputRepeatPassword ">
                              <bean:message key="registration.Repeat_Password"/><span class="mandatory">*</span>
                            </label>
                            <input type="password" class="form-control " required="required" name="rePassword" id="rePassword" value="${userUim.password}" maxlength="10 "
                               />
                          </div>
                          <div class="float-right ">
                            <div class="btn btn-primary next-button " >
                              <span class="fas fa-arrow-right "></span>&nbsp;&nbsp;
                              <bean:message key="registration.Next"/>
                              &nbsp;&nbsp;
                            </div>
                          </div>
                        </div>
                        <div class="card2 ml-2 " id="second-screen">
                          
                        	<h5 class="card-title ">
								<strong> <i class="fas fa-building "
									aria-hidden="true "></i>&nbsp; Represented Company
								</strong>
							</h5>
							<hr />
							<table>
									<div class="form-group ">
										<label for="companyName "> Represented Company Name :</label> 
									</div>
								<c:forEach var="contractPartyListval" items="${userUim.contractPartyList}"  varStatus="loopCounter">
									  <c:if test="${contractPartyListval.contractPartyStatus=='ACTIVE'}">
										  <div class="row">
											<input type="hidden" name="fkContractPartyCode" id="fkContractPartyCode${loopCounter.count-1}" value="${contractPartyListval.fkContractPartyCode}" />
			                                <input type="hidden" name="pkEsvPpHdrSeq" id="pkEsvPpHdrSeq${loopCounter.count-1}" value="${contractPartyListval.pkEsvPpHdrSeq}" />
			                                <input type="hidden" name="statusFlag" id="statusFlag${loopCounter.count-1}" value="${contractPartyListval.statusFlag}" />
			                                <input type="hidden" name="recStatus" id="recStatus${loopCounter.count-1}" value="${contractPartyListval.recStatus}" />
			                                <input type="hidden" name="approveFlag" id="approveFlag${loopCounter.count-1}" value="${contractPartyListval.approveFlag}" />
			                                <input type="hidden" name="contractPartyFscCode" id="contractPartyFscCode${loopCounter.count-1}" value="${contractPartyListval.contractPartyFscCode}" />
			                                <input type="hidden" name="contractPartyType" id="contractPartyType${loopCounter.count-1}" value="${contractPartyListval.contractPartyType}" />
											<div class="col-md-4">
													<input type="text"  
													class="form-control " name="contractPartyName" id="contractPartyName${loopCounter.count-1}"
													value="${contractPartyListval.contractPartyName}" disabled="true" />
											</div>
											<div  class="col-md-3">
													<input type="text"  
													class="form-control " name="contractPartyStatus" id="contractPartyStatus${loopCounter.count-1}"
													value="${contractPartyListval.contractPartyStatus}" disabled="true" />
											</div>
											<div  class="col-md-3">
												 <c:if test="${contractPartyListval.pwd != contractPartyListval.reactPwd}"> 
													<input type="password"  
													class="form-control " name="reactPwd" id="reactPwd${loopCounter.count-1}"
													value="${contractPartyListval.reactPwd}" />
												  </c:if>
												<c:if test="${contractPartyListval.pwd == contractPartyListval.reactPwd}">
													<input type="password" 
													class="form-control " name="reactPwd" id="reactPwd${loopCounter.count-1}"
													value="${contractPartyListval.reactPwd}" disabled="true" />
												</c:if>  
											</div>
											<div class="col-md-2">
												<c:if test="${contractPartyListval.pwd != contractPartyListval.reactPwd}"> 
													<a class="btn btn-success" id="btnActiveContractCompany" name="btnActiveContractCompany" style="color:white;" onClick="activateRepresentedCompany(this,${loopCounter.count-1})">&nbsp; 
													Active</a>
												</c:if>
												  <c:if test="${contractPartyListval.pwd == contractPartyListval.reactPwd}">
													<a class="btn btn-success" id="btnActiveContractCompany" name="btnActiveContractCompany" style="color:white;" disabled   > &nbsp; 
													Active</a>
												  </c:if> 
											</div>
										  </div>	
									  </c:if>
										  <br>	
									</c:forEach>
                          </table>
                          <h5 class="card-title ">
                            <strong>
                              <i class="fas fa-building " aria-hidden="true "></i>&nbsp; 
                              <bean:message key="registration.Company"/>
                            </strong>
                          </h5>
                          <hr />
                          <div class="form-group ">
                            <label for="companyName ">
                              <bean:message key="registration.Company_Name"/>
                            </label>
                            <input type="text" required="required" class="form-control " name="companyName" id="companyName" value="${userUim.companyName}" readonly />
                          </div>
                          <div class="form-group ">
                            <label for="inputAddress1 ">
                              <bean:message key="registration.Address_1"/>
                            </label>
                            <input type="text" class="form-control " required="required"  name="address1" id="inputAddress1" value="${userUim.address1}" maxlength="35"/>
                          </div>
                          <div class="form-group ">
                            <label for="inputAddress2 ">
                              <bean:message key="registration.Address_2"/>
                            </label>
                            <input type="text" class="form-control" name="address2" id="inputAddress2"
                              value="${userUim.address2}" maxlength="35"/>
                          </div>
                          <div class="form-group ">
                            <label for="inputAddress2">
                              <bean:message key="registration.Address_3"/>
                            </label>
                            <input type="text" class="form-control" name="address3" id="inputAddress3" value="${userUim.address3}"
                              placeholder=" " maxlength="20"/>
                          </div>
                          <div class="form-group ">
                            <label for="inputAddress2">
                              <bean:message key="registration.Address_4"/>
                            </label>
                            <input type="text" class="form-control " name="address4" id="inputAddress4" value="${userUim.address4}"
                              placeholder=" " maxlength="20"/>
                          </div>
                          <div class="form-row ">
                            <div class="form-group col-md-6 ">
                              <label for="inputCity ">
                                <bean:message key="registration.City"/>
                              </label>
                              <input type="text" class="form-control" required="required" name="city" id="inputCity" value="${userUim.city}" onblur="changeUpper(this)"  />
                            </div>
                            <div class="form-group col-md-3 ">
                              <label for="inputState ">
                                <bean:message key="registration.State"/>
                              </label>
                              <input type="text" class="form-control"  name="state" id="inputState" value="${userUim.state}" maxlength="2" onblur="changeUpper(this)" />
                            </div>
                            <div class="form-group col-md-3 ">
                              <label for="inputCountry ">
                                <bean:message key="registration.Country"/>
                              </label>
                              <select id="userInfoMod.country" name="country" size="1" class="form-control" required="required" disabled>
                              <c:forEach var="listCountry" items="${requestScope.countryList}" varStatus="loopCounter">
                                 <c:choose>
											<c:when test="${listCountry.code == userUim.country}">
												<option selected="selected" value="${listCountry.code}">${listCountry.name}</option>
											</c:when>   
											<c:otherwise>
												<option  value="${listCountry.code}">${listCountry.name}</option>
											</c:otherwise>
								</c:choose>
                              </c:forEach> 
                              </select>
                              <%-- <input  type="hidden" name="userInfoMod.country" class="form-control"   id="inputCountry" value="${userUim.country}" required="required"/> --%>

                            </div>
                            <div class="form-row col-md-6 ">
                              <div class="form-group col-md-6 ">
                                <label for="inputCity ">
                                  <bean:message key="registration.Phone_Number"/>
                                </label>
                                <input type="text" class="form-control " name="phoneNo" id="phoneNo" value="${userUim.phoneNo}"  onchange="checkNumeric(this,'Phone No')" required="required"/>
                              </div>
                              <div class="form-group col-md-6 ">
                                <label for="inputCity ">
                                  <bean:message key="registration.FAX_Number"/>
                                </label>
                                <input type="text" class="form-control" name="faxNo" id="faxNo" value="${userUim.faxNo}"  onchange="checkNumeric(this,'Fax No')" />
                              </div>
                            </div>
                          </div>
                          <div class="row float-right ">
                            <div class="btn btn-secondary prev mr-2 ">
                              <bean:message key="registration.Prev"/>
                              &nbsp;&nbsp;<span class="fas fa-arrow-left "></span>&nbsp;&nbsp;
                            </div>
                            <div class="btn btn-primary next-button1">
                                <span class="fas fa-arrow-right"></span>&nbsp;&nbsp; 
                                <bean:message key="registration.Next"/>
                                &nbsp;&nbsp;
                            </div>
                          </div>
                        </div>
                        
                        <div class="card2 ml-2 " id="thard-screen">
                         <h5 class="card-title ">
                           <strong>
                             <i class="fas fa-file-invoice " aria-hidden="true "></i>&nbsp;
                             <bean:message key="registration.RCL_eServices"/>
                           </strong>
                         </h5>
                         <hr />
                         <div class="form-group ">
                           <label for="companyName "><bean:message key="registration.Please_Select_Atleast_One_of_the_Following_Available_eServices_Offered_by_Bhumnet*"/></label>
                           <div>
                             <c:forEach var="listValue" items="${userUim.userServiceModList}" varStatus="loopCounter">
                               <input type="hidden"  name="checked" value="${listValue.checked}"/>
                               <input type="hidden" name="sfuCode" value="${listValue.sfu}" />
                               <div class="input-group" >
                                 <input type="checkbox" class="checkbox" style="width:20px; height:22px !important ;" name="sfu" value="on"  onclick="clearMsg(); onServiceChecked(${loopCounter.count-1});"   />
                                 &nbsp;<label>${listValue.moduleName}</label>
                               </div>
                             </c:forEach>
                           </div>
                           <hr class="mt-5 " />
                           <div class="input-group" >
                             <input type="checkbox" class="checkbox" style="width:20px; height:22px !important ;"  name="chkAccept" id="chkAccept" checked="true" />
                             &nbsp;<label for="agreement ">
                               <bean:message key="registration.I_Have_Read_The"/>&nbsp;
                               <a href="javascript:openAnnouncement('<%=contextPath%>', '_blank', ANNOUNCE_TYPE_TERM_OF_USE);"><bean:message key="registration.Terms_Of_Use"/></a>&nbsp;<bean:message key="registration.and"/>&nbsp;
                               <a href="javascript:openAnnouncement('<%=contextPath%>', '_blank', ANNOUNCE_TYPE_PRIVACY_POLICY);"><bean:message key="registration.Privacy_Policy"/></a>&nbsp;
                               <bean:message key="registration.Terms_Conditions_Regarding"/> 
                               <span class="font_require ">*</span>
                             </label>
                           </div>
                           <div class="row float-right ">
                             <div class="btn btn-secondary prev mr-2 "> <bean:message key="registration.Prev"/>
                               &nbsp;&nbsp;<span class="fas fa-arrow-left "></span>&nbsp;&nbsp;
                             </div>
                             <div class="btn btn-primary" onclick="updateUserProfile();">
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
    </div>
    <!-- End Of Vertical Menu -->
    <!-- Start Of script Section -->
   
     <%-- <script src="<%=contextPath%>/js/registration.js?id=1"></script> --%>
     
    <script>
      $(document).ready(function() {
    	  debugger;
   		if($("#loginDateCheck").val()==null || $("#loginDateCheck").val()==""){
   	    		  window.location.href="../do/sexn007usePassword";
   	    } 
      	$('#registration-custom-chart').attr('data-percent', 0);
      	updateCustomGraph('registration-custom-chart');
      	
      	if($('#msg').val()=='success'){
      		swal("Message", profilesuccessfullyupdated , "info");
      		$('#msg').val("");
      	}
      });
      
      // Next button
      $(".next-button").click(function () {
    	 
    	 if(!persoanlDetail()){
    		 return ;
    	 }
     
        current_fs = $(this).parent().parent();
        next_fs = $(this).parent().parent().next();

        $(".prev").css({ display: "block" });

        $(current_fs).removeClass("show");
        $(next_fs).addClass("show");

        $("#progressbar li").eq($(".card2").index(next_fs)).addClass("active");
        $(".progressbar-menu").eq($(".card2").index(next_fs)).addClass("progressbar-menu-active");

        current_fs.animate(
          {},
          {
            step: function () {
              current_fs.css({
                display: "none",
                position: "relative",
              });

              next_fs.css({
                display: "block",
              });
            },
          }
        );
      });

      
      $(".next-button1").click(function () {
     	 
     	 if(!companyDetail()){
     		 window.scrollTo(500, 0);
     		 return ;
     	 }
     	 window.scrollTo(500, 0);
     	 $('#registration-custom-chart span').html("90%");
         current_fs = $(this).parent().parent();
         next_fs = $(this).parent().parent().next();

         $(".prev").css({ display: "block" });

         $(current_fs).removeClass("show");
         $(next_fs).addClass("show");

         $("#progressbar li").eq($(".card2").index(next_fs)).addClass("active");
         $(".progressbar-menu").eq($(".card2").index(next_fs)).addClass("progressbar-menu-active");

         current_fs.animate(
           {},
           {
             step: function () {
               current_fs.css({
                 display: "none",
                 position: "relative",
               });

               next_fs.css({
                 display: "block",
               });
             },
           }
         );
       });
      
      
      function persoanlDetail(){
    	  $("#alertId").hide();
    	  var index=7;
    	  var isValid=true;
    	  if($("#firstName").val()== ""){    		   
    		  $("#firstName").parsley().validate(true);    		
    		  $("#"+ $("#firstName").attr("aria-describedby")+" li").html("Please specify the First Name.");
    		  isValid =false;
    		  index--; 		 
    	  }
    	  
          if($("#lastName").val()== ""){          	             
          	 $("#lastName").parsley().validate(true);    		
   		 	 $("#"+ $("#lastName").attr("aria-describedby")+" li").html("Please specify the Last Name.");
   		 	 isValid =false;
   		 	index--;
          }
    	  if($("#userInfoMod_email").val()== ""){
    		  $("#userInfoMod_email").parsley().validate(true);    		
    		  $("#"+ $("#userInfoMod_email").attr("aria-describedby")+" li").html("Please Enter email id.");
    		  isValid =false;    		  
    		  index--;
    		  
    	  }else{
    		  if(validateMultipleEmails($("#userInfoMod_email")[0])){
	    		  if($("#userInfoMod_email").val()!= $("#reEmailAddress").val()){
	        		  //$("#userInfoMod_email").parsley().validate(true);    		
	        		  showBarMessageNew("Email addresses do not match.");
	        		  isValid =false;
	        		  return false;
	    		  } 
        	  }else{
        		  isValid =false;
        		  return false;
        	  }
    	  }

    	  if($("#userInfoMod_userId").val()== ""){          	             
           	 $("#userInfoMod_userId").parsley().validate(true);    		
    		 	 $("#"+ $("#userInfoMod_userId").attr("aria-describedby")+" li").html("Please enter User ID first.");
    		 	 isValid =false;
    		 	index--;
           }else {
        	   
        	   if($("#userInfoMod_userId").val().length < 6){                   
                   showBarMessageNew('Please specifiy User Id which is 6 to 10 characters long.');
                   isValid =false;

                   
               }
           }
    	  
    	  if($("#password").val()== ""){          	             
            	 $("#password").parsley().validate(true);    		
     		 	 $("#"+ $("#userInfoMod_userId").attr("aria-describedby")+" li").html("Please enter password.");
     		 	 isValid =false;
     		 	index--;
            }else{
            	isValid= validatePassword($("#password").val(),"");
            	if(isValid){
            			if($("#password").val()!=$("#rePassword").val()){
            				showBarMessageNew('Both the password is not same');
            				isValid =false;
            			}
            	}
            }
    	  
    	$('#registration-custom-chart span').html((Math.ceil(index/(4))+3)+"0%");
      	  
    	  return isValid;
    	  
    	 
    	  
      }
      
      function companyDetail(){
    	  
    	  $("#alertId").hide();
    	  var index=4;
    	  var isValid=true;
    	  if($("#companyName").val()== ""){    		   
    		  $("#companyName").parsley().validate(true);    		
    		  $("#"+ $("#companyName").attr("aria-describedby")+" li").html("Please specify Company Name.");
    		  isValid =false;
    		  index--; 		 
    	  }
    	  
    	  if($("#inputCity").val()== ""){    		   
    		  $("#inputCity").parsley().validate(true);    		
    		  $("#"+ $("#inputCity").attr("aria-describedby")+" li").html("Please specific City.");
    		  isValid =false;
    		  index--; 		 
    	  }
    	  
    	  if($("#inputCountry").val()== ""){    		   
    		  $("#inputCountry").parsley().validate(true);    		
    		  $("#"+ $("#inputCountry").attr("aria-describedby")+" li").html("Please specific Country.");
    		  isValid =false;
    		  index--; 		 
    	  }
    	  
    	  if($("#inputAddress1").val()== ""){    		   
    		  $("#inputAddress1").parsley().validate(true);    		
    		  $("#"+ $("#inputAddress1").attr("aria-describedby")+" li").html("Please specific Addrres.");
    		  isValid =false;
    		  index--; 		 
    	  }  	  
    	  
    	
    	  if($("#phoneNo").val()== ""){    		   
    		  $("#phoneNo").parsley().validate(true);    		
    		  $("#"+ $("#phoneNo").attr("aria-describedby")+" li").html("Please specific Phone Number.");
    		  isValid =false;
    		  index--; 		 
    	  }
    	
			$('#registration-custom-chart span').html(Math.ceil(index/(7*3))+"0%");
      	  
    	  return isValid;
    	
      }
      function fastPage(){
    	   $("#step0").removeClass();
    	   $("#step0").addClass("active step0");
    	   $("#step1").removeClass();
    	   $("#step1").addClass("step0");
    	   $("#step2").removeClass();
    	   $("#step2").addClass("step0");
      	
   	   $("#first-screen").removeClass();
   	   $("#first-screen").addClass("card2 first-screen show ml-2");
   	   $("#second-screen").removeClass();
   	   $("#second-screen").addClass("card2 first-screen ml-2");
   	   $("#thard-screen").removeClass();
   	   $("#thard-screen").addClass("card2 first-screen ml-2");
     }
  	  function secPage(){
  		if(!persoanlDetail()){
  		 window.scrollTo(500, 0);
  		 return;
  	 }
  		   $("#step0").removeClass();
  	  	   $("#step0").addClass("step0");
  	  	   $("#step1").removeClass();
  	  	   $("#step1").addClass("active step0");
  	  	   $("#step2").removeClass();
  	  	   $("#step2").addClass("step0");
  	    	
  		   $("#first-screen").removeClass();
  	   	   $("#first-screen").addClass("card2 first-screen ml-2");
  	   	   $("#second-screen").removeClass();
  	   	   $("#second-screen").addClass("card2 first-screen show ml-2");
  	   	   $("#thard-screen").removeClass();
  	   	   $("#thard-screen").addClass("card2 first-screen ml-2");
  	  }
  	  
  	function thardPage(){
			if(!persoanlDetail()){
				 window.scrollTo(500, 0);
		 	return;
	 		}
   		if(!companyDetail()){
   		 window.scrollTo(500, 0);
   		 return ;
   	   }
		   $("#step0").removeClass();
	  	   $("#step0").addClass("step0");
	  	   $("#step1").removeClass();
	  	   $("#step1").addClass("step0");
	  	   $("#step2").removeClass();
	  	   $("#step2").addClass("active step0");
		  
		   $("#first-screen").removeClass();
	   	   $("#first-screen").addClass("card2 first-screen ml-2");
	   	   $("#second-screen").removeClass();
	   	   $("#second-screen").addClass("card2 first-screen ml-2");
	   	   $("#thard-screen").removeClass();
	   	   $("#thard-screen").addClass("card2 first-screen show ml-2");
	  }
    </script>
    <!-- End Of Script Section -->
  </body>
</html>