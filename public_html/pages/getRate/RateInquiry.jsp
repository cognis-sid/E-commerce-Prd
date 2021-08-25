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
   
 <jsp:include page="../common/cognis/header.jsp"></jsp:include>
  <!-- End Of Nav Bar -->
  <div class="rcl-content">
     
    <!-- Start Of Page -->
   <!--   -->
    <div class="content-container content-height">
      <div class="container-fluid px-1 px-md-4 py-2 mx-auto">
        <div class="row d-flex justify-content-center">
          <div class="col-12">
            <div class="card card0 border-0">
              <div class="row">
                <div class="col-12">
                  <div class="card card00 m-2 border-0">
                    <div class="d-flex flex-md-row px-3 mt-4 mb-4 flex-column-reverse">
                      <div class="border-right" style="width: 550px;padding-right: 10px;">
                        <div class="row px-3">
                          <div class="col-12">
                            <h3 style="margin-top: 10px;"><strong><bean:message key="Get_Rate.rate_Inquiries"/></strong></h3>
                          </div>
                        </div>
                        <hr />
                        <!-- Your form Starts here -->
                        <div class="form-row">
                          <div class="form-group col-md-6">
                            <label for="inputPortOfLanding"><bean:message key="Get_Rate.From_Port_Of_Landing"/> <span class="mandatory">*</span></label>
                            <div class="input-icons">
					  		 
    						<select class="form-control input-field  " name="pol" id="pol" >
										<option selected="selected" value=""><bean:message key="search.Select_Pol" /></option>
									
					  		</select> 
					  		
							</div>
                          </div>
                          <div class="form-group col-md-6">
                            <label for="inputPortOfDischarge">&nbsp;<bean:message key="Get_Rate.To_Port_Of_Discharge"/> <span class="mandatory">*</span></label>
                            <div class="input-icons">
					  		    						
    						<select class="form-control input-field " name="pod" id="pod" >
										<option selected="selected" value=""><bean:message key="search.Select_Pod"/></option>
									<c:forEach var="listValue" items="${rateInquiryUim.contryList}">
										<option  value="${listValue.code}">${listValue.contryName} - ${listValue.code}</option>
									</c:forEach>
					  		</select> 
							</div>
                          </div>
                        </div>
                        <div class="form-row">
                          <div class="form-group col-md-6">
                            <label for="inputShipmentTerm"><bean:message key="Get_Rate.Shipment_Term"/> <span class="mandatory">*</span></label>                            
                            <select class="form-control" name="shipmentTerm" id="inputShipmentTerm">
                            	<option>CYCY</option>
                            </select>
                          </div>
                          <div class="form-group col-md-6">
                            <label for="inputCargoType"><bean:message key="Get_Rate.Cargo_Type"/>  <span class="mandatory">*</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                             
                            <select class="form-control" name="cargoType" id="inputCargoType">
                            	<option value="General Cargo"><bean:message key="Get_Rate.General_Cargo_GP"/></option>
                            </select>
                            
                            
                          </div>
                        </div>
						<div id="containerSizeDiv">
	                        <div class="form-row">
	                          <div class="form-group col-md-6">
	                            <label for="inputContainerSize"><bean:message key="Get_Rate.Container_Size"/> <span class="mandatory">*</span></label>
	                            <select id="inputContainerSize1" name="containerSize" class="form-control">	                               
	                              <option value="20 GP"><bean:message key="Get_Rate.Gp"/></option>	                               
	                              <option value="40 HC"><bean:message key="Get_Rate.Hc"/></option>
	                            </select>
	                          </div>
	                          <div class="form-group col-md-6">
	                            <label for="inputExpectedVolume"><bean:message key="Get_Rate.Expected_Volume"/><span class="mandatory">&nbsp;</span></label>
	                            <input type="number" class="form-control"  maxlength=3 onkeypress="return onKeyPressNumber(event)"  name="expectedVolume" id="inputExpectedVolume1"
	                              placeholder="Enter the Volume"  min="1">
	                          </div>
	                        </div>
                        </div>
                        <div class="form-row">
                          <div class="form-group col-md-8">
                          </div>
                          <div class="form-group col-md-4">
                            <button type="button" class="btn btn-primary btn-sm float-right py-0"
                              style="height: 30px !important" data-toggle="tooltip" data-placement="bottom"
                              title="Add more conatiner" onclick="addContainer()">
                              <i class="fas fa-plus" aria-hidden="true"></i>&nbsp; <bean:message key="Get_Rate.Add_More"/></button>
                          </div>
                        </div>
                        <div class="form-row">
                          <div class="form-group col-md-12">
                            <label for="inputCommodity"><bean:message key="Get_Rate.Commodity"/></label>
                            <input type="text" class="form-control" name="commodity" id="inputCommodity" placeholder="Enter the Commodity">
                          </div>
                        </div>
                        <div class="form-row">
                          <div class="form-group col-md-6">
                             
                            
                            <label for="eta" style="font-size:15px"><bean:message key="Get_Rate.Expected_Loading_Period_From"/><span class="mandatory">*</span> </label>
							<div class="input-icons">
								<i class="fas fa-calendar-alt icon"></i> <input type="text" name="loadingFrom"
									id="loadingFrom" class="form-control input-field  date-picker"  >
							</div>
                          </div>
                          <div class="form-group col-md-6">                     
                            
                            <label for="eta" style="font-size:15px"><bean:message key="Get_Rate.Expected_Loading_Period_To"/>  <span class="mandatory">*</span>&nbsp;&nbsp;&nbsp;&nbsp; </label>
							<div class="input-icons">
								<i class="fas fa-calendar-alt icon"></i> 
								<input type="text" name="loadingTo" 	id="loadingTo" class="form-control input-field  date-picker"  >
							</div>
							
                          </div>
                        </div>
                        <hr>
                        <div class="form-row">
                          <div class="col-md-12">
                            <div class="float-right">
                              <input type="reset" class="btn btn-danger js-cancel-search"/> 
                              <button type="button" class="btn btn-primary js-get-rates" onclick="validatePolPod()"><bean:message key="Get_Rate.Get_Rates"/></button>
                            </div>
                          </div>
                        </div>
                  
                        <!-- Your form Ends here -->
                      </div>
                      </form>
                      <div class="mb-4" style="min-height: 700px;float:right;width:100%;margin-left: 20px;">
                        <!-- You Result Starts here -->
                        <div id="searchResult">
                        </div>
                        <!-- Your Result Ends here -->
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
  </form>    
  <!-- Footer Starts here -->
   
  <!-- Footer Ends here -->
  <!-- End of Page -->
  <!-- Start Of script Section -->
  
  <!-- End Of Script Section -->
  <script>
var user_id_login ='${sessionScope.sUserAccountBean.userId}';
 // var user_id ='GUINESS7';
 user_id=user_id_login
  var countryCode='${sessionScope.sUserAccountBean.countryCode}';
   
  var line='${sessionScope.sUserAccountBean.line}';
  var trade='${sessionScope.sUserAccountBean.trade}';
  var agent='${sessionScope.sUserAccountBean.agent}';
  var line='${sessionScope.sUserAccountBean.line}';
  var fscCode='${sessionScope.sUserAccountBean.fscCode}';
   var orgCode='${sessionScope.sUserAccountBean.orgCode}';
   var customerName='${sessionScope.sUserAccountBean.customerName}';
   var companyName='${sessionScope.sUserAccountBean.companyName}';
   var orgType='${sessionScope.sUserAccountBean.orgType}';
   var tokenNumber;
       
    function getAllCurrency(){
    	
    	$.ajax({
    		method: "GET",
    		url: '/DCSWebService/rclws/currency',    		 
    		contentType: "application/json;",
    		traditional: true,
    		dataType: 'json',
    		success: function (data) {
    			g_currency= data.response;
    		},
    		error: function (error, textStatus, jqXHR) {
    			 
    		}
    	});
    }
    
    
function getAllSurcharge(){
    	
    	$.ajax({
    		method: "GET",
    		url: '/DCSWebService/rclws/commonService/getAllSurcharge',    		 
    		contentType: "application/json;",
    		traditional: true,
    		dataType: 'json',
    		success: function (data) {
    			ALL_SURCHARE = data;
    		},
    		error: function (error, textStatus, jqXHR) {
    			 
    		}
    	});
    }
    
var getCountryByCodeJson={};
function getCountryByCode(){
    	
    	$.ajax({
    		method: "GET",
    		url: '/DCSWebService/rclws/commonService/getCountryByCode',    		 
    		contentType: "application/json;",
    		traditional: true,
    		dataType: 'json',
    		success: function (data) {
    			getCountryByCodeJson=data;
    			
    			
    			$("#pol").html('<option value=""><bean:message key="search.Select_Pol" /></option>'+getCountryOpts())
    			$("#pod").html('<option value=""><bean:message key="search.Select_Pod" /></option>'+getCountryOpts())
    		
    		},
    		error: function (error, textStatus, jqXHR) {
    			 
    		}
    	});
    }
    
    
function generateToken(){
	var josnData=JSON.stringify({  "userId":user_id})
	
	$.ajax({
		method: "POST",
		url: '/DCSWebService/rclws/generateToken',
		data: josnData,
		contentType: "application/json;",
		traditional: true,
		dataType: 'json',
		success: function (data) {
			tokenNumber= data["token"]
		},
		error: function (error, textStatus, jqXHR) {
			 
		}
	});

}
var G_LIST_OF_COUNTRY_NOT_USER={};
<c:forEach var="countryCode" items="${rateInquiryUim.contryList}">
G_LIST_OF_COUNTRY_NOT_USER["${countryCode.code}"]="${countryCode.contryName}"
	 
</c:forEach>

//G_LIST_OF_COUNTRY
function getCountryOpts(){
	var opts ='';
	<c:forEach var="countryCode" items="${rateInquiryUim.contryList}">
		opts+='<option value="${countryCode.code}">'+G_LIST_OF_COUNTRY("${countryCode.code}")+'</option>';
	</c:forEach>
	return opts;
}




$(document).ready(function (){    	

 
			getAllSurcharge();
			getCountryByCode();
			generateToken();	
			getAllCurrency();
			
			 var etdDate = new Date();
			  etdDate.setDate(etdDate.getDate()+3); 
			
			  var maxDate=new Date();
			  maxDate.setDate(maxDate.getDate()+6);
			  
			  $('#loadingFrom').datetimepicker({
		       format: 'DD/MM/YYYY',
				defaultDate: etdDate,
				minDate : 	etdDate,
				
		     }).on('dp.change', function (e) {
		      
		       var date = new Date(e.date);
		       date.setDate(date.getDate() + 7);		       
		       var minDate = new Date(e.date);
			   minDate.setDate(minDate.getDate()+1);  
			   
			   
			   var minFrom = new Date(date);
			   minFrom.setDate(minFrom.getDate() -1);
			  // $('#loadingFrom').data("DateTimePicker").maxDate(minFrom);
				  
				$('#loadingTo').data("DateTimePicker").maxDate(new Date(date));
				$('#loadingTo').data("DateTimePicker").date(new Date(date));
				$('#loadingTo').data("DateTimePicker").minDate(minDate);
				});
			  
			  
			  var minDate = new Date();
			  minDate.setDate(minDate.getDate()+1); 
			  
			  var etaDate=new Date(etdDate);
			  etaDate.setDate(etaDate.getDate()+7);
			  
			  $('#loadingTo').datetimepicker({
		       format: 'DD/MM/YYYY',
				defaultDate : minDate,
				maxDate : etaDate,
				minDate : minDate,
		     });
		     $('#loadingTo').data("DateTimePicker").date(new Date(etaDate));
		     
		     $(".btn-danger").click(function(){
		    	 $("#searchResult").html("");
		    	});
			   		
			
		  $('[data-toggle="tooltip"]').tooltip();
		
		  //When the page loads, show the loading page and hide the result page
		  hideResultPage();
		  $('body').on('click', '.js-get-rates', function (e) {
		    e.preventDefault();
		    showResultPage();
		  });
		  $('body').on('click', '.js-cancel-search', function (e) {
		    e.preventDefault();
		    hideResultPage();
		  });
		
		  function showResultPage() {
		    $('.js-result-loading-div').removeClass('show');
		    $('.js-result-div').addClass('show');
		  }
		  function hideResultPage() {
		    $('.js-result-div').removeClass('show');
		    $('.js-result-loading-div').addClass('show');
		  }
		});
		
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

		var Get_Rate_GP_Message='<bean:message key="Get_Rate.Gp"/>';
		var Get_Rate_HC_Message='<bean:message key="Get_Rate.Hc"/>';
		var containerSize_Message = '<bean:message key="Get_Rates.Container_Size"/>';
		var addedmaxContainer_Message = '<bean:message key="addedmaxContainer"/>';
		var Port_of_Discharge_Message='<bean:message key ="search.Port_of_Discharge"/>'
		var Cargo_Type_Message='<bean:message key ="web_booking_edit.Cargo_Type"/>'
		var Freight_Charges_Message='<bean:message key ="Get_Rates.Freight_Charges"/>'
		var expectedVolume_Message ='<bean:message key="Get_Rates.Expected_Volume"/>';
		var freeDaysPerContainer_Message ='<bean:message key="Get_Rates.Free_Days_Per_Container"/>';
		var exportDemurrage_Message ='<bean:message key="Get_Rates.Export_Demurrage"/>';
		var exportDetention_Message ='<bean:message key="Get_Rates.Export_Detention"/>';
		var importDemurrage_Message ='<bean:message key="Get_Rates.Import_Demurrage"/>';
		var importDetention_Message ='<bean:message key="Get_Rates.Import_Detention"/>';
		 
		var regionalContainerLines_Message ='<bean:message key="Get_Rates.Regional_Container_Lines"/>';
		var rclRateInquiry_Message ='<bean:message key="Get_Rates.Rcl_Rate_Inquiry"/>';
		var from_Message ='<bean:message key="Get_Rates.From"/>';
		var shipmentTerm_Message ='<bean:message key="Get_Rates.Shipment_Term"/>';
		var expectedLoadingPeriod_Message ='<bean:message key="Get_Rates.Expected_Loading_Period"/>';
		//var to = '<bean:message key="Get_Rates.To"/>';
		//var cargoType ='<bean:message key="Get_Rates.Cargo_Type"/>';
		//var expectedVolume ='<bean:message key="Get_Rates.Expected_Volume"/>';
		var commodity_Message ='<bean:message key="Get_Rates.Commodity" />';
		var totalPrice_Message = '<bean:message key="Get_Rates.Total_Price"/>';
		var clickForPriceBreakDown__Message ='<bean:message key="Get_Rates.Click_For_Price_Break_Down" />';
		var dry_Message ='<bean:message key="Get_Rates.Dry" />';
		var priceBreakDown_Message ='<bean:message key="Get_Rates.Price_Breakdown" />';
		var oceanFreight ='<bean:message key="Get_Rates.Ocean_Freight"/>';
		var cancel_Message ='<bean:message key="Get_Rates.Cancel" />';
		var getQuatation_Message ='<bean:message key="Get_Rates.Get_Quatation"/>';
		
		var there_no_vessel_contact_agency_msg = '<bean:message key="Get_Rates.there_no_vessel_contact_agency_msg"/>';
		var no_routing_found_msg = '<bean:message key="Get_Rates.no_routing_found_msg"/>';
		var to = '<bean:message key="Get_Rates.To"/>';
		var duplicate_container_msg = '<bean:message key="Get_Rates.duplicate_container_msg"/>';
		var container_of_msg = '<bean:message key="Get_Rates.container_of_msg"/>';
		var expected_volume_zero_msg = '<bean:message key="Get_Rates.expected_volume_zero_msg"/>';
		var there_no_schedule_contact_agency_msg = '<bean:message key="Get_Rates.there_no_schedule_contact_agency_msg"/>';
		var duplicate_container_same_size_msg = '<bean:message key="Get_Rates.duplicate_container_same_size_msg"/>';
		var there_no_rate_found_msg = '<bean:message key="Get_Rates.there_no_rate_found_msg"/>';
		var contact_local_agency_msg = '<bean:message key="Get_Rates.contact_local_agency_msg"/>';
		var enter_Port_Landing_msg = '<bean:message key="Get_Rates.enter_Port_Landing_msg"/>';
		var enter_Port_Discharge_msg = '<bean:message key="Get_Rates.enter_Port_Discharge_msg"/>';
		var expected_Loading_Period_From_msg = '<bean:message key="Get_Rates.expected_Loading_Period_From_msg"/>';
		var expected_Loading_Period_To_msg = '<bean:message key="Get_Rates.expected_Loading_Period_To_msg"/>';
		var limit_rate_inquiry_contact_admin_msg = '<bean:message key="Get_Rates.limit_rate_inquiry_contact_admin_msg"/>';
		var system_Error_Occure_msg = '<bean:message key="Get_Rates.system_Error_Occure_msg"/>';
		var no_record_found_msg = '<bean:message key="Get_Rates.no_record_found_msg"/>';
		
		
		
		
		
		
		

  </script> 
		 
		 <style>
		 .searchPadding {
    		 margin: 0px; 
			}
			
			.table {
     
    	margin-bottom: 0px;  
}
		 </style>
</body>
</html>