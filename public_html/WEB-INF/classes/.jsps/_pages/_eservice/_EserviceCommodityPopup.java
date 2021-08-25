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
import java.util.List;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceInquiryWebBookingDao;


public class _EserviceCommodityPopup extends com.orionserver.http.OrionHttpJspPage {


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
    _EserviceCommodityPopup page = this;
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
      out.write(__oracle_jsp_text[8]);
      
          String lstrCtxPath     = request.getContextPath();
      
      out.write(__oracle_jsp_text[9]);
      out.print(lstrCtxPath);
      out.write(__oracle_jsp_text[10]);
      out.print(lstrCtxPath);
      out.write(__oracle_jsp_text[11]);
      out.print(lstrCtxPath);
      out.write(__oracle_jsp_text[12]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv004LookupData", pageContext));
      out.write(__oracle_jsp_text[13]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv001", pageContext));
      out.write(__oracle_jsp_text[14]);
      {
        org.apache.struts.taglib.html.FormTag __jsp_taghandler_1=(org.apache.struts.taglib.html.FormTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.FormTag.class,"org.apache.struts.taglib.html.FormTag action method");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setAction("/serv002");
        __jsp_taghandler_1.setMethod("POST");
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[15]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_2=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
              __jsp_taghandler_2.setParent(__jsp_taghandler_1);
              __jsp_taghandler_2.setName("feserv04");
              __jsp_taghandler_2.setProperty("commodityRowIndex");
              __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
              if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,2);
            }
            out.write(__oracle_jsp_text[16]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_3=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag name onblur property");
              __jsp_taghandler_3.setParent(__jsp_taghandler_1);
              __jsp_taghandler_3.setName("feserv04");
              __jsp_taghandler_3.setOnblur("changeUpper(this)");
              __jsp_taghandler_3.setProperty("find");
              __jsp_tag_starteval=__jsp_taghandler_3.doStartTag();
              if (__jsp_taghandler_3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_3,2);
            }
            out.write(__oracle_jsp_text[17]);
            {
              org.apache.struts.taglib.html.SelectTag __jsp_taghandler_4=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name property size");
              __jsp_taghandler_4.setParent(__jsp_taghandler_1);
              __jsp_taghandler_4.setName("feserv04");
              __jsp_taghandler_4.setProperty("column");
              __jsp_taghandler_4.setSize("1");
              __jsp_tag_starteval=__jsp_taghandler_4.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_4,__jsp_tag_starteval,out);
                do {
                  out.write(__oracle_jsp_text[18]);
                  {
                    org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_5=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                    __jsp_taghandler_5.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_5.setLabel("name");
                    __jsp_taghandler_5.setName("feserv04");
                    __jsp_taghandler_5.setProperty("columnList");
                    __jsp_taghandler_5.setValue("code");
                    __jsp_tag_starteval=__jsp_taghandler_5.doStartTag();
                    if (__jsp_taghandler_5.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_5,3);
                  }
                  out.write(__oracle_jsp_text[19]);
                } while (__jsp_taghandler_4.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_4.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_4,2);
            }
            out.write(__oracle_jsp_text[20]);
            {
              org.apache.struts.taglib.html.SelectTag __jsp_taghandler_6=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name property size");
              __jsp_taghandler_6.setParent(__jsp_taghandler_1);
              __jsp_taghandler_6.setName("feserv04");
              __jsp_taghandler_6.setProperty("sortBy");
              __jsp_taghandler_6.setSize("1");
              __jsp_tag_starteval=__jsp_taghandler_6.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_6,__jsp_tag_starteval,out);
                do {
                  out.write(__oracle_jsp_text[21]);
                  {
                    org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_7=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                    __jsp_taghandler_7.setParent(__jsp_taghandler_6);
                    __jsp_taghandler_7.setLabel("name");
                    __jsp_taghandler_7.setName("feserv04");
                    __jsp_taghandler_7.setProperty("sortByList");
                    __jsp_taghandler_7.setValue("code");
                    __jsp_tag_starteval=__jsp_taghandler_7.doStartTag();
                    if (__jsp_taghandler_7.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_7,3);
                  }
                  out.write(__oracle_jsp_text[22]);
                } while (__jsp_taghandler_6.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_6.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_6,2);
            }
            out.write(__oracle_jsp_text[23]);
            {
              org.apache.struts.taglib.html.SelectTag __jsp_taghandler_8=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name property size");
              __jsp_taghandler_8.setParent(__jsp_taghandler_1);
              __jsp_taghandler_8.setName("feserv04");
              __jsp_taghandler_8.setProperty("order");
              __jsp_taghandler_8.setSize("1");
              __jsp_tag_starteval=__jsp_taghandler_8.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_8,__jsp_tag_starteval,out);
                do {
                  out.write(__oracle_jsp_text[24]);
                  {
                    org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_9=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                    __jsp_taghandler_9.setParent(__jsp_taghandler_8);
                    __jsp_taghandler_9.setLabel("name");
                    __jsp_taghandler_9.setName("feserv04");
                    __jsp_taghandler_9.setProperty("orderList");
                    __jsp_taghandler_9.setValue("code");
                    __jsp_tag_starteval=__jsp_taghandler_9.doStartTag();
                    if (__jsp_taghandler_9.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_9,3);
                  }
                  out.write(__oracle_jsp_text[25]);
                } while (__jsp_taghandler_8.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_8.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_8,2);
            }
            out.write(__oracle_jsp_text[26]);
            {
              org.apache.struts.taglib.html.CheckboxTag __jsp_taghandler_10=(org.apache.struts.taglib.html.CheckboxTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.CheckboxTag.class,"org.apache.struts.taglib.html.CheckboxTag name property style styleId value");
              __jsp_taghandler_10.setParent(__jsp_taghandler_1);
              __jsp_taghandler_10.setName("feserv04");
              __jsp_taghandler_10.setProperty("chkBoxWildCard");
              __jsp_taghandler_10.setStyle("float:left;border:0px;width:15px;");
              __jsp_taghandler_10.setStyleId("chkBoxWildCard");
              __jsp_taghandler_10.setValue("Y");
              __jsp_tag_starteval=__jsp_taghandler_10.doStartTag();
              if (__jsp_taghandler_10.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_10,2);
            }
            out.write(__oracle_jsp_text[27]);
            
                            List list = (List)request.getAttribute("listLookupData");     
                        if(null == list){
                                
                        
            out.write(__oracle_jsp_text[28]);
            out.write(__oracle_jsp_text[29]);
            } else if (!list.isEmpty()){
                                 int x = 0;
                        
            out.write(__oracle_jsp_text[30]);
            {
              org.apache.struts.taglib.logic.IterateTag __jsp_taghandler_11=(org.apache.struts.taglib.logic.IterateTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.IterateTag.class,"org.apache.struts.taglib.logic.IterateTag id name");
              __jsp_taghandler_11.setParent(__jsp_taghandler_1);
              __jsp_taghandler_11.setId("listLookupDataId");
              __jsp_taghandler_11.setName("listLookupData");
              java.lang.Object listLookupDataId = null;
              __jsp_tag_starteval=__jsp_taghandler_11.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_11,__jsp_tag_starteval,out);
                do {
                  listLookupDataId = (java.lang.Object) pageContext.findAttribute("listLookupDataId");
                  out.write(__oracle_jsp_text[31]);
                  out.print(x);
                  out.write(__oracle_jsp_text[32]);
                  {
                    org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_12=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                    __jsp_taghandler_12.setParent(__jsp_taghandler_11);
                    __jsp_taghandler_12.setName("listLookupDataId");
                    __jsp_taghandler_12.setProperty("code");
                    __jsp_tag_starteval=__jsp_taghandler_12.doStartTag();
                    if (__jsp_taghandler_12.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_12,3);
                  }
                  out.write(__oracle_jsp_text[33]);
                  {
                    org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_13=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                    __jsp_taghandler_13.setParent(__jsp_taghandler_11);
                    __jsp_taghandler_13.setName("listLookupDataId");
                    __jsp_taghandler_13.setProperty("description");
                    __jsp_tag_starteval=__jsp_taghandler_13.doStartTag();
                    if (__jsp_taghandler_13.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_13,3);
                  }
                  out.write(__oracle_jsp_text[34]);
                  {
                    org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_14=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                    __jsp_taghandler_14.setParent(__jsp_taghandler_11);
                    __jsp_taghandler_14.setName("feserv04");
                    __jsp_taghandler_14.setProperty("commodityRowIndex");
                    __jsp_tag_starteval=__jsp_taghandler_14.doStartTag();
                    if (__jsp_taghandler_14.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_14,3);
                  }
                  out.write(__oracle_jsp_text[35]);
                  out.print(x);
                  out.write(__oracle_jsp_text[36]);
                  {
                    org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_15=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                    __jsp_taghandler_15.setParent(__jsp_taghandler_11);
                    __jsp_taghandler_15.setName("listLookupDataId");
                    __jsp_taghandler_15.setProperty("description");
                    __jsp_tag_starteval=__jsp_taghandler_15.doStartTag();
                    if (__jsp_taghandler_15.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_15,3);
                  }
                  out.write(__oracle_jsp_text[37]);
                  {
                    org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_16=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                    __jsp_taghandler_16.setParent(__jsp_taghandler_11);
                    __jsp_taghandler_16.setName("listLookupDataId");
                    __jsp_taghandler_16.setProperty("code");
                    __jsp_tag_starteval=__jsp_taghandler_16.doStartTag();
                    if (__jsp_taghandler_16.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_16,3);
                  }
                  out.write(__oracle_jsp_text[38]);
                   x++; 
                  out.write(__oracle_jsp_text[39]);
                } while (__jsp_taghandler_11.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_11.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_11,2);
            }
            out.write(__oracle_jsp_text[40]);
            }
            out.write(__oracle_jsp_text[41]);
            {
              String __url=OracleJspRuntime.toStr("../common/tiles/pagination.jsp");
              __url=OracleJspRuntime.genPageUrl(__url,request,response,new String[] {"formName" } ,new String[] {OracleJspRuntime.toStr("feserv04") } );
              // Include 
              pageContext.include( __url,false);
              if (pageContext.getAttribute(OracleJspRuntime.JSP_REQUEST_REDIRECTED, PageContext.REQUEST_SCOPE) != null) return;
            }

            out.write(__oracle_jsp_text[42]);
          } while (__jsp_taghandler_1.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[43]);

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
  private static final char __oracle_jsp_text[][]=new char[44][];
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
    "\r\n".toCharArray();
    __oracle_jsp_text[9] = 
    "\r\n\r\n<head>\r\n    <!-- add screen specific JavaScript file -->\r\n    <script language=\"JavaScript\" src=\"".toCharArray();
    __oracle_jsp_text[10] = 
    "/js/common/Constants.js\" ></script>\r\n\r\n    <script language=\"JavaScript\" src=\"".toCharArray();
    __oracle_jsp_text[11] = 
    "/js/RutHelp.js\" ></script>\r\n    \r\n    <!-- add javascript file for this screen -->\r\n    <script language=\"JavaScript\" src=\"".toCharArray();
    __oracle_jsp_text[12] = 
    "/js/screen/EserviceCommodityPopup.js\" ></script>\r\n    \r\n    <script language=\"JavaScript\">\r\n        var GET_LOOKUP_DATA \r\n            = '".toCharArray();
    __oracle_jsp_text[13] = 
    "';\r\n        var NEW_WEB_BOOKING \r\n            = '".toCharArray();
    __oracle_jsp_text[14] = 
    "';\r\n    </script>\r\n\r\n</head>\r\n\r\n<body>    \r\n    ".toCharArray();
    __oracle_jsp_text[15] = 
    "         \r\n        ".toCharArray();
    __oracle_jsp_text[16] = 
    "\r\n        <table class=\"table_search\" border=\"0\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\r\n            <tr>\r\n                <td width=\"10%\">Find</td>\r\n                <td width=\"25%\">\r\n                    ".toCharArray();
    __oracle_jsp_text[17] = 
    "\r\n                    \r\n                </td>\r\n                <td width=\"10%\">Column</td>\r\n                <td width=\"25%\">\r\n                    ".toCharArray();
    __oracle_jsp_text[18] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[19] = 
    "\r\n                    ".toCharArray();
    __oracle_jsp_text[20] = 
    "\r\n                </td>\r\n                <td valign=\"top\" style=\"padding-left:7px;padding-top:1px;\">\r\n                    <a id=\"btnSearch\" name=\"btnSearch\" class=\"m-btn mini blue rnd\"\r\n                        href=\"#\" onClick=\"searchBtn()\">&nbsp;Search\r\n                    </a>\r\n                    <a id=\"btnReset\" name=\"btnReset\" class=\"m-btn mini blue rnd\"\r\n                        href=\"#\" onClick=\"resetBtn()\">&nbsp;Reset\r\n                    </a>\r\n                </td>\r\n            </tr>\r\n            <tr>\r\n                <td>Sort by</td>\r\n                <td>\r\n                    ".toCharArray();
    __oracle_jsp_text[21] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[22] = 
    "\r\n                    ".toCharArray();
    __oracle_jsp_text[23] = 
    "\r\n                    \r\n                </td>\r\n                <td>Order by</td>\r\n                <td>\r\n                \r\n                    ".toCharArray();
    __oracle_jsp_text[24] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[25] = 
    "\r\n                    ".toCharArray();
    __oracle_jsp_text[26] = 
    "\r\n                <td style=\"padding-top:3px;\">\r\n                    ".toCharArray();
    __oracle_jsp_text[27] = 
    "Wild Card\r\n                    <script>document.getElementById(\"chkBoxWildCard\").checked = true; </script>\r\n                </td>\r\n            </tr>\r\n        </table>\r\n        <br>\r\n        <table border=\"0\" width=\"100%\" cellspacing=\"0\" class=\"TablePopup\" >\r\n            <tr>\r\n                <td class=\"TdLeftHeaderPopup\" width=\"20%\">Description</td>\r\n                <!-- \r\n                <td class=\"TdLeftSubColor\" width=\"20%\">Code</td>\r\n                -->\r\n            </tr>\r\n        </table>\r\n        \r\n        <table border=\"0\" width=\"100%\" cellspacing=\"0\" class=\"TablePopup\" >\r\n            ".toCharArray();
    __oracle_jsp_text[28] = 
    "\r\n                ".toCharArray();
    __oracle_jsp_text[29] = 
    "\r\n            \r\n            ".toCharArray();
    __oracle_jsp_text[30] = 
    "\r\n                ".toCharArray();
    __oracle_jsp_text[31] = 
    "\r\n                    <tr id=\"row".toCharArray();
    __oracle_jsp_text[32] = 
    "\" \r\n                        ondblclick=\"callbackToField('".toCharArray();
    __oracle_jsp_text[33] = 
    "',\r\n                            '".toCharArray();
    __oracle_jsp_text[34] = 
    "',\r\n                            '".toCharArray();
    __oracle_jsp_text[35] = 
    "')\"  \r\n                        onclick=\"highlightradioTD('row".toCharArray();
    __oracle_jsp_text[36] = 
    "')\">\r\n                        \r\n                        <td class=\"TdLeftDetailPopup\" height=\"20px\">".toCharArray();
    __oracle_jsp_text[37] = 
    "</td>\r\n                <!-- \r\n                        <td height=\"20px\">".toCharArray();
    __oracle_jsp_text[38] = 
    "</td>\r\n                -->\r\n                    </tr>\r\n                    ".toCharArray();
    __oracle_jsp_text[39] = 
    "\r\n                ".toCharArray();
    __oracle_jsp_text[40] = 
    "\r\n            \r\n            ".toCharArray();
    __oracle_jsp_text[41] = 
    "\r\n            \r\n        </table>\r\n        ".toCharArray();
    __oracle_jsp_text[42] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[43] = 
    "\r\n</body>\r\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
