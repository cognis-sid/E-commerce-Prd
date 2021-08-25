<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page import="com.niit.control.common.GlobalConstants" %>
<%@page import="com.niit.control.web.action.BaseAction" %>
<%@ page import="com.niit.control.web.UserAccountBean" %>
<%@page import="com.niit.control.common.StringUtil" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String lstrCtxPath     = request.getContextPath();
%>
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Web Booking New</title>
  
  <script src="https://kit.fontawesome.com/cfc9fdee3b.js" crossorigin="anonymous"></script>
  <script type="text/javascript">
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');
  ga('create', 'UA-39255240-1', 'rclgroup.com');
  ga('send', 'pageview');
</script>
 <jsp:include page="../../pages/common/cognis/commonInclude.jsp"></jsp:include>
<style type="text/css">
.btnSamll {
  height: 30px !important;
  border-radius: 4px !important;
}
</style>
<script type="text/javascript" language="JavaScript" src="<%=lstrCtxPath%>/js/screen/EserviceNewWebBooking.js" ></script>
<script type="text/javascript" language="JavaScript">
    
var SAVE_BOOKING
		= '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn001SaveBooking", pageContext)%>';
var OPEN_ACKNOWLEDGEMENT
		= '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn003", pageContext)%>';
var SAVE_TEMPLATE
		= '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn001SaveTemplate", pageContext)%>';
var GET_TEMPLATE_DATA
		= '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn001GetTemplateData", pageContext)%>';
var DEL_SIZE_TYPE_DATA
		= '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn001delSizeType", pageContext)%>';
var DEL_COMMODITY_DATA
		= '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn001delCommodity", pageContext)%>';
//@03 BEGIN
var GET_DATA_BT_QTN
		= '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn001GetDefaultByQuotationNo", pageContext)%>';
//@03 END

var GET_BOOKING_NUMBER = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn002GetData", pageContext)%>';

var SET_QUATATION_ROUTING_DATA
		= '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn001SetQuotationRoutingData", pageContext)%>';

var REFER_COMMODITY
		= '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv019", pageContext)%>';

var REFER_COMMODITY_GET_DATA
		= '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn019getData", pageContext)%>';

var DG_COMMODITY
		= '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv020", pageContext)%>';

var DG_COMMODITY_GET_DATA
		= '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn020getData", pageContext)%>';

var OOG_COMMODITY
		= '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn021", pageContext)%>';

var OOG_COMMODITY_GET_DATA
		= '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn021getData", pageContext)%>';

var CHANGE_RATE_TYPE
		= '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn001changeRateType", pageContext)%>';

var UPD_SIZE_TYPE_DATA
		= '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn001updateSizeType", pageContext)%>';   

var UPLOAD_ATTACHMENT
		= '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv023", pageContext)%>'; 

var GET_UPLOAD_ATTACHMENT
		= '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv023getData", pageContext)%>';

var GET_EQUIP_TYPE_LOOKUP_DATA     
		= '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv028equipTypeLookUp", pageContext)%>';   

/*Begin @11*/    
var CHANGE_REP_COMP     
		= '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn001ChangeRepComp", pageContext)%>';
/*End @11*/

var CHECK_QTN_SIZE
		= '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn001CheckQuotationSize", pageContext)%>';

var ON_LOAD
		= '<%=com.niit.control.web. JSPUtils.getActionMappingURL("/sexn001", pageContext)%>';

var POPULATE_DEPENDENT_COMBOS
		= '<%=com.niit.control.web. JSPUtils.getActionMappingURL("/sexn001ChangeCountryCode", pageContext)%>';    

var CHECK_QTN
		= '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn001CheckQuotation", pageContext)%>';
var COMMODITY_LOOKUP
		= '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn004", pageContext)%>';    
var UPD_COMMODITY_DATA
		= '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn001updateCommodity", pageContext)%>';
var ADD_COMMODITY_DATA
		= '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn001addCommodity", pageContext)%>';  
var ADD_SIZE_TYPE_DATA
		= '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn001addSizeType", pageContext)%>';        
        
</script>
</head>
<body >	
	<form  method="POST" action="/sexn001">
<!-- hidden field start-->
 
 		<input type=hidden  name="bookingNo" value="${feserv01.bookingNo}"/>
        <input type=hidden  name="status" value="${feserv01.status}"/>
        <input type=hidden  name="email" value="${sessionScope.sUserAccountBean.mailId}"/>
        <input type=hidden  name="saveOperationFlag" value="${feserv01.saveOperationFlag}"/>
        <input type=hidden  name="openAcknowledgement" value="${feserv01.openAcknowledgement}"/>
        <input type=hidden  name="customerCode" value="${feserv01.customerCode}"/>
        <input type=hidden  name="customerName" value="${feserv01.customerName}"/>
        <input type=hidden  name="equipmentSeq" value="${feserv01.equipmentSeq}"/>
        <input type=hidden  name="commoditySeq" value="${feserv01.commoditySeq}"/>
        <input type=hidden  name="commodityRowIndex" value="${feserv01.commodityRowIndex}"/>
        <input type=hidden  name="line" value="${feserv01.line}"/>
        <input type=hidden  name="trade" value="${feserv01.trade}"/>
        <input type=hidden  name="agent" value="${feserv01.agent}"/>
        <input type=hidden  name="commodityGroup" value="${feserv01.commodityGroup}"/>
        <input type=hidden  name="commodityGroupDetail" value="${feserv01.commodityGroupDetail}"/>
        <input type=hidden  name="newWebBookingErrMsg" value="${feserv01.newWebBookingErrMsg}"/>
        <input type=hidden  name="msgTooltip" value="${feserv01.msgTooltip}"/>
        <!--Begin @10 -->
        <input type=hidden  name="deleleEqSizeType" id="deleleEqSizeType" value="${feserv01.deleleEqSizeType}"/>
        <input type=hidden  name="deleteCommod" id="deleteCommod" value="${feserv01.deleteCommod}"/>
        <input type=hidden  name="commoditySeqNoTmp" id="commoditySeqNoTmp" value="${feserv01.commoditySeqNoTmp}"/>
        <input type=hidden  name="equipmentSeqNoTmp" id="equipmentSeqNoTmp" value="${feserv01.equipmentSeqNoTmp}"/>
        <input type=hidden  name="uploadFlag" id="uploadFlag" value="${feserv01.uploadFlag}"/>
        <input type=hidden  name="errMsg" id="errMsg" value="${feserv01.errMsg}"/>
        <input type=hidden  name="rfTypeNormal" id="rfTypeNormal" value="${feserv01.rfTypeNormal}"/>
 
<!-- hidden field end -->	
<!-- Start Of Nav Bar -->
  <jsp:include page="../../pages/common/cognis/header.jsp"></jsp:include>
  <!-- End Of Nav Bar -->
  <div class="rcl-content" style="margin-top: 20px !important;">
    <nav aria-label="breadcrumb" class="mt-2" >
      <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="#"><bean:message key="web_booking.Home"/></a></li>
        <li class="breadcrumb-item"><a href="#"><bean:message key="web_booking.Web_Booking"/></a></li>
        <li class="breadcrumb-item active" aria-current="page"><bean:message key="web_booking.Booking_Details"/></li>
      </ol>
    </nav>
    <!-- Start Of Page -->
    <div class="content-container">
      <div class="container-fluid px-1 px-md-4 py-2 mx-auto">
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
                            <h3 style="margin-top: 10px;"><strong><bean:message key="web_booking.Web_Booking"/></strong></h3>
                          </div>
                          <div class="col-3">
                            <div class="row justify-content-center">
                              <div class=" col">
                                <div class="custom-chart" id="booking-dedtails-progress" data-percent="0" data-size="60"
                                  data-line="6">
                                </div>
                              </div>
                            </div>
                          </div>
                        </div>
                        <hr />
                        <div class="card1 mt-5">
                          <ul id="progressbar" class="text-center">
                            <li class="active step0"></li>
                            <li class="step0"></li>
                            <li class="step0"></li>
                          </ul>
                          <h5 class="mb-5">
                            <a href="#" class="progressbar-menu progressbar-menu-active">
                              <strong><bean:message key="web_booking.E_Booking" /></strong></a>

                          </h5>
                          <h5 class="mb-5">
                            <a href="#" class="progressbar-menu">
                              <strong><bean:message key="web_booking.Routing_&_Schedule" /></strong></h5></a>

                          <h5 class="mb-5">
                            <a href="#" class="progressbar-menu">
                              <strong><bean:message key="web_booking.Equipment_&_Commodity" /> </strong></h5>
                          </a>

                        </div>

                      </div>
                      <div class="col-md-8 mb-4" style="min-height: 700px;">
                      
                       <jsp:include page="../../pages/common/cognis/alert.jsp"></jsp:include>
                       
                        <div class="card2 first-screen show ml-2">
                          <h5 class="card-title">
                            <strong><i class="fas fa-ticket-alt" aria-hidden="true"></i>&nbsp; <bean:message key="web_booking.Booking_Details" /> </strong>
                          </h5>
                          <hr />
                          <div class="form-row">
                            <div class="form-group col-md-4">
                              	<label for="inputTemplate"><bean:message key="web_booking.Template" /> </label>
                             	<select name="template" id="template" size="1" onchange="onTemplateChange()" class="form-control">
									<c:forEach var="listValue" items="${feserv01.templateValues}">
										<c:if test="${listValue.code == feserv01.template }">
										<option selected="selected" value="${listValue.code}">${listValue.name}</option>
										</c:if>
										<c:if test="${listValue.code != feserv01.template }">
										<option  value="${listValue.code}">${listValue.name}</option>
										</c:if>
									</c:forEach>
					  			</select>
                            </div>
                            <div class="form-group col-md-4">
                              <div class="checkbox">
                                <input type="checkbox" class="margin-left-zero styled-checkbox"
                                  name="representCompChkBox" id="representCompChkBox" 
                                  	value="Y"  onclick="lp_manageRepresentCompChkBox(2);"/>
                                <label for="inputRepresentedCompany"><bean:message key="web_booking.Represented_Company" /></label>
                              </div>

                              <select name="representComp" id="representComp" size="1" onchange="checkQuotationNo();" class="form-control">
									<c:forEach var="listValue" items="${feserv01.representCompValues}">
										<c:if test="${listValue.code == feserv01.representComp}">
										<option selected="selected" value="${listValue.code}">${listValue.name}</option>
										</c:if>
										<c:if test="${listValue.code != feserv01.representComp}">
										<option value="${listValue.code}">${listValue.name}</option>
										</c:if>
									</c:forEach>
					  			</select>
                            </div>
                            <div class="form-group col-md-4">
                              <label for="inputCOC"><bean:message key="web_booking.COC/SOC" /> </label>
                              <select name="socCocUserFlag" id="socCocUserFlag" size="1"  class="form-control">
								     <c:if test="${socCocUserFlag == 'S'}">										
								 	  <option selected="selected" value="S"><bean:message key="web_booking_edit.shipperOwnContainer"/></option>
								   </c:if>
								    <c:if test="${socCocUserFlag != 'S'}">										
								 	  <option value="S"><bean:message key="web_booking_edit.shipperOwnContainer"/>r</option>
								   </c:if>
								   <c:if test="${socCocUserFlag == 'C'}">
								   		<option selected="selected" value="C"><bean:message key="web_booking_edit.carrierOwnContainer"/></option>
								   </c:if>
								   <c:if test="${socCocUserFlag != 'C'}">
								   		<option  value="C"><bean:message key="web_booking_edit.carrierOwnContainer"/></option>
								   </c:if>
					  		  </select>
                            </div>
                          </div>
                          <div class="form-row">
                            <div class="form-group col-md-4">
                              <label for="inputBookingNumber"><bean:message key="web_booking.Booking_Number" /> </label>
                              <input type="text" class="form-control" name="bookingNo" id="bookingNo" 
                                readonly value="${feserv01.bookingNo}" />
                            </div>
                            <div class="form-group col-md-4">
                              <label for="inputQuatationNumber"><bean:message key="web_booking.Quotation_Number" /></label>
                               <select name="quotationNumber" size="1" class="form-control">
									<c:forEach var="listValue" items="${feserv01.quotationNumberValues}">
										<c:if test="${listValue.code == feserv01.quotationNumber}">
										<option  selected="selected" value="${listValue.code}">${listValue.name}</option>
										</c:if>
										<c:if test="${listValue.code != feserv01.quotationNumber}">
										<option  value="${listValue.code}">${listValue.name}</option>
										</c:if>
									</c:forEach>
					  			</select>
                            </div>
                            <div class="form-group col-md-4">
                              <label for="inputStatus"><bean:message key="web_booking.Status" /> </label>
                              <input type="text" class="form-control" name="status" readonly
                                value="${feserv01.status}" />
                            </div>
                          </div>

                          <div class="form-row">
                            <div class="form-group col-md-6">
                              <label for="inputPOLTeam"><bean:message key="web_booking.POL_Team" /></label>
                              <select name="pol" size="1" class="form-control">
									<c:forEach var="listValue" items="${feserv01.polList}">
										<c:if test="${listValue.code == feserv01.pol}">
										<option selected="selected" value="${listValue.code}">${listValue.name}</option>
										</c:if>
										<c:if test="${listValue.code != feserv01.pol}">
										<option value="${listValue.code}">${listValue.name}</option>
										</c:if>
									</c:forEach>
					  			</select>
                            </div>
                            <div class="form-group col-md-6">
                              <label for="inputPODTeam"><bean:message key="web_booking.POD_Team" /></label>
                              <select name="pod" size="1" class="form-control">
									<c:forEach var="listValue" items="${feserv01.podList}">
									    <c:if test="${listValue.code == feserv01.pod}">
										<option selected="selected" value="${listValue.code}">${listValue.name}</option>
										</c:if>
										<c:if test="${listValue.code != feserv01.pod}">
										<option  value="${listValue.code}">${listValue.name}</option>
										</c:if>
									</c:forEach>
					  			</select>
                            </div>
                          </div>
                          <hr>
                          <div class="form-row">
                            <div class="form-group  col-md-6">
                              <label for="inputCustomerReference"><bean:message key="web_booking.Customer_Reference" /> </label>
                             <input type="text" class="form-control" name="customerReference" maxlength='17' onblur="changeUpper(this)" />
                            </div>
                            <div class="form-group  col-md-6">
                              <label for="inputEmailAddress"><bean:message key="web_booking.Email" /></label>
                              <input type="text" class="form-control" name="email" value="${sessionScope.sUserAccountBean.mailId}"
                                readonly="readonly"/>	
                            </div>
                          </div>
                          <div class="form-row">
                            <div class="form-group  col-md-6">
                              <label for="inputTelephone"><bean:message key="web_booking.Telephone" /> </label>
                              <input type="text" class="form-control" name="telephone" id="telephone"    value="${feserv01.telephone}" readonly="readonly"/>
                            </div>
                            <div class="form-group  col-md-6">
                              <label for="inputFax"><bean:message key="web_booking.Fax" /></label>
                              <input type="text" class="form-control" name="fax" maxlength='17' onblur="changeUpper(this)"
                                  value="${feserv01.fax}"  />
                            </div>
                          </div>
                          <div class="form-group">
                            <label for="inputContactPerson"><bean:message key="web_booking.Contact_Person" /></label>
                             <input type="text" class="form-control" name="contact" maxlength='25' onblur="changeUpper(this)" 
                              value="${feserv01.contact}" />
                          </div>
                          <div class="form-group">
                            <label for="inputAdditionalMailReciepients"><bean:message key="web_booking.Additional_Mail_Recipients" /> </label>
                            <textarea class="form-control" name="additionalMailRecipeints" value="${feserv01.additionalMailRecipeints}"  onblur="validateEmail();" rows="4"></textarea>
                          </div>
                          <hr>
                          <div class="float-right">
                            <div class="btn btn-primary next-button" onclick="routingPage();">
                              <span class="fas fa-arrow-right"></span>&nbsp;&nbsp;
                              <bean:message key="web_booking.continue"/>&nbsp;&nbsp;
                            </div>
                          </div>
                        </div>
                        <div class="card2 ml-2">
                          <h5 class="card-title"><strong><i class="fas fa-calendar-check" aria-hidden="true"></i>&nbsp;
                              <bean:message key="web_booking.Routing_&_Schedule" /></strong></h5>
                          <hr />
                          <div class="form-row">
                            <div class="form-group col-md-6">
                              <label for="inputOriginalCountry"><bean:message key="web_booking.Original_Country" /></label>
			        				<c:forEach var="listValue" items="${feserv01.originCountryValues}" varStatus="loopCounter" >
										<c:if test="${listValue.code != '' }">
										<input type="hidden" name="originCountry" id="originCountry"   class="form-control" value="${listValue.code }" >		    
										<input type="text" name="originCountryName" id="originCountryName"   class="form-control" value="${listValue.name }" >
										</c:if>
									</c:forEach>
                            </div>
                            <div class="form-group col-md-6">
                              <label for="inputDestinationCountry"><bean:message key="web_booking.Destination_Country" /></label>
									<c:forEach var="listValue" items="${feserv01.destinationCountryValues}" varStatus="loopCounter">
										<c:if test="${listValue.code != ''}">
										<input type="hidden" name="destinationCountry" id="destinationCountry"   class="form-control" value="${listValue.code }" >		    
										<input type="text" name="destinationCountryName" id="destinationCountryName"  class="form-control" value="${listValue.name }" >
										</c:if>
									</c:forEach>
					  		
                            </div>
                          </div>
                          <div class="form-row">
                            <div class="form-group col-md-6">
                              <label for="inputPortOfLanding"><bean:message key="web_booking.Port_of_Loading_POL" /></label>
									<c:forEach var="listValue" items="${feserv01.portOfLoadingValues}" varStatus="loopCounter">
									    <c:if test="${listValue.code != ''}">
										    <input type="hidden" name="portOfLoading" id="portOfLoading"  value="${listValue.code }"  class="form-control">
											<input type="text" name="portOfLoadingName" id="portOfLoadingName"  value="${listValue.name }"  class="form-control">
										</c:if>
									</c:forEach>
                            </div>
                            <div class="form-group col-md-6">
                              <label for="inputPortOfDischarge"><bean:message key="web_booking.Port_of_Discharge_POD" /></label>
									<c:forEach var="listValue" items="${feserv01.portOfDischargeValues}">
										<c:if test="${listValue.code != ''}">
											 <input type="hidden"  name="portOfDischarge" id="portOfDischarge" value="${listValue.code }" class="form-control"   >
											 <input type="text"  name="portOfDischargeName" id="portOfDischargeName" value="${listValue.name }" class="form-control"   >
										</c:if>
									</c:forEach>
					  		
                            </div>
                          </div>
                          <div class="form-row">
                            <div class="form-group col-md-6">
                              <label for="inputPlaceOfReciept"><bean:message key="web_booking.Place_of_Receipt" /> </label>
                              <select name="placeOfReceipt" id="placeOfReceipt" class="form-control" size="1" onchange="checkQuotationNo();">
									<c:forEach var="listValue" items="${feserv01.placeOfReceiptValues}">
										<c:if test="${listValue.code == feserv01.placeOfReceipt }">
										<option selected="selected" value="${listValue.code}">${listValue.name}</option>
										</c:if>
										<c:if test="${listValue.code != feserv01.placeOfReceipt }">
										<option value="${listValue.code}">${listValue.name}</option>
										</c:if>
									</c:forEach>
					  			</select>
                            </div>
                            <div class="form-group col-md-6">
                              <label for="inputPlaceOfDelivery"><bean:message key="web_booking.Place_of_Delivery" /> </label>
                              <select name="placeOfDelivery" size="1" onchange="checkQuotationNo();" class="form-control">
									<c:forEach var="listValue" items="${feserv01.placeOfDeliveryValues}">
										<c:if test="${listValue.code == feserv01.placeOfDelivery}">
										<option selected="selected" value="${listValue.code}">${listValue.name}</option>
										</c:if> 
										<c:if test="${listValue.code != feserv01.placeOfDelivery}">
										<option  value="${listValue.code}">${listValue.name}</option>
										</c:if>
									</c:forEach>
					  			</select>
                            </div>
                          </div>
                          <div class="form-group">
                            <label for="inputEmptyPickUpDepo"><bean:message key="web_booking.Empty_Pickup_Depot" /></label>
                            <select name="emptyPickupDepot" size="1" class="form-control" onchange="checkQuotationNoNew();" class="form-control">
									<c:forEach var="listValue" items="${feserv01.emptyPickupDepotValues}">
										<c:if test="${listValue.code == feserv01.emptyPickupDepot}">
										<option selected="selected" value="${listValue.code}">${listValue.name}</option>
										</c:if>
										<c:if test="${listValue.code != feserv01.emptyPickupDepot}">
										<option  value="${listValue.code}">${listValue.name}</option>
										</c:if>
									</c:forEach>
					  		</select>
                          </div>
                          <div class="form-row">
                            <div class="form-group col-md-3">
                              <label for="etd"><bean:message key="web_booking.Empty_Pickup_Date" /></label>
                              <div class="input-icons">
                                <i class="fas fa-calendar-alt icon"></i>
                                <input type="text" class="form-control  input-field date-picker" value="${feserv01.emptyPickupDate}" id="emptyPickupDate" name="emptyPickupDate">
                              </div>
                            </div>
                            <div class="form-group col-md-3">
                              <label for="etd"><bean:message key="web_booking.Cargo_Availability_Date" /> </label>
                              <div class="input-icons">
                                <i class="fas fa-calendar-alt icon"></i>
                                <input type="text" class="form-control  input-field date-picker" id="shipmentDate" value="${feserv01.shipmentDate}" name="shipmentDate">
                              </div>
                            </div>
                            <div class="form-group col-md-3">
                              <label for="etd"><bean:message key="web_booking.Expected_Sailing_Date" /> </label>
                              <div class="input-icons">
                                <i class="fas fa-calendar-alt icon"></i>
                                <input type="text" class="form-control  input-field date-picker" id="sailingDate" value="${feserv01.sailingDate}" name="sailingDate">
                              </div>
                            </div>
                            <div class="form-group col-md-3">
                              <label for="etd"><bean:message key="web_booking.Desired_Arriaval_Date" />  </label>
                              <div class="input-icons">
                                <i class="fas fa-calendar-alt icon"></i>
                                <input type="text" class="form-control  input-field date-picker" value="${ feserv01.desiredArrivalDate}" id="desiredArrivalDate" name="desiredArrivalDate">
                              </div>
                            </div>
                          </div>
                          <div class="form-group">
                            <label for="inputRoutingPreference"><bean:message key="web_booking.Routing_Preference" /> </label>
                            <textarea name="inputRoutingPreference" class="form-control" id="routingPreference" value="${feserv01.routingPreference}"
                              rows="4" placeholder="Min 5 lines...."></textarea>
                          </div>
                          <hr>
                          <div class="row float-right">
                            <div class="btn btn-secondary prev mr-2">
                              <bean:message key="web_booking.back" />&nbsp;&nbsp;<span class="fas fa-arrow-left"></span>&nbsp;&nbsp;
                            </div>
                            <div class="btn btn-primary next-button">
                              <span class="fas fa-arrow-right"></span>&nbsp;&nbsp;
                                <bean:message key="web_booking.continue" />&nbsp;&nbsp;
                            </div>
                          </div>
                        </div>
                        <div class="card2 ml-2">
                          <!-- Equipment Details Starts here -->
                          <h5 class="card-title">
                            <strong><i class="fas fa-file-invoice" aria-hidden="true"></i>&nbsp;<bean:message key="web_booking.Equipment_Details" /> </strong>
                          </h5>
                          <hr />

                         <div class="equipment-details">
                            <div class="table-responsive">
                              <table class="table equipment-comodity-details  border-bottom" id="search_result" >
                                <colgroup>
                                  <col span="1" style="width: 3%;">
                                  <col span="1" style="width: 15%;">
                                  <col span="1" style="width: 10%;">
                                  <col span="1" style="width: 10%;">
                                  <col span="1" style="width: 10%;">
                                  <col span="1" style="width: 10%;">
                                  <col span="1" style="width: 15%;">
                                  <col span="1" style="width: 12%;">
                                  <col span="1" style="width: 12%;">
                                  <col span="1" style="width: 3%;">
                                </colgroup>
                                <thead>
                                  <tr class="bg-light-blue">
                                    <th scope="col-1">#</th>
                                    <th scope="col-2"><bean:message key="web_booking.Type" /> </th>
                                    <th scope="col-1"><bean:message key="web_booking.Size" /> </th>
                                    <th scope="col-1"><bean:message key="web_booking.Cargo_Type" /></th>
                                    <th scope="col-1"><bean:message key="web_booking.Laden" /></th>
                                    <th scope="col-1"><bean:message key="web_booking.Empty" /></th>
                                    <th scope="col-2"><bean:message key="web_booking.CargoContainer"/></th>
                                    <th scope="col-1"><bean:message key="web_booking.POL_Status"/></th>
                                    <th scope="col-1"><bean:message key="web_booking.POD_Status"/></th>
                                    <th scope="col-1"><bean:message key="web_booking.Select"/></th>
                                  </tr>
                                </thead>
                              <tbody id="result_dtl">
								<c:forEach var="listofequipment" items="${feserv01.equipmentVoDataList}"  varStatus="loopCounter">
                                 
                                  <tr scope="row border-bottom">
                                    <th>${loopCounter.count}</th>
                                    <input type=hidden name="type" value="${listofequipment.type}" id= "type${loopCounter.count-1}" />
                                    <td>
                                      <div class="input-group">
                                        <input type="text" class="form-control form-control-sm" name="typeDesc" id="typeDesc${loopCounter.count-1}"
                                         value="${listofequipment.typeDesc }" readonly="true">
                                        <div class="input-group-prepend cursor-pointer">
                                          <div class="input-group-text" name="btnTypeLookup" href="javascript:void(0)" onclick='openEquipTypeLookup(this);' ><i class="fas fa-search"></i></div>
                                        </div>
                                      </div>
                                    </td>
                                    
                                    <td>
                                      <select name='size' id="size${loopCounter.count-1}" class="form-control"  onchange="updateSizeTypeRecStatusNew(this,${loopCounter.count-1});">
										<c:forEach var="listsize" items="${feserv01.sizeValues}">
											<c:if test="${listsize.code ==  listofequipment.size}">
											<option selected="selected" value="${listsize.code}">${listsize.name}</option>
											</c:if>
											<c:if test="${listsize.code !=  listofequipment.size}">
											<option  value="${listsize.code}">${listsize.name}</option>
											</c:if>
										</c:forEach>
					  			     </select>
                                    </td>
                                    <td>
                                      <select name='cargoType' id="cargoType${loopCounter.count-1}" class="form-control"  onchange="updateSizeTypeRecStatusNew(this,${loopCounter.count-1});">
										<c:forEach var="listcargoType" items="${feserv01.cargoTypeValues}">
											<c:if test="${listcargoType.code == listofequipment.cargoType }">
											<option selected="selected" value="${listcargoType.code}">${listcargoType.name}</option>
											</c:if>
											<c:if test="${listcargoType.code != listofequipment.cargoType }">
											<option value="${listcargoType.code}">${listcargoType.name}</option>
											</c:if>
										</c:forEach>
					  			     </select>
                                    </td>
                                    <td>
                                      <input type="text" class="form-control form-control-sm" value="${listofequipment.laden}"
                                       name='laden' id="laden${loopCounter.count-1}"  maxlength='4' onblur="maskWithOutDecimal(this, 4, 2);updateSizeTypeRecStatusNew(this,${loopCounter.count-1});" />
                                    </td>
                                    <td>
                                      <input type="text" class="form-control form-control-sm" value="${listofequipment.mt }"
                                       name='mt' id="mt${loopCounter.count-1}"  maxlength='4' readonly="true" onblur="maskWithOutDecimal(this, 4, 2);updateSizeTypeRecStatusNew(this,${loopCounter.count-1});" >
                                    </td>
                                    <td>
                                      <input type="text" class="form-control form-control-sm" value="${listofequipment.grossContainerWeight}"
                                       name='grossContainerWeight' id="grossContainerWeight${loopCounter.count-1}"  maxlength='17' onblur="putMask_NumberEX(this, 14, 2);updateSizeTypeRecStatusNew(this,${loopCounter.count-1});" onclick="hideMask_Number(this);" />
                                    </td>
                                    <td>
                                     <select name='polStatus' id="polStatus+ ${loopCounter.count-1}" class="form-control"  onblur='updateSizeTypeRecStatusNew(this,${loopCounter.count-1});' disabled="true">
										<c:forEach var="listpolStatus" items="${feserv01.polStatusList}">
											<c:if test="${listpolStatus.code == listofequipment.polStatus}">
											<option selected="selected" value="${listpolStatus.code}">${listpolStatus.name}</option>
											</c:if>
											<c:if test="${listpolStatus.code != listofequipment.polStatus}">
											<option value="${listpolStatus.code}">${listpolStatus.name}</option>
											</c:if>
										</c:forEach>
					  			     </select>
                                    </td>
                                    <td>
                                     <select name='podStatus' id="podStatus+ ${loopCounter.count-1}" class="form-control" onblur='updateSizeTypeRecStatusNew(this,${loopCounter.count-1});' size="1" disabled="true">
										<c:forEach var="listpodStatus" items="${feserv01.podStatusList}">
											<c:if test="${listpodStatus.code ==  listofequipment.podStatus}">
											<option selected="selected" value="${listpodStatus.code}">${listpodStatus.name}</option>
											</c:if>
											<c:if test="${listpodStatus.code !=  listofequipment.podStatus}">
											<option value="${listpodStatus.code}">${listpodStatus.name}</option>
											</c:if>
										</c:forEach>
					  			     </select>
                                    </td>
                                    
                                    <td>
                                    
	                                    <c:if test="${loopCounter.count==1}">
	                                    	<input type=hidden name='eqRecordStatus' id="eqRecordStatus${loopCounter.count-1}" value="${listofequipment.eqRecordStatus}">
	                        				<input type=hidden name='eqSeqNo' id="eqSeqNo${loopCounter.count-1}" value="${listofequipment.eqSeqNo }" >    
	                                    </c:if>
	                                    <c:if test="${loopCounter.count>1}" >
		                                    <div class="checkbox mt-2 pl-2">
		                                  	  <input type="checkbox" class="margin-left-zero styled-checkbox form-control" name='equipmentSelectChkBox' id= "equipmentSelectChkBox${loopCounter.count-1}" value="Y"  >
		                                    </div>
					                           <input type=hidden name='eqRecordStatus' id="eqRecordStatus${loopCounter.count-1}" value="${listofequipment.eqRecordStatus}" >
					                           <input type=hidden name='eqSeqNo' id="eqSeqNo${loopCounter.count-1}" value="${listofequipment.eqSeqNo }">  
	                                    </c:if>
                                    </td>
                                  </tr>
                                 
								</c:forEach>
							 </tbody>
							 
                              
                              </table>
                            </div>
                          </div>

 						<div class="row">
                            <div class="col-12">
                              <div class="btnSamll btn-danger btn-sm float-right" data-toggle="tooltip"
                                data-placement="bottom" title="Delete Equipment" href="javascript:void(0)" onClick="return deleteEquipmentNew();">
                                <span class="fas fa-trash"></span>
                              </div>
                              <div class="btnSamll btn-success btn-sm mr-2 float-right" data-toggle="tooltip"
                                data-placement="bottom" title="Add New Equipment" href="javascript:void(0)" onClick="return addEquipmentNew();">
                                <span class="fas fa-plus"></span>
                              </div>
                            </div>
                          </div>
                          <div class="row mt-3">
                            <div class="col-12">
                              <textarea class="form-control" 
                                name="cargoDescription"
                                value="${feserv01.cargoDescription}"
		                        cols="50"
		                        rows="5"
		                        onkeyup="maxlenghtTextArea('cargoDescription', 500)"
		                        onclick="maxlenghtTextArea('cargoDescription', 500)"></textarea>
                            </div>
                          </div>
                          <!-- Equipment Details Ends here -->
                          <hr>
                          <!-- Commodity Details Starts here -->
                          <h5 class="card-title">
                            <strong><i class="fas fa-file-invoice" aria-hidden="true"></i>&nbsp;<bean:message key="web_booking.Commodity_Details"/></strong>
                          </h5>
                          <hr />
                          <div class="equipment-details">
                            <div class="table-responsive">
                              <table class="table equipment-comodity-details  border-bottom" id="comm_search_result">
                                <colgroup>
                                  <col span="1" style="width: 5%;">
                                  <col span="1" style="width: 5%;">
                                  <col span="1" style="width: 15%;">
                                  <col span="1" style="width: 15%;">
                                  <col span="1" style="width: 20%;">
                                  <col span="1" style="width: 10%;">
                                  <col span="1" style="width: 25%;">
                                  <col span="1" style="width: 5%;">
                                </colgroup>
                                <thead>
                                  <tr class="bg-light-blue">
                                  	<th scope="col-1"><th>
                                  	<th scope="col-1">#</th>
                                    <th scope="col-2"><bean:message key="web_booking.Commodity_Group" /></th>
                                    <th scope="col-1"></th>
                                    <th scope="col-1"><bean:message key="web_booking.Gross_Weight" /></th>
                                    <th scope="col-1"><bean:message key="web_booking.Special_Cargo" /></th>
                                    <th scope="col-1"><bean:message key="web_booking.Rate_Type"/></th>
                                    <th scope="col-1"><bean:message key="web_booking.Select" />  </th>
                                  </tr>
                                </thead>
                                 <tbody id="comm_result_dtl">
                                	<c:forEach var="listofcommodityVoData" items="${feserv01.commodityVoDataList}"  varStatus="loopCounter">
                                			<tr scope="row border-bottom">
                                			   <td>
	                                			   <div class="radio">
	                                			   	 <input type="radio" class="form-control"  style="height: 20px !important"; name="radCommodity" id="radCommodity${loopCounter.count-1}"   value="${loopCounter.count-1}"  onclick="displaySpecialIns()" > 
	                                			   </div>
                                			   </td>
                                			   <th>${loopCounter.count}</th>
                                			   <td>
	                                			   <input type="hidden" name="posObjectCommod" id='posObjectCommod${loopCounter.count-1}' value="${loopCounter.count-1}" />
	                                			   <input type="hidden" name='seqNo' id="seqNo${loopCounter.count-1}" value="${listofcommodityVoData.seqNo }"  /> 
	                                        	   <input type="text" class="form-control" name='group' id="group${loopCounter.count-1}" value="${listofcommodityVoData.group}" 
	                           						 maxlength='1'  readonly="true"  onblur='updateCommodityRecStatusNew(this);changeUpper(this);'>
                                			   </td>
                                			   <td>
												 <div class="input-group">
														<input type="text" class="form-control" name='description' value="${listofcommodityVoData.description }"
														 	id="description${loopCounter.count-1}"  maxlength='1' onblur="changeUpper(this)" readonly="true">
													<div class="input-group-prepend cursor-pointer">
														<div class="input-group-text" href="javascript:void(0)"
                           											 onclick='openCommodityGroupLookupNew(this,${loopCounter.count-1});'>
                           								<i class="fas fa-search">
                           								</i>
                           							</div>
													</div>
											 </div>
                                			   </td>
                                			   <td>
                                			   		<input type="text" class="form-control" name='grossWeight'  id="grossWeight${loopCounter.count-1}" class="form-control"
                       								value="${listofcommodityVoData.grossWeight}" maxlength='17'  onblur='updateCommodityRecStatusNew(this);putMask_NumberEX(this, 14, 2);'
                       								 onclick="hideMask_Number(this);" >
                                			   </td>
                                			   <td>
                                			   		<div class="checkbox" >
				                                        <input type="checkbox" class="form-control" style="height:20px !important ;" name='specialCargo' value="Y" id="specialCargo${loopCounter.count-1}" onclick='lp_onChangeRateTypeNew(this);displaySpecialIns();updateSizeTypeRecStatusNewCheckBox(this);'  />
				                                        <label for="commoditySpecialCargo11" class="margin-left-zero styled-checkbox form-control"></label>
                                      				</div>
                                			   </td>
                                			   <td>
													<div class="input-group">
														 <select name="rateType" class="form-control" size="1" onchange="lp_onChangeRateType();updateCommodityRecStatusNew(this);">
															<c:forEach var="listValue" items="${feserv01.rateTypeValues}">
																<c:if test="${listValue.code == listofcommodityVoData.rateType}">
																<option selected="selected" value="${listValue.code}">${listValue.name}</option>
																</c:if>
																<c:if test="${listValue.code != listofcommodityVoData.rateType}">
																<option value="${listValue.code}">${listValue.name}</option>
																</c:if>
															</c:forEach>
											  			 </select>	
														 <div class="input-group-prepend cursor-pointer">
														   <div class="input-group-text" href="javascript:void(0)" name="btnRateTypeDetails"  onClick="openRateTypeLookUpNew();">
														   	<i class="fas fa-plus" ></i>
														   </div>
														 </div>
													</div>
                                			   </td>
                                			   <td>
													<c:if test="${loopCounter.count==1}">
														<input type=hidden name='recordStatus'  id="recordStatus${loopCounter.count-1}" value="${listofcommodityVoData.recordStatus}">
													</c:if>
													<c:if test="${loopCounter.count>1}" >
														<div class="checkbox">
														 	<input type="checkbox" class="margin-left-zero styled-checkbox form-control" name='isSelected' id="isSelected${loopCounter.count-1}" value="Y"   >
														 </div>
														<input type=hidden name='recordStatus'  id="recordStatus${loopCounter.count-1}" value="${listofcommodityVoData.recordStatus}" />
													</c:if>
													 	<input type=hidden name="rateTypeFlag" id="rateTypeFlag${loopCounter.count-1}" value="${listofcommodityVoData.rateTypeFlag }" />
                                			   </td>
                                			</tr>
                          			</c:forEach>
                          	     </tbody>		
                              </table>
                            </div>
                          </div>
                          <div class="row">
                            <div class="col-12">
                              <div class="btnSamll btn-danger btn-sm float-right" data-toggle="tooltip" href="javascript:void(0)" onClick="return deleteCommodityNew()"
                                data-placement="bottom" title="Delete Commodity"> 
                                <span class="fas fa-trash"></span>
                              </div>
                              <div class="btnSamll btn-success btn-sm mr-2 float-right" data-toggle="tooltip" href="javascript:void(0)" onClick="return addCommodityNew()"
                                data-placement="bottom" title="Add New Commodity">
                                <span class="fas fa-plus"></span>
                              </div>
                            </div>
                          </div>
                          <div class="equipment-details">
                            <div class="table-responsive">
                              <table class="table equipment-comodity-details  border-bottom" id="tableSI">
                                <tr scope="row border-bottom">
                                			   <td>
                                <c:forEach var="listcommodityVoData" items="${feserv01.commodityVoDataList}" varStatus="loopCounter">
	                                <textarea class="form-control" placeholder="Special Instructions (5 Lines maximum)"
	                                  name='specialInstruction' id="specialInstruction${loopCounter.count-1}" value="${listcommodityVoData.specialInstruction}"cols="50" rows="5"
                                	  onblur="updateCommodityRecStatusNewFortextArea(this);" onkeyup="maxlenghtTextArea(this, 400)" onclick="maxlenghtTextArea(this, 400)"></textarea>
                           	    </c:forEach>
                           	    			  </td>
                           	    </tr>
                           	  </table>	
                            </div>
                          </div>
                          <div class="row mt-3">
                            <div class="form-group col-12">
                              <label for="templateName"> <bean:message key="web_booking.EnterEditTemplateName"/></label>
                              <input type="text" class="form-control" name="templateName" id="templatename" maxlength='17' onblur="changeUpper(this)" value="${feserv01.templateName}" >
                            </div>
                          </div>
                          <div class="row">
                            <div class="form-group col-12">
                              <div class="checkbox">
                                <input type="checkbox" class="margin-left-zero styled-checkbox form-control"
                                 name="rclArrangementChkBox" value="${feserv01.rclArrangementChkBox }" />
                                <label for="eShippingInstruction"> <bean:message key="web_booking.WillSubmiteShippingInstruction"/></label>
                              </div>
                            </div>
                          </div>
                          <!-- Commodity Details Ends here -->
                          <hr class="mb-2">
                          <div class="row float-right">
                            <div class="col-12">
                              <div class="btn-group" role="group" aria-label="Basic example" id="showButton" style="display:inline;">
                                <div class="btn btn-secondary prev mr-2" onclick="routingPage('back');" >
                                  <span class="fas fa-arrow-left"></span>&nbsp;&nbsp;<bean:message key="web_booking.back" />  &nbsp;&nbsp;
                                </div>
                                <div class="btn btn-primary mr-2" href="javascript:void(0)" onClick="return uploadAttachment();">
                                   <bean:message key="web_booking.UploadDocument"/>&nbsp;&nbsp;<span class="fas fa-upload"></span>&nbsp;&nbsp;
                                </div>
                                <div class="btn btn-primary mr-2" href="javascript:void(0)" onClick="return saveBooking(MODE_SAVE_DRAFT);">
                                  <bean:message key="web_booking.Saveastemplate"/>&nbsp;&nbsp;<span class="fas fa-download"></span>&nbsp;&nbsp;
                                </div>
                                <div class="btn btn-success" href="javascript:void(0)" onClick="return saveBooking(MODE_SAVE_BOOKING);">
                                  &nbsp;&nbsp;
                                  <bean:message key="web_booking.SubmitBooking"/>&nbsp;&nbsp; <span class="fas fa-save"></span>
                                </div>
                              </div>
                              <div class="btn-group" role="group" aria-label="Basic example" id="hideButton" style="display:none;">
                                <div class="btn btn-secondary prev mr-2" >
                                  <span class="fas fa-arrow-left"></span>&nbsp;&nbsp;<bean:message key="web_booking.back"/>&nbsp;&nbsp;
                                </div>
                                <div class="btn btn-primary mr-2">
                                 <bean:message key="web_booking.UploadDocument"/> &nbsp;&nbsp;<span class="fas fa-upload"></span>&nbsp;&nbsp;
                                </div>
                                <div class="btn btn-primary mr-2">
                                  <bean:message key="web_booking.Saveastemplate"/>&nbsp;&nbsp;<span class="fas fa-download"></span>&nbsp;&nbsp;
                                </div>
                                <div class="btn btn-success">
                                  &nbsp;&nbsp;<bean:message key="web_booking.SubmitBooking"/>
                                  &nbsp;&nbsp; <span class="fas fa-save"></span>
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
    </div>
  </div>

  <!-- End of Page -->

           </form>
	 <!-- Start Of script Section -->
    <script src="<%=lstrCtxPath%>/js/libraries/jquery-3.5.1.js"></script>
  	<script src="<%=lstrCtxPath%>/js/libraries/popper.js"></script>
    <script src="<%=lstrCtxPath%>/js/libraries/bootstrap.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.27.0/moment.min.js"
      integrity="sha512-rmZcZsyhe0/MAjquhTgiUcb4d9knaFc7b5xAfju483gbEXTkeJRUMIPk6s3ySZMYUHEcjKbjLjyddGWMrNEvZg=="
      crossorigin="anonymous"></script>
    <script src="<%=lstrCtxPath%>/js/libraries/bootstrap-datetimepicker.js"></script>
    <script src="<%=lstrCtxPath%>/js/custom-chart.js"></script>
    <script src="<%=lstrCtxPath%>/js/booking-details.js"></script>
    
   
  
  
    <!-- End Of Script Section -->
    <script>
      $(document).ready(function () {        
        $('#booking-dedtails-progress').attr('data-percent', 30);
        updateCustomGraph('booking-dedtails-progress');
        $('.date-picker').datetimepicker({
          format: 'DD-MM-YYYY',
        });
 		$('[data-toggle="tooltip"]').tooltip();
      });
      
      function bookingPage(){
    	  $('#booking-dedtails-progress span').html("30%");    	  
      }
      

      function routingPage(){
    	  $('#booking-dedtails-progress span').html( "70%");
      }
      

      function commodityPage(){
    	  $('#booking-dedtails-progress span').html("90%");
      }
      
      $(document).ready(function() {
      
    
      });
    </script>
</body>

</html>