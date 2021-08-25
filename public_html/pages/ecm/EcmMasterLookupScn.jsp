<%--
-------------------------------------------------------------------------------------------------------------
EcmMasterLookupScn.jsp
-------------------------------------------------------------------------------------------------------------
Copyright RCL Public Co., Ltd. 2007
-------------------------------------------------------------------------------------------------------------  
Author -
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
<title> <bean:write name="fecm002" property="screenTitle"/></title>
<script type="text/javaScript" language="JavaScript" src="<%=lstrCtxPath%>/js/RutHelp.js" ></script>
<script type="text/javaScript" language="JavaScript" src="<%=lstrCtxPath%>/js/screen/EcmMasterLookup.js" ></script>
<script type="text/javaScript" language="JavaScript">
    var contextPath4Date    = "<%=request.getContextPath()%>";
    var BROWSE_FSC_LOOKUP   = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/secm002search", pageContext)%>';
    
    function onLoad() {    
        lastFindVal     = document.forms[0].findVal.value;
        lastFindIn      = document.forms[0].findIn.value;
        lastWildCard    = document.forms[0].wildCard.value;
        lastSortBy      = document.forms[0].sortBy.value;
        lastSortIn      = document.forms[0].sortIn.value;
        lastRecStatus   = document.forms[0].recStatus.value;
        
        lastOrderBy     = document.forms[0].orderBy.value;
        lastAscDesc     = document.forms[0].ascDesc.value;
        
        
        //Focus on Module Combo Box
        document.forms[0].findVal.focus();        
    }
    
    function openHelp() {
        
        var strFileName = '1';
        var strUrl = "/RCLWebApp/help/ApplicationHelp.htm#"+strFileName;
        var objWindow = window.open(strUrl,"Help","width=900,height=600,status=no,resizable=no,top=150,left=150");
        objWindow.focus();
    }
</script>
</head>
<body>    
<html:form method="POST" action="/secm002">
    <html:hidden name="fecm002" property="prmFormName" />
    <html:hidden name="fecm002" property="prmRowId" />
    <html:hidden name="fecm002" property="prmMasterId" />
    <html:hidden name="fecm002" property="prmValues" />
    <html:hidden name="fecm002" property="screenTitle" />
    <html:hidden name="fecm002" property="sectionTitle" />   
    <html:hidden name="fecm002" property="findInCode" />
    <html:hidden name="fecm002" property="findInDesc" />
    <html:hidden name="fecm002" property="sortByCode" />
    <html:hidden name="fecm002" property="sortByDesc" />
    <html:hidden name="fecm002" property="colNames" />
    <html:hidden name="fecm002" property="noOfColumn" />
    <html:hidden name="fecm002" property="preCriteria" />
    <html:hidden name="fecm002" property="orderBy" />
    <html:hidden name="fecm002" property="ascDesc" />
    <html:hidden name="fecm002" property="searchPerformed" />
    <input type="hidden" name="pageId" value="customerPopup"/>
    <!--Begin @01 -->
    <html:hidden name="fecm002" property="prmRowIndex" styleId="prmRowIndex" />
    <!--End @01 -->
    <bean:define id="totalNoOfColumn" name ="fecm002" property="noOfColumn"/>
    <%
        int totColumn = Integer.parseInt(totalNoOfColumn.toString())  ;
        int colWidth = totColumn-2;
    %>
    <table class="table_search" border="0" width="100%" cellspacing="0" cellpadding="0">
        <tr>
            <td width="10%">Find</td>
            <td width="30%">
                <html:text name="fecm002" property="findVal" maxlength='15'/>
            </td>
            <td width="10%">In</td>
            <td width="25%">
                <html:select name="fecm002" property="findIn" size="1">
                    <html:optionsCollection name="fecm002" value="code" label="name" property="findInValues"/>
                </html:select>
            </td>
            <td valign="top" style="padding-top:1px;padding-left:9px;">
                <a id="btnSearch" name="btnSearch" class="m-btn mini blue rnd" href="#" onClick="onSearch()">
                    Search
                </a>
                <a id="btnReset" name="btnReset" class="m-btn mini blue rnd" href="#" onClick="onResetForm()">
                    Reset
                </a>
            </td>
        </tr>
        <tr>
            <td>Sort by</td>
            <td>
               <html:select name="fecm002" property="sortBy" size="1">
                   <html:optionsCollection name="fecm002" value="code" label="name" property="sortByValues"/>
                </html:select>
            </td>
            <td>In</td>
            <td colspan="2">
                <html:select name="fecm002" property="sortIn" size="1">
                    <html:optionsCollection name="fecm002" value="code" label="name" property="sortInValues"/>
                </html:select>
            </td>
        </tr>
        <tr>
            <td>Status</td>
            <td class="whitebg">
                <html:select name="fecm002" property="recStatus" size="1">
                    <html:optionsCollection name="fecm002" value="code" label="name" property="recStatusValues"/>
                </html:select>
            </td>   
            <td>Wild Card</td>
            <td colspan="2">
                <html:select name="fecm002" property="wildCard" size="1">
                    <html:optionsCollection name="fecm002" value="code" label="name" property="wildCardValues"/>
                </html:select>
            </td>
        </tr>
    </table><br />
    <table class="TablePopup">
        <tr>
            <td class="TdLeftHeaderPopup" width="5%">Seq#</td>
        <logic:iterate name="fecm002" property="columnHeader" indexId="ctr" id="rowdata" type="java.lang.String">
<%      if(ctr == 0){       %>
            <td class="TdLeftHeaderPopup" width="10%" id="${ctr}">
                <bean:write  name='fecm002' property='<%="colName["+ctr+"]"%>'/>
            </td>
<%      }else if(ctr == 1){     %>
            <td class="TdLeftHeaderPopup" width="20%" id="${ctr}">
                <bean:write  name='fecm002' property='<%="colName["+ctr+"]"%>'/>
            </td>
<%      }else if(ctr != colWidth+1){        %>
            <td class="TdLeftHeaderPopup" width="<%=(65/colWidth)+"%"%>" id="${ctr}">
                <bean:write  name='fecm002' property='<%="colName["+ctr+"]"%>'/>
            </td>
<%      }else{      %>
            <%--td class="TdLeftHeaderPopup" id="${ctr}" onclick="sortData(this.id)" --%>
            <td class="TdLeftHeaderPopup" id="${ctr}" onclick="sortData(this.id)">
                <bean:write  name="fecm002" property='<%="colName["+ctr+"]"%>'/>
            </td>
<%      }       %>                            
            </logic:iterate>
        </tr>  
    </table>
    <table class="TablePopup">
    <logic:notEmpty name="fecm002" property="values">
    <logic:iterate name="fecm002" property="values" indexId="ctr" id="rowdata" type="com.rclgroup.dolphin.ezl.web.ecm.vo.EcmMasterLookupMod">
        <%--tr id='<%= "row" + ctr %>'  onclick="highlightradioTD('<%="row" + ctr %>')" ONDBLCLICK="returnValues(this.id)"--%>
        <tr id="row${ctr}"  onclick="highlightradioTD('row${ctr}')" ondblclick="returnValues(this.id)">
            <td class="TdLeftDetailPopup" width="5%" >
                <bean:write  name='fecm002' property='<%="value["+ctr+"].srlNo"%>'/></td>
<% for (int i=1; i<=totColumn;i++){
        if(i == 1){ 
%>
            <td class="TdLeftDetailPopup" width="10%" >
                <bean:write  name='fecm002' property='<%="value["+ctr+"].col1"%>'/></td>
<%      }else if(i == 2){   %>
            <td class="TdLeftDetailPopup" width="20%"  >
                <bean:write  name='fecm002' property='<%="value["+ctr+"].col2"%>'/>
            </td>
<%      }else if(i != totColumn) {      %>
            <td class="TdLeftDetailPopup" width='<%=(65/colWidth)+"%"%>'  >
                <bean:write  name='fecm002' property='<%="value["+ctr+"].col"+i%>'/>
            </td>
<%      } else { %>
            <td class="TdLeftDetailPopup">
                <bean:write  name='fecm002' property='<%="value["+ctr+"].col"+i%>'/>
            </td>
<%      } 
    }
%>
                                    
        </tr>
    </logic:iterate>
    </logic:notEmpty>
    <logic:empty name="fecm002" property="values">
        <tr style="height: 20px">    
            <td align="center">No record found.</td>
        </tr>
    </logic:empty>
    </table>
    <jsp:include page="../common/tiles/pagination.jsp">
        <jsp:param name="formName" value="fecm002" />
    </jsp:include>
</html:form>
</body>
</html:html>
