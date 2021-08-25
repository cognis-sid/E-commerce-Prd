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


public class _EserviceUploadScn extends com.orionserver.http.OrionHttpJspPage {


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
    _EserviceUploadScn page = this;
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
      out.print(lstrCtxPath);
      out.write(__oracle_jsp_text[14]);
      out.print(lstrCtxPath);
      out.write(__oracle_jsp_text[15]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv023onSubmit", pageContext));
      out.write(__oracle_jsp_text[16]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv023sendFileToTemp", pageContext));
      out.write(__oracle_jsp_text[17]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv023onDelete", pageContext));
      out.write(__oracle_jsp_text[18]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv024", pageContext));
      out.write(__oracle_jsp_text[19]);
      {
        org.apache.struts.taglib.html.FormTag __jsp_taghandler_1=(org.apache.struts.taglib.html.FormTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.FormTag.class,"org.apache.struts.taglib.html.FormTag action method styleId");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setAction("/serv023");
        __jsp_taghandler_1.setMethod("POST");
        __jsp_taghandler_1.setStyleId("frm1");
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[20]);
            {
              org.apache.struts.taglib.html.FileTag __jsp_taghandler_2=(org.apache.struts.taglib.html.FileTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.FileTag.class,"org.apache.struts.taglib.html.FileTag name property style styleClass styleId value");
              __jsp_taghandler_2.setParent(__jsp_taghandler_1);
              __jsp_taghandler_2.setName("feserv23");
              __jsp_taghandler_2.setProperty("dataFile");
              __jsp_taghandler_2.setStyle("width:400px;");
              __jsp_taghandler_2.setStyleClass("fupload");
              __jsp_taghandler_2.setStyleId("dataFile");
              __jsp_taghandler_2.setValue("");
              __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
              if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,2);
            }
            out.write(__oracle_jsp_text[21]);
          } while (__jsp_taghandler_1.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[22]);
      {
        org.apache.struts.taglib.html.FormTag __jsp_taghandler_3=(org.apache.struts.taglib.html.FormTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.FormTag.class,"org.apache.struts.taglib.html.FormTag action method styleId");
        __jsp_taghandler_3.setParent(null);
        __jsp_taghandler_3.setAction("/serv023");
        __jsp_taghandler_3.setMethod("POST");
        __jsp_taghandler_3.setStyleId("frm2");
        __jsp_tag_starteval=__jsp_taghandler_3.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[23]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_4=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
              __jsp_taghandler_4.setParent(__jsp_taghandler_3);
              __jsp_taghandler_4.setName("feserv23");
              __jsp_taghandler_4.setProperty("errMsg");
              __jsp_taghandler_4.setStyleId("errMsg");
              __jsp_tag_starteval=__jsp_taghandler_4.doStartTag();
              if (__jsp_taghandler_4.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_4,2);
            }
            out.write(__oracle_jsp_text[24]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_5=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
              __jsp_taghandler_5.setParent(__jsp_taghandler_3);
              __jsp_taghandler_5.setName("feserv23");
              __jsp_taghandler_5.setProperty("maxSeq");
              __jsp_taghandler_5.setStyleId("maxSeq");
              __jsp_tag_starteval=__jsp_taghandler_5.doStartTag();
              if (__jsp_taghandler_5.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_5,2);
            }
            out.write(__oracle_jsp_text[25]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_6=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
              __jsp_taghandler_6.setParent(__jsp_taghandler_3);
              __jsp_taghandler_6.setName("feserv23");
              __jsp_taghandler_6.setProperty("totalSize");
              __jsp_taghandler_6.setStyleId("totalSize");
              __jsp_tag_starteval=__jsp_taghandler_6.doStartTag();
              if (__jsp_taghandler_6.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_6,2);
            }
            out.write(__oracle_jsp_text[26]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_7=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
              __jsp_taghandler_7.setParent(__jsp_taghandler_3);
              __jsp_taghandler_7.setName("feserv23");
              __jsp_taghandler_7.setProperty("disBtn");
              __jsp_taghandler_7.setStyleId("disBtn");
              __jsp_tag_starteval=__jsp_taghandler_7.doStartTag();
              if (__jsp_taghandler_7.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_7,2);
            }
            out.write(__oracle_jsp_text[27]);
            out.print(lstrCtxPath);
            out.write(__oracle_jsp_text[28]);
            out.print(lstrCtxPath);
            out.write(__oracle_jsp_text[29]);
            {
              org.apache.struts.taglib.logic.IterateTag __jsp_taghandler_8=(org.apache.struts.taglib.logic.IterateTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.IterateTag.class,"org.apache.struts.taglib.logic.IterateTag id indexId name property type");
              __jsp_taghandler_8.setParent(__jsp_taghandler_3);
              __jsp_taghandler_8.setId("rowdata");
              __jsp_taghandler_8.setIndexId("ctr");
              __jsp_taghandler_8.setName("feserv23");
              __jsp_taghandler_8.setProperty("list");
              __jsp_taghandler_8.setType("com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceUploadMod");
              com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceUploadMod rowdata = null;
              java.lang.Integer ctr = null;
              __jsp_tag_starteval=__jsp_taghandler_8.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_8,__jsp_tag_starteval,out);
                do {
                  rowdata = (com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceUploadMod) pageContext.findAttribute("rowdata");
                  ctr = (java.lang.Integer) pageContext.findAttribute("ctr");
                  out.write(__oracle_jsp_text[30]);
                  {
                    org.apache.struts.taglib.logic.NotEqualTag __jsp_taghandler_9=(org.apache.struts.taglib.logic.NotEqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEqualTag.class,"org.apache.struts.taglib.logic.NotEqualTag name property value");
                    __jsp_taghandler_9.setParent(__jsp_taghandler_8);
                    __jsp_taghandler_9.setName("rowdata");
                    __jsp_taghandler_9.setProperty("status");
                    __jsp_taghandler_9.setValue("DEL");
                    __jsp_tag_starteval=__jsp_taghandler_9.doStartTag();
                    if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                    {
                      do {
                        out.write(__oracle_jsp_text[31]);
                        {
                          org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_10=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name property value");
                          __jsp_taghandler_10.setParent(__jsp_taghandler_9);
                          __jsp_taghandler_10.setName("rowdata");
                          __jsp_taghandler_10.setProperty("status");
                          __jsp_taghandler_10.setValue("ADD");
                          __jsp_tag_starteval=__jsp_taghandler_10.doStartTag();
                          if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                          {
                            do {
                              out.write(__oracle_jsp_text[32]);
                              {
                                org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_11=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                                __jsp_taghandler_11.setParent(__jsp_taghandler_10);
                                __jsp_taghandler_11.setName("rowdata");
                                __jsp_taghandler_11.setProperty("fileName");
                                __jsp_tag_starteval=__jsp_taghandler_11.doStartTag();
                                if (__jsp_taghandler_11.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_11,5);
                              }
                              out.write(__oracle_jsp_text[33]);
                            } while (__jsp_taghandler_10.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                          }
                          if (__jsp_taghandler_10.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_10,4);
                        }
                        out.write(__oracle_jsp_text[34]);
                        {
                          org.apache.struts.taglib.logic.NotEqualTag __jsp_taghandler_12=(org.apache.struts.taglib.logic.NotEqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEqualTag.class,"org.apache.struts.taglib.logic.NotEqualTag name property value");
                          __jsp_taghandler_12.setParent(__jsp_taghandler_9);
                          __jsp_taghandler_12.setName("rowdata");
                          __jsp_taghandler_12.setProperty("status");
                          __jsp_taghandler_12.setValue("ADD");
                          __jsp_tag_starteval=__jsp_taghandler_12.doStartTag();
                          if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                          {
                            do {
                              out.write(__oracle_jsp_text[35]);
                              out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv024", pageContext));
                              out.write(__oracle_jsp_text[36]);
                              {
                                org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_13=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                                __jsp_taghandler_13.setParent(__jsp_taghandler_12);
                                __jsp_taghandler_13.setName("rowdata");
                                __jsp_taghandler_13.setProperty("fileName");
                                __jsp_tag_starteval=__jsp_taghandler_13.doStartTag();
                                if (__jsp_taghandler_13.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_13,5);
                              }
                              out.write(__oracle_jsp_text[37]);
                              {
                                org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_14=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                                __jsp_taghandler_14.setParent(__jsp_taghandler_12);
                                __jsp_taghandler_14.setName("rowdata");
                                __jsp_taghandler_14.setProperty("newFileName");
                                __jsp_tag_starteval=__jsp_taghandler_14.doStartTag();
                                if (__jsp_taghandler_14.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_14,5);
                              }
                              out.write(__oracle_jsp_text[38]);
                              {
                                org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_15=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                                __jsp_taghandler_15.setParent(__jsp_taghandler_12);
                                __jsp_taghandler_15.setName("rowdata");
                                __jsp_taghandler_15.setProperty("fileName");
                                __jsp_tag_starteval=__jsp_taghandler_15.doStartTag();
                                if (__jsp_taghandler_15.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_15,5);
                              }
                              out.write(__oracle_jsp_text[39]);
                            } while (__jsp_taghandler_12.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                          }
                          if (__jsp_taghandler_12.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_12,4);
                        }
                        out.write(__oracle_jsp_text[40]);
                        {
                          org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_16=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                          __jsp_taghandler_16.setParent(__jsp_taghandler_9);
                          __jsp_taghandler_16.setName("rowdata");
                          __jsp_taghandler_16.setProperty("sizeDisplay");
                          __jsp_tag_starteval=__jsp_taghandler_16.doStartTag();
                          if (__jsp_taghandler_16.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_16,4);
                        }
                        out.write(__oracle_jsp_text[41]);
                        {
                          org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_17=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name property value");
                          __jsp_taghandler_17.setParent(__jsp_taghandler_9);
                          __jsp_taghandler_17.setName("feserv23");
                          __jsp_taghandler_17.setProperty("disBtn");
                          __jsp_taghandler_17.setValue("N");
                          __jsp_tag_starteval=__jsp_taghandler_17.doStartTag();
                          if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                          {
                            do {
                              out.write(__oracle_jsp_text[42]);
                              {
                                org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_18=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                                __jsp_taghandler_18.setParent(__jsp_taghandler_17);
                                __jsp_taghandler_18.setName("rowdata");
                                __jsp_taghandler_18.setProperty("seq");
                                __jsp_tag_starteval=__jsp_taghandler_18.doStartTag();
                                if (__jsp_taghandler_18.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_18,5);
                              }
                              out.write(__oracle_jsp_text[43]);
                              out.print(lstrCtxPath);
                              out.write(__oracle_jsp_text[44]);
                            } while (__jsp_taghandler_17.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                          }
                          if (__jsp_taghandler_17.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_17,4);
                        }
                        out.write(__oracle_jsp_text[45]);
                        {
                          org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_19=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name property value");
                          __jsp_taghandler_19.setParent(__jsp_taghandler_9);
                          __jsp_taghandler_19.setName("feserv23");
                          __jsp_taghandler_19.setProperty("disBtn");
                          __jsp_taghandler_19.setValue("Y");
                          __jsp_tag_starteval=__jsp_taghandler_19.doStartTag();
                          if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                          {
                            do {
                              out.write(__oracle_jsp_text[46]);
                              out.print(lstrCtxPath);
                              out.write(__oracle_jsp_text[47]);
                            } while (__jsp_taghandler_19.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                          }
                          if (__jsp_taghandler_19.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_19,4);
                        }
                        out.write(__oracle_jsp_text[48]);
                        {
                          org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_20=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
                          __jsp_taghandler_20.setParent(__jsp_taghandler_9);
                          __jsp_taghandler_20.setName("rowdata");
                          __jsp_taghandler_20.setProperty("seq");
                          __jsp_tag_starteval=__jsp_taghandler_20.doStartTag();
                          if (__jsp_taghandler_20.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_20,4);
                        }
                        out.write(__oracle_jsp_text[49]);
                        {
                          org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_21=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
                          __jsp_taghandler_21.setParent(__jsp_taghandler_9);
                          __jsp_taghandler_21.setName("rowdata");
                          __jsp_taghandler_21.setProperty("status");
                          __jsp_tag_starteval=__jsp_taghandler_21.doStartTag();
                          if (__jsp_taghandler_21.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_21,4);
                        }
                        out.write(__oracle_jsp_text[50]);
                      } while (__jsp_taghandler_9.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                    }
                    if (__jsp_taghandler_9.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_9,3);
                  }
                  out.write(__oracle_jsp_text[51]);
                } while (__jsp_taghandler_8.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_8.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_8,2);
            }
            out.write(__oracle_jsp_text[52]);
          } while (__jsp_taghandler_3.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_3,1);
      }
      out.write(__oracle_jsp_text[53]);

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
  private static final char __oracle_jsp_text[][]=new char[54][];
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
    "\r\n\r\n<head>\r\n    <script language=\"Javascript\" src=\"".toCharArray();
    __oracle_jsp_text[11] = 
    "/js/jquery-1.6.1.min.js\"></script>\r\n    <script language=\"JavaScript\" src=\"".toCharArray();
    __oracle_jsp_text[12] = 
    "/js/common/Constants.js\" ></script>\r\n    <script language=\"JavaScript\" src=\"".toCharArray();
    __oracle_jsp_text[13] = 
    "/js/RutHelp.js\" ></script>\r\n    <script type=\"text/javascript\" src=\"".toCharArray();
    __oracle_jsp_text[14] = 
    "/js/jquery.AjaxFileUpload.js\" ></script>\r\n    <script language=\"JavaScript\" src=\"".toCharArray();
    __oracle_jsp_text[15] = 
    "/js/screen/EserviceUpload.js\" ></script>\r\n    \r\n    <script type=\"text/javascript\">\r\n        var SUBMIT                  = '".toCharArray();
    __oracle_jsp_text[16] = 
    "';\r\n        var SEND_FILE_TO_TEMP       = '".toCharArray();
    __oracle_jsp_text[17] = 
    "';\r\n        var DELETE                  = '".toCharArray();
    __oracle_jsp_text[18] = 
    "';\r\n        \r\n        var VIEW_PDF                = '".toCharArray();
    __oracle_jsp_text[19] = 
    "';\r\n    </script>\r\n    \r\n    <style type=\"text/css\">\r\n        /* for show browse button on right side */\r\n        fupload {width: 320px; height: 30px; margin: 0; border: 1px solid #777;\r\n          float: left; -webkit-box-sizing: border-box; -moz-box-sizing: border-box; }\r\n        input[type=\"file\"].fupload::-webkit-file-upload-button {\r\n          float: right; position: relative; top: -1px; right: -1px;}\r\n    </style>\r\n\r\n</head>\r\n\r\n<body onload=\"onLoad();\">    \r\n    ".toCharArray();
    __oracle_jsp_text[20] = 
    "\r\n        <table class=\"table_search\" border=\"0\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\r\n            <tr>\r\n                <td width=\"100%\">\r\n                    ".toCharArray();
    __oracle_jsp_text[21] = 
    "<br/>\r\n                    <font color=\"gray\">The file must be in PDF format with a maximum size of 2 MB.</font>\r\n                </td>\r\n            </tr>\r\n        </table>\r\n    ".toCharArray();
    __oracle_jsp_text[22] = 
    "\r\n        <br>\r\n    ".toCharArray();
    __oracle_jsp_text[23] = 
    "\r\n        ".toCharArray();
    __oracle_jsp_text[24] = 
    "\r\n        ".toCharArray();
    __oracle_jsp_text[25] = 
    "\r\n        ".toCharArray();
    __oracle_jsp_text[26] = 
    "\r\n        ".toCharArray();
    __oracle_jsp_text[27] = 
    "\r\n        <input type=\"hidden\" name=\"lstrCtxPath\" id=\"lstrCtxPath\" value=\"".toCharArray();
    __oracle_jsp_text[28] = 
    "\" />\r\n        \r\n        <div align=\"center\" id=\"FreezePane\" class=\"FreezePaneOff\">\r\n            <div id=\"processBar\" class=\"processBarOff\">\r\n                <center>\r\n                    <br/>\r\n                    Please wait...<br/>\r\n                    <img id=\"imgProgress\" valign=\"center\" src=\"".toCharArray();
    __oracle_jsp_text[29] = 
    "/images/loadingAnimation.gif\" alt=\"\" />\r\n                \r\n                </center>\r\n            </div>\r\n        </div>\r\n        \r\n        <table border=\"0\" width=\"100%\" cellspacing=\"0\" class=\"TablePopup\" >\r\n            <tr>\r\n                <td class=\"TdLeftHeaderPopup\" width=\"50%\">File Name</td>\r\n                <td class=\"TdLeftHeaderPopup\" width=\"30%\">File Size</td>\r\n                <td class=\"TdLeftHeaderPopup\" width=\"20%\">Delete</td>\r\n            </tr>\r\n        </table>\r\n        \r\n        <table border=\"0\" width=\"100%\" cellspacing=\"0\" class=\"TablePopup\" id=\"tableData\" >\r\n            ".toCharArray();
    __oracle_jsp_text[30] = 
    "\r\n                    ".toCharArray();
    __oracle_jsp_text[31] = 
    "\r\n                    <tr>\r\n                        <td class=\"TdLeftDetailPopup\" width=\"50%\"  height=\"20px;\">\r\n                            ".toCharArray();
    __oracle_jsp_text[32] = 
    "\r\n                                ".toCharArray();
    __oracle_jsp_text[33] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[34] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[35] = 
    "\r\n                                <A href='".toCharArray();
    __oracle_jsp_text[36] = 
    "?pdfName=".toCharArray();
    __oracle_jsp_text[37] = 
    "&fileName=".toCharArray();
    __oracle_jsp_text[38] = 
    "' target=\"_blank\" >\r\n                                    ".toCharArray();
    __oracle_jsp_text[39] = 
    "\r\n                                </A>\r\n                            ".toCharArray();
    __oracle_jsp_text[40] = 
    "\r\n                        </td>\r\n                        <td class=\"TdLeftDetailPopup\" width=\"30%\"  height=\"20px;\">\r\n                            ".toCharArray();
    __oracle_jsp_text[41] = 
    "&nbsp;\r\n                            <span>KB</span>\r\n                        </td>\r\n                        <td class=\"TdLeftDetailPopup\" width=\"20%\"  height=\"20px;\">\r\n                            ".toCharArray();
    __oracle_jsp_text[42] = 
    "\r\n                                <A href='javascript:void(0)' onclick='lp_delete(".toCharArray();
    __oracle_jsp_text[43] = 
    ", this)' >\r\n                                    <IMG border=\"0\" alt=\"Delete\" src=\"".toCharArray();
    __oracle_jsp_text[44] = 
    "/images/btnClose.gif\" width=\"16\" height=\"16\">\r\n                                </A>\r\n                            ".toCharArray();
    __oracle_jsp_text[45] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[46] = 
    "\r\n                                <A href='javascript:void(0)' onclick='' >\r\n                                    <IMG border=\"0\" alt=\"Delete\" src=\"".toCharArray();
    __oracle_jsp_text[47] = 
    "/images/btnClose.gif\" width=\"16\" height=\"16\">\r\n                                </A>\r\n                            ".toCharArray();
    __oracle_jsp_text[48] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[49] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[50] = 
    "\r\n                        </td>\r\n                    </tr>\r\n                    ".toCharArray();
    __oracle_jsp_text[51] = 
    "\r\n                ".toCharArray();
    __oracle_jsp_text[52] = 
    "\r\n        </table>\r\n        <table border=\"0\" width=\"100%\" cellspacing=\"0\" class=\"TablePopup\" id=\"trSubmitBtn\" >\r\n            <tr>\r\n                <td align=\"center\" width=\"100%\"  height=\"20px;\">\r\n                    <a class=\"m-btn mini blue rnd\" href=\"javascript:void(0)\" onClick=\"submitBtn();\">\r\n                        <strong>Save</strong>\r\n                    </a>\r\n                </td>\r\n            </tr>\r\n        </table>\r\n    ".toCharArray();
    __oracle_jsp_text[53] = 
    "\r\n</body>\r\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
