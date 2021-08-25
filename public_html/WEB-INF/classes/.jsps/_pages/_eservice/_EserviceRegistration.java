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
import com.rclgroup.dolphin.rcl.web.captcha.CaptchaServiceSingleton;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import com.octo.captcha.service.CaptchaServiceException;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceRegistrationUim;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceRegistrationDao;
import java.util.List;


public class _EserviceRegistration extends com.orionserver.http.OrionHttpJspPage {


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
    _EserviceRegistration page = this;
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
      out.write(__oracle_jsp_text[11]);
      out.write(__oracle_jsp_text[12]);
      out.write(__oracle_jsp_text[13]);
      out.write(__oracle_jsp_text[14]);
      out.write(__oracle_jsp_text[15]);
      out.write(__oracle_jsp_text[16]);
      out.write(__oracle_jsp_text[17]);
      
          String contextPath = request.getContextPath();
          String userIdChecked = (String) request.getAttribute("userIdChecked");
          if(userIdChecked == null){
              userIdChecked = "false";
          }
          
          String userIdPassed = (String) request.getAttribute("userIdPassed");
          if(userIdPassed == null){
              userIdPassed = "false";
          }
          
          String userIdViewMode = (String) request.getAttribute("userIdViewMode");
          if(userIdViewMode == null){
              userIdViewMode = "false";
          }
          
          String authPage = (String) request.getAttribute("authPage");
          if(authPage == null){
              authPage = "Auth";
          }
              
          String userId = (String) request.getAttribute("userId");
      
      out.write(__oracle_jsp_text[18]);
      {
        org.apache.struts.taglib.html.HtmlTag __jsp_taghandler_1=(org.apache.struts.taglib.html.HtmlTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HtmlTag.class,"org.apache.struts.taglib.html.HtmlTag");
        __jsp_taghandler_1.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
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
            out.write(__oracle_jsp_text[25]);
            out.write(__oracle_jsp_text[26]);
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
            out.print(contextPath);
            out.write(__oracle_jsp_text[34]);
            out.print(contextPath);
            out.write(__oracle_jsp_text[35]);
            out.print(contextPath);
            out.write(__oracle_jsp_text[36]);
            out.print(contextPath);
            out.write(__oracle_jsp_text[37]);
            out.print(contextPath);
            out.write(__oracle_jsp_text[38]);
            out.print(contextPath);
            out.write(__oracle_jsp_text[39]);
            out.print(contextPath);
            out.write(__oracle_jsp_text[40]);
            out.print(contextPath);
            out.write(__oracle_jsp_text[41]);
            out.print(contextPath);
            out.write(__oracle_jsp_text[42]);
            out.print(contextPath);
            out.write(__oracle_jsp_text[43]);
            out.print(contextPath);
            out.write(__oracle_jsp_text[44]);
            out.print(contextPath);
            out.write(__oracle_jsp_text[45]);
            out.print(contextPath);
            out.write(__oracle_jsp_text[46]);
            out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv007Registration", pageContext));
            out.write(__oracle_jsp_text[47]);
            out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv007CheckAvailableUserId", pageContext));
            out.write(__oracle_jsp_text[48]);
            out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv014", pageContext));
            out.write(__oracle_jsp_text[49]);
            out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv016", pageContext));
            out.write(__oracle_jsp_text[50]);
            out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv007CreateCRMCustomer", pageContext));
            out.write(__oracle_jsp_text[51]);
            out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv015", pageContext));
            out.write(__oracle_jsp_text[52]);
            out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv007GenerateCaptcha", pageContext));
            out.write(__oracle_jsp_text[53]);
            out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv007OpenAcknowledge", pageContext));
            out.write(__oracle_jsp_text[54]);
            out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv007Reject", pageContext));
            out.write(__oracle_jsp_text[55]);
            out.print(userIdPassed);
            out.write(__oracle_jsp_text[56]);
            out.print(userIdChecked);
            out.write(__oracle_jsp_text[57]);
            out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv007addContractPartyCompany", pageContext));
            out.write(__oracle_jsp_text[58]);
            out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv007updContractPartyCompany", pageContext));
            out.write(__oracle_jsp_text[59]);
            out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv007delContractPartyCompany", pageContext));
            out.write(__oracle_jsp_text[60]);
            out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv007CreateCRMCustomerForContractParty", pageContext));
            out.write(__oracle_jsp_text[61]);
            {
              org.apache.struts.taglib.html.FormTag __jsp_taghandler_2=(org.apache.struts.taglib.html.FormTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.FormTag.class,"org.apache.struts.taglib.html.FormTag action method");
              __jsp_taghandler_2.setParent(__jsp_taghandler_1);
              __jsp_taghandler_2.setAction("/serv007");
              __jsp_taghandler_2.setMethod("post");
              __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[62]);
                  {
                    org.apache.struts.taglib.bean.DefineTag __jsp_taghandler_3=(org.apache.struts.taglib.bean.DefineTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.DefineTag.class,"org.apache.struts.taglib.bean.DefineTag id name property");
                    __jsp_taghandler_3.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_3.setId("internalUser");
                    __jsp_taghandler_3.setName("feserv12");
                    __jsp_taghandler_3.setProperty("internalUser");
                    __jsp_tag_starteval=__jsp_taghandler_3.doStartTag();
                    if (__jsp_taghandler_3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_3,3);
                  }
                  java.lang.Object internalUser = null;
                  internalUser = (java.lang.Object) pageContext.findAttribute("internalUser");
                  out.write(__oracle_jsp_text[63]);
                  {
                    org.apache.struts.taglib.bean.DefineTag __jsp_taghandler_4=(org.apache.struts.taglib.bean.DefineTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.DefineTag.class,"org.apache.struts.taglib.bean.DefineTag id name property");
                    __jsp_taghandler_4.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_4.setId("isInternalUser");
                    __jsp_taghandler_4.setName("feserv12");
                    __jsp_taghandler_4.setProperty("isInternalUser");
                    __jsp_tag_starteval=__jsp_taghandler_4.doStartTag();
                    if (__jsp_taghandler_4.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_4,3);
                  }
                  java.lang.Object isInternalUser = null;
                  isInternalUser = (java.lang.Object) pageContext.findAttribute("isInternalUser");
                  out.write(__oracle_jsp_text[64]);
                  {
                    org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_5=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
                    __jsp_taghandler_5.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_5.setName("feserv12");
                    __jsp_taghandler_5.setProperty("controlFsc");
                    __jsp_tag_starteval=__jsp_taghandler_5.doStartTag();
                    if (__jsp_taghandler_5.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_5,3);
                  }
                  out.write(__oracle_jsp_text[65]);
                  {
                    org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_6=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
                    __jsp_taghandler_6.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_6.setName("feserv12");
                    __jsp_taghandler_6.setProperty("fscCode");
                    __jsp_taghandler_6.setStyleId("fscCode");
                    __jsp_tag_starteval=__jsp_taghandler_6.doStartTag();
                    if (__jsp_taghandler_6.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_6,3);
                  }
                  out.write(__oracle_jsp_text[66]);
                  {
                    org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_7=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
                    __jsp_taghandler_7.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_7.setName("feserv12");
                    __jsp_taghandler_7.setProperty("internalUser");
                    __jsp_taghandler_7.setStyleId("internalUser");
                    __jsp_tag_starteval=__jsp_taghandler_7.doStartTag();
                    if (__jsp_taghandler_7.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_7,3);
                  }
                  out.write(__oracle_jsp_text[67]);
                  {
                    org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_8=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
                    __jsp_taghandler_8.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_8.setName("feserv12");
                    __jsp_taghandler_8.setProperty("isInternalUser");
                    __jsp_tag_starteval=__jsp_taghandler_8.doStartTag();
                    if (__jsp_taghandler_8.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_8,3);
                  }
                  out.write(__oracle_jsp_text[68]);
                  {
                    org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_9=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
                    __jsp_taghandler_9.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_9.setName("feserv12");
                    __jsp_taghandler_9.setProperty("errMsg");
                    __jsp_tag_starteval=__jsp_taghandler_9.doStartTag();
                    if (__jsp_taghandler_9.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_9,3);
                  }
                  out.write(__oracle_jsp_text[69]);
                  {
                    org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_10=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
                    __jsp_taghandler_10.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_10.setName("feserv12");
                    __jsp_taghandler_10.setProperty("submitSuccess");
                    __jsp_tag_starteval=__jsp_taghandler_10.doStartTag();
                    if (__jsp_taghandler_10.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_10,3);
                  }
                  out.write(__oracle_jsp_text[70]);
                  {
                    org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_11=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
                    __jsp_taghandler_11.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_11.setName("feserv12");
                    __jsp_taghandler_11.setProperty("allSFUChecked");
                    __jsp_tag_starteval=__jsp_taghandler_11.doStartTag();
                    if (__jsp_taghandler_11.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_11,3);
                  }
                  out.write(__oracle_jsp_text[71]);
                  out.print(userIdChecked);
                  out.write(__oracle_jsp_text[72]);
                  out.print(userIdPassed);
                  out.write(__oracle_jsp_text[73]);
                  out.print(userIdViewMode);
                  out.write(__oracle_jsp_text[74]);
                  out.print(authPage);
                  out.write(__oracle_jsp_text[75]);
                  {
                    org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_12=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
                    __jsp_taghandler_12.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_12.setName("feserv12");
                    __jsp_taghandler_12.setProperty("maxPkPortPairSeq");
                    __jsp_taghandler_12.setStyleId("maxPkPortPairSeq");
                    __jsp_tag_starteval=__jsp_taghandler_12.doStartTag();
                    if (__jsp_taghandler_12.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_12,3);
                  }
                  out.write(__oracle_jsp_text[76]);
                  out.print(contextPath);
                  out.write(__oracle_jsp_text[77]);
                  {
                    org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_13=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
                    __jsp_taghandler_13.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_13.setName("feserv12");
                    __jsp_taghandler_13.setProperty("portPairFlag");
                    __jsp_taghandler_13.setStyleId("portPairFlag");
                    __jsp_tag_starteval=__jsp_taghandler_13.doStartTag();
                    if (__jsp_taghandler_13.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_13,3);
                  }
                  out.write(__oracle_jsp_text[78]);
                  out.print(contextPath);
                  out.write(__oracle_jsp_text[79]);
                  out.print(contextPath);
                  out.write(__oracle_jsp_text[80]);
                  out.write(__oracle_jsp_text[81]);
                  {
                    org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_14=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name value");
                    __jsp_taghandler_14.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_14.setName("internalUser");
                    __jsp_taghandler_14.setValue(OracleJspRuntime.toStr( EserviceRegistrationDao.USER_MODE.EXTERNAL));
                    __jsp_tag_starteval=__jsp_taghandler_14.doStartTag();
                    if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                    {
                      do {
                        out.write(__oracle_jsp_text[82]);
                        {
                          org.apache.struts.taglib.html.TextTag __jsp_taghandler_15=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag name onkeypress property size");
                          __jsp_taghandler_15.setParent(__jsp_taghandler_14);
                          __jsp_taghandler_15.setName("feserv12");
                          __jsp_taghandler_15.setOnkeypress("clearMsg();");
                          __jsp_taghandler_15.setProperty("firstName");
                          __jsp_taghandler_15.setSize("20");
                          __jsp_tag_starteval=__jsp_taghandler_15.doStartTag();
                          if (__jsp_taghandler_15.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_15,4);
                        }
                        out.write(__oracle_jsp_text[83]);
                        {
                          org.apache.struts.taglib.html.TextTag __jsp_taghandler_16=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag name onkeypress property size");
                          __jsp_taghandler_16.setParent(__jsp_taghandler_14);
                          __jsp_taghandler_16.setName("feserv12");
                          __jsp_taghandler_16.setOnkeypress("clearMsg();");
                          __jsp_taghandler_16.setProperty("lastName");
                          __jsp_taghandler_16.setSize("20");
                          __jsp_tag_starteval=__jsp_taghandler_16.doStartTag();
                          if (__jsp_taghandler_16.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_16,4);
                        }
                        out.write(__oracle_jsp_text[84]);
                      } while (__jsp_taghandler_14.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                    }
                    if (__jsp_taghandler_14.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_14,3);
                  }
                  out.write(__oracle_jsp_text[85]);
                  {
                    org.apache.struts.taglib.logic.NotEqualTag __jsp_taghandler_17=(org.apache.struts.taglib.logic.NotEqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEqualTag.class,"org.apache.struts.taglib.logic.NotEqualTag name value");
                    __jsp_taghandler_17.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_17.setName("internalUser");
                    __jsp_taghandler_17.setValue(OracleJspRuntime.toStr( EserviceRegistrationDao.USER_MODE.EXTERNAL));
                    __jsp_tag_starteval=__jsp_taghandler_17.doStartTag();
                    if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                    {
                      do {
                        out.write(__oracle_jsp_text[86]);
                        {
                          org.apache.struts.taglib.html.TextTag __jsp_taghandler_18=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag name property readonly style styleId");
                          __jsp_taghandler_18.setParent(__jsp_taghandler_17);
                          __jsp_taghandler_18.setName("feserv12");
                          __jsp_taghandler_18.setProperty("userInfoMod.userName");
                          __jsp_taghandler_18.setReadonly(OracleJspRuntime.toBoolean( userIdViewMode));
                          __jsp_taghandler_18.setStyle("width: 200px");
                          __jsp_taghandler_18.setStyleId("userInfoMod.userName");
                          __jsp_tag_starteval=__jsp_taghandler_18.doStartTag();
                          if (__jsp_taghandler_18.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_18,4);
                        }
                        out.write(__oracle_jsp_text[87]);
                      } while (__jsp_taghandler_17.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                    }
                    if (__jsp_taghandler_17.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_17,3);
                  }
                  out.write(__oracle_jsp_text[88]);
                  {
                    org.apache.struts.taglib.html.TextTag __jsp_taghandler_19=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag name onkeypress property readonly style styleId");
                    __jsp_taghandler_19.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_19.setName("feserv12");
                    __jsp_taghandler_19.setOnkeypress("clearMsg(); return validEmailKey(event, this);");
                    __jsp_taghandler_19.setProperty("userInfoMod.email");
                    __jsp_taghandler_19.setReadonly(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${isInternalUser}",java.lang.Boolean.class, __ojsp_varRes,null)));
                    __jsp_taghandler_19.setStyle("width: 200px");
                    __jsp_taghandler_19.setStyleId("userInfoMod.email");
                    __jsp_tag_starteval=__jsp_taghandler_19.doStartTag();
                    if (__jsp_taghandler_19.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_19,3);
                  }
                  out.write(__oracle_jsp_text[89]);
                  {
                    org.apache.struts.taglib.logic.NotEqualTag __jsp_taghandler_20=(org.apache.struts.taglib.logic.NotEqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEqualTag.class,"org.apache.struts.taglib.logic.NotEqualTag name value");
                    __jsp_taghandler_20.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_20.setName("internalUser");
                    __jsp_taghandler_20.setValue(OracleJspRuntime.toStr( EserviceRegistrationDao.USER_MODE.INTERNAL));
                    __jsp_tag_starteval=__jsp_taghandler_20.doStartTag();
                    if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                    {
                      do {
                        out.write(__oracle_jsp_text[90]);
                        {
                          org.apache.struts.taglib.html.TextTag __jsp_taghandler_21=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag name onkeypress property style");
                          __jsp_taghandler_21.setParent(__jsp_taghandler_20);
                          __jsp_taghandler_21.setName("feserv12");
                          __jsp_taghandler_21.setOnkeypress("clearMsg(); return validEmailKey(event, this);");
                          __jsp_taghandler_21.setProperty("reEmailAddress");
                          __jsp_taghandler_21.setStyle("width: 200px");
                          __jsp_tag_starteval=__jsp_taghandler_21.doStartTag();
                          if (__jsp_taghandler_21.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_21,4);
                        }
                        out.write(__oracle_jsp_text[91]);
                      } while (__jsp_taghandler_20.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                    }
                    if (__jsp_taghandler_20.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_20,3);
                  }
                  out.write(__oracle_jsp_text[92]);
                  {
                    org.apache.struts.taglib.logic.NotEqualTag __jsp_taghandler_22=(org.apache.struts.taglib.logic.NotEqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEqualTag.class,"org.apache.struts.taglib.logic.NotEqualTag name value");
                    __jsp_taghandler_22.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_22.setName("internalUser");
                    __jsp_taghandler_22.setValue(OracleJspRuntime.toStr( EserviceRegistrationDao.USER_MODE.INTERNAL));
                    __jsp_tag_starteval=__jsp_taghandler_22.doStartTag();
                    if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                    {
                      do {
                        out.write(__oracle_jsp_text[93]);
                      } while (__jsp_taghandler_22.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                    }
                    if (__jsp_taghandler_22.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_22,3);
                  }
                  out.write(__oracle_jsp_text[94]);
                  {
                    org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_23=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name value");
                    __jsp_taghandler_23.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_23.setName("internalUser");
                    __jsp_taghandler_23.setValue(OracleJspRuntime.toStr( EserviceRegistrationDao.USER_MODE.INTERNAL));
                    __jsp_tag_starteval=__jsp_taghandler_23.doStartTag();
                    if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                    {
                      do {
                        out.write(__oracle_jsp_text[95]);
                      } while (__jsp_taghandler_23.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                    }
                    if (__jsp_taghandler_23.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_23,3);
                  }
                  out.write(__oracle_jsp_text[96]);
                  out.write(__oracle_jsp_text[97]);
                  out.write(__oracle_jsp_text[98]);
                  {
                    org.apache.struts.taglib.logic.NotEqualTag __jsp_taghandler_24=(org.apache.struts.taglib.logic.NotEqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEqualTag.class,"org.apache.struts.taglib.logic.NotEqualTag name value");
                    __jsp_taghandler_24.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_24.setName("internalUser");
                    __jsp_taghandler_24.setValue(OracleJspRuntime.toStr( EserviceRegistrationDao.USER_MODE.INTERNAL));
                    __jsp_tag_starteval=__jsp_taghandler_24.doStartTag();
                    if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                    {
                      do {
                        out.write(__oracle_jsp_text[99]);
                        {
                          org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_25=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name value");
                          __jsp_taghandler_25.setParent(__jsp_taghandler_24);
                          __jsp_taghandler_25.setName("internalUser");
                          __jsp_taghandler_25.setValue(OracleJspRuntime.toStr( EserviceRegistrationDao.USER_MODE.EXTERNAL));
                          __jsp_tag_starteval=__jsp_taghandler_25.doStartTag();
                          if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                          {
                            do {
                              out.write(__oracle_jsp_text[100]);
                              {
                                org.apache.struts.taglib.html.TextTag __jsp_taghandler_26=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onkeypress property size styleId");
                                __jsp_taghandler_26.setParent(__jsp_taghandler_25);
                                __jsp_taghandler_26.setMaxlength("10");
                                __jsp_taghandler_26.setName("feserv12");
                                __jsp_taghandler_26.setOnkeypress("clearMsg(); clearUserIdParam(); validAccountKey(event);");
                                __jsp_taghandler_26.setProperty("userInfoMod.userId");
                                __jsp_taghandler_26.setSize("20");
                                __jsp_taghandler_26.setStyleId("userInfoMod.userId");
                                __jsp_tag_starteval=__jsp_taghandler_26.doStartTag();
                                if (__jsp_taghandler_26.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_26,5);
                              }
                              out.write(__oracle_jsp_text[101]);
                            } while (__jsp_taghandler_25.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                          }
                          if (__jsp_taghandler_25.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_25,4);
                        }
                        out.write(__oracle_jsp_text[102]);
                        {
                          org.apache.struts.taglib.logic.NotEqualTag __jsp_taghandler_27=(org.apache.struts.taglib.logic.NotEqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEqualTag.class,"org.apache.struts.taglib.logic.NotEqualTag name value");
                          __jsp_taghandler_27.setParent(__jsp_taghandler_24);
                          __jsp_taghandler_27.setName("internalUser");
                          __jsp_taghandler_27.setValue(OracleJspRuntime.toStr( EserviceRegistrationDao.USER_MODE.EXTERNAL));
                          __jsp_tag_starteval=__jsp_taghandler_27.doStartTag();
                          if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                          {
                            do {
                              out.write(__oracle_jsp_text[103]);
                              {
                                org.apache.struts.taglib.html.TextTag __jsp_taghandler_28=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name property readonly size");
                                __jsp_taghandler_28.setParent(__jsp_taghandler_27);
                                __jsp_taghandler_28.setMaxlength("10");
                                __jsp_taghandler_28.setName("feserv12");
                                __jsp_taghandler_28.setProperty("userInfoMod.userId");
                                __jsp_taghandler_28.setReadonly(true);
                                __jsp_taghandler_28.setSize("20");
                                __jsp_tag_starteval=__jsp_taghandler_28.doStartTag();
                                if (__jsp_taghandler_28.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_28,5);
                              }
                              out.write(__oracle_jsp_text[104]);
                            } while (__jsp_taghandler_27.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                          }
                          if (__jsp_taghandler_27.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_27,4);
                        }
                        out.write(__oracle_jsp_text[105]);
                        {
                          org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_29=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name value");
                          __jsp_taghandler_29.setParent(__jsp_taghandler_24);
                          __jsp_taghandler_29.setName("internalUser");
                          __jsp_taghandler_29.setValue(OracleJspRuntime.toStr( EserviceRegistrationDao.USER_MODE.EXTERNAL));
                          __jsp_tag_starteval=__jsp_taghandler_29.doStartTag();
                          if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                          {
                            do {
                              out.write(__oracle_jsp_text[106]);
                            } while (__jsp_taghandler_29.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                          }
                          if (__jsp_taghandler_29.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_29,4);
                        }
                        out.write(__oracle_jsp_text[107]);
                        {
                          org.apache.struts.taglib.logic.NotEqualTag __jsp_taghandler_30=(org.apache.struts.taglib.logic.NotEqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEqualTag.class,"org.apache.struts.taglib.logic.NotEqualTag name value");
                          __jsp_taghandler_30.setParent(__jsp_taghandler_24);
                          __jsp_taghandler_30.setName("internalUser");
                          __jsp_taghandler_30.setValue(OracleJspRuntime.toStr( EserviceRegistrationDao.USER_MODE.EXTERNAL));
                          __jsp_tag_starteval=__jsp_taghandler_30.doStartTag();
                          if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                          {
                            do {
                              out.write(__oracle_jsp_text[108]);
                            } while (__jsp_taghandler_30.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                          }
                          if (__jsp_taghandler_30.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_30,4);
                        }
                        out.write(__oracle_jsp_text[109]);
                        {
                          org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_31=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name value");
                          __jsp_taghandler_31.setParent(__jsp_taghandler_24);
                          __jsp_taghandler_31.setName("internalUser");
                          __jsp_taghandler_31.setValue(OracleJspRuntime.toStr( EserviceRegistrationDao.USER_MODE.EXTERNAL));
                          __jsp_tag_starteval=__jsp_taghandler_31.doStartTag();
                          if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                          {
                            do {
                              out.write(__oracle_jsp_text[110]);
                            } while (__jsp_taghandler_31.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                          }
                          if (__jsp_taghandler_31.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_31,4);
                        }
                        out.write(__oracle_jsp_text[111]);
                        {
                          org.apache.struts.taglib.logic.NotEqualTag __jsp_taghandler_32=(org.apache.struts.taglib.logic.NotEqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEqualTag.class,"org.apache.struts.taglib.logic.NotEqualTag name value");
                          __jsp_taghandler_32.setParent(__jsp_taghandler_24);
                          __jsp_taghandler_32.setName("internalUser");
                          __jsp_taghandler_32.setValue(OracleJspRuntime.toStr( EserviceRegistrationDao.USER_MODE.EXTERNAL));
                          __jsp_tag_starteval=__jsp_taghandler_32.doStartTag();
                          if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                          {
                            do {
                              out.write(__oracle_jsp_text[112]);
                              {
                                org.apache.struts.taglib.html.PasswordTag __jsp_taghandler_33=(org.apache.struts.taglib.html.PasswordTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.PasswordTag.class,"org.apache.struts.taglib.html.PasswordTag maxlength name onblur onkeypress property size");
                                __jsp_taghandler_33.setParent(__jsp_taghandler_32);
                                __jsp_taghandler_33.setMaxlength("10");
                                __jsp_taghandler_33.setName("feserv12");
                                __jsp_taghandler_33.setOnblur("accountControl();");
                                __jsp_taghandler_33.setOnkeypress("clearMsg(); return validAccountKey(event);");
                                __jsp_taghandler_33.setProperty("oldPassword");
                                __jsp_taghandler_33.setSize("21");
                                __jsp_tag_starteval=__jsp_taghandler_33.doStartTag();
                                if (__jsp_taghandler_33.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_33,5);
                              }
                              out.write(__oracle_jsp_text[113]);
                            } while (__jsp_taghandler_32.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                          }
                          if (__jsp_taghandler_32.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_32,4);
                        }
                        out.write(__oracle_jsp_text[114]);
                        {
                          org.apache.struts.taglib.html.PasswordTag __jsp_taghandler_34=(org.apache.struts.taglib.html.PasswordTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.PasswordTag.class,"org.apache.struts.taglib.html.PasswordTag maxlength name onkeypress property size");
                          __jsp_taghandler_34.setParent(__jsp_taghandler_24);
                          __jsp_taghandler_34.setMaxlength("10");
                          __jsp_taghandler_34.setName("feserv12");
                          __jsp_taghandler_34.setOnkeypress("clearMsg(); return validAccountKey(event);");
                          __jsp_taghandler_34.setProperty("password");
                          __jsp_taghandler_34.setSize("21");
                          __jsp_tag_starteval=__jsp_taghandler_34.doStartTag();
                          if (__jsp_taghandler_34.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_34,4);
                        }
                        out.write(__oracle_jsp_text[115]);
                        {
                          org.apache.struts.taglib.html.PasswordTag __jsp_taghandler_35=(org.apache.struts.taglib.html.PasswordTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.PasswordTag.class,"org.apache.struts.taglib.html.PasswordTag maxlength name onkeypress property size");
                          __jsp_taghandler_35.setParent(__jsp_taghandler_24);
                          __jsp_taghandler_35.setMaxlength("10");
                          __jsp_taghandler_35.setName("feserv12");
                          __jsp_taghandler_35.setOnkeypress("clearMsg(); return validAccountKey(event);");
                          __jsp_taghandler_35.setProperty("rePassword");
                          __jsp_taghandler_35.setSize("21");
                          __jsp_tag_starteval=__jsp_taghandler_35.doStartTag();
                          if (__jsp_taghandler_35.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_35,4);
                        }
                        out.write(__oracle_jsp_text[116]);
                      } while (__jsp_taghandler_24.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                    }
                    if (__jsp_taghandler_24.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_24,3);
                  }
                  out.write(__oracle_jsp_text[117]);
                  out.write(__oracle_jsp_text[118]);
                  out.write(__oracle_jsp_text[119]);
                  {
                    org.apache.struts.taglib.html.TextTag __jsp_taghandler_36=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag name property readonly size styleId");
                    __jsp_taghandler_36.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_36.setName("feserv12");
                    __jsp_taghandler_36.setProperty("userInfoMod.cmpName");
                    __jsp_taghandler_36.setReadonly(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${isInternalUser}",java.lang.Boolean.class, __ojsp_varRes,null)));
                    __jsp_taghandler_36.setSize("20");
                    __jsp_taghandler_36.setStyleId("userInfoMod.cmpName");
                    __jsp_tag_starteval=__jsp_taghandler_36.doStartTag();
                    if (__jsp_taghandler_36.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_36,3);
                  }
                  out.write(__oracle_jsp_text[120]);
                  {
                    org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_37=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
                    __jsp_taghandler_37.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_37.setName("feserv12");
                    __jsp_taghandler_37.setProperty("crmErrorMsg");
                    __jsp_tag_starteval=__jsp_taghandler_37.doStartTag();
                    if (__jsp_taghandler_37.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_37,3);
                  }
                  out.write(__oracle_jsp_text[121]);
                  {
                    org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_38=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                    __jsp_taghandler_38.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_38.setName("feserv12");
                    __jsp_taghandler_38.setProperty("crmErrorMsg");
                    __jsp_tag_starteval=__jsp_taghandler_38.doStartTag();
                    if (__jsp_taghandler_38.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_38,3);
                  }
                  out.write(__oracle_jsp_text[122]);
                  {
                    org.apache.struts.taglib.html.TextTag __jsp_taghandler_39=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag name property readonly size styleId");
                    __jsp_taghandler_39.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_39.setName("feserv12");
                    __jsp_taghandler_39.setProperty("userInfoMod.address1");
                    __jsp_taghandler_39.setReadonly(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${isInternalUser}",java.lang.Boolean.class, __ojsp_varRes,null)));
                    __jsp_taghandler_39.setSize("20");
                    __jsp_taghandler_39.setStyleId("userInfoMod.address1");
                    __jsp_tag_starteval=__jsp_taghandler_39.doStartTag();
                    if (__jsp_taghandler_39.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_39,3);
                  }
                  out.write(__oracle_jsp_text[123]);
                  {
                    org.apache.struts.taglib.html.TextTag __jsp_taghandler_40=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag name property readonly size styleId");
                    __jsp_taghandler_40.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_40.setName("feserv12");
                    __jsp_taghandler_40.setProperty("userInfoMod.address2");
                    __jsp_taghandler_40.setReadonly(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${isInternalUser}",java.lang.Boolean.class, __ojsp_varRes,null)));
                    __jsp_taghandler_40.setSize("20");
                    __jsp_taghandler_40.setStyleId("userInfoMod.address2");
                    __jsp_tag_starteval=__jsp_taghandler_40.doStartTag();
                    if (__jsp_taghandler_40.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_40,3);
                  }
                  out.write(__oracle_jsp_text[124]);
                  {
                    org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_41=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name value");
                    __jsp_taghandler_41.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_41.setName("internalUser");
                    __jsp_taghandler_41.setValue(OracleJspRuntime.toStr( EserviceRegistrationDao.USER_MODE.INTERNAL));
                    __jsp_tag_starteval=__jsp_taghandler_41.doStartTag();
                    if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                    {
                      do {
                        out.write(__oracle_jsp_text[125]);
                      } while (__jsp_taghandler_41.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                    }
                    if (__jsp_taghandler_41.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_41,3);
                  }
                  out.write(__oracle_jsp_text[126]);
                  {
                    org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_42=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name value");
                    __jsp_taghandler_42.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_42.setName("internalUser");
                    __jsp_taghandler_42.setValue(OracleJspRuntime.toStr( EserviceRegistrationDao.USER_MODE.INTERNAL));
                    __jsp_tag_starteval=__jsp_taghandler_42.doStartTag();
                    if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                    {
                      do {
                        out.write(__oracle_jsp_text[127]);
                        {
                          org.apache.struts.taglib.html.TextTag __jsp_taghandler_43=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onchange onkeydown onkeypress property style styleClass styleId");
                          __jsp_taghandler_43.setParent(__jsp_taghandler_42);
                          __jsp_taghandler_43.setMaxlength("45");
                          __jsp_taghandler_43.setName("feserv12");
                          __jsp_taghandler_43.setOnchange("clearMsg(); customerControl();");
                          __jsp_taghandler_43.setOnkeydown("clearMsg(); return checkCustomerCodeKeyIn(event)");
                          __jsp_taghandler_43.setOnkeypress("clearMsg(); return checkCustomerCodeKeyIn(event)");
                          __jsp_taghandler_43.setProperty("customerCode");
                          __jsp_taghandler_43.setStyle("width:100px;");
                          __jsp_taghandler_43.setStyleClass("must");
                          __jsp_taghandler_43.setStyleId("customerCode");
                          __jsp_tag_starteval=__jsp_taghandler_43.doStartTag();
                          if (__jsp_taghandler_43.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_43,4);
                        }
                        out.write(__oracle_jsp_text[128]);
                        {
                          org.apache.struts.taglib.logic.NotEqualTag __jsp_taghandler_44=(org.apache.struts.taglib.logic.NotEqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEqualTag.class,"org.apache.struts.taglib.logic.NotEqualTag name value");
                          __jsp_taghandler_44.setParent(__jsp_taghandler_42);
                          __jsp_taghandler_44.setName("userIdViewMode");
                          __jsp_taghandler_44.setValue("true");
                          __jsp_tag_starteval=__jsp_taghandler_44.doStartTag();
                          if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                          {
                            do {
                              out.write(__oracle_jsp_text[129]);
                            } while (__jsp_taghandler_44.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                          }
                          if (__jsp_taghandler_44.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_44,4);
                        }
                        out.write(__oracle_jsp_text[130]);
                        {
                          org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_45=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name value");
                          __jsp_taghandler_45.setParent(__jsp_taghandler_42);
                          __jsp_taghandler_45.setName("userIdViewMode");
                          __jsp_taghandler_45.setValue("true");
                          __jsp_tag_starteval=__jsp_taghandler_45.doStartTag();
                          if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                          {
                            do {
                              out.write(__oracle_jsp_text[131]);
                            } while (__jsp_taghandler_45.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                          }
                          if (__jsp_taghandler_45.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_45,4);
                        }
                        out.write(__oracle_jsp_text[132]);
                      } while (__jsp_taghandler_42.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                    }
                    if (__jsp_taghandler_42.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_42,3);
                  }
                  out.write(__oracle_jsp_text[133]);
                  {
                    org.apache.struts.taglib.html.TextTag __jsp_taghandler_46=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag name onkeypress property readonly size styleId");
                    __jsp_taghandler_46.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_46.setName("feserv12");
                    __jsp_taghandler_46.setOnkeypress("clearMsg();");
                    __jsp_taghandler_46.setProperty("userInfoMod.address3");
                    __jsp_taghandler_46.setReadonly(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${isInternalUser}",java.lang.Boolean.class, __ojsp_varRes,null)));
                    __jsp_taghandler_46.setSize("20");
                    __jsp_taghandler_46.setStyleId("userInfoMod.address3");
                    __jsp_tag_starteval=__jsp_taghandler_46.doStartTag();
                    if (__jsp_taghandler_46.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_46,3);
                  }
                  out.write(__oracle_jsp_text[134]);
                  {
                    org.apache.struts.taglib.html.TextTag __jsp_taghandler_47=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag name onkeypress property readonly size styleId");
                    __jsp_taghandler_47.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_47.setName("feserv12");
                    __jsp_taghandler_47.setOnkeypress("clearMsg();");
                    __jsp_taghandler_47.setProperty("userInfoMod.address4");
                    __jsp_taghandler_47.setReadonly(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${isInternalUser}",java.lang.Boolean.class, __ojsp_varRes,null)));
                    __jsp_taghandler_47.setSize("20");
                    __jsp_taghandler_47.setStyleId("userInfoMod.address4");
                    __jsp_tag_starteval=__jsp_taghandler_47.doStartTag();
                    if (__jsp_taghandler_47.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_47,3);
                  }
                  out.write(__oracle_jsp_text[135]);
                  {
                    org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_48=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name value");
                    __jsp_taghandler_48.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_48.setName("internalUser");
                    __jsp_taghandler_48.setValue(OracleJspRuntime.toStr( EserviceRegistrationDao.USER_MODE.INTERNAL));
                    __jsp_tag_starteval=__jsp_taghandler_48.doStartTag();
                    if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                    {
                      do {
                        out.write(__oracle_jsp_text[136]);
                        out.write(__oracle_jsp_text[137]);
                        out.write(__oracle_jsp_text[138]);
                      } while (__jsp_taghandler_48.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                    }
                    if (__jsp_taghandler_48.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_48,3);
                  }
                  out.write(__oracle_jsp_text[139]);
                  {
                    org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_49=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name value");
                    __jsp_taghandler_49.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_49.setName("internalUser");
                    __jsp_taghandler_49.setValue(OracleJspRuntime.toStr( EserviceRegistrationDao.USER_MODE.INTERNAL));
                    __jsp_tag_starteval=__jsp_taghandler_49.doStartTag();
                    if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                    {
                      do {
                        out.write(__oracle_jsp_text[140]);
                        {
                          org.apache.struts.taglib.html.TextTag __jsp_taghandler_50=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag name onblur onkeypress property readonly style styleClass styleId");
                          __jsp_taghandler_50.setParent(__jsp_taghandler_49);
                          __jsp_taghandler_50.setName("feserv12");
                          __jsp_taghandler_50.setOnblur("changeUpper(this)");
                          __jsp_taghandler_50.setOnkeypress("clearMsg();");
                          __jsp_taghandler_50.setProperty("customerFscCode");
                          __jsp_taghandler_50.setReadonly(true);
                          __jsp_taghandler_50.setStyle("width:100px;");
                          __jsp_taghandler_50.setStyleClass("must");
                          __jsp_taghandler_50.setStyleId("customerFscCode");
                          __jsp_tag_starteval=__jsp_taghandler_50.doStartTag();
                          if (__jsp_taghandler_50.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_50,4);
                        }
                        out.write(__oracle_jsp_text[141]);
                        {
                          org.apache.struts.taglib.logic.NotEqualTag __jsp_taghandler_51=(org.apache.struts.taglib.logic.NotEqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEqualTag.class,"org.apache.struts.taglib.logic.NotEqualTag name value");
                          __jsp_taghandler_51.setParent(__jsp_taghandler_49);
                          __jsp_taghandler_51.setName("userIdViewMode");
                          __jsp_taghandler_51.setValue("true");
                          __jsp_tag_starteval=__jsp_taghandler_51.doStartTag();
                          if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                          {
                            do {
                              out.write(__oracle_jsp_text[142]);
                              {
                                org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_52=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                                __jsp_taghandler_52.setParent(__jsp_taghandler_51);
                                __jsp_taghandler_52.setName("feserv12");
                                __jsp_taghandler_52.setProperty("userInfoMod.country");
                                __jsp_tag_starteval=__jsp_taghandler_52.doStartTag();
                                if (__jsp_taghandler_52.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_52,5);
                              }
                              out.write(__oracle_jsp_text[143]);
                            } while (__jsp_taghandler_51.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                          }
                          if (__jsp_taghandler_51.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_51,4);
                        }
                        out.write(__oracle_jsp_text[144]);
                        {
                          org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_53=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name value");
                          __jsp_taghandler_53.setParent(__jsp_taghandler_49);
                          __jsp_taghandler_53.setName("userIdViewMode");
                          __jsp_taghandler_53.setValue("true");
                          __jsp_tag_starteval=__jsp_taghandler_53.doStartTag();
                          if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                          {
                            do {
                              out.write(__oracle_jsp_text[145]);
                            } while (__jsp_taghandler_53.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                          }
                          if (__jsp_taghandler_53.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_53,4);
                        }
                        out.write(__oracle_jsp_text[146]);
                      } while (__jsp_taghandler_49.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                    }
                    if (__jsp_taghandler_49.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_49,3);
                  }
                  out.write(__oracle_jsp_text[147]);
                  {
                    org.apache.struts.taglib.html.TextTag __jsp_taghandler_54=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag name onkeypress property readonly size styleId");
                    __jsp_taghandler_54.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_54.setName("feserv12");
                    __jsp_taghandler_54.setOnkeypress("clearMsg();");
                    __jsp_taghandler_54.setProperty("userInfoMod.city");
                    __jsp_taghandler_54.setReadonly(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${isInternalUser}",java.lang.Boolean.class, __ojsp_varRes,null)));
                    __jsp_taghandler_54.setSize("20");
                    __jsp_taghandler_54.setStyleId("userInfoMod.city");
                    __jsp_tag_starteval=__jsp_taghandler_54.doStartTag();
                    if (__jsp_taghandler_54.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_54,3);
                  }
                  out.write(__oracle_jsp_text[148]);
                  {
                    org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_55=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name value");
                    __jsp_taghandler_55.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_55.setName("internalUser");
                    __jsp_taghandler_55.setValue(OracleJspRuntime.toStr( EserviceRegistrationDao.USER_MODE.INTERNAL));
                    __jsp_tag_starteval=__jsp_taghandler_55.doStartTag();
                    if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                    {
                      do {
                        out.write(__oracle_jsp_text[149]);
                        out.write(__oracle_jsp_text[150]);
                        out.write(__oracle_jsp_text[151]);
                      } while (__jsp_taghandler_55.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                    }
                    if (__jsp_taghandler_55.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_55,3);
                  }
                  out.write(__oracle_jsp_text[152]);
                  {
                    org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_56=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name value");
                    __jsp_taghandler_56.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_56.setName("internalUser");
                    __jsp_taghandler_56.setValue(OracleJspRuntime.toStr( EserviceRegistrationDao.USER_MODE.INTERNAL));
                    __jsp_tag_starteval=__jsp_taghandler_56.doStartTag();
                    if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                    {
                      do {
                        out.write(__oracle_jsp_text[153]);
                        {
                          org.apache.struts.taglib.html.TextTag __jsp_taghandler_57=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag name onblur onkeypress property readonly style styleClass styleId");
                          __jsp_taghandler_57.setParent(__jsp_taghandler_56);
                          __jsp_taghandler_57.setName("feserv12");
                          __jsp_taghandler_57.setOnblur("changeUpper(this)");
                          __jsp_taghandler_57.setOnkeypress("clearMsg();");
                          __jsp_taghandler_57.setProperty("customerType");
                          __jsp_taghandler_57.setReadonly(true);
                          __jsp_taghandler_57.setStyle("width:100px;");
                          __jsp_taghandler_57.setStyleClass("must");
                          __jsp_taghandler_57.setStyleId("customerType");
                          __jsp_tag_starteval=__jsp_taghandler_57.doStartTag();
                          if (__jsp_taghandler_57.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_57,4);
                        }
                        out.write(__oracle_jsp_text[154]);
                        {
                          org.apache.struts.taglib.logic.NotEqualTag __jsp_taghandler_58=(org.apache.struts.taglib.logic.NotEqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEqualTag.class,"org.apache.struts.taglib.logic.NotEqualTag name value");
                          __jsp_taghandler_58.setParent(__jsp_taghandler_56);
                          __jsp_taghandler_58.setName("userIdViewMode");
                          __jsp_taghandler_58.setValue("true");
                          __jsp_tag_starteval=__jsp_taghandler_58.doStartTag();
                          if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                          {
                            do {
                              out.write(__oracle_jsp_text[155]);
                            } while (__jsp_taghandler_58.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                          }
                          if (__jsp_taghandler_58.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_58,4);
                        }
                        out.write(__oracle_jsp_text[156]);
                        {
                          org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_59=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name value");
                          __jsp_taghandler_59.setParent(__jsp_taghandler_56);
                          __jsp_taghandler_59.setName("userIdViewMode");
                          __jsp_taghandler_59.setValue("true");
                          __jsp_tag_starteval=__jsp_taghandler_59.doStartTag();
                          if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                          {
                            do {
                              out.write(__oracle_jsp_text[157]);
                            } while (__jsp_taghandler_59.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                          }
                          if (__jsp_taghandler_59.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_59,4);
                        }
                        out.write(__oracle_jsp_text[158]);
                      } while (__jsp_taghandler_56.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                    }
                    if (__jsp_taghandler_56.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_56,3);
                  }
                  out.write(__oracle_jsp_text[159]);
                  {
                    org.apache.struts.taglib.html.TextTag __jsp_taghandler_60=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur onkeypress property readonly size styleId");
                    __jsp_taghandler_60.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_60.setMaxlength("2");
                    __jsp_taghandler_60.setName("feserv12");
                    __jsp_taghandler_60.setOnblur("lp_upperCase(this);");
                    __jsp_taghandler_60.setOnkeypress("clearMsg();");
                    __jsp_taghandler_60.setProperty("userInfoMod.state");
                    __jsp_taghandler_60.setReadonly(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${isInternalUser}",java.lang.Boolean.class, __ojsp_varRes,null)));
                    __jsp_taghandler_60.setSize("20");
                    __jsp_taghandler_60.setStyleId("userInfoMod.state");
                    __jsp_tag_starteval=__jsp_taghandler_60.doStartTag();
                    if (__jsp_taghandler_60.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_60,3);
                  }
                  out.write(__oracle_jsp_text[160]);
                  {
                    org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_61=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name value");
                    __jsp_taghandler_61.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_61.setName("internalUser");
                    __jsp_taghandler_61.setValue(OracleJspRuntime.toStr( EserviceRegistrationDao.USER_MODE.INTERNAL));
                    __jsp_tag_starteval=__jsp_taghandler_61.doStartTag();
                    if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                    {
                      do {
                        out.write(__oracle_jsp_text[161]);
                      } while (__jsp_taghandler_61.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                    }
                    if (__jsp_taghandler_61.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_61,3);
                  }
                  out.write(__oracle_jsp_text[162]);
                  {
                    org.apache.struts.taglib.html.SelectTag __jsp_taghandler_62=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag disabled name onclick property");
                    __jsp_taghandler_62.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_62.setDisabled(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${isInternalUser}",java.lang.Boolean.class, __ojsp_varRes,null)));
                    __jsp_taghandler_62.setName("feserv12");
                    __jsp_taghandler_62.setOnclick("clearMsg();");
                    __jsp_taghandler_62.setProperty("userInfoMod.country");
                    __jsp_tag_starteval=__jsp_taghandler_62.doStartTag();
                    if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                    {
                      out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_62,__jsp_tag_starteval,out);
                      do {
                        out.write(__oracle_jsp_text[163]);
                        {
                          org.apache.struts.taglib.html.OptionsCollectionTag __jsp_taghandler_63=(org.apache.struts.taglib.html.OptionsCollectionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionsCollectionTag.class,"org.apache.struts.taglib.html.OptionsCollectionTag label name property value");
                          __jsp_taghandler_63.setParent(__jsp_taghandler_62);
                          __jsp_taghandler_63.setLabel("name");
                          __jsp_taghandler_63.setName("feserv12");
                          __jsp_taghandler_63.setProperty("countryList");
                          __jsp_taghandler_63.setValue("code");
                          __jsp_tag_starteval=__jsp_taghandler_63.doStartTag();
                          if (__jsp_taghandler_63.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_63,4);
                        }
                        out.write(__oracle_jsp_text[164]);
                      } while (__jsp_taghandler_62.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                      out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                    }
                    if (__jsp_taghandler_62.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_62,3);
                  }
                  out.write(__oracle_jsp_text[165]);
                  {
                    org.apache.struts.taglib.html.TextTag __jsp_taghandler_64=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onkeypress property readonly size styleId");
                    __jsp_taghandler_64.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_64.setMaxlength("17");
                    __jsp_taghandler_64.setName("feserv12");
                    __jsp_taghandler_64.setOnkeypress("clearMsg(); return validNumberKey(event);");
                    __jsp_taghandler_64.setProperty("userInfoMod.phoneNo");
                    __jsp_taghandler_64.setReadonly(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${isInternalUser}",java.lang.Boolean.class, __ojsp_varRes,null)));
                    __jsp_taghandler_64.setSize("20");
                    __jsp_taghandler_64.setStyleId("userInfoMod.phoneNo");
                    __jsp_tag_starteval=__jsp_taghandler_64.doStartTag();
                    if (__jsp_taghandler_64.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_64,3);
                  }
                  out.write(__oracle_jsp_text[166]);
                  {
                    org.apache.struts.taglib.html.TextTag __jsp_taghandler_65=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onkeypress property readonly size styleId");
                    __jsp_taghandler_65.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_65.setMaxlength("9");
                    __jsp_taghandler_65.setName("feserv12");
                    __jsp_taghandler_65.setOnkeypress("clearMsg(); return validNumberKey(event);");
                    __jsp_taghandler_65.setProperty("userInfoMod.faxNo");
                    __jsp_taghandler_65.setReadonly(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${isInternalUser}",java.lang.Boolean.class, __ojsp_varRes,null)));
                    __jsp_taghandler_65.setSize("20");
                    __jsp_taghandler_65.setStyleId("userInfoMod.faxNo");
                    __jsp_tag_starteval=__jsp_taghandler_65.doStartTag();
                    if (__jsp_taghandler_65.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_65,3);
                  }
                  out.write(__oracle_jsp_text[167]);
                  {
                    org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_66=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name value");
                    __jsp_taghandler_66.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_66.setName("internalUser");
                    __jsp_taghandler_66.setValue(OracleJspRuntime.toStr( EserviceRegistrationDao.USER_MODE.EXTERNAL));
                    __jsp_tag_starteval=__jsp_taghandler_66.doStartTag();
                    if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                    {
                      do {
                        out.write(__oracle_jsp_text[168]);
                        {
                          org.apache.struts.taglib.html.MultiboxTag __jsp_taghandler_67=(org.apache.struts.taglib.html.MultiboxTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.MultiboxTag.class,"org.apache.struts.taglib.html.MultiboxTag name onclick property style styleId value");
                          __jsp_taghandler_67.setParent(__jsp_taghandler_66);
                          __jsp_taghandler_67.setName("feserv12");
                          __jsp_taghandler_67.setOnclick("lp_chkRepresentedCompanyFlag();");
                          __jsp_taghandler_67.setProperty("representedCompanyFlag");
                          __jsp_taghandler_67.setStyle("border:0px;width:10%;position:relative;left:-27px;");
                          __jsp_taghandler_67.setStyleId("representedCompanyFlag");
                          __jsp_taghandler_67.setValue("Y");
                          __jsp_tag_starteval=__jsp_taghandler_67.doStartTag();
                          if (__jsp_taghandler_67.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_67,4);
                        }
                        out.write(__oracle_jsp_text[169]);
                      } while (__jsp_taghandler_66.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                    }
                    if (__jsp_taghandler_66.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_66,3);
                  }
                  out.write(__oracle_jsp_text[170]);
                  {
                    org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_68=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name value");
                    __jsp_taghandler_68.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_68.setName("internalUser");
                    __jsp_taghandler_68.setValue(OracleJspRuntime.toStr( EserviceRegistrationDao.USER_MODE.INTERNAL));
                    __jsp_tag_starteval=__jsp_taghandler_68.doStartTag();
                    if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                    {
                      do {
                        out.write(__oracle_jsp_text[171]);
                        {
                          org.apache.struts.taglib.html.MultiboxTag __jsp_taghandler_69=(org.apache.struts.taglib.html.MultiboxTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.MultiboxTag.class,"org.apache.struts.taglib.html.MultiboxTag disabled name property style styleId value");
                          __jsp_taghandler_69.setParent(__jsp_taghandler_68);
                          __jsp_taghandler_69.setDisabled(true);
                          __jsp_taghandler_69.setName("feserv12");
                          __jsp_taghandler_69.setProperty("representedCompanyFlag");
                          __jsp_taghandler_69.setStyle("border:0px;width:10%;position:relative;left:-27px;");
                          __jsp_taghandler_69.setStyleId("representedCompanyFlag");
                          __jsp_taghandler_69.setValue("Y");
                          __jsp_tag_starteval=__jsp_taghandler_69.doStartTag();
                          if (__jsp_taghandler_69.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_69,4);
                        }
                        out.write(__oracle_jsp_text[172]);
                      } while (__jsp_taghandler_68.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                    }
                    if (__jsp_taghandler_68.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_68,3);
                  }
                  out.write(__oracle_jsp_text[173]);
                  {
                    org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_70=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name value");
                    __jsp_taghandler_70.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_70.setName("internalUser");
                    __jsp_taghandler_70.setValue(OracleJspRuntime.toStr( EserviceRegistrationDao.USER_MODE.INTERNAL_MRES));
                    __jsp_tag_starteval=__jsp_taghandler_70.doStartTag();
                    if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                    {
                      do {
                        out.write(__oracle_jsp_text[174]);
                        {
                          org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_71=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name property value");
                          __jsp_taghandler_71.setParent(__jsp_taghandler_70);
                          __jsp_taghandler_71.setName("feserv12");
                          __jsp_taghandler_71.setProperty("representedCompanyFlag");
                          __jsp_taghandler_71.setValue("Y");
                          __jsp_tag_starteval=__jsp_taghandler_71.doStartTag();
                          if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                          {
                            do {
                              out.write(__oracle_jsp_text[175]);
                              {
                                org.apache.struts.taglib.html.MultiboxTag __jsp_taghandler_72=(org.apache.struts.taglib.html.MultiboxTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.MultiboxTag.class,"org.apache.struts.taglib.html.MultiboxTag disabled name property style styleId value");
                                __jsp_taghandler_72.setParent(__jsp_taghandler_71);
                                __jsp_taghandler_72.setDisabled(true);
                                __jsp_taghandler_72.setName("feserv12");
                                __jsp_taghandler_72.setProperty("representedCompanyFlag");
                                __jsp_taghandler_72.setStyle("border:0px;width:10%;position:relative;left:-27px;");
                                __jsp_taghandler_72.setStyleId("representedCompanyFlag");
                                __jsp_taghandler_72.setValue("Y");
                                __jsp_tag_starteval=__jsp_taghandler_72.doStartTag();
                                if (__jsp_taghandler_72.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_72,5);
                              }
                              out.write(__oracle_jsp_text[176]);
                            } while (__jsp_taghandler_71.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                          }
                          if (__jsp_taghandler_71.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_71,4);
                        }
                        out.write(__oracle_jsp_text[177]);
                        {
                          org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_73=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name property value");
                          __jsp_taghandler_73.setParent(__jsp_taghandler_70);
                          __jsp_taghandler_73.setName("feserv12");
                          __jsp_taghandler_73.setProperty("representedCompanyFlag");
                          __jsp_taghandler_73.setValue("N");
                          __jsp_tag_starteval=__jsp_taghandler_73.doStartTag();
                          if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                          {
                            do {
                              out.write(__oracle_jsp_text[178]);
                              {
                                org.apache.struts.taglib.html.MultiboxTag __jsp_taghandler_74=(org.apache.struts.taglib.html.MultiboxTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.MultiboxTag.class,"org.apache.struts.taglib.html.MultiboxTag name onclick property style styleId value");
                                __jsp_taghandler_74.setParent(__jsp_taghandler_73);
                                __jsp_taghandler_74.setName("feserv12");
                                __jsp_taghandler_74.setOnclick("lp_chkRepresentedCompanyFlag();");
                                __jsp_taghandler_74.setProperty("representedCompanyFlag");
                                __jsp_taghandler_74.setStyle("border:0px;width:10%;position:relative;left:-27px;");
                                __jsp_taghandler_74.setStyleId("representedCompanyFlag");
                                __jsp_taghandler_74.setValue("Y");
                                __jsp_tag_starteval=__jsp_taghandler_74.doStartTag();
                                if (__jsp_taghandler_74.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_74,5);
                              }
                              out.write(__oracle_jsp_text[179]);
                            } while (__jsp_taghandler_73.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                          }
                          if (__jsp_taghandler_73.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_73,4);
                        }
                        out.write(__oracle_jsp_text[180]);
                      } while (__jsp_taghandler_70.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                    }
                    if (__jsp_taghandler_70.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_70,3);
                  }
                  out.write(__oracle_jsp_text[181]);
                  out.write(__oracle_jsp_text[182]);
                  {
                    org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_75=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name value");
                    __jsp_taghandler_75.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_75.setName("internalUser");
                    __jsp_taghandler_75.setValue(OracleJspRuntime.toStr( EserviceRegistrationDao.USER_MODE.EXTERNAL));
                    __jsp_tag_starteval=__jsp_taghandler_75.doStartTag();
                    if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                    {
                      do {
                        out.write(__oracle_jsp_text[183]);
                        {
                          org.apache.struts.taglib.logic.IterateTag __jsp_taghandler_76=(org.apache.struts.taglib.logic.IterateTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.IterateTag.class,"org.apache.struts.taglib.logic.IterateTag id indexId name property type");
                          __jsp_taghandler_76.setParent(__jsp_taghandler_75);
                          __jsp_taghandler_76.setId("rowdata");
                          __jsp_taghandler_76.setIndexId("ctr");
                          __jsp_taghandler_76.setName("feserv12");
                          __jsp_taghandler_76.setProperty("contractPartyList");
                          __jsp_taghandler_76.setType("com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceContractPartyPortPairMod");
                          com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceContractPartyPortPairMod rowdata = null;
                          java.lang.Integer ctr = null;
                          __jsp_tag_starteval=__jsp_taghandler_76.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_76,__jsp_tag_starteval,out);
                            do {
                              rowdata = (com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceContractPartyPortPairMod) pageContext.findAttribute("rowdata");
                              ctr = (java.lang.Integer) pageContext.findAttribute("ctr");
                              out.write(__oracle_jsp_text[184]);
                              {
                                org.apache.struts.taglib.logic.NotEqualTag __jsp_taghandler_77=(org.apache.struts.taglib.logic.NotEqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEqualTag.class,"org.apache.struts.taglib.logic.NotEqualTag name property value");
                                __jsp_taghandler_77.setParent(__jsp_taghandler_76);
                                __jsp_taghandler_77.setName("rowdata");
                                __jsp_taghandler_77.setProperty("statusFlag");
                                __jsp_taghandler_77.setValue(OracleJspRuntime.toStr( EserviceRegistrationDao.DEL));
                                __jsp_tag_starteval=__jsp_taghandler_77.doStartTag();
                                if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                {
                                  do {
                                    out.write(__oracle_jsp_text[185]);
                                    {
                                      org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_78=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
                                      __jsp_taghandler_78.setParent(__jsp_taghandler_77);
                                      __jsp_taghandler_78.setName("rowdata");
                                      __jsp_taghandler_78.setProperty("fkContractPartyCode");
                                      __jsp_tag_starteval=__jsp_taghandler_78.doStartTag();
                                      if (__jsp_taghandler_78.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_78,6);
                                    }
                                    out.write(__oracle_jsp_text[186]);
                                    {
                                      org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_79=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
                                      __jsp_taghandler_79.setParent(__jsp_taghandler_77);
                                      __jsp_taghandler_79.setName("rowdata");
                                      __jsp_taghandler_79.setProperty("pkPortPairSeq");
                                      __jsp_tag_starteval=__jsp_taghandler_79.doStartTag();
                                      if (__jsp_taghandler_79.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_79,6);
                                    }
                                    out.write(__oracle_jsp_text[187]);
                                    {
                                      org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_80=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
                                      __jsp_taghandler_80.setParent(__jsp_taghandler_77);
                                      __jsp_taghandler_80.setName("rowdata");
                                      __jsp_taghandler_80.setProperty("statusFlag");
                                      __jsp_tag_starteval=__jsp_taghandler_80.doStartTag();
                                      if (__jsp_taghandler_80.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_80,6);
                                    }
                                    out.write(__oracle_jsp_text[188]);
                                    {
                                      org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_81=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
                                      __jsp_taghandler_81.setParent(__jsp_taghandler_77);
                                      __jsp_taghandler_81.setName("rowdata");
                                      __jsp_taghandler_81.setProperty("recStatus");
                                      __jsp_tag_starteval=__jsp_taghandler_81.doStartTag();
                                      if (__jsp_taghandler_81.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_81,6);
                                    }
                                    out.write(__oracle_jsp_text[189]);
                                    {
                                      org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_82=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
                                      __jsp_taghandler_82.setParent(__jsp_taghandler_77);
                                      __jsp_taghandler_82.setName("rowdata");
                                      __jsp_taghandler_82.setProperty("recStatusDesc");
                                      __jsp_tag_starteval=__jsp_taghandler_82.doStartTag();
                                      if (__jsp_taghandler_82.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_82,6);
                                    }
                                    out.write(__oracle_jsp_text[190]);
                                    {
                                      org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_83=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
                                      __jsp_taghandler_83.setParent(__jsp_taghandler_77);
                                      __jsp_taghandler_83.setName("rowdata");
                                      __jsp_taghandler_83.setProperty("approveFlag");
                                      __jsp_tag_starteval=__jsp_taghandler_83.doStartTag();
                                      if (__jsp_taghandler_83.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_83,6);
                                    }
                                    out.write(__oracle_jsp_text[191]);
                                    {
                                      org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_84=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
                                      __jsp_taghandler_84.setParent(__jsp_taghandler_77);
                                      __jsp_taghandler_84.setName("rowdata");
                                      __jsp_taghandler_84.setProperty("contractPartyFscCode");
                                      __jsp_tag_starteval=__jsp_taghandler_84.doStartTag();
                                      if (__jsp_taghandler_84.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_84,6);
                                    }
                                    out.write(__oracle_jsp_text[192]);
                                    {
                                      org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_85=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
                                      __jsp_taghandler_85.setParent(__jsp_taghandler_77);
                                      __jsp_taghandler_85.setName("rowdata");
                                      __jsp_taghandler_85.setProperty("contractPartyType");
                                      __jsp_tag_starteval=__jsp_taghandler_85.doStartTag();
                                      if (__jsp_taghandler_85.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_85,6);
                                    }
                                    out.write(__oracle_jsp_text[193]);
                                    {
                                      org.apache.struts.taglib.html.TextTag __jsp_taghandler_86=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onblur property style");
                                      __jsp_taghandler_86.setParent(__jsp_taghandler_77);
                                      __jsp_taghandler_86.setMaxlength("45");
                                      __jsp_taghandler_86.setName("rowdata");
                                      __jsp_taghandler_86.setOnblur("lp_updContractCompany(this);");
                                      __jsp_taghandler_86.setProperty("contractPartyName");
                                      __jsp_taghandler_86.setStyle("width:500px;");
                                      __jsp_tag_starteval=__jsp_taghandler_86.doStartTag();
                                      if (__jsp_taghandler_86.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_86,6);
                                    }
                                    out.write(__oracle_jsp_text[194]);
                                    out.print(contextPath);
                                    out.write(__oracle_jsp_text[195]);
                                  } while (__jsp_taghandler_77.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                }
                                if (__jsp_taghandler_77.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_77,5);
                              }
                              out.write(__oracle_jsp_text[196]);
                            } while (__jsp_taghandler_76.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_76.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_76,4);
                        }
                        out.write(__oracle_jsp_text[197]);
                      } while (__jsp_taghandler_75.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                    }
                    if (__jsp_taghandler_75.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_75,3);
                  }
                  out.write(__oracle_jsp_text[198]);
                  {
                    org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_87=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name value");
                    __jsp_taghandler_87.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_87.setName("internalUser");
                    __jsp_taghandler_87.setValue(OracleJspRuntime.toStr( EserviceRegistrationDao.USER_MODE.INTERNAL));
                    __jsp_tag_starteval=__jsp_taghandler_87.doStartTag();
                    if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                    {
                      do {
                        out.write(__oracle_jsp_text[199]);
                        {
                          org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_88=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name property value");
                          __jsp_taghandler_88.setParent(__jsp_taghandler_87);
                          __jsp_taghandler_88.setName("feserv12");
                          __jsp_taghandler_88.setProperty("representedCompanyFlag");
                          __jsp_taghandler_88.setValue("Y");
                          __jsp_tag_starteval=__jsp_taghandler_88.doStartTag();
                          if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                          {
                            do {
                              out.write(__oracle_jsp_text[200]);
                              {
                                org.apache.struts.taglib.logic.IterateTag __jsp_taghandler_89=(org.apache.struts.taglib.logic.IterateTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.IterateTag.class,"org.apache.struts.taglib.logic.IterateTag id indexId name property type");
                                __jsp_taghandler_89.setParent(__jsp_taghandler_88);
                                __jsp_taghandler_89.setId("rowdata");
                                __jsp_taghandler_89.setIndexId("ctr");
                                __jsp_taghandler_89.setName("feserv12");
                                __jsp_taghandler_89.setProperty("contractPartyList");
                                __jsp_taghandler_89.setType("com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceContractPartyPortPairMod");
                                com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceContractPartyPortPairMod rowdata = null;
                                java.lang.Integer ctr = null;
                                __jsp_tag_starteval=__jsp_taghandler_89.doStartTag();
                                if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                                {
                                  out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_89,__jsp_tag_starteval,out);
                                  do {
                                    rowdata = (com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceContractPartyPortPairMod) pageContext.findAttribute("rowdata");
                                    ctr = (java.lang.Integer) pageContext.findAttribute("ctr");
                                    out.write(__oracle_jsp_text[201]);
                                    {
                                      org.apache.struts.taglib.logic.NotEqualTag __jsp_taghandler_90=(org.apache.struts.taglib.logic.NotEqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEqualTag.class,"org.apache.struts.taglib.logic.NotEqualTag name property value");
                                      __jsp_taghandler_90.setParent(__jsp_taghandler_89);
                                      __jsp_taghandler_90.setName("rowdata");
                                      __jsp_taghandler_90.setProperty("statusFlag");
                                      __jsp_taghandler_90.setValue(OracleJspRuntime.toStr( EserviceRegistrationDao.DEL));
                                      __jsp_tag_starteval=__jsp_taghandler_90.doStartTag();
                                      if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                      {
                                        do {
                                          out.write(__oracle_jsp_text[202]);
                                          {
                                            org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_91=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
                                            __jsp_taghandler_91.setParent(__jsp_taghandler_90);
                                            __jsp_taghandler_91.setName("rowdata");
                                            __jsp_taghandler_91.setProperty("pkPortPairSeq");
                                            __jsp_tag_starteval=__jsp_taghandler_91.doStartTag();
                                            if (__jsp_taghandler_91.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                              return;
                                            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_91,7);
                                          }
                                          out.write(__oracle_jsp_text[203]);
                                          {
                                            org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_92=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
                                            __jsp_taghandler_92.setParent(__jsp_taghandler_90);
                                            __jsp_taghandler_92.setName("rowdata");
                                            __jsp_taghandler_92.setProperty("statusFlag");
                                            __jsp_tag_starteval=__jsp_taghandler_92.doStartTag();
                                            if (__jsp_taghandler_92.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                              return;
                                            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_92,7);
                                          }
                                          out.write(__oracle_jsp_text[204]);
                                          {
                                            org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_93=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
                                            __jsp_taghandler_93.setParent(__jsp_taghandler_90);
                                            __jsp_taghandler_93.setName("rowdata");
                                            __jsp_taghandler_93.setProperty("recStatus");
                                            __jsp_tag_starteval=__jsp_taghandler_93.doStartTag();
                                            if (__jsp_taghandler_93.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                              return;
                                            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_93,7);
                                          }
                                          out.write(__oracle_jsp_text[205]);
                                          {
                                            org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_94=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
                                            __jsp_taghandler_94.setParent(__jsp_taghandler_90);
                                            __jsp_taghandler_94.setName("rowdata");
                                            __jsp_taghandler_94.setProperty("recStatusDesc");
                                            __jsp_tag_starteval=__jsp_taghandler_94.doStartTag();
                                            if (__jsp_taghandler_94.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                              return;
                                            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_94,7);
                                          }
                                          out.write(__oracle_jsp_text[206]);
                                          {
                                            org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_95=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
                                            __jsp_taghandler_95.setParent(__jsp_taghandler_90);
                                            __jsp_taghandler_95.setName("rowdata");
                                            __jsp_taghandler_95.setProperty("contractPartyName");
                                            __jsp_tag_starteval=__jsp_taghandler_95.doStartTag();
                                            if (__jsp_taghandler_95.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                              return;
                                            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_95,7);
                                          }
                                          out.write(__oracle_jsp_text[207]);
                                          {
                                            org.apache.struts.taglib.html.TextTag __jsp_taghandler_96=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag disabled maxlength name property style");
                                            __jsp_taghandler_96.setParent(__jsp_taghandler_90);
                                            __jsp_taghandler_96.setDisabled(true);
                                            __jsp_taghandler_96.setMaxlength("45");
                                            __jsp_taghandler_96.setName("rowdata");
                                            __jsp_taghandler_96.setProperty("contractPartyNameDisabled");
                                            __jsp_taghandler_96.setStyle("width:400px;");
                                            __jsp_tag_starteval=__jsp_taghandler_96.doStartTag();
                                            if (__jsp_taghandler_96.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                              return;
                                            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_96,7);
                                          }
                                          out.write(__oracle_jsp_text[208]);
                                          {
                                            org.apache.struts.taglib.html.MultiboxTag __jsp_taghandler_97=(org.apache.struts.taglib.html.MultiboxTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.MultiboxTag.class,"org.apache.struts.taglib.html.MultiboxTag name onclick property styleClass value");
                                            __jsp_taghandler_97.setParent(__jsp_taghandler_90);
                                            __jsp_taghandler_97.setName("rowdata");
                                            __jsp_taghandler_97.setOnclick((java.lang.String) ("lp_updContractCompany("+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${ctr}",java.lang.String.class, __ojsp_varRes, null)+");"));
                                            __jsp_taghandler_97.setProperty("approveFlag");
                                            __jsp_taghandler_97.setStyleClass("check_box_style");
                                            __jsp_taghandler_97.setValue("Y");
                                            __jsp_tag_starteval=__jsp_taghandler_97.doStartTag();
                                            if (__jsp_taghandler_97.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                              return;
                                            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_97,7);
                                          }
                                          out.write(__oracle_jsp_text[209]);
                                          out.print(ctr);
                                          out.write(__oracle_jsp_text[210]);
                                          {
                                            org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_98=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
                                            __jsp_taghandler_98.setParent(__jsp_taghandler_90);
                                            __jsp_taghandler_98.setName("rowdata");
                                            __jsp_taghandler_98.setProperty("errCrmDesc");
                                            __jsp_tag_starteval=__jsp_taghandler_98.doStartTag();
                                            if (__jsp_taghandler_98.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                              return;
                                            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_98,7);
                                          }
                                          out.write(__oracle_jsp_text[211]);
                                          out.print(ctr);
                                          out.write(__oracle_jsp_text[212]);
                                          {
                                            org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_99=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                                            __jsp_taghandler_99.setParent(__jsp_taghandler_90);
                                            __jsp_taghandler_99.setName("rowdata");
                                            __jsp_taghandler_99.setProperty("errCrmDesc");
                                            __jsp_tag_starteval=__jsp_taghandler_99.doStartTag();
                                            if (__jsp_taghandler_99.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                              return;
                                            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_99,7);
                                          }
                                          out.write(__oracle_jsp_text[213]);
                                          {
                                            org.apache.struts.taglib.html.TextTag __jsp_taghandler_100=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength name onchange onkeydown onkeypress property size styleClass");
                                            __jsp_taghandler_100.setParent(__jsp_taghandler_90);
                                            __jsp_taghandler_100.setMaxlength("45");
                                            __jsp_taghandler_100.setName("rowdata");
                                            __jsp_taghandler_100.setOnchange((java.lang.String) ("clearMsgForContractParty("+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${ctr}",java.lang.String.class, __ojsp_varRes, null)+"); lp_updContractCompany("+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${ctr}",java.lang.String.class, __ojsp_varRes, null)+");"));
                                            __jsp_taghandler_100.setOnkeydown((java.lang.String) ("clearMsgForContractParty("+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${ctr}",java.lang.String.class, __ojsp_varRes, null)+"); return checkCustomerCodeKeyIn(event)"));
                                            __jsp_taghandler_100.setOnkeypress((java.lang.String) ("clearMsgForContractParty("+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${ctr}",java.lang.String.class, __ojsp_varRes, null)+"); return checkCustomerCodeKeyIn(event)"));
                                            __jsp_taghandler_100.setProperty("fkContractPartyCode");
                                            __jsp_taghandler_100.setSize("20");
                                            __jsp_taghandler_100.setStyleClass("must");
                                            __jsp_tag_starteval=__jsp_taghandler_100.doStartTag();
                                            if (__jsp_taghandler_100.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                              return;
                                            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_100,7);
                                          }
                                          out.write(__oracle_jsp_text[214]);
                                          out.print(ctr);
                                          out.write(__oracle_jsp_text[215]);
                                          out.print(ctr);
                                          out.write(__oracle_jsp_text[216]);
                                          {
                                            org.apache.struts.taglib.html.TextTag __jsp_taghandler_101=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag name onblur onkeypress property readonly style styleClass");
                                            __jsp_taghandler_101.setParent(__jsp_taghandler_90);
                                            __jsp_taghandler_101.setName("rowdata");
                                            __jsp_taghandler_101.setOnblur("changeUpper(this)");
                                            __jsp_taghandler_101.setOnkeypress((java.lang.String) ("clearMsgForContractParty("+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${ctr}",java.lang.String.class, __ojsp_varRes, null)+");"));
                                            __jsp_taghandler_101.setProperty("contractPartyFscCode");
                                            __jsp_taghandler_101.setReadonly(true);
                                            __jsp_taghandler_101.setStyle("width:100px;");
                                            __jsp_taghandler_101.setStyleClass("must");
                                            __jsp_tag_starteval=__jsp_taghandler_101.doStartTag();
                                            if (__jsp_taghandler_101.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                              return;
                                            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_101,7);
                                          }
                                          out.write(__oracle_jsp_text[217]);
                                          out.print(ctr);
                                          out.write(__oracle_jsp_text[218]);
                                          out.print(ctr);
                                          out.write(__oracle_jsp_text[219]);
                                          {
                                            org.apache.struts.taglib.html.TextTag __jsp_taghandler_102=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag name onblur onkeypress property readonly style styleClass");
                                            __jsp_taghandler_102.setParent(__jsp_taghandler_90);
                                            __jsp_taghandler_102.setName("rowdata");
                                            __jsp_taghandler_102.setOnblur("changeUpper(this)");
                                            __jsp_taghandler_102.setOnkeypress((java.lang.String) ("clearMsgForContractParty("+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${ctr}",java.lang.String.class, __ojsp_varRes, null)+");"));
                                            __jsp_taghandler_102.setProperty("contractPartyType");
                                            __jsp_taghandler_102.setReadonly(true);
                                            __jsp_taghandler_102.setStyle("width:100px;");
                                            __jsp_taghandler_102.setStyleClass("must");
                                            __jsp_tag_starteval=__jsp_taghandler_102.doStartTag();
                                            if (__jsp_taghandler_102.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                              return;
                                            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_102,7);
                                          }
                                          out.write(__oracle_jsp_text[220]);
                                          out.print(ctr);
                                          out.write(__oracle_jsp_text[221]);
                                          out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${ctr}",java.lang.String.class, __ojsp_varRes, null));
                                          out.write(__oracle_jsp_text[222]);
                                        } while (__jsp_taghandler_90.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                      }
                                      if (__jsp_taghandler_90.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_90,6);
                                    }
                                    out.write(__oracle_jsp_text[223]);
                                  } while (__jsp_taghandler_89.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                  out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                                }
                                if (__jsp_taghandler_89.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_89,5);
                              }
                              out.write(__oracle_jsp_text[224]);
                            } while (__jsp_taghandler_88.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                          }
                          if (__jsp_taghandler_88.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_88,4);
                        }
                        out.write(__oracle_jsp_text[225]);
                      } while (__jsp_taghandler_87.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                    }
                    if (__jsp_taghandler_87.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_87,3);
                  }
                  out.write(__oracle_jsp_text[226]);
                  {
                    org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_103=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name value");
                    __jsp_taghandler_103.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_103.setName("internalUser");
                    __jsp_taghandler_103.setValue(OracleJspRuntime.toStr( EserviceRegistrationDao.USER_MODE.INTERNAL_MRES));
                    __jsp_tag_starteval=__jsp_taghandler_103.doStartTag();
                    if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                    {
                      do {
                        out.write(__oracle_jsp_text[227]);
                        {
                          org.apache.struts.taglib.logic.IterateTag __jsp_taghandler_104=(org.apache.struts.taglib.logic.IterateTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.IterateTag.class,"org.apache.struts.taglib.logic.IterateTag id indexId name property type");
                          __jsp_taghandler_104.setParent(__jsp_taghandler_103);
                          __jsp_taghandler_104.setId("rowdata");
                          __jsp_taghandler_104.setIndexId("ctr");
                          __jsp_taghandler_104.setName("feserv12");
                          __jsp_taghandler_104.setProperty("contractPartyList");
                          __jsp_taghandler_104.setType("com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceContractPartyPortPairMod");
                          com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceContractPartyPortPairMod rowdata = null;
                          java.lang.Integer ctr = null;
                          __jsp_tag_starteval=__jsp_taghandler_104.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_104,__jsp_tag_starteval,out);
                            do {
                              rowdata = (com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceContractPartyPortPairMod) pageContext.findAttribute("rowdata");
                              ctr = (java.lang.Integer) pageContext.findAttribute("ctr");
                              out.write(__oracle_jsp_text[228]);
                              {
                                org.apache.struts.taglib.logic.NotEqualTag __jsp_taghandler_105=(org.apache.struts.taglib.logic.NotEqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEqualTag.class,"org.apache.struts.taglib.logic.NotEqualTag name property value");
                                __jsp_taghandler_105.setParent(__jsp_taghandler_104);
                                __jsp_taghandler_105.setName("rowdata");
                                __jsp_taghandler_105.setProperty("statusFlag");
                                __jsp_taghandler_105.setValue(OracleJspRuntime.toStr( EserviceRegistrationDao.DEL));
                                __jsp_tag_starteval=__jsp_taghandler_105.doStartTag();
                                if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                {
                                  do {
                                    out.write(__oracle_jsp_text[229]);
                                    {
                                      org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_106=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
                                      __jsp_taghandler_106.setParent(__jsp_taghandler_105);
                                      __jsp_taghandler_106.setName("rowdata");
                                      __jsp_taghandler_106.setProperty("fkContractPartyCode");
                                      __jsp_tag_starteval=__jsp_taghandler_106.doStartTag();
                                      if (__jsp_taghandler_106.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_106,6);
                                    }
                                    out.write(__oracle_jsp_text[230]);
                                    {
                                      org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_107=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
                                      __jsp_taghandler_107.setParent(__jsp_taghandler_105);
                                      __jsp_taghandler_107.setName("rowdata");
                                      __jsp_taghandler_107.setProperty("pkPortPairSeq");
                                      __jsp_tag_starteval=__jsp_taghandler_107.doStartTag();
                                      if (__jsp_taghandler_107.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_107,6);
                                    }
                                    out.write(__oracle_jsp_text[231]);
                                    {
                                      org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_108=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
                                      __jsp_taghandler_108.setParent(__jsp_taghandler_105);
                                      __jsp_taghandler_108.setName("rowdata");
                                      __jsp_taghandler_108.setProperty("statusFlag");
                                      __jsp_tag_starteval=__jsp_taghandler_108.doStartTag();
                                      if (__jsp_taghandler_108.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_108,6);
                                    }
                                    out.write(__oracle_jsp_text[232]);
                                    {
                                      org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_109=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
                                      __jsp_taghandler_109.setParent(__jsp_taghandler_105);
                                      __jsp_taghandler_109.setName("rowdata");
                                      __jsp_taghandler_109.setProperty("recStatus");
                                      __jsp_tag_starteval=__jsp_taghandler_109.doStartTag();
                                      if (__jsp_taghandler_109.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_109,6);
                                    }
                                    out.write(__oracle_jsp_text[233]);
                                    {
                                      org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_110=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
                                      __jsp_taghandler_110.setParent(__jsp_taghandler_105);
                                      __jsp_taghandler_110.setName("rowdata");
                                      __jsp_taghandler_110.setProperty("approveFlag");
                                      __jsp_tag_starteval=__jsp_taghandler_110.doStartTag();
                                      if (__jsp_taghandler_110.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_110,6);
                                    }
                                    out.write(__oracle_jsp_text[234]);
                                    {
                                      org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_111=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
                                      __jsp_taghandler_111.setParent(__jsp_taghandler_105);
                                      __jsp_taghandler_111.setName("rowdata");
                                      __jsp_taghandler_111.setProperty("contractPartyFscCode");
                                      __jsp_tag_starteval=__jsp_taghandler_111.doStartTag();
                                      if (__jsp_taghandler_111.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_111,6);
                                    }
                                    out.write(__oracle_jsp_text[235]);
                                    {
                                      org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_112=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
                                      __jsp_taghandler_112.setParent(__jsp_taghandler_105);
                                      __jsp_taghandler_112.setName("rowdata");
                                      __jsp_taghandler_112.setProperty("contractPartyType");
                                      __jsp_tag_starteval=__jsp_taghandler_112.doStartTag();
                                      if (__jsp_taghandler_112.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_112,6);
                                    }
                                    out.write(__oracle_jsp_text[236]);
                                    {
                                      org.apache.struts.taglib.html.TextTag __jsp_taghandler_113=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag disabled name onblur property style");
                                      __jsp_taghandler_113.setParent(__jsp_taghandler_105);
                                      __jsp_taghandler_113.setDisabled(true);
                                      __jsp_taghandler_113.setName("rowdata");
                                      __jsp_taghandler_113.setOnblur("lp_updContractCompany(this);");
                                      __jsp_taghandler_113.setProperty("contractPartyName");
                                      __jsp_taghandler_113.setStyle("width:500px;");
                                      __jsp_tag_starteval=__jsp_taghandler_113.doStartTag();
                                      if (__jsp_taghandler_113.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_113,6);
                                    }
                                    out.write(__oracle_jsp_text[237]);
                                    {
                                      org.apache.struts.taglib.html.TextTag __jsp_taghandler_114=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag disabled name property style");
                                      __jsp_taghandler_114.setParent(__jsp_taghandler_105);
                                      __jsp_taghandler_114.setDisabled(true);
                                      __jsp_taghandler_114.setName("rowdata");
                                      __jsp_taghandler_114.setProperty("recStatusDesc");
                                      __jsp_taghandler_114.setStyle("width:150px;text-align:center;");
                                      __jsp_tag_starteval=__jsp_taghandler_114.doStartTag();
                                      if (__jsp_taghandler_114.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_114,6);
                                    }
                                    out.write(__oracle_jsp_text[238]);
                                    {
                                      org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_115=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name property value");
                                      __jsp_taghandler_115.setParent(__jsp_taghandler_105);
                                      __jsp_taghandler_115.setName("rowdata");
                                      __jsp_taghandler_115.setProperty("statusFlag");
                                      __jsp_taghandler_115.setValue(OracleJspRuntime.toStr( EserviceRegistrationDao.ADD));
                                      __jsp_tag_starteval=__jsp_taghandler_115.doStartTag();
                                      if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                      {
                                        do {
                                          out.write(__oracle_jsp_text[239]);
                                          out.print(contextPath);
                                          out.write(__oracle_jsp_text[240]);
                                        } while (__jsp_taghandler_115.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                      }
                                      if (__jsp_taghandler_115.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_115,6);
                                    }
                                    out.write(__oracle_jsp_text[241]);
                                  } while (__jsp_taghandler_105.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                }
                                if (__jsp_taghandler_105.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_105,5);
                              }
                              out.write(__oracle_jsp_text[242]);
                            } while (__jsp_taghandler_104.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_104.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_104,4);
                        }
                        out.write(__oracle_jsp_text[243]);
                      } while (__jsp_taghandler_103.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                    }
                    if (__jsp_taghandler_103.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_103,3);
                  }
                  out.write(__oracle_jsp_text[244]);
                  {
                    org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_116=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name property value");
                    __jsp_taghandler_116.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_116.setName("feserv12");
                    __jsp_taghandler_116.setProperty("portPairFlag");
                    __jsp_taghandler_116.setValue("N");
                    __jsp_tag_starteval=__jsp_taghandler_116.doStartTag();
                    if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                    {
                      do {
                        out.write(__oracle_jsp_text[245]);
                        out.write(__oracle_jsp_text[246]);
                        {
                          org.apache.struts.taglib.logic.NotEmptyTag __jsp_taghandler_117=(org.apache.struts.taglib.logic.NotEmptyTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEmptyTag.class,"org.apache.struts.taglib.logic.NotEmptyTag name property");
                          __jsp_taghandler_117.setParent(__jsp_taghandler_116);
                          __jsp_taghandler_117.setName("feserv12");
                          __jsp_taghandler_117.setProperty("userServiceModList");
                          __jsp_tag_starteval=__jsp_taghandler_117.doStartTag();
                          if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                          {
                            do {
                              out.write(__oracle_jsp_text[247]);
                              {
                                org.apache.struts.taglib.logic.IterateTag __jsp_taghandler_118=(org.apache.struts.taglib.logic.IterateTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.IterateTag.class,"org.apache.struts.taglib.logic.IterateTag id indexId name property");
                                __jsp_taghandler_118.setParent(__jsp_taghandler_117);
                                __jsp_taghandler_118.setId("serviceList");
                                __jsp_taghandler_118.setIndexId("rowIndex");
                                __jsp_taghandler_118.setName("feserv12");
                                __jsp_taghandler_118.setProperty("userServiceModList");
                                java.lang.Object serviceList = null;
                                java.lang.Integer rowIndex = null;
                                __jsp_tag_starteval=__jsp_taghandler_118.doStartTag();
                                if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                                {
                                  out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_118,__jsp_tag_starteval,out);
                                  do {
                                    serviceList = (java.lang.Object) pageContext.findAttribute("serviceList");
                                    rowIndex = (java.lang.Integer) pageContext.findAttribute("rowIndex");
                                    out.write(__oracle_jsp_text[248]);
                                    {
                                      org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_119=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
                                      __jsp_taghandler_119.setParent(__jsp_taghandler_118);
                                      __jsp_taghandler_119.setName("serviceList");
                                      __jsp_taghandler_119.setProperty("checked");
                                      __jsp_tag_starteval=__jsp_taghandler_119.doStartTag();
                                      if (__jsp_taghandler_119.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_119,6);
                                    }
                                    out.write(__oracle_jsp_text[249]);
                                    {
                                      org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_120=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                                      __jsp_taghandler_120.setParent(__jsp_taghandler_118);
                                      __jsp_taghandler_120.setName("serviceList");
                                      __jsp_taghandler_120.setProperty("sfu");
                                      __jsp_tag_starteval=__jsp_taghandler_120.doStartTag();
                                      if (__jsp_taghandler_120.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_120,6);
                                    }
                                    out.write(__oracle_jsp_text[250]);
                                    {
                                      org.apache.struts.taglib.html.CheckboxTag __jsp_taghandler_121=(org.apache.struts.taglib.html.CheckboxTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.CheckboxTag.class,"org.apache.struts.taglib.html.CheckboxTag name onclick property styleClass");
                                      __jsp_taghandler_121.setParent(__jsp_taghandler_118);
                                      __jsp_taghandler_121.setName("serviceList");
                                      __jsp_taghandler_121.setOnclick((java.lang.String) ("clearMsg(); onServiceChecked("+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rowIndex}",java.lang.String.class, __ojsp_varRes, null)+");"));
                                      __jsp_taghandler_121.setProperty("sfu");
                                      __jsp_taghandler_121.setStyleClass("check_box_style");
                                      __jsp_tag_starteval=__jsp_taghandler_121.doStartTag();
                                      if (__jsp_taghandler_121.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_121,6);
                                    }
                                    out.write(__oracle_jsp_text[251]);
                                    out.write(__oracle_jsp_text[252]);
                                    {
                                      org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_122=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                                      __jsp_taghandler_122.setParent(__jsp_taghandler_118);
                                      __jsp_taghandler_122.setName("serviceList");
                                      __jsp_taghandler_122.setProperty("moduleName");
                                      __jsp_tag_starteval=__jsp_taghandler_122.doStartTag();
                                      if (__jsp_taghandler_122.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_122,6);
                                    }
                                    out.write(__oracle_jsp_text[253]);
                                    {
                                      org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_123=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                                      __jsp_taghandler_123.setParent(__jsp_taghandler_118);
                                      __jsp_taghandler_123.setName("serviceList");
                                      __jsp_taghandler_123.setProperty("usageRemark");
                                      __jsp_tag_starteval=__jsp_taghandler_123.doStartTag();
                                      if (__jsp_taghandler_123.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_123,6);
                                    }
                                    out.write(__oracle_jsp_text[254]);
                                  } while (__jsp_taghandler_118.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                  out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                                }
                                if (__jsp_taghandler_118.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_118,5);
                              }
                              out.write(__oracle_jsp_text[255]);
                            } while (__jsp_taghandler_117.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                          }
                          if (__jsp_taghandler_117.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_117,4);
                        }
                        out.write(__oracle_jsp_text[256]);
                        {
                          org.apache.struts.taglib.logic.NotEqualTag __jsp_taghandler_124=(org.apache.struts.taglib.logic.NotEqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEqualTag.class,"org.apache.struts.taglib.logic.NotEqualTag name value");
                          __jsp_taghandler_124.setParent(__jsp_taghandler_116);
                          __jsp_taghandler_124.setName("internalUser");
                          __jsp_taghandler_124.setValue(OracleJspRuntime.toStr( EserviceRegistrationDao.USER_MODE.EXTERNAL));
                          __jsp_tag_starteval=__jsp_taghandler_124.doStartTag();
                          if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                          {
                            do {
                              out.write(__oracle_jsp_text[257]);
                              {
                                org.apache.struts.taglib.logic.NotEqualTag __jsp_taghandler_125=(org.apache.struts.taglib.logic.NotEqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEqualTag.class,"org.apache.struts.taglib.logic.NotEqualTag name property value");
                                __jsp_taghandler_125.setParent(__jsp_taghandler_124);
                                __jsp_taghandler_125.setName("feserv12");
                                __jsp_taghandler_125.setProperty("currPageAction");
                                __jsp_taghandler_125.setValue("manageAccount");
                                __jsp_tag_starteval=__jsp_taghandler_125.doStartTag();
                                if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                {
                                  do {
                                    out.write(__oracle_jsp_text[258]);
                                    {
                                      org.apache.struts.taglib.html.TextareaTag __jsp_taghandler_126=(org.apache.struts.taglib.html.TextareaTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextareaTag.class,"org.apache.struts.taglib.html.TextareaTag cols disabled name property rows styleId");
                                      __jsp_taghandler_126.setParent(__jsp_taghandler_125);
                                      __jsp_taghandler_126.setCols("50");
                                      __jsp_taghandler_126.setDisabled(OracleJspRuntime.toBoolean( userIdViewMode));
                                      __jsp_taghandler_126.setName("feserv12");
                                      __jsp_taghandler_126.setProperty("rejectReason");
                                      __jsp_taghandler_126.setRows("3");
                                      __jsp_taghandler_126.setStyleId("rejectReason");
                                      __jsp_tag_starteval=__jsp_taghandler_126.doStartTag();
                                      if (__jsp_taghandler_126.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_126,6);
                                    }
                                    out.write(__oracle_jsp_text[259]);
                                  } while (__jsp_taghandler_125.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                }
                                if (__jsp_taghandler_125.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_125,5);
                              }
                              out.write(__oracle_jsp_text[260]);
                            } while (__jsp_taghandler_124.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                          }
                          if (__jsp_taghandler_124.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_124,4);
                        }
                        out.write(__oracle_jsp_text[261]);
                        out.write(__oracle_jsp_text[262]);
                      } while (__jsp_taghandler_116.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                    }
                    if (__jsp_taghandler_116.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_116,3);
                  }
                  out.write(__oracle_jsp_text[263]);
                  out.write(__oracle_jsp_text[264]);
                  {
                    org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_127=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name value");
                    __jsp_taghandler_127.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_127.setName("internalUser");
                    __jsp_taghandler_127.setValue(OracleJspRuntime.toStr( EserviceRegistrationDao.USER_MODE.EXTERNAL));
                    __jsp_tag_starteval=__jsp_taghandler_127.doStartTag();
                    if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                    {
                      do {
                        out.write(__oracle_jsp_text[265]);
                        out.print(contextPath);
                        out.write(__oracle_jsp_text[266]);
                        out.print(contextPath);
                        out.write(__oracle_jsp_text[267]);
                      } while (__jsp_taghandler_127.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                    }
                    if (__jsp_taghandler_127.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_127,3);
                  }
                  out.write(__oracle_jsp_text[268]);
                  {
                    org.apache.struts.taglib.logic.NotEqualTag __jsp_taghandler_128=(org.apache.struts.taglib.logic.NotEqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEqualTag.class,"org.apache.struts.taglib.logic.NotEqualTag name value");
                    __jsp_taghandler_128.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_128.setName("userIdViewMode");
                    __jsp_taghandler_128.setValue("true");
                    __jsp_tag_starteval=__jsp_taghandler_128.doStartTag();
                    if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                    {
                      do {
                        out.write(__oracle_jsp_text[269]);
                        out.print(contextPath);
                        out.write(__oracle_jsp_text[270]);
                        out.print(contextPath);
                        out.write(__oracle_jsp_text[271]);
                      } while (__jsp_taghandler_128.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                    }
                    if (__jsp_taghandler_128.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_128,3);
                  }
                  out.write(__oracle_jsp_text[272]);
                  {
                    org.apache.struts.taglib.logic.NotEqualTag __jsp_taghandler_129=(org.apache.struts.taglib.logic.NotEqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEqualTag.class,"org.apache.struts.taglib.logic.NotEqualTag name value");
                    __jsp_taghandler_129.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_129.setName("internalUser");
                    __jsp_taghandler_129.setValue(OracleJspRuntime.toStr( EserviceRegistrationDao.USER_MODE.EXTERNAL));
                    __jsp_tag_starteval=__jsp_taghandler_129.doStartTag();
                    if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                    {
                      do {
                        out.write(__oracle_jsp_text[273]);
                        {
                          org.apache.struts.taglib.logic.NotEqualTag __jsp_taghandler_130=(org.apache.struts.taglib.logic.NotEqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEqualTag.class,"org.apache.struts.taglib.logic.NotEqualTag name property value");
                          __jsp_taghandler_130.setParent(__jsp_taghandler_129);
                          __jsp_taghandler_130.setName("feserv12");
                          __jsp_taghandler_130.setProperty("currPageAction");
                          __jsp_taghandler_130.setValue("manageAccount");
                          __jsp_tag_starteval=__jsp_taghandler_130.doStartTag();
                          if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                          {
                            do {
                              out.write(__oracle_jsp_text[274]);
                              {
                                org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_131=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name property value");
                                __jsp_taghandler_131.setParent(__jsp_taghandler_130);
                                __jsp_taghandler_131.setName("feserv12");
                                __jsp_taghandler_131.setProperty("portPairFlag");
                                __jsp_taghandler_131.setValue("N");
                                __jsp_tag_starteval=__jsp_taghandler_131.doStartTag();
                                if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                {
                                  do {
                                    out.write(__oracle_jsp_text[275]);
                                    {
                                      org.apache.struts.taglib.logic.NotEqualTag __jsp_taghandler_132=(org.apache.struts.taglib.logic.NotEqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEqualTag.class,"org.apache.struts.taglib.logic.NotEqualTag name value");
                                      __jsp_taghandler_132.setParent(__jsp_taghandler_131);
                                      __jsp_taghandler_132.setName("userIdViewMode");
                                      __jsp_taghandler_132.setValue("true");
                                      __jsp_tag_starteval=__jsp_taghandler_132.doStartTag();
                                      if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                      {
                                        do {
                                          out.write(__oracle_jsp_text[276]);
                                          out.print(contextPath);
                                          out.write(__oracle_jsp_text[277]);
                                        } while (__jsp_taghandler_132.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                      }
                                      if (__jsp_taghandler_132.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_132,6);
                                    }
                                    out.write(__oracle_jsp_text[278]);
                                  } while (__jsp_taghandler_131.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                }
                                if (__jsp_taghandler_131.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_131,5);
                              }
                              out.write(__oracle_jsp_text[279]);
                            } while (__jsp_taghandler_130.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                          }
                          if (__jsp_taghandler_130.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_130,4);
                        }
                        out.write(__oracle_jsp_text[280]);
                      } while (__jsp_taghandler_129.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                    }
                    if (__jsp_taghandler_129.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_129,3);
                  }
                  out.write(__oracle_jsp_text[281]);
                  out.print(contextPath);
                  out.write(__oracle_jsp_text[282]);
                  out.write(__oracle_jsp_text[283]);
                  out.write(__oracle_jsp_text[284]);
                  out.write(__oracle_jsp_text[285]);
                  out.write(__oracle_jsp_text[286]);
                  out.print(authPage);
                  out.write(__oracle_jsp_text[287]);
                  out.print(userId);
                  out.write(__oracle_jsp_text[288]);
                } while (__jsp_taghandler_2.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,2);
            }
            out.write(__oracle_jsp_text[289]);
          } while (__jsp_taghandler_1.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[290]);

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
  private static final char __oracle_jsp_text[][]=new char[291][];
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
    "\r\n".toCharArray();
    __oracle_jsp_text[13] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[14] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[15] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[16] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[17] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[18] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[19] = 
    "\r\n<head>\r\n<title>RCL Group</title>\r\n<meta content=\"text/html; charset=utf-8\" http-equiv=\"content-type\" />\r\n<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" >\r\n<link type=\"text/css\" href=\"".toCharArray();
    __oracle_jsp_text[20] = 
    "/css/registration/common.css\" rel=\"stylesheet\">\r\n<link type=\"text/css\" href=\"".toCharArray();
    __oracle_jsp_text[21] = 
    "/css/registration/registration.css\" rel=\"stylesheet\">\r\n<link type=\"text/css\" href=\"".toCharArray();
    __oracle_jsp_text[22] = 
    "/css/registration/reset.css\" rel=\"stylesheet\">\r\n<link type=\"text/css\" href=\"".toCharArray();
    __oracle_jsp_text[23] = 
    "/css/registration/style.css\" rel=\"stylesheet\">\r\n<script type=\"text/javascript\" src=\"".toCharArray();
    __oracle_jsp_text[24] = 
    "/js/RutString.js\"></script>\r\n".toCharArray();
    __oracle_jsp_text[25] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[26] = 
    "\r\n".toCharArray();
    __oracle_jsp_text[27] = 
    "\r\n<style type=\"text/css\">\r\n    .refresh_btn{\r\n        vertical-align: top; \r\n        height: 15px;\r\n        background-image: url('".toCharArray();
    __oracle_jsp_text[28] = 
    "/images/btnRefresh.jpg');\r\n    }\r\n    td.sub_table_blt_center{\r\n         background-image: url('".toCharArray();
    __oracle_jsp_text[29] = 
    "/images/registration/registration_blt_center.gif');\r\n         width: 10px; \r\n         height: 10px;\r\n    }\r\n    \r\n    td.sub_table_blt_right{\r\n        background-image: url('".toCharArray();
    __oracle_jsp_text[30] = 
    "/images/registration/registration_blt_right.gif');\r\n        width: 10px; \r\n        height: 10px;\r\n    }\r\n    td.sub_table_blt_left{\r\n        background-image: url('".toCharArray();
    __oracle_jsp_text[31] = 
    "/images/registration/registration_blt_left.gif');\r\n        width: 10px; \r\n        height: 10px;\r\n    }\r\n    \r\n    td.sub_table_brt_center{\r\n        background-image: url('".toCharArray();
    __oracle_jsp_text[32] = 
    "/images/registration/registration_brt_center.gif');\r\n        width: 10px; \r\n        height: 10px;\r\n    }\r\n    \r\n    td.sub_table_brt_right{\r\n        background-image: url('".toCharArray();
    __oracle_jsp_text[33] = 
    "/images/registration/registration_brt_right.gif');\r\n        width: 10px; \r\n        height: 10px;\r\n    }\r\n    \r\n    td.sub_table_brt_left{\r\n        background-image: url('".toCharArray();
    __oracle_jsp_text[34] = 
    "/images/registration/registration_brt_left.gif');\r\n        width: 10px; \r\n        height: 10px;\r\n    }\r\n    \r\n     td.sub_table_blb_center{\r\n        background-image: url('".toCharArray();
    __oracle_jsp_text[35] = 
    "/images/registration/registration_blb_center.gif');\r\n        width: 10px; \r\n        height: 10px;\r\n    }\r\n    \r\n    td.sub_table_blb_right{\r\n        background-image: url('".toCharArray();
    __oracle_jsp_text[36] = 
    "/images/registration/registration_blb_right.gif');\r\n        width: 10px; \r\n        height: 10px;\r\n    }\r\n    \r\n    td.sub_table_blb_left{\r\n        background-image: url('".toCharArray();
    __oracle_jsp_text[37] = 
    "/images/registration/registration_blb_left.gif');\r\n        width: 10px; \r\n        height: 10px;\r\n    }\r\n    \r\n    td.sub_table_brb_center{\r\n        background-image: url('".toCharArray();
    __oracle_jsp_text[38] = 
    "/images/registration/registration_brb_center.gif');\r\n        width: 10px; \r\n        height: 10px;\r\n    }\r\n    \r\n    td.sub_table_brb_right{\r\n        background-image: url('".toCharArray();
    __oracle_jsp_text[39] = 
    "/images/registration/registration_brb_right.gif');\r\n        width: 10px; \r\n        height: 10px;\r\n    }\r\n    \r\n    td.sub_table_brb_left{\r\n        background-image: url('".toCharArray();
    __oracle_jsp_text[40] = 
    "/images/registration/registration_brb_left.gif');\r\n        width: 10px; \r\n        height: 10px;\r\n    }\r\n    \r\n    td.sub_table_horizon_top{\r\n        background-image: url('".toCharArray();
    __oracle_jsp_text[41] = 
    "/images/registration/registration_horizon_top.gif');\r\n        background-repeat: repeat-x;\r\n        height: 10px;\r\n    }\r\n    \r\n    td.sub_table_horizon_bottom{\r\n        background-image: url('".toCharArray();
    __oracle_jsp_text[42] = 
    "/images/registration/registration_horizon_bottom.gif');\r\n        background-repeat: repeat-x;\r\n        height: 10px;\r\n    }\r\n    \r\n    td.sub_table_vertical_left{\r\n        background-image: url('".toCharArray();
    __oracle_jsp_text[43] = 
    "/images/registration/registration_vertical_left.gif');\r\n        background-repeat: repeat-y;\r\n        height: 10px;\r\n    }\r\n    \r\n    td.sub_table_vertical_right{\r\n        background-image: url('".toCharArray();
    __oracle_jsp_text[44] = 
    "/images/registration/registration_vertical_right.gif');\r\n        background-repeat: repeat-y;\r\n        height: 10px;\r\n    }\r\n    \r\n    .delBtnDisabled {\r\n       pointer-events: none;\r\n       cursor: default;\r\n    }\r\n    \r\n</style>\r\n<script  type=\"text/javascript\" language=\"JavaScript\" src=\"".toCharArray();
    __oracle_jsp_text[45] = 
    "/js/RutHelp.js\" ></script>\r\n<script type=\"text/javascript\" src=\"".toCharArray();
    __oracle_jsp_text[46] = 
    "/js/screen/EserviceRegistration.js\" ></script>\r\n<script type=\"text/javascript\">\r\n  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){\r\n  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),\r\n  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)\r\n  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');\r\n  ga('create', 'UA-39255240-1', 'rclgroup.com');\r\n  ga('send', 'pageview');\r\n</script>\r\n<script type=\"text/javascript\">\r\n    var REGISTRATION                    = '".toCharArray();
    __oracle_jsp_text[47] = 
    "';\r\n    var CHECK_AVAILABLE_USER_ID         = '".toCharArray();
    __oracle_jsp_text[48] = 
    "';\r\n    var BROWSE_CUSTOMER_DATA            = '".toCharArray();
    __oracle_jsp_text[49] = 
    "';\r\n    var BROWSE_CUSTOMER_TYPE_DATA       = '".toCharArray();
    __oracle_jsp_text[50] = 
    "';\r\n    var CREATE_CRM_CUSTOMER             = '".toCharArray();
    __oracle_jsp_text[51] = 
    "';\r\n    var REGISTRATION_REQUEST            = '".toCharArray();
    __oracle_jsp_text[52] = 
    "';\r\n    var GENERATE_CAPTCHA                = '".toCharArray();
    __oracle_jsp_text[53] = 
    "';\r\n    var OPEN_ACKNOWLEDGE                = '".toCharArray();
    __oracle_jsp_text[54] = 
    "';\r\n    var REJECTREASON                    = '".toCharArray();
    __oracle_jsp_text[55] = 
    "';\r\n    var userIdPassed                    = '".toCharArray();
    __oracle_jsp_text[56] = 
    "';\r\n    var userIdChecked                   = '".toCharArray();
    __oracle_jsp_text[57] = 
    "';\r\n    \r\n    /*Begin @02*/\r\n    var ADD_CONTRACT_COMPANY            = '".toCharArray();
    __oracle_jsp_text[58] = 
    "';\r\n    var UPD_CONTRACT_COMPANY            = '".toCharArray();
    __oracle_jsp_text[59] = 
    "';\r\n    var DEL_CONTRACT_COMPANY            = '".toCharArray();
    __oracle_jsp_text[60] = 
    "';\r\n    var CREATE_CRM_FOR_CONTRACT_PARTY   = '".toCharArray();
    __oracle_jsp_text[61] = 
    "';\r\n    /*End @02*/\r\n    \r\n//    function refreshCaptcha(){\r\n//        document.getElementById('captchaKey').src=GENERATE_CAPTCHA;\r\n//    }\r\n</script>\r\n</head>\r\n<body onload=\"onLoad();\">\r\n".toCharArray();
    __oracle_jsp_text[62] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[63] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[64] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[65] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[66] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[67] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[68] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[69] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[70] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[71] = 
    "\r\n    <input type=\"hidden\" id=\"userIdChecked\" name=\"userIdChecked\" value=\"".toCharArray();
    __oracle_jsp_text[72] = 
    "\" />\r\n    <input type=\"hidden\" id=\"userIdPassed\" name=\"userIdPassed\" value=\"".toCharArray();
    __oracle_jsp_text[73] = 
    "\" />\r\n    <input type=\"hidden\" id=\"userIdViewMode\" name=\"userIdViewMode\" value=\"".toCharArray();
    __oracle_jsp_text[74] = 
    "\" />\r\n    <input type=\"hidden\" id=\"authPage\" name=\"authPage\" value=\"".toCharArray();
    __oracle_jsp_text[75] = 
    "\" />\r\n    <!--Begin @02 -->\r\n    ".toCharArray();
    __oracle_jsp_text[76] = 
    "\r\n    <input type=\"hidden\" name=\"contextPath\" id=\"contextPath\" value=\"".toCharArray();
    __oracle_jsp_text[77] = 
    "\" />\r\n    ".toCharArray();
    __oracle_jsp_text[78] = 
    "\r\n    <!--End @02 -->\r\n    <div align=\"center\" style=\"width:100%\">\r\n        \r\n        <table width=\"910\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\r\n            <tr>\r\n                <td>\r\n                <div style=\"width: 910px; position: relative;\">\r\n                    <img src=\"".toCharArray();
    __oracle_jsp_text[79] = 
    "/images/registration/headertop.jpg\" border=\"0\" usemap=\"#Map\" \r\n                    alt=\"country\"  />\r\n                    \r\n                    <map name=\"Map\" id=\"Map\" >\r\n                        <area shape=\"rect\" coords=\"5, 6, 123, 64\" href=\"default.aspx\" target=\"_self\" alt=\"Country list\" onclick=\"backHome();\" />\r\n                        <!--<area shape=\"rect\" coords=\"621, 22, 670, 51\" href=\"rclhotline_00.asp\" target=\"_self\" />-->\r\n                    </map>\r\n                </div>\r\n                </td>\r\n            </tr>\r\n            <tr style=\"height: 30px\">\r\n                <td>\r\n                    <a href=\"".toCharArray();
    __oracle_jsp_text[80] = 
    "/download/setup.zip\" target=\"_blank\" style=\"text-decoration: underline;\" >Download eService setup</a>\r\n                </td>\r\n            </tr>\r\n            <tr>\r\n                <td>\r\n                <!-- ########## Personal And Account Detail START ########### -->\r\n                    <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"table_main_detail\">\r\n                        <tr class=\"table_tr_header\">\r\n                            <td  class=\"font_header\">\r\n                                Personal And Account Details\r\n                            </td>\r\n                        </tr>\r\n                        <tr>\r\n                            <td class=\"td_sub_detail\">\r\n                                ".toCharArray();
    __oracle_jsp_text[81] = 
    "\r\n                                <table width=\"892\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n                                    <tr style=\"height: 10px\">\r\n                                        <td width=\"10\" class=\"sub_table_blt_center\"></td>\r\n                                        <td width=\"10\" class=\"sub_table_blt_right\"></td>\r\n                                        <td width=\"852\" class=\"sub_table_horizon_top\"></td>\r\n                                        <td width=\"10\" class=\"sub_table_brt_left\"></td>\r\n                                        <td width=\"10\" class=\"sub_table_brt_center\"></td>\r\n                                    </tr>\r\n                                    <tr style=\"height: 10px\">\r\n                                        <td class=\"sub_table_blt_left\"></td>\r\n                                        <td colspan=\"3\" rowspan=\"3\" style=\"background-color: #dce6f2\">\r\n                                        <div id=\"personalDetailsDiv\">\r\n                                            <table width=\"95%\" border=\"0\" cellspacing=\"2\" cellpadding=\"0\" align=\"center\" class=\"table_sub_detail\">\r\n                                            <tr class=\"tr_sub_detail\">\r\n                                                <td colspan=\"2\" class=\"font_sub_header\">Personal</td>\r\n                                            </tr>\r\n                                        ".toCharArray();
    __oracle_jsp_text[82] = 
    "\r\n                                            <tr class=\"tr_sub_detail\">\r\n                                                <td width=\"20%\">First Name: <span class=\"font_require\">*</span></td>\r\n                                                <td width=\"80%\">\r\n                                                    ".toCharArray();
    __oracle_jsp_text[83] = 
    "\r\n                                                </td>\r\n                                            </tr>\r\n                                            <tr class=\"tr_sub_detail\">\r\n                                                <td>Last Name: <span class=\"font_require\">*</span></td>\r\n                                                <td>\r\n                                                    ".toCharArray();
    __oracle_jsp_text[84] = 
    "\r\n                                                </td>\r\n                                            </tr>\r\n                                        ".toCharArray();
    __oracle_jsp_text[85] = 
    "\r\n                                        ".toCharArray();
    __oracle_jsp_text[86] = 
    "\r\n                                            <tr class=\"tr_sub_detail\">\r\n                                                <td width=\"20%\">Name: </td>\r\n                                                <td width=\"80%\">\r\n                                                    ".toCharArray();
    __oracle_jsp_text[87] = 
    "\r\n                                                </td>\r\n                                            </tr>\r\n                                        ".toCharArray();
    __oracle_jsp_text[88] = 
    "\r\n                                            <tr class=\"tr_sub_detail\">\r\n                                                <td>Email Address: <span class=\"font_require\">*</span></td>\r\n                                                <td>\r\n                                                    ".toCharArray();
    __oracle_jsp_text[89] = 
    "\r\n                                                </td>\r\n                                            </tr>                            \r\n                                        ".toCharArray();
    __oracle_jsp_text[90] = 
    "\r\n                                            <tr class=\"tr_sub_detail\">\r\n                                                <td>Repeat Email Address: <span class=\"font_require\">*</span></td>\r\n                                                <td>\r\n                                                    ".toCharArray();
    __oracle_jsp_text[91] = 
    "\r\n                                                </td>\r\n                                            </tr>\r\n                                        ".toCharArray();
    __oracle_jsp_text[92] = 
    "\r\n                                            </table>\r\n                                        </div>\r\n                                        </td>\r\n                                        <td class=\"sub_table_brt_right\"></td>\r\n                                    </tr>                          \r\n                                    ".toCharArray();
    __oracle_jsp_text[93] = 
    "\r\n                                        <tr style=\"height: 110px;\">\r\n                                            <td class=\"sub_table_vertical_left\"></td>\r\n                                            <td class=\"sub_table_vertical_right\"></td>\r\n                                        </tr>\r\n                                    ".toCharArray();
    __oracle_jsp_text[94] = 
    "                     \r\n                                    ".toCharArray();
    __oracle_jsp_text[95] = 
    "\r\n                                        <tr style=\"height: 80px;\">\r\n                                            <td class=\"sub_table_vertical_left\"></td>\r\n                                            <td class=\"sub_table_vertical_right\"></td>\r\n                                        </tr>\r\n                                    ".toCharArray();
    __oracle_jsp_text[96] = 
    "\r\n                                    <tr>\r\n                                        <td class=\"sub_table_blb_left\"></td>\r\n                                        <td class=\"sub_table_brb_right\"></td>\r\n                                    </tr>\r\n                                    <tr style=\"height: 10px\">\r\n                                        <td class=\"sub_table_blb_center\"></td>\r\n                                        <td class=\"sub_table_blb_right\"></td>\r\n                                        <td class=\"sub_table_horizon_bottom\"></td>\r\n                                        <td class=\"sub_table_brb_left\"></td>\r\n                                        <td class=\"sub_table_brb_center\"></td>\r\n                                    </tr>\r\n                                </table>                    \r\n                                ".toCharArray();
    __oracle_jsp_text[97] = 
    "\r\n                                ".toCharArray();
    __oracle_jsp_text[98] = 
    "\r\n                                ".toCharArray();
    __oracle_jsp_text[99] = 
    "\r\n                                    <span style=\"height: 10px\" >&nbsp;</span>\r\n                                    <table width=\"892\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n                                        <tr style=\"height: 10px\">\r\n                                            <td width=\"10\" class=\"sub_table_blt_center\"></td>\r\n                                            <td width=\"10\" class=\"sub_table_blt_right\"></td>\r\n                                            <td width=\"852\" class=\"sub_table_horizon_top\"></td>\r\n                                            <td width=\"10\" class=\"sub_table_brt_left\"></td>\r\n                                            <td width=\"10\" class=\"sub_table_brt_center\"></td>\r\n                                        </tr>\r\n                                        <tr style=\"height: 10px\">\r\n                                            <td class=\"sub_table_blt_left\"></td>\r\n                                            <td colspan=\"3\" rowspan=\"3\" style=\"background-color: #dce6f2\">\r\n                                                <div id=\"accountDetailsDiv\">\r\n                                                    <table width=\"95%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"table_sub_detail\">\r\n                                                        <tr class=\"tr_sub_detail\">\r\n                                                            <td colspan=\"2\" class=\"font_sub_header\">Account</td>\r\n                                                        </tr>\r\n                                                        <tr class=\"tr_sub_detail\">\r\n                                                            <td width=\"20%\">User ID: <span class=\"font_require\">*</span></td>\r\n                                                            <td width=\"80%\">\r\n                                                                ".toCharArray();
    __oracle_jsp_text[100] = 
    "\r\n                                                                    ".toCharArray();
    __oracle_jsp_text[101] = 
    "&nbsp;\r\n                                                                    <span style=\" font-style: italic;\">(6 to 10 characters length required. A-Z, a-z, 0-9, _)</span>\r\n                                                                ".toCharArray();
    __oracle_jsp_text[102] = 
    "\r\n                                                                ".toCharArray();
    __oracle_jsp_text[103] = 
    "\r\n                                                                    ".toCharArray();
    __oracle_jsp_text[104] = 
    "\r\n                                                                ".toCharArray();
    __oracle_jsp_text[105] = 
    "\r\n                                                            </td>\r\n                                                        </tr>\r\n                                                        <tr class=\"tr_sub_detail\">\r\n                                                            <td>\r\n                                                                ".toCharArray();
    __oracle_jsp_text[106] = 
    "\r\n                                                                    &nbsp;\r\n                                                                ".toCharArray();
    __oracle_jsp_text[107] = 
    "\r\n                                                                ".toCharArray();
    __oracle_jsp_text[108] = 
    "\r\n                                                                    Old Password: \r\n                                                                ".toCharArray();
    __oracle_jsp_text[109] = 
    "\r\n                                                            </td>\r\n                                                            <td style=\"vertical-align: top\">\r\n                                                                ".toCharArray();
    __oracle_jsp_text[110] = 
    "\r\n                                                                    <font class=\"ALink_01\">\r\n                                                                        <a href=\"#\" onclick=\"clearMsg(); checkAvailableUserId();\" style=\"text-decoration: underline;\">Check Availability</a>\r\n                                                                    </font>\r\n                                                                    &nbsp;\r\n                                                                    <span id=\"checkResultMessage\">&nbsp;</span>\r\n                                                                ".toCharArray();
    __oracle_jsp_text[111] = 
    "\r\n                                                                ".toCharArray();
    __oracle_jsp_text[112] = 
    "\r\n                                                                    ".toCharArray();
    __oracle_jsp_text[113] = 
    "&nbsp;\r\n                                                                ".toCharArray();
    __oracle_jsp_text[114] = 
    "\r\n                                                            </td>\r\n                                                        </tr>\r\n                                                    <tr class=\"tr_sub_detail\">\r\n                                                        <td>Password: <span id=\"pwdSpan\"  class=\"font_require\">*</span></td>\r\n                                                        <td>\r\n                                                            ".toCharArray();
    __oracle_jsp_text[115] = 
    "&nbsp;\r\n                                                            <span style=\" font-style: italic;\">(least 8 characters, at least one letter and one digit.)</span>\r\n                                                        </td>\r\n                                                    </tr>\r\n                                                    <tr class=\"tr_sub_detail\">\r\n                                                        <td>Repeat Password: <span id=\"repeatPwdSpan\" class=\"font_require\">*</span></td>\r\n                                                        <td>\r\n                                                            ".toCharArray();
    __oracle_jsp_text[116] = 
    "\r\n                                                        </td>\r\n                                                    </tr>\r\n                                                    </table>\r\n                                                </div>\r\n                                            </td>\r\n                                            <td class=\"sub_table_brt_right\"></td>\r\n                                        </tr>\r\n                                        <tr style=\"height: 100px;\">\r\n                                            <td class=\"sub_table_vertical_left\"></td>\r\n                                            <td class=\"sub_table_vertical_right\"></td>\r\n                                        </tr>\r\n                                        <tr>\r\n                                            <td class=\"sub_table_blb_left\"></td>\r\n                                            <td class=\"sub_table_brb_right\"></td>\r\n                                        </tr>\r\n                                        <tr style=\"height: 10px\">\r\n                                            <td class=\"sub_table_blb_center\"></td>\r\n                                            <td class=\"sub_table_blb_right\"></td>\r\n                                            <td class=\"sub_table_horizon_bottom\"></td>\r\n                                            <td class=\"sub_table_brb_left\"></td>\r\n                                            <td class=\"sub_table_brb_center\"></td>\r\n                                        </tr>\r\n                                    </table>\r\n                                ".toCharArray();
    __oracle_jsp_text[117] = 
    "\r\n                                ".toCharArray();
    __oracle_jsp_text[118] = 
    "\r\n                            </td>\r\n                        </tr>\r\n                    </table>\r\n                    <!-- ########## Personal And Account Detail END ########### -->\r\n                </td>\r\n            </tr>\r\n            <tr><td>&nbsp;</td></tr>\r\n            <tr>\r\n                <td>\r\n                    <!-- ########## Company Details START ########### -->\r\n                    <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"table_main_detail\">\r\n                        <tr class=\"table_tr_header\">\r\n                            <td  class=\"font_header\">\r\n                                Company Details\r\n                            </td>\r\n                        </tr>\r\n                        <tr>\r\n                            <td class=\"td_sub_detail\">\r\n                                ".toCharArray();
    __oracle_jsp_text[119] = 
    "\r\n                                <table width=\"892\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n                                    <tr style=\"height: 10px\">\r\n                                        <td width=\"10\" class=\"sub_table_blt_center\"></td>\r\n                                        <td width=\"10\" class=\"sub_table_blt_right\"></td>\r\n                                        <td width=\"852\" class=\"sub_table_horizon_top\"></td>\r\n                                        <td width=\"10\" class=\"sub_table_brt_left\"></td>\r\n                                        <td width=\"10\" class=\"sub_table_brt_center\"></td>\r\n                                    </tr>\r\n                                    <tr style=\"height: 10px\">\r\n                                        <td class=\"sub_table_blt_left\"></td>\r\n                                        <td colspan=\"3\" rowspan=\"3\" style=\"background-color: #dce6f2\">\r\n                                            <div id=\"companyDetailsDiv\">\r\n                                                <table width=\"95%\" border=\"0\" cellspacing=\"2\" cellpadding=\"0\" align=\"center\" class=\"table_sub_detail\">\r\n                                                    <tr class=\"tr_sub_detail\">\r\n                                                        <td colspan=\"4\" class=\"font_sub_header\">Company</td>\r\n                                                    </tr>\r\n                                                    <tr class=\"tr_sub_detail\">\r\n                                                        <td width=\"26%\">Company Name: <span class=\"font_require\">*</span></td>\r\n                                                        <td width=\"38%\">\r\n                                                            ".toCharArray();
    __oracle_jsp_text[120] = 
    "\r\n                                                        </td>\r\n                                                        <td colspan=\"2\">\r\n                                                            ".toCharArray();
    __oracle_jsp_text[121] = 
    "\r\n                                                            <span id=\"crmErrorMsgSpan\" style=\"color: red\">\r\n                                                                ".toCharArray();
    __oracle_jsp_text[122] = 
    "\r\n                                                            </span>\r\n                                                        </td>\r\n                                                    </tr>\r\n                                                    <tr class=\"tr_sub_detail\">\r\n                                                        <td>Address: <span class=\"font_require\">*</span></td>\r\n                                                        <td style=\"white-space: nowrap;\">\r\n                                                            ".toCharArray();
    __oracle_jsp_text[123] = 
    "&nbsp;\r\n                                                            ".toCharArray();
    __oracle_jsp_text[124] = 
    "\r\n                                                        </td>\r\n                                                        <td width=\"15%\">\r\n                                                            ".toCharArray();
    __oracle_jsp_text[125] = 
    "\r\n                                                                Booking Party Code:\r\n                                                            ".toCharArray();
    __oracle_jsp_text[126] = 
    "\r\n                                                        </td>\r\n                                                        <td width=\"41%\" style=\"vertical-align: text-top;\">\r\n                                                            ".toCharArray();
    __oracle_jsp_text[127] = 
    "\r\n                                                               ".toCharArray();
    __oracle_jsp_text[128] = 
    "\r\n                                                               ".toCharArray();
    __oracle_jsp_text[129] = 
    "\r\n                                                                    <a name=\"btnBrowseCutsomerName\" id=\"btnBrowseCutsomerName\" href=\"javascript:void(0)\" onclick=\"clearMsg(); openCustomerData();\" class=\"m-btn smallest blue rnd smallericn-only\">\r\n                                                                        <i class=\"icon-search icon-white\"></i>\r\n                                                                    </a>\r\n                                                               ".toCharArray();
    __oracle_jsp_text[130] = 
    "\r\n                                                               \r\n                                                               ".toCharArray();
    __oracle_jsp_text[131] = 
    "\r\n                                                                    <a name=\"btnBrowseCutsomerName\" id=\"btnBrowseCutsomerName\" href=\"javascript:void(0)\" class=\"m-btn smallest blue rnd smallericn-only disabled\">\r\n                                                                        <i class=\"icon-search icon-white\"></i>\r\n                                                                    </a>\r\n                                                               ".toCharArray();
    __oracle_jsp_text[132] = 
    "\r\n                                                            ".toCharArray();
    __oracle_jsp_text[133] = 
    "&nbsp;\r\n                                                        </td>\r\n                                                    </tr>\r\n                                                    <tr class=\"tr_sub_detail\">\r\n                                                        <td>&nbsp;</td>\r\n                                                        <td style=\"white-space: nowrap;\">\r\n                                                            ".toCharArray();
    __oracle_jsp_text[134] = 
    "&nbsp;\r\n                                                            ".toCharArray();
    __oracle_jsp_text[135] = 
    "\r\n                                                        </td>\r\n                                                        <td>\r\n                                                            ".toCharArray();
    __oracle_jsp_text[136] = 
    "\r\n                                                                ".toCharArray();
    __oracle_jsp_text[137] = 
    "\r\n                                                                FSC Code: <span class=\"font_require\">*</span>\r\n                                                                ".toCharArray();
    __oracle_jsp_text[138] = 
    "\r\n                                                            ".toCharArray();
    __oracle_jsp_text[139] = 
    "&nbsp;\r\n                                                        </td>\r\n                                                        <td style=\"vertical-align: text-top;\">\r\n                                                            ".toCharArray();
    __oracle_jsp_text[140] = 
    "\r\n                                                                ".toCharArray();
    __oracle_jsp_text[141] = 
    "\r\n                                                                ".toCharArray();
    __oracle_jsp_text[142] = 
    "\r\n                                                                    <a id=\"btnBrowseFSC\" href=\"javascript:void(0)\" onclick=\"clearMsg(); openLookup('feserv12', 0, 'FSC_BY_CNTR', '".toCharArray();
    __oracle_jsp_text[143] = 
    "');\"\r\n                                                                        class=\"m-btn smallest blue rnd smallericn-only\">\r\n                                                                        <i class=\"icon-search icon-white\"></i>\r\n                                                                    </a>\r\n                                                                ".toCharArray();
    __oracle_jsp_text[144] = 
    " \r\n                                                                \r\n                                                                ".toCharArray();
    __oracle_jsp_text[145] = 
    "\r\n                                                                    <a id=\"btnBrowseFSC\" href=\"javascript:void(0)\" class=\"m-btn smallest blue rnd smallericn-only disabled\">\r\n                                                                        <i class=\"icon-search icon-white\"></i>\r\n                                                                    </a>\r\n                                                                ".toCharArray();
    __oracle_jsp_text[146] = 
    "\r\n                                                            ".toCharArray();
    __oracle_jsp_text[147] = 
    "&nbsp;\r\n                                                        </td>\r\n                                                    </tr>\r\n                                                    <tr class=\"tr_sub_detail\">\r\n                                                        <td>City: <span class=\"font_require\">*</span></td>\r\n                                                        <td>\r\n                                                            ".toCharArray();
    __oracle_jsp_text[148] = 
    "\r\n                                                        </td>\r\n                                                        <td>\r\n                                                            ".toCharArray();
    __oracle_jsp_text[149] = 
    "\r\n                                                                ".toCharArray();
    __oracle_jsp_text[150] = 
    "\r\n                                                                    Customer Type : <span class=\"font_require\">*</span>\r\n                                                                ".toCharArray();
    __oracle_jsp_text[151] = 
    "\r\n                                                            ".toCharArray();
    __oracle_jsp_text[152] = 
    "&nbsp;\r\n                                                        </td>\r\n                                                        <td style=\"vertical-align: text-top;\">\r\n                                                            ".toCharArray();
    __oracle_jsp_text[153] = 
    "\r\n                                                                ".toCharArray();
    __oracle_jsp_text[154] = 
    "\r\n                                                                ".toCharArray();
    __oracle_jsp_text[155] = 
    "\r\n                                                                    <a id=\"btnBrowseCutsomerType\" href=\"javascript:void(0)\" onclick=\"clearMsg(); openCustomerTypeData();\" class=\"m-btn smallest blue rnd smallericn-only\">\r\n                                                                        <i class=\"icon-search icon-white\"></i>\r\n                                                                    </a>\r\n                                                                    \r\n                                                                    <a id=\"btnBrowseCutsomerTypeDisabled\" href=\"javascript:void(0)\" class=\"m-btn smallest blue rnd smallericn-only disabled\">\r\n                                                                        <i class=\"icon-search icon-white\"></i>\r\n                                                                    </a>\r\n                                                                ".toCharArray();
    __oracle_jsp_text[156] = 
    "\r\n                                                                \r\n                                                                ".toCharArray();
    __oracle_jsp_text[157] = 
    "\r\n                                                                    <a id=\"btnBrowseCutsomerType\" href=\"javascript:void(0)\" class=\"m-btn smallest blue rnd smallericn-only disabled\">\r\n                                                                        <i class=\"icon-search icon-white\"></i>\r\n                                                                    </a>\r\n                                                                    \r\n                                                                    <a id=\"btnBrowseCutsomerTypeDisabled\" href=\"javascript:void(0)\" class=\"m-btn smallest blue rnd smallericn-only disabled\">\r\n                                                                        <i class=\"icon-search icon-white\"></i>\r\n                                                                    </a>\r\n                                                                ".toCharArray();
    __oracle_jsp_text[158] = 
    "\r\n                                                            ".toCharArray();
    __oracle_jsp_text[159] = 
    "&nbsp;\r\n                                                        </td>\r\n                                                    </tr>\r\n                                                    <tr class=\"tr_sub_detail\">\r\n                                                        <td>State: </td>\r\n                                                        <td>\r\n                                                            ".toCharArray();
    __oracle_jsp_text[160] = 
    "\r\n                                                        </td>\r\n                                                        <td align=\"right\">\r\n                                                            ".toCharArray();
    __oracle_jsp_text[161] = 
    "\r\n                                                                <a id=\"createCRMCustBtn\" href=\"javascript:void(0)\" class=\"m-btn mini blue rnd\" style=\"text-align: right; width: 140px\" onclick=\"createCRMCustomer()\">\r\n                                                                    <i class=\"icon-plus icon-white\"></i>&nbsp;Create Customer in CRM\r\n                                                                </a>\r\n                                                                <a id=\"createCRMCustDisabledBtn\" href=\"javascript:void(0)\" class=\"m-btn smallest rnd icn-only disabled\" style=\"display: none; text-align: right; width: 140px\" >\r\n                                                                    <i class=\"icon-plus icon-white\"></i>&nbsp;Create Customer in CRM\r\n                                                                </a>\r\n                                                            ".toCharArray();
    __oracle_jsp_text[162] = 
    "&nbsp;\r\n                                                        </td>\r\n                                                    </tr>\r\n                                                    <tr class=\"tr_sub_detail\">\r\n                                                        <td>Country: <span class=\"font_require\">*</span></td>\r\n                                                        <td colspan=\"3\">\r\n                                                            ".toCharArray();
    __oracle_jsp_text[163] = 
    "\r\n                                                                ".toCharArray();
    __oracle_jsp_text[164] = 
    "\r\n                                                            ".toCharArray();
    __oracle_jsp_text[165] = 
    "\r\n                                                        </td>\r\n                                                    </tr>\r\n                                                    <tr class=\"tr_sub_detail\">\r\n                                                        <td>Phone Number: <span class=\"font_require\">*</span></td>\r\n                                                        <td colspan=\"3\">\r\n                                                            ".toCharArray();
    __oracle_jsp_text[166] = 
    "\r\n                                                        </td>\r\n                                                    </tr>\r\n                                                <tr class=\"tr_sub_detail\">\r\n                                                    <td>FAX Number:</td>\r\n                                                    <td colspan=\"3\">\r\n                                                        ".toCharArray();
    __oracle_jsp_text[167] = 
    "\r\n                                                    </td>\r\n                                                </tr>\r\n                                                <tr class=\"tr_sub_detail\">\r\n                                                    <td>Represented Contract Party Company:</td>\r\n                                                    <td colspan=\"3\" align=\"left\">\r\n                                                        ".toCharArray();
    __oracle_jsp_text[168] = 
    "\r\n                                                            ".toCharArray();
    __oracle_jsp_text[169] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[170] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[171] = 
    "\r\n                                                            ".toCharArray();
    __oracle_jsp_text[172] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[173] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[174] = 
    "\r\n                                                            ".toCharArray();
    __oracle_jsp_text[175] = 
    "\r\n                                                                ".toCharArray();
    __oracle_jsp_text[176] = 
    "\r\n                                                            ".toCharArray();
    __oracle_jsp_text[177] = 
    "\r\n                                                            ".toCharArray();
    __oracle_jsp_text[178] = 
    "\r\n                                                                ".toCharArray();
    __oracle_jsp_text[179] = 
    "\r\n                                                            ".toCharArray();
    __oracle_jsp_text[180] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[181] = 
    "\r\n                                                    </td>\r\n                                                </tr>\r\n                                                </table>\r\n                                            </div>\r\n                                        </td>\r\n                                        <td class=\"sub_table_brt_right\"></td>\r\n                                    </tr>\r\n                                    <tr style=\"height: 200px;\">\r\n                                        <td class=\"sub_table_vertical_left\"></td>\r\n                                        <td class=\"sub_table_vertical_right\"></td>\r\n                                    </tr>\r\n                                    <tr>\r\n                                        <td class=\"sub_table_blb_left\"></td>\r\n                                        <td class=\"sub_table_brb_right\"></td>\r\n                                    </tr>\r\n                                    <tr style=\"height: 10px\">\r\n                                        <td class=\"sub_table_blb_center\"></td>\r\n                                        <td class=\"sub_table_blb_right\"></td>\r\n                                        <td class=\"sub_table_horizon_bottom\"></td>\r\n                                        <td class=\"sub_table_brb_left\"></td>\r\n                                        <td class=\"sub_table_brb_center\"></td>\r\n                                    </tr>\r\n                                </table>                    \r\n                                ".toCharArray();
    __oracle_jsp_text[182] = 
    "\r\n                                <!--Begin Contract party -->\r\n                                <br/>\r\n                                ".toCharArray();
    __oracle_jsp_text[183] = 
    "\r\n                                    <table width=\"892\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n                                        <tr style=\"height: 10px\">\r\n                                            <td width=\"10\" class=\"sub_table_blt_center\"></td>\r\n                                            <td width=\"10\" class=\"sub_table_blt_right\"></td>\r\n                                            <td width=\"852\" class=\"sub_table_horizon_top\"></td>\r\n                                            <td width=\"10\" class=\"sub_table_brt_left\"></td>\r\n                                            <td width=\"10\" class=\"sub_table_brt_center\"></td>\r\n                                        </tr>\r\n                                        <tr style=\"height: 10px\">\r\n                                            <td class=\"sub_table_blt_left\"></td>\r\n                                            <td colspan=\"3\" rowspan=\"3\" style=\"background-color: #dce6f2\">\r\n                                                    <div id=\"contractPartyCompanyDiv\" style=\"position:relative;\" >\r\n                                                        <table width=\"95%\" border=\"0\" cellspacing=\"2\" cellpadding=\"0\" align=\"center\" class=\"table_sub_detail\" id=\"contractPartyTab\">\r\n                                                            <tr class=\"tr_sub_detail\">\r\n                                                                <td colspan=\"3\" class=\"font_sub_header\">Contract Party Company</td>\r\n                                                            </tr>\r\n                                                            ".toCharArray();
    __oracle_jsp_text[184] = 
    "\r\n                                                                ".toCharArray();
    __oracle_jsp_text[185] = 
    "\r\n                                                                    <tr class=\"tr_sub_detail\">\r\n                                                                        <td width=\"15%\" height=\"30px;\" >Contract Company:</td>\r\n                                                                        <td  width=\"60%\" height=\"30px;\" align=\"left\" valign=\"middle\">\r\n                                                                            ".toCharArray();
    __oracle_jsp_text[186] = 
    "\r\n                                                                            ".toCharArray();
    __oracle_jsp_text[187] = 
    "\r\n                                                                            ".toCharArray();
    __oracle_jsp_text[188] = 
    "\r\n                                                                            ".toCharArray();
    __oracle_jsp_text[189] = 
    "\r\n                                                                            ".toCharArray();
    __oracle_jsp_text[190] = 
    "\r\n                                                                            ".toCharArray();
    __oracle_jsp_text[191] = 
    "\r\n                                                                            ".toCharArray();
    __oracle_jsp_text[192] = 
    "\r\n                                                                            ".toCharArray();
    __oracle_jsp_text[193] = 
    "\r\n                                                                            ".toCharArray();
    __oracle_jsp_text[194] = 
    "\r\n                                                                        </td>\r\n                                                                        <td  width=\"20%\" height=\"30px;\" align=\"center\" valign=\"middle\" style=\"position:relative;\" >\r\n                                                                            <div style=\"position:absolute;top:1px;left:2px;\">\r\n                                                                                <A name=\"delBtn\" class=\"\" href='javascript:void(0)' onclick=\"lp_delContractCompany(this);\" >\r\n                                                                                    <IMG border=\"0\" alt=\"Delete\" src=\"".toCharArray();
    __oracle_jsp_text[195] = 
    "/images/btnClose.gif\" width=\"16\" height=\"16\">\r\n                                                                                </A>\r\n                                                                            </div>\r\n                                                                        </td>\r\n                                                                    </tr>\r\n                                                                ".toCharArray();
    __oracle_jsp_text[196] = 
    "\r\n                                                            ".toCharArray();
    __oracle_jsp_text[197] = 
    "\r\n                                                        </table>\r\n                                                        <div style=\"position:absolute;right:0px;\">\r\n                                                            <a class=\"m-btn mini blue rnd\" name=\"btnAddContractCompany\" id=\"btnAddContractCompany\"\r\n                                                                href=\"javascript:void(0)\" onClick=\"return lp_addContractCompany()\">\r\n                                                                    <i class=\"icon-plus icon-white\"></i>&nbsp;Add more Contract Company\r\n                                                            </a>\r\n                                                        </div>\r\n                                                        <div style=\"height:50px;\"></div>\r\n                                                    </div>\r\n                                            </td>\r\n                                            <td class=\"sub_table_brt_right\"></td>\r\n                                        </tr>\r\n                                        <tr style=\"height: 200px;\">\r\n                                            <td class=\"sub_table_vertical_left\"></td>\r\n                                            <td class=\"sub_table_vertical_right\"></td>\r\n                                        </tr>\r\n                                        <tr>\r\n                                            <td class=\"sub_table_blb_left\"></td>\r\n                                            <td class=\"sub_table_brb_right\"></td>\r\n                                        </tr>\r\n                                        <tr style=\"height: 10px\">\r\n                                            <td class=\"sub_table_blb_center\"></td>\r\n                                            <td class=\"sub_table_blb_right\"></td>\r\n                                            <td class=\"sub_table_horizon_bottom\"></td>\r\n                                            <td class=\"sub_table_brb_left\"></td>\r\n                                            <td class=\"sub_table_brb_center\"></td>\r\n                                        </tr>\r\n                                    </table>\r\n                                ".toCharArray();
    __oracle_jsp_text[198] = 
    "\r\n                                ".toCharArray();
    __oracle_jsp_text[199] = 
    "\r\n                                    ".toCharArray();
    __oracle_jsp_text[200] = 
    "\r\n                                        <table width=\"892\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n                                            <tr style=\"height: 10px\">\r\n                                                <td width=\"10\" class=\"sub_table_blt_center\"></td>\r\n                                                <td width=\"10\" class=\"sub_table_blt_right\"></td>\r\n                                                <td width=\"852\" class=\"sub_table_horizon_top\"></td>\r\n                                                <td width=\"10\" class=\"sub_table_brt_left\"></td>\r\n                                                <td width=\"10\" class=\"sub_table_brt_center\"></td>\r\n                                            </tr>\r\n                                            <tr style=\"height: 10px\">\r\n                                                <td class=\"sub_table_blt_left\"></td>\r\n                                                <td colspan=\"3\" rowspan=\"3\" style=\"background-color: #dce6f2\">\r\n                                                    <div id=\"contractPartyCompanyDiv\" style=\"position:relative;\" >\r\n                                                        <table width=\"95%\" border=\"0\" cellspacing=\"2\" cellpadding=\"0\" align=\"center\" class=\"table_sub_detail\" id=\"contractPartyTab\">\r\n                                                            <tr class=\"tr_sub_detail\">\r\n                                                                <td colspan=\"6\" class=\"font_sub_header\">Contract Party Company</td>\r\n                                                            </tr>\r\n                                                        ".toCharArray();
    __oracle_jsp_text[201] = 
    "\r\n                                                            ".toCharArray();
    __oracle_jsp_text[202] = 
    "\r\n                                                                <tr class=\"tr_sub_detail\">\r\n                                                                    <td colspan=\"4\" align=\"left\" valign=\"middle\">\r\n                                                                        ".toCharArray();
    __oracle_jsp_text[203] = 
    "\r\n                                                                        ".toCharArray();
    __oracle_jsp_text[204] = 
    "\r\n                                                                        ".toCharArray();
    __oracle_jsp_text[205] = 
    "\r\n                                                                        ".toCharArray();
    __oracle_jsp_text[206] = 
    "\r\n                                                                        ".toCharArray();
    __oracle_jsp_text[207] = 
    "\r\n                                                                        <span>Contract Company:&nbsp;</span>\r\n                                                                        ".toCharArray();
    __oracle_jsp_text[208] = 
    "\r\n                                                                    </td>\r\n                                                                    <td width=\"12%\" height=\"30px\" align=\"center\" valign=\"middle\" style=\"position:relative;\" >\r\n                                                                        ".toCharArray();
    __oracle_jsp_text[209] = 
    "\r\n                                                                        &nbsp;<span>Approve</span>\r\n                                                                    </td>\r\n                                                                    <td width=\"20%\" height=\"30px\" align=\"center\" valign=\"middle\" style=\"position:relative;\" >\r\n                                                                        <a name=\"createCRMCustBtnForContractParty\" href=\"javascript:void(0)\" class=\"m-btn mini blue rnd\" onclick=\"createCRMCustomerForContractParty(".toCharArray();
    __oracle_jsp_text[210] = 
    ");\">\r\n                                                                            <i class=\"icon-plus icon-white\"></i>&nbsp;Create Customer in CRM\r\n                                                                        </a>\r\n                                                                    </td>\r\n                                                                </tr>\r\n                                                                <tr class=\"tr_sub_detail\">\r\n                                                                    <td colspan=\"6\" >\r\n                                                                        ".toCharArray();
    __oracle_jsp_text[211] = 
    "\r\n                                                                        <span id=\"errCrmDescSpan".toCharArray();
    __oracle_jsp_text[212] = 
    "\" style=\"color: red\">\r\n                                                                            ".toCharArray();
    __oracle_jsp_text[213] = 
    "\r\n                                                                        </span>\r\n                                                                    </td>\r\n                                                                </tr>\r\n                                                                <tr class=\"tr_sub_detail\">\r\n                                                                    <td width=\"13%\" height=\"30px\">Contract Party code:</td>\r\n                                                                    <td width=\"22%\" height=\"30px\" style=\"vertical-align: text-top;\">\r\n                                                                        ".toCharArray();
    __oracle_jsp_text[214] = 
    "\r\n                                                                        <a name=\"btnBrowseCutsomerNameForContractParty\" href=\"javascript:void(0)\" onclick=\"clearMsgForContractParty(".toCharArray();
    __oracle_jsp_text[215] = 
    "); openCustomerDataForContractParty(".toCharArray();
    __oracle_jsp_text[216] = 
    ");\"\r\n                                                                        class=\"m-btn smallest blue rnd smallericn-only\">\r\n                                                                            <i class=\"icon-search icon-white\" ></i>\r\n                                                                        </a>\r\n                                                                    </td>\r\n                                                                    <td width=\"9%\" height=\"30px\">FSC Code: <span class=\"font_require\">*</span></td>\r\n                                                                    <td width=\"20%\" height=\"30px\" style=\"vertical-align: text-top;\">\r\n                                                                        ".toCharArray();
    __oracle_jsp_text[217] = 
    "\r\n                                                                        <a name=\"btnBrowseFSCForContractParty\" href=\"javascript:void(0)\" onclick=\"clearMsgForContractParty(".toCharArray();
    __oracle_jsp_text[218] = 
    "); openLookupForContractParty('feserv12', 0, 'FSC_BY_CNTR', ".toCharArray();
    __oracle_jsp_text[219] = 
    ");\"\r\n                                                                            class=\"m-btn smallest blue rnd smallericn-only\">\r\n                                                                            <i class=\"icon-search icon-white\"></i>\r\n                                                                        </a>\r\n                                                                    </td>\r\n                                                                    <td width=\"11%\" height=\"30px\">Customer Type : <span class=\"font_require\">*</span></td>\r\n                                                                    <td width=\"20%\" height=\"30px\" style=\"vertical-align: text-top;\">\r\n                                                                        ".toCharArray();
    __oracle_jsp_text[220] = 
    "\r\n                                                                        <a name=\"btnBrowseCutsomerTypeForContractParty\" href=\"javascript:void(0)\" onclick=\"clearMsgForContractParty(".toCharArray();
    __oracle_jsp_text[221] = 
    "); openCustomerTypeDataForContractParty(".toCharArray();
    __oracle_jsp_text[222] = 
    ");\"\r\n                                                                        class=\"m-btn smallest blue rnd smallericn-only\">\r\n                                                                            <i class=\"icon-search icon-white\"></i>\r\n                                                                        </a>\r\n                                                                    </td>\r\n                                                                </tr>\r\n                                                                <tr>\r\n                                                                    <td colspan=\"6\">\r\n                                                                        &nbsp;\r\n                                                                    </td>\r\n                                                                </tr>\r\n                                                            ".toCharArray();
    __oracle_jsp_text[223] = 
    "\r\n                                                        ".toCharArray();
    __oracle_jsp_text[224] = 
    "\r\n                                                        </table>\r\n                                                    </div>\r\n                                                </td>\r\n                                                <td class=\"sub_table_brt_right\"></td>\r\n                                            </tr>\r\n                                            <tr style=\"height: 200px;\">\r\n                                                <td class=\"sub_table_vertical_left\"></td>\r\n                                                <td class=\"sub_table_vertical_right\"></td>\r\n                                            </tr>\r\n                                            <tr>\r\n                                                <td class=\"sub_table_blb_left\"></td>\r\n                                                <td class=\"sub_table_brb_right\"></td>\r\n                                            </tr>\r\n                                            <tr style=\"height: 10px\">\r\n                                                <td class=\"sub_table_blb_center\"></td>\r\n                                                <td class=\"sub_table_blb_right\"></td>\r\n                                                <td class=\"sub_table_horizon_bottom\"></td>\r\n                                                <td class=\"sub_table_brb_left\"></td>\r\n                                                <td class=\"sub_table_brb_center\"></td>\r\n                                            </tr>\r\n                                        </table>\r\n                                    ".toCharArray();
    __oracle_jsp_text[225] = 
    "\r\n                                ".toCharArray();
    __oracle_jsp_text[226] = 
    "\r\n                                ".toCharArray();
    __oracle_jsp_text[227] = 
    "\r\n                                    <table width=\"892\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" id=\"mresTable\">\r\n                                        <tr style=\"height: 10px\">\r\n                                            <td width=\"10\" class=\"sub_table_blt_center\"></td>\r\n                                            <td width=\"10\" class=\"sub_table_blt_right\"></td>\r\n                                            <td width=\"852\" class=\"sub_table_horizon_top\"></td>\r\n                                            <td width=\"10\" class=\"sub_table_brt_left\"></td>\r\n                                            <td width=\"10\" class=\"sub_table_brt_center\"></td>\r\n                                        </tr>\r\n                                        <tr style=\"height: 10px\">\r\n                                            <td class=\"sub_table_blt_left\"></td>\r\n                                            <td colspan=\"3\" rowspan=\"3\" style=\"background-color: #dce6f2\">\r\n                                                    <div id=\"contractPartyCompanyDiv\" style=\"position:relative;\" >\r\n                                                        <table width=\"95%\" border=\"0\" cellspacing=\"2\" cellpadding=\"0\" align=\"center\" class=\"table_sub_detail\" id=\"contractPartyTab\">\r\n                                                            <tr class=\"tr_sub_detail\">\r\n                                                                <td colspan=\"4\" class=\"font_sub_header\">Contract Party Company</td>\r\n                                                            </tr>\r\n                                                            ".toCharArray();
    __oracle_jsp_text[228] = 
    "\r\n                                                                ".toCharArray();
    __oracle_jsp_text[229] = 
    "\r\n                                                                    <tr class=\"tr_sub_detail\">\r\n                                                                        <td width=\"15%\" height=\"30px;\" >Contract Company:</td>\r\n                                                                        <td width=\"60%\" height=\"30px;\" align=\"left\" valign=\"middle\">\r\n                                                                            ".toCharArray();
    __oracle_jsp_text[230] = 
    "\r\n                                                                            ".toCharArray();
    __oracle_jsp_text[231] = 
    "\r\n                                                                            ".toCharArray();
    __oracle_jsp_text[232] = 
    "\r\n                                                                            ".toCharArray();
    __oracle_jsp_text[233] = 
    "\r\n                                                                            ".toCharArray();
    __oracle_jsp_text[234] = 
    "\r\n                                                                            ".toCharArray();
    __oracle_jsp_text[235] = 
    "\r\n                                                                            ".toCharArray();
    __oracle_jsp_text[236] = 
    "\r\n                                                                            ".toCharArray();
    __oracle_jsp_text[237] = 
    "\r\n                                                                        </td>\r\n                                                                        <td width=\"10%\" height=\"30px;\" align=\"left\" valign=\"middle\">\r\n                                                                            ".toCharArray();
    __oracle_jsp_text[238] = 
    "\r\n                                                                        </td>\r\n                                                                        <td width=\"10%\" height=\"30px;\" align=\"center\" valign=\"middle\" style=\"position:relative;\" >\r\n                                                                            ".toCharArray();
    __oracle_jsp_text[239] = 
    "\r\n                                                                                <div style=\"position:absolute;top:1px;left:2px;\">\r\n                                                                                    <A name=\"delBtn\" class=\"\" href='javascript:void(0)' onclick=\"lp_delContractCompany(this);\" >\r\n                                                                                        <IMG border=\"0\" alt=\"Delete\" src=\"".toCharArray();
    __oracle_jsp_text[240] = 
    "/images/btnClose.gif\" width=\"16\" height=\"16\">\r\n                                                                                    </A>\r\n                                                                                </div>\r\n                                                                            ".toCharArray();
    __oracle_jsp_text[241] = 
    "\r\n                                                                        </td>\r\n                                                                    </tr>\r\n                                                                ".toCharArray();
    __oracle_jsp_text[242] = 
    "\r\n                                                            ".toCharArray();
    __oracle_jsp_text[243] = 
    "\r\n                                                        </table>\r\n                                                        <div style=\"position:absolute;right:0px;\">\r\n                                                            <a class=\"m-btn mini blue rnd\" name=\"btnAddContractCompany\" id=\"btnAddContractCompany\"\r\n                                                                href=\"javascript:void(0)\" onClick=\"return lp_addContractCompany()\">\r\n                                                                    <i class=\"icon-plus icon-white\"></i>&nbsp;Add more Contract Company\r\n                                                            </a>\r\n                                                        </div>\r\n                                                        <div style=\"height:50px;\"></div>\r\n                                                    </div>\r\n                                            </td>\r\n                                            <td class=\"sub_table_brt_right\"></td>\r\n                                        </tr>\r\n                                        <tr style=\"height: 200px;\">\r\n                                            <td class=\"sub_table_vertical_left\"></td>\r\n                                            <td class=\"sub_table_vertical_right\"></td>\r\n                                        </tr>\r\n                                        <tr>\r\n                                            <td class=\"sub_table_blb_left\"></td>\r\n                                            <td class=\"sub_table_brb_right\"></td>\r\n                                        </tr>\r\n                                        <tr style=\"height: 10px\">\r\n                                            <td class=\"sub_table_blb_center\"></td>\r\n                                            <td class=\"sub_table_blb_right\"></td>\r\n                                            <td class=\"sub_table_horizon_bottom\"></td>\r\n                                            <td class=\"sub_table_brb_left\"></td>\r\n                                            <td class=\"sub_table_brb_center\"></td>\r\n                                        </tr>\r\n                                    </table>\r\n                                ".toCharArray();
    __oracle_jsp_text[244] = 
    "\r\n                                <!--End Contract party -->\r\n                            </td>\r\n                        </tr>\r\n                    </table>\r\n                <!-- ########## Company Details END ########### -->\r\n                </td>\r\n            </tr>\r\n        <tr><td>&nbsp;</td></tr>\r\n        <tr>\r\n            <td>\r\n            <!-- ########## Service(s) Request START ########### -->\r\n            ".toCharArray();
    __oracle_jsp_text[245] = 
    "\r\n                <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"table_main_detail\">\r\n                <tr class=\"table_tr_header\">\r\n                    <td  class=\"font_header\">\r\n                        Service(s) Requested\r\n                    </td>\r\n                </tr>\r\n                <tr>\r\n                    <td class=\"td_sub_detail\">\r\n    ".toCharArray();
    __oracle_jsp_text[246] = 
    "\r\n                        <table width=\"892\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n                        <tr style=\"height: 10px\">\r\n                            <td width=\"10\" class=\"sub_table_blt_center\"></td>\r\n                            <td width=\"10\" class=\"sub_table_blt_right\"></td>\r\n                            <td width=\"852\" class=\"sub_table_horizon_top\"></td>\r\n                            <td width=\"10\" class=\"sub_table_brt_left\"></td>\r\n                            <td width=\"10\" class=\"sub_table_brt_center\"></td>\r\n                        </tr>\r\n                        <tr style=\"height: 10px\">\r\n                            <td class=\"sub_table_blt_left\"></td>\r\n                            <td colspan=\"3\" style=\"background-color: #dce6f2\">\r\n                            <td class=\"sub_table_brt_right\"></td>\r\n                        </tr>\r\n                        <tr style=\"height: 10px\">\r\n                            <td class=\"sub_table_vertical_left\"></td>\r\n                            <td colspan=\"3\" style=\"background-color: #dce6f2\">\r\n                            <div id=\"serviceRequestDetailsDiv\">\r\n                                <table width=\"95%\" border=\"0\" cellspacing=\"2\" cellpadding=\"0\" align=\"center\" class=\"table_sub_detail\">\r\n                                <tr class=\"tr_sub_detail\">\r\n                                    <td colspan=\"3\" class=\"font_sub_header\">RCL eServices</td>\r\n                                </tr>\r\n                                <tr class=\"tr_sub_detail\">\r\n                                    <td colspan=\"3\" >\r\n                                        Please select at least one of the following available eServices  offered by Bhumnet.<span class=\"font_require\">*</span>\r\n                                    </td>\r\n                                </tr>\r\n                        ".toCharArray();
    __oracle_jsp_text[247] = 
    "\r\n                            ".toCharArray();
    __oracle_jsp_text[248] = 
    "\r\n                                <tr class=\"tr_sub_detail\">\r\n                                    <td width=\"10%\">&nbsp;</td>\r\n                                    <td width=\"30%\">\r\n                                        ".toCharArray();
    __oracle_jsp_text[249] = 
    "\r\n                                        <input type=\"hidden\" name=\"sfuCode\" value=\"".toCharArray();
    __oracle_jsp_text[250] = 
    "\" />\r\n                                        ".toCharArray();
    __oracle_jsp_text[251] = 
    "\r\n                                        ".toCharArray();
    __oracle_jsp_text[252] = 
    "\r\n                                        &nbsp;".toCharArray();
    __oracle_jsp_text[253] = 
    "\r\n                                    </td>\r\n                                    <td width=\"60%\">\r\n                                        <a name=\"userService\" href=\"javascript:void(0)\" class=\"m-btn smallest blue rnd smallericn-only\" \r\n                                        onmouseover=\"loadServiceDesctiption(this, '".toCharArray();
    __oracle_jsp_text[254] = 
    "')\">\r\n                                            <i class=\"icon-info-sign icon-white\"></i>\r\n                                        </a>\r\n                                    </td>\r\n                                </tr>\r\n                            ".toCharArray();
    __oracle_jsp_text[255] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[256] = 
    "\r\n                                    ".toCharArray();
    __oracle_jsp_text[257] = 
    "\r\n                                        ".toCharArray();
    __oracle_jsp_text[258] = 
    "\r\n                                            <tr class=\"tr_sub_detail\">\r\n                                                <td align=\"left\" width=\"12%\" style=\"vertical-align:text-top;\">\r\n                                                    <span>Reject Reason</span>\r\n                                                </td>\r\n                                                <td colspan=\"2\" align=\"left\" valign=\"top\">\r\n                                                    ".toCharArray();
    __oracle_jsp_text[259] = 
    "\r\n                                                </td>\r\n                                            </tr>\r\n                                        ".toCharArray();
    __oracle_jsp_text[260] = 
    "\r\n                                    ".toCharArray();
    __oracle_jsp_text[261] = 
    "\r\n                                </table>\r\n                            </div>\r\n                            \r\n                            </td>\r\n                            <td class=\"sub_table_vertical_right\"></td>\r\n                        </tr>\r\n                        ".toCharArray();
    __oracle_jsp_text[262] = 
    "\r\n                        <tr style=\"height: 10px\">\r\n                            <td class=\"sub_table_blb_left\"></td>\r\n                            <td colspan=\"3\" style=\"background-color: #dce6f2\">\r\n                            <td class=\"sub_table_brb_right\"></td>\r\n                        </tr>\r\n                        <tr style=\"height: 10px\">\r\n                            <td class=\"sub_table_blb_center\"></td>\r\n                            <td class=\"sub_table_blb_right\"></td>\r\n                            <td class=\"sub_table_horizon_bottom\"></td>\r\n                            <td class=\"sub_table_brb_left\"></td>\r\n                            <td class=\"sub_table_brb_center\"></td>\r\n                        </tr>\r\n                        </table>\r\n                    ".toCharArray();
    __oracle_jsp_text[263] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[264] = 
    "\r\n                    </td>\r\n                </tr>\r\n                </table>\r\n            <!-- ########## Service(s) Request END ########### -->\r\n            </td>\r\n        </tr>    \r\n        ".toCharArray();
    __oracle_jsp_text[265] = 
    "\r\n            <tr style=\"height: 50px\">\r\n                <td class=\"td_main_detail\">\r\n                <!-- ########## Service(s) Requested START ########### -->\r\n                    <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n                        <tr>\r\n                            <td>\r\n                                <input type=\"checkbox\" name=\"chkAccept\" class=\"check_box_style\" />\r\n                            </td>\r\n                            <td>\r\n                                I have read the&nbsp;\r\n                                <a href=\"javascript:openAnnouncement('".toCharArray();
    __oracle_jsp_text[266] = 
    "', '_blank', ANNOUNCE_TYPE_TERM_OF_USE);\">Terms of Use</a>&nbsp;and&nbsp;\r\n                                <a href=\"javascript:openAnnouncement('".toCharArray();
    __oracle_jsp_text[267] = 
    "', '_blank', ANNOUNCE_TYPE_PRIVACY_POLICY);\">Privacy Policy</a>&nbsp;\r\n                                and agree to the terms and conditions regarding the storage of my data. <span class=\"font_require\">*</span>\r\n                            </td>\r\n                        </tr>\r\n                    </table>\r\n                    <!-- ########## Service(s) Request END ########### -->\r\n                </td>\r\n            </tr> \r\n        ".toCharArray();
    __oracle_jsp_text[268] = 
    "\r\n            <tr><td>&nbsp;</td></tr>\r\n                <tr>\r\n                    <td>\r\n                        <div align=\"center\" style=\"width:100%\">\r\n                            <table width=\"400\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\r\n                                <tr>\r\n                                    <td width=\"400\" style=\"text-align: left; padding-left: 110px\">\r\n                                        ".toCharArray();
    __oracle_jsp_text[269] = 
    "                                                                    \r\n                                            <img src=\"".toCharArray();
    __oracle_jsp_text[270] = 
    "/images/registration/button_submit.png\" \r\n                                                 name=\"btnSubmit\" \r\n                                                 style=\"width: 70px; height: 22px; border: none; cursor: pointer\" \r\n                                                 alt=\"Submit\" \r\n                                                 onclick=\"submitBtn();\" />\r\n                                            <img src=\"".toCharArray();
    __oracle_jsp_text[271] = 
    "/images/registration/button_clear.png\" \r\n                                                 name=\"BtnClearAll\" \r\n                                                 style=\"width: 61px; height: 22px; border: none; cursor: pointer;\"\r\n                                                 alt=\"Clear\" \r\n                                                 onclick=\"clearBtn();\"/>\r\n                                        ".toCharArray();
    __oracle_jsp_text[272] = 
    "\r\n                                        ".toCharArray();
    __oracle_jsp_text[273] = 
    "\r\n                                            ".toCharArray();
    __oracle_jsp_text[274] = 
    "\r\n                                                ".toCharArray();
    __oracle_jsp_text[275] = 
    "\r\n                                                    ".toCharArray();
    __oracle_jsp_text[276] = 
    "\r\n                                                        <img src=\"".toCharArray();
    __oracle_jsp_text[277] = 
    "/images/registration/button_reject.png\" \r\n                                                             name=\"BtnReject\" \r\n                                                             style=\"width: 63px; height: 23px; border: none; cursor: pointer;\"\r\n                                                             alt=\"Reject\" \r\n                                                             onclick=\"rejectBtn();\"/>\r\n                                                    ".toCharArray();
    __oracle_jsp_text[278] = 
    "\r\n                                                ".toCharArray();
    __oracle_jsp_text[279] = 
    "\r\n                                            ".toCharArray();
    __oracle_jsp_text[280] = 
    "\r\n                                        ".toCharArray();
    __oracle_jsp_text[281] = 
    "\r\n                                    </td>\r\n                                </tr>\r\n                            </table>\r\n                        </div>\r\n                    </td>\r\n                </tr>\r\n                <tr style=\"height: 20px\"><td></td></tr>\r\n                <tr>\r\n                    <td>\r\n                        <div id=\"footerbox\">\r\n                            <div id=\"footermain\">\r\n                                <div style=\"width: 910px;\">\r\n                                    <img class=\"homepageFooterDivider\" src=\"".toCharArray();
    __oracle_jsp_text[282] = 
    "/images/registration/divbottom.jpg\" border=\"0\" />\r\n                                    <p style=\"text-align: center; font-family: Arial; font-size: 10px; line-height: 2em;\">\r\n                                        Copyright 2011 Regional Container Lines. All rights reserved. \r\n                                    </p>\r\n                                    \r\n                                    <p style=\"text-align: center;\"> \r\n                                        <font style=\"text-align: center; font-family: Arial; font-size: 10px; line-height: 2em;\">\r\n                                        ".toCharArray();
    __oracle_jsp_text[283] = 
    "\r\n                                            Terms of Use\r\n                                            ".toCharArray();
    __oracle_jsp_text[284] = 
    "\r\n                                        </font>\r\n                                        <font style=\"text-align: center; font-family: Arial; font-size: 10px; line-height: 2em;\">&nbsp;|&nbsp;</font>\r\n                                        <font style=\"text-align: center; font-family: Arial; font-size: 10px; line-height: 2em;\">\r\n                                        ".toCharArray();
    __oracle_jsp_text[285] = 
    "\r\n                                            Privacy Policy".toCharArray();
    __oracle_jsp_text[286] = 
    "\r\n                                        </font>\t\r\n                                        <font style=\"text-align: center; font-family: Arial; font-size: 10px; line-height: 2em;\">&nbsp;|&nbsp;</font>\r\n                                        <font style=\"text-align: center; font-family: Arial; font-size: 10px; line-height: 2em;\">\r\n                                        This website is best viewed with IE 9.x and above.\r\n                                        </font>\t\r\n                                    </p>\r\n                                </div>\r\n                            </div>\r\n                        </div>\r\n                    </td>\r\n                </tr>\r\n                <tr style=\"height: 50px\"><td></td></tr>\r\n            </table>     \r\n       \r\n    </div>\r\n    <script type=\"text/javascript\">        \r\n        var authPage                        = '".toCharArray();
    __oracle_jsp_text[287] = 
    "';\r\n        var userId                          = '".toCharArray();
    __oracle_jsp_text[288] = 
    "';\r\n        \r\n        if(authPage == \"noAuth\"){\r\n            alert(\"No Authorize\");\r\n            var url = REGISTRATION_REQUEST+'?appId=webbkg&tbx_uid=' + userId + \"&first_login=first\";\r\n            document.forms[0].action = url;\r\n            document.forms[0].submit();\r\n        }\r\n    </script>\r\n".toCharArray();
    __oracle_jsp_text[289] = 
    "\r\n</body>\r\n".toCharArray();
    __oracle_jsp_text[290] = 
    "\r\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
