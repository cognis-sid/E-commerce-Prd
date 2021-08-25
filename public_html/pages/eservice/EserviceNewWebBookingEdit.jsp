<%@page import="java.util.Date"%>
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
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <meta http-equiv="Pragma" content="no-cache">
  <meta http-equiv="Expires" content="-1">
  <title>Web Booking New</title>
  <jsp:include page="../../pages/common/cognis/commonInclude.jsp"></jsp:include>
  
  <script type="text/javascript">
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');
  ga('create', 'UA-39255240-1', 'rclgroup.com');
  ga('send', 'pageview');
</script>

<style type="text/css">
.btnSamll {
  height: 30px !important;
  border-radius: 4px !important;
}
</style>
<script type="text/javascript" language="JavaScript" src="<%=lstrCtxPath%>/js/screen/EserviceNewWebBooking.js?id=1" ></script>
<script src="<%=lstrCtxPath%>/js/booking-details.js"></script>
<script type="text/javascript" language="JavaScript">
    
var SAVE_BOOKING
		= '../do/sexn001SaveBooking';
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
		= '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv019getData", pageContext)%>';

var DG_COMMODITY
		= '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv020", pageContext)%>';

var DG_COMMODITY_GET_DATA
		= '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv020getData", pageContext)%>';

var OOG_COMMODITY
		= '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv021", pageContext)%>';

var OOG_COMMODITY_GET_DATA
		= '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv021getData", pageContext)%>';

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
var GET_TEMLATE							 	
		= '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn002Temlate", pageContext)%>'; 
var ON_LOAD_INQUIRY 		
     = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn002", pageContext)%>';
var ON_EMPTY_PICK_UP_DEPO_DATA		
     = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn001EmptyPickUPDepo", pageContext)%>';
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
 		<input type=hidden  name="representedCompanyCheckValidation" id="representedCompanyCheckValidation" value="${feserv01.representedCompanyCheckValidation}"/>
		<input type=hidden  name="editSatus" id="editSatus" value="${feserv01.editSatus}"/>
		<input type="hidden" name="confirmRemarks" id="confirmRemarks"   value="${feserv01.confirmRemarks}"/>
<!-- hidden field end -->	
<!-- Start Of Nav Bar -->
  <jsp:include page="../../pages/common/cognis/header.jsp"></jsp:include>
  <!-- End Of Nav Bar -->
  <div class="rcl-content" >
     
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
                      <div class="col-md-3 border-right">
                        <div class="row px-3">
                          <div class="col-8">
                            <h3 style="margin-top: 10px;"><strong><bean:message key="web_booking_edit.Web_Booking"/></strong></h3>
                          </div>
                          <div class="col-4">
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
                            <li class="active step0" id="step0" onclick="fastPage()"></li>
                            <li class="step0" id="step1" onclick="secPage()"></li>
                            <li class="step0" id="step2" onclick="thardPage()"></li>
                          </ul>
                          <h5 class="mb-5">
                            <a href="#" class="progressbar-menu progressbar-menu-active" id="stepLine0" onclick="fastPage()">
                              <strong><bean:message key="web_booking_edit.e_Booking" /></strong></a>

                          </h5>
                          <h5 class="mb-5">
                            <a href="#" class="progressbar-menu" id="stepLine1" onclick="secPage()">
                              <strong><bean:message key="web_booking_edit.Routing_Schedule" /> </strong></h5></a>

                          <h5 class="mb-5">
                            <a href="#" class="progressbar-menu" id="stepLine2" onclick="thardPage()">
                              <strong><bean:message key="web_booking_edit.Equipment_Commodity"/></strong></h5>
                          </a>

                        </div>

                      </div>
                      <div class="col-md-9 mb-4" style="min-height: 700px;">
                      
                     
                      <jsp:include page="../../pages/common/cognis/alert.jsp"></jsp:include>
                      
                        <div class="card2 first-screen show ml-2" id="first-screen">
                          <h5 class="card-title">
                            <strong><i class="fas fa-ticket-alt" aria-hidden="true"></i>&nbsp;<bean:message key="web_booking_edit.Booking_Details"/></strong>
                          </h5>
                          <hr />
                          <div class="form-row">
                            <div class="form-group col-md-4">
                              	<label for="inputTemplate"><bean:message key="web_booking_edit.Template"/></label>
                             	<input type="hidden" class="form-control" name="templateFlag" id="templateFlag"  value="${feserv01.templateFlag}" />
                             	<select name="template" id="template" size="1" onchange="onTemplateChange()" disabled class="form-control">
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
                              <div class="input-group">
                                <input type="checkbox" class="checkbox" style="width:20px; height:20px !important ;"
                                  name="representCompChkBox" id="representCompChkBox" 
                                  	value="Y"  onclick="lp_manageRepresentCompChkBox(2);"/>&nbsp;
                                <label for="inputRepresentedCompany"><bean:message key="web_booking_edit.Represented_Company" /></label>
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
                              <label for="inputCOC"><bean:message key="web_booking_edit.COCSOC"/></label>
                              <select name="socCocUserFlag" id="socCocUserFlag" size="1"  class="form-control" onchange="onPolPodStatus();">
								    <c:if test="${feserv01.socCocUserFlag == 'Shipper own container'}">										
								 	  <option selected="selected" value="S"><bean:message key="web_booking_edit.shipperOwnContainer"/></option>
									  <option  value="C"><bean:message key="web_booking_edit.carrierOwnContainer"/></option>		   	  
								   </c:if>
								   <c:if test="${feserv01.socCocUserFlag == 'Carrier own container (RCL)'}">
								   		<option value="S"><bean:message key="web_booking_edit.shipperOwnContainer"/></option>
								   		<option selected="selected" value="C"><bean:message key="web_booking_edit.carrierOwnContainer"/></option>
								   </c:if>
					  		  </select>
                            </div>
                          </div>
                          <div class="form-row">
                            <div class="form-group col-md-4">
                              <label for="inputBookingNumber"><bean:message key="web_booking_edit.bookingNumber"/></label>
                              <input type="text" class="form-control" name="bookingNo" id="bookingNo" 
                                readonly value="${feserv01.bookingNo}" />
                            </div>
                            <div class="form-group col-md-4">
                              <label for="inputQuatationNumber"><bean:message key="web_booking_edit.quatationNumber"/></label>
                               <select name="quotationNumber" id="quotationNumber" size="1" class="form-control" >
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
                              <label for="inputStatus"><bean:message key="web_booking_edit.status"/></label>
                              <input type="text" class="form-control" name="status" readonly
                                value="${feserv01.status}" />
                            </div>
                          </div>

                          <div class="form-row">
                            <div class="form-group col-md-6">
                              <label for="inputPOLTeam"><bean:message key="web_booking_edit.POL_Team"/></label>
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
                              <label for="inputPODTeam"><bean:message key="web_booking_edit.POD_Team"/></label>
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
                              <label for="inputCustomerReference"><bean:message key="web_booking_edit.Customer_Reference" /></label>
			      <input type="hidden" name="companyName" value="${sessionScope.sUserAccountBean.companyName}">
                             <input type="text" class="form-control" name="customerReference" value="${feserv01.customerReference}" maxlength='17' onblur="changeUpper(this)" />
                            </div>
                            <div class="form-group  col-md-6">
                              <label for="inputEmailAddress"><bean:message key="web_booking_edit.Email_Address"/></label>
                              <input type="hidden" class="form-control" name="toPicMail" id="toPicMail"  value="${feserv01.toPicMail }"/>
                              <input type="hidden" class="form-control" name="ccPicMail" id="ccPicMail"  value="${feserv01.ccPicMail }"/>
                              <input type="hidden" class="form-control" name="bccPicMail" id="bccPicMail"  value="${feserv01.bccPicMail }"/>
                              <input type="text" class="form-control" name="email" value="${sessionScope.sUserAccountBean.mailId}" />	
                            </div>
                          </div>
                          <div class="form-row">
                            <div class="form-group  col-md-6">
                              <label for="inputTelephone"><bean:message key="web_booking_edit.Telephone"/></label>
                              <input type="number" class="form-control" name="telephone" id="telephone"  onchange="checkNumeric(this,'Phone No')"  value="${feserv01.telephone}"/>
                            </div>
                            <div class="form-group  col-md-6">
                              <label for="inputFax"><bean:message key="web_booking_edit.Fax"/></label>
                              <input type="text" class="form-control" name="fax" id="fax" maxlength='17' onchange="checkNumeric(this,'Fax No')" onblur="changeUpper(this)"
                                  value="${feserv01.fax}"  />
                            </div>
                          </div>
                          <div class="form-group">
                            <label for="inputContactPerson"><bean:message key="web_booking_edit.Contact_Person"/></label> <i class="fa fa-asterisk" aria-hidden="true" style="color:red;"></i> 
                             <input type="hidden" class="form-control" required="required" id="orgCode" name="orgCode" maxlength='25'  onblur="changeUpper(this)" 
                              value="${feserv01.orgCode}" />
                             <input type="text" class="form-control" required="required" id="contact" name="contact" maxlength='25'  onblur="changeUpper(this)" 
                              value="${feserv01.contact}" />
                          </div>
                          <div class="form-group">
                            <label for="inputAdditionalMailReciepients"><bean:message key="web_booking_edit.Additional_Mail_Recipients"/></label>
                            <textarea class="form-control" name="additionalMailRecipeints" id="additionalMailRecipeints" placeholder="use Space to separate Mail id."  onblur="validateEmail();" rows="4">${feserv01.additionalMailRecipeints}</textarea>
                          </div>
                          <hr>
                          <div class="float-right">
                          	<div class="btn btn-secondary" onclick="bakeToInqueryPage();" id="backInquiryBookingSt" >
                                  <span class="fas fa-arrow-up"></span>&nbsp;&nbsp;<bean:message key="web_booking.Web_Booking_Cancel" />  &nbsp;&nbsp;
                            </div>
                            <div class="btn btn-primary next-button" onclick="bookingPage();">
                              <span class="fas fa-arrow-right"></span>&nbsp;&nbsp;
                              <bean:message key="web_booking_edit.Continue"/> &nbsp;&nbsp;
                            </div>
                          </div>
                        </div>
                        <div class="card2 second-screen ml-2" id="second-screen">
                          <h5 class="card-title"><strong><i class="fas fa-calendar-check" aria-hidden="true"></i>&nbsp;
                            <bean:message key="web_booking_edit.Routing_Schedule"/></strong></h5>
                          <hr />
                          <div class="form-row">
                            <div class="form-group col-md-6">
                              <label for="inputOriginalCountry"><bean:message key="web_booking_edit.Original_Country"/></label>
			        				<c:forEach var="listValue" items="${feserv01.originCountryValues}" varStatus="loopCounter" >
										<c:if test="${listValue.code != '' }">
										<input type="hidden" name="originCountry" id="originCountry"   class="form-control" value="${listValue.code }" >		    
										<input type="text" name="originCountryName" id="originCountryName"   class="form-control" value="${listValue.name }" >
										</c:if>
									</c:forEach>
                            </div>
                            <div class="form-group col-md-6">
                              <label for="inputDestinationCountry"><bean:message key="web_booking_edit.Destination_Country"/></label>
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
                              <label for="inputPortOfLanding"><bean:message key="web_booking_edit.Port_of_Loading_POL"/></label>
									<c:forEach var="listValue" items="${feserv01.portOfLoadingValues}" varStatus="loopCounter">
									    <c:if test="${listValue.code != ''}">
									    	<input type="hidden" name="fromTerminal" id="fromTerminal"  value="${feserv01.fromTerminal }"  class="form-control">
										    <input type="hidden" name="portOfLoading" id="portOfLoading"  value="${listValue.code }"  class="form-control">
											<input type="hidden" name="polName" id="polName"  value="${listValue.name }"  class="form-control">
											<input type="text" name="portOfLoadingName" id="portOfLoadingName"  value="${listValue.code } - ${listValue.name } (${feserv01.fromTerminalDes })"  class="form-control" readonly>
										</c:if>
									</c:forEach>
                            </div>
                            <div class="form-group col-md-6">
                              <label for="inputPortOfDischarge"><bean:message key="web_booking_edit.Port_of_Discharge_POD"/></label>
									<c:forEach var="listValue" items="${feserv01.portOfDischargeValues}">
										<c:if test="${listValue.code != ''}">
										<input type="hidden"  name="to" id="to" value="${feserv01.to }" class="form-control"   >
											 <input type="hidden"  name="toLocation" id="toLocation" value="${feserv01.toLocation }" class="form-control"   >
											 <input type="hidden"  name="toTerminal" id="toTerminal" value="${feserv01.toTerminal }" class="form-control"   >
											 <input type="hidden"  name="portOfDischarge" id="portOfDischarge" value="${listValue.code }" class="form-control"   >
											 <input type="hidden"  name="podNmae" id=podNmae value="${listValue.name }" class="form-control" readonly>
											 <input type="text"  name="portOfDischargeName" id="portOfDischargeName" value="${listValue.code } - ${listValue.name } (${feserv01.toTerminalDes})" class="form-control" readonly>
										</c:if>
									</c:forEach>
					  		
                            </div>
                          </div>
                          <div class="form-row">
                            <div class="form-group col-md-6">
                              <label for="inputPlaceOfReciept"><bean:message key="web_booking_edit.Place_of_Receipt"/></label>
                              <select name="placeOfReceipt" id="placeOfReceipt" required="required" class="form-control" size="1" onchange="getEmptyPickUpDepoData(this);" >
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
                              <label for="inputPlaceOfDelivery"><bean:message key="web_booking_edit.Place_of_Delivery"/></label>
                              <select name="placeOfDelivery" id="placeOfDelivery" size="1"  class="form-control">
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
                            <label for="inputEmptyPickUpDepo"><bean:message key="web_booking_edit.Empty_Pickup_Depot"/></label>
                            <select name="emptyPickupDepot" id="emptyPickupDepot" size="1" class="form-control"  class="form-control">
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
                              <label for="etd"><bean:message key="web_booking_edit.Empty_Pickup_Date"/></label><i class="fa fa-asterisk" aria-hidden="true" style="color:red;"></i>
                              <div class="input-icons">
                                <i class="fas fa-calendar-alt icon"></i>
                                <input type="text" class="form-control  input-field date-picker" value="${feserv01.emptyPickupDate}" id="emptyPickupDate" required="required" name="emptyPickupDate">
                              </div>
                            </div>
                            <div class="form-group col-md-3">
                              <label for="etd"><bean:message key="web_booking_edit.Cargo_Availability_Date"/> </label><i class="fa fa-asterisk" aria-hidden="true" style="color:red;"></i> 
                              <div class="input-icons">
                                <i class="fas fa-calendar-alt icon"></i>
                                <input type="text" class="form-control  input-field date-picker" id="shipmentDate" value="${feserv01.shipmentDate}" required="required" name="shipmentDate">
                              </div>
                            </div>
                            <div class="form-group col-md-3">
                              <label for="etd"><bean:message key="web_booking_edit.Expected_Sailing_Date"/></label>
                              <div class="input-icons">
                                <i class="fas fa-calendar-alt icon"></i>
                                <input type="text" class="form-control  input-field date-picker" id="sailingDate" value="${feserv01.sailingDate}" name="sailingDate">
                              </div>
                            </div>
                            <div class="form-group col-md-3">
                              <label for="etd"><bean:message key="web_booking_edit.Desired_Arriaval_Date"/></label>
                              <div class="input-icons">
                                <i class="fas fa-calendar-alt icon"></i>
                                <input type="text" class="form-control  input-field date-picker" value="${ feserv01.desiredArrivalDate}" id="desiredArrivalDate" name="desiredArrivalDate">
                              </div>
                            </div>
                          </div>
                          <div class="form-group">
                            <label for="inputRoutingPreference"><bean:message key="web_booking_edit.Routing_Details"/></label>
                            <textarea name="routingPreference" class="form-control" id="routingPreference"  
                              rows="4" >${feserv01.routingPreference}</textarea>
                          </div> 
                          <hr>
                          <div class="row float-right">
                          	<div class="btn btn-secondary mr-2" onclick="bakeToInqueryPage();" id="backInquiryBookingNd" >
                                  <span class="fas fa-arrow-up"></span>&nbsp;&nbsp;<bean:message key="web_booking.Web_Booking_Cancel" />  &nbsp;&nbsp;
                            </div>
                            <div class="btn btn-secondary prev mr-2">
                              <bean:message key="web_booking_edit.Back"/>&nbsp;&nbsp;<span class="fas fa-arrow-left"></span>&nbsp;&nbsp;
                            </div>
                            <div class="btn btn-primary next-button" onclick="routingPage();">
                              <span class="fas fa-arrow-right"></span>&nbsp;&nbsp;
                              <bean:message key="web_booking_edit.Continue"/>&nbsp;&nbsp;
                            </div>
                          </div>
                        </div>
                        <div class="card2 thard-screen ml-2" id="thard-screen">
                          <!-- Equipment Details Starts here -->
                          <h5 class="card-title">
                            <strong><i class="fas fa-file-invoice" aria-hidden="true"></i>&nbsp;<bean:message key="web_booking_edit.Equipment_Details"/></strong>
                          </h5>
                          <hr/>

                         <div class="equipment-details">
                            <div class="table-responsive">
                              <table class="table equipment-comodity-details  border-bottom" id="search_result"  style="table-layout: fixed;">
                                <colgroup>
                                  <col span="1" style="width: 5%;">
                                  <col span="1" style="width: 20%;">
                                  <col span="1" style="width: 13%;">
                                  <col span="1" style="width: 13%;">
                                  <%-- <col span="1" style="width: 15%;"> --%>
                                  <col span="1" style="width: 7%;">
                                  <col span="1" style="width: 7%;">
                                  <col span="1" style="width: 10%;">
                                  <col span="1" style="width: 10%;">
                                  <col span="1" style="width: 10%;">
                                  <col span="1" style="width: 5%;">
                                </colgroup>
                                <thead>
                                  <tr class="bg-light-blue">
                                    <th scope="col-1">#</th>
                                    <th scope="col-2"><bean:message key="web_booking_edit.Type"/><i class="fa fa-asterisk" aria-hidden="true" style="color:red;"></i></th>
                                    <th scope="col-1"><bean:message key="web_booking_edit.Size"/></th>
                                    <th scope="col-1"><bean:message key="web_booking_edit.Cargo_Type"/></th>
				    			   <%--  <th scope="col-1"><bean:message key="web_booking.Special_Cargo" /></th> --%>
                                    <th scope="col-1"><bean:message key="web_booking_edit.Laden"/><i class="fa fa-asterisk" aria-hidden="true" style="color:red;"></i></th>
                                    <th scope="col-1"><bean:message key="web_booking_edit.Empty"/></th>
                                    <th scope="col-2"><bean:message key="web_booking_edit.cargoContainer"/><i class="fa fa-asterisk" aria-hidden="true" style="color:red;"></i></th>
                                    <th scope="col-1"><bean:message key="web_booking_edit.POL_Status"/></th>
                                    <th scope="col-1"><bean:message key="web_booking_edit.POD_Status"/></th>
                                    <th scope="col-1"><bean:message key="web_booking_edit.Select"/></th>
                                  </tr>
                                </thead>
                              <tbody id="result_dtl">
								<c:forEach var="listofequipment" items="${feserv01.equipmentVoDataList}"  varStatus="loopCounter">
                                 
                                  <tr scope="row border-bottom">
                                    <th>${loopCounter.count}</th>
                                    <%-- <input type=hidden name="type" value="${listofequipment.type}" id= "type${loopCounter.count-1}" />
                                    <td>
                                      <div class="input-group">
                                        <input type="text" class="form-control form-control-sm" name="typeDesc" id="typeDesc${loopCounter.count-1}"
                                         value="${listofequipment.typeDesc }"  readonly="true">
                                        <div class="input-group-prepend cursor-pointer">
                                          <div class="input-group-text" name="btnTypeLookup" href="javascript:void(0)" onclick='openEquipTypeLookup(this);' ><i class="fas fa-search"></i></div>
                                        </div>
                                      </div>
                                    </td> --%>
                                    <td>
                                    	<select name='type' id="type${loopCounter.count-1}" class="form-control"  onchange="updateSizeTypeRecStatusNew(this,${loopCounter.count-1});">
										<c:forEach var="listType" items="${feserv01.carogoTypeValues}">
											<c:if test="${listType.code == listofequipment.type }">
											<option selected="selected" value="${listType.code}">${listType.code} - ${listType.name}</option>
											</c:if>
											<c:if test="${listType.code != listofequipment.type }">
											<option value="${listType.code}">${listType.code} - ${listType.name}</option>
											</c:if>
										</c:forEach>
					  			     </select>
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
                                      <select name='cargoType' id="cargoType${loopCounter.count-1}" class="form-control"  onchange="updateSizeTypeRecStatusNew(this,${loopCounter.count-1});ChangeRateType(this,${loopCounter.count-1});">
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
                                   <%--  <td>
	                                  	<select name="specialCargo" class="form-control" size="1" onchange="updateSizeTypeRecStatusNew(this);" >
												<c:forEach var="listValue" items="${feserv01.specialCargoValues}">
													<c:if test="${listValue.code == ''}">
														<option selected="selected" value="${listValue.code}"> ${listValue.name}</option>
													</c:if>
													<c:if test="${listValue.code == listofcommodityVoData.specialCargoBox && listValue.code != ''}">
														<option selected="selected" value="${listValue.code}">${listValue.code} - ${listValue.name}</option>
													</c:if>
													<c:if test="${listValue.code != listofcommodityVoData.specialCargoBox  &&  listValue.code != ''}">
														<option value="${listValue.code}">${listValue.code} - ${listValue.name}</option>
													</c:if>
												</c:forEach>
								  		</select>	
                                    </td> --%>
                                    <td>
                                      <input type="text" class="form-control form-control-sm" value="${listofequipment.laden}"
                                       name='laden' id="laden${loopCounter.count-1}"  maxlength='4' onblur="maskWithOutDecimal(this, 4, 2);updateSizeTypeRecStatusNew(this,${loopCounter.count-1});" />
                                    </td>
                                    <td>
                                      <input type="text" class="form-control form-control-sm" value="${listofequipment.mt }"
                                       name='mt' id="mt${loopCounter.count-1}"  maxlength='4' disabled onblur="maskWithOutDecimal(this, 4, 2);updateSizeTypeRecStatusNew(this,${loopCounter.count-1});calculateGrossWaiht(this,${loopCounter.count-1});"" >
                                    </td>
                                    <td>
                                      <input type="text" class="form-control form-control-sm" value="${listofequipment.grossContainerWeight}"
                                       name='grossContainerWeight' id="grossContainerWeight${loopCounter.count-1}" maxlength='17' onblur="putMask_NumberEX(this, 14, 2);updateSizeTypeRecStatusNew(this,${loopCounter.count-1});calculateGrossWaiht(this,${loopCounter.count-1});" onclick="hideMask_Number(this);" />
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
                                id="cargoDescription"
		                        cols="50"
		                        rows="5"
		                        style="background-color : #ffb3b3"
		                        placeholder='<bean:message key="web_booking.Cargo_Description"/>'
		                        onkeyup="maxlenghtTextArea('cargoDescription', 500)"
		                        onclick="maxlenghtTextArea('cargoDescription', 500)">${feserv01.cargoDescription}</textarea>
                            </div>
                          </div>
                          <!-- Equipment Details Ends here -->
                          <hr>
                          <!-- Commodity Details Starts here -->
                          <h5 class="card-title">
                            <strong><i class="fas fa-file-invoice" aria-hidden="true"></i>&nbsp;<bean:message key="web_booking_edit.Commodity_Details"/></strong>
                          </h5>
                          <hr />
                          <div class="equipment-details">
                            <div class="table-responsive">
                              <table class="table equipment-comodity-details  border-bottom" id="comm_search_result" style="table-layout: fixed;">
                                <colgroup>
                                  <col span="1" style="width: 5%;">
                                  <col span="1" style="width: 5%;">
                                  <col span="1" style="width: 15%;">
                                  <col span="1" style="width: 25%;">
                                  <col span="1" style="width: 20%;">
                                  <col span="1" style="width: 25%;">
                                  <col span="1" style="width: 5%;">
                                </colgroup>
                                <thead>
                                  <tr class="bg-light-blue">
                                  	<th scope="col-1"><th>
                                    <th scope="col-1">#</th>
                                    <th scope="col-2"><bean:message key="web_booking_edit.Commodity_Group"/><i class="fa fa-asterisk" aria-hidden="true" style="color:red;"></i></th>
                                    <th scope="col-1"></th>
                                    <th scope="col-1"><bean:message key="web_booking_edit.Gross_Weight"/></th>
                                    
                                    <th scope="col-1"><bean:message key="web_booking_edit.Rate_Type"/></th>
                                    <th scope="col-1"><bean:message key="web_booking_edit.Select"/></th>
                                  </tr>
                                </thead>
                                 <tbody id="comm_result_dtl">
                                	<c:forEach var="listofcommodityVoData" items="${feserv01.commodityVoDataList}"  varStatus="loopCounter">
                                			<tr scope="row border-bottom">
                                			   <td>
	                                			   <div class="radio">
	                                			     <c:if test="${loopCounter.count-1 ==0 }"> 
	                                			   	 <input type="radio" class="form-control"  style="height: 20px !important"; name="radCommodity" id="radCommodity${loopCounter.count-1}" checked="true"  value="${loopCounter.count-1}"  onclick="displaySpecialIns()" > 
	                                			  	 </c:if>
	                                			  	 <c:if test="${loopCounter.count-1 !=0}">
	                                			  	 <input type="radio" class="form-control"  style="height: 20px !important"; name="radCommodity" id="radCommodity${loopCounter.count-1}"   value="${loopCounter.count-1}"  onclick="displaySpecialIns()" >
	                                			  	 </c:if>
	                                			   </div>
                                			   </td>
                                			   <td>${loopCounter.count}</td>
                                			   <td>
	                                			   <input type="hidden" name="posObjectCommod" id='posObjectCommod${loopCounter.count-1}' value="${loopCounter.count-1}" />
	                                			   <input type="hidden" name='seqNo' id="seqNo${loopCounter.count-1}" value="${listofcommodityVoData.seqNo }"  /> 
	                                        	   <input type="text" class="form-control" name='group' id="group${loopCounter.count-1}" value="${listofcommodityVoData.group}" 
	                           						 maxlength='1'  readonly="true"  onblur='updateCommodityRecStatusNew(this);changeUpper(this);'>
                                			   </td>
                                			   <td>
												 <div class="input-group">
														<input type="text" class="form-control" name='description' value="${listofcommodityVoData.description }"
														 	id="description${loopCounter.count-1}"  maxlength='10' onblur="changeUpper(this)" readonly="true">
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
													<div class="input-group">
														 <select name="rateType" class="form-control" size="1" onchange="lp_onChangeRateType();updateCommodityRecStatusNewRateType(this);checkRateTypeData(this);">
															<c:forEach var="listValue" items="${feserv01.rateTypeValues}">
																<c:if test="${listValue.code == 'N'}">
																<option selected="selected" value="${listValue.code}">${listValue.name}</option>
																</c:if>
																<c:if test="${listValue.code != 'N'}">
																<option value="${listValue.code}">${listValue.name}</option>
																</c:if>
															</c:forEach>
											  			 </select>	
														 <div class="input-group-prepend cursor-pointer">
														   <div class="input-group-text" href="" name="btnRateTypeDetails"  onClick="openRateTypeLookUpNew();" style="background-color:#ced4da">
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
														 <div>
														 	<input type="checkbox" class="checkbox" style="width:20px; height:37px !important ;" name='isSelected' id="isSelected${loopCounter.count-1}" value="Y"   >
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
                              <c:forEach var="listcommodityVoData" items="${feserv01.commodityVoDataList}" varStatus="loopCounter">
                                <tr scope="row border-bottom">
                                     <td>
	                              	<c:if test="${loopCounter.count-1 == 0}">
	                                <textarea class="form-control" placeholder='<bean:message key="web_booking.Special_Instructions"/>'
	                                  name='specialInstruction' id="specialInstruction${loopCounter.count-1}"  cols="50" rows="5"
                                	  onblur="updateCommodityRecStatusNewFortextArea(this);" onkeyup="maxlenghtTextArea(this, 400)" onclick="maxlenghtTextArea(this, 400)">${listcommodityVoData.specialInstruction}</textarea>
                           	   		</c:if>
                           	   		<c:if test="${loopCounter.count-1 != 0}">
                           	   		<textarea class="form-control" placeholder='<bean:message key="web_booking.Special_Instructions"/>'
	                                  name='specialInstruction' id="specialInstruction${loopCounter.count-1}"  cols="50" rows="5"  
                                	  onblur="updateCommodityRecStatusNewFortextArea(this);" onkeyup="maxlenghtTextArea(this, 400)" onclick="maxlenghtTextArea(this, 400)">${listcommodityVoData.specialInstruction}</textarea>
                           	   		</c:if>
                           	    
                           	    			  </td>
                           	    </tr>
                           	    </c:forEach>
                           	  </table>	
                            </div>
                          </div>
                          <div class="row mt-3">
                            <div class="form-group col-12">
                              <label for="templateName"><bean:message key="web_booking_edit.enterEditTemplateName"/></label>
                              <input type="text" class="form-control" name="templateName" id="templatename" maxlength='17' onblur="changeUpper(this)" value="${feserv01.templateName}" >
                            </div>
                          </div>
                          <div class="row">
                            <div class="form-group col-12">
                              <div class="input-group">
                                <input type="checkbox" class="checkbox" style="width:20px; height:25px !important;"
                                 name="rclArrangementChkBox" value="${feserv01.rclArrangementChkBox }" checked="true"/>
                                <label for="eShippingInstruction"><bean:message key="web_booking_edit.willSubmitEShippingInstruction"/></label>
                              </div>
                            </div>
                          </div>
                          <!-- Commodity Details Ends here -->
                          <hr class="mb-2">
                         <div id="showButton" style="display:inline;">
                          <div class="row">
                            <div class="col-12">
                              <div class="btn-group" role="group" aria-label="Basic example">
                                <button type="button" class="btn btn-secondary mr-2" onclick="bakeToInqueryPage();" id="backInquiryBooking" >
                                  <span class="fas fa-arrow-up"></span>&nbsp;&nbsp;<bean:message key="web_booking.Web_Booking_Cancel" />  &nbsp;&nbsp;
                                </button>
                            	<button type="button" class="btn btn-secondary prev mr-2" onclick="routingPage('back');" id="lastPageBackButton" >
                                  <span class="fas fa-arrow-left"></span>&nbsp;&nbsp;<bean:message key="web_booking.back" />  &nbsp;&nbsp;
                                </button>
                                <button type="button" class="btn btn-primary mr-2" href="" onClick="return uploadAttachment();">
                                   <bean:message key="web_booking.UploadDocument"/>&nbsp;&nbsp;<span class="fas fa-upload"></span>&nbsp;&nbsp;
                                </button>
                                <button type="button" class="btn btn-primary mr-2" href="" onClick="return saveBooking(MODE_SAVE_DRAFT);">
                                  <bean:message key="web_booking.Saveastemplate"/>&nbsp;&nbsp;<span class="fas fa-download"></span>&nbsp;&nbsp;
                                </button>
                                <button type="button" class="btn btn-success" href="" onClick="return confirmDialogOpen();">
                                  &nbsp;&nbsp;
                                  <bean:message key="web_booking.SubmitBooking"/>&nbsp;&nbsp; <span class="fas fa-save"></span>
                                </button>
                                </div>
                              </div>
                           </div> 
                          </div> 
                          <div id="hideButton" style="display:none;">
                          <div class="row">
                            <div class="col-12"> 
                              <div class="btn-group" role="group" aria-label="Basic example">
                                <button type="button" class="btn btn-secondary mr-2" onclick="bakeToInqueryPage();">
                                  <span class="fas fa-arrow-up"></span>&nbsp;&nbsp;<bean:message key="web_booking.Web_Booking_Cancel" />  &nbsp;&nbsp;
                                </button>
                            	<button type="button" class="btn btn-secondary prev mr-2" onclick="routingPage('back');">
                                  <span class="fas fa-arrow-left"></span>&nbsp;&nbsp;<bean:message key="web_booking.back" />  &nbsp;&nbsp;
                                </button>
                                <button type="button" class="btn btn-primary mr-2">
                                 <bean:message key="web_booking.UploadDocument"/> &nbsp;&nbsp;<span class="fas fa-upload"></span>&nbsp;&nbsp;
                                </button>
                                <button type="button" class="btn btn-primary mr-2">
                                  <bean:message key="web_booking.Saveastemplate"/>&nbsp;&nbsp;<span class="fas fa-download"></span>&nbsp;&nbsp;
                                </button>
                                <button type="button" class="btn btn-success">
                                  &nbsp;&nbsp;<bean:message key="web_booking.SubmitBooking"/>
                                  &nbsp;&nbsp; <span class="fas fa-save"></span>
                                </button>
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
    <script>
      $(document).ready(function () {
      
       $('textarea[name="additionalMailRecipeints"]').keydown(function (event){
			 debugger;
		        if(event.keyCode==32 || event.keyCode==13){
					$('textarea[name="additionalMailRecipeints"]').val($('textarea[name="additionalMailRecipeints"]').val()+",");
					return false;
			}
		});
 	    
        $('#booking-dedtails-progress').attr('data-percent', 30);
        updateCustomGraph('booking-dedtails-progress');
        $('.date-picker').datetimepicker({
          format: 'DD-MM-YYYY',
        });
 		$('[data-toggle="tooltip"]').tooltip();
 		$("#lastPageBackButton").removeAttr('style');
 		
 		
 		
      });
      
      function bookingPage(){
    	  $('#booking-dedtails-progress span').html("30%");
    	  $("#lastPageBackButton").removeAttr('style');
  		  $("#backInquiryBooking").removeAttr('style');
      }
      
      function bookingDtl(){
     	 debugger;
     	 $("#alertId").hide();
    	  var index=1;
    	  var isValid=true;
    	  if($("#contact").val()== ""){   
    		  
    		  $("#contact").parsley().validate(true);  
    		  $("#"+ $("#contact").attr("aria-describedby")+" li").html('Please specify Contact Person Name.');
    		  isValid =false;
    		  index--;
    	  }
    	  return isValid;
      }	  
      function routingDtls(){
     	 debugger;
     	 $("#alertId").hide();
       	  var index=3;
       	  var isValid=true;
       	  if($("#placeOfReceipt").val()== ""){   
       		  
       		  $("#placeOfReceipt").parsley().validate(true);  
       		  $("#"+ $("#placeOfReceipt").attr("aria-describedby")+" li").html('Please specify Place Of Receipt.');
       		  isValid =false;
       		  index--;
       	  }
       	  	if($("#emptyPickupDate").val()== ""){   
       	  	debugger;
     		  $("#emptyPickupDate").parsley().validate(true);  
     		  $("#"+ $("#emptyPickupDate").attr("aria-describedby")+" li").html('Please specify Empty Pickup Date.');
     		  isValid =false;
     		  index--;
     	  } if($("#shipmentDate").val()== ""){   
     		  debugger;
     		  $("#shipmentDate").parsley().validate(true);  
     		  $("#"+ $("#shipmentDate").attr("aria-describedby")+" li").html('Please specify Shipment Date.');
     		  isValid =false;
     		  index--;
     	  }
       	  return isValid;
      }

      function routingPage(){
    	  $('#booking-dedtails-progress span').html( "70%");
    	  $("#lastPageBackButton").removeAttr('style');
  		  $("#backInquiryBooking").removeAttr('style');
      }
      

      function commodityPage(){
    	  $('#booking-dedtails-progress span').html("90%");
      }
      
      $(document).ready(function() {
    	  MODE_SAVE_BOOKING="S"
      /*
      $("form").validate({
			rules : {
			 
				telephone : {
					required : true,
					number : true,
					maxlength : 17
				},
				fax : {
					required : false,
					number : true,
					maxlength : 17
				}
			}
		});*/
      });
    
      function fastPage(){
     	   $("#step0").removeClass();
     	   $("#step0").addClass("active step0");
     	   $("#step1").removeClass();
     	   $("#step1").addClass("step0");
     	   $("#step2").removeClass();
     	   $("#step2").addClass("step0");
     	   
     	   $("#stepLine0").removeClass();
  	  	   $("#stepLine0").addClass("progressbar-menu progressbar-menu-active");
  	  	   $("#stepLine1").removeClass();
  	  	   $("#stepLine1").addClass("progressbar-menu");
  	  	   $("#stepLine2").removeClass();
  	  	   $("#stepLine2").addClass("progressbar-menu");     	   
       	
    	   $("#first-screen").removeClass();
    	   $("#first-screen").addClass("card2 first-screen show ml-2");
    	   $("#second-screen").removeClass();
    	   $("#second-screen").addClass("card2 first-screen ml-2");
    	   $("#thard-screen").removeClass();
    	   $("#thard-screen").addClass("card2 first-screen ml-2");
    	   
    	   $(".prev").css({ display: "none" }); 
    	   
      }
   	  function secPage(){
   		   $("#step0").removeClass();
   	  	   $("#step0").addClass("step0");
   	  	   $("#step1").removeClass();
   	  	   $("#step1").addClass("active step0");
   	  	   $("#step2").removeClass();
   	  	   $("#step2").addClass("step0");
   	  	   $("#stepLine0").removeClass();
	  	   $("#stepLine0").addClass("progressbar-menu");
	  	   $("#stepLine1").removeClass();
	  	   $("#stepLine1").addClass("progressbar-menu progressbar-menu-active");
	  	   $("#stepLine2").removeClass();
	  	   $("#stepLine2").addClass("progressbar-menu");  
   	    	
   		   $("#first-screen").removeClass();
   	   	   $("#first-screen").addClass("card2 first-screen ml-2");
   	   	   $("#second-screen").removeClass();
   	   	   $("#second-screen").addClass("card2 first-screen show ml-2");
   	   	   $("#thard-screen").removeClass();
   	   	   $("#thard-screen").addClass("card2 first-screen ml-2");
   	   	   
   	   	   $(".prev").css({ display: "block" });
   	  }
   	  function thardPage(){
   		   $("#step0").removeClass();
   	  	   $("#step0").addClass("step0");
   	  	   $("#step1").removeClass();
   	  	   $("#step1").addClass("step0");
   	  	   $("#step2").removeClass();
   	  	   $("#step2").addClass("active step0");
   	  	   
   	  	   $("#stepLine0").removeClass();
	  	   $("#stepLine0").addClass("progressbar-menu");
	  	   $("#stepLine1").removeClass();
	  	   $("#stepLine1").addClass("progressbar-menu");
	  	   $("#stepLine2").removeClass();
	  	   $("#stepLine2").addClass("progressbar-menu progressbar-menu-active");  
   		  
   		   $("#first-screen").removeClass();
   	   	   $("#first-screen").addClass("card2 first-screen ml-2");
   	   	   $("#second-screen").removeClass();
   	   	   $("#second-screen").addClass("card2 first-screen ml-2");
   	   	   $("#thard-screen").removeClass();
   	   	   $("#thard-screen").addClass("card2 first-screen show ml-2");
   	   	   
   	   	   $(".prev").css({ display: "block" });
   	   	   
   	  }
    </script>
       
</body>

 <script>
  $( function() {
	  
	  $( "#confirmDialog" ).dialog({
		  autoOpen: false,
	      height: "auto",
	      width: "500px",
	      modal: true
	       
	    });
	  
	  $( "#confirmDialog" ).dialog("close");
	  $( "#confirmDialog" ).parent().css('position', 'fixed');
	  $( "#confirmDialog" ).parent().css('top', '40%');
	  $( "#confirmDialog" ).parent().css('left', '40%');
  } );
  
  function confirmDialogOpen(){
	  if(validation()){
		  $( "#confirmDialog" ).dialog("open");
	  }
  }
  function validateSumit(){
	  if($("#dialogConfirmRemarks").val()== ""){  
		  
		  $("#dialogConfirmRemarks").parsley().validate(true);
		  $("#"+ $("#dialogConfirmRemarks").attr("aria-describedby")+" li").html('Please enter summary of changes.');
		  return false;
		  
	  }
	 $("#confirmRemarks").val( $("#dialogConfirmRemarks").val());
	  return true;
  }
  
  function closeDialog(){
	  $( "#confirmDialog" ).dialog("close");
  }
  

  function saveDialog(){
	  
   	if(validateSumit()){
    	saveBooking(MODE_SAVE_BOOKING);
    	$( "#confirmDialog" ).dialog("close");
   	}

  }
  </script>
  

<style>
	 
	.ui-dialog-buttonset{
	float:right;
	}
	
	.ui-dialog-titlebar-close{
		display: none;
	}
</style>
</html>

<div id="confirmDialog"  title="&nbsp;&nbsp;&nbsp;Remarks&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;">
<div style="margin:10px;">
  <p>Please enter summary of changes which you have done.</p>
 <textarea rows="3" cols="50" id="dialogConfirmRemarks" required></textarea>
 </div>
 <div style="float: right; margin: 15px;" >
                              <div class="btn-group" role="group" aria-label="Basic example">
                                <button type="button" class="btn btn-secondary mr-2" onclick="closeDialog();" id="backInquiryBooking" >
                                  <span class="fas fa-arrow-up"></span>&nbsp;&nbsp;<bean:message key="web_booking.Web_Booking_Cancel" />  &nbsp;&nbsp;
                                </button>
                            	 
                                <button type="button" class="btn btn-success" href="" onClick="return saveDialog();">
                                  &nbsp;&nbsp;
                                  <bean:message key="web_booking.SubmitBooking"/>&nbsp;&nbsp; <span class="fas fa-save"></span>
                                </button>
                                </div>
     </div>
</div>