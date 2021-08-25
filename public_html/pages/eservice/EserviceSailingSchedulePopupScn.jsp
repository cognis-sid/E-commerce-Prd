<%--
-------------------------------------------------------------------------------------------------------------
EserviceSailingSchedulePopupScn.jsp
-------------------------------------------------------------------------------------------------------------
Copyright RCL Public Co., Ltd. 2007
-------------------------------------------------------------------------------------------------------------  
Author Pratya Thanuchaisak 11/09/2014
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
    <script language="JavaScript" src="<%=lstrCtxPath%>/js/screen/EserviceSailingSchedulePopup.js" ></script>
    
    <script language="JavaScript">
        var GET_HAULAGE_LOOKUP_DATA     = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv027hualageLookUp", pageContext)%>';
        var GET_PORT_LOOKUP_DATA        = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv027portLookUp", pageContext)%>';
        var GET_PLACE_LOOKUP_DATA       = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv027placeLookUp", pageContext)%>';
    </script>

</head>
<link rel="stylesheet" 	href="<%=lstrCtxPath%>/css/libraries/bootstrap.css" />
<body>    
    <html:form method="POST" styleId="frm" action="/serv027hualageLookUp">
        <html:hidden name="feserv27" property="flag" styleId="flag" />
        <html:hidden name="feserv27" property="errorMsg" styleId="errorMsg" />
        <html:hidden name="feserv27" property="userId" styleId="userId" />
        <html:hidden name="feserv27" property="rowIndex" styleId="rowIndex" />
        <html:hidden name="feserv27" property="objName" styleId="objName" />
        <table class="table_search" border="0" width="100%" cellspacing="0" cellpadding="0">
            <tr>
                <td width="10%">Find</td>
                <td width="25%">
                    <html:text name="feserv27" property="find" styleId="find" onblur="changeUpper(this)" styleClass="form-control input-field"/>
                    
                </td>
                <td width="10%">Column</td>
                <td width="25%">
                    <html:select name="feserv27" property="column" styleId="column" size="1" styleClass="form-control input-field">
                        <html:optionsCollection name="feserv27" value="code" label="name" property="columnList"/>
                    </html:select>
                </td>
                <td valign="top" style="padding-left:7px;padding-top:1px;">
                    <a id="btnSearch" name="btnSearch" class="btn btn-primary rounded-sm"
                        href="#" onClick="searchBtn()">&nbsp;Search
                    </a>
                    <a id="btnReset" name="btnReset" class="btn btn-secondary rounded-sm"
                        href="#" onClick="resetBtn()">&nbsp;Reset
                    </a>
                </td>
            </tr>
            <tr>
                <td>Sort by</td>
                <td>
                    <html:select name="feserv27" property="sortBy" styleId="sortBy" size="1" styleClass="form-control input-field" >
                        <html:optionsCollection name="feserv27" value="code" label="name" property="sortByList"/>
                    </html:select>
                    
                </td>
                <td>Order by</td>
                <td>
                
                    <html:select name="feserv27" property="order" styleId="order" size="1" styleClass="form-control input-field">
                        <html:optionsCollection name="feserv27" value="code" label="name" property="orderList"/>
                    </html:select>
                <td style="padding-top:3px;">
                    <html:checkbox name="feserv27" property="chkBoxWildCard" styleId="chkBoxWildCard" value="Y" style="float:left;border:0px;width:10%"/>Wild Card
                </td>
            </tr>
        </table>
        <br>
        <table border="0" width="100%" cellspacing="0" class="TablePopup" >
            <tr>
                <td class="TdLeftHeaderPopup" width="20%">Code</td>
                <td class="TdLeftHeaderPopup" width="80%">Description</td>
            </tr>
        </table>
        
        <table border="0" width="100%" cellspacing="0" class="TablePopup" >
            <logic:greaterThan value="0" name="feserv27" property="totRecord" >
                <logic:iterate name='feserv27' property='searchResultsList' indexId='ctr' id='rowdata'
                    type='com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceSailingSchedulePopupMod'>
                    <tr id = '<%="row" + ctr %>'
                        ondblclick="callbackToField('<bean:write name="rowdata" property="code"/>',
                                                    '<bean:write name="rowdata" property="description"/>')"  
                        onclick="highlightradioTD('<%="row" + ctr %>')">
                        <td class="TdLeftDetailPopup" width="20%" height="20px;"><bean:write name="rowdata" property="code"/></td>
                        <td class="TdLeftDetailPopup" width="80%"  height="20px;"><bean:write name="rowdata" property="description"/></td>
                    </tr>
                </logic:iterate>
            </logic:greaterThan>
            <logic:equal  value="0" name="feserv27" property="totRecord" >
                <tr>
                    <td class="TdCentertDetailPopup" height="20px;" colspan="2" >
                        Record not found
                    </td>
                </tr>
            </logic:equal>
        </table>
        <jsp:include page="../common/tiles/pagination.jsp">
            <jsp:param name="formName" value="feserv27" />
        </jsp:include>
    </html:form>
</body>
