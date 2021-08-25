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
<html:html>
<head>
<link rel="stylesheet" 	href="<%=lstrCtxPath%>/css/libraries/bootstrap.css" />
<script type="text/javascript" language="JavaScript" src="<%=lstrCtxPath%>/js/RutHelp.js" ></script>
<script type="text/javascript" language="JavaScript" src="<%=lstrCtxPath%>/js/screen/EshippingPackageKindPopup.js" ></script>
<script type="text/javascript" language="JavaScript">
    var BROWSE_PACKGAE_KIND_DATA = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv011LookUpData", pageContext)%>';
</script>
</head>
<body style="margin:10px;">    
<html:form method="POST" action="/serv011">
    <html:hidden name="feserv09" property="packageCodeDocNameForSet"/>
    <html:hidden name="feserv09" property="packageNameDocNameForSet"/>
    <html:hidden name="feserv09" property="packageType"/>
    <html:hidden name="feserv09" property="rowForSet"/>
    <input type="hidden" name="pageId" value="packageKindPopup"/>
    <table  border="0" width="100%" cellspacing="0" cellpadding="0">
        <tr>
            <td width="9%">Find</td>
            <td width="28%">
                <html:text name="feserv09" property="tbxFind" onblur="changeUpper(this)"/>
            </td>
            <td width="9%">Column</td>
            <td width="30%">
                <html:select name="feserv09" property="columnValue" size="1" style="width:180px">
                    <html:optionsCollection name="feserv09" value="code" label="name" property="columnList"/>
                </html:select>
            </td>
            <td valign="top" style="padding-top:1px;padding-left:9px;">
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
                <html:select name="feserv09" property="sortByValue" size="1" style="width:180px">
                    <html:optionsCollection name="feserv09" value="code" label="name" property="sortByList"/>
                </html:select>
            </td>
            <td>Order by</td>
            <td colspan="2">
                <html:select name="feserv09" property="orderValue" size="1" style="width:180px">
                    <html:optionsCollection name="feserv09" value="code" label="name" property="orderList"/>
                </html:select>
            </td>    
        </tr>
    </table><br>
    <table class="TablePopup table">
        <tr>
            <td width="10%" class="TdLeftHeaderPopup">#</td>
            <td width="25%" class="TdLeftHeaderPopup">Package Kind Code</td>
            <td width="65%" class="TdLeftHeaderPopup">Package Kind</td>
        </tr>
    </table>
    <table class="TablePopup table table-sm">
<logic:notEmpty name="feserv09" property="packageList" >
    <logic:iterate id="list" name="feserv09" property="packageList" indexId="index">
        <tr id="row${index}" onclick="highlightRadioTD('row${index}')" style="cursor:hand;"
        ondblclick="callbackToField('<bean:write name="list" property="packageCode"/>', '<bean:write name="list" property="packageName"/>')" >
            <td class="TdLeftDetailPopup" width="10%" height="20px">
                <%=(index+1)%>
            </td>
            <td width="25%" class="TdLeftDetailPopup" height="20px"><bean:write name="list" property="packageCode"/></td>
            <td width="65%" class="TdLeftDetailPopup" height="20px"><bean:write name="list" property="packageName"/></td>
        </tr>
    </logic:iterate>
</logic:notEmpty>
<logic:empty name="feserv09" property="packageList">
    <tr style="height: 20px">    
        <td colspan="8" align="center">No record found.</td>
    </tr>
</logic:empty>
    </table>
    <jsp:include page="../common/tiles/pagination.jsp">
        <jsp:param name="formName" value="feserv09" />
    </jsp:include>
</html:form>
</body>
</html:html>
