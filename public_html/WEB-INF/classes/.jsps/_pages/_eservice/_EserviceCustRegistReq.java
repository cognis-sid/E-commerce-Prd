package _pages._eservice;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;


public class _EserviceCustRegistReq extends com.orionserver.http.OrionHttpJspPage {


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
    _EserviceCustRegistReq page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      out.write(__oracle_jsp_text[1]);
      out.write(__oracle_jsp_text[2]);
      out.write(__oracle_jsp_text[3]);
      
       String lstrCtxPath     = request.getContextPath();
      
      out.write(__oracle_jsp_text[4]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv007", pageContext));
      out.write(__oracle_jsp_text[5]);
      {
        org.apache.struts.taglib.html.FormTag __jsp_taghandler_1=(org.apache.struts.taglib.html.FormTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.FormTag.class,"org.apache.struts.taglib.html.FormTag action method");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setAction("/serv015");
        __jsp_taghandler_1.setMethod("POST");
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[6]);
            {
              org.apache.struts.taglib.logic.NotEmptyTag __jsp_taghandler_2=(org.apache.struts.taglib.logic.NotEmptyTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEmptyTag.class,"org.apache.struts.taglib.logic.NotEmptyTag name property");
              __jsp_taghandler_2.setParent(__jsp_taghandler_1);
              __jsp_taghandler_2.setName("feserv17");
              __jsp_taghandler_2.setProperty("custRegistReqList");
              __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[7]);
                  {
                    org.apache.struts.taglib.logic.IterateTag __jsp_taghandler_3=(org.apache.struts.taglib.logic.IterateTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.IterateTag.class,"org.apache.struts.taglib.logic.IterateTag id indexId name property");
                    __jsp_taghandler_3.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_3.setId("list");
                    __jsp_taghandler_3.setIndexId("rowId");
                    __jsp_taghandler_3.setName("feserv17");
                    __jsp_taghandler_3.setProperty("custRegistReqList");
                    java.lang.Object list = null;
                    java.lang.Integer rowId = null;
                    __jsp_tag_starteval=__jsp_taghandler_3.doStartTag();
                    if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                    {
                      out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_3,__jsp_tag_starteval,out);
                      do {
                        list = (java.lang.Object) pageContext.findAttribute("list");
                        rowId = (java.lang.Integer) pageContext.findAttribute("rowId");
                        out.write(__oracle_jsp_text[8]);
                        {
                          org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_4=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                          __jsp_taghandler_4.setParent(__jsp_taghandler_3);
                          __jsp_taghandler_4.setName("list");
                          __jsp_taghandler_4.setProperty("countryName");
                          __jsp_tag_starteval=__jsp_taghandler_4.doStartTag();
                          if (__jsp_taghandler_4.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_4,4);
                        }
                        out.write(__oracle_jsp_text[9]);
                        {
                          org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_5=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                          __jsp_taghandler_5.setParent(__jsp_taghandler_3);
                          __jsp_taghandler_5.setName("list");
                          __jsp_taghandler_5.setProperty("city");
                          __jsp_tag_starteval=__jsp_taghandler_5.doStartTag();
                          if (__jsp_taghandler_5.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_5,4);
                        }
                        out.write(__oracle_jsp_text[10]);
                        {
                          org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_6=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                          __jsp_taghandler_6.setParent(__jsp_taghandler_3);
                          __jsp_taghandler_6.setName("list");
                          __jsp_taghandler_6.setProperty("companyName");
                          __jsp_tag_starteval=__jsp_taghandler_6.doStartTag();
                          if (__jsp_taghandler_6.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_6,4);
                        }
                        out.write(__oracle_jsp_text[11]);
                        {
                          org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_7=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                          __jsp_taghandler_7.setParent(__jsp_taghandler_3);
                          __jsp_taghandler_7.setName("list");
                          __jsp_taghandler_7.setProperty("userId");
                          __jsp_tag_starteval=__jsp_taghandler_7.doStartTag();
                          if (__jsp_taghandler_7.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_7,4);
                        }
                        out.write(__oracle_jsp_text[12]);
                        {
                          org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_8=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                          __jsp_taghandler_8.setParent(__jsp_taghandler_3);
                          __jsp_taghandler_8.setName("list");
                          __jsp_taghandler_8.setProperty("portPairFlag");
                          __jsp_tag_starteval=__jsp_taghandler_8.doStartTag();
                          if (__jsp_taghandler_8.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_8,4);
                        }
                        out.write(__oracle_jsp_text[13]);
                        {
                          org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_9=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                          __jsp_taghandler_9.setParent(__jsp_taghandler_3);
                          __jsp_taghandler_9.setName("list");
                          __jsp_taghandler_9.setProperty("userName");
                          __jsp_tag_starteval=__jsp_taghandler_9.doStartTag();
                          if (__jsp_taghandler_9.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_9,4);
                        }
                        out.write(__oracle_jsp_text[14]);
                        {
                          org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_10=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                          __jsp_taghandler_10.setParent(__jsp_taghandler_3);
                          __jsp_taghandler_10.setName("list");
                          __jsp_taghandler_10.setProperty("addDateTime");
                          __jsp_tag_starteval=__jsp_taghandler_10.doStartTag();
                          if (__jsp_taghandler_10.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_10,4);
                        }
                        out.write(__oracle_jsp_text[15]);
                      } while (__jsp_taghandler_3.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                      out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                    }
                    if (__jsp_taghandler_3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_3,3);
                  }
                  out.write(__oracle_jsp_text[16]);
                } while (__jsp_taghandler_2.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,2);
            }
            out.write(__oracle_jsp_text[17]);
            {
              String __url=OracleJspRuntime.toStr("../common/tiles/pagination.jsp");
              __url=OracleJspRuntime.genPageUrl(__url,request,response,new String[] {"formName" } ,new String[] {OracleJspRuntime.toStr("feserv17") } );
              // Include 
              pageContext.include( __url,false);
              if (pageContext.getAttribute(OracleJspRuntime.JSP_REQUEST_REDIRECTED, PageContext.REQUEST_SCOPE) != null) return;
            }

            out.write(__oracle_jsp_text[18]);
          } while (__jsp_taghandler_1.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[19]);

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
  private static final char __oracle_jsp_text[][]=new char[20][];
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
    "\r\n<head>\r\n<script type=\"text/javascript\" language=\"JavaScript\">\r\n    var REGISTRATION_REVIEW = '".toCharArray();
    __oracle_jsp_text[5] = 
    "';\r\n    function onLoad(){}\r\n    \r\n    function openRegistrationReview(userId, portPairFlag){\r\n        var url             = REGISTRATION_REVIEW;\r\n        var windowHeight    = screen.height;\r\n        var windowWidth     = screen.width;\r\n        try{\r\n            error_code = 1;\r\n            loading();\r\n            error_code = 2;\r\n            url += '?userRegistId='+userId + \"&portPairFlag=\" + portPairFlag + \"&fromMenu=serv015\";\r\n            error_code = 3;\r\n//            openScreen(url,'serv007');\r\n//            openHelpList(url, windowWidth, windowHeight);\r\n            document.forms[0].action = url;\r\n            document.forms[0].submit();\r\n            error_code = 4;\r\n        }catch(err){\r\n            handleJavaScriptError('openRegistrationReview', err, error_code);     \r\n        }\r\n    }\r\n    \r\n    function refresh(){\r\n        loading();\r\n    \r\n        document.forms[0].action = REGISTRATION_REVIEW;\r\n        document.forms[0].submit();\r\n    }\r\n</script>   \r\n</head>\r\n<body>    \r\n".toCharArray();
    __oracle_jsp_text[6] = 
    "\r\n    <div class=\"TableLeftSubColor2\">\r\n        <h2>Customer's Registration Requested Overview</h2>\r\n    </div>\r\n    <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n    <tr>\r\n        <td width=\"20%\" class=\"TableHeadingRow2\"><span class=\"m0l0iout\">Country</span></td>\r\n        <td width=\"20%\" class=\"TableHeadingRow2\"><span class=\"m0l0iout\">City</span></td>\r\n        <td width=\"20%\" class=\"TableHeadingRow2\"><span class=\"m0l0iout\">Company Name</span></td>\r\n        <td width=\"20%\" class=\"TableHeadingRow2\"><span class=\"m0l0iout\">Customer Name</span></td>\r\n        <td width=\"20%\" class=\"TableHeadingRow2\"><span class=\"m0l0iout\">Requested Date</span></td>\r\n    </tr>\r\n".toCharArray();
    __oracle_jsp_text[7] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[8] = 
    "\r\n    <tr>\r\n        <td class=\"whitebg\" height=\"20px\">\r\n        <span class=\"displayText\">\r\n            ".toCharArray();
    __oracle_jsp_text[9] = 
    "\r\n        </span>\r\n        </td>\r\n        <td class=\"whitebg\">\r\n        <span class=\"displayText\">\r\n            ".toCharArray();
    __oracle_jsp_text[10] = 
    "\r\n        </span>\r\n        </td>\r\n        <td class=\"whitebg\">\r\n            <span class=\"displayText\">\r\n                ".toCharArray();
    __oracle_jsp_text[11] = 
    "\r\n            </span>\r\n        </td>\r\n        <td class=\"whitebg\">\r\n            <a href=\"javascript:void(0)\" onclick=\"openRegistrationReview('".toCharArray();
    __oracle_jsp_text[12] = 
    "', '".toCharArray();
    __oracle_jsp_text[13] = 
    "');\" >\r\n                ".toCharArray();
    __oracle_jsp_text[14] = 
    "\r\n            </a>\r\n        </td>\r\n        <td class=\"whitebg\">\r\n        <span class=\"displayText\">\r\n            ".toCharArray();
    __oracle_jsp_text[15] = 
    "\r\n        </span>\r\n        </td>\r\n    </tr>\r\n    ".toCharArray();
    __oracle_jsp_text[16] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[17] = 
    "\r\n    <tr class=\"tr_sub_detail tr_table_display_detail\">\r\n        <td colspan=\"5\">\r\n    ".toCharArray();
    __oracle_jsp_text[18] = 
    "\r\n        </td>\r\n    </tr>\r\n    </table>\r\n".toCharArray();
    __oracle_jsp_text[19] = 
    "\r\n</body>\r\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
