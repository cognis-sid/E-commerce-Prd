<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=windows-1252"%>
<%@ page import="javax.servlet.http.*"%>
<%@ page import="com.niit.control.common.*"%>
<%@ page import="com.niit.control.web.*"%>
<%@ page import="com.niit.control.web.action.*"%>

<%
String strServerName = request.getServerName();
String strServerPort = ""+request.getServerPort();
String lstrCtxPath = request.getContextPath();

String strUserid = (String)request.getParameter("userid");
String strAppId = (String) request.getParameter("appId");
if(strAppId == null || "".equals(strAppId)){
    strAppId = "webbkg";
}
//String strUserid = ""; // for Dolphin testing
%>
<%-- 
session.removeAttribute(GlobalConstants.USER_ACCOUNT_BEAN);
String strUserid = (String)request.getParameter("userid");
String password  = "x";
String strUserFsc = "R";
String strAccessLvl = "R~*~***";
String dateFormat = "1";
if(strUserid == null){
    strUserid = "NIIT01";
}
if ( strUserid.equals("NESTLE")){
    strUserFsc = "-";
    strAccessLvl = "-~-~-";
} else if ( !strUserid.equals("NIIT01")){
    strUserFsc = "BKK";
    strAccessLvl = "R~I~BKK";
}
Cookie objCookie1 = new Cookie("RCL_AUTH_KEY",strUserid + "~" + password + "~" + strUserFsc + "~" + strAccessLvl + "~" + dateFormat);
objCookie1.setMaxAge(-1);
//objCookie1.setDomain(".rclgroup.com");
//objCookie1.setDomain(".in.niit-tech.com");
objCookie1.setPath("/");
response.addCookie(objCookie1);


System.out.println("request.getServerName()="+strServerName);
System.out.println("request.getServerPort()="+strServerPort);

%>
<%

UserAccountBean account = (UserAccountBean) session.getAttribute(GlobalConstants.USER_ACCOUNT_BEAN);
if(account!= null){
String astrProgId = "SVCT001";
String strProgGroupId = (String)GlobalParam.loadProgInfo().get(astrProgId);
System.out.println("strProgGroupId="+strProgGroupId);
ProgInfo        lobjProgInfo = account.getProgInfo(strProgGroupId);
System.out.println("lobjProgInfo.getReadFlag()="+lobjProgInfo.getReadFlag());
}
%>
<%-- 
--%>

<script language="javascript">
var serverUrl = '<%="http://" + strServerName + ":" + strServerPort%>';
var aw = screen.availWidth;
var ah = screen.availHeight;

function openScreen(screen_url,screen_id)
{
	debugger;
    var screenWidth = aw-5;
    var screenHeight= ah-54;
    var x = aw>800?(aw-screenWidth)/2:0;
    var y = ah>600?(ah-screenHeight)/2:0;
    var winName = screen_id;
      childWindow = window.open(screen_url,winName, 'width='+screenWidth+',height=' + screenHeight+40 + ',left=' + x + ',top=' + y + 'resizable=yes,scrollbars=yes,toolbar=yes,titlebar=yes');
      childWindow.focus();
}
function openChildScreen(screen_url,screen_id)
{
    var screenWidth = 600;
    var screenHeight= 400;
    var x = aw>800?(aw-screenWidth)/2:0;
    var y = ah>600?(ah-screenHeight)/2:0;
    var winName = screen_id;
    childWindow = window.open(screen_url,winName, 'width='+screenWidth+',height=' + screenHeight + ',left=' + x + ',top=' + y + 'resizable=no,scrollbars=no,toolbar=no,titlebar=yes');
    childWindow.focus();
}

function doBack() {
    document.menu.action='<%=lstrCtxPath%>/pages/Welcome.jsp';
    document.menu.submit();
    return false;
}
</script>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
    <title>Welcome Eservice</title>
    <style type="text/css">
      body {
      background-color: #FFFFFF;
      }
      a:link { color: #736AD6; }
    </style>
  </head>
  <body>
  <form name="menu" method="POST" action="#">
  <div align='center'>
  <p>
  <b>RCL - ESERVICE APPLICATION</b>
  </p>
  <BR>
  <BR>
  </div>
  <div align='center'>
  <table border="1" cellspacing="0" cellpadding="0" width="250">
  <tr>
    <td>User ID :</td>
    <td>
    <input type="text" name="userid" value='<%=strUserid%>' readonly />
    </td>
  </tr>
  </table>
  </p>
  <table border="1" cellspacing="0" cellpadding="0" width="250">
  <tr>
  <td>
  <b>ESERVICE MENU</b>
  </td>
  </tr>
  <!--


	
  <tr>
  <td>
  <a href="javascript:openScreen(serverUrl + '<%=lstrCtxPath%>/do/sedl001?appId=Dolphin','sedl001')"> Discharge List Overview</a>
  </td>
  </tr>
    <tr>
  <td>
  <a href="javascript:openScreen(serverUrl + '<%=lstrCtxPath%>/do/sell001?appId=Dolphin','sell001')"> Load List Overview</a>
  </td>
  </tr>
  <tr>
  <td>
  <a href="javascript:openScreen(serverUrl + '<%=lstrCtxPath%>/do/secm005?appId=Dolphin','secm005')"> E-Notice Template</a>
  </td>
  </tr>
  <tr>
  <td>
  <a href="javascript:openScreen(serverUrl + '<%=lstrCtxPath%>/do/secm007?appId=Dolphin','secm007')"> Maintain Mail Alert</a>
  </td>
  </tr>
  -->
   <tr>
        <td>
            <a href="javascript:openScreen(serverUrl + '<%=lstrCtxPath%>/do/serv00111?appId=webbkg&tbx_uid=<%=strUserid%>&first_login=first','serv00111')"> Login</a>
        </td>
  </tr>
   <tr>
        <td>
        <a href="javascript:openScreen(serverUrl + '<%=lstrCtxPath%>/do/sexn001?appId=webbkg&tbx_uid=<%=strUserid%>&first_login=first','sexn001')"> NEW WEB BOOKING NEW</a>
        </td>
  </tr>
    <tr>
        <td>
        <a href="javascript:openScreen(serverUrl + '<%=lstrCtxPath%>/do/serv001?appId=webbkg&tbx_uid=<%=strUserid%>&first_login=first','serv001')"> NEW WEB BOOKING</a>
        </td>
  </tr>
  <tr>
        <td>
            <a href="javascript:openScreen(serverUrl + '<%=lstrCtxPath%>/do/serv002?appId=webbkg&tbx_uid=<%=strUserid%>&first_login=first','serv002')"> WEB BOOKING INQUIRY</a>
        </td>
  </tr>
  <tr>
        <td>
            <a href="javascript:openScreen(serverUrl + '<%=lstrCtxPath%>/do/sexn002?appId=webbkg&tbx_uid=<%=strUserid%>&first_login=first','sexn002')"> WEB BOOKING INQUIRY NEW</a>
        </td>
  </tr>
  <!--tr>
        <td>
            <a href="javascript:openScreen(serverUrl + '<%=lstrCtxPath%>/do/serv004?appId=webbkg','serv004')"> TEST PAGE FOR ACK</a>
        </td>
  </tr-->
  <tr>
        <td>
            <a href="javascript:openScreen(serverUrl + '<%=lstrCtxPath%>/do/serv006?appId=webbkg&tbx_uid=<%=strUserid%>&first_login=first','serv006')"> E-SHIPPING INSTRUCTION</a>
        </td>
  </tr>
  <tr>
        <td>
            <a href="javascript:openScreen(serverUrl + '<%=lstrCtxPath%>/do/sexn007?appId=webbkg&first_login=first&registMode=R','sexn007')"> REGISTRATION NEW(External)</a>
        </td>
  </tr>
  <tr>
        <td>
            <a href="javascript:openScreen(serverUrl + '<%=lstrCtxPath%>/do/serv007?appId=webbkg&first_login=first&registMode=R','serv007')"> REGISTRATION (External)</a>
        </td>
  </tr>
  <tr>
        <td>
            <a href="javascript:openScreen(serverUrl + '<%=lstrCtxPath%>/do/serv007ManageAccount?appId=webbkg&tbx_uid=<%=strUserid%>&first_login=first','serv007ManageAccount')"> REGISTRATION (Internal)</a>
        </td>
  </tr>
  <tr>
        <td>
            <a href="javascript:openScreen(serverUrl + '<%=lstrCtxPath%>/do/serv008?appId=webbkg&first_login=first&txtUserId=<%=strUserid%>&txtPwd=dolphin1','serv008')"> MRES</a>
        </td>
  </tr>
  <tr>
        <td>
            <a href="javascript:openScreen(serverUrl + '<%=lstrCtxPath%>/do/serv009?appId=webbkg&tbx_uid=<%=strUserid%>&first_login=first','serv009')"> FORGET PASSWORD</a>
        </td>
  </tr>
  <tr>
        <td>
            <a href="javascript:openScreen(serverUrl + '<%=lstrCtxPath%>/do/serv015?appId=webbkg&tbx_uid=<%=strUserid%>&first_login=first','serv015')">Customer's Registration Requested</a>
        </td>
  </tr>
  <tr>
        <td>
            <a href="javascript:openScreen(serverUrl + '<%=lstrCtxPath%>/do/serv014?appId=webbkg&country=TH&tbx_uid=<%=strUserid%>&first_login=first','serv014')">Customer Lookup</a>
        </td>
  </tr>
  <tr>
        <td>
            <a href="javascript:openScreen(serverUrl + '<%=lstrCtxPath%>/do/serv019?appId=webbkg&tbx_uid=<%=strUserid%>&first_login=first','serv019')">Refer Commodities</a>
        </td>
  </tr>
  <tr>
        <td>
            <a href="javascript:openScreen(serverUrl + '<%=lstrCtxPath%>/do/serv022?appId=webbkg&tbx_uid=<%=strUserid%>&first_login=first','serv022')">UNNO LookUp</a>
        </td>
  </tr>
  <tr>
        <td>
            <a href="javascript:openScreen(serverUrl + '<%=lstrCtxPath%>/do/serv023?appId=webbkg&tbx_uid=<%=strUserid%>&first_login=first','serv023')">Upload File</a>
        </td>
  </tr>
  <tr>
        <td>
            <a href="javascript:openScreen(serverUrl + '<%=lstrCtxPath%>/do/serv025?appId=webbkg&tbx_uid=<%=strUserid%>&first_login=first','serv025')">Preview uploaded document</a>
        </td>
  </tr>
  <tr>
        <td>
            <a href="javascript:openScreen(serverUrl + '<%=lstrCtxPath%>/do/serv028equipTypeLookUp?appId=webbkg&tbx_uid=<%=strUserid%>&first_login=first','serv028equipTypeLookUp')">Equipment Type Lookup</a>
        </td>
  </tr>
  <tr>
        <td>
            <a href="javascript:openScreen(serverUrl + '<%=lstrCtxPath%>/do/serv029?appId=webbkg&tbx_uid=<%=strUserid%>&first_login=first','serv029')">Manage Port Pair - Contract Party</a>
        </td>
  </tr>
  <!--
  <tr>
  <td>
  <a href="javascript:openScreen(serverUrl + '<%=lstrCtxPath%>/do/sedl004?appId=Dolphin&PAGE_URL=/do/sedl004','sedl004')"> Return Shipment</a>
  </td>
  </tr>
  -->
  </table>
  </p>
  <table border="1" cellspacing="0" cellpadding="0" width="250">
  <tr>
    <td>
    <input type="button" value=" BACK " onclick="doBack()"/>
    </td>
  </tr>
  </table>
  </div>
  </form>
  </body>
</html>
