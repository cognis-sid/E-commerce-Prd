
<%@page import="java.util.Date"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page import="com.niit.control.common.GlobalConstants" %>
<%@page import="com.niit.control.web.action.BaseAction" %>
<%@ page import="com.niit.control.web.UserAccountBean" %>
<%@page import="com.niit.control.common.StringUtil" %>
<%@page import="java.util.List" %>
<%@page import="com.rclgroup.dolphin.rcl.web.eservice.actionform.EshippingInstructionUim" %>
<%@page import="com.rclgroup.dolphin.rcl.web.eservice.vo.EshippingCargoDescriptionMod" %>
<%@page import="com.rclgroup.dolphin.rcl.web.eservice.dao.EshippingInstructionDao" %>
<%@page import="com.niit.control.common.ComboVO" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
 String lstrCtxPath     = request.getContextPath();
 UserAccountBean code=new UserAccountBean();
 String country=code.getCountryCode();
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
      <meta http-equiv="Pragma" content="no-cache">
	<meta http-equiv="Expires" content="-1">
  <title>E - Shipping Instruction | Regional Container Lines</title>
  <jsp:include page="../../pages/common/cognis/commonInclude.jsp"></jsp:include>
  
<script type="text/javascript">
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');
  ga('create', 'UA-39255240-1', 'rclgroup.com');
  ga('send', 'pageview');
</script>
<script type="text/javascript" language="JavaScript" src="<%=lstrCtxPath%>/js/screen/EshippingInstruction.js?id=<%=new Date()%>" ></script>
<script src="<%=lstrCtxPath%>/js/si-Detils.js"></script>
<script type="text/javascript" language="JavaScript">
    var INPUT_CARGO_DESCRIPTION                     = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv006InputCargoDescription", pageContext)%>';
    var GET_BOOKING_NUMBER_TO_ESHIPPING_PAGE        = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv006GetData", pageContext)%>';
//    var BROWSE_CUSTOMER_DATA = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv006BrowseCustomerData", pageContext)%>';
    var BROWSE_CUSTOMER_DATA                        = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv010", pageContext)%>';
//    var BROWSE_BOOKING_NUMBER = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv006BrowseBookingNumber", pageContext)%>';
    var BROWSE_BOOKING_NUMBER                       = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv012", pageContext)%>';
//    var BROWSE_PACKGAE_KIND_DATA = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv006BrowsePackageKindData", pageContext)%>';
    var BROWSE_PACKGAE_KIND_DATA                    = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv011", pageContext)%>';
    var PRIVIEW_PDF_REPORT                          = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv006PreviewPDFReport", pageContext)%>';
    var SAVE_AS_DRAFT                               = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn006SaveAsDraft", pageContext)%>';
    var SUBMIT_ESI                                  = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn006SubmitEsi", pageContext)%>';
    var OPEN_ACKNOWLEDGEMENT                        = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv006Acknowledgement", pageContext)%>';
    //##02 BEGIN
    var BROWSE_COMMODITY                            = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv013", pageContext)%>';
//    var BROWSE_COMMODITY = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv006BrowseCommodity", pageContext)%>';
    var SET_COMMODITY_DATA                          = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn006SetCommodityData", pageContext)%>';
    var DEL_COMMODITY_DATA                          = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn006delCommodity", pageContext)%>';
    var ADD_COMMODITY_DATA                          = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn006addCommodity", pageContext)%>';
    //##02 END
    //##03 BEGIN
    var CHECK_DUPLICATE_CONTAINER_NO                = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv006checkDuplicateContainerNo", pageContext)%>';
    var VALIDATE_DATA_CHANGE                        = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn006validateData", pageContext)%>';
    var CLEAR_ESI_DATA		                        = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv006clearESIData", pageContext)%>';
    var VALIDATE_DATA_CONATINER_NO					= '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv006ValidateConatine", pageContext)%>';
    //##03 END        
    //@04 BEGIN
    var NEW_MODE                                    = '<%=EshippingInstructionDao.ESI_STATUS.NEW%>';
    var IN_PROGRESS_MODE                            = '<%=EshippingInstructionDao.ESI_STATUS.IN_PROGRESS%>';
    var SUBMITTED_MODE                              = '<%=EshippingInstructionDao.ESI_STATUS.SUBMITTED%>';
    var OPEN_SHIPPINGINQUIRY						= '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn010", pageContext)%>';
//    var NEW_MODE = "NEW";
//    var IN_PROGRESS_MODE = "IN PROGRESS";
//    var SUBMITTED_MODE = "ESI SUBMITTED";
    var SUBMITTED_AFTER_MODE                        = "SUBMITTED_AFTER_MODE";
    //@04 END

    var contextPath                                 = '<%=lstrCtxPath%>';

</script>     
</head>
<body >
		<form method="POST" action="/sexn006">
		
	 <input type="hidden" name="notFound" value="${feserv06.notFound}"  id="notFound"/>
    <input type="hidden" name="saveDraftIsSuccess" value="${feserv06.saveDraftIsSuccess}" id="saveDraftIsSuccess"/>
    <input type="hidden" name="submitIsSuccess" value="${feserv06.submitIsSuccess}" id="submitIsSuccess"/>
    <input type="hidden" name="textSeparate" value="${feserv06.textSeparate}" id="textSeparate"/>
    <input type="hidden" name="flag" value="${feserv06.flag}" id="flag"/>
    <input type="hidden" name="itemsDelete" value="${feserv06.itemsDelete}" id="itemsDelete"/>
    <input type="hidden" name="flagItemsDelete" value="${feserv06.flagItemsDelete}" id="flagItemsDelete"/>
    <input type="hidden" name="itemNo"  id="itemNo"/>
    <input type="hidden" name="fieldName"  id="fieldName"/>
    <input type="hidden" name="fieldAdd1"  id="fieldAdd1"/>
    <input type="hidden" name="fieldAdd2"  id="fieldAdd2"/>
    <input type="hidden" name="fieldAdd3"  id="fieldAdd3"/>
    <input type="hidden" name="fieldAdd4"  id="fieldAdd4"/>
    <input type="hidden" name="rowSelected"  id="rowSelected"/>
    <input type="hidden" name="shipperNameCountryCode"  id="shipperNameCountryCode"/>
    <input type="hidden" name="consigneeNameCountryCode"  id="consigneeNameCountryCode"/>
    <input type="hidden" name="notifyPartyNameCountryCode" id="notifyPartyNameCountryCode"/>
    <input type="hidden" name="blNo" value="${feserv06.blNo}" id="blNo"/>
    <input type="hidden" name="cocSoc" value="${feserv06.cocSoc}" id="cocSoc"/>
    <input type="hidden" name="shipperCode" value="${feserv06.shipperCode}" id="shipperCode"/>
    <input type="hidden" name="consigneeCode" value="${feserv06.consigneeCode}" id="consigneeCode"/>
    <input type="hidden" name="notifyPartyCode" value="${feserv06.notifyPartyCode}" id="notifyPartyCode"/>
    <input type="hidden" name="fsc" value="${feserv06.fsc}" id="fsc"/>
    <input type="hidden" name="openAcknowledgement" value="${feserv06.openAcknowledgement}" id="openAcknowledgement"/>
    <input type="hidden" name="emailAcknowledgment" value="${feserv06.emailAcknowledgment}" id="emailAcknowledgment"/>
    <input type="hidden" name="vendorTelephone" value="${feserv06.vendorTelephone}" id="vendorTelephone"/>
    <input type="hidden" name="vendorFax" value="${feserv06.vendorFax}" id="vendorFax"/>
    <input type="hidden" name="vendorEmail" value="${feserv06.vendorEmail}" id="vendorEmail"/>
    <input type="hidden" name="podCountry" value="${feserv06.podCountry}" id="podCountry"/>
    <input type="hidden" name="isDisabledSubmit" value="${feserv06.isDisabledSubmit}" id="isDisabledSubmit"/>
    <input type="hidden" name="esiErrMsg" value="${feserv06.esiErrMsg}" id="esiErrMsg"/>
    <input type="hidden" name="prevBookingNo" value="${feserv06.prevBookingNo}" id="prevBookingNo"/>
    <%-- @04 BEGIN --%>
    <input type="hidden" name="esiStatusCode" value="${feserv06.esiStatusCode}" id="esiStatusCode"/>
    <input type="hidden" name="esiStatusDesc" value="${feserv06.esiStatusDesc}" id="esiStatusDesc"/>
    <input type="hidden" name="prevEsiStatusCode" value="${feserv06.prevEsiStatusCode}" id="prevEsiStatusCode"/>
    <input type="hidden" name="prevEsiStatusDesc" value="${feserv06.prevEsiStatusDesc}" id="prevEsiStatusDesc"/>
    <input type="hidden" name="comSeqNoTemp" value="${feserv06.comSeqNoTemp}" id="comSeqNoTemp" />
    <%-- @04 END --%>
    <input type="hidden" name="msgFieldChanged" value="${feserv06.msgFieldChanged}" id="msgFieldChanged" />
    
    <%
        EshippingInstructionUim obj = (EshippingInstructionUim) request.getSession().getAttribute(EshippingInstructionUim.FORM_BUFF_ESHHIPING_INSTRUCTION);
        String isReadonly = "false";
        String esiStatusCode = null;
        if(null!=obj)
        {
            esiStatusCode = obj.getEsiStatusCode();
            isReadonly = (EshippingInstructionDao.ESI_STATUS.SUBMITTED.equals(esiStatusCode)? "true":"false");
        }
    %>
    
    <input type="hidden" id="isReadOnly" value="<%=isReadonly%>" />
  <!-- Start Of Nav Bar -->
  			<jsp:include page="../../pages/common/cognis/header.jsp"></jsp:include>
  <!-- End Of Nav Bar -->
  <div class="rcl-content" style="margin-top: 20px !important;">
    <nav aria-label="breadcrumb" class="mt-2">
      <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="#"><bean:message key="eShipping_Instructions.Home"/></a></li>
        <li class="breadcrumb-item active" aria-current="page"><bean:message key="eShipping_Instructions.eShipping_Instructions"/></li>
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
                      <div class="col-md-3 border-right">
                        <div class="row px-3">
                          <div class="col-9">
                            <h3 style="margin-top: 10px;"><strong><bean:message key="eShipping_Instructions.eShipping_Instructions"/></strong></h3>
                          </div>
                          <div class="col-3">
                            <div class="row justify-content-center">
                              <div class=" col">
                                <div class="custom-chart" id="eshipping-dedtails-progress" data-percent="0"
                                  data-size="60" data-line="6">
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
                            <a href="#" class="progressbar-menu progressbar-menu-active" onclick="fastPage()">
                              <strong><bean:message key="eShipping_Instructions.Shipment_Details"/></strong></a>

                          </h5>
                          <h5 class="mb-5">
                            <a href="#" class="progressbar-menu" onclick="secPage()">
                              <strong><bean:message key="eShipping_Instructions.Contact_Routing_Details"/></strong></h5></a>

                          <h5 class="mb-5">
                            <a href="#" class="progressbar-menu" onclick="thardPage()">
                              <strong><bean:message key="eShipping_Instructions.Equipment_Commodity_Details"/></strong></h5>
                          </a>

                        </div>

                      </div>
                      <div class="col-md-9 mb-4" style="min-height: 700px;">
                      
                      <jsp:include page="../../pages/common/cognis/alert.jsp"></jsp:include>
                      
                        <div class="card2 first-screen show ml-2" id="first-screen" >
                          <h5 class="card-title">
                            <strong><bean:message key="eShipping_Instructions.BL_Type_Details"/></strong>
                          </h5>
                          <hr />
                          <div class="form-row">
                            <div class="col-md-4">
                              <div class="form-check">
                                <input class="form-check-input" type="radio" name="choiceRad" id="choiceRad" value="1" checked >
                                <label class="form-check-label" for="blTypeDetails1">
                                  <bean:message key="eShipping_Instructions.One_Booking_One_BL"/>
                                </label>
                              </div>
                            </div>
                            <div class="form-group col-md-4">
                              <div class="form-check">
                                <input class="form-check-input" type="radio" name="choiceRad" id="choiceRad" value="2" disabled="true" >
                                <label class="form-check-label" for="blTypeDetails2">
                                   <bean:message key="eShipping_Instructions.One_Booking_Many_BLs"/>
                                </label>
                              </div>
                            </div>
                            <div class="form-group col-md-4">
                              <div class="form-check">
                                <input class="form-check-input" type="radio" name="choiceRad" id="choiceRad" value="3"  disabled="true" >
                                <label class="form-check-label" for="blTypeDetails3">
                                   <bean:message key="eShipping_Instructions.Many_Bookings_One_BL"/>
                                </label>
                              </div>
                            </div>
                          </div>
                          <div class="form-row">
                            <div class="form-group col-md-4">
                              <label for="inputQuatationNumber"><bean:message key="eShipping_Instructions.BL_Type"/></label>
                              <select name="blType" id="blType" size="1" class="form-control">
                                <c:forEach var="blTypelistValue" items="${feserv06.blTypeValues}">
                                	<c:if test="${blTypelistValue.code == feserv06.blType}">
                                		<option selected="selected" value="${blTypelistValue.code}">${blTypelistValue.name}</option>
                                	</c:if>
                                	<c:if test="${blTypelistValue.code != feserv06.blType}">
                                		<option  value="${blTypelistValue.code}">${blTypelistValue.name}</option>
                                	</c:if>
                                </c:forEach>
                              </select>
                            </div>
                          </div>

                          <h5 class="card-title">
                            <strong><bean:message key="eShipping_Instructions.Shipment_Details"/></strong>
                          </h5>
                          <hr />
                          <div class="form-row">
                            <div class="form-group  col-md-4">
                              <label for="inputBookingNumber"><bean:message key="eShipping_Instructions.Booking_Number"/></label><i class="fa fa-asterisk" aria-hidden="true" style="color:red;"></i>
                              <div class="input-group">
                                <input type="text" class="form-control" required="required" name="bookingNo" id="bookingNo" 
                                value="${feserv06.bookingNo}" maxlength='17'  onkeydown="gotoToSearchBookingEsi(this)"  >
                              </div>
                            </div>
                            <div class="form-group  col-md-4">
                              <label for="inputBLNumber"><bean:message key="eShipping_Instructions.BL_Number"/></label>
                              <input type="hidden" name="quotation" id="quotation" value="${feserv06.quotation }"/>
                              <input type="hidden" name="blNumber" id="blNumber" value="${feserv06.blNumber }"/>
                              <input type="text" class="form-control" readonly id="blNumber" name="blNumber" value="${feserv06.blNumber }" />
                            </div>
                            <div class="form-group  col-md-4">
                              <label for="inputESStatus"><bean:message key="eShipping_Instructions.EIS_Status"/></label>
                              <input type="text"  class="form-control" readonly id="esiStatusDesc" name="esiStatusDesc" value="${feserv06.esiStatusDesc}" />
                            </div>
                          </div>
                          <div class="form-row">
                            <div class="form-group  col-md-4">
                              <label for="inputSISubmittedBy"><bean:message key="eShipping_Instructions.SI_Submitted_By"/></label>
                              <input type="hidden" id="siSubmittedBy" name="siSubmittedBy" value="${feserv06.siSubmittedBy }"/>
                              <input type="text" readonly class="form-control" id="siSubmittedBy" name="siSubmittedBy" value="${feserv06.siSubmittedBy }" />
                            </div>
                            <div class="form-group  col-md-4">
                              <label for="inputContactPerson"><bean:message key="eShipping_Instructions.Contact_Person"/></label><i class="fa fa-asterisk" aria-hidden="true" style="color:red;"></i>
                            <input type="text" class="form-control" name="contact" required="required" id="contact" maxlength='25' value="${feserv06.contact }" onblur="changeUpper(this)" onchange="checkSpecialCharacter(this,'Contact Person')" />
                            </div>
                            <div class="form-group  col-md-4">
                              <label for="inputEmailAddress"><bean:message key="eShipping_Instructions.Email_Address"/></label>
                              <input type="hidden" class="form-control" name="toPicMail" id="toPicMail"  value="${feserv06.toPicMail }"/>
                              <input type="hidden" class="form-control" name="ccPicMail" id="ccPicMail"  value="${feserv06.ccPicMail }"/>
                              <input type="hidden" class="form-control" name="bccPicMail" id="bccPicMail"  value="${feserv06.bccPicMail }"/>
                              <input type="text" class="form-control" name="email" id="email"  value="${feserv06.email }" onchange="validateMultipleEmails(this,'Mail')"/>
                            </div>
                          </div>
                          <div class="form-row">
                            <div class="form-group  col-md-4">
                              <label for="input_Telephone"><bean:message key="eShipping_Instructions.Telephone"/></label>
                              <input type="number" class="form-control" name="telephone" id="telephone" maxlength='17'value="${feserv06.telephone }"  onblur="changeUpper(this)"  />
                            </div>
                            <div class="form-group  col-md-4">
                              <label for="input_Fax"><bean:message key="eShipping_Instructions.Fax"/></label>
                              <input type="number" class="form-control" name="fax" id="fax" value="${feserv06.fax }" maxlength='17'  onblur="changeUpper(this)"   />
                            </div>
                            <div class="form-group  col-md-4">
                              <label for="additionalMail"><bean:message key="eShipping_Instructions.Additional_Mail_Recipients"/></label>
                              <input type="text" class="form-control" name="additionalEmail" id="additionalEmail" value="${feserv06.additionalEmail }" maxlength='250' onchange="validateMultipleEmails(this,'Mail')"/>
                            </div>
                          </div>
                          <hr>
                          <div class="float-right">
                          	<div class="btn btn-secondary mr-2" onclick="bakeToShippingInqueryPage();">
                                  <span class="fas fa-arrow-up"></span>&nbsp;&nbsp;<bean:message key="eShipping_Instructions.Back_Inquery"/>&nbsp;&nbsp;
                            </div>
                            <div class="btn btn-primary next-button">
                              <span class="fas fa-arrow-right"></span>&nbsp;&nbsp;
                              <bean:message key="eShipping_Instructions.Continue"/>&nbsp;&nbsp;
                            </div>
                          </div>
                        </div>
                        <div class="card2 second-screen  ml-2" id="second-screen">
                          <h5 class="card-title"><strong><bean:message key="eShipping_Instructions.Contact_Details"/></strong></h5>
                          <hr />
                          <div class="form-row">
                            <div class="form-group col-md-4">
                              <label for="shipperNameAndAddress"><bean:message key="eShipping_Instructions.Shipper_Name_Address"/></label>
                              <input type="text" class="form-control" name="shipperName" value="${feserv06.shipperName }" id="shipperName" maxlength='70'  onkeydown="changeField('btnBrowseNotifyPartyName');"  onblur="changeUpper(this)"  />
                              <input type="text" class="form-control mt-2" name="shipperAddress1" id="shipperAddress1" maxlength='35' value="${feserv06.shipperAddress1 }" onkeydown="changeField('notifyPartyAddress1');" onblur="changeUpper(this)"  />
                              <input type="text" class="form-control mt-2" name="shipperAddress2" id="shipperAddress2" value="${feserv06.shipperAddress2 }" maxlength='35'  onkeydown="changeField('notifyPartyAddress2');" onblur="changeUpper(this)"    />
                              <input type="text" class="form-control mt-2" name="shipperAddress3" id="shipperAddress3" maxlength='35' value="${feserv06.shipperAddress3}" onkeydown="changeField('notifyPartyAddress3');"  onblur="changeUpper(this)"   />
                              <input type="text" class="form-control mt-2" name="shipperAddress4" id="shipperAddress4" maxlength='35' value="${feserv06.shipperAddress4 }" onkeydown="changeField('shipperName');" onblur="changeUpper(this)"   />
                            </div>
                            <div class="form-group col-md-4">
                              <label for="consigneeNameAndAddress"><bean:message key="eShipping_Instructions.Consignee_Name_Address"/></label>
                              <div class="input-group">
                                <input type="text" class="form-control" name="consigneeName" value="${feserv06.consigneeName }" required="required" id="consigneeName" maxlength='70' onkeydown="changeField('shipperAddress1');"  onblur="changeUpper(this)" style="background-color : #ffb3b3" />
                               <div class="input-group-prepend cursor-pointer">
                                  <div class="input-group-text" id="btnBrowseConsigneeName" href="javascript:void(0)"
                                onclick="openCustomerData(this,'consigneeName', 'consigneeAddress1', 'consigneeAddress2', 'consigneeAddress3', 'consigneeAddress4');"><i class="fas fa-search" data-toggle="tooltip"
                                      data-placement="bottom" title="Search" aria-hidden="true"></i></div>
                                </div> 
                              </div>
                              <input type="text" class="form-control mt-2" name="consigneeAddress1" id="consigneeAddress1" required="required" value="${feserv06.consigneeAddress1 }" maxlength='35' onkeydown="changeField('shipperAddress2');" onblur="changeUpper(this)"  style="background-color : #ffb3b3" />
                              <input type="text" class="form-control mt-2" name="consigneeAddress2" id="consigneeAddress2" maxlength='35' value="${feserv06.consigneeAddress2 }" onkeydown="changeField('shipperAddress3');" onblur="changeUpper(this)"  />
                              <input type="text" class="form-control mt-2" name="consigneeAddress3" id="consigneeAddress3" maxlength='35' value="${feserv06.consigneeAddress3 }" onkeydown="changeField('shipperAddress4');" onblur="changeUpper(this)"  />
                              <input type="text" class="form-control mt-2" name="consigneeAddress4" id="consigneeAddress4" maxlength='35' value="${feserv06.consigneeAddress4 }" onkeydown="changeField('btnBrowseConsigneeName');" onblur="changeUpper(this)"  />
                            </div>
                            <div class="form-group col-md-4">
                              <label for="notifyPartyNameAndAddress"><bean:message key="eShipping_Instructions.Notify_Party_Name_Address"/></label>
                              <div class="input-group">
                                <input type="text" class="form-control" name="notifyPartyName" required="required" id="notifyPartyName" value="${feserv06.notifyPartyName }" maxlength='70'   onkeydown="changeField('consigneeAddress1');" onblur="changeUpper(this)" style="background-color : #ffb3b3" />
                                 <div class="input-group-prepend cursor-pointer">
                                  <div class="input-group-text" id="btnBrowseNotifyPartyName" href="javascript:void(0)"
                                	  onclick="openCustomerData(this,'notifyPartyName', 'notifyPartyAddress1', 'notifyPartyAddress2', 'notifyPartyAddress3', 'notifyPartyAddress4');"><i class="fas fa-search" data-toggle="tooltip"
                                      data-placement="bottom" title="Search" aria-hidden="true"></i></div>
                                </div> 
                              </div>

                              <input type="text" class="form-control mt-2" name="notifyPartyAddress1" id="notifyPartyAddress1" value="${feserv06.notifyPartyAddress1 }" maxlength='35' onkeydown="changeField('consigneeAddress2');" required="required" onblur="changeUpper(this)"  style="background-color : #ffb3b3" />
                              <input type="text" class="form-control mt-2" name="notifyPartyAddress2" id="notifyPartyAddress2" maxlength='35' value="${feserv06.notifyPartyAddress2 }" onkeydown="changeField('consigneeAddress3');" onblur="changeUpper(this)"   />
                              <input type="text" class="form-control mt-2" name="notifyPartyAddress3" id="notifyPartyAddress3" maxlength='35' value="${feserv06.notifyPartyAddress3 }" onkeydown="changeField('consigneeAddress4');" onblur="changeUpper(this)"   />
                              <input type="text" class="form-control mt-2" name="notifyPartyAddress4" id="notifyPartyAddress4" maxlength='35' value="${feserv06.notifyPartyAddress4 }" onblur="changeUpper(this)"  />
                            </div>
                          </div>
                          <h5 class="card-title"><strong><bean:message key="eShipping_Instructions.Routing_Details"/></strong></h5>
                          <hr />
                          <div class="form-row">
                            <div class="form-group col-md-6">
                              <label for="input_Vessel"><bean:message key="eShipping_Instructions.Vessel"/></label>
                              <input type="hidden" name="vesselEdi" value="${feserv06.vesselEdi }"/> 
                              <input type="hidden" name="vesselNo" value="${feserv06.vesselNo }"/>
							  <c:choose>
									<c:when test="${feserv06.voyageNo == 'TBA'}">
  										 <input type="hidden" class="form-control" name="vessel" value="${feserv06.vessel }" readonly >
										 <input type="text" class="form-control" name="vesselTempVal" value="" readonly >
									</c:when>
							 		<c:otherwise>
  										 <input type="text" class="form-control" name="vessel" value="${feserv06.vessel }" readonly >
									</c:otherwise>
						      </c:choose>
                            </div>
                            <div class="form-group col-md-6">
                              <label for="input_VoyageNo"><bean:message key="eShipping_Instructions.Voyage_No"/></label>
                              <c:choose>
									<c:when test="${feserv06.voyageNo  == 'TBA'}">
  										 <input type="hidden" class="form-control" name="voyageNo" value="${feserv06.voyageNo }" readonly>
  										 <input type="text" class="form-control" name="voyageNoTempVal" value="${feserv06.voyageNo }" readonly>
									</c:when>
							 		<c:otherwise>
  										 <input type="text" class="form-control" name="voyageNo" value="${feserv06.voyageNo }" readonly>
									</c:otherwise>
						      </c:choose>
                            </div>
                          </div>
                          <div class="form-row">
                            <div class="form-group col-md-6">
                              <label for="input_ShippedOnBoardDate"><bean:message key="eShipping_Instructions.Shipped_On_Board_Date"/></label>
                              <input type="text" name="shippedOnBoardDate" id="shippedOnBoardDate" class="form-control" value="${feserv06.shippedOnBoardDate }" readonly/>
                            </div>
                            <div class="form-group col-md-6">
                              <label for="input_PlaceOfIssue"><bean:message key="eShipping_Instructions.Place_Of_Issue"/></label>
                              <input type="text" class="form-control" name="placeDateOfIssue" id="placeDateOfIssue" value="${feserv06.placeDateOfIssue }" maxlength='50' onblur="changeUpper(this)"  >
                            </div>
                          </div>
                          <div class="form-row">
                            <div class="form-group col-md-6">
                              <label for="input_PortOfLanding"><bean:message key="eShipping_Instructions.Port_Of_Landing"/></label>
                              <input type="hidden" name="fromTerminal" value="${feserv06.fromTerminal }"/>
                              <input type="hidden" name="polNo" value="${feserv06.polNo }"/>
                              <input type="text" class="form-control" name="pol" id="pol" maxlength="50" value="${feserv06.pol}" onblur="changeUpper(this)"  >
                            </div>
                            <div class="form-group col-md-6">
                              <label for="input_PortOfDischarge"><bean:message key="eShipping_Instructions.Port_Of_Discharge"/></label>
                              <input type="hidden" name="toTerminal" value="${feserv06.toTerminal }"/>
                              <input type="hidden" name="podNo" value="${feserv06.podNo }"/>
                              <input type="text" class="form-control" name="pod" id="pod" maxlength="50" value="${feserv06.pod}" onblur="changeUpper(this)"  >
                            </div>
                          </div>
                          <div class="form-row">
                            <div class="form-group col-md-6">
                              <label for="input_PlaceOfReceipt"><bean:message key="eShipping_Instructions.Place_Of_Receipt"/></label>
                              <input type="text" class="form-control" name="placeOfReceipt" id="placeOfReceipt" maxlength="50" value="${feserv06.placeOfReceipt }" onblur="chaneUpper(this)"  >
                            </div>
                            <div class="form-group col-md-6">
                              <label for="input_PlaceOfDelivery"><bean:message key="eShipping_Instructions.Place_Of_Delivery"/></label>
                              <input type="text" class="form-control" name="placeOfDelivery" id="placeOfDelivery" maxlength="50" value="${feserv06.placeOfDelivery }" onblur="changeUpper(this)"  >
                            </div>
                          </div>
                          <hr>
                          <div class="row float-right">
                         	<div class="btn btn-secondary prev mr-2" onclick="bakeToShippingInqueryPage();">
                                  <span class="fas fa-arrow-up"></span>&nbsp;&nbsp;<bean:message key="eShipping_Instructions.Back_Inquery"/>&nbsp;&nbsp;
                            </div>
                            <div class="btn btn-secondary prev mr-2">
                              <bean:message key="eShipping_Instructions.Back"/>&nbsp;&nbsp;<span class="fas fa-arrow-left"></span>&nbsp;&nbsp;
                            </div>
                            <div class="btn btn-primary next-button">
                              <span class="fas fa-arrow-right"></span>&nbsp;&nbsp;
                              <bean:message key="eShipping_Instructions.Continue"/>&nbsp;&nbsp;
                            </div>
                          </div>
                        </div>
                        <div class="card2 ml-2" id="thard-screen">
                          <!-- Commodity Details Starts here -->
                          <h5 class="card-title">
                            <strong><bean:message key="eShipping_Instructions.Commodity_Details"/></strong>
                          </h5>
                          <hr />
                          <div class="equipment-details">
                            <div class="table-responsive">
                              <table class="table equipment-comodity-details  border-bottom" style="table-layout: fixed;">
                                <colgroup>
                                  <col span="1" style="width: 3%;">
                                  <col span="1" style="width: 18%;">
                                  <col span="1" style="width: 14%;">
                                  <col span="1" style="width: 16%;">
                                  <col span="1" style="width: 10%;">
                                  <col span="1" style="width: 10%;">
                                  <col span="1" style="width: 13%;">
                                  <col span="1" style="width: 10%;">
                                  <col span="1" style="width: 6%;">
                                 <%--  <col span="1" style="width: 6%;"> --%>
                                </colgroup>
                                <thead>
                                  <tr class="bg-light-blue">
                                    <th scope="col-1">#</th>
                                    <th scope="col-2"><bean:message key="eShipping_Instructions.Commodity_Group"/></th>
                                    <th scope="col-1"><bean:message key="eShipping_Instructions.HS_Coded"/><i class="fa fa-asterisk" aria-hidden="true" style="color:red;"></th></i>
                                    <th scope="col-1"><bean:message key="eShipping_Instructions.Commodity_Description"/></th>
                                    <th scope="col-1"><bean:message key="eShipping_Instructions.Of_Packages"/></th>
                                    <th scope="col-1"><bean:message key="eShipping_Instructions.Package_Kind"/><i class="fa fa-asterisk" aria-hidden="true" style="color:red;" ></th></i>
                                    <th scope="col-2"><bean:message key="eShipping_Instructions.Gross_Weight"/></th>
                                    <th scope="col-1"><bean:message key="eShipping_Instructions.Gross_Cargo_Measurement_CBM"/></th>
                                    <th scope="col-1"><bean:message key="eShipping_Instructions.Marks_Desc"/></th>
                                   <%--  <th scope="col-1"><bean:message key="eShipping_Instructions.Select"/></th> --%>
                                  </tr>
                                </thead>
                                <tbody id="comm_result_dtl">
                                    <c:forEach var="commodityValue" items="${feserv06.commodityVoDataList}" varStatus="loopCounter">
                                    	
                                    	<tr scope="row border-bottom">
                                    		<th>${loopCounter.count}</th>	
                                    		<td class="tableColumnData">
					                            <input type="hidden" name="intCommGroupSeqNo" id="intCommGroupSeqNo" value="${commodityValue.intCommGroupSeqNo }"/>
					                            <input type="hidden" name="strCommGroupCode" id="strCommGroupCode" value="${commodityValue.strCommGroupCode }"/>
					                            <input type="hidden" name="recordStatus" id="recordStatus" value="${commodityValue.recordStatus }"/>
					                            <input type="hidden" name="strCommPackageKindCode" id="strCommPackageKindCode" value="${commodityValue.strCommPackageKindCode }"/>
					                            <textarea name="marksAndNumbers" id="marksAndNumbers" style="display : none">${commodityValue.marksAndNumbers }</textarea>
					                            <textarea name="description" id="description" style="display : none" >${commodityValue.description }</textarea>
					                            <input type="hidden" name="comBookingNo" id="comBookingNo" value="${commodityValue.comBookingNo }"/>
					                            <input type="hidden" name="strCommodityForMark" id="strCommodityForMark" value="${commodityValue.strCommodityForMark }"/>
					                            <input type="hidden" name="containerNoToCargo" id="containerNoToCargo" value="${commodityValue.containerNoToCargo }"/>
					                            <input type="hidden" name="comSeqNo" id="comSeqNo" value="${commodityValue.comSeqNo }"/>
					                            <input type="text" class="form-control form-control-sm" name="strCommGroup"  value="${commodityValue.strCommGroup }" onkeypress="return false;" onkeydown="return false;" readonly="true"/>
                       						</td>
                                    		<td>
                                    		<div class="input-group">
		                                        <input type="text" class="form-control form-control-sm" name="strCommCode"  id="strCommCode"
                                        			value="${commodityValue.strCommCode }" onkeypress="return false;" onkeydown="return false;"   readonly="true">
	                                       		<!-- <div class="input-group-prepend cursor-pointer">
	                                            <div class="input-group-text white" name="btnCommodityGroupLookup" href="javascript:void(0)"  style="background-color:#ced4da" >
	                                            <i class="fas fa-search" data-toggle="tooltip"
	                                             data-placement="bottom" title="Search"></i></div>
		                                        </div> -->
		                                        <div class="input-group-prepend cursor-pointer">
	                                            <div class="input-group-text white" name="btnCommodityGroupLookup" href="javascript:void(0)"  onclick="openCommodityGroupLookup(this, '0', '');">
	                                            <i class="fas fa-search" data-toggle="tooltip"
	                                             data-placement="bottom" title="Search"></i></div>
		                                        </div>
	                                      	</div>
                                    		</td>
                                    		<td>
		                                      <input type="text" class="form-control form-control-sm" name="strCommDesc"  id="strCommDesc"
                                              value="${commodityValue.strCommDesc }"   onkeypress="return false;"   onkeydown="return false;" readonly="true"  >
		                                    </td>
		                                    <td>
		                                      <input type="text" class="form-control form-control-sm" name="strCommOfPackages" id="strCommOfPackages"
                                       		  maxlength='6'  value="${commodityValue.strCommOfPackages }"  onkeypress="return false;"  onkeydown="return false;" readonly="true">
		                                    </td>
		                                    <td>
		                                      	<div class="input-group">
		                                        	<input type="text" class="form-control form-control-sm"
		                                        	  name="strCommPackageKindName" id="strCommPackageKindName"
                                       				  value="${commodityValue.strCommPackageKindName }" onkeypress="return false;" onkeydown="return false;" readonly="true" >
		                                        <div class="input-group-prepend cursor-pointer">
		                                          	  <div class="input-group-text white" name="btnBrowseCommPackageKind" href="javascript:void(0)" onclick="openPackageKind(this, 'strCommPackageKindCode', 'strCommPackageKindName', PACKAGE_KIND_TYPE_COMMODITY)">
		                                          	  <i class="fas fa-search" data-toggle="tooltip"
		                                              data-placement="bottom" title="Search"></i></div>
		                                        </div>
		                                      	</div>
		                                    </td>
		                                    <td>
		                                      <input type="text" class="form-control form-control-sm" name= "strCommWeight" 
		                                        id="strCommWeight"  value="${commodityValue.strCommWeight }"   onkeypress="return false;"
		                                        onkeydown="return false;" readonly="true">
                                    		</td>
                                    		<td>
		                                       <input type="text" class="form-control form-control-sm" name="strCommMeasurement" 
		                                        id="strCommMeasurement" maxlength='19'  onkeypress="return false;"  onkeydown="return false;"
		                                        value="${commodityValue.strCommMeasurement }" readonly="true">
                                    		</td>
                                    		<td class="text-center">
			                                      <div class="btn btn-secondary btn-sm" name="btnCargoDetails" href="javascript:void(0)" 
                            						onclick="openCargoDescription(this)" >  <span class="fas fa-plus"></span>
			                                      </div>
			                                </td>
			                                <td>
			                                <c:if test="${loopCounter.count>1}" >
			                                        <input type="checkbox" class="form-control"
			                                          name="isSelected" id="isSelected" value="Y" style="height:20px !important;" />
			                                        <label for="inputIsEmpty"></label>
			                                </c:if>
			                                </td>
                                    	</tr>
                                    	
                                    </c:forEach>
                                </tbody>
                              </table>
                            </div>
                          </div>
                            <div class="row">
                          	<!-- <div class="col-12">
                          	 	<div class="float-right">
                          	 	<label for="input_Fax"><Strong>Additional Hs code/commodity</Strong></label>
                              </div>
                          	</div> -->
                          </div> 
                          <div class="row">
                            <div class="col-12">
                              <!-- <div class="btn btn-danger btn-sm float-right" data-toggle="tooltip"
                                data-placement="bottom" title="Delete Equipment" id="deleteCommBtn"
                                href="javascript:void(0)" onClick="return deleteCommodityNew()">
                                <span class="fas fa-trash"></span>
                              </div> -->
                              <!-- <div class="btn btn-success btn-sm mr-2 float-right" data-toggle="tooltip"
                                data-placement="bottom" title="Add New Equipment" id="addCommBtn"
                                    href="javascript:void(0)" disabled="true" onClick="return addCommodityNew();">
                                <span class="fas fa-plus"></span>
                              </div> -->
                            </div>
                          </div>
                          <!-- Equipment Details Ends here -->
                          <hr>
                          <!-- Commodity Details Starts here -->
                          <h5 class="card-title">
                            <strong><bean:message key="eShipping_Instructions.Equipment_Details"/>
                              </strong>
                          </h5>
                          <hr />
                          <div class="equipment-details">
                            <div class="table-responsive">
                              <table class="table equipment-comodity-details  border-bottom" style="table-layout: fixed;">
                                <colgroup>
                                  <col span="1" style="width: 3%;">
                                  <col span="1" style="width: 15%;">
                                  <col span="1" style="width: 15%;">
                                  <col span="1" style="width: 15%;">
                                  <col span="1" style="width: 10%;">
                                  <col span="1" style="width: 13%;">
                                  <col span="1" style="width: 15%;">
                                  <col span="1" style="width: 14%;">
                                   
                                </colgroup>
                                <thead>
                                  <tr class="bg-light-blue">
                                    <th scope="col-1">#</th>
                                    <th scope="col-2"><bean:message key="eShipping_Instructions.Container_No"/></th>
                                    <th scope="col-1"><bean:message key="eShipping_Instructions.Container_Type"/></th>
                                    <th scope="col-1"><bean:message key="eShipping_Instructions.Carrier_Seal"/></th>
                                    <th scope="col-1"><bean:message key="eShipping_Instructions.Shipper_Seal"/></th>
                                    <th scope="col-1"><bean:message key="eShipping_Instructions.Of_Packages"/></th>
                                    <th scope="col-1"><bean:message key="eShipping_Instructions.Package_Kind"/></th>
                                    <th scope="col-1"><bean:message key="eShipping_Instructions.Gross_Cargo_Weight"/></th>
                                     
                                  </tr>
                                  <tr class="bg-light-blue border-top">
                                    <th scope="col-1"></th>
                                    <th scope="col-2"><bean:message key="eShipping_Instructions.Commodity"/></th>
                                    <th scope="col-1"><bean:message key="eShipping_Instructions.Laden_MT"/></th>
                                    <th scope="col-1"></th>
                                    <th scope="col-1"></th>
                                    <th scope="col-1"></th>
                                    <th scope="col-1"></th>
                                    <th scope="col-1"><bean:message key="eShipping_Instructions.Gross_Cargo_Measurement_CBM"/></th>
                                    <th scope="col-1" >
                                   		 <div style="display:none" class="checkbox mt-2 pl-2">
                                			<input type="checkbox" class="margin-left-zero styled-checkbox form-control" name="cbdelall"  onclick="selectAllData()"/>
                            			 </div>
                                    </th>
                                  </tr>
                                </thead>
                                <tbody>
                                  		<c:forEach var="cargoDetails"  items="${eshippingInstructionUim.cargoDescriptionDetails }" varStatus="loopCounter">
                                  			<tr scope="row border-bottom">
                                  				<td>
                                  					<strong>${cargoDetails.seqNo}</strong>
                                  				    <input type="hidden" name="seqNo" id="seqNo" value="${cargoDetails.seqNo}"/>
                           						    <input type="hidden" name="cntrSeq" id="cntrSeq" value="${cargoDetails.cntrSeq }"/>
                                  				</td>
                                  				<td>
                                  				
                                  					<input type="hidden" name="dbFlag" id="dbFlag" value="${cargoDetails.dbFlag}"/>
						                            <input type="hidden" name="statusFlag" id="statusFlag" value="${cargoDetails.statusFlag}"/>
						                            <input type="hidden" name="originalSeqNo" id="originalSeqNo" value="${cargoDetails.originalSeqNo}"/>
						                            <input type="hidden" name="fkEquipmentDetail" id="fkEquipmentDetail" value="${cargoDetails.fkEquipmentDetail}"/>
						                            <input type="hidden" name="fkBookingSupplier" id="fkBookingSupplier" value="${cargoDetails.fkBookingSupplier}"/>
						                            <input type="hidden" name="fkBookingSizeTypeDetail" id="fkBookingSizeTypeDetail" value="${cargoDetails.fkBookingSizeTypeDetail}"/>
						                            <input type="hidden" name="cargoDetails" id="cargoDetails" value="" />
						                            <input type="hidden" name="editFlag" id="editFlag" value="${cargoDetails.editFlag}" />
						                            <c:if test="${isReadOnly==false}">
						                            <input type="text" class="form-control" name="containerNo" id="containerNo" maxlength="11" 
				                                    value="${cargoDetails.containerNo }" onblur="changeUpper(this);" onfocus="editContainerNo(${loopCounter.count-1});"
				                                    onchange="onChangeContainerNo(${loopCounter.count-1});" readonly="${isReadOnly}" />	
						                            </c:if>
						                            <c:if test="${isReadOnly==true}">
						                            <input type="text" name="containerNo" id="containerNo" maxlength="11" 
                                   					value="${cargoDetails.containerNo }" readonly="${isReadOnly}" />
						                            </c:if>
						                            <c:if test="${isReadOnly==null}">
						                            	<input type="text" class="form-control" name="containerNo" id="containerNo" maxlength="11" 
				                                    	value="${cargoDetails.containerNo }" onblur="changeUpper(this);" onfocus="editContainerNo(${loopCounter.count-1});"
				                                    	onchange="onChangeContainerNo(${loopCounter.count-1});"   />
						                            </c:if>
						                            <select name='commodity' id="commodity" class="form-control"  onchange="onChangeEquipmentToCommodity(true);">
						                            <c:forEach var="commodityValue" items="${cargoDetails.commodityValues}">
						                            	 <c:if test="${cargoDetails.strEqptCommodity==commodityValue.code}">
						                            			<option selected="selected"  value="${commodityValue.code}">${commodityValue.name}</option>
						                         		 </c:if>
						                         		 <c:if test="${cargoDetails.strEqptCommodity!=commodityValue.code}">
						                         				<option   value="${commodityValue.code}">${commodityValue.name}</option>
						                         		 </c:if>	
						                            </c:forEach>
						                            </select>
                                  				</td>
                                  				<td>
                                  					<input type="hidden" name="containerEqSize" id="containerEqSize" value="${cargoDetails.containerEqSize}" />
                                  					<input type="hidden" name="containerEqType" id="containerEqType" value="${cargoDetails.containerEqType}" />
                                  					<input type="hidden" name="containerType" id="containerType" value="${cargoDetails.containerType}" />
                                  					<input type="text" class="form-control" value="${cargoDetails.containerType}" />
                                  					<input type="hidden" name="ladenMt" id="ladenMt" value="${cargoDetails.ladenMt}" /> 
                                  					<input type="text" class="form-control" value="${cargoDetails.ladenMt }" readonly>
                                  					<input type="hidden" name="ladenMt" id="ladenMt" value="${cargoDetails.ladenMt}">
                                  				</td>
                                  				<td>
                                  					<input type="text" class="form-control" name="carrierSeal" id="carrierSeal" value="${cargoDetails.carrierSeal }" maxlength='12' onblur="changeUpper(this)" />
                                  				</td>
                                  				<td>
                                  					<input type="text" class="form-control" name="shipperSeal" id="shipperSeal" value="${cargoDetails.shipperSeal }"maxlength='12'  onblur="changeUpper(this)" />
                                  				</td>
                                  				<td>
                                  				<div class="input-group">
                                  					<input type="text" name="ofPackages" class="form-control" id="ofPackages" maxlength='6'  
						                            onblur="maskWithOutDecimal(this, 6, 2)" value="${cargoDetails.ofPackages }"
						                            onchange="onChangeEquipmentToCommodity(false);"
						                            onclick="hideMask_Number(this);"  />
													<div class="input-group-prepend cursor-pointer">
														<div class="input-group-text" id="ofPackageCopyBtn${loopCounter.count-1}"
																name="ofPackageCopyBtn" data-placement="bottom"
																href="javascript: void(0)" 
																onClick="onClickCopyEquipmentField(EQUIPMENT_OF_PACKAGE, ${loopCounter.count-1})">
															<i class="fas fa-copy" data-toggle="tooltip"
																title="Copy"></i>
														</div>
													</div>
												</div>
                                  				</td>
                                  				<td>
                                  					<input type="hidden" name="packagesKindCode" id="packagesKindCode" value="${cargoDetails.packagesKindCode}"/>
                        				<div class="input-group">
												<input type="text" name="packagesKind"
													class="form-control" id="packagesKind"
													value="${cargoDetails.packagesKind }"
													readonly="true" /> <input type="hidden"
													name="packagesKindName" id="packagesKindName"
													value="${cargoDetails.packagesKind }" />
												<div class="input-group-prepend cursor-pointer">
													<div class="input-group-text white"
														name="btnBrowsePackageKind"
														href="javascript:void(0)"
														onclick="openPackageKind(this, 'packagesKindCode', 'packagesKind', PACKAGE_KIND_TYPE_EQUIPMENT)">
														<i class="fas fa-search" data-toggle="tooltip"
															data-placement="bottom" title="Search"></i>
													</div>
													<div class="input-group-text"
														id="packageKindCopyBtn${loopCounter.count-1}"
														name="packageKindCopyBtn"
														href="javascript: void(0)"
														onClick="onClickCopyEquipmentField(EQUIPMENT_PACKAGE_KIND, ${loopCounter.count-1});">
														<i class="fas fa-copy" data-toggle="tooltip"
															data-placement="bottom" title="Copy"></i>
													</div>
												</div>
											</div>
										</td>
                                  				<td>
                                  				<div class="input-group">
			                                        <input type="text" class="form-control" name="grossContainerWeight" id="grossContainerWeight" maxlength='19' 
			                                        value="${cargoDetails.grossContainerWeight }" onblur="putMask_NumberEX(this, 15, 3)" onchange="putMask_NumberEX(this, 15, 3);onChangeEquipmentToCommodity(false);"
			                                        onclick="hideMask_Number(this);" >
			                                          <div class="input-group-prepend cursor-pointer">
			                                          <div class="input-group-text" id="grossWeightCopyBtn${loopCounter.count-1}" name="grossWeightCopyBtn" href="javascript: void(0)" onClick="onClickCopyEquipmentField(EQUIPMENT_GROSS_WEIGHT, ${loopCounter.count-1});">
			                                          <i class="fas fa-copy" data-toggle="tooltip"
			                                              data-placement="bottom" title="Copy"></i></div>
			                                        </div> 
			                                     </div>
			                                     <div class="input-group mt-2">
			                                        <input type="text" class="form-control" name="grossCargoMeasurement" id="grossCargoMeasurement" value="${cargoDetails.grossCargoMeasurement }"
			                                          placeholder="0.000" onblur="putMask_NumberEX(this, 14, 4)"   onchange="onChangeEquipmentToCommodity(false);" onclick="hideMask_Number(this);">
			                                         <div class="input-group-prepend cursor-pointer">
			                                          <div class="input-group-text"
			                                          id="grossMeasurementCopyBtn${rowCargoDetailsId}" 
			                                          name="grossMeasurementCopyBtn"
			                                          href="javascript: void(0)"
			                                          onClick="onClickCopyEquipmentField(EQUIPMENT_GROSS_MEASUREMENT, ${loopCounter.count-1});"><i class="fas fa-copy" data-toggle="tooltip"
			                                              data-placement="bottom" title="Copy"></i></div>
                                        			</div>
                                        		</div>	
                                  				</td>
                                  				<td>
                                  					<div style="display:none" class="checkbox mt-2 pl-2">
                                						<input type="checkbox" class="margin-left-zero styled-checkbox form-control" name="cbdel" id="cbdel"  />
                            			 			</div>
                                  				</td>
                                  			</tr>
                                  		</c:forEach>
                                </tbody>
                              </table>
                            </div>
                          </div>
                          <div class="row">
                            <div class="col-12">
                              <div class="btn btn-danger btn-sm float-right" data-toggle="tooltip"
                                data-placement="bottom" title="Delete Equipment" 
                                id="addDisabledBtn"  style="display:none"href="javascript:void(0)">
                                <span class="fas fa-trash"></span>
                              </div>
                              <div class="btn btn-danger btn-sm float-right" data-toggle="tooltip"
                                data-placement="bottom" title="Delete Equipment" id="addBtn"  style="display:none"
                            	href="javascript:void(0)" onClick="return addItem()">
                                <span class="fas fa-trash"></span>
                              </div>
                              <div class="btn btn-success btn-sm mr-2 float-right" data-toggle="tooltip"
                                data-placement="bottom" title="Add New Equipment" id="delDisabledBtn"  style="display:none"
                            	href="javascript:void(0)">
                                <span class="fas fa-plus"></span>
                              </div>
                              <div class="btn btn-success btn-sm mr-2 float-right" data-toggle="tooltip"
                                data-placement="bottom" title="Add New Equipment" id="delBtn" class="m-btn mini red rnd" style="display:none"
                            	href="javascript:void(0)" onClick="return deleteItem()">
                                <span class="fas fa-plus"></span>
                              </div>
                            </div>
                          </div>
                          <!-- Equipment Details Ends here -->
                          <hr>
                          <div class="row mt-3">
                            <div class="form-group col-12">
                              <label for="noOfOriginalBL"><bean:message key="eShipping_Instructions.No_Of_Original_BL"/></label>
                              <input type="text" class="form-control" name="noOfOriginal" value="${feserv06.noOfOriginal }" id="noOfOriginal" maxlength='2'  onblur="maskWithOutDecimal(this, 2, 2)" >
                            </div>
                          </div>
                          <div class="row mt-3">
                            <div class="col-12">
                              <textarea class="form-control" name="remarks"  id="remarks"  cols="85" rows="7"   placeholder=<bean:message key="eShipping_Instructions.Remarks"/> rows="4" onkeyup="maxlenghtTextAreaBooking(this, 500)"
                                onclick="maxlenghtTextAreaBooking(this, 500)" >${feserv06.remarks }</textarea>
                            </div>
                          </div>
                          <!-- Commodity Details Ends here -->
                          <hr class="mb-2">
                          <div class="row">
                            <div class="col-12">
                              <div class="btn-group" role="group" aria-label="Basic example" >
                              	<div class="btn btn-secondary prev mr-2" onclick="bakeToShippingInqueryPage();">
                                  <span class="fas fa-arrow-up"></span>&nbsp;&nbsp;<bean:message key="eShipping_Instructions.Back_Inquery"/>&nbsp;&nbsp;
                                </div>
                                <div class="btn btn-secondary prev mr-2">
                                  <span class="fas fa-arrow-left"></span>&nbsp;&nbsp;<bean:message key="eShipping_Instructions.Back"/>&nbsp;&nbsp;
                                </div>
                               <button type="button" class="btn btn-primary mr-2" href="javascript:void(0)"  id="previewDisabledBtn" style="display: none">
                                  &nbsp;&nbsp;
                                  <bean:message key="eShipping_Instructions.Preview_Draft_SI"/>&nbsp;&nbsp; <span class="fas fa-save"></span>
                                </button>
                                <button type="button" class="btn btn-primary mr-2" href="javascript:void(0)"  onClick="return getPDF()" id="previewBtn" style="display: none" >
                                  &nbsp;&nbsp;
                                  <bean:message key="eShipping_Instructions.Preview_Draft_SI"/>&nbsp;&nbsp; <span class="fas fa-save"></span>
                                </button> 
                                <button type="button" class="btn btn-primary mr-2" id="saveDisabledBtn">
                                  &nbsp;&nbsp;
                                  <bean:message key="eShipping_Instructions.Save"/>&nbsp;&nbsp; <span class="fas fa-save"></span>
                                </button>
                                <button type="button" class="btn btn-primary mr-2" id="saveBtn" onClick="clearMsg(); saveDraftBtn();">
                                  &nbsp;&nbsp;
                                  <bean:message key="eShipping_Instructions.Save"/>&nbsp;&nbsp; <span class="fas fa-save"></span>
                                </button>
                                <button type="button" class="btn btn-success" id="submitDisabledBtn" onClick="clearMsg(); submitBtns();">
                                  &nbsp;&nbsp;
                                  <bean:message key="eShipping_Instructions.Submit"/>&nbsp;&nbsp; <span class="fas fa-check"></span>
                                </button>
                                <button type="button" class="btn btn-success" id="submitBtn" href="javascript:void(0)" onClick="clearMsg(); submitBtns();">
                                  &nbsp;&nbsp;
                                  <bean:message key="eShipping_Instructions.Submit"/>&nbsp;&nbsp; <span class="fas fa-check"></span>
                                </button>
                              </div>
                            </div>
                          </div>
                          <div class="row mt-2">
                            <%-- <div class="col-12 pl-0">
                              <button class="btn btn-info btn-block" data-toggle="modal" disable="true;"
                                data-target="#rateAndFreeTimeModalWindow">
                                <bean:message key="eShipping_Instructions.Rate_Free_time"/>
                              </button>
                            </div> --%>
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
  <!-- Modal -->
  <div class="modal fade" id="rateAndFreeTimeModalWindow" tabindex="-1" role="dialog"
    aria-labelledby="rateAndFreeTimeModalWindowLabel" aria-hidden="true">
    <div class="modal-dialog  modal-dialog-centered modal-xl" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="rateAndFreeTimeModalWindowLabel"><bean:message key="eShipping_Instructions.Rate"/></h5>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <div class="modal-body">
          ...
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-dismiss="modal"><bean:message key="eShipping_Instructions.Close"/></button>
          <button type="button" class="btn btn-primary"><bean:message key="eShipping_Instructions.Save_changes"/></button>
        </div>
      </div>
    </div>
  </div>
  <!-- End of Page -->
  <div id="cargoDescriptionDiv" style="display: none;" >
        <jsp:include page="../eshipping/EshippingCargoDescriptionPopup.jsp" />
  </div>
</form>
	
	
	
  <script>
    $(document).ready(function () {
      $('#eshipping-dedtails-progress').attr('data-percent', Math.floor(Math.random() * 100));
      updateCustomGraph('eshipping-dedtails-progress');
      $('.date-picker').datetimepicker({
        format: 'ddd DD/MM',
      });
      $('[data-toggle="tooltip"]').tooltip();
    });
    
    function blTypeDetls(){
    	 debugger;
    	 $("#alertId").hide();
   	  var index=2;
   	  var isValid=true;
   	  if($("#bookingNo").val()== ""){   
   		  
   		  //$("#bookingNo").parsley().validate(true);  
   		  //$("#"+ $("#bookingNo").attr("aria-describedby")+" li").html('Please specify Booking Number.');
   		  showBarMessageNew("Please specify Booking Number.");
   		  isValid =false;
   		  return isValid;
   		  index--;
   	  }
  	if($("#contact").val()== ""){   
  	  	debugger;
		  $("#contact").parsley().validate(true);  
		  $("#"+ $("#contact").attr("aria-describedby")+" li").html('Please specify Contact Person Name.');
		  showBarMessageNew("Please specify Contact Person Name.");
		  isValid =false;
		  return isValid;
		  index--;
  	}else{
  		if(!checkSpecialCharacter($("#contact")[0],'Contact Person')){
  		  isValid =false;
  		  index--;
  		  return isValid;
  		}
  	}
  	if($("#email").val().trim() != ""){   
  		if(!validateMultipleEmails($("#email")[0],'Email Address')){
    		  isValid =false;
    		  index--;
    		  return isValid;
    		}
  	}
  	if($("#additionalEmail").val().trim() != ""){   
  	  if(!validateMultipleEmails($("#additionalEmail")[0],'Additional Mail Recipients')){
		  isValid =false;
		  index--;
		}
  	}
  	
   	  return isValid;
     }	  
    function contactDtls(){
   	 debugger;
   	 $("#alertId").hide();
     	  var index=3;
     	  var isValid=true;
     	  if($("#consigneeName").val()== ""){   
     		  
     		  //$("#consigneeName").parsley().validate(true);  
     		  //$("#"+ $("#consigneeName").attr("aria-describedby")+" li").html('Please specify the consigneeName.');
     		  showBarMessageNew("Please specify the consigneeName.");
     		  isValid =false;
     		  index--;
     	  }
     	  	if($("#consigneeAddress1").val()== ""){   
     	  	debugger;
   		  //$("#consigneeAddress1").parsley().validate(true);  
   		  //$("#"+ $("#consigneeAddress1").attr("aria-describedby")+" li").html('Please specify Consignee Address1.');
   		  showBarMessageNew("Please specify Consignee Address1.");
   		  isValid =false;
   		  index--;
   	  } if($("#notifyPartyName").val()== ""){   
   		  debugger;
   		  //$("#notifyPartyName").parsley().validate(true);  
   		  //$("#"+ $("#notifyPartyName").attr("aria-describedby")+" li").html('Please specify NotifyParty Name.');
   		 showBarMessageNew("Please specify NotifyParty Name.");
   		  isValid =false;
   		  index--;
   	  }
   	if($("#notifyPartyAddress1").val()== ""){   
 		  debugger;
 		  //$("#notifyPartyAddress1").parsley().validate(true);  
 		  //$("#"+ $("#notifyPartyAddress1").attr("aria-describedby")+" li").html('Please specify NotifyParty Address1.');
 		  showBarMessageNew("Please specify NotifyParty Address1.");
 		  isValid =false;
 		  index--;
 	  }
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
</body>
</html>
