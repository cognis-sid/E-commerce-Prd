<%--
-------------------------------------------------------------------------------------------------------------
EserviceInquiryWebBooking.jsp
-------------------------------------------------------------------------------------------------------------
Copyright RCL Public Co., Ltd. 2007
-------------------------------------------------------------------------------------------------------------  
Author vikas Verma 01/01/2013
- Change Log ------------------------------------------------------------------------------------------------
## DD/MM/YY      -User-          -TaskRef-         -ShortDescription-
## 01/08/2014     PRATHA1           01                Eservice phase 3.1
## 27/10/2014     PRATHA1           02                PD_CR_20140826_ESV [Contract Party for registeration]
## 27/10/2014     PRATHA1           03                PD_CR_20141003_ESV [COC_SOC in eBKG]
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
<%@page import="com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceInquiryWebBookingDao" %>
<%
    String lstrCtxPath     = request.getContextPath();
%>

<head>
    <!-- add screen specific JavaScript file -->
    <script language="JavaScript" src="<%=lstrCtxPath%>/js/common/Constants.js" ></script>

    <script language="JavaScript" src="<%=lstrCtxPath%>/js/RutHelp.js" ></script>
    
    <!-- add javascript file for this screen -->
    <script language="JavaScript" src="<%=lstrCtxPath%>/js/screen/EserviceInquiryWebBooking.js?id=<%=new Date() %>" ></script>
    
    <script language="JavaScript">
        var BROWSE_BOOKING_NUMBER                   = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv002BrowseBookingNumber", pageContext)%>';
        var GET_BOOKING_NUMBER_TO_WEBBOOKING_PAGE   = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv002GetData", pageContext)%>';
        var NEW_WEBBOOKING_PAGE                     = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv001", pageContext)%>';
        
        /*Begin @01*/
        var REFER_COMMODITY_GET_DATA                = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv019getData", pageContext)%>';
        var DG_COMMODITY_GET_DATA                   = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv020getData", pageContext)%>';
        var OOG_COMMODITY_GET_DATA                  = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv021getData", pageContext)%>';
        var GET_UPLOAD_ATTACHMENT                   = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv023getData", pageContext)%>';
        /*End @01*/
        
    </script>
    
    <script language="JavaScript">
      (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
      (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
      m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
      })(window,document,'script','//www.google-analytics.com/analytics.js','ga');
      ga('create', 'UA-39255240-1', 'rclgroup.com');
      ga('send', 'pageview');
    </script>
</head>

<body>    
    <html:form method="POST" action="/serv002">
        <html:hidden name="feserv03" property="notFound" />
        <html:hidden name="feserv03" property="firstCheckedCommodity"  />
        <div class="TableLeftSubColor2">
            <h2>Booking Details </h2>
        </div>
        <table class="table_search" border="0" width="100%" cellspacing="0" cellpadding="0" style="table-layout: fixed;">
            <colgroup>
                <col width="12%">
                <col width="16%">
                <col width="14%">
                <col width="14%">
                <col width="10%">
                <col width="12%">
                <col width="8%">
                <col width="14%">
            </colgroup>
            <tr>
                <td class="lableBackground">
                    Booking Number
                </td>
                <td class="whitebg" style="padding-left:4px;padding-top:1px;">
                    <html:text name="feserv03" property="bookingNo" maxlength='17' style="width:118px" 
                                onkeydown="gotoToSearchBookingInquiry(this)" />
                    <a id="btnBrowseBookingNo" name="btnBrowseBookingNo" class="m-btn smallest blue rnd smallericn-only" href="#"
                        onclick='openBookingNumber()'>
                        <i class="icon-search icon-white"></i>
                    </a>
                </td>
                <td class="lableBackground">
                    Quotation Number
                </td>
                <td class="whitebg">
                    <font class="displayText">
                        <bean:write name="feserv03" property="quotationNumber"/>
                    </font>
                </td>
                <!--Begin @02 -->
                <td colspan="4" class="whitebg">
                    <html:checkbox name="feserv03" property="representCompChkBox" styleId="representCompChkBox" value="Y" style="border:0px;width:15px;height:15px;" disabled="true" />&nbsp;
                    Represented Company
                    <html:text name="feserv03" property="representComp" disabled="true" styleClass="input-disabled" style="width:300px;" />
                </td>
                <!--End @02 -->
            </tr>
            <tr>
                <td class="lableBackground">
                    Shipment Term
                </td>
                <td class="whitebg">
                    <font class="displayText">
                        <bean:write name="feserv03" property="shipmentTerm"/>
                    </font>
                </td>
                <!--Begin @03 -->
                <td class="lableBackground">
                    COC/SOC
                </td>
                <td class="whitebg" colspan="2">
                    <html:text name="feserv03" property="socCocUserFlag" disabled="true" styleClass="input-disabled" style="width:200px;" />
                </td>
                <!--End @03 -->
                <td class="lableBackground">
                    Status
                </td>
                <td class="whitebg" colspan="2" >
                    <font class="displayText">
                        <bean:write name="feserv03" property="status"/>
                    </font>    
                </td>
            </tr>
            <tr>
                <td class="lableBackground" height="18px">
                    Customer Reference
                </td>
                <td class="whitebg">
                    <font class="displayText">
                        <bean:write name="feserv03" property="customerReference" />
                    </font>
                </td>
                <td class="lableBackground">
                    Email
                </td>
                <td class="whitebg">
                    <font class="displayText">
                        <bean:write name="feserv03" property="email" />
                    </font>
                </td>
                <td class="lableBackground">
                    Telephone
                </td>
                <td class="whitebg">
                    <font class="displayText">
                        <bean:write name="feserv03" property="telephone" />
                    </font>
                </td>
                <td class="lableBackground">
                    Fax
                </td>
                <td class="whitebg">
                    <font class="displayText">
                        <bean:write name="feserv03" property="fax" />
                    </font>
                </td>
            </tr>
            <tr>
                <td class="lableBackground">
                    Contact
                </td>
                <td class="whitebg">
                    <font class="displayText">
                        <bean:write name="feserv03" property="contact" />
                    </font>
                </td>
                <td class="lableBackground">
                    Additional Mail Recipients
                </td>
                <td colspan="5" >
                    <font class="displayText">
                        <bean:write name="feserv03" property="additionalMailRecipeints" />
                    </font>
                </td>
            </tr>
        </table>
        <div class="TableLeftSubColor2">
            <h2>Routing Details</h2>
        </div>
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_search">
            <tr>
                <td width="14%" class="tableHeadingBlue">
                    <span class="m0l0iout">
                        Original Country
                    </span>
                </td>
                <td width="14%" class="tableHeadingBlue">
                    <span class="m0l0iout">
                        Destination Country
                    </span>
                </td>
                <td width="28%" class="tableHeadingBlue" colspan="2">
                    <span class="m0l0iout">
                        Place of Receipt
                    </span>
                </td>
                <td width="13%" class="tableHeadingBlue">
                    <span class="m0l0iout">
                        Port of Loading POL
                    </span>
                </td>
                <td width="13%" class="tableHeadingBlue">
                    <span class="m0l0iout">
                        Port of Discharge POD
                    </span>
                </td>
                <td class="tableHeadingBlue">
                    <span class="m0l0iout">
                        Place of Delivery
                    </span>
                </td>
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
                        Cargo Availability Date
                    </span>
                </td>
                <td class="tableHeadingSecondRow2Blue">
                    <span class="m0l0iout">
                        Expected Sailing Date
                    </span>
                </td>
                <td class="tableHeadingSecondRow2Blue" colspan="3">
                    <span class="m0l0iout">
                        Desired Arriaval Date
                    </span>
                </td>
            </tr>
        </table>
         
         <!-- for line spacing -->
        <table style="margin:0; padding:0;" border="0">
            <tr><td></td></tr>
        </table>
           
<DIV CLASS="search_result" STYLE="HEIGHT:38px">
    <TABLE CLASS="table_results"  BORDER="0" CELLPADDING="0" CELLSPACING="0">
        <TBODY>   
            <tr height="12px">
                <td width="13%" class="tableColumnData">
                    <font class="displayText">
                        <bean:write name="feserv03" property="originCountry" />
                    </font>
                </td>
                <td width="13%" class="tableColumnData">
                    <font class="displayText">
                        <bean:write name="feserv03" property="destinationCountry" />
                    </font>
                </td>
                <td width="13%" class="tableColumnData">
                    <font class="displayText">
                        <bean:write name="feserv03" property="placeOfReceipt" />
                    </font>
                </td>
                <td width="13%">&nbsp;</td>
                <td width="12%" class="tableColumnData">
                    <font class="displayText">
                        <bean:write name="feserv03" property="portOfLoading"/>
                    </font>
                </td>
                <td width="12%" class="tableColumnData">
                    <font class="displayText">
                        <bean:write name="feserv03" property="portOfDischarge" />
                    </font>
                </td>
                <td width="16%" class="tableColumnData">
                    <font class="displayText">
                        <bean:write name="feserv03" property="placeOfDelivery" />
                    </font>
                </td>
            </tr>
            <tr>
                <td class="tableColumnData">
                    <font class="displayText">
                        <bean:write name="feserv03" property="emptyPickupDepot" />
                    </font>
                </td>
                <td class="tableColumnData">
                    <font class="displayText">
                        <bean:write name="feserv03" property="emptyPickupDate" />
                    </font>    
                </td>
                <td class="tableColumnData">
                    <font class="displayText">
                        <bean:write name="feserv03" property="shipmentDate" />
                    </font>
                </td>
                <td class="tableColumnData">
                    <font class="displayText">
                        <bean:write name="feserv03" property="sailingDate" />
                    </font>
                </td>
                <td class="tableColumnData">
                    <font class="displayText">
                        <bean:write name="feserv03" property="desiredArrivalDate" />
                    </font>
                </td>
                <td>&nbsp;</td>
                <td class="tableColumnData">
                    <html:checkbox name="feserv03" property="rclArrangementChkBox" style="float:left;border:0px;width:10%" disabled="true"/>
                    (as per RCL arrangement)
                </td>
            </tr>
        </TBODY>
    </TABLE>
</DIV>
         <!-- for line spacing -->
        <table style="margin:0; padding:0;" border="0">
            <tr><td></td></tr>
        </table>
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_search">
            <tr>
                <td width="3%" class="tableHeadingBlue">
                    <span class="m0l0iout">
                        Leg
                    </span>
                </td>
                <td width="24%" class="tableHeadingBlue">
                    <span class="m0l0iout">
                        From
                    </span>
                </td>
                <td width="25%" class="tableHeadingBlue">
                    <span class="m0l0iout">
                        To
                    </span>
                </td>
                <td width="6%" class="tableHeadingBlue">
                    <span class="m0l0iout">
                        ETD
                    </span>
                </td>
                <td width="6%" class="tableHeadingBlue">
                    <span class="m0l0iout">
                        ETA
                    </span>
                </td>
                <td width="6%" class="tableHeadingBlue">
                    <span class="m0l0iout">
                        Service
                    </span>
                </td>
                <td width="10%" class="tableHeadingBlue">
                    <span class="m0l0iout">
                        Vessel
                    </span>
                </td>
                <td width="10%" class="tableHeadingBlue">
                    <span class="m0l0iout">
                        Voyage
                    </span>
                </td>
                <td width="10%" class="tableHeadingBlue">
                    <span class="m0l0iout">
                        Transit Time
                    </span>
                </td>
            </tr>
            <tr>
                <td class="tableHeadingSecondRow2Blue">
                    <span class="m0l0iout">
                        #
                    </span>
                </td>
                <td class="tableHeadingSecondRow2Blue">
                    <span class="m0l0iout">
                        Loading Terminal Name
                    </span>
                </td>
                <td class="tableHeadingSecondRow2Blue" colspan="7">
                    <span class="m0l0iout">
                        Discharging Terminal Name
                    </span>
                </td>
            </tr>
        </table>
        <!-- for line spacing -->
        <table style="margin:0; padding:0;" border="0">
            <tr><td></td></tr>
        </table>
        <DIV ID="comm_search_result" CLASS="search_result" STYLE="HEIGHT:76px">
            <TABLE CLASS="table_results"  BORDER="0" CELLPADDING="0" CELLSPACING="0">
                <TBODY>
            <%
                List rList = (List)request.getAttribute("routingList");
                if(null!=rList && !rList.isEmpty())
                {
                    int i = 1;
            %>

                        <logic:iterate name="routingList" id="routing">                
                            <tr>
                                <td class="tableColumnData" width="3%" rowspan="2" align="center"><font class="displayText"><%=i%></font></td>
                                <td class="tableColumnData" width="24%"><font class="displayText"><bean:write name="routing" property="from"/></font></td>
                                <td class="tableColumnData" width="25%"><font class="displayText"><bean:write name="routing" property="to"/></font></td>
                                <td class="tableColumnData" width="6%"><font class="displayText"><bean:write name="routing" property="etd"/></font></td>
                                <td class="tableColumnData" width="6%"><font class="displayText"><bean:write name="routing" property="eta"/></font></td>
                                <td class="tableColumnData" width="6%"><font class="displayText"><bean:write name="routing" property="service"/></font></td>
                                <td class="tableColumnData" width="10%"><font class="displayText"><bean:write name="routing" property="vessel"/></font></td>
                                <td class="tableColumnData" width="10%"><font class="displayText"><bean:write name="routing" property="voyage"/></font></td>
                                <td class="tableColumnData" width="10%"><font class="displayText"><bean:write name="routing" property="transitTime"/></font></td>
                            </tr>
                            <tr>
                                <td class="tableColumnData"><font class="displayText"><bean:write name="routing" property="loadingTerminalName"/></font></td>
                                <td class="tableColumnData" colspan="7"><font class="displayText"><bean:write name="routing" property="dischargingTerminalName"/></font></td>
                            </tr>
                            <% i++;%>
                        </logic:iterate>
            <%
                }
                else
                {
            %>
                    <tr>
                        <td class="tableColumnData" width="3%" rowspan="2">&nbsp;</td>
                        <td class="tableColumnData" width="24%">&nbsp;</td>
                        <td class="tableColumnData" width="25%">&nbsp;</td>
                        <td class="tableColumnData" width="6%">&nbsp;</td>
                        <td class="tableColumnData" width="6%">&nbsp;</td>
                        <td class="tableColumnData" width="6%">&nbsp;</td>
                        <td class="tableColumnData" width="10%">&nbsp;</td>
                        <td class="tableColumnData" width="10%">&nbsp;</td>
                        <td class="tableColumnData" width="10%">&nbsp;</td>
                    </tr>
                    <tr>
                        <td class="tableColumnData">&nbsp;</td>
                        <td class="tableColumnData" colspan="7">&nbsp;</td>
                    </tr>
            <%
                }
            %>
                </TBODY>
            </TABLE>
        </DIV>            
            <!-- for line spacing -->
        <table style="margin:0; padding:0;" border="0">
            <tr><td></td></tr>
        </table>
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_search">
            <tr>
                <td width="99%" class="tableHeadingSecondRow2Blue"><span class="tableHeaderLeftAlign">Routing Preference (5 Lines Maximum) </span></td>
            </tr>
        </table>
        <!-- for line spacing -->
        <table style="margin:0; padding:0;" border="0">
            <tr><td></td></tr>
        </table>
        
        <TABLE ID="comm_result_dtl" BORDER="0" CELLPADDING="0" CELLSPACING="0">
            <TBODY>
                <tr height="12px">
                    <td>
                        <html:textarea
                            name="feserv03"
                            property="routingPreference"
                            cols="50"
                            rows="5"
                            readonly="true"
                            styleClass="Combo"/>
                    </td>
                </tr>
            </TBODY>
         </table>
        <!-- for line spacing -->
        <table style="margin:0; padding:0;" border="0">
            <tr><td></td></tr>
        </table>
        
        <div class="TableLeftSubColor2">
            <h2>Equipment Details</h2>
        </div>
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_search">
            <tr>
                <td width="4%" class="tableHeadingBlue"><span class="m0l0iout">#</span></td>
                <td width="6%" class="tableHeadingBlue"><span class="m0l0iout">Type</span></td>
                <td width="6%" class="tableHeadingBlue"><span class="m0l0iout">Size</span></td>
                <td width="8%" class="tableHeadingBlue"><span class="m0l0iout">Cargo Type </span></td>
                <td width="9%" class="tableHeadingBlue"><span class="m0l0iout">Laden</span></td>
                <td width="11%" class="tableHeadingBlue"><span class="m0l0iout">Empty</span></td>
                <td width="18%" class="tableHeadingBlue"><span class="m0l0iout">Gross Container Weight (KG)</span></td>
                <td width="19%" class="tableHeadingBlue"><span class="m0l0iout">POL Status </span></td>
                <td width="19%" class="tableHeadingBlue"><span class="m0l0iout">POD Status </span></td>
            </tr>
        </table>
        
        <!-- for line spacing -->
        <table style="margin:0; padding:0;" border="0">
            <tr><td></td></tr>
        </table>            
        <DIV ID="comm_search_result" CLASS="search_result" STYLE="HEIGHT:76px">
            <TABLE ID="comm_result_dtl" CLASS="table_results"  BORDER="0" CELLPADDING="0" CELLSPACING="0">
                <TBODY>
            <%
                List eList = (List)request.getAttribute("equipmentList");
                if(null!=eList && !eList.isEmpty())
                {
                    int i = 1;
            %>
            <logic:iterate name="equipmentList" id="equipment">
                <tr>
                    <td class="tableColumnData" width="4%"><font class="displayText"><%=i%></font></td>
                    <td class="tableColumnData" width="6%"><font class="displayText"><bean:write name="equipment" property="type"/></font></td>
                    <td class="tableColumnData" width="6%"><font class="displayText"><bean:write name="equipment" property="size"/></font></td>
                    <td class="tableColumnData" width="8%"><font class="displayText"><bean:write name="equipment" property="cargoType"/></font></td>
                    <td class="tableColumnData" width="9%"><font class="displayText"><bean:write name="equipment" property="laden"/></font></td>
                    <td class="tableColumnData" width="11%"><font class="displayText"><bean:write name="equipment" property="mt"/></font></td>
                    <td class="tableColumnData" width="18%"><font class="displayText"><bean:write name="equipment" property="grossContainerWeight"/></font></td>
                    <td class="tableColumnData" width="19%"><font class="displayText"><bean:write name="equipment" property="polStatus"/></font></td>
                    <td class="tableColumnData" width="19%"><font class="displayText"><bean:write name="equipment" property="podStatus"/></font></td>
                </tr>
                <%i++;%>
            </logic:iterate>
            <%
                }
                else
                {
            %>
                    <tr>
                        <td class="tableColumnData" width="4%">&nbsp;</td>
                        <td class="tableColumnData" width="6%">&nbsp;</td>
                        <td class="tableColumnData" width="6%">&nbsp;</td>
                        <td class="tableColumnData" width="8%">&nbsp;</td>
                        <td class="tableColumnData" width="9%">&nbsp;</td>
                        <td class="tableColumnData" width="11%">&nbsp;</td>
                        <td class="tableColumnData" width="18%">&nbsp;</td>
                        <td class="tableColumnData" width="19%">&nbsp;</td>
                        <td class="tableColumnData" width="19%">&nbsp;</td>
                    </tr>
            <%
                }
            %>
                </TBODY>
            </TABLE>
        </DIV>            
            <!-- for line spacing -->
            <table style="margin:0; padding:0;" border="0">
                <tr><td></td></tr>
            </table>
        <div class="TableLeftSubColor2">
            <h2>Cargo Description</h2>
        </div>
        
        <!-- for line spacing -->
        <table style="margin:0; padding:0;" border="0">
            <tr><td></td></tr>
        </table>
        <TABLE ID="comm_result_dtl" BORDER="0" CELLPADDING="0" CELLSPACING="0">
            <TBODY>
                <tr>
                    <td height="12px">
                        <html:textarea
                            name="feserv03"
                            property="cargoDescription"
                            cols="50"
                            rows="5"
                            readonly="true"
                            styleClass="Combo"/>
                    </td>
                </tr>
            </TBODY>
        </table>
        <!-- for line spacing -->
        <table style="margin:0; padding:0;" border="0">
            <tr><td></td></tr>
        </table>
        
        <div class="TableLeftSubColor2">
            <h2>Commodity Details</h2>
        </div>
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_search">
            <tr>
                <td width="4%"  class="tableHeadingBlue">&nbsp;</td>
                <td width="4%"  class="tableHeadingBlue"><span class="m0l0iout">#</span></td>
                <td width="20%" class="tableHeadingBlue"><span class="m0l0iout">Commodity Group</span></td>
                <td width="18%" class="tableHeadingBlue"><span class="m0l0iout">Gross Weight(KGS) </span></td>
                <td width="10%" class="tableHeadingBlue"><span class="m0l0iout">Special Cargo </span></td>
                <td width="8%" class="tableHeadingBlue"><span class="m0l0iout">Rate Type </span></td>
                <td width="10%" class="tableHeadingBlue"><span class="m0l0iout">&nbsp;</span></td>
            </tr>
        </table>
        <!-- for line spacing -->
        <table style="margin:0; padding:0;" border="0">
            <tr><td></td></tr>
        </table>
        <DIV ID="comm_search_result" CLASS="search_result" STYLE="HEIGHT:76px">
            <TABLE ID="comm_result_dtl" CLASS="table_results"  BORDER="0" CELLPADDING="0" CELLSPACING="0">
                <TBODY>
            <%
                List cList = (List)request.getAttribute("commodityList");
                if(null!=cList && !cList.isEmpty())
                {
                    int i = 1;
            %>
            <logic:iterate name="commodityList" id="commodity" type='com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceCommodityDetailsMod' >
                <tr>                    
                    <td class="tableColumnData" width="4%">
                        <html:radio value="${commodity.seqNo}" name="commodity" property="radCommodity" style="border:0px;width:50%" onclick="showSpecialInstruction(this.value)"/>
                    </td>
                    <td class="tableColumnData" width="4%">
                        <font class="displayText"><%=i%></font>
                    </td>
                    <td class="tableColumnData" width="20%">
                        <font class="displayText">
                            <bean:write name="commodity" property="group"/>&nbsp;-&nbsp;<bean:write name="commodity" property="description"/>
                        </font>
                    </td>
                    <td class="tableColumnData" width="18%">
                        <font class="displayText">
                            <bean:write name="commodity" property="grossWeight"/>
                        </font>
                    </td>
                    <td class="tableColumnData" width="10%">
                        <font class="displayText">
                            <bean:write name="commodity" property="specialCargo"/>
                        </font>
                    </td>
                    <td class="tableColumnData" width="8%">
                        <font class="displayText">
                            <bean:write name="commodity" property="rateTypeDesc"/>
                        </font>
                    </td>
                    <td class="tableColumnData" width="10%">
                        <html:hidden name="commodity" property="seqNo"/>
                        <html:hidden name="commodity" property="rateType"/>
                        <html:hidden name="commodity" property="rateTypeFlag"/>
                        <logic:equal name="commodity" property="rateTypeDisabled" value="false">
                            <a class="<%=commodity.getRateTypeClassName()%>" href="javascript:void(0)" name="btnRateTypeDetails"  onClick="openRateTypeLookUpForInquiry();">
                                <i class="icon-plus icon-white"></i>
                            </a>
                        </logic:equal>
                        <logic:equal name="commodity" property="rateTypeDisabled" value="true">
                            <a class="<%=commodity.getRateTypeClassName()%>" disabled href="javascript:void(0)" name="btnRateTypeDetails"  onClick="openRateTypeLookUpForInquiry();">
                                <i class="icon-plus icon-white"></i>
                            </a>
                        </logic:equal>
                    </td>
                </tr>
                <%i++;%>
            </logic:iterate>                    
            <%
                }
                else
                {
            %>
                    <tr>                    
                        <td class="tableColumnData" colspan="2" width="8%">&nbsp;</td>
                        <td class="tableColumnData" width="20%">&nbsp;</td>
                        <td class="tableColumnData" width="18%">&nbsp;</td>
                        <td class="tableColumnData">&nbsp;</td>
                    </tr>
            <%
                }
            %>
                </TBODY>
            </TABLE>
        </DIV>
        
         <!-- for line spacing -->
        <table style="margin:0; padding:0;" border="0">
            <tr><td></td></tr>
        </table>
        <div class="TableLeftSubColor2">
            <h2>Special Instruction (5 Lines Maximum)</h2>
        </div>
          <!-- for line spacing -->
        <table style="margin:0; padding:0;" border="0">
            <tr><td></td></tr>
        </table>
        <TABLE ID="tableSI"  BORDER="0" CELLPADDING="0" CELLSPACING="0">
            <TBODY>
            <%
                if(null!=cList)
                {
            %>
            <logic:iterate name="commodityList" id="commodity">     
                <tr id="row_${commodity.seqNo}" style="display: none;">
                    <td class="tableColumnData">
                        <html:textarea
                            name="commodity"
                            property="specialInstruction"
                            cols="50"
                            rows="5"
                            readonly="true"
                            styleClass="Combo"/>
                    </td>
                </tr>
            </logic:iterate>
            <%
                }
            %>
                </TBODY>
            </TABLE>
        <br>
        <div align="right">
            <% 
                Boolean isDisabled = (Boolean)request.getAttribute("disabledEdit");
            %>
            <a class="m-btn sm blue rnd"
                href="javascript:void(0)" onClick="return uploadAttachmentForInquiry();">
                    View Upload Document
                <i class="m-icon-swapup m-icon-white"></i>
            </a>
            <a class="m-btn sm green rnd" 
                href="javascript:void(0)" onclick="gotoNewBooking()">New Web Booking&nbsp;<i class="m-icon-swapleft m-icon-white"></i>
            </a> 
            <!--a class="<%=(null!=isDisabled && !isDisabled)?"m-btn sm green rnd":"m-btn sm rnd disabled"%>" 
                href="#" onclick="editBooking()">Edit Booking <i class="m-icon-swapright m-icon-white"></i>
            </a--> 
        </div>
    </html:form>
</body>
