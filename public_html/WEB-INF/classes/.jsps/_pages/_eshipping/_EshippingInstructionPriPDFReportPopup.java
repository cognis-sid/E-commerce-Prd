package _pages._eshipping;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EshippingInstructionPrintReportUim;
import java.util.Vector;


public class _EshippingInstructionPriPDFReportPopup extends com.orionserver.http.OrionHttpJspPage {


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
    _EshippingInstructionPriPDFReportPopup page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      out.write(__oracle_jsp_text[1]);
      		
          String lstrCtxPath = request.getContextPath();
      
      out.write(__oracle_jsp_text[2]);
      out.print(lstrCtxPath);
      out.write(__oracle_jsp_text[3]);
      out.print(lstrCtxPath);
      out.write(__oracle_jsp_text[4]);
      com.rclgroup.dolphin.rcl.web.eservice.actionform.EshippingInstructionPrintReportUim eshippingInstructionPrintReportUim;
      synchronized (session) {
        if ((eshippingInstructionPrintReportUim = (com.rclgroup.dolphin.rcl.web.eservice.actionform.EshippingInstructionPrintReportUim) pageContext.getAttribute( "eshippingInstructionPrintReportUim", PageContext.SESSION_SCOPE)) == null) {
          eshippingInstructionPrintReportUim = (com.rclgroup.dolphin.rcl.web.eservice.actionform.EshippingInstructionPrintReportUim) new com.rclgroup.dolphin.rcl.web.eservice.actionform.EshippingInstructionPrintReportUim();
          pageContext.setAttribute( "eshippingInstructionPrintReportUim", eshippingInstructionPrintReportUim, PageContext.SESSION_SCOPE);
        }
      }
      out.write(__oracle_jsp_text[5]);
      out.print(lstrCtxPath);
      out.write(__oracle_jsp_text[6]);
      
            String strError = eshippingInstructionPrintReportUim.getErrMsg()==null?"":eshippingInstructionPrintReportUim.getErrMsg();
        
      out.write(__oracle_jsp_text[7]);
      out.print(strError);
      out.write(__oracle_jsp_text[8]);
      
      
      if("".equals(strError)){
      
      
      out.write(__oracle_jsp_text[9]);
      out.print( eshippingInstructionPrintReportUim.getReportUrl());
      out.write(__oracle_jsp_text[10]);
      //Begin:Footer Section
      out.write(__oracle_jsp_text[11]);
      //End: Footer Section
      out.write(__oracle_jsp_text[12]);
       }else{ 
      out.write(__oracle_jsp_text[13]);
      out.print(strError);
      out.write(__oracle_jsp_text[14]);
      }
      out.write(__oracle_jsp_text[15]);

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
  private static final char __oracle_jsp_text[][]=new char[16][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\r\n<html>\r\n  <head>\r\n   <!-- add screen specific JavaScript file -->\r\n    <script language=\"JavaScript\" src=\"".toCharArray();
    __oracle_jsp_text[3] = 
    "/js/common/Constants.js\" ></script>\r\n    \r\n    <script language=\"JavaScript\" src=\"".toCharArray();
    __oracle_jsp_text[4] = 
    "/js/screen/EshippingInstruction.js\" ></script>    \r\n  \r\n  \r\n  <script language=\"JavaScript\">\r\n  function onLoad() \r\n{   \r\n    var errMsg = document.getElementById(\"errMsg\");\r\n    if(null!=errMsg)\r\n    {\r\n        if(''!=errMsg.value)\r\n        {\r\n         \r\n            showBarMessage(errMsg.value,1);\r\n        }\r\n    }\r\n}\r\n </script>\r\n  \r\n  ".toCharArray();
    __oracle_jsp_text[5] = 
    "\r\n\r\n    <title>EshippingInstructionPriPDFReportPopup</title>\r\n        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=x-windows-874\"/>\r\n        <link rel=\"stylesheet\" type=\"text/css\" href=\"".toCharArray();
    __oracle_jsp_text[6] = 
    "/css/sealiner.css\">\r\n  </head>\r\n  <body  onLoad=\"onLoad();\">\r\n  ".toCharArray();
    __oracle_jsp_text[7] = 
    "\r\n<form  method=\"POST\" action= \"/serv006PreviwPDFReport\">\r\n<input type=\"hidden\" name=\"pageAction\" value=\"\">\r\n<input type=\"hidden\" name=\"reportFormat\" value=\"\">\r\n<input type=\"hidden\" name=\"errMsg\" id=\"errMsg\" value=\"".toCharArray();
    __oracle_jsp_text[8] = 
    "\">\r\n".toCharArray();
    __oracle_jsp_text[9] = 
    "\r\n\r\n<iframe src=\"".toCharArray();
    __oracle_jsp_text[10] = 
    "\" width=\"100%\" height=\"600px\"  frameborder=\"0\" name=\"fraReport\"></iframe>\r\n".toCharArray();
    __oracle_jsp_text[11] = 
    "\r\n\r\n".toCharArray();
    __oracle_jsp_text[12] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[13] = 
    "\r\n<!-- \r\n<h1> ".toCharArray();
    __oracle_jsp_text[14] = 
    ".</h1>\r\n-->\r\n\r\n".toCharArray();
    __oracle_jsp_text[15] = 
    "\r\n\r\n</form>\r\n  </body>\r\n</html>\r\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
