<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@page import="com.niit.control.common.GlobalConstants" %>
<%@page import="com.niit.control.web.action.BaseAction" %>
<%@page import="com.niit.control.web.UserAccountBean" %>
<%@page import="com.niit.control.common.StringUtil" %>
<%
    String lstrCtxPath     = request.getContextPath();
%>
<html:html>
<head>
<!-- add screen specific JavaScript file -->
<script type="text/javascript" language="JavaScript" src="<%=lstrCtxPath%>/js/common/Constants.js" ></script>
<script type="text/javascript" language="JavaScript" src="<%=lstrCtxPath%>/js/RutHelp.js" ></script>
<script type="text/javascript" language="JavaScript" src="<%=lstrCtxPath%>/js/screen/EshippingAcknowledgementPopup.js" ></script>

<script type="text/javascript" language="JavaScript">
    var GET_BOOKING_NUMBER_TO_ESHIPPING_PAGE = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv006GetData", pageContext)%>';        
</script>
</head>
<body>
    <html:hidden name="feserv06" property="bookingNo" styleId="bookingNo"/>
    <html:hidden name="feserv06" property="blNo" styleId="blNo"/>
    <html:hidden name="feserv06" property="cocSoc" styleId="cocSoc"/>
    <html:hidden name="feserv06" property="flag" styleId="flag"/>
    <div style="padding-left:10px;padding-right:10px">
        <div class="popupHeader">Thanks you, e-Shipping Instruction had been submitted successfully!</div> 
        <br>
        <div>The acknowledgement for the same will be sent shortly  to the email: <span class="displayMail"><bean:write name="feserv06" property="emailAcknowledgment"/></span> and requested list of recipient email addresses.</div>        
        <br>
        <div>Billing of lading for this booking shall be created as per your e-Shipping Instruction. For further information required please contact us at:</div>        
        <br>
        <table width="50%" cellspacing="5" border="0" align="center">
            <tr style="height: 10px;">
                <td width="5%"><strong>Phone&nbsp;:</strong></td>
                <td width="25%"><bean:write name="feserv06" property="vendorTelephone"/></td>
            </tr>
            <tr style="height: 10px;">
                <td><strong>Fax&nbsp;</strong></td>
                <td ><bean:write name="feserv06" property="vendorFax"/></td>
            </tr>
            <tr style="height: 10px;">
                <td><strong>Email&nbsp;</strong></td>
                <td ><bean:write name="feserv06" property="vendorEmail"/></td>
            </tr>
        </table>
        <br>
        <div><strong>Note:</strong> The carrier reserves its full rights, and at any given time without prior notice, change the arrangement listed or make alternate arrangment or decline a booking.</div>
        <br><br><br>
        <div align="center" style="padding-right:10px;">
            <a class="m-btn sm blue rnd" 
                href="#" onclick="onClose();">OK <i class="icon-remove icon-white"></i>
            </a> 
        </div>
    </div>    
</body>
</html:html>
