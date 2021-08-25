package _pages._ecm;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;


public class _EcmCreateArrivalBayPlanScn extends com.orionserver.http.OrionHttpJspPage {


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
    _EcmCreateArrivalBayPlanScn page = this;
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
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/secm011generate", pageContext));
      out.write(__oracle_jsp_text[7]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/secm011download", pageContext));
      out.write(__oracle_jsp_text[8]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/secm011back", pageContext));
      out.write(__oracle_jsp_text[9]);
      {
        org.apache.struts.taglib.html.FormTag __jsp_taghandler_1=(org.apache.struts.taglib.html.FormTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.FormTag.class,"org.apache.struts.taglib.html.FormTag action method");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setAction("/secm011");
        __jsp_taghandler_1.setMethod("POST");
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[10]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_2=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
              __jsp_taghandler_2.setParent(__jsp_taghandler_1);
              __jsp_taghandler_2.setName("fecm011");
              __jsp_taghandler_2.setProperty("flag");
              __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
              if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,2);
            }
            out.write(__oracle_jsp_text[11]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_3=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
              __jsp_taghandler_3.setParent(__jsp_taghandler_1);
              __jsp_taghandler_3.setName("fecm011");
              __jsp_taghandler_3.setProperty("tmp");
              __jsp_tag_starteval=__jsp_taghandler_3.doStartTag();
              if (__jsp_taghandler_3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_3,2);
            }
            out.write(__oracle_jsp_text[12]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_4=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
              __jsp_taghandler_4.setParent(__jsp_taghandler_1);
              __jsp_taghandler_4.setName("fecm011");
              __jsp_taghandler_4.setProperty("eta");
              __jsp_tag_starteval=__jsp_taghandler_4.doStartTag();
              if (__jsp_taghandler_4.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_4,2);
            }
            out.write(__oracle_jsp_text[13]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_5=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
              __jsp_taghandler_5.setParent(__jsp_taghandler_1);
              __jsp_taghandler_5.setName("fecm011");
              __jsp_taghandler_5.setProperty("etd");
              __jsp_tag_starteval=__jsp_taghandler_5.doStartTag();
              if (__jsp_taghandler_5.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_5,2);
            }
            out.write(__oracle_jsp_text[14]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_6=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
              __jsp_taghandler_6.setParent(__jsp_taghandler_1);
              __jsp_taghandler_6.setName("fecm011");
              __jsp_taghandler_6.setProperty("voyage");
              __jsp_tag_starteval=__jsp_taghandler_6.doStartTag();
              if (__jsp_taghandler_6.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_6,2);
            }
            out.write(__oracle_jsp_text[15]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_7=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
              __jsp_taghandler_7.setParent(__jsp_taghandler_1);
              __jsp_taghandler_7.setName("fecm011");
              __jsp_taghandler_7.setProperty("direction");
              __jsp_tag_starteval=__jsp_taghandler_7.doStartTag();
              if (__jsp_taghandler_7.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_7,2);
            }
            out.write(__oracle_jsp_text[16]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_8=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
              __jsp_taghandler_8.setParent(__jsp_taghandler_1);
              __jsp_taghandler_8.setName("fecm011");
              __jsp_taghandler_8.setProperty("emeUid");
              __jsp_tag_starteval=__jsp_taghandler_8.doStartTag();
              if (__jsp_taghandler_8.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_8,2);
            }
            out.write(__oracle_jsp_text[17]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_9=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
              __jsp_taghandler_9.setParent(__jsp_taghandler_1);
              __jsp_taghandler_9.setName("fecm011");
              __jsp_taghandler_9.setProperty("portSeq");
              __jsp_tag_starteval=__jsp_taghandler_9.doStartTag();
              if (__jsp_taghandler_9.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_9,2);
            }
            out.write(__oracle_jsp_text[18]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_10=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
              __jsp_taghandler_10.setParent(__jsp_taghandler_1);
              __jsp_taghandler_10.setName("fecm011");
              __jsp_taghandler_10.setProperty("screenName");
              __jsp_tag_starteval=__jsp_taghandler_10.doStartTag();
              if (__jsp_taghandler_10.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_10,2);
            }
            out.write(__oracle_jsp_text[19]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_11=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
              __jsp_taghandler_11.setParent(__jsp_taghandler_1);
              __jsp_taghandler_11.setName("fecm011");
              __jsp_taghandler_11.setProperty("lldlflag");
              __jsp_tag_starteval=__jsp_taghandler_11.doStartTag();
              if (__jsp_taghandler_11.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_11,2);
            }
            out.write(__oracle_jsp_text[20]);
            {
              org.apache.struts.taglib.html.RadioTag __jsp_taghandler_12=(org.apache.struts.taglib.html.RadioTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.RadioTag.class,"org.apache.struts.taglib.html.RadioTag name onclick property styleClass value");
              __jsp_taghandler_12.setParent(__jsp_taghandler_1);
              __jsp_taghandler_12.setName("fecm011");
              __jsp_taghandler_12.setOnclick("onRadioEdi();");
              __jsp_taghandler_12.setProperty("radioGroup");
              __jsp_taghandler_12.setStyleClass("check");
              __jsp_taghandler_12.setValue("edi");
              __jsp_tag_starteval=__jsp_taghandler_12.doStartTag();
              if (__jsp_taghandler_12.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_12,2);
            }
            out.write(__oracle_jsp_text[21]);
            {
              org.apache.struts.taglib.html.SelectTag __jsp_taghandler_13=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name property style");
              __jsp_taghandler_13.setParent(__jsp_taghandler_1);
              __jsp_taghandler_13.setName("fecm011");
              __jsp_taghandler_13.setProperty("ediList");
              __jsp_taghandler_13.setStyle("width:200px;");
              __jsp_tag_starteval=__jsp_taghandler_13.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_13,__jsp_tag_starteval,out);
                do {
                  out.write(__oracle_jsp_text[22]);
                  {
                    org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_14=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                    __jsp_taghandler_14.setParent(__jsp_taghandler_13);
                    __jsp_taghandler_14.setLabel("name");
                    __jsp_taghandler_14.setName("fecm011");
                    __jsp_taghandler_14.setProperty("ediListValues");
                    __jsp_taghandler_14.setValue("code");
                    __jsp_tag_starteval=__jsp_taghandler_14.doStartTag();
                    if (__jsp_taghandler_14.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_14,3);
                  }
                  out.write(__oracle_jsp_text[23]);
                } while (__jsp_taghandler_13.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_13.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_13,2);
            }
            out.write(__oracle_jsp_text[24]);
            {
              org.apache.struts.taglib.html.RadioTag __jsp_taghandler_15=(org.apache.struts.taglib.html.RadioTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.RadioTag.class,"org.apache.struts.taglib.html.RadioTag name onclick property styleClass value");
              __jsp_taghandler_15.setParent(__jsp_taghandler_1);
              __jsp_taghandler_15.setName("fecm011");
              __jsp_taghandler_15.setOnclick("onRadioExcel();");
              __jsp_taghandler_15.setProperty("radioGroup");
              __jsp_taghandler_15.setStyleClass("check");
              __jsp_taghandler_15.setValue("excel");
              __jsp_tag_starteval=__jsp_taghandler_15.doStartTag();
              if (__jsp_taghandler_15.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_15,2);
            }
            out.write(__oracle_jsp_text[25]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_16=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property readonly style styleClass");
              __jsp_taghandler_16.setParent(__jsp_taghandler_1);
              __jsp_taghandler_16.setMaxlength("4");
              __jsp_taghandler_16.setName("fecm011");
              __jsp_taghandler_16.setOnblur("changeUpper(this)");
              __jsp_taghandler_16.setProperty("arrivalTerminal");
              __jsp_taghandler_16.setReadonly(true);
              __jsp_taghandler_16.setStyle("width:226px");
              __jsp_taghandler_16.setStyleClass("non_edit");
              __jsp_tag_starteval=__jsp_taghandler_16.doStartTag();
              if (__jsp_taghandler_16.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_16,2);
            }
            out.write(__oracle_jsp_text[26]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_17=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property readonly style styleClass");
              __jsp_taghandler_17.setParent(__jsp_taghandler_1);
              __jsp_taghandler_17.setMaxlength("4");
              __jsp_taghandler_17.setName("fecm011");
              __jsp_taghandler_17.setOnblur("changeUpper(this)");
              __jsp_taghandler_17.setProperty("arrivalPort");
              __jsp_taghandler_17.setReadonly(true);
              __jsp_taghandler_17.setStyle("width:250px");
              __jsp_taghandler_17.setStyleClass("non_edit");
              __jsp_tag_starteval=__jsp_taghandler_17.doStartTag();
              if (__jsp_taghandler_17.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_17,2);
            }
            out.write(__oracle_jsp_text[27]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_18=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property readonly style styleClass");
              __jsp_taghandler_18.setParent(__jsp_taghandler_1);
              __jsp_taghandler_18.setMaxlength("4");
              __jsp_taghandler_18.setName("fecm011");
              __jsp_taghandler_18.setOnblur("changeUpper(this)");
              __jsp_taghandler_18.setProperty("messageRecepiant");
              __jsp_taghandler_18.setReadonly(true);
              __jsp_taghandler_18.setStyle("width:250px");
              __jsp_taghandler_18.setStyleClass("non_edit");
              __jsp_tag_starteval=__jsp_taghandler_18.doStartTag();
              if (__jsp_taghandler_18.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_18,2);
            }
            out.write(__oracle_jsp_text[28]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_19=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property readonly style styleClass");
              __jsp_taghandler_19.setParent(__jsp_taghandler_1);
              __jsp_taghandler_19.setMaxlength("5");
              __jsp_taghandler_19.setName("fecm011");
              __jsp_taghandler_19.setOnblur("changeUpper(this)");
              __jsp_taghandler_19.setProperty("messageSet");
              __jsp_taghandler_19.setReadonly(true);
              __jsp_taghandler_19.setStyle("width:250px");
              __jsp_taghandler_19.setStyleClass("non_edit");
              __jsp_tag_starteval=__jsp_taghandler_19.doStartTag();
              if (__jsp_taghandler_19.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_19,2);
            }
            out.write(__oracle_jsp_text[29]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_20=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property readonly style styleClass");
              __jsp_taghandler_20.setParent(__jsp_taghandler_1);
              __jsp_taghandler_20.setMaxlength("5");
              __jsp_taghandler_20.setName("fecm011");
              __jsp_taghandler_20.setOnblur("changeUpper(this)");
              __jsp_taghandler_20.setProperty("service");
              __jsp_taghandler_20.setReadonly(true);
              __jsp_taghandler_20.setStyle("width:250px");
              __jsp_taghandler_20.setStyleClass("non_edit");
              __jsp_tag_starteval=__jsp_taghandler_20.doStartTag();
              if (__jsp_taghandler_20.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_20,2);
            }
            out.write(__oracle_jsp_text[30]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_21=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property readonly style styleClass");
              __jsp_taghandler_21.setParent(__jsp_taghandler_1);
              __jsp_taghandler_21.setMaxlength("2");
              __jsp_taghandler_21.setName("fecm011");
              __jsp_taghandler_21.setOnblur("changeUpper(this)");
              __jsp_taghandler_21.setProperty("vessel");
              __jsp_taghandler_21.setReadonly(true);
              __jsp_taghandler_21.setStyle("width:250px");
              __jsp_taghandler_21.setStyleClass("non_edit");
              __jsp_tag_starteval=__jsp_taghandler_21.doStartTag();
              if (__jsp_taghandler_21.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_21,2);
            }
            out.write(__oracle_jsp_text[31]);
            {
              org.apache.struts.taglib.html.CheckboxTag __jsp_taghandler_22=(org.apache.struts.taglib.html.CheckboxTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.CheckboxTag.class,"org.apache.struts.taglib.html.CheckboxTag name property styleClass value");
              __jsp_taghandler_22.setParent(__jsp_taghandler_1);
              __jsp_taghandler_22.setName("fecm011");
              __jsp_taghandler_22.setProperty("robIncluded");
              __jsp_taghandler_22.setStyleClass("check");
              __jsp_taghandler_22.setValue("on");
              __jsp_tag_starteval=__jsp_taghandler_22.doStartTag();
              if (__jsp_taghandler_22.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_22,2);
            }
            out.write(__oracle_jsp_text[32]);
            out.write(__oracle_jsp_text[33]);
            {
              org.apache.struts.taglib.html.SelectTag __jsp_taghandler_23=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name property style");
              __jsp_taghandler_23.setParent(__jsp_taghandler_1);
              __jsp_taghandler_23.setName("fecm011");
              __jsp_taghandler_23.setProperty("containerOperFlag");
              __jsp_taghandler_23.setStyle("width:100px;");
              __jsp_tag_starteval=__jsp_taghandler_23.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_23,__jsp_tag_starteval,out);
                do {
                  out.write(__oracle_jsp_text[34]);
                  {
                    org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_24=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                    __jsp_taghandler_24.setParent(__jsp_taghandler_23);
                    __jsp_taghandler_24.setLabel("name");
                    __jsp_taghandler_24.setName("fecm011");
                    __jsp_taghandler_24.setProperty("llstOperSelect");
                    __jsp_taghandler_24.setValue("code");
                    __jsp_tag_starteval=__jsp_taghandler_24.doStartTag();
                    if (__jsp_taghandler_24.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_24,3);
                  }
                  out.write(__oracle_jsp_text[35]);
                } while (__jsp_taghandler_23.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_23.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_23,2);
            }
            out.write(__oracle_jsp_text[36]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_25=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property style");
              __jsp_taghandler_25.setParent(__jsp_taghandler_1);
              __jsp_taghandler_25.setMaxlength("250");
              __jsp_taghandler_25.setName("fecm011");
              __jsp_taghandler_25.setOnblur("changeUpper(this)");
              __jsp_taghandler_25.setProperty("containerOper");
              __jsp_taghandler_25.setStyle("width:250px");
              __jsp_tag_starteval=__jsp_taghandler_25.doStartTag();
              if (__jsp_taghandler_25.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_25,2);
            }
            out.write(__oracle_jsp_text[37]);
            {
              org.apache.struts.taglib.html.SelectTag __jsp_taghandler_26=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name property style");
              __jsp_taghandler_26.setParent(__jsp_taghandler_1);
              __jsp_taghandler_26.setName("fecm011");
              __jsp_taghandler_26.setProperty("slotOperFlag");
              __jsp_taghandler_26.setStyle("width:100px;");
              __jsp_tag_starteval=__jsp_taghandler_26.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_26,__jsp_tag_starteval,out);
                do {
                  out.write(__oracle_jsp_text[38]);
                  {
                    org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_27=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                    __jsp_taghandler_27.setParent(__jsp_taghandler_26);
                    __jsp_taghandler_27.setLabel("name");
                    __jsp_taghandler_27.setName("fecm011");
                    __jsp_taghandler_27.setProperty("llstOperSelect");
                    __jsp_taghandler_27.setValue("code");
                    __jsp_tag_starteval=__jsp_taghandler_27.doStartTag();
                    if (__jsp_taghandler_27.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_27,3);
                  }
                  out.write(__oracle_jsp_text[39]);
                } while (__jsp_taghandler_26.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_26.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_26,2);
            }
            out.write(__oracle_jsp_text[40]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_28=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property style");
              __jsp_taghandler_28.setParent(__jsp_taghandler_1);
              __jsp_taghandler_28.setMaxlength("250");
              __jsp_taghandler_28.setName("fecm011");
              __jsp_taghandler_28.setOnblur("changeUpper(this)");
              __jsp_taghandler_28.setProperty("slotOper");
              __jsp_taghandler_28.setStyle("width:250px");
              __jsp_tag_starteval=__jsp_taghandler_28.doStartTag();
              if (__jsp_taghandler_28.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_28,2);
            }
            out.write(__oracle_jsp_text[41]);
          } while (__jsp_taghandler_1.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[42]);

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
  private static final char __oracle_jsp_text[][]=new char[43][];
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
    "/css/EZL.css\"/>\r\n\r\n<SCRIPT language=\"javascript\" type=\"text/javascript\">\r\n\r\n    var PROG_ID          = 'SECM011';\r\n    var FORM_ID          = 'fecm011';\r\n    var lastLookup;\r\n    var radioVal         = \"\";\r\n\r\n    function onLoad() {\r\n        var tmp = document.getElementById(\"tmp\").value;\r\n        if ((tmp != null) && (tmp != '')) {\r\n            document.getElementById(\"arrivalTerminal\").value\r\n                = document.getElementById(\"tmp\").value;\r\n        }\r\n    }\r\n\r\n    function onRadioExcel(){\r\n        document.forms[0].radioGroup.value=\"excel\"\r\n        radioVal = \"excel\";\r\n    }\r\n\r\n    function onRadioEdi(){\r\n        document.forms[0].radioGroup.value=\"edi\"\r\n        radioVal = \"edi\";\r\n    }\r\n\r\n    function onGenerate(){\r\n\r\n        if (document.forms[0].radioGroup[0].checked == true) {\r\n            if(!mandatoryCheck(document.forms[0].ediList)) {\r\n                showBarMessage(ECM_GE0010, ERROR_MSG);\r\n                document.forms[0].ediList.focus();\r\n                return false;\r\n            }\r\n            //Message Receipient Mandatory Check\r\n            if(!mandatoryCheckNoSpaces(document.forms[0].messageRecepiant)) {\r\n                showBarMessage(ECM_SE0028, ERROR_MSG);\r\n                document.forms[0].messageRecepiant.focus();\r\n                return false;\r\n            }\r\n            //Message Set Mandatory Check\r\n            if(!mandatoryCheckNoSpaces(document.forms[0].messageSet)) {\r\n                showBarMessage(ECM_SE0029, ERROR_MSG);\r\n                document.forms[0].messageSet.focus();\r\n                return false;\r\n            }\r\n        }\r\n\r\n        /* Show ready message */\r\n        showBarMessage(ECM_GI0001);\r\n        document.forms[0].flag.value=\"generated\";\r\n        if (document.forms[0].radioGroup[0].checked == true) {\r\n            /* for EDI generate */\r\n            /* Disable all controls */\r\n            disableOnSubmit();\r\n            document.forms[0].action='".toCharArray();
    __oracle_jsp_text[7] = 
    "';\r\n        }else{\r\n            /* for excel download */\r\n            document.forms[0].flag.value=\"generated\";\r\n            document.forms[0].action='".toCharArray();
    __oracle_jsp_text[8] = 
    "';\r\n        }\r\n        document.forms[0].submit();\r\n        return false;\r\n    }\r\n\r\n    /* Opens Partner Terminal Lookup */\r\n    function openPartnerTerminalLookup(){\r\n        var rowId = FORM_ID;\r\n        var terminal = document.getElementById(\"arrivalTerminal\").value;\r\n        lastLookup = 'ArrivalTerminal';\r\n        openLookup(FORM_ID, rowId, \"PARTNER_TERMINAL\", terminal);\r\n    }\r\n\r\n    /*Called by master lookup screens to return selected values */\r\n    function setLookupValues(aFormName, aRowId,strMasterId, arrResultData){\r\n        if(arrResultData[0] == FAILURE){\r\n            return;\r\n        }\r\n        if(lastLookup ==\"ArrivalTerminal\"){\r\n            //set arrrival terminal code\r\n            document.forms[0].arrivalTerminal.value=arrResultData[0];\r\n            document.forms[0].messageRecepiant.value=arrResultData[2];\r\n            document.forms[0].messageSet.value = arrResultData[4];\r\n            document.forms[0].emeUid.value=arrResultData[9];\r\n        }\r\n    }\r\n\r\n    function onBack(){\r\n        document.forms[0].action = '".toCharArray();
    __oracle_jsp_text[9] = 
    "';\r\n        document.forms[0].submit();\r\n        return false;\r\n    }\r\n\r\n</SCRIPT>\r\n</HEAD>\r\n<BODY>\r\n".toCharArray();
    __oracle_jsp_text[10] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[11] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[12] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[13] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[14] = 
    "    \r\n".toCharArray();
    __oracle_jsp_text[15] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[16] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[17] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[18] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[19] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[20] = 
    " <!--  *1 -->\r\n\r\n<div class=\"text_header\"><h2>Create Arrival Bay Plan</h2></div>\r\n    <TABLE CLASS=\"table_search\" BORDER=\"0\" WIDTH=\"100%\" CELLSPACING=\"0\" CELLPADDING=\"0\">\r\n        <tr height = '10px'/>\r\n        <TR height = '20px'>\r\n            <TD width='150px'>Export Via</TD>\r\n            <!-- TD >EDI</TD -->\r\n            <TD width='50px'>\r\n                EDI ".toCharArray();
    __oracle_jsp_text[21] = 
    "\r\n            </TD>\r\n            <TD width='200px'>\r\n                ".toCharArray();
    __oracle_jsp_text[22] = 
    "\r\n                    ".toCharArray();
    __oracle_jsp_text[23] = 
    "\r\n                ".toCharArray();
    __oracle_jsp_text[24] = 
    "\r\n            </TD>\r\n            <TD COLSPAN='2'>\r\n                Excel ".toCharArray();
    __oracle_jsp_text[25] = 
    "\r\n            </TD>\r\n        </TR>\r\n        <TR height = '20px'>\r\n            <TD>Arrival Terminal</TD>\r\n            <TD colspan=\"5\">\r\n                ".toCharArray();
    __oracle_jsp_text[26] = 
    "\r\n                <input type=\"button\" value=\". . .\" name=\"btnContLookup\" class=\"btnbutton\" onclick='return openPartnerTerminalLookup()'/>\r\n            </TD>\r\n        </TR>\r\n        <TR height = '20px'>\r\n            <TD>Arrival Port</TD>\r\n            <TD colspan=\"5\">\r\n                ".toCharArray();
    __oracle_jsp_text[27] = 
    "\r\n            </td>\r\n        </TR>\r\n        <TR height = '20px'>\r\n            <TD>Message Recepient</TD>\r\n            <TD colspan=\"5\">\r\n                ".toCharArray();
    __oracle_jsp_text[28] = 
    "\r\n            </TD>\r\n        </TR>\r\n        <TR height = '20px'>\r\n            <TD>Message Set</TD>\r\n            <TD colspan=\"5\">\r\n                ".toCharArray();
    __oracle_jsp_text[29] = 
    "\r\n            </TD>\r\n        </TR>\r\n        <TR height = '20px'>\r\n            <TD>Service</TD>\r\n            <TD colspan=\"5\">\r\n                ".toCharArray();
    __oracle_jsp_text[30] = 
    "\r\n            </TD>\r\n        </TR>\r\n        <TR height = '20px'>\r\n            <TD>Vessel</TD>\r\n            <TD colspan=\"5\">\r\n                ".toCharArray();
    __oracle_jsp_text[31] = 
    "\r\n            </TD>\r\n        </TR>\r\n        <TR height = '20px'>\r\n            <TD>ROB Included</TD>\r\n            <TD colspan=\"5\">\r\n                ".toCharArray();
    __oracle_jsp_text[32] = 
    "\r\n            </TD>\r\n        </TR>\r\n        <TR height = '20px'>\r\n            ".toCharArray();
    __oracle_jsp_text[33] = 
    "\r\n            <TD colspan='10'>\r\n                <table border ='0' WIDTH=\"100%\" CELLSPACING=\"0\" CELLPADDING=\"0\">\r\n                    <tr>\r\n                        <TD width = \"170px\">\r\n                            Container Operator\r\n                        </TD>\r\n                        <TD width = \"120px\">\r\n                            ".toCharArray();
    __oracle_jsp_text[34] = 
    "\r\n                                ".toCharArray();
    __oracle_jsp_text[35] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[36] = 
    "\r\n                        </TD>\r\n                        <td>\r\n                            ".toCharArray();
    __oracle_jsp_text[37] = 
    "\r\n                        </td>\r\n                    </tr>\r\n                    <tr>\r\n                        <TD>\r\n                            Slot Operator\r\n                        </TD>\r\n                        <TD>\r\n                            ".toCharArray();
    __oracle_jsp_text[38] = 
    "\r\n                                ".toCharArray();
    __oracle_jsp_text[39] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[40] = 
    "\r\n                        </TD>\r\n                        <td>\r\n                            ".toCharArray();
    __oracle_jsp_text[41] = 
    "\r\n                        </td>\r\n                    </tr>\r\n                </table>\r\n            </TD>\r\n        </tr>\r\n    </TABLE>\r\n\r\n    <div class=\"buttons_box\">\r\n        <input type=\"button\" value=\"Generate\" name=\"btnSave\" class=\"event_btnbutton\" onclick=\"onGenerate();\"/>\r\n    </div>\r\n".toCharArray();
    __oracle_jsp_text[42] = 
    "\r\n</BODY>\r\n</HTML>\r\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
