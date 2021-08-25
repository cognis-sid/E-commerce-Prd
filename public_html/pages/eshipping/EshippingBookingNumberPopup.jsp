<%--
-------------------------------------------------------------------------------------------------------------
EshippingBookingNumberPopup.jsp
-------------------------------------------------------------------------------------------------------------
Copyright RCL Public Co., Ltd. 2007
-------------------------------------------------------------------------------------------------------------  
Author anurak Thanapradit 05/07/13
- Change Log ------------------------------------------------------------------------------------------------
## DD/MM/YY      -User-          -TaskRef-         -ShortDescription-
## 10/10/2013                       01                add shiper name column
## 12/12/2013    YOSSUN!            02                add esiStatusDesc.
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
<%@page import="com.rclgroup.dolphin.rcl.web.eservice.dao.EshippingInstructionDao" %>
<%
    String lstrCtxPath     = request.getContextPath();
%>

<head>
<script type="text/javascript" language="JavaScript" src="<%=lstrCtxPath%>/js/RutHelp.js" ></script>
<script type="text/javascript" language="JavaScript" src="<%=lstrCtxPath%>/js/screen/EshippingBookingNumberPopup.js" ></script>
<script type="text/javascript" language="JavaScript">
    var GET_BOOKING_NUMBER_TO_ESHIPPING_PAGE = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv006GetData", pageContext)%>';  
    var BROWSE_BOOKING_NUMBER = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv012LookUpData", pageContext)%>';
</script>
</head>

<body>    
    <html:form method="POST" action="/serv012">         
        <html:hidden name="feserv15" property="page"/>
        <input type="hidden" name="pageId" value="bookingPopup"/>
        <table class="table_search" border="0" width="100%" cellspacing="0" cellpadding="0">
            <tr>
                <td width="6%">Find</td>
                <td width="23%">
                    <html:text name="feserv15" property="tbxFind" onblur="changeUpper(this)"/>
                </td>
                <td width="7%">Column</td>
                <td width="23%">
                    <html:select name="feserv15" property="columnValue" size="1">
                        <html:optionsCollection name="feserv15" value="code" label="name" property="columnList"/>
                    </html:select>
                </td>
                <td width="8%" style="padding-left:6px">eSI Status</td>
                <td width="18%">
                    <html:select name="feserv15" property="statusValue" size="1">
                        <html:optionsCollection name="feserv15" value="code" label="name" property="statusList"/>
                    </html:select>
                </td>
                <td valign="top" style="padding-top:1px">
                    <a id="btnSearch" name="btnSearch" class="m-btn mini blue rnd"
                        href="#" onclick="searchBtn();" >&nbsp;Search
                    </a>
                    <a id="btnReset" name="btnReset" class="m-btn mini blue rnd"
                        href="#" onClick="resetBtn()">&nbsp;Reset
                    </a>
                </td>
            </tr>
            <tr>
                <td>Sort by</td>
                <td>
                    <html:select name="feserv15" property="sortByValue" size="1">
                        <html:optionsCollection name="feserv15" value="code" label="name" property="sortByList"/>
                    </html:select>
                </td>
                <td>Order by</td>
                <td>
                    <html:select name="feserv15" property="orderValue" size="1">
                        <html:optionsCollection name="feserv15" value="code" label="name" property="orderList"/>
                    </html:select>
                <td colspan="3">
                    <html:checkbox name="feserv15" property="chkBoxWildCard" style="float:left;border:0px;width:5%"/>Wild Card
                </td>
            </tr>
        </table><br>
        <table class="TablePopup">
        <tr>
            <td class="TdLeftHeaderPopup" width="11%"><%=EshippingInstructionDao.KEY_COLUMN_SHOW_BOOKING_DATE%></td>
            <td class="TdLeftHeaderPopup" width="11%"><%=EshippingInstructionDao.KEY_COLUMN_SHOW_BOOKING_NO%></td>
            <!-- @01 BEGIN--> 
            <td class="TdLeftHeaderPopup" width="21%"><%=EshippingInstructionDao.KEY_COLUMN_SHOW_SHIPPER_NAME%></td>
            <!-- @01 END-->
            <td class="TdLeftHeaderPopup" width="6%"><%=EshippingInstructionDao.KEY_COLUMN_SHOW_LEG_VESSEL%></td>
            <td class="TdLeftHeaderPopup" width="6%"><%=EshippingInstructionDao.KEY_COLUMN_SHOW_LEG_VOYAGE%></td>
            <td class="TdLeftHeaderPopup" width="11%"><%=EshippingInstructionDao.KEY_COLUMN_SHOW_POL%></td>
            <td class="TdLeftHeaderPopup" width="11%"><%=EshippingInstructionDao.KEY_COLUMN_SHOW_POD%></td>
            <td class="TdLeftHeaderPopup" width="11%"><%=EshippingInstructionDao.KEY_COLUMN_SHOW_STATUS%></td>
            <td class="TdLeftHeaderPopup"><%=EshippingInstructionDao.KEY_COLUMN_SHOW_BL_NO%></td>
        </tr>
    <logic:notEmpty name="feserv15" property="bookingList">
    <logic:iterate id="list" name="feserv15" property="bookingList" indexId="index">
    <%--    @02 BEGIN  --%>
        <tr id="row${index}" ondblclick="callbackToField('<bean:write name="list" property="bookingNo"/>', 
        '<bean:write name="list" property="blNo"/>', '<bean:write name="list" property="esiStatusCode"/>', 
        '<bean:write name="list" property="esiStatusDesc"/>', '<bean:write name="list" property="cocSoc"/>',
        '<bean:write name="list" property="polNo"/>','<bean:write name="list" property="podNo"/>')" 
        onclick="highlightRadioTD('row${index}')" style="cursor:hand;">
            <td class="TdLeftDetailPopup" height="20px"><bean:write name="list" property="bookingDate"/></td>
            <td class="TdLeftDetailPopup" height="20px"><bean:write name="list" property="bookingNo"/></td>
            <!-- @01 BEGIN-->
            <td class="TdLeftDetailPopup" height="20px"><bean:write name="list" property="shipperName"/></td>
            <!-- @01 END-->
            <td class="TdLeftDetailPopup" height="20px"><bean:write name="list" property="legVessel"/></td>
            <td class="TdLeftDetailPopup" height="20px"><bean:write name="list" property="legVoyage"/></td>
            <td class="TdLeftDetailPopup" height="20px"><bean:write name="list" property="pol"/></td>
            <td class="TdLeftDetailPopup" height="20px"><bean:write name="list" property="pod"/></td>
            <td class="TdLeftDetailPopup" height="20px"><bean:write name="list" property="esiStatusDesc"/></td>
            <td class="TdLeftDetailPopup" height="20px"><bean:write name="list" property="blNo"/></td>
        </tr>
    <%--    @02 END  --%>
    </logic:iterate>
    </logic:notEmpty>
    <logic:empty name="feserv15" property="bookingList">            
        <tr style="height: 20px">    
            <td colspan="8" align="center">No record found.</td>
        </tr>
    </logic:empty>
        </table>
        <jsp:include page="../common/tiles/pagination.jsp">
            <jsp:param name="formName" value="feserv15" />
        </jsp:include>
    </html:form>
</body>
