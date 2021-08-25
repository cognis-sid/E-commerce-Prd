<%--
-------------------------------------------------------------------------------------------------------------
EshippingBookingNumberPopup.jsp
-------------------------------------------------------------------------------------------------------------
Copyright RCL Public Co., Ltd. 2007
-------------------------------------------------------------------------------------------------------------  
Author Yossawat Suntisukkasem 13/01/14
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
<%@page import="com.niit.control.common.ComboVO" %>
<%@ page import="com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceRegistrationUim" %>
<%@page import="java.util.List" %>
<%
    String contextPath = request.getContextPath();

%>
<html:html>
<head>
<title>RCL Group</title>
<meta content="text/html; charset=utf-8" http-equiv="content-type" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" >
<link type="text/css" href="<%=contextPath%>/css/registration/common.css" rel="stylesheet">
<link type="text/css" href="<%=contextPath%>/css/registration/registration.css" rel="stylesheet">
<link type="text/css" href="<%=contextPath%>/css/registration/reset.css" rel="stylesheet">
<link type="text/css" href="<%=contextPath%>/css/registration/style.css" rel="stylesheet">
<style type="text/css">
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
</style>
<!-- add screen specific JavaScript file -->
<script type="text/javascript" src="<%=contextPath%>/js/common/Constants.js" ></script>
<script type="text/javascript" src="<%=contextPath%>/js/screen/EserviceForgetPassword.js" ></script>
<script type="text/javascript">
    var FORGET_PASSWORD = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv009ForgetPassword", pageContext)%>';
</script>
</head>
<body onload="window.history.forward(); onLoad();">
<html:form method="post" action="/serv009">
    <html:hidden name="feserv14" property="errMsg" />
    <div align="center" style="width:100%">
        <table width="910" border="0" cellspacing="0" cellpadding="0" align="center">
            <tr>
                <td>
                <div style="width: 910px; position: relative;">
                    <img src="<%=contextPath%>/images/registration/headertop.jpg" border="0" usemap="#Map" 
                    alt="country"  />
                    <div id="countryMenuDiv" class="rcl_countries">
                        <ul>
                            <li><a href="javascript:backHome();">Home Page</a></li>
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
                <td><a href="javascript:backHome();" style="text-decoration: underline;">Home</a></td>
            </tr>
            <logic:equal name="feserv14" property="sentPassword" value="false">
            <tr>
                <td>
                    <!-- ########## Personal And Account Detail START ########### -->
                    <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_main_detail">
                        <tr class="table_tr_header">
                            <td  class="font_header">
                                Forget Password
                            </td>
                        </tr>
                        <tr style="height: 100px">
                            <td class="td_sub_detail" style="vertical-align: middle">
                                <%-- ########################## PERSONAL Detail === START  ############################# --%>                    
                                <table width="95%" border="0" cellspacing="2" cellpadding="0" align="center" class="table_sub_detail">
                                    <tr class="tr_sub_detail">
                                        <td width="20%">User ID: <span class="font_require">*</span></td>
                                        <td width="80%">
                                            <html:text name="feserv14" property="userId" size="20" onkeypress="clearMsg();" />
                                        </td>
                                    </tr>
                                    <tr class="tr_sub_detail">
                                        <td>Email Address: <span class="font_require">*</span></td>
                                        <td>
                                            <html:text name="feserv14" property="emailAddress" style="width: 200px" 
                                            onkeypress="clearMsg(); return validEmailKey(event, this);" />
                                        </td>
                                    </tr>
                                </table>  
                            </td>
                        </tr>
                    </table>
                <!-- ########## Personal And Account Detail END ########### -->
                </td>
            </tr>
            <tr><td>&nbsp;</td></tr>
            <tr>
                <td>
                    <div align="center" style="width:100%">
                        <table width="400" border="0" cellspacing="0" cellpadding="0" align="center">
                            <tr>
                                <td width="200" style="text-align: right; padding-right: 5px">
                                    <img src="<%=contextPath%>/images/registration/button_submit.png" name="btnSubmit" 
                                    style="width: 70px; height: 22px; border: none; cursor: pointer" 
                                    alt="Submit" onclick="submitBtn();" />
                                </td>
                                <td width="200" style="text-align: left; padding-left: 5px">
                                    <img src="<%=contextPath%>/images/registration/button_clear.png" name="BtnClearAll" 
                                    style="width: 61px; height: 22px; border: none; cursor: pointer;"
                                    alt="Clear" onclick="clearBtn();"/>
                                </td>
                            </tr>
                        </table>
                    </div>
                </td>
            </tr>
            </logic:equal>
        <logic:notEqual name="feserv14" property="sentPassword" value="false">
        <tr>
            <td>
                <table width="100%" border="0" cellpadding="0" class="table_main_detail">
                    <tr style="height: 20px">
                        <td class="td_sub_detail">&nbsp;</td>
                    </tr>
                    <tr>
                        <td class="td_sub_detail" style="padding-left: 10px; vertical-align:middle">Your New Password has been sent to beolow email,</td>
                    </tr>
                    <tr>
                        <td class="td_sub_detail" style="padding-left: 10px; vertical-align:middle">
                            <span style="font-weight: bold">
                            <bean:write name="feserv14" property="emailAddress" />
                            </span>
                        </td>
                    </tr>
                    <tr style="height: 50px">
                        <td>&nbsp;</td>
                    </tr>
                    <tr>
                         <td class="td_sub_detail" style="padding-left: 10px; vertical-align:middle">
                           Log on to our website : <a href="http://www.rclgroup.com">http://www.rclgroup.com</a> and change your password
                         </td>
                    </tr>
                    <tr style="height: 20px">
                        <td class="td_sub_detail">&nbsp;</td>
                    </tr>
                </table>
            </td>
        </tr>
        </logic:notEqual>
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
