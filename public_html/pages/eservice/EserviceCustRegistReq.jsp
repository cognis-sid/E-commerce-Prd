<%--
-------------------------------------------------------------------------------------------------------------
EshippingInstruction.jsp
-------------------------------------------------------------------------------------------------------------
Copyright RCL Public Co., Ltd. 2007
-------------------------------------------------------------------------------------------------------------  
Author Pratya Thanuchaisak 26/01/13
- Change Log ------------------------------------------------------------------------------------------------
## DD/MM/YY      -User-          -TaskRef-         -ShortDescription-
## 07/02/2014    YOSSUN1         01                Modified code for increase performance and make the code shorter.
## 03/06/2015    Sarawut         02                Send parameter fromMenu to screen serv007
-------------------------------------------------------------------------------------------------------------
--%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%
 String lstrCtxPath     = request.getContextPath();
%>
<head>
<script type="text/javascript" language="JavaScript">
    var REGISTRATION_REVIEW = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv007", pageContext)%>';
    function onLoad(){}
    
    function openRegistrationReview(userId, portPairFlag){
        var url             = REGISTRATION_REVIEW;
        var windowHeight    = screen.height;
        var windowWidth     = screen.width;
        try{
            debugger;
            error_code = 1;
            loading();
            error_code = 2;
            url += '?userRegistId='+userId + "&portPairFlag=" + portPairFlag + "&fromMenu=serv015";
            error_code = 3;
//            openScreen(url,'serv007');
//            openHelpList(url, windowWidth, windowHeight);
            document.forms[0].action = url;
            document.forms[0].submit();
            error_code = 4;
        }catch(err){
            handleJavaScriptError('openRegistrationReview', err, error_code);     
        }
    }
    
    function refresh(){
        loading();
    
        document.forms[0].action = REGISTRATION_REVIEW;
        document.forms[0].submit();
    }
</script>   
</head>
<body>    
<html:form method="POST" action="/serv015">
    <div class="TableLeftSubColor2">
        <h2>Customer's Registration Requested Overview</h2>
    </div>
    <table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr>
        <td width="20%" class="TableHeadingRow2"><span class="m0l0iout">Country</span></td>
        <td width="20%" class="TableHeadingRow2"><span class="m0l0iout">City</span></td>
        <td width="20%" class="TableHeadingRow2"><span class="m0l0iout">Company Name</span></td>
        <td width="20%" class="TableHeadingRow2"><span class="m0l0iout">Customer Name</span></td>
        <td width="20%" class="TableHeadingRow2"><span class="m0l0iout">Requested Date</span></td>
    </tr>
<logic:notEmpty name="feserv17" property="custRegistReqList" >
    <logic:iterate id="list" name="feserv17" property="custRegistReqList" indexId="rowId" >
    <tr>
        <td class="whitebg" height="20px">
        <span class="displayText">
            <bean:write name="list" property="countryName" />
        </span>
        </td>
        <td class="whitebg">
        <span class="displayText">
            <bean:write name="list" property="city" />
        </span>
        </td>
        <td class="whitebg">
            <span class="displayText">
                <bean:write name="list" property="companyName" />
            </span>
        </td>
        <td class="whitebg">
            <a href="javascript:void(0)" onclick="openRegistrationReview('<bean:write name="list" property="userId" />', '<bean:write name="list" property="portPairFlag" />');" >
                <bean:write name="list" property="userName" />
            </a>
        </td>
        <td class="whitebg">
        <span class="displayText">
            <bean:write name="list" property="addDateTime" />
        </span>
        </td>
    </tr>
    </logic:iterate>
</logic:notEmpty>
    <tr class="tr_sub_detail tr_table_display_detail">
        <td colspan="5">
    <jsp:include page="../common/tiles/pagination.jsp">
        <jsp:param name="formName" value="feserv17" />
    </jsp:include>
        </td>
    </tr>
    </table>
</html:form>
</body>
