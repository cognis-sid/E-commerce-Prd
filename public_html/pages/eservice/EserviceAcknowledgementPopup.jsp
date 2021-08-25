<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@page import="com.niit.control.common.GlobalConstants" %>
<%@page import="com.niit.control.web.action.BaseAction" %>
<%@page import="com.niit.control.web.UserAccountBean" %>
<%@page import="com.niit.control.common.StringUtil" %>
<%
    String lstrCtxPath     = request.getContextPath();
%>
<head>
<script type="text/javascript" language="JavaScript" src="<%=lstrCtxPath%>/js/RutHelp.js" ></script>
<script type="text/javascript" language="JavaScript" src="<%=lstrCtxPath%>/js/screen/EserviceAcknowledgementPopup.js" ></script>

<script type="text/javascript" language="JavaScript">
    var BROWSE_BOOKING_NUMBER = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv002BrowseBookingNumber", pageContext)%>';
    // var GET_BOOKING_NUMBER = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv002", pageContext)%>';        
    var GET_BOOKING_NUMBER = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv002GetData", pageContext)%>';        
</script>
</head>

<body>
    <html:hidden name="feserv01" property="bookingNo"/>
    <div style="padding-left:10px;padding-right:10px">
        <div class="popupHeader">Thank you for your booking request!</div> 
        <br>
        <div>The acknowledgement for the same will be sent shortly  to the email: <span class="displayMail"><bean:write name="feserv01" property="email"/></span> and requested list of recipient email addresses.</div>        
        <br>
        <div>Your booking is binding as soon as you receive the booking confirmation from us via email as soon as we can confirm space availability and any other details pertainting to this request.</div>        
        <table width="50%" cellspacing="5" border="0" align="center">
            <tr style="height: 10px">
                <td width="25%"><strong>Booking Number</strong></td>
                <td width="25%"><bean:write name="feserv01" property="bookingNo"/></td>
            </tr>
            <tr style="height: 10px">
                <td><strong>Quotation Number</strong></td>
                <td ><bean:write name="feserv01" property="customerName"/></td>
            </tr>
            <tr style="height: 10px">
                <td><strong>Booked By</strong></td>
                <td ><bean:write name="feserv01" property="userId"/></td>
            </tr>
        </table>
        <br>
        <div><strong>Note:</strong> The carrier reserves its full rights, and at any given time without prior notice, change the arrangement listed or make alternate arrangment or decline a booking.</div>
        <br><br><br>
        <div align="center" style="padding-right:10px;">
            <a class="m-btn sm blue rnd" 
                href="#" onclick="window.close();">OK <i class="icon-remove icon-white"></i>
            </a> 
        </div>
    </div>    
</body>
