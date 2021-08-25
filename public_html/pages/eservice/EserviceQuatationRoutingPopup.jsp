<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page import="com.niit.control.common.GlobalConstants" %>
<%@page import="com.niit.control.web.action.BaseAction" %>
<%@page import="com.niit.control.web.UserAccountBean" %>
<%@page import="com.niit.control.common.StringUtil" %>
<%@page import="java.util.List" %>
<%@page import="com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceInquiryWebBookingDao" %>
<%@page import="com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceNewWebBookingUim" %>
<%
    String lstrCtxPath     = request.getContextPath();
    List<EserviceNewWebBookingUim> eServiceQuatationRoutingList = (List<EserviceNewWebBookingUim>) session.getAttribute("eServiceQuatationRoutingList");
    if(eServiceQuatationRoutingList != null && !eServiceQuatationRoutingList.isEmpty()){
        System.out.println("eServiceQuatationRoutingList.size = "+eServiceQuatationRoutingList.size());
    }else{
        System.out.println("Empty");
    }
%>
<html:html>
<head>
    <!-- add screen specific JavaScript file -->
    <script type="text/javascript" language="JavaScript" src="<%=lstrCtxPath%>/js/common/Constants.js" ></script>
    <script  type="text/javascript" language="JavaScript" src="<%=lstrCtxPath%>/js/RutHelp.js" ></script>
    <!-- add javascript file for this screen -->
    <script type="text/javascript" language="JavaScript" src="<%=lstrCtxPath%>/js/screen/EserviceQuotationRoutingPopup.js" ></script>
    <script type="text/javascript" language="JavaScript">
        var SET_QUATATION_ROUTING_DATA
            = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv001SetQuotationRoutingData", pageContext)%>';
    </script>
</head>

<body>    
    <html:form method="POST" action="/serv001">
    <table class="table_search" border="0" width="100%" cellspacing="0" cellpadding="0">
        <tr style="height: 20px">
            <td>
                <table width="300" border="0" cellspacing="0" cellpadding="0">
                <tr style="height: 25px">
                    <td width="150">
                        <font class="table_search" style="font-size: 14px">
                        Quotation Number
                        </font>
                    </td>
                    <td width="150" class="whitebg">
                        <%--
                        <html:text name="feserv01" property="bookingNo" maxlength='17' onblur="changeUpper(this)"  styleClass="rclDisabledTab" />
                        --%>
                        <font class="displayText" style="font-size: 14px">
                            <bean:write name="quotationNumber" scope="request"/>
                        </font>
                    </td>
                </tr>
                </table>
            </td>
        </tr>
        <tr>
            <td>       
                <table border="0" width="100%" cellspacing="0" class="TablePopup" >
                <tr>
                    <td class="TdLeftHeaderPopup" width="10%">#</td>
                    <td class="TdLeftHeaderPopup" width="15%">Original Country</td>
                    <td class="TdLeftHeaderPopup" width="15%">Destination Country</td>
                    <td class="TdLeftHeaderPopup" width="15%">Place of Reciept </td>
                    <td class="TdLeftHeaderPopup" width="15%">Port of Loading</td>
                    <td class="TdLeftHeaderPopup" width="15%">Port of Discharge</td>
                    <td class="TdLeftHeaderPopup" width="15%">Place of Delivery</td>
                </tr>
                </table>
                
                <table border="0" width="100%" cellspacing="0" class="TablePopup" >
        <logic:notEmpty name="eServiceQuatationRoutingList" scope="session">
            <%--bean:define id="quatationRoutingList" name="feserv01" property="quatationRoutingList" 
            type="java.util.List" --%>
            <bean:define id="quatationRoutingList" name="eServiceQuatationRoutingList" scope="session" />
            <logic:iterate id="eserviceNewWebBookingUim" name="quatationRoutingList" indexId="rowIndex" 
            type="com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceNewWebBookingUim">
                <bean:define id="newRowIndex" value="${rowIndex+1}" />
                <%--tr ondblclick="callbackToFieldQuotationRouting('<bean:write name="rowIndex" />');" 
                onclick="highlightradioTD('<bean:write name="newRowIndex" />');" 
                style="cursor:hand;"--%>
                <tr ondblclick="callBack(
                '${eserviceNewWebBookingUim.pol}', '${eserviceNewWebBookingUim.pod}', 
                '${eserviceNewWebBookingUim.originCountry}', '${eserviceNewWebBookingUim.destinationCountry}',
                '${eserviceNewWebBookingUim.placeOfReceipt}', '${eserviceNewWebBookingUim.portOfLoading}', 
                '${eserviceNewWebBookingUim.portOfDischarge}', '${eserviceNewWebBookingUim.placeOfDelivery}',
                '${eserviceNewWebBookingUim.shipmentType}', '${eserviceNewWebBookingUim.socCocUserFlag}');" 
                onclick="highlightradioTD('<bean:write name="newRowIndex" />');" 
                style="cursor:hand; height: 20px">
                    <td width="10%" class="TdLeftDetailPopup" style="color: #000000">
                        <bean:write name="newRowIndex" />
                    </td>
                    <td width="15%" class="TdLeftDetailPopup" style="color: #000000">
                        <bean:write name="eserviceNewWebBookingUim" property="originCountry" />
                    </td>
                    <td width="15%" class="TdLeftDetailPopup" style="color: #000000">
                        <bean:write name="eserviceNewWebBookingUim" property="destinationCountry"/>
                    </td>
                    <td width="15%" class="TdLeftDetailPopup" style="color: #000000">
                        <bean:write name="eserviceNewWebBookingUim" property="placeOfReceipt" />
                    </td>
                    <td width="15%" class="TdLeftDetailPopup" style="color: #000000">
                        <bean:write name="eserviceNewWebBookingUim" property="portOfLoading"/>
                    </td>
                    <td width="15%" class="TdLeftDetailPopup" style="color: #000000">
                        <bean:write name="eserviceNewWebBookingUim" property="portOfDischarge" />
                    </td>
                    <td width="15%" class="TdLeftDetailPopup" style="color: #000000">
                        <bean:write name="eserviceNewWebBookingUim" property="placeOfDelivery"/>
                    </td>
                </tr>
            </logic:iterate>
        </logic:notEmpty>
        <logic:empty name="eServiceQuatationRoutingList" scope="session">
            <tr style="height: 20px">    
                <td colspan="7" align="center">
                    <span  style="color: #000000">No record found.</span>
                </td>
            </tr>
        </logic:empty>
                </table>
            </td>
        </tr>
        </table>
        <jsp:include page="../common/tiles/pagination.jsp">
            <jsp:param name="formName" value="feserv01" />
        </jsp:include>
    </html:form>
</body>
</html:html>
