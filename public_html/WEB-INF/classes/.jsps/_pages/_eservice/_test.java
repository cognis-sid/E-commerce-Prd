package _pages._eservice;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;


public class _test extends com.orionserver.http.OrionHttpJspPage {


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
    _test page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);

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
  private static final char __oracle_jsp_text[][]=new char[1][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<head>\r\n<SCRIPT language=\"JavaScript\">\r\n\t\t\r\n\tfunction onLoad() {\r\n\t\r\n\t}\r\n</script>\r\n\r\n<style type=\"text/css\">\r\n<!--\r\n.style1 {font-family: Verdana, Arial, Helvetica, sans-serif}\r\n-->\r\n    </style>\r\n    <!--\r\n<link href=\"file:///D|/RCL/e_service/java/css/RCL.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n<link href=\"file:///D|/RCL/e_service/java/css/NTL.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n<link href=\"file:///D|/RCL/e_service/java/css/EZL.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n<link href=\"file:///D|/RCL/e_service/java/css/MyStyle.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n<link href=\"file:///D|/RCL/e_service/java/css/BGround.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n-->\r\n</head>\r\n<body>\r\n<strong>Web Booking Screen</strong>\r\n<div class=\"TableLeftSubColor\">\r\n  <h2>Booking Details </h2>\r\n</div>\r\n<table class=\"table_search\" border=\"0\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\r\n  <tr>\r\n    <td>Booking Number </td>\r\n    <td class=\"whitebg\">\r\n    </td>\r\n    <td>Quotation Number </td>\r\n    <td class=\"whitebg\">&nbsp;</td>\r\n    <td>Shipment Term </td>\r\n    <td class=\"whitebg\">&nbsp;</td>\r\n    <td>Status</td>\r\n    <td class=\"whitebg\">\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td>Customer Reference</td>\r\n    <td class=\"whitebg\">&nbsp;</td>\r\n    <td>Email</td>\r\n    <td class=\"whitebg\">&nbsp;</td>\r\n    <td>Telephone</td>\r\n    <td class=\"whitebg\">&nbsp;</td>\r\n    <td>Fax</td>\r\n    <td class=\"whitebg\">&nbsp;</td>\r\n  </tr>\r\n  <tr>\r\n    <td width=\"8%\">Contact</td>\r\n    <td class=\"whitebg\" width=\"16%\">&nbsp;</td>\r\n    <td width=\"7%\">&nbsp;</td>\r\n    <td class=\"whitebg\" width=\"15%\">&nbsp;</td>\r\n    <td width=\"6%\">&nbsp;</td>\r\n    <td class=\"whitebg\" width=\"15%\">&nbsp;</td>\r\n    <td width=\"4%\">&nbsp;</td>\r\n    <td class=\"whitebg\" width=\"15%\">&nbsp;</td>\r\n  </tr>\r\n</table>\r\n<div class=\"TableLeftSubColor\">\r\n <h2>Routing Details</h2>\r\n</div>\r\n<!-- div class=\"text_header\" -->\r\n  <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"table_search\">\r\n    <tr>\r\n      <td width=\"11%\" class=\"tableHeading\"><span class=\"m0l0iout\">Original Country</span></td>\r\n      <td width=\"14%\" class=\"tableHeading\"><span class=\"m0l0iout\">Destination Country </span></td>\r\n      <td width=\"14%\" class=\"tableHeading\"><span class=\"m0l0iout\">Place of receipt </span></td>\r\n      <td width=\"16%\" class=\"tableHeading\"><span class=\"m0l0iout\">Port of Loading POL </span></td>\r\n      <td width=\"21%\" class=\"tableHeading\"><span class=\"m0l0iout\">Port of Discharge POD</span></td>\r\n      <td width=\"24%\" class=\"tableHeading\"><span class=\"m0l0iout\">Place of Delivery </span></td>\r\n    </tr>\r\n    <tr>\r\n      <td class=\"tableHeading\"><span class=\"m0l0iout\">Empty Pickup Depot</span></td>\r\n      <td class=\"tableHeading\"><span class=\"m0l0iout\">Empty Pickup Date </span></td>\r\n      <td class=\"tableHeading\"><span class=\"m0l0iout\">Shipment Date </span></td>\r\n      <td class=\"tableHeading\"><span class=\"m0l0iout\">Desired Arriaval Date </span></td>\r\n      <td class=\"tableHeading\"><span class=\"m0l0iout\">Routing</span></td>\r\n      <td class=\"tableHeading\"><span class=\"m0l0iout\"></span></td>\r\n    </tr>\r\n    <tr>\r\n      <td>&nbsp;</td>\r\n      <td>&nbsp;</td>\r\n      <td>&nbsp;</td>\r\n      <td>&nbsp;</td>\r\n      <td>&nbsp;</td>\r\n      <td>&nbsp;</td>\r\n    </tr>\r\n    <tr>\r\n      <td>&nbsp;</td>\r\n      <td>&nbsp;</td>\r\n      <td>&nbsp;</td>\r\n      <td>&nbsp;</td>\r\n      <td>&nbsp;</td>\r\n      <td>&nbsp;</td>\r\n    </tr>\r\n  </table>\r\n  \r\n  \r\n  <div class=\"TableLeftSubColor\">\r\n    <h2>Equipment Details</h2>\r\n  </div>\r\n  <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"table_search\">\r\n    <tr>\r\n      <td width=\"4%\" class=\"tableHeading\"><span class=\"m0l0iout\">#</span></td>\r\n      <td width=\"9%\" class=\"tableHeading\"><span class=\"m0l0iout\">Type</span></td>\r\n      <td width=\"7%\" class=\"tableHeading\"><span class=\"m0l0iout\">Size</span></td>\r\n      <td width=\"16%\" class=\"tableHeading\"><span class=\"m0l0iout\">Cargo Type </span></td>\r\n      <td width=\"11%\" class=\"tableHeading\"><span class=\"m0l0iout\">Laden</span></td>\r\n      <td width=\"11%\" class=\"tableHeading\"><span class=\"m0l0iout\">Mt</span></td>\r\n      <td width=\"15%\" class=\"tableHeading\"><span class=\"m0l0iout\">Gross Container Weight </span></td>\r\n      <td width=\"10%\" class=\"tableHeading\"><span class=\"m0l0iout\">POL Status </span></td>\r\n      <td width=\"10%\" class=\"tableHeading\">POD Status </td>\r\n      <td width=\"7%\" class=\"tableHeading\"><span class=\"m0l0iout\">Select</span></td>\r\n    </tr>\r\n    <tr>\r\n      <td>&nbsp;</td>\r\n      <td>&nbsp;</td>\r\n      <td>&nbsp;</td>\r\n      <td>&nbsp;</td>\r\n      <td>&nbsp;</td>\r\n      <td>&nbsp;</td>\r\n      <td>&nbsp;</td>\r\n      <td>&nbsp;</td>\r\n      <td>&nbsp;</td>\r\n      <td>&nbsp;</td>\r\n    </tr>\r\n    <tr>\r\n      <td>&nbsp;</td>\r\n      <td>&nbsp;</td>\r\n      <td>&nbsp;</td>\r\n      <td>&nbsp;</td>\r\n      <td>&nbsp;</td>\r\n      <td>&nbsp;</td>\r\n      <td>&nbsp;</td>\r\n      <td>&nbsp;</td>\r\n      <td>&nbsp;</td>\r\n      <td>&nbsp;</td>\r\n    </tr>\r\n  </table>\r\n  <div class=\"TableLeftSubColor\">\r\n    <h2>Cargo Description</h2>\r\n  </div>\r\n  text box \r\n  <div class=\"TableLeftSubColor\">\r\n    <h2>Commodity Details</h2>\r\n  </div>\r\n    <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"table_search\">\r\n    <tr>\r\n      <td width=\"8%\" class=\"tableHeading\">&nbsp;</td>\r\n      <td width=\"13%\" class=\"tableHeading\"><span class=\"m0l0iout\">#</span></td>\r\n      <td width=\"11%\" class=\"tableHeading\"><span class=\"m0l0iout\">Commodity Group</span></td>\r\n      <td width=\"20%\" class=\"tableHeading\">&nbsp;</td>\r\n      <td width=\"15%\" class=\"tableHeading\"><span class=\"m0l0iout\">Gross Weight </span></td>\r\n      <td width=\"13%\" class=\"tableHeading\"><span class=\"m0l0iout\">Special Cargo </span></td>\r\n      <td width=\"20%\" class=\"tableHeading\"><span class=\"m0l1iover\">Select</span></td>\r\n    </tr>\r\n  </table>\r\n<!--/div -->\r\n</body>\r\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
