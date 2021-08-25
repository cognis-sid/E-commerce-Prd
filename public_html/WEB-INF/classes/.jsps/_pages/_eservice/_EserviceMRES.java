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
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceMRESUim;
import java.util.List;


public class _EserviceMRES extends com.orionserver.http.OrionHttpJspPage {


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
    _EserviceMRES page = this;
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
      
          UserAccountBean account=(UserAccountBean) session.getAttribute(GlobalConstants.USER_ACCOUNT_BEAN);
          String contextPath = request.getContextPath();
          
          String accountName = account.getUserName();
          if(accountName == null || "".equals(accountName)){
              accountName = account.getUserId();
          }
          
      
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
            out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv007ManageAccount", pageContext));
            out.write(__oracle_jsp_text[19]);
            out.print(contextPath);
            out.write(__oracle_jsp_text[20]);
            out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv008LookupData", pageContext));
            out.write(__oracle_jsp_text[21]);
            out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv008LogOut", pageContext));
            out.write(__oracle_jsp_text[22]);
            {
              org.apache.struts.taglib.html.FormTag __jsp_taghandler_2=(org.apache.struts.taglib.html.FormTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.FormTag.class,"org.apache.struts.taglib.html.FormTag action method");
              __jsp_taghandler_2.setParent(__jsp_taghandler_1);
              __jsp_taghandler_2.setAction("/serv008");
              __jsp_taghandler_2.setMethod("post");
              __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[23]);
                  {
                    org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_3=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
                    __jsp_taghandler_3.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_3.setName("feserv13");
                    __jsp_taghandler_3.setProperty("errMsg");
                    __jsp_tag_starteval=__jsp_taghandler_3.doStartTag();
                    if (__jsp_taghandler_3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_3,3);
                  }
                  out.write(__oracle_jsp_text[24]);
                  {
                    org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_4=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
                    __jsp_taghandler_4.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_4.setName("feserv13");
                    __jsp_taghandler_4.setProperty("sortCol");
                    __jsp_tag_starteval=__jsp_taghandler_4.doStartTag();
                    if (__jsp_taghandler_4.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_4,3);
                  }
                  out.write(__oracle_jsp_text[25]);
                  {
                    org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_5=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
                    __jsp_taghandler_5.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_5.setName("feserv13");
                    __jsp_taghandler_5.setProperty("orderBy");
                    __jsp_tag_starteval=__jsp_taghandler_5.doStartTag();
                    if (__jsp_taghandler_5.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_5,3);
                  }
                  out.write(__oracle_jsp_text[26]);
                  out.print(contextPath);
                  out.write(__oracle_jsp_text[27]);
                  out.print(contextPath);
                  out.write(__oracle_jsp_text[28]);
                  out.print(contextPath);
                  out.write(__oracle_jsp_text[29]);
                  {
                    org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_6=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name property value");
                    __jsp_taghandler_6.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_6.setName("feserv13");
                    __jsp_taghandler_6.setProperty("authPass");
                    __jsp_taghandler_6.setValue("true");
                    __jsp_tag_starteval=__jsp_taghandler_6.doStartTag();
                    if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                    {
                      do {
                        out.write(__oracle_jsp_text[30]);
                        out.print(accountName);
                        out.write(__oracle_jsp_text[31]);
                        {
                          org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_7=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                          __jsp_taghandler_7.setParent(__jsp_taghandler_6);
                          __jsp_taghandler_7.setName("feserv13");
                          __jsp_taghandler_7.setProperty("fullCurrentDate");
                          __jsp_tag_starteval=__jsp_taghandler_7.doStartTag();
                          if (__jsp_taghandler_7.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_7,4);
                        }
                        out.write(__oracle_jsp_text[32]);
                        out.write(__oracle_jsp_text[33]);
                        {
                          org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_8=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                          __jsp_taghandler_8.setParent(__jsp_taghandler_6);
                          __jsp_taghandler_8.setName("feserv13");
                          __jsp_taghandler_8.setProperty("totalNotification");
                          __jsp_tag_starteval=__jsp_taghandler_8.doStartTag();
                          if (__jsp_taghandler_8.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_8,4);
                        }
                        out.write(__oracle_jsp_text[34]);
                        out.print(contextPath);
                        out.write(__oracle_jsp_text[35]);
                        {
                          org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_9=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                          __jsp_taghandler_9.setParent(__jsp_taghandler_6);
                          __jsp_taghandler_9.setName("feserv13");
                          __jsp_taghandler_9.setProperty("idOrderBy");
                          __jsp_tag_starteval=__jsp_taghandler_9.doStartTag();
                          if (__jsp_taghandler_9.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_9,4);
                        }
                        out.write(__oracle_jsp_text[36]);
                        out.print(contextPath);
                        out.write(__oracle_jsp_text[37]);
                        {
                          org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_10=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                          __jsp_taghandler_10.setParent(__jsp_taghandler_6);
                          __jsp_taghandler_10.setName("feserv13");
                          __jsp_taghandler_10.setProperty("subjectOrderBy");
                          __jsp_tag_starteval=__jsp_taghandler_10.doStartTag();
                          if (__jsp_taghandler_10.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_10,4);
                        }
                        out.write(__oracle_jsp_text[38]);
                        out.print(contextPath);
                        out.write(__oracle_jsp_text[39]);
                        {
                          org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_11=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                          __jsp_taghandler_11.setParent(__jsp_taghandler_6);
                          __jsp_taghandler_11.setName("feserv13");
                          __jsp_taghandler_11.setProperty("dateOrderBy");
                          __jsp_tag_starteval=__jsp_taghandler_11.doStartTag();
                          if (__jsp_taghandler_11.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_11,4);
                        }
                        out.write(__oracle_jsp_text[40]);
                        {
                          org.apache.struts.taglib.logic.NotEmptyTag __jsp_taghandler_12=(org.apache.struts.taglib.logic.NotEmptyTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEmptyTag.class,"org.apache.struts.taglib.logic.NotEmptyTag name property");
                          __jsp_taghandler_12.setParent(__jsp_taghandler_6);
                          __jsp_taghandler_12.setName("feserv13");
                          __jsp_taghandler_12.setProperty("notificationsList");
                          __jsp_tag_starteval=__jsp_taghandler_12.doStartTag();
                          if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                          {
                            do {
                              out.write(__oracle_jsp_text[41]);
                              {
                                org.apache.struts.taglib.logic.IterateTag __jsp_taghandler_13=(org.apache.struts.taglib.logic.IterateTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.IterateTag.class,"org.apache.struts.taglib.logic.IterateTag id indexId length name property");
                                __jsp_taghandler_13.setParent(__jsp_taghandler_12);
                                __jsp_taghandler_13.setId("notification");
                                __jsp_taghandler_13.setIndexId("index");
                                __jsp_taghandler_13.setLength("10");
                                __jsp_taghandler_13.setName("feserv13");
                                __jsp_taghandler_13.setProperty("notificationsList");
                                java.lang.Object notification = null;
                                java.lang.Integer index = null;
                                __jsp_tag_starteval=__jsp_taghandler_13.doStartTag();
                                if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                                {
                                  out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_13,__jsp_tag_starteval,out);
                                  do {
                                    notification = (java.lang.Object) pageContext.findAttribute("notification");
                                    index = (java.lang.Integer) pageContext.findAttribute("index");
                                    out.write(__oracle_jsp_text[42]);
                                    {
                                      org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_14=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                                      __jsp_taghandler_14.setParent(__jsp_taghandler_13);
                                      __jsp_taghandler_14.setName("notification");
                                      __jsp_taghandler_14.setProperty("id");
                                      __jsp_tag_starteval=__jsp_taghandler_14.doStartTag();
                                      if (__jsp_taghandler_14.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_14,6);
                                    }
                                    out.write(__oracle_jsp_text[43]);
                                    out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${index}",java.lang.String.class, __ojsp_varRes, null));
                                    out.write(__oracle_jsp_text[44]);
                                    out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${index}",java.lang.String.class, __ojsp_varRes, null));
                                    out.write(__oracle_jsp_text[45]);
                                    {
                                      org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_15=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag filter name property");
                                      __jsp_taghandler_15.setParent(__jsp_taghandler_13);
                                      __jsp_taghandler_15.setFilter(true);
                                      __jsp_taghandler_15.setName("notification");
                                      __jsp_taghandler_15.setProperty("mailBody");
                                      __jsp_tag_starteval=__jsp_taghandler_15.doStartTag();
                                      if (__jsp_taghandler_15.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_15,6);
                                    }
                                    out.write(__oracle_jsp_text[46]);
                                    out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${index}",java.lang.String.class, __ojsp_varRes, null));
                                    out.write(__oracle_jsp_text[47]);
                                    out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${index}",java.lang.String.class, __ojsp_varRes, null));
                                    out.write(__oracle_jsp_text[48]);
                                    {
                                      org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_16=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                                      __jsp_taghandler_16.setParent(__jsp_taghandler_13);
                                      __jsp_taghandler_16.setName("notification");
                                      __jsp_taghandler_16.setProperty("mailSubject");
                                      __jsp_tag_starteval=__jsp_taghandler_16.doStartTag();
                                      if (__jsp_taghandler_16.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_16,6);
                                    }
                                    out.write(__oracle_jsp_text[49]);
                                    {
                                      org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_17=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name property value");
                                      __jsp_taghandler_17.setParent(__jsp_taghandler_13);
                                      __jsp_taghandler_17.setName("notification");
                                      __jsp_taghandler_17.setProperty("flag");
                                      __jsp_taghandler_17.setValue("NEW");
                                      __jsp_tag_starteval=__jsp_taghandler_17.doStartTag();
                                      if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                                      {
                                        do {
                                          out.write(__oracle_jsp_text[50]);
                                          out.print(contextPath);
                                          out.write(__oracle_jsp_text[51]);
                                        } while (__jsp_taghandler_17.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                      }
                                      if (__jsp_taghandler_17.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_17,6);
                                    }
                                    out.write(__oracle_jsp_text[52]);
                                    {
                                      org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_18=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                                      __jsp_taghandler_18.setParent(__jsp_taghandler_13);
                                      __jsp_taghandler_18.setName("notification");
                                      __jsp_taghandler_18.setProperty("mailDateStr");
                                      __jsp_tag_starteval=__jsp_taghandler_18.doStartTag();
                                      if (__jsp_taghandler_18.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_18,6);
                                    }
                                    out.write(__oracle_jsp_text[53]);
                                  } while (__jsp_taghandler_13.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                  out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                                }
                                if (__jsp_taghandler_13.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_13,5);
                              }
                              out.write(__oracle_jsp_text[54]);
                            } while (__jsp_taghandler_12.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                          }
                          if (__jsp_taghandler_12.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_12,4);
                        }
                        out.write(__oracle_jsp_text[55]);
                        {
                          String __url=OracleJspRuntime.toStr("../common/tiles/pagination.jsp");
                          __url=OracleJspRuntime.genPageUrl(__url,request,response,new String[] {"formName" } ,new String[] {OracleJspRuntime.toStr("feserv13") } );
                          // Include 
                          pageContext.include( __url,false);
                          if (pageContext.getAttribute(OracleJspRuntime.JSP_REQUEST_REDIRECTED, PageContext.REQUEST_SCOPE) != null) return;
                        }

                        out.write(__oracle_jsp_text[56]);
                        out.write(__oracle_jsp_text[57]);
                        {
                          org.apache.struts.taglib.logic.NotEmptyTag __jsp_taghandler_19=(org.apache.struts.taglib.logic.NotEmptyTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEmptyTag.class,"org.apache.struts.taglib.logic.NotEmptyTag name property");
                          __jsp_taghandler_19.setParent(__jsp_taghandler_6);
                          __jsp_taghandler_19.setName("feserv13");
                          __jsp_taghandler_19.setProperty("esvMap");
                          __jsp_tag_starteval=__jsp_taghandler_19.doStartTag();
                          if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                          {
                            do {
                              out.write(__oracle_jsp_text[58]);
                              {
                                org.apache.struts.taglib.logic.IterateTag __jsp_taghandler_20=(org.apache.struts.taglib.logic.IterateTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.IterateTag.class,"org.apache.struts.taglib.logic.IterateTag id name property");
                                __jsp_taghandler_20.setParent(__jsp_taghandler_19);
                                __jsp_taghandler_20.setId("esvMap");
                                __jsp_taghandler_20.setName("feserv13");
                                __jsp_taghandler_20.setProperty("esvMap");
                                java.lang.Object esvMap = null;
                                __jsp_tag_starteval=__jsp_taghandler_20.doStartTag();
                                if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                                {
                                  out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_20,__jsp_tag_starteval,out);
                                  do {
                                    esvMap = (java.lang.Object) pageContext.findAttribute("esvMap");
                                    out.write(__oracle_jsp_text[59]);
                                    {
                                      org.apache.struts.taglib.bean.DefineTag __jsp_taghandler_21=(org.apache.struts.taglib.bean.DefineTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.DefineTag.class,"org.apache.struts.taglib.bean.DefineTag id name property");
                                      __jsp_taghandler_21.setParent(__jsp_taghandler_20);
                                      __jsp_taghandler_21.setId("moduleName");
                                      __jsp_taghandler_21.setName("esvMap");
                                      __jsp_taghandler_21.setProperty("key");
                                      __jsp_tag_starteval=__jsp_taghandler_21.doStartTag();
                                      if (__jsp_taghandler_21.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_21,6);
                                    }
                                    java.lang.Object moduleName = null;
                                    moduleName = (java.lang.Object) pageContext.findAttribute("moduleName");
                                    out.write(__oracle_jsp_text[60]);
                                    {
                                      org.apache.struts.taglib.bean.DefineTag __jsp_taghandler_22=(org.apache.struts.taglib.bean.DefineTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.DefineTag.class,"org.apache.struts.taglib.bean.DefineTag id name property type");
                                      __jsp_taghandler_22.setParent(__jsp_taghandler_20);
                                      __jsp_taghandler_22.setId("esvList");
                                      __jsp_taghandler_22.setName("esvMap");
                                      __jsp_taghandler_22.setProperty("value");
                                      __jsp_taghandler_22.setType("java.util.List");
                                      __jsp_tag_starteval=__jsp_taghandler_22.doStartTag();
                                      if (__jsp_taghandler_22.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_22,6);
                                    }
                                    java.util.List esvList = null;
                                    esvList = (java.util.List) pageContext.findAttribute("esvList");
                                    out.write(__oracle_jsp_text[61]);
                                    out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${moduleName}",java.lang.String.class, __ojsp_varRes, null));
                                    out.write(__oracle_jsp_text[62]);
                                    {
                                      org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_23=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name");
                                      __jsp_taghandler_23.setParent(__jsp_taghandler_20);
                                      __jsp_taghandler_23.setName("moduleName");
                                      __jsp_tag_starteval=__jsp_taghandler_23.doStartTag();
                                      if (__jsp_taghandler_23.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_23,6);
                                    }
                                    out.write(__oracle_jsp_text[63]);
                                    {
                                      org.apache.struts.taglib.logic.IterateTag __jsp_taghandler_24=(org.apache.struts.taglib.logic.IterateTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.IterateTag.class,"org.apache.struts.taglib.logic.IterateTag id indexId name type");
                                      __jsp_taghandler_24.setParent(__jsp_taghandler_20);
                                      __jsp_taghandler_24.setId("esv");
                                      __jsp_taghandler_24.setIndexId("index");
                                      __jsp_taghandler_24.setName("esvList");
                                      __jsp_taghandler_24.setType("com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceMRESMyEServiceMod");
                                      com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceMRESMyEServiceMod esv = null;
                                      java.lang.Integer index = null;
                                      __jsp_tag_starteval=__jsp_taghandler_24.doStartTag();
                                      if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                                      {
                                        out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_24,__jsp_tag_starteval,out);
                                        do {
                                          esv = (com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceMRESMyEServiceMod) pageContext.findAttribute("esv");
                                          index = (java.lang.Integer) pageContext.findAttribute("index");
                                          out.write(__oracle_jsp_text[64]);
                                          {
                                            org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_25=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property styleId");
                                            __jsp_taghandler_25.setParent(__jsp_taghandler_24);
                                            __jsp_taghandler_25.setName("esv");
                                            __jsp_taghandler_25.setProperty("usrLogin");
                                            __jsp_taghandler_25.setStyleId("usrLogin");
                                            __jsp_tag_starteval=__jsp_taghandler_25.doStartTag();
                                            if (__jsp_taghandler_25.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                              return;
                                            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_25,7);
                                          }
                                          out.write(__oracle_jsp_text[65]);
                                          {
                                            org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_26=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                                            __jsp_taghandler_26.setParent(__jsp_taghandler_24);
                                            __jsp_taghandler_26.setName("esv");
                                            __jsp_taghandler_26.setProperty("url");
                                            __jsp_tag_starteval=__jsp_taghandler_26.doStartTag();
                                            if (__jsp_taghandler_26.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                              return;
                                            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_26,7);
                                          }
                                          out.write(__oracle_jsp_text[66]);
                                          {
                                            org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_27=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                                            __jsp_taghandler_27.setParent(__jsp_taghandler_24);
                                            __jsp_taghandler_27.setName("esv");
                                            __jsp_taghandler_27.setProperty("menuName");
                                            __jsp_tag_starteval=__jsp_taghandler_27.doStartTag();
                                            if (__jsp_taghandler_27.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                              return;
                                            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_27,7);
                                          }
                                          out.write(__oracle_jsp_text[67]);
                                          {
                                            org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_28=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                                            __jsp_taghandler_28.setParent(__jsp_taghandler_24);
                                            __jsp_taghandler_28.setName("esv");
                                            __jsp_taghandler_28.setProperty("information");
                                            __jsp_tag_starteval=__jsp_taghandler_28.doStartTag();
                                            if (__jsp_taghandler_28.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                              return;
                                            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_28,7);
                                          }
                                          out.write(__oracle_jsp_text[68]);
                                        } while (__jsp_taghandler_24.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                        out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                                      }
                                      if (__jsp_taghandler_24.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                        return;
                                      OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_24,6);
                                    }
                                    out.write(__oracle_jsp_text[69]);
                                  } while (__jsp_taghandler_20.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                  out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                                }
                                if (__jsp_taghandler_20.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_20,5);
                              }
                              out.write(__oracle_jsp_text[70]);
                            } while (__jsp_taghandler_19.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                          }
                          if (__jsp_taghandler_19.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_19,4);
                        }
                        out.write(__oracle_jsp_text[71]);
                      } while (__jsp_taghandler_6.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                    }
                    if (__jsp_taghandler_6.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_6,3);
                  }
                  out.write(__oracle_jsp_text[72]);
                  {
                    org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_29=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name property value");
                    __jsp_taghandler_29.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_29.setName("feserv13");
                    __jsp_taghandler_29.setProperty("authPass");
                    __jsp_taghandler_29.setValue("false");
                    __jsp_tag_starteval=__jsp_taghandler_29.doStartTag();
                    if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                    {
                      do {
                        out.write(__oracle_jsp_text[73]);
                      } while (__jsp_taghandler_29.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                    }
                    if (__jsp_taghandler_29.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_29,3);
                  }
                  out.write(__oracle_jsp_text[74]);
                  out.print(contextPath);
                  out.write(__oracle_jsp_text[75]);
                  out.write(__oracle_jsp_text[76]);
                  out.write(__oracle_jsp_text[77]);
                  out.write(__oracle_jsp_text[78]);
                  out.write(__oracle_jsp_text[79]);
                } while (__jsp_taghandler_2.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,2);
            }
            out.write(__oracle_jsp_text[80]);
          } while (__jsp_taghandler_1.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[81]);

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
  private static final char __oracle_jsp_text[][]=new char[82][];
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
    "\r\n<head>\r\n<title>RCL Group</title>\r\n<meta content=\"text/html; charset=utf-8\" http-equiv=\"content-type\" />\r\n<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" >\r\n<link type=\"text/css\" href=\"".toCharArray();
    __oracle_jsp_text[13] = 
    "/css/registration/common.css\" rel=\"stylesheet\">\r\n<link type=\"text/css\" href=\"".toCharArray();
    __oracle_jsp_text[14] = 
    "/css/registration/mres.css\" rel=\"stylesheet\">\r\n<link type=\"text/css\" href=\"".toCharArray();
    __oracle_jsp_text[15] = 
    "/css/registration/reset.css\" rel=\"stylesheet\">\r\n<link type=\"text/css\" href=\"".toCharArray();
    __oracle_jsp_text[16] = 
    "/css/registration/style.css\" rel=\"stylesheet\">\r\n<script type=\"text/javascript\" src=\"".toCharArray();
    __oracle_jsp_text[17] = 
    "/js/screen/EserviceMRES.js\" ></script>\r\n<script type=\"text/javascript\" src=\"".toCharArray();
    __oracle_jsp_text[18] = 
    "/js/RutHelp.js\"></script>  \r\n<script type=\"text/javascript\">\r\n  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){\r\n  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),\r\n  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)\r\n  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');\r\n  ga('create', 'UA-39255240-1', 'rclgroup.com');\r\n  ga('send', 'pageview');\r\n</script>\r\n<script type=\"text/javascript\">\r\n    var MANAGE_ACCOUNT = '".toCharArray();
    __oracle_jsp_text[19] = 
    "';\r\n    var contextPath = '".toCharArray();
    __oracle_jsp_text[20] = 
    "';\r\n    \r\n    function getActionUrl(){\r\n        return '".toCharArray();
    __oracle_jsp_text[21] = 
    "';\r\n    }\r\n    \r\n    function getLogOutUrl(){\r\n        return '".toCharArray();
    __oracle_jsp_text[22] = 
    "';\r\n    }\r\n</script>\r\n</head>\r\n<body onload=\"window.history.forward(); onLoad();\">\r\n".toCharArray();
    __oracle_jsp_text[23] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[24] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[25] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[26] = 
    "\r\n    <div align=\"center\" style=\"width:100%\">\r\n    <table width=\"910\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\r\n    <tr>\r\n        <td>\r\n        <div style=\"width: 910px; position: relative;\">\r\n            <img src=\"".toCharArray();
    __oracle_jsp_text[27] = 
    "/images/registration/headertop.jpg\" border=\"0\" usemap=\"#Map\" alt=\"country\"  />\r\n            <div id=\"countryMenuDiv\" class=\"rcl_countries\">\r\n                <ul>\r\n                    <li><a href=\"default.aspx\">Home Page</a></li>\r\n                    <!--<li><a href=\"/hongkong/index.asp\" target=\"_blank\">Hong Kong</a></li>-->\r\n                    <li><a href=\"/Australia/\" target=\"_blank\">Australia</a></li>\r\n                    <li><a href=\"/china/\" target=\"_blank\">China �?海箱�?�??�?�</a></li>\r\n                    <!--<li><a href=\"/indonesia/RCL_files/home.asp\" target=\"_blank\">Indonesia</a></li>-->\r\n                </ul>\r\n            </div>\r\n            <map name=\"Map\" id=\"Map\" >\r\n                <area shape=\"rect\" coords=\"5, 6, 123, 64\" href=\"default.aspx\" target=\"_self\" alt=\"Country list\" onclick=\"backHome();\" />\r\n                <!--<area shape=\"rect\" coords=\"621, 22, 670, 51\" href=\"rclhotline_00.asp\" target=\"_self\" />-->\r\n            </map>\r\n        </div>\r\n        </td>\r\n    </tr>\r\n    <tr style=\"height: 30px\">\r\n        <td>\r\n            <a href=\"javascript:backHome();\" style=\"text-decoration: underline;\">Home</a>&nbsp;\r\n            <a href=\"".toCharArray();
    __oracle_jsp_text[28] = 
    "/download/setup.zip\" target=\"_blank\" style=\"text-decoration: underline;\" >Download eService setup</a>&nbsp;\r\n            <a href=\"".toCharArray();
    __oracle_jsp_text[29] = 
    "/help/eService.html\" target=\"_blank\" style=\"text-decoration: underline;\" >Help</a>\r\n        </td>\r\n    </tr>\r\n    ".toCharArray();
    __oracle_jsp_text[30] = 
    "\r\n    <tr style=\"height: 30px\">\r\n        <td style=\"padding-bottom: 10px\">\r\n            <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"padding-top: 10px; padding-bottom: 10px\">\r\n            <tr>\r\n                <td width=\"60%\" valign=\"top\">\r\n                    <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n                    <tr><td><span class=\"font_header\" style=\"font-size: 18px; padding-top: 5px; padding-bottom: 5px\">My RCL e-SERVICES</span></td></tr>\r\n                    <tr>\r\n                        <td style=\"padding-top: 5px; padding-bottom: 5px\">\r\n                             <span  class=\"font_header\"  style=\"color: #1f497d; font-size: 16px; font-style: italic\">\r\n                             Welcome, ".toCharArray();
    __oracle_jsp_text[31] = 
    " : ".toCharArray();
    __oracle_jsp_text[32] = 
    "\r\n                            </span>\r\n                        </td>\r\n                    </tr>\r\n                    </table>\r\n                </td>\r\n                <td align=\"right\" valign=\"top\">\r\n                <div class=\"spotlight-action\" align=\"right\" style=\"vertical-align: top;\">\r\n                    <!--<a href=\"D:/setup.zip\" target=\"_blank\" >Download eService setup1</a> -->\r\n                    <a id=\"manageMyAccountBtn\" class=\"m-btn mini blue rnd\" style=\"vertical-align: top; height: 15px; \" \r\n                    href=\"javascript: void(0);\" onclick=\"manageAccount();\">\r\n                        Manage My Account <i class=\"icon-cog icon-white\"></i>\r\n                    </a>\r\n                    <a id=\"logoutBtn\" class=\"m-btn mini blue rnd\" style=\"visiblity: visible; vertical-align: top;  height: 15px\"\r\n                    href=\"javascript:void(0)\" onClick=\"clearMsg(); logout();\" >Log Out <i class=\"m-icon-swapright m-icon-white\"></i>\r\n                    </a>\r\n                </div>\r\n                </td>\r\n            </tr>\r\n            </table>\r\n        </td>\r\n    </tr>\r\n    <tr>\r\n        <td>\r\n        ".toCharArray();
    __oracle_jsp_text[33] = 
    "\r\n            <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"table_main_detail\">\r\n            <tr class=\"table_tr_header\">\r\n                <td  class=\"font_header\">\r\n                        Notifications (".toCharArray();
    __oracle_jsp_text[34] = 
    ")\r\n                </td>\r\n            </tr>\r\n            <tr>\r\n                <td align=\"center\" class=\"td_sub_detail\">\r\n                    <table id=\"notificationTable\" width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\"\r\n                            style=\"border: solid 1px #dcdcdc\">\r\n                    <tr class=\"tr_sub_detail tr_table_display_detail\">\r\n                        <td width=\"10%\" class=\"font_sub_header td_table_display_detail\" \r\n                        style=\"vertical-align: middle;  border-right: transparent; padding: 0px\">\r\n                            <table width=\"100%\" align=\"right\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" >\r\n                            <tr>\r\n                                <td style=\"vertical-align: middle; width: 100%; padding-left: 10px\">ID</td>\r\n                                <td align=\"right\" style=\"vertical-align: middle; width: 21px\">\r\n                                    <img id=\"idSortImg\" src=\"".toCharArray();
    __oracle_jsp_text[35] = 
    "/images/mres/mres_sort_asc.gif\" style=\"cursor: pointer;\" \r\n                                    align=\"right\" border=\"0\" onClick=\"clickNotificationSorting(SORT_TYPE_ID, '".toCharArray();
    __oracle_jsp_text[36] = 
    "');\" />\r\n                                </td>\r\n                            </tr>\r\n                            </table>\r\n                        </td>\r\n                        <td width=\"70%\" class=\"font_sub_header td_table_display_detail\" \r\n                        style=\"vertical-align: middle; border-right: transparent; padding: 0px\">\r\n                            <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n                            <tr>\r\n                                <td width=\"100%\" style=\"vertical-align: middle; width: 100%; padding-left: 10px\">Subject</td>\r\n                                <td align=\"right\" style=\"vertical-align: middle; width: 21px\">\r\n                                    <img id=\"subjectSortImg\" src=\"".toCharArray();
    __oracle_jsp_text[37] = 
    "/images/mres/mres_sort_asc.gif\" style=\"cursor: pointer; text-align:right\"\r\n                                    align=\"right\" border=\"0\" onClick=\"clickNotificationSorting(SORT_TYPE_SUBJECT, '".toCharArray();
    __oracle_jsp_text[38] = 
    "');\" />\r\n                                </td>\r\n                            </tr>\r\n                            </table>\r\n                        </td>\r\n                        <td width=\"20%\" class=\"font_sub_header td_table_display_detail\" \r\n                        style=\"vertical-align: middle; padding: 0px; border-right: transparent\" >\r\n                            <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n                            <tr>\r\n                                <td style=\"vertical-align: middle; width: 100%; padding-left: 10px\">Date</td>\r\n                                <td align=\"right\" style=\"vertical-align: middle; width: 21px\">\r\n                                    <img id=\"dateSortImg\" src=\"".toCharArray();
    __oracle_jsp_text[39] = 
    "/images/mres/mres_sort_asc.gif\" style=\"cursor: pointer;\"\r\n                                    align=\"right\" border=\"0\" onClick=\"clickNotificationSorting(SORT_TYPE_DATE, '".toCharArray();
    __oracle_jsp_text[40] = 
    "');\" />\r\n                                </td>\r\n                            </tr>\r\n                            </table>\r\n                        </td>\r\n                    </tr>\r\n                ".toCharArray();
    __oracle_jsp_text[41] = 
    "\r\n                    ".toCharArray();
    __oracle_jsp_text[42] = 
    "\r\n                    <tr class=\"tr_sub_detail\">\r\n                        <td class=\"td_table_display_detail\" style=\"vertical-align: middle; text-align: center;\">\r\n                            ".toCharArray();
    __oracle_jsp_text[43] = 
    "\r\n                        </td>\r\n                        <td class=\"td_table_display_detail\" style=\"vertical-align: middle;\">\r\n                            <div id=\"mailSubjectDiv".toCharArray();
    __oracle_jsp_text[44] = 
    "\" style=\"z-index: 5; visibility: hidden\"></div>\r\n                            <input type=\"hidden\" id=\"mailSubjectHid".toCharArray();
    __oracle_jsp_text[45] = 
    "\" name=\"mailSubjectHid\" value=\"".toCharArray();
    __oracle_jsp_text[46] = 
    "\" />\r\n                            <a id=\"mailSubject".toCharArray();
    __oracle_jsp_text[47] = 
    "\" href=\"javascript:void(0)\" \r\n                            style=\"text-decoration: none; color: #000000;\"\r\n                            onmouseover=\"loadMailBody(this, ".toCharArray();
    __oracle_jsp_text[48] = 
    ");\">\r\n                                ".toCharArray();
    __oracle_jsp_text[49] = 
    "\r\n                                ".toCharArray();
    __oracle_jsp_text[50] = 
    "\r\n                                    &nbsp;<img src=\"".toCharArray();
    __oracle_jsp_text[51] = 
    "/images/mres/icon_new.gif\" border=\"0\" />\r\n                                ".toCharArray();
    __oracle_jsp_text[52] = 
    "\r\n                            </a>\r\n                        </td>\r\n                        <td class=\"td_table_display_detail\" style=\"vertical-align: middle; text-align: center; border-right: transparent\">\r\n                            ".toCharArray();
    __oracle_jsp_text[53] = 
    "\r\n                        </td>\r\n                    </tr>\r\n                    ".toCharArray();
    __oracle_jsp_text[54] = 
    "\r\n                ".toCharArray();
    __oracle_jsp_text[55] = 
    "\r\n                    <tr class=\"tr_sub_detail tr_table_display_detail\">\r\n                        <td colspan=\"4\">\r\n                    ".toCharArray();
    __oracle_jsp_text[56] = 
    "\r\n                        </td>\r\n                    </tr>\r\n                    </table>\r\n                </td>\r\n            </tr>\r\n            </table>\r\n            \r\n        ".toCharArray();
    __oracle_jsp_text[57] = 
    "\r\n        </td>\r\n    </tr>\r\n    <tr><td>&nbsp;</td></tr>\r\n    <tr>\r\n        <td>\r\n        <!-- ########## Company Details START ########### -->\r\n            <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"table_main_detail\">\r\n            <tr class=\"table_tr_header\">\r\n                <td  class=\"font_header\">\r\n                        My e-SERVICES\r\n                </td>\r\n            </tr>\r\n            <tr>\r\n                <td align=\"center\" class=\"td_sub_detail\">\r\n        ".toCharArray();
    __oracle_jsp_text[58] = 
    "\r\n            ".toCharArray();
    __oracle_jsp_text[59] = 
    "\r\n                ".toCharArray();
    __oracle_jsp_text[60] = 
    "\r\n                ".toCharArray();
    __oracle_jsp_text[61] = 
    "\r\n                <div id=\"".toCharArray();
    __oracle_jsp_text[62] = 
    "Div\">\r\n                    <table width=\"700\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"left\" class=\"table_sub_detail\"\r\n                    style=\"border: solid 1px #dcdcdc\">\r\n                    <tr class=\"tr_sub_detail tr_table_display_detail\">\r\n                        <td width=\"30%\" class=\"font_sub_header td_table_display_detail\"\r\n                        style=\"vertical-align: middle; padding-left: 5px\">\r\n                            ".toCharArray();
    __oracle_jsp_text[63] = 
    "\r\n                        </td>\r\n                        <td width=\"70%\" class=\"font_sub_header td_table_display_detail_last\"\r\n                        style=\"vertical-align: middle; padding-left: 5px\">Information</td>\r\n                    </tr>\r\n                ".toCharArray();
    __oracle_jsp_text[64] = 
    "\r\n                    <tr class=\"tr_sub_detail\">\r\n                        <td class=\"td_table_display_detail td_myeservice_detail\">\r\n                            ".toCharArray();
    __oracle_jsp_text[65] = 
    "\r\n                            <a href=\"javascript: openScreenForMRES('".toCharArray();
    __oracle_jsp_text[66] = 
    "', 'eServices');\">\r\n                                ".toCharArray();
    __oracle_jsp_text[67] = 
    "\r\n                            </a>\r\n                        </td>\r\n                        <td class=\"td_table_display_detail_last td_myeservice_detail\">\r\n                            ".toCharArray();
    __oracle_jsp_text[68] = 
    "\r\n                        </td>\r\n                    </tr>\r\n                    ".toCharArray();
    __oracle_jsp_text[69] = 
    "\r\n                    </table>\r\n                </div>\r\n                <span style=\"height: 20px\">&nbsp;</span>\r\n            ".toCharArray();
    __oracle_jsp_text[70] = 
    "\r\n        ".toCharArray();
    __oracle_jsp_text[71] = 
    "\r\n                </td>\r\n            </tr>\r\n            </table>\r\n        <!-- ########## Company Details END ########### -->\r\n        </td>\r\n    </tr>\r\n    ".toCharArray();
    __oracle_jsp_text[72] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[73] = 
    "\r\n    <tr>\r\n        <td>\r\n            <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"table_main_detail\">\r\n            <tr class=\"table_tr_header\">\r\n                <td  class=\"font_header\">\r\n                        Login Fail\r\n                </td>\r\n            </tr>\r\n            <tr style=\"height: 50px\">\r\n                 <td align=\"center\" class=\"td_sub_detail\" style=\"text-align: middle;\">\r\n                    User ID or Password incorrect , <a href=\"http://www.rclgroup.com\">Click here</a> to re login\r\n                 </td>\r\n            </tr>\r\n            </table>\r\n        </td>\r\n    </tr>\r\n    ".toCharArray();
    __oracle_jsp_text[74] = 
    "\r\n    <tr style=\"height: 20px\"><td></td></tr>\r\n    <tr>\r\n        <td>\r\n        <div id=\"footerbox\">\r\n\t    <div id=\"footermain\">\r\n\t        <div style=\"width: 910px;\">\r\n\t            <img class=\"homepageFooterDivider\" src=\"".toCharArray();
    __oracle_jsp_text[75] = 
    "/images/registration/divbottom.jpg\" border=\"0\" />\r\n\t            <p style=\"text-align: center; font-family: Arial; font-size: 10px; line-height: 2em;\">\r\n\t                Copyright 2011 Regional Container Lines. All rights reserved. \r\n\t            </p>\r\n\t\t    \r\n\t\t    <p style=\"text-align: center;\"> \r\n                        <font style=\"text-align: center; font-family: Arial; font-size: 10px; line-height: 2em;\">\r\n\t\t\t".toCharArray();
    __oracle_jsp_text[76] = 
    "\r\n                            Terms of Use\r\n                            ".toCharArray();
    __oracle_jsp_text[77] = 
    "\r\n                        </font>\r\n\t\t\t<font style=\"text-align: center; font-family: Arial; font-size: 10px; line-height: 2em;\">&nbsp;|&nbsp;</font>\r\n\t\t\t<font style=\"text-align: center; font-family: Arial; font-size: 10px; line-height: 2em;\">\r\n\t\t\t".toCharArray();
    __oracle_jsp_text[78] = 
    "\r\n                            Privacy Policy".toCharArray();
    __oracle_jsp_text[79] = 
    "\r\n                        </font>\t\r\n\t\t\t<font style=\"text-align: center; font-family: Arial; font-size: 10px; line-height: 2em;\">&nbsp;|&nbsp;</font>\r\n                        <font style=\"text-align: center; font-family: Arial; font-size: 10px; line-height: 2em;\">\r\n\t\t\tThis website is best viewed with IE 9.x and above.\r\n                        </font>\t\r\n\t\t    </p>\r\n\t        </div>\r\n\t    </div>\r\n\t</div>\r\n        </td>\r\n    </tr>\r\n    <tr style=\"height: 50px\"><td></td></tr>\r\n    </table>\r\n    </div>\r\n".toCharArray();
    __oracle_jsp_text[80] = 
    "\r\n</body>\r\n".toCharArray();
    __oracle_jsp_text[81] = 
    "\r\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
