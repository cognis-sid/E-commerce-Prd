<%--
-------------------------------------------------------------------------------------------------------------
EserviceCustomerPopup.jsp
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
<head>
<script type="text/javaScript" language="JavaScript" src="<%=lstrCtxPath%>/js/RutHelp.js" ></script>
<script type="text/javaScript" language="JavaScript" src="<%=lstrCtxPath%>/js/screen/EserviceCustomerPopup.js" ></script>
<script type="text/javaScript" language="JavaScript">
    var BROWSE_CUSTOMER_DATA = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv014LookUpData", pageContext)%>';
</script>
</head>
<body>
    <html:form method="POST" action="/serv014">   
        <input type="hidden" name="pageId" value="customerPopup"/>
        <html:hidden name="feserv16" property="defaultSearch" />
        <html:hidden name="feserv16" property="userId" />
        <html:hidden name="feserv16" property="fscCode" />
        <html:hidden name="feserv16" property="controlFsc" />
        <!--Begin @01 -->
        <html:hidden name="feserv16" property="rowIndex" styleId="rowIndex" />
        <!--End @01 -->
        
        <table class="table_search" border="0" width="100%" cellspacing="0" cellpadding="0">
            <tr>
                <td width="120">Find</td>
                <td width="200">
                    <html:text name="feserv16" property="tbxFind" onblur="changeUpper(this)"/>
                </td>
                <td width="120">Column</td>
                <td width="200">
                    <html:select name="feserv16" property="columnValue" size="1">
                        <html:optionsCollection name="feserv16" value="code" label="name" property="columnList"/>
                    </html:select>
                </td>
                <td width="820" valign="top" style="padding-left:7px;padding-top:1px;">
                <div id="controlDiv">
                    <a id="btnSearch" name="btnSearch" class="m-btn mini blue rnd"
                        href="javascript: void(0)" onClick="searchBtn()">&nbsp;Search
                    </a>
                    <a id="btnReset" name="btnReset" class="m-btn mini blue rnd"
                        href="javascript: void(0)" onClick="resetBtn()">&nbsp;Reset
                    </a>
                </div>
                </td>
            </tr>
            <tr>
                <td>Sort by</td>
                <td>
                    <html:select name="feserv16" property="sortByValue" size="1">
                        <html:optionsCollection name="feserv16" value="code" label="name" property="sortByList"/>
                    </html:select>
                </td>
                <td>Order by</td>
                <td>
                    <html:select name="feserv16" property="orderValue" size="1">
                        <html:optionsCollection name="feserv16" value="code" label="name" property="orderList"/>
                    </html:select>
                </td>    
                <td style="padding-top:3px" align="left">
                    <html:checkbox name="feserv16" property="chkBoxWildCard" style="float:left;border:0px;width:10%;" styleId="chkBoxWildCard"  />Wild Card
                    <script>document.getElementById("chkBoxWildCard").checked = true; </script>
                </td>
            </tr>
        </table>
        <br>
        <div style="height: 400px;overflow-y:auto;width:100%;">
                <table border=0 cellSpacing=0 cellPadding=0 id="t_main" width="98%" >
                    <tr>
                        <td>
                            <TABLE border=0	cellSpacing=0 width="100%" class=TablePopup style="POSITION: relative;  TOP: expression(offsetParent.scrollTop);">
                                    <COLGROUP>
                                        <COL class=TdLeftHeaderPopup width="4%">
                                        <COL class=TdLeftHeaderPopup width="9%">
                                        <COL class=TdLeftHeaderPopup width="9%">
                                        <COL class=TdLeftHeaderPopup width="15%">
                                        <COL class=TdLeftHeaderPopup width="9%">
                                        <COL class=TdLeftHeaderPopup width="9%">
                                        <COL class=TdLeftHeaderPopup width="9%">
                                        <COL class=TdLeftHeaderPopup width="9%">
                                        <COL class=TdLeftHeaderPopup width="9%">
                                        <COL class=TdLeftHeaderPopup width="9%">
                                        <COL class=TdLeftHeaderPopup width="9%">
                                    </COLGROUP>
                                    <TR>
                                        <TD>Seq#</TD>
                                        <TD>Customer Code</TD>
                                        <TD>Description</TD>
                                        <TD>Address</TD>
                                        <TD>City Name</TD>
                                        <TD>Telephone</TD>
                                        <TD>Fax	No.</TD>
                                        <TD>Email</TD>
                                        <TD>Country	Code</TD>
                                        <TD>Country	Name</TD>
                                        <TD>Consolidated</TD>
                                    </TR>
                            </TABLE>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <TABLE border=0	cellSpacing=0 width="100%" class=TablePopup>
                                <COLGROUP>
                                        <COL class=TdLeftDetailPopup width="4%">
                                        <COL class=TdLeftDetailPopup width="9%">
                                        <COL class=TdLeftDetailPopup width="9%">
                                        <COL class=TdLeftDetailPopup width="15%">
                                        <COL class=TdLeftDetailPopup width="9%">
                                        <COL class=TdLeftDetailPopup width="9%">
                                        <COL class=TdLeftDetailPopup width="9%">
                                        <COL class=TdLeftDetailPopup width="9%">
                                        <COL class=TdLeftDetailPopup width="9%">
                                        <COL class=TdLeftDetailPopup width="9%">
                                        <COL class=TdLeftDetailPopup width="9%">
                                </COLGROUP>
                                <COLGROUP>
                                        <COL class=TdLeftDetailPopup width="100%">
                                </COLGROUP>
                                <logic:notEmpty name="feserv16" property="customerList">
                                    <logic:iterate id="list" name="feserv16" property="customerList" indexId="index">
                                    <div style="height:0px;display:none;">
                                        <input type="hidden" id="custDesc" name="custDesc" value="<bean:write name="list" property="description"/>" />
                                    </div>
                                    <tr id="row${index}" ondblclick="callbackToField('<bean:write name="list" property="customerCode"/>',document.getElementById('custDesc').value, '<bean:write name="list" property="fscCode"/>', '<bean:write name="list" property="customerType"/>');"
                                        onclick="highlightRadioTD('row${index}')" style="cursor: pointer;">
                                        <td title='<bean:write name="list" property="rownum"/>'>
                                            <bean:write name="list" property="rownum"/>
                                        </td>
                                        <td title='<bean:write name="list" property="customerCode"/>'>
                                            <bean:write name="list" property="customerCode"/>
                                        </td>
                                        <td title='<bean:write name="list" property="description"/>'>
                                            <bean:write name="list" property="description"/>
                                        </td>
                                        <td title='<bean:write name="list" property="address"/>'>
                                            <bean:write name="list" property="address"/>
                                        </td>
                                        <td title='<bean:write name="list" property="cityName"/>'>
                                            <bean:write name="list" property="cityName"/>
                                        </td>
                                        <td title='<bean:write name="list" property="telephone"/>'>
                                            <bean:write name="list" property="telephone"/>
                                        </td>
                                        <td title='<bean:write name="list" property="faxNo"/>'>
                                            <bean:write name="list" property="faxNo"/>
                                        </td>
                                        <td title='<bean:write name="list" property="email"/>'>
                                            <script>
                                                var str = '<bean:write name="list" property="email"/>';
                                                if(str.length > 10){
                                                    document.write(str.substring(0,10) + '...');
                                                }else{
                                                    document.write(str);
                                                }
                                            </script>
                                        </td>
                                        <td title='<bean:write name="list" property="countryCode"/>'>
                                            <bean:write name="list" property="countryCode"/>
                                        </td>
                                        <td title='<bean:write name="list" property="countryName"/>'>
                                            <bean:write name="list" property="countryName"/>
                                        </td>
                                        <td title='<bean:write name="list" property="consolidated"/>'>
                                            <bean:write name="list" property="consolidated"/>
                                        </td>
                                    </tr>
                                    </logic:iterate>
                                </logic:notEmpty>
                                <logic:empty name="feserv16" property="customerList">
                                    <tr>    
                                        <td colspan="11" align="center">No record found.</td>
                                    </tr>
                                </logic:empty>
                            </TABLE>
                        </td>
                    </tr>
                </table>
	  </div>
        <jsp:include page="../common/tiles/pagination.jsp">
            <jsp:param name="formName" value="feserv16" />
        </jsp:include>
    </html:form>
</body>
