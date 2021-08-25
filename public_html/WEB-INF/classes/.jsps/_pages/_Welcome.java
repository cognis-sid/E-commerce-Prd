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
import java.util.Locale;


public class _Welcome extends com.orionserver.http.OrionHttpJspPage {


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
    _Welcome page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      out.write(__oracle_jsp_text[1]);
      out.write(__oracle_jsp_text[2]);
      out.write(__oracle_jsp_text[3]);
      out.write(__oracle_jsp_text[4]);
      out.write(__oracle_jsp_text[5]);
      out.write(__oracle_jsp_text[6]);
      		
          String lstrCtxPath = request.getContextPath();
          
      
      out.write(__oracle_jsp_text[7]);
      out.print(lstrCtxPath);
      out.write(__oracle_jsp_text[8]);

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
  private static final char __oracle_jsp_text[][]=new char[9][];
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
    "\r\n".toCharArray();
    __oracle_jsp_text[6] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[7] = 
    "\r\n\r\n<html>\r\n  <head>\r\n    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=windows-1252\"/>\r\n    <title>Welcome Eservice</title>\r\n    <style type=\"text/css\">\r\n      body {\r\n      background-color: #FFFFFF; \r\n      }\r\n      a:link { color: #ffee22; }\r\n    </style>\r\n  </head>\r\n  <body>\r\n  <form name=\"welcome\" method=\"POST\" action=\"".toCharArray();
    __oracle_jsp_text[8] = 
    "/pages/DummyMenu.jsp\">\r\n  <div align='center'>\r\n  <p>\r\n  <b>RCL - ESERVICE APPLICATION</b>\r\n  </p>\r\n  <BR>\r\n  <BR>\r\n  </div>\r\n  <div align='center'>\r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"300\">\r\n      <tr>\r\n            <td>User ID :</td>\r\n            <td>\r\n                <select name=\"userid\" size=\"1\">\r\n                        <option value=\"NIIT01\">Principal User(Admin)</option>\r\n                        <option value=\"BHUDOL1\">Web Booking User for Phillips</option>\r\n                        <option value=\"HQLPRDSS01\">HQ Business Super user</option>\r\n                        <option value=\"SINSAM01\">SIN - Sales Manager</option>  \r\n                        <option value=\"BNECSE01\">BNE - Sales Exe</option> \r\n                        <option value=\"BKKCSDOE01\" >BKK - BKKCSDOE01</option> \r\n                        <option value=\"SINWEB01\" selected>BKK - SINWEB01</option>  \r\n                        <option value=\"sinweb01\">BKK - sinweb01</option>   \r\n                        <option value=\"watcho1\">BKK - watcho1</option> \r\n                        <option value=\"BKKWEB01\">BKK - BKKWEB01</option> \r\n                        <option value=\"BKKWEB02\">BKK - BKKWEB02</option> \r\n                        <option value=\"DEV_TEAM\">DEV_TEAM</option>\r\n                        <option value=\"SINWEB02\">SINWEB02</option>\r\n                        <option value=\"SINWEB03\">SINWEB03</option>\r\n                        <option value=\"BKKWEB04\">BKKWEB04</option>\r\n                </select>\r\n            </td>\r\n            <td>\r\n                <input type=\"submit\" id=\"btnSubmit\" name=\"btnSubmit\" value=\" OK \"/>\r\n            </td>\r\n      </tr>\r\n  </table>\r\n  </div>\r\n  </form>\r\n  </body>\r\n</html>\r\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
