<%--
-------------------------------------------------------------------------------------------------------------
EserviceEquipmentTypePopUpScn.jsp
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
	<link rel="stylesheet" 	href="<%=lstrCtxPath%>/css/libraries/bootstrap.css" />
    <!-- add screen specific JavaScript file -->
    <script language="JavaScript" src="<%=lstrCtxPath%>/js/common/Constants.js" ></script>

    <script language="JavaScript" src="<%=lstrCtxPath%>/js/RutHelp.js" ></script>
    
    <!-- add javascript file for this screen -->
    <script language="JavaScript" src="<%=lstrCtxPath%>/js/screen/EserviceEquipmentTypePopUp.js" ></script>
    
    <script language="JavaScript">
        var GET_EQUIP_TYPE_LOOKUP_DATA     = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv028equipTypeLookUp", pageContext)%>';
    </script>

</head>

<body>    
    <html:form method="POST" styleId="frm" action="/serv028equipTypeLookUp">
        <html:hidden name="feserv28" property="errorMsg" styleId="errorMsg" />
        <html:hidden name="feserv28" property="userId" styleId="userId" />
        <html:hidden name="feserv28" property="rowIndex" styleId="rowIndex" />
        <table  border="0" width="100%" cellspacing="0" cellpadding="0">
            <tr>
                <td width="10%">Find</td>
                <td width="25%">
                    <html:text name="feserv28" property="find" styleId="find" onblur="changeUpper(this)"/>
                    
                </td>
                <td width="10%">Column</td>
                <td width="25%">
                    <html:select name="feserv28" property="column" styleId="column" size="1" style="width:180px">
                        <html:optionsCollection name="feserv28" value="code" label="name" property="columnList"/>
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
                    <html:select name="feserv28" property="sortBy" styleId="sortBy" size="1" style="width:180px">
                        <html:optionsCollection name="feserv28" value="code" label="name" property="sortByList"/>
                    </html:select>
                    
                </td>
                <td>Order by</td>
                <td>
                
                    <html:select name="feserv28" property="order" styleId="order" size="1" style="width:180px">
                        <html:optionsCollection name="feserv28" value="code" label="name" property="orderList"/>
                    </html:select>
                <td style="padding-top:3px;">
                    <html:checkbox name="feserv28" property="chkBoxWildCard" styleId="chkBoxWildCard" value="Y" style="float:left;border:0px;width:10%"/>Wild Card
                </td>
            </tr>
        </table>
        <br>
        <table border="0" width="100%" cellspacing="0" class="TablePopup table" >
            <tr>
                <td class="TdLeftHeaderPopup" width="20%">Code</td>
                <td class="TdLeftHeaderPopup" width="80%">Description</td>
            </tr>
        </table>
        
        <table border="0" width="100%" cellspacing="0" class="TablePopup table table-sm" >
            <logic:greaterThan value="0" name="feserv28" property="totRecord" >
                <logic:iterate name='feserv28' property='searchResultsList' indexId='ctr' id='rowdata'
                    type='com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceEquipmentTypePopUpMod'>
                    <tr id = '<%="row" + ctr %>'
                        ondblclick="callbackToField('<bean:write name="rowdata" property="code"/>',
                                                    '<bean:write name="rowdata" property="description"/>')"  
                        onclick="highlightradioTD('<%="row" + ctr %>')">
                        <td class="TdLeftDetailPopup" width="20%" height="20px;"><bean:write name="rowdata" property="code"/></td>
                        <td class="TdLeftDetailPopup" width="80%"  height="20px;"><bean:write name="rowdata" property="description"/></td>
                    </tr>
                </logic:iterate>
            </logic:greaterThan>
            <logic:equal  value="0" name="feserv28" property="totRecord" >
                <tr>
                    <td class="TdCentertDetailPopup" height="20px;" colspan="2" >
                        Record not found
                    </td>
                </tr>
            </logic:equal>
        </table>
        <jsp:include page="../common/tiles/pagination.jsp">
            <jsp:param name="formName" value="feserv28" />
        </jsp:include>
    </html:form>
</body>
