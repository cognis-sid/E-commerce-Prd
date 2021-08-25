package _pages._eshipping;

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
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EshippingInstructionUim;


public class _EshippingCargoDescriptionPopup extends com.orionserver.http.OrionHttpJspPage {


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
    _EshippingCargoDescriptionPopup page = this;
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
      out.write(__oracle_jsp_text[7]);
      
          String lstrCtxPath     = request.getContextPath();
      
      out.write(__oracle_jsp_text[8]);
      out.print(lstrCtxPath);
      out.write(__oracle_jsp_text[9]);
      out.write(__oracle_jsp_text[10]);
      {
        org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_1=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setName("feserv06");
        __jsp_taghandler_1.setProperty("commodityRowIndex");
        __jsp_taghandler_1.setStyleId("commodityRowIndex");
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[11]);
      {
        org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_2=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
        __jsp_taghandler_2.setParent(null);
        __jsp_taghandler_2.setName("feserv06");
        __jsp_taghandler_2.setProperty("blNumber");
        __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
        if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,1);
      }
      out.write(__oracle_jsp_text[12]);
      {
        org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_3=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
        __jsp_taghandler_3.setParent(null);
        __jsp_taghandler_3.setName("feserv06");
        __jsp_taghandler_3.setProperty("commodity");
        __jsp_tag_starteval=__jsp_taghandler_3.doStartTag();
        if (__jsp_taghandler_3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_3,1);
      }
      out.write(__oracle_jsp_text[13]);
      {
        org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_4=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
        __jsp_taghandler_4.setParent(null);
        __jsp_taghandler_4.setName("feserv06");
        __jsp_taghandler_4.setProperty("containerNoToCargo");
        __jsp_tag_starteval=__jsp_taghandler_4.doStartTag();
        if (__jsp_taghandler_4.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_4,1);
      }
      out.write(__oracle_jsp_text[14]);
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
    "\r\n".toCharArray();
    __oracle_jsp_text[8] = 
    "\r\n<head>\r\n<script type=\"text/javascript\" language=\"JavaScript\" src=\"".toCharArray();
    __oracle_jsp_text[9] = 
    "/js/screen/EshippingCargoDescriptionPopup.js\" ></script>\r\n</head>\r\n<body>    \r\n    ".toCharArray();
    __oracle_jsp_text[10] = 
    "      \r\n    <!--Begin @02 -->\r\n    ".toCharArray();
    __oracle_jsp_text[11] = 
    "\r\n    <!--End @02 -->\r\n    <table width=\"800\" border=\"0\" cellspacing=\"0\" cellpadding=\"10\">\r\n    <tr>\r\n        <td width=\"20\">&nbsp;</td>\r\n        <td width=\"760\" style=\"margin: 10px\">\r\n            <table border=\"0\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\r\n            <tr>\r\n                <td class=\"TableHeadingRow2\" width=\"26%\"><span class=\"m0l0iout\">B/L Number</span></td>\r\n                <td class=\"TableHeadingRow2\" width=\"37%\"><span class=\"m0l0iout\">Commodity</span></td>\r\n                <td class=\"TableHeadingRow2\"><span class=\"m0l0iout\">Container No.</span></td>\r\n            </tr>\r\n            <tr style=\"height: 20px\">\r\n                <td class=\"whitebg\">\r\n                    <font class=\"displayText\" id=\"posComBookingNo\">\r\n                        ".toCharArray();
    __oracle_jsp_text[12] = 
    "\r\n                    </font>\r\n                </td>\r\n                <td class=\"whitebg\">\r\n                    <font class=\"displayText\" id=\"posStrCommodityForMark\">\r\n                        ".toCharArray();
    __oracle_jsp_text[13] = 
    "\r\n                    </font>\r\n                </td>\r\n                <td class=\"whitebg\">\r\n                    <font class=\"displayText\" id=\"posContainerNoToCargo\">\r\n                        ".toCharArray();
    __oracle_jsp_text[14] = 
    "\r\n                    </font>\r\n                </td>\r\n            </tr>\r\n            <!-- for line spacing -->\r\n            <tr><td></td></tr>\r\n            </table>\r\n            <div class=\"page_info\">\r\n            </div>\r\n            <div class=\"TableLeftSubColor2\">\r\n                <h2>Marks/Desription Details </h2>\r\n            </div>\r\n            <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n            <tr>\r\n                <td width=\"50%\" class=\"TableHeadingRow2\"><span class=\"m0l0iout\">Marks & Numbers</span></td>\r\n                <td class=\"TableHeadingRow2\"><span class=\"m0l0iout\"  style=\"padding-left:17px;\">Description</span></td>\r\n            </tr>\r\n            <tr>\r\n                <td>\r\n                    <textarea  style=\"text-transform: uppercase;\" name=\"txtMarksAndNumbers\" id=\"txtMarksAndNumbers\" cols=\"50\" \r\n                    rows=\"14\" onblur=\"changeUpper(this);\" ></textarea>\r\n                </td>\r\n                <td align=\"right\">\r\n                    <textarea  style=\"text-transform: uppercase;\" name=\"txtDescription\" id=\"txtDescription\" cols=\"50\" \r\n                    rows=\"14\" onblur=\"changeUpper(this);\" ></textarea>\r\n                </td>\r\n            </tr>\r\n            </table>\r\n            <div align=\"right\" style=\"padding-top:5px;\">\r\n                <a id=\"getEquipDetailDisabledBtn\" class=\"m-btn sm rnd disabled\" style=\"display:none\" \r\n                    href=\"#\">Get Equipment Details&nbsp;<i class=\"icon-repeat icon-white\"></i>\r\n                </a> \r\n                <a id=\"getEquipDetailBtn\" class=\"m-btn sm blue rnd\" style=\"display:''\"  \r\n                    href=\"#\" onclick=\"getEquipDetails();\">\r\n                    Get Equipment Details&nbsp;<i class=\"icon-repeat icon-white\"></i>\r\n                </a>\r\n                <a id=\"saveCargoDisabledBtn\" class=\"m-btn sm rnd disabled\" style=\"display:none\" \r\n                    href=\"#\">Save\r\n                </a> \r\n                <a id=\"saveCargoBtn\" class=\"m-btn sm blue rnd\" style=\"display: inline\"  \r\n                    href=\"#\" onclick=\"callbackFromCargoDesc(true);\">Save\r\n                </a> \r\n                <a class=\"m-btn sm blue rnd\" \r\n                    href=\"#\" onclick=\"callbackFromCargoDesc(false);\">Close <i class=\"icon-remove icon-white\"></i>\r\n                </a>\r\n            </div>\r\n        </td>\r\n        <td width=\"20\">&nbsp;</td>\r\n    </tr>\r\n    </table>\r\n    ".toCharArray();
    __oracle_jsp_text[15] = 
    "\r\n</body>\r\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
