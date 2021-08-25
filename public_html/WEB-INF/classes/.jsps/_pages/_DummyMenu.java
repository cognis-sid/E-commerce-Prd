package _pages;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import javax.servlet.http.*;
import com.niit.control.common.*;
import com.niit.control.web.*;
import com.niit.control.web.action.*;


public class _DummyMenu extends com.orionserver.http.OrionHttpJspPage {


  // ** Begin Declarations


  // ** End Declarations

  public void _jspService(HttpServletRequest request, HttpServletResponse response) throws java.io.IOException, ServletException {

    response.setContentType( "text/html;charset=windows-1252");
    /* set up the intrinsic variables using the pageContext goober:
    ** session = HttpSession
    ** application = ServletContext
    ** out = JspWriter
    ** page = this
    ** config = ServletConfig
    ** all session/app beans declared in globals.jsa
    */
    PageContext pageContext = JspFactory.getDefaultFactory().getPageContext( this, request, response, null, true, JspWriter.DEFAULT_BUFFER, true);
    // Note: this is not emitted if the session directive == false
    HttpSession session = pageContext.getSession();
    int __jsp_tag_starteval;
    ServletContext application = pageContext.getServletContext();
    JspWriter out = pageContext.getOut();
    _DummyMenu page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      out.write(__oracle_jsp_text[1]);
      out.write(__oracle_jsp_text[2]);
      out.write(__oracle_jsp_text[3]);
      out.write(__oracle_jsp_text[4]);
      out.write(__oracle_jsp_text[5]);
      
      String strServerName = request.getServerName();
      String strServerPort = ""+request.getServerPort();
      String lstrCtxPath = request.getContextPath();
      
      String strUserid = (String)request.getParameter("userid");
      String strAppId = (String) request.getParameter("appId");
      if(strAppId == null || "".equals(strAppId)){
          strAppId = "webbkg";
      }
      //String strUserid = ""; // for Dolphin testing
      
      out.write(__oracle_jsp_text[6]);
      out.write(__oracle_jsp_text[7]);
      out.print("http://" + strServerName + ":" + strServerPort);
      out.write(__oracle_jsp_text[8]);
      out.print(lstrCtxPath);
      out.write(__oracle_jsp_text[9]);
      out.print(strUserid);
      out.write(__oracle_jsp_text[10]);
      out.print(lstrCtxPath);
      out.write(__oracle_jsp_text[11]);
      out.print(lstrCtxPath);
      out.write(__oracle_jsp_text[12]);
      out.print(lstrCtxPath);
      out.write(__oracle_jsp_text[13]);
      out.print(lstrCtxPath);
      out.write(__oracle_jsp_text[14]);
      out.print(lstrCtxPath);
      out.write(__oracle_jsp_text[15]);
      out.print(strUserid);
      out.write(__oracle_jsp_text[16]);
      out.print(lstrCtxPath);
      out.write(__oracle_jsp_text[17]);
      out.print(strUserid);
      out.write(__oracle_jsp_text[18]);
      out.print(lstrCtxPath);
      out.write(__oracle_jsp_text[19]);
      out.print(lstrCtxPath);
      out.write(__oracle_jsp_text[20]);
      out.print(strUserid);
      out.write(__oracle_jsp_text[21]);
      out.print(lstrCtxPath);
      out.write(__oracle_jsp_text[22]);
      out.print(lstrCtxPath);
      out.write(__oracle_jsp_text[23]);
      out.print(strUserid);
      out.write(__oracle_jsp_text[24]);
      out.print(lstrCtxPath);
      out.write(__oracle_jsp_text[25]);
      out.print(strUserid);
      out.write(__oracle_jsp_text[26]);
      out.print(lstrCtxPath);
      out.write(__oracle_jsp_text[27]);
      out.print(strUserid);
      out.write(__oracle_jsp_text[28]);
      out.print(lstrCtxPath);
      out.write(__oracle_jsp_text[29]);
      out.print(strUserid);
      out.write(__oracle_jsp_text[30]);
      out.print(lstrCtxPath);
      out.write(__oracle_jsp_text[31]);
      out.print(strUserid);
      out.write(__oracle_jsp_text[32]);
      out.print(lstrCtxPath);
      out.write(__oracle_jsp_text[33]);
      out.print(strUserid);
      out.write(__oracle_jsp_text[34]);
      out.print(lstrCtxPath);
      out.write(__oracle_jsp_text[35]);
      out.print(strUserid);
      out.write(__oracle_jsp_text[36]);
      out.print(lstrCtxPath);
      out.write(__oracle_jsp_text[37]);
      out.print(strUserid);
      out.write(__oracle_jsp_text[38]);
      out.print(lstrCtxPath);
      out.write(__oracle_jsp_text[39]);
      out.print(strUserid);
      out.write(__oracle_jsp_text[40]);
      out.print(lstrCtxPath);
      out.write(__oracle_jsp_text[41]);
      out.print(strUserid);
      out.write(__oracle_jsp_text[42]);
      out.print(lstrCtxPath);
      out.write(__oracle_jsp_text[43]);
      out.print(strUserid);
      out.write(__oracle_jsp_text[44]);
      out.print(lstrCtxPath);
      out.write(__oracle_jsp_text[45]);

    }
    catch (Throwable e) {
      if (!(e instanceof javax.servlet.jsp.SkipPageException)){
        try {
          if (out != null) out.clear();
        }
        catch (Exception clearException) {
        }
        pageContext.handlePageException(e);
      }
    }
    finally {
      OracleJspRuntime.extraHandlePCFinally(pageContext, true);
      JspFactory.getDefaultFactory().releasePageContext(pageContext);
    }

  }
  private static final char __oracle_jsp_text[][]=new char[46][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\r\n\"http://www.w3.org/TR/html4/loose.dtd\">\r\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[4] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[5] = 
    "\r\n\r\n".toCharArray();
    __oracle_jsp_text[6] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[7] = 
    "\r\n\r\n<script language=\"javascript\">\r\nvar serverUrl = '".toCharArray();
    __oracle_jsp_text[8] = 
    "';\r\nvar aw = screen.availWidth;\r\nvar ah = screen.availHeight;\r\n\r\nfunction openScreen(screen_url,screen_id)\r\n{\r\n    var screenWidth = aw-5;\r\n    var screenHeight= ah-54;\r\n    var x = aw>800?(aw-screenWidth)/2:0;\r\n    var y = ah>600?(ah-screenHeight)/2:0;\r\n    var winName = screen_id;\r\n      childWindow = window.open(screen_url,winName, 'width='+screenWidth+',height=' + screenHeight+40 + ',left=' + x + ',top=' + y + 'resizable=yes,scrollbars=yes,toolbar=yes,titlebar=yes');\r\n      childWindow.focus();\r\n}\r\nfunction openChildScreen(screen_url,screen_id)\r\n{\r\n    var screenWidth = 600;\r\n    var screenHeight= 400;\r\n    var x = aw>800?(aw-screenWidth)/2:0;\r\n    var y = ah>600?(ah-screenHeight)/2:0;\r\n    var winName = screen_id;\r\n    childWindow = window.open(screen_url,winName, 'width='+screenWidth+',height=' + screenHeight + ',left=' + x + ',top=' + y + 'resizable=no,scrollbars=no,toolbar=no,titlebar=yes');\r\n    childWindow.focus();\r\n}\r\n\r\nfunction doBack() {\r\n    document.menu.action='".toCharArray();
    __oracle_jsp_text[9] = 
    "/pages/Welcome.jsp';\r\n    document.menu.submit();\r\n    return false;\r\n}\r\n</script>\r\n<html>\r\n  <head>\r\n    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=windows-1252\"/>\r\n    <title>Welcome Eservice</title>\r\n    <style type=\"text/css\">\r\n      body {\r\n      background-color: #FFFFFF;\r\n      }\r\n      a:link { color: #736AD6; }\r\n    </style>\r\n  </head>\r\n  <body>\r\n  <form name=\"menu\" method=\"POST\" action=\"#\">\r\n  <div align='center'>\r\n  <p>\r\n  <b>RCL - ESERVICE APPLICATION</b>\r\n  </p>\r\n  <BR>\r\n  <BR>\r\n  </div>\r\n  <div align='center'>\r\n  <table border=\"1\" cellspacing=\"0\" cellpadding=\"0\" width=\"250\">\r\n  <tr>\r\n    <td>User ID :</td>\r\n    <td>\r\n    <input type=\"text\" name=\"userid\" value='".toCharArray();
    __oracle_jsp_text[10] = 
    "' readonly />\r\n    </td>\r\n  </tr>\r\n  </table>\r\n  </p>\r\n  <table border=\"1\" cellspacing=\"0\" cellpadding=\"0\" width=\"250\">\r\n  <tr>\r\n  <td>\r\n  <b>ESERVICE MENU</b>\r\n  </td>\r\n  </tr>\r\n  <!--\r\n\r\n  <tr>\r\n  <td>\r\n  <a href=\"javascript:openScreen(serverUrl + '".toCharArray();
    __oracle_jsp_text[11] = 
    "/do/sedl001?appId=Dolphin','sedl001')\"> Discharge List Overview</a>\r\n  </td>\r\n  </tr>\r\n    <tr>\r\n  <td>\r\n  <a href=\"javascript:openScreen(serverUrl + '".toCharArray();
    __oracle_jsp_text[12] = 
    "/do/sell001?appId=Dolphin','sell001')\"> Load List Overview</a>\r\n  </td>\r\n  </tr>\r\n  <tr>\r\n  <td>\r\n  <a href=\"javascript:openScreen(serverUrl + '".toCharArray();
    __oracle_jsp_text[13] = 
    "/do/secm005?appId=Dolphin','secm005')\"> E-Notice Template</a>\r\n  </td>\r\n  </tr>\r\n  <tr>\r\n  <td>\r\n  <a href=\"javascript:openScreen(serverUrl + '".toCharArray();
    __oracle_jsp_text[14] = 
    "/do/secm007?appId=Dolphin','secm007')\"> Maintain Mail Alert</a>\r\n  </td>\r\n  </tr>\r\n  -->\r\n    <tr>\r\n        <td>\r\n        <a href=\"javascript:openScreen(serverUrl + '".toCharArray();
    __oracle_jsp_text[15] = 
    "/do/serv001?appId=webbkg&tbx_uid=".toCharArray();
    __oracle_jsp_text[16] = 
    "&first_login=first','serv001')\"> NEW WEB BOOKING</a>\r\n        </td>\r\n  </tr>\r\n  <tr>\r\n        <td>\r\n            <a href=\"javascript:openScreen(serverUrl + '".toCharArray();
    __oracle_jsp_text[17] = 
    "/do/serv002?appId=webbkg&tbx_uid=".toCharArray();
    __oracle_jsp_text[18] = 
    "&first_login=first','serv002')\"> WEB BOOKING INQUIRY</a>\r\n        </td>\r\n  </tr>\r\n  <!--tr>\r\n        <td>\r\n            <a href=\"javascript:openScreen(serverUrl + '".toCharArray();
    __oracle_jsp_text[19] = 
    "/do/serv004?appId=webbkg','serv004')\"> TEST PAGE FOR ACK</a>\r\n        </td>\r\n  </tr-->\r\n  <tr>\r\n        <td>\r\n            <a href=\"javascript:openScreen(serverUrl + '".toCharArray();
    __oracle_jsp_text[20] = 
    "/do/serv006?appId=webbkg&tbx_uid=".toCharArray();
    __oracle_jsp_text[21] = 
    "&first_login=first','serv006')\"> E-SHIPPING INSTRUCTION</a>\r\n        </td>\r\n  </tr>\r\n  <tr>\r\n        <td>\r\n            <a href=\"javascript:openScreen(serverUrl + '".toCharArray();
    __oracle_jsp_text[22] = 
    "/do/serv007?appId=webbkg&first_login=first&registMode=R','serv007')\"> REGISTRATION (External)</a>\r\n        </td>\r\n  </tr>\r\n  <tr>\r\n        <td>\r\n            <a href=\"javascript:openScreen(serverUrl + '".toCharArray();
    __oracle_jsp_text[23] = 
    "/do/serv007ManageAccount?appId=webbkg&tbx_uid=".toCharArray();
    __oracle_jsp_text[24] = 
    "&first_login=first','serv007ManageAccount')\"> REGISTRATION (Internal)</a>\r\n        </td>\r\n  </tr>\r\n  <tr>\r\n        <td>\r\n            <a href=\"javascript:openScreen(serverUrl + '".toCharArray();
    __oracle_jsp_text[25] = 
    "/do/serv008?appId=webbkg&first_login=first&txtUserId=".toCharArray();
    __oracle_jsp_text[26] = 
    "&txtPwd=dolphin1','serv008')\"> MRES</a>\r\n        </td>\r\n  </tr>\r\n  <tr>\r\n        <td>\r\n            <a href=\"javascript:openScreen(serverUrl + '".toCharArray();
    __oracle_jsp_text[27] = 
    "/do/serv009?appId=webbkg&tbx_uid=".toCharArray();
    __oracle_jsp_text[28] = 
    "&first_login=first','serv009')\"> FORGET PASSWORD</a>\r\n        </td>\r\n  </tr>\r\n  <tr>\r\n        <td>\r\n            <a href=\"javascript:openScreen(serverUrl + '".toCharArray();
    __oracle_jsp_text[29] = 
    "/do/serv015?appId=webbkg&tbx_uid=".toCharArray();
    __oracle_jsp_text[30] = 
    "&first_login=first','serv015')\">Customer's Registration Requested</a>\r\n        </td>\r\n  </tr>\r\n  <tr>\r\n        <td>\r\n            <a href=\"javascript:openScreen(serverUrl + '".toCharArray();
    __oracle_jsp_text[31] = 
    "/do/serv014?appId=webbkg&country=TH&tbx_uid=".toCharArray();
    __oracle_jsp_text[32] = 
    "&first_login=first','serv014')\">Customer Lookup</a>\r\n        </td>\r\n  </tr>\r\n  <tr>\r\n        <td>\r\n            <a href=\"javascript:openScreen(serverUrl + '".toCharArray();
    __oracle_jsp_text[33] = 
    "/do/serv019?appId=webbkg&tbx_uid=".toCharArray();
    __oracle_jsp_text[34] = 
    "&first_login=first','serv019')\">Refer Commodities</a>\r\n        </td>\r\n  </tr>\r\n  <tr>\r\n        <td>\r\n            <a href=\"javascript:openScreen(serverUrl + '".toCharArray();
    __oracle_jsp_text[35] = 
    "/do/serv022?appId=webbkg&tbx_uid=".toCharArray();
    __oracle_jsp_text[36] = 
    "&first_login=first','serv022')\">UNNO LookUp</a>\r\n        </td>\r\n  </tr>\r\n  <tr>\r\n        <td>\r\n            <a href=\"javascript:openScreen(serverUrl + '".toCharArray();
    __oracle_jsp_text[37] = 
    "/do/serv023?appId=webbkg&tbx_uid=".toCharArray();
    __oracle_jsp_text[38] = 
    "&first_login=first','serv023')\">Upload File</a>\r\n        </td>\r\n  </tr>\r\n  <tr>\r\n        <td>\r\n            <a href=\"javascript:openScreen(serverUrl + '".toCharArray();
    __oracle_jsp_text[39] = 
    "/do/serv025?appId=webbkg&tbx_uid=".toCharArray();
    __oracle_jsp_text[40] = 
    "&first_login=first','serv025')\">Preview uploaded document</a>\r\n        </td>\r\n  </tr>\r\n  <tr>\r\n        <td>\r\n            <a href=\"javascript:openScreen(serverUrl + '".toCharArray();
    __oracle_jsp_text[41] = 
    "/do/serv028equipTypeLookUp?appId=webbkg&tbx_uid=".toCharArray();
    __oracle_jsp_text[42] = 
    "&first_login=first','serv028equipTypeLookUp')\">Equipment Type Lookup</a>\r\n        </td>\r\n  </tr>\r\n  <tr>\r\n        <td>\r\n            <a href=\"javascript:openScreen(serverUrl + '".toCharArray();
    __oracle_jsp_text[43] = 
    "/do/serv029?appId=webbkg&tbx_uid=".toCharArray();
    __oracle_jsp_text[44] = 
    "&first_login=first','serv029')\">Manage Port Pair - Contract Party</a>\r\n        </td>\r\n  </tr>\r\n  <!--\r\n  <tr>\r\n  <td>\r\n  <a href=\"javascript:openScreen(serverUrl + '".toCharArray();
    __oracle_jsp_text[45] = 
    "/do/sedl004?appId=Dolphin&PAGE_URL=/do/sedl004','sedl004')\"> Return Shipment</a>\r\n  </td>\r\n  </tr>\r\n  -->\r\n  </table>\r\n  </p>\r\n  <table border=\"1\" cellspacing=\"0\" cellpadding=\"0\" width=\"250\">\r\n  <tr>\r\n    <td>\r\n    <input type=\"button\" value=\" BACK \" onclick=\"doBack()\"/>\r\n    </td>\r\n  </tr>\r\n  </table>\r\n  </div>\r\n  </form>\r\n  </body>\r\n</html>\r\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
