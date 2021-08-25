package _pages._eshipping;

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
import com.rclgroup.dolphin.rcl.web.eservice.dao.EshippingInstructionDao;


public class _EshippingBookingNumberPopup extends com.orionserver.http.OrionHttpJspPage {


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
    _EshippingBookingNumberPopup page = this;
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
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv006GetData", pageContext));
      out.write(__oracle_jsp_text[13]);
      out.print(com.niit.control.web.JSPUtils.getActionMappingURL("/serv012LookUpData", pageContext));
      out.write(__oracle_jsp_text[14]);
      {
        org.apache.struts.taglib.html.FormTag __jsp_taghandler_1=(org.apache.struts.taglib.html.FormTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.FormTag.class,"org.apache.struts.taglib.html.FormTag action method");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setAction("/serv012");
        __jsp_taghandler_1.setMethod("POST");
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[15]);
            {
              org.apache.struts.taglib.html.HiddenTag __jsp_taghandler_2=(org.apache.struts.taglib.html.HiddenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.HiddenTag.class,"org.apache.struts.taglib.html.HiddenTag name property");
              __jsp_taghandler_2.setParent(__jsp_taghandler_1);
              __jsp_taghandler_2.setName("feserv15");
              __jsp_taghandler_2.setProperty("page");
              __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
              if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,2);
            }
            out.write(__oracle_jsp_text[16]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_3=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag name onblur property");
              __jsp_taghandler_3.setParent(__jsp_taghandler_1);
              __jsp_taghandler_3.setName("feserv15");
              __jsp_taghandler_3.setOnblur("changeUpper(this)");
              __jsp_taghandler_3.setProperty("tbxFind");
              __jsp_tag_starteval=__jsp_taghandler_3.doStartTag();
              if (__jsp_taghandler_3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_3,2);
            }
            out.write(__oracle_jsp_text[17]);
            {
              org.apache.struts.taglib.html.SelectTag __jsp_taghandler_4=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name property size");
              __jsp_taghandler_4.setParent(__jsp_taghandler_1);
              __jsp_taghandler_4.setName("feserv15");
              __jsp_taghandler_4.setProperty("columnValue");
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
                    __jsp_taghandler_5.setName("feserv15");
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
              __jsp_taghandler_6.setName("feserv15");
              __jsp_taghandler_6.setProperty("statusValue");
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
                    __jsp_taghandler_7.setName("feserv15");
                    __jsp_taghandler_7.setProperty("statusList");
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
              __jsp_taghandler_8.setName("feserv15");
              __jsp_taghandler_8.setProperty("sortByValue");
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
                    __jsp_taghandler_9.setName("feserv15");
                    __jsp_taghandler_9.setProperty("sortByList");
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
              org.apache.struts.taglib.html.SelectTag __jsp_taghandler_10=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag name property size");
              __jsp_taghandler_10.setParent(__jsp_taghandler_1);
              __jsp_taghandler_10.setName("feserv15");
              __jsp_taghandler_10.setProperty("orderValue");
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
                    __jsp_taghandler_11.setName("feserv15");
                    __jsp_taghandler_11.setProperty("orderList");
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
              org.apache.struts.taglib.html.CheckboxTag __jsp_taghandler_12=(org.apache.struts.taglib.html.CheckboxTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.CheckboxTag.class,"org.apache.struts.taglib.html.CheckboxTag name property style");
              __jsp_taghandler_12.setParent(__jsp_taghandler_1);
              __jsp_taghandler_12.setName("feserv15");
              __jsp_taghandler_12.setProperty("chkBoxWildCard");
              __jsp_taghandler_12.setStyle("float:left;border:0px;width:5%");
              __jsp_tag_starteval=__jsp_taghandler_12.doStartTag();
              if (__jsp_taghandler_12.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_12,2);
            }
            out.write(__oracle_jsp_text[30]);
            out.print(EshippingInstructionDao.KEY_COLUMN_SHOW_BOOKING_DATE);
            out.write(__oracle_jsp_text[31]);
            out.print(EshippingInstructionDao.KEY_COLUMN_SHOW_BOOKING_NO);
            out.write(__oracle_jsp_text[32]);
            out.print(EshippingInstructionDao.KEY_COLUMN_SHOW_SHIPPER_NAME);
            out.write(__oracle_jsp_text[33]);
            out.print(EshippingInstructionDao.KEY_COLUMN_SHOW_LEG_VESSEL);
            out.write(__oracle_jsp_text[34]);
            out.print(EshippingInstructionDao.KEY_COLUMN_SHOW_LEG_VOYAGE);
            out.write(__oracle_jsp_text[35]);
            out.print(EshippingInstructionDao.KEY_COLUMN_SHOW_POL);
            out.write(__oracle_jsp_text[36]);
            out.print(EshippingInstructionDao.KEY_COLUMN_SHOW_POD);
            out.write(__oracle_jsp_text[37]);
            out.print(EshippingInstructionDao.KEY_COLUMN_SHOW_STATUS);
            out.write(__oracle_jsp_text[38]);
            out.print(EshippingInstructionDao.KEY_COLUMN_SHOW_BL_NO);
            out.write(__oracle_jsp_text[39]);
            {
              org.apache.struts.taglib.logic.NotEmptyTag __jsp_taghandler_13=(org.apache.struts.taglib.logic.NotEmptyTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEmptyTag.class,"org.apache.struts.taglib.logic.NotEmptyTag name property");
              __jsp_taghandler_13.setParent(__jsp_taghandler_1);
              __jsp_taghandler_13.setName("feserv15");
              __jsp_taghandler_13.setProperty("bookingList");
              __jsp_tag_starteval=__jsp_taghandler_13.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[40]);
                  {
                    org.apache.struts.taglib.logic.IterateTag __jsp_taghandler_14=(org.apache.struts.taglib.logic.IterateTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.IterateTag.class,"org.apache.struts.taglib.logic.IterateTag id indexId name property");
                    __jsp_taghandler_14.setParent(__jsp_taghandler_13);
                    __jsp_taghandler_14.setId("list");
                    __jsp_taghandler_14.setIndexId("index");
                    __jsp_taghandler_14.setName("feserv15");
                    __jsp_taghandler_14.setProperty("bookingList");
                    java.lang.Object list = null;
                    java.lang.Integer index = null;
                    __jsp_tag_starteval=__jsp_taghandler_14.doStartTag();
                    if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                    {
                      out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_14,__jsp_tag_starteval,out);
                      do {
                        list = (java.lang.Object) pageContext.findAttribute("list");
                        index = (java.lang.Integer) pageContext.findAttribute("index");
                        out.write(__oracle_jsp_text[41]);
                        out.write(__oracle_jsp_text[42]);
                        out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${index}",java.lang.String.class, __ojsp_varRes, null));
                        out.write(__oracle_jsp_text[43]);
                        {
                          org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_15=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                          __jsp_taghandler_15.setParent(__jsp_taghandler_14);
                          __jsp_taghandler_15.setName("list");
                          __jsp_taghandler_15.setProperty("bookingNo");
                          __jsp_tag_starteval=__jsp_taghandler_15.doStartTag();
                          if (__jsp_taghandler_15.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_15,4);
                        }
                        out.write(__oracle_jsp_text[44]);
                        {
                          org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_16=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                          __jsp_taghandler_16.setParent(__jsp_taghandler_14);
                          __jsp_taghandler_16.setName("list");
                          __jsp_taghandler_16.setProperty("blNo");
                          __jsp_tag_starteval=__jsp_taghandler_16.doStartTag();
                          if (__jsp_taghandler_16.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_16,4);
                        }
                        out.write(__oracle_jsp_text[45]);
                        {
                          org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_17=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                          __jsp_taghandler_17.setParent(__jsp_taghandler_14);
                          __jsp_taghandler_17.setName("list");
                          __jsp_taghandler_17.setProperty("esiStatusCode");
                          __jsp_tag_starteval=__jsp_taghandler_17.doStartTag();
                          if (__jsp_taghandler_17.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_17,4);
                        }
                        out.write(__oracle_jsp_text[46]);
                        {
                          org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_18=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                          __jsp_taghandler_18.setParent(__jsp_taghandler_14);
                          __jsp_taghandler_18.setName("list");
                          __jsp_taghandler_18.setProperty("esiStatusDesc");
                          __jsp_tag_starteval=__jsp_taghandler_18.doStartTag();
                          if (__jsp_taghandler_18.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_18,4);
                        }
                        out.write(__oracle_jsp_text[47]);
                        {
                          org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_19=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                          __jsp_taghandler_19.setParent(__jsp_taghandler_14);
                          __jsp_taghandler_19.setName("list");
                          __jsp_taghandler_19.setProperty("cocSoc");
                          __jsp_tag_starteval=__jsp_taghandler_19.doStartTag();
                          if (__jsp_taghandler_19.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_19,4);
                        }
                        out.write(__oracle_jsp_text[48]);
                        out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${index}",java.lang.String.class, __ojsp_varRes, null));
                        out.write(__oracle_jsp_text[49]);
                        {
                          org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_20=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                          __jsp_taghandler_20.setParent(__jsp_taghandler_14);
                          __jsp_taghandler_20.setName("list");
                          __jsp_taghandler_20.setProperty("bookingDate");
                          __jsp_tag_starteval=__jsp_taghandler_20.doStartTag();
                          if (__jsp_taghandler_20.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_20,4);
                        }
                        out.write(__oracle_jsp_text[50]);
                        {
                          org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_21=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                          __jsp_taghandler_21.setParent(__jsp_taghandler_14);
                          __jsp_taghandler_21.setName("list");
                          __jsp_taghandler_21.setProperty("bookingNo");
                          __jsp_tag_starteval=__jsp_taghandler_21.doStartTag();
                          if (__jsp_taghandler_21.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_21,4);
                        }
                        out.write(__oracle_jsp_text[51]);
                        {
                          org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_22=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                          __jsp_taghandler_22.setParent(__jsp_taghandler_14);
                          __jsp_taghandler_22.setName("list");
                          __jsp_taghandler_22.setProperty("shipperName");
                          __jsp_tag_starteval=__jsp_taghandler_22.doStartTag();
                          if (__jsp_taghandler_22.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_22,4);
                        }
                        out.write(__oracle_jsp_text[52]);
                        {
                          org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_23=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                          __jsp_taghandler_23.setParent(__jsp_taghandler_14);
                          __jsp_taghandler_23.setName("list");
                          __jsp_taghandler_23.setProperty("legVessel");
                          __jsp_tag_starteval=__jsp_taghandler_23.doStartTag();
                          if (__jsp_taghandler_23.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_23,4);
                        }
                        out.write(__oracle_jsp_text[53]);
                        {
                          org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_24=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                          __jsp_taghandler_24.setParent(__jsp_taghandler_14);
                          __jsp_taghandler_24.setName("list");
                          __jsp_taghandler_24.setProperty("legVoyage");
                          __jsp_tag_starteval=__jsp_taghandler_24.doStartTag();
                          if (__jsp_taghandler_24.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_24,4);
                        }
                        out.write(__oracle_jsp_text[54]);
                        {
                          org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_25=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                          __jsp_taghandler_25.setParent(__jsp_taghandler_14);
                          __jsp_taghandler_25.setName("list");
                          __jsp_taghandler_25.setProperty("pol");
                          __jsp_tag_starteval=__jsp_taghandler_25.doStartTag();
                          if (__jsp_taghandler_25.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_25,4);
                        }
                        out.write(__oracle_jsp_text[55]);
                        {
                          org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_26=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                          __jsp_taghandler_26.setParent(__jsp_taghandler_14);
                          __jsp_taghandler_26.setName("list");
                          __jsp_taghandler_26.setProperty("pod");
                          __jsp_tag_starteval=__jsp_taghandler_26.doStartTag();
                          if (__jsp_taghandler_26.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_26,4);
                        }
                        out.write(__oracle_jsp_text[56]);
                        {
                          org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_27=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                          __jsp_taghandler_27.setParent(__jsp_taghandler_14);
                          __jsp_taghandler_27.setName("list");
                          __jsp_taghandler_27.setProperty("esiStatusDesc");
                          __jsp_tag_starteval=__jsp_taghandler_27.doStartTag();
                          if (__jsp_taghandler_27.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_27,4);
                        }
                        out.write(__oracle_jsp_text[57]);
                        {
                          org.apache.struts.taglib.bean.WriteTag __jsp_taghandler_28=(org.apache.struts.taglib.bean.WriteTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.bean.WriteTag.class,"org.apache.struts.taglib.bean.WriteTag name property");
                          __jsp_taghandler_28.setParent(__jsp_taghandler_14);
                          __jsp_taghandler_28.setName("list");
                          __jsp_taghandler_28.setProperty("blNo");
                          __jsp_tag_starteval=__jsp_taghandler_28.doStartTag();
                          if (__jsp_taghandler_28.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_28,4);
                        }
                        out.write(__oracle_jsp_text[58]);
                        out.write(__oracle_jsp_text[59]);
                      } while (__jsp_taghandler_14.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                      out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                    }
                    if (__jsp_taghandler_14.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_14,3);
                  }
                  out.write(__oracle_jsp_text[60]);
                } while (__jsp_taghandler_13.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_13.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_13,2);
            }
            out.write(__oracle_jsp_text[61]);
            {
              org.apache.struts.taglib.logic.EmptyTag __jsp_taghandler_29=(org.apache.struts.taglib.logic.EmptyTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EmptyTag.class,"org.apache.struts.taglib.logic.EmptyTag name property");
              __jsp_taghandler_29.setParent(__jsp_taghandler_1);
              __jsp_taghandler_29.setName("feserv15");
              __jsp_taghandler_29.setProperty("bookingList");
              __jsp_tag_starteval=__jsp_taghandler_29.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[62]);
                } while (__jsp_taghandler_29.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_29.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_29,2);
            }
            out.write(__oracle_jsp_text[63]);
            {
              String __url=OracleJspRuntime.toStr("../common/tiles/pagination.jsp");
              __url=OracleJspRuntime.genPageUrl(__url,request,response,new String[] {"formName" } ,new String[] {OracleJspRuntime.toStr("feserv15") } );
              // Include 
              pageContext.include( __url,false);
              if (pageContext.getAttribute(OracleJspRuntime.JSP_REQUEST_REDIRECTED, PageContext.REQUEST_SCOPE) != null) return;
            }

            out.write(__oracle_jsp_text[64]);
          } while (__jsp_taghandler_1.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[65]);

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
  private static final char __oracle_jsp_text[][]=new char[66][];
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
    "\r\n\r\n<head>\r\n<script type=\"text/javascript\" language=\"JavaScript\" src=\"".toCharArray();
    __oracle_jsp_text[11] = 
    "/js/RutHelp.js\" ></script>\r\n<script type=\"text/javascript\" language=\"JavaScript\" src=\"".toCharArray();
    __oracle_jsp_text[12] = 
    "/js/screen/EshippingBookingNumberPopup.js\" ></script>\r\n<script type=\"text/javascript\" language=\"JavaScript\">\r\n    var GET_BOOKING_NUMBER_TO_ESHIPPING_PAGE = '".toCharArray();
    __oracle_jsp_text[13] = 
    "';  \r\n    var BROWSE_BOOKING_NUMBER = '".toCharArray();
    __oracle_jsp_text[14] = 
    "';\r\n</script>\r\n</head>\r\n\r\n<body>    \r\n    ".toCharArray();
    __oracle_jsp_text[15] = 
    "         \r\n        ".toCharArray();
    __oracle_jsp_text[16] = 
    "\r\n        <input type=\"hidden\" name=\"pageId\" value=\"bookingPopup\"/>\r\n        <table class=\"table_search\" border=\"0\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\r\n            <tr>\r\n                <td width=\"6%\">Find</td>\r\n                <td width=\"23%\">\r\n                    ".toCharArray();
    __oracle_jsp_text[17] = 
    "\r\n                </td>\r\n                <td width=\"7%\">Column</td>\r\n                <td width=\"23%\">\r\n                    ".toCharArray();
    __oracle_jsp_text[18] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[19] = 
    "\r\n                    ".toCharArray();
    __oracle_jsp_text[20] = 
    "\r\n                </td>\r\n                <td width=\"8%\" style=\"padding-left:6px\">eSI Status</td>\r\n                <td width=\"18%\">\r\n                    ".toCharArray();
    __oracle_jsp_text[21] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[22] = 
    "\r\n                    ".toCharArray();
    __oracle_jsp_text[23] = 
    "\r\n                </td>\r\n                <td valign=\"top\" style=\"padding-top:1px\">\r\n                    <a id=\"btnSearch\" name=\"btnSearch\" class=\"m-btn mini blue rnd\"\r\n                        href=\"#\" onclick=\"searchBtn();\" >&nbsp;Search\r\n                    </a>\r\n                    <a id=\"btnReset\" name=\"btnReset\" class=\"m-btn mini blue rnd\"\r\n                        href=\"#\" onClick=\"resetBtn()\">&nbsp;Reset\r\n                    </a>\r\n                </td>\r\n            </tr>\r\n            <tr>\r\n                <td>Sort by</td>\r\n                <td>\r\n                    ".toCharArray();
    __oracle_jsp_text[24] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[25] = 
    "\r\n                    ".toCharArray();
    __oracle_jsp_text[26] = 
    "\r\n                </td>\r\n                <td>Order by</td>\r\n                <td>\r\n                    ".toCharArray();
    __oracle_jsp_text[27] = 
    "\r\n                        ".toCharArray();
    __oracle_jsp_text[28] = 
    "\r\n                    ".toCharArray();
    __oracle_jsp_text[29] = 
    "\r\n                <td colspan=\"3\">\r\n                    ".toCharArray();
    __oracle_jsp_text[30] = 
    "Wild Card\r\n                </td>\r\n            </tr>\r\n        </table><br>\r\n        <table class=\"TablePopup\">\r\n        <tr>\r\n            <td class=\"TdLeftHeaderPopup\" width=\"11%\">".toCharArray();
    __oracle_jsp_text[31] = 
    "</td>\r\n            <td class=\"TdLeftHeaderPopup\" width=\"11%\">".toCharArray();
    __oracle_jsp_text[32] = 
    "</td>\r\n            <!-- @01 BEGIN--> \r\n            <td class=\"TdLeftHeaderPopup\" width=\"21%\">".toCharArray();
    __oracle_jsp_text[33] = 
    "</td>\r\n            <!-- @01 END-->\r\n            <td class=\"TdLeftHeaderPopup\" width=\"6%\">".toCharArray();
    __oracle_jsp_text[34] = 
    "</td>\r\n            <td class=\"TdLeftHeaderPopup\" width=\"6%\">".toCharArray();
    __oracle_jsp_text[35] = 
    "</td>\r\n            <td class=\"TdLeftHeaderPopup\" width=\"11%\">".toCharArray();
    __oracle_jsp_text[36] = 
    "</td>\r\n            <td class=\"TdLeftHeaderPopup\" width=\"11%\">".toCharArray();
    __oracle_jsp_text[37] = 
    "</td>\r\n            <td class=\"TdLeftHeaderPopup\" width=\"11%\">".toCharArray();
    __oracle_jsp_text[38] = 
    "</td>\r\n            <td class=\"TdLeftHeaderPopup\">".toCharArray();
    __oracle_jsp_text[39] = 
    "</td>\r\n        </tr>\r\n    ".toCharArray();
    __oracle_jsp_text[40] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[41] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[42] = 
    "\r\n        <tr id=\"row".toCharArray();
    __oracle_jsp_text[43] = 
    "\" ondblclick=\"callbackToField('".toCharArray();
    __oracle_jsp_text[44] = 
    "', \r\n        '".toCharArray();
    __oracle_jsp_text[45] = 
    "', '".toCharArray();
    __oracle_jsp_text[46] = 
    "', \r\n        '".toCharArray();
    __oracle_jsp_text[47] = 
    "', '".toCharArray();
    __oracle_jsp_text[48] = 
    "')\" \r\n        onclick=\"highlightRadioTD('row".toCharArray();
    __oracle_jsp_text[49] = 
    "')\" style=\"cursor:hand;\">\r\n            <td class=\"TdLeftDetailPopup\" height=\"20px\">".toCharArray();
    __oracle_jsp_text[50] = 
    "</td>\r\n            <td class=\"TdLeftDetailPopup\" height=\"20px\">".toCharArray();
    __oracle_jsp_text[51] = 
    "</td>\r\n            <!-- @01 BEGIN-->\r\n            <td class=\"TdLeftDetailPopup\" height=\"20px\">".toCharArray();
    __oracle_jsp_text[52] = 
    "</td>\r\n            <!-- @01 END-->\r\n            <td class=\"TdLeftDetailPopup\" height=\"20px\">".toCharArray();
    __oracle_jsp_text[53] = 
    "</td>\r\n            <td class=\"TdLeftDetailPopup\" height=\"20px\">".toCharArray();
    __oracle_jsp_text[54] = 
    "</td>\r\n            <td class=\"TdLeftDetailPopup\" height=\"20px\">".toCharArray();
    __oracle_jsp_text[55] = 
    "</td>\r\n            <td class=\"TdLeftDetailPopup\" height=\"20px\">".toCharArray();
    __oracle_jsp_text[56] = 
    "</td>\r\n            <td class=\"TdLeftDetailPopup\" height=\"20px\">".toCharArray();
    __oracle_jsp_text[57] = 
    "</td>\r\n            <td class=\"TdLeftDetailPopup\" height=\"20px\">".toCharArray();
    __oracle_jsp_text[58] = 
    "</td>\r\n        </tr>\r\n    ".toCharArray();
    __oracle_jsp_text[59] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[60] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[61] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[62] = 
    "            \r\n        <tr style=\"height: 20px\">    \r\n            <td colspan=\"8\" align=\"center\">No record found.</td>\r\n        </tr>\r\n    ".toCharArray();
    __oracle_jsp_text[63] = 
    "\r\n        </table>\r\n        ".toCharArray();
    __oracle_jsp_text[64] = 
    "\r\n    ".toCharArray();
    __oracle_jsp_text[65] = 
    "\r\n</body>\r\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
