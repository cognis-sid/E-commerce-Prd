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
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RCL Group</title>
<jsp:include page="../../pages/common/cognis/commonInclude.jsp"></jsp:include>  
<script type="text/javascript" src="<%=contextPath%>/js/screen/getRate.js?id=<%=new Date()%>"></script>
<script type="text/javascript" src="<%=contextPath%>/js/screen/surcharge.js?id=<%=new Date()%>"></script>
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
 	
 var SENDMAIL = "../do/getRate002";
 
 </script>
</head>
<body >
	
	<div class="top-nav">
    <div class="logo-container">
      <a href="#"><img src="imgs/rcl_logo.png" alt="rcl-logo"></a>
    </div>
    <div class="section-white"></div>
    <div class="section-blue navbar navbar-expand-lg navbar-dark">
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#rclNavBar"
        aria-controls="rclNavBar" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <a class="brand-logo" href="#"><img src="rcl_logo.png" alt=""></a>
      <div class="collapse navbar-collapse" id="rclNavBar">
        <ul class="nav nav-blue navbar-nav ml-auto">
          <li class="nav-item ">
            <a class="nav-link" href="dashboard.html">Online Help <span class="sr-only">(current)</span></a>
           
        </ul>
      </div>
    </div>
  </div>	
	<style>
		.mandatory{
			color:red;
			color: red;
		    font-style: italic;
		    font-size: 20px;
		    margin-top: 20px;
		}
		.searchPadding{
			margin:5px;
		}
		
		.rate_header{
			font-size:20px;
			}
			
			
	</style> 
	
 <form method="post"   action="../do/getRate002" id="pdfDownlaod" >
 <input type="hidden" id="payload" name="payload"/>
 <input type="hidden" id="freeDays" name="freeDays"/>
 <input type="hidden" id="quotationNo" name="quotationNo" value="RCL V01"/>
 <input type="hidden" id="containerSize20GP" name="containerSize20GP" value=""/>
 <input type="hidden" id="containerSize40GP" name="containerSize40GP" value=""/>
 <input type="hidden" id="containerSize40HC" name="containerSize45HC" value=""/>
 <input type="hidden" id="usd20GP" name="usd20GP" value=""/>
 <input type="hidden" id="usd40GP" name="usd40GP" value=""/>
 <input type="hidden" id="usd40HC" name="usd40HC" value=""/>
 
 <input type="hidden" id="portOfLoading" name="portOfLoading" value=""/>
 <input type="hidden" id="portOfDeparture" name="portOfDeparture" value=""/>
 <input type="hidden" id="numberOfContainer" name="numberOfContainer" value=""/>
 <input type="hidden" id="quotationRef" name="quotationRef" value=""/>
 
  <input type="hidden" id="currentDate" name="currentDate" value=""/>  
    
  
  <script>
	function hideAndShow(name){
		$(".userProfile").hide();
		$(".booking").hide();
		$(".shipping").hide();
		$("."+name).show();
		
	}
  </script>
  <!-- End Of Nav Bar -->
  <div class="rcl-content">
     
    <!-- Start Of Page -->
    <div class="content-container content-height ">
      <div class="left-menu pt-3">
        <div class="form-group">
           <label for="bookingNumber" onclick="hideAndShow('booking')">About E-Booking <i class="fa fa-question-circle" aria-hidden="true"></i> </label>
		 
           
        </div>
        <div class="form-group">
            <label for="ediNumber" onclick="hideAndShow('shipping')">About Shipping  <i class="fa fa-question-circle" aria-hidden="true"></i></label>
		    
           
        </div>
        <div class="form-group">
		  
          <label for="blNumber" onclick="hideAndShow('userProfile')">Rate Inquiry  <i class="fa fa-question-circle" aria-hidden="true"></i>
		   
		  </label>
		   
           
        </div>
         
      </div>
      <div class="right-menu">
        <div class="">
           
          <div class="row right-row mt-3 ml-1 mr-1 p-0">
            <div class="col-12  p-0">
              <ul class="nav nav-pills nav-justified esi-inquiry" id="pills-tab" role="tablist">
                <li class="nav-item">
                  <a class="nav-link active" id="pills-open-orders-tab" data-toggle="pill" href="#pills-open-orders"
                    role="tab" aria-controls="pills-open-orders" aria-selected="true"><i class="fa fa-question-circle" aria-hidden="true"></i> &nbsp;
                    English</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" id="pills-completed-orders-tab" data-toggle="pill" href="#pills-completed-orders"
                    role="tab" aria-controls="pills-completed-orders" aria-selected="false">
                    <i class="fa fa-question-circle" aria-hidden="true"></i>
                    China Locations</a>
                </li>
                 
              </ul>
            </div>
          </div>
          <div class="tab-content" id="pills-tabContent">
            <!-- Open Orders tab starts here -->
            <div class="tab-pane fade show active" id="pills-open-orders" role="tabpanel"
              aria-labelledby="pills-open-orders-tab">
              <!-- You ROW Starts here, to repeat just copy and paste the same div again and again -->
              <div class="div-booking-details right-row mt-3 ml-1 mr-1 pl-3 pr-3">
                 <div class="booking"  style="text-align:center;" >
					<h3>About E-Booking</h3>
					 
					
					<iframe width="100%" height="720" src="https://www.youtube.com/embed/F1hthxFG4GQ" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
					
				</div>
				
				<div class="shipping"  style="display:none;text-align:center;" >
					<h3>About E-Shipping</h3>
					 
					
					<iframe width="100%" height="720" src="https://www.youtube.com/embed/7X1ZR01Q-6g" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
				</div>
				
				<div class="userProfile"  style="display:none;text-align:center;">
					<h3>Rate Inquiry</h3>
					 
										 
					
					<iframe width="100%" height="720" src="https://www.youtube.com/embed/V2jsp7kTGzE" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
				</div>
                 
              </div>
              
            </div>
            <!-- Open Orders tab closes here -->
			
			
            <div class="tab-pane fade" id="pills-completed-orders" role="tabpanel"
              aria-labelledby="pills-completed-orders-tab">

              <!-- Incase you want to repeat Completed Orders repeat this tab -->
                <div class="booking"  style="text-align:center;" >
					<h3>About E-Booking</h3>
					 
					
					<iframe width="100%" height="720" src="https://www.youtube.com/embed/F1hthxFG4GQ" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
					
				</div>
				
				<div class="shipping"  style="display:none;text-align:center;" >
					<h3>About E-Shipping</h3>
					 
					
					<iframe width="100%" height="720" src="https://www.youtube.com/embed/7X1ZR01Q-6g" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
				</div>
				
				<div class="userProfile"  style="display:none;text-align:center;">
					<h3>Rate Inquiry</h3>
					 
										 
					
					<iframe width="100%" height="720" src="https://www.youtube.com/embed/V2jsp7kTGzE" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
				</div>
			  
			  
            </div>
             

        </div>
      </div>
      <div class="clearfix"></div>
    </div>
  </div>

  <style>
	h3{
	font-weight: 500;
	}
  </style>
   
  <!-- End Of Script Section -->
  <script>
    $(document).ready(function () {
      $('[data-toggle="tooltip"]').tooltip();


      $('.order-summary').on('hide.bs.collapse', function () {
        console.log("hide.bs.collapse", $(this));
        var id = $(this).attr('id');
        $('a[href="#' + id + '"]').html('More <i class="fa fa-angle-down" aria-hidden="true"></i>');
      });
      $('.order-summary').on('show.bs.collapse', function () {
        var id = $(this).attr('id');
        $('a[href="#' + id + '"]').html('Less <i class="fa fa-angle-up" aria-hidden="true"></i>');
      });
    });
  </script>
</body>
</html>