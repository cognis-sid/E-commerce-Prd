<%--
-------------------------------------------------------------------------------------------------------------
EshippingInstruction.jsp
-------------------------------------------------------------------------------------------------------------
Copyright RCL Public Co., Ltd. 2007
-------------------------------------------------------------------------------------------------------------  
Author anurak Thanapradit 05/07/13
- Change Log ------------------------------------------------------------------------------------------------
## DD/MM/YY      -User-          -TaskRef-         -ShortDescription-
## 01/08/2013                       01                add commodity in equipment detail
## 22/08/2013    YOSSUN1            02                Add commodity detail.
## 20/09/2013    YOSSUN1            03                add check duplicate container no.
## 12/12/2013    YOSSUN1            04                change parameter esiStatus
## 02/01/2014    YOSSUN1            05                Get rid of limit max lenght of Cargo Descriptions / Marks & No. & Printing Details.
## 20/01/2014    YOSSUN1            06                Add CR.
## 10/09/2014    PRATYA             07                PD_CR_20140820_ESV [Description and Mark_No for ecah commodity]
## 18/10/2019	 Sarawut			08				  Add hidden column Vessel No, Pol No, Pod no
-------------------------------------------------------------------------------------------------------------
--%>
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
<%
 String lstrCtxPath     = request.getContextPath();
%>
<head>
<script type="text/javascript">
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');
  ga('create', 'UA-39255240-1', 'rclgroup.com');
  ga('send', 'pageview');
</script>
<script type="text/javascript" language="JavaScript" src="<%=lstrCtxPath%>/js/screen/EshippingInstruction.js?id=<%=new Date() %>" ></script>
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
    var SAVE_AS_DRAFT                               = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv006SaveAsDraft", pageContext)%>';
    var SUBMIT_ESI                                  = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv006SubmitEsi", pageContext)%>';
    var OPEN_ACKNOWLEDGEMENT                        = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv006Acknowledgement", pageContext)%>';
    //##02 BEGIN
    var BROWSE_COMMODITY                            = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv013", pageContext)%>';
//    var BROWSE_COMMODITY = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv006BrowseCommodity", pageContext)%>';
    var SET_COMMODITY_DATA                          = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv006SetCommodityData", pageContext)%>';
    var DEL_COMMODITY_DATA                          = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv006delCommodity", pageContext)%>';
    var ADD_COMMODITY_DATA                          = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv006addCommodity", pageContext)%>';
    //##02 END
    //##03 BEGIN
    var CHECK_DUPLICATE_CONTAINER_NO                = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv006checkDuplicateContainerNo", pageContext)%>';
    var VALIDATE_DATA_CHANGE                        = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv006validateData", pageContext)%>';
    var CLEAR_ESI_DATA		                        = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv006clearESIData", pageContext)%>';
    //##03 END        
    //@04 BEGIN
    var NEW_MODE                                    = '<%=EshippingInstructionDao.ESI_STATUS.NEW%>';
    var IN_PROGRESS_MODE                            = '<%=EshippingInstructionDao.ESI_STATUS.IN_PROGRESS%>';
    var SUBMITTED_MODE                              = '<%=EshippingInstructionDao.ESI_STATUS.SUBMITTED%>';
//    var NEW_MODE = "NEW";
//    var IN_PROGRESS_MODE = "IN PROGRESS";
//    var SUBMITTED_MODE = "ESI SUBMITTED";
    var SUBMITTED_AFTER_MODE                        = "SUBMITTED_AFTER_MODE";
    //@04 END

    var contextPath                                 = '<%=lstrCtxPath%>';

</script>     
</head>

<body>    
<html:form method="POST" action="/serv006">
    <html:hidden name="feserv06" property="notFound" styleId="notFound"/>
    <html:hidden name="feserv06" property="saveDraftIsSuccess" styleId="saveDraftIsSuccess"/>
    <html:hidden name="feserv06" property="submitIsSuccess" styleId="submitIsSuccess"/>
    <html:hidden property="textSeparate" styleId="textSeparate"/>
    <html:hidden property="flag" styleId="flag"/>
    <html:hidden property="itemsDelete" styleId="itemsDelete"/>
    <html:hidden property="flagItemsDelete" styleId="flagItemsDelete"/>
    <input type="hidden" name="itemNo" id="itemNo"/>
    <input type="hidden" name="fieldName" id="fieldName"/>
    <input type="hidden" name="fieldAdd1" id="fieldAdd1"/>
    <input type="hidden" name="fieldAdd2" id="fieldAdd2"/>
    <input type="hidden" name="fieldAdd3" id="fieldAdd3"/>
    <input type="hidden" name="fieldAdd4" id="fieldAdd4"/>
    <input type="hidden" name="rowSelected" id="rowSelected"/>
    <input type="hidden" name="shipperNameCountryCode" id="shipperNameCountryCode"/>
    <input type="hidden" name="consigneeNameCountryCode" id="consigneeNameCountryCode"/>
    <input type="hidden" name="notifyPartyNameCountryCode" id="notifyPartyNameCountryCode"/>
    <html:hidden name="feserv06" property="blNo" styleId="blNo"/>
    <html:hidden name="feserv06" property="cocSoc" styleId="cocSoc"/>
    <html:hidden name="feserv06" property="shipperCode" styleId="shipperCode"/>
    <html:hidden name="feserv06" property="consigneeCode" styleId="consigneeCode"/>
    <html:hidden name="feserv06" property="notifyPartyCode" styleId="notifyPartyCode"/>
    <html:hidden name="feserv06" property="fsc" styleId="fsc"/>
    <html:hidden name="feserv06" property="openAcknowledgement" styleId="openAcknowledgement"/>
    <html:hidden name="feserv06" property="emailAcknowledgment" styleId="emailAcknowledgment"/>
    <html:hidden name="feserv06" property="vendorTelephone" styleId="vendorTelephone"/>
    <html:hidden name="feserv06" property="vendorFax" styleId="vendorFax"/>
    <html:hidden name="feserv06" property="vendorEmail" styleId="vendorEmail"/>
    <html:hidden name="feserv06" property="podCountry" styleId="podCountry"/>
    <html:hidden name="feserv06" property="isDisabledSubmit" styleId="isDisabledSubmit"/>
    <html:hidden name="feserv06" property="esiErrMsg" styleId="esiErrMsg"/>
    <html:hidden name="feserv06" property="prevBookingNo" styleId="prevBookingNo"/>
    <%-- @04 BEGIN --%>
    <html:hidden name="feserv06" property="esiStatusCode" styleId="esiStatusCode"/>
    <html:hidden name="feserv06" property="esiStatusDesc" styleId="esiStatusDesc"/>
    <html:hidden name="feserv06" property="prevEsiStatusCode" styleId="prevEsiStatusCode"/>
    <html:hidden name="feserv06" property="prevEsiStatusDesc" styleId="prevEsiStatusDesc"/>
    <html:hidden name="feserv06" property="comSeqNoTemp" styleId="comSeqNoTemp" />
    <%-- @04 END --%>
    <html:hidden name="feserv06" property="msgFieldChanged" styleId="msgFieldChanged" />
    
    
    <%--input type="hidden" id="esiErrMsg" value="<bean:write name='feserv06' property='esiErrMsg' />" /--%>
    
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
    
    <bean:define id="isReadOnly" value="<%=isReadonly%>" />
    <table width="100%" border="0" cellspacing="0" cellpadding="0" style="min-width: 1024px">
    <tr>
        <td width="100%" style="min-width: 1024px">
            <table width="100%" border="0" cellspacing="0" cellpadding="0" style="min-width: 1024px">
            <tr>
                <td style="width: 100%; min-width: 1024px">
                <div class="TableLeftSubColor2" style="width: 100%; min-width: 1024px">
                    <h2>B/L Type Details </h2>
                </div>
                </td>
            </tr>
            <tr>
                <td>
                    <table class="table_search" border="0" width="100%" cellspacing="0" cellpadding="0">
                    <tr>
                        <td width="15%" style="min-width: 150px" class="lableBackground" height="18px">
                            One Booking One BL
                        </td>
                        <td>${feserv06.choiceRad }</td>
                        <td width="18%" style="min-width: 191px" class="whitebg" valign="middle">
                            <html:radio name="feserv06" property="choiceRad" styleId="choiceRad" value="1" style="float:left;border:0px;width:8%"/>
                        </td>
                        <td width="15%" style="min-width: 150px" class="lableBackground">
                            One Booking Many BLs
                        </td>
                        <td width="18%" style="min-width: 191px" class="whitebg" valign="middle">
                            <html:radio name="feserv06" property="choiceRad" styleId="choiceRad" value="2" style="float:left;border:0px;width:8%" disabled="true"/>
                        </td>
                        <td width="15%" style="min-width: 150px" class="lableBackground">
                            Many Bookings One B/L
                        </td>
                        <td width="19%" style="min-width: 192px" class="whitebg" valign="middle">
                            <html:radio name="feserv06" property="choiceRad" styleId="choiceRad" value="3" style="float:left;border:0px;width:8%" disabled="true"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="lableBackground" height="18px">
                            B/L Type
                        </td>
                        <td class="whitebg" colspan="5">
                            <html:select name="feserv06" property="blType" styleId="blType" size="1">
                                <html:optionsCollection name="feserv06" value="code" label="name" property="blTypeValues"/>
                            </html:select>
                        </td>
                    </tr>
                    </table>
                </td>
            </tr>
            </table>
        </td>
    </tr>
    <tr>
        <td>
            <table border="0" width="100%" cellspacing="0" cellpadding="0" style="min-width: 1024px">
            <tr>
                <td style="width: 100%; min-width: 1024px">
                <div class="TableLeftSubColor2" style="width: 100%; min-width: 1024px">
                    <h2>Shipment Details </h2>
                </div>
                </td>
            </tr>
            <tr>
                <td>
                    <table class="table_search" border="0" width="100%" cellspacing="0" cellpadding="0" style="min-width: 1024px">
                    <tr>
                        <td width="15%" style="min-width: 150px" class="lableBackground">
                            Booking Number
                        </td>
                        <td width="18%" class="whitebg" style="padding-top:1px;padding-left:4px; min-width: 150px" valign="top">
                            <html:text name="feserv06" property="bookingNo" styleId="bookingNo" maxlength='17' style="width:66%" styleClass="must"
                                onkeydown="gotoToSearchBookingEsi(this)" />
                            <a id="browseBookingNoBtn" class="m-btn smallest blue rnd smallericn-only" href="javascript:void(0)"
                                onclick="openBookingNumberForShipping()">
                                <i class="icon-search icon-white"></i>
                            </a>                    
                        </td>
                        <td width="15%" style="min-width: 150px" class="lableBackground">
                            B/L Number
                        </td>
                        <td width="18%" style="min-width: 191px" class="whitebg">
                            <font class="displayText">
                                <html:hidden name="feserv06" property="blNumber" styleId="blNumber"/>
                                <bean:write name="feserv06" property="blNumber" />
                            </font>
                        </td>
                        <td width="15%" style="min-width: 150px" class="lableBackground">
                            eSI Status
                        </td>
                        <td width="19%" style="min-width: 192px" class="whitebg">
                            <font class="displayText">
                                <bean:write name="feserv06" property="esiStatusDesc"/>
                            </font>    
                        </td>
                    </tr>
                    <tr>
                        <td class="lableBackground" height="18px">
                            SI Submitted By
                        </td>
                        <td class="whitebg">
                            <font class="displayText">
                                <html:hidden name="feserv06" property="siSubmittedBy" />
                                <bean:write name="feserv06" property="siSubmittedBy" />
                            </font>
                        </td>
                        <td class="lableBackground">
                            Contact Person
                        </td>
                        <td class="whitebg" style="padding-left:4px;">
                            <html:text name="feserv06" property="contact" styleId="contact" maxlength='25' style="width: 95%" styleClass="must" onblur="changeUpper(this)" readonly="${isReadOnly}"/>
                        </td>
                        <td class="lableBackground">
                            Email
                        </td>
                        <td class="whitebg" style="padding-left:4px;">
                            <%--html:hidden name="feserv06" property="email" /--%>
                            <html:text name="feserv06" property="email" styleId="email" style="width: 95%"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="lableBackground" height="18px">
                            Telephone
                        </td>
                        <td class="whitebg" style="padding-left:4px;">
                            <html:text name="feserv06" property="telephone" styleId="telephone" maxlength='17' style="width: 95%" onblur="changeUpper(this)" readonly="${isReadOnly}"/>
                        </td>
                        <td class="lableBackground">
                            Fax
                        </td>
                        <td style="padding-left:4px;">
                            <html:text name="feserv06" property="fax" styleId="fax" maxlength='17' style="width: 95%" onblur="changeUpper(this)" readonly="${isReadOnly}"/>
                        </td>
                        <td class="lableBackground">
                            Additional Mail Recipients
                        </td>
                        <td class="whitebg" style="padding-left:4px;">
                            <html:text name="feserv06" property="additionalEmail" styleId="additionalEmail" maxlength='250' style="width: 95%" onblur="changeUpper(this)" readonly="${isReadOnly}"/>
                        </td>
                    </tr>   
                    </table>
                </td>
            </tr>
            </table>
        </td>
    </tr>
    <tr>
        <td>
            <table border="0" width="100%" cellspacing="0" cellpadding="0" style="min-width: 1024px">
            <tr>
                <td style="width: 100%; min-width: 1024px">
                    <div class="TableLeftSubColor2" style="width: 100%; min-width: 1024px">
                        <h2>Contact Details </h2>
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <table width="100%" border="0" cellpadding="0" cellspacing="0" style="min-width: 1024px">
                    <tr>
                        <td width="33%" style="min-width: 341px" class="TableHeadingRow2"><span class="m0l0iout">Shipper Name/Address</span></td>
                        <td width="33%" style="min-width: 341px" class="TableHeadingRow2"><span class="m0l0iout">Consignee Name/Address</span></td>
                        <td width="34%" style="min-width: 342px" class="TableHeadingRow2"><span class="m0l0iout">Notify Party Name/Address</span></td>
                    </tr>
                    <tr>
                        <td class="whitebg">
                            <html:text name="feserv06" property="shipperName" styleId="shipperName" maxlength='45' style="width: 80%" styleClass="must" onkeydown="changeField('btnBrowseNotifyPartyName');"  onblur="changeUpper(this)" readonly="${isReadOnly}"/>
                            <!--input type="button" value=". . ." id="btnBrowseShipperName" name="btnBrowseShipperName" class="event_btnbutton" onclick="openCustomerData('shipperName', 'shipperAddress1', 'shipperAddress2', 'shipperAddress3', 'shipperAddress4' );"/-->
                        </td>
                        <td class="whitebg">
                            <html:text name="feserv06" property="consigneeName" styleId="consigneeName" maxlength='45' style="width: 80%" styleClass="must" onkeydown="changeField('shipperAddress1');"  onblur="changeUpper(this)" readonly="${isReadOnly}"/>
                            <a id="btnBrowseConsigneeName" href="javascript:void(0)"
                                onclick="openCustomerData(this,'consigneeName', 'consigneeAddress1', 'consigneeAddress2', 'consigneeAddress3', 'consigneeAddress4');"><i class="icon-search icon-white"></i></a>
                        </td>
                        <td class="whitebg">
                            <html:text name="feserv06" property="notifyPartyName" styleId="notifyPartyName" maxlength='45' style="width: 80%" styleClass="must"  onkeydown="changeField('consigneeAddress1');" onblur="changeUpper(this)" readonly="${isReadOnly}"/>
                            <a id="btnBrowseNotifyPartyName" href="javascript:void(0)"
                                onclick="openCustomerData(this,'notifyPartyName', 'notifyPartyAddress1', 'notifyPartyAddress2', 'notifyPartyAddress3', 'notifyPartyAddress4');"><i class="icon-search icon-white"></i></a>
                        </td>
                    </tr>
                    <tr>
                        <td class="whitebg">
                            <html:text name="feserv06" property="shipperAddress1" styleId="shipperAddress1" maxlength='35' style="width: 80%" styleClass="must" onkeydown="changeField('notifyPartyAddress1');" onblur="changeUpper(this)" readonly="${isReadOnly}"/>
                        </td>
                        <td class="whitebg">
                            <html:text name="feserv06" property="consigneeAddress1" styleId="consigneeAddress1" maxlength='35' style="width: 80%" styleClass="must" onkeydown="changeField('shipperAddress2');" onblur="changeUpper(this)" readonly="${isReadOnly}"/>
                        </td>
                        <td class="whitebg">
                            <html:text name="feserv06" property="notifyPartyAddress1" styleId="notifyPartyAddress1" maxlength='35' style="width: 80%" styleClass="must" onkeydown="changeField('consigneeAddress2');" onblur="changeUpper(this)" readonly="${isReadOnly}"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="whitebg">
                            <html:text name="feserv06" property="shipperAddress2" styleId="shipperAddress2" maxlength='35' style="width: 80%" onkeydown="changeField('notifyPartyAddress2');" onblur="changeUpper(this)"  readonly="${isReadOnly}" />
                        </td>
                        <td class="whitebg">
                            <html:text name="feserv06" property="consigneeAddress2" styleId="consigneeAddress2" maxlength='35' style="width: 80%" onkeydown="changeField('shipperAddress3');" onblur="changeUpper(this)" readonly="${isReadOnly}"/>
                        </td>
                        <td class="whitebg">
                            <html:text name="feserv06" property="notifyPartyAddress2" styleId="notifyPartyAddress2" maxlength='35' style="width: 80%" onkeydown="changeField('consigneeAddress3');" onblur="changeUpper(this)" readonly="${isReadOnly}"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="whitebg">
                            <html:text name="feserv06" property="shipperAddress3" styleId="shipperAddress3" maxlength='35' style="width: 80%" onkeydown="changeField('notifyPartyAddress3');"  onblur="changeUpper(this)" readonly="${isReadOnly}"/>
                        </td>
                        <td class="whitebg">
                            <html:text name="feserv06" property="consigneeAddress3" styleId="consigneeAddress3" maxlength='35' style="width: 80%" onkeydown="changeField('shipperAddress4');" onblur="changeUpper(this)" readonly="${isReadOnly}"/>
                        </td>
                        <td class="whitebg">
                            <html:text name="feserv06" property="notifyPartyAddress3" styleId="notifyPartyAddress3" maxlength='35' style="width: 80%" onkeydown="changeField('consigneeAddress4');" onblur="changeUpper(this)" readonly="${isReadOnly}"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="whitebg">
                            <html:text name="feserv06" property="shipperAddress4" styleId="shipperAddress4" maxlength='35' style="width: 80%" onkeydown="changeField('shipperName');" onblur="changeUpper(this)" readonly="${isReadOnly}"/>
                        </td>
                        <td class="whitebg">
                            <html:text name="feserv06" property="consigneeAddress4" styleId="consigneeAddress4" maxlength='35' style="width: 80%" onkeydown="changeField('btnBrowseConsigneeName');" onblur="changeUpper(this)" readonly="${isReadOnly}"/>
                        </td>
                        <td class="whitebg">
                            <html:text name="feserv06" property="notifyPartyAddress4" styleId="notifyPartyAddress4" maxlength='35' style="width: 80%" onblur="changeUpper(this)" readonly="${isReadOnly}"/>
                        </td>
                    </tr>
                    <!-- for line spacing -->
                    <tr style="height: 2px"><td></td></tr>
                    </table>
                </td>
            </tr>
            </table>
        </td>
    </tr>
    <tr>
        <td>
            <table border="0" width="100%" cellspacing="0" cellpadding="0" style="min-width: 1024px">
            <tr>
                <td style="width: 100%; min-width: 1024px">
                    <div class="TableLeftSubColor2" style="width: 100%; min-width: 1024px">
                        <h2>Routing Details </h2>
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <table width="100%" border="0" cellpadding="0" cellspacing="0" style="min-width: 1024px">
                    <tr>
                        <td width="25%" style="min-width: 256px" class="TableHeadingRow2"><span class="m0l0iout">Vessel</span></td>
                        <td width="25%" style="min-width: 256px" class="TableHeadingRow2"><span class="m0l0iout">Voyage No.</span></td>
                        <td width="25%" style="min-width: 256px" class="TableHeadingRow2"><span class="m0l0iout">Shipped on Board Date</span></td>
                        <td width="25%" style="min-width: 256px" class="TableHeadingRow2"><span class="m0l0iout">Place of Issue</span></td>
                    </tr>
                    <tr>
                        <td class="whitebg" height="20px">
                            <font class="displayText">
                                <html:hidden name="feserv06" property="vessel" styleId="vessel"/>
                                <html:hidden name="feserv06" property="vesselNo"/>
                                <bean:write name="feserv06" property="vessel" />
                            </font>
                        </td>
                        <td class="whitebg">
                            <font class="displayText">
                                <html:hidden name="feserv06" property="voyageNo" styleId="voyageNo"/>
                                <bean:write name="feserv06" property="voyageNo" />
                            </font>
                        </td>
                        <td class="whitebg">
                            <font class="displayText">
                                <html:hidden name="feserv06" property="shippedOnBoardDate" styleId="shippedOnBoardDate"/>
                                <bean:write name="feserv06" property="shippedOnBoardDate" />
                            </font>
                        </td>
                        <td class="whitebg">
                            <html:text name="feserv06" property="placeDateOfIssue" styleId="placeDateOfIssue" maxlength='50' style="width: 95%" onblur="changeUpper(this)" readonly="${isReadOnly}"/>
                        </td>
                    </tr>
                    <!-- for line spacing -->
                    <tr style="height: 2px"><td></td></tr>
                    <tr>
                        <td class="TableHeadingRow2"><span class="m0l0iout">Port of Loading(POL)</span></td>
                        <td class="TableHeadingRow2"><span class="m0l0iout">Port of Discharge(POD)</span></td>
                        <td class="TableHeadingRow2"><span class="m0l0iout">Place of Receipt</span></td>
                        <td class="TableHeadingRow2"><span class="m0l0iout">Place of Delivery</span></td>
                    </tr>
                    <tr>
                        <td class="whitebg" height="20px">
                            <html:hidden name="feserv06" property="polNo"/>
                            <html:text name="feserv06" property="pol" styleId="pol" maxlength="50" styleClass="must" style="width:95%" onblur="changeUpper(this)" readonly="${isReadOnly}"/>
                        </td>
                        <td class="whitebg">                    
                            <html:hidden name="feserv06" property="podNo"/>
                            <html:text name="feserv06" property="pod" styleId="pod" maxlength="50" styleClass="must" style="width:95%" onblur="changeUpper(this)" readonly="${isReadOnly}"/>
                        </td>
                        <td class="whitebg">
                            <html:text name="feserv06" property="placeOfReceipt" styleId="placeOfReceipt" maxlength="50" styleClass="must" style="width:95%" onblur="changeUpper(this)" readonly="${isReadOnly}"/>
                        </td>
                        <td class="whitebg">
                            <html:text name="feserv06" property="placeOfDelivery" styleId="placeOfDelivery" maxlength="50" styleClass="must" style="width:95%" onblur="changeUpper(this)" readonly="${isReadOnly}"/>
                        </td>
                    </tr>
                    <!-- for line spacing -->
                    <tr style="height: 2px"><td></td></tr>
                    </table>
                </td>
            </tr>
            </table>
        </td>
    </tr>
    <tr>
        <td>
            <table width="100%" border="0" cellpadding="0" cellspacing="0" style="min-width: 1024px">
            <tr>
                <td style="width: 100%; min-width: 1024px">
                    <%-- ##02 BEGIN --%>
                    <div class="TableLeftSubColorNoBorder" style="width: 100%; min-width: 1024px">
                        <h2>Commodity Details</h2>
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                <%--div id="comm_search_result" class="search_result" style="width: 100%; min-width: 1024px; height: 100% "--%>
                    <table id="comm_result_dtl" width="100%" border="0" cellpadding="0" cellspacing="0"
                    style="table-layout:fixed; min-width: 1024px">
                    <%--table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_search"--%>
                    <tr>
                        <td width="3%" style="border: none;" class="tableHeadingBlue"><span class="m0l0iout">#</span></td>
                        <td width="11%" style="border: none;" class="tableHeadingBlue"><span class="m0l0iout">Commodity Group</span></td>
                        <td width="11%" style="border: none;" class="tableHeadingBlue"><span class="m0l0iout">HS Code</span></td>
                        <td width="16%" style="border: none;" class="tableHeadingBlue"><span class="m0l0iout">Commodity Description</span></td>
                        <td width="8%" style="border: none;" class="tableHeadingBlue"><span class="m0l0iout"># of Packages</span></td>  
                        <td width="13%" style="border: none;" class="tableHeadingBlue"><span class="m0l0iout">Package Kind</span></td>
                        <td width="10%" style="border: none;" class="tableHeadingBlue"><span class="m0l0iout">Gross Weight</span></td>
                        <td width="15%" style="border: none;" class="tableHeadingBlue"><span class="m0l0iout">Gross Cargo Measurement (CBM)</span></td>
                        <!--Begin @07 -->
                        <td width="7%" style="border: none;" class="tableHeadingBlue"><span class="m0l0iout">Marks/Desc</span></td>
                        <!--End @07 -->
                        <td width="6%" style="border: none;" class="tableHeadingBlue"><span class="m0l0iout">Select</span></td>
                    </tr>
            <%--div id="comm_search_result" class="search_result" style="height: 100% ">
                <table id="comm_result_dtl" class="table_results"  border="0" cellpadding="0" cellspacing="0"--%>
                        <%
                            int countCommo = 0;
                            
                            //COMMODITY_SELECT
                        %>
        <logic:iterate id="commodityValue" name="feserv06" property="commodityVoDataList" 
        indexId="ctr" type="com.rclgroup.dolphin.rcl.web.eservice.vo.EshippingCommodityDetailsMod">
        <logic:notEqual name="commodityValue" property="recordStatus" value="DEL">
            <% if(EshippingInstructionDao.ESI_STATUS.NEW.equals(esiStatusCode) || EshippingInstructionDao.ESI_STATUS.IN_PROGRESS.equals(esiStatusCode)) { %>
                    <tr style="height: 25px">
                        <td class="tableColumnData" align="center">
                            <%=countCommo+1%>
                         </td>
                        <td class="tableColumnData">
                            <html:hidden name="commodityValue" property="intCommGroupSeqNo" styleId="intCommGroupSeqNo"/>
                            <html:hidden name="commodityValue" property="strCommGroupCode" styleId="strCommGroupCode"/>
                            <html:hidden name='commodityValue' property="recordStatus" styleId="recordStatus"/>
                            <html:hidden name='commodityValue' property="strCommPackageKindCode" styleId="strCommPackageKindCode"/>
                            <html:hidden name='commodityValue' property="marksAndNumbers" styleId="marksAndNumbers"/>
                            <html:hidden name='commodityValue' property="description" styleId="description"/>
                            <html:hidden name="commodityValue" property="comBookingNo" styleId="comBookingNo"/>
                            <html:hidden name="commodityValue" property="strCommodityForMark" styleId="strCommodityForMark"/>
                            <html:hidden name="commodityValue" property="containerNoToCargo" styleId="containerNoToCargo"/>
                            <html:hidden name="commodityValue" property="comSeqNo" styleId="comSeqNo"/>
                            <html:text  name="commodityValue" 
                                        property="strCommGroup"  
                                        style="width: 75%"
                                        onkeypress="return false;"
                                        onkeydown="return false;"
                                        styleClass="input-disabled"  />
                            <%--html:text name="commodityValue" property="strCommGroup"  style="width:80%" 
                            onblur="openCommodityGroupLookup(${ctr}, '1', this.value);  changeUpper(this); " styleClass="must" /--%>
                        </td>
                        <td class="tableColumnData">
                            <html:text  name="commodityValue" 
                                        property="strCommCode" 
                                        styleId="strCommCode"
                                        style="width: 75%"
                                        onkeypress="return false;"
                                        onkeydown="return false;"
                                        styleClass="must"  />
                            <%--html:text name="commodityValue" property="strCommGroup"  style="width:80%" 
                            onblur="openCommodityGroupLookup(${ctr}, '1', this.value);  changeUpper(this); " styleClass="must" /--%>
                            <% if(obj.getBookingNo() != null && !"".equals(obj.getBookingNo())){ %>
                            <a name="btnCommodityGroupLookup" class="m-btn smallest blue rnd smallericn-only" href="javascript:void(0)"
                                onclick="openCommodityGroupLookup(this, '0', '');" >
                                <i class="icon-search icon-white"></i>
                            </a>  
                            <% } %>
                        </td>
                        <td class="tableColumnData">
                            <html:text  name="commodityValue" 
                                        property="strCommDesc" 
                                        styleId="strCommDesc"
                                        style="width: 75%"  
                                        onkeypress="return false;"
                                        onkeydown="return false;"
                                        styleClass="input-disabled"
                                        />
                            <%--html:text name="commodityValue" property="strCommDesc" style="width:80%"
                            onblur="openCommodityGroupLookup(${ctr}, '2', this.value); changeUpper(this)"  /--%>
                            
                            
                        </td>   
                        <td class="tableColumnData">                        
                            <html:text  name="commodityValue" 
                                        property="strCommOfPackages" 
                                        styleId="strCommOfPackages"
                                        maxlength='6' 
                                        style="width: 70%" 
                                        onkeypress="return false;"
                                        onkeydown="return false;"
                                        styleClass="input-disabled"
                                        readonly="true"/>
                        </td>
                        <td class="tableColumnData">
                            <html:text  name="commodityValue" 
                                        property="strCommPackageKindName" 
                                        styleId="strCommPackageKindName"
                                        style="width: 66%;" 
                                        onkeypress="return false;"
                                        onkeydown="return false;"
                                        styleClass="input-disabled"
                                        readonly="true" />
                            <a name="btnBrowseCommPackageKind" href="javascript:void(0)" class="m-btn smallest blue rnd smallericn-only"
                            onclick="openPackageKind(this, 'strCommPackageKindCode', 'strCommPackageKindName', PACKAGE_KIND_TYPE_COMMODITY)"><i class="icon-search icon-white"></i></a>
                        </td>
                        <td class="tableColumnData">
                            <html:text  name="commodityValue" 
                                        property="strCommWeight" 
                                        styleId="strCommWeight"
                                        style="width: 66%" 
                                        onkeypress="return false;"
                                        onkeydown="return false;"
                                        styleClass="input-disabled"
                                        readonly="true" />
                        </td>
                        <td class="tableColumnData">
                            <html:text  name="commodityValue" 
                                        property="strCommMeasurement" 
                                        styleId="strCommMeasurement"
                                        maxlength='19' 
                                        style="width: 66%" 
                                        onkeypress="return false;"
                                        onkeydown="return false;"
                                        styleClass="input-disabled"
                                        readonly="true" />
                        </td>
                        <!--Begin @07 -->
                        <td class="tableColumnData" valign="middle" align="center">
                            <a name="btnCargoDetails" class="m-btn smallest blue rnd smallericn-only" href="javascript:void(0)" 
                            onclick="openCargoDescription(this)"><i class="icon-plus icon-white"></i></a>
                        </td>
                        <!--End @07 -->
                        <td class="tableColumnData" align="center">
                        <% if(countCommo > 0){ %>
                            <html:checkbox name="commodityValue" property="isSelected" styleId="isSelected" value="Y" style="border:0px; width:15px; height: 15px" />
                        <% } %>&nbsp;
                         <%  ++countCommo;   %>
                        </td>
                    </tr>
            <% }else{   %>
                    <tr style="height: 25px">
                        <td class="tableColumnData" align="center">
                            <%=countCommo+1%>
                         </td>
                        <td class="tableColumnData">
                            <html:text  name="commodityValue" 
                                        property="strCommGroup" 
                                        styleId="strCommGroup"
                                        style="width: 75%" 
                                        onkeypress="return false;"
                                        onkeydown="return false;"
                                        styleClass="input-disabled" 
                                        readonly="true"  />
                        </td>
                        <td class="tableColumnData">
                            <html:text  name="commodityValue" 
                                        property="strCommCode"  
                                        styleId="strCommCode"
                                        style="width: 75%"
                                        onkeypress="return false;"
                                        onkeydown="return false;"
                                        styleClass="must"  />
                            <a name="btnCommodityGroupLookup" class="m-btn smallest rnd icn-only disabled" href="javascript:void(0)">
                                <i class="icon-search icon-white"></i>
                            </a>
                        </td>
                        <td class="tableColumnData">
                            <html:text  name="commodityValue" 
                                        property="strCommDesc" 
                                        styleId="strCommDesc"
                                        style="width: 75%" 
                                        readonly="true"
                                        onkeypress="return false;"
                                        onkeydown="return false;"
                                        styleClass="input-disabled" 
                                        />
                            
                            
                        </td>
                        <td class="tableColumnData">
                            <html:text  name="commodityValue" 
                                        property="strCommOfPackages" 
                                        styleId="strCommOfPackages"
                                        maxlength='6' style="width: 70%" 
                                        onblur="maskWithOutDecimal(this, 6, 2)" 
                                        styleClass="must"
                                        onclick="hideMask_Number(this);" 
                                        onkeypress="return false;"
                                        onkeydown="return false;"
                                        readonly="true"/>
                        </td>
                        <td class="tableColumnData">
                            <html:text  name="commodityValue" 
                                        property="strCommPackageKindName" 
                                        styleId="strCommPackageKindName"
                                        style="width: 66%" 
                                        onkeypress="return false;"
                                        onkeydown="return false;"
                                        styleClass="input-disabled"
                                        readonly="true"/>
                            <a name="btnBrowseCommPackageKind" class="m-btn smallest rnd icn-only disabled" href="javascript:void(0)">
                                <i class="icon-search icon-white"></i>
                            </a>
                        </td>
                        <td class="tableColumnData">
                            <html:text  name="commodityValue" 
                                        property="strCommWeight" 
                                        styleId="strCommWeight"
                                        style="width: 66%" 
                                        onkeypress="return false;"
                                        onkeydown="return false;"
                                        styleClass="input-disabled" 
                                        readonly="true" />
                        </td>
                        <td class="tableColumnData">
                            <html:text  name="commodityValue" 
                                        property="strCommMeasurement" 
                                        styleId="strCommMeasurement"
                                        maxlength='19' 
                                        style="width: 66%" 
                                        onblur="putMask_NumberEX(this, 14, 4)" 
                                        onclick="hideMask_Number(this);" 
                                        onkeypress="return false;"
                                        onkeydown="return false;"
                                        styleClass="input-disabled" 
                                        readonly="true" />
                        </td>
                        <!--Begin @07 -->
                        <td class="tableColumnData">
                            <logic:equal name="feserv06" property="esiStatusCode" value="<%=EshippingInstructionDao.ESI_STATUS.SUBMITTED%>" >
                                <a name="btnCargoDetails" class="m-btn smallest blue rnd smallericn-only" href="javascript:void(0)" 
                                    onclick="openCargoDescription(this)"><i class="icon-plus icon-white"></i>
                                </a>
                            </logic:equal>
                            <logic:notEqual name="feserv06" property="esiStatusCode" value="<%=EshippingInstructionDao.ESI_STATUS.SUBMITTED%>" >
                                <a name="btnCargoDetails" class="m-btn smallest rnd icn-only disabled" href="javascript:void(0)">
                                    <i class="icon-plus icon-white"></i>
                                </a>
                            </logic:notEqual>
                        </td>
                        <!--End @07 -->
                        <td class="tableColumnData">
                            &nbsp;
                        </td>
                    </tr>
                <%  countCommo++;   %>
            <% } %>
        </logic:notEqual>
        </logic:iterate>
                    </table>
                <%--/div--%>
                </td>
            </tr>
        <logic:notEmpty name="feserv06" property="commodityVoDataList">
            <logic:notEqual name="feserv06" property="esiStatusCode" value="<%=EshippingInstructionDao.ESI_STATUS.SUBMITTED%>" >
            <tr>
                <td align="right">
                    <div class="spotlight-action">
                    <!-- @02 BEGIN -->
                        <logic:notEmpty name="feserv06" property="bookingNo">
                        
                        <table border="0" cellspacing="2" cellpadding="0">
                        <tr>
                            <td align="right">
                                <a class="m-btn mini blue rnd" id="addCommBtn"
                                    href="javascript:void(0)" onClick="return addCommodity();">
                                        <i class="icon-plus icon-white"></i>&nbsp;Add Commodity
                                </a>
                            </td>
                        <%
                            String deleteCommBtnDisp = null;
                            String columnWidth = null;
                            if(obj.getCommodityVoDataList() != null && obj.getCommodityVoDataList().size() > 1){
                                deleteCommBtnDisp = "inline";
                            }else{
                                deleteCommBtnDisp = "none";
                            }
                        %>
                            <td id="deleteCommTd" align="right" style="display: <%=deleteCommBtnDisp%>">
                                <a class="m-btn mini red rnd" id="deleteCommBtn"
                                href="javascript:void(0)" onClick="return deleteCommodity()">  
                                    <i class="icon-trash icon-white"></i>&nbsp;Delete Commodity
                                </a>
                            </td>
                        </tr>
                        </table>
                        </logic:notEmpty>
                        
                    <!-- @02 END -->
                    </div>
                </td>
            </tr>
            </logic:notEqual>
        </logic:notEmpty>
            <tr><td style="height: 20px">&nbsp;</td></tr>
            </table>
        </td>
    </tr>
    <tr>
        <td>
            <table width="100%" border="0" cellpadding="0" cellspacing="0" style="min-width: 1024px">
            <tr>
                <td style="width: 100%; min-width: 1024px">
                    <div class="TableLeftSubColor2" style="width: 100%; min-width: 1024px">
                        <h2>Equipment Details </h2>
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <table width="100%" border="0" cellpadding="0" cellspacing="0" style="min-width: 1024px">
                    <tr>
                        <td width="3%" style="min-width: 30px" class="TableHeadingRow2"><span class="m0l0iout">#</span></td>
                        <td width="12%" style="min-width: 124px" class="TableHeadingRow2"><span class="m0l0iout">Container No.</span></td>
                        <td width="14%" style="min-width: 150px" class="TableHeadingRow2"><span class="m0l0iout">Container Type</span></td>
                        <td width="10%" style="min-width: 100px" class="TableHeadingRow2"><span class="m0l0iout">Carrier Seal</span></td>
                        <td width="10%" style="min-width: 100px" class="TableHeadingRow2"><span class="m0l0iout">Shipper Seal</span></td>
                        <td width="12%" style="min-width: 120px" class="TableHeadingRow2"><span class="m0l0iout"># of Packages</span></td>  
                        <td width="21%" style="min-width: 220px" class="TableHeadingRow2"><span class="m0l0iout">Package Kind</span></td>
                        <td width="14%" style="min-width: 140px" class="TableHeadingRow2"><span class="m0l0iout">Gross Cargo Weight (KG)</span></td>
                        <td width="4%" style="min-width: 40px" class="TableHeadingRow2" align="center">
                            <div style="display:none">
                                <input type="checkbox" name="cbdelall" style="float:left;border:0px;width:100%" onclick="selectAllData()"/>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td class="TableHeadingRow3" ></td>
                        <td class="TableHeadingRow3" ><span class="m0l0iout">Commodity</span></td>
                        <td class="TableHeadingRow3" colspan="5"><span class="m0l0iout">Laden / MT</span></td>
                        <td class="TableHeadingRow3" colspan="2"><span class="m0l0iout">Gross Cargo Measurement (CBM)</span></td>
                    </tr>
                <logic:notEmpty name="eshippingInstructionUim" scope="session" >
                <bean:define id="objFormSession" name="eshippingInstructionUim" 
                type="com.rclgroup.dolphin.rcl.web.eservice.actionform.EshippingInstructionUim" scope="session" />
                    <logic:notEmpty name="objFormSession" property="cargoDescriptionDetails"> 
                    <bean:define id="cargoDescriptionDetailsList" name="objFormSession" property="cargoDescriptionDetails" type="java.util.List" />
                        <logic:iterate id="cargoDetails" name="cargoDescriptionDetailsList" indexId="rowCargoDetailsId" >
                        <bean:define id="seqNo" name="cargoDetails" property="seqNo" />
                    <tr class="<%=((rowCargoDetailsId+1)%2==0)?"rowEvenColor":"rowOddColor"%>">
                        <td>
                            <bean:write name="seqNo" />
                            <input type="hidden" name="seqNo" id="seqNo" value="<bean:write name='seqNo' />"/>
                            <input type="hidden" name="cntrSeq" id="cntrSeq" value="<bean:write name='cargoDetails' property='cntrSeq' />"/>
                        </td>   
                        <td>
                            <input type="hidden" name="dbFlag" id="dbFlag" value="<bean:write name='cargoDetails' property='dbFlag' />"/>
                            <input type="hidden" name="statusFlag" id="statusFlag" value="<bean:write name='cargoDetails' property='statusFlag' />"/>
                            <input type="hidden" name="originalSeqNo" id="originalSeqNo" value="<bean:write name='cargoDetails' property='originalSeqNo' />"/>
                            <input type="hidden" name="fkEquipmentDetail" id="fkEquipmentDetail" value="<bean:write name='cargoDetails' property='fkEquipmentDetail' />"/>
                            <input type="hidden" name="fkBookingSupplier" id="fkBookingSupplier" value="<bean:write name='cargoDetails' property='fkBookingSupplier' />"/>
                            <input type="hidden" name="fkBookingSizeTypeDetail" id="fkBookingSizeTypeDetail" value="<bean:write name='cargoDetails' property='fkBookingSizeTypeDetail' />"/>
                            <input type="hidden" name="cargoDetails" id="cargoDetails" value="" style="width:408px"/>
                            <logic:notEmpty name="cargoDetails" property="containerNo">
                                <logic:equal name="isReadOnly" value="false">
                                    <html:text name="cargoDetails" property="containerNo" styleId="containerNo" maxlength="11" 
                                    style="width: 81%" onblur="changeUpper(this);" onfocus="editContainerNo(${rowCargoDetailsId});"
                                    onchange="onChangeContainerNo(${rowCargoDetailsId});" readonly="${isReadOnly}" />
                                </logic:equal>
                                <logic:notEqual name="isReadOnly" value="false">
                                    <html:text name="cargoDetails" property="containerNo" styleId="containerNo" maxlength="11" 
                                    style="width: 81%" readonly="${isReadOnly}" />
                                </logic:notEqual>
                            </logic:notEmpty>
                            <logic:empty name="cargoDetails" property="containerNo">
                                <html:text name="cargoDetails" property="containerNo" styleId="containerNo" value="" maxlength="11" 
                                style="width: 81%" onblur="changeUpper(this);" onfocus="editContainerNo(${rowCargoDetailsId});"
                                onchange="onChangeContainerNo(${rowCargoDetailsId});" readonly="${isReadOnly}" />
                            </logic:empty>
                        </td>
                        <td>
                            <logic:notEmpty name="cargoDetails" property="containerEqSize">
                                <input type="hidden" name="containerEqSize" id="containerEqSize" value="<bean:write name='cargoDetails' property="containerEqSize" />" />
                            </logic:notEmpty>
                            <logic:empty name="cargoDetails" property="containerEqSize">
                                <input type="hidden" name="containerEqSize" id="containerEqSize" value="" />
                            </logic:empty>
                             <logic:notEmpty name="cargoDetails" property="containerEqType">
                               <input type="hidden" name="containerEqType" id="containerEqType" value="<bean:write name='cargoDetails' property='containerEqType' />" />
                            </logic:notEmpty>
                            <logic:empty name="cargoDetails" property="containerEqSize">
                               <input type="hidden" name="containerEqType" id="containerEqType" value="" />
                            </logic:empty>
                            
                            <logic:equal name="cargoDetails" property="dbFlag" value="0">                                    
                                <html:select name="cargoDetails" property="containerType" styleId="containerType" style="width: 90%; height:20px;" onchange="setContainerValue(this, '<%=seqNo%>')" >
                                    <html:optionsCollection name="cargoDetails" property="containerTypeValues" label="name" value="code"  />
                                </html:select>
                            </logic:equal>
                            <logic:notEqual name="cargoDetails" property="dbFlag" value="0">
                                <logic:notEmpty name="cargoDetails" property="containerType">
                                    <input type="hidden" name="containerType" id="containerType" value="<bean:write name='cargoDetails' property="containerType" />" />
                                
                                    <font class="displayText"><bean:write name='cargoDetails' property="containerType" /></font>
                                </logic:notEmpty>
                                <logic:empty name="cargoDetails" property="containerType">
                                    <input type="hidden" name="containerType" id="containerType" value="" />
                                </logic:empty>
                            </logic:notEqual>                                   
                        </td>
                        <td>
                            <logic:notEmpty name="cargoDetails" property="carrierSeal">
                                <html:text name="cargoDetails" property="carrierSeal" styleId="carrierSeal" maxlength='12' style="width: 70%" onblur="changeUpper(this)" readonly="${isReadOnly}"/>
                            </logic:notEmpty>
                            <logic:empty name="cargoDetails" property="carrierSeal">
                                <html:text name="cargoDetails" property="carrierSeal" styleId="carrierSeal" value="" maxlength='12' style="width:70%" onblur="changeUpper(this)" readonly="${isReadOnly}"/>
                            </logic:empty>
                        </td>
                        <td>
                            <logic:notEmpty name="cargoDetails" property="shipperSeal">
                                <html:text name="cargoDetails" property="shipperSeal" styleId="shipperSeal" maxlength='12' style="width:70%" onblur="changeUpper(this)" readonly="${isReadOnly}"/>
                            </logic:notEmpty>
                            <logic:empty name="cargoDetails" property="shipperSeal">
                                <html:text name="cargoDetails" property="shipperSeal" styleId="shipperSeal" value="" maxlength='12' style="width:70%" onblur="changeUpper(this)" readonly="${isReadOnly}"/>
                            </logic:empty>
                        </td>
                        <td>
                        <logic:notEmpty name="cargoDetails" property="containerNo">                              
                            <html:text name="cargoDetails" property="ofPackages" styleId="ofPackages" maxlength='6' style="width: 42%" 
                            onblur="maskWithOutDecimal(this, 6, 2)" styleClass="must"
                            onchange="onChangeEquipmentToCommodity(false);"
                            onclick="hideMask_Number(this);" readonly="${isReadOnly}"/>
                        </logic:notEmpty>
                        <logic:empty name="cargoDetails" property="containerNo">                                   
                            <html:text name="cargoDetails" property="ofPackages" styleId="ofPackages" maxlength='6' style="width: 42%" 
                            onblur="maskWithOutDecimal(this, 6, 2)" 
                            onchange="onChangeEquipmentToCommodity(false);"
                            onclick="hideMask_Number(this);" readonly="${isReadOnly}"/>
                        </logic:empty>
                        <logic:equal name="rowCargoDetailsId" value="0">
                            <a id="ofPackageCopyBtn${rowCargoDetailsId}" name="ofPackageCopyBtn" class="m-btn mini blue rnd" 
                            style="visiblity: visible; vertical-align: top;  height: 15px" 
                            href="javascript: void(0)" onClick="onClickCopyEquipmentField(EQUIPMENT_OF_PACKAGE, ${rowCargoDetailsId});">
                                Copy<i class="m-icon-white"></i>
                            </a>
                        </logic:equal>
                        </td>
                        <td style="padding-top:1px;" valign="top">
                        <logic:notEmpty name="cargoDetails" property="packagesKindCode">
                            <input type="hidden" name="packagesKindCode" id="packagesKindCode" value="<bean:write name='cargoDetails' property='packagesKindCode' />"/>
                        </logic:notEmpty>
                        <logic:empty name="cargoDetails" property="packagesKindCode">
                            <input type="hidden" name="packagesKindCode" id="packagesKindCode" value=""/>
                        </logic:empty>
                    <logic:notEqual name="objFormSession" property="esiStatusCode" value="<%=EshippingInstructionDao.ESI_STATUS.SUBMITTED%>">
                        <logic:notEmpty name="cargoDetails" property="containerNo">
                            <html:text name="cargoDetails" property="packagesKind" styleId="packagesKind" style="width: 54%" styleClass="must" readonly="true" />
                        </logic:notEmpty>
                        <logic:empty name="cargoDetails" property="containerNo">
                            <html:text name="cargoDetails" property="packagesKind" styleId="packagesKind" style="width: 54%" readonly="true" />
                        </logic:empty>
                            <a name="btnBrowsePackageKind" href="javascript:void(0)" 
                                onclick="openPackageKind(this, 'packagesKindCode', 'packagesKind', PACKAGE_KIND_TYPE_EQUIPMENT)"><i class="icon-search icon-white"></i></a>
                    </logic:notEqual>
                    <logic:equal name="objFormSession" property="esiStatusCode" value="<%=EshippingInstructionDao.ESI_STATUS.SUBMITTED%>">
                        <logic:notEmpty name="cargoDetails" property="packagesKind">
                            <input type="hidden" name="packagesKind" id="packagesKind" value="<bean:write name='cargoDetails' property='packagesKind' />"/>
                            
                            <font class="displayText">
                                <bean:write name="cargoDetails" property="packagesKind" />
                            </font>
                        </logic:notEmpty>
                        <logic:empty name="cargoDetails" property="packagesKind">
                            <input type="hidden" name="packagesKind" id="packagesKind" value=""/>
                        </logic:empty>
                    </logic:equal>
                        <logic:notEmpty name="cargoDetails" property="packagesKind">
                            <input type="hidden" name="packagesKindName" id="packagesKindName" value="<bean:write name='cargoDetails' property='packagesKind' />"/>
                        </logic:notEmpty>
                        <logic:empty name="cargoDetails" property="packagesKind">
                            <input type="hidden" name="packagesKindName" id="packagesKindName" value=""/>
                        </logic:empty>
                        <logic:equal name="rowCargoDetailsId" value="0">
                            <a id="packageKindCopyBtn${rowCargoDetailsId}" name="packageKindCopyBtn" class="m-btn mini blue rnd" 
                            style="visiblity: visible; vertical-align: top;  height: 15px" 
                            href="javascript: void(0)" onClick="onClickCopyEquipmentField(EQUIPMENT_PACKAGE_KIND, ${rowCargoDetailsId});">
                                Copy<i class="m-icon-white"></i>
                            </a>
                        </logic:equal>
                        </td>
                        <td>        
                        <logic:notEmpty name="cargoDetails" property="containerNo">
                            <html:text name="cargoDetails" property="grossContainerWeight" styleId="grossContainerWeight" maxlength='19' 
                            style="width: 57%"  styleClass="must"
                            onblur="putMask_NumberEX(this, 15, 3)"
                            onchange="putMask_NumberEX(this, 15, 3);onChangeEquipmentToCommodity(false);" 
                            onclick="hideMask_Number(this);" readonly="${isReadOnly}"/>
                        </logic:notEmpty>
                        <logic:empty name="cargoDetails" property="containerNo">
                            <html:text name="cargoDetails" property="grossContainerWeight" styleId="grossContainerWeight" maxlength='19' 
                            style="width: 57%" onblur="putMask_NumberEX(this, 15, 3)" 
                            onchange="putMask_NumberEX(this, 15, 3);onChangeEquipmentToCommodity(false);"
                            onclick="hideMask_Number(this);" readonly="${isReadOnly}"/>
                        </logic:empty>
                        <logic:equal name="rowCargoDetailsId" value="0">
                            <a id="grossWeightCopyBtn${rowCargoDetailsId}" name="grossWeightCopyBtn" class="m-btn mini blue rnd" 
                            style="visiblity: visible; vertical-align: top;  height: 15px" 
                            href="javascript: void(0)" onClick="onClickCopyEquipmentField(EQUIPMENT_GROSS_WEIGHT, ${rowCargoDetailsId});">
                                Copy<i class="m-icon-white"></i>
                            </a>
                        </logic:equal>
                        </td>
                        <td align="center">
                        <div style="display:none">
                            <input type="checkbox" name="cbdel" id="cbdel" style="float:left;border:0px;width:100%"/>
                        </div>
                        </td>
                    </tr>
                    <tr class="<%=((rowCargoDetailsId+1)%2==0)?"rowEvenColor":"rowOddColor"%>">
                        <td>&nbsp;</td>
                        <td align="left" >
                    <logic:notEqual name="objFormSession" property="esiStatusCode" value="<%=EshippingInstructionDao.ESI_STATUS.SUBMITTED%>">
                        <logic:notEmpty name="cargoDetails" property="commodityValues">
                            <html:select name="cargoDetails" property="commodity" styleId="commodity" style="width: 81%;height:20px;"
                            onchange="onChangeEquipmentToCommodity(true);">
                            <logic:iterate id="commodityValue" name="cargoDetails" property="commodityValues">
                                <logic:equal name="commodityValue" property="code" value="${cargoDetails.commodity}">
                                    <option value="<bean:write name="commodityValue" property="code" />" 
                                    label="<bean:write name="commodityValue" property="name" />" selected="selected" />
                                </logic:equal>
                                <logic:notEqual name="commodityValue" property="code" value="${cargoDetails.commodity}">
                                    <option value="<bean:write name="commodityValue" property="code" />" 
                                    label="<bean:write name="commodityValue" property="name" />" />
                                </logic:notEqual>
                            </logic:iterate>
                            </html:select>
                        </logic:notEmpty>
                    </logic:notEqual>
                    <logic:equal name="objFormSession" property="esiStatusCode" value="<%=EshippingInstructionDao.ESI_STATUS.SUBMITTED%>">
                        <logic:notEmpty name="cargoDetails" property="commodity">
                            <logic:notEqual name="cargoDetails" property="commodity" value="" >                                        
                                <logic:notEqual name="cargoDetails" property="commodity" value="0" >
                                    <logic:notEmpty name="cargoDetails" property="strCommodityName">
                                        <bean:write name="cargoDetails" property="strCommodityName" />
                                    </logic:notEmpty>
                                </logic:notEqual>
                            </logic:notEqual>
                        </logic:notEmpty>
                    </logic:equal>
                    <logic:equal name="objFormSession" property="esiStatusCode" value="">
                        <html:hidden name="cargoDetails" property="commodity" styleId="commodity"/>
                    </logic:equal>
                        </td>   
                        <td>
                            <logic:equal name="cargoDetails" property="dbFlag" value="0">
                                <html:select name="cargoDetails" property="ladenMt" styleId="ladenMt" style="width: 90%; height:20px;" disabled="${isReadOnly}">
                                    <html:optionsCollection name="cargoDetails" property="ladenMtValues" label="name" value="code" />
                                </html:select>
                            </logic:equal>
                            <logic:notEqual name="cargoDetails" property="dbFlag" value="0">
                                <logic:notEmpty name="cargoDetails" property="ladenMt">
                                    <input type="hidden" name="ladenMt" id="ladenMt" value="<bean:write name='cargoDetails' property='ladenMt' />" />                                        
                                    <font class="displayText">
                                        <bean:write name='cargoDetails' property='ladenMt' />
                                    </font>
                                </logic:notEmpty>
                                <logic:empty name="cargoDetails" property="ladenMt">
                                    <input type="hidden" name="ladenMt" id="ladenMt" value="" />    
                                </logic:empty>
                            </logic:notEqual>
                        </td>                                
                        <td colspan="4">&nbsp;</td>
                        <td style="padding-bottom:2px">
                            <logic:notEmpty name="cargoDetails" property="grossCargoMeasurement">
                                <html:text name="cargoDetails" property="grossCargoMeasurement" styleId="grossCargoMeasurement" maxlength='19' style="width:57%" 
                                onblur="putMask_NumberEX(this, 14, 4)" 
                                onchange="onChangeEquipmentToCommodity(false);"
                                onclick="hideMask_Number(this);" readonly="${isReadOnly}" />
                            </logic:notEmpty>
                            <logic:empty name="cargoDetails" property="grossCargoMeasurement">
                                <html:text name="cargoDetails" property="grossCargoMeasurement" styleId="grossCargoMeasurement" value="" maxlength='19' style="width:57%" 
                                onblur="putMask_NumberEX(this, 14, 4)" 
                                onchange="onChangeEquipmentToCommodity(false);"
                                onclick="hideMask_Number(this);" readonly="${isReadOnly}" />
                            </logic:empty>
                            
                        <logic:equal name="rowCargoDetailsId" value="0">
                            <a id="grossMeasurementCopyBtn${rowCargoDetailsId}" name="grossMeasurementCopyBtn" class="m-btn mini blue rnd" 
                            style="visiblity: visible; vertical-align: top;  height: 15px" 
                            href="javascript: void(0)" onClick="onClickCopyEquipmentField(EQUIPMENT_GROSS_MEASUREMENT, ${rowCargoDetailsId});">
                                Copy<i class="m-icon-white"></i>
                            </a>
                        </logic:equal>
                        </td>
                        <td>&nbsp;</td>
                    </tr>
                        </logic:iterate>
                    </logic:notEmpty>
                </logic:notEmpty>
                    </table>
                </td>
            </tr>
            <tr>
                <td align="right">
                    <div align="right" class="spotlight-action" style="display:none;padding-top:5px;padding-bottom:13px;">
                        <a id="addDisabledBtn" class="m-btn mini rnd disabled" style="display:none"
                            href="javascript:void(0)">
                                <i class="icon-plus icon-white"></i>&nbsp;Add Equipment
                        </a>
                        <a id="addBtn" class="m-btn mini blue rnd" style="display:''"
                            href="javascript:void(0)" onClick="return addItem()">
                                <i class="icon-plus icon-white"></i>&nbsp;Add Equipment
                        </a>
                        
                        <a id="delDisabledBtn" class="m-btn mini rnd disabled" style="display:none"
                            href="javascript:void(0)">
                                <i class="icon-trash icon-white"></i>&nbsp;Delete Equipment
                        </a>
                        <a id="delBtn" class="m-btn mini red rnd" style="display:''"
                            href="javascript:void(0)" onClick="return deleteItem()">
                                <i class="icon-trash icon-white"></i>&nbsp;Delete Equipment
                        </a>
                    </div>
                </td>
            </tr>
            </table>
        </td>
    </tr>
    <tr>
        <td>
            <table width="100%" border="0" cellpadding="0" cellspacing="0" style="min-width: 1024px">
            <tr>
                <td style="width: 100%; min-width: 1024px">
                    <div class="TableLeftSubColor2" style="width: 100%; min-width: 1024px">
                        <h2>Cargo Descriptions / Marks & No. & Printing Details </h2>
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <table width="100%" border="0" cellpadding="0" cellspacing="0" style="min-width: 1024px">
                    <tr>
                        <td width="12%" style="min-width: 120px" class="TableHeadingRow2"><span class="m0l0iout">No. of Original BL</span></td>
                        <td width="88%" style="min-width: 824px" class="TableHeadingRow2"><span class="m0l0iout">Remarks</span></td>
                    </tr>
                    <tr>
                        <td class="whitebg" style="padding-top:1px;" valign="top" align="center">
                            <html:text name="feserv06" property="noOfOriginal"  styleId="noOfOriginal" maxlength='2' style="width:30%; height:17px;" onblur="maskWithOutDecimal(this, 2, 2)" readonly="${isReadOnly}"/>
                        </td>
                        <td class="whitebg">
                            <!-- @05 BEGIN -->
                            <html:textarea name="feserv06" property="remarks"  styleId="remarks" cols="85" rows="7" readonly="${isReadOnly}" />
                            <%--html:textarea
                                name="feserv06"
                                property="remarks"
                                cols="85"
                                rows="7"
                                readonly="${isReadOnly}"
                                onkeyup="maxlenghtTextArea('remarks', 500)"
                                onclick="maxlenghtTextArea('remarks', 500)" /--%>
                            <!-- @05 END -->
                        </td>
                    </tr>
                    </table>
                </td>
            </tr>
            <tr><td style="height:20px"></td></tr>
            <tr>
                <td align="right">
                    <%--div class="spotlight-action" align="right" style="padding-top:20px;"--%>
                        <a id="previewDisabledBtn" class="m-btn sm rnd disabled"
                            href="javascript:void(0)">Preview Draft SI <i class="m-icon-swapup m-icon-white"></i>
                        </a> 
                        <a id="previewBtn" class="m-btn sm blue rnd"
                            href="javascript:void(0)" onClick="return getPDF()">Preview Draft SI <i class="m-icon-swapup m-icon-white"></i>
                        </a>
                        
                        <a id="saveDisabledBtn" class="m-btn sm rnd disabled"
                            href="javascript:void(0)">Save
                        </a> 
                        <a id="saveBtn" class="m-btn sm blue rnd"
                            href="javascript:void(0)" onClick="clearMsg(); saveDraftBtn()">Save
                        </a>
                        
                        <a id="submitDisabledBtn" class="m-btn sm rnd disabled"
                            href="javascript:void(0)">Submit SI <i class="m-icon-swapright m-icon-white"></i>
                        </a>
                        <logic:empty name="btnSubmitEsiDisp" scope="request">
                            <a id="submitBtn" class="m-btn sm green rnd" style="visiblity: visible"
                            href="javascript:void(0)" onClick="clearMsg(); submitBtn();" >Submit SI <i class="m-icon-swapright m-icon-white"></i>
                            </a>
                        </logic:empty>
                    <%--/div--%>
                </td>
            </tr>
            </table>
        </td>
    </tr>
    </table>
    <div id="cargoDescriptionDiv"  >
        <jsp:include page="../eshipping/EshippingCargoDescriptionPopup.jsp" />
    </div>
</html:form>
</body>
