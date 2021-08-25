<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page import="com.niit.control.common.GlobalConstants" %>
<%@page import="com.niit.control.web.action.BaseAction" %>
<%@page import="com.niit.control.web.UserAccountBean" %>
<%@page import="com.niit.control.common.StringUtil" %>
<%@page import="java.util.List" %>
<%@page import="com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceInquiryWebBookingDao" %>
<%
    String lstrCtxPath     = request.getContextPath();
%>

<head>
<script type="text/javascript" language="JavaScript" src="<%=lstrCtxPath%>/js/RutHelp.js" ></script>
<!-- add javascript file for this screen -->
<script type="text/javascript" language="JavaScript" src="<%=lstrCtxPath%>/js/screen/EserviceBookingNumberPopup.js" ></script>
<script type="text/javascript" language="JavaScript">
    var BROWSE_BOOKING_NUMBER = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv002BrowseBookingNumber", pageContext)%>';   
    var GET_BOOKING_NUMBER_TO_WEBBOOKING_PAGE = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv002GetData", pageContext)%>';
</script>
</head>
<body>    
    <html:form method="POST" action="/serv002">         
        <html:hidden name="feserv02" property="page"/>
        <html:hidden name="feserv02" property="pageFlag" styleId="pageFlag" />
        <table class="table_search" border="0" width="100%" cellspacing="0" cellpadding="0">
            <tr>
                <td width="6%">Find</td>
                <td width="23%">
                    <html:text name="feserv02" property="tbxFind" onblur="changeUpper(this)"/>
                </td>
                <td width="7%">Column</td>
                <td width="23%">
                    <html:select name="feserv02" property="columnValue" size="1">
                        <html:optionsCollection name="feserv02" value="code" label="name" property="columnList"/>
                    </html:select>
                </td>
                <td width="6%" style="padding-left:6px">Status</td>
                <td width="18%">
                    <html:select name="feserv02" property="statusValue" size="1">
                        <html:optionsCollection name="feserv02" value="code" label="name" property="statusList"/>
                    </html:select>
                </td>
                <td valign="top" style="padding-top:1px">
                    <a id="btnSearch" name="btnSearch" class="m-btn mini blue rnd"
                        href="#" onClick="searchBtn()">&nbsp;Search
                    </a>
                    <a id="btnReset" name="btnReset" class="m-btn mini blue rnd"
                        href="#" onClick="resetBtn()">&nbsp;Reset
                    </a>
                </td>
            </tr>
            <tr>
                <td>Sort by</td>
                <td>
                    <html:select name="feserv02" property="sortByValue" size="1">
                        <html:optionsCollection name="feserv02" value="code" label="name" property="sortByList"/>
                    </html:select>
                </td>
                <td>Order by</td>
                <td>
                    <html:select name="feserv02" property="orderValue" size="1">
                        <html:optionsCollection name="feserv02" value="code" label="name" property="orderList"/>
                    </html:select>
                <td colspan="3" style="padding-left:4px;padding-top:3px">
                    <html:checkbox name="feserv02" property="chkBoxWildCard" style="float:left;border:0px;width:5%"/>Wild Card
                </td>
            </tr>
        </table><br>
        <table class="TablePopup">
            <tr>
                <td class="TdLeftHeaderPopup" width="16%"><%=EserviceInquiryWebBookingDao.KEY_COLUMN_SHOW_BOOKING_DATE%></td>
                <td class="TdLeftHeaderPopup" width="16%"><%=EserviceInquiryWebBookingDao.KEY_COLUMN_SHOW_BOOKING_NO%></td>
                <td class="TdLeftHeaderPopup" width="16%"><%=EserviceInquiryWebBookingDao.KEY_COLUMN_SHOW_BOOKING_TYPE%></td>
                <td class="TdLeftHeaderPopup" width="16%"><%=EserviceInquiryWebBookingDao.KEY_COLUMN_SHOW_POL%></td>
                <td class="TdLeftHeaderPopup" width="16%"><%=EserviceInquiryWebBookingDao.KEY_COLUMN_SHOW_POD%></td>
                <td class="TdLeftHeaderPopup"><%=EserviceInquiryWebBookingDao.KEY_COLUMN_SHOW_STATUS%></td>
            </tr>
        </table>
        <table class="TablePopup">
            <%
                List list = (List)request.getAttribute("listBooking");     
                if(!list.isEmpty()){
                    int x = 0;
            %>
            <logic:iterate name="listBooking" id="listBookingId">
                <tr id="row<%=x%>" ondblclick="callbackToField('<bean:write name="listBookingId" property="bookingNo"/>', '<bean:write name="listBookingId" property="bookingType"/>')" onclick="highlightRadioTD('row<%=x%>')" style="cursor:hand;">
                    <td class="TdLeftDetailPopup" width="16%" height="20px"><bean:write name="listBookingId" property="bookingDate"/></td>
                    <td class="TdLeftDetailPopup" width="16%" height="20px"><bean:write name="listBookingId" property="bookingNo"/></td>
                    <td class="TdLeftDetailPopup" width="16%" height="20px"><bean:write name="listBookingId" property="bookingType"/></td>
                    <td class="TdLeftDetailPopup" width="16%" height="20px"><bean:write name="listBookingId" property="pol"/></td>
                    <td class="TdLeftDetailPopup" width="16%" height="20px"><bean:write name="listBookingId" property="pod"/></td>
                    <td class="TdLeftDetailPopup" height="20px"><bean:write name="listBookingId" property="status"/></td>
                </tr>
                <% x++; %>
            </logic:iterate>
            <%} else {%>
                <tr style="height: 20px">    
                    <td colspan="8" align="center">No record found.</td>
                </tr>
            <%}%>
        </table>
        <jsp:include page="../common/tiles/pagination.jsp">
            <jsp:param name="formName" value="feserv02" />
        </jsp:include>
    </html:form>
</body>
