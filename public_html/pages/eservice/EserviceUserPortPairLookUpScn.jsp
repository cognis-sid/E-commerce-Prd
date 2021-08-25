<%--
-------------------------------------------------------------------------------------------------------------
EserviceUserPortPairLookUpScn.jsp
-------------------------------------------------------------------------------------------------------------
Copyright RCL Public Co., Ltd. 2007
-------------------------------------------------------------------------------------------------------------
Author Pratya Thanuchaisak 21/10/2014
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
<%
    String lstrCtxPath     = request.getContextPath();
%>

<head>
    <!-- add screen specific JavaScript file -->
    <script language="JavaScript" src="<%=lstrCtxPath%>/js/common/Constants.js" ></script>

    <script language="JavaScript" src="<%=lstrCtxPath%>/js/RutHelp.js" ></script>

    <!-- add javascript file for this screen -->
    <script language="JavaScript" src="<%=lstrCtxPath%>/js/screen/EserviceUserPortPairLookUp.js" ></script>

    <script language="JavaScript">
        var LOOKUP_DATA     = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv030lookUp", pageContext)%>';
    </script>

</head>

<body>
    <html:form method="POST" styleId="frm" action="/serv030lookUp">
        <html:hidden name="feserv30" property="errorMsg" styleId="errorMsg" />
        <html:hidden name="feserv30" property="userLoginId" styleId="userLoginId" />
        <html:hidden name="feserv30" property="rowIndex" styleId="rowIndex" />
        <table class="table_search" border="0" width="100%" cellspacing="0" cellpadding="0">
            <tr>
                <td width="10%">Find</td>
                <td width="25%">
                    <html:text name="feserv30" property="find" styleId="find" onblur="changeUpper(this)"/>

                </td>
                <td width="10%">Column</td>
                <td width="25%">
                    <html:select name="feserv30" property="column" styleId="column" size="1">
                        <html:optionsCollection name="feserv30" value="code" label="name" property="columnList"/>
                    </html:select>
                </td>
                <td valign="top" style="padding-left:7px;padding-top:1px;">
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
                    <html:select name="feserv30" property="sortBy" styleId="sortBy" size="1">
                        <html:optionsCollection name="feserv30" value="code" label="name" property="sortByList"/>
                    </html:select>

                </td>
                <td>Order by</td>
                <td>

                    <html:select name="feserv30" property="order" styleId="order" size="1">
                        <html:optionsCollection name="feserv30" value="code" label="name" property="orderList"/>
                    </html:select>
                <td style="padding-top:3px;">
                    <html:checkbox name="feserv30" property="chkBoxWildCard" styleId="chkBoxWildCard" value="Y" style="float:left;border:0px;width:10%;" />Wild Card
                </td>
            </tr>
        </table>
        <br>
        <table border="0" width="100%" cellspacing="0" class="TablePopup" >
            <tr>
                <td class="TdLeftHeaderPopup" width="20%">User Id</td>
                <td class="TdLeftHeaderPopup" width="40%">User Name</td>
                <td class="TdLeftHeaderPopup" width="40%">Company Name</td>
            </tr>
        </table>

        <table border="0" width="100%" cellspacing="0" class="TablePopup" >
            <logic:greaterThan value="0" name="feserv30" property="totRecord" >
                <logic:iterate name='feserv30' property='searchResultsList' indexId='ctr' id='rowdata'
                    type='com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceUserPortPairLookUpMod'>
                    <tr id = '<%="row" + ctr %>'
                        ondblclick="callbackToField('<bean:write name="rowdata" property="userId"/>',
                                                    '<bean:write name="rowdata" property="userName"/>',
                                                    '<bean:write name="rowdata" property="companyName"/>',
                                                    '<bean:write name="rowdata" property="contractCompany"/>')"
                        onclick="highlightradioTD('<%="row" + ctr %>')">
                        <td class="TdLeftDetailPopup" width="20%" height="20px;"><bean:write name="rowdata" property="userId"/></td>
                        <td class="TdLeftDetailPopup" width="40%"  height="20px;"><bean:write name="rowdata" property="userName"/></td>
                        <td class="TdLeftDetailPopup" width="40%"  height="20px;"><bean:write name="rowdata" property="companyName"/></td>
                    </tr>
                </logic:iterate>
            </logic:greaterThan>
            <logic:equal  value="0" name="feserv30" property="totRecord" >
                <tr>
                    <td class="TdCentertDetailPopup" height="20px;" colspan="3" >
                        Record not found
                    </td>
                </tr>
            </logic:equal>
        </table>
        <jsp:include page="../common/tiles/pagination.jsp">
            <jsp:param name="formName" value="feserv30" />
        </jsp:include>
    </html:form>
</body>
