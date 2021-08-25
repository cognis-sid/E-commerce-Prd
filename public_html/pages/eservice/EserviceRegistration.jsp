<%--
-------------------------------------------------------------------------------------------------------------
EserviceRegistration.jsp
-------------------------------------------------------------------------------------------------------------
Copyright RCL Public Co., Ltd. 2007
-------------------------------------------------------------------------------------------------------------
Author anurak Thanapradit 05/07/13
- Change Log ------------------------------------------------------------------------------------------------
## DD/MM/YY      -User-          -TaskRef-         -ShortDescription-
## 10/10/2013                       01                add shiper name column
## 07/10/2014    Pratya             02                PD_CR_20140826_ESV [Contract Party for registeration]
## 03/06/2015    Sarawut            03                Check user role_cd can edit or read only
## 08/12/2015    Watchakorn         04                Change solution represented Contract Company
## 20/12/2018    Thitipong          05                Add checkbox Non RA Account.
-------------------------------------------------------------------------------------------------------------
--%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ page import="com.niit.control.common.GlobalConstants" %>
<%@ page import="com.niit.control.web.action.BaseAction" %>
<%@ page import="com.niit.control.web.UserAccountBean" %>
<%@ page import="com.niit.control.common.StringUtil" %>
<%@ page import="com.niit.control.common.ComboVO" %>
<%@ page import="com.rclgroup.dolphin.rcl.web.captcha.CaptchaServiceSingleton" %>
<%@ page import="java.awt.image.BufferedImage" %>
<%@ page import="java.io.ByteArrayOutputStream" %>
<%@ page import="com.octo.captcha.service.CaptchaServiceException" %>
<%@ page import="com.sun.image.codec.jpeg.JPEGCodec" %>
<%@ page import="com.sun.image.codec.jpeg.JPEGImageEncoder" %>
<%@ page import="com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceRegistrationUim" %>
<%@ page import = "com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceRegistrationDao" %>
<%@ page import="java.util.List" %>
<%
    String contextPath = request.getContextPath();
    String userIdChecked = (String) request.getAttribute("userIdChecked");
    if(userIdChecked == null){
        userIdChecked = "false";
    }

    String userIdPassed = (String) request.getAttribute("userIdPassed");
    if(userIdPassed == null){
        userIdPassed = "false";
    }

    String userIdViewMode = (String) request.getAttribute("userIdViewMode");
    if(userIdViewMode == null){
        userIdViewMode = "false";
    }

    String authPage = (String) request.getAttribute("authPage");
    if(authPage == null){
        authPage = "Auth";
    }

    String userId = (String) request.getAttribute("userId");
%>
<html:html>
<head>
<title>RCL Group</title>
<meta content="text/html; charset=utf-8" http-equiv="content-type" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" >
<jsp:include page="../../pages/common/cognis/commonInclude.jsp"></jsp:include>
<link type="text/css" href="<%=contextPath%>/css/registration/common.css" rel="stylesheet">
<link type="text/css" href="<%=contextPath%>/css/registration/registration.css" rel="stylesheet">
<link type="text/css" href="<%=contextPath%>/css/registration/reset.css" rel="stylesheet">
<link type="text/css" href="<%=contextPath%>/css/registration/style.css" rel="stylesheet">
<script type="text/javascript" src="<%=contextPath%>/js/RutString.js"></script>
<%--link type="text/css" href="<%=contextPath%>/css/registration/menu.css" rel="stylesheet"--%>
<%--link type="text/css" href="<%=contextPath%>/css/registration/bluedesign_selective.css"--%>
<%--script type="text/javascript" src="<%=contextPath%>/js/registration/jquery-1.3.1.min.js"></script>
<script type="text/javascript" src="<%=contextPath%>/js/registration/jquery.dropdownPlain.js"></script--%>
<style type="text/css">
    .refresh_btn{
        vertical-align: top;
        height: 15px;
        background-image: url('<%=contextPath%>/images/btnRefresh.jpg');
    }
    td.sub_table_blt_center{
         background-image: url('<%=contextPath%>/images/registration/registration_blt_center.gif');
         width: 10px;
         height: 10px;
    }

    td.sub_table_blt_right{
        background-image: url('<%=contextPath%>/images/registration/registration_blt_right.gif');
        width: 10px;
        height: 10px;
    }
    td.sub_table_blt_left{
        background-image: url('<%=contextPath%>/images/registration/registration_blt_left.gif');
        width: 10px;
        height: 10px;
    }

    td.sub_table_brt_center{
        background-image: url('<%=contextPath%>/images/registration/registration_brt_center.gif');
        width: 10px;
        height: 10px;
    }

    td.sub_table_brt_right{
        background-image: url('<%=contextPath%>/images/registration/registration_brt_right.gif');
        width: 10px;
        height: 10px;
    }

    td.sub_table_brt_left{
        background-image: url('<%=contextPath%>/images/registration/registration_brt_left.gif');
        width: 10px;
        height: 10px;
    }

     td.sub_table_blb_center{
        background-image: url('<%=contextPath%>/images/registration/registration_blb_center.gif');
        width: 10px;
        height: 10px;
    }

    td.sub_table_blb_right{
        background-image: url('<%=contextPath%>/images/registration/registration_blb_right.gif');
        width: 10px;
        height: 10px;
    }

    td.sub_table_blb_left{
        background-image: url('<%=contextPath%>/images/registration/registration_blb_left.gif');
        width: 10px;
        height: 10px;
    }

    td.sub_table_brb_center{
        background-image: url('<%=contextPath%>/images/registration/registration_brb_center.gif');
        width: 10px;
        height: 10px;
    }

    td.sub_table_brb_right{
        background-image: url('<%=contextPath%>/images/registration/registration_brb_right.gif');
        width: 10px;
        height: 10px;
    }

    td.sub_table_brb_left{
        background-image: url('<%=contextPath%>/images/registration/registration_brb_left.gif');
        width: 10px;
        height: 10px;
    }

    td.sub_table_horizon_top{
        background-image: url('<%=contextPath%>/images/registration/registration_horizon_top.gif');
        background-repeat: repeat-x;
        height: 10px;
    }

    td.sub_table_horizon_bottom{
        background-image: url('<%=contextPath%>/images/registration/registration_horizon_bottom.gif');
        background-repeat: repeat-x;
        height: 10px;
    }

    td.sub_table_vertical_left{
        background-image: url('<%=contextPath%>/images/registration/registration_vertical_left.gif');
        background-repeat: repeat-y;
        height: 10px;
    }

    td.sub_table_vertical_right{
        background-image: url('<%=contextPath%>/images/registration/registration_vertical_right.gif');
        background-repeat: repeat-y;
        height: 10px;
    }

    .delBtnDisabled {
       pointer-events: none;
       cursor: default;
    }

</style>
<script  type="text/javascript" language="JavaScript" src="<%=contextPath%>/js/RutHelp.js" ></script>
<script type="text/javascript" src="<%=contextPath%>/js/screen/EserviceRegistration.js" ></script>
<script type="text/javascript">
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');
  ga('create', 'UA-39255240-1', 'rclgroup.com');
  ga('send', 'pageview');
</script>
<script type="text/javascript">
    var REGISTRATION                    = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv007Registration", pageContext)%>';
    var CHECK_AVAILABLE_USER_ID         = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv007CheckAvailableUserId", pageContext)%>';
    var BROWSE_CUSTOMER_DATA            = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv014", pageContext)%>';
    var BROWSE_CUSTOMER_TYPE_DATA       = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv016", pageContext)%>';
    var CREATE_CRM_CUSTOMER             = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv007CreateCRMCustomer", pageContext)%>';
    var REGISTRATION_REQUEST            = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv015", pageContext)%>';
    var GENERATE_CAPTCHA                = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv007GenerateCaptcha", pageContext)%>';
    var OPEN_ACKNOWLEDGE                = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv007OpenAcknowledge", pageContext)%>';
    var REJECTREASON                    = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv007Reject", pageContext)%>';
    var userIdPassed                    = '<%=userIdPassed%>';
    var userIdChecked                   = '<%=userIdChecked%>';

    /*Begin @02*/
    var ADD_CONTRACT_COMPANY            = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv007addContractPartyCompany", pageContext)%>';
    var UPD_CONTRACT_COMPANY            = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv007updContractPartyCompany", pageContext)%>';
    var DEL_CONTRACT_COMPANY            = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv007delContractPartyCompany", pageContext)%>';
    var CREATE_CRM_FOR_CONTRACT_PARTY   = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv007CreateCRMCustomerForContractParty", pageContext)%>';
    /*End @02*/

    /*##04 Begin */
    var ACTIVATE_REPRESENTED_COMPANY    = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv007activateRepresentedCompany", pageContext) %>';
    var FILTER_CONTRACT_PARTY           = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv007filterContractParty", pageContext) %>';
    /*##04 End */

//    function refreshCaptcha(){
//        document.getElementById('captchaKey').src=GENERATE_CAPTCHA;
//    }
</script>
</head>
<body onload="onLoad();">
<html:form method="post" action="/serv007">
    <bean:define id="internalUser" name="feserv12" property="internalUser" />
    <bean:define id="isInternalUser" name="feserv12" property="isInternalUser" />
    <html:hidden name="feserv12" property="controlFsc" />
    <html:hidden name="feserv12" property="fscCode" styleId="fscCode" />
    <html:hidden name="feserv12" property="internalUser" styleId="internalUser" />
    <html:hidden name="feserv12" property="isInternalUser" />
    <html:hidden name="feserv12" property="errMsg" />
    <html:hidden name="feserv12" property="submitSuccess" />
    <html:hidden name="feserv12" property="allSFUChecked" />
    <input type="hidden" id="userIdChecked" name="userIdChecked" value="<%=userIdChecked%>" />
    <input type="hidden" id="userIdPassed" name="userIdPassed" value="<%=userIdPassed%>" />
    <input type="hidden" id="userIdViewMode" name="userIdViewMode" value="<%=userIdViewMode%>" />
    <input type="hidden" id="authPage" name="authPage" value="<%=authPage%>" />
    <!--Begin @02 -->
    <html:hidden name="feserv12" styleId="maxPkPortPairSeq" property="maxPkPortPairSeq" />
    <input type="hidden" name="contextPath" id="contextPath" value="<%=contextPath%>" />
    <html:hidden name="feserv12" styleId="portPairFlag" property="portPairFlag" />
    <!--End @02 -->
    <div align="center" style="width:100%">

        <table width="910" border="0" cellspacing="0" cellpadding="0" align="center">
            <tr>
                <td>
                <div style="width: 910px; position: relative;">
                    <img src="<%=contextPath%>/images/registration/headertop.jpg" border="0" usemap="#Map"
                    alt="country"  />

                    <map name="Map" id="Map" >
                        <area shape="rect" coords="5, 6, 123, 64" href="default.aspx" target="_self" alt="Country list" onclick="backHome();" />
                        <!--<area shape="rect" coords="621, 22, 670, 51" href="rclhotline_00.asp" target="_self" />-->
                    </map>
                </div>
                </td>
            </tr>
            <tr style="height: 30px">
                <td>
                    <a href="<%=contextPath%>/download/setup.zip" target="_blank" style="text-decoration: underline;" >Download eService setup</a>
                </td>
            </tr>
            <tr>
                <td>
                <!-- ########## Personal And Account Detail START ########### -->
                    <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_main_detail">
                        <tr class="table_tr_header">
                            <td  class="font_header">
                                Personal And Account Details
                            </td>
                        </tr>
                        <tr>
                            <td class="td_sub_detail">
                                <%-- ########################## PERSONAL Detail === START  ############################# --%>
                                <table width="892" border="0" cellpadding="0" cellspacing="0">
                                    <tr style="height: 10px">
                                        <td width="10" class="sub_table_blt_center"></td>
                                        <td width="10" class="sub_table_blt_right"></td>
                                        <td width="852" class="sub_table_horizon_top"></td>
                                        <td width="10" class="sub_table_brt_left"></td>
                                        <td width="10" class="sub_table_brt_center"></td>
                                    </tr>
                                    <tr style="height: 10px">
                                        <td class="sub_table_blt_left"></td>
                                        <td colspan="3" rowspan="3" style="background-color: #dce6f2">
                                        <div id="personalDetailsDiv">
                                            <table width="95%" border="0" cellspacing="2" cellpadding="0" align="center" class="table_sub_detail">
                                            <tr class="tr_sub_detail">
                                                <td colspan="2" class="font_sub_header">Personal</td>
                                            </tr>
                                        <logic:equal name="internalUser" value="<%=EserviceRegistrationDao.USER_MODE.EXTERNAL%>">
                                            <tr class="tr_sub_detail">
                                                <td width="20%">First Name: <span class="font_require">*</span></td>
                                                <td width="80%">
                                                    <html:text name="feserv12" property="firstName" size="20" onkeypress="clearMsg();" />
                                                </td>
                                            </tr>
                                            <tr class="tr_sub_detail">
                                                <td>Last Name: <span class="font_require">*</span></td>
                                                <td>
                                                    <html:text name="feserv12" property="lastName" size="20" onkeypress="clearMsg();" />
                                                </td>
                                            </tr>
                                        </logic:equal>
                                        <logic:notEqual name="internalUser" value="<%=EserviceRegistrationDao.USER_MODE.EXTERNAL%>">
                                            <tr class="tr_sub_detail">
                                                <td width="20%">Name: </td>
                                                <td width="80%">
                                                    <html:text name="feserv12" property="userInfoMod.userName" styleId="userInfoMod.userName" style="width: 200px" readonly="<%=Boolean.parseBoolean(userIdViewMode)%>" />
                                                </td>
                                            </tr>
                                        </logic:notEqual>
                                            <tr class="tr_sub_detail">
                                                <td>Email Address: <span class="font_require">*</span></td>
                                                <td>
                                                    <html:text name="feserv12" property="userInfoMod.email" styleId="userInfoMod.email" style="width: 200px"
                                                    onkeypress="clearMsg(); return validEmailKey(event, this);" readonly="${isInternalUser}" />
                                                </td>
                                            </tr>
                                        <logic:notEqual name="internalUser" value="<%=EserviceRegistrationDao.USER_MODE.INTERNAL%>">
                                            <tr class="tr_sub_detail">
                                                <td>Repeat Email Address: <span class="font_require">*</span></td>
                                                <td>
                                                    <html:text name="feserv12" property="reEmailAddress" style="width: 200px"
                                                    onkeypress="clearMsg(); return validEmailKey(event, this);" />
                                                </td>
                                            </tr>
                                        </logic:notEqual>
                                            </table>
                                        </div>
                                        </td>
                                        <td class="sub_table_brt_right"></td>
                                    </tr>
                                    <logic:notEqual name="internalUser" value="<%=EserviceRegistrationDao.USER_MODE.INTERNAL%>">
                                        <tr style="height: 110px;">
                                            <td class="sub_table_vertical_left"></td>
                                            <td class="sub_table_vertical_right"></td>
                                        </tr>
                                    </logic:notEqual>
                                    <logic:equal name="internalUser" value="<%=EserviceRegistrationDao.USER_MODE.INTERNAL%>">
                                        <tr style="height: 80px;">
                                            <td class="sub_table_vertical_left"></td>
                                            <td class="sub_table_vertical_right"></td>
                                        </tr>
                                    </logic:equal>
                                    <tr>
                                        <td class="sub_table_blb_left"></td>
                                        <td class="sub_table_brb_right"></td>
                                    </tr>
                                    <tr style="height: 10px">
                                        <td class="sub_table_blb_center"></td>
                                        <td class="sub_table_blb_right"></td>
                                        <td class="sub_table_horizon_bottom"></td>
                                        <td class="sub_table_brb_left"></td>
                                        <td class="sub_table_brb_center"></td>
                                    </tr>
                                </table>
                                <%-- ########################## PERSONAL Detail === END  ############################# --%>
                                <%-- ########################## ACCOUNT Detail === START  ############################# --%>
                                <logic:notEqual name="internalUser" value="<%=EserviceRegistrationDao.USER_MODE.INTERNAL%>">
                                    <span style="height: 10px" >&nbsp;</span>
                                    <table width="892" border="0" cellpadding="0" cellspacing="0">
                                        <tr style="height: 10px">
                                            <td width="10" class="sub_table_blt_center"></td>
                                            <td width="10" class="sub_table_blt_right"></td>
                                            <td width="852" class="sub_table_horizon_top"></td>
                                            <td width="10" class="sub_table_brt_left"></td>
                                            <td width="10" class="sub_table_brt_center"></td>
                                        </tr>
                                        <tr style="height: 10px">
                                            <td class="sub_table_blt_left"></td>
                                            <td colspan="3" rowspan="3" style="background-color: #dce6f2">
                                                <div id="accountDetailsDiv">
                                                    <table width="95%" border="0" cellspacing="0" cellpadding="0" align="center" class="table_sub_detail">
                                                        <tr class="tr_sub_detail">
                                                            <td colspan="2" class="font_sub_header">Account</td>
                                                        </tr>
                                                        <tr class="tr_sub_detail">
                                                            <td width="20%">User ID: <span class="font_require">*</span></td>
                                                            <td width="80%">
                                                                <logic:equal name="internalUser" value="<%=EserviceRegistrationDao.USER_MODE.EXTERNAL%>">
                                                                    <html:text  name="feserv12"
                                                                                property="userInfoMod.userId"
                                                                                styleId="userInfoMod.userId"
                                                                                size="20"
                                                                                maxlength="10"
                                                                                onkeypress="clearMsg(); clearUserIdParam(); validAccountKey(event);" />&nbsp;
                                                                    <span style=" font-style: italic;">(6 to 10 characters length required. A-Z, a-z, 0-9, _)</span>
                                                                </logic:equal>
                                                                <logic:notEqual name="internalUser" value="<%=EserviceRegistrationDao.USER_MODE.EXTERNAL%>">
                                                                    <html:text  name="feserv12"
                                                                                property="userInfoMod.userId"
                                                                                size="20"
                                                                                maxlength="10"
                                                                                readonly="true" />
                                                                </logic:notEqual>
                                                            </td>
                                                        </tr>
                                                        <tr class="tr_sub_detail">
                                                            <td>
                                                                <logic:equal name="internalUser" value="<%=EserviceRegistrationDao.USER_MODE.EXTERNAL%>">
                                                                    &nbsp;
                                                                </logic:equal>
                                                                <logic:notEqual name="internalUser" value="<%=EserviceRegistrationDao.USER_MODE.EXTERNAL%>">
                                                                    Old Password:
                                                                </logic:notEqual>
                                                            </td>
                                                            <td style="vertical-align: top">
                                                                <logic:equal name="internalUser" value="<%=EserviceRegistrationDao.USER_MODE.EXTERNAL%>">
                                                                    <font class="ALink_01">
                                                                        <a href="#" onclick="clearMsg(); checkAvailableUserId();" style="text-decoration: underline;">Check Availability</a>
                                                                    </font>
                                                                    &nbsp;
                                                                    <span id="checkResultMessage">&nbsp;</span>
                                                                </logic:equal>
                                                                <logic:notEqual name="internalUser" value="<%=EserviceRegistrationDao.USER_MODE.EXTERNAL%>">
                                                                    <html:password  name="feserv12"
                                                                                    property="oldPassword"
                                                                                    size="21"
                                                                                    maxlength="10"
                                                                                    onkeypress="clearMsg(); return validAccountKey(event);"
                                                                                    onblur="accountControl();" />&nbsp;
                                                                </logic:notEqual>
                                                            </td>
                                                        </tr>
                                                    <tr class="tr_sub_detail">
                                                        <td>Password: <span id="pwdSpan"  class="font_require">*</span></td>
                                                        <td>
                                                            <html:password name="feserv12" property="password" size="21" maxlength="10"
                                                            onkeypress="clearMsg(); return validAccountKey(event);" />&nbsp;
                                                            <span style=" font-style: italic;">(least 8 characters, at least one letter and one digit.)</span>
                                                        </td>
                                                    </tr>
                                                    <tr class="tr_sub_detail">
                                                        <td>Repeat Password: <span id="repeatPwdSpan" class="font_require">*</span></td>
                                                        <td>
                                                            <html:password name="feserv12" property="rePassword" size="21" maxlength="10"
                                                            onkeypress="clearMsg(); return validAccountKey(event);" />
                                                        </td>
                                                    </tr>
                                                    </table>
                                                </div>
                                            </td>
                                            <td class="sub_table_brt_right"></td>
                                        </tr>
                                        <tr style="height: 100px;">
                                            <td class="sub_table_vertical_left"></td>
                                            <td class="sub_table_vertical_right"></td>
                                        </tr>
                                        <tr>
                                            <td class="sub_table_blb_left"></td>
                                            <td class="sub_table_brb_right"></td>
                                        </tr>
                                        <tr style="height: 10px">
                                            <td class="sub_table_blb_center"></td>
                                            <td class="sub_table_blb_right"></td>
                                            <td class="sub_table_horizon_bottom"></td>
                                            <td class="sub_table_brb_left"></td>
                                            <td class="sub_table_brb_center"></td>
                                        </tr>
                                    </table>
                                </logic:notEqual>
                                <%-- ########################## ACCOUNT Detail === END  ############################# --%>
                            </td>
                        </tr>
                    </table>
                    <!-- ########## Personal And Account Detail END ########### -->
                </td>
            </tr>
            <tr><td>&nbsp;</td></tr>
            <tr>
                <td>
                    <!-- ########## Company Details START ########### -->
                    <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_main_detail">
                        <tr class="table_tr_header">
                            <td  class="font_header">
                                Company Details
                            </td>
                        </tr>
                        <tr>
                            <td class="td_sub_detail">
                                <%-- ########################## COMPANY Detail === START  ############################# --%>
                                <table width="892" border="0" cellpadding="0" cellspacing="0">
                                    <tr style="height: 10px">
                                        <td width="10" class="sub_table_blt_center"></td>
                                        <td width="10" class="sub_table_blt_right"></td>
                                        <td width="852" class="sub_table_horizon_top"></td>
                                        <td width="10" class="sub_table_brt_left"></td>
                                        <td width="10" class="sub_table_brt_center"></td>
                                    </tr>
                                    <tr style="height: 10px">
                                        <td class="sub_table_blt_left"></td>
                                        <td colspan="3" rowspan="3" style="background-color: #dce6f2">
                                            <div id="companyDetailsDiv">
                                                <table width="95%" border="0" cellspacing="2" cellpadding="0" align="center" class="table_sub_detail">
                                                    <tr class="tr_sub_detail">
                                                        <td colspan="4" class="font_sub_header">Company</td>
                                                    </tr>
                                                    <tr class="tr_sub_detail">
                                                        <td width="26%">Company Name: <span class="font_require">*</span></td>
                                                        <td width="38%">
                                                            <html:text name="feserv12" property="userInfoMod.cmpName" styleId="userInfoMod.cmpName" size="20" readonly="${isInternalUser}" />
                                                        </td>
                                                        <td colspan="2">
                                                            <html:hidden name="feserv12" property="crmErrorMsg" />
                                                            <span id="crmErrorMsgSpan" style="color: red">
                                                                <bean:write name="feserv12" property="crmErrorMsg" />
                                                            </span>
                                                        </td>
                                                    </tr>
                                                    <tr class="tr_sub_detail">
                                                        <td>Address: <span class="font_require">*</span></td>
                                                        <td style="white-space: nowrap;">
                                                            <html:text name="feserv12" property="userInfoMod.address1" styleId="userInfoMod.address1" size="20" readonly="${isInternalUser}" maxlength="35"/>&nbsp;
                                                            <html:text name="feserv12" property="userInfoMod.address2" styleId="userInfoMod.address2" size="20" readonly="${isInternalUser}" maxlength="35"/>
                                                        </td>
                                                        <td width="15%">
                                                            <logic:equal name="internalUser" value="<%=EserviceRegistrationDao.USER_MODE.INTERNAL%>">
                                                                Booking Party Code:
                                                            </logic:equal>
                                                        </td>
                                                        <td width="41%" style="vertical-align: text-top;">
                                                            <logic:equal name="internalUser" value="<%=EserviceRegistrationDao.USER_MODE.INTERNAL%>">
                                                               <html:text  name="feserv12"
                                                                                property="customerCode"
                                                                                styleId="customerCode"
                                                                                maxlength="45"
                                                                                styleClass="must"
                                                                                style="width:100px;"
                                                                                onkeypress="clearMsg(); return checkCustomerCodeKeyIn(event)"
                                                                                onkeydown="clearMsg(); return checkCustomerCodeKeyIn(event)"
                                                                                onchange="clearMsg(); customerControl();"
                                                                                />
                                                               <logic:notEqual name="userIdViewMode" value="true">
                                                                    <a name="btnBrowseCutsomerName" id="btnBrowseCutsomerName" href="javascript:void(0)" onclick="clearMsg(); openCustomerData();" class="m-btn smallest blue rnd smallericn-only">
                                                                        <i class="icon-search icon-white"></i>
                                                                    </a>
                                                               </logic:notEqual>

                                                               <logic:equal name="userIdViewMode" value="true">
                                                                    <a name="btnBrowseCutsomerName" id="btnBrowseCutsomerName" href="javascript:void(0)" class="m-btn smallest blue rnd smallericn-only disabled">
                                                                        <i class="icon-search icon-white"></i>
                                                                    </a>
                                                               </logic:equal>
                                                            </logic:equal>&nbsp;
                                                        </td>
                                                    </tr>
                                                    <tr class="tr_sub_detail">
                                                        <td>&nbsp;</td>
                                                        <td style="white-space: nowrap;">
                                                            <html:text name="feserv12" property="userInfoMod.address3" styleId="userInfoMod.address3" size="20" onkeypress="clearMsg();" readonly="${isInternalUser}" />&nbsp;
                                                            <html:text name="feserv12" property="userInfoMod.address4" styleId="userInfoMod.address4" size="20" onkeypress="clearMsg();" readonly="${isInternalUser}" />
                                                        </td>
                                                        <td>
                                                            <logic:equal name="internalUser" value="<%=EserviceRegistrationDao.USER_MODE.INTERNAL%>">
                                                                <%--div id="fscCodeLabelDiv"--%>
                                                                FSC Code: <span class="font_require">*</span>
                                                                <%--/div--%>
                                                            </logic:equal>&nbsp;
                                                        </td>
                                                        <td style="vertical-align: text-top;">
                                                            <logic:equal name="internalUser" value="<%=EserviceRegistrationDao.USER_MODE.INTERNAL%>">
                                                                <html:text  name="feserv12"
                                                                            property="customerFscCode"
                                                                            styleId="customerFscCode"
                                                                            styleClass="must"
                                                                            style="width:100px;"
                                                                            onkeypress="clearMsg();"
                                                                            onblur="changeUpper(this)"
                                                                            readonly="true"  />
                                                                <logic:notEqual name="userIdViewMode" value="true">
                                                                    <a id="btnBrowseFSC" href="javascript:void(0)" onclick="clearMsg(); openLookup('feserv12', 0, 'FSC_BY_CNTR', '<bean:write name="feserv12" property="userInfoMod.country" />');"
                                                                        class="m-btn smallest blue rnd smallericn-only">
                                                                        <i class="icon-search icon-white"></i>
                                                                    </a>
                                                                </logic:notEqual>

                                                                <logic:equal name="userIdViewMode" value="true">
                                                                    <a id="btnBrowseFSC" href="javascript:void(0)" class="m-btn smallest blue rnd smallericn-only disabled">
                                                                        <i class="icon-search icon-white"></i>
                                                                    </a>
                                                                </logic:equal>
                                                            </logic:equal>&nbsp;
                                                        </td>
                                                    </tr>
                                                    <tr class="tr_sub_detail">
                                                        <td>City: <span class="font_require">*</span></td>
                                                        <td>
                                                            <html:text name="feserv12" property="userInfoMod.city" styleId="userInfoMod.city" size="20" onkeypress="clearMsg();" readonly="${isInternalUser}" />
                                                        </td>
                                                        <td>
                                                            <logic:equal name="internalUser" value="<%=EserviceRegistrationDao.USER_MODE.INTERNAL%>">
                                                                <%--div id="customerTypeLabelDiv" --%>
                                                                    Customer Type : <span class="font_require">*</span>
                                                                <%--/div--%>
                                                            </logic:equal>&nbsp;
                                                        </td>
                                                        <td style="vertical-align: text-top;">
                                                            <logic:equal name="internalUser" value="<%=EserviceRegistrationDao.USER_MODE.INTERNAL%>">
                                                                <html:text  name="feserv12"
                                                                            property="customerType"
                                                                            styleId="customerType"
                                                                            styleClass="must"
                                                                            style="width:100px;"
                                                                            onkeypress="clearMsg();"
                                                                            onblur="changeUpper(this)"
                                                                            readonly="true"/>
                                                                <logic:notEqual name="userIdViewMode" value="true">
                                                                    <a id="btnBrowseCutsomerType" href="javascript:void(0)" onclick="clearMsg(); openCustomerTypeData();" class="m-btn smallest blue rnd smallericn-only">
                                                                        <i class="icon-search icon-white"></i>
                                                                    </a>

                                                                    <a id="btnBrowseCutsomerTypeDisabled" href="javascript:void(0)" class="m-btn smallest blue rnd smallericn-only disabled">
                                                                        <i class="icon-search icon-white"></i>
                                                                    </a>
                                                                </logic:notEqual>

                                                                <logic:equal name="userIdViewMode" value="true">
                                                                    <a id="btnBrowseCutsomerType" href="javascript:void(0)" class="m-btn smallest blue rnd smallericn-only disabled">
                                                                        <i class="icon-search icon-white"></i>
                                                                    </a>

                                                                    <a id="btnBrowseCutsomerTypeDisabled" href="javascript:void(0)" class="m-btn smallest blue rnd smallericn-only disabled">
                                                                        <i class="icon-search icon-white"></i>
                                                                    </a>
                                                                </logic:equal>
                                                            </logic:equal>&nbsp;
                                                        </td>
                                                    </tr>
                                                    <tr class="tr_sub_detail">
                                                        <td>State: </td>
                                                        <td>
                                                            <html:text name="feserv12" property="userInfoMod.state" styleId="userInfoMod.state" size="20" onkeypress="clearMsg();" onblur="lp_upperCase(this);" readonly="${isInternalUser}" maxlength="2" />
                                                        </td>
                                                        <td align="right">
                                                            <logic:equal name="internalUser" value="<%=EserviceRegistrationDao.USER_MODE.INTERNAL%>">
                                                                <a id="createCRMCustBtn" href="javascript:void(0)" class="m-btn mini blue rnd" style="text-align: right; width: 140px" onclick="createCRMCustomer()">
                                                                    <i class="icon-plus icon-white"></i>&nbsp;Create Customer in CRM
                                                                </a>
                                                                <a id="createCRMCustDisabledBtn" href="javascript:void(0)" class="m-btn smallest rnd icn-only disabled" style="display: none; text-align: right; width: 140px" >
                                                                    <i class="icon-plus icon-white"></i>&nbsp;Create Customer in CRM
                                                                </a>
                                                            </logic:equal>&nbsp;
                                                        </td>
                                                    </tr>
                                                    <tr class="tr_sub_detail">
                                                        <td>Country: <span class="font_require">*</span></td>
                                                        <td colspan="3">
                                                            <html:select name="feserv12" property="userInfoMod.country" onclick="clearMsg();" disabled="${isInternalUser}">
                                                                <html:optionsCollection name="feserv12" property="countryList" label="name" value="code" />
                                                            </html:select>
                                                        </td>
                                                    </tr>
                                                    <tr class="tr_sub_detail">
                                                        <td>Phone Number: <span class="font_require">*</span></td>
                                                        <td colspan="3">
                                                            <html:text  name="feserv12"
                                                                        property="userInfoMod.phoneNo"
                                                                        styleId="userInfoMod.phoneNo"
                                                                        size="20"
                                                                        readonly="${isInternalUser}"
                                                                        maxlength="17"
                                                                        onkeypress="clearMsg(); return validNumberKey(event);" />
                                                        </td>
                                                    </tr>
                                                <tr class="tr_sub_detail">
                                                    <td>FAX Number:</td>
                                                    <td colspan="3">
                                                        <html:text  name="feserv12"
                                                                    property="userInfoMod.faxNo"
                                                                    styleId="userInfoMod.faxNo"
                                                                    size="20"
                                                                    readonly="${isInternalUser}"
                                                                    maxlength="9"
                                                                    onkeypress="clearMsg(); return validNumberKey(event);" />
                                                    </td>
                                                </tr>
                                                
                                                <%-- #05 BEGIN --%>
                                                <logic:equal name="internalUser" value="<%=EserviceRegistrationDao.USER_MODE.INTERNAL%>">
                                                    <logic:equal name="feserv12" property="portPairFlag" value="N">
                                                        <tr class="tr_sub_detail">
                                                            <td>Non RA Account</td>
                                                            <td colspan="3">
                                                            <input type="checkbox" id="nonRaAccount" name="nonRaAccount" value="N" class="check_box_style" />
                                                            </td>
                                                        </tr>
                                                    </logic:equal>
                                                </logic:equal>
                                                <%-- #05 END --%>
                                                
                                                <%-- ##04 BEGIN --%>
                                                <%-- <tr class="tr_sub_detail">
                                                    <td>Represented Contract Party Company:</td>
                                                    <td colspan="3" align="left">
                                                        <logic:equal name="internalUser" value="<%=EserviceRegistrationDao.USER_MODE.EXTERNAL%>">
                                                            <html:multibox name="feserv12" property='representedCompanyFlag' styleId="representedCompanyFlag" style="border:0px;width:10%;position:relative;left:-27px;" value="Y" onclick="lp_chkRepresentedCompanyFlag();" />
                                                        </logic:equal>
                                                        <logic:equal name="internalUser" value="<%=EserviceRegistrationDao.USER_MODE.INTERNAL%>">
                                                            <html:multibox name="feserv12" property='representedCompanyFlag' styleId="representedCompanyFlag" style="border:0px;width:10%;position:relative;left:-27px;" value="Y" disabled="true" />
                                                        </logic:equal>
                                                        <logic:equal name="internalUser" value="<%=EserviceRegistrationDao.USER_MODE.INTERNAL_MRES%>">
                                                            <logic:equal name="feserv12" property="representedCompanyFlag" value="Y">
                                                                <html:multibox name="feserv12" property='representedCompanyFlag' styleId="representedCompanyFlag" style="border:0px;width:10%;position:relative;left:-27px;" value="Y" disabled="true" />
                                                            </logic:equal>
                                                            <logic:equal name="feserv12" property="representedCompanyFlag" value="N">
                                                                <html:multibox name="feserv12" property='representedCompanyFlag' styleId="representedCompanyFlag" style="border:0px;width:10%;position:relative;left:-27px;" value="Y" onclick="lp_chkRepresentedCompanyFlag();" />
                                                            </logic:equal>
                                                        </logic:equal>
                                                    </td>
                                                </tr> --%>
                                                <%-- ##04 END --%>
                                                </table>
                                            </div>
                                        </td>
                                        <td class="sub_table_brt_right"></td>
                                    </tr>
                                    <tr style="height: 200px;">
                                        <td class="sub_table_vertical_left"></td>
                                        <td class="sub_table_vertical_right"></td>
                                    </tr>
                                    <tr>
                                        <td class="sub_table_blb_left"></td>
                                        <td class="sub_table_brb_right"></td>
                                    </tr>
                                    <tr style="height: 10px">
                                        <td class="sub_table_blb_center"></td>
                                        <td class="sub_table_blb_right"></td>
                                        <td class="sub_table_horizon_bottom"></td>
                                        <td class="sub_table_brb_left"></td>
                                        <td class="sub_table_brb_center"></td>
                                    </tr>
                                </table>
                                <%-- ########################## COMPANY Detail === END  ############################# --%>
                                <%-- ##04 BEGIN --%>
                                <%--
                                <!--Begin Contract party -->
                                <br/>
                                <logic:equal name="internalUser" value="<%=EserviceRegistrationDao.USER_MODE.EXTERNAL%>">
                                    <table width="892" border="0" cellpadding="0" cellspacing="0">
                                        <tr style="height: 10px">
                                            <td width="10" class="sub_table_blt_center"></td>
                                            <td width="10" class="sub_table_blt_right"></td>
                                            <td width="852" class="sub_table_horizon_top"></td>
                                            <td width="10" class="sub_table_brt_left"></td>
                                            <td width="10" class="sub_table_brt_center"></td>
                                        </tr>
                                        <tr style="height: 10px">
                                            <td class="sub_table_blt_left"></td>
                                            <td colspan="3" rowspan="3" style="background-color: #dce6f2">
                                                    <div id="contractPartyCompanyDiv" style="position:relative;" >
                                                        <table width="95%" border="0" cellspacing="2" cellpadding="0" align="center" class="table_sub_detail" id="contractPartyTab">
                                                            <tr class="tr_sub_detail">
                                                                <td colspan="3" class="font_sub_header">Contract Party Company</td>
                                                            </tr>
                                                            <logic:iterate name='feserv12' property='contractPartyList' indexId='ctr' id='rowdata'
                                                                type='com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceContractPartyPortPairMod'>
                                                                <logic:notEqual name="rowdata" property="statusFlag" value="<%=EserviceRegistrationDao.DEL%>">
                                                                    <tr class="tr_sub_detail">
                                                                        <td width="15%" height="30px;" >Contract Company:</td>
                                                                        <td  width="60%" height="30px;" align="left" valign="middle">
                                                                            <html:hidden name="rowdata" property="fkContractPartyCode" />
                                                                            <html:hidden name="rowdata" property="pkPortPairSeq" />
                                                                            <html:hidden name="rowdata" property="statusFlag" />
                                                                            <html:hidden name="rowdata" property="recStatus" />
                                                                            <html:hidden name="rowdata" property="recStatusDesc" />
                                                                            <html:hidden name="rowdata" property="approveFlag" />
                                                                            <html:hidden name="rowdata" property="contractPartyFscCode" />
                                                                            <html:hidden name="rowdata" property="contractPartyType" />
                                                                            <html:text name="rowdata" property="contractPartyName" style="width:500px;" maxlength="45" onblur="lp_updContractCompany(this);" />
                                                                        </td>
                                                                        <td  width="20%" height="30px;" align="center" valign="middle" style="position:relative;" >
                                                                            <div style="position:absolute;top:1px;left:2px;">
                                                                                <A name="delBtn" class="" href='javascript:void(0)' onclick="lp_delContractCompany(this);" >
                                                                                    <IMG border="0" alt="Delete" src="<%=contextPath%>/images/btnClose.gif" width="16" height="16">
                                                                                </A>
                                                                            </div>
                                                                        </td>
                                                                    </tr>
                                                                </logic:notEqual>
                                                            </logic:iterate>
                                                        </table>
                                                        <div style="position:absolute;right:0px;">
                                                            <a class="m-btn mini blue rnd" name="btnAddContractCompany" id="btnAddContractCompany"
                                                                href="javascript:void(0)" onClick="return lp_addContractCompany()">
                                                                    <i class="icon-plus icon-white"></i>&nbsp;Add more Contract Company
                                                            </a>
                                                        </div>
                                                        <div style="height:50px;"></div>
                                                    </div>
                                            </td>
                                            <td class="sub_table_brt_right"></td>
                                        </tr>
                                        <tr style="height: 200px;">
                                            <td class="sub_table_vertical_left"></td>
                                            <td class="sub_table_vertical_right"></td>
                                        </tr>
                                        <tr>
                                            <td class="sub_table_blb_left"></td>
                                            <td class="sub_table_brb_right"></td>
                                        </tr>
                                        <tr style="height: 10px">
                                            <td class="sub_table_blb_center"></td>
                                            <td class="sub_table_blb_right"></td>
                                            <td class="sub_table_horizon_bottom"></td>
                                            <td class="sub_table_brb_left"></td>
                                            <td class="sub_table_brb_center"></td>
                                        </tr>
                                    </table>
                                </logic:equal>
                                <logic:equal name="internalUser" value="<%=EserviceRegistrationDao.USER_MODE.INTERNAL%>">
                                    <logic:equal name="feserv12" property="representedCompanyFlag" value="Y">
                                        <table width="892" border="0" cellpadding="0" cellspacing="0">
                                            <tr style="height: 10px">
                                                <td width="10" class="sub_table_blt_center"></td>
                                                <td width="10" class="sub_table_blt_right"></td>
                                                <td width="852" class="sub_table_horizon_top"></td>
                                                <td width="10" class="sub_table_brt_left"></td>
                                                <td width="10" class="sub_table_brt_center"></td>
                                            </tr>
                                            <tr style="height: 10px">
                                                <td class="sub_table_blt_left"></td>
                                                <td colspan="3" rowspan="3" style="background-color: #dce6f2">
                                                    <div id="contractPartyCompanyDiv" style="position:relative;" >
                                                        <table width="95%" border="0" cellspacing="2" cellpadding="0" align="center" class="table_sub_detail" id="contractPartyTab">
                                                            <tr class="tr_sub_detail">
                                                                <td colspan="6" class="font_sub_header">Contract Party Company</td>
                                                            </tr>
                                                        <logic:iterate name='feserv12' property='contractPartyList' indexId='ctr' id='rowdata'
                                                            type='com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceContractPartyPortPairMod'>
                                                            <logic:notEqual name="rowdata" property="statusFlag" value="<%=EserviceRegistrationDao.DEL%>">
                                                                <tr class="tr_sub_detail">
                                                                    <td colspan="4" align="left" valign="middle">
                                                                        <html:hidden name="rowdata" property="pkPortPairSeq" />
                                                                        <html:hidden name="rowdata" property="statusFlag" />
                                                                        <html:hidden name="rowdata" property="recStatus" />
                                                                        <html:hidden name="rowdata" property="recStatusDesc" />
                                                                        <html:hidden name="rowdata" property="contractPartyName" />
                                                                        <span>Contract Company:&nbsp;</span>
                                                                        <html:text name="rowdata" property="contractPartyNameDisabled" style="width:400px;" maxlength="45" disabled="true" />
                                                                    </td>
                                                                    <td width="12%" height="30px" align="center" valign="middle" style="position:relative;" >
                                                                        <html:multibox name="rowdata" property="approveFlag" styleClass="check_box_style" value="Y" onclick="lp_updContractCompany(${ctr});" />
                                                                        &nbsp;<span>Approve</span>
                                                                    </td>
                                                                    <td width="20%" height="30px" align="center" valign="middle" style="position:relative;" >
                                                                        <a name="createCRMCustBtnForContractParty" href="javascript:void(0)" class="m-btn mini blue rnd" onclick="createCRMCustomerForContractParty(<%=ctr%>);">
                                                                            <i class="icon-plus icon-white"></i>&nbsp;Create Customer in CRM
                                                                        </a>
                                                                    </td>
                                                                </tr>
                                                                <tr class="tr_sub_detail">
                                                                    <td colspan="6" >
                                                                        <html:hidden name="rowdata" property="errCrmDesc" />
                                                                        <span id="errCrmDescSpan<%=ctr%>" style="color: red">
                                                                            <bean:write name="rowdata" property="errCrmDesc" />
                                                                        </span>
                                                                    </td>
                                                                </tr>
                                                                <tr class="tr_sub_detail">
                                                                    <td width="13%" height="30px">Contract Party code:</td>
                                                                    <td width="22%" height="30px" style="vertical-align: text-top;">
                                                                        <html:text  name="rowdata"
                                                                                    property="fkContractPartyCode"
                                                                                    maxlength="45"
                                                                                    size="20"
                                                                                    styleClass="must"
                                                                                    onkeypress="clearMsgForContractParty(${ctr}); return checkCustomerCodeKeyIn(event)"
                                                                                    onkeydown="clearMsgForContractParty(${ctr}); return checkCustomerCodeKeyIn(event)"
                                                                                    onchange="clearMsgForContractParty(${ctr}); lp_updContractCompany(${ctr});" />
                                                                        <a name="btnBrowseCutsomerNameForContractParty" href="javascript:void(0)" onclick="clearMsgForContractParty(<%=ctr%>); openCustomerDataForContractParty(<%=ctr%>);"
                                                                        class="m-btn smallest blue rnd smallericn-only">
                                                                            <i class="icon-search icon-white" ></i>
                                                                        </a>
                                                                    </td>
                                                                    <td width="9%" height="30px">FSC Code: <span class="font_require">*</span></td>
                                                                    <td width="20%" height="30px" style="vertical-align: text-top;">
                                                                        <html:text  name="rowdata"
                                                                                    property="contractPartyFscCode"
                                                                                    style="width:100px;"
                                                                                    styleClass="must"
                                                                                    onkeypress="clearMsgForContractParty(${ctr});"
                                                                                    onblur="changeUpper(this)"
                                                                                    readonly="true"  />
                                                                        <a name="btnBrowseFSCForContractParty" href="javascript:void(0)" onclick="clearMsgForContractParty(<%=ctr%>); openLookupForContractParty('feserv12', 0, 'FSC_BY_CNTR', <%=ctr%>);"
                                                                            class="m-btn smallest blue rnd smallericn-only">
                                                                            <i class="icon-search icon-white"></i>
                                                                        </a>
                                                                    </td>
                                                                    <td width="11%" height="30px">Customer Type : <span class="font_require">*</span></td>
                                                                    <td width="20%" height="30px" style="vertical-align: text-top;">
                                                                        <html:text  name="rowdata"
                                                                                    property="contractPartyType"
                                                                                    style="width:100px;"
                                                                                    styleClass="must"
                                                                                    onkeypress="clearMsgForContractParty(${ctr});"
                                                                                    onblur="changeUpper(this)"
                                                                                    readonly="true"/>
                                                                        <a name="btnBrowseCutsomerTypeForContractParty" href="javascript:void(0)" onclick="clearMsgForContractParty(<%=ctr%>); openCustomerTypeDataForContractParty(${ctr});"
                                                                        class="m-btn smallest blue rnd smallericn-only">
                                                                            <i class="icon-search icon-white"></i>
                                                                        </a>
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td colspan="6">
                                                                        &nbsp;
                                                                    </td>
                                                                </tr>
                                                            </logic:notEqual>
                                                        </logic:iterate>
                                                        </table>
                                                    </div>
                                                </td>
                                                <td class="sub_table_brt_right"></td>
                                            </tr>
                                            <tr style="height: 200px;">
                                                <td class="sub_table_vertical_left"></td>
                                                <td class="sub_table_vertical_right"></td>
                                            </tr>
                                            <tr>
                                                <td class="sub_table_blb_left"></td>
                                                <td class="sub_table_brb_right"></td>
                                            </tr>
                                            <tr style="height: 10px">
                                                <td class="sub_table_blb_center"></td>
                                                <td class="sub_table_blb_right"></td>
                                                <td class="sub_table_horizon_bottom"></td>
                                                <td class="sub_table_brb_left"></td>
                                                <td class="sub_table_brb_center"></td>
                                            </tr>
                                        </table>
                                    </logic:equal>
                                </logic:equal>
                                <logic:equal name="internalUser" value="<%=EserviceRegistrationDao.USER_MODE.INTERNAL_MRES%>">
                                    <table width="892" border="0" cellpadding="0" cellspacing="0" id="mresTable">
                                        <tr style="height: 10px">
                                            <td width="10" class="sub_table_blt_center"></td>
                                            <td width="10" class="sub_table_blt_right"></td>
                                            <td width="852" class="sub_table_horizon_top"></td>
                                            <td width="10" class="sub_table_brt_left"></td>
                                            <td width="10" class="sub_table_brt_center"></td>
                                        </tr>
                                        <tr style="height: 10px">
                                            <td class="sub_table_blt_left"></td>
                                            <td colspan="3" rowspan="3" style="background-color: #dce6f2">
                                                    <div id="contractPartyCompanyDiv" style="position:relative;" >
                                                        <table width="95%" border="0" cellspacing="2" cellpadding="0" align="center" class="table_sub_detail" id="contractPartyTab">
                                                            <tr class="tr_sub_detail">
                                                                <td colspan="4" class="font_sub_header">Contract Party Company</td>
                                                            </tr>
                                                            <logic:iterate name='feserv12' property='contractPartyList' indexId='ctr' id='rowdata'
                                                                type='com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceContractPartyPortPairMod'>
                                                                <logic:notEqual name="rowdata" property="statusFlag" value="<%=EserviceRegistrationDao.DEL%>">
                                                                    <tr class="tr_sub_detail">
                                                                        <td width="15%" height="30px;" >Contract Company:</td>
                                                                        <td width="60%" height="30px;" align="left" valign="middle">
                                                                            <html:hidden name="rowdata" property="fkContractPartyCode" />
                                                                            <html:hidden name="rowdata" property="pkPortPairSeq" />
                                                                            <html:hidden name="rowdata" property="statusFlag" />
                                                                            <html:hidden name="rowdata" property="recStatus" />
                                                                            <html:hidden name="rowdata" property="approveFlag" />
                                                                            <html:hidden name="rowdata" property="contractPartyFscCode" />
                                                                            <html:hidden name="rowdata" property="contractPartyType" />
                                                                            <html:text name="rowdata" property="contractPartyName" style="width:500px;" disabled="true" onblur="lp_updContractCompany(this);" />
                                                                        </td>
                                                                        <td width="10%" height="30px;" align="left" valign="middle">
                                                                            <html:text name="rowdata" property="recStatusDesc" style="width:150px;text-align:center;" disabled="true" />
                                                                        </td>
                                                                        <td width="10%" height="30px;" align="center" valign="middle" style="position:relative;" >
                                                                            <logic:equal name="rowdata" property="statusFlag" value="<%=EserviceRegistrationDao.ADD%>">
                                                                                <div style="position:absolute;top:1px;left:2px;">
                                                                                    <A name="delBtn" class="" href='javascript:void(0)' onclick="lp_delContractCompany(this);" >
                                                                                        <IMG border="0" alt="Delete" src="<%=contextPath%>/images/btnClose.gif" width="16" height="16">
                                                                                    </A>
                                                                                </div>
                                                                            </logic:equal>
                                                                        </td>
                                                                    </tr>
                                                                </logic:notEqual>
                                                            </logic:iterate>
                                                        </table>
                                                        <div style="position:absolute;right:0px;">
                                                            <a class="m-btn mini blue rnd" name="btnAddContractCompany" id="btnAddContractCompany"
                                                                href="javascript:void(0)" onClick="return lp_addContractCompany()">
                                                                    <i class="icon-plus icon-white"></i>&nbsp;Add more Contract Company
                                                            </a>
                                                        </div>
                                                        <div style="height:50px;"></div>
                                                    </div>
                                            </td>
                                            <td class="sub_table_brt_right"></td>
                                        </tr>
                                        <tr style="height: 200px;">
                                            <td class="sub_table_vertical_left"></td>
                                            <td class="sub_table_vertical_right"></td>
                                        </tr>
                                        <tr>
                                            <td class="sub_table_blb_left"></td>
                                            <td class="sub_table_brb_right"></td>
                                        </tr>
                                        <tr style="height: 10px">
                                            <td class="sub_table_blb_center"></td>
                                            <td class="sub_table_blb_right"></td>
                                            <td class="sub_table_horizon_bottom"></td>
                                            <td class="sub_table_brb_left"></td>
                                            <td class="sub_table_brb_center"></td>
                                        </tr>
                                    </table>
                                </logic:equal> --%>
                                <%-- ##04 END --%>
                                <!--End Contract party -->
                            </td>
                        </tr>
                    </table>
                    <!-- ########## Company Details END ########### -->

                    <!-- ##04 Begin -->
                    <!-- ########## Represeented Company Details Start ########## -->
                    <br/>
                    <logic:equal name="internalUser" value="<%=EserviceRegistrationDao.USER_MODE.INTERNAL_MRES%>">
                        <logic:present name="feserv12" property="contractPartyList" >
                            <bean:size id="size" name="feserv12" property="contractPartyList"/>
                            <logic:greaterThan name="size" value="0" >
                                <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_main_detail">
                                    <tr class="table_tr_header">
                                        <td  class="font_header">
                                            Represented Company Details
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="td_sub_detail">
                                          <table width="892" border="0" cellpadding="0" cellspacing="0">
                                              <tr style="height: 10px">
                                                  <td width="10" class="sub_table_blt_center"></td>
                                                  <td width="10" class="sub_table_blt_right"></td>
                                                  <td width="852" class="sub_table_horizon_top"></td>
                                                  <td width="10" class="sub_table_brt_left"></td>
                                                  <td width="10" class="sub_table_brt_center"></td>
                                              </tr>
                                              <tr style="height: 10px">
                                                  <td class="sub_table_blt_left"></td>
                                                  <td colspan="3" rowspan="3" style="background-color: #dce6f2">
                                                      <div id="represetedCompanyDetailsDiv">
                                                          <table width="95%" border="0" cellspacing="2" cellpadding="0" align="center" class="table_sub_detail" id="tblRepresentComp">
                                                              <tr class="tr_sub_detail">
                                                                  <td colspan="4" ><span class="font_sub_header">Contract Party Company</span>&nbsp;
                                                                      <html:checkbox
                                                                          name="feserv12"
                                                                          property="excludeExpireContractParty"
                                                                          styleId="excludeExpireContractParty"
                                                                          value="Y"
                                                                          style="border:0px;width:15px"/>
                                                                      &nbsp;Exclude expire contract party
                                                                  </td>
                                                              </tr>
                                                              <%-- <tr>
                                                                <td colspan="4">
                                                                  <html:checkbox
                                                                      name="feserv12"
                                                                      property="excludeExpireContractParty"
                                                                      styleId="excludeExpireContractParty"
                                                                      value="Y"
                                                                      style="border:0px;width:15px"/>
                                                                  &nbsp;Exclude expire contract party
                                                                </td>
                                                              </tr> --%>
                                                              <logic:iterate name='feserv12' property='contractPartyList' indexId='ctr' id='rowdata'
                                                                  type='com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceContractPartyPortPairMod'>

                                                                  <logic:notEqual name="rowdata" property="statusFlag" value="<%=EserviceRegistrationDao.DEL%>">
                                                                      <logic:equal name="feserv12" property="excludeExpireContractParty" value="Y">
                                                                          <logic:equal name="rowdata" property="contractPartyStatus" value="ACTIVE">
                                                                              <html:hidden name="rowdata" property="fkContractPartyCode" />
                                                                              <html:hidden name="rowdata" property="pkEsvPpHdrSeq" />
                                                                              <html:hidden name="rowdata" property="statusFlag" />
                                                                              <html:hidden name="rowdata" property="recStatus" />
                                                                              <html:hidden name="rowdata" property="approveFlag" />
                                                                              <html:hidden name="rowdata" property="contractPartyFscCode" />
                                                                              <html:hidden name="rowdata" property="contractPartyType" />
                                                                              <tr class="tr_sub_detail">
                                                                                  <td width="15%" height="30px;" style="text-align:center; vertical-align:middle">Company Name:</td>
                                                                                  <td width="54%" height="30px;" style="text-align:center; vertical-align:middle">
                                                                                      <html:text name="rowdata" property="contractPartyName" style="width:98%;" disabled="true" />
                                                                                  </td>
                                                                                  <td width="13%" height="30px;" style="text-align:center; vertical-align:middle">
                                                                                      <html:text name="rowdata" property="contractPartyStatus" style="width:80px;" disabled="true"/>
                                                                                  </td>
                                                                                  <td width="13%" height="30px;" style="text-align:center; vertical-align:middle">
                                                                                      <logic:equal name="rowdata" property="pwd" value="${rowdata.reactPwd}">
                                                                                          <html:text name="rowdata" property="reactPwd" style="width:80px; text-align:left" disabled="true"/>
                                                                                      </logic:equal>
                                                                                      <logic:notEqual name="rowdata" property="pwd" value="${rowdata.reactPwd}">
                                                                                          <html:text name="rowdata" property="reactPwd" style="width:80px; text-align:left" />
                                                                                      </logic:notEqual>
                                                                                  </td>
                                                                                  <td width="15%" height="30px;" style="text-align:center; vertical-align:middle">
                                                                                    <a class="m-btn mini blue rnd" name="btnActiveContractCompany" id="btnActiveContractCompany"
                                                                                      href="javascript:void(0)"
                                                                                      <logic:notEqual name="rowdata" property="pwd" value="${rowdata.reactPwd}">
                                                                                          onClick="activateRepresentedCompany(this)"
                                                                                      </logic:notEqual>
                                                                                      <logic:equal name="rowdata" property="pwd" value="${rowdata.reactPwd}">
                                                                                          onClick="javascript:void(0)" disabled="disabled"
                                                                                      </logic:equal>
                                                                                      >
                                                                                      Activate
                                                                                    </a>
                                                                                  </td>
                                                                              </tr>
                                                                          </logic:equal>
                                                                      </logic:equal>
                                                                      <logic:equal name="feserv12" property="excludeExpireContractParty" value="N">
                                                                          <html:hidden name="rowdata" property="fkContractPartyCode" />
                                                                          <html:hidden name="rowdata" property="pkEsvPpHdrSeq" />
                                                                          <html:hidden name="rowdata" property="statusFlag" />
                                                                          <html:hidden name="rowdata" property="recStatus" />
                                                                          <html:hidden name="rowdata" property="approveFlag" />
                                                                          <html:hidden name="rowdata" property="contractPartyFscCode" />
                                                                          <html:hidden name="rowdata" property="contractPartyType" />
                                                                          <tr class="tr_sub_detail">
                                                                              <td width="15%" height="30px;" style="text-align:center; vertical-align:middle">Company Name:</td>
                                                                              <td width="54%" height="30px;" style="text-align:center; vertical-align:middle">
                                                                                  <html:text name="rowdata" property="contractPartyName" style="width:98%;" disabled="true" />
                                                                              </td>
                                                                              <td width="13%" height="30px;" style="text-align:center; vertical-align:middle">
                                                                                  <html:text name="rowdata" property="contractPartyStatus" style="width:80px;" disabled="true"/>
                                                                              </td>
                                                                              <td width="13%" height="30px;" style="text-align:center; vertical-align:middle">
                                                                                  <logic:equal name="rowdata" property="pwd" value="${rowdata.reactPwd}">
                                                                                      <html:text name="rowdata" property="reactPwd" style="width:80px; text-align:left" disabled="true"/>
                                                                                  </logic:equal>
                                                                                  <logic:notEqual name="rowdata" property="pwd" value="${rowdata.reactPwd}">
                                                                                      <html:text name="rowdata" property="reactPwd" style="width:80px; text-align:left" />
                                                                                  </logic:notEqual>
                                                                              </td>
                                                                              <td width="15%" height="30px;" style="text-align:center; vertical-align:middle">
                                                                                <a class="m-btn mini blue rnd" name="btnActiveContractCompany" id="btnActiveContractCompany"
                                                                                  href="javascript:void(0)"
                                                                                  <logic:notEqual name="rowdata" property="pwd" value="${rowdata.reactPwd}">
                                                                                      onClick="activateRepresentedCompany(this)"
                                                                                  </logic:notEqual>
                                                                                  <logic:equal name="rowdata" property="pwd" value="${rowdata.reactPwd}">
                                                                                      onClick="javascript:void(0)" disabled="disabled"
                                                                                  </logic:equal>
                                                                                  >
                                                                                  Activate
                                                                                </a>
                                                                              </td>
                                                                          </tr>
                                                                      </logic:equal>
                                                                  </logic:notEqual>
                                                              </logic:iterate>
                                                          </table>
                                                      </div>
                                                  </td>
                                                  <td class="sub_table_brt_right"></td>
                                              </tr>
                                              <tr style="height: 100px;">
                                                  <td class="sub_table_vertical_left"></td>
                                                  <td class="sub_table_vertical_right"></td>
                                              </tr>
                                              <tr>
                                                  <td class="sub_table_blb_left"></td>
                                                  <td class="sub_table_brb_right"></td>
                                              </tr>
                                              <tr style="height: 10px">
                                                  <td class="sub_table_blb_center"></td>
                                                  <td class="sub_table_blb_right"></td>
                                                  <td class="sub_table_horizon_bottom"></td>
                                                  <td class="sub_table_brb_left"></td>
                                                  <td class="sub_table_brb_center"></td>
                                              </tr>
                                          </table>
                                        </td>
                                    </tr>
                                </table>
                            </logic:greaterThan>
                        </logic:present>
                    </logic:equal>
                    <!-- ########## Represeented Company Details End ########## -->
                    <!-- ##04 End -->
                </td>
            </tr>
        <tr><td>&nbsp;</td></tr>
        <tr>
            <td>
            <!-- ########## Service(s) Request START ########### -->
            <logic:equal name="feserv12" property="portPairFlag" value="N">
                <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_main_detail">
                <tr class="table_tr_header">
                    <td  class="font_header">
                        Service(s) Requested
                    </td>
                </tr>
                <tr>
                    <td class="td_sub_detail">
    <%-- ########################## SERVICE REQUEST Detail === START  ############################# --%>
                        <table width="892" border="0" cellpadding="0" cellspacing="0">
                        <tr style="height: 10px">
                            <td width="10" class="sub_table_blt_center"></td>
                            <td width="10" class="sub_table_blt_right"></td>
                            <td width="852" class="sub_table_horizon_top"></td>
                            <td width="10" class="sub_table_brt_left"></td>
                            <td width="10" class="sub_table_brt_center"></td>
                        </tr>
                        <tr style="height: 10px">
                            <td class="sub_table_blt_left"></td>
                            <td colspan="3" style="background-color: #dce6f2">
                            <td class="sub_table_brt_right"></td>
                        </tr>
                        <tr style="height: 10px">
                            <td class="sub_table_vertical_left"></td>
                            <td colspan="3" style="background-color: #dce6f2">
                            <div id="serviceRequestDetailsDiv">
                                <table width="95%" border="0" cellspacing="2" cellpadding="0" align="center" class="table_sub_detail">
                                <tr class="tr_sub_detail">
                                    <td colspan="3" class="font_sub_header">RCL eServices</td>
                                </tr>
                                <tr class="tr_sub_detail">
                                    <td colspan="3" >
                                        Please select at least one of the following available eServices  offered by Bhumnet.<span class="font_require">*</span>
                                    </td>
                                </tr>
                        <logic:notEmpty name="feserv12" property="userServiceModList">
                            <logic:iterate id="serviceList" name="feserv12" property="userServiceModList" indexId="rowIndex">
                                <tr class="tr_sub_detail">
                                    <td width="10%">&nbsp;</td>
                                    <td width="30%">
                                        <html:hidden name="serviceList" property="checked" />
                                        <input type="hidden" name="sfuCode" value="<bean:write name="serviceList" property="sfu" />" />
                                        <html:checkbox name="serviceList" property="sfu" styleClass="check_box_style"
                                        onclick="clearMsg(); onServiceChecked(${rowIndex});"/>
                                        <%--input type="checkbox" id="eWBService" name="chkServiceRequest" class="check_box_style"
                                        onclick="clearMsg()" /--%>
                                        &nbsp;<bean:write name="serviceList" property="moduleName" />
                                    </td>
                                    <td width="60%" style="vertical-align: top;">
                                        <a name="userService" href="javascript:void(0)" class="m-btn smallest blue rnd smallericn-only"
                                        onmouseover="loadServiceDesctiption(this, '<bean:write name="serviceList" property="usageRemark" />')">
                                            <i class="icon-info-sign icon-white"></i>
                                        </a>
                                    </td>
                                </tr>
                            </logic:iterate>
                        </logic:notEmpty>
                                    <logic:notEqual name="internalUser" value="<%=EserviceRegistrationDao.USER_MODE.EXTERNAL%>">
                                        <logic:notEqual name="feserv12" property="currPageAction" value="manageAccount">
                                            <logic:equal name="feserv12" property="fromMenu" value="serv015">
                                                <tr class="tr_sub_detail">
                                                    <td align="left" width="12%" style="vertical-align:text-top;">
                                                        <span>Reject Reason</span>
                                                    </td>
                                                    <td colspan="2" align="left" valign="top">
                                                        <html:textarea name="feserv12" property="rejectReason" styleId="rejectReason" rows="3" cols="50" disabled="<%=Boolean.parseBoolean(userIdViewMode)%>"/>
                                                    </td>
                                                </tr>
                                            </logic:equal>
                                        </logic:notEqual>
                                    </logic:notEqual>
                                </table>
                            </div>

                            </td>
                            <td class="sub_table_vertical_right"></td>
                        </tr>
                        <%--tr style="height: 100px;">
                            <td class="sub_table_vertical_left"></td>
                            <td class="sub_table_vertical_right"></td>
                        </tr--%>
                        <tr style="height: 10px">
                            <td class="sub_table_blb_left"></td>
                            <td colspan="3" style="background-color: #dce6f2">
                            <td class="sub_table_brb_right"></td>
                        </tr>
                        <tr style="height: 10px">
                            <td class="sub_table_blb_center"></td>
                            <td class="sub_table_blb_right"></td>
                            <td class="sub_table_horizon_bottom"></td>
                            <td class="sub_table_brb_left"></td>
                            <td class="sub_table_brb_center"></td>
                        </tr>
                        </table>
                    </logic:equal>
    <%-- ########################## SERVICE REQUEST Detail === END  ############################# --%>
                    </td>
                </tr>
                </table>
            <!-- ########## Service(s) Request END ########### -->
            </td>
        </tr>
        <logic:equal name="internalUser" value="<%=EserviceRegistrationDao.USER_MODE.EXTERNAL%>">
            <tr style="height: 50px">
                <td class="td_main_detail">
                <!-- ########## Service(s) Requested START ########### -->
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                            <td>
                                <input type="checkbox" name="chkAccept" class="check_box_style" />
                            </td>
                            <td>
                                I have read the&nbsp;
                                <a href="javascript:openAnnouncement('<%=contextPath%>', '_blank', ANNOUNCE_TYPE_TERM_OF_USE);">Terms of Use</a>&nbsp;and&nbsp;
                                <a href="javascript:openAnnouncement('<%=contextPath%>', '_blank', ANNOUNCE_TYPE_PRIVACY_POLICY);">Privacy Policy</a>&nbsp;
                                and agree to the terms and conditions regarding the storage of my data. <span class="font_require">*</span>
                            </td>
                        </tr>
                    </table>
                    <!-- ########## Service(s) Request END ########### -->
                </td>
            </tr>
        </logic:equal>
            <tr><td>&nbsp;</td></tr>
                <tr>
                    <td>
                        <div align="center" style="width:100%">
                            <table width="400" border="0" cellspacing="0" cellpadding="0" align="center">
                                <tr>
                                    <td width="400" style="text-align: left; padding-left: 110px">
                                        <logic:notEqual name="userIdViewMode" value="true">
                                            <img src="<%=contextPath%>/images/registration/button_submit.png"
                                                 name="btnSubmit"
                                                 style="width: 70px; height: 22px; border: none; cursor: pointer"
                                                 alt="Submit"
                                                 onclick="submitBtn();" />
                                            <img src="<%=contextPath%>/images/registration/button_clear.png"
                                                 name="BtnClearAll"
                                                 style="width: 61px; height: 22px; border: none; cursor: pointer;"
                                                 alt="Clear"
                                                 onclick="clearBtn();"/>
                                        </logic:notEqual>
                                        <logic:notEqual name="internalUser" value="<%=EserviceRegistrationDao.USER_MODE.EXTERNAL%>">
                                            <logic:notEqual name="feserv12" property="currPageAction" value="manageAccount">
                                                <logic:equal name="feserv12" property="portPairFlag" value="N">
                                                    <logic:notEqual name="userIdViewMode" value="true">
                                                        <logic:equal name="feserv12" property="fromMenu" value="serv015">
                                                            <img src="<%=contextPath%>/images/registration/button_reject.png"
                                                                 name="BtnReject"
                                                                 style="width: 63px; height: 23px; border: none; cursor: pointer;"
                                                                 alt="Reject"
                                                                 onclick="rejectBtn();"/>
                                                        </logic:equal>
                                                    </logic:notEqual>
                                                </logic:equal>
                                            </logic:notEqual>
                                        </logic:notEqual>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </td>
                </tr>
                <tr style="height: 20px"><td></td></tr>
                <tr>
                    <td>
                        <div id="footerbox">
                            <div id="footermain">
                                <div style="width: 910px;">
                                    <img class="homepageFooterDivider" src="<%=contextPath%>/images/registration/divbottom.jpg" border="0" />
                                    <p style="text-align: center; font-family: Arial; font-size: 10px; line-height: 2em;">
                                        Copyright 2011 Regional Container Lines. All rights reserved.
                                    </p>

                                    <p style="text-align: center;">
                                        <font style="text-align: center; font-family: Arial; font-size: 10px; line-height: 2em;">
                                        <%--font class="ALink_01">
                                            <a a href="javascript:openAnnouncement('<%=contextPath%>', '_blank', ANNOUNCE_TYPE_TERM_OF_USE);"
                                            style="text-decoration: none;"%--%>
                                            Terms of Use
                                            <%--/a--%>
                                        </font>
                                        <font style="text-align: center; font-family: Arial; font-size: 10px; line-height: 2em;">&nbsp;|&nbsp;</font>
                                        <font style="text-align: center; font-family: Arial; font-size: 10px; line-height: 2em;">
                                        <%--font class="ALink_01">
                                            <a a href="javascript:openAnnouncement('<%=contextPath%>', '_blank', ANNOUNCE_TYPE_PRIVACY_POLICY);"
                                            style="text-decoration: none;"--%>
                                            Privacy Policy<%--/a--%>
                                        </font>
                                        <font style="text-align: center; font-family: Arial; font-size: 10px; line-height: 2em;">&nbsp;|&nbsp;</font>
                                        <font style="text-align: center; font-family: Arial; font-size: 10px; line-height: 2em;">
                                        This website is best viewed with IE 9.x and above.
                                        </font>
                                    </p>
                                </div>
                            </div>
                        </div>
                    </td>
                </tr>
                <tr style="height: 50px"><td></td></tr>
            </table>

    </div>
    <script type="text/javascript">
        var authPage                        = '<%=authPage%>';
        var userId                          = '<%=userId%>';

        if(authPage == "noAuth"){
            alert("No Authorize");
            var url = REGISTRATION_REQUEST+'?appId=webbkg&tbx_uid=' + userId + "&first_login=first";
            document.forms[0].action = url;
            document.forms[0].submit();
        }
    </script>
</html:form>
</body>
</html:html>
