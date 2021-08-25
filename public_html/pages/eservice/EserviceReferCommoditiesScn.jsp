<%--
-------------------------------------------------------------------------------------------------------------
EserviceReferCommoditiesScn.jsp
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
<%@page import="com.niit.control.common.ComboVO" %>
<%@ page import="com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceReferCommoditiesUim" %>
<%@page import="java.util.List" %>
<%
    String contextPath = request.getContextPath();

%>
<html:html>
<head>
<title>Reefer Details</title>
<meta content="text/html; charset=utf-8" http-equiv="content-type" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" >
<link type="text/css" href="<%=contextPath%>/css/registration/common.css" rel="stylesheet">
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
<script type="text/javascript" src="<%=contextPath%>/js/screen/EserviceReferCommodities.js" ></script>
<script type="text/javascript">
    var SUBMIT = '<%=com.niit.control.web.JSPUtils.getActionMappingURL("/serv019OnSubmit", pageContext)%>';
</script>
</head>
<body onload="onLoad();">
<html:form method="post" styleId="frm" action="/serv019">
    <html:hidden name="feserv19" property="errMsg" />
    <html:hidden name="feserv19" property="seqNo" styleId="seqNo" />
    <html:hidden name="feserv19" property="rowIndex" styleId="rowIndex" />
    <html:hidden name="feserv19" property="disBtn" styleId="disBtn" />
    
    <table width="910" border="0" cellspacing="0" cellpadding="0" align="center">
        <tr>
            <td>
            <!-- ########## Personal And Account Detail START ########### -->
                <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_main_detail">
                    <tr class="table_tr_header">
                        <td  class="font_header">
                            Reefer Details
                        </td>
                    </tr>
                    <tr style="height: 100px">
                        <td class="td_sub_detail" style="vertical-align: middle">
                            <%-- ########################## PERSONAL Detail === START  ############################# --%>                    
                            <table width="95%" border="0" cellspacing="2" cellpadding="0" align="center" class="table_sub_detail">
                                <tr class="tr_sub_detail">
                                    <td width="20%">Temperature (Celcius)</td>
                                    <td width="80%">
                                        <html:text name="feserv19" property="temperature" styleId="temperature" onkeypress="return gp_validNumberKeyMinus(event);" onblur="lp_onBlursetFormat();" style="width: 200px" />
                                    </td>
                                </tr>
                                <tr class="tr_sub_detail">
                                    <td>Ventilation %</td>
                                    <td>
                                        <html:text name="feserv19" property="ventilation" styleId="ventilation" onkeypress="return gp_validNumberKey(event);" onblur="lp_onBlursetFormat();" style="width: 200px" />
                                    </td>
                                </tr>
                                <tr class="tr_sub_detail">
                                    <td>Remark</td>
                                    <td>
                                        <html:text name="feserv19" property="remark" styleId="remark" maxlength="60" style="width: 400px" />
                                    </td>
                                </tr>
                                <tr class="tr_sub_detail">
                                    <td>Humidity</td>
                                    <td>
                                        <html:text name="feserv19" property="humidity" styleId="humidity" onkeypress="return gp_validNumberKey(event);" onblur="lp_onBlursetFormat();" style="width: 200px" />
                                    </td>
                                </tr>
                                <tr class="tr_sub_detail">
                                    <td>Controlled Atmosphere</td>
                                    <td align="left">
                                        <html:checkbox name="feserv19" property="controlledAtmosphere" value="Y" styleId="controlledAtmosphere" style="border:0px;width:2%" onclick="lp_onClickControlledAtmosphere();" />
                                    </td>
                                </tr>
                                <tr class="tr_sub_detail">
                                    <td>Nitrogen %</td>
                                    <td>
                                        <html:text name="feserv19" property="nitrogen" styleId="nitrogen" onkeypress="return gp_validNumberKey(event);" onblur="lp_onBlursetFormat();" style="width: 200px" />
                                    </td>
                                </tr>
                                <tr class="tr_sub_detail">
                                    <td>Oxygent%</td>
                                    <td>
                                        <html:text name="feserv19" property="oxygent" styleId="oxygent" onkeypress="return gp_validNumberKey(event);" onblur="lp_onBlursetFormat();" style="width: 200px" />
                                    </td>
                                </tr>
                                <tr class="tr_sub_detail">
                                    <td>CO2%</td>
                                    <td>
                                        <html:text name="feserv19" property="co2" styleId="co2" onkeypress="return gp_validNumberKey(event);" onblur="lp_onBlursetFormat();" style="width: 200px" />
                                    </td>
                                </tr>
                                <tr class="tr_sub_detail">
                                    <td>Refr. Mode</td>
                                    <td>
                                        <html:select name="feserv19" property="refMode" size="1" onchange="">
                                            <html:optionsCollection name="feserv19" value="code" label="name" property="refrModeList"/>
                                        </html:select>
                                    </td>
                                </tr>
                                <tr class="tr_sub_detail">
                                    <td>Pre-Cooled</td>
                                    <td align="left">
                                        <html:checkbox name="feserv19" property="preCooled" styleId="preCooled" value="Y" style="border:0px;width:2%;" />
                                    </td>
                                </tr>
                            </table>  
                        </td>
                    </tr>
                    <tr class="tr_sub_detail" style="height: 50px;" id="trSubmitBtn">
                        <td  class="font_header" style="text-align: center;">
                            <a class="m-btn mini blue rnd" href="javascript:void(0)" onClick="submitBtn();">
                                <strong>OK</strong>
                            </a>
                        </td>
                    </tr>
                </table>
            <!-- ########## Personal And Account Detail END ########### -->
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
</html:form>
</body>
</html:html>
