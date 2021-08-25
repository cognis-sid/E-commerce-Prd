<%--
-------------------------------------------------------------------------------------------------------------
EservicePreviewUploadedDocScn.jsp
-------------------------------------------------------------------------------------------------------------
Copyright RCL Public Co., Ltd. 2007
-------------------------------------------------------------------------------------------------------------  
Author Pratya Thanuchaisak 08/08/2014
- Change Log ------------------------------------------------------------------------------------------------
## DD/MM/YY      -User-          -TaskRef-         -ShortDescription-
-------------------------------------------------------------------------------------------------------------
--%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page import="com.niit.control.common.GlobalConstants" %>
<%@page import="com.niit.control.web.action.BaseAction" %>
<%@page import="com.niit.control.web.UserAccountBean" %>
<%@page import="com.niit.control.common.StringUtil" %>
<%@page import="java.util.List" %>
<%@page import="com.rclgroup.dolphin.rcl.web.eservice.dao.EservicePortClassDao" %>
<%
    String lstrCtxPath     = request.getContextPath();
%>
<head>
    <!-- add screen specific JavaScript file -->
    <script language="JavaScript" src="<%=lstrCtxPath%>/js/common/Constants.js" ></script>

    <script language="JavaScript" src="<%=lstrCtxPath%>/js/RutHelp.js" ></script>
    
    <!-- add javascript file for this screen -->
    <script language="JavaScript" src="<%=lstrCtxPath%>/js/screen/EservicePreviewUploadedDoc.js" ></script>
    
    <script language="JavaScript">
        var SEARCH_CRITERIA                         = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv025searchData", pageContext)%>';
        var BOOKED_BY                               = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv014", pageContext)%>';
        var BROWSE_BOOKING_NUMBER                   = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv002BrowseBookingNumber", pageContext)%>';
    </script>

</head>

<body>    
    <html:form method="POST" styleId="frm" action="/serv025">
        <html:hidden name="feserv25" property="userId" styleId="userId"/>
        <html:hidden name="feserv25" property="fscCode" styleId="fscCode"/>
        <div class="TableLeftSubColor2">
            <h2>Preview Uploaded Document - Search</h2>
        </div>
        <table class="table_search" border="0" width="100%" cellspacing="0" cellpadding="0">
            <tr style="height:30px;">
                <td width="10%">Booking No</td>
                <td width="15%">
                    <html:text name="feserv25" property="bookingNo" styleId="bookingNo" onblur="changeUpper(this)" />
                    <a name="btnBookingNo" class="m-btn smallest blue rnd smallericn-only" href="javascript:void(0)" onclick='openBookingNumber();'>
                        <i class="icon-search icon-white"></i>
                    </a> 
                </td>
                <td width="10%">Booking Date From</td>
                <td width="15%">
                    <html:text
                        name="feserv25"
                        property="bookingDateFrom"
                        styleId="bookingDateFrom"
                        style="width:49%"
                        maxlength='10'
                        onblur="gp_checkDate(this);"
                        styleClass="dateForm"/>

                    <a href="javascript:void(0)" class="m-btn smallest blue rnd smallericn-only" onClick="gp_calendar('bookingDateFrom');">
                        <i class="icon-calendar icon-white"></i>
                    </a>
                </td>
                <td width="10%">Booking  Date To</td>
                <td width="15%">
                    <html:text
                        name="feserv25"
                        property="bookingDateTo"
                        styleId="bookingDateTo"
                        style="width:49%"
                        maxlength='10'
                        onblur="gp_checkDate(this);"
                        styleClass="dateForm"/>

                    <a href="javascript:void(0)" class="m-btn smallest blue rnd smallericn-only" onClick="gp_calendar('bookingDateTo');">
                        <i class="icon-calendar icon-white"></i>
                    </a>
                </td>
                <td width="10%">Booked By</td>
                <td width="15%">
                    <html:text name="feserv25" property="bookingDateBy" styleId="bookingDateBy" style="width: 100px;" />&nbsp;
                    <a name="btnBookingDateBy" class="m-btn smallest blue rnd smallericn-only" href="javascript:void(0)" onclick='openCustomerData();'>
                        <i class="icon-search icon-white"></i>
                    </a>  
                </td>
            </tr>
            <tr style="height:30px;">
                <td>Sort by</td>
                <td>
                    <html:select name="feserv25" property="sortBy" styleId="sortBy" size="1">
                        <html:optionsCollection name="feserv25" value="code" label="name" property="sortByComboList"/>
                    </html:select>
                    
                </td>
                <td>Order by</td>
                <td>
                    <html:select name="feserv25" property="orderBy" styleId="orderBy" size="1">
                        <html:optionsCollection name="feserv25" value="code" label="name" property="orderByComboList"/>
                    </html:select>
                </td>
                <td valign="top" style="padding-left:7px;padding-top:1px;" colspan="4">
                    <a id="btnSearch" name="btnSearch" class="m-btn mini blue rnd"
                        href="#" onClick="searchBtn()">&nbsp;Search
                    </a>
                    <a id="btnReset" name="btnReset" class="m-btn mini blue rnd"
                        href="#" onClick="resetBtn()">&nbsp;Reset
                    </a>
                </td>
            </tr>
        </table>
        <br>
        <div class="TableLeftSubColor2">
            <h2>Preview Uploaded Document List</h2>
        </div>
        <table border="0" width="100%" cellspacing="0" class="TablePopup" >
            <tr>
                <td class="tableHeadingBlue" width="15%">Booking No</td>
                <td class="tableHeadingBlue" width="15%">Booking Date</td>
                <td class="tableHeadingBlue" width="30%">Booked By</td>
                <td class="tableHeadingBlue" width="40%">File Name</td>
            </tr>
        </table>
        
        <table border="0" width="100%" cellspacing="0" class="TablePopup" >
            <logic:greaterThan value="0" name="feserv25" property="totRecord" >
                <logic:iterate name='feserv25' property='searchResultsList' indexId='ctr' id='rowdata'
                    type='com.rclgroup.dolphin.rcl.web.eservice.vo.EservicePreviewUploadedDocMod'>
                    <tr>
                        <td class="TdLeftDetailPopup" width="15%" height="20px;">
                            <bean:write name="rowdata" property="bookingNo"/>
                        </td>
                        <td class="TdLeftDetailPopup" width="15%"  height="20px;">
                            <bean:write name="rowdata" property="bookingDate"/>
                        </td>
                        <td class="TdLeftDetailPopup" width="30%"  height="20px;">
                            <bean:write name="rowdata" property="bookingBy"/>
                        </td>
                        <td class="TdLeftDetailPopup" width="40%"  height="20px;">
                            <A href='<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv024", pageContext)%>?pdfName=<bean:write name="rowdata" property="fileName"/>&fileName=<bean:write name="rowdata" property="newFileName"/>' target="_blank" >
                                <bean:write name="rowdata" property="fileName"/>
                            </A>
                        </td>
                    </tr>
                </logic:iterate>
            </logic:greaterThan>
            <logic:equal  value="0" name="feserv25" property="totRecord" >
                <tr>
                    <td class="TdCentertDetailPopup" height="20px;" colspan="4" >
                        Record not found
                    </td>
                </tr>
            </logic:equal>
        </table>
        <jsp:include page="../common/tiles/pagination.jsp">
            <jsp:param name="formName" value="feserv25" />
        </jsp:include>
    </html:form>
</body>
