package _pages._eservice;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;


public class _EserviceRegistrationTermOfUse extends com.orionserver.http.OrionHttpJspPage {


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
    _EserviceRegistrationTermOfUse page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      
          String contextPath = request.getContextPath();
      
      out.write(__oracle_jsp_text[1]);
      out.print(contextPath);
      out.write(__oracle_jsp_text[2]);
      out.print(contextPath);
      out.write(__oracle_jsp_text[3]);
      out.print(contextPath);
      out.write(__oracle_jsp_text[4]);
      out.print(contextPath);
      out.write(__oracle_jsp_text[5]);
      out.print(contextPath);
      out.write(__oracle_jsp_text[6]);
      out.print(contextPath);
      out.write(__oracle_jsp_text[7]);
      out.print(contextPath);
      out.write(__oracle_jsp_text[8]);
      out.write(__oracle_jsp_text[9]);
      out.write(__oracle_jsp_text[10]);
      out.write(__oracle_jsp_text[11]);
      out.write(__oracle_jsp_text[12]);

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
  private static final char __oracle_jsp_text[][]=new char[13][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\r\n<html>\r\n<head>\r\n<title>RCL Group</title>\r\n<meta content=\"text/html; charset=utf-8\" http-equiv=\"content-type\" />\r\n<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" >\r\n<link type=\"text/css\" href=\"".toCharArray();
    __oracle_jsp_text[2] = 
    "/css/registration/common.css\" rel=\"stylesheet\">\r\n<link type=\"text/css\" href=\"".toCharArray();
    __oracle_jsp_text[3] = 
    "/css/registration/registration.css\" rel=\"stylesheet\">\r\n<link type=\"text/css\" href=\"".toCharArray();
    __oracle_jsp_text[4] = 
    "/css/registration/reset.css\" rel=\"stylesheet\">\r\n<link type=\"text/css\" href=\"".toCharArray();
    __oracle_jsp_text[5] = 
    "/css/registration/style.css\" rel=\"stylesheet\">\r\n<script type=\"text/javascript\" src=\"".toCharArray();
    __oracle_jsp_text[6] = 
    "/js/screen/EserviceRegistration.js\" ></script>\r\n</head>\r\n<body>\r\n    <table width=\"910\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\r\n    <tr>\r\n        <td style=\"padding-left: 10px; padding-right: 10px;\">\r\n        <div style=\"width: 910px; position: relative;\">\r\n            <img src=\"".toCharArray();
    __oracle_jsp_text[7] = 
    "/images/registration/headertop.jpg\" border=\"0\" usemap=\"#Map\" alt=\"country\"  />\r\n            <div id=\"countryMenuDiv\" class=\"rcl_countries\">\r\n                <ul>\r\n                    <li><a href=\"default.aspx\">Home Page</a></li>\r\n                    <!--<li><a href=\"/hongkong/index.asp\" target=\"_blank\">Hong Kong</a></li>-->\r\n                    <li><a href=\"/Australia/\" target=\"_blank\">Australia</a></li>\r\n                    <li><a href=\"/china/\" target=\"_blank\">China å®?æµ·ç®±è¿?é??å?¢</a></li>\r\n                    <!--<li><a href=\"/indonesia/RCL_files/home.asp\" target=\"_blank\">Indonesia</a></li>-->\r\n                </ul>\r\n            </div>\r\n            <map name=\"Map\" id=\"Map\" >\r\n                <area shape=\"rect\" coords=\"5, 6, 123, 64\" href=\"default.aspx\" target=\"_self\" alt=\"Country list\" />\r\n                <!--<area shape=\"rect\" coords=\"621, 22, 670, 51\" href=\"rclhotline_00.asp\" target=\"_self\" />-->\r\n            </map>\r\n        </div>\r\n        </td>\r\n    </tr>\r\n    <tr style=\"height: 30px\">\r\n        <td class=\"td_sub_detail\"><a href=\"javascript: homeClicked();\" style=\"text-decoration: underline;\">Home</a></td>\r\n    </tr>\r\n    <tr>\r\n        <td class=\"td_sub_detail\">\r\n            <table width=\"892\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"table_main_detail\" style=\"height: 400px\">\r\n            <tr class=\"table_tr_header\">\r\n                <td  class=\"font_header\">\r\n                    Terms of Use\r\n                </td>\r\n            </tr>\r\n            <tr>\r\n                <td class=\"td_sub_detail\">\r\n                    <table width=\"882\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"table_sub_detail\" >\r\n                    <tr class=\"tr_sub_detail\" style=\"height\">\r\n                    <th><b>Terms and Conditions</b></th>\r\n                    </tr>\r\n                    <tr class=\"tr_sub_detail\">\r\n                        <td>\r\n                            By accessing this website and/or using any of the online services herein, \r\n                            you have agreed to be bound by the following legal disclaimers and \r\n                            information.  If you do not accept the conditions specified below, \r\n                            you must immediately discontinue your access to this website and/or \r\n                            any of the available online services.<br /><br />\r\n                        </td>\r\n                    </tr>\r\n                    <tr class=\"tr_sub_detail\"><td></td></tr>\r\n                    <tr class=\"tr_sub_detail\">\r\n                        <td>\r\n                            <b>Legal Disclaimers and Information</b>\r\n                            <br /> \r\n                        </td>\r\n                    </tr>\r\n                    <tr class=\"tr_sub_detail\">\r\n                        <td>\r\n                            Although RCL Group of Companies \r\n                            (hereinafter referred to as \"RCL\") tries its best to ensure \r\n                            the accuracy of the information contained in this website, \r\n                            it assumes no responsibility for the accuracy or usefulness \r\n                            or the data available and shall have no obligation to update \r\n                            or otherwise supplement or correct any data provided. <br />\r\n                        </td>\r\n                    </tr>\r\n                    <tr class=\"tr_sub_detail\">\r\n                        <td>\r\n                            Any person or entity (\"user\") using RCLâ€?s website shall \r\n                            agree to defend, indemnify and hold RCL harmless, its agents \r\n                            and employees, harmless from and against all claims, demands, \r\n                            losses, suits, liabilities or expenses, including court costs \r\n                            and legal fees, if any, for property damage, economic loss, \r\n                            consequential losses, injury, disease, or death of persons, \r\n                            in connection with the use or misuse of the data provided.<br />\r\n                        </td>\r\n                    </tr>\r\n                    <tr class=\"tr_sub_detail\">\r\n                        <td>\r\n                            The use of this website is governed by the laws of the \r\n                            Republic of Singapore and to the exclusive jurisdiction \r\n                            to the Supreme Court of Singapore with no recourse whatsoever \r\n                            to any other jurisdiction.<br />\r\n                        </td>\r\n                    </tr>\r\n                    <tr class=\"tr_sub_detail\">\r\n                        <td>\r\n                            This disclaimer shall also be extended to any and all \r\n                            customers, sponsors and partners of RCL who maintain or \r\n                            are offered and accept the use of services and equipment of \r\n                            RCL in any action or claim brought forward by a Browser in \r\n                            conjunction with any matter which includes RCL.<br />\r\n                        </td>\r\n                    </tr>\r\n                    <tr class=\"tr_sub_detail\"><td></td></tr>\r\n                    <tr class=\"tr_sub_detail\">\r\n                        <td >\r\n                            All materials contained within this Web Site, \r\n                            as defined by originating from those sites registered \r\n                            to or operating from the equipment of RCL, and including \r\n                            all text, graphic, programming and ancillary mechanisms not \r\n                            previously licensed by other parties or in public domain are \r\n                            held in sole copyright and trademark ownership by RCL and may \r\n                            not be used without the express written permission of \r\n                            RCL obtained no less than thirty (30) working days prior \r\n                            to any such use, nor may it be used without having been \r\n                            reviewed by the staff and management of RCL.<br />\r\n                        </td>\r\n                    </tr>\r\n                    </table>\r\n                </td>\r\n            </tr>\r\n            </table>\r\n        </td>\r\n    </tr>\r\n    <tr style=\"height: 20px\"><td></td></tr>\r\n    <tr>\r\n        <td>\r\n        <div id=\"footerbox\">\r\n\t    <div id=\"footermain\">\r\n\t        <div style=\"width: 910px;\">\r\n\t            <img src=\"".toCharArray();
    __oracle_jsp_text[8] = 
    "/images/registration/divbottom.jpg\" border=\"0\" class=\"homepageFooterDivider\" />\r\n\t            <p style=\"text-align: center; font-family: Arial; font-size: 10px; line-height: 2em;\">\r\n\t                Copyright 2011 Regional Container Lines. All rights reserved. \r\n\t            </p>\r\n\t\t    \r\n\t\t    <p style=\"text-align: center;\"> \r\n                        <font style=\"text-align: center; font-family: Arial; font-size: 10px; line-height: 2em;\">\r\n\t\t\t".toCharArray();
    __oracle_jsp_text[9] = 
    "\r\n                            Terms of Use\r\n                            ".toCharArray();
    __oracle_jsp_text[10] = 
    "\r\n                        </font>\r\n\t\t\t<font style=\"text-align: center; font-family: Arial; font-size: 10px; line-height: 2em;\">&nbsp;|&nbsp;</font>\r\n\t\t\t<font style=\"text-align: center; font-family: Arial; font-size: 10px; line-height: 2em;\">\r\n\t\t\t".toCharArray();
    __oracle_jsp_text[11] = 
    "\r\n                            Privacy Policy".toCharArray();
    __oracle_jsp_text[12] = 
    "\r\n                        </font>\t\r\n\t\t\t<font style=\"text-align: center; font-family: Arial; font-size: 10px; line-height: 2em;\">&nbsp;|&nbsp;</font>\r\n                        <font style=\"text-align: center; font-family: Arial; font-size: 10px; line-height: 2em;\">\r\n\t\t\tThis website is best viewed with IE 9.x and above.\r\n                        </font>\t\r\n\t\t    </p>\r\n\t        </div>\r\n\t    </div>\r\n\t</div>\r\n        </td>\r\n    </tr>\r\n    <tr style=\"height: 50px\"><td></td></tr>\r\n    </table>\r\n</body>\r\n</html>\r\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
