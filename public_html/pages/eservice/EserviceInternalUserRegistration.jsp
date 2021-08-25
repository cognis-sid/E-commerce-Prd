<%@page import="java.util.Date"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ page import="com.niit.control.common.GlobalConstants"%>
<%@ page import="com.niit.control.web.action.BaseAction"%>
<%@ page import="com.niit.control.web.UserAccountBean"%>
<%@ page import="com.niit.control.common.StringUtil"%>
<%@ page import="com.niit.control.common.ComboVO"%>
<%@ page import="java.awt.image.BufferedImage"%>
<%@ page import="java.io.ByteArrayOutputStream"%>
<%@ page
	import="com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceInternalUserRegistrationUim"%>
<%@ page
	import="com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceInternalUserRegistrationDao"%>
<%@ page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%! String s1="sid" ; %>
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
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>RCL Group</title>
<jsp:include page="../../pages/common/cognis/commonInclude.jsp"></jsp:include>
<%--     <script type="text/javascript" src="<%=contextPath%>/js/screen/EserviceRegistration.js?id=<%=new Date()%>"></script>
 --%>
<script type="text/javascript"
	src="<%=contextPath%>/js/registration.js?id=<%=new Date()%>"></script>

<link type="text/css"
	href="<%=contextPath%>/css/registration/ocr.min.css" rel="stylesheet">

<script src="<%=contextPath%>/js/selectbox.js" charset="utf-8"></script>

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
      var REGISTRATION = "../do/serv0031create";
      var CHECK_AVAILABLE_USER_ID ="../do/serv0031chkuser";
  var ON_LOG_OUT_ADM = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/logoutservAdm", pageContext)%>';
      //../do/logoutservAdm';
      
    </script>
</head>
<body onload="onLoad();">
	<form method="post" action="/serv0031create">

		<input type="hidden" name="contextPath" id="contextPath"
			value="<%=contextPath%>" /> <input type="hidden" name="portPairFlag"
			id="portPairFlag" value="Y" />
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
										<div
											class="d-flex flex-md-row px-3 mt-4 mb-4 flex-column-reverse">
											<div class="col-md-5 border-right">
												<div class="row px-3">
													<div class="col-9">
														<h3 style="margin-top: 10px;">
															<strong> <bean:message
																	key="registration.Registration" />
															</strong>
														</h3>
													</div>
													<div class="col-3">
														<div class="row justify-content-center">
															<div class=" col">
																<div class="custom-chart" id="registration-custom-chart"
																	data-percent="0" data-size="60" data-line="6"></div>
															</div>
														</div>
													</div>
												</div>
												<hr />
												<div class="card1 mt-5">
													<ul id="progressbar" class="text-center">
														<li class="active step0" id="step0" onclick="fastPage()"></li>
													</ul>
													<h5 class="mb-5">
														<a href="#"
															class="progressbar-menu progressbar-menu-active"
															onclick="fastPage()"> <i class="fas fa-user-circle"
															aria-hidden="true"></i>&nbsp; <strong> <bean:message
																	key="registration.Personal_&_Account_Details" />
														</strong>
														</a>
													</h5>

												</div>
											</div>

											<div class="col-md-7 mb-4" style="min-height: 700px;">
												<jsp:include page="../../pages/common/cognis/alert.jsp"></jsp:include>
												<div class="card2 first-screen show ml-2" id="first-screen">
													<h5 class="card-title">
														<strong> <i class="fas fa-user-alt"
															aria-hidden="true"></i>&nbsp; <bean:message
																key="registration.Personal_Details" />
														</strong>
													</h5>
													<hr />



													<div class="form-group ">
														<label for="inputUserId "> <bean:message
																key="registration.User_ID" /><span class="mandatory">*</span>
														</label> <input type="text" class="form-control "
															name="userLoginId" id="userLoginId"
															placeholder='<bean:message key="registration.Enter_User_ID"/>'
															onchange="checkAvailableUserId()" required="required"
															maxlength="10" /> <span id="checkResultMessage">&nbsp;</span>
														<span style="font-weight: 600;"><bean:message
																key="registration.Characters_Length_Required" /></span>
													</div>
													<div class="form-group ">
														<label for="inputPassword "> <bean:message
																key="registration.Password" /><span class="mandatory">*</span>
														</label> <input type="password" class="form-control "
															placeholder='<bean:message key="registration.Enter_password"/>'
															name="password" id="password" required="required"
															maxlength="20" /> <span style="font-weight: 600;"><bean:message
																key="registration.Least_8_Characters" /></span>
													</div>

													<div class="form-group ">
														<label for="inputRepeatPassword "> <bean:message
																key="registration.Repeat_Password" /><span
															class="mandatory">*</span>
														</label> <input type="password" class="form-control "
															placeholder='<bean:message key="registration.Enter_password_again"/>'
															required="required" name="rePassword" id="rePassword"
															maxlength="10 " />
													</div>

													<div class="form-group">
														<label for="inputEmailAddress"> <bean:message
																key="registration.E-Mail_Address" /><span
															class="mandatory">*</span>
														</label> <input type="email" class="form-control" name="email"
															id="userInfoMod_email"
															placeholder='<bean:message key="registration.Enter_email_address"/>'
															data-parsley-trigger="change" required="required" />
													</div>

													<div class="form-group ">
														<label for="inputRepeatPassword "> <bean:message
																key="Port.User_Name" /><span class="mandatory">*</span>
														</label> <input type="text" class="form-control "
															placeholder='<bean:message key="Port.User_Name"/>'
															required="required" name="name" id="name" maxlength="30 " />
													</div>
													<div class="form-row">

														<div class="form-group col-md-4">
															<label for="inputRepeatPassword ">CTRL+Click for
																selecting multiple Location<span class="mandatory">*</span>
															</label> <select class="form-control" id="contryList"
																name="contryList" multiple="multiple">

																<logic:iterate id="listUserId" name="feserv31"
																	collection="${feserv31.contryList}">

																	<option
																		value="${listUserId.contryName}-${listUserId.code}">${listUserId.contryName}-${listUserId.code}</option>
																</logic:iterate>

															</select>
														</div>
														<div class="form-group col-md-4">
															<div class="text-center" style="padding-top: 2px;">

																<button type="button" class="ms-btn ms-btn-single"
																	name="move-right">
																	<i class="fa fa-angle-right"></i>
																</button>
																<br />
																<button type="button" class="ms-btn ms-btn-single"
																	name="move-left">
																	<i class="fa fa-angle-left"></i>
																</button>
																<br />
																<button type="button" class="ms-btn"
																	name="move-all-right">
																	<i class="fa fa-angle-double-right"></i>
																</button>
																<br />
																<button type="button" class="ms-btn"
																	name="move-all-left">
																	<i class="fa fa-angle-double-left"></i>
																</button>
																<br />
															</div>
														</div>
														<div class="form-group col-md-4">
															<select class="form-control" id="location"
																name="location" multiple="multiple">
															</select>
														</div>

													</div>
													<div class="float-right ">
														<%-- <div class="btn btn-secondary mr-2" onclick="logoutAdm();">
															<span class="fas fa-arrow-up"></span>&nbsp;&nbsp;
															<bean:message key="web_booking_edit.Back" />
															&nbsp;&nbsp;
														</div> --%>
														<div class="btn btn-primary next-button_reg_fir "
															onclick="submitBtn(); ">
															<span class="fas fa-arrow-right "></span>&nbsp;&nbsp;
															<bean:message key="registration.Submit" />
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

		<%--  <script src="<%=contextPath%>/js/registration.js?id=1"></script> --%>
		<script>
    var xmlhttp                             = new XMLHttpRequest();


    $(document).on('change', 'location', function () {
        var value = $(this).val();
        $(this).find('option[value="' + value + '"]').attr("selected", "selected");
    })
    

    
	$("form").submit(function() { $('#location').each(function(){
		$('#location option').attr("selected","selected");
		});
	});
	
      $(document).ready(function() {
      	$('#registration-custom-chart').attr('data-percent', 0);
      	updateCustomGraph('registration-custom-chart');
      	
      	
      	$('#password').on('keyup',function() {
      	    var count = $(this).val().length;
      			if(count>=10){ 
      				swal("Message","Password maxmimum length is 10,please remember we can enter till 10 character.","info")
      				}
      		});
      	
      });


      
  	


      $('[name="move-right"]').click(function(){
  		moveSelectedOptions(document.forms[0]['contryList'], document.forms[0]['location'],true);

  		if (document.forms[0]['location'].length == 0) {
  	        alert("Nothing to move.");
  	       
  	      }
  	});

  	$('[name="move-left"]').click(function(){
  		moveSelectedOptions(document.forms[0]['location'], document.forms[0]['contryList'],true);
  		if (document.forms[0]['contryList'].length == 0) {
  	        alert("Nothing to move.");
  	       
  	      }
  	});

  	$('[name="move-all-right"]').click(function(){
  		moveAllOptions(document.forms[0]['contryList'], document.forms[0]['location'],true);
  	});

  	$('[name="move-all-left"]').click(function(){
  		moveAllOptions(document.forms[0]['location'], document.forms[0]['contryList'],true);
  	});

  	

  	$('[name="save"]').click(function(){alert('jkkkjjj')
  		$('#location option').prop('selected','selected');
  		$('#contryList option').prop('selected','');
  		
  		$('[name="../do/serv0031sexn007updateUser"]').processRequest({
  			url: '../do/serv0031sexn007updateUser'
  		});

  	});

  

  
  	  
      function persoanlDetail(){
    	  debugger;
    	  $("#alertId").hide();
    	  var index=7;
    	  var isValid=true;

    	  var isloc;
    	 
       
    	  debugger;
    	  if($("#userLoginId").val()== ""){          	             
           	 $("#userLoginId").parsley().validate(true);    		
    		 	 $("#"+ $("#userLoginId").attr("aria-describedby")+" li").html('<bean:message key="registration.Please_enter_User_ID_first"/>');
    		 	 return false;
    		 	 isValid =false;
    		 	index--;
           }else {
        	   
        	   if($("#userLoginId").val().length < 6){                   
                   showBarMessageNew('<bean:message key="registration.Please_specifiy_User_Des"/>');
                   isValid =false;

                   
               }
           }

    	 
          
    	  if($("#password").val()== ""){          	             
            	 $("#password").parsley().validate(true);    		
     		 	 $("#"+ $("#userLoginId").attr("aria-describedby")+" li").html('<bean:message key="registration.Please_enter_password"/>');
     		 	 isValid =false;
     		 	index--;
            }else{
            	var isValid= validatePassword($("#password").val(),"");

            	
            	if(isValid){
            			 if($("#password").val()!=$("#rePassword").val()){
            				isValid =false;
            				showBarMessageNew('<bean:message key="registration.Both_the_password_is_not_same"/>');
            				
            			}
            	}
            }


    	  if($("#userInfoMod_email").val()== ""){
    		  $("#userInfoMod_email").parsley().validate(true);    		
    		  $("#"+ $("#userInfoMod_email").attr("aria-describedby")+" li").html('<bean:message key="registration.Please_Enter_email_id"/>');
    		  isValid =false;    		  
    		  index--;
    		  
    	  }
    	  
    	  
    	  if($("#name").val()== ""){          	             
            	 $("#name").parsley().validate(true);    		
     		 	 $("#"+ $("#name").attr("aria-describedby")+" li").html('Enter User Name');
     		 	 return false;
     		 	 isValid =false;
     		 	index--;
            }

    	  
		$('#registration-custom-chart span').html((Math.ceil(index/(4))+3)+"0%");
      	  
    	  return isValid;
      }
      


      function comparePassword(txtPassword, txtRePassword){
    	    var isMatch = false;
    	   // alert('txtPassword'+txtPassword);
    	   // alert('txtRePassword'+txtRePassword);
    	    try{
    	        error_code = 1;
    	        if(txtPassword.value == txtRePassword.value){
    	            isMatch = true;
    	        }else{
    	            error_code = 2;
    	            showBarMessage('Password and Repeat Password not matched.', MSG_ERROR_CODE);
    	            //alert('Password and Repeat Password not matched.');
    	            txtPassword.focus();
    	        }
    	    }catch(err){
    	        handleJavaScriptError('comparePassword', err, error_code);
    	        isMatch = false;
    	    }
    	    return isMatch;
    	}
  	
      
      function checkSpace(name){
    	debugger;
    	return  name.indexOf(' ') >= 0;
      }
      
      function loginPage(){
   		var logoutUrl = "../do/logout";
  		document.forms[0].action = logoutUrl;
  		document.forms[0].submit();
  	  }  

   function submitBtn(){
		debugger;
		var isPassed = false;
		try{
			//$('#location').selectedIndex = 1;
			
			var txtLocation =  $('#location option').prop('selected', 'selected');
         
	  			
	    	var txtPassword  = document.getElementsByName('password')[0];

			var txtRePassword  = document.getElementsByName('rePassword')[0];
			
			
			isPassed =  persoanlDetail();


			 if(isPassed && !comparePassword(txtPassword, txtRePassword)){
				 isPassed = false;
	            }
	            

			 if(txtLocation.length == 0){
	              showBarMessageNew('Please enter at least one location.', MSG_ERROR_CODE);
		     }
	
			if(isPassed && txtLocation.length > 0){
		     var url = REGISTRATION;
	    	document.forms[0].action = url;
	        document.forms[0].submit();
	       	}
	    }catch(err){
	        handleJavaScriptError('submitBtn', err, "");
	        unloading();
	    }
	  }


   function isNullObj(obj){
	    if(obj != null && obj != undefined){
	        return false;
	    }else{
	        return true;
	    }
	}

   function isBlank(objValue){
	    if(objValue != null && objValue != undefined && objValue != ''){
	        return false;
	    }else{
	        return true;
	    }
	}
	
   function validateUserId(txtUserId){
	    var isPass = true;
	    try{
	       // error_code = 1;
	        if(isNullObj(txtUserId) || isBlank(txtUserId.value)){
	         //   error_code = 2;
	            showBarMessageNew('Please enter User ID first.', MSG_ERROR_CODE);
	          // alert('Please specific User Id.');

	            isPass = false;
	        }else{
	           // error_code = 3;
	            //alert('txtUserId.length = '+txtUserId.value.length+'\ntxtUserId.value = '+txtUserId.value);
	            if(txtUserId.value.length < 6){
	             //   error_code = 4;
	                showBarMessageNew('Please specifiy User Id which is 6 to 10 characters long.', MSG_ERROR_CODE);
	                //alert('Please specific User Id.');

	                isPass = false;
	            }
	        }
	        //error_code = 5;
	    }catch(err){
	        handleJavaScriptError('validateUserId', err,"");
	        isPass = false;
	    }finally{
	        if(!isPass){
	            txtUserId.focus();
	        }
	    }
	    return isPass;
	}

   function checkAvailableUserId() {
		debugger;
	    var txtUserId = document.getElementsByName("userLoginId")[0];
	   // alert(txtUserId.value)
	    try{
	         if(validateUserId(txtUserId)){
	            var url = CHECK_AVAILABLE_USER_ID+'?userId='+gp_sanitizeURLString(gp_trim(txtUserId.value));
	    	    //alert(url)
	            
	            error_code = 4;
	            xmlhttp.onreadystatechange=callbackToFieldUserId;
	            error_code = 5;
	            xmlhttp.open("GET", url, true);
	            error_code = 6;
	            xmlhttp.send(null);
	            error_code = 7;
	        }
	    }catch(err){
	        unloading();
	        handleJavaScriptError('checkAvaliableUserId', err, error_code);
	    }

	}

   function callbackToFieldUserId()
   {
   	debugger;
       var respTxt                 = null;
       var userId                  = document.getElementsByName('userLoginId')[0];
      // var checkResultMessage      = document.getElementById('checkResultMessage');
       debugger;
       var userIdCheckedObj        = document.getElementById('userIdChecked');
       var userIdPassedObj         = document.getElementById('userIdPassed');
       try{
           error_code = 1;
           if(xmlhttp.readyState == 4 && xmlhttp.status == 200) {
               error_code      = 2;
               userIdChecked   = "true";
               respTxt         = xmlhttp.responseText;
               error_code      = 3;
               if(respTxt != null && respTxt != undefined && respTxt != ''){
                   error_code                      = 4;
                   userId.style.backgroundColor    = '#ff7c7c';
                   checkResultMessage.style.color  = '#FF0000';
                   checkResultMessage.innerHTML    = respTxt;

                   userIdPassed                    = "false";
               }else{
                   error_code                          = 5;
                   userId.style.backgroundColor        = '#FFFFFF';
                   checkResultMessage.style.color      = '#00c400';
                   checkResultMessage.style.fontWeight = 'bold';
                   checkResultMessage.style.fontSize   = '11';
                   checkResultMessage.innerHTML        = 'Available';
                   userIdPassed                        = "true";
               }
               error_code = 6;
               userIdCheckedObj.value = userIdChecked;
               userIdPassedObj.value = userIdPassed;
               error_code = 7;
               runPage1();
               error_code = 8;
               clearMsg();
               error_code = 9;
           }
           error_code = 10;
       }catch(err){
           unloading();
           handleJavaScriptError('callbackToFieldUserId', err, error_code);
       }
   }

   function validatePassword(txtPassword){
	   var digitFormat = /\D+/g;
	     var charFormat = /\d+/g;
	     var isMainInputBlank = false;
	     var isWrongMainInputFormat = false;
	     var isPassed = false;
	     try{
	         
	     	{
	             error_code = 3;
	            // alert(txtPassword.value.length);
	             if(txtPassword.length < 8){
		             error_code = 4;
	                 showBarMessageNew('Please create an alphanumeric password with minimum 8 characters', MSG_ERROR_CODE);
	             }else if(txtPassword.match(charFormat) == null || txtPassword.match(digitFormat) == null){
	                 error_code = 5;
	                 showBarMessageNew('Please create an alphanumeric password with minimum 8 characters', MSG_ERROR_CODE);

	             }else{
	                 isPassed = true;
	             }
	         }
	         error_code = 6;
	     }catch(err){
	         //handleJavaScriptError('validatePassword', err, error_code);
	     }
	     return isPassed;
	 }

   
   function logoutAdm() {
	   
	  	var logoutUrl = ON_LOG_OUT_ADM;
	  	//alert(logoutUrl);
	  	document.forms[0].action = logoutUrl;
	  	document.forms[0].submit();
	  }

  
    </script>
		<!-- End Of Script Section -->
	</form>
</body>
<style>
.input-field {
	height: 100px !important;
}

.form-control {
	height: 230px !important;
}
</style>
</html>
