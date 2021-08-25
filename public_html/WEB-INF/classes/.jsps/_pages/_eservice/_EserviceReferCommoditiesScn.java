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
import com.niit.control.common.ComboVO;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceReferCommoditiesUim;
import java.util.List;


public class _EserviceReferCommoditiesScn extends com.orionserver.http.OrionHttpJspPage {


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
    _EserviceReferCommoditiesScn page = this;
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
      out.write(__oracle_jsp_text[10]);
      
          String contextPath = request.getContextPath();
      
      
      out.write(__oracle_jsp_text[11]);
      {
        org.apache.struts.taglib.html.HtmlTag __jsp_taghandler_1=(org.apache.struts.taglib.html.HtmlTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HtmlTag.class,"org.apache.struts.taglib.html.HtmlTag");
        __jsp_taghandler_1.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[12]);
            out.print(contextPath);
            out.write(__oracle_jsp_text[13]);
            out.print(contextPath);
            out.write(__oracle_jsp_text[14]);
            out.print(contextPath);
            out.write(__oracle_jsp_text[15]);
            out.print(contextPath);
            out.write(__oracle_jsp_text[16]);
            out.print(contextPath);
            out.write(__oracle_jsp_text[17]);
            out.print(contextPath);
            out.write(__oracle_jsp_text[18]);
            out.print(contextPath);
            out.write(__oracle_jsp_text[19]);
            out.print(contextPath);
            out.write(__oracle_jsp_text[20]);
            out.print(contextPath);
            out.write(__oracle_jsp_text[21]);
            out.print(contextPath);
            out.write(__oracle_jsp_text[22]);
            out.print(contextPath);
            out.write(__oracle_jsp_text[23]);
            out.print(contextPath);
            out.write(__oracle_jsp_text[24]);
            out.print(contextPath);
            out.write(__oracle_jsp_text[25]);
            out.print(contextPath);
            out.write(__oracle_jsp_text[26]);
            out.print(contextPath);
            out.write(__oracle_jsp_text[27]);
            out.print(contextPath);
            out.write(__oracle_jsp_text[28]);
            out.print(contextPath);
            out.write(__oracle_jsp_text[29]);
            out.print(contextPath);
            out.write(__oracle_jsp_text[30]);
            out.print(contextPath);
            out.write(__oracle_jsp_text[31]);
            out.print(contextPath);
            out.write(__oracle_jsp_text[32]);
            out.print(contextPath);
            out.write(__oracle_jsp_text[33]);
            out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv019OnSubmit", pageContext));
            out.write(__oracle_jsp_text[34]);
            {
              org.apache.struts.taglib.html.FormTag __jsp_taghandler_2=(org.apache.struts.taglib.html.FormTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.FormTag.class,"org.apache.struts.taglib.html.FormTag action method styleId");
              __jsp_taghandler_2.setParent(__jsp_taghandler_1);
              __jsp_taghandler_2.setAction("/serv019");
              __jsp_taghandler_2.setMethod("post");
              __jsp_taghandler_2.setStyleId("frm");
              __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[35]);
                  {
                    org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_3=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
                    __jsp_taghandler_3.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_3.setName("feserv19");
                    __jsp_taghandler_3.setProperty("errMsg");
                    __jsp_tag_starteval=__jsp_taghandler_3.doStartTag();
                    if (__jsp_taghandler_3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_3,3);
                  }
                  out.write(__oracle_jsp_text[36]);
                  {
                    org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_4=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
                    __jsp_taghandler_4.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_4.setName("feserv19");
                    __jsp_taghandler_4.setProperty("seqNo");
                    __jsp_taghandler_4.setStyleId("seqNo");
                    __jsp_tag_starteval=__jsp_taghandler_4.doStartTag();
                    if (__jsp_taghandler_4.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_4,3);
                  }
                  out.write(__oracle_jsp_text[37]);
                  {
                    org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_5=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
                    __jsp_taghandler_5.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_5.setName("feserv19");
                    __jsp_taghandler_5.setProperty("rowIndex");
                    __jsp_taghandler_5.setStyleId("rowIndex");
                    __jsp_tag_starteval=__jsp_taghandler_5.doStartTag();
                    if (__jsp_taghandler_5.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_5,3);
                  }
                  out.write(__oracle_jsp_text[38]);
                  {
                    org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_6=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
                    __jsp_taghandler_6.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_6.setName("feserv19");
                    __jsp_taghandler_6.setProperty("disBtn");
                    __jsp_taghandler_6.setStyleId("disBtn");
                    __jsp_tag_starteval=__jsp_taghandler_6.doStartTag();
                    if (__jsp_taghandler_6.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_6,3);
                  }
                  out.write(__oracle_jsp_text[39]);
                  out.write(__oracle_jsp_text[40]);
                  {
                    org.apache.struts.taglib.html.TextTag __jsp_taghandler_7=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag name onblur onkeypress property style styleId");
                    __jsp_taghandler_7.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_7.setName("feserv19");
                    __jsp_taghandler_7.setOnblur("lp_onBlursetFormat();");
                    __jsp_taghandler_7.setOnkeypress("return gp_validNumberKeyMinus(event);");
                    __jsp_taghandler_7.setProperty("temperature");
                    __jsp_taghandler_7.setStyle("width: 200px");
                    __jsp_taghandler_7.setStyleId("temperature");
                    __jsp_tag_starteval=__jsp_taghandler_7.doStartTag();
                    if (__jsp_taghandler_7.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_7,3);
                  }
                  out.write(__oracle_jsp_text[41]);
                  {
                    org.apache.struts.taglib.html.TextTag __jsp_taghandler_8=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag name onblur onkeypress property style styleId");
                    __jsp_taghandler_8.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_8.setName("feserv19");
                    __jsp_taghandler_8.setOnblur("lp_onBlursetFormat();");
                    __jsp_taghandler_8.setOnkeypress("return gp_validNumberKey(event);");
                    __jsp_taghandler_8.setProperty("ventilation");
                    __jsp_taghandler_8.setStyle("width: 200px");
                    __jsp_taghandler_8.setStyleId("ventilation");
                    __jsp_tag_starteval=__jsp_taghandler_8.doStartTag();
                    if (__jsp_taghandler_8.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_8,3);
                  }
                  out.write(__oracle_jsp_text[42]);
                  {
                    org.apache.struts.taglib.html.TextTag __jsp_taghandler_9=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name property style styleId");
                    __jsp_taghandler_9.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_9.setMaxlength("60");
                    __jsp_taghandler_9.setName("feserv19");
                    __jsp_taghandler_9.setProperty("remark");
                    __jsp_taghandler_9.setStyle("width: 400px");
                    __jsp_taghandler_9.setStyleId("remark");
                    __jsp_tag_starteval=__jsp_taghandler_9.doStartTag();
                    if (__jsp_taghandler_9.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_9,3);
                  }
                  out.write(__oracle_jsp_text[43]);
                  {
                    org.apache.struts.taglib.html.TextTag __jsp_taghandler_10=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag name onblur onkeypress property style styleId");
                    __jsp_taghandler_10.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_10.setName("feserv19");
                    __jsp_taghandler_10.setOnblur("lp_onBlursetFormat();");
                    __jsp_taghandler_10.setOnkeypress("return gp_validNumberKey(event);");
                    __jsp_taghandler_10.setProperty("humidity");
                    __jsp_taghandler_10.setStyle("width: 200px");
                    __jsp_taghandler_10.setStyleId("humidity");
                    __jsp_tag_starteval=__jsp_taghandler_10.doStartTag();
                    if (__jsp_taghandler_10.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_10,3);
                  }
                  out.write(__oracle_jsp_text[44]);
                  {
                    org.apache.struts.taglib.html.CheckboxTag __jsp_taghandler_11=(org.apache.struts.taglib.html.CheckboxTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.CheckboxTag.class,"org.apache.struts.taglib.html.CheckboxTag name onclick property style styleId value");
                    __jsp_taghandler_11.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_11.setName("feserv19");
                    __jsp_taghandler_11.setOnclick("lp_onClickControlledAtmosphere();");
                    __jsp_taghandler_11.setProperty("controlledAtmosphere");
                    __jsp_taghandler_11.setStyle("border:0px;width:2%");
                    __jsp_taghandler_11.setStyleId("controlledAtmosphere");
                    __jsp_taghandler_11.setValue("Y");
                    __jsp_tag_starteval=__jsp_taghandler_11.doStartTag();
                    if (__jsp_taghandler_11.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_11,3);
                  }
                  out.write(__oracle_jsp_text[45]);
                  {
                    org.apache.struts.taglib.html.TextTag __jsp_taghandler_12=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag name onblur onkeypress property style styleId");
                    __jsp_taghandler_12.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_12.setName("feserv19");
                    __jsp_taghandler_12.setOnblur("lp_onBlursetFormat();");
                    __jsp_taghandler_12.setOnkeypress("return gp_validNumberKey(event);");
                    __jsp_taghandler_12.setProperty("nitrogen");
                    __jsp_taghandler_12.setStyle("width: 200px");
                    __jsp_taghandler_12.setStyleId("nitrogen");
                    __jsp_tag_starteval=__jsp_taghandler_12.doStartTag();
                    if (__jsp_taghandler_12.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_12,3);
                  }
                  out.write(__oracle_jsp_text[46]);
                  {
                    org.apache.struts.taglib.html.TextTag __jsp_taghandler_13=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag name onblur onkeypress property style styleId");
                    __jsp_taghandler_13.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_13.setName("feserv19");
                    __jsp_taghandler_13.setOnblur("lp_onBlursetFormat();");
                    __jsp_taghandler_13.setOnkeypress("return gp_validNumberKey(event);");
                    __jsp_taghandler_13.setProperty("oxygent");
                    __jsp_taghandler_13.setStyle("width: 200px");
                    __jsp_taghandler_13.setStyleId("oxygent");
                    __jsp_tag_starteval=__jsp_taghandler_13.doStartTag();
                    if (__jsp_taghandler_13.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_13,3);
                  }
                  out.write(__oracle_jsp_text[47]);
                  {
                    org.apache.struts.taglib.html.TextTag __jsp_taghandler_14=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag name onblur onkeypress property style styleId");
                    __jsp_taghandler_14.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_14.setName("feserv19");
                    __jsp_taghandler_14.setOnblur("lp_onBlursetFormat();");
                    __jsp_taghandler_14.setOnkeypress("return gp_validNumberKey(event);");
                    __jsp_taghandler_14.setProperty("co2");
                    __jsp_taghandler_14.setStyle("width: 200px");
                    __jsp_taghandler_14.setStyleId("co2");
                    __jsp_tag_starteval=__jsp_taghandler_14.doStartTag();
                    if (__jsp_taghandler_14.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_14,3);
                  }
                  out.write(__oracle_jsp_text[48]);
                  {
                    org.apache.struts.taglib.html.SelectTag __jsp_taghandler_15=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name onchange property size");
                    __jsp_taghandler_15.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_15.setName("feserv19");
                    __jsp_taghandler_15.setOnchange("");
                    __jsp_taghandler_15.setProperty("refMode");
                    __jsp_taghandler_15.setSize("1");
                    __jsp_tag_starteval=__jsp_taghandler_15.doStartTag();
                    if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                    {
                      out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_15,__jsp_tag_starteval,out);
                      do {
                        out.write(__oracle_jsp_text[49]);
                        {
                          org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_16=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                          __jsp_taghandler_16.setParent(__jsp_taghandler_15);
                          __jsp_taghandler_16.setLabel("name");
                          __jsp_taghandler_16.setName("feserv19");
                          __jsp_taghandler_16.setProperty("refrModeList");
                          __jsp_taghandler_16.setValue("code");
                          __jsp_tag_starteval=__jsp_taghandler_16.doStartTag();
                          if (__jsp_taghandler_16.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_16,4);
                        }
                        out.write(__oracle_jsp_text[50]);
                      } while (__jsp_taghandler_15.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                      out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                    }
                    if (__jsp_taghandler_15.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_15,3);
                  }
                  out.write(__oracle_jsp_text[51]);
                  {
                    org.apache.struts.taglib.html.CheckboxTag __jsp_taghandler_17=(org.apache.struts.taglib.html.CheckboxTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.CheckboxTag.class,"org.apache.struts.taglib.html.CheckboxTag name property style styleId value");
                    __jsp_taghandler_17.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_17.setName("feserv19");
                    __jsp_taghandler_17.setProperty("preCooled");
                    __jsp_taghandler_17.setStyle("border:0px;width:2%;");
                    __jsp_taghandler_17.setStyleId("preCooled");
                    __jsp_taghandler_17.setValue("Y");
                    __jsp_tag_starteval=__jsp_taghandler_17.doStartTag();
                    if (__jsp_taghandler_17.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_17,3);
                  }
                  out.write(__oracle_jsp_text[52]);
                  out.print(contextPath);
                  out.write(__oracle_jsp_text[53]);
                  out.write(__oracle_jsp_text[54]);
                  out.write(__oracle_jsp_text[55]);
                  out.write(__oracle_jsp_text[56]);
                  out.write(__oracle_jsp_text[57]);
                } while (__jsp_taghandler_2.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,2);
            }
            out.write(__oracle_jsp_text[58]);
          } while (__jsp_taghandler_1.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[59]);

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
  private static final char __oracle_jsp_text[][]=new char[60][];
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
    "\r\n".toCharArray();
    __oracle_jsp_text[11] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[12] = 
    "\r\n<head>\r\n<title>Reefer Details</title>\r\n<meta content=\"text/html; charset=utf-8\" http-equiv=\"content-type\" />\r\n<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" >\r\n<link type=\"text/css\" href=\"".toCharArray();
    __oracle_jsp_text[13] = 
    "/css/registration/common.css\" rel=\"stylesheet\">\r\n<link type=\"text/css\" href=\"".toCharArray();
    __oracle_jsp_text[14] = 
    "/css/registration/reset.css\" rel=\"stylesheet\">\r\n<link type=\"text/css\" href=\"".toCharArray();
    __oracle_jsp_text[15] = 
    "/css/registration/style.css\" rel=\"stylesheet\">\r\n<style type=\"text/css\">\r\n    td.sub_table_blt_center{\r\n         background-image: url('".toCharArray();
    __oracle_jsp_text[16] = 
    "/images/registration/registration_blt_center.gif');\r\n         width: 10px; \r\n         height: 10px;\r\n    }\r\n    \r\n    td.sub_table_blt_right{\r\n        background-image: url('".toCharArray();
    __oracle_jsp_text[17] = 
    "/images/registration/registration_blt_right.gif');\r\n        width: 10px; \r\n        height: 10px;\r\n    }\r\n    td.sub_table_blt_left{\r\n        background-image: url('".toCharArray();
    __oracle_jsp_text[18] = 
    "/images/registration/registration_blt_left.gif');\r\n        width: 10px; \r\n        height: 10px;\r\n    }\r\n    \r\n    td.sub_table_brt_center{\r\n        background-image: url('".toCharArray();
    __oracle_jsp_text[19] = 
    "/images/registration/registration_brt_center.gif');\r\n        width: 10px; \r\n        height: 10px;\r\n    }\r\n    \r\n    td.sub_table_brt_right{\r\n        background-image: url('".toCharArray();
    __oracle_jsp_text[20] = 
    "/images/registration/registration_brt_right.gif');\r\n        width: 10px; \r\n        height: 10px;\r\n    }\r\n    \r\n    td.sub_table_brt_left{\r\n        background-image: url('".toCharArray();
    __oracle_jsp_text[21] = 
    "/images/registration/registration_brt_left.gif');\r\n        width: 10px; \r\n        height: 10px;\r\n    }\r\n    \r\n     td.sub_table_blb_center{\r\n        background-image: url('".toCharArray();
    __oracle_jsp_text[22] = 
    "/images/registration/registration_blb_center.gif');\r\n        width: 10px; \r\n        height: 10px;\r\n    }\r\n    \r\n    td.sub_table_blb_right{\r\n        background-image: url('".toCharArray();
    __oracle_jsp_text[23] = 
    "/images/registration/registration_blb_right.gif');\r\n        width: 10px; \r\n        height: 10px;\r\n    }\r\n    \r\n    td.sub_table_blb_left{\r\n        background-image: url('".toCharArray();
    __oracle_jsp_text[24] = 
    "/images/registration/registration_blb_left.gif');\r\n        width: 10px; \r\n        height: 10px;\r\n    }\r\n    \r\n    td.sub_table_brb_center{\r\n        background-image: url('".toCharArray();
    __oracle_jsp_text[25] = 
    "/images/registration/registration_brb_center.gif');\r\n        width: 10px; \r\n        height: 10px;\r\n    }\r\n    \r\n    td.sub_table_brb_right{\r\n        background-image: url('".toCharArray();
    __oracle_jsp_text[26] = 
    "/images/registration/registration_brb_right.gif');\r\n        width: 10px; \r\n        height: 10px;\r\n    }\r\n    \r\n    td.sub_table_brb_left{\r\n        background-image: url('".toCharArray();
    __oracle_jsp_text[27] = 
    "/images/registration/registration_brb_left.gif');\r\n        width: 10px; \r\n        height: 10px;\r\n    }\r\n    \r\n    td.sub_table_horizon_top{\r\n        background-image: url('".toCharArray();
    __oracle_jsp_text[28] = 
    "/images/registration/registration_horizon_top.gif');\r\n        background-repeat: repeat-x;\r\n        height: 10px;\r\n    }\r\n    \r\n    td.sub_table_horizon_bottom{\r\n        background-image: url('".toCharArray();
    __oracle_jsp_text[29] = 
    "/images/registration/registration_horizon_bottom.gif');\r\n        background-repeat: repeat-x;\r\n        height: 10px;\r\n    }\r\n    \r\n    td.sub_table_vertical_left{\r\n        background-image: url('".toCharArray();
    __oracle_jsp_text[30] = 
    "/images/registration/registration_vertical_left.gif');\r\n        background-repeat: repeat-y;\r\n        height: 10px;\r\n    }\r\n    \r\n    td.sub_table_vertical_right{\r\n        background-image: url('".toCharArray();
    __oracle_jsp_text[31] = 
    "/images/registration/registration_vertical_right.gif');\r\n        background-repeat: repeat-y;\r\n        height: 10px;\r\n    }\r\n</style>\r\n<!-- add screen specific JavaScript file -->\r\n<script type=\"text/javascript\" src=\"".toCharArray();
    __oracle_jsp_text[32] = 
    "/js/common/Constants.js\" ></script>\r\n<script type=\"text/javascript\" src=\"".toCharArray();
    __oracle_jsp_text[33] = 
    "/js/screen/EserviceReferCommodities.js\" ></script>\r\n<script type=\"text/javascript\">\r\n    var SUBMIT = '".toCharArray();
    __oracle_jsp_text[34] = 
    "';\r\n</script>\r\n</head>\r\n<body onload=\"onLoad();\">\r\n".toCharArray();
    __oracle_jsp_text[35] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[36] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[37] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[38] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[39] = 
    "\r\n    \r\n    <table width=\"910\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\r\n        <tr>\r\n            <td>\r\n            <!-- ########## Personal And Account Detail START ########### -->\r\n                <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"table_main_detail\">\r\n                    <tr class=\"table_tr_header\">\r\n                        <td  class=\"font_header\">\r\n                            Reefer Details\r\n                        </td>\r\n                    </tr>\r\n                    <tr style=\"height: 100px\">\r\n                        <td class=\"td_sub_detail\" style=\"vertical-align: middle\">\r\n                            ".toCharArray();
    __oracle_jsp_text[40] = 
    "                    \r\n                            <table width=\"95%\" border=\"0\" cellspacing=\"2\" cellpadding=\"0\" align=\"center\" class=\"table_sub_detail\">\r\n                                <tr class=\"tr_sub_detail\">\r\n                                    <td width=\"20%\">Temperature (Celcius)</td>\r\n                                    <td width=\"80%\">\r\n                                        ".toCharArray();
    __oracle_jsp_text[41] = 
    "\r\n                                    </td>\r\n                                </tr>\r\n                                <tr class=\"tr_sub_detail\">\r\n                                    <td>Ventilation %</td>\r\n                                    <td>\r\n                                        ".toCharArray();
    __oracle_jsp_text[42] = 
    "\r\n                                    </td>\r\n                                </tr>\r\n                                <tr class=\"tr_sub_detail\">\r\n                                    <td>Remark</td>\r\n                                    <td>\r\n                                        ".toCharArray();
    __oracle_jsp_text[43] = 
    "\r\n                                    </td>\r\n                                </tr>\r\n                                <tr class=\"tr_sub_detail\">\r\n                                    <td>Humidity</td>\r\n                                    <td>\r\n                                        ".toCharArray();
    __oracle_jsp_text[44] = 
    "\r\n                                    </td>\r\n                                </tr>\r\n                                <tr class=\"tr_sub_detail\">\r\n                                    <td>Controlled Atmosphere</td>\r\n                                    <td align=\"left\">\r\n                                        ".toCharArray();
    __oracle_jsp_text[45] = 
    "\r\n                                    </td>\r\n                                </tr>\r\n                                <tr class=\"tr_sub_detail\">\r\n                                    <td>Nitrogen %</td>\r\n                                    <td>\r\n                                        ".toCharArray();
    __oracle_jsp_text[46] = 
    "\r\n                                    </td>\r\n                                </tr>\r\n                                <tr class=\"tr_sub_detail\">\r\n                                    <td>Oxygent%</td>\r\n                                    <td>\r\n                                        ".toCharArray();
    __oracle_jsp_text[47] = 
    "\r\n                                    </td>\r\n                                </tr>\r\n                                <tr class=\"tr_sub_detail\">\r\n                                    <td>CO2%</td>\r\n                                    <td>\r\n                                        ".toCharArray();
    __oracle_jsp_text[48] = 
    "\r\n                                    </td>\r\n                                </tr>\r\n                                <tr class=\"tr_sub_detail\">\r\n                                    <td>Refr. Mode</td>\r\n                                    <td>\r\n                                        ".toCharArray();
    __oracle_jsp_text[49] = 
    "\r\n                                            ".toCharArray();
    __oracle_jsp_text[50] = 
    "\r\n                                        ".toCharArray();
    __oracle_jsp_text[51] = 
    "\r\n                                    </td>\r\n                                </tr>\r\n                                <tr class=\"tr_sub_detail\">\r\n                                    <td>Pre-Cooled</td>\r\n                                    <td align=\"left\">\r\n                                        ".toCharArray();
    __oracle_jsp_text[52] = 
    "\r\n                                    </td>\r\n                                </tr>\r\n                            </table>  \r\n                        </td>\r\n                    </tr>\r\n                    <tr class=\"tr_sub_detail\" style=\"height: 50px;\" id=\"trSubmitBtn\">\r\n                        <td  class=\"font_header\" style=\"text-align: center;\">\r\n                            <a class=\"m-btn mini blue rnd\" href=\"javascript:void(0)\" onClick=\"submitBtn();\">\r\n                                <strong>OK</strong>\r\n                            </a>\r\n                        </td>\r\n                    </tr>\r\n                </table>\r\n            <!-- ########## Personal And Account Detail END ########### -->\r\n            </td>\r\n        </tr>\r\n        <tr style=\"height: 20px\"><td></td></tr>\r\n        <tr>\r\n            <td>\r\n            <div id=\"footerbox\">\r\n                <div id=\"footermain\">\r\n                    <div style=\"width: 910px;\">\r\n                        <img class=\"homepageFooterDivider\" src=\"".toCharArray();
    __oracle_jsp_text[53] = 
    "/images/registration/divbottom.jpg\" border=\"0\" />\r\n                        <p style=\"text-align: center; font-family: Arial; font-size: 10px; line-height: 2em;\">\r\n                            Copyright 2011 Regional Container Lines. All rights reserved. \r\n                        </p>\r\n                        \r\n                        <p style=\"text-align: center;\"> \r\n                            <font style=\"text-align: center; font-family: Arial; font-size: 10px; line-height: 2em;\">\r\n                            ".toCharArray();
    __oracle_jsp_text[54] = 
    "\r\n                                Terms of Use\r\n                                ".toCharArray();
    __oracle_jsp_text[55] = 
    "\r\n                            </font>\r\n                            <font style=\"text-align: center; font-family: Arial; font-size: 10px; line-height: 2em;\">&nbsp;|&nbsp;</font>\r\n                            <font style=\"text-align: center; font-family: Arial; font-size: 10px; line-height: 2em;\">\r\n                            ".toCharArray();
    __oracle_jsp_text[56] = 
    "\r\n                                Privacy Policy".toCharArray();
    __oracle_jsp_text[57] = 
    "\r\n                            </font>\t\r\n                            <font style=\"text-align: center; font-family: Arial; font-size: 10px; line-height: 2em;\">&nbsp;|&nbsp;</font>\r\n                            <font style=\"text-align: center; font-family: Arial; font-size: 10px; line-height: 2em;\">\r\n                            This website is best viewed with IE 9.x and above.\r\n                            </font>\t\r\n                        </p>\r\n                    </div>\r\n                </div>\r\n            </div>\r\n            </td>\r\n        </tr>\r\n        <tr style=\"height: 50px\"><td></td></tr>\r\n    </table>\r\n".toCharArray();
    __oracle_jsp_text[58] = 
    "\r\n</body>\r\n".toCharArray();
    __oracle_jsp_text[59] = 
    "\r\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
