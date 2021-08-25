<%--
-------------------------------------------------------------------------------------------------------------
EserviceCustomerTypePopup.jsp
-------------------------------------------------------------------------------------------------------------
Copyright RCL Public Co., Ltd. 2007
-------------------------------------------------------------------------------------------------------------  
Author anurak Thanapradit 05/07/13
- Change Log ------------------------------------------------------------------------------------------------
## DD/MM/YY      -User-          -TaskRef-         -ShortDescription-
## 07/10/2014    Pratya             01                PD_CR_20140826_ESV [Contract Party for registeration]
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
<%@page import="com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceCustomerPopupDao" %>
<%
    String lstrCtxPath     = request.getContextPath();
%>
<html:html>
<head>
<script type="text/javaScript" language="JavaScript" src="<%=lstrCtxPath%>/js/RutHelp.js" ></script>
<script type="text/javaScript" language="JavaScript" src="<%=lstrCtxPath%>/js/screen/EserviceCustomerTypePopup.js" ></script>
<script type="text/javaScript" language="JavaScript">
    var BROWSE_CUSTOMER_TYPE_DATA = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv016LookUpData", pageContext)%>';
</script>
</head>
<body>    
<html:form method="POST" action="/serv016">     
    <input type="hidden" name="pageId" value="customerTypePopup"/>
    <html:hidden name="feserv18" property="defaultSearch" />
    <!--Begin @01 -->
    <html:hidden name="feserv18" property="rowIndex" styleId="rowIndex" />
    <!--End @01 -->

    <table class="table_search" border="0" width="910" cellspacing="0" cellpadding="0">
        <tr>
            <td width="120">Find</td>
            <td width="200">
                <html:text name="feserv18" property="tbxFind" onblur="changeUpper(this)"/>
            </td>
            <td width="120">Column</td>
            <td width="200">
                <html:select name="feserv18" property="columnValue" size="1">
                    <html:optionsCollection name="feserv18" value="code" label="name" property="columnList"/>
                </html:select>
            </td>
            <td valign="top" width="260" style="padding-top:1px;padding-left:9px;">
                <a id="btnSearch" name="btnSearch" class="m-btn mini blue rnd"
                    href="javascript: void(0)" onClick="searchBtn()">&nbsp;Search
                </a>
                <a id="btnReset" name="btnReset" class="m-btn mini blue rnd"
                    href="javascript: void(0)" onClick="resetBtn()">&nbsp;Reset
                </a>
            </td>
        </tr>
        <tr>
            <td>Sort by</td>
            <td>
                <html:select name="feserv18" property="sortByValue" size="1">
                    <html:optionsCollection name="feserv18" value="code" label="name" property="sortByList"/>
                </html:select>
            </td>
            <td>Order by</td>
            <td>
                <html:select name="feserv18" property="orderValue" size="1">
                    <html:optionsCollection name="feserv18" value="code" label="name" property="orderList"/>
                </html:select>
            </td>    
            <td style="padding-top:3px">
                <html:checkbox name="feserv18" property="chkBoxWildCard" value="Y" style="float:left;border:0px;width:15%"/>Wild Card
            </td>
        </tr>
    </table><br>
    <table class="TablePopup" width="910">
        <tr>
            <td class="TdLeftHeaderPopup" width="15%"><%=EserviceCustomerPopupDao.COLUMN_HEADER.CUSTOMER_TYPE%></td>
            <td class="TdLeftHeaderPopup" width="60%"><%=EserviceCustomerPopupDao.COLUMN_HEADER.DESCRIPTION%></td>
            <td class="TdLeftHeaderPopup" width="15%"><%=EserviceCustomerPopupDao.COLUMN_HEADER.ORGANIZATION_TYPE%></td>
            <td class="TdLeftHeaderPopup" width="10%"><%=EserviceCustomerPopupDao.COLUMN_HEADER.STATUS%></td>
        </tr>
    </table>
    <table class="TablePopup"width="910">
    <logic:notEmpty name="feserv18" property="customerList">
        <logic:iterate id="list" name="feserv18" property="customerList" indexId="index">
            <tr id="row${index}" ondblclick="callbackToField('<bean:write name="list" property="customerType"/>', 
                '<bean:write name="list" property="description"/>', '<bean:write name="list" property="organizationType"/>', 
                '<bean:write name="list" property="status"/>')" 
            onclick="highlightRadioTD('row${index}')" style="cursor:hand;">
                <td class="TdLeftDetailPopup" width="15%" height="20px">
                    <bean:write name="list" property="customerType"/>
                </td>
                <td class="TdLeftDetailPopup" width="60%" height="20px">
                    <bean:write name="list" property="description"/>
                </td>
                <td class="TdLeftDetailPopup" width="15%" height="20px">
                    <bean:write name="list" property="organizationType"/>
                </td>
                <td class="TdLeftDetailPopup" width="10%" height="20px">
                    <bean:write name="list" property="status"/>
                </td>
            </tr>
        </logic:iterate>
    </logic:notEmpty>
    <logic:empty name="feserv18" property="customerList">
        <tr style="height: 20px">    
            <td align="center">No record found.</td>
        </tr>
    </logic:empty>
    </table>
    <jsp:include page="../common/tiles/pagination.jsp">
        <jsp:param name="formName" value="feserv18" />
    </jsp:include>
</html:form>
</body>
</html:html>
