package _pages._ecm;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;


public class _EcmDeclareDischargeListOutboundScn extends com.orionserver.http.OrionHttpJspPage {


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
    _EcmDeclareDischargeListOutboundScn page = this;
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
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/secm003generate", pageContext));
      out.write(__oracle_jsp_text[7]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/secm003download", pageContext));
      out.write(__oracle_jsp_text[8]);
      {
        org.apache.struts.taglib.html.FormTag __jsp_taghandler_1=(org.apache.struts.taglib.html.FormTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.FormTag.class,"org.apache.struts.taglib.html.FormTag action method");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setAction("/secm003");
        __jsp_taghandler_1.setMethod("POST");
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[9]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_2=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
              __jsp_taghandler_2.setParent(__jsp_taghandler_1);
              __jsp_taghandler_2.setName("fecm003");
              __jsp_taghandler_2.setProperty("mode");
              __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
              if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,2);
            }
            out.write(__oracle_jsp_text[10]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_3=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
              __jsp_taghandler_3.setParent(__jsp_taghandler_1);
              __jsp_taghandler_3.setName("fecm003");
              __jsp_taghandler_3.setProperty("listId");
              __jsp_tag_starteval=__jsp_taghandler_3.doStartTag();
              if (__jsp_taghandler_3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_3,2);
            }
            out.write(__oracle_jsp_text[11]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_4=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
              __jsp_taghandler_4.setParent(__jsp_taghandler_1);
              __jsp_taghandler_4.setName("fecm003");
              __jsp_taghandler_4.setProperty("terminal");
              __jsp_tag_starteval=__jsp_taghandler_4.doStartTag();
              if (__jsp_taghandler_4.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_4,2);
            }
            out.write(__oracle_jsp_text[12]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_5=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
              __jsp_taghandler_5.setParent(__jsp_taghandler_1);
              __jsp_taghandler_5.setName("fecm003");
              __jsp_taghandler_5.setProperty("emeUid");
              __jsp_tag_starteval=__jsp_taghandler_5.doStartTag();
              if (__jsp_taghandler_5.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_5,2);
            }
            out.write(__oracle_jsp_text[13]);
            {
              org.apache.struts.taglib.html.RadioTag __jsp_taghandler_6=(org.apache.struts.taglib.html.RadioTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.RadioTag.class,"org.apache.struts.taglib.html.RadioTag name onclick property styleClass value");
              __jsp_taghandler_6.setParent(__jsp_taghandler_1);
              __jsp_taghandler_6.setName("fecm003");
              __jsp_taghandler_6.setOnclick("onRadioEdi()");
              __jsp_taghandler_6.setProperty("radioGroupExprtBy");
              __jsp_taghandler_6.setStyleClass("check");
              __jsp_taghandler_6.setValue("edi");
              __jsp_tag_starteval=__jsp_taghandler_6.doStartTag();
              if (__jsp_taghandler_6.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_6,2);
            }
            out.write(__oracle_jsp_text[14]);
            {
              org.apache.struts.taglib.html.SelectTag __jsp_taghandler_7=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name property style");
              __jsp_taghandler_7.setParent(__jsp_taghandler_1);
              __jsp_taghandler_7.setName("fecm003");
              __jsp_taghandler_7.setProperty("ediList");
              __jsp_taghandler_7.setStyle("width:182px;");
              __jsp_tag_starteval=__jsp_taghandler_7.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_7,__jsp_tag_starteval,out);
                do {
                  out.write(__oracle_jsp_text[15]);
                  {
                    org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_8=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                    __jsp_taghandler_8.setParent(__jsp_taghandler_7);
                    __jsp_taghandler_8.setLabel("name");
                    __jsp_taghandler_8.setName("fecm003");
                    __jsp_taghandler_8.setProperty("ediListValues");
                    __jsp_taghandler_8.setValue("code");
                    __jsp_tag_starteval=__jsp_taghandler_8.doStartTag();
                    if (__jsp_taghandler_8.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_8,3);
                  }
                  out.write(__oracle_jsp_text[16]);
                } while (__jsp_taghandler_7.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_7.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_7,2);
            }
            out.write(__oracle_jsp_text[17]);
            {
              org.apache.struts.taglib.html.RadioTag __jsp_taghandler_9=(org.apache.struts.taglib.html.RadioTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.RadioTag.class,"org.apache.struts.taglib.html.RadioTag name onclick property styleClass value");
              __jsp_taghandler_9.setParent(__jsp_taghandler_1);
              __jsp_taghandler_9.setName("fecm003");
              __jsp_taghandler_9.setOnclick("onRadioExcel()");
              __jsp_taghandler_9.setProperty("radioGroupExprtBy");
              __jsp_taghandler_9.setStyleClass("check");
              __jsp_taghandler_9.setValue("excel");
              __jsp_tag_starteval=__jsp_taghandler_9.doStartTag();
              if (__jsp_taghandler_9.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_9,2);
            }
            out.write(__oracle_jsp_text[18]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_10=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property readonly style styleClass");
              __jsp_taghandler_10.setParent(__jsp_taghandler_1);
              __jsp_taghandler_10.setMaxlength("4");
              __jsp_taghandler_10.setName("fecm003");
              __jsp_taghandler_10.setOnblur("changeUpper(this)");
              __jsp_taghandler_10.setProperty("terminal");
              __jsp_taghandler_10.setReadonly(true);
              __jsp_taghandler_10.setStyle("width:226px");
              __jsp_taghandler_10.setStyleClass("non_edit");
              __jsp_tag_starteval=__jsp_taghandler_10.doStartTag();
              if (__jsp_taghandler_10.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_10,2);
            }
            out.write(__oracle_jsp_text[19]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_11=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property readonly style styleClass");
              __jsp_taghandler_11.setParent(__jsp_taghandler_1);
              __jsp_taghandler_11.setMaxlength("4");
              __jsp_taghandler_11.setName("fecm003");
              __jsp_taghandler_11.setOnblur("changeUpper(this)");
              __jsp_taghandler_11.setProperty("messageRecepiant");
              __jsp_taghandler_11.setReadonly(true);
              __jsp_taghandler_11.setStyle("width:250px");
              __jsp_taghandler_11.setStyleClass("non_edit");
              __jsp_tag_starteval=__jsp_taghandler_11.doStartTag();
              if (__jsp_taghandler_11.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_11,2);
            }
            out.write(__oracle_jsp_text[20]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_12=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property readonly style styleClass");
              __jsp_taghandler_12.setParent(__jsp_taghandler_1);
              __jsp_taghandler_12.setMaxlength("4");
              __jsp_taghandler_12.setName("fecm003");
              __jsp_taghandler_12.setOnblur("changeUpper(this)");
              __jsp_taghandler_12.setProperty("messageSet");
              __jsp_taghandler_12.setReadonly(true);
              __jsp_taghandler_12.setStyle("width:250px");
              __jsp_taghandler_12.setStyleClass("non_edit");
              __jsp_tag_starteval=__jsp_taghandler_12.doStartTag();
              if (__jsp_taghandler_12.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_12,2);
            }
            out.write(__oracle_jsp_text[21]);
            {
              org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_13=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name property value");
              __jsp_taghandler_13.setParent(__jsp_taghandler_1);
              __jsp_taghandler_13.setName("fecm003");
              __jsp_taghandler_13.setProperty("mode");
              __jsp_taghandler_13.setValue("D");
              __jsp_tag_starteval=__jsp_taghandler_13.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[22]);
                  {
                    org.apache.struts.taglib.html.RadioTag __jsp_taghandler_14=(org.apache.struts.taglib.html.RadioTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.RadioTag.class,"org.apache.struts.taglib.html.RadioTag name onclick property styleClass value");
                    __jsp_taghandler_14.setParent(__jsp_taghandler_13);
                    __jsp_taghandler_14.setName("fecm003");
                    __jsp_taghandler_14.setOnclick("clearSpecificPortValue()");
                    __jsp_taghandler_14.setProperty("radioGroupPortOfLoading");
                    __jsp_taghandler_14.setStyleClass("check");
                    __jsp_taghandler_14.setValue("A");
                    __jsp_tag_starteval=__jsp_taghandler_14.doStartTag();
                    if (__jsp_taghandler_14.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_14,3);
                  }
                  out.write(__oracle_jsp_text[23]);
                  {
                    org.apache.struts.taglib.html.RadioTag __jsp_taghandler_15=(org.apache.struts.taglib.html.RadioTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.RadioTag.class,"org.apache.struts.taglib.html.RadioTag name property styleClass value");
                    __jsp_taghandler_15.setParent(__jsp_taghandler_13);
                    __jsp_taghandler_15.setName("fecm003");
                    __jsp_taghandler_15.setProperty("radioGroupPortOfLoading");
                    __jsp_taghandler_15.setStyleClass("check");
                    __jsp_taghandler_15.setValue("S");
                    __jsp_tag_starteval=__jsp_taghandler_15.doStartTag();
                    if (__jsp_taghandler_15.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_15,3);
                  }
                  out.write(__oracle_jsp_text[24]);
                  {
                    org.apache.struts.taglib.html.TextTag __jsp_taghandler_16=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property style");
                    __jsp_taghandler_16.setParent(__jsp_taghandler_13);
                    __jsp_taghandler_16.setMaxlength("5");
                    __jsp_taghandler_16.setName("fecm003");
                    __jsp_taghandler_16.setOnblur("changeUpper(this)");
                    __jsp_taghandler_16.setProperty("portOfLoadig");
                    __jsp_taghandler_16.setStyle("width:104px");
                    __jsp_tag_starteval=__jsp_taghandler_16.doStartTag();
                    if (__jsp_taghandler_16.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_16,3);
                  }
                  out.write(__oracle_jsp_text[25]);
                } while (__jsp_taghandler_13.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_13.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_13,2);
            }
            out.write(__oracle_jsp_text[26]);
            {
              org.apache.struts.taglib.logic.NotEqualTag __jsp_taghandler_17=(org.apache.struts.taglib.logic.NotEqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEqualTag.class,"org.apache.struts.taglib.logic.NotEqualTag name property value");
              __jsp_taghandler_17.setParent(__jsp_taghandler_1);
              __jsp_taghandler_17.setName("fecm003");
              __jsp_taghandler_17.setProperty("mode");
              __jsp_taghandler_17.setValue("D");
              __jsp_tag_starteval=__jsp_taghandler_17.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[27]);
                  {
                    org.apache.struts.taglib.html.RadioTag __jsp_taghandler_18=(org.apache.struts.taglib.html.RadioTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.RadioTag.class,"org.apache.struts.taglib.html.RadioTag name onclick property styleClass value");
                    __jsp_taghandler_18.setParent(__jsp_taghandler_17);
                    __jsp_taghandler_18.setName("fecm003");
                    __jsp_taghandler_18.setOnclick("clearSpecificPortValue()");
                    __jsp_taghandler_18.setProperty("radioGroupPortOfLoading");
                    __jsp_taghandler_18.setStyleClass("check");
                    __jsp_taghandler_18.setValue("A");
                    __jsp_tag_starteval=__jsp_taghandler_18.doStartTag();
                    if (__jsp_taghandler_18.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_18,3);
                  }
                  out.write(__oracle_jsp_text[28]);
                  {
                    org.apache.struts.taglib.html.RadioTag __jsp_taghandler_19=(org.apache.struts.taglib.html.RadioTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.RadioTag.class,"org.apache.struts.taglib.html.RadioTag name property styleClass value");
                    __jsp_taghandler_19.setParent(__jsp_taghandler_17);
                    __jsp_taghandler_19.setName("fecm003");
                    __jsp_taghandler_19.setProperty("radioGroupPortOfLoading");
                    __jsp_taghandler_19.setStyleClass("check");
                    __jsp_taghandler_19.setValue("S");
                    __jsp_tag_starteval=__jsp_taghandler_19.doStartTag();
                    if (__jsp_taghandler_19.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_19,3);
                  }
                  out.write(__oracle_jsp_text[29]);
                  {
                    org.apache.struts.taglib.html.TextTag __jsp_taghandler_20=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property style");
                    __jsp_taghandler_20.setParent(__jsp_taghandler_17);
                    __jsp_taghandler_20.setMaxlength("5");
                    __jsp_taghandler_20.setName("fecm003");
                    __jsp_taghandler_20.setOnblur("changeUpper(this)");
                    __jsp_taghandler_20.setProperty("portOfLoadig");
                    __jsp_taghandler_20.setStyle("width:104px");
                    __jsp_tag_starteval=__jsp_taghandler_20.doStartTag();
                    if (__jsp_taghandler_20.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_20,3);
                  }
                  out.write(__oracle_jsp_text[30]);
                } while (__jsp_taghandler_17.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_17.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_17,2);
            }
            out.write(__oracle_jsp_text[31]);
            {
              org.apache.struts.taglib.html.RadioTag __jsp_taghandler_21=(org.apache.struts.taglib.html.RadioTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.RadioTag.class,"org.apache.struts.taglib.html.RadioTag name property styleClass value");
              __jsp_taghandler_21.setParent(__jsp_taghandler_1);
              __jsp_taghandler_21.setName("fecm003");
              __jsp_taghandler_21.setProperty("radioGroupFlatRacks");
              __jsp_taghandler_21.setStyleClass("check");
              __jsp_taghandler_21.setValue("Y");
              __jsp_tag_starteval=__jsp_taghandler_21.doStartTag();
              if (__jsp_taghandler_21.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_21,2);
            }
            out.write(__oracle_jsp_text[32]);
            {
              org.apache.struts.taglib.html.RadioTag __jsp_taghandler_22=(org.apache.struts.taglib.html.RadioTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.RadioTag.class,"org.apache.struts.taglib.html.RadioTag name property styleClass value");
              __jsp_taghandler_22.setParent(__jsp_taghandler_1);
              __jsp_taghandler_22.setName("fecm003");
              __jsp_taghandler_22.setProperty("radioGroupFlatRacks");
              __jsp_taghandler_22.setStyleClass("check");
              __jsp_taghandler_22.setValue("N");
              __jsp_tag_starteval=__jsp_taghandler_22.doStartTag();
              if (__jsp_taghandler_22.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_22,2);
            }
            out.write(__oracle_jsp_text[33]);
            {
              org.apache.struts.taglib.html.RadioTag __jsp_taghandler_23=(org.apache.struts.taglib.html.RadioTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.RadioTag.class,"org.apache.struts.taglib.html.RadioTag name property styleClass value");
              __jsp_taghandler_23.setParent(__jsp_taghandler_1);
              __jsp_taghandler_23.setName("fecm003");
              __jsp_taghandler_23.setProperty("radioGroupFumigationDG");
              __jsp_taghandler_23.setStyleClass("check");
              __jsp_taghandler_23.setValue("Y");
              __jsp_tag_starteval=__jsp_taghandler_23.doStartTag();
              if (__jsp_taghandler_23.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_23,2);
            }
            out.write(__oracle_jsp_text[34]);
            {
              org.apache.struts.taglib.html.RadioTag __jsp_taghandler_24=(org.apache.struts.taglib.html.RadioTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.RadioTag.class,"org.apache.struts.taglib.html.RadioTag name property styleClass value");
              __jsp_taghandler_24.setParent(__jsp_taghandler_1);
              __jsp_taghandler_24.setName("fecm003");
              __jsp_taghandler_24.setProperty("radioGroupFumigationDG");
              __jsp_taghandler_24.setStyleClass("check");
              __jsp_taghandler_24.setValue("N");
              __jsp_tag_starteval=__jsp_taghandler_24.doStartTag();
              if (__jsp_taghandler_24.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_24,2);
            }
            out.write(__oracle_jsp_text[35]);
            {
              org.apache.struts.taglib.html.SelectTag __jsp_taghandler_25=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name property style");
              __jsp_taghandler_25.setParent(__jsp_taghandler_1);
              __jsp_taghandler_25.setName("fecm003");
              __jsp_taghandler_25.setProperty("containerOperFlag");
              __jsp_taghandler_25.setStyle("width:100px;");
              __jsp_tag_starteval=__jsp_taghandler_25.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_25,__jsp_tag_starteval,out);
                do {
                  out.write(__oracle_jsp_text[36]);
                  {
                    org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_26=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                    __jsp_taghandler_26.setParent(__jsp_taghandler_25);
                    __jsp_taghandler_26.setLabel("name");
                    __jsp_taghandler_26.setName("fecm003");
                    __jsp_taghandler_26.setProperty("llstOperSelect");
                    __jsp_taghandler_26.setValue("code");
                    __jsp_tag_starteval=__jsp_taghandler_26.doStartTag();
                    if (__jsp_taghandler_26.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_26,3);
                  }
                  out.write(__oracle_jsp_text[37]);
                } while (__jsp_taghandler_25.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_25.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_25,2);
            }
            out.write(__oracle_jsp_text[38]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_27=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property style");
              __jsp_taghandler_27.setParent(__jsp_taghandler_1);
              __jsp_taghandler_27.setMaxlength("250");
              __jsp_taghandler_27.setName("fecm003");
              __jsp_taghandler_27.setOnblur("changeUpper(this)");
              __jsp_taghandler_27.setProperty("containerOper");
              __jsp_taghandler_27.setStyle("width:250px");
              __jsp_tag_starteval=__jsp_taghandler_27.doStartTag();
              if (__jsp_taghandler_27.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_27,2);
            }
            out.write(__oracle_jsp_text[39]);
            {
              org.apache.struts.taglib.html.SelectTag __jsp_taghandler_28=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name property style");
              __jsp_taghandler_28.setParent(__jsp_taghandler_1);
              __jsp_taghandler_28.setName("fecm003");
              __jsp_taghandler_28.setProperty("slotOperFlag");
              __jsp_taghandler_28.setStyle("width:100px;");
              __jsp_tag_starteval=__jsp_taghandler_28.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_28,__jsp_tag_starteval,out);
                do {
                  out.write(__oracle_jsp_text[40]);
                  {
                    org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_29=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                    __jsp_taghandler_29.setParent(__jsp_taghandler_28);
                    __jsp_taghandler_29.setLabel("name");
                    __jsp_taghandler_29.setName("fecm003");
                    __jsp_taghandler_29.setProperty("llstOperSelect");
                    __jsp_taghandler_29.setValue("code");
                    __jsp_tag_starteval=__jsp_taghandler_29.doStartTag();
                    if (__jsp_taghandler_29.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_29,3);
                  }
                  out.write(__oracle_jsp_text[41]);
                } while (__jsp_taghandler_28.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_28.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_28,2);
            }
            out.write(__oracle_jsp_text[42]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_30=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property style");
              __jsp_taghandler_30.setParent(__jsp_taghandler_1);
              __jsp_taghandler_30.setMaxlength("250");
              __jsp_taghandler_30.setName("fecm003");
              __jsp_taghandler_30.setOnblur("changeUpper(this)");
              __jsp_taghandler_30.setProperty("slotOper");
              __jsp_taghandler_30.setStyle("width:250px");
              __jsp_tag_starteval=__jsp_taghandler_30.doStartTag();
              if (__jsp_taghandler_30.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_30,2);
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
    "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n<HTML xmlns=\"http://www.w3.org/1999/xhtml\">\r\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\r\n\r\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[4] = 
    "\r\n\r\n".toCharArray();
    __oracle_jsp_text[5] = 
    "\r\n\r\n<HEAD>\r\n\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\" />\r\n\r\n    <LINK REL=\"stylesheet\" HREF=\"".toCharArray();
    __oracle_jsp_text[6] = 
    "/css/EZL.css\"/>\r\n\r\n<SCRIPT language=\"javascript\" type=\"text/javascript\">\r\n\r\n    var FORM_ID         = 'fecm003';\r\n    var lastLookup ;\r\n    var radioVal = \"\";\r\n\r\n    function onLoad() {\r\n\r\n\r\n        if ((document.forms[0].radioGroupExprtBy[0].checked == false)\r\n            && (document.forms[0].radioGroupExprtBy[1].checked == false)) {\r\n            document.forms[0].radioGroupExprtBy[0].checked = true;\r\n        }\r\n\r\n        if ((document.forms[0].radioGroupPortOfLoading[0].checked == false)\r\n            && (document.forms[0].radioGroupPortOfLoading[1].checked == false)) {\r\n            document.forms[0].radioGroupPortOfLoading[0].checked = true;\r\n        }\r\n\r\n        if ((document.forms[0].radioGroupFlatRacks[0].checked == false)\r\n            && (document.forms[0].radioGroupFlatRacks[1].checked == false)) {\r\n            document.forms[0].radioGroupFlatRacks[0].checked = true;\r\n        }\r\n\r\n        if ((document.forms[0].radioGroupFumigationDG[0].checked == false)\r\n            && (document.forms[0].radioGroupFumigationDG[1].checked == false)) {\r\n            document.forms[0].radioGroupFumigationDG[0].checked = true;\r\n        }\r\n    }\r\n\r\n    function clearSpecificPortValue() {\r\n        document.getElementById(\"portOfLoadig\").value = \"\";\r\n    }\r\n\r\n    function onRadioExcel(){\r\n        radioVal = \"excel\";\r\n    }\r\n\r\n    function onRadioEdi(){\r\n        radioVal = \"edi\";\r\n    }\r\n\r\n    /* Call action method to generate list */\r\n    function onGenerate(){\r\n\r\n          //Check if Terminal is entered or not\r\n        if(!mandatoryCheckNoSpaces(document.getElementById(\"terminal\"))) {\r\n            showBarMessage(ELL_SE0002, ERROR_MSG);\r\n            document.getElementById(\"terminal\").focus();\r\n            return false;\r\n        }\r\n\r\n        /* Check if port of loading is not given */\r\n        if(document.forms[0].radioGroupPortOfLoading[1].checked) {\r\n            if(!mandatoryCheckNoSpaces(document.getElementById(\"portOfLoadig\"))) {\r\n                showBarMessage(ECM_SE0027, ERROR_MSG);\r\n                document.getElementById(\"portOfLoadig\").focus();\r\n                return false;\r\n            }\r\n        }\r\n        showBarMessage(ECM_GI0001);\r\n        if (document.forms[0].radioGroupExprtBy[0].checked == true) {\r\n            /* for EDI generate */\r\n            if(!mandatoryCheckNoSpaces(document.forms[0].messageRecepiant)) {\r\n                showBarMessage(ECM_SE0028, ERROR_MSG);\r\n                document.forms[0].messageRecepiant.focus();\r\n                return false;\r\n            }\r\n            //Message Set Mandatory Check\r\n            if(!mandatoryCheckNoSpaces(document.forms[0].messageSet)) {\r\n                showBarMessage(ECM_SE0029, ERROR_MSG);\r\n                document.forms[0].messageSet.focus();\r\n                return false;\r\n            }\r\n            /* Disable all controls */\r\n            disableOnSubmit();\r\n            document.forms[0].action='".toCharArray();
    __oracle_jsp_text[7] = 
    "';\r\n        } else {\r\n            /* for excel download */\r\n            document.forms[0].action='".toCharArray();
    __oracle_jsp_text[8] = 
    "';\r\n        }\r\n        document.forms[0].submit();\r\n        return false;\r\n    }\r\n\r\n    /* Opens Partner Terminal Lookup */\r\n    function openPartnerTerminalLookup(){\r\n        var rowId = FORM_ID;\r\n        var terminal = document.getElementById(\"terminal\").value;\r\n        lastLookup = 'ArrivalTerminal';\r\n        openLookup(FORM_ID, rowId, \"PARTNER_TERMINAL_DIS\", terminal);\r\n    }\r\n\r\n    /*Called by master lookup screens to return selected values*/\r\n    function setLookupValues(aFormName, aRowId,strMasterId, arrResultData){\r\n\r\n        if(arrResultData[0] == FAILURE){\r\n            return;\r\n        }\r\n\r\n        if(lastLookup ==\"ArrivalTerminal\"){\r\n            //set arrrival terminal code\r\n            document.forms[0].terminal.value = arrResultData[0];\r\n            document.forms[0].messageRecepiant.value = arrResultData[2];\r\n            document.forms[0].messageSet.value = arrResultData[4];\r\n            // document.forms[0].emeUid.value = arrResultData[12];\r\n            document.forms[0].emeUid.value = arrResultData[9];\r\n        }\r\n\r\n    }\r\n\r\n</SCRIPT>\r\n</HEAD>\r\n<BODY>\r\n".toCharArray();
    __oracle_jsp_text[9] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[10] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[11] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[12] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[13] = 
    "\r\n\r\n<div class=\"text_header\" width='100%' nowrap><h2>Declare Discharge Load List Outbound</h2></div>\r\n    <TABLE CLASS=\"table_search\" BORDER=\"0\" WIDTH=\"100%\" CELLSPACING=\"0\" CELLPADDING=\"0\">\r\n        <tr height = '15px'/>\r\n        <TR>\r\n            <TD width='150px'>Export Via</TD>\r\n            <TD width='70px'>\r\n                EDI ".toCharArray();
    __oracle_jsp_text[14] = 
    "\r\n            </TD>\r\n            <TD width='175px'>\r\n                ".toCharArray();
    __oracle_jsp_text[15] = 
    "\r\n                    ".toCharArray();
    __oracle_jsp_text[16] = 
    "\r\n                ".toCharArray();
    __oracle_jsp_text[17] = 
    "\r\n            </TD>\r\n            <td width='10px'>&nbsp;</td>\r\n            <TD>\r\n                Excel ".toCharArray();
    __oracle_jsp_text[18] = 
    "\r\n            </TD>\r\n        </TR>\r\n        <TR height = '25px'>\r\n            <TD>Terminal</TD>\r\n            <TD valign='center' colspan=\"4\">\r\n                ".toCharArray();
    __oracle_jsp_text[19] = 
    "\r\n                <input type=\"button\" value=\". . .\" name=\"btnContLookup\" class=\"btnbutton\" onclick='return openPartnerTerminalLookup();'/>\r\n            </TD>\r\n        </TR>\r\n        <TR height = '25px'>\r\n            <TD>Message Recipient</TD>\r\n            <TD colspan=\"4\">\r\n                ".toCharArray();
    __oracle_jsp_text[20] = 
    "\r\n            </td>\r\n        </TR>\r\n        <TR height = '25px'>\r\n            <TD>Message Set</TD>\r\n            <TD colspan=\"4\">\r\n                ".toCharArray();
    __oracle_jsp_text[21] = 
    "\r\n            </TD>\r\n        </TR>\r\n    </TABLE>\r\n    <TABLE CLASS=\"table_search\" BORDER=\"0\" WIDTH=\"100%\" CELLSPACING=\"0\" CELLPADDING=\"0\">\r\n        <TR>\r\n            ".toCharArray();
    __oracle_jsp_text[22] = 
    "\r\n                <TD width='150px'>All Port Of Loading</TD>\r\n                <TD width='120px'>\r\n                    ".toCharArray();
    __oracle_jsp_text[23] = 
    "\r\n                    Port Of Loading\r\n                </TD>\r\n                <TD>\r\n                    ".toCharArray();
    __oracle_jsp_text[24] = 
    "\r\n                    ".toCharArray();
    __oracle_jsp_text[25] = 
    "\r\n                </TD>\r\n            ".toCharArray();
    __oracle_jsp_text[26] = 
    "\r\n            ".toCharArray();
    __oracle_jsp_text[27] = 
    "\r\n                <TD  width='150px' >All Port Of Discharge</TD>\r\n\r\n\r\n                <TD width='120px'>\r\n                    ".toCharArray();
    __oracle_jsp_text[28] = 
    "\r\n                    Port Of Discharge\r\n                </TD>\r\n                <TD>\r\n                    ".toCharArray();
    __oracle_jsp_text[29] = 
    "\r\n                    ".toCharArray();
    __oracle_jsp_text[30] = 
    "\r\n                </TD>\r\n            ".toCharArray();
    __oracle_jsp_text[31] = 
    "\r\n\r\n        </TR>\r\n\r\n        <TR height = '25px'>\r\n            <TD width='150px'>With Bundled Flat Racks</TD>\r\n            <TD>\r\n                ".toCharArray();
    __oracle_jsp_text[32] = 
    "\r\n                Yes\r\n            </TD>\r\n\r\n            <TD>\r\n                ".toCharArray();
    __oracle_jsp_text[33] = 
    "\r\n                No\r\n            </TD>\r\n        </TR>\r\n        <TR height = '25px'>\r\n            <TD width='150px'>With Fumigation DG</TD>\r\n\r\n            <TD>\r\n                ".toCharArray();
    __oracle_jsp_text[34] = 
    "\r\n                Yes\r\n            </TD>\r\n\r\n            <TD>\r\n                ".toCharArray();
    __oracle_jsp_text[35] = 
    "\r\n                No\r\n            </TD>\r\n        </tr>\r\n\r\n        <TR height = '25px'>\r\n            <TD colspan=\"3\">\r\n                <table border ='0' WIDTH=\"100%\" CELLSPACING=\"0\" CELLPADDING=\"0\">\r\n                    <tr>\r\n                        <TD width = \"150px\">\r\n                            Container Operator\r\n                        </TD>\r\n                        <TD width = \"120px\">\r\n                            ".toCharArray();
    __oracle_jsp_text[36] = 
    "\r\n                                ".toCharArray();
    __oracle_jsp_text[37] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[38] = 
    "\r\n                        </TD>\r\n                        <td>\r\n                            ".toCharArray();
    __oracle_jsp_text[39] = 
    "\r\n                        </td>\r\n                    </tr>\r\n                    <tr>\r\n                        <TD>\r\n                            Slot Operator\r\n                        </TD>\r\n                        <TD>\r\n                            ".toCharArray();
    __oracle_jsp_text[40] = 
    "\r\n                                ".toCharArray();
    __oracle_jsp_text[41] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[42] = 
    "\r\n                        </TD>\r\n                        <td>\r\n                            ".toCharArray();
    __oracle_jsp_text[43] = 
    "\r\n                        </td>\r\n                    </tr>\r\n                </table>\r\n            </TD>\r\n        </tr>\r\n\r\n    </TABLE>\r\n\r\n    <div class=\"buttons_box\">\r\n        <input type=\"button\" value=\"Generate\" name=\"btnGenerate\" class=\"event_btnbutton\" onclick=\"onGenerate();\"/>\r\n    </div>\r\n\r\n".toCharArray();
    __oracle_jsp_text[44] = 
    "\r\n</BODY>\r\n</HTML>\r\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
