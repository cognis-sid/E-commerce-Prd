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


public class _EserviceAcknowledgementPopup extends com.orionserver.http.OrionHttpJspPage {


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
    _EserviceAcknowledgementPopup page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      out.write(__oracle_jsp_text[1]);
      out.write(__oracle_jsp_text[2]);
      out.write(__oracle_jsp_text[3]);
      out.write(__oracle_jsp_text[4]);
      out.write(__oracle_jsp_text[5]);
      
          String lstrCtxPath     = request.getContextPath();
      
      out.write(__oracle_jsp_text[6]);
      out.print(lstrCtxPath);
      out.write(__oracle_jsp_text[7]);
      out.print(lstrCtxPath);
      out.write(__oracle_jsp_text[8]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv002BrowseBookingNumber", pageContext));
      out.write(__oracle_jsp_text[9]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv002", pageContext));
      out.write(__oracle_jsp_text[10]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv002GetData", pageContext));
      out.write(__oracle_jsp_text[11]);
      {
        org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_1=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setName("feserv01");
        __jsp_taghandler_1.setProperty("bookingNo");
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[12]);
      {
        org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_2=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
        __jsp_taghandler_2.setParent(null);
        __jsp_taghandler_2.setName("feserv01");
        __jsp_taghandler_2.setProperty("email");
        __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
        if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,1);
      }
      out.write(__oracle_jsp_text[13]);
      {
        org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_3=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
        __jsp_taghandler_3.setParent(null);
        __jsp_taghandler_3.setName("feserv01");
        __jsp_taghandler_3.setProperty("bookingNo");
        __jsp_tag_starteval=__jsp_taghandler_3.doStartTag();
        if (__jsp_taghandler_3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_3,1);
      }
      out.write(__oracle_jsp_text[14]);
      {
        org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_4=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
        __jsp_taghandler_4.setParent(null);
        __jsp_taghandler_4.setName("feserv01");
        __jsp_taghandler_4.setProperty("customerName");
        __jsp_tag_starteval=__jsp_taghandler_4.doStartTag();
        if (__jsp_taghandler_4.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_4,1);
      }
      out.write(__oracle_jsp_text[15]);
      {
        org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_5=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
        __jsp_taghandler_5.setParent(null);
        __jsp_taghandler_5.setName("feserv01");
        __jsp_taghandler_5.setProperty("userId");
        __jsp_tag_starteval=__jsp_taghandler_5.doStartTag();
        if (__jsp_taghandler_5.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_5,1);
      }
      out.write(__oracle_jsp_text[16]);

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
  private static final char __oracle_jsp_text[][]=new char[17][];
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
    "\r\n".toCharArray();
    __oracle_jsp_text[5] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[6] = 
    "\r\n<head>\r\n<script type=\"text/javascript\" language=\"JavaScript\" src=\"".toCharArray();
    __oracle_jsp_text[7] = 
    "/js/RutHelp.js\" ></script>\r\n<script type=\"text/javascript\" language=\"JavaScript\" src=\"".toCharArray();
    __oracle_jsp_text[8] = 
    "/js/screen/EserviceAcknowledgementPopup.js\" ></script>\r\n\r\n<script type=\"text/javascript\" language=\"JavaScript\">\r\n    var BROWSE_BOOKING_NUMBER = '".toCharArray();
    __oracle_jsp_text[9] = 
    "';\r\n    // var GET_BOOKING_NUMBER = '".toCharArray();
    __oracle_jsp_text[10] = 
    "';        \r\n    var GET_BOOKING_NUMBER = '".toCharArray();
    __oracle_jsp_text[11] = 
    "';        \r\n</script>\r\n</head>\r\n\r\n<body>\r\n    ".toCharArray();
    __oracle_jsp_text[12] = 
    "\r\n    <div style=\"padding-left:10px;padding-right:10px\">\r\n        <div class=\"popupHeader\">Thank you for your booking request!</div> \r\n        <br>\r\n        <div>The acknowledgement for the same will be sent shortly  to the email: <span class=\"displayMail\">".toCharArray();
    __oracle_jsp_text[13] = 
    "</span> and requested list of recipient email addresses.</div>        \r\n        <br>\r\n        <div>Your booking is binding as soon as you receive the booking confirmation from us via email as soon as we can confirm space availability and any other details pertainting to this request.</div>        \r\n        <table width=\"50%\" cellspacing=\"5\" border=\"0\" align=\"center\">\r\n            <tr style=\"height: 10px\">\r\n                <td width=\"25%\"><strong>Booking Number</strong></td>\r\n                <td width=\"25%\">".toCharArray();
    __oracle_jsp_text[14] = 
    "</td>\r\n            </tr>\r\n            <tr style=\"height: 10px\">\r\n                <td><strong>Quotation Company</strong></td>\r\n                <td >".toCharArray();
    __oracle_jsp_text[15] = 
    "</td>\r\n            </tr>\r\n            <tr style=\"height: 10px\">\r\n                <td><strong>Booked By</strong></td>\r\n                <td >".toCharArray();
    __oracle_jsp_text[16] = 
    "</td>\r\n            </tr>\r\n        </table>\r\n        <br>\r\n        <div><strong>Note:</strong> The carrier reserves its full rights, and at any given time without prior notice, change the arrangement listed or make alternate arrangment or decline a booking.</div>\r\n        <br><br><br>\r\n        <div align=\"center\" style=\"padding-right:10px;\">\r\n            <a class=\"m-btn sm blue rnd\" \r\n                href=\"#\" onclick=\"window.close();\">OK <i class=\"icon-remove icon-white\"></i>\r\n            </a> \r\n        </div>\r\n    </div>    \r\n</body>\r\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
