package _pages._ecm;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;


public class _EcmENoticeTemplateScn extends com.orionserver.http.OrionHttpJspPage {


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
    _EcmENoticeTemplateScn page = this;
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
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/secm005search", pageContext));
      out.write(__oracle_jsp_text[7]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/secm006", pageContext));
      out.write(__oracle_jsp_text[8]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/secm005save", pageContext));
      out.write(__oracle_jsp_text[9]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/secm009", pageContext));
      out.write(__oracle_jsp_text[10]);
      {
        org.apache.struts.taglib.html.FormTag __jsp_taghandler_1=(org.apache.struts.taglib.html.FormTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.FormTag.class,"org.apache.struts.taglib.html.FormTag action method");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setAction("/secm005");
        __jsp_taghandler_1.setMethod("POST");
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[11]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_2=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
              __jsp_taghandler_2.setParent(__jsp_taghandler_1);
              __jsp_taghandler_2.setName("fecm005");
              __jsp_taghandler_2.setProperty("searchPerformed");
              __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
              if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,2);
            }
            out.write(__oracle_jsp_text[12]);
            out.write(__oracle_jsp_text[13]);
            {
              org.apache.struts.taglib.html.SelectTag __jsp_taghandler_3=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name property style styleClass size");
              __jsp_taghandler_3.setParent(__jsp_taghandler_1);
              __jsp_taghandler_3.setName("fecm005");
              __jsp_taghandler_3.setProperty("noticeType");
              __jsp_taghandler_3.setStyle("width:100%;height:25px");
              __jsp_taghandler_3.setStyleClass("must");
              __jsp_taghandler_3.setSize("1");
              __jsp_tag_starteval=__jsp_taghandler_3.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_3,__jsp_tag_starteval,out);
                do {
                  out.write(__oracle_jsp_text[14]);
                  {
                    org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_4=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                    __jsp_taghandler_4.setParent(__jsp_taghandler_3);
                    __jsp_taghandler_4.setLabel("name");
                    __jsp_taghandler_4.setName("fecm005");
                    __jsp_taghandler_4.setProperty("noticeTypeValues");
                    __jsp_taghandler_4.setValue("code");
                    __jsp_tag_starteval=__jsp_taghandler_4.doStartTag();
                    if (__jsp_taghandler_4.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_4,3);
                  }
                  out.write(__oracle_jsp_text[15]);
                } while (__jsp_taghandler_3.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_3,2);
            }
            out.write(__oracle_jsp_text[16]);
            out.write(__oracle_jsp_text[17]);
            out.write(__oracle_jsp_text[18]);
            out.write(__oracle_jsp_text[19]);
            out.write(__oracle_jsp_text[20]);
            {
              org.apache.struts.taglib.logic.IterateTag __jsp_taghandler_5=(org.apache.struts.taglib.logic.IterateTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.IterateTag.class,"org.apache.struts.taglib.logic.IterateTag id indexId name property type");
              __jsp_taghandler_5.setParent(__jsp_taghandler_1);
              __jsp_taghandler_5.setId("rowdata");
              __jsp_taghandler_5.setIndexId("ctr");
              __jsp_taghandler_5.setName("fecm005");
              __jsp_taghandler_5.setProperty("values");
              __jsp_taghandler_5.setType("com.rclgroup.dolphin.ezl.web.ecm.vo.EcmENoticeTemplateMod");
              com.rclgroup.dolphin.ezl.web.ecm.vo.EcmENoticeTemplateMod rowdata = null;
              java.lang.Integer ctr = null;
              __jsp_tag_starteval=__jsp_taghandler_5.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_5,__jsp_tag_starteval,out);
                do {
                  rowdata = (com.rclgroup.dolphin.ezl.web.ecm.vo.EcmENoticeTemplateMod) pageContext.findAttribute("rowdata");
                  ctr = (java.lang.Integer) pageContext.findAttribute("ctr");
                  out.write(__oracle_jsp_text[21]);
                  {
                    org.apache.struts.taglib.html.TextTag __jsp_taghandler_6=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property style styleClass");
                    __jsp_taghandler_6.setParent(__jsp_taghandler_5);
                    __jsp_taghandler_6.setMaxlength("100");
                    __jsp_taghandler_6.setName("fecm005");
                    __jsp_taghandler_6.setOnblur(OracleJspRuntime.toStr( "updateRecordStatus("+ctr+")"));
                    __jsp_taghandler_6.setProperty(OracleJspRuntime.toStr( "value[" + ctr + "].templateDesc"));
                    __jsp_taghandler_6.setStyle("width:127px");
                    __jsp_taghandler_6.setStyleClass("must");
                    __jsp_tag_starteval=__jsp_taghandler_6.doStartTag();
                    if (__jsp_taghandler_6.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_6,3);
                  }
                  out.write(__oracle_jsp_text[22]);
                  {
                    org.apache.struts.taglib.html.SelectTag __jsp_taghandler_7=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name onchange property style size");
                    __jsp_taghandler_7.setParent(__jsp_taghandler_5);
                    __jsp_taghandler_7.setName("fecm005");
                    __jsp_taghandler_7.setOnchange(OracleJspRuntime.toStr( "updateRecordStatus("+ctr+")"));
                    __jsp_taghandler_7.setProperty(OracleJspRuntime.toStr( "value[" + ctr + "].templateLanguage"));
                    __jsp_taghandler_7.setStyle("width:95%");
                    __jsp_taghandler_7.setSize("1");
                    __jsp_tag_starteval=__jsp_taghandler_7.doStartTag();
                    if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                    {
                      out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_7,__jsp_tag_starteval,out);
                      do {
                        out.write(__oracle_jsp_text[23]);
                        {
                          org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_8=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                          __jsp_taghandler_8.setParent(__jsp_taghandler_7);
                          __jsp_taghandler_8.setLabel("name");
                          __jsp_taghandler_8.setName("fecm005");
                          __jsp_taghandler_8.setProperty("templateLanguageValues");
                          __jsp_taghandler_8.setValue("code");
                          __jsp_tag_starteval=__jsp_taghandler_8.doStartTag();
                          if (__jsp_taghandler_8.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_8,4);
                        }
                        out.write(__oracle_jsp_text[24]);
                      } while (__jsp_taghandler_7.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                      out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                    }
                    if (__jsp_taghandler_7.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_7,3);
                  }
                  out.write(__oracle_jsp_text[25]);
                  {
                    org.apache.struts.taglib.html.TextareaTag __jsp_taghandler_9=(org.apache.struts.taglib.html.TextareaTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextareaTag.class,"org.apache.struts.taglib.html.TextareaTag cols name onblur property readonly rows styleClass");
                    __jsp_taghandler_9.setParent(__jsp_taghandler_5);
                    __jsp_taghandler_9.setCols("6");
                    __jsp_taghandler_9.setName("fecm005");
                    __jsp_taghandler_9.setOnblur(OracleJspRuntime.toStr( "updateRecordStatus("+ctr+")"));
                    __jsp_taghandler_9.setProperty(OracleJspRuntime.toStr( "value[" + ctr + "].subject"));
                    __jsp_taghandler_9.setReadonly(true);
                    __jsp_taghandler_9.setRows("1");
                    __jsp_taghandler_9.setStyleClass("non_edit");
                    __jsp_tag_starteval=__jsp_taghandler_9.doStartTag();
                    if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                    {
                      out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_9,__jsp_tag_starteval,out);
                      do {
                        out.write(__oracle_jsp_text[26]);
                      } while (__jsp_taghandler_9.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                      out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                    }
                    if (__jsp_taghandler_9.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_9,3);
                  }
                  out.write(__oracle_jsp_text[27]);
                  {
                    org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_10=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
                    __jsp_taghandler_10.setParent(__jsp_taghandler_5);
                    __jsp_taghandler_10.setName("fecm005");
                    __jsp_taghandler_10.setProperty(OracleJspRuntime.toStr( "value[" + ctr + "].subject"));
                    __jsp_tag_starteval=__jsp_taghandler_10.doStartTag();
                    if (__jsp_taghandler_10.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_10,3);
                  }
                  out.write(__oracle_jsp_text[28]);
                  out.print("openVariableLookup("+1+","+ctr+")");
                  out.write(__oracle_jsp_text[29]);
                  {
                    org.apache.struts.taglib.html.TextareaTag __jsp_taghandler_11=(org.apache.struts.taglib.html.TextareaTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextareaTag.class,"org.apache.struts.taglib.html.TextareaTag cols name onblur property readonly rows styleClass");
                    __jsp_taghandler_11.setParent(__jsp_taghandler_5);
                    __jsp_taghandler_11.setCols("6");
                    __jsp_taghandler_11.setName("fecm005");
                    __jsp_taghandler_11.setOnblur(OracleJspRuntime.toStr( "updateRecordStatus("+ctr+")"));
                    __jsp_taghandler_11.setProperty(OracleJspRuntime.toStr( "value[" + ctr + "].bodyHeader"));
                    __jsp_taghandler_11.setReadonly(true);
                    __jsp_taghandler_11.setRows("1");
                    __jsp_taghandler_11.setStyleClass("non_edit");
                    __jsp_tag_starteval=__jsp_taghandler_11.doStartTag();
                    if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                    {
                      out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_11,__jsp_tag_starteval,out);
                      do {
                        out.write(__oracle_jsp_text[30]);
                      } while (__jsp_taghandler_11.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                      out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                    }
                    if (__jsp_taghandler_11.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_11,3);
                  }
                  out.write(__oracle_jsp_text[31]);
                  {
                    org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_12=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
                    __jsp_taghandler_12.setParent(__jsp_taghandler_5);
                    __jsp_taghandler_12.setName("fecm005");
                    __jsp_taghandler_12.setProperty(OracleJspRuntime.toStr( "value[" + ctr + "].bodyHeader"));
                    __jsp_tag_starteval=__jsp_taghandler_12.doStartTag();
                    if (__jsp_taghandler_12.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_12,3);
                  }
                  out.write(__oracle_jsp_text[32]);
                  out.print("openVariableLookup("+2+","+ctr+")");
                  out.write(__oracle_jsp_text[33]);
                  {
                    org.apache.struts.taglib.html.TextareaTag __jsp_taghandler_13=(org.apache.struts.taglib.html.TextareaTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextareaTag.class,"org.apache.struts.taglib.html.TextareaTag cols name onblur property readonly rows styleClass");
                    __jsp_taghandler_13.setParent(__jsp_taghandler_5);
                    __jsp_taghandler_13.setCols("6");
                    __jsp_taghandler_13.setName("fecm005");
                    __jsp_taghandler_13.setOnblur(OracleJspRuntime.toStr( "updateRecordStatus("+ctr+")"));
                    __jsp_taghandler_13.setProperty(OracleJspRuntime.toStr( "value[" + ctr + "].bodyDetail"));
                    __jsp_taghandler_13.setReadonly(true);
                    __jsp_taghandler_13.setRows("1");
                    __jsp_taghandler_13.setStyleClass("non_edit");
                    __jsp_tag_starteval=__jsp_taghandler_13.doStartTag();
                    if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                    {
                      out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_13,__jsp_tag_starteval,out);
                      do {
                        out.write(__oracle_jsp_text[34]);
                      } while (__jsp_taghandler_13.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                      out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                    }
                    if (__jsp_taghandler_13.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_13,3);
                  }
                  out.write(__oracle_jsp_text[35]);
                  {
                    org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_14=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
                    __jsp_taghandler_14.setParent(__jsp_taghandler_5);
                    __jsp_taghandler_14.setName("fecm005");
                    __jsp_taghandler_14.setProperty(OracleJspRuntime.toStr( "value[" + ctr + "].bodyDetail"));
                    __jsp_tag_starteval=__jsp_taghandler_14.doStartTag();
                    if (__jsp_taghandler_14.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_14,3);
                  }
                  out.write(__oracle_jsp_text[36]);
                  out.print("openVariableLookup("+3+","+ctr+")");
                  out.write(__oracle_jsp_text[37]);
                  {
                    org.apache.struts.taglib.html.TextareaTag __jsp_taghandler_15=(org.apache.struts.taglib.html.TextareaTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextareaTag.class,"org.apache.struts.taglib.html.TextareaTag cols name onblur property readonly rows styleClass");
                    __jsp_taghandler_15.setParent(__jsp_taghandler_5);
                    __jsp_taghandler_15.setCols("6");
                    __jsp_taghandler_15.setName("fecm005");
                    __jsp_taghandler_15.setOnblur(OracleJspRuntime.toStr( "updateRecordStatus("+ctr+")"));
                    __jsp_taghandler_15.setProperty(OracleJspRuntime.toStr( "value[" + ctr + "].bodyFooter"));
                    __jsp_taghandler_15.setReadonly(true);
                    __jsp_taghandler_15.setRows("1");
                    __jsp_taghandler_15.setStyleClass("non_edit");
                    __jsp_tag_starteval=__jsp_taghandler_15.doStartTag();
                    if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                    {
                      out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_15,__jsp_tag_starteval,out);
                      do {
                        out.write(__oracle_jsp_text[38]);
                      } while (__jsp_taghandler_15.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                      out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                    }
                    if (__jsp_taghandler_15.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_15,3);
                  }
                  out.write(__oracle_jsp_text[39]);
                  {
                    org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_16=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
                    __jsp_taghandler_16.setParent(__jsp_taghandler_5);
                    __jsp_taghandler_16.setName("fecm005");
                    __jsp_taghandler_16.setProperty(OracleJspRuntime.toStr( "value[" + ctr + "].bodyFooter"));
                    __jsp_tag_starteval=__jsp_taghandler_16.doStartTag();
                    if (__jsp_taghandler_16.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_16,3);
                  }
                  out.write(__oracle_jsp_text[40]);
                  out.print("openVariableLookup("+4+","+ctr+")");
                  out.write(__oracle_jsp_text[41]);
                  {
                    org.apache.struts.taglib.html.SelectTag __jsp_taghandler_17=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name onchange property style styleClass size");
                    __jsp_taghandler_17.setParent(__jsp_taghandler_5);
                    __jsp_taghandler_17.setName("fecm005");
                    __jsp_taghandler_17.setOnchange(OracleJspRuntime.toStr( "updateRecordStatus("+ctr+")"));
                    __jsp_taghandler_17.setProperty(OracleJspRuntime.toStr( "value[" + ctr + "].attachmentFlag"));
                    __jsp_taghandler_17.setStyle("width:95%;height:20px");
                    __jsp_taghandler_17.setStyleClass("must");
                    __jsp_taghandler_17.setSize("1");
                    __jsp_tag_starteval=__jsp_taghandler_17.doStartTag();
                    if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                    {
                      out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_17,__jsp_tag_starteval,out);
                      do {
                        out.write(__oracle_jsp_text[42]);
                        {
                          org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_18=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                          __jsp_taghandler_18.setParent(__jsp_taghandler_17);
                          __jsp_taghandler_18.setLabel("name");
                          __jsp_taghandler_18.setName("fecm005");
                          __jsp_taghandler_18.setProperty("attachmentFlagValues");
                          __jsp_taghandler_18.setValue("code");
                          __jsp_tag_starteval=__jsp_taghandler_18.doStartTag();
                          if (__jsp_taghandler_18.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_18,4);
                        }
                        out.write(__oracle_jsp_text[43]);
                      } while (__jsp_taghandler_17.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                      out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                    }
                    if (__jsp_taghandler_17.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_17,3);
                  }
                  out.write(__oracle_jsp_text[44]);
                  {
                    org.apache.struts.taglib.html.SelectTag __jsp_taghandler_19=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name onchange property style styleClass size");
                    __jsp_taghandler_19.setParent(__jsp_taghandler_5);
                    __jsp_taghandler_19.setName("fecm005");
                    __jsp_taghandler_19.setOnchange(OracleJspRuntime.toStr( "updateRecordStatus("+ctr+")"));
                    __jsp_taghandler_19.setProperty(OracleJspRuntime.toStr( "value[" + ctr + "].recordStatus"));
                    __jsp_taghandler_19.setStyle("width:95%;height:20px");
                    __jsp_taghandler_19.setStyleClass("must");
                    __jsp_taghandler_19.setSize("1");
                    __jsp_tag_starteval=__jsp_taghandler_19.doStartTag();
                    if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                    {
                      out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_19,__jsp_tag_starteval,out);
                      do {
                        out.write(__oracle_jsp_text[45]);
                        {
                          org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_20=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                          __jsp_taghandler_20.setParent(__jsp_taghandler_19);
                          __jsp_taghandler_20.setLabel("name");
                          __jsp_taghandler_20.setName("fecm005");
                          __jsp_taghandler_20.setProperty("recStatusValues");
                          __jsp_taghandler_20.setValue("code");
                          __jsp_tag_starteval=__jsp_taghandler_20.doStartTag();
                          if (__jsp_taghandler_20.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_20,4);
                        }
                        out.write(__oracle_jsp_text[46]);
                      } while (__jsp_taghandler_19.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                      out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                    }
                    if (__jsp_taghandler_19.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_19,3);
                  }
                  out.write(__oracle_jsp_text[47]);
                  {
                    org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_21=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
                    __jsp_taghandler_21.setParent(__jsp_taghandler_5);
                    __jsp_taghandler_21.setName("fecm005");
                    __jsp_taghandler_21.setProperty(OracleJspRuntime.toStr( "value[" + ctr + "].status"));
                    __jsp_tag_starteval=__jsp_taghandler_21.doStartTag();
                    if (__jsp_taghandler_21.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_21,3);
                  }
                  out.write(__oracle_jsp_text[48]);
                  {
                    org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_22=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
                    __jsp_taghandler_22.setParent(__jsp_taghandler_5);
                    __jsp_taghandler_22.setName("fecm005");
                    __jsp_taghandler_22.setProperty(OracleJspRuntime.toStr( "value[" + ctr + "].updTime"));
                    __jsp_tag_starteval=__jsp_taghandler_22.doStartTag();
                    if (__jsp_taghandler_22.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_22,3);
                  }
                  out.write(__oracle_jsp_text[49]);
                  {
                    org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_23=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
                    __jsp_taghandler_23.setParent(__jsp_taghandler_5);
                    __jsp_taghandler_23.setName("fecm005");
                    __jsp_taghandler_23.setProperty(OracleJspRuntime.toStr( "value[" + ctr + "].templateId"));
                    __jsp_tag_starteval=__jsp_taghandler_23.doStartTag();
                    if (__jsp_taghandler_23.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_23,3);
                  }
                  out.write(__oracle_jsp_text[50]);
                  out.print("openPreview("+ctr+")");
                  out.write(__oracle_jsp_text[51]);
                } while (__jsp_taghandler_5.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_5.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_5,2);
            }
            out.write(__oracle_jsp_text[52]);
            out.write(__oracle_jsp_text[53]);
            {
              org.apache.struts.taglib.html.SelectTag __jsp_taghandler_24=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag property");
              __jsp_taghandler_24.setParent(__jsp_taghandler_1);
              __jsp_taghandler_24.setProperty("templateLanguage");
              __jsp_tag_starteval=__jsp_taghandler_24.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_24,__jsp_tag_starteval,out);
                do {
                  out.write(__oracle_jsp_text[54]);
                  {
                    org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_25=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                    __jsp_taghandler_25.setParent(__jsp_taghandler_24);
                    __jsp_taghandler_25.setLabel("name");
                    __jsp_taghandler_25.setName("fecm005");
                    __jsp_taghandler_25.setProperty("templateLanguageValues");
                    __jsp_taghandler_25.setValue("code");
                    __jsp_tag_starteval=__jsp_taghandler_25.doStartTag();
                    if (__jsp_taghandler_25.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_25,3);
                  }
                  out.write(__oracle_jsp_text[55]);
                } while (__jsp_taghandler_24.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_24.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_24,2);
            }
            out.write(__oracle_jsp_text[56]);
          } while (__jsp_taghandler_1.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[57]);

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
  private static final char __oracle_jsp_text[][]=new char[58][];
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
    "/css/EZL.css\"/>\r\n    <!--meta http-equiv=\"X-UA-Compatible\" content=\"IE=EmulateIE7\"/--> \r\n    <STYLE TYPE=\"text/css\">\r\n         div.search_result{height:100px;}\r\n         table.table_results tbody{height:100px;}\r\n    </STYLE>\r\n    <!--[if IE]>\r\n        <style type=\"text/css\">\r\n            div.search_result {\r\n                position: relative;\r\n                height: 180px;\r\n                width: 100%;\r\n                overflow-y: scroll;\r\n                overflow-x: hidden;\r\n            }\r\n            table.table_results{width:99%}\r\n           \r\n            table.table_results thead tr {\r\n                position: absolute;width:100%;\r\n                top: expression(this.offsetParent.scrollTop);\r\n            }\r\n            table.table_results tbody {\r\n                height: auto;\r\n            }\r\n            /*table.table_results tbody tr td.first_row {\r\n                padding-top: 24px;}*/}\r\n             table.header{width:99%; }             \r\n        </style>\r\n    <![endif]-->   \r\n    \r\n\r\n<SCRIPT TYPE=\"text/javascript\" LANGUAGE=\"JavaScript\">\r\n\r\n    var lastNoticeTyp = '';\r\n    /*Called by framework on-load of this JSP*/\r\n    function onLoad() {\r\n        lastNoticeTyp = document.getElementById(\"noticeType\").value;\r\n        document.forms[0].templateLanguage.style.display = \"none\";\r\n        //document.getElementById('value[' + 0 + '].subject').setAttribute('class','non_edit');\r\n    }\r\n    \r\n    /*Called by Find Button*/\r\n    function onSearch() {\r\n        lastNoticeTyp ='';\r\n       var value = document.getElementById(\"noticeType\").value ;\r\n       if(value=='' || value.length ==0) {\r\n        showBarMessage(ECM_SE0012,ERROR_MSG);\r\n        return false;\r\n       }\r\n        //Clear the Data Table\r\n        clearDiv('search_result');\r\n        \r\n        //set the action\r\n        //document.forms[0].currPageNo.value= 1;\r\n        \r\n        /* Disable all controls */\r\n        disableOnSubmit();            \r\n    \r\n        document.forms[0].action='".toCharArray();
    __oracle_jsp_text[7] = 
    "';\r\n        \r\n        document.forms[0].submit();\r\n        return false;\r\n    }\r\n    \r\n    function updateRecordStatus(arow) {\r\n        var lobjStatus = document.getElementById('value[' + arow + '].status');\r\n      var lstrstatus = lobjStatus.value;\r\n      if(lstrstatus == '') {\r\n             lobjStatus.value = UPD;\r\n             //Set status to upd\r\n           \r\n          }\r\n    }\r\n    \r\n    function openVariableLookup(fieldType,aintIndex) {\r\n       var prmMasterId = document.getElementById(\"noticeType\").value;\r\n       \r\n       var variableValue = '';\r\n       if(fieldType == '1') {\r\n            fieldType='S';\r\n            document.getElementById(\"mselectedControl\").value = document.getElementById('value[' + aintIndex + '].subject').value;\r\n       } else if(fieldType == '2') {\r\n            fieldType = 'H';\r\n            document.getElementById(\"mselectedControl\").value = document.getElementById('value[' + aintIndex + '].bodyHeader').value; \r\n       } else if(fieldType == '3') {\r\n            fieldType = 'D';\r\n            document.getElementById(\"mselectedControl\").value = document.getElementById('value[' + aintIndex + '].bodyDetail').value;\r\n       } else if(fieldType == '4') {\r\n            fieldType = 'F';\r\n            document.getElementById(\"mselectedControl\").value = document.getElementById('value[' + aintIndex + '].bodyFooter').value; \r\n       }\r\n      \r\n       var urlStr = '".toCharArray();
    __oracle_jsp_text[8] = 
    "?prmMasterId='+prmMasterId+'&fieldType='+fieldType+'&rowId='+aintIndex;\r\n        window.open(urlStr,'secm006','height=600px','width=530px');\r\n        //openChildScreen(urlStr,'secm006');\r\n        return false;\r\n    }\r\n    \r\n    function getSelectedControl() {\r\n        return document.getElementById(\"mselectedControl\").value;\r\n    }\r\n    \r\n    function setLookupValues(arowId,afieldType,aVariables) {\r\n    \r\n        if(afieldType == 'S') {\r\n            document.getElementById('value[' + arowId + '].subject').value = aVariables;\r\n        }    else if(afieldType == 'H') {\r\n            document.getElementById('value[' + arowId + '].bodyHeader').value = aVariables;\r\n        } else if(afieldType == 'D') {\r\n            document.getElementById('value[' + arowId + '].bodyDetail').value = aVariables ;\r\n        } else if (afieldType == 'F') {\r\n            document.getElementById('value[' + arowId + '].bodyFooter').value = aVariables ;\r\n        }\r\n        if(document.getElementById('value[' + arowId + '].status').value == '') {\r\n            \r\n            document.getElementById('value[' + arowId + '].status').value = 'UPD';\r\n        }\r\n    }\r\n    \r\n    function onSave() {\r\n        resetSearchCriteria();\r\n        var tableResult = \"result_dtl\";\r\n        var pkArr       = [\"templateLanguage\"];\r\n        \r\n        var ctr =0;\r\n        var table     = document.getElementById(\"result_dtl\");\r\n        var totalRows = table.rows.length;\r\n        var rowIndex  = table.rows.length;\r\n        \r\n        var searchPerformed = document.getElementById(\"searchPerformed\").value ;\r\n        \r\n        /*\r\n        if(searchPerformed == 'false') {\r\n            showBarMessage(ECM_SE0007,ERROR_MSG);\r\n                        return;\r\n        }*/\r\n                if(totalRows == 0) {\r\n                    showBarMessage(ECM_GE0014,ERROR_MSG);\r\n                        return;\r\n                }\r\n                \r\n        for(ctr = 0 ; ctr<totalRows ;ctr++) {\r\n        \r\n            var value = document.getElementById('value[' + ctr + '].templateDesc').value;\r\n            if(value == '' || (trimString(value).length == 0)){\r\n                showBarMessage(ECM_SE0003,ERROR_MSG);\r\n                document.getElementById('value[' + ctr + '].templateDesc').focus();\r\n                return ;\r\n            }\r\n            \r\n            var subject = document.getElementById('value[' + ctr + '].subject').value;\r\n            if(subject == '' || (trimString(subject).length == 0)){\r\n                showBarMessage(ECM_SE0005,ERROR_MSG);\r\n                return ;\r\n            } else if(subject.length >1000) {\r\n                            showBarMessage(ECM_SE0013,ERROR_MSG);\r\n                return;\r\n                        }\r\n            var header = document.getElementById('value[' + ctr + '].bodyHeader').value;\r\n            var body   = document.getElementById('value[' + ctr + '].bodyDetail').value;\r\n            var footer = document.getElementById('value[' + ctr + '].bodyFooter').value;\r\n            if((header == '' || (trimString(header).length == 0)) && (body == '' || (trimString(body).length == 0))&&(footer == '' || (trimString(footer).length == 0))) {\r\n                            showBarMessage(ECM_SE0006,ERROR_MSG);\r\n                            return;\r\n            }\r\n                        \r\n                        if(header.length!=0 && header.length>4000) {\r\n                            showBarMessage(ECM_SE0014,ERROR_MSG);\r\n                            return;\r\n                        }\r\n                        if(body.length!=0 && body.length>4000) {\r\n                           showBarMessage(ECM_SE0015,ERROR_MSG);\r\n                            return;\r\n                        }\r\n                         if(footer.length!=0 && footer.length>4000) {\r\n                           showBarMessage(ECM_SE0016,ERROR_MSG);\r\n                            return;\r\n                        }\r\n        }\r\n\r\n        if(checkDuplicacyTable(tableResult,pkArr)) {\r\n            showBarMessage(ECM_SE0004,ERROR_MSG);\r\n            return;\r\n        }\r\n        \r\n           \r\n        \r\n        document.forms[0].action='".toCharArray();
    __oracle_jsp_text[9] = 
    "';\r\n        \r\n        document.forms[0].submit();\r\n        return false;\r\n    }    \r\n    \r\nfunction  addRow() {\r\n    resetSearchCriteria();\r\n    var table     = document.getElementById(\"result_dtl\");\r\n    var totalRows = table.rows.length;\r\n    var rowIndex  = table.rows.length;\r\n    var lstrLanguageCode = \"value[\"+rowIndex+\"].templateLanguage\";\r\n    var attachmentFlag = \"value[\"+rowIndex+\"].attachmentFlag\";\r\n    /*\r\n        if(totalRows == 0) {\r\n            showBarMessage(ECM_SE0007,ERROR_MSG);\r\n        }\r\n      */\r\n    if(document.getElementById(\"noticeType\").value == '' || document.getElementById(\"noticeType\").value.length == 0) {\r\n        showBarMessage(ECM_SE0007,ERROR_MSG);\r\n        return false;\r\n    }\r\n      \r\n    var statusValue = \"value[\"+rowIndex+\"].recordStatus\";\r\n    var row       = table.insertRow(totalRows);\r\n    row.setAttribute(\"id\", \"row\"+rowIndex);\r\n    row.setAttribute(\"height\", \"20px\");\r\n    \r\n    var cell1         = row.insertCell(0);\r\n    cell1.setAttribute(\"width\", \"15%\");\r\n    cell1.innerHTML   = \"<td >\"+\r\n                                                \"<input type='hidden' value='' name='value[\"+rowIndex+\"].templateId' >\"+\r\n                                                \"<input type='hidden' value='' name='value[\"+rowIndex+\"].updTime' >\"+\r\n                        \"<input type='hidden' value='ADD' name='value[\"+rowIndex+\"].status' >\"+\r\n                        \"<input type='text' value=''  style='width:90%' class='must'  name='value[\"+rowIndex+\"].templateDesc' maxlength='100'></td>\";\r\n \r\n    \r\n    var lobjLanguageCell;\r\n         lobjLanguageCell='<TD ><select name =' + lstrLanguageCode + ' style=\"width:95%\" size=\"1\" >';\r\n      \r\n         var lobjCombo = eval(document.forms[0].templateLanguage);\r\n            for(lintCtr=0;lintCtr<lobjCombo.length;lintCtr++) {\r\n               var lstrCellVal= document.forms[0].templateLanguage[lintCtr].value;\r\n               var lstrOpt= document.forms[0].templateLanguage[lintCtr].text;\r\n               lobjLanguageCell = lobjLanguageCell +'<option value=\"'+lstrCellVal+'\">'+lstrOpt+'</option>';\r\n            }\r\n         lobjLanguageCell=lobjLanguageCell+'</select></TD>';\r\n         \r\n         var cell2       = row.insertCell(1);\r\n         cell2.setAttribute(\"width\", \"13%\");\r\n         cell2.innerHTML = lobjLanguageCell;\r\n    \r\n    \r\n    var cell3 = row.insertCell(2);\r\n    cell3.setAttribute(\"width\", \"11%\");\r\n    cell3.innerHTML = \"<TD  class='whitebg'>\"+\r\n                            \"<textarea rows='1' cols='6'  value='' class='non_edit' readOnly='true'  name='value[\"+rowIndex+\"].subject' ></textarea>\"+\r\n                            \"&nbsp;&nbsp;<input type='button' value='. . .' name='btnBodyHeaderLookup' class='btnbutton' onclick='openVariableLookup(\"+1+\",\"+rowIndex+\")'/>\"+\r\n                        \"</TD>\";\r\n    var cell4 = row.insertCell(3);\r\n    cell4.setAttribute(\"width\", \"12%\");\r\n    cell4.innerHTML = \"<TD  class='whitebg'>\"+\r\n                            \"<textarea rows='1' cols='6' value=''  class='non_edit' readOnly='true' name='value[\"+rowIndex+\"].bodyHeader' ></textarea>\"+\r\n                            \"&nbsp;&nbsp;<input type='button' value='. . .' name='btnBodyHeaderLookup' class='btnbutton' onclick='openVariableLookup(\"+2+\",\"+rowIndex+\")'/>\"+\r\n                        \"</TD>\";\r\n    var cell5 = row.insertCell(4);\r\n    cell5.setAttribute(\"width\", \"12%\");\r\n    cell5.innerHTML = \"<TD  class='whitebg'>\"+\r\n                            \"<textarea rows='1' cols='6' value=''  class='non_edit' readOnly='true' name='value[\"+rowIndex+\"].bodyDetail' ></textarea>\"+\r\n                            \"&nbsp;&nbsp;<input type='button' value='. . .' name='btnBodyHeaderLookup' class='btnbutton' onclick='openVariableLookup(\"+3+\",\"+rowIndex+\")'/>\"+\r\n                        \"</TD>\";\r\n    var cell6 = row.insertCell(5);\r\n    cell6.setAttribute(\"width\", \"12%\");\r\n    cell6.innerHTML = \"<TD  class='whitebg'>\"+\r\n                            \"<textarea rows='1' cols='6' value=''  class='non_edit' readOnly='true' name='value[\"+rowIndex+\"].bodyFooter' ></textarea>\"+\r\n                            \"&nbsp;&nbsp;<input type='button' value='. . .' name='btnBodyHeaderLookup' class='btnbutton' onclick='openVariableLookup(\"+4+\",\"+rowIndex+\")'/>\"+\r\n                        \"</TD>\";\r\n    var flagCell  = '<td  class=\"whitebg\"><select name = ' +attachmentFlag + ' style=\"width:95%;height:20px\" size=\"1\" class=\"must\" >';\r\n    flagCell=  flagCell + '<option value=\"Y\">Yes </option>'\r\n                        + '<option value=\"N\">No</option>';\r\n    flagCell = flagCell + '</select></td>';\r\n    var cell7 = row.insertCell(6);\r\n    cell7.setAttribute(\"width\", \"12%\");\r\n    cell7.innerHTML = flagCell;\r\n    \r\n    var statusCell  = '<td  class=\"whitebg\"><select name = ' +statusValue + ' size=\"1\" style=\"width:95%;height:20px\" class=\"must\" >';\r\n    statusCell=  statusCell + '<option value=\"A\">Active </option>'\r\n                            + '<option value=\"S\">Suspended</option>';\r\n    statusCell = statusCell + '</select></td>';\r\n    var cell8 = row.insertCell(7);\r\n    cell8.setAttribute(\"width\", \"8%\");\r\n    cell8.innerHTML = statusCell;\r\n    \r\n    var previewCell = \"<TD><input type='button' value='. . .' name='btnBodyHeaderLookup' class='btnbutton' onclick='openPreview(\"+rowIndex+\")'/><TD>\";\r\n    var cell9 = row.insertCell(8);\r\n    cell9.className = \"center\";\r\n    cell9.innerHTML = previewCell;\r\n    \r\n    return false;\r\n        \r\n    }\r\n    \r\n    /*To reset theoriginal search criteria before processing*/\r\n    function resetSearchCriteria() {\r\n        document.getElementById(\"noticeType\").value = lastNoticeTyp;\r\n    }\r\n\r\n    function openHelp() {\r\n        \r\n        var strFileName = '1';\r\n        var strUrl = \"/RCLWebApp/help/ApplicationHelp.htm#\"+strFileName;\r\n        var objWindow = window.open(strUrl,\"Help\",\"width=900,height=600,status=no,resizable=no,top=150,left=150\");\r\n        objWindow.focus();\r\n    }    \r\n    \r\n    function openPreview(aintIndex) {\r\n        document.getElementById(\"mselectedSubject\").value = document.getElementById('value[' + aintIndex + '].subject').value;\r\n        document.getElementById(\"mselectedHeader\").value = document.getElementById('value[' + aintIndex + '].bodyHeader').value;\r\n        document.getElementById(\"mselectedDetail\").value = document.getElementById('value[' + aintIndex + '].bodyDetail').value;\r\n        document.getElementById(\"mselectedFooter\").value = document.getElementById('value[' + aintIndex + '].bodyFooter').value;\r\n        \r\n        var urlStr = '".toCharArray();
    __oracle_jsp_text[10] = 
    "';\r\n        //window.open(urlStr,'secm009','height=600px','width=1500px');\r\n        window.open(urlStr,'secm009');\r\n    }\r\n    \r\n    function getControlsForPreview() {\r\n        var subject = document.getElementById(\"mselectedSubject\").value ;\r\n        var body    = document.getElementById(\"mselectedHeader\").value + \"\\n\" +  document.getElementById(\"mselectedDetail\").value + \"\\n\" + document.getElementById(\"mselectedFooter\").value;\r\n        \r\n        return (subject + \"~\" + body) ;\r\n    }\r\n    \r\n</SCRIPT>\r\n</HEAD>\r\n<BODY onload='javascript:onLoad()' onunload=\"javascript:doCloseAllChilds()\">\r\n\r\n".toCharArray();
    __oracle_jsp_text[11] = 
    "\r\n<input type=\"hidden\" name=\"mselectedControl\" />\r\n<input type=\"hidden\" name=\"mselectedSubject\" />\r\n<input type=\"hidden\" name=\"mselectedHeader\" />\r\n<input type=\"hidden\" name=\"mselectedDetail\" />\r\n<input type=\"hidden\" name=\"mselectedFooter\" />   \r\n".toCharArray();
    __oracle_jsp_text[12] = 
    " \r\n    ".toCharArray();
    __oracle_jsp_text[13] = 
    "\r\n    <div class=\"text_header\"><h2>E-Notice Template</h2></div>\r\n    <TABLE CLASS=\"table_search\" BORDER=\"0\" WIDTH=\"100%\" CELLSPACING=\"0\" CELLPADDING=\"0\">\r\n        <TR>\r\n            <TD width=\"80px\">Notice Type</TD>\r\n            <TD width=\"250px\" CLASS=\"whitebg\">\r\n                ".toCharArray();
    __oracle_jsp_text[14] = 
    "\r\n                    ".toCharArray();
    __oracle_jsp_text[15] = 
    "\r\n                ".toCharArray();
    __oracle_jsp_text[16] = 
    "    \r\n            </TD>\r\n            <TD>\r\n            </TD>\r\n            </TD>\r\n            \r\n        </TR>\r\n    \r\n        \r\n    </TABLE>\r\n    ".toCharArray();
    __oracle_jsp_text[17] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[18] = 
    "    \r\n    <DIV CLASS=\"buttons_box\">\r\n        <INPUT TYPE=\"button\" VALUE=\"Find\" NAME=\"btnFind\" CLASS=\"event_btnbutton\" ONCLICK='return onSearch()'/>\r\n        \r\n    </DIV>\r\n    ".toCharArray();
    __oracle_jsp_text[19] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[20] = 
    "    \r\n    <DIV CLASS=\"text_header\"><H2>Search Results</H2></DIV>   \r\n        <TABLE ID=\"result_hdr\" class=\"header\" BORDER=\"0\" CELLPADDING=\"0\" CELLSPACING=\"0\" WIDTH=\"100%\">\r\n            <THEAD>\r\n                <TR>\r\n                    <TH STYLE=\"WIDTH:15%;HEIGHT:20px;\" class=\"center\">Template Description</TH>\r\n                    <TH  STYLE=\"WIDTH:13%\">Template Language</TH>\r\n                    <TH STYLE=\"WIDTH:11%\">Subject</TH>\r\n                    <TH STYLE=\"WIDTH:12%\">Body Header</TH>\r\n                    <TH STYLE=\"WIDTH:12%\">Body Detail</TH>\r\n                    <TH STYLE=\"WIDTH:12%\">Body Footer</TH>\r\n                    <TH STYLE=\"WIDTH:12%\">Attachment Flag</TH>\r\n                    <TH STYLE=\"WIDTH:8%\">Record Status</TH>\r\n                    <TH >Preview</TH>\r\n                </TR>            \r\n            </THEAD>\r\n        </TABLE>   \r\n        \r\n        <DIV ID=\"search_result\" CLASS=\"search_result\" STYLE=\"HEIGHT:325px;WIDTH:100%\">\r\n        \r\n        <TABLE ID=\"result_dtl\" CLASS=\"table_results\"  BORDER=\"0\" CELLPADDING=\"0\" CELLSPACING=\"0\" >\r\n      \r\n            <TBODY>\r\n            \r\n                ".toCharArray();
    __oracle_jsp_text[21] = 
    "\r\n                    <TR >\r\n                        <TD width=\"15%\" class=\"left\">\r\n                                                    ".toCharArray();
    __oracle_jsp_text[22] = 
    "\r\n                                                </TD>\r\n                        <TD width=\"13%\">\r\n                            ".toCharArray();
    __oracle_jsp_text[23] = 
    "\r\n                                ".toCharArray();
    __oracle_jsp_text[24] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[25] = 
    "\r\n                        </TD>\r\n                        <TD width=\"11%\" >\r\n                            ".toCharArray();
    __oracle_jsp_text[26] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[27] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[28] = 
    "\r\n                            <input type=\"button\" value=\". . .\" name=\"btnLevelKeyLookup\" class=\"btnbutton\" onclick='".toCharArray();
    __oracle_jsp_text[29] = 
    "'/>\r\n                        </TD>\r\n                        <TD  width=\"12%\">\r\n                            \r\n                            ".toCharArray();
    __oracle_jsp_text[30] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[31] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[32] = 
    "\r\n                                                        <input type=\"button\" value=\". . .\" name=\"btnBodyHeaderLookup\" class=\"btnbutton\" onclick='".toCharArray();
    __oracle_jsp_text[33] = 
    "'/>\r\n                        </TD>\r\n                        <TD width=\"12%\">\r\n                            \r\n                            ".toCharArray();
    __oracle_jsp_text[34] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[35] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[36] = 
    "\r\n                                                        <input type=\"button\" value=\". . .\" name=\"btnBodyDetailLookup\" class=\"btnbutton\" onclick='".toCharArray();
    __oracle_jsp_text[37] = 
    "'/>\r\n                        </TD>\r\n                        <TD width=\"12%\">\r\n                            \r\n                            ".toCharArray();
    __oracle_jsp_text[38] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[39] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[40] = 
    "\r\n                                                        <input type=\"button\" value=\". . .\" name=\"btnBodyFooterLookup\" class=\"btnbutton\" onclick='".toCharArray();
    __oracle_jsp_text[41] = 
    "'/>\r\n                        </TD>\r\n                        <TD width=\"12%\">\r\n                                                \r\n                            ".toCharArray();
    __oracle_jsp_text[42] = 
    "\r\n                                ".toCharArray();
    __oracle_jsp_text[43] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[44] = 
    "\r\n                        </TD>\r\n                        <TD WIDTH=\"8%\">\r\n                            ".toCharArray();
    __oracle_jsp_text[45] = 
    "\r\n                                ".toCharArray();
    __oracle_jsp_text[46] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[47] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[48] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[49] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[50] = 
    "\r\n                        </TD>\r\n                        <TD class=\"center\"><input type=\"button\" value=\". . .\" name=\"btnLevelKeyLookup\" class=\"btnbutton\" onclick='".toCharArray();
    __oracle_jsp_text[51] = 
    "'/>\r\n                        </TD>\r\n                    </TR>\r\n                ".toCharArray();
    __oracle_jsp_text[52] = 
    "\r\n                \r\n            </TBODY>\r\n        </TABLE>\r\n        </DIV>\r\n ".toCharArray();
    __oracle_jsp_text[53] = 
    "\r\n  <div class=\"buttons_box\">\r\n       <input type=\"button\" value=\"Add\" name=\"btnAdd\" class=\"event_btnbutton\" onclick='return addRow()'/>\r\n        ".toCharArray();
    __oracle_jsp_text[54] = 
    "\r\n                ".toCharArray();
    __oracle_jsp_text[55] = 
    "\r\n            ".toCharArray();
    __oracle_jsp_text[56] = 
    "\r\n    </div>\r\n \r\n <br>\r\n \r\n  \r\n".toCharArray();
    __oracle_jsp_text[57] = 
    "\r\n</BODY>\r\n</HTML>\r\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
