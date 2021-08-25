package _pages._ecm;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;


public class _EcmENoticeTemplatePreviewScn extends com.orionserver.http.OrionHttpJspPage {


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
    _EcmENoticeTemplatePreviewScn page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      out.write(__oracle_jsp_text[1]);
      out.write(__oracle_jsp_text[2]);
      out.write(__oracle_jsp_text[3]);
      out.write(__oracle_jsp_text[4]);
      		
          String lstrCtxPath = request.getContextPath();
      
      out.write(__oracle_jsp_text[5]);
      out.print(lstrCtxPath);
      out.write(__oracle_jsp_text[6]);
      {
        org.apache.struts.taglib.html.FormTag __jsp_taghandler_1=(org.apache.struts.taglib.html.FormTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.FormTag.class,"org.apache.struts.taglib.html.FormTag action method");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setAction("/secm009");
        __jsp_taghandler_1.setMethod("POST");
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[7]);
            out.write(__oracle_jsp_text[8]);
            {
              org.apache.struts.taglib.html.TextareaTag __jsp_taghandler_2=(org.apache.struts.taglib.html.TextareaTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextareaTag.class,"org.apache.struts.taglib.html.TextareaTag cols name property readonly rows styleClass");
              __jsp_taghandler_2.setParent(__jsp_taghandler_1);
              __jsp_taghandler_2.setCols("120");
              __jsp_taghandler_2.setName("fecm009");
              __jsp_taghandler_2.setProperty("subject");
              __jsp_taghandler_2.setReadonly(true);
              __jsp_taghandler_2.setRows("2");
              __jsp_taghandler_2.setStyleClass("non_edit");
              __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_2,__jsp_tag_starteval,out);
                do {
                  out.write(__oracle_jsp_text[9]);
                } while (__jsp_taghandler_2.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,2);
            }
            out.write(__oracle_jsp_text[10]);
            {
              org.apache.struts.taglib.html.TextareaTag __jsp_taghandler_3=(org.apache.struts.taglib.html.TextareaTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextareaTag.class,"org.apache.struts.taglib.html.TextareaTag cols name property readonly rows styleClass");
              __jsp_taghandler_3.setParent(__jsp_taghandler_1);
              __jsp_taghandler_3.setCols("120");
              __jsp_taghandler_3.setName("fecm009");
              __jsp_taghandler_3.setProperty("body");
              __jsp_taghandler_3.setReadonly(true);
              __jsp_taghandler_3.setRows("18");
              __jsp_taghandler_3.setStyleClass("non_edit");
              __jsp_tag_starteval=__jsp_taghandler_3.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_3,__jsp_tag_starteval,out);
                do {
                  out.write(__oracle_jsp_text[11]);
                } while (__jsp_taghandler_3.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_3,2);
            }
            out.write(__oracle_jsp_text[12]);
          } while (__jsp_taghandler_1.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[13]);

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
  private static final char __oracle_jsp_text[][]=new char[14][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n<HTML xmlns=\"http://www.w3.org/1999/xhtml\">\r\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\r\n\r\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[4] = 
    "\r\n\r\n\r\n".toCharArray();
    __oracle_jsp_text[5] = 
    "\r\n<HEAD>\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\" />\r\n\r\n    <LINK REL=\"stylesheet\" HREF=\"".toCharArray();
    __oracle_jsp_text[6] = 
    "/css/EZL.css\"/>\r\n    <!--meta http-equiv=\"X-UA-Compatible\" content=\"IE=EmulateIE7\"/--> \r\n    <STYLE TYPE=\"text/css\">\r\n         div.search_result{height:100px;}\r\n         table.table_results tbody{height:100px;}\r\n    </STYLE>\r\n    <!--[if IE]>\r\n        <style type=\"text/css\">\r\n            div.search_result {\r\n                position: relative;\r\n                height: 180px;\r\n                width: 100%;\r\n                overflow-y: scroll;\r\n                overflow-x: hidden;\r\n            }\r\n            table.table_results{width:99%}\r\n           \r\n            table.table_results thead tr {\r\n                position: absolute;width:100%;\r\n                top: expression(this.offsetParent.scrollTop);\r\n            }\r\n            table.table_results tbody {\r\n                height: auto;\r\n            }\r\n            /*table.table_results tbody tr td.first_row {\r\n                padding-top: 24px;}*/}\r\n             table.header{width:99%; }             \r\n        </style>\r\n    <![endif]-->   \r\n    \r\n\r\n<SCRIPT TYPE=\"text/javascript\" LANGUAGE=\"JavaScript\">\r\n    var FORM_ID       = 'fecm009';\r\n    var currselrowid  = 'row0';\r\n    \r\n    \r\n    /*Called by framework on-load of this JSP*/\r\n    function onLoad() {    \r\n\t\tvar value \t= window.opener.getControlsForPreview();\r\n\t\tvar lintLoc = value.indexOf(\"~\");\r\n\t\tvar subject = value.substring(0,lintLoc);\r\n\t\tvar body \t= value.substring(lintLoc+1);\r\n\r\n\t\tdocument.getElementById(\"subject\").value = subject;\r\n\t\tdocument.getElementById(\"body\").value \t = body;\r\n    }\r\n    \r\n    function openHelp() {\r\n        \r\n        var strFileName = '1';\r\n        var strUrl = \"/RCLWebApp/help/ApplicationHelp.htm#\"+strFileName;\r\n        var objWindow = window.open(strUrl,\"Help\",\"width=900,height=600,status=no,resizable=no,top=150,left=150\");\r\n        objWindow.focus();\r\n    }\r\n    \r\n    /*To reset theoriginal search criteria before processing*/\r\n    function resetSearchCriteria() {\r\n        \r\n    }\r\n    \r\n    \r\n</SCRIPT>\r\n</HEAD>\r\n<BODY onload='javascript:onLoad()' onunload=\"javascript:doCloseAllChilds()\">\r\n\r\n".toCharArray();
    __oracle_jsp_text[7] = 
    "\r\n    \r\n    ".toCharArray();
    __oracle_jsp_text[8] = 
    "\r\n    <div class=\"text_header\"><h2>Template Preview</h2></div>\r\n    \r\n    \r\n        <TABLE ID=\"result_hdr\" CLASS=\"table_search\"  BORDER=\"0\" CELLPADDING=\"0\" CELLSPACING=\"0\" WIDTH=\"100%\" HEIGHT=\"80%\">\r\n            <TR>\r\n\t\t<TD valign=\"top\" align=\"left\" >Subject</TD>\r\n\t\t<TR>\r\n\t\t<TR>\r\n\t\t<TD WIDTH=\"100%\">\r\n                   ".toCharArray();
    __oracle_jsp_text[9] = 
    "\r\n                    ".toCharArray();
    __oracle_jsp_text[10] = 
    "\r\n\t\t</TD>\r\n\t    </TR>\r\n\t    <TR>\r\n                <TD valign=\"top\" align=\"left\">Body</TD>\r\n\t\t<TR>\r\n\t\t<TR>\r\n\t\t<TD>".toCharArray();
    __oracle_jsp_text[11] = 
    "\r\n            ".toCharArray();
    __oracle_jsp_text[12] = 
    "\r\n\t\t</TD>\r\n\t    </TR>\r\n        </TABLE>   \r\n        \r\n        \r\n  \r\n <br>\r\n \r\n  \r\n".toCharArray();
    __oracle_jsp_text[13] = 
    "\r\n</BODY>\r\n</HTML>\r\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
