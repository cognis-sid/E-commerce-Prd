<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page import="com.niit.control.common.GlobalConstants" %>
<%@page import="com.niit.control.web.action.BaseAction" %>
<%@page import="com.niit.control.web.UserAccountBean" %>
<%@page import="com.niit.control.common.StringUtil" %>
<%@page import="java.util.List" %>
<%@page import="com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceCustomerPopupDao" %>
<%
    String lstrCtxPath     = request.getContextPath();
%>
<html:html>
<head>
<script type="text/javaScript" language="JavaScript" src="<%=lstrCtxPath%>/js/RutHelp.js" ></script>
<script type="text/javaScript" language="JavaScript" src="<%=lstrCtxPath%>/js/screen/EshippingCustomerPopup.js" ></script>
<script type="text/javaScript" language="JavaScript">
    var BROWSE_CUSTOMER_DATA = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv010LookUpData", pageContext)%>';
</script>
</head>
<body>    
<html:form method="POST" action="/serv010">     
    <input type="hidden" name="pageId" value="customerPopup"/>
    <html:hidden name="feserv07" property="defaultSearch" />
    <html:hidden name="feserv07" property="cocSoc" />
    <html:hidden name="feserv07" property="podCountry" />
    <table class="table_search" border="0" width="100%" cellspacing="0" cellpadding="0">
        <tr>
            <td width="10%">Find</td>
            <td width="30%">
                <html:text name="feserv07" property="tbxFind" onblur="changeUpper(this)"/>
            </td>
            <td width="10%">Column</td>
            <td width="25%">
                <html:select name="feserv07" property="columnValue" size="1">
                    <html:optionsCollection name="feserv07" value="code" label="name" property="columnList"/>
                </html:select>
            </td>
            <td valign="top" style="padding-top:1px;padding-left:9px;">
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
                <html:select name="feserv07" property="sortByValue" size="1">
                    <html:optionsCollection name="feserv07" value="code" label="name" property="sortByList"/>
                </html:select>
            </td>
            <td>Order by</td>
            <td>
                <html:select name="feserv07" property="orderValue" size="1">
                    <html:optionsCollection name="feserv07" value="code" label="name" property="orderList"/>
                </html:select>
            </td>    
            <td colspan="3" style="padding-top:3px">
                <html:checkbox name="feserv07" property="chkBoxWildCard" style="float:left;border:0px;width:15%"/>Wild Card
            </td>
        </tr>
    </table><br>
    <table class="TablePopup">
        <tr>
            <td class="TdLeftHeaderPopup" width="20%"><%=EserviceCustomerPopupDao.COLUMN_HEADER.CUSTOMER_CODE%></td>
            <td class="TdLeftHeaderPopup" width="67%"><%=EserviceCustomerPopupDao.COLUMN_HEADER.CUSTOMER_NAME%></td>
            <td class="TdLeftHeaderPopup"><%=EserviceCustomerPopupDao.COLUMN_HEADER.COUNTRY%></td>
        </tr>
    </table>
    <table class="TablePopup">
    <logic:notEmpty name="feserv07" property="customerList">
        <logic:iterate id="list" name="feserv07" property="customerList" indexId="index">
            <tr id="row${index}" ondblclick="callbackToField('<bean:write name="list" property="customerNameRe"/>', 
                '<bean:write name="list" property="address1"/>', '<bean:write name="list" property="address2"/>', 
                '<bean:write name="list" property="address3"/>', '<bean:write name="list" property="address4"/>', 
                '<bean:write name="list" property="countryCode"/>', '<bean:write name="list" property="customerCode"/>')" 
            onclick="highlightRadioTD('row${index}')" style="cursor:hand;">
                <td class="TdLeftDetailPopup" width="20%" height="20px">
                    <bean:write name="list" property="customerCode"/>
                </td>
                <td class="TdLeftDetailPopup" width="67%" height="20px">
                    <bean:write name="list" property="customerName"/>
                </td>
                <td class="TdLeftDetailPopup" height="20px">
                    <bean:write name="list" property="countryName"/>
                </td>
            </tr>
        </logic:iterate>
    </logic:notEmpty>
    <logic:empty name="feserv07" property="customerList">
        <tr style="height: 20px">    
            <td align="center">No record found.</td>
        </tr>
    </logic:empty>
    </table>
    <jsp:include page="../common/tiles/pagination.jsp">
        <jsp:param name="formName" value="feserv07" />
    </jsp:include>
</html:form>
</body>
</html:html>
