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
import com.rclgroup.dolphin.rcl.web.eservice.dao.EservicePortClassDao;


public class _EservicePreviewUploadedDocScn extends com.orionserver.http.OrionHttpJspPage {


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
    _EservicePreviewUploadedDocScn page = this;
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
      out.write(__oracle_jsp_text[9]);
      
          String lstrCtxPath     = request.getContextPath();
      
      out.write(__oracle_jsp_text[10]);
      out.print(lstrCtxPath);
      out.write(__oracle_jsp_text[11]);
      out.print(lstrCtxPath);
      out.write(__oracle_jsp_text[12]);
      out.print(lstrCtxPath);
      out.write(__oracle_jsp_text[13]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv025searchData", pageContext));
      out.write(__oracle_jsp_text[14]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv014", pageContext));
      out.write(__oracle_jsp_text[15]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv002BrowseBookingNumber", pageContext));
      out.write(__oracle_jsp_text[16]);
      {
        org.apache.struts.taglib.html.FormTag __jsp_taghandler_1=(org.apache.struts.taglib.html.FormTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.FormTag.class,"org.apache.struts.taglib.html.FormTag action method styleId");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setAction("/serv025");
        __jsp_taghandler_1.setMethod("POST");
        __jsp_taghandler_1.setStyleId("frm");
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[17]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_2=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
              __jsp_taghandler_2.setParent(__jsp_taghandler_1);
              __jsp_taghandler_2.setName("feserv25");
              __jsp_taghandler_2.setProperty("userId");
              __jsp_taghandler_2.setStyleId("userId");
              __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
              if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,2);
            }
            out.write(__oracle_jsp_text[18]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_3=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
              __jsp_taghandler_3.setParent(__jsp_taghandler_1);
              __jsp_taghandler_3.setName("feserv25");
              __jsp_taghandler_3.setProperty("fscCode");
              __jsp_taghandler_3.setStyleId("fscCode");
              __jsp_tag_starteval=__jsp_taghandler_3.doStartTag();
              if (__jsp_taghandler_3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_3,2);
            }
            out.write(__oracle_jsp_text[19]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_4=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag name onblur property styleId");
              __jsp_taghandler_4.setParent(__jsp_taghandler_1);
              __jsp_taghandler_4.setName("feserv25");
              __jsp_taghandler_4.setOnblur("changeUpper(this)");
              __jsp_taghandler_4.setProperty("bookingNo");
              __jsp_taghandler_4.setStyleId("bookingNo");
              __jsp_tag_starteval=__jsp_taghandler_4.doStartTag();
              if (__jsp_taghandler_4.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_4,2);
            }
            out.write(__oracle_jsp_text[20]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_5=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property style styleClass styleId");
              __jsp_taghandler_5.setParent(__jsp_taghandler_1);
              __jsp_taghandler_5.setMaxlength("10");
              __jsp_taghandler_5.setName("feserv25");
              __jsp_taghandler_5.setOnblur("gp_checkDate(this);");
              __jsp_taghandler_5.setProperty("bookingDateFrom");
              __jsp_taghandler_5.setStyle("width:49%");
              __jsp_taghandler_5.setStyleClass("dateForm");
              __jsp_taghandler_5.setStyleId("bookingDateFrom");
              __jsp_tag_starteval=__jsp_taghandler_5.doStartTag();
              if (__jsp_taghandler_5.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_5,2);
            }
            out.write(__oracle_jsp_text[21]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_6=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property style styleClass styleId");
              __jsp_taghandler_6.setParent(__jsp_taghandler_1);
              __jsp_taghandler_6.setMaxlength("10");
              __jsp_taghandler_6.setName("feserv25");
              __jsp_taghandler_6.setOnblur("gp_checkDate(this);");
              __jsp_taghandler_6.setProperty("bookingDateTo");
              __jsp_taghandler_6.setStyle("width:49%");
              __jsp_taghandler_6.setStyleClass("dateForm");
              __jsp_taghandler_6.setStyleId("bookingDateTo");
              __jsp_tag_starteval=__jsp_taghandler_6.doStartTag();
              if (__jsp_taghandler_6.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_6,2);
            }
            out.write(__oracle_jsp_text[22]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_7=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag name property style styleId");
              __jsp_taghandler_7.setParent(__jsp_taghandler_1);
              __jsp_taghandler_7.setName("feserv25");
              __jsp_taghandler_7.setProperty("bookingDateBy");
              __jsp_taghandler_7.setStyle("width: 100px;");
              __jsp_taghandler_7.setStyleId("bookingDateBy");
              __jsp_tag_starteval=__jsp_taghandler_7.doStartTag();
              if (__jsp_taghandler_7.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_7,2);
            }
            out.write(__oracle_jsp_text[23]);
            {
              org.apache.struts.taglib.html.SelectTag __jsp_taghandler_8=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name property styleId size");
              __jsp_taghandler_8.setParent(__jsp_taghandler_1);
              __jsp_taghandler_8.setName("feserv25");
              __jsp_taghandler_8.setProperty("sortBy");
              __jsp_taghandler_8.setStyleId("sortBy");
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
                    __jsp_taghandler_9.setName("feserv25");
                    __jsp_taghandler_9.setProperty("sortByComboList");
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
              org.apache.struts.taglib.html.SelectTag __jsp_taghandler_10=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name property styleId size");
              __jsp_taghandler_10.setParent(__jsp_taghandler_1);
              __jsp_taghandler_10.setName("feserv25");
              __jsp_taghandler_10.setProperty("orderBy");
              __jsp_taghandler_10.setStyleId("orderBy");
              __jsp_taghandler_10.setSize("1");
              __jsp_tag_starteval=__jsp_taghandler_10.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_10,__jsp_tag_starteval,out);
                do {
                  out.write(__oracle_jsp_text[27]);
                  {
                    org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_11=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                    __jsp_taghandler_11.setParent(__jsp_taghandler_10);
                    __jsp_taghandler_11.setLabel("name");
                    __jsp_taghandler_11.setName("feserv25");
                    __jsp_taghandler_11.setProperty("orderByComboList");
                    __jsp_taghandler_11.setValue("code");
                    __jsp_tag_starteval=__jsp_taghandler_11.doStartTag();
                    if (__jsp_taghandler_11.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_11,3);
                  }
                  out.write(__oracle_jsp_text[28]);
                } while (__jsp_taghandler_10.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_10.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_10,2);
            }
            out.write(__oracle_jsp_text[29]);
            {
              org.apache.struts.taglib.logic.GreaterThanTag __jsp_taghandler_12=(org.apache.struts.taglib.logic.GreaterThanTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.GreaterThanTag.class,"org.apache.struts.taglib.logic.GreaterThanTag name property value");
              __jsp_taghandler_12.setParent(__jsp_taghandler_1);
              __jsp_taghandler_12.setName("feserv25");
              __jsp_taghandler_12.setProperty("totRecord");
              __jsp_taghandler_12.setValue("0");
              __jsp_tag_starteval=__jsp_taghandler_12.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[30]);
                  {
                    org.apache.struts.taglib.logic.IterateTag __jsp_taghandler_13=(org.apache.struts.taglib.logic.IterateTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.IterateTag.class,"org.apache.struts.taglib.logic.IterateTag id indexId name property type");
                    __jsp_taghandler_13.setParent(__jsp_taghandler_12);
                    __jsp_taghandler_13.setId("rowdata");
                    __jsp_taghandler_13.setIndexId("ctr");
                    __jsp_taghandler_13.setName("feserv25");
                    __jsp_taghandler_13.setProperty("searchResultsList");
                    __jsp_taghandler_13.setType("com.rclgroup.dolphin.rcl.web.eservice.vo.EservicePreviewUploadedDocMod");
                    com.rclgroup.dolphin.rcl.web.eservice.vo.EservicePreviewUploadedDocMod rowdata = null;
                    java.lang.Integer ctr = null;
                    __jsp_tag_starteval=__jsp_taghandler_13.doStartTag();
                    if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                    {
                      out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_13,__jsp_tag_starteval,out);
                      do {
                        rowdata = (com.rclgroup.dolphin.rcl.web.eservice.vo.EservicePreviewUploadedDocMod) pageContext.findAttribute("rowdata");
                        ctr = (java.lang.Integer) pageContext.findAttribute("ctr");
                        out.write(__oracle_jsp_text[31]);
                        {
                          org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_14=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                          __jsp_taghandler_14.setParent(__jsp_taghandler_13);
                          __jsp_taghandler_14.setName("rowdata");
                          __jsp_taghandler_14.setProperty("bookingNo");
                          __jsp_tag_starteval=__jsp_taghandler_14.doStartTag();
                          if (__jsp_taghandler_14.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_14,4);
                        }
                        out.write(__oracle_jsp_text[32]);
                        {
                          org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_15=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                          __jsp_taghandler_15.setParent(__jsp_taghandler_13);
                          __jsp_taghandler_15.setName("rowdata");
                          __jsp_taghandler_15.setProperty("bookingDate");
                          __jsp_tag_starteval=__jsp_taghandler_15.doStartTag();
                          if (__jsp_taghandler_15.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_15,4);
                        }
                        out.write(__oracle_jsp_text[33]);
                        {
                          org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_16=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                          __jsp_taghandler_16.setParent(__jsp_taghandler_13);
                          __jsp_taghandler_16.setName("rowdata");
                          __jsp_taghandler_16.setProperty("bookingBy");
                          __jsp_tag_starteval=__jsp_taghandler_16.doStartTag();
                          if (__jsp_taghandler_16.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_16,4);
                        }
                        out.write(__oracle_jsp_text[34]);
                        out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv024", pageContext));
                        out.write(__oracle_jsp_text[35]);
                        {
                          org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_17=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                          __jsp_taghandler_17.setParent(__jsp_taghandler_13);
                          __jsp_taghandler_17.setName("rowdata");
                          __jsp_taghandler_17.setProperty("fileName");
                          __jsp_tag_starteval=__jsp_taghandler_17.doStartTag();
                          if (__jsp_taghandler_17.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_17,4);
                        }
                        out.write(__oracle_jsp_text[36]);
                        {
                          org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_18=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                          __jsp_taghandler_18.setParent(__jsp_taghandler_13);
                          __jsp_taghandler_18.setName("rowdata");
                          __jsp_taghandler_18.setProperty("newFileName");
                          __jsp_tag_starteval=__jsp_taghandler_18.doStartTag();
                          if (__jsp_taghandler_18.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_18,4);
                        }
                        out.write(__oracle_jsp_text[37]);
                        {
                          org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_19=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                          __jsp_taghandler_19.setParent(__jsp_taghandler_13);
                          __jsp_taghandler_19.setName("rowdata");
                          __jsp_taghandler_19.setProperty("fileName");
                          __jsp_tag_starteval=__jsp_taghandler_19.doStartTag();
                          if (__jsp_taghandler_19.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_19,4);
                        }
                        out.write(__oracle_jsp_text[38]);
                      } while (__jsp_taghandler_13.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                      out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                    }
                    if (__jsp_taghandler_13.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_13,3);
                  }
                  out.write(__oracle_jsp_text[39]);
                } while (__jsp_taghandler_12.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_12.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_12,2);
            }
            out.write(__oracle_jsp_text[40]);
            {
              org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_20=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name property value");
              __jsp_taghandler_20.setParent(__jsp_taghandler_1);
              __jsp_taghandler_20.setName("feserv25");
              __jsp_taghandler_20.setProperty("totRecord");
              __jsp_taghandler_20.setValue("0");
              __jsp_tag_starteval=__jsp_taghandler_20.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[41]);
                } while (__jsp_taghandler_20.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_20.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_20,2);
            }
            out.write(__oracle_jsp_text[42]);
            {
              String __url=OracleJspRuntime.toStr("../common/tiles/pagination.jsp");
              __url=OracleJspRuntime.genPageUrl(__url,request,response,new String[] {"formName" } ,new String[] {OracleJspRuntime.toStr("feserv25") } );
              // Include 
              pageContext.include( __url,false);
              if (pageContext.getAttribute(OracleJspRuntime.JSP_REQUEST_REDIRECTED, PageContext.REQUEST_SCOPE) != null) return;
            }

            out.write(__oracle_jsp_text[43]);
          } while (__jsp_taghandler_1.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[44]);

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
  private static final char __oracle_jsp_text[][]=new char[45][];
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
    "\r\n".toCharArray();
    __oracle_jsp_text[10] = 
    "\r\n<head>\r\n    <!-- add screen specific JavaScript file -->\r\n    <script language=\"JavaScript\" src=\"".toCharArray();
    __oracle_jsp_text[11] = 
    "/js/common/Constants.js\" ></script>\r\n\r\n    <script language=\"JavaScript\" src=\"".toCharArray();
    __oracle_jsp_text[12] = 
    "/js/RutHelp.js\" ></script>\r\n    \r\n    <!-- add javascript file for this screen -->\r\n    <script language=\"JavaScript\" src=\"".toCharArray();
    __oracle_jsp_text[13] = 
    "/js/screen/EservicePreviewUploadedDoc.js\" ></script>\r\n    \r\n    <script language=\"JavaScript\">\r\n        var SEARCH_CRITERIA                         = '".toCharArray();
    __oracle_jsp_text[14] = 
    "';\r\n        var BOOKED_BY                               = '".toCharArray();
    __oracle_jsp_text[15] = 
    "';\r\n        var BROWSE_BOOKING_NUMBER                   = '".toCharArray();
    __oracle_jsp_text[16] = 
    "';\r\n    </script>\r\n\r\n</head>\r\n\r\n<body>    \r\n    ".toCharArray();
    __oracle_jsp_text[17] = 
    "\r\n        ".toCharArray();
    __oracle_jsp_text[18] = 
    "\r\n        ".toCharArray();
    __oracle_jsp_text[19] = 
    "\r\n        <div class=\"TableLeftSubColor2\">\r\n            <h2>Preview Uploaded Document - Search</h2>\r\n        </div>\r\n        <table class=\"table_search\" border=\"0\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\r\n            <tr style=\"height:30px;\">\r\n                <td width=\"10%\">Booking No</td>\r\n                <td width=\"15%\">\r\n                    ".toCharArray();
    __oracle_jsp_text[20] = 
    "\r\n                    <a name=\"btnBookingNo\" class=\"m-btn smallest blue rnd smallericn-only\" href=\"javascript:void(0)\" onclick='openBookingNumber();'>\r\n                        <i class=\"icon-search icon-white\"></i>\r\n                    </a> \r\n                </td>\r\n                <td width=\"10%\">Booking Date From</td>\r\n                <td width=\"15%\">\r\n                    ".toCharArray();
    __oracle_jsp_text[21] = 
    "\r\n\r\n                    <a href=\"javascript:void(0)\" class=\"m-btn smallest blue rnd smallericn-only\" onClick=\"gp_calendar('bookingDateFrom');\">\r\n                        <i class=\"icon-calendar icon-white\"></i>\r\n                    </a>\r\n                </td>\r\n                <td width=\"10%\">Booking  Date To</td>\r\n                <td width=\"15%\">\r\n                    ".toCharArray();
    __oracle_jsp_text[22] = 
    "\r\n\r\n                    <a href=\"javascript:void(0)\" class=\"m-btn smallest blue rnd smallericn-only\" onClick=\"gp_calendar('bookingDateTo');\">\r\n                        <i class=\"icon-calendar icon-white\"></i>\r\n                    </a>\r\n                </td>\r\n                <td width=\"10%\">Booked By</td>\r\n                <td width=\"15%\">\r\n                    ".toCharArray();
    __oracle_jsp_text[23] = 
    "&nbsp;\r\n                    <a name=\"btnBookingDateBy\" class=\"m-btn smallest blue rnd smallericn-only\" href=\"javascript:void(0)\" onclick='openCustomerData();'>\r\n                        <i class=\"icon-search icon-white\"></i>\r\n                    </a>  \r\n                </td>\r\n            </tr>\r\n            <tr style=\"height:30px;\">\r\n                <td>Sort by</td>\r\n                <td>\r\n                    ".toCharArray();
    __oracle_jsp_text[24] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[25] = 
    "\r\n                    ".toCharArray();
    __oracle_jsp_text[26] = 
    "\r\n                    \r\n                </td>\r\n                <td>Order by</td>\r\n                <td>\r\n                    ".toCharArray();
    __oracle_jsp_text[27] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[28] = 
    "\r\n                    ".toCharArray();
    __oracle_jsp_text[29] = 
    "\r\n                </td>\r\n                <td valign=\"top\" style=\"padding-left:7px;padding-top:1px;\" colspan=\"4\">\r\n                    <a id=\"btnSearch\" name=\"btnSearch\" class=\"m-btn mini blue rnd\"\r\n                        href=\"#\" onClick=\"searchBtn()\">&nbsp;Search\r\n                    </a>\r\n                    <a id=\"btnReset\" name=\"btnReset\" class=\"m-btn mini blue rnd\"\r\n                        href=\"#\" onClick=\"resetBtn()\">&nbsp;Reset\r\n                    </a>\r\n                </td>\r\n            </tr>\r\n        </table>\r\n        <br>\r\n        <div class=\"TableLeftSubColor2\">\r\n            <h2>Preview Uploaded Document List</h2>\r\n        </div>\r\n        <table border=\"0\" width=\"100%\" cellspacing=\"0\" class=\"TablePopup\" >\r\n            <tr>\r\n                <td class=\"tableHeadingBlue\" width=\"15%\">Booking No</td>\r\n                <td class=\"tableHeadingBlue\" width=\"15%\">Booking Date</td>\r\n                <td class=\"tableHeadingBlue\" width=\"30%\">Booked By</td>\r\n                <td class=\"tableHeadingBlue\" width=\"40%\">File Name</td>\r\n            </tr>\r\n        </table>\r\n        \r\n        <table border=\"0\" width=\"100%\" cellspacing=\"0\" class=\"TablePopup\" >\r\n            ".toCharArray();
    __oracle_jsp_text[30] = 
    "\r\n                ".toCharArray();
    __oracle_jsp_text[31] = 
    "\r\n                    <tr>\r\n                        <td class=\"TdLeftDetailPopup\" width=\"15%\" height=\"20px;\">\r\n                            ".toCharArray();
    __oracle_jsp_text[32] = 
    "\r\n                        </td>\r\n                        <td class=\"TdLeftDetailPopup\" width=\"15%\"  height=\"20px;\">\r\n                            ".toCharArray();
    __oracle_jsp_text[33] = 
    "\r\n                        </td>\r\n                        <td class=\"TdLeftDetailPopup\" width=\"30%\"  height=\"20px;\">\r\n                            ".toCharArray();
    __oracle_jsp_text[34] = 
    "\r\n                        </td>\r\n                        <td class=\"TdLeftDetailPopup\" width=\"40%\"  height=\"20px;\">\r\n                            <A href='".toCharArray();
    __oracle_jsp_text[35] = 
    "?pdfName=".toCharArray();
    __oracle_jsp_text[36] = 
    "&fileName=".toCharArray();
    __oracle_jsp_text[37] = 
    "' target=\"_blank\" >\r\n                                ".toCharArray();
    __oracle_jsp_text[38] = 
    "\r\n                            </A>\r\n                        </td>\r\n                    </tr>\r\n                ".toCharArray();
    __oracle_jsp_text[39] = 
    "\r\n            ".toCharArray();
    __oracle_jsp_text[40] = 
    "\r\n            ".toCharArray();
    __oracle_jsp_text[41] = 
    "\r\n                <tr>\r\n                    <td class=\"TdCentertDetailPopup\" height=\"20px;\" colspan=\"4\" >\r\n                        Record not found\r\n                    </td>\r\n                </tr>\r\n            ".toCharArray();
    __oracle_jsp_text[42] = 
    "\r\n        </table>\r\n        ".toCharArray();
    __oracle_jsp_text[43] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[44] = 
    "\r\n</body>\r\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
