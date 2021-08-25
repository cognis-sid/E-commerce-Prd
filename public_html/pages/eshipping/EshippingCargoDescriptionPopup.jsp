<%--
-------------------------------------------------------------------------------------------------------------
EshippingCargoDescriptionPopup.jsp
-------------------------------------------------------------------------------------------------------------
Copyright RCL Public Co., Ltd. 2007
-------------------------------------------------------------------------------------------------------------  
Author anurak Thanapradit 05/07/13
- Change Log ------------------------------------------------------------------------------------------------
## DD/MM/YY      -User-          -TaskRef-         -ShortDescription-
## 11/10/2013                       01                Fix upper case by use style="text-transform: uppercase;"
## 10/09/2014    PRATYA             02              PD_CR_20140820_ESV [Description and Mark_No for ecah commodity]
-------------------------------------------------------------------------------------------------------------
--%>
<%@page import="java.util.Date"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@page import="com.niit.control.common.GlobalConstants" %>
<%@page import="com.niit.control.web.action.BaseAction" %>
<%@page import="com.niit.control.web.UserAccountBean" %>
<%@page import="com.niit.control.common.StringUtil" %>
<%@page import="com.rclgroup.dolphin.rcl.web.eservice.actionform.EshippingInstructionUim" %>
<%
    String lstrCtxPath     = request.getContextPath();
%>
<head>


<script type="text/javascript" language="JavaScript" src="<%=lstrCtxPath%>/js/screen/EshippingCargoDescriptionPopup.js?id=<%=new Date() %>" ></script>
</head>
<body> 
	<input type="hidden" name="commodityNo" id="commodityNo"  />   
    <%--html:form method="POST" action="/serv006"--%>      
    <!--Begin @02 -->
    <html:hidden name="feserv06" property="commodityRowIndex" styleId="commodityRowIndex" />
    <!--End @02 -->
    <table width="700" border="0" cellspacing="0" cellpadding="10">
    <tr>
        <td width="20">&nbsp;</td>
        <td width="700" style="margin: 10px">
            <table border="0" width="100%" cellspacing="0" cellpadding="0">
            <tr>
                <td class="TableHeadingRow2" width="26%"><span class="m0l0iout">B/L Number</span></td>
                <td class="TableHeadingRow2" width="37%"><span class="m0l0iout">Commodity</span></td>
                <td class="TableHeadingRow2"><span class="m0l0iout">Container No.</span></td>
            </tr>
            <tr style="height: 20px">
                <td class="whitebg">
                    <font class="displayText" id="posComBookingNo">
                        <bean:write name="feserv06" property="blNumber"/>
                    </font>
                </td>
                <td class="whitebg">
                    <font class="displayText" id="posStrCommodityForMark">
                        <bean:write name="feserv06" property="commodity"/>
                    </font>
                </td>
                <td class="whitebg">
                    <font class="displayText" id="posContainerNoToCargo">
                        <bean:write name="feserv06" property="containerNoToCargo"/>
                    </font>
                </td>
            </tr>
            <!-- for line spacing -->
            <tr><td></td></tr>
            </table>
            <div class="page_info">
            </div>
            <div class="bg-light-blue">
                <h2>Marks/Description Details </h2>
            </div>
            <table width="100%" border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td width="50%" class="TableHeadingRow2"><span class="m0l0iout">Marks & Numbers</span></td>
                <td class="TableHeadingRow2"><span class="m0l0iout"  style="padding-left:17px;">Description</span></td>
            </tr>
            <tr>
                <td>
                    <textarea  style="text-transform: uppercase;" name="txtMarksAndNumbers" id="txtMarksAndNumbers" cols="50" 
                    rows="14" onblur="changeUpper(this);" ></textarea>
                </td>
                <td align="right">
                    <textarea  style="text-transform: uppercase;" name="txtDescription" id="txtDescription" cols="50"  
                    rows="14" onblur="changeUpper(this);" ></textarea>
                </td>
            </tr>
            </table>
            <div align="right" style="padding-top:5px;">
                <a id="getEquipDetailDisabledBtn" class="m-btn sm rnd disabled" style="display:none" 
                    href="#">Get Equipment Details&nbsp;<i class="icon-repeat icon-white"></i>
                </a> 
                <a id="getEquipDetailBtn" class="m-btn sm blue rnd" style="display:''"  
                    href="#" onclick="getEquipDetails();">
                    Get Equipment Details&nbsp;<i class="icon-repeat icon-white"></i>
                </a>
                <a id="saveCargoDisabledBtn" class="m-btn sm rnd disabled" style="display:none" 
                    href="#">Save
                </a> 
                <a id="saveCargoBtn" class="m-btn sm blue rnd" style="display: inline"  
                    href="#" onclick="callbackFromCargoDesc(true);">Save
                </a> 
                <a class="m-btn sm blue rnd" 
                    href="#" onclick="callbackFromCargoDesc(false);">Close <i class="icon-remove icon-white"></i>
                </a>
            </div>
        </td>
        <td width="20">&nbsp;</td>
    </tr>
    </table>
	<div id="ErrorMsgLog" style="width: 720px;height: 30px;background-color: #FFE3D1;display: none; ">
	<strong style="position: absolute;font:12px; color: #853D0C; padding-left: 10px;padding-top: 5px;">Error!</strong><p style="position: absolute;font:12px; color: #853D0C; padding-left: 50px;padding-top: 5px;">Invalid Character entered '<i class="fa fa-angle-left" aria-hidden="true"></i>' or '<i class="fa fa-angle-right" aria-hidden="true"></i>' or Single Quotes please remove from Mark & Description</p>
	</div>
    <%--/html:form--%>
</body>

<script>

$( function() {
    $( "#cargoDescriptionDiv" ).draggable();
    //$( "#cargoDescriptionDiv" ).dialog( "close" );
  });
  </script>