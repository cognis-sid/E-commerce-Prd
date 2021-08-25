<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=windows-1252"%>
<%@ page import="javax.servlet.http.*"%>
<%@ page import="com.niit.control.common.*"%>
<%@ page import="com.niit.control.web.*"%>
<%@ page import="com.niit.control.web.action.*"%>
<%@ page import="java.util.Locale"%>
<%
    String lstrCtxPath = request.getContextPath();

%>

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
    <title>Welcome Eservice</title>
    <style type="text/css">
      body {
      background-color: #FFFFFF;
      }
      a:link { color: #ffee22; }
    </style>
  </head>
  <body>
  <form name="welcome" method="POST" action="<%=lstrCtxPath%>/pages/DummyMenu.jsp">
  <div align='center'>
  <p>
  <b>RCL - ESERVICE APPLICATION</b>
  </p>
  <BR>
  <BR>
  </div>
  <div align='center'>
  <table border="0" cellspacing="0" cellpadding="0" width="300">
      <tr>
            <td>User ID :</td>
            <td>
                <select name="userid" size="1">
                        <option value="NIIT01">Principal User(Admin)</option>
                        <option value="BHUDOL1">Web Booking User for Phillips</option>
                        <option value="HQLPRDSS01">HQ Business Super user</option>
                        <option value="SINSAM01">SIN - Sales Manager</option>
                        <option value="BNECSE01">BNE - Sales Exe</option>
                        <option value="BKKCSDOE01" >BKK - BKKCSDOE01</option>
                        <option value="SINWEB01" selected>BKK - SINWEB01</option>
                        <option value="sinweb01">BKK - sinweb01</option>
                        <option value="watcho1">BKK - watcho1</option>
                        <option value="BKKWEB01">BKK - BKKWEB01</option>
                        <option value="BKKWEB02">BKK - BKKWEB02</option>
                        <option value="DEV_TEAM">DEV_TEAM</option>
                        <option value="SINWEB02">SINWEB02</option>
                        <option value="SINWEB03">SINWEB03</option>
                        <option value="BKKWEB04">BKKWEB04</option>
                        <option value="ESVNAKAA">ESVNAKAA</option>
                        <option value="XMEN001">XMEN001</option>
                </select>
                <!-- <input type="text" name="userid" value="SINWEB01"/> -->
            </td>
            <td>
                <input type="submit" id="btnSubmit" name="btnSubmit" value=" OK "/>
            </td>
      </tr>
  </table>
  </div>
  </form>
  </body>
</html>
