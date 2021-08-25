package _pages._eservice;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;


public class _EcmENoticeServiceMaintenanceTScn extends com.orionserver.http.OrionHttpJspPage {


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
    _EcmENoticeServiceMaintenanceTScn page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
       
              String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
      	String mstrStatus = (String) request.getParameter("deamonStatus");
              
      	String status = null;
              
      	if("true".equals(mstrStatus)) {
                  status = "Running";
      	} else if("false".equals(mstrStatus)){
                  status = "Stopped";
      	} else {
                  status = "";
              }
              
      	out.println("Current E-Notice Service Status :: " + status);
      
      out.write(__oracle_jsp_text[1]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/secm010", pageContext));
      out.write(__oracle_jsp_text[2]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/secm010", pageContext));
      out.write(__oracle_jsp_text[3]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/secm010", pageContext));
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
    "<B><FONT ALIGN=\"CENTER\">Welcome to maintain E-Notice service.</FONT><B><BR><BR>\r\n\r\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\r\n\r\n<HEAD>\r\n    \r\n    <SCRIPT language=\"JavaScript\">\r\n\t\t\r\n\t\tfunction onLoad() {\r\n\t\t\r\n\t\t}\r\n\t\t\r\n        function startMailService()\r\n        { \r\n             document.forms[0].SERVICE_TYPE.value = \"START\";\r\n             \r\n             var urlString = '".toCharArray();
    __oracle_jsp_text[2] = 
    "';\r\n             document.forms[0].action=urlString;        \r\n             document.forms[0].submit(); \r\n             return false;\r\n        }\r\n\r\n        function stopMailService()\r\n        {\r\n            document.forms[0].SERVICE_TYPE.value = \"STOP\";        \r\n            var urlString = '".toCharArray();
    __oracle_jsp_text[3] = 
    "';\r\n            document.forms[0].action=urlString;        \r\n            document.forms[0].submit(); \r\n            return false;    \r\n        }\r\n\t\t\r\n        function inquireStatus()\r\n        {\r\n            document.forms[0].SERVICE_TYPE.value = \"INQUIRY\";        \r\n            var urlString = '".toCharArray();
    __oracle_jsp_text[4] = 
    "';\r\n            document.forms[0].action=urlString;        \r\n            document.forms[0].submit(); \r\n            return;\r\n        }\r\n        \r\n    </SCRIPT>\r\n</HEAD>\r\n\r\n<BODY>\r\n    <form METHOD=\"POST\" ACTION=\"/secm010\">\r\n\r\n        <input type=\"hidden\" name=\"PAGE_URL\" value=\"/do/secm010\">    \r\n        <input type=\"hidden\" name=\"SERVICE_TYPE\" value=\"\">\r\n\r\n         <div class=\"buttons_box\">\t\t\r\n                <input type=\"button\" name=\"Start\" class=\"event_btnbutton\" value=\"Start\" onclick=\"startMailService()\">\r\n\t\t<input type=\"button\" name=\"Stop\" class=\"event_btnbutton\" value=\"Stop\" onclick=\"stopMailService()\">\r\n\t\t<input type=\"button\" name=\"Inquire Status\" value=\"Inquire Status\" class=\"event_btnbutton\" onclick=\"inquireStatus()\">\r\n        </div>   \r\n    </form> \r\n</BODY>\r\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
