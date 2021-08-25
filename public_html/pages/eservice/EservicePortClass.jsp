<%--
-------------------------------------------------------------------------------------------------------------
EservicePortClass.jsp
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
    <script language="JavaScript" src="<%=lstrCtxPath%>/js/screen/EservicePortClass.js" ></script>
    
    <script language="JavaScript">
        var GET_LOOKUP_DATA = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv022LookupData", pageContext)%>';
    </script>

</head>

<body>    
    <html:form method="POST" styleId="frm" action="/serv022">
        <table class="table_search" border="0" width="100%" cellspacing="0" cellpadding="0">
            <tr>
                <td width="10%">Find</td>
                <td width="25%">
                    <html:text name="feserv22" property="find" styleId="find" onblur="changeUpper(this)"/>
                    
                </td>
                <td width="10%">Column</td>
                <td width="25%">
                    <html:select name="feserv22" property="column" styleId="column" size="1">
                        <html:optionsCollection name="feserv22" value="code" label="name" property="columnList"/>
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
                    <html:select name="feserv22" property="sortBy" styleId="sortBy" size="1">
                        <html:optionsCollection name="feserv22" value="code" label="name" property="sortByList"/>
                    </html:select>
                    
                </td>
                <td>Order by</td>
                <td>
                
                    <html:select name="feserv22" property="order" styleId="order" size="1">
                        <html:optionsCollection name="feserv22" value="code" label="name" property="orderList"/>
                    </html:select>
                <td style="padding-top:3px;">
                    <html:checkbox name="feserv22" property="chkBoxWildCard" styleId="chkBoxWildCard" value="Y" style="float:left;border:0px;width:10%"/>Wild Card
                </td>
            </tr>
        </table>
        <br>
        <table border="0" width="100%" cellspacing="0" class="TablePopup" >
            <tr>
                <td class="TdLeftHeaderPopup" width="10%">Port class type</td>
                <td class="TdLeftHeaderPopup" width="10%">Port Class</td>
                <td class="TdLeftHeaderPopup" width="10%">UNNO</td>
                <td class="TdLeftHeaderPopup" width="10%">VARIANT</td>
                <td class="TdLeftHeaderPopup" width="10%">IMDG</td>
                <td class="TdLeftHeaderPopup" width="40%">PSN</td>
                <td class="TdLeftHeaderPopup" width="10%">RECORD STATUS</td>
                <!-- 
                <td class="TdLeftSubColor" width="20%">Code</td>
                -->
            </tr>
        </table>
        
        <table border="0" width="100%" cellspacing="0" class="TablePopup" >
            <logic:greaterThan value="0" name="feserv22" property="totRecord" >
                <logic:iterate name='feserv22' property='tableData' indexId='ctr' id='rowdata'
                    type='com.rclgroup.dolphin.rcl.web.eservice.vo.EservicePortClassMod'>
                    <tr id = '<%="row" + ctr %>'
                        ondblclick="callbackToField('<bean:write name="rowdata" property="portClassCode"/>',
                                                    '<bean:write name="rowdata" property="unno"/>',
                                                    '<bean:write name="rowdata" property="variant"/>',
                                                    '<bean:write name="rowdata" property="imdgClass"/>')"  
                        onclick="highlightradioTD('<%="row" + ctr %>')">
                        <td class="TdLeftDetailPopup" width="10%"  height="20px;"><bean:write name="rowdata" property="portClassType"/></td>
                        <td class="TdLeftDetailPopup" width="10%" height="20px;"><bean:write name="rowdata" property="portClassCode"/></td>
                        <td class="TdLeftDetailPopup" width="10%"  height="20px;"><bean:write name="rowdata" property="unno"/></td>
                        <td class="TdLeftDetailPopup" width="10%"  height="20px;"><bean:write name="rowdata" property="variant"/></td>
                        <td class="TdLeftDetailPopup" width="10%"  height="20px;"><bean:write name="rowdata" property="imdgClass"/></td>
                        <td class="TdLeftDetailPopup" width="40%"  height="20px;"><bean:write name="rowdata" property="psn"/></td>
                        <td class="TdLeftDetailPopup" width="10%"  height="20px;"><bean:write name="rowdata" property="recStatus"/></td>
                    </tr>
                </logic:iterate>
            </logic:greaterThan>
            <logic:equal  value="0" name="feserv22" property="totRecord" >
                <tr>
                    <td class="TdCentertDetailPopup" height="20px;" colspan="7" >
                        Record not found
                    </td>
                </tr>
            </logic:equal>
        </table>
        <jsp:include page="../common/tiles/pagination.jsp">
            <jsp:param name="formName" value="feserv22" />
        </jsp:include>
    </html:form>
</body>
