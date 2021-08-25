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
                    Privacy Policy
                </td>
            </tr>
            <tr>
                <td class="td_sub_detail">
                    <table width="882" border="0" cellspacing="0" cellpadding="0" class="table_sub_detail">
                    <tr class="tr_sub_detail">
                        <td align="center"><b>RCL Online Privacy Policy</b></td>
                    </tr>
                    <tr class="tr_sub_detail">
                        <td>
                            Your privacy is important to RCL. We maintain full 
                            confidentiality of personal information provided to us
                            via this website. This applies to all who access our websites or 
                            use the online services within.<br /><br />
                        </td>
                    </tr>
                    <tr class="tr_sub_detail">
                        <td>
                            Any personal information collected from you via this website 
                            is only intended for use to provide better service.
                            Such personal information is restricted to only 
                            authorised RCL staff.<br /><br />
                        </td>
                    </tr>
                    <tr class="tr_sub_detail">
                        <td>
                            We may use cookies to "remember" information about your 
                            preferences so as to provide a better user experience.<br /><br />
                        </td>
                    </tr>
                    <tr class="tr_sub_detail">
                        <td>
                            This Policy may be subjected to change without notice and is 
                            not intended to, nor does it, create any contractual
                            rights between RCL and anyone accessing this website 
                            and the contents within.<br /><br />
                        </td>
                    </tr>	
                    <tr class="tr_sub_detail"><td></td></tr>
                    <tr class="tr_sub_detail">
                        <td>
                            <b>IMPORTANT: </b>
                            By accessing this website and its contents within, 
                            you are in agreement to the 
                            <a href="javascript:openAnnouncement('<%=contextPath%>', '_self', ANNOUNCE_TYPE_TERM_OF_USE);"><b>terms</b></a> 
                            stated herein.<br /><br />
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
