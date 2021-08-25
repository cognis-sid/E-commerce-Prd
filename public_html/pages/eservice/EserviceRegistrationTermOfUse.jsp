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
<%
    String contextPath = request.getContextPath();
%>
<html>
<head>
<title>RCL Group</title>
<meta content="text/html; charset=utf-8" http-equiv="content-type" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" >
<link type="text/css" href="<%=contextPath%>/css/registration/common.css" rel="stylesheet">
<link type="text/css" href="<%=contextPath%>/css/registration/registration.css" rel="stylesheet">
<link type="text/css" href="<%=contextPath%>/css/registration/reset.css" rel="stylesheet">
<link type="text/css" href="<%=contextPath%>/css/registration/style.css" rel="stylesheet">
<script type="text/javascript" src="<%=contextPath%>/js/screen/EserviceRegistration.js" ></script>
</head>
<body>
    <table width="910" border="0" cellspacing="0" cellpadding="0" align="center">
    <tr>
        <td style="padding-left: 10px; padding-right: 10px;">
        <div style="width: 910px; position: relative;">
            <img src="<%=contextPath%>/images/registration/headertop.jpg" border="0" usemap="#Map" alt="country"  />
            <div id="countryMenuDiv" class="rcl_countries">
                <ul>
                    <li><a href="default.aspx">Home Page</a></li>
                    <!--<li><a href="/hongkong/index.asp" target="_blank">Hong Kong</a></li>-->
                    <li><a href="/Australia/" target="_blank">Australia</a></li>
                    <li><a href="/china/" target="_blank">China å®?æµ·ç®±è¿?é??å?¢</a></li>
                    <!--<li><a href="/indonesia/RCL_files/home.asp" target="_blank">Indonesia</a></li>-->
                </ul>
            </div>
            <map name="Map" id="Map" >
                <area shape="rect" coords="5, 6, 123, 64" href="default.aspx" target="_self" alt="Country list" />
                <!--<area shape="rect" coords="621, 22, 670, 51" href="rclhotline_00.asp" target="_self" />-->
            </map>
        </div>
        </td>
    </tr>
    <tr style="height: 30px">
        <td class="td_sub_detail"><a href="javascript: homeClicked();" style="text-decoration: underline;">Home</a></td>
    </tr>
    <tr>
        <td class="td_sub_detail">
            <table width="892" border="0" cellspacing="0" cellpadding="0" class="table_main_detail" style="height: 400px">
            <tr class="table_tr_header">
                <td  class="font_header">
                    Terms of Use
                </td>
            </tr>
            <tr>
                <td class="td_sub_detail">
                    <table width="882" border="0" cellspacing="0" cellpadding="0" class="table_sub_detail" >
                    <tr class="tr_sub_detail" style="height">
                    <th><b>Terms and Conditions</b></th>
                    </tr>
                    <tr class="tr_sub_detail">
                        <td>
                            By accessing this website and/or using any of the online services herein, 
                            you have agreed to be bound by the following legal disclaimers and 
                            information.  If you do not accept the conditions specified below, 
                            you must immediately discontinue your access to this website and/or 
                            any of the available online services.<br /><br />
                        </td>
                    </tr>
                    <tr class="tr_sub_detail"><td></td></tr>
                    <tr class="tr_sub_detail">
                        <td>
                            <b>Legal Disclaimers and Information</b>
                            <br /> 
                        </td>
                    </tr>
                    <tr class="tr_sub_detail">
                        <td>
                            Although RCL Group of Companies 
                            (hereinafter referred to as "RCL") tries its best to ensure 
                            the accuracy of the information contained in this website, 
                            it assumes no responsibility for the accuracy or usefulness 
                            or the data available and shall have no obligation to update 
                            or otherwise supplement or correct any data provided. <br />
                        </td>
                    </tr>
                    <tr class="tr_sub_detail">
                        <td>
                            Any person or entity ("user") using RCLâ€?s website shall 
                            agree to defend, indemnify and hold RCL harmless, its agents 
                            and employees, harmless from and against all claims, demands, 
                            losses, suits, liabilities or expenses, including court costs 
                            and legal fees, if any, for property damage, economic loss, 
                            consequential losses, injury, disease, or death of persons, 
                            in connection with the use or misuse of the data provided.<br />
                        </td>
                    </tr>
                    <tr class="tr_sub_detail">
                        <td>
                            The use of this website is governed by the laws of the 
                            Republic of Singapore and to the exclusive jurisdiction 
                            to the Supreme Court of Singapore with no recourse whatsoever 
                            to any other jurisdiction.<br />
                        </td>
                    </tr>
                    <tr class="tr_sub_detail">
                        <td>
                            This disclaimer shall also be extended to any and all 
                            customers, sponsors and partners of RCL who maintain or 
                            are offered and accept the use of services and equipment of 
                            RCL in any action or claim brought forward by a Browser in 
                            conjunction with any matter which includes RCL.<br />
                        </td>
                    </tr>
                    <tr class="tr_sub_detail"><td></td></tr>
                    <tr class="tr_sub_detail">
                        <td >
                            All materials contained within this Web Site, 
                            as defined by originating from those sites registered 
                            to or operating from the equipment of RCL, and including 
                            all text, graphic, programming and ancillary mechanisms not 
                            previously licensed by other parties or in public domain are 
                            held in sole copyright and trademark ownership by RCL and may 
                            not be used without the express written permission of 
                            RCL obtained no less than thirty (30) working days prior 
                            to any such use, nor may it be used without having been 
                            reviewed by the staff and management of RCL.<br />
                        </td>
                    </tr>
                    </table>
                </td>
            </tr>
            </table>
        </td>
    </tr>
    <tr style="height: 20px"><td></td></tr>
    <tr>
        <td>
        <div id="footerbox">
	    <div id="footermain">
	        <div style="width: 910px;">
	            <img src="<%=contextPath%>/images/registration/divbottom.jpg" border="0" class="homepageFooterDivider" />
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
</body>
</html>
