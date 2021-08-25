package _pages._common._tiles;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.niit.control.common.GlobalConstants;
import com.niit.control.web.action.BaseAction;
import com.niit.control.web.*;


public class _header extends com.orionserver.http.OrionHttpJspPage {


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
    _header page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      out.write(__oracle_jsp_text[1]);
      out.write(__oracle_jsp_text[2]);
      out.write(__oracle_jsp_text[3]);
      out.write(__oracle_jsp_text[4]);
      {
        org.apache.struts.taglib.tiles.UseAttributeTag __jsp_taghandler_1=(org.apache.struts.taglib.tiles.UseAttributeTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.tiles.UseAttributeTag.class,"org.apache.struts.taglib.tiles.UseAttributeTag id name");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setId("lstrProgID");
        __jsp_taghandler_1.setName("progId");
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      java.lang.Object lstrProgID = null;
      lstrProgID = (java.lang.Object) pageContext.findAttribute("lstrProgID");
      out.write(__oracle_jsp_text[5]);
      {
        org.apache.struts.taglib.tiles.UseAttributeTag __jsp_taghandler_2=(org.apache.struts.taglib.tiles.UseAttributeTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.tiles.UseAttributeTag.class,"org.apache.struts.taglib.tiles.UseAttributeTag id name");
        __jsp_taghandler_2.setParent(null);
        __jsp_taghandler_2.setId("lstrFormBeanID");
        __jsp_taghandler_2.setName("formId");
        __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
        if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,1);
      }
      java.lang.Object lstrFormBeanID = null;
      lstrFormBeanID = (java.lang.Object) pageContext.findAttribute("lstrFormBeanID");
      out.write(__oracle_jsp_text[6]);
      {
        org.apache.struts.taglib.tiles.UseAttributeTag __jsp_taghandler_3=(org.apache.struts.taglib.tiles.UseAttributeTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.tiles.UseAttributeTag.class,"org.apache.struts.taglib.tiles.UseAttributeTag id name");
        __jsp_taghandler_3.setParent(null);
        __jsp_taghandler_3.setId("lstrScrTitle");
        __jsp_taghandler_3.setName("title");
        __jsp_tag_starteval=__jsp_taghandler_3.doStartTag();
        if (__jsp_taghandler_3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_3,1);
      }
      java.lang.Object lstrScrTitle = null;
      lstrScrTitle = (java.lang.Object) pageContext.findAttribute("lstrScrTitle");
      out.write(__oracle_jsp_text[7]);
      {
        org.apache.struts.taglib.tiles.UseAttributeTag __jsp_taghandler_4=(org.apache.struts.taglib.tiles.UseAttributeTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.tiles.UseAttributeTag.class,"org.apache.struts.taglib.tiles.UseAttributeTag id name");
        __jsp_taghandler_4.setParent(null);
        __jsp_taghandler_4.setId("lstrScreenHeading");
        __jsp_taghandler_4.setName("screenHeading");
        __jsp_tag_starteval=__jsp_taghandler_4.doStartTag();
        if (__jsp_taghandler_4.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_4,1);
      }
      java.lang.Object lstrScreenHeading = null;
      lstrScreenHeading = (java.lang.Object) pageContext.findAttribute("lstrScreenHeading");
      out.write(__oracle_jsp_text[8]);
      {
        org.apache.struts.taglib.tiles.UseAttributeTag __jsp_taghandler_5=(org.apache.struts.taglib.tiles.UseAttributeTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.tiles.UseAttributeTag.class,"org.apache.struts.taglib.tiles.UseAttributeTag id name");
        __jsp_taghandler_5.setParent(null);
        __jsp_taghandler_5.setId("lstrScreenVersion");
        __jsp_taghandler_5.setName("screenVersion");
        __jsp_tag_starteval=__jsp_taghandler_5.doStartTag();
        if (__jsp_taghandler_5.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_5,1);
      }
      java.lang.Object lstrScreenVersion = null;
      lstrScreenVersion = (java.lang.Object) pageContext.findAttribute("lstrScreenVersion");
      out.write(__oracle_jsp_text[9]);
      {
        org.apache.struts.taglib.bean.DefineTag __jsp_taghandler_6=(org.apache.struts.taglib.bean.DefineTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.DefineTag.class,"org.apache.struts.taglib.bean.DefineTag id name property type");
        __jsp_taghandler_6.setParent(null);
        __jsp_taghandler_6.setId("hasBack");
        __jsp_taghandler_6.setName(OracleJspRuntime.toStr( lstrFormBeanID));
        __jsp_taghandler_6.setProperty("backVisible");
        __jsp_taghandler_6.setType("java.lang.Boolean");
        __jsp_tag_starteval=__jsp_taghandler_6.doStartTag();
        if (__jsp_taghandler_6.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_6,1);
      }
      java.lang.Boolean hasBack = null;
      hasBack = (java.lang.Boolean) pageContext.findAttribute("hasBack");
      out.write(__oracle_jsp_text[10]);
      {
        org.apache.struts.taglib.bean.DefineTag __jsp_taghandler_7=(org.apache.struts.taglib.bean.DefineTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.DefineTag.class,"org.apache.struts.taglib.bean.DefineTag id name property type");
        __jsp_taghandler_7.setParent(null);
        __jsp_taghandler_7.setId("hasRefresh");
        __jsp_taghandler_7.setName(OracleJspRuntime.toStr( lstrFormBeanID));
        __jsp_taghandler_7.setProperty("refreshVisible");
        __jsp_taghandler_7.setType("java.lang.Boolean");
        __jsp_tag_starteval=__jsp_taghandler_7.doStartTag();
        if (__jsp_taghandler_7.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_7,1);
      }
      java.lang.Boolean hasRefresh = null;
      hasRefresh = (java.lang.Boolean) pageContext.findAttribute("hasRefresh");
      out.write(__oracle_jsp_text[11]);
      {
        org.apache.struts.taglib.bean.DefineTag __jsp_taghandler_8=(org.apache.struts.taglib.bean.DefineTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.DefineTag.class,"org.apache.struts.taglib.bean.DefineTag id name property type");
        __jsp_taghandler_8.setParent(null);
        __jsp_taghandler_8.setId("hasSave");
        __jsp_taghandler_8.setName(OracleJspRuntime.toStr( lstrFormBeanID));
        __jsp_taghandler_8.setProperty("saveVisible");
        __jsp_taghandler_8.setType("java.lang.Boolean");
        __jsp_tag_starteval=__jsp_taghandler_8.doStartTag();
        if (__jsp_taghandler_8.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_8,1);
      }
      java.lang.Boolean hasSave = null;
      hasSave = (java.lang.Boolean) pageContext.findAttribute("hasSave");
      out.write(__oracle_jsp_text[12]);
      
      System.out.println("-------hasBack-----------"+hasBack);
      String lstrCtxPath = request.getContextPath();
      UserAccountBean account=(UserAccountBean)session.getAttribute(GlobalConstants.USER_ACCOUNT_BEAN);
      
      response.setHeader("Cache-Control","no-cache"); // HTTP 1.1
      response.setHeader("Pragma","no-cache"); // HTTP 1.0
      response.setDateHeader ("Expires", 0); // prevent caching at the proxy server
      
      System.out.println("-------hasBack-----------"+hasBack);
      
      out.write(__oracle_jsp_text[13]);
      out.print(lstrCtxPath);
      out.write(__oracle_jsp_text[14]);
      out.print(lstrCtxPath);
      out.write(__oracle_jsp_text[15]);
      out.print(lstrCtxPath);
      out.write(__oracle_jsp_text[16]);
      out.print(lstrCtxPath);
      out.write(__oracle_jsp_text[17]);
      out.print(account.getFscAccessLevels());
      out.write(__oracle_jsp_text[18]);
      out.print(lstrScreenHeading);
      out.write(__oracle_jsp_text[19]);
      out.print(account.getUserName());
      out.write(__oracle_jsp_text[20]);
      out.print(account.getCustomerName());
      out.write(__oracle_jsp_text[21]);
      out.write(__oracle_jsp_text[22]);
      out.write(__oracle_jsp_text[23]);
      out.write(__oracle_jsp_text[24]);
      out.print(lstrScreenVersion);
      out.write(__oracle_jsp_text[25]);

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
  private static final char __oracle_jsp_text[][]=new char[26][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\r\n\r\n".toCharArray();
    __oracle_jsp_text[4] = 
    "\r\n\r\n<!--style href>\r\na {\r\n    text-decoration: none\r\n  }\r\n</style-->\r\n\r\n".toCharArray();
    __oracle_jsp_text[5] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[6] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[7] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[8] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[9] = 
    "\r\n\r\n".toCharArray();
    __oracle_jsp_text[10] = 
    " \r\n".toCharArray();
    __oracle_jsp_text[11] = 
    " \r\n".toCharArray();
    __oracle_jsp_text[12] = 
    " \r\n\r\n".toCharArray();
    __oracle_jsp_text[13] = 
    "\r\n<link rel=\"stylesheet\" href=\"".toCharArray();
    __oracle_jsp_text[14] = 
    "/css/jquery-ui-1.8.10.custom.css\"/>\r\n<script type=\"text/javascript\" language=\"JavaScript\" src=\"".toCharArray();
    __oracle_jsp_text[15] = 
    "/js/jquery-1.4.4.min.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript\" src=\"".toCharArray();
    __oracle_jsp_text[16] = 
    "/js/jquery-ui-1.8.10.offset.datepicker.min.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript\" src=\"".toCharArray();
    __oracle_jsp_text[17] = 
    "/js/please_wait.js\" ></script>\r\n<script type=\"text/javascript\" language=\"JavaScript\">\r\nvar fscAccessLevels = '".toCharArray();
    __oracle_jsp_text[18] = 
    "';\r\nvar allVals = fscAccessLevels.split(\"/\");\r\n\r\n$(document).ready(function(){\r\n    try{\r\n        $(\".dateForm\").live(\"focus\",function(){\r\n            $(this).datepicker({ changeMonth: true, changeYear: true, dateFormat: 'dd/mm/yy', inline: true });\r\n        });\r\n        $(\".dateFormMust\").live(\"focus\",function(){\r\n            $(this).datepicker({ changeMonth: true, changeYear: true, dateFormat: 'dd/mm/yy', inline: true });\r\n        });\r\n    }catch(e){\r\n        alert(\"header :: \" + e);\r\n    }\r\n    \r\n//    try{\r\n//        var $sidebar   = $(\"#divStayTopLeft\"), \r\n//            $window    = $(window),\r\n//            offset     = $sidebar.offset(),\r\n//            topPadding = $(\"#divStayTopLeft\").height();\r\n//    \r\n//        $(window).scroll(function() {\r\n//            try{\r\n//                $sidebar.stop().animate({\r\n//                    marginTop: $(window).scrollTop() - offset.top - topPadding + $(window).height()\r\n//                }, 400);\r\n//            }catch(e){\r\n//                alert(\"in divStayTopLeft :: \" + e);\r\n//            }\r\n//        });\r\n//    }catch(e){\r\n//        alert(\"divStayTopLeft :: \" + e);\r\n//    }\r\n    \r\n});\r\n\r\nfunction getLine(){\r\n\treturn allVals[0];\r\n}\r\nfunction getTrade(){\r\n\treturn allVals[1];\r\n}\r\nfunction getAgent(){\r\n\treturn allVals[2];\r\n}\r\n</script>\r\n<div class=\"page_title\">\r\n<table border=\"0\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\r\n<tr>\r\n    <td width=\"40%\" class=\"PageTitle\">".toCharArray();
    __oracle_jsp_text[19] = 
    "</td>\r\n    <td width=\"60%\" class=\"PageTitleRight\"><font color=\"#00CCFF\" style=\"font-style:normal;\">Customer Name : </font>".toCharArray();
    __oracle_jsp_text[20] = 
    "<BR><font color=\"#00CCFF\" style=\"font-style:normal;\">Contract Party : </font>".toCharArray();
    __oracle_jsp_text[21] = 
    "\r\n        ".toCharArray();
    __oracle_jsp_text[22] = 
    "\r\n                ".toCharArray();
    __oracle_jsp_text[23] = 
    "\r\n            ".toCharArray();
    __oracle_jsp_text[24] = 
    "\r\n    </td>\r\n</tr>\r\n</table>\r\n</div>\r\n<div class=\"page_info\">\r\n<b>App Ver. </b>ESERVICE_WEB_APP_BUILD_030_01_20151127&nbsp;&nbsp;<br />".toCharArray();
    __oracle_jsp_text[25] = 
    "&nbsp;&nbsp;\r\n</div>\r\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
