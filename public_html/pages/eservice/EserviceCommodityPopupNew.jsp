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
	<link rel="stylesheet" 	href="<%=lstrCtxPath%>/css/libraries/bootstrap.css" />
    <!-- add screen specific JavaScript file -->
    <script language="JavaScript" src="<%=lstrCtxPath%>/js/common/Constants.js" ></script>

    <script language="JavaScript" src="<%=lstrCtxPath%>/js/RutHelp.js" ></script>
    
    <!-- add javascript file for this screen -->
    <script language="JavaScript" src="<%=lstrCtxPath%>/js/screen/EserviceCommodityPopup.js" ></script>
    
    <script language="JavaScript">
        var GET_LOOKUP_DATA 
            = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn004LookupData", pageContext)%>';
        var NEW_WEB_BOOKING 
            = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/sexn001", pageContext)%>';
    </script>

</head>

<body style="margin:10px;">    
    <html:form method="POST" action="/sexn002">         
        <html:hidden name="feserv04" property="commodityRowIndex"/>
        <table  border="0" width="100%" cellspacing="0" cellpadding="0">
            <tr>
                <td width="10%">Find</td>
                <td width="25%">
                    <html:text name="feserv04" property="find" onblur="changeUpper(this)"/>
                    
                </td>
                <td width="10%">Column</td>
                <td width="25%">
                    <html:select name="feserv04" property="column" size="1" style="width:180px">
                        <html:optionsCollection name="feserv04" value="code" label="name" property="columnList"/>
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
                    <html:select name="feserv04" property="sortBy" size="1" style="width:180px">
                        <html:optionsCollection name="feserv04" value="code" label="name" property="sortByList"/>
                    </html:select>
                    
                </td>
                <td>Order by</td>
                <td>
                
                    <html:select name="feserv04" property="order" size="1" style="width:180px">
                        <html:optionsCollection name="feserv04" value="code" label="name" property="orderList"/>
                    </html:select>
                <td style="padding-top:3px;">
                    <html:checkbox name="feserv04" property="chkBoxWildCard" styleId="chkBoxWildCard" style="float:left;border:0px;width:15px;" value="Y" />Wild Card
                    <script>document.getElementById("chkBoxWildCard").checked = true; </script>
                </td>
            </tr>
        </table>
        <br>
        <table border="0" width="100%" cellspacing="0" class="TablePopup table" >
            <tr>
                <td class="TdLeftHeaderPopup" width="20%">Description</td>
                <!-- 
                <td class="TdLeftSubColor" width="20%">Code</td>
                -->
            </tr>
        </table>
        
        <table border="0" width="100%" cellspacing="0" class="TablePopup table table-sm">
            <%
                List list = (List)request.getAttribute("listLookupData");     
            if(null == list){
                    
            %>
                <%-- 
                    <tr height="20px">    
                        <td colspan="6" align="center">No record found.</td>
                    </tr>
                --%>
            
            <%} else if (!list.isEmpty()){
                     int x = 0;
            %>
                <logic:iterate name="listLookupData" id="listLookupDataId">
                    <tr id="row<%=x%>" 
                        ondblclick="callbackToFieldNew('<bean:write name="listLookupDataId" property="code"/>',
                            '<bean:write name="listLookupDataId" property="description"/>',
                            '<bean:write name="feserv04" property="commodityRowIndex"/>')"  
                        onclick="highlightradioTD('row<%=x%>')">
                        
                        <td class="TdLeftDetailPopup" height="20px"><bean:write name="listLookupDataId" property="description"/></td>
                <!-- 
                        <td height="20px"><bean:write name="listLookupDataId" property="code"/></td>
                -->
                    </tr>
                    <% x++; %>
                </logic:iterate>
            
            <%}%>
            
        </table>
        <jsp:include page="../common/tiles/pagination.jsp">
            <jsp:param name="formName" value="feserv04" />
        </jsp:include>
    </html:form>
</body>
