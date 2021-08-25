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
<html:html>
<head>
<link rel="stylesheet" href="<%=lstrCtxPath%>/css/libraries/bootstrap.css">
<!-- add screen specific JavaScript file -->
<script type="text/javascript" language="JavaScript" src="<%=lstrCtxPath%>/js/common/Constants.js" ></script>
<script  type="text/javascript" language="JavaScript" src="<%=lstrCtxPath%>/js/RutHelp.js" ></script>
<!-- add javascript file for this screen -->
<script type="text/javascript" language="JavaScript" src="<%=lstrCtxPath%>/js/screen/EshippingCommodityPopup.js" ></script>
<script type="text/javascript" language="JavaScript">
    var SET_COMMODITY_DATA
        = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv006SetCommodityData", pageContext)%>';
    var BROWSE_COMMODITY 
        = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv013LookUpData", pageContext)%>';
</script>
</head>

<body style="margin:10px;">    
<html:form method="POST" action="/serv013">     
    <html:hidden name="feserv11" property="page"/>
    <input type="hidden" name="pageId" value="commodityPopup"/>
    <html:hidden name="feserv11" property="commodityRowIndex"/>
    <table class="table_search" border="0" width="100%" cellspacing="0" cellpadding="0">
        <tr>
            <td width="10%">Commodity Group</td>
            <td colspan="4">
                <html:select name="feserv11" property="commodityGroup" styleId="commodityGroup" style="width:180px">
                    <html:optionsCollection name="feserv11" value="code" label="name" property="commodityGroupList"/>
                </html:select>
            </td>
        </tr>
        <tr>
            <td width="10%">HS Code</td>
            <td colspan="4">
                <html:text name="feserv11" property="commodityCode" styleId="commodityCode"   maxlength="255" onblur="gp_objTrim(this)" />
            </td>
        </tr>
         <tr>
            <td width="10%">Commodity Desc</td>
            <td colspan="4">
                <html:text name="feserv11" property="commodityDesc" styleId="commodityDesc"   maxlength="255" onblur="gp_objTrim(this)" />
            </td>
        </tr>
        <tr>
            <td>Sort by</td>
            <td>
                <html:select name="feserv11" property="sortBy" styleId="sortBy" size="1">
                    <html:optionsCollection name="feserv11" value="code" label="name" property="sortByList"/>
                </html:select>
                
            </td>
            <td>Order by</td>
            <td>
            
                <html:select name="feserv11" property="orderBy" styleId="orderBy" size="1">
                    <html:optionsCollection name="feserv11" value="code" label="name" property="orderList"/>
                </html:select>
            <td style="padding-top:3px;">
                <html:checkbox name="feserv11" property="chkBoxWildCard" styleId="chkBoxWildCard" style="float:left;border:0px;width:15px;" value="Y" />Wild Card
                <script>document.getElementById("chkBoxWildCard").checked = true; </script>
                <a id="btnSearch" name="btnSearch" class="btn btn-primary rounded-sm"
                    href="#" onClick="searchBtn()">&nbsp;Search
                </a>
                <a id="btnReset" name="btnReset" class="btn btn-secondary rounded-sm"
                    href="#" onClick="resetBtn()">&nbsp;Reset
                </a>
            </td>
        </tr>
    </table>
    <br>
    <table border="0" width="100%" cellspacing="0" class="TablePopup table" style="tabke-layout: fixed; margin-bottom: 0px;">
        <tr>
            <td class="TdLeftHeaderPopup" width="5%">#</td>
            <td class="TdLeftHeaderPopup" width="15%">HS Code</td>
            <td class="TdLeftHeaderPopup" width="65%">Commodity Description</td>
            <td class="TdLeftHeaderPopup" width="15%">Commodity Group</td>
        </tr>
    </table>
    
    <table border="0" width="100%" cellspacing="0" class="TablePopup table table-sm" >
    <logic:empty name="listCommodity" scope="request">
        <tr style="height: 20px">    
            <td colspan="3" align="center">No record found.</td>
        </tr>
    </logic:empty>
    <logic:notEmpty name="feserv11" property="commodityList">
        <%--logic:iterate id="listLookupDataId" name="listCommodity" indexId="rowIndex"--%>
        <logic:iterate id="listLookupDataId" name="feserv11" property="commodityList" indexId="rowIndex">
            <bean:define id="newRowIndex" value="${rowIndex+1}" />
            <tr ondblclick="callbackToField('<bean:write name="listLookupDataId" property="commCode"/>','<bean:write name="listLookupDataId" property="commDesc"/>','<bean:write name="listLookupDataId" property="commGrpCode"/>','<bean:write name="listLookupDataId" property="commGrpDesc"/>','<bean:write name="feserv11" property="commodityRowIndex" />')"  
                onclick="highlightradioTD('<bean:write name="newRowIndex" />')" style="cursor:hand;">
                <td width="5%" class="TdLeftDetailPopup" height="20px">
                    <bean:write name="newRowIndex" />
                </td>
                <td width="15%" class="TdLeftDetailPopup" height="20px">
                    <bean:write name="listLookupDataId" property="commCode" />
                </td>
                <td width="65%" class="TdLeftDetailPopup" height="20px">
                    <bean:write name="listLookupDataId" property="commDesc"/>
                </td>
                <td width="15%" class="TdLeftDetailPopup" height="20px">
                    <bean:write name="listLookupDataId" property="commGrpDesc" />
                </td>
            </tr>
        </logic:iterate>
    </logic:notEmpty>            
    </table>
    <jsp:include page="../common/tiles/pagination.jsp">
        <jsp:param name="formName" value="feserv11" />
    </jsp:include>
</html:form>
</body>
</html:html>
