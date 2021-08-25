<%--
-------------------------------------------------------------------------------------------------------------
EserviceNewWebBooking.jsp
-------------------------------------------------------------------------------------------------------------
Copyright RCL Public Co., Ltd. 2007
-------------------------------------------------------------------------------------------------------------  
Author vikas Verma 01/01/2013
- Change Log ------------------------------------------------------------------------------------------------
## DD/MM/YY      -User-          -TaskRef-         -ShortDescription-
## 11/07/2013                       02                change # in <a href> to javascript:void(0) for fix position
## 11/07/2013                       03                add get data default when select QTN
## 16/07/2013                       04                delete check QTN on POD , POL , size , type
## 16/07/2013                       05                add tooltip for show  Empty Pickup Depot Name
## 17/07/2013                       06                add logic for substring user name to show
## 31/07/2013                       07                disable save and submit button when click save or submit 
## 16/09/2013                       08                change decimal Gross Container Weight and  Gross Weight
## 06/01/2014     YOSSUN1           09                change display drop down list.
## 01/08/2014     PRATHA1           10                Eservice phase 3.1
## 24/10/2014     PRATHA1           11                PD_CR_20140826_ESV [Contract Party for registeration]
## 27/10/2014     PRATHA1           12                PD_CR_20141003_ESV [COC_SOC in eBKG]
-------------------------------------------------------------------------------------------------------------
--%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page import="com.niit.control.common.GlobalConstants" %>
<%@page import="com.niit.control.web.action.BaseAction" %>
<%@ page import="com.niit.control.web.UserAccountBean" %>
<%@page import="com.niit.control.common.StringUtil" %>

<%
    String lstrCtxPath     = request.getContextPath();
%>

<head>
<style type="text/css">
/*
select.center_pull {
    background:#eeeeee none repeat scroll 0 0;
    border:1px solid #7E7E7E;
    color:#333333;
    font-size:12px;
    margin-bottom:4px;
    margin-right:4px;
    margin-top:4px;
    width:145px;
}
*/
</style>
<script type="text/javascript">
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');
  ga('create', 'UA-39255240-1', 'rclgroup.com');
  ga('send', 'pageview');
</script>
<script type="text/javascript" language="JavaScript" src="<%=lstrCtxPath%>/js/screen/EserviceNewWebBooking.js" ></script>
<script type="text/javascript" language="JavaScript">
    var POPULATE_DEPENDENT_COMBOS
        = '<%=com.niit.control.web. JSPUtils.getActionMappingURL("/serv001ChangeCountryCode", pageContext)%>';
    var SAVE_BOOKING
        = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv001SaveBooking", pageContext)%>';
    var OPEN_ACKNOWLEDGEMENT
        = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv003", pageContext)%>';
    var COMMODITY_LOOKUP
        = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv004", pageContext)%>';
    var SAVE_TEMPLATE
        = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv001SaveTemplate", pageContext)%>';
    var GET_TEMPLATE_DATA
        = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv001GetTemplateData", pageContext)%>';
    var DEL_SIZE_TYPE_DATA
        = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv001delSizeType", pageContext)%>';
    var DEL_COMMODITY_DATA
        = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv001delCommodity", pageContext)%>';
    var CHECK_QTN
        = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv001CheckQuotation", pageContext)%>';
        //@03 BEGIN
    var GET_DATA_BT_QTN
        = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv001GetDefaultByQuotationNo", pageContext)%>';
        //@03 END
        
    var GET_BOOKING_NUMBER = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv002GetData", pageContext)%>';
    var CHECK_QTN_SIZE
        = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv001CheckQuotationSize", pageContext)%>';
    var SET_QUATATION_ROUTING_DATA
        = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv001SetQuotationRoutingData", pageContext)%>';
    
    var ADD_COMMODITY_DATA
        = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv001addCommodity", pageContext)%>';
    
    var UPD_COMMODITY_DATA
        = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv001updateCommodity", pageContext)%>';
    
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
        = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv001changeRateType", pageContext)%>';

    var ADD_SIZE_TYPE_DATA
        = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv001addSizeType", pageContext)%>';  
    
    var UPD_SIZE_TYPE_DATA
        = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv001updateSizeType", pageContext)%>';   
    
    var UPLOAD_ATTACHMENT
        = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv023", pageContext)%>'; 
    
    var GET_UPLOAD_ATTACHMENT
        = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv023getData", pageContext)%>';
    
    var GET_EQUIP_TYPE_LOOKUP_DATA     
        = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv028equipTypeLookUp", pageContext)%>';   
    
    /*Begin @11*/    
    var CHANGE_REP_COMP     
        = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv001ChangeRepComp", pageContext)%>';
    /*End @11*/
    
    var ON_LOAD
        = '<%=com.niit.control.web. JSPUtils.getActionMappingURL("/serv001", pageContext)%>';
    
</script>
</head>
<body>
    <html:form method="POST" action="/serv001">
    <%-----------------------------------hidden variables --%>
        <html:hidden name="feserv01" property="bookingNo"/>
        <html:hidden name="feserv01" property="status"/>
        <html:hidden name="feserv01" property="email"/>
        <html:hidden name="feserv01" property="saveOperationFlag"/>
        <html:hidden name="feserv01" property="openAcknowledgement"/>
        <html:hidden name="feserv01" property="customerCode"/>
        <html:hidden name="feserv01" property="customerName"/>
        <html:hidden name="feserv01" property="equipmentSeq"/>
        <html:hidden name="feserv01" property="commoditySeq"/>
        <html:hidden name="feserv01" property="commodityRowIndex"/>
        <html:hidden name="feserv01" property="line"/>
        <html:hidden name="feserv01" property="trade"/>
        <html:hidden name="feserv01" property="agent"/>
        <html:hidden name="feserv01" property="commodityGroup"/>
        <html:hidden name="feserv01" property="commodityGroupDetail"/>
        <html:hidden name="feserv01" property="newWebBookingErrMsg"/>
        <html:hidden name="feserv01" property="msgTooltip"/>
        <!--Begin @10 -->
        <html:hidden name="feserv01" property="deleleEqSizeType" styleId="deleleEqSizeType"/>
        <html:hidden name="feserv01" property="deleteCommod" styleId="deleteCommod"/>
        <html:hidden name="feserv01" property="commoditySeqNoTmp" styleId="commoditySeqNoTmp"/>
        <html:hidden name="feserv01" property="equipmentSeqNoTmp" styleId="equipmentSeqNoTmp"/>
        <html:hidden name="feserv01" property="uploadFlag" styleId="uploadFlag"/>
        <html:hidden name="feserv01" property="errMsg" styleId="errMsg"/>
        <html:hidden name="feserv01" property="rfTypeNormal" styleId="rfTypeNormal"/>
        <!--End @10 -->
        
        <%-- @09 BEGIN --%>
        <%--html:hidden name="feserv01" property="emptyPickupDepot"/>
        <html:hidden name="feserv01" property="placeOfReceipt"/>
        <html:hidden name="feserv01" property="portOfLoading"/>
        <html:hidden name="feserv01" property="portOfDischarge"/>
        <html:hidden name="feserv01" property="placeOfDelivery"/--%>
       <%-- @09 END --%>
       <div id="divBackground" style="position: absolute; top: 0px; left: 0px; background-color: black;
        z-index: 100; opacity: 0.8; filter: alpha(opacity=60); -moz-opacity: 0.8; overflow: hidden;
        display: none">
        </div> 
        
        
        <div class="TableLeftSubColor2">
            <h2>Booking Details </h2>
        </div>

        <%-- for line spacing
        <table style="margin:0; padding:0;" border="0">
            <tr><td></td></tr>
        </table>
        --%>
        
        <table class="table_search" border="0" width="100%" cellspacing="0" cellpadding="0">
            <tr>
                <td class="lableBackground">
                    Template
                </td>
                <td class="whitebg">
                    <html:select name="feserv01" property="template" styleId="template" size="1" onchange="onTemplateChange()">
                        <html:optionsCollection name="feserv01" value="code" label="name" property="templateValues"/>
                    </html:select>
                </td>
                <!--Begin @11 -->
                <td class="whitebg" colspan="3" align="left">
                    <html:checkbox name="feserv01" property="representCompChkBox" styleId="representCompChkBox" value="Y" style="border:0px;width:15px;height:15px;" onclick="lp_manageRepresentCompChkBox(2);" />&nbsp;
                    Represented Company :
                    <html:select name="feserv01" property="representComp" styleId="representComp" size="1" onchange="checkQuotationNo();">
                        <html:optionsCollection name="feserv01" value="code" label="name" property="representCompValues"/>
                    </html:select>
                </td>
                <!--End @11 -->
                <!--Begin @12 -->
                <td width="4%" class="lableBackground">
                    COC/SOC
                </td>
                <td width="15%" class="whitebg">
                    <html:select name="feserv01" property="socCocUserFlag" styleId="socCocUserFlag" size="1" onchange="checkQuotationNo();">
                        <html:optionsCollection name="feserv01" value="code" label="name" property="cocSocValues"/>
                    </html:select>
                </td>
                <!--End @12 -->
                <td width="4%" class="lableBackground">
                    Status
                </td>
                <td width="15%" class="whitebg">
                    <%-- html:text name="fe" property="status" maxlength='1' onblur="changeUpper(this)"  styleClass="rclDisabledTab" / --%>
                    <font class="displayText">
                        <bean:write name="feserv01" property="status" />
                    </font>
                </td>

            </tr>
            <tr>
                <td class="lableBackground">
                    Booking Number
                </td>
                <td class="whitebg">
                    <%--
                    <html:text name="feserv01" property="bookingNo" maxlength='17' onblur="changeUpper(this)"  styleClass="rclDisabledTab" />
                    --%>
                    <font class="displayText">
                        <bean:write name="feserv01" property="bookingNo"/>
                    </font>
                </td>
                <td width="8%" class="lableBackground">
                    Quotation Number
                </td>
                <td width="4%" class="lableBackground">&nbsp;</td>
                <td width="22%" class="whitebg">
                <!-- @03 BEGIN -->
                    <html:select name="feserv01" property="quotationNumber" size="1" onchange="getDataByQuotationNo();">
                        <html:optionsCollection name="feserv01" value="code" label="name" property="quotationNumberValues"/>
                    </html:select>
                    <a id="qtnInfo" href="javascript:void(0)" class="m-btn smallest blue rnd smallericn-only" onmouseover="showQuotationInfo()">
                        <i class="icon-info-sign icon-white"></i>
                    </a>                    
                </td>

                <!-- split shipment term to POL and POD -->
                <td width="10%" class="lableBackground">
                    POL Term
                </td>
                <td width="10%" class="whitebg">
                    <html:select name="feserv01" property="pol" size="1" >
                        <html:optionsCollection name="feserv01" value="code" label="name" property="polList"/>
                    </html:select>
                </td>
                <td width="10%" class="lableBackground">
                    POD Term
                </td>
                <td width="10%" class="whitebg">
                    <%-- html:text name="fe" property="status" maxlength='1' onblur="changeUpper(this)"  styleClass="rclDisabledTab" / --%>
                    <html:select name="feserv01" property="pod" size="1" >
                        <html:optionsCollection name="feserv01" value="code" label="name" property="podList"/>
                    </html:select>
                </td>
                <!-- end -->
              <%--  <td width="8%" class="lableBackground">
                    Shipment Term
                </td>
                <td width="13%" class="whitebg">
                    <html:select name="feserv01" property="shipmentTerm" size="1" >
                        <html:optionsCollection name="feserv01" value="code" label="name" property="shipmentTermValues"/>
                    </html:select>
                </td>
                <td width="4%" class="lableBackground">
                    Status
                </td>
                <td width="15%" class="whitebg">
                    <html:text name="fe" property="status" maxlength='1' onblur="changeUpper(this)"  styleClass="rclDisabledTab" />
                    <font class="displayText">
                        <bean:write name="feserv01" property="status" />
                    </font>
                </td> --%>
            </tr>
            <tr>
                <td class="lableBackground">
                    Customer Reference
                </td>
                <td class="whitebg">
                    <html:text name="feserv01" property="customerReference" maxlength='17' onblur="changeUpper(this)" />
                </td>
                <td class="lableBackground">
                    Email
                </td>
                <td class="lableBackground" >&nbsp;</td>
                <td class="whitebg">
                    <%-- <html:text name="feserv01" property="email" maxlength='80' onblur="changeUpper(this)" /> --%>
                    <font class="displayText">
                       <bean:write name="feserv01" property="email" /> 
                         <%//<html:text name="feserv01" property="email" onblur="validateEmail();" />%>
                    </font>
                </td>
                <td class="lableBackground">
                    Telephone
                </td>
                <td class="whitebg">
                    <html:text name="feserv01" property="telephone" maxlength='17' onblur="changeUpper(this);validateForm();" />
                </td>
                <td class="lableBackground">
                    Fax
                </td>
                <td class="whitebg">
                    <html:text name="feserv01" property="fax" maxlength='17' onblur="changeUpper(this)" />
                </td>
            </tr>
            <tr>
                <td width="9%" class="lableBackground">
                    Contact Person
                </td>
                <td class="whitebg" width="17%">
                <!-- @06 BEGIN -->
                    <html:text name="feserv01" property="contact" maxlength='25' style="width:80%" onblur="changeUpper(this)" styleClass="must"/>
                <!-- @06 END -->
                </td>
                <td colspan="2" class="lableBackground">
                    Additional Mail Recipients
                </td>
                <td colspan="5" >
                    <html:text name="feserv01" property="additionalMailRecipeints" maxlength='500' style="width:45%" onblur="validateEmail();"/>
                    &nbsp;&nbsp;(please key in multiple mail addresses separated by comma)
                </td>
            </tr>
        </table>
        <%-- for line spacing
        <table style="margin:0; padding:0;" border="0">
            <tr><td></td></tr>
        </table>
        --%>
        <div class="TableLeftSubColor2">
            <h2>Routing Details</h2>
        </div>

        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_search">
            <tr>
                <td width="15%" class="tableHeadingBlue">
                    <span class="m0l0iout">
                        Origin Country                    </span>                </td>
                <td width="15%" class="tableHeadingBlue">
                    <span class="m0l0iout">
                        Destination Country                    </span>                </td>
                <td width="13%" class="tableHeadingBlue" >
                    <span class="m0l0iout">
                        Place of Receipt                    </span>                </td>
                <td width="12%" class="tableHeadingBlue" >
                    <span class="m0l0iout">
                        &nbsp;                  </span>                </td>
                <td width="15%" class="tableHeadingBlue">
                    <span class="m0l0iout">
                        Port of Loading POL                    </span>                </td>
                <td width="15%" class="tableHeadingBlue">
                    <span class="m0l0iout">
                        Port of Discharge POD                    </span>                </td>
                <td width="15%" class="tableHeadingBlue">
                    <span class="m0l0iout">
                        Place of Delivery                    </span>                </td>
            </tr>
            <tr>
                <td class="tableHeadingSecondRow2Blue">
                    <span class="m0l0iout">
                        Empty Pickup Depot
                    </span>
                </td>
                <td class="tableHeadingSecondRow2Blue">
                    <span class="m0l0iout">
                        Empty Pickup Date
                    </span>
                </td>
                <td class="tableHeadingSecondRow2Blue">
                    <span class="m0l0iout">
                        <!--Shipment Date -->Cargo Availability Date                   </span>                </td>
                <td class="tableHeadingSecondRow2Blue">
                    <span class="m0l0iout">
                        <!--Shipment Date -->Expected Sailing Date                  </span>                </td>
                <td class="tableHeadingSecondRow2Blue">
                    <span class="m0l0iout">
                        Desired Arrival Date                    </span>                </td>
                <td class="tableHeadingSecondRow2Blue">
                    <span class="m0l0iout">
                        Routing                    </span>                </td>
                <td class="tableHeadingSecondRow2Blue">
                    <span class="m0l0iout">                    </span>                </td>
            </tr>
        </table>
        <%-- for line spacing --%>
        <table style="margin:0; padding:0;" border="0">
            <tr><td></td></tr>
        </table>

        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_search">
            <tr>
                <td class="tableColumnData" width="15%">
                    <html:select name="feserv01" property="originCountry" styleId="originCountry" size="1" styleClass="must" style="height:20px" onchange="onCountryChange()" >
                        <html:optionsCollection name="feserv01" value="code" label="name" property="originCountryValues" />
                    </html:select>
                </td>
                <td class="tableColumnData" width="15%">
                    <html:select name="feserv01" property="destinationCountry" styleId="destinationCountry" size="1" styleClass="must" style="height:20px" onchange="onCountryChange()">
                        <html:optionsCollection name="feserv01" value="code" label="name" property="destinationCountryValues" />
                    </html:select>                </td>
                <td class="tableColumnData" width="13%">
                    <%-- @09 BEGIN --%>
                    <html:select name="feserv01" property="placeOfReceipt" styleId="placeOfReceipt" size="1" onchange="checkQuotationNo();">
                        <html:optionsCollection name="feserv01" property="placeOfReceiptValues" value="code" label="name" />
                    </html:select>
                    <!-- @05 BEGIN -->
                    <%--select name="selPlaceOfReceipt" size="1" onchange="assignValuePLR();" id="selPlaceOfReceipt">
                        <logic:iterate name="feserv01" id="lstPLR" property="placeOfReceiptValues">
                        <p>
                            <option value="<bean:write name="lstPLR" property="code"/>" title="<bean:write name="lstPLR" property="name"/>"><bean:write name="lstPLR" property="name"/></option>
                            
                        </p>
                        </logic:iterate>
                    </select--%>
                    <!-- @05 END -->
                    <%-- @09 END --%>
                    </td>
                <td class="tableColumnData" width="12%">
                    &nbsp; </td>
                
                <td class="tableColumnData" width="15%">
                    <%-- @09 BEGIN --%>
                    <html:select name="feserv01" property="portOfLoading" styleId="portOfLoading" size="1" onchange="checkQuotationNo();">
                        <html:optionsCollection name="feserv01" property="portOfLoadingValues" value="code" label="name" />
                    </html:select>
                    <!-- @05 BEGIN -->
                    <%--select name="selPortOfLoading" size="1" class="must" style="height: 20px" onchange="assignValuePOL();">
                        <logic:iterate name="feserv01" id="lstPOL" property="portOfLoadingValues" >
                        <p>
                            <option value="<bean:write name="lstPOL" property="code"/>" title="<bean:write name="lstPOL" property="name"/>"><bean:write name="lstPOL" property="name"/></option>
                            
                        </p>
                        </logic:iterate>
                    </select--%>
                    <!-- @05 END -->
                    <%-- @09 END --%>
                </td>
                <td class="tableColumnData" width="15%">
                    <%-- @09 BEGIN --%>
                    <html:select name="feserv01" property="portOfDischarge" styleId="portOfDischarge" size="1" onchange="checkQuotationNo();">
                        <html:optionsCollection name="feserv01" property="portOfDischargeValues" value="code" label="name" />
                    </html:select>
                    <!-- @05 BEGIN -->
                    <%--select name="selPortOfDischarge" size="1" class="must" style="height: 20px" onchange="assignValuePOD();">
                        <logic:iterate name="feserv01" id="lstPOD" property="portOfDischargeValues" >
                        <p>
                            <option value="<bean:write name="lstPOD" property="code"/>" title="<bean:write name="lstPOD" property="name"/>"><bean:write name="lstPOD" property="name"/></option>
                            
                        </p>
                        </logic:iterate>
                    </select--%>
                    <!-- @05 END -->
                    <%-- @09 END --%>
                </td>
                
                <td class="tableColumnData" width="15%">
                    <%-- @09 BEGIN --%>
                    <html:select name="feserv01" property="placeOfDelivery" size="1" onchange="checkQuotationNo();">
                        <html:optionsCollection name="feserv01" property="placeOfDeliveryValues" value="code" label="name" />
                    </html:select>
                    <!-- @05 BEGIN -->
                    <%--select name="selPlaceOfDelivery" size="1" onchange="assignValuePLD();" id="selPlaceOfDelivery">
                        <logic:iterate name="feserv01" id="lstPLD" property="placeOfDeliveryValues">
                        <p>
                            <option value="<bean:write name="lstPLD" property="code"/>" title="<bean:write name="lstPLD" property="name"/>"><bean:write name="lstPLD" property="name"/></option>
                            
                        </p>
                        </logic:iterate>
                    </select--%>
                    <!-- @05 END -->
                    <%-- @09 END --%>
                </td>
            </tr>
            <tr>
                <td class="tableColumnData" id="tol"  width="15%"  >
                    <%-- @09 BEGIN --%>
                    <html:select name="feserv01" property="emptyPickupDepot" size="1" onchange="checkQuotationNo();">
                        <html:optionsCollection name="feserv01" property="emptyPickupDepotValues" value="code" label="name" />
                    </html:select>
                    <!-- @05 BEGIN -->
                    <%--select name="selEmptyPickupDepot" onmouseover="showEmptyPickDepotName(this)" onchange="assignValue();" size="1">
                        <logic:iterate name="feserv01" id="lstEmptyDepot" property="emptyPickupDepotValues">
                        <p>
                            <option value="<bean:write name="lstEmptyDepot" property="code"/>" title="<bean:write name="lstEmptyDepot" property="name"/>"><bean:write name="lstEmptyDepot" property="name"/></option>
                            
                        </p>
                        </logic:iterate>
                    </select--%>
                    <!-- @05 END -->
                    <%-- @09 END --%>
                    </td>
                <td class="tableColumnData" width="15%">
                    <html:text
                        name="feserv01"
                        property="emptyPickupDate"
                        styleId="emptyPickupDate"
                        style="width:49%"
                        maxlength='10'
                        onblur="gp_checkDate(this);"
                        styleClass="dateForm"/>

                    <a href="javascript:void(0)" class="m-btn smallest blue rnd smallericn-only" onClick="gp_calendar('emptyPickupDate')">
                        <i class="icon-calendar icon-white"></i></a>
                </td>
                <td class="tableColumnData" width="13%">
                    <html:text
                        name="feserv01"
                        property="shipmentDate"
                        styleId="shipmentDate"
                        style="width:53%"
                        styleClass="dateFormMust"
                        maxlength='10'
                        onblur="gp_checkDate(this);"/>

                    <a href="javascript:void(0)" class="m-btn smallest blue rnd smallericn-only" onClick="gp_calendar('shipmentDate')">
                        <i class="icon-calendar icon-white"></i></a>
                </td>
                <td class="tableColumnData" width="12%">
                    <html:text
                        name="feserv01"
                        property="sailingDate"
                        styleId="sailingDate"
                        style="width:53%"
                        maxlength='10'
                        onblur="gp_checkDate(this);"
                        styleClass="dateForm"/>

                    <a href="javascript:void(0)" class="m-btn smallest blue rnd smallericn-only" onClick="gp_calendar('sailingDate')">
                        <i class="icon-calendar icon-white"></i></a>
                </td>
                <td class="tableColumnData" width="15%">
                    <html:text
                        name="feserv01"
                        property="desiredArrivalDate"
                        styleId="desiredArrivalDate"
                        style="width:53%"
                        maxlength='10'
                        onblur="gp_checkDate(this);"
                        styleClass="dateForm"/>

                    <a href="javascript:void(0)" class="m-btn smallest blue rnd smallericn-only" onClick="gp_calendar('desiredArrivalDate')">
                        <i class="icon-calendar icon-white"></i></a>
                </td>
                <td colspan="2" class="tableColumnData" width="15%">
                   <!-- <div class="spotlight-action">class="m-btn mini blue rnd" -->
                        <a class="m-btn mini blue rnd"
                            href="javascript:void(0)"
                            id="btnRoutingInfo"
                            onclick="return routingInfoButton()"><i class="icon-search icon-white"></i>&nbsp;View Schedule </a>
                            <!-- change name "Routing Info" to "View Schedule" 29/05/2013-->
                            
                    <!-- </div> -->
               <!-- </td> -->
                
               <!-- <td class="tableColumnData"> style="float:left;border:0px;width:10%"  -->
                    <html:checkbox name="feserv01" property="rclArrangementChkBox" style="border:0px;width:10%" disabled="true"/>
                    (<span style="color: #ff0000">as per RCL arrangement</span>)                </td>
            </tr>
            <tr>
                <td colspan="6">&nbsp;</td>
                <!-- td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td -->
            </tr>
            <tr>
                <td colspan="6">&nbsp;</td>
            </tr>
        </table>

        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_search">
            <tr>
                <td width="99%" class="tableHeadingSecondRow2Blue"><span class="tableHeaderLeftAlign">Routing Preference (5 Lines Maximum) </span></td>
            </tr>
        </table>
        <%-- for line spacing --%>
        <table style="margin:0; padding:0;" border="0">
            <tr><td></td></tr>
        </table>

        <table width ="50%" border="0" class="table_search">
            <tr>
                <td rowspan="4" width="50%">
                    <html:textarea
                        name="feserv01"
                        property="routingPreference"
                        cols="50"
                        rows="5"
                        styleClass="Combo"
                        onkeyup="maxlenghtTextArea('routingPreference', 500)"
                        onclick="maxlenghtTextArea('routingPreference', 500)"/>
                </td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td>
                    <div class="ReportData4">  
                        <i>(please state routing preference if any.)</i>
                    </div>
                </td>
            </tr>
    </table>
        <%-- for line spacing --%>
        <table style="margin:0; padding:0;" border="0">
            <tr><td></td></tr>
        </table>

        <div class="TableLeftSubColorNoBorder">
            <h2>Equipment Details</h2>
        </div>
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_search">
            <tr>
                <td width="3%" class="tableHeadingBlue"><span class="m0l0iout">#</span></td>
                <td width="18%" class="tableHeadingBlue"><span class="m0l0iout">Type</span></td>
                <td width="5%" class="tableHeadingBlue"><span class="m0l0iout">Size</span></td>
                <td width="8%" class="tableHeadingBlue"><span class="m0l0iout">Cargo Type </span></td>
                <td width="7%" class="tableHeadingBlue"><span class="m0l0iout">Laden</span></td>
                <td width="7%" class="tableHeadingBlue"><span class="m0l0iout">Empty</span></td>
                <td width="18%" class="tableHeadingBlue"><span class="m0l0iout">Cargo + Container Wt. (KG)</span></td>
                <td width="13%" class="tableHeadingBlue"><span class="m0l0iout">POL Status </span></td>
                <td width="13%" class="tableHeadingBlue"><span class="m0l0iout">POD Status </span></td>
                <td width="8%" class="tableHeadingBlue"><span class="m0l0iout">Select</span></td>
            </tr>
        </table>
        <%-- for line spacing --%>
        <table style="margin:0; padding:0;" border="0">
            <tr><td></td></tr>
        </table>
        <div id="search_result" class="search_result" style="height:30px;overflow:auto;">
            <table id="result_dtl" class="table_results"  border="0" cellpadding="0" cellspacing="0">
        <%  int count = 1;  %>
        <logic:iterate name='feserv01' property='equipmentVoDataList' indexId='ctr' id='rowdata'
        type='com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceEquipmentDetailsMod'>        
            <logic:notEqual name="rowdata"  property="eqRecordStatus" value="DEL">
                <tr>
                    <td width="3%">
                        <%=count%>
                    </td>
                    <!-- @04 BEGIN -->
                  <td width="18%">
                        <html:hidden name="rowdata" property='type' styleId='<%= "type" + ctr %>' />
                        <html:text  name="rowdata" 
                                    property='typeDesc' 
                                    styleId='<%= "typeDesc" + ctr %>' 
                                    styleClass="must" 
                                    readonly="true"
                                    style="width:180px"  />
                        <a name="btnTypeLookup" class="m-btn smallest blue rnd smallericn-only" href="javascript:void(0)"
                            onclick='openEquipTypeLookup(this);'>
                            <i class="icon-search icon-white"></i>
                        </a> 
                  </td>
                    <td width="5%">
                        <html:select name="rowdata" property='size' styleId='<%= "size" + ctr %>'
                        onchange="updateSizeTypeRecStatus(this);"
                        size="1" style="width:60px" >
                            <html:optionsCollection name="feserv01" value="code" label="name" property="sizeValues"/>
                        </html:select>
                  </td>
                  <!-- @04 END -->
                    <td width="8%">
                        <html:select name="rowdata" property='cargoType' styleId='<%= "cargoType" + ctr %>' onchange="lp_onChangeCargoType(this);" size="1" style="width:80px">
                            <html:optionsCollection name="feserv01" value="code" label="name" property="cargoTypeValues"/>
                        </html:select>
                  </td>
                  <td width="7%">
                        <html:text name="rowdata" property='laden' styleId='<%= "laden" + ctr %>' maxlength='4' onblur="maskWithOutDecimal(this, 4, 2);updateSizeTypeRecStatus(this);" styleClass="must" style="width:70px"/>
                  </td>
                  <td width="7%">
                        <logic:equal name="rowdata" property="cargoType" value="N">
                            <html:text name="rowdata" property='mt' styleId='<%= "mt" + ctr %>' maxlength='4' onblur="maskWithOutDecimal(this, 4, 2);updateSizeTypeRecStatus(this);" styleClass="must"  style="width:70px"/>
                        </logic:equal>
                        <logic:notEqual name="rowdata" property="cargoType" value="N">
                            <html:text name="rowdata" property='mt' styleId='<%= "mt" + ctr %>' maxlength='4' readonly="true" onblur="maskWithOutDecimal(this, 4, 2);updateSizeTypeRecStatus(this);" styleClass="must"  style="width:70px"/>
                        </logic:notEqual>
                  </td>
                  <td width="18%">
                  <!-- @08 BEGIN putMask_NumberEX(this, 15, 3)-->
                        <html:text name="rowdata" property='grossContainerWeight' styleId='<%= "grossContainerWeight" + ctr %>' maxlength='17' onblur="putMask_NumberEX(this, 14, 2);updateSizeTypeRecStatus(this);" onclick="hideMask_Number(this);" styleClass="must" style="width:195px"/>
                  <!-- @08 END -->
                  </td>
                  <td width="13%">
                        <logic:equal  name="feserv01" property="socCocUserFlag" value="S">
                            <!-- change to drop down 28/05/2013-->     
                            <html:select name="rowdata" property='polStatus' styleId='<%= "polStatus" + ctr %>' onblur='updateSizeTypeRecStatus(this);' size="1" style="height=20px;width:60px">
                                <html:optionsCollection name="feserv01" value="code" label="name" property="polStatusList"/>
                            </html:select>
                        </logic:equal>
                        <!-- add drop down 28/05/2013-->
                        <logic:equal  name="feserv01" property="socCocUserFlag" value="C">
                        
                              
                            <html:select name="rowdata" property='polStatus' styleId='<%= "polStatus" + ctr %>' onblur='updateSizeTypeRecStatus(this);' size="1" style="height=20px;width:60px" disabled="true">
                                <html:optionsCollection name="feserv01" value="code" label="name" property="polStatusList"/>
                            </html:select>
                            
                              
                        </logic:equal>
                  </td>
                  <td width="13%">
                        <logic:equal  name="feserv01" property="socCocUserFlag" value="S">
                            <!-- change to drop down 28/05/2013-->     
                            <html:select name="rowdata" property='podStatus' styleId='<%= "podStatus" + ctr %>' onblur='updateSizeTypeRecStatus(this);' size="1" style="height=20px;width:60px" >
                                <html:optionsCollection name="feserv01" value="code" label="name" property="podStatusList"/>
                            </html:select>
                        </logic:equal>
                        <!-- add drop down 28/05/2013-->
                        <logic:equal  name="feserv01" property="socCocUserFlag" value="C">
                          
                            <html:select name="rowdata" property='podStatus' styleId='<%= "podStatus" + ctr %>' onblur='updateSizeTypeRecStatus(this);' size="1" style="height=20px;width:60px" disabled="true">
                                <html:optionsCollection name="feserv01" value="code" label="name" property="podStatusList"/>
                            </html:select>
                           
                        </logic:equal>
                  </td>
                  <td width="8%">
                      <%
                        if(count == 1){
                      %>
                        <html:hidden name='rowdata' property='eqRecordStatus' styleId='<%= "eqRecordStatus" + ctr %>' />
                        <html:hidden name='rowdata' property='eqSeqNo' styleId='<%= "eqSeqNo" + ctr %>' />    
                        &nbsp;
                     
                     <%}else{%>
                         <html:checkbox name="rowdata" property='equipmentSelectChkBox' styleId='<%= "equipmentSelectChkBox" + ctr %>' value="Y" style="border:0px;width:20%" />
                         <html:hidden name='rowdata' property='eqRecordStatus' styleId='<%= "eqRecordStatus" + ctr %>' />
                         <html:hidden name='rowdata' property='eqSeqNo' styleId='<%= "eqSeqNo" + ctr %>' />    
                     <%}
                        count++;
                     %>
                  </td>
                </tr>
            </logic:notEqual>
        </logic:iterate>
            </table>
        </div>
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_search">
            <tr>
                <td colspan="5" >&nbsp;</td>
                <td colspan="2" align="right">
                    <div class="spotlight-action">
                    <!-- @02 BEGIN -->
                        <a class="m-btn mini blue rnd"
                            href="javascript:void(0)" onClick="return addEquipment()">
                                <i class="icon-plus icon-white"></i>&nbsp;Add Equipment
                        </a>
                        <a class="m-btn mini red rnd"
                            href="javascript:void(0)" onClick="return deleteEquipment()">
                                <i class="icon-trash icon-white"></i>&nbsp;Delete Equipment
                        </a>
                        <!-- @02 END -->
                    </div>
                    &nbsp;
                    &nbsp;
                    &nbsp;
                </td>
                <!-- <td>&nbsp;3</td> -->
            </tr>
        </table>

        <%-- for line spacing --%>
        <table style="margin:0; padding:0;" border="0">
            <tr><td></td></tr>
        </table>
        <div class="TableLeftSubColorNoBorder">
            <h2>Cargo Description</h2>
        </div>
        <%-- for line spacing --%>
        <table style="margin:0; padding:0;" border="0">
            <tr><td></td></tr>
        </table>
<!--
        <div>
            <html:textarea
                name="feserv01"
                property="cargoDescription"
                cols="50"
                rows="5"
                styleClass="ComboMust"
                onkeyup="maxlenghtTextArea('cargoDescription', 500)"
                onclick="maxlenghtTextArea('cargoDescription', 500)" />
        </div>
-->

        <table width ="50%" border="0" class="table_search">
            <tr>
                <td rowspan="4" width="100%">
                    <html:textarea
                        name="feserv01"
                        property="cargoDescription"
                        cols="50"
                        rows="5"
                        styleClass="ComboMust"
                        onblur='updateSizeTypeRecStatus(this);'
                        onkeyup="maxlenghtTextArea('cargoDescription', 500)"
                        onclick="maxlenghtTextArea('cargoDescription', 500)" />

                </td>
            </tr>
        </table>
        <%-- for line spacing --%>
        <table style="margin:0; padding:0;" border="0">
            <tr><td></td></tr>
        </table>

        <div class="TableLeftSubColorNoBorder">
            <h2>Commodity Details</h2>
        </div>
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_search">
            <tr>
                <td width="4%" class="tableHeadingBlue">&nbsp;</td>
                <td width="4%" class="tableHeadingBlue"><span class="m0l0iout">#</span></td>
                <td width="15%" class="tableHeadingBlue"><span class="m0l0iout">Commodity Group</span></td>
                <td width="20%" class="tableHeadingBlue">&nbsp;</td>
                <td width="15%" class="tableHeadingBlue"><span class="m0l0iout">Gross Weight </span></td>
                <td width="13%" class="tableHeadingBlue"><span class="m0l0iout">Special Cargo </span></td>
                <!--Begin @10 -->
                <td width="16%" class="tableHeadingBlue"><span class="m0l0iout">Rate Type </span></td>
                <!--End @10 -->
                <td width="13%" class="tableHeadingBlue"><span class="m0l1iover">Select</span></td>
            </tr>
        </table>

        <%-- for line spacing --%>
        <table style="margin:0; padding:0;" border="0">
            <tr><td></td></tr>
        </table>

        <div id="comm_search_result" class="search_result" style="height:30px">
            <table id="comm_result_dtl" class="table_results" border="0" cellpadding="0" cellspacing="0">
        <%
            int countCommo = 0;            
            //COMMODITY_SELECT
        %>
        <logic:iterate name='feserv01' property='commodityVoDataList' indexId='ctr' id='rowdata'
            type='com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceCommodityDetailsMod'>            
            <logic:notEqual name="rowdata"  property="recordStatus" value="DEL">
                <tr>
                    <td width="4%" class="tableColumnData">
                        <html:radio name="rowdata"  property="radCommodity" styleId='<%= "radCommodity" + ctr %>'  value="<%=ctr.toString()%>" style="border:0px;width:100%"  onclick="displaySpecialIns()"/>
                    </td>
                    <td width="4%" class="tableColumnData" align="center">
                        <%=countCommo+1%>                               
                    </td>
                    <td width="15%" class="tableColumnData">                        
                        <input type="hidden" name="posObjectCommod" id='posObjectCommod<%=ctr%>' value="<%=ctr%>" />
                        <html:hidden name='rowdata' property='seqNo' styleId='<%= "seqNo" + ctr %>' /> 
                        
                        <html:text name="rowdata"
                            property='group'
                            styleId='<%= "group" + ctr %>'
                            style="width:80%"
                            maxlength='1'
                            readonly="true"
                            onblur='updateCommodityRecStatus(this);changeUpper(this);'
                            styleClass="must"/>
                    </td>
                    <td width="20%" class="tableColumnData" style="white-space: nowrap;">
                        <html:text name="rowdata" property='description' styleId='<%= "description" + ctr %>' style="width:80%" maxlength='1' onblur="changeUpper(this)" readonly="true" />
                        <a name="btnCommodityGroupLookup" class="m-btn smallest blue rnd smallericn-only" href="javascript:void(0)"
                            onclick='openCommodityGroupLookup(this);'>
                            <i class="icon-search icon-white"></i>
                        </a>  
                    </td>
                    <!-- @08 BEGIN putMask_NumberEX(this, 15, 3)-->
                    <td width="15%" class="tableColumnData">
                        <html:text name="rowdata"
                        property='grossWeight'
                        styleId='<%= "grossWeight" + ctr %>'
                        style="width:80%"
                        maxlength='17'
                        onblur='updateCommodityRecStatus(this);putMask_NumberEX(this, 14, 2);'
                        onclick="hideMask_Number(this);" />
                    </td>
                    <!-- @08 END -->
                    <td width="13%" class="tableColumnData">
                        <html:checkbox name="rowdata" property='specialCargo' value="Y" styleId='<%= "specialCargo" + ctr %>' onclick='lp_onChangeRateType();displaySpecialIns();updateCommodityRecStatus(this);' style="border:0px;width:10%;" />
                    </td>
                    <!--Begin @10 -->
                    <td width="16%" class="tableColumnData" style="white-space: nowrap;">
                        <html:select name="rowdata" property="rateType" size="1" onchange="lp_onChangeRateType();updateCommodityRecStatus(this);">
                            <html:optionsCollection name="feserv01" value="code" label="name" property="rateTypeValues"/>
                        </html:select>
                        <a class="<%=rowdata.getRateTypeClassName()%>" href="javascript:void(0)" name="btnRateTypeDetails"  onClick="openRateTypeLookUp();">
                            <i class="icon-plus icon-white"></i>
                        </a>
                    </td>
                    <!--End @10 -->
                    <td width="13%" class="tableColumnData">
                        <%
                        if(countCommo == 0){
                      %>
                        <html:hidden name='rowdata' property='recordStatus' styleId='<%= "recordStatus" + ctr %>' />                  
                        &nbsp;                     
                     <%}else{%>
                         <html:checkbox name="rowdata" property='isSelected' styleId='<%= "isSelected" + ctr %>' style="border:0px;width:10%;" value="Y" />
                         <html:hidden name='rowdata' property='recordStatus' styleId='<%= "recordStatus" + ctr %>' />
                     <%}
                        countCommo++;
                     %>
                     <html:hidden name="rowdata" property="rateTypeFlag" styleId='<%= "rateTypeFlag" + ctr %>' />
                    </td>
                </tr>
            </logic:notEqual>
        </logic:iterate>
            </table>
        </div>
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_search">
            <tr>
                <td colspan="5" >&nbsp;</td>
                <td colspan="2" align="right">
                    <div class="spotlight-action">
                    <!-- @02 BEGIN -->
                        <a class="m-btn mini blue rnd"
                            href="javascript:void(0)" onClick="return addCommodity()">
                                <i class="icon-plus icon-white"></i>&nbsp;Add Commodity
                        </a>
                        <a class="m-btn mini red rnd"
                            href="javascript:void(0)" onClick="return deleteCommodity()">
                                <i class="icon-trash icon-white"></i>&nbsp;Delete Commodity
                        </a>
                    <!-- @02 END -->
                    </div>
                    &nbsp;
                    &nbsp;
                    &nbsp;
                </td>
                <!-- <td>&nbsp;3</td> -->
            </tr>
        </table>


        <%--
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_search">

            <tr>
                <td width="4%" class="tableColumnData">
                    <html:radio name="feserv01" property="commodityRadio" value="COMMODITY_SELECT" style="border:0px;width:100%"  />
                </td>
                <td width="4%" class="tableColumnData" align="center">
                    <bean:write name="feserv01" property="commoditySeq" />
                </td>
                <td width="15%" class="tableColumnData">
                    <html:text name="feserv01" property="commodityGroup" style="width:80%" maxlength='1' onblur="changeUpper(this)" styleClass="must"/>
                </td>
                <td width="20%" class="tableColumnData">
                    <html:text name="feserv01" property="commodityGroupDetail" style="width:80%" maxlength='1' onblur="changeUpper(this)" />
                    <input type="button" value=". . ." name="btnCommodityGroupLookup" class="btnbutton" onclick='return openCommodityGroupLookup()'/>
                </td>
                <td width="15%" class="tableColumnData">
                    <html:text name="feserv01" property="grossWeight" maxlength='15' onblur="maskWithOutDecimal(this, 15, 2)" onclick="hideMask_Number(this);" />
                </td>
                <td width="13%" class="tableColumnData">
                    <html:checkbox name="feserv01" property="specialCargoChkBox" style="border:0px;width:10%" />
                </td>
                <td width="29%" class="tableColumnData">
                    <html:checkbox name="feserv01" property="commoditySelectChkBox" style="border:0px;width:10%" />
                </td>

            </tr>
            <tr>
                <td colspan="5" >&nbsp;</td>
                <!-- td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td -->
                <td colspan="2" align="right">
                    <div class="spotlight-action">
                        <a class="m-btn mini blue rnd"
                            href="#" onClick="return addCommodity()">
                                <i class="icon-plus icon-white"></i>&nbsp;Add Commodity
                        </a>
                        <a class="m-btn mini red rnd"
                            href="#" onClick="return deleteEquipment()">
                                <i class="icon-trash icon-white"></i>&nbsp;Delete Commodity
                        </a>
                    </div>
                    <%--
                    <input
                        type="button"
                        value="Add Commodity"
                        id="btnAddCommodity"
                        name="AddCommodity"
                        class="event_btnbutton"
                        onclick="return addCommodity()"/>
                    &nbsp;
                     <input
                        type="button"
                        value="Delete Equipment"
                        id="btnDeleteEquipment"
                        name="Delete Equipment"
                        class="event_btnbutton"
                        onclick="return deleteEquipment()"/>
                    &nbsp;
                    &nbsp;
                    &nbsp;
                </td>
                <!-- <td>&nbsp;3</td> --
            </tr>
        </table>
        --%>
        <%-- for line spacing --%>
        <table style="margin:0; padding:0;" border="0">
            <tr><td></td></tr>
        </table>
        
        <div class="TableLeftSubColorNoBorder">
            <h2>Special Instruction (5 Lines Maximum)</h2>
        </div>
        <%-- for line spacing --%>
        <table style="margin:0; padding:0;" border="0">
            <tr><td></td></tr>
        </table>
<!--
        <div>
            <html:textarea
                name="feserv01"
                property="specialInstruction"
                cols="50"
                rows="5"
                styleClass="Combo"
                onkeyup="maxlenghtTextArea('specialInstruction', 400)"
                onclick="maxlenghtTextArea('specialInstruction', 400)"/>
        </div>
        -->
        <table width ="100%" border="0" class="table_search" id="tableSI" style="height: 96px;">       
            <logic:iterate
                name='feserv01'
                property='commodityVoDataList'
                indexId='ctr'
                id='rowdata'
                type='com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceCommodityDetailsMod'>
                <logic:notEqual name="rowdata"  property="recordStatus" value="DEL">
                    <tr>
                        <td>
                            <html:textarea
                                name="rowdata"
                                property='specialInstruction'
                                styleId='<%="specialInstruction" + ctr %>'
                                cols="50"
                                rows="5"
                                styleClass="Combo"
                                onblur="updateCommodityRecStatus(this);"
                                onkeyup="maxlenghtTextArea(this, 400)"
                                onclick="maxlenghtTextArea(this, 400)"/>
                        </td>
                    </tr>
                    </logic:notEqual>
            </logic:iterate> 
        </table>

        <br/>
        <table class="table_search" border="0" width="100%" cellspacing="0" cellpadding="0">
            <tr>
                <td width="40%" colspan="2">&nbsp;</td>
                <td width="25%" align="right">Enter/Edit Template name</td>
                <td  width="35%" class="whitebg" align="center">
                    <html:text name="feserv01" property="templateName" styleId="templatename" maxlength='17' onblur="changeUpper(this)" style="width:90%"/>
                </td>
                
                <!-- <td width="25%">&nbsp;</td> -->
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td  colspan="3" align="right">
                    <%-- @07 BEGIN
                    --%>
                    <div class="spotlight-action" id="showButton" style="display:inline;">
                        <a class="m-btn sm blue rnd"
                            href="javascript:void(0)" onClick="return uploadAttachment();">
                                Upload Document
                            <i class="m-icon-swapup m-icon-white"></i>
                        </a>
                        <a class="m-btn sm blue rnd"
                            href="javascript:void(0)" onClick="return saveBooking(MODE_SAVE_DRAFT);">
                                Save as template
                            <i class="m-icon-swapdown m-icon-white"></i>
                        </a>
                        <a class="m-btn sm green rnd"
                            href="javascript:void(0)" onClick="return saveBooking(MODE_SAVE_BOOKING);">
                                Submit Booking
                            <i class="m-icon-swapright m-icon-white"></i>
                        </a>
                    </div>
                    <div class="spotlight-action" id="hideButton" style="display:none;">
                        <a class="m-btn sm blue rnd"
                            href="javascript:void(0)" onClick="return uploadAttachment();">
                                Upload Document
                            <i class="m-icon-swapup m-icon-white"></i>
                        </a>
                        <a class="m-btn sm rnd disabled"
                            href="javascript:void(0)" >
                                Save as template
                            <i class="m-icon-swapdown m-icon-white"></i>
                        </a>
                        <a class="m-btn sm rnd disabled"
                            href="javascript:void(0)" >
                                Submit Booking 
                            <i class="m-icon-swapright m-icon-white"></i>
                        </a>
                    </div>
                    <%--
                    @07 END --%>
                    &nbsp;
                    &nbsp;
                </td>
            </tr>
            <tr>
              <td colspan="2">&nbsp;</td>
              <td  colspan="3" align="center">
                <%--
                <i>
                    (Maximum 2MB)
                </i>
                --%>
            </td>
            </tr>
            <tr>
              <td colspan="2">&nbsp;</td>
              <td  colspan="3" align="center">
                <%--
                <i>
                    (Maximum 2MB)
                </i>
                --%>
            </td>
            </tr>
            <!-- @01 add checkbox for submit ESI -->
            <tr>
                <td width="40%" colspan="2">&nbsp;</td>
                <td width="25%" align="right"></td>
                <td  width="35%" class="whitebg" align="right">
                Will submit eShipping Instruction. &nbsp;
                    <html:checkbox name="feserv01" property="rclArrangementChkBox" style="border:0px;width:10%"/>
                </td>
                
                <!-- <td width="25%">&nbsp;</td> -->
            </tr>
            
            <!-- @01 END -->
            
        </table>

    </html:form>
    <br>
</body>
