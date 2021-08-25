<%--
-------------------------------------------------------------------------------------------------------------
EshippingBookingNumberPopup.jsp
-------------------------------------------------------------------------------------------------------------
Copyright RCL Public Co., Ltd. 2007
-------------------------------------------------------------------------------------------------------------  
Author anurak Thanapradit 05/07/13
- Change Log ------------------------------------------------------------------------------------------------
## DD/MM/YY      -User-          -TaskRef-         -ShortDescription-
## 10/10/2013                       01                add shiper name column
-------------------------------------------------------------------------------------------------------------
--%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page import="com.niit.control.common.GlobalConstants" %>
<%@page import="com.niit.control.web.action.BaseAction" %>
<%@page import="com.niit.control.web.UserAccountBean" %>
<%@page import="com.niit.control.common.StringUtil" %>
<%@page import="com.niit.control.common.ComboVO" %>
<%@ page import="com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceMRESUim" %>
<%@page import="java.util.List" %>
<%
    UserAccountBean account=(UserAccountBean) session.getAttribute(GlobalConstants.USER_ACCOUNT_BEAN);
    String contextPath = request.getContextPath();
    
    String accountName = account.getUserName();
    if(accountName == null || "".equals(accountName)){
        accountName = account.getUserId();
    }
    
%>
<html:html>
<head>
<title>RCL Group</title>
<meta content="text/html; charset=utf-8" http-equiv="content-type" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" >
<link type="text/css" href="<%=contextPath%>/css/registration/common.css" rel="stylesheet">
<link type="text/css" href="<%=contextPath%>/css/registration/mres.css" rel="stylesheet">
<link type="text/css" href="<%=contextPath%>/css/registration/reset.css" rel="stylesheet">
<link type="text/css" href="<%=contextPath%>/css/registration/style.css" rel="stylesheet">
<script type="text/javascript" src="<%=contextPath%>/js/screen/EserviceMRES.js" ></script>
<script type="text/javascript" src="<%=contextPath%>/js/RutHelp.js"></script>  
<script type="text/javascript">
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');
  ga('create', 'UA-39255240-1', 'rclgroup.com');
  ga('send', 'pageview');
</script>
<script type="text/javascript">
    var MANAGE_ACCOUNT = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv007ManageAccount", pageContext)%>';
    var contextPath = '<%=contextPath%>';
    
    function getActionUrl(){
        return '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv008LookupData", pageContext)%>';
    }
    
    function getLogOutUrl(){
        return '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv008LogOut", pageContext)%>';
    }
</script>
</head>
<body onload="window.history.forward(); onLoad();">
<html:form method="post" action="/serv008">
    <html:hidden name="feserv13" property="errMsg" />
    <html:hidden name="feserv13" property="sortCol" />
    <html:hidden name="feserv13" property="orderBy" />
    <div align="center" style="width:100%">
    <table width="910" border="0" cellspacing="0" cellpadding="0" align="center">
    <tr>
        <td>
        <div style="width: 910px; position: relative;">
            <img src="<%=contextPath%>/images/registration/headertop.jpg" border="0" usemap="#Map" alt="country"  />
            <div id="countryMenuDiv" class="rcl_countries">
                <ul>
                    <li><a href="default.aspx">Home Page</a></li>
                    <!--<li><a href="/hongkong/index.asp" target="_blank">Hong Kong</a></li>-->
                    <li><a href="/Australia/" target="_blank">Australia</a></li>
                    <li><a href="/china/" target="_blank">China �?海箱�?�??�?�</a></li>
                    <!--<li><a href="/indonesia/RCL_files/home.asp" target="_blank">Indonesia</a></li>-->
                </ul>
            </div>
            <map name="Map" id="Map" >
                <area shape="rect" coords="5, 6, 123, 64" href="default.aspx" target="_self" alt="Country list" onclick="backHome();" />
                <!--<area shape="rect" coords="621, 22, 670, 51" href="rclhotline_00.asp" target="_self" />-->
            </map>
        </div>
        </td>
    </tr>
    <tr style="height: 30px">
        <td>
            <a href="javascript:backHome();" style="text-decoration: underline;">Home</a>&nbsp;
            <a href="<%=contextPath%>/download/setup.zip" target="_blank" style="text-decoration: underline;" >Download eService setup</a>&nbsp;
            <a href="<%=contextPath%>/help/eService.html" target="_blank" style="text-decoration: underline;" >Help</a>
        </td>
    </tr>
    <logic:equal name="feserv13" property="authPass" value="true">
    <tr style="height: 30px">
        <td style="padding-bottom: 10px">
            <table width="100%" border="0" cellspacing="0" cellpadding="0" style="padding-top: 10px; padding-bottom: 10px">
            <tr>
                <td width="60%" valign="top">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr><td><span class="font_header" style="font-size: 18px; padding-top: 5px; padding-bottom: 5px">My RCL e-SERVICES</span></td></tr>
                    <tr>
                        <td style="padding-top: 5px; padding-bottom: 5px">
                             <span  class="font_header"  style="color: #1f497d; font-size: 16px; font-style: italic">
                             Welcome, <%=accountName%> : <bean:write name="feserv13" property="fullCurrentDate" />
                            </span>
                        </td>
                    </tr>
                    </table>
                </td>
                <td align="right" valign="top">
                <div class="spotlight-action" align="right" style="vertical-align: top;">
                    <!--<a href="D:/setup.zip" target="_blank" >Download eService setup1</a> -->
                    <a id="manageMyAccountBtn" class="m-btn mini blue rnd" style="vertical-align: top; height: 15px; " 
                    href="javascript: void(0);" onclick="manageAccount();">
                        Manage My Account <i class="icon-cog icon-white"></i>
                    </a>
                    <a id="logoutBtn" class="m-btn mini blue rnd" style="visiblity: visible; vertical-align: top;  height: 15px"
                    href="javascript:void(0)" onClick="clearMsg(); logout();" >Log Out <i class="m-icon-swapright m-icon-white"></i>
                    </a>
                </div>
                </td>
            </tr>
            </table>
        </td>
    </tr>
    <tr>
        <td>
        <%-- ########## Personal And Account Detail START ########### --%>
            <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_main_detail">
            <tr class="table_tr_header">
                <td  class="font_header">
                        Notifications (<bean:write name="feserv13" property="totalNotification" />)
                </td>
            </tr>
            <tr>
                <td align="center" class="td_sub_detail">
                    <table id="notificationTable" width="100%" border="0" cellspacing="0" cellpadding="0" align="center"
                            style="border: solid 1px #dcdcdc">
                    <tr class="tr_sub_detail tr_table_display_detail">
                        <td width="10%" class="font_sub_header td_table_display_detail" 
                        style="vertical-align: middle;  border-right: transparent; padding: 0px">
                            <table width="100%" align="right" border="0" cellspacing="0" cellpadding="0" >
                            <tr>
                                <td style="vertical-align: middle; width: 100%; padding-left: 10px">ID</td>
                                <td align="right" style="vertical-align: middle; width: 21px">
                                    <img id="idSortImg" src="<%=contextPath%>/images/mres/mres_sort_asc.gif" style="cursor: pointer;" 
                                    align="right" border="0" onClick="clickNotificationSorting(SORT_TYPE_ID, '<bean:write name="feserv13" property="idOrderBy" />');" />
                                </td>
                            </tr>
                            </table>
                        </td>
                        <td width="70%" class="font_sub_header td_table_display_detail" 
                        style="vertical-align: middle; border-right: transparent; padding: 0px">
                            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td width="100%" style="vertical-align: middle; width: 100%; padding-left: 10px">Subject</td>
                                <td align="right" style="vertical-align: middle; width: 21px">
                                    <img id="subjectSortImg" src="<%=contextPath%>/images/mres/mres_sort_asc.gif" style="cursor: pointer; text-align:right"
                                    align="right" border="0" onClick="clickNotificationSorting(SORT_TYPE_SUBJECT, '<bean:write name="feserv13" property="subjectOrderBy" />');" />
                                </td>
                            </tr>
                            </table>
                        </td>
                        <td width="20%" class="font_sub_header td_table_display_detail" 
                        style="vertical-align: middle; padding: 0px; border-right: transparent" >
                            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td style="vertical-align: middle; width: 100%; padding-left: 10px">Date</td>
                                <td align="right" style="vertical-align: middle; width: 21px">
                                    <img id="dateSortImg" src="<%=contextPath%>/images/mres/mres_sort_asc.gif" style="cursor: pointer;"
                                    align="right" border="0" onClick="clickNotificationSorting(SORT_TYPE_DATE, '<bean:write name="feserv13" property="dateOrderBy" />');" />
                                </td>
                            </tr>
                            </table>
                        </td>
                    </tr>
                <logic:notEmpty name="feserv13" property="notificationsList">
                    <logic:iterate id="notification" name="feserv13" property="notificationsList" indexId="index" length="10">
                    <tr class="tr_sub_detail">
                        <td class="td_table_display_detail" style="vertical-align: middle; text-align: center;">
                            <bean:write name="notification" property="id" />
                        </td>
                        <td class="td_table_display_detail" style="vertical-align: middle;">
                            <div id="mailSubjectDiv${index}" style="z-index: 5; visibility: hidden"></div>
                            <input type="hidden" id="mailSubjectHid${index}" name="mailSubjectHid" value="<bean:write name="notification" property="mailBody" filter="true" />" />
                            <a id="mailSubject${index}" href="javascript:void(0)" 
                            style="text-decoration: none; color: #000000;"
                            onmouseover="loadMailBody(this, ${index});">
                                <bean:write name="notification" property="mailSubject" />
                                <logic:equal name="notification" property="flag" value="NEW" >
                                    &nbsp;<img src="<%=contextPath%>/images/mres/icon_new.gif" border="0" />
                                </logic:equal>
                            </a>
                        </td>
                        <td class="td_table_display_detail" style="vertical-align: middle; text-align: center; border-right: transparent">
                            <bean:write name="notification" property="mailDateStr" />
                        </td>
                    </tr>
                    </logic:iterate>
                </logic:notEmpty>
                    <tr class="tr_sub_detail tr_table_display_detail">
                        <td colspan="4">
                    <jsp:include page="../common/tiles/pagination.jsp">
                        <jsp:param name="formName" value="feserv13" />
                    </jsp:include>
                        </td>
                    </tr>
                    </table>
                </td>
            </tr>
            </table>
            
        <%-- ########## Personal And Account Detail END ########### --%>
        </td>
    </tr>
    <tr><td>&nbsp;</td></tr>
    <tr>
        <td>
        <!-- ########## Company Details START ########### -->
            <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_main_detail">
            <tr class="table_tr_header">
                <td  class="font_header">
                        My e-SERVICES
                </td>
            </tr>
            <tr>
                <td align="center" class="td_sub_detail">
        <logic:notEmpty name="feserv13" property="esvMap">
            <logic:iterate id="esvMap" name="feserv13" property="esvMap">
                <bean:define id="moduleName" name="esvMap" property="key" />
                <bean:define id="esvList" name="esvMap" property="value" type="java.util.List" />
                <div id="${moduleName}Div">
                    <table width="700" border="0" cellspacing="0" cellpadding="0" align="left" class="table_sub_detail"
                    style="border: solid 1px #dcdcdc">
                    <tr class="tr_sub_detail tr_table_display_detail">
                        <td width="30%" class="font_sub_header td_table_display_detail"
                        style="vertical-align: middle; padding-left: 5px">
                            <bean:write name="moduleName" />
                        </td>
                        <td width="70%" class="font_sub_header td_table_display_detail_last"
                        style="vertical-align: middle; padding-left: 5px">Information</td>
                    </tr>
                <logic:iterate id="esv" name="esvList" indexId="index" 
                type="com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceMRESMyEServiceMod">
                    <tr class="tr_sub_detail">
                        <td class="td_table_display_detail td_myeservice_detail">
                            <html:hidden name="esv" property="usrLogin" styleId="usrLogin" />
                            <a href="javascript: openScreenForMRES('<bean:write name="esv" property="url" />', 'eServices');">
                                <bean:write name="esv" property="menuName" />
                            </a>
                        </td>
                        <td class="td_table_display_detail_last td_myeservice_detail">
                            <bean:write name="esv" property="information" />
                        </td>
                    </tr>
                    </logic:iterate>
                    </table>
                </div>
                <span style="height: 20px">&nbsp;</span>
            </logic:iterate>
        </logic:notEmpty>
                </td>
            </tr>
            </table>
        <!-- ########## Company Details END ########### -->
        </td>
    </tr>
    </logic:equal>
    <logic:equal name="feserv13" property="authPass" value="false">
    <tr>
        <td>
            <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_main_detail">
            <tr class="table_tr_header">
                <td  class="font_header">
                        Login Fail
                </td>
            </tr>
            <tr style="height: 50px">
                 <td align="center" class="td_sub_detail" style="text-align: middle;">
                    User ID or Password incorrect , <a href="http://www.rclgroup.com">Click here</a> to re login
                 </td>
            </tr>
            </table>
        </td>
    </tr>
    </logic:equal>
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
</html:form>
</body>
</html:html>
