package _pages._eservice;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.niit.control.common.GlobalConstants;
import com.niit.control.web.action.BaseAction;
import com.niit.control.web.UserAccountBean;
import com.niit.control.common.StringUtil;


public class _EserviceRegisterAcknowledgePopup extends com.orionserver.http.OrionHttpJspPage {


  // ** Begin Declarations


  // ** End Declarations

  public void _jspService(HttpServletRequest request, HttpServletResponse response) throws java.io.IOException, ServletException {

    response.setContentType( "text/html");
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
    _EserviceRegisterAcknowledgePopup page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      out.write(__oracle_jsp_text[1]);
      out.write(__oracle_jsp_text[2]);
      out.write(__oracle_jsp_text[3]);
      
          String lstrCtxPath     = request.getContextPath();
      
      out.write(__oracle_jsp_text[4]);

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
  private static final char __oracle_jsp_text[][]=new char[5][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[4] = 
    "\r\n<head>\r\n<title></title>\r\n<script type=\"text/javascript\">\r\nfunction closeRegistration(){\r\n    window.close();\r\n    \r\n    window.opener.unloading();\r\n    window.opener.close();\r\n}\r\n</script>\r\n</head>\r\n<body>\r\n    <div style=\"padding-left:10px;padding-right:10px\">\r\n        <div class=\"popupHeader\">Thank you for your interest in RCL eServices!</div> \r\n        <br /><br />\r\n        <div>We received your registration request and it had been forwarded to our RCL person in charge for review.</div>        \r\n        <br /><br />\r\n        <div>You will get the confirmation shortly with login information by email once your account is activated after the review.</div>        \r\n        <br />\r\n        <br /><br /><br />\r\n        <div align=\"center\" style=\"padding-right:10px;\">\r\n            <a class=\"m-btn sm blue rnd\" \r\n                href=\"#\" onclick=\"closeRegistration();\">OK <i class=\"icon-remove icon-white\"></i>\r\n            </a> \r\n        </div>\r\n    </div>    \r\n</body>\r\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
